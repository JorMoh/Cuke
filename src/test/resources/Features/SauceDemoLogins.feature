Feature: Sauce Login
As a Sauce user,
I want to be able to login to my Sauce account,
so i can explore products it offers

Background:
Given I am on SauceDemo website login page
And I enter a valid password "secret_sauce"


Scenario: Log in with valid username

When I enter a valid user "standard_user"
And I click the login button
Then I shoud be logged in successfully

Scenario: Log in with invalid user 
When I enter an invalid username "invalid_user"
And I click the login button
Then I should not be logged in
And I should get the creds. don't match error message

Scenario: Log in with locked out user
When I enter a locked out username "locked_out_user"
And I click the login button
Then I should not be logged in
And I should get the locked out user error message
