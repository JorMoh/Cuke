Feature: Login Popups
As a Guru user,
I want to be able to sign in,
So that I gain access to different projects

Scenario: Sign in using a valid email

Given I am on the guru popup page
And I get the page title and store it
And I click on the CLICK HERE button and switch over to the next window
And I provide an email "m.muhaidat877@yahoo.com" and click submit
And I get the texts of user ID and passwords
Then I should verify that the text “This access is valid only for20 days is displayed.” 
When I close the window
And I go back to the main window, and get the title
Then the title should match the stored title above.


    
