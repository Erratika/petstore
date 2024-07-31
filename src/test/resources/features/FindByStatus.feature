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

    Scenario Outline: Find pets by invalid status
      Given I have prepared a URL with "<status>"
      When I perform a GET request
      Then A 400 status code is returned
      And The response body contains the error message "Input error:"
      Examples:
        | status |
        | |
        | invalid |

    Scenario: Find pets by status without providing a status parameter
      Given I have prepared a URL without a status parameter
      When I perform a GET request
      Then A 400 status code is returned
      And The response body contains the message "No status provided. Try again?"