package stepDefinitions;

import resources.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.client.methods.RequestBuilder;

import pojoClasses.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.Assert;

public class TradeMeCharityTestSteps {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	RequestSpecification request;
	Charity[] responseCharities;

	@Given("I want to find if St John is a charity on TradeMe")
	public void i_want_to_find_if_st_john_is_a_charity_on_trade_me() {

		requestSpecification = new RequestSpecBuilder().setBaseUri(APIResources.valueOf("baseURI").getResource())
				.build();
	}

	@When("I request the information on All charities using {string} in {string} format")
	public void i_request_the_information_on_all_charities_using_in_format(String resource, String responseFormat) {

		String dynamicResource = APIResources.valueOf(resource).getResource();
		System.out.println(dynamicResource);

		dynamicResource = dynamicResource.replaceAll("file_format", responseFormat);
		responseSpecification = new ResponseSpecBuilder().build();

		request = given().spec(requestSpecification);

		responseCharities = request.when().get(dynamicResource).then().spec(responseSpecification).extract().response()
				.as(Charity[].class);

	}

	@Then("I verify if {string} is listed")
	public void i_verify_if_is_listed(String string) {

		boolean charityFound = false;
		for (int i = 0; i < responseCharities.length; i++) {
//			System.out.println(responseCharities[i].getDescription());

			if (responseCharities[i].getDescription().toString().contains("St John")) {
				charityFound = true;
				System.out.println("\n\nSt Johns Found");
				break;
			}
		}

		if (!charityFound) {
			System.out.println("\n\nSt Johns Not Found");
		}

	}

}
