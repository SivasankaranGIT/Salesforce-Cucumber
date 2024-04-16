package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocumentInactivecheck {
	WebConnector selenium = WebConnector.getInstance();
	
	@When("^I go to product catalog screen$")
	public void i_go_to_product_catalog_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("allButtonLightning");
			selenium.click("allButtonLightning");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("productcatalog1");
			selenium.scrollToElement("productcatalog1");
			selenium.click("productcatalog1");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "product catalog screen loaded successfully!");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@When("^I fill require details$")
	public void i_fill_require_details() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(4000);
			selenium.switchToFrame("newAccountFrame");
			selenium.click("Isbn131");
			selenium.type("Isbn131", "Isbn");
			//selenium.enterData("Isbn131", "Isbn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Allregion");
			selenium.click("Allregion");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(8000);
			selenium.clickDynamic("alltext", "Product", "end");
			selenium.test.log(LogStatus.INFO,"all region loaded successfully!");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	
	
	
	
	@Then("^the product should be displayed$")
	public void the_product_should_be_displayed() {
		try {
		selenium.waitingTime(2000);
		boolean isSuccess=false;
		String product = null;
		String expected_product=null;
		if (selenium.getUI().contains("Lightning")) {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("productcatalog");
			product = selenium.getText("productcatalog");
			expected_product = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("productname");
					
		if(product.contains(expected_product)) {
						isSuccess = true;
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");	
			}
				 
			selenium.printLastTestResult(isSuccess);
				
	}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	
	}
	
	@Then("^navigate to mhe document$")
	public void navigate_to_mhe_document() {
		try {
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.type("searchTextL", "productname");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("searchTextL");
			selenium.pressEnter("searchTextL");
			selenium.waitingTime(2000);
			String Xpath=selenium.getDynamicXpath("anchorTitlecontains", "Document", "endContains");
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editL");
			selenium.clickLoop("editL");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Inactivedoccheckbox");
			selenium.clickLoop("Inactivedoccheckbox");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	
	}
	
	@Then("^the product should not be displayed$")
	public void the_product_should_not_be_displayed() {
		try {
		selenium.waitingTime(2000);
		boolean isSuccess=false;
		String product = null;
		String expected_product=null;
		if (selenium.getUI().contains("Lightning")) {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("productnotavailable");
			product = selenium.getText("productnotavailable");
			expected_product = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Productmessage");
					
		if(product.contains(expected_product)) {
						isSuccess = true;
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");	
			}
				 
			selenium.printLastTestResult(isSuccess);
				
	}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	
}
}
