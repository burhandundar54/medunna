Feature:  test database
  @DBUsers
  Scenario Outline: test database users
    Given user sends the "<query>" to DB
    And user saves data in correspondent files
    Examples: query
      |query|
      |select id from physician |