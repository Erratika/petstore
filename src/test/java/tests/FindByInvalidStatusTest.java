package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PetUtils;

import static org.hamcrest.Matchers.*;

public class FindByInvalidStatusTest {

    private static Response response;

    @BeforeAll
    public static void beforeAll() {
        response = RestAssured.given(PetUtils.findByStatusRequestSpec("invalid"))
                              .when()
                              .get()
                              .thenReturn();
    }

    @Test
    @DisplayName("Searching using an invalid status returns a 400 status code")
    void searchingUsingAnInvalidStatusReturnsA400StatusCode() {
        MatcherAssert.assertThat(response.statusCode(), is(400));
    }

    @Test
    @DisplayName("Searching using an invalid status returns a body with an error message")
    void searchingUsingAnInvalidStatusReturnsABodyWithAnErrorMessage() {
        String expectedError = "Input error: query parameter `status value `invalid` is not in the allowable values `[available, pending, sold]`";
        MatcherAssert.assertThat(response.jsonPath().getString("message"), is(expectedError));
    }
}
