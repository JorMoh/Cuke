Feature: Select Dropdown
As an Amazon user,
I want to have a dropdown list of different departments
so I can browse and choose departments

Background:
Given I'm on Amazon Website

Scenario: Verify list elements number
And I get all the options in the dropdown
And I print them out 
Then there should be a total of 56 departments

Scenario: Verify list elements
Then the default dropdown value should be “All Departments”
When I select department “Amazon Devices”
And I search for a "Night vision goggles" 
Then I should be on the "Night vision goggles" search page
And I should be in the “Amazon Devices” department

