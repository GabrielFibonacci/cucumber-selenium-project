package com.project.selenium.stepsDefinitions;

import com.project.selenium.helpers.Options;
import com.project.selenium.stepsLogic.Driver;
import com.project.selenium.stepsLogic.SeleniumTools;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
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
        When("^I press the \"([^\"]*)\" hyperlink$", (String arg0) -> {
            WebElement pressAboutGoogle = driver.getActiveDrive().findElement(By.xpath("//*[@id=\"fsl\"]/a[3]"));
            Assert.assertTrue(pressAboutGoogle.isDisplayed(), "The About not displayed");
            pressAboutGoogle.click();
        });
        Then("^The google help page should be displayed$", () -> {
            WebElement validateImagePrincipal = driver.getActiveDrive().findElement(By.xpath("/html/body/main/div/section[1]/a[1]/div/div[1]/div"));
            SeleniumTools.takeScreenShot(driver.getActiveDrive());
            Assert.assertTrue(validateImagePrincipal.isDisplayed(), "This image was not displayed");
        });
        And("^I navigate to the main Amazon page$", () -> {
            driver.getActiveDrive().get("http://www.amazon.com");
            String tittleAmazon = driver.getActiveDrive().getTitle();
            assertThat("The name of the page does not correspond", tittleAmazon, containsString("Amazon"));
        });
        When("^I press the button To day's Deals hyperlink$", () -> {
            WebElement pressToDayIsDeals = driver.getActiveDrive().findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
            Assert.assertTrue(pressToDayIsDeals.isDisplayed(), "The page is not To Day´s Deals");
            pressToDayIsDeals.click();
        });
        And("^I press button \"([^\"]*)\" -Low to High$", (String arg0) -> {
            WebDriverWait waitTime = new WebDriverWait(driver.getActiveDrive(), 10);
            WebElement pressSortBy = waitTime.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"FilterItemView_sortOrder_dropdown\"]/div/span[2]/span/span/span/span/span")));
            Assert.assertTrue(pressSortBy.isDisplayed(), "Not displayed Relevance");
            pressSortBy.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        Then("^Products must be shown from lowest to highest value$", () -> {
            // WebElement allSearchLowToHigh = driver.getActiveDrive().findElement(By.xpath("//*[@id=\"widgetFilters\"]/div[4]/div/span"));
            //Assert.assertTrue(a);
            //System.out.println(allSearchLowToHigh);
        });
        And("^I navigate to the main Fender page$", () -> {
            driver.getActiveDrive().get("http://www.fender.com");
            String tittleFender = driver.getActiveDrive().getTitle();
            assertThat("The name of the page does not correspond", tittleFender, containsString("Fender"));
        });
        When("^I press button search$", () -> {
            WebElement buttonSearch = river.getActiveDrive().findElement(By.xpath("/html/body/div[1]/header/nav/div/div/div[2]/div[1]"));
            Assert.assertTrue(buttonSearch.isDisplayed(), "Not displayed text field search");
            buttonSearch.click();
        });
        And("^Enter something to search for \"([^\"]*)\", click$", (String arg0) -> {
            WebElement textBoxSearch = driver.getActiveDrive().findElement(By.name("q"));
            textBoxSearch.clear();
            textBoxSearch.sendeys("Telecaster");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textBoxSearch.submit();
        });
        Then("^Displayed products \"([^\"]*)\" new arrivals$", (String arg0) -> {
            
        });


    }
}

