package SAMPLE_COMP.COMP_NAME.step_def;

import SAMPLE_COMP.COMP_NAME.utility.DB_Util;
import SAMPLE_COMP.COMP_NAME.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After("@UI")
    public void teardownScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }

    @Before("@DB")
    public void dbHook() {
        DB_Util.createConnection();
    }

    @After("@DB")
    public void afterDbHook() {
        DB_Util.destroy();
    }
}
