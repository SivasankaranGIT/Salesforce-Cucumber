package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SamplesFromContactTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@When("^I go to samples creation screen from contacts$")
	public void i_go_to_samples_creation_screen_from_contact() {
		try {
		if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeVisible("searchTextC");
			selenium.type("searchTextC", "Contact");
			selenium.pressEnter("searchTextC");
			selenium.waitForElementToBeClickable("Contact");
			selenium.click("Contact");
			selenium.waitForElementToBeClickable("newSample");
			selenium.click("newSample");
		}
		else if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("searchTextL");
			selenium.type("searchTextL", "Contact");
			selenium.pressEnter("searchTextL");
			//selenium.clickDynamic("spanTitle", "Contact", "end");
			/*selenium.click("salesrepsearch");
			selenium.waitingTime(6000);
			selenium.scrollToElement("Accountsearch");*/
			selenium.waitingTime(6000);
			
			String Contactsearch=selenium.getDynamicXpath("Contactsearchsample", "Contact", "end");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Contactsearch);
			//selenium.clickDynamic("Contactsearchsample", "Contact", "end");
			//selenium.click("contactsearchlink");
			selenium.waitForElementToBeClickable("newSampleL");
			selenium.click("newSampleL");
		}
	}
	catch (Exception e)
	{
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
	}
				
	}

	@When("^I enter all the required details on sample screen$")
	public void i_enter_all_the_required_details_on_sample_screen() {
		try {
		if(selenium.getUI().equalsIgnoreCase("classic")){
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
				selenium.click("yestoall");
			}
		
		}
		else if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(4000);
			selenium.switchToFrame("sampleContact");
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
			selenium.switchToFrame("sampleContact");
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
	
	@Then("^Sample creatison should be successfull$")
	public void Sample_creation_should_should_be_successfull() {
		try {
		selenium.waitingTime(2000);
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(selenium.isElementPresentFast("new"));
			selenium.assertMessage("contactNameVerificationL", "Contact");
			
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(selenium.isElementPresentFast("recentsample"));
			selenium.assertMessage("contactName", "Contact");
			
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
		
	   
}
