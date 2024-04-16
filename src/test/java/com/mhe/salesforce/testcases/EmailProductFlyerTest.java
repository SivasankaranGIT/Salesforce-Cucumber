package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EmailProductFlyerTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("I search product through business unit$")
	public void search_product_through_business_unit() {
		try{
		selenium.test.log(LogStatus.INFO, "Selecting and expanding Business Unit");
		selenium.switchToMultipleFrame("productframeUat");
		selenium.click("businessUnitDropDwn");
		selenium.selectDropdownText("businessUnitDropDwn", "Business Unit");
		selenium.waitForElementToBeClickable("expandAllOption");
		selenium.click("expandAllOption");
		selenium.waitingTime(5000);
		selenium.clickDynamic("spantextContains", "Area", "endContains");
		//selenium.waitingTime(2000);
		//selenium.click("searchProductsBtn");
		selenium.waitingTime(4000);
		
	}
	
		 catch (Exception e) {
			 selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while searching product" + e.getMessage());
				}
	}

	
	@And("Email a product Flyer$")
	public void email_product_flyer() {
		try {
		
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("productsTable");
		selenium.scrollToElement("productsTable");
		selenium.waitForElementToBeClickable("goButton");
		selenium.click("goButton");
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		selenium.switchToLastWindow();
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("emailCatalogLink");
		selenium.click("emailCatalogLink");
		selenium.switchToLastWindow();
		selenium.waitingTime(2000);
		selenium.clearText("emailToField");
		selenium.type("emailToField", "Email To");
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("emailCCField");
		selenium.clearText("emailCCField");
		//selenium.type("emailToField", "Email To");
		selenium.clearText("emailFromField");
		selenium.type("emailFromField", "Email From");
		selenium.waitForElementToBeClickable("sendEmailBtn");
		selenium.click("sendEmailBtn");
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("successMsg")) {
			selenium.test.log(LogStatus.PASS, "Email sent successfully");
		}
		else {
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.FAIL, "Email couldn't be sent");
			selenium.reportFailure("Test Case Failed");
		}
		
		selenium.close();
		selenium.switchToLastWindow();
		selenium.close();
		selenium.switchBackToParentWindow();
		selenium.switchOutOfFrame();
		
	
	}
	 catch (Exception e) {
		 selenium.close();
			selenium.switchToLastWindow();
			selenium.close();
			selenium.switchBackToParentWindow();
			selenium.reportFailure("Error while emailing" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}

}
