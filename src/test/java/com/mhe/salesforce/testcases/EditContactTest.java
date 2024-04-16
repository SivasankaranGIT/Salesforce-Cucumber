package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditContactTest {
	WebConnector selenium = WebConnector.getInstance();

	@When("^I edit contact$")
	public void i_edit_contact() {
		selenium.waitingTime(2000);
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(2000);
			//selenium.clickLoop("editL");
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
//			selenium.waitingTime(2000);
			//selenium.click("contactType");
			//selenium.clickDynamic("anchorTitle", "Contact Type", "end");
			selenium.waitForElementToBeClickable("contactTypeDropdown");
			selenium.click("contactTypeDropdown");
			selenium.clickDynamic("spanTitle", "Contact Type", "end");
			
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeClickable("edit");
			selenium.click("edit");
			selenium.selectDropdownText("contactTypeC", "Contact Type");
		}
		selenium.waitForElementToBeClickable("save");
			selenium.click("save");
			selenium.test.log(LogStatus.INFO, "Contact Updated successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	
	}


	@Then("^the contact should be successfully updated$")
	public void the_product_should_be_successfully_updated() {
		try {
				String Actual="";
				String expected=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact Type");
				selenium.waitingTime(5000);
				if (selenium.getUI().equalsIgnoreCase("lightning")) {
					Actual=selenium.getText("ContactTypeverificationL");
					
					if(Actual.contains(expected))
					{
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");
					}
					else {
						selenium.reportFailure("Test Case Failed");
					}
				}
				else if(selenium.getUI().equalsIgnoreCase("Classic")) {
					Actual=selenium.getText("ContactTypeverification");
					if(Actual.contains(expected))
					{
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");
					}
					else {
						selenium.reportFailure("Test Case Failed");
					}
				} 
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		}

}
