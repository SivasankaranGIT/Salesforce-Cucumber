package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditSamplesTest {
	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to recent Samples$")
	public void i_navigate_to_recent_Samples() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitForElementToBeVisible("searchTextL");
			selenium.type("searchTextL", "Samplename");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchTextL");
			selenium.pressEnter("searchTextL");			
			selenium.test.log(LogStatus.INFO, "Samples screen loaded successfully!");
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeVisible("searchTextC");
			selenium.type("searchTextC", "Samplename");
			selenium.pressEnter("searchTextC");					
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^I edit the sfdc status$")
	public void i_edit_the_sfdc_status() {
		selenium.test.log(LogStatus.INFO, "Selecting the samples");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
		selenium.waitingTime(2000);
		
		String xpath=selenium.getDynamicXpath("anchorTitle", "Samplename", "end");
//		selenium.waitForXpathElementToBeClickable(xpath);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(xpath);
		selenium.waitingTime(2000);
		selenium.scrolldown(300);
		selenium.clickLoop("EditsfdcstatusL");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("SfdcStatusL");
		selenium.click("SfdcStatusL");
		selenium.waitingTime(2000);
		selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Sfdc Status", "end"));
//	    selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("save");
		selenium.clickLoop("save");
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.clickDynamic("anchorText", "Samplename", "end");
			selenium.waitForElementToBeClickable("edit");
			selenium.click("edit");
			selenium.selectDropdownText("sfdcstatus", "Sfdc Status");			
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}

	@Then("^the changed value should bee displayed$")
	public void the_changed_value_should_be_displayed() {
		try {
			selenium.waitingTime(2000);
			boolean isSuccess = false;
				if (selenium.getUI().equalsIgnoreCase("lightning")) {
					String xpath=selenium.getTextLoop("SfdcstatusverificationL");
					selenium.waitingTime(2000);
					String expected=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sfdc Status");
					if (xpath.contains(expected)) {
						isSuccess = true;
					}
					else {
						selenium.reportFailure("Test Case Failed");
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}
				} else {
					selenium.waitingTime(2000);
					String xpath = selenium.getDynamicXpath("divText", "Sfdc Status", "end");
					isSuccess = selenium.isElementPresentXpathFast(xpath);
				}
				selenium.printLastTestResult(isSuccess);
		
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
	}}
		

}
