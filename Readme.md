# Pet store testing

A project to test functionality of the [pet store API](https://petstore3.swagger.io). Currently tests endpoints for finding and adding pets as well as for creating users and logging in.

## Getting Started

### Prerequisites

* Java 21
* Intellij is the recommended IDE for this project with the plugins Cucumber for Java and Gherkin
* Maven

### Installation

Clone the repository and open in your preferred IDE. Install the dependencies from the pom.xml using maven.

## Usage

Tests can be run within an IDE by running the Cucumber runner class in `src/test/java/tests`. Alternatively, they can be run by executing `mvn clean test` in the command line. Either way, running the tests will generate JSON- and HTML-formatted reports in the `target` directory.

## Defects

A summary of defects identified while working with the API.

| ID | Title                                                                              | Date       | Author         | Context                                                                                                                        | Description                                                                                                  | Expected                                                                                                                                                           | Actual                                                                                                                                                            | Severity | Priority |
|----|------------------------------------------------------------------------------------|------------|----------------|:-------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|----------|
| 1  | Posting pet without ID causes server error                                         | 01/08/2024 | Alastair Smith | Occurs when attempting to add a new pet to the store sending a POST request to the /pet endpoint                               | Send a POST request to the /pet endpoint. The body contains a JSON-formatted pet object without an ID field. | The response status should be a 4xx code, such as 400 or 405 (as stated in the swagger documentation). This should be accompanied by an informative error message. | The response status is a 500 server error with the generic error message "There was an error processing your request. It has been logged (ID: daa18c0cc5aa0024)". | Medium   | Medium   |
| 2  | Error response after attempt to post a pet without a request body is uninformative | 01/08/2024 | Alastair Smith | Occurs when attempting to add a new pet to the store sending a POST request to the /pet endpoint without adding a request body | Send a POST request to the /pet endpoint without any request body.                                           | The response status should be a 4xx code, such as 400 or 405 (as stated in the swagger documentation). This should be accompanied by an informative error message. | Rather than an informative message, there is what appears to be a json serialisation of an internal object.                                                       | Medium   | Medium   |

## Contributors

* Marc Murray
  * Testing of the user endpoints
* Alastair Smith
  * Testing the pets endpoints