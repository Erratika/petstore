package stepdefs.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.hamcrest.MatcherAssert;
import pojos.User;
import stepdefs.AbstractAPI;
import utils.UserUtil;

import static org.hamcrest.Matchers.is;

public class GetUserStepdefs extends AbstractAPI {
	@Given("I have prepared a request to get user details with username {string}")
	public void iHavePreparedARequestToGetUserDetailsWithUsername(String username) {
		setRequestSpecification(RestAssured.given(UserUtil.getUser(username)));
	}

	@And("username is {string}")
	public void usernameIs(String expectedUsername) {
		User user = getResponse().getBody().as(User.class);
		MatcherAssert.assertThat(user.getUsername(),is(expectedUsername));
	}

	@And("id is {int}")
	public void idIs(int expectedId) {
		User user = getResponse().getBody().as(User.class);
		MatcherAssert.assertThat(user.getId(),is(expectedId));
	}

	@And("firstName is {string}")
	public void firstnameIs(String expectedFirstName) {
		User user = getResponse().getBody().as(User.class);
		MatcherAssert.assertThat(user.getFirstName(),is(expectedFirstName));
	}

	@And("lastName is {string}")
	public void lastnameIs(String expectedLastName) {
		User user = getResponse().getBody().as(User.class);
		MatcherAssert.assertThat(user.getLastName(),is(expectedLastName));
	}

	@Given("I have prepared a request to get user details with username null")
	public void iHavePreparedARequestToGetUserDetailsWithUsernameNull() {
		setRequestSpecification(RestAssured.given(UserUtil.getUser(null)));

	}
}
