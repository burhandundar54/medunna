@demo
Feature: demo

    @UIRegistration
    @registration_ssn_invalid
  Scenario Outline: TC02 user should not be able to register with an invalid ssn
    Given user enters ssn number as "<invalid ssn>"
    And user proceeds to the next field
    Then user verifies the error message as "Your SSN is invalid"
    Examples: invalid ssn data
      |invalid ssn|
      |123-$5-6789 |

  @UIRegistration
  @registration_all_valid
Scenario: TC08 registering with valid credentials
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

@ApiPostRegistrant
Scenario Outline: TC09 Api registrant POST request and validation
Given user sets the necessary path params
And user sets the expected data "<firstname>" "<lastname>" "<SSN>" "<email>" "<username>" "<password>" "<lan>"
And user sends the POST request and gets the response
And user saves the api records to correspondent files
Then user validates api records

Examples: api test data
|firstname|lastname|SSN        |email            |username |password |lan|
|Stephan  |Taylor  |215-83-1456|stephan@gmail.com|s.taylor |123T45as?|Eng|

@ApiRegistrant
Scenario Outline: TC08 Api registrant GET request and validation
Given user sets the endpoint to get user info with "<SSN>"
And user sets the expected data as "<firstname>" "<lastname>" "<SSN>" "<email>" "<username>" "<password>"
And user makes a GET request and gets the response
Then user validates registrant information using api

Examples: previously created data
|firstname|lastname |SSN        |email                      |username       |password          |
|Alton    |Casper   |527-87-5703|theresia.cummings@gmail.com|vergie.donnelly|Q9@L*%H7          |
|Bud      |Robel    |691-81-5313|eileen.howe@gmail.com      |efrain.hyatt   |Ww25EMQr!ax4      |

  @Registrant_DB_validation
  Scenario Outline: DB registrant validation with SSN
    Given user sets a connection with database
    And user selects all "ssn" column data
    Then user validates registrant "<ssn>" ids with the database

    Examples:
      |ssn        |
      |527-87-5703|


  @registration_password_lowercase
  Scenario: Registration_Password_Lowercase
    When user launches the browser
    And user navigates to home page
    And user verifies home page is visible
    And user clicks account_menu
    And user clicks register button
    And user verifies registration title is visible
    Given user enter registration password "ADK123*?-"
    And user verifies fifth strength bar colour add "c"


  @registration_password_specialchar
  Scenario: Registration_Password_SpecialChar_Changes
    When user launches the browser
    And user navigates to home page
    And user verifies home page is visible
    And user clicks account_menu
    And user clicks register button
    And user verifies registration title is visible
    Given user enter registration password "XDFA1234"
    And user verifies all strengths bar colour add "*"

  @registration_password_4char
  Scenario: Registration_Password_4char
    When user launches the browser
    And user navigates to home page
    And user verifies home page is visible
    And user clicks account_menu
    And user clicks register button
    And user verifies registration title is visible
    Given user enter registration password "Ey4"
    And user verifies registration password 4char


  @US_004
  Scenario Outline: verifying login functionalty
    Given User is on the home page
    And User clicks on account icon
    And User clicks  on Sign in
    Then User verifies if user is on the sign in page
    When User provides valid "<username>" and "<password>"
    And  User clicks on Sign in button
    Then User verifies login is success
    Then User closes the application
    Examples:
      | username  | password  |
      | useremre  |   1234    |


  @TC_0002
  Scenario: verifying cancel button
    Given User is on the home page
    And User clicks on account icon
    And User clicks  on Sign in
    Then User verifies if user is on the sign in page
    When User clicks on cancel button
    Then User verifies the if cancel button is enable
    Then User closes the application

  @TC_0003
  Scenario Outline: verifying remember me option is working
    Given User is on the home page
    And User clicks on account icon
    And User clicks  on Sign in
    Then User verifies if user is on the sign in page
    When User provides valid "<username>" and "<password>"
    Then User verifies if the remember me option is exist and clickable
    And User clicks and put check mark on remember me option
    And User clicks on Sign in button
    And User clicks on Account Menu
    And User clicks on Sign Out
    And User clicks on SIGN IN AGAIN button
    And User provides previously provided "<username>"
    Then User Verifies if the previously provided password comes automatically
    Then User closes the application

    Examples:
      | username  | password  |
      | useremre  |   1234    |


  @US05_patient_appointment
  Scenario:Make_appointment_with_correct_credentials
    When user launches the browser
    And user navigates to home page
    And user verifies home page is visible
    And user clicks MakeAnAppointment button
    And user verifies Appointment page is visible
    And user sets the expected data "<firstname>", "<lastname>" "<ssn>" "<email>" "<phoneNumber>" "<date>"
    And user clicks FirstName TextBox
    Then user enters valid FirstName
    And user clicks LastName TextBox
    Then user enters valid LastName
    And user clicks SSN TextBox
    Then user enters valid SSN
    And user clicks Email TextBox
    Then user enters valid Email
    And user clicks FirstName TextBox
    Then user enters valid FirstName
    And user clicks Phone TextBox
    Then user enters valid Phone
    And user clicks AppDateTime TextBox
    Then user enters valid AppDateTime
    Then user clicks SendAnAppRequest button
    Then user validates application
    Then user saves the records corresponding file
    Then user clicks AccountMenu button
    When user clicks Register button
    And user clicks SSN TextBox at Registration page
    And user enters SSN
    And user clicks FirstName TextBox at Registration page
    And user enters any firstname
    Then user clicks LastName TextBox at Registration page
    And user enters any lastname
    Then user clicks username TextBox at Registration page
    And user enters username
    Then user clicks email TextBox at Registration page
    And user enters email
    Then user clicks newpassword TextBox at Registration page
    And user enters newpassword
    Then user clicks passwordconfirm TextBox at Registration page
    And user enters passwordconfirm
    Then user clicks Register button at Registration page
    And user validates registration


  @US_006
  @TC_0001
  Scenario Outline:TC_0001 updating firstname
    Given User is on the main page
    And User navigates to login page
    Then Verify if user is on the sign in page
    When User provides valid as "<username>" and "<password>"
    And  User click Sign in button
    And User clicks on account menu
    And User clicks on settings
    And User clicks on firstnamebox and clears
    And User updates firstname as "<firstname>"
    And User clicks on save button
    And User verifies the Settings saved! message
    Then Close the application

    Examples:
      | username  | password | firstname |
      | usertugba | 123Tugba | User      |


  @TC_0002
  Scenario Outline:TC_0002 updating lastname
    Given User is on the main page
    And User navigates to login page
    Then Verify if user is on the sign in page
    When User provides valid as "<username>" and "<password>"
    And  User click Sign in button
    And User clicks on account menu
    And User clicks on settings
    And User clicks on lastnamebox and clears
    And User updates lastname as "<lastname>"
    And User clicks on save button
    And User verifies the Settings saved! message
    Then Close the application

    Examples:
      | username  | password | lastname |
      | usertugba | 123Tugba | Tugba    |


  @TC_0003
  Scenario Outline:TC_0003 updating email
    Given User is on the main page
    And User navigates to login page
    Then Verify if user is on the sign in page
    When User provides valid as "<username>" and "<password>"
    And  User click Sign in button
    And User clicks on account menu
    And User clicks on settings
    And User clicks on emailbox and clears
    And User updates email as "<email>"
    And User clicks on save button
    And User verifies the Settings saved! message
    Then Close the application

    Examples:
      | username  | password | email               |
      | usertugba | 123Tugba | usertugba@gmail.com |

  @US_007
  @TC_001
  Scenario:TC_001 verifying date
    Given User is on the main page
    Then user clicks make an appointment button
    And user clear the date box and enters a valid date
    And verifies that the invalid date message does not appear
    Then Close the application

  @AppointmentPostApi
  Scenario Outline: Api POST request for new appointment
    Given user sets the path params
    And user sets expected data "<firstname>" "<lastname>" "<ssn>" "<email>" "<phone number>" "<appointment date>"
    And user send Post request and gets response
    And user saves the records
    Then user validates record with Api

    Examples:
      |firstname|lastname|ssn|email|phone number|appointment date|
      |firstname|lastname|ssn|email|973-212-4556|2022-03-22|



  @AppointmentGetApi
  Scenario Outline: Api GET request for appointments
    Given user sends the get request for appointments data
    Then user deserializes data to Java and validates "<firstname>" "<lastname>" "<ssn>" "<email>" and "<phone number>"

    Examples: appointment data created with Post request
      |firstname           |lastname           |ssn              |email                           |phone number      |
      |firstName=Arthur    |lastName=Hegmann   |ssn=714-51-3242  |email=lucina.brakus@gmail.com   |phone=973-212-4556|



  @new_password_confirmed
  Scenario Outline: New_Password_Confirmed
    When user launches the browser
    And user navigates to home page
    And user verifies home page is visible
    And user clicks account_menu
    And user clicks sign_in_menu
    Then user verifies sign_in_title
    And user enter username as "userrecep"
    And user enter password as "123Recep"
    And user clicks sign_in_button
    Then user verifies name is visible on homepage
    And user clicks account_menu
    And user clicks password_menu
    And user verifies password for username title
    And user enter current password as "<currentPassword>"
    And user enter new password as "<newPassword>"
    And user enter password confirmation as "<confirmationPassword>"
    And user clicks save submit button
    And user verifies password should be confirmation
    And user clicks account_menu
    And user clicks sign_out_menu
    Examples:
      | currentPassword | newPassword | confirmationPassword |
      | 123Recep        | 123recep    |                      |

  @for_password_not_match
  Scenario Outline: For_Password_Not_Match
    When user launches the browser
    And user navigates to home page
    And user verifies home page is visible
    And user clicks account_menu
    And user clicks sign_in_menu
    Then user verifies sign_in_title
    And user enter username as "userrecep"
    And user enter password as "123Recep"
    And user clicks sign_in_button
    Then user verifies name is visible on homepage
    And user clicks account_menu
    And user clicks password_menu
    And user verifies password for username title
    And user enter current password as "<currentPassword>"
    And user enter new password as "<newPassword>"
    And user enter password confirmation as "<confirmationPassword>"
    And user clicks save submit button
    And user verifies password not match message
    And user clicks account_menu
    And user clicks sign_out_menu
    Examples:
      | currentPassword | newPassword | confirmationPassword |
      | 123Recep        | 123recep    | 123reCEP             |


  @for_password_not_changed
  Scenario Outline: For_Password_Not_Changed
    When user launches the browser
    And user navigates to home page
    And user verifies home page is visible
    And user clicks account_menu
    And user clicks sign_in_menu
    Then user verifies sign_in_title
    And user enter username as "userrecep"
    And user enter password as "123Recep"
    And user clicks sign_in_button
    Then user verifies name is visible on homepage
    And user clicks account_menu
    And user clicks password_menu
    And user verifies password for username title
    And user enter current password as "<currentPassword>"
    And user enter new password as "<newPassword>"
    And user enter password confirmation as "<confirmationPassword>"
    And user clicks save submit button
    And user verifies password not changed message
    And user clicks account_menu
    And user clicks sign_out_menu
    Examples:
      | currentPassword | newPassword | confirmationPassword |
      | 123ReCEP        | 123recep    | 123recep             |


  @physician_appointments
  Scenario Outline: TC0001_my appointments_with_physician_validate
    Given user is on the homepage
    When user clicks human icon
    And user clicks sigin button
    Then user verifies signin page
    And user is sign in as a physician username "<username>" and password "<password>"
    Then user verifies the physician's page
    And user clicks MyPages and select My Appointments from dropdown
    Then user verifies the My Appointments page
    Then user verifies can see their appointments list and time slots on My Appointments
    Then user verifies the user can see patient id, start date, end date, status…
    Then user select one of the patient list and click edit button
    Then user verifies the edit page
    Then user verifies the Request a test button is displayed
    When user clicks Request a test button
    When clicks the some of checkmark options(Glucose, Urea, Creatinine, Sodium,Potassium, Total protein, Albumin, Hemoglobin)
    Then user verifies the have following items as checkmark options; (Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin)
    And user closes the page
    And user closes the page
    Examples: credentials
      |username |password  |
      |Jo       |789456123 |

  @AppointmentGetApi
  @physician_appoinments_with_api_secondway
  Scenario Outline:Api GET request for users
    Given user sends the get request for physician_appointments with data "<fromdate>" and "<toDate>" and "<id>"
    And user deserializes physician_appointments with date data to java
    And user saves the users physician_appointments with date data to correspondent files
    Then user validates physician appointment with date records
    Examples: test data
      |fromdate   |toDate   |id   |
      |2022-03-03|2022-03-16|10642|


  @validate_physician_db
  Scenario: DB validation physician
    Given user connect to DB
    And user gets "*" from "appointment" table
    And user reads all of the "physician_id" column data
    Then close the database connection

  @UI_US_09
  @AdminFunctions
  Scenario: Admin View patient information navigating to view portal
    Given Go to medunna.com homepage
    Then User signs in as Admin
    Then click on Items&Titiles dropdown
    Then click on Patients
    Then click on View button on patient info
    Then verify patient informations are visable
    Then click on Items&Titiles dropdown
    Then click on Patients
    Then click on edit button on patient info as Admin User
    Then edit the patient informations and click on save button
    Then verify patient informations are updated as Admin
    Then click on Items&Titiles dropdown
    Then click on Patients
    Then click on Delete button on the patient you want to delete
    Then click on Delete button on the opening alert
    Then verify patient is deleted
    Then click on Items&Titiles dropdown
    Then click on Patients
    Then verify Patient Search Box is not visiable
    Then sign out

  @UI_US_09
  @UStaffFunctions
  Scenario: Staff View patient information navigating to view portal
    Given Go to medunna.com homepage
    When User signs in as Staff
    Then click on MY PAGES dropdown
    Then click on Search Patient button
    Then click on View button on patient info
    Then verify patient informations are visable
    Then click on MY PAGES dropdown
    Then click on Search Patient button
    Then click on edit button on patient info as Staff User
    Then edit the patient informations and click on save button
    Then verify patient informations are updated
    Then click on MY PAGES dropdown
    Then click on Search Patient button
    Then enter a valid SSN ID in the Patients search box
    Then verify the patient informations are  invoked
    Then click on MY PAGES dropdown
    Then click on Search Patient button
    Then verify Delete button is not dispalyed

  @DB_US_09
  @UStaffFunctionsDB
  Scenario: Validate patient's eMail with DB
    Given user sets a connection with the database
    And user selects all email column data
    Then user validates patient's eMail with the database

  @AppointmentGetApi
  @API_US_05
  Scenario: Get appointment info and validate
    When user sets the Base Url
    And user sends the GET request and get the response
    And user sets the expected data
    Then user does validation


  @US_0011
  @TC_0001
  Scenario Outline: Edit_An_Appointment
    Given User is on home page
    And User navigate to login page
    Given User provide valid "<username>" and "<password>"
    And User clicks Sign in
    And User clicks on My Pages
    And User clicks on My Appointment
    And User Clicks Edit button
    And user provide status "<status>"
    And user provide anamnesis "<anamnesis>"
    And user provide treatment "<treatment>"
    And user provide diagnosis "<diagnosis>"
    And User click on Save
    Then User verifies success message "The Appointment is updated with identifier"
    And User clicks Sign out button
    Examples:
      |username   |password|status   |anamnesis|treatment|diagnosis|
      |doctorrecep|123Recep|COMPLETED|Headache |Majezik  |Migraine |

  @US_0013UITestResultAndImpatient
  @US_0013TC_0001
  Scenario Outline: Doctor_Should_Able_To_See_Test_Results
    Given Doctor is on home page
    And Doctor navigate to login page
    And capture the screenshot
    Given Doctor provide valid "<username>" and "<password>"
    And Doctor clicks on the sign in button
    And Doctor clicks on My Pages dropdown
    And Doctor clicks on My Appointments
    And Doctor clicks on Edit for patient button
    And Doctor clicks on Show Test Result button
    And Doctor clicks on View Result button
    Then Doctor should see and verify all test information
    Then Doctor clicks on Sign out button
    And capture the screenshot
    Examples: Doctor see test results
      |username   |password|
      |doctorrecep|123Recep|

  @US_0013TC_0002
  Scenario Outline: Doctor_Should_Able_To_Request_Inpatient
    Given Doctor is on home page
    And Doctor navigate to login page
    And capture the screenshot
    Given Doctor provide valid "<username>" and "<password>"
    And Doctor clicks on the sign in button
    And Doctor clicks on My Pages dropdown
    And Doctor clicks on My Appointments
    And Doctor clicks on Edit for patient button
    And Doctor clicks on Request Impatient button
    Then Doctor Verifies message "InPatient request already done for this appointment"
    And capture the screenshot
    Then Doctor clicks on Sign out button
    Examples: Doctor see test results
      |username   |password|
      |doctorrecep|123Recep|