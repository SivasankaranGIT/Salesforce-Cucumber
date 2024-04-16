package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditProductsInUseTest {
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^I edit the product in use$")
	public void goToAddProduct() {
		try {
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				selenium.waitForElementsToBeVisible("productInUse");
				selenium.jsClickXpath("//span[contains(@title,'Product In Use')]");
				selenium.waitingTime(2000);
				//selenium.isCheck("Viewall");
				String xpath=selenium.getDynamicXpath("anyTitle", "Product", "productEditButton");
//				selenium.waitForXpathElementToBeClickable(xpath);
				selenium.waitingTime(4000);
				selenium.clickXpath(xpath);
				selenium.waitingTime(4000);
				selenium.jsClickXpath("//a[@title='Edit']");
				//selenium.clickLoop("editL");
//				selenium.waitingTime(2000);
				selenium.waitForElementsToBeVisible("productInUseTextBox");
				selenium.type("productInUseTextBox", "Edit Product");			
			} else if (selenium.getUI().equalsIgnoreCase("classic")) {
				selenium.scrollToElement("addProductInUseC");
				String xpath=selenium.getDynamicXpath("anchorText", "Product", "productEditButtonC");
//				selenium.waitForXpathElementToBeClickable(xpath);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(xpath);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("NameField");
				selenium.clearText("NameField");
				selenium.type("NameField", "Edit Product");
			}
			selenium.waitingTime(3000);
			while(selenium.isElementPresentFast("sveprductL")) {
			selenium.jsClick("sveprductL");
			selenium.waitingTime(3000);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Error while editing the product in use");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@Then("^the required details should get updated$")
	public void verifyEdit(){
		boolean isSuccess=false;
		selenium.waitingTime(2000);
		if(selenium.getUI().equalsIgnoreCase("Lightning")){
			String xpath=selenium.getDynamicXpath("anchorTitle", "Edit Product", "end");
			isSuccess=selenium.isElementPresentXpathFast(xpath);
		}
		else if(selenium.getUI().equalsIgnoreCase("Classic")){
			String xpath=selenium.getDynamicXpath("anchorText", "Edit Product", "end");
			isSuccess=selenium.isElementPresentXpathFast(xpath);
		}
		
		selenium.printLastTestResult(isSuccess);
	}
}
