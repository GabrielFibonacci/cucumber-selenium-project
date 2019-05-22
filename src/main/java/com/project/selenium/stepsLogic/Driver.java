package com.project.selenium.stepsLogic;

import com.project.selenium.helpers.Options;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class Driver {
    private WebDriver activeDrive;

    public WebDriver getDriver(Options.driverType driverName) {
        WebDriver myDriver = null;
        switch (driverName) {
            case FIREFOX:
                File routeNameFirefox = new File("drivers/geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", routeNameFirefox.getAbsolutePath());
                myDriver = new FirefoxDriver();
                break;
            case CHROME:
                File routeNameChrome = new File("drivers/chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", routeNameChrome.getAbsolutePath());
                myDriver = new ChromeDriver();
                break;
            case IEXPLORER:
                File routeNameIExplorer = new File("drivers/IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", routeNameIExplorer.getAbsolutePath());
                myDriver = new InternetExplorerDriver();

        }
        return myDriver;
    }

    public WebDriver getActiveDrive() {
        return activeDrive;
    }

    public void setActiveDrive(WebDriver activeDrive) {
        this.activeDrive = activeDrive;
    }
}
