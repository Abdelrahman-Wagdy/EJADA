package runner;

import browseractions.BrowserActions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

@CucumberOptions
        (
                plugin = {
                        "pretty", "html:target/cucumberHtmlReport",
                        "html:target/reports/cucumber/cucumber.html",     //  for html result
                        "json:target/cucumber.json"   // for json result
                },
                features = "src/test/java/feature/",
                glue = "steps"
        )

public class TestRunner extends AbstractTestNGCucumberTests {
    BrowserActions browserActions = new BrowserActions();
    @AfterTest
    public void endSession(){
        browserActions.closeBrowser();
    }
}

