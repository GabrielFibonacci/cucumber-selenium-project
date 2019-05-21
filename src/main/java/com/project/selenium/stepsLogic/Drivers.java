package com.project.selenium.stepsLogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.io.File;

public class Drivers {


    public WebDriver getDriver(String driverName) {
        WebDriver myDriver = null;
        switch (driverName) {
            case "firefoxDriver":
                File routeNameFirefox = new File("drivers/geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", routeNameFirefox.getAbsolutePath());
                myDriver = new FirefoxDriver();
                break;
            case "chromeDriver":
                File routeNameChrome = new File("drivers/chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", routeNameChrome.getAbsolutePath());
                myDriver = new ChromeDriver();
                break;
            case "iExplorerDriver":
                File routeNameIExplorer = new File("drivers/IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", routeNameIExplorer.getAbsolutePath());
                myDriver = new InternetExplorerDriver();
            default:
                Assert.fail("There is not a valid driver name");

        }
        return myDriver;
    }
}
