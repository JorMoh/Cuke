package step_definitions;

import java.io.File;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class ApiTesting {
	Response response;
	Response response2;
	int PetID;

	

	@Given("the base url is : https:\\/\\/petstore.swagger.io\\/v2")
	public void the_base_url_is_https_petstore_swagger_io_v2() {
	    RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
 
//	Scenario: Create a pet
	
	@When("I create a pet with id 3465788 and I give the pet a name booboo in the request body and available status")
	public void i_create_a_pet_with_id_and_i_give_the_pet_a_name_booboo_in_the_request_body_and_available_status() {
		
		File requestBody = new File("./src/test/resources/TestData/ApiData/createPet2.json"); 
	    response = RestAssured
			   .given().accept(ContentType.JSON)
			   .when().body(requestBody).contentType("application/json").post("/pet");
	   
	  
			   
	}
	@Then("the status code returned should be 200 and content type application json")
	public void the_status_code_returned_should_be_and_content_type_application_json() {
		 response.then()
		   .assertThat().statusCode(200).and().contentType("application/json");
		 
		 PetID = response.body().path("id");
		 System.out.println("pet id is: "+PetID);
		
	}
	
	
	
//	Scenario: Retreive the created pet
	
	@When("I perform a get request to the pet created previously")
	public void i_perform_a_get_request_to_the_pet_created_previously() {
		 
	   response = RestAssured
			   .given().accept(ContentType.JSON)
			   .when().get("/pet/3465788");
	  
	}
	@Then("the status code should be 200, the content type application json, the pet's name is booboo and status is available")
	public void the_status_code_should_be_the_content_type_a_j_the_pet_s_name_is_booboo_and_status_is_available() {
	   response.then()
	   .assertThat().statusCode(200).and().contentType("application/json")
	   .body("name", equalTo("booboo"))
	   .body("status", equalTo("available"));
	   
	   
	}


//	Scenario: Retreive an unvailable pet
	
	@When("I perform a GET request to find a pet with ID 7867864")
	public void i_perform_a_get_request_to_find_a_pet_with_id() {
	  response = RestAssured
			  .given().accept(ContentType.JSON)
			  .when().get("/pet/7867864");
	}
	@Then("the status code should be 404 and content type is application.json")
	public void the_status_code_should_be_and_content_type_is_application_json() {
	    response.then()
	    .assertThat().statusCode(404).and().contentType("application/json");
	}
	@Then("the response body message value should be : Pet not found")
	public void the_response_body_message_value_should_be_pet_not_found() {
		response.then()
		.body("message", equalTo("Pet not found"));
	    
	}







}
