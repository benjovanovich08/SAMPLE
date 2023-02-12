package SAMPLE_COMP.COMP_NAME.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/features" ,
        glue = "SAMPLE_COMP/COMP_NAME/step_def" ,
        dryRun = false,
        publish = true,
        tags = ""
)
public class CukesRunner {

}
