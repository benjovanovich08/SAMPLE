@regression @API
Feature: API verification
  Background: User should have authorization for following scenarios
    Given User sends valid user info

    Scenario: Verify API is generating access token
      Then Status code should be 200
      And Access token is not null

    Scenario: Verify API response for employee info
      When user sends GET request to "/api/employees" endpoint
      Then verify employees first names are same as names listed below
      |John |
      |Peter|
      |Josh |

    Scenario: Verify API POST request successfully creates new employee
      and validate employee info
        When user sends POST request to "/api/employees" endpoint with employee data below
        |first_name   |Liz    |
        |last_name    |Pearing|
        |department_id|103    |
        |salary       |95500  |
        Then Status code should be 201
        And verify response data matches info above and id is not null
