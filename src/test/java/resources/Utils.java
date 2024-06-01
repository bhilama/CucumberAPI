package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Utils {

	RequestSpecification req;
	public RequestSpecification requestSpecification() throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return req;
	}
}
