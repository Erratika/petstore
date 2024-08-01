package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import pojos.User;
import utils.UserUtil;

import java.util.Map;

public class CreateUserStepdefs extends AbstractAPI {
	private User sentUser;

	@Given("I have prepared a request with the following user details")
	public void iHavePreparedARequestWith(DataTable dataTable) {
		Map<String, String> userDetails = dataTable.asMap();
		sentUser = new User();
		sentUser.setUsername(userDetails.get("username"));
		sentUser.setPassword(userDetails.get("password"));
		sentUser.setEmail(userDetails.get("email"));
		sentUser.setFirstName(userDetails.get("firstName"));
		sentUser.setLastName(userDetails.get("lastName"));
		sentUser.setId(Integer.parseInt(userDetails.get("id")));
		sentUser.setPhone(userDetails.get("phoneNumber"));
		setRequestSpecification(RestAssured
				.given(UserUtil.createUser(sentUser)).body(sentUser));

	}


}
