package ro.cbn.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "ro.cbn.automation.steps",
        tags = "@test1")
public class RunnerTest {
}
