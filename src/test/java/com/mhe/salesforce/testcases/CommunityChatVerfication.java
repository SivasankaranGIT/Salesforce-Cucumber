package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommunityChatVerfication {
	
	WebConnector selenium = WebConnector.getInstance();
	String chatTranscriptURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/LiveChatTranscript/5708b000002LPf0AAG/view";
	
	 @When("^I navigate to chat transcript tab$")
	    public void i_navigate_to_chat_transcript_tab() {
			 
			 try {

					selenium.waitingTime(5000);
					selenium.refresh();
					selenium.waitingTime(10000);
					if (selenium.isElementPresentFast("CXGApp"))
					{
						selenium.waitForElementToBeClickable("menuDots");
						selenium.click("menuDots");
//						selenium.waitingTime(3000);
						selenium.waitForElementToBeVisible("searchItemsTextField");
						selenium.getElement("searchItemsTextField").sendKeys("Sales");
//						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("Saleslightningapp");
						selenium.jsClick("Saleslightningapp");
						selenium.waitingTime(4000);
					}
					selenium.waitForElementToBeClickable("menuDots");
					selenium.click("menuDots");
//					selenium.waitingTime(3000);
					selenium.waitForElementToBeVisible("searchItemsTextField");
					selenium.type("searchItemsTextField", "Chat Transcript");
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("chattranscriptsOptionMenuDots");
					selenium.jsClick("chattranscriptsOptionMenuDots");
					selenium.waitingTime(3000);
			 }
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while navigating to Chat transcript tab " + e.getMessage());
				}

		 }
	 
	 @And("^open the chat transcript$")
	    public void open_the_chat_transcript() {
		 
		 try {
			 
			 selenium.search("Transcript Number");
				String Xpath = selenium.getDynamicXpath("anchorTitle", "Transcript Number", "end");
				selenium.waitingTime(2000);
				if(selenium.isElementPresentFast("OppsTopResult"))
				{
					selenium.click("OppsTopResult");
				}
				else
				{
					selenium.click("TopResultShowMoreLink");
					selenium.waitForElementToBeClickable("ChatTopResult");
					selenium.click("ChatTopResult");
				}
				System.out.println(Xpath);
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(8000);
				selenium.test.log(LogStatus.INFO, "Navigated to the chat transcript page");
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while opening chat record " + e.getMessage());
			}
	 }
	 
	 @Then("^click on case details for the chat$")
	    public void click_on_case_details_for_the_chat() {
			 
			 try {
				 selenium.navigateToURL(chatTranscriptURL);
				 selenium.waitingTime(6000);
				 selenium.refresh();
				 selenium.waitingTime(10000);
				 selenium.waitForElementToBeClickable("detailTab_files");
				 selenium.click("detailTab_files");
				selenium.waitForElementsToBeVisible("caseInsideChatTranscript");
				 boolean caseRecord = selenium.isElementPresentFast("caseInsideChatTranscript");
				 System.out.println("caseRecord present" + caseRecord);
				 if(caseRecord == true) {
					 selenium.test.log(LogStatus.INFO, "Clicking on case lookup field" );
				 }
				 selenium.waitForElementToBeClickable("caseInsideChatTranscript");
				 selenium.jsClick("caseInsideChatTranscript");
				 selenium.waitingTime(5000); 
				 selenium.captureScreenShot();
//					selenium.waitingTime(2000); 
			 }
			 
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while clicking case details " + e.getMessage());
				}
		 }
	 
	 @And("^verify Case details$")
	    public void verify_case_details() {
			 
			 try {
				 selenium.waitingTime(3000);
				 boolean owner = selenium.isElementPresentFast("CSOMCaseOwner");
				 boolean case_origin = selenium.isElementPresentFast("Case_Origin");
				 System.out.println("case owner --> " + owner);
				 System.out.println("case origin --> " + case_origin);
				 if(owner == true & (case_origin == true)) {
					 System.out.println("PASS");
					 selenium.test.log(LogStatus.PASS, "Case details verified successfully" );
				 }
				 else {
					 selenium.test.log(LogStatus.FAIL, "Case details not present" );
					 selenium.reportFailure("Case details not present");
				 }
					 
			 }
			 
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying case details " + e.getMessage());
				}
		 }
	 
	 @And("^verify default Case details$")
	    public void verify_default_case_details() {
			 
			 try {
				 
				 boolean owner = selenium.isElementPresentFast("CSOMCaseOwner");
				 boolean case_origin = selenium.isElementPresentFast("Case_Origin");
				 System.out.println("case owner --> " + owner);
				 System.out.println("case origin --> " + case_origin);
				 if(owner == true & (case_origin == true)) {
					 System.out.println("PASS");
					 selenium.test.log(LogStatus.PASS, "Case details verified successfully" );
				 }
				 else {
					 selenium.test.log(LogStatus.FAIL, "Case details not present" );
					 selenium.reportFailure("Case details not present");
				 }				 
			 }
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying default case details " + e.getMessage());
				}
		 }

}
