Feature: Mct Order Features Test

  Background: Langing on MCT Page
    Given I open browser chrome
    And I land on multicart landing page
    And I complete login with James valid credentails
    And I navigate to my account page

  Scenario: User can verify corect no of iteams he placed
    When I navigate to order page
    Then I see a table with all my orders
    
