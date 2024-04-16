package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateErrorMsgForContactSalesEditTest {
	WebConnector selenium = WebConnector.getInstance();
	
	 @When("^I navigate to the Contact screen$")
	    public void i_navigate_to_the_contact_screen() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.type("searchTextL", "Contact Name");
			selenium.pressEnter("searchTextL");
			selenium.waitingTime(4000);
			String Xpath=selenium.getDynamicXpath("anchorText", "Account Name", "endeditcontact");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
		
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.type("searchTextC", "Contact Name");
			selenium.pressEnter("searchTextC");
			selenium.waitingTime(2000);
			String Xpath=selenium.getDynamicXpath("anchorText", "Account Name", "endeditcontact");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			
		}
			selenium.test.log(LogStatus.INFO, "Contact screen loaded successfully!");
	
	}

	@And("^I edit Marketing Contact Type details$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the Contact tab");
//				selenium.waitingTime(2000);
//				selenium.clickLoop("editL");
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
			selenium.waitForElementToBeClickable("save");
				selenium.click("save");
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for Marketing Contact Type edit successfully$")
    public void validate_error_message_for_marketing_contact_type_edit_successfully() {
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
