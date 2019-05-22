import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        format = {"pretty", "json:target/cucumber.json", "html:target/html"},
        features = {"src/main/resources"},
        glue = "com.project.selenium",
        tags = {"@qa-automatedTest"}
)
public class RunCukesTest extends AbstractTestNGCucumberTests {
}