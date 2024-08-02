package stepdefs.user;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import stepdefs.AbstractAPI;
import utils.UserUtil;

public class LoginStepdefs extends AbstractAPI {
	@Given("I have prepared a request to login with username {string} and password {string}")
	public void iHavePreparedARequestToLoginWithUsernameAndPassword(String username, String password) {
		setRequestSpecification(RestAssured.given(UserUtil.login(username, password)));
	}
}
