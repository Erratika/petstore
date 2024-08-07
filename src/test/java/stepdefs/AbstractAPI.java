package stepdefs;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractAPI {
	private static RequestSpecification requestSpecification;
	private static Response response;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public RequestSpecification getRequestSpecification() {
		return requestSpecification;
	}

	public void setRequestSpecification(RequestSpecification requestSpecification) {
		this.requestSpecification = requestSpecification;
	}
}
