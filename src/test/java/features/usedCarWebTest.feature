@WebTestFeature
Feature: TradeMe web test using Selenium Java

@WebTestScenario1  
  Scenario: As a Web UI test: Query any existing Used Car listing and confirm that the following details are shown for that car:
Number plate
Kilometres
Body
Seats

    Given I search for used cars on Trademe
    When I find a used car listed
    Then I verify that details for Number plate, Kilometres, Body and Seats is shown