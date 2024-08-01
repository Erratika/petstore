package tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import utils.UserUtil;

public class UserLoginTest {
	private static Response response;
	@BeforeAll
	public static void beforeAll(){
		response = RestAssured.given(UserUtil.login("example37","password")).get().thenReturn();

	}
}
