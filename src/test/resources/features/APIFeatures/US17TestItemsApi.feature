Feature: Appointment Api functionalities

  @TestItemApi
  @ApiPostTestItem
  Scenario: US17 Api post request to create test item
    Given user sets the path params to create test item
    And user sets expected data
    And user send Post request for test item and gets response
    And user saves the test item records
    Then user validates test item record with Api

  @TestItemApi
  @ApiGetTestItem
  Scenario: US17 Api Get request for test item
    Given user sends the get request for test items data
    And user deserializes test items data to Java
    And user saves the test items data to correspondent file
    Then user validates expected test item records with Api

  @TestItemApi
  @ApiPutTestItem
  Scenario: update existing test items
    Given user sets the expected test item data
    And user makes a put request for test item
    And user validates the changes

