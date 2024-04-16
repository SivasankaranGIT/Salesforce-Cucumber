package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuoteUsingMatchQuoteOption {
	WebConnector selenium = WebConnector.getInstance();
	
	@When("^I navigate to existing quote$")
    public void i_navigate_to_existing_quote() {
	        try {

	            selenium.waitingTime(3000);
	            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Quote Link");
	            selenium.navigateToURL(url);
	            selenium.waitingTime(10000);
	            selenium.captureScreenShot();
//	            selenium.waitingTime(2000);
	        }
	        catch (Exception e) {
	            selenium.reportFailure("Error while navigating to Quote " + e.getMessage());
	            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	        }
	    }
	 
	 @Then("^Revise Quote for one ISBN$")
	    public void revise_quote_for_one_isbn() {
	        try {
//	        	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Quote__c/a25DY000000L3BzYAK/view");
	        	selenium.waitingTime(4000);
	            selenium.waitForElementToBeClickable("globalSearch");
	            selenium.click("globalSearch");
	            selenium.waitingTime(2000);
	            selenium.waitForElementToBeClickable("globalsearchadvance");
				selenium.typeData("globalsearchadvance", selenium.newQuoteNum);
				selenium.waitingTime(3000);
				selenium.getElement("globalsearchadvance").sendKeys(Keys.ENTER);
				selenium.waitingTime(3000);
				String Xpath = selenium.getDynamicXpathData("quoteStartContains1", selenium.newQuoteUniqueName, "endContains");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentFast("QuotesTopResult"))
				{
					selenium.click("QuotesTopResult");
				}
				else
				{
					selenium.click("TopResultShowMoreLink");
					selenium.waitForElementToBeClickable("QuotesTopResult");
					selenium.click("QuotesTopResult");
				}
				System.out.println(Xpath);
				selenium.clickXpath(Xpath);
				selenium.waitingTime(10000);
				selenium.test.log(LogStatus.INFO, "Navigated to the desired quote");
	            selenium.captureScreenShot();
	             selenium.switchToMultipleFrame("newAccountFrame");
	             selenium.waitingTime(2000);
	             selenium.scrollToElement("reviseQuoteBtn");
	             selenium.waitForElementToBeClickable("reviseQuoteBtn");
	             selenium.click("reviseQuoteBtn");
	             selenium.waitingTime(6000);
	             selenium.defaultframe();
	            selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("nextButtonValue");
	            selenium.click("nextButtonValue");
	            selenium.switchOutOfFrame();
	            System.out.println("Waiting Waiting....");
	            selenium.waitingTime(150000);
	            selenium.waitForElementToBeClickableLongerDuration("EditOption");
	            selenium.captureScreenShot();
	            selenium.defaultframe();
	            selenium.switchToMultipleFrame("productframeUat");
	            System.out.println("1st frame");
	            selenium.switchToFrame("frame_quote");
	            System.out.println("2nd frame");
	            selenium.waitingTime(2000);
	            selenium.waitingTime(2000);
	            boolean value = selenium.isElementPresentFast("isbnRecordsOnQuote");
	            System.out.println("value is"+value);
	            
//	            if(value==false){
//	            	 System.out.println("ISBN record one");
//	            	selenium.test.log(LogStatus.PASS, "Only One ISBN record present");
//	            }
//	            else {
//	            	System.out.println("ISBN record more than one");
//	            	
//	            	selenium.test.log(LogStatus.FAIL, "Only One ISBN record should be present to continue");
//	            }
	            selenium.captureScreenShot();
	            selenium.waitingTime(2000);
	        }

	        catch (Exception e) {
	        	selenium.switchOutOfFrame();
	            selenium.reportFailure(e.getMessage());
	            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	        }
	    }
	 
	 @And("^Go through the approval process for Match Quote$")
	    public void go_through_the_approval_process_for_match_quote() {
	        try {

	            selenium.waitForElementToBeVisible("approve_quote");
	           selenium.scrollToElement("approve_quote");
	           selenium.waitForElementToBeClickable("approve_quote");
	            selenium.click("approve_quote");
//	            selenium.waitingTime(4000);
	            selenium.waitForElementToBeClickable("noApprovalRequired_quote");
	           // selenium.waitForElementToBeVisible("nextButton_quote");
	            selenium.click("noApprovalRequired_quote");
//	            selenium.waitingTime(3000);
//	            selenium.captureScreenShot();
	            selenium.waitForElementToBeClickable("nextButton_quote");
	            selenium.click("nextButton_quote");
	            selenium.waitingTime(4000);
	            selenium.captureScreenShot();
	            selenium.waitForElementToBeClickable("nextButton_quote");
	            selenium.click("nextButton_quote");
	            selenium.waitingTime(6000);
	            if(selenium.isElementPresentFast("nextButton_quote2"))
	            {
	            	selenium.click("LinkOppCheckBox");
	            	selenium.waitingTime(4000);
	            }
	            selenium.waitForElementToBeClickable("nextButton_quote");
	            selenium.click("nextButton_quote");

	            selenium.waitingTime(6000);
	            selenium.click("LinkToExistingOppRadioBtn");
	            selenium.waitingTime(2000);
//	            Select dropdown = new Select(selenium.getElement("opportunityDD"));
            	String OpportunityName = selenium.getTestDataFromPropertiesFile("USB065_ExpectedOpp");
//            	dropdown.selectByVisibleText(OpportunityName);
	            
	            selenium.click("opportunityDD");
	            selenium.waitingTime(2000);
	            selenium.clickDynamic("LinkOppStart",OpportunityName, "endContains");
	            selenium.waitingTime(2000);
	            
	            selenium.waitForElementToBeVisible("updateDropDown");
	            Select dropdown_update = new Select(selenium.getElement("updateDropDown"));
	            dropdown_update.selectByValue("Match Quote");
//	            selenium.waitingTime(2000);
	            selenium.waitForElementToBeClickable("next");
	            selenium.clickLoop("next");
	            selenium.waitingTime(10000);
	            selenium.captureScreenShot();
	            selenium.waitingTime(50000);

	        } catch (Exception e) {
	        	selenium.switchOutOfFrame();
	            selenium.reportFailure(e.getMessage());
	            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	        }
	    }

	 @Then("^Validate grand Total price for opportunity$")
	    public void grand_total_price_validate_for_opportunity() {
	        try {
	            selenium.scrollToElement("grandTotalprice");
	        	selenium.waitForElementToBeClickable("grandTotalprice");
	        	selenium.click("moreInfoOpenBtn");
//	            selenium.waitingTime(2000);
	            selenium.waitForElementToBeVisible("TotalSellingprice");
	            selenium.captureScreenShot();
	            selenium.waitingTime(2000);
	            String totalPrice = selenium.getText("TotalSellingprice");
	            selenium.click("moreInfoCloseBtn");
	           // selenium.test.log(LogStatus.INFO, "Grand Total Price is : "+totalPrice);
	            selenium.waitingTime(2000);
	            System.out.println("quote price"+ totalPrice);
	            String numberOnly= totalPrice.replaceAll("[^0-9]", "");
	            System.out.println("quote price after replace"+numberOnly);
	            selenium.captureScreenShot();
	            selenium.switchOutOfFrame();
	            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Link");
	            selenium.navigateToURL(url);
//	            selenium.waitingTime(5000);
	            selenium.waitForElementToBeVisible("opportunityDetailsTab");
	            selenium.scrollToElement("opportunityDetailsTab");
//	            selenium.waitingTime(2000);
	            selenium.waitForElementToBeVisible("opportunityAmount");
	            selenium.captureScreenShot();
	            selenium.waitingTime(2000);
	            String amount = selenium.getText("opportunityAmount");
	            System.out.println("opp amount"+ amount);
	            String number= amount.replaceAll("[^0-9]", "");
	            System.out.println("opp price after replace"+number);
	            if(number.equals(numberOnly)) {
	            	System.out.println("inside pass");
	            	selenium.test.log(LogStatus.PASS, "Quote amount matched to opportunity");
	            	
	            }
	            else {
	            	System.out.println("inside fail");
	            	selenium.test.log(LogStatus.FAIL, "Quote amount not matched to opportunity");
	            	selenium.reportFailure("Quote amount not matched to opportunity");
	            }
	            selenium.captureScreenShot();
	            
	        }catch (Exception e){
	            selenium.reportFailure(e.getMessage());
	            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	        }
	    }
	    
	
}
