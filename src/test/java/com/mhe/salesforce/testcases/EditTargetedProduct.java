package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditTargetedProduct {
	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to Opportunity screen$")
	public void i_navigate_to_Opportunity_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			/*selenium.type("searchTextL", "opportunity name");
			selenium.waitingTime(2000);
			selenium.pressEnter("searchTextL");
			selenium.waitingTime(2000);*/
			selenium.searchForOpp();
			//String Xpath=selenium.getDynamicRandomOpp("anchorTitlecontains", selenium.opportunity, "endContains");
			String Xpath=selenium.getDynamicXpath("opportunityNameContains", "opportunity name", "opportunityNameEnds7");
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
		
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.type("searchTextC", "opportunity name");
			selenium.pressEnter("searchTextC");
			selenium.waitForElementToBeClickable("opportunityLink");
			selenium.click("opportunityLink");	
		}
			selenium.test.log(LogStatus.INFO, "Opportunity screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	
	}

	@And("^I edit the product on opportunity screen$")
	public void i_edit_the_product_on_opportunity_screen() {
		selenium.test.log(LogStatus.INFO, "edit product");
		try {
		
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitForElementToBeClickable("productsLink");
			selenium.click("productsLink");
			selenium.clickDynamic("anchorTitlecontains", "Product Name", "endContains");
			selenium.waitForElementToBeClickable("EditActionButton");
			selenium.jsClick("EditActionButton");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.clickDynamic("anchorText","Product Name", "producteditdynamic");
			selenium.selectDropdownText("Producttype", "Product Type");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");	
		}}
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

	@Then("^the product should be successfully updated$")
	public void the_product_should_be_successfully_added() {
		try {
				String Actual="";
				String expected=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Product Type");
				selenium.waitingTime(5000);
				if (selenium.getUI().equalsIgnoreCase("lightning")) {
					//String xpath=selenium.getDynamicXpath("ProductTypeverificationL", "Product Type", "endContains");
					String xpath=selenium.getDynamicXpath("productHeaderTypeText", "Product Type", "endContains");
					Actual=selenium.getDynamicText(xpath);
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
					String xpath=selenium.getDynamicXpath("anchorText", "Product Name", "productverification");
					Actual=selenium.getDynamicText(xpath);
					
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


	@Then("^verify the knowledge transfer field$")
	public void verify_the_knowledge_transfer_field() {
		try {
			if(selenium.isElementPresentFast("OpportunityClick01"))
			{
				selenium.jsClick("OpportunityClick01");
			}
			else
			{
				System.out.println("Opening all opportunity list view...");
				selenium.waitForElementToBeClickable("OpptyListViewNotchBtn");
				selenium.jsClick("OpptyListViewNotchBtn");
				selenium.waitForElementToBeClickable("SearchList");
				selenium.typeData("SearchList","All Opportunities");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("OpptyAllOpportunities");
				selenium.jsClick("OpptyAllOpportunities");
				System.out.println("Waiting long...");
				selenium.waitingTime(180000);
				selenium.waitForElementToBeClickable("OpportunityClick01");
				selenium.click("OpportunityClick01");
			}
			selenium.waitingTime(6000);
//			selenium.scrolldown(950);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrolldown(200);
			selenium.waitingTime(2000);
			selenium.scrollToElement("KnowledgeTrfName");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("KnowledgeTrfName");
			String name=selenium.getText("KnowledgeTrfName").toString();
			if(name.equalsIgnoreCase("Knowledge Transfer"))
			{
				System.out.println("Knowledge Transfer Field is Available in Comment Section");
				selenium.waitForElementToBeClickable("KnowledgeTrfEdit");
				selenium.hoverAndClick("KnowledgeTrfEdit");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("New_Save_Btn");
				selenium.jsClick("New_Save_Btn");
				selenium.waitingTime(10000);
				selenium.test.log(LogStatus.PASS, "Test Case Passed! Knowledge Transfer field is editable");
				System.out.println("PASS - Knowledge Transfer field is editable");
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Test Case Failed! Knowledge Transfer field is either not available or not editable");
				System.out.println("FAIL - Knowledge Transfer field is either not available or not editable");
			}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

}
