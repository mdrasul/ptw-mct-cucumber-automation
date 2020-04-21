package mct.steps.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class SellerDashboardPage extends MasterPage {

	// XPATH 
	String allLeftMenu = "//div[@class='links_container']//a";
	
	
	/** Constructor */
	public SellerDashboardPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getAllLeftDashMenuOptions() {		
		return getElementsText(allLeftMenu);
	}
	
	public boolean checkALLSellerDashBoardLinks() {
		
		try {
			clickAllElements(allLeftMenu);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	
	
}
