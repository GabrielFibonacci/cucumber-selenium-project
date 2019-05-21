import com.project.selenium.stepsLogic.Drivers;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        WebDriver test;
        Drivers myDriver = new Drivers();
        test = myDriver.getDriver("firefoxDriver");
        test.get("http://www.google.com");

        try {
            Thread.sleep(5000);
            test.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Aquí las instrucciones del método


    }
}
