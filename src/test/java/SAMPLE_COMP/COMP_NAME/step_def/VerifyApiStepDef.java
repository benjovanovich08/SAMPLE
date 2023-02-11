package SAMPLE_COMP.COMP_NAME.step_def;

import SAMPLE_COMP.COMP_NAME.utility.APIUtil;
import SAMPLE_COMP.COMP_NAME.utility.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VerifyApiStepDef {

    String token;
    Response response;

    Map<String,String> expResponseData;

    @Given("User sends valid user info")
    public void user_sends_valid_user_info() {
        token=APIUtil.generateToken(Environment.DB_USERNAME,Environment.DB_PASSWORD);

       response=given().accept(ContentType.JSON).when().get(Environment.API_BASEURL+"/api/authentication");

    }
    @Then("Status code should be {int}")
    public void status_code_should_be(Integer expStatusCode) {
       response.then().statusCode(expStatusCode);
    }
    @Then("Access token is not null")
    public void access_token_is_not_null() {
        assertNotNull(token);
    }


    @When("user sends GET request to {string} endpoint")
    public void user_sends_get_request_to_endpoint(String endPoint) {
        response=given().accept(ContentType.JSON)
                .and().header("Authorization","Bearer "+token)
                .when().get(Environment.API_BASEURL+endPoint).prettyPeek();
        response.then().statusCode(200);
    }

    @Then("verify employees first names are same as names listed below")
    public void verify_employees_first_names_are_same_as_names_listed_below(List<String> expNames) {
        List<String> actNames=response.jsonPath().getList("employees.first_name");
        assertEquals(expNames,actNames);
    }

    @When("user sends POST request to {string} endpoint with employee data below")
    public void user_sends_post_request_to_endpoint_with_employee_data_below(String endPoint, Map<String,String> employeeData) {

       response= given().accept(ContentType.JSON)
               .and().header("Authorization","Bearer "+token).and().body
                       ("{\n" +
                               "    \"first_name\": \"Liz\",\n" +
                               "    \"last_name\": \"Pearing\",\n" +
                               "    \"department_id\": \"103\",\n" +
                               "    \"salary\": \"95500\"\n" +
                               "}")
               .when().post(Environment.API_BASEURL+endPoint).prettyPeek();
       expResponseData=employeeData;
    }

    @Then("verify response data matches info above and id is not null")
    public void verify_response_data_matches_info_above_and_id_is_not_null() {
        Map<String,String> actResponseData=response.jsonPath().getMap("data");
        assertNotNull(actResponseData.get("id"));
        assertEquals(expResponseData.get("first_name"),actResponseData.get("first_name"));
        assertEquals(expResponseData.get("last_name"),actResponseData.get("last_name"));
        assertEquals(expResponseData.get("department_id"),actResponseData.get("department_id"));
        assertEquals(expResponseData.get("salary"),actResponseData.get("salary"));
    }

}
