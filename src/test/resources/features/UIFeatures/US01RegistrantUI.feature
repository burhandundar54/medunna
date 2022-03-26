@registration_functionality
Feature: registration feature

  @UIRegistration
  @registration_ssn_valid
  Scenario Outline: TC01 user should be able to register with a valid ssn
    Given user enters ssn number as "<valid ssn>"
    And user proceeds to the next field
    Then user verifies "ssn" is valid
    Examples: valid ssn data
    |valid ssn  |
    |383-06-4367|
    |635-57-1782|
    |492-55-3245|
    |284-92-2345|
    |528-63-5687|

  @UIRegistration
  @registration_ssn_invalid
  Scenario Outline: TC02 user should not be able to register with an invalid ssn
    Given user enters ssn number as "<invalid ssn>"
    And user proceeds to the next field
    Then user verifies the error message as "Your SSN is invalid"
    Examples: invalid ssn data
    |invalid ssn|
    |123-00-4567|
    |000-12-3456|
    |666-12-3456|
    |901-12-3456|
    |123-45-0000|
    |12345-6789 |
    |123-456789 |
    |123456789  |
    |123-45-678 |
    |123-45-67891|
    |123-$5-6789 |

    @UIRegistration
    @registration_ssn_blank
    Scenario Outline: TC03 ssn can not be left blank
      Given user enters ssn number as "<blank>"
      And user proceeds to the next field
      Then user verifies the error message as "Your SSN is required."
      Examples: ssn is blank
      |blank|
      |     |

      @UIRegistration
      @registration_firstname_valid
      Scenario Outline: : TC04 user should be able to register with a valid firstname
        Given user enters firstname as "<valid firstname>"
        And user proceeds to the next field
        Then user verifies "firstname" is valid
        Examples: valid first names
        |valid firstname|
        |Stanton        |
        |Jo             |
        |Şahnur         |
        |Flávia         |
        |零             |
        |Грозда         |


      @UIRegistration
      @registration_firstname_blank
      Scenario Outline: TC05 first name can not be left blank
        Given user enters firstname as "<blank>"
        And user proceeds to the next field
        Then user verifies the error message as "Your FirstName is required."
        Examples: first name is blank
        |blank|
        |     |


      @UIRegistration
      @registration_lastname_valid
      Scenario Outline: TC06 user should be able to register with a valid lastname
        Given user enters lastname as "<valid lastname>"
        And user proceeds to the next field
        Then user verifies "lastname" is valid
        Examples: valid lastnames
          |valid lastname |
          |D'Largy        |
          |King, Jr.      |
          |Çağıran        |
          |Quiñones       |
          |渚             |
          |Јованчић       |


      @UIRegistration
      @registration_lastname_blank
      Scenario Outline: TC07 last name can not be left blank
        Given user enters lastname as "<blank>"
        And user proceeds to the next field
        Then user verifies the error message as "Your LastName is required."
        Examples: first name is blank
        |blank|
        |     |

      @UIRegistration
      @registration_all_valid
      Scenario: TC08 user should be able to register with valid credentials
        Given user enters ssn number
        And user enters firstname
        And user enters lastname
        And user provides username
        And user provides email
        And user provides firstPassword
        And user provides secondPassword
        When user clicks on register button
        Then user verifies the success message as "Registration Saved"
        And user creates the records to a correspondent file




        









