@featureTest
Feature: Google Search Feature
  I want to use this template for my feature file

  @test @googleSearch
  Scenario: Search for Jordan 4
    Given Launch "https://www.google.com"
    Then search with "Jordan 4"