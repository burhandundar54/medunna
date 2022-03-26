Feature: staff functions

  @StaffCanOnlyEditAppointments
  Scenario: US21
    Given user is on the main page
    And user sign-in as staff
    And user selects Search Patient option from MYPAGES dropdown
    And user clicks show appointments button
    Then user verifies that there is no Delete button

  @StaffCanNotMakeCompleted
  Scenario: US21
    Given user is on the main page
    And user sign-in as staff
    And user selects Search Patient option from MYPAGES dropdown
    And user clicks show appointments button
    And user clicks edit button
    And user clicks status dropdown
    Then user verifies UNAPPROVED PENDING and CANCELLED options are selectable
    Then user verifies COMPLETED option is not selectable

  @StaffNoRequiredFields
  Scenario Outline: US21
    Given user is on the main page
    And user sign-in as staff
    And user selects Search Patient option from MYPAGES dropdown
    And user clicks show appointments button
    And user clicks edit button
    And user leaves Anamnesis Treatment and Diagnosis fields "<blank>"
    And user clicks-on save button
    Then user verifies updated message

    Examples: no data entered
    |blank|
    |     |

  @StaffSelectsPhysician
  Scenario: US21
    Given user is on the main page
    And user sign-in as staff
    And user selects Search Patient option from MYPAGES dropdown
    And user clicks show appointments button
    And user clicks edit button
    And user clicks physician dropdown
    And user selects physician from dropdown menu
    Then user verifies physician is selected


  @StaffCanViewTestResults
  Scenario: US21
    Given user is on the main page
    And user sign-in as staff
    And user selects Search Patient option from MYPAGES dropdown
    And user clicks show appointments button
    And user clicks show tests button
    Then user verifies Tests page is displayed
#



