package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo3 {

    private <ThreadLocal>RemoteWebDriver driver;
    private String Status = "failed";
    
    //Tunnel t;


    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws Exception, MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");

        String hub = "@hub.lambdatest.com/wd/hub";


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "cengage_test");
        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        //caps.setCapability("geoLocation", "NZ");
        caps.setCapability("performance", false);
        caps.setCapability("tunnel",true);



        //create tunnel instance
        // t = new Tunnel();
        // HashMap<String, String> options = new HashMap<String, String>();
        // options.put("user", username);
        // options.put("key", authkey);
        // options.put("logFile", "src/test");
        // options.put("mode", "tcp");
        // options.put("mitm", "--mitm");

        // start tunnel
        // t.start(options);

        driver = new <ThreadLocal>RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTestOne() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(8000);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestTwo() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(8000);

        System.out.println("TestFinished");
    }
    @Test
    public void basicTestThird() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(8000);

        System.out.println("TestFinished");

    }

    @Test
    public void basicTestFourth() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(8000);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestFifth() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(8000);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestSixth() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestSeven() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestEighth() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestNinth() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestTenth() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestEleven() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestTwolve() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestThirteen() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestFourteen() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestFifteen() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestSixteen() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }

    @Test
    public void basicTestSeventeen() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestEighteen() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestNineteen() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }
    @Test
    public void basicTestTwenty() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
        //t.stop();
    }
}
