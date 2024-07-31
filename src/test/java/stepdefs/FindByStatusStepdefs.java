package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import pojos.Pet;
import utils.PetUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class FindByStatusStepdefs {

    private Response response;
    private List<Pet> pets;
    private RequestSpecification requestSpecification;
    private String providedStatus;

    @Given("I have prepared a URL with {string}")
    public void iHavePreparedAURLWith(String status) {
        providedStatus = status;
        requestSpecification = RestAssured.given(PetUtils.findByStatusRequestSpec(status));
    }

    @Given("I have prepared a URL without a status parameter")
    public void iHavePreparedAURLWithoutAStatusParameter() {
        requestSpecification = RestAssured.given(PetUtils.findByStatusNoQueryParamRequestSpec());
    }

    @When("I perform a GET request")
    public void iPerformAGETRequest() {
        response = requestSpecification.when()
                .get()
                .thenReturn();
    }

    @And("I retrieve the pet data from the response body")
    public void iRetrieveThePetDataFromTheResponseBody() {
        pets = Arrays.asList(response.getBody().as(Pet[].class));
    }

    @Then("A {int} status code is returned")
    public void aStatusCodeIsReturned(int expectedStatusCode) {
        MatcherAssert.assertThat(response.statusCode(), is(expectedStatusCode));
    }

    @And("The response body contains more than one pet")
    public void theResponseBodyContainsMoreThanOnePet() {
        MatcherAssert.assertThat(pets.size(), greaterThan(1));
    }

    @And("The returned pets have the requested status")
    public void theReturnedPetsHaveTheRequestedStatus() {
        MatcherAssert.assertThat(pets.getFirst().getStatus(), is(providedStatus));
    }

    @And("The response body contains the error message {string}")
    public void theResponseBodyContainsTheErrorMessage(String expectedErrorMessage) {
        MatcherAssert.assertThat(response.jsonPath().getString("message"), containsString(expectedErrorMessage));
    }

    @And("The response body contains the message {string}")
    public void theResponseBodyContainsTheMessage(String expectedMessage) {
        String body = response.asString();
        MatcherAssert.assertThat(body, is(expectedMessage));
    }
}
