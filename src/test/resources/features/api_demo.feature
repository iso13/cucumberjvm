Feature: api_demo
  As an Engr
  I want to test apis
  So I can provide additional code coverage

  Scenario: Star Wars API
    Given the apis are up and running for "https://swapi.co/"
    When a user performs a GET request to "api/starships/9/"
    Then the response code should be 200
    And the response should have the following
      | name         | Death Star                                                     |
      | model        | DS-1 Orbital Battle Station                                    |
      | manufacturer | Imperial Department of Military Research, Sienar Fleet Systems |
      | length       | 120000                                                         |
