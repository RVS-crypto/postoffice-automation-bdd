
@tag
Feature: Search for Item from Amazon portal
  
  @tag1
  Scenario:  Search for IPhone from Amazon portal
    Given User launches the Amazon Portal "https://www.amazon.com/"
    And User clicks on search tab and enters "IPhone"
    When clicks on Search Icon
    Then validate Iphone is displayed
    And closes the browser
    
     @tag1
  Scenario:  Search for IPhone from Amazon portal
    Given User launches the Amazon Portal "https://www.amazon.com/"
    And User clicks on search tab and enters "IPhone"
    When clicks on Search Icon
    Then validate Iphone is displayed
    And closes the browser
   
