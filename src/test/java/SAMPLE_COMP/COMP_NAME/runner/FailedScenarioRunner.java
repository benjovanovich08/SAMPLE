package SAMPLE_COMP.COMP_NAME.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "SAMPLE_COMP/COMP_NAME/step_def"
)

public class FailedScenarioRunner {
}
