package SAMPLE_COMP.COMP_NAME.step_def;

import SAMPLE_COMP.COMP_NAME.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseValidationStepDef {

   public List<String> allIDs;
   public HashSet<String> uniqueIDs;
   public List<String> allColumnNames;
    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        //already created in hooks before method
    }
    @When("I execute a query to get all IDs from employees")
    public void i_execute_a_query_to_get_all_i_ds_from_employees() {

        DB_Util.runQuery("SELECT id from Employees");
        allIDs=DB_Util.getColumnDataAsList("id");
        System.out.println(allIDs+" - allIds");
    }
    @Then("verify all employees have unique IDs")
    public void verify_all_employees_have_unique_i_ds() {
      uniqueIDs=new HashSet<>();
      uniqueIDs.addAll(allIDs);
        System.out.println(uniqueIDs+" - uniqueIDs");
       assertEquals(allIDs.size(), uniqueIDs.size());
    }

    @When("Execute query to get all employee columns")
    public void execute_query_to_get_all_employee_columns() {
        DB_Util.runQuery("Select * from employees");
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expColumnNames) {
        allColumnNames=DB_Util.getAllColumnNamesAsList();
        System.out.println(expColumnNames+" - expColumnNames");
        System.out.println(allColumnNames+" -allColumnNames");
        assertEquals(expColumnNames,allColumnNames);
    }
}




