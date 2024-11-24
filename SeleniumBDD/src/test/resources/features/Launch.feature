@featureTest
Feature: Login Feature
  I want to use this template for my feature file

  @test1
  Scenario: Search for Jordan 4
    Given Launch "https://www.google.com"
    Then search with "Jordan 4"

  @test2
  Scenario Outline: Login case
    #Given Get selenium driver
    When Launch "http://testphp.vulnweb.com/login.php"
    And login with <username> and <password>
    Then validate Login Succesful

    Examples: 
      | username | password |
      | test     | test     |
      | test1    | test2    |

  @test3
  Scenario: Auomate the MakeMyTrip Website
    Given Launch MakeMyTrip Website
    When Select One way Flight
    And Select the from Destination as "Chennai" from "MAA" Airport
    And Select the To Destination as "Mumbai" from "BOM" Airport
