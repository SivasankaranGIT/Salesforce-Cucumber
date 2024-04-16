package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForContactMarketingTest {
	
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit Marketing Contact Type details for Marketing$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the Contact tab");
//				selenium.waitingTime(2000);
//				selenium.jsClick("editL");
//				selenium.waitingTime(2000);
//				selenium.click("MarketingContactType");
//				selenium.clickDynamic("anchorTitle", "Marketing Contact Type", "end");
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.test.log(LogStatus.INFO, "selecting the value for Marketing Contact Type!");
				selenium.scrollToElement("marketingContactTypeDropDwn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("marketingContactTypeDropDwn");
				selenium.click("marketingContactTypeDropDwn");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("newType", "Marketing Contact Type", "end"));
				
			}
			else if(selenium.getUI().equalsIgnoreCase("classic")){
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
				selenium.click("edit");
				selenium.selectDropdownText("MarketingContactType_C", "Marketing Contact Type");
				
	
			}
				selenium.click("save");
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for Marketing Contact edit successfully$")
    public void validate_error_message_for_marketing_contact_edit_successfully() {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("error_sales_L");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
		if(error.contains(expected_error)) {
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			
		}
		else {
			selenium.click("CancelEdit");
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			
		}
		}
			else if (selenium.getUI().equalsIgnoreCase("classic")) {
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
					selenium.waitingTime(2000);
			error = selenium.getText("errorSales");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message Classic: " + error);
		if(error.contains(expected_error))
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		else {
			selenium.reportFailure("Test Case Failed");
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	}


}
