package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(   tags = "@smoke",
                                   features = "src/test/java/feature",
                                   glue = {"base","stepsDefination"},
                                   dryRun = false,
                                   plugin = {"pretty","html:target/index.html"}
)

public class TestRunner {

}
