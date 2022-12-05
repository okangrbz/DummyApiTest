package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:test-output/Raports/default-cucumber-reports.html",
                "json:test-output/Raports/json-reports/cucumber.json",
                "junit:test-output/Raports/xml-report/cucumber.xml",
                "rerun:test-output/Raports/failedRerun.txt"},
        features="src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@Put",
        dryRun = false
)
public class runner {
}
