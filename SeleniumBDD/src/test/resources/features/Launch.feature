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
