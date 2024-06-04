package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
		
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		

		req = new RequestSpecBuilder().setBaseUri(globalValues("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		}
		return req;
	}
	
	
	public String globalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		prop.load(fin);
		return prop.getProperty(key);
	}
}
