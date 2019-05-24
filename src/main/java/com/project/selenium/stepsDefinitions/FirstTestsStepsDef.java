package com.project.selenium.stepsDefinitions;

import com.project.selenium.helpers.Options;
import com.project.selenium.stepsLogic.Driver;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

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
            Assert.assertEquals(driver.getActiveDrive().getTitle(), "Google",
                    "test invalid, but don´t similar");
        });
        When("^I put the Url amazon\\.com in the search field$", () -> {
            WebElement inputTextGoogle = driver.getActiveDrive().findElement(By.name("q"));
            Assert.assertTrue(inputTextGoogle.isDisplayed(), "The field was not displayed");
            inputTextGoogle.click();
            inputTextGoogle.sendKeys("amazon.com");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        And("^I press the button Google Search$", () -> {
            WebElement pressButtonGoogle = driver.getActiveDrive().findElement(By.name("btnK"));
            Assert.assertTrue(pressButtonGoogle.isDisplayed(), "The list not displayed");
            pressButtonGoogle.click();
        });
        Then("^The search results of amazon\\.com should be displayed in the results list$", () -> {
            //WebElement shouldDisplayed = driver.getActiveDrive().findElement(By.className("g"));
            List<WebElement> allSearchResults = driver.getActiveDrive().findElements(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/div/a"));
            for (WebElement element : allSearchResults) {
                assertThat(element.getText(), containsString("Amazon"));
                System.out.println("this is the result: " + element.getText());
            }// close for loop


        });

    }
}
