Feature: My Account


	  Background: Langing on MCT Page
    Given I open browser chrome
    And I land on multicart landing page
	  And I complete login with James valid credentails
	  And I navigate to my account page
	  
	

  Scenario: My Account options are available
    Then I see all my account options available
      | My Orders            |
      | Profile              |
      | My Return Requests   |
      | Change Password  |
      | My Favorite Products |
      | My Favorite Sellers  |
      | Seller Dashboard     |

  Scenario: Can be navigate to all options pages
  Then I expect all options links are working
   
  
      
      