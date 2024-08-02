# Pet store testing

A project to test functionality of the [pet store API](https://petstore3.swagger.io). Currently, tests endpoints for
finding and adding pets as well as for creating users and logging in.

## Getting Started

### Prerequisites

* Java 21
* Intellij is the recommended IDE for this project with the plugins Cucumber for Java and Gherkin
* Maven

### Installation

Clone the repository and open in your preferred IDE. Install the dependencies from the pom.xml using maven.

## Usage

Tests can be run within an IDE by running the Cucumber runner class in `src/test/java/tests`. Alternatively, they can be
run by executing `mvn clean test` in the command line. Either way, running the tests will generate JSON- and
HTML-formatted reports in the `target` directory.

## Tested Endpoints
- Pet
  - POST /pet/{petId}
  - GET /pet/findByStatus
- User
  - POST /user
  - GET /user/login
  - GET /user/{username}


## Defects

A summary of defects identified while working with the API.

| ID | Title                                                                              | Date       | Author         | Context                                                                                                                        | Description                                                                                                  | Expected                                                                                                                                                                                                                                     | Actual                                                                                                                                                            | Severity | Priority |
|----|------------------------------------------------------------------------------------|------------|----------------|:-------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|----------|
| 1  | Posting pet without ID causes server error                                         | 01/08/2024 | Alastair Smith | Occurs when attempting to add a new pet to the store sending a POST request to the /pet endpoint                               | Send a POST request to the /pet endpoint. The body contains a JSON-formatted pet object without an ID field. | The response status should be a 4xx code, such as 400 or 405 (as stated in the swagger documentation). This should be accompanied by an informative error message.                                                                           | The response status is a 500 server error with the generic error message "There was an error processing your request. It has been logged (ID: daa18c0cc5aa0024)". | Medium   | Medium   |
| 2  | Error response after attempt to post a pet without a request body is uninformative | 01/08/2024 | Alastair Smith | Occurs when attempting to add a new pet to the store sending a POST request to the /pet endpoint without adding a request body | Send a POST request to the /pet endpoint without any request body.                                           | The response status should be a 4xx code, such as 400 or 405 (as stated in the swagger documentation). This should be accompanied by an informative error message.                                                                           | Rather than an informative message, there is what appears to be a json serialisation of an internal object.                                                       | Medium   | Medium   |
| 3  | Inappropriate error when creating user with an existing id.                        | 01/08/2024 | Marc Murray    | Occurs when attempting to add a new user with an already existing id sending a POST to the /user endpoint.                     | Send a POST request to /user endpoint with an existing id.                                                   | The response status should return a 409 - Conflict as is more appropriate per REST standards. This should be accompanied with message stating that id already exists. Alternatively id should auto-increment and be ignored in post request. | Returns 200 - Success status code and overwrites the user with the existing id.                                                                                   | High     | High     |
| 4  | Inappropriate error when creating user with an existing username.                  | 01/08/2024 | Marc Murray    | Occurs when attempting to add a new user with an already existing username sending a POST to the /user endpoint.               | Send a POST request to /user endpoint with an existing username.                                             | The response status should return a 409 - Conflict as is more appropriate per REST standards. This should be accompanied with message stating that username already exists.                                                                  | Returns 200 - Success status code and any further operations utilising username prioritises the latest User entity with same username that is posted.             | High     | High     |
| 5  | Inappropriate error when creating user with an existing email.                     | 01/08/2024 | Marc Murray    | Occurs when attempting to add a new user with an already existing email sending a POST to the /user endpoint.                  | Send a POST request to /user endpoint with an existing email.                                                | The response status should return a 409 - Conflict as is more appropriate per REST standards. This should be accompanied with message stating that email already exists.                                                                     | Returns 200 - Success status code.                                                                                                                                | Low      | Medium   |
| 6  | Get user accepting non-standard characters.                                        | 01/08/2024 | Marc Murray    | Occurs when attempting to get a user with an invalid username sending a GET request to /user/{username} endpoint.              | Send a GET request to /user/{username} with a username containing invalid characters such as "][=/-';#.,".   | The response status should return a 400 - Bad Request per the swagger documentation.                                                                                                                                                         | Returns 404 - Not Found status code.                                                                                                                              | High     | Medium   |
| 7  | Login with incorrect password.                                                     | 01/08/2024 | Marc Murray    | Occurs when attempting to login with a correct username and invalid password, sending a GET request to /user/login endpoint.   | Send a GET request to /user/login with valid existing username and invalid password.                         | The response status should return a 400 - Bad Request per the swagger documentation.                                                                                                                                                         | Returns 200 - Success status code and creates a session with invalid credentials.                                                                                 | High     | High     |
| 8  | Login with a user that does not exist.                                             | 01/08/2024 | Marc Murray    | Occurs when attempting to login with a username that does not exist, sending a GET request to /user/login endpoint.            | Send a GET request to /user/login with a username that does not exist.                                       | The response status should return a 400 - Bad Request per the swagger documentation.                                                                                                                                                         | Returns 200 - Success status code and creates a session with invalid credentials.                                                                                 | High     | High     |
| 9  |                                                                                    |            |                |                                                                                                                                |                                                                                                              |                                                                                                                                                                                                                                              |                                                                                                                                                                   |          |          |

## Test Report
Latest test report can be found [here](https://reports.cucumber.io/reports/22c515bd-a573-436e-a180-079ea230865c).
## Contributors

* Marc Murray
    * Testing of the user endpoints
* Alastair Smith
    * Testing the pets endpoints