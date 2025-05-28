package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class TestNGTodo2 {

    private RemoteWebDriver driver;
    private String Status = "failed";
    private JSONObject config;

    public TestNGTodo2(JSONObject config) {
        this.config = config;
    }

    @Factory
    @Parameters({"LT_BROWSERS"})
    public static Object[] createInstances() {
        String browsersJson = System.getenv("LT_BROWSERS");
        JSONArray browsersArray = new JSONArray(browsersJson);

        List<Object> tests = new ArrayList<>();
        for (int i = 0; i < browsersArray.length(); i++) {
            JSONObject browserConfig = browsersArray.getJSONObject(i);
            tests.add(new TestNGTodo2(browserConfig));
        }
        return tests.toArray();
    }

    @BeforeMethod
    public void setup(Method m) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";
        String buildname = System.getenv("LT_BUILD_NAME");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("build", buildname);
        caps.setCapability("platform", config.getString("operatingSystem"));
        caps.setCapability("browserName", config.getString("browserName"));
        caps.setCapability("version", config.getString("browserVersion"));
        caps.setCapability("resolution", config.getString("resolution"));
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[]{"Feature", "Magicleap", "Severe"};
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Running on: " + config.toString());

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        driver.findElement(By.name("li1")).click();
        driver.findElement(By.name("li2")).click();
        driver.findElement(By.name("li3")).click();
        driver.findElement(By.name("li4")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
        driver.findElement(By.id("addbutton")).click();
        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
        driver.findElement(By.id("addbutton")).click();
        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
        driver.findElement(By.id("addbutton")).click();

        driver.findElement(By.name("li1")).click();
        driver.findElement(By.name("li3")).click();
        driver.findElement(By.name("li7")).click();
        driver.findElement(By.name("li8")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
        driver.findElement(By.id("addbutton")).click();
        driver.findElement(By.name("li9")).click();

        spanText = driver.findElementByXPath("/html/body/div/div/div/ul/li[9]/span").getText();
        Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);

        Status = "passed";
        Thread.sleep(150);
        System.out.println("TestFinished");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.executeScript("lambda-status=" + Status);
            driver.quit();
        }
    }
}
