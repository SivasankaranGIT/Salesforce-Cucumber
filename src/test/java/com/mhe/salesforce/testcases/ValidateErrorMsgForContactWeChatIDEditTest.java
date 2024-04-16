package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForContactWeChatIDEditTest {
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit WeChat ID details$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the Contact tab");
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.test.log(LogStatus.INFO, "selecting the value for WeChat ID");
				selenium.scrollToElement("weChatId_L");
				selenium.type("weChatId_L", "WeChat ID");
				
			}
			else if(selenium.getUI().equalsIgnoreCase("classic")){
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("edit");
				selenium.jsClick("edit");
				selenium.scrollToElement("weChatId_C");
				selenium.type("weChatId_C", "WeChat ID");
				
			}
			selenium.waitForElementToBeClickable("save");
				selenium.click("save");
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for WeChat ID edit successfully$")
    public void validate_error_message_for_wechat_id_edit_successfully() {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("errorWeChatId_L");
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
			error = selenium.getText("errorText");
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
