@Demo2
Feature: Sprint2 features

  @US_0014Doctor_can_edit_Impatient @burhanbey
  Scenario: : user is on the homepage
    When user launch the browser
    And user navigate to home page
    And user verify home page is visible
    And user click PersonBox button
    And user click signin button
    And user verifies signin to account is visible
    Given Doctor provide valid "Jimortan"
    Then user provide valid "Aa.1234"
    And user clicks signinlst button
    Then user verifies that signed in to doctor account
    Given Doctor clicks on My Pages dropdowns
    Given Doctor clicks on My InpatientButton
    When doctor clicks on from date for impatient box
    Then doctor enters valid start date
    Then doctor clicks on end date of inpatient text box
    Then doctor enters valid end date
    Then Doctor should see and verify ID of InPatient information
    Then Doctor should see and verify StartDate of InPatient information
    Then Doctor should see and verify EndDate of InPatient information
    Then Doctor should see and verify Status of InPatient information
    Then Doctor should see and verify Description of InPatient information
    Then Doctor should see and verify CreatedDate of InPatient information
    Then Doctor should see and verify Room of InPatient information
    Then Doctor should see and verify Appointment of InPatient information
    And Doctor clicks on Edit button for InPatients
    Then Doctor clicks on StartDate text box
    Then Doctor provide valid Start date
    Then doctor clicks on EndDate text box
    Then doctor provide valid End date
    Then doctor clicks on CreatedDate textbox
    Then doctor provide valid date
    Then doctor clicks on Status textbox
    Then doctor provides valid status
    Then doctor clicks Save button
    Then doctor verifies the new information
    And Doctor clicks on Edit button for InPatients
    And doctor clicks room textbox
    Then doctor selects any Appropriate room
    Then doctor clicks Save button
    Then doctor verifies the new information


  @US015_CreateEditPatient @ApiRegistrant @recepbey
  Scenario Outline: Create or Edit Patient
    When user launches the browser
    And user navigates to home page
    And user clicks account_menu
    And user clicks sign_in_menu
    And user enter username as "<userName>"
    And user enter password as "<password>"
    And user clicks sign_in_button
    And user clicks ItemsTitles menu
    And user clicks Patient menu
    And user verifies create_a_new_patient button
    And user clicks view information of first patient
    And user verifies all patient information title
    And user verifies id item added for edit patient
    And user enter patient values with Pojo "<firstName>", "<lastName>", "<phone>", "<email>", "<userId>"
#    And user create a new patient with POST and API and Pojo
    And user saves the API records with writeToText
    And user validate patient info with DB
    And user validate patient info with API
#    And admin can delete any patient

    Examples:
      | userName   | password | firstName | lastName  | phone       | email               | userId |
      | adminrecep | 123Recep | RecepPojo | PojoRecep | 555-44-8888 | pojorecep@gmail.com | 11034  |


  @US_16-UI @ApiRegistrant @yasinbey
  Scenario: Admin can create new rooms for inpatients
    Given Go to medunna.com homepage
    Given User signs in as Admin
    And click on Items&Titiles dropdown
    And click on Room
    And click on Create a new Room button
    Then verify Create or edit a Room page is visable
    Given Enter Room Number
    Then Verify all Room Types are selectable.
    Given Click on Status checkbox
    Then Verify checkbox is clicked
    Given Send an empty value to the Price box
    And Enter a value to Description box
    And Verify This field is required message
    Then Enter a valid price to Price box
    When Enter a value to Description box
    And Clear the value you entered
    Then Verify there is no required alert on this box
    Given Enter an invalid date to the Created Date Box
    And Click save button
    And Verify Created Date text is visable
    And Enter a  valid date to the Created Date Box
    Then Verify room is created
    Given Click on View button on Rooms page
    And Verify Room Information is visable
    And click on Items&Titiles dropdown
    And click on Room
    Given Click on Edit button
    And Provide the necessary parts
    And Click save button
    Then Verify The room is updated message
    When Go to medunna.com homepage
    And click on Items&Titiles dropdown
    And click on Room
    Given click on delete button
    And click on delete in the opening alert
    Then verify Room is Deleted message

#  @US_16_API_DELETE @ApiRegistrant @yasinbey1
#  Scenario: Delete a room and validate
#    When set the room Base Url
#    And send the DELETE request and get the response
#    Then validate deleted data

  @US_16_API_GET @ApiRegistrant @yasinbey
  Scenario: Get room info and validate
    When set Medunna Base Url
    And send the Get request and get the response
    And set the room's expected data
    Then do the validation

  @US_16_API_POST @ApiRegistrant @yasinbey
  Scenario: Post room info and validate
    When set  Base Url
    And set expected data
    And send the POST request and get the response
    Then validate data

  @US_16_API_PUT @ApiRegistrant @yasinbey
  Scenario: Update room info and validate
    When set the Medunna Base Url
    And set updated expected data
    And send the PUT request and get the response
    Then validate updated data

  @DB_US_16 @yasinbey
  Scenario: Validate room's number with DB
    Given set connection with database
    And select id column data
    Then validate room's number with the database


  @CreateTestItem @AdminUI @bulentbey
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

  @TestItemApi
  @ApiPostTestItemdemo @bulentbey
  Scenario: US17 Api post request to create test item
    Given user sets the path params to create test item
    And user sets expected data
    And user send Post request for test item and gets response
    And user saves the test item records
    Then user validates test item record with Api

  @TestItemApi
  @ApiGetTestItemdemo @bulentbey
  Scenario: US17 Api Get request for test item
    Given user sends the get request for test items data
    And user deserializes test items data to Java
    And user saves the test items data to correspondent file
    Then user validates expected test item records with Api

  @US17_DBTestdemo @bulentbey
  Scenario Outline: US17 db validations
    Given user creates connection with DB using "jdbc:postgresql://medunna.com:5432/medunna_db" and "medunnadb_user" , "Medunnadb_@129"
    And user sends query to DB and gets the column data "<query>" and "<columnName>"
    And user saves DB records to correspondent files
    Then user validates DB test item data

    Examples:  test data
      |query                     |columnName     |
      |Select * from c_test_item |name           |


  @Create @ilknurhanim
  Scenario Outline: US18_TC0001_admin_create_new_physicians
    Given user is on the homepage
    When user clicks human icon
    And user clicks sigin button
    Then user verifies signin page
    And user is sign in as a physician username "mariams" and password "789456123"
    And admin clicks Items and select physician from dropdown
    Then admin verify physician page
    And admin clicks Create New Physician button
    Then admin verify create edit new physician page
    And admin can choose search an existing registered person by "<SSN>"
    And admin clicks user search checkbox and search user button
    Then admin verify the success message
    And admin their info should be populated firstname, lastname birth date etc..
    And admin should provide a specialty for the Doctor
    And admin can provide a profile picture of the doctor
    Then admin verify a profile picture
    And admin should provide the Exam fee of the doctor
    And admin should choose the doctor among existing users
    And admin provide physicians country and state
    And admin clicks save button
    Then verify the success save message
    And admin finds an existing physician
    And admin clicks view button
    Then admin validate existing Physicians' info
    And admin clicks edit button
    And admin updates Physician's some data
    Then admin verify the update message
    And admin finds an existing physician
    And admin clicks delete button
    Then admin validate delete existing Physicians
    Examples: test data
      |SSN|
      |550-25-5656|


  @US_0019 @emrebey
  Scenario Outline: Admin can search new Staff among registered people using their SSN
    Given User is on the home page
    And User clicks on account icon
    And User clicks  on Sign in
    Then User verifies if user is on the sign in page
    When User provides valid "<username>" and "<password>"
    And  User clicks on Sign in button
    Then User verifies login is success as admin
    And User clicks on items&titles
    And User clicks on staff
    And User clicks on Create a new Staff button
    Then User provides SSN of registered person "<SSN>"
    And User clicks and puts check mark on Use Search checkbox
    And User clicks on Search User button
    Then User verifies User found with search SSN message
    Then user clicks user dropdown and verifies if user can select user from the existing users
    Examples:
      |username|password|SSN|
      |admemre |1234    |456-68-5214|

  @US_0019_TC_0003 @emrebey
  Scenario Outline: User can edit their info
    Given User is on the home page
    And User clicks on account icon
    And User clicks  on Sign in
    Then User verifies if user is on the sign in page
    When User provides valid "<username>" and "<password>"
    And  User clicks on Sign in button
    Then User verifies login is success as admin
    And User clicks on items&titles
    And User clicks on staff
    And User should proceed to second page
    And User clicks on edit button
    And User edits description
    Then User clicks save button and verify success message
    Examples:
      |username|password|
      |admemre |1234    |

  @US_0019_TC_0004 @emrebey
  Scenario Outline: User can delete their info
    Given User is on the home page
    And User clicks on account icon
    And User clicks  on Sign in
    Then User verifies if user is on the sign in page
    When User provides valid "<username>" and "<password>"
    And  User clicks on Sign in button
    Then User verifies login is success as admin
    And User clicks on items&titles
    And User clicks on staff
    And User should proceed to second page
    And User clicks on edit button
    And User deletes description
    Then User clicks save button and verify success message
    Examples:
      |username|password|
      |admemre |1234    |


  @ViewList @tugbahanim
  Scenario Outline:TC_0001 us20
    Given User is on the home page
    And User navigates to login page
    Then Verify if user is on the sign in page
    When User provides valid "<username>" and "<password>"
    And  User click Sign in button
    And admin clicks administration button
    And admin clicks user management
    And admin verifies that she can view registered people info as firstname, lastname, email etc.
    Examples:
      | username  | password |
      | admintugba | 123Tugba |

#    @CreateUpdateDelete
#    @UIRegistration @tugbahanim
#  Scenario Outline: test registration US20
#    Given user provides ssn id2 "<SSN>"
#    And  user provide firstname and lastname "<firstname>" and "<lastname>"
#    Then user create username "<username>"
#    And user provide also email "<email>"
#    And user generate the password "<password>"
#    And user registers and validates
#    Then user creates the records to a correspondent file
#    Examples: test data
#      | SSN         | firstname | lastname  | username  | email               | password |
#      | 383-35-3837 | tugbauser | tugbauser | tugbauser | tugbauser@gmail.com | 123Tugba |
#
#
#  @CreateUpdateDelete @tugbahanim
#  @UpdateUser #@UIRegistration ile birlikte çalıştırılacak
#  Scenario Outline:TC_0002 US20
#    Given User is on the home page
#    And User navigates to login page
#    Then Verify if user is on the sign in page
#    When User provides valid "<username>" and "<password>"
#    And  User click Sign in button
#    And admin clicks administration button
#    And admin clicks user management
#    And admin goes the last page
#    And admin finds the registrant
#    And admin actives the user
#    Then verifies the updated message
#    And admin gives physician role to the user
#    And admin verifies the message
#    And admin goes the last page
#    And admin finds the registrant
#    And admin gives staff role to the physician
#    And admin verifies the message
#    And admin goes the last page
#    And admin finds the registrant
#    And admin deletes the user
#    Then close the application
#    Examples:
#      | username | password |
#      | admintugba | 123Tugba |

  @StaffCanEditAssignAppointments @mustafabey
  Scenario: US21 Staff can assign physician but not delete or make appointments completed
    Given user is on the main page
    And user sign-in as staff
    And user selects Search Patient option from MYPAGES dropdown
    And user clicks show appointments button
    Then user verifies that there is no Delete button
    And user clicks edit button
    And user clicks status dropdown
    Then user verifies UNAPPROVED PENDING and CANCELLED options are selectable
    Then user verifies COMPLETED option is not selectable
    And user clicks physician dropdown
    And user selects physician from dropdown menu
    Then user verifies physician is selected


  @US_0022
  @US_0022TC_0001 @yesimhanim
  Scenario Outline: Staff can see patient by SSN id
    Given staff is on the home page
    And staff navigates on login page
    Given staff provides valid "<username1>" and "<password1>"
    And staff clicks Sign in button
    And staff clicks on my pages dropdown
    And staff clicks on search patient
    And staff clicks on patient SSN box
    And staff provides "<SSN>"
    Then staff verifies patient
    Then staff clicks on Sign out button

    Examples: patient SSN id
      |username1 |password1|SSN        |
      |staffrecep|123Recep |856-45-6789|

  @US_0022TC_0002 @yesimhanim
  Scenario Outline: Staff_edits_patient_test_results
    Given staff is on the home page
    And staff navigates on login page
    Given staff provides valid "<username1>" and "<password1>"
    And staff clicks Sign in button
    And staff clicks on my pages dropdown
    And staff clicks on search patient
    And staff clicks on patient SSN box
    And staff provides "<SSN>"
    And staff clicks on show appointments button
    And staff clicks on show test button
    And staff click on view results button
    And staff edits test results
    Then staff verifies visibility of test
    Then staff clicks on Sign out button

    Examples: patient SSN id
      |username1 |password1|SSN        |
      |staffrecep|123Recep |856-45-6789|


  @US_0022TC_0003 @yesimhanim
  Scenario Outline: Staff_edits_patient_test_results
    Given staff is on the home page
    And staff navigates on login page
    Given staff provides valid "<username1>" and "<password1>"
    And staff clicks Sign in button
    And staff clicks on my pages dropdown
    And staff clicks on search patient
    And staff clicks on patient SSN box
    And staff provides "<SSN>"
    And staff clicks on show appointments button
    And staff clicks on show test button
    And staff click on view results button
    Then staff verifies visibility of test result
    Then staff clicks on Sign out button

    Examples: patient SSN id
      |username1 |password1|SSN        |
      |staffrecep|123Recep |856-45-6789|
