package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class Sample_VerifyDefaultShippinAddressWillBeBasedOnDepartmentAddress {
	
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^click on account link and verify shipping address$")
	public void click_on_account_link_and_verify_shipping_address()  {
		
		try{
			selenium.waitingTime(4000);
			String xpath=selenium.getDynamicXpath("anchorAccountOnContact","Account Name","endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(xpath);
//			selenium.waitingTime(2000);
//			selenium.captureScreenShot();
		
	}
	catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Error while clicking on Account link from contact tab");
		selenium.reportFailure("Error while clicking on Account link from contact tab " + e.getMessage());
	
	}
		
		
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("shippingOnAccount");
			String address = selenium.getElement("shippingOnAccount").getAttribute("aria-label");
			System.out.println("Actual address :" + address);
		 	String expected_address = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address");
		 	System.out.println("Exp. Address :" + expected_address);
		 	if(address.contains(expected_address)) {
		 		selenium.test.log(LogStatus.PASS, "Shipping address present on Axccount page and matches sample page");
		 		
			} else {
				selenium.test.log(LogStatus.FAIL, "Shipping address doesnot match");
				selenium.reportFailure("Shipping address doesnot match");
				}
//		 	selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.navigateBack();
			selenium.waitingTime(4000);
		
	}
	
}

