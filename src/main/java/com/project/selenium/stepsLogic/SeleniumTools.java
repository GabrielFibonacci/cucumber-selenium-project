package com.project.selenium.stepsLogic;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class SeleniumTools {

    public static void takeScreenShot(WebDriver driver) {
        // Take screenshot and store as a file format
        File routeNameImages = new File("images");
        String route = routeNameImages.getAbsolutePath();
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(route + "\\" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
