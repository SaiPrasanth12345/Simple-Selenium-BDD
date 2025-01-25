@featureTest
Feature: Flights Feature
  I want to use this template for my feature file

  @test @flights
  Scenario: Auomate the MakeMyTrip Website
    Given Launch MakeMyTrip Website
    When Select One way Flight
    And Select the from Destination as "Chennai" from "MAA" Airport
    And Select the To Destination as "Mumbai" from "BOM" Airport
    And Select today as Travel date
    And Search for flights
