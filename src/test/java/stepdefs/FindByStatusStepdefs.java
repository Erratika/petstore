package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.MatcherAssert;
import pojos.Pet;
import utils.PetUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class FindByStatusStepdefs extends AbstractAPI {

    private List<Pet> pets;
    private String providedStatus;

    @Given("I have prepared a URL with {string}")
    public void iHavePreparedAURLWith(String status) {
        providedStatus = status;
        setRequestSpecification(RestAssured.given(PetUtils.findByStatusRequestSpec(status)));
    }

    @When("I perform a GET request")
    public void iPerformAGETRequest() {
        setResponse(getRequestSpecification().when()
                .get()
                .thenReturn());
        try {
            pets = Arrays.asList(getResponse().getBody().as(Pet[].class));
        } catch (Exception e) {
            pets = new ArrayList<>();
        }
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
        MatcherAssert.assertThat(getResponse().jsonPath().getString("message"), containsString(expectedErrorMessage));
    }
}
