@regression @DB
Feature: Employee database validation
  Background:
    Given Establish the database connection

  Scenario: Verify all employees have unique IDs
    When I execute a query to get all IDs from employees
    Then verify all employees have unique IDs

  Scenario: Verify employees columns
    When Execute query to get all employee columns
    Then verify the below columns are listed in result
    |id           |
    |first_name   |
    |last_name    |
    |department_id|
    |salary       |