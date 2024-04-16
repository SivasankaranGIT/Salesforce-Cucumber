package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SamplesFromSampleTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@When("^I go to samples creation screen$")
	public void i_go_to_pipeline_creation_screen() {
		try {
		if(selenium.getUI().equalsIgnoreCase("classic")){
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("allButtonClassic");
			selenium.jsClick("allButtonClassic");
			selenium.waitForElementToBeClickable("Samples");
			selenium.click("Samples");

		}
		else if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("allButtonLightning");
			selenium.click("allButtonLightning");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("AllButtonL");
			selenium.click("AllButtonL");
			selenium.waitingTime(2000);
			selenium.type("searchallitems", "Samples");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("samplesLnew");
			selenium.click("samplesLnew");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
					
	}

	@When("^I enter all the required details on sample tab$")
	public void i_enter_all_the_required_details_on_sample_tab() {
		try {
		if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeClickable("newButton_C");
			selenium.click("newButton_C");
			selenium.selectFromLookUp("Contact Name Lookup", "Contact Name");
			selenium.waitForElementsToBeVisible("Selectcontact");
			selenium.type("author", "Author Name");
			selenium.type("Title", "Title Name");
			selenium.type("Edition", "Edition");
			selenium.type("copyright", "Copyright");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitForElementToBeVisible("products");
			selenium.selectResult("opportunityclone","Total Products", "end");
			selenium.waitForElementToBeClickable("Addtosampleandcontinue");
			selenium.click("Addtosampleandcontinue");
			selenium.waitForElementToBeClickable("samplereview");
			selenium.click("createsampleorder");
			if(selenium.isElementPresentFast("Duplicate"))
			{
				selenium.waitForElementToBeClickable("yestoall");
				selenium.click("yestoall");
			}
		
		}
		else if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("new");
			selenium.clickLoop("new");
			selenium.switchToFrame("newAccountFrame");
			selenium.selectFromLookUp("Contact Name Lookup", "Contact Name");
			selenium.waitForElementsToBeVisible("Selectcontact");
			selenium.switchToFrame("newAccountFrame");
			selenium.type("author", "Author Name");
			selenium.type("Title", "Title Name");
			selenium.type("Edition", "Edition");
			selenium.type("copyright", "Copyright");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitForElementToBeVisible("products");
			selenium.selectResult("opportunityclone","Total Products", "end");
			selenium.waitForElementToBeClickable("Addtosampleandcontinue");
			selenium.click("Addtosampleandcontinue");
			selenium.defaultframe();
			selenium.waitingTime(3000);
//			selenium.switchToFrame("iFrame"); //index
			selenium.waitForElementToBeClickable("createsampleorder");
			selenium.click("createsampleorder");
			if(selenium.isElementPresentFast("Duplicate"))
			{
				selenium.waitForElementToBeClickable("yestoall");
				selenium.click("yestoall");
			}
			}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
			
		}
	
	@Then("^Sample creation should be successful$")
	public void Sample_creation_should_should_be_successful() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(2000);
			selenium.printLastTestResult(selenium.isElementPresentFast("new"));
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(selenium.isElementPresentFast("recentsample"));
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
		
	   
}
