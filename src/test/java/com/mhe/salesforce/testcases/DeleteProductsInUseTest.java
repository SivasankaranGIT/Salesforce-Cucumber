package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeleteProductsInUseTest {
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^I delete the product in use$")
	public void goToAddProduct() {
		try {
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				selenium.waitForElementToBeClickable("productInUse");
				selenium.clickLoop("productInUse");
				selenium.waitingTime(4000);
				//selenium.isCheck("Viewall");
				String xpath=selenium.getDynamicXpath("anyTitle", "Product", "productEditButton");
//				selenium.waitForXpathElementToBeClickable(xpath);
				selenium.waitingTime(4000);
				selenium.clickXpath(xpath);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DeleteRecord");
				selenium.clickLoop("DeleteRecord");
				selenium.waitForElementToBeClickable("deleteBtn");
				selenium.click("deleteBtn");			
			} else if (selenium.getUI().equalsIgnoreCase("classic")) {
				selenium.scrollToElement("addProductInUseC");
				String Xpath=selenium.getDynamicXpath("anchorText", "Product", "productDelButtonC");
//				selenium.waitForXpathElementToBeClickable(Xpath);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);
				selenium.acceptAlert();
			}
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Error while deleting the product in use");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("^Product in use should be successfully deleted$")
	public void Product_in_use_should_be_successfully_deleted() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(selenium.isElementPresentFast("contactSuccessfulL"));
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			String xpath=selenium.getDynamicXpath("anchorText", "Product", "end");
			boolean success=selenium.isElementPresentXpathFast(xpath);
			selenium.printLastTestResult(!success);
		}
	}
	
}
