@regression @UI
Feature: Google login and search feature
  Background:
    Given user is on the Google homepage

  Scenario: As an endUser I should be able to successfully login to my Google Account
    When "endUser" sends valid username and password
    Then user should see "endUser" username on userDropDown

  Scenario Outline: As an endUser I should be able to search various subjects
    When I search for "testItems"
    Then page title should contain "testItems"
    Examples:
    |testItems   |
    |selenium    |
    |jdbc        |
    |postman     |
    |sql         |
    |java        |
    |rest assured|
    |ide         |