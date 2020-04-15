package mct.steps.pageobjectmodel;

import org.openqa.selenium.WebDriver;

public class HomePage extends MasterPage {

	
	/** Locators */

	// SCR WE can Channge the Xpath If Needed 
	String loginLink = "//span[contains(text(),'Login')]";
	String userIDField = "//input[@id='username']";
	String passwordField = "//input[@id='password']";
	String loginButton = "//button[@id='jqLogin']";
	String profileNamePlace = "//*[@id='dLabel']/span";
	String signUpButton = "//button[@id='jqSignup']";
	String accountLink = "//div[@class='login_sec2']//div[1]//a[1]";

	
	
	/** Constructor */
	public HomePage(WebDriver driver) {
		super(driver);
	}


	/** All Page Specific Functions */
	// ===>> SCR Rule we can't Change ANy Page Actions <<===== 
	public void doLogin() {
		clickWebElement(loginLink);
		typeOnWebElement(userIDField, "user");
		typeOnWebElement(passwordField, "pass");
		clickWebElement(loginButton);
		uglyWaitFor(2000);
	}

	public String getProfileName() {
		return getWebElementText(profileNamePlace);
	}

	public void navigateToRegistrationPage() {
		clickWebElement(loginLink);
		clickWebElement(signUpButton);
		uglyWaitFor(1000);
	}
	
	public void navigateToAccountPage() {
		clickWebElement(profileNamePlace);
		clickWebElement(accountLink);
		uglyWaitFor(1000);
	}
	
	
}
