Feature: tradeMeCharities

Scenario: Check if a particular charity is listed in TradeMe

Given I want to find if St John is a charity on TradeMe 
When I request the information on All charities using "charitiesResource" in "JSON" format
Then I verify if "St John" is listed
