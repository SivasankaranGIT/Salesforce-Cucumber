package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SamplesFromOpportunitiesTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@When("^I go to samples creation screen from Opportunities$")
	public void i_go_to_samples_creation_screen_from_opportunities() {
	try {	
		if(selenium.getUI().equalsIgnoreCase("classic")){
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Addproduct");
			selenium.scrollToElement("Addproduct");
			selenium.waitForElementToBeClickable("Addproduct");
			selenium.click("Addproduct");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ProductCourse");
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitForElementToBeVisible("productHeader");
			selenium.selectResult("opportunityclone","Total Products", "end");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("addContact");
			selenium.click("addContact");
			selenium.waitForElementToBeClickable("contactC");
			selenium.click("contactC");
//			selenium.waitingTime(2000);
			selenium.waitForElementsToBeVisible("contactTypeOpportunity");
			selenium.selectDropdownText("contactTypeOpportunity", "Contact Type");
			selenium.type("LastNameopportunity", "Last Name");
			selenium.waitForElementToBeClickable("Emailopportunity");
			selenium.click("Emailopportunity");
			selenium.type("Emailopportunity", "Email");
			selenium.selectFromLookUp("Department Name Lookup", "Department Name");
			selenium.isDuplicate();
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitForElementToBeClickable("newSample");
			selenium.click("newSample");
			
		}
		else if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(2000);
			selenium.jsClickXpath("//span[contains(@title,'Products')]");
			//selenium.hoverAndClick("NewProductOpportunity");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddproductL");
			selenium.clickLoop("AddproductL");
			selenium.waitingTime(2000);
			selenium.switchToFrame("productframeUat");
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitForElementToBeVisible("productHeader");
			selenium.selectResult("opportunityclone","Total Products", "end");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");
			selenium.waitingTime(2000);
			String Xpath=selenium.getDynamicRandomOpp("anchorTitle", selenium.opportunity, "end");
			//String xpath=selenium.getDynamicXpath("anchorTitle", "opportunity name", "end");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewContactOpportunityL");
			selenium.clickLoop("NewContactOpportunityL");
//			selenium.waitingTime(5000);
			//selenium.isCheck("Viewall");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("addContactL");
			selenium.clickLoop("addContactL");
			selenium.waitingTime(6000);
			selenium.switchToFrame("productframeUat");
			selenium.type("lastnamecontact", "Last Name");
			selenium.clickDynamic("Text_Span", "Last Name", "selectcontactdynamicL");
			selenium.click("Addtoopportunity");
			/*selenium.click("contactC");
			selenium.waitingTime(2000);
			selenium.waitForElementsToBeVisible("contactTypeOpportunity");
			selenium.selectDropdownText("contactTypeOpportunity", "Contact Type");
			selenium.type("LastNameopportunity", "Last Name");
			selenium.click("Emailopportunity");
			selenium.type("Emailopportunity", "Email");
			selenium.selectFromLookUp("Department Name Lookup", "Department Name");
			selenium.waitingTime(2000);
		    selenium.switchToFrame("newAccountFrame");
			selenium.isDuplicateOpportunity();
			selenium.click("Save_Btn");*/
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			String Xpath1=selenium.getDynamicRandomOpp("anchorTitlecontains", selenium.opportunity, "endContains");
			//String xpath1=selenium.getDynamicXpath("anchorTitlecontains", "opportunity name", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath1);
//			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("NewSampleopportunityL");
			selenium.click("NewSampleopportunityL");
		}
	}
		catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Error while editing the product in use");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	
	}

	@When("^I enter all the required details on sample creation screen$")
	public void i_enter_all_the_required_details_on_sample_creation_screen() {
		try {
		if(selenium.getUI().equalsIgnoreCase("classic")){
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("author");
			selenium.type("author", "Author Name");
			selenium.type("Title", "Title Name");
			selenium.type("Edition", "Edition");
			selenium.type("copyright", "Copyright");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.selectResult("opportunityclone","Total Products", "end");
			selenium.waitForElementToBeClickable("Addtosampleandcontinue");
			selenium.click("Addtosampleandcontinue");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("samplereview");
			selenium.click("createsampleorder");
			selenium.waitingTime(9000);
			if(selenium.isElementPresentFast("Duplicate"))
			{
				selenium.waitForElementToBeClickable("yestoall");
				selenium.click("yestoall");
				selenium.waitingTime(2000);
			}
		
		}
		else if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.switchToFrame("productframeUat");
			selenium.type("author", "Author Name");
			selenium.type("Title", "Title Name");
			selenium.type("Edition", "Edition");
			selenium.type("copyright", "Copyright");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("products");
			selenium.selectResult("opportunityclone","Total Products", "end");
			selenium.waitForElementToBeClickable("Addtosampleandcontinue");
			selenium.click("Addtosampleandcontinue");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("createsampleorder");
			selenium.click("createsampleorder");
			selenium.waitingTime(6000);
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
	
	@Then("^Sample creatison should be1 successfull$")
	public void Sample_creation_should_shoulda_be_successfull() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(4000);
			selenium.printLastTestResult(selenium.isElementPresentFast("new"));
			selenium.assertMessage("contactNameSampleL", "Last Name sample");
			
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitingTime(4000);
			selenium.printLastTestResult(selenium.isElementPresentFast("recentsample"));
			selenium.assertMessage("contactName", "Last Name");
			
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
		
	   
}
