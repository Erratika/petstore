Feature: Find pets by status

  As a user I want to be able to find pets by their status so that I can find relevant pets

  Scenario Outline: Find pets by valid status
    Given I have prepared a URL with "<status>"
    When I perform a GET request
    Then A 200 status code is returned
    And The response body contains more than one pet
    And The returned pets have the requested status
    Examples:
      | status |
      | pending |
      | available |
      | sold |