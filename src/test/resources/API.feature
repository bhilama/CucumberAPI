Feature: Add product

Scenario Outline: Login to the website
Given I have username "<UserName>" and password "<Password>"
When I send post request
Then I get "Token" in response
And I get "User ID" in response

Examples:
|UserName								|Password		|
|infy.maheshb@gmail.com	|Mswinse1!	|
|infy.maheshb@gmail.com	|Mswinse1!	|