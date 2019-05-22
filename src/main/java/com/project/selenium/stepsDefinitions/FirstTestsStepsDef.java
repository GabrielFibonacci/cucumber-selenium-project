package com.project.selenium.stepsDefinitions;

import com.project.selenium.helpers.Options;
import com.project.selenium.stepsLogic.Driver;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FirstTestsStepsDef implements En {
    Driver driver;
    public FirstTestsStepsDef() {
        Given("^The (.*) is opened$", (Options.driverType driverType) -> {
            driver = new Driver();
            driver.setActiveDrive(driver.getDriver(driverType));
        });
        When("^I navigate to the URL www\\.google\\.com$", () -> {
            driver.getActiveDrive().get("http://www.google.com");
        });
        After((Scenario scenario) -> {
            driver.getActiveDrive().close();
        });
        Then("^The google page should be displayed correctly$", () -> {
            Assert.assertEquals(driver.getActiveDrive().getTitle(),"Google",
                    "test invalid, but don´t similar");
        });

    }
}
