@ApiValidationTests
Feature: Registrant api test

  @ApiPostRegistrant
  Scenario Outline: TC09 user should create registrant using Api and validate
    Given user sets the necessary path params
    And user sets the expected data "<firstname>" "<lastname>" "<SSN>" "<email>" "<username>" "<password>" "<lan>"
    And user sends the POST request and gets the response
    And user saves the api records to correspondent files
    Then user validates api records

    Examples: api test data
    |firstname|lastname|SSN        |email            |username |password |lan|
    |Stephan  |Taylor  |215-83-1456|stephan@gmail.com|s.taylor |123T45as?|Eng|

  @ApiRegistrant
  Scenario Outline: TC08 user should get all registrant information using Api and validate them
    Given user sets the endpoint to get user info with "<SSN>"
    And user sets the expected data as "<firstname>" "<lastname>" "<SSN>" "<email>" "<username>" "<password>"
    And user makes a GET request and gets the response
    Then user validates registrant information using api

    Examples: previously created data
    |firstname|lastname |SSN        |email                      |username       |password          |
    |Alton    |Casper   |527-87-5703|theresia.cummings@gmail.com|vergie.donnelly|Q9@L*%H7          |
    |Bud      |Robel    |691-81-5313|eileen.howe@gmail.com      |efrain.hyatt   |Ww25EMQr!ax4      |
    |Dahlia   |Huels    |383-06-4367|erna.ebert@yahoo.com       |tracy.hintz    |TroG0ib#9O6S3cRxr9|
    |Fatima   |Wilkinson|635-57-1782|paula.hills@gmail.com      |michaela.wisozk|tZ*P&qPI5t&P7^CN  |
    |Sixta    |Boehm    |024-85-5660|janene.kuhic@hotmail.com   |cheri.harber   |0rU&b1i5wtd10F    |
    |Leslie   |Collins  |784-87-3883|elois.von@gmail.com        |theda.goyette  |iN1IYMN9fDgs4J    |
    |Myrtie   |Larkin   |164-07-3409|sharon.abshire@hotmail.com |david.schneider|kOwt5lz*A#Lt      |
    |Laraine  |Jenkins  |531-36-5815|ewa.roberts@hotmail.com    |nick.stracke   |^FF@58KYI0        |




