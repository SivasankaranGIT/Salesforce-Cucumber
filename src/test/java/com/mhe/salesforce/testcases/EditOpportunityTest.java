package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditOpportunityTest {
	WebConnector selenium = WebConnector.getInstance();

	@When("^I edit opportunity on opprtunity detail page$")
	public void i_edit_opportunity_on_Opportunity_detail_page() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("opportunityTermDropDwn");
			selenium.scrollToElement("opportunityTermDropDwn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunityTermDropDwn");
			selenium.click("opportunityTermDropDwn");
			selenium.waitingTime(2000);
			selenium.jsClickXpath(selenium.getDynamicXpath("newType", "Term", "end"));
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunityTypeDropDwn");
			selenium.click("opportunityTypeDropDwn");
			selenium.waitingTime(2000);
			selenium.jsClickXpath(selenium.getDynamicXpath("newType", "Opportunity type", "end"));
			
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeClickable("edit");
			selenium.click("edit");
			selenium.selectDropdownText("OpportunityType", "Opportunity type");
			
		}
		selenium.waitForElementToBeClickable("save");
			selenium.click("save");
			selenium.test.log(LogStatus.INFO, "opportunity Updated successfully!");
		}
		
		catch (Exception e) 
		{
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) 
			{
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}

			else 
			{
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}
	
	}
	
	


	@Then("^the opportunity should be successfully updated$")
	public void the_opportunity_should_be_successfully_updated() {
		try {
		selenium.waitingTime(2000);
				String Actual="";
				String expected=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity type");
				selenium.waitingTime(2000);
				if (selenium.getUI().equalsIgnoreCase("lightning")) {
					Actual=selenium.getTextLoop("OpportunityTypeVerificationL");
					
					if(Actual.contains(expected))
					{
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");
					}
					else {
						selenium.reportFailure("Test Case Failed");
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}
				}
				else if(selenium.getUI().equalsIgnoreCase("Classic")) {
					Actual=selenium.getText("OpportunityEditVerification");
					if(Actual.contains(expected))
					{
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");
					}
					else {
						selenium.reportFailure("Test Case Failed");
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
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
