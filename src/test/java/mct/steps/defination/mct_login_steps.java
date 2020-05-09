package mct.steps.defination;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mct.steps.pageobjectmodel.HomePage;
import mct.steps.pageobjectmodel.MyAccountPage;
import mct.steps.pageobjectmodel.MyOrders;
import mct.steps.pageobjectmodel.RegistrationPage;
import mct.steps.pageobjectmodel.SellerDashboardPage;
import mct.steps.support.TestHelper;

public class mct_login_steps {

	// Global Variable or Objects
	TestHelper helper;
	HomePage homePage;
	RegistrationPage regPage;
	WebDriver driver;
	MyAccountPage myaccountPage;
	SellerDashboardPage sellerDashboard;
	MyOrders myorders;
	
	String regUserData;
	
	

	// ====== HOOKS
	@After
	public void rampDown() {
		driver.close();
	}

	/** Common Steps For Our Gherkin **/

	@Given("^I open browser chrome$")
	public void i_open_browser_chrome() {
		System.out.println("######I open browser chrome#####");
		helper = new TestHelper();
		driver = helper.getDriver(); // Driver 001 [ Chrome ]
	}

	@Given("^I land on multicart landing page$")
	public void i_land_on_multicart_landing_page() {
		System.out.println("######I land on multicart landing page#####");
		helper.launchApplication(); // Driver 001 [ Chrome ] - go to MCT.com
	}

	/** Steps Code For Reggistrtion.feature FIle's GHERKIN **/

	@Given("^I navigate to Registration Page$")
	public void i_navigate_to_Registration_Page() throws Throwable {
		System.out.println("######I navigate to Registration Page#####");

		homePage = new HomePage(driver);
		homePage.navigateToRegistrationPage(); // Home Moves to RegPage
		regPage = new RegistrationPage(driver);
	}

	@When("^I complete registration for MR FNAME$")
	public void i_complete_registration_for_MR_FNAME() throws Throwable {
		
        Random rand = new Random(); 
        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(1000); 
        regUserData = "NAME" + rand_int1;
		regPage.completeRegistration(regUserData);
	}

	@Then("^I expect to seee profile Name MR FNAME$")
	public void i_expect_to_seee_profile_Name_MR_FNAME() {

		System.out.println("######I expect to seee profile Name as James Williams#####");
		String expProfileName = "MR "+regUserData;
		String actualProfileName = homePage.getProfileName();

		// J-unit Or TestNG Or
		Assert.assertEquals("Register User Is Not Creatd !!!!", expProfileName, actualProfileName);

	}

	/** Steps Code For Login.feature FIle's GHERKIN **/

	@When("^I complete login with James valid credentails$")
	public void i_complete_login_with_James_valid_credentails() {
		System.out.println("######I complete login with James valid credentail#####");
		homePage = new HomePage(driver);
		homePage.doLogin();
	}

	@Then("^I expect to seee profile Name as James Williams$")
	public void i_expect_to_seee_profile_Name_as_James_Williams() throws Throwable {

		System.out.println("######I expect to seee profile Name as James Williams#####");
		String expProfileName = "JAMES WILLIAMS";
		String actualProfileName = homePage.getProfileName();

		// J-unit Or TestNG Or
		Assert.assertEquals("Profile Miss Matched !!!!", expProfileName, actualProfileName);
	}

	
	@Then("^I navigate to my account page$")
	public void I_navigate_to_my_account_page() {
		// Home PAge Please Move to My Account Page 
		homePage.navigateToAccountPage();
		
		// == Pico COntainer 
		myaccountPage = new MyAccountPage(driver);
	}
	
	@Then("^I see all my account options available$")
	public void I_see_all_my_account_options_available(DataTable dataTable) {

		// Actual From the PAge 
		//myaccountPage = new MyAccountPage(driver);
		List<String> actualOptionsNames=myaccountPage.getAllAccountOptions();
		System.out.println(actualOptionsNames.toString());
		
		
		// Expectation that need to match with Test 
		//List<String> expectOptionsNames = new ArrayList<String>();
		List<String> expectedOptionsNames = dataTable.asList(String.class);

		Assert.assertEquals("List Not Matched !!",expectedOptionsNames,actualOptionsNames);

	}
	

	@Then("^I expect all options links are working$")
	public void I_expect_all_options_links_are_working() {
		
		Assert.assertEquals("All Links Not Good !!",true,myaccountPage.checkALLOptionLinks());

	}
	

	@When("^I navigate to sellerdashboard$")
	public void i_navigate_to_sellerdashboard(){		
		myaccountPage.navigateToOption("Seller Dashboard");
		
		// Wait 
		
		sellerDashboard = new SellerDashboardPage(driver);
	}

	
	@When("^I navigate to order page$")
	public void I_navigate_to_order_page(){		
		myaccountPage.navigateToOption("My Orders");
		
		// Wait 
		myorders=new MyOrders(driver);
		//sellerDashboard = new SellerDashboardPage(driver);
	}
	
	@Then("I see a table with all my orders")
	public void i_see_a_table_with_al_lmy_orderes() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new cucumber.api.PendingException();
		
		boolean isActualOrderTableisExist = myorders.isOrderTableExist();
		
		//Assert.assertEquals(isActualOrderTableisExist,true,"Failed To Find the Order History Table ");
		if(isActualOrderTableisExist==true) {
			System.out.println(" Find the Order History Table ");
		}
	}
	
	
	
	
//	@Then("I exepct count {int} in my order table")
//	public void i_exepct_count_in_my_order_table(int expCount) {
//	    // Write code here that turns the phrase above into concrete actions
//	    // throw new cucumber.api.PendingException();
//		
//		// =>> Get the total number of rows from a web table 
//		int actualCount =myorders.getTotalTableRowsCount()-1;
//		
//		
//		
//		if(actualCount==expCount) {
//			System.out.println("Failed To Find the Correct Number of!!!");
//			
//		};
//
//		
//	}


	
	
	
	@Then("^I see all my dashboard left options available$")
	public void i_see_all_my_dashboard_left_options_available(){

		List<String> actualLeftDashMenues=sellerDashboard.getAllLeftDashMenuOptions();
		System.out.println(actualLeftDashMenues.toString());
		
		
		// Expectation that need to match with Test 
		//List<String> expectOptionsNames = new ArrayList<String>();
		//List<String> expectedOptionsNames = dataTable.asList(String.class);

		//Assert.assertEquals("List Not Matched !!",expectedOptionsNames,actualOptionsNames);

	}
	
	@Then("^I expect all Seller Dash Board links are working$")
	public void I_expect_all_Seller_Dash_Board_links_are_working() {
		
		sellerDashboard.checkALLSellerDashBoardLinks();
		
		//Assert.assertEquals("All Links Not Good !!",true,sellerDashboard.checkALLSellerDashBoardLinks());
		sellerDashboard.uglyWaitFor(2000);

	}


	
	
	
	
}
