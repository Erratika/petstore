package tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.User;
import utils.UserUtil;

public class CreateUserTest {

	@BeforeAll
	public static void beforeAll() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("password");
		user.setEmail("test@example.com");
		user.setFirstName("Test");
		user.setLastName("Example");
		user.setId(17632);

		Response response = RestAssured
				.given(UserUtil.createUser(user))
				.when()
				.post()
				.thenReturn();
	}

	@Test
	public void createUserTest() {}
}
