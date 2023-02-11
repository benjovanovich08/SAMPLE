package SAMPLE_COMP.COMP_NAME.step_def;

import SAMPLE_COMP.COMP_NAME.pages.BasePage;
import SAMPLE_COMP.COMP_NAME.utility.BrowserUtil;
import SAMPLE_COMP.COMP_NAME.utility.ConfigurationReader;
import SAMPLE_COMP.COMP_NAME.utility.Driver;
import SAMPLE_COMP.COMP_NAME.utility.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static org.junit.Assert.*;

public class SearchFeatureStepDef extends BasePage {

    @Given("user is on the Google homepage")
    public void user_is_on_the_google_homepage() {
        Driver.getDriver().get(Environment.ENV_URL);
    }
    @When("{string} sends valid username and password")
    public void sends_valid_username_and_password(String userType) {
        login(userType);
    }
    @Then("user should see {string} username on userDropDown")
    public void user_should_see_username_on_user_drop_down(String userType) {
        String expUserEmail="";
        if(userType.equals("endUser")){
            expUserEmail=Environment.END_USER_USERNAME;
        }else {
            expUserEmail = Environment.ADMIN_USERNAME;
            assertTrue(accountVerfier.getAttribute("aria-label").contains(expUserEmail));
        }
    }



    @When("I search for {string}")
    public void i_search_for(String testItems) {
        searchBar.sendKeys(testItems+ Keys.ENTER);
    }
    @Then("page title should contain {string}")
    public void page_title_should_contain(String testItems) {
        String currentTitle=Driver.getDriver().getTitle();
        assertTrue(currentTitle.contains(testItems));
    }
}
