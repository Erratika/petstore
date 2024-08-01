# Created by marcm at 01/08/2024
Feature: Create user on API
  As a user I want to be able to create a new account so that i can perform other operations on the API.

  Scenario: Create valid user
    Given I have prepared a request with the following user details
      | id    | username  | email              | password | firstName | lastName | phoneNumber |
      | 33452 | example38 | test@example38.com | password | Test      | Example  | 04823748928 |
    When I perform a POST request
    Then A 200 status code is returned
   #Expand with more tests

  Scenario: Create user with existing id
    Given I have prepared a request with the following user details
      | id    | username  | email              | password | firstName | lastName | phoneNumber |
      | 33452 | example38 | test@example38.com | password | Test      | Example  | 04823748928 |
    When I perform a POST request
    Then A 409 status code is returned

    # Enter steps here