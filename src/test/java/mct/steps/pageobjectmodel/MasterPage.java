package mct.steps.pageobjectmodel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MasterPage {

	WebDriver driver;

	public MasterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickWebElement(String paramLocators) {
		driver.findElement(By.xpath(paramLocators)).click();
	}

	public String getWebElementText(String paramLocators) {
		return driver.findElement(By.xpath(paramLocators)).getText();
	}

	public void typeOnWebElement(String paramLocators, String paramValue) {
		driver.findElement(By.xpath(paramLocators)).sendKeys(paramValue);
	}

	// This Method Return List
	public List<String> getElementsText(String locators) {

		List<String> returnList = new ArrayList<String>();

		List<WebElement> allElements = driver.findElements(By.xpath(locators));

		for (int i = 0; i < allElements.size(); i++) {
			returnList.add(allElements.get(i).getText());
		}

		return returnList;
	}

	public void clickAllElements(String locators) {
		List<WebElement> allElements = driver.findElements(By.xpath(locators));
		for (int i = 0; i < allElements.size(); i++) {
			allElements.get(i).click();
			driver.navigate().back();
			
			allElements = driver.findElements(By.xpath(locators)); //Re Load the 
		}
	}
	
	
	public void uglyWaitFor(int mls) {
		try {
			Thread.sleep(mls);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
