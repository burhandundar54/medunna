Feature: Admin test items functionality

  @CreateTestItem @AdminUI
  Scenario: US17 Admin can create new test items
    Given user sign-in as admin
    And user selects test item from items-titles dropdown
    And user clicks create a new test item button
    Then user verifies name field is displayed
    And user provides name
    Then user verifies description field is displayed
    And user provides description
    Then user verifies price field is displayed
    And user provides price
    Then user verifies min value field is displayed
    And user provides min value
    Then user verifies max value field is displayed
    And user provides max value
    Then user verifies created date field is displayed
    And user enters current date
    And user saves the test item records created with ui
    And user clicks save button
    Then user verifies that created message is displayed

  @ViewTestItem @AdminUI
  Scenario: user can view test items
    Given user sign-in as admin
    And user selects test item from items-titles dropdown
    And user clicks the view button of an item
    Then user verifies that item info is displayed

  @DeleteTestItem @AdminUI
  Scenario: user can delete test items
    Given user sign-in as admin
    And user selects test item from items-titles dropdown
    And user clicks the delete button of an item
    Then user verifies that deleted message is displayed












