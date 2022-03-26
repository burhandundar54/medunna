@RegistrantDB_validationTests
Feature: registrant database validation

  @Registrant_DB_validation
  Scenario Outline: Validate registrant SSN ids with DB
    Given user sets a connection with database
    And user selects all "ssn" column data
   Then user validates registrant "<ssn>" ids with the database

    Examples:
      |ssn        |
      |527-87-5703|
      |691-81-5313|
      |383-06-4367|
      |635-57-1782|
      |024-85-5660|
      |784-87-3883|
      |164-07-3409|
      |531-36-5815|
      |840-44-5495|
      |164-71-7266|
      |887-82-9699|
      |093-09-4553|


