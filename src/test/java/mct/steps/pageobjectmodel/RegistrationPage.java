package mct.steps.pageobjectmodel;

import org.openqa.selenium.WebDriver;

public class RegistrationPage extends MasterPage{


	String emailField = "//input[@id='txtEmail']";
	String regUserNameField = "//input[@id='txtUserName']";
	String regPasswordField = "//input[@id='txtPassword']";
	String regConfPasswordField = "//input[@id='txtCnfPassword']";
	String firstNameField = "//input[@id='txtFirstName']";
	String lastNameField = "//input[@id='txtLastName']";
	String addressField = "//input[@placeholder='Address *']";
	String createAcctButton = "//input[@id='btnRegister']";


	/** Locators */
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	public void completeRegistration(String userValue) {

		typeOnWebElement(emailField, userValue+"@gmail.com");
		typeOnWebElement(regUserNameField, userValue);
		typeOnWebElement(regPasswordField, "ABC123");
		typeOnWebElement(regConfPasswordField, "ABC123");		
		typeOnWebElement(firstNameField, "MR");
		typeOnWebElement(lastNameField, userValue);
		typeOnWebElement(addressField, "123 Fifth Ave");
		clickWebElement(createAcctButton);

	}

}
