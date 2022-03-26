@AppointmentApiFunctionalities
Feature: Appointment Api functionalities

  @AppointmentPostApi
  Scenario Outline: api post request to create new appointment
    Given user sets the path params
    And user sets expected data "<firstname>" "<lastname>" "<ssn>" "<email>" "<phone number>" "<appointment date>"
    And user send Post request and gets response
    And user saves the records
    Then user validates record with Api

    Examples:
    |firstname|lastname|ssn|email|phone number|appointment date|
    |firstname|lastname|ssn|email|973-212-4556|2022-03-22|
    |firstname|lastname|ssn|email|273-362-9854|2022-03-23|
    |firstname|lastname|ssn|email|375-257-4721|2022-03-24|


  @AppointmentGetApi @bulentAp
  Scenario Outline: api get request for appointments
    Given user sends the get request for appointments data
    Then user deserializes data to Java and validates "<firstname>" "<lastname>" "<ssn>" "<email>" and "<phone number>"

    Examples: appointment data created with Post request
    |firstname |lastname  |ssn          |email                     |phone number|
    |Lakeisha  |Little    |266-95-6537  |ricarda.wiegand@yahoo.com |973-212-4556|
    |Cornelia  |Goodwin   |717-93-9632  |aron.orn@yahoo.com        |273-362-9854|
    |Paul      |Bashirian |202-45-3723  |maximo.kirlin@yahoo.com   |375-257-4721|
    |Arthur             |Hegmann            |714-51-3242      |lucina.brakus@gmail.com         |973-212-4556|





