Feature: Add product

Scenario: Login to the website
Given I have username infy.maheshb@gmail.com and password Mswinse1!
When I send post request
Then I get "Token" in response
And I get "User ID" in response