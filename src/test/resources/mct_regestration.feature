Feature: User Registration Mechanism
  In order to get all membership benefit from multicart ecommerce 
 	I want to registratr my self

	  Background: Langing on MCT Page
    Given I open browser chrome
    And I land on multicart landing page


  Scenario: Successfull registration
    And I navigate to Registration Page
    When I complete registration for MR FNAME
    Then I expect to seee profile Name MR FNAME