
@Regression @Smoke
Feature: Amazon Search
As an Amazon user,
I want to search an item on the website,
so that I find what I am looking for and compare options.

Scenario Outline: Search multiple items

Given I am on Amazon Website homepage
And I enter a search item "<Item>" in the search box
And I click on the search button
Then I should see the searched item "<Item>" on the results page

Examples:
|   Item   |
|   Dior   |
|  Chanel  |
| Versace  |
| Polo Red |
|  Tommy   |




