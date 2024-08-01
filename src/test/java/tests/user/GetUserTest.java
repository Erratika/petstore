package tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.UserUtil;

import static org.hamcrest.Matchers.is;

public class GetUserTest {
	private static Response response;

	@BeforeAll
	public static void beforeAll() {
		response = RestAssured.given(UserUtil.getUser("example37")).get().thenReturn();
	}

	@Test
	public void returns200StatusCode(){
		MatcherAssert.assertThat(response.statusCode(),is(200));
	}
}
