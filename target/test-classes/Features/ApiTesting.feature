@api
Feature: Api requests
Description: Testing creating and retrieving pets

Background:
Given the base url is : https://petstore.swagger.io/v2

Scenario: Create a pet
When I create a pet with id 3465788 and I give the pet a name booboo in the request body and available status
Then the status code returned should be 200 and content type application json

Scenario: Retreive the created pet
When I perform a get request to the pet created previously
Then the status code should be 200, the content type application json, the pet's name is booboo and status is available

Scenario: Retreive an unvailable pet
When I perform a GET request to find a pet with ID 7867864
Then the status code should be 404 and content type is application.json 
And the response body message value should be : Pet not found






