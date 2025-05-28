package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTodo2 {

    private RemoteWebDriver driver;
    private String Status = "failed";
    private JSONObject config;

    public TestNGTodo2(JSONObject config) {
        this.config = config;
    }

    @Factory
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

        String browserName = config.getString("browserName").toLowerCase();
        String browserVersion = config.getString("browserVersion");
        String platform = config.getString("operatingSystem");

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("project", "Cross Browser Test");
        ltOptions.put("build", buildname);
        ltOptions.put("name", m.getName() + "_" + browserName);
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);

        // Optional tagging
        ltOptions.put("tags", Arrays.asList("parallel", "testng", browserName));

        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setPlatformName(platform);
            options.setBrowserVersion(browserVersion);
            options.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), options);

        } else if (browserName.equals("MicrosoftEdge")) {
            EdgeOptions options = new EdgeOptions();
            options.setPlatformName(platform);
            options.setBrowserVersion(browserVersion);
            options.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), options);

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
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

        spanText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[9]/span")).getText();
        Assert.assertEquals(spanText, "Get Taste of Lambda and Stick to It");

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
