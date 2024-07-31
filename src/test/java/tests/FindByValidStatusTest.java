package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.Pet;
import utils.PetUtils;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class FindByValidStatusTest {

    private static Response response;
    private static List<Pet> pets;

    @BeforeAll
    public static void beforeAll() {
        response = RestAssured.given(PetUtils.findByStatusRequestSpec("pending"))
                .when()
                .get()
                .thenReturn();
        pets = Arrays.asList(response.getBody().as(Pet[].class));
    }

    @Test
    @DisplayName("Searching with a valid status returns a 200 response status code")
    void searchingWithAValidStatusReturnsA200ResponseStatusCode() {
        MatcherAssert.assertThat(response.statusCode(), is(200));
    }

    @Test
    @DisplayName("Searching with a valid status returns multiple pets")
    void searchingWithAValidStatusReturnsMultiplePets() {
        MatcherAssert.assertThat(pets.size(), greaterThan(1));
    }

    @Test
    @DisplayName("Searching with a valid status returns pets with that status")
    void searchingWithAValidStatusReturnsPetsWithThatStatus() {
        MatcherAssert.assertThat(pets.getFirst().getStatus(), is("pending"));
    }
}
