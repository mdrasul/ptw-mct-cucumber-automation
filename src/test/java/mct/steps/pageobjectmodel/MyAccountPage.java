package mct.steps.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends MasterPage{

	/** Locators */

	// SCR WE can Channge the Xpath If Needed 
	String loginLink = "//span[contains(text(),'Login')]";
	String allOptionsATag = "//div[@class='myaccount_list']//div[@class='col-sm-12 col-lg-3 col-md-3']/a";
	String optionLinkName = "//div[@class='myaccount_list']//div[@class='col-sm-12 col-lg-3 col-md-3']/a[contains(text(),'${xx}')]";
	
	
	/** Constructor */
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public List<String> getAllAccountOptions() {
		return getElementsText(allOptionsATag);
	}

	public boolean checkALLOptionLinks() {
		
		try {
			clickAllElements(allOptionsATag);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void navigateToOption(String optionName) {
		
		List<String> allOption=getElementsText(allOptionsATag);
		
		for(int i=0;i<allOption.size();i++) {
			if(allOption.get(i).equals(optionName)) {
				clickWebElement(optionLinkName.replace("${xx}", optionName));
			}
		}
		
	}
	
	
}
