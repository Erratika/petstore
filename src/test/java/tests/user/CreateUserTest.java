package tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.User;
import utils.UserUtil;

import static org.hamcrest.Matchers.is;

public class CreateUserTest {
	private static User sentUser;
	private static User responseUser;
	private static Response response;

	@BeforeAll
	public static void beforeAll() {
		sentUser = new User();
		sentUser.setUsername("example37");
		sentUser.setPassword("password");
		sentUser.setEmail("test@example.com");
		sentUser.setFirstName("Test");
		sentUser.setLastName("Example");
		sentUser.setId(17632);

		response = RestAssured
				.given(UserUtil.createUser(sentUser))
				.when()
				.post()
				.thenReturn();
		responseUser = response.getBody().as(User.class);

	}
	@Test
	public void returns200StatusCode(){
		MatcherAssert.assertThat(response.statusCode(),is(200));
	}

	@Test
	public void createUserHasCorrectUsername() {
		MatcherAssert.assertThat(responseUser.getUsername(),is(sentUser.getUsername()));

	}
	@Test
	public void createUserHasCorrectPassword() {

	}

	@Test
	public void createUserHasCorrectEmail() {

	}
	@Test public void createUserHasCorrectFirstName() {

	}
	@Test public void createUserHasCorrectLastName() {

	}
	@Test public void createUserHasCorrectId() {

	}
	@Test public void createUserHasCorrectUsernameAndPassword() {}
}
