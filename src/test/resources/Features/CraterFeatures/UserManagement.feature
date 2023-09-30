@smoke @regression
Feature: Log In
As a Crater user,
I want to be able to log in,
so that I can manage various business transactions.

Background:
Given user is on the login page

Scenario: Successful login
When user enters valid username "entityadmin@primetechschool.com" and password "primetech@school"
And click login button
Then user should be on the dashboard page

Scenario Outline: Unsuccessful login
When user enters invalid username "<USERNAME>" and password "<PASSWORD>"
And click login button
Then an error message should appear
And user stays on the login page
 
Examples:

|        USERNAME                |     PASSWORD     |
|       ghd@yahoo.com            |    asdfsdfsg     |
|entityadmin@primetechschool.com |     sfdsgdh      |
|       ghd@yahoo.com            | primetech@school |
|                                | primetech@school |
|entityadmin@primetechschool.com |                  |

