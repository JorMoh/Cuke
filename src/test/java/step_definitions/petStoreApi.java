package step_definitions;

import java.io.File;

import com.github.dockerjava.api.command.RestartContainerCmd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class petStoreApi {
	Response response;
	

	
	@Given("base url is {string}")
	public void base_url_is(String url) {
	  RestAssured.baseURI = url;
	    
//	Scenario: Find by status,    
	}
	@When("I Send a request to find by status “pending”")
	public void i_send_a_request_to_find_by_status_pending() {
	    response = RestAssured
			   .given().accept(ContentType.JSON)
			   .param("status", "pending")
			   .when().get("/pet/findByStatus");
	}
	@Then("status code should be 200 and content type application json")
	public void status_code_should_be_and_content_type_application_json() {
	   response.then()
	   .assertThat().statusCode(200).and().contentType("application/json");
	   response.prettyPrint();
	}


//  Scenario: Add a pet
	@When("I add a pet with the body provided")
	public void i_add_a_pet_with_the_body_provided() {
	   File requestBody = new File("./src/test/resources/TestData/ApiData/addPet.json"); 
	   response = RestAssured
			   .given().accept(ContentType.JSON)
			   .body(requestBody).contentType("application/json")
			   .when().post("/pet");
			   
	}
	
	@Then("the pet's name should be “max”")
	public void the_pet_s_name_should_be_max() {
	    response.then().assertThat().body("name", equalTo("Max"));
	    response.prettyPrint();
	}



//	Scenario: Update a pet
	@When("I update the previously added pet by changing the category name to 'dogs'")
	public void i_update_the_previously_added_pet_by_changing_the_category_name_to() {
		  String requestBody = "{\n"
			  		+ "  \"id\": 1234,\n"
			  		+ "  \"category\": {\n"
			  		+ "    \"id\": 21,\n"
			  		+ "    \"name\": \"dogs\"\n"
			  		+ "  },\n"
			  		+ "  \"name\": \"Max\",\n"
			  		+ "  \"photoUrls\": [\n"
			  		+ "    \"string\"\n"
			  		+ "  ],\n"
			  		+ "  \"tags\": [\n"
			  		+ "    {\n"
			  		+ "      \"id\": 0,\n"
			  		+ "      \"name\": \"string\"\n"
			  		+ "    },\n"
			  		+ "    {\n"
			  		+ "        \"id\": 1,\n"
			  		+ "        \"name\":\"String2\"\n"
			  		+ "    }\n"
			  		+ "  ],\n"
			  		+ "  \"status\": \"available\"\n"
			  		+ "}";
		  
		  response = RestAssured
				  .given().accept(ContentType.JSON)
				  .body(requestBody).contentType("application/json")
				  .when().put("/pet");
	}
  
	@Then("the category name should updated to 'dogs'")
	public void the_category_name_should_updated_to() {
	    String categoryName = response.body().jsonPath().get("category.name");
	    assertEquals(categoryName, "dogs");
	}



//  Scenario: Validate response  
	@When("I Send a request to find the pet created by ID")
	public void i_send_a_request_to_find_the_pet_created_by_id() {
	    response = RestAssured
	    		.given().accept(ContentType.JSON)
	    		.when().get("/pet/1234");
	    		
	}
	
	@Then("the response body elements should match the expected")
	public void the_response_body_elements_should_match_the_expected() {
	    response.then().assertThat()
	    .body("id", equalTo(1234))
	    .body("category.id", equalTo(21))
	    .body("name", equalTo("Max"))
	    .body("category.name", equalTo("dogs"))
	    .body("tags.id[0]", equalTo(0))
	    .body("tags.name[1]", equalTo("String2"));
	    
	    
	}


//  Scenario: Improper update	
	@When("I send an update request of the pet with improper body")
	public void i_send_an_update_request_of_the_pet_with_improper_body() {
		String requestBody = "{\n"
				+ "  \"id\": 123123123f,\n"
				+ "  \"category\": {\n"
				+ "    \"id\": 21,\n"
				+ "    \"name\": \"string\"\n"
				+ "  },\n"
				+ "  \"name\": \"Max\",\n"
				+ "  \"photoUrls\": [\n"
				+ "    \"string\"\n"
				+ "  ],\n"
				+ "  \"tags\": [\n"
				+ "    {\n"
				+ "      \"id\": 0,\n"
				+ "      \"name\": \"string\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "        \"id\": 1,\n"
				+ "        \"name\":\"String2\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"status\": \"available\"\n"
				+ "}";
		
		response = RestAssured
				.given().accept(ContentType.JSON)
				.body(requestBody).contentType("application/json")
				.when().put("/pet");
		
		
	}
	@Then("the status code should be 400 and the response message should say: bad input")
	public void the_status_code_should_be_and_the_response_message_should_say_bad_input() {
	   response.then().assertThat().statusCode(400)
	   .and().body("message", equalTo("bad input"));
	}




//  Scenario: Delete the pet
	@When("I send a delete request of the pet")
	public void i_send_a_delete_request_of_the_pet() {
	   response = RestAssured
			   .given().accept(ContentType.JSON).contentType("application/json")
			   .when().delete("/pet/1234");
	}
	@Then("the response 'message' value should match the pet ID")
	public void the_response_value_should_match_the_pet_id() {
	  response.then().body("message", equalTo("1234"));
	}







}
