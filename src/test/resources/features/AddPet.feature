Feature: Add a pet to the store

  As a user, I want to be able to add a pet to the store
  so that I can update the store with information about my pets

  Scenario: Add a valid pet

    Given I have constructed a request for the add pet endpoint with valid pet data
    When I make a POST request to the pet store API
    Then I receive a response with a 200 status code
    And the response body contains pet data that matches the data I sent