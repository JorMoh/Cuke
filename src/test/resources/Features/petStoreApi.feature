@api
Feature: Api Validations
Testing CRUD functions

Background:
Given base url is "https://petstore.swagger.io/v2"

Scenario: Find by status,
When I Send a request to find by status “pending”
Then status code should be 200 and content type application json

Scenario: Add a pet
When I add a pet with the body provided
Then status code should be 200 and content type application json
And the pet's name should be “max”

Scenario: Update a pet
When I update the previously added pet by changing the category name to 'dogs'
Then status code should be 200 and content type application json
And the category name should updated to 'dogs'

Scenario: Validate response 
When I Send a request to find the pet created by ID
Then status code should be 200 and content type application json
And the response body elements should match the expected

Scenario: Improper update
When I send an update request of the pet with improper body
Then the status code should be 400 and the response message should say: bad input

Scenario: Delete the pet
When I send a delete request of the pet
Then status code should be 200 and content type application json
And the response 'message' value should match the pet ID












	  
	 
	  
	  