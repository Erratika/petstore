# Created by marcm at 01/08/2024
Feature: Create user on API
  As a user I want to be able to create a new account so that i can perform other operations on the API.

  Scenario: Create valid user
    Given I have prepared a request with the following user details
      | id          | 1              |
      | username    | example1          |
      | email       | test1@example38.com |
      | password    | password           |
      | firstName   | Test               |
      | lastName    | Example            |
      | phoneNumber | 04823748928        |
      | userStatus  | 1                  |
    When I perform a POST request
    Then A 201 status code is returned

  Scenario: Create user with existing id
    Given I have prepared a request with the following user details
      | id          | 1              |
      | username    | example2          |
      | email       | test2@example38.com |
      | password    | password           |
      | firstName   | Test               |
      | lastName    | Example            |
      | phoneNumber | 04823748928        |
      | userStatus  | 1                  |
    When I perform a POST request
    Then A 409 status code is returned

  Scenario: Create user with existing username
    Given I have prepared a request with the following user details
      | id          | 2              |
      | username    | example1          |
      | email       | test3@example.com |
      | password    | password           |
      | firstName   | Test               |
      | lastName    | Example            |
      | phoneNumber | 04823748928        |
      | userStatus  | 1                  |
    When I perform a POST request
    Then A 409 status code is returned

  Scenario: Create user with existing username
    Given I have prepared a request with the following user details
      | id          | 3              |
      | username    | example3          |
      | email       | test1@example.com |
      | password    | password           |
      | firstName   | Test               |
      | lastName    | Example            |
      | phoneNumber | 04823748928        |
      | userStatus  | 1                  |
    When I perform a POST request
    Then A 409 status code is returned