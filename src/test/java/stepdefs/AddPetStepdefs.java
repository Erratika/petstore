package stepdefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import pojos.Category;
import pojos.Pet;
import utils.PetUtils;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;

public class AddPetStepdefs {
    private RequestSpecification requestSpecification;
    private Response response;
    private static Pet pet;

    @Given("I have constructed a request for the add pet endpoint with valid pet data")
    public void iHaveConstructedAValidRequestForTheAddPetEndpoint() {
        Category category = new Category();
        category.setId(7890);
        category.setName("Cats");
        pet = new Pet();
        pet.setId(123456);
        pet.setCategory(category);
        pet.setTags(new ArrayList<>());
        pet.setStatus("pending");
        pet.setPhotoUrls(new ArrayList<>());
        requestSpecification = RestAssured.given(PetUtils.addPetRequestSpec(pet));
    }

    @When("I make a POST request to the pet store API")
    public void iMakeAPOSTRequestToThePetStoreAPI() {
        response = requestSpecification.when()
                .post()
                .thenReturn();
    }

    @Then("I receive a response with a {int} status code")
    public void iReceiveAResponseWithAStatusCode(int expected) {
        MatcherAssert.assertThat(response.statusCode(), is(expected));
    }

    @And("the response body contains pet data that matches the data I sent")
    public void theResponseBodyContainsPetDataThatMatchesTheDataISent() {
        MatcherAssert.assertThat(response.as(Pet.class), is(pet));
    }

    @AfterAll
    public static void afterAll() {
        if (pet != null) {
            Response deletionResponse = RestAssured.given(PetUtils.deletePetRequestSpec(pet.getId()))
                                                   .delete()
                                                   .thenReturn();

            Assert.assertEquals(deletionResponse.statusCode(), 200);
        }
    }
}
