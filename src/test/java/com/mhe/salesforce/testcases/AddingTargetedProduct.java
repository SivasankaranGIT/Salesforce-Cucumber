package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddingTargetedProduct {
	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to targeted product screen$")
	public void i_navigate_to_targeted_product_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("productsLink");
			selenium.clickLoop("productsLink");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addProductBtn");
			selenium.click("addProductBtn");
			selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.type("searchTextC", "opportunity name");
			selenium.pressEnter("searchTextC");
			selenium.clickDynamic("anchorText", "opportunity name", "end");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Addproduct");
			selenium.click("Addproduct");
			
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while loading product page " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I add the product on targeted product screen$")
	public void i_add_the_product_on_targeted_product_screen() {
		selenium.test.log(LogStatus.INFO, "adding product");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("clearButton");
			selenium.click("clearButton");
			selenium.type("Isbn13", "ISBN");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("TdtextProuductcontains","Product Name", "productnamedynamic");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("productsLink");
			selenium.clickLoop("productsLink");
	
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
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
			selenium.reportFailure("Error while loading product page " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		
	}

	@Then("^the product should be successfully added$")
	public void the_product_should_be_successfully_added() {
		try {
			selenium.waitingTime(2000);
			boolean isSuccess = false;
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
			String xpath=selenium.getDynamicXpath("anchorTextcontains", "Product", "endContains");
			selenium.waitingTime(2000);		
			if (selenium.isElementPresentXpathFast(xpath))
						isSuccess = true;	
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
