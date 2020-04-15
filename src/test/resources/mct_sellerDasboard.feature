Feature: Mct Seller Dash Board Features Test

  Background: Langing on MCT Page
    Given I open browser chrome
    And I land on multicart landing page
    And I complete login with James valid credentails
    And I navigate to my account page

  @WIP
  Scenario: My Account options are available
  	When I navigate to sellerdashboard
    Then I see all my dashboard left options available
