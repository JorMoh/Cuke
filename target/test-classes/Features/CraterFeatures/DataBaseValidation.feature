@smoke @regression
Feature: Database Validation

Background:
Given I'm On the Crater App homepage
And I create an item
When I go to the database, and query from the Item created
Then the retreived data should match the information I have provided on UI

Scenario: UI to Database Validation
When I update the Item on the UI
Then if I come back to database the update should be in effect
When delete the Item on the UI
Then if I come back to database, the Item should no longer exist 

Scenario: Database to UI Validation
When I update the Item on the database
Then if I come back to UI the update should be in effect
When delete the Item on the database
Then if I come back to UI, the Item should no longer exist 









