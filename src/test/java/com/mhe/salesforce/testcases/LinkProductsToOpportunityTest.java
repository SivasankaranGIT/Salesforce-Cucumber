package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LinkProductsToOpportunityTest {

	WebConnector selenium = WebConnector.getInstance();
//	public String OppProductAdd="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001ENrZAAA1/view";

	@When("^I navigate to products screen and add a product$")
	public void I_navigate_product_screen_add_Product() {
		try {
		
		selenium.waitingTime(2000);		
		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitForElementToBeClickable("productsLinkOpportunity");
			selenium.click("productsLinkOpportunity");
		} else {
			selenium.waitForElementToBeClickable("productsLinkOpportunity");
			selenium.click("productsLinkOpportunity");
		}
		selenium.waitingTime(10000);
		selenium.waitForElementToBeClickable("productAddOrEdit1");
		selenium.click("productAddOrEdit1");
		selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
		selenium.waitingTime(15000);
		
		selenium.switchToMultipleFrame("productframeUat");
		
		selenium.click("selectAllCheckbox");
		selenium.waitForElementToBeClickable("removeBtn");
		selenium.click("removeBtn");
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("searchBtn");
		//selenium.click("clearButton");
		//selenium.type("copyrightField", "Copyright");
		selenium.click("searchBtn");
		selenium.waitingTime(15000);
		//selenium.clickDynamic("divText","Author Name", "productCheckBoxDynamic");
		String checkBox = selenium.getDynamicXpath("divText", "Author Name", "productCheckBoxDynamic");
//		selenium.waitForXpathElementToBeClickable(checkBox);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(checkBox);
		selenium.waitForElementToBeClickable("Addtoopportunity");
		selenium.click("Addtoopportunity");
		selenium.waitingTime(5000);
		selenium.scrollToElement("Button_Save");
		selenium.click("selectAllCheckbox");
		selenium.waitForElementToBeClickable("Button_Save");
		selenium.click("Button_Save");
		selenium.waitingTime(20000);
		selenium.waitForElementToBeClickable("oppProductLink");
		selenium.clickLoop("oppProductLink");
	}
	catch (Exception e)
	{
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
	}
	}
	
}
