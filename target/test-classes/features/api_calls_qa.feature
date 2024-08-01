
@apitag
Feature: Title of your feature
  I want to use this template for my feature file

  @apitag1
  Scenario: Test for Get Call
    Given User runs a get call on following api "https://reqres.in/api/users?page=2"
    Then User validates that clients requested resource is available for "https://reqres.in/api/users?page=2"
    Then User validates that clients post resource is available for "https://reqres.in/api/users?page=2"
    And User validates that put call is working fine for "https://reqres.in/api/users/2"
    And User validates that delete call is working fine for "https://reqres.in/api/users/2"
    
    
    
    
