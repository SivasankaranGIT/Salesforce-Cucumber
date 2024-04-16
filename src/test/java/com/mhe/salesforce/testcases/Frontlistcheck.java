package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Frontlistcheck {
	WebConnector selenium = WebConnector.getInstance();


	@And("^I add product on targeted product screen frontlist$")
	public void i_add_product_on_targeted_product_screen_frontlist() {
		selenium.test.log(LogStatus.INFO, "adding product");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.switchToFrame("newAccountFrame");
			selenium.clearText("ProductCourse");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("Isbn13");
			selenium.type("Isbn13", "Isbn");
			//selenium.type("author", "Author Name");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");
			selenium.waitingTime(2000);
			//selenium.clickLoop("NewProductOpportunity");
	
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeVisible("ProductCourse");
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");			
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}

	@Then("^the frontlist checkbox should be checked$")
	public void the_frontlist_checkbox_should_be_checked() {
		try {
			selenium.waitingTime(2000);
			boolean isSuccess = false;
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(2000);		
			selenium.waitForElementToBeVisible("Frontlistcheck");
			String frontlist=selenium.getAttributeclass("Frontlistcheck");

			if (frontlist.contains("checked")) {
						isSuccess = true;	
			}
				} 
			if (selenium.getUI().equalsIgnoreCase("classic")) {
			String xpath=selenium.getDynamicXpath("anchorText", "Product Name", "end");
			selenium.waitingTime(2000);	
			if (selenium.isElementPresentXpathFast(xpath))
						isSuccess = true;	
					} 
			selenium.printLastTestResult(isSuccess);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
				
	}
	
}
