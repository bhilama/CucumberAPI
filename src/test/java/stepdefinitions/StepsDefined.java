package stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import resources.PayLoadData;
import resources.Utils;

public class StepsDefined extends Utils {
	
	PayLoadData payloadData = new PayLoadData();
	RequestSpecification reqLogin;
	LoginResponse loginResponse;
	Response resp;

	@Given("I have username {string} and password {string}")
	public void i_have_username_infy_maheshb_gmail_com(String userID, String password) throws IOException {
		
		reqLogin = given().spec(requestSpecification()).contentType(ContentType.JSON).body(payloadData.getLoginPayload(userID, password));
		System.out.println("I have username " + userID);
		
	}
	
	@When("I send post request")
	public void i_send_post_request() {
		
		resp = reqLogin.when().post("/api/ecom/auth/login").then().extract().response();
		System.out.println("I send post request");
	}
	@Then("I get {string} in response")
	public void i_get_in_response(String string) {
	   System.out.println(resp.asString());
	}
}
