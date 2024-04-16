package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class QuoteModification {

    WebConnector selenium = WebConnector.getInstance();
   // String revision;
    String quoteNo;

    @And("^Edit Quote Using Do Not Link feature$")
    public void Edit_Quote_do_not_link_feature() {
        try {
            selenium.waitingTime(4000);
            System.out.println("selenium.newQuoteName is " + selenium.newQuoteName);
            System.out.println("selenium.newQuoteNumber is " + selenium.newQuoteNumber);
            selenium.waitForElementToBeClickable("globalSearch");
            selenium.click("globalSearch");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("globalsearchadvance");
            selenium.waitingTime(2000);
            if(selenium.newQuoteNumber == null)
	        {
	        	System.out.println("selenium.newQuoteNumber is.. " + selenium.newQuoteNumber);
	        	selenium.newQuoteNumber = selenium.newQuoteName;
	        }
			selenium.typeData("globalsearchadvance", selenium.newQuoteNumber);
			selenium.waitingTime(3000);
			selenium.getElement("globalsearchadvance").sendKeys(Keys.ENTER);
			selenium.waitingTime(3000);
			String Xpath = selenium.getDynamicXpathData("quoteStartContains1", selenium.newQuoteName, "endContains");
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
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired quote");			
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("newAccountFrame");
            selenium.switchToMultipleFrame("newAccountFrame");
            selenium.waitingTime(8000);
            if(selenium.isElementPresentFast("reviseQuoteBtn"))
            {
                selenium.waitForElementToBeVisible("reviseQuoteBtn");
                selenium.scrollToElement("reviseQuoteBtn");
                selenium.waitForElementToBeClickable("reviseQuoteBtn");
                selenium.click("reviseQuoteBtn");
            }
            else
            {
            	selenium.refresh();
                selenium.waitingTime(10000);
                selenium.switchToMultipleFrame("newAccountFrame");
                selenium.waitingTime(15000);
                selenium.waitForElementToBeVisible("reviseQuoteBtn");
                selenium.scrollToElement("reviseQuoteBtn");
                selenium.waitForElementToBeClickable("reviseQuoteBtn");
                selenium.click("reviseQuoteBtn");             	
            }
            selenium.waitingTime(6000);
            selenium.defaultframe();
            selenium.waitingTime(2000);
            selenium.switchToMultipleFrame("newAccountFrame");
            selenium.waitingTime(2000);
            selenium.click("nextButtonValue");
            selenium.waitingTime(2000);
            selenium.switchOutOfFrame();
            System.out.println("Waiting Waiting....");
            selenium.waitingTime(170000);
            selenium.captureScreenShot();
            selenium.defaultframe();
            selenium.switchToMultipleFrame("productframeUat");
            System.out.println("1st frame");
            selenium.switchToFrame("frame_quote");
            System.out.println("2nd frame");
            selenium.waitingTime(30000);
    		selenium.waitForElementToBeClickable("editQuoteLine1");
            selenium.click("editQuoteLine1");
            selenium.waitingTime(10000);
    		selenium.waitForElementToBeVisible("lineItemQuantity");
            selenium.clearText("lineItemQuantity");
            String quantity = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Quantity");
            selenium.typeData("lineItemQuantity",quantity);
    		selenium.waitForElementToBeClickable("saveQuoteLine");
            selenium.jsClick("saveQuoteLine");
            selenium.waitingTime(8000);
            selenium.test.log(LogStatus.PASS, "Edited Quantity");

        }

        catch (Exception e) {

            selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
            selenium.waitingTime(3000);
            System.out.println("Error catch");
            boolean error = selenium.isElementPresentFast("ErrorListAll");
            System.out.println(error);
            if (error == true) {
                System.out.println("Error came");

                selenium.jsClick("closePopUp");
                selenium.waitingTime(2000);
                selenium.click("ProductCloseButtonOpp");
            }

            else {

                selenium.click("ProductCloseButtonOpp");
                selenium.test.log(LogStatus.FAIL, "Edited from Opp");
                selenium.reportFailure("Edited from Opp");
            }
        }
    }

    @And("^Go through the approval process with Do not link Opportunity$")
    public void approval_process() {
        try {

            selenium.waitForElementToBeVisible("approve_quote");
            selenium.scrollToElement("approve_quote");
            selenium.waitForElementToBeClickable("approve_quote");
            selenium.click("approve_quote");
//            selenium.waitingTime(4000);
    		selenium.waitForElementToBeClickable("noApprovalRequired_quote");
            selenium.click("noApprovalRequired_quote");
//            selenium.waitingTime(3000);
//            selenium.captureScreenShot();
    		selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("LinkOpportunityCheckBox");
			selenium.click("LinkOpportunityCheckBox");
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
//            selenium.waitingTime(4000);
    		selenium.waitForElementToBeClickable("savedoNotLinkQuoteLine");
            selenium.click("doNotLink");
//            selenium.waitingTime(2000);
    		selenium.waitForElementToBeVisible("reasonText");
            selenium.typeData("reasonText","Test");
//            selenium.waitingTime(2000);
    		selenium.waitForElementToBeClickable("next");
            selenium.clickLoop("next");
            selenium.waitingTime(30000);

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^Validate opportunity linked$")
    public void validate_opportunity_linked() {
        try {

            if (selenium.isElementPresentFast("oppNotLinkedText")) {
                selenium.test.log(LogStatus.PASS, "Opportunity not Present");
                System.out.println("PASS");
            } else {
                selenium.test.log(LogStatus.FAIL, "Opportunity is Present");
                System.out.println("FAIL");
                selenium.reportFailure("Opportunity is Present");
                selenium.captureScreenShot();
            }
            selenium.scrollToElement("oppNotLinkedText");
            selenium.captureScreenShot();
        }catch (Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
        }

    @And("^Go through the approval process with Link to Existing$")
    public void approval_process_link_existing() {
        try {

            selenium.waitingTime(10000);
            selenium.waitForElementToBeVisible("approve_quote");
            selenium.scrollToElement("approve_quote");
    		selenium.waitForElementToBeClickable("approve_quote");
            selenium.click("approve_quote");
//            selenium.waitingTime(4000);
    		selenium.waitForElementToBeClickable("noApprovalRequired_quote");
            selenium.click("noApprovalRequired_quote");
//            selenium.waitingTime(3000);
//            selenium.captureScreenShot();
    		selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(4000);
    		selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(4000);
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
            String OpportunityName = selenium.getTestDataFromPropertiesFile("USB057_ExpectedOpp");            
            selenium.click("opportunityDD");
            selenium.waitingTime(2000);
            selenium.clickDynamic("LinkOppStart",OpportunityName, "endContains");
            selenium.waitingTime(2000);            
            
            Select dropdown = new Select(selenium.getElement("SubtypeDrpDwnInQuoteExistingOpp"));
	        dropdown.selectByValue("New Logo");
            selenium.waitingTime(2000);
            
            selenium.waitForElementToBeVisible("updateDropDown");
            Select dropdown_update = new Select(selenium.getElement("updateDropDown"));
            dropdown_update.selectByValue("Add New");
            selenium.waitForElementToBeClickable("next");
            selenium.clickLoop("next");
            selenium.captureScreenShot();
            selenium.waitingTime(60000);
            selenium.test.log(LogStatus.PASS, "Quote Linked To Existing Opp");
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^Validate item Quantity$")
    public void validate_item_Quantity() {
        try {

            String excel_qty = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Quantity");
            String quantityXpath = selenium.getPropertiesObj().getProperty("tableRowVal").
                    replace("$val", excel_qty);
            System.out.println("Result:" + excel_qty + quantityXpath);
            
            if (selenium.isElementPresentXpathFast(quantityXpath)){
                selenium.test.log(LogStatus.PASS, "Quantity matches");
                System.out.println("PASS");
            }else {
                selenium.test.log(LogStatus.FAIL, "Quantity does not matches");
                System.out.println("FAIL");
                selenium.reportFailure("Quantity does not matches");
                selenium.captureScreenShot();
            }

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }

    }


    @And("^Go through the approval process with SUM EXISTING$")
    public void approval_process_Sum_existing() {
        try {

            selenium.waitForElementToBeVisible("approve_quote");
            selenium.scrollToElement("approve_quote");
            selenium.waitForElementToBeClickable("approve_quote");
            selenium.click("approve_quote");
//            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("noApprovalRequired_quote");
            selenium.click("noApprovalRequired_quote");
//            selenium.waitingTime(3000);
//            selenium.captureScreenShot();
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
//            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
//            selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("LinkOpportunityCheckBox");
			selenium.click("LinkOpportunityCheckBox");
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
			selenium.waitForElementToBeClickable("LinkToExistingOppRadioBtn");
			selenium.click("LinkToExistingOppRadioBtn");
			String OppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
			Select dropdwn = new Select(selenium.getElement("opportunityDD"));
			dropdwn.selectByVisibleText(OppName);
			selenium.waitingTime(2000);
            selenium.waitForElementToBeVisible("updateDropDown");
            Select dropdown_update = new Select(selenium.getElement("updateDropDown"));
            dropdown_update.selectByValue("Append Existing");
//            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("next");
            selenium.clickLoop("next");
            selenium.captureScreenShot();
            selenium.waitingTime(60000);

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^navigate to opp and remove the \"([^\"]*)\"$")
    public void navigate_to_opp_and_remove_the_isbn(String ISBN) {
        try {
        	
            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Link");
            selenium.navigateToURL(url);
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("products_quote");
            selenium.clickLoop("products_quote");
            selenium.waitForElementToBeVisible("isbnProduct");
            String isbnXpath = selenium.getPropertiesObj().getProperty("isbnProduct").
                    replace("$val", ISBN);
            System.out.println("isbnXpath is: "+isbnXpath);
            if(selenium.isElementPresentXpathFast(isbnXpath)){
                System.out.println("The ISBN is already present, so I am deleting it..");
                selenium.click("ISBNPresent");	//if we updated ISBN in this test case then we need to update this xpath as well.
                selenium.waitingTime(1000);
                selenium.waitForElementToBeClickable("DeleteRecord");
                selenium.click("DeleteRecord");
                selenium.waitingTime(10000);
                selenium.refresh();
                selenium.waitingTime(10000);
                System.out.println("Deleted ISBN under test");
            }else {
            	 System.out.println("The ISBN under test is not present. so, don't need to do anything");
            }
        }
        catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^Revise Quote and add \"([^\"]*)\"$")
    public void revise_quote_isbn(String ISBN) {
        try {
//        	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Quote__c/a25DY000000L3BzYAK/view");
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
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired quote");
            selenium.captureScreenShot();
            selenium.switchToMultipleFrame("newAccountFrame");
            selenium.waitingTime(5000);
            selenium.scrollToElement("reviseQuoteBtn");
            quoteNo=selenium.getText("quoteNoGetText");
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("reviseQuoteBtn");
            selenium.click("reviseQuoteBtn");
            selenium.waitingTime(6000);
            selenium.defaultframe();
            selenium.switchToMultipleFrame("newAccountFrame");
            //revision = selenium.getTextLoop("quoteRevisionGetText");
            selenium.captureScreenShot();
            selenium.waitForElementToBeClickable("nextButtonValue");
            selenium.click("nextButtonValue");
            selenium.waitingTime(2000);
            selenium.switchOutOfFrame();
            System.out.println("Waiting Waiting....");
            selenium.waitingTime(180000);
//            selenium.waitingTime(20000);
//            if(selenium.isElementPresentFast("quoteFrameOpp"))
//            {
//	        	System.out.println("Invalid product warning message..");
//            	selenium.switchToMultipleFrame("quoteFrameOpp");
//	        	selenium.clickLoop("SelectAllCheckbox");
//	        	selenium.waitingTime(1000);
//	          	selenium.jsClick("AddProductProceedBtn");
//	          	selenium.waitingTime(2000);
//	          	selenium.switchOutOfFrame();
//            }
            selenium.waitForElementToBeClickableLongerDuration("EditOption");
            selenium.captureScreenShot();
            selenium.defaultframe();
            selenium.switchToMultipleFrame("productframeUat");
            System.out.println("1st frame");
            selenium.switchToFrame("frame_quote");
            System.out.println("2nd frame");
            selenium.captureScreenShot();
            selenium.waitingTime(2000);


//            //******************************************
//            if(!selenium.isElementPresentFast("isbnInput"))
//            {
//            	selenium.captureScreenShot();
//            	System.out.println("Re-trying...");
//            	selenium.refresh();
//            	selenium.waitingTime(8000);
//                selenium.switchOutOfFrame();
//                System.out.println("Waiting Waiting....");
//                selenium.waitingTime(10000);
//                selenium.waitForElementToBeClickableLongerDuration("EditOption");
//                selenium.captureScreenShot();
//                selenium.defaultframe();
//                selenium.switchToMultipleFrame("productframeUat");
//                System.out.println("1st frame");
//                selenium.switchToFrame("frame_quote");
//                System.out.println("2nd frame");
//                selenium.captureScreenShot();
//                selenium.waitingTime(2000);
//                selenium.waitingTime(5000);
//                //******************************************
//                selenium.waitForElementToBeVisible("isbnInput");
//                selenium.type("isbnInput","ISBN");
//                selenium.waitingTime(4000);
//                selenium.waitForElementToBeVisible("addIsbn");
//            }
            selenium.waitForElementToBeVisible("isbnInput");
            selenium.typeData("isbnInput",ISBN);
            selenium.waitingTime(4000);
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("addIsbn");
            selenium.click("addIsbn");
            selenium.waitingTime(4000);
            
            if(selenium.isElementPresentFast("QuoteProdRepCostAlertPopup"))
            {
            	System.out.println("Accepting Rep Cost 0 warning message");
            	selenium.click("CloseAlertMsgPopup");
            }
//            if(selenium.isElementPresentFast("subscriptionYes"))
//            {
//            	System.out.println("Inside Subscription Popup");
//            	selenium.waitingTime(2000);
//            	selenium.waitForElementToBeClickable("subscriptionYes");
//            	selenium.click("subscriptionYes");
//            }
            selenium.waitingTime(15000);
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
        }

        catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^Validate ISBN with updated Quantity in Opportunity Page$")
    public void grand_total_price_validate() {
        try {
        	selenium.waitForElementToBeVisible("grandTotalprice");
            selenium.scrollToElement("grandTotalprice");
            String totalPrice = selenium.getText("grandTotalprice");
            System.out.println("totalPrice is :" +totalPrice);
            selenium.test.log(LogStatus.PASS, "Grand Total Price is : "+totalPrice);
//            selenium.waitingTime(2000);
//            selenium.captureScreenShot();
            selenium.waitForElementToBeVisible("isbn_quote_new3");
            String oldISBN = selenium.getText("isbn_quote_new3");
            System.out.println("oldISBN is :" +oldISBN);
            selenium.switchOutOfFrame();
            //*********************************
            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Link");
            selenium.navigateToURL(url);
//            selenium.waitingTime(5000);
            //selenium.click("goToOpportunity");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("products_quote");
            selenium.clickLoop("products_quote");
//            selenium.waitingTime(4000);
            selenium.waitForElementToBeVisible("isbnProduct");
            String isbnXpath = selenium.getPropertiesObj().getProperty("isbnProduct").
                    replace("$val", oldISBN);
            System.out.println("isbnXpath is: "+isbnXpath);
            if(!selenium.isElementPresentXpathFast(isbnXpath)){
                selenium.test.log(LogStatus.PASS, "Original ISBN is NOT Present as Expected. Because for SumExisting type ISBN should not get linked to opp");
                System.out.println("PASS");
            }else {
                selenium.test.log(LogStatus.FAIL, "Original ISBN is Present");
                selenium.reportFailure("Original ISBN is Present");
                System.out.println("FAIL");
            }
            selenium.captureScreenShot();
        }catch (Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
	@And("^Go through the approval process with LINK ONLY$")
	public void approval_process_link_only() {
		try {

			selenium.waitForElementToBeVisible("approve_quote");
			selenium.scrollToElement("approve_quote");
			selenium.waitForElementToBeClickable("approve_quote");
			selenium.click("approve_quote");
//			selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("noApprovalRequired_quote");
			selenium.click("noApprovalRequired_quote");
//			selenium.waitingTime(3000);
//			selenium.captureScreenShot();
            selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
//			selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("LinkOpportunityCheckBox");
			selenium.click("LinkOpportunityCheckBox");
			selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
			selenium.waitForElementToBeClickable("LinkToExistingOppRadioBtn");
			selenium.click("LinkToExistingOppRadioBtn");
            selenium.waitForElementToBeVisible("opportunityDD");
			String OppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
			Select dropdown1 = new Select(selenium.getElement("opportunityDD"));
			dropdown1.selectByVisibleText(OppName);
//			selenium.waitingTime(2000);
            selenium.waitForElementToBeVisible("updateDropDown");
			Select dropdown_update = new Select(selenium.getElement("updateDropDown"));
			dropdown_update.selectByValue("Link for Informational Purposes");
//			selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("next");
			selenium.clickLoop("next");
			selenium.captureScreenShot();
			selenium.waitingTime(60000);

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^Validate quote link displayed$")
	public void quote_link_validate() {
		try {
			selenium.defaultframe();
            selenium.switchToMultipleFrame("productframeUat");
            selenium.clickLoop("goToOppLinkBtn");
            selenium.waitingTime(6000);
            selenium.defaultframe();
            
            if (selenium.isElementPresentFast("closeBtn")) {
            	selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("mheQuoteLink");
				selenium.click("mheQuoteLink");
			} else {
				selenium.waitForElementToBeClickable("mheQuoteLink");
				selenium.click("mheQuoteLink");
			}
//			selenium.waitingTime(8000);
            selenium.waitForElementToBeClickable("objectFilterBtn");
			
			selenium.jsClick("objectFilterBtn");
//			selenium.waitingTime(2000);
            selenium.waitForElementToBeVisible("quoteNoFilter");
			selenium.getElement("quoteNoFilter").sendKeys(quoteNo);
//			selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
//			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("closeFilterBtn");
			
			selenium.jsClick("closeFilterBtn");
			selenium.waitingTime(4000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Revised Quote is displayed successfully");
			
			
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


    @And("^I change the app launcher to Salesforce Chatter$")
    public void i_change_the_app_launcher_to_Salesforce_Chatter() {
        try {
            String appName = selenium.getText("appName");
            if(appName.equalsIgnoreCase("Salesforce Chatter")){
                System.out.println("App Launcher is Salesforce Chatter");
            }else{
//                selenium.waitingTime(5000);
                selenium.waitForElementToBeClickable("menuDots");
                selenium.click("menuDots");
                selenium.waitingTime(3000);
                selenium.waitForElementToBeVisible("searchItemsTextField");
                selenium.typeData("searchItemsTextField", "Salesforce Chatter");
//                selenium.waitingTime(2000);
                selenium.waitForElementToBeClickable("salesforceChatter");
                selenium.jsClick("salesforceChatter");
                selenium.waitingTime(5000);

            }

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^Validate both old and newly added ISBN in Opportunity Page$")
    public void validate_old_new_isbn() {
        try {
        	selenium.waitForElementToBeVisible("quoteDetailSection");
            selenium.scrollToElement("quoteDetailSection");
            String totalPrice = selenium.getText("grandTotalprice");
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
            selenium.test.log(LogStatus.PASS, "Grand Total Price is : "+totalPrice);
            selenium.waitingTime(2000);
            selenium.captureScreenShot();
            String oppName = selenium.getText("opportunityName_Quote");
            System.out.println("Opp Name:"+ oppName);
            String oldISBN = selenium.getText("isbn_quote_new4");
            System.out.println("Old ISBN:"+ oldISBN);
            String newISBN = selenium.getText("isbn_quote_new3");
            System.out.println("New ISBN:"+ newISBN);
            selenium.switchOutOfFrame();
            //************************************
//            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Link");
//            selenium.navigateToURL(url);
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("goToOpportunity");
            selenium.click("goToOpportunity");
            selenium.waitingTime(5000);
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("products_quote");
            selenium.clickLoop("products_quote");
//            selenium.waitingTime(4000);
            selenium.waitForElementToBeVisible("isbnProduct");
            String isbnXpath = selenium.getPropertiesObj().getProperty("isbnProduct").
                    replace("$val", oldISBN);
            String isbnXpath_new = selenium.getPropertiesObj().getProperty("isbnProduct").
                    replace("$val", newISBN);
            if(selenium.isElementPresentXpathFast(isbnXpath) && selenium.isElementPresentXpathFast(isbnXpath_new)){
                selenium.test.log(LogStatus.PASS, "Both ISBN is Present");
                System.out.println("PASS");
            }else {
                selenium.test.log(LogStatus.FAIL, "Both ISBN is not Present");
                System.out.println("FAIL");
                selenium.reportFailure("Both ISBN is not Present");
            }
            selenium.captureScreenShot();
        }catch (Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^Go through the approval process with Add Override$")
    public void approval_process_add_override() {
        try {
            selenium.waitForElementToBeVisible("approve_quote");
            selenium.scrollToElement("approve_quote");
            selenium.waitForElementToBeClickable("approve_quote");
            selenium.click("approve_quote");
//            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("isbnProduct");
            selenium.click("noApprovalRequired_quote");
//            selenium.waitingTime(3000);
//            selenium.captureScreenShot();
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
//            selenium.waitingTime(4000);
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
//            Select dropdown = new Select(selenium.getElement("opportunityDD"));
        	String OpportunityName = selenium.getTestDataFromPropertiesFile("USB065_ExpectedOpp");
//        	dropdown.selectByVisibleText(OpportunityName);
        	
            selenium.click("opportunityDD");
            selenium.waitingTime(2000);
            selenium.clickDynamic("LinkOppStart",OpportunityName, "endContains");
            selenium.waitingTime(2000);
        	
            selenium.waitForElementToBeVisible("updateDropDown");
            Select dropdown_update = new Select(selenium.getElement("updateDropDown"));
            dropdown_update.selectByValue("Update Values");

//            selenium.waitForElementToBeVisible("opportunityDD");
//			String OppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
//			Select dropdown2 = new Select(selenium.getElement("opportunityDD"));
//			dropdown2.selectByVisibleText(OppName);
//            selenium.waitingTime(2000);
//            Select dropdown_update = new Select(selenium.getElement("updateDropDown"));
//            dropdown_update.selectByValue("Update Values");
//            if(selenium.isElementPresentFast("opportunityReason"))
//            {
//                selenium.waitForElementToBeVisible("opportunityReason");
//                Select dropdown_reason = new Select(selenium.getElement("opportunityReason"));
//                dropdown_reason.selectByValue("a9R0y000000L0MYEA0");            	
//            }
            selenium.waitingTime(2000);
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
            selenium.scrolldown(200);
            selenium.waitForElementToBeClickable("next");
            selenium.clickLoop("next");
            selenium.captureScreenShot();
            selenium.waitingTime(60000);

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

	@Then("^Go through the approval process$")
	public void go_through_the_approval_process() {
		try {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("approve_quote");
			selenium.click("approve_quote");
			selenium.waitForElementToBeClickable("noApprovalRequired_quote");
			selenium.click("noApprovalRequired_quote");
			selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
			selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
			selenium.waitForElementToBeClickable("LinkOpportunityCheckBox");
			selenium.click("LinkOpportunityCheckBox");
			selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
			selenium.waitingTime(5000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyCatalogPriceInClonedQuoteWithoutDiscount_InternationalAccount") || selenium.getTestCaseName().equalsIgnoreCase("VerifyCatalogPriceInClonedQuoteWithoutDiscount_DomasticAccount"))
			{
	    		selenium.waitForElementToBeClickable("doNotLink");
	            selenium.click("doNotLink");
	    		selenium.waitForElementToBeVisible("reasonText");
	            selenium.typeData("reasonText","Test");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
			}
			else if(selenium.getTestCaseName().equalsIgnoreCase("CreateNewQuoteWithDifferentQuoteTypes"))
			{
				selenium.waitForElementToBeClickable("LinkToExistingOppRadioBtn");
				selenium.click("LinkToExistingOppRadioBtn");
				selenium.waitForElementToBeVisible("opportunityDD");
				String OppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
				Select dropdwn = new Select(selenium.getElement("opportunityDD"));
				dropdwn.selectByVisibleText(OppName);
//				dropdwn.selectByIndex(1);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("WonOppReasonForQuoteLinkage")) {
					selenium.click("CloseAlertMsgPopup");
					selenium.waitingTime(2000);
					Select opportunityReason = new Select(selenium.getElement("opportunityReason"));
					opportunityReason.selectByVisibleText("Due to Messaging/Presentation");			//Due to Messaging/Presentation
					Select PrimaryFundingType = new Select(selenium.getElement("PrimaryFundingType"));
					PrimaryFundingType.selectByValue("Title I");										//Title I
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("next");
					selenium.clickLoop("next");
				}
			}
			else
			{
				selenium.waitForElementToBeClickable("LinkToExistingOppRadioBtn");
				selenium.click("LinkToExistingOppRadioBtn");
				selenium.waitForElementToBeVisible("opportunityDD");
				String OppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
				Select dropdwn = new Select(selenium.getElement("opportunityDD"));
				dropdwn.selectByVisibleText(OppName);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
			}

			selenium.waitingTime(60000);
            if(selenium.getTestCaseName().equalsIgnoreCase("SEGSalesRepCreateNewQuote") || selenium.getTestCaseName().equalsIgnoreCase("CreateNewQuoteThroughAccounts"))
            {
				/*Getting newly created quote unique number*/
	            selenium.waitForElementToBeClickable("moreInfoOpenBtn");
	        	selenium.click("moreInfoOpenBtn");
	            selenium.waitForElementToBeVisible("QuoteNumber");
	            selenium.newQuoteNum = selenium.getText("QuoteNumber");
	            System.out.println("The new quote num is : " + selenium.newQuoteNum);
	            selenium.click("moreInfoCloseBtn");
	            selenium.waitingTime(2000);
            }
            
		} catch (Exception e)
		{
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^Go through the approval process with multiple approvers$")
	public void go_through_the_approval_process_with_multiple_approvers() {
		try {
			selenium.captureScreenShot();
			selenium.waitingTime(4000);
			if(!selenium.isElementPresentFast("approve_quote"))
			{
				selenium.refresh();
				selenium.waitingTime(10000);
	            selenium.defaultframe();
	            selenium.switchToFrame("newAccountFrame");
	            System.out.println("1st frame");
	            selenium.waitingTime(2000);
	            selenium.switchToFrame("frame_quote");
	            System.out.println("2nd frame");
			}
			selenium.waitForElementToBeClickable("approve_quote");
			selenium.click("approve_quote");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("QuoteApprovalRequiredRadioBtn");
			selenium.click("QuoteApprovalRequiredRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("QuoteRVPChkBox");
			selenium.click("QuoteRVPChkBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("QuoteFinanceChkBox");
			selenium.click("QuoteFinanceChkBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("nextButton_quote");
			selenium.click("nextButton_quote");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next");
			selenium.clickLoop("next");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next");
			selenium.clickLoop("next");
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("approve_quote"))
			{
				selenium.waitForElementToBeClickable("approve_quote");
				selenium.click("approve_quote");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("QuoteApprovalRequiredRadioBtn");
				selenium.click("QuoteApprovalRequiredRadioBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("QuoteRVPChkBox");
				selenium.click("QuoteRVPChkBox");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("QuoteFinanceChkBox");
				selenium.click("QuoteFinanceChkBox");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
				selenium.waitingTime(5000);
			}
            String quoteReviewText = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Review Comment");
            selenium.typeData("QuoteApprovalTextBox",quoteReviewText);
			selenium.waitForElementToBeClickable("next");
			selenium.clickLoop("next");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubmitForApprovalBtn");
			selenium.clickLoop("SubmitForApprovalBtn");
			selenium.captureScreenShot();
			selenium.waitingTime(10000);
		}
		catch (Exception e)
		{
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^validate the quote status$")
	public void validate_the_quote_status()
	{
		try
			{
				selenium.scrolldown(-200);
	            String status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Status");
	            String statusXpath = selenium.getPropertiesObj().getProperty("status_quote_val").
	                    replace("$val", status);
	            System.out.println(statusXpath);
	            selenium.waitingTime(5000);
	            if(selenium.isElementPresentXpathFast(statusXpath))
	            {
	                selenium.test.log(LogStatus.PASS, "Status Matches");
	                System.out.println("PASS");
	            }
	            else
	            {
	                selenium.test.log(LogStatus.FAIL, "Status not Matching");
	                selenium.reportFailure("Status not Matching");
	                System.out.println("FAIL");
	            }
			}

		catch (Exception e)
			{
				selenium.reportFailure(e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	}
	
	@And("^confirm new opp status is set as Renewal$")
	public void confirm_new_opp_status_is_set_as_Renewal()
	{
		try
			{
	            String status = "Renewal";
	            String newOppNameinQuote = selenium.getText("OppNameinQuoteProductScreen");
	            System.out.println("newOppNameinQuote" + newOppNameinQuote);
	            if(newOppNameinQuote.contains(status))
	            {
	                selenium.test.log(LogStatus.PASS, "Status Matches");
	                System.out.println("PASS");
	            }
	            else
	            {
	                selenium.test.log(LogStatus.FAIL, "Status not Matching");
	                selenium.reportFailure("Status not Matching");
	                System.out.println("FAIL");
	            }
			}

		catch (Exception e)
			{
				selenium.reportFailure(e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	}

	 @Then("^navigate to MHE Quotes tab$")
	 public void navigate_to_MHE_Quotes_tab()
	 {
			try
				{
					selenium.refresh();
					selenium.waitingTime(8000);
					selenium.waitForElementToBeClickable("menuDots");
					selenium.click("menuDots");
					selenium.waitingTime(3000);
					selenium.type("searchItemsTextField", "Search Text");
					selenium.waitForElementToBeClickable("MHEQuoteTabSearchInAppLauncher");
					selenium.jsClick("MHEQuoteTabSearchInAppLauncher");
					selenium.waitingTime(5000);
				}

			catch (Exception e)
				{
					selenium.reportFailure("Error while navigating to MHE Quotes tab" + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

	 }

	 @And("^validate the quote status in approval history section$")
	 public void validate_the_quote_status_in_approval_history_section()
	 {
			try
				{
					selenium.captureScreenShot();
					selenium.waitingTime(4000);
//					selenium.waitForElementToBeClickable("RecentlyAddedRecord");
//					selenium.click("RecentlyAddedRecord");
					String newlyCreatedQuoteLinkXpath = selenium.getDynamicXpathData("anchorTextcontains", selenium.newlyGeneratedQuoteName , "endContains");
					System.out.println(newlyCreatedQuoteLinkXpath);
					selenium.waitingTime(2000);
					selenium.clickXpath(newlyCreatedQuoteLinkXpath);
					selenium.waitingTime(15000);
					selenium.newQuoteURL = selenium.getURL();
					System.out.println("Newly created MHEQuote url is :" + selenium.newQuoteURL);
					selenium.waitingTime(2000);
					selenium.switchToFrame("newAccountFrame");
					selenium.waitForElementToBeClickable("approvaHistorySection");
					selenium.click("approvaHistorySection");
					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("MHEQuoteApprovalHistoryStatus"))
						{
							selenium.test.log(LogStatus.PASS, "Status Matches In Approval History");
							System.out.println("PASS");
						}
					else
						{
							selenium.test.log(LogStatus.FAIL, "Status Doesn't Match In Approval History");
							System.out.println("FAIL");
							selenium.reportFailure("Status Doesn't Match In Approval History");
							selenium.captureScreenShot();
						}
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }

	 @And("^reject the quote in approval history section$")
	 public void reject_the_quote_in_approval_history_section()
	 {
			try
				{
					selenium.waitForElementToBeClickable("MHEQuoteApproveOrRejectLink");
					selenium.click("MHEQuoteApproveOrRejectLink");
					selenium.waitingTime(8000);
					selenium.switchOutOfFrame();
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("MHEQuoteRejectBtn");
					selenium.click("MHEQuoteRejectBtn");
		            String quoteRejectComment = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Reject Comment");
		            selenium.typeData("SimpleTextBox",quoteRejectComment);
		            selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("MHEQuoteConfirmationPopupRejectBtn");
					selenium.click("MHEQuoteConfirmationPopupRejectBtn");
					selenium.test.log(LogStatus.PASS, "MHE Quote has been rejected successfully!");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }

	 @Then("^delete previously created opportunity$")
	 public void delete_previously_created_opportunity()
	 {
		 try
		 {
	        selenium.waitingTime(5000);
 			selenium.search("Opp. Search Data");
 			String Xpath = selenium.getDynamicXpath("opportunityStartContains1", "Opp. Search Data", "endContains");
 			selenium.waitingTime(2000);
 			if(selenium.isElementPresentFast("OppsTopResult"))
 			{
 				selenium.click("OppsTopResult");
 			}
 			else
 			{
 				selenium.click("TopResultShowMoreLink");
 				selenium.waitForElementToBeClickable("OppsTopResult");
 				selenium.click("OppsTopResult");
 			}
 			System.out.println(Xpath);
 			if(selenium.isElementPresentXpathFast(Xpath))
 			{
	 			 selenium.clickLoopXpath(Xpath);
	 			 selenium.waitingTime(8000);
	 			 selenium.test.log(LogStatus.INFO, "Navigated to the desired opportunity");
		 		 selenium.waitForElementToBeClickable("moreActionsBtn");
		 		 selenium.click("moreActionsBtn");
		 		 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("DeletePopup2");
				 selenium.clickLoop("DeletePopup2");
				 selenium.waitForElementToBeClickable("deletePopupBtn");
				 selenium.clickLoop("deletePopupBtn");
				 selenium.waitingTime(9000);
 			}
		 }
		catch (Exception e)
		{
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
}
	 @Then("^edit existing quote$")
	 public void edit_existing_quote()
	 {
			try
				{
					selenium.navigateToURL(selenium.newQuoteURL);
					System.out.println("Navigated to MHEQuote URL : " + selenium.newQuoteURL);
					selenium.waitingTime(15000);
					selenium.switchToFrame("newAccountFrame");
					selenium.waitForElementToBeClickable("edit");
					selenium.click("edit");
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }

	 @And("^link new opportunity with existing quote$")
	 public void link_new_opportunity_with_existing_quote(DataTable table)
	 {
		 List<String> data = table.transpose().asList(String.class);
			try
				{
		            System.out.println("waiting waiting....");
		            selenium.waitingTime(150000);
		            selenium.refresh();
		            selenium.waitingTime(10000);
		            selenium.defaultframe();
		            selenium.switchToFrame("newAccountFrame");
		            System.out.println("1st frame");
		            selenium.waitingTime(2000);
		            selenium.switchToFrame("frame_quote");
		            System.out.println("2nd frame");
		            selenium.waitForElementToBeClickable("MHEQuoteLinkOppBtnNew");
		            selenium.clickLoop("MHEQuoteLinkOppBtnNew");
					selenium.waitingTime(4000);					
		            
		            if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
		            {
		            	selenium.click("CloseAlertMsgPopup");
		            	selenium.waitingTime(2000);
		            	System.out.println("Adding valid ISBN");
		                selenium.waitForElementToBeVisible("isbnInput");
		                selenium.typeData("isbnInput",data.get(0));
		                selenium.waitingTime(4000);
		                selenium.waitForElementToBeClickable("addIsbn");
		                selenium.click("addIsbn");
		                selenium.waitingTime(10000);
		                selenium.refresh();
		                selenium.waitingTime(20000);
			            selenium.defaultframe();
			            selenium.switchToFrame("newAccountFrame");
			            System.out.println("1st frame");
			            selenium.waitingTime(2000);
			            selenium.switchToFrame("frame_quote");
			            System.out.println("2nd frame");
			            selenium.waitForElementToBeClickable("MHEQuoteLinkOppBtnNew");
			            selenium.clickLoop("MHEQuoteLinkOppBtnNew");
						selenium.waitingTime(4000);
		            }
		            
					selenium.waitForElementToBeClickable("MHEQuoteNewOppRatioBtn");
					selenium.click("MHEQuoteNewOppRatioBtn");
					
					if(selenium.getTestCaseName().equalsIgnoreCase("MHEQuoteValidateInvalidCloseAndPurchaseDate"))
					{
			            Select dropdown = new Select(selenium.getElement("MarketSubject"));
			            dropdown.selectByIndex(5);
					}
					else
					{
			            Select dropdown = new Select(selenium.getElement("MarketSubject"));
			            dropdown.selectByIndex(2);
					}
					if(selenium.getTestCaseName().equalsIgnoreCase("CreateOppThroughMHEQuote"))
					{
			            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendar");
			            selenium.click("NewOppCloseOrDecisionDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.click("NewOppCloseOrDecisionDateCalendar");
			            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendarDate");
			            selenium.click("NewOppCloseOrDecisionDateCalendarDate");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("NewOppPurchaseDateCalendar");
			            selenium.click("NewOppPurchaseDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.click("NewOppPurchaseDateCalendar");
			            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendarDate");
			            selenium.click("NewOppCloseOrDecisionDateCalendarDate");
					}
					if(selenium.getTestCaseName().equalsIgnoreCase("MHEQuoteValidateCloseAndPurchaseDate"))
					{
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendar");
			            selenium.click("NewOppCloseOrDecisionDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.click("NewOppCloseOrDecisionDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectMonthFilter");
			            selenium.click("SelectMonthFilter");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("ChooseMonth");
			            selenium.clickLoop("ChooseMonth");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectCloseOrDecisionDate");
			            selenium.click("SelectCloseOrDecisionDate");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("NewOppPurchaseDateCalendar");
			            selenium.click("NewOppPurchaseDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.click("NewOppPurchaseDateCalendar");
			            selenium.waitForElementToBeClickable("SelectMonthFilter");
			            selenium.click("SelectMonthFilter");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("ChooseMonth");
			            selenium.clickLoop("ChooseMonth");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectPurchaseDate");
			            selenium.click("SelectPurchaseDate");
			            selenium.waitingTime(2000);
					}
					if(selenium.getTestCaseName().equalsIgnoreCase("MHEQuoteValidateInvalidCloseAndPurchaseDate"))
					{
			            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendar");
			            selenium.click("NewOppCloseOrDecisionDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.click("NewOppCloseOrDecisionDateCalendar");
			            selenium.waitForElementToBeClickable("SelectMonthFilter");
			            selenium.waitingTime(2000);
			            selenium.click("SelectMonthFilter");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("ChooseMonth1");
			            selenium.click("ChooseMonth1");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectCloseOrDecisionDate1");
			            selenium.click("SelectCloseOrDecisionDate1");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("NewOppPurchaseDateCalendar");
			            selenium.click("NewOppPurchaseDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.click("NewOppPurchaseDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectMonthFilter");
			            selenium.click("SelectMonthFilter");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("ChooseMonth");
			            selenium.click("ChooseMonth");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectPurchaseDate");
			            selenium.click("SelectPurchaseDate");
			            selenium.waitingTime(2000);
					}
					
					 selenium.waitingTime(2000);
		            /*Select dropdown = new Select(selenium.getElement("SubtypeDrpDwnInQuoteNewOpp"));
			        dropdown.selectByValue("New Logo");
		            selenium.waitingTime(2000);
		            selenium.waitForElementToBeClickable("QuoteOppLinkPopupSaveBtn");
		            selenium.waitingTime(4000);*/
		            selenium.click("QuoteOppLinkPopupSaveBtn");
		            selenium.waitingTime(4000);
		            if(selenium.isElementPresentFast("OppAlreadyExistsPopup"))
		            {
		            	selenium.click("CloseAlertMsgPopup");
		            	selenium.waitForElementToBeClickable("QuoteOppLinkPopupCancelBtn");
		            	selenium.click("QuoteOppLinkPopupCancelBtn");
			            selenium.waitingTime(8000);
			            selenium.switchOutOfFrame();
			            selenium.refresh();
			            selenium.waitingTime(8000);
			            String OppName="MA-John Duggan Middle Schoo-ELEMENTARY: ASG - MATH-Open";
//						selenium.search("Opp. Search Data");
						selenium.search_data(OppName);
						String Xpath = selenium.getDynamicXpath_data("opportunityStartContains1", OppName, "endContains");
						selenium.waitingTime(2000);
						if(selenium.isElementPresentFast("OppsTopResult"))
						{
							selenium.click("OppsTopResult");
						}
						else
						{
							selenium.click("TopResultShowMoreLink");
							selenium.waitForElementToBeClickable("OppsTopResult");
							selenium.click("OppsTopResult");
						}
						System.out.println(Xpath);
						selenium.clickLoopXpath(Xpath);
						selenium.waitingTime(8000);
						selenium.test.log(LogStatus.INFO, "Navigated to the desired opportunity");
				 		 selenium.waitForElementToBeClickable("moreActionsBtn");
				 		 selenium.click("moreActionsBtn");
				 		 selenium.waitingTime(2000);
						 selenium.waitForElementToBeClickable("DeletePopup2");
						 selenium.jsClick("DeletePopup2");
						 selenium.waitForElementToBeClickable("deletePopupBtn");
						 selenium.clickLoop("deletePopupBtn");
						 selenium.waitingTime(9000);
		            }
		            selenium.captureScreenShot();
		            selenium.waitingTime(2000);
					if(selenium.getTestCaseName().equalsIgnoreCase("MHEQuoteValidateInvalidCloseAndPurchaseDate"))
					{
			            if(selenium.isElementPresentFast("PurchaseOrDecisionDateErrorPopup"))
				            {
								selenium.test.log(LogStatus.PASS, "Purchase/Decision Date verified successfully");
								System.out.println("Purchase/Decision Date verified successfull");
								selenium.click("CloseAlertMsgPopup");
							}
						else
							{
								selenium.test.log(LogStatus.FAIL, "Purchase/Decision Date details not proper");
								System.out.println("Purchase/Decision Date details not proper");
								selenium.captureScreenShot();
								selenium.reportFailure("Purchase/Decision Date details not proper");
							}
					}
					selenium.switchOutOfFrame();
		            selenium.waitingTime(2000);
		            selenium.waitForElementToBeClickable("MHEQuoteEditPageCloseBtn");
		            selenium.click("MHEQuoteEditPageCloseBtn");
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }

	 @Then("^validate new opportunity details$")
	 public void validate_new_opportunity_details()
	 {
			try
				{
					selenium.waitingTime(4000);
					selenium.refresh();
					selenium.waitingTime(8000);
		            selenium.switchToFrame("newAccountFrame");
					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("MHEQuoteShowDetailsArrow"))
					{
						selenium.click("MHEQuoteShowDetailsArrow");
					}

					selenium.waitingTime(2000);
					selenium.refresh();
					selenium.waitingTime(8000);
		            selenium.switchToFrame("newAccountFrame");
					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("MHEQuoteShowDetailsArrow"))
					{
						selenium.click("MHEQuoteShowDetailsArrow");
					}
		            if(selenium.isElementPresentFast("DefaultAdoptionLink"))
		            {
						selenium.waitForElementToBeClickable("DefaultAdoptionLink");
						selenium.click("DefaultAdoptionLink");
		            }
		            else
		            {
						selenium.refresh();
						selenium.waitingTime(10000);
			            selenium.switchToFrame("newAccountFrame");
						selenium.waitingTime(2000);
						if(selenium.isElementPresentFast("MHEQuoteShowDetailsArrow"))
						{
							selenium.click("MHEQuoteShowDetailsArrow");
						}
						selenium.waitForElementToBeClickable("DefaultAdoptionLink");
						selenium.click("DefaultAdoptionLink");
		            }
					selenium.waitingTime(2000);
					selenium.switchOutOfFrame();
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("closedateOpp2");
					String closedate = selenium.getText("closedateOpp2");
					String purchasedate = selenium.getText("purchaseDateopp3");
					System.out.println("closedate" + closedate + "purchasedate" + purchasedate);

						if(selenium.getTestCaseName().equalsIgnoreCase("CreateOppThroughMHEQuote"))
						{
								selenium.waitingTime(2000);
								selenium.captureScreenShot();
								selenium.waitingTime(2000);
								selenium.QuoteNewOppURL=selenium.getURL();
								System.out.println("DefaultAdoptionLink1 URL is :" + selenium.QuoteNewOppURL);

							    Calendar calendar1 = Calendar.getInstance();
								Date date = calendar1.getTime();
								SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
								String todaysDate = sdf1.format(date);
								calendar1.setTime(date);
								calendar1.add(Calendar.DATE, -1);
								Date dateBefore1Day = calendar1.getTime();
								SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
								String yesterdaysDate = sdf2.format(dateBefore1Day);
								System.out.println("todays date"+todaysDate);
								System.out.println("closedate date"+closedate);
								System.out.println("purchasedate date"+purchasedate);
								System.out.println("yesterday/today date" + yesterdaysDate);
							if( (closedate.contains(todaysDate) || closedate.contains(yesterdaysDate)) & ( (purchasedate.contains(todaysDate) || purchasedate.contains(yesterdaysDate))))
								{
									selenium.test.log(LogStatus.PASS, "Opportunity details Verified successfully");
									System.out.println("PASS");
									selenium.captureScreenShot();
								}
							else
								{
									selenium.test.log(LogStatus.FAIL, "Opportunity details not proper");
									selenium.captureScreenShot();
									selenium.reportFailure("Opportunity details not proper");
								}
							}

						if(selenium.getTestCaseName().equalsIgnoreCase("MHEQuoteValidateCloseAndPurchaseDate"))
						{
							selenium.waitingTime(2000);
							selenium.captureScreenShot();
							selenium.waitingTime(2000);
							selenium.QuoteNewOppURL1=selenium.getURL();
							System.out.println("DefaultAdoptionLink2 URL is :" + selenium.QuoteNewOppURL1);
							selenium.waitingTime(2000);
							String expected_closeDate = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Close Date");
							String expected_purchaseDate = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Purchase Date");
							System.out.println("expected_closeDate :" + expected_closeDate);
							System.out.println("expected_purchaseDate :" + expected_purchaseDate);
							selenium.waitingTime(2000);
								if((closedate.equals(expected_closeDate)) & (purchasedate.equals(expected_purchaseDate))) 
								{
									selenium.test.log(LogStatus.PASS, "Opportunity details Verified successfully");
									System.out.println("PASS");
									selenium.captureScreenShot();
								}
							else
								{
									selenium.test.log(LogStatus.FAIL, "Opportunity details not proper");
									selenium.captureScreenShot();
									selenium.reportFailure("Opportunity details not proper");
								}
						}

					selenium.captureScreenShot();
					selenium.waitingTime(2000);
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }

	 @And("^delete the newly created opportunity$")
	 public void delete_the_newly_created_opportunity()
	 {
			try
				{
					 if(selenium.getTestCaseName().equalsIgnoreCase("VerifyDiscountApprovalQuoteExportForRenewalQuoteType"))
					 {
						selenium.navigateToURL(selenium.new_QuoteOppURL);
						selenium.waitingTime(10000);
						if(selenium.isElementPresentFast("DeleteActionBtn"))
						{
							selenium.click("DeleteActionBtn");
							selenium.waitingTime(2000);
							selenium.waitForElementToBeClickable("deleteBtn");
							selenium.click("deleteBtn");
							selenium.waitingTime(18000);
						}
						else
						{
							selenium.waitForElementToBeClickable("moreActionsBtn");
							selenium.click("moreActionsBtn");
							selenium.waitForElementToBeClickable("OppDeleteActionListOption");
							selenium.click("OppDeleteActionListOption");
							selenium.waitForElementToBeClickable("DeleteOppConfirmationPopupOkBtn");
							selenium.clickLoop("DeleteOppConfirmationPopupOkBtn");
							selenium.waitingTime(18000);
						}
					 }
					 else
					 {
							if(selenium.isElementPresentFast("DeleteActionBtn"))
							{
								selenium.click("DeleteActionBtn");
								selenium.waitingTime(2000);
								selenium.waitForElementToBeClickable("deleteBtn");
								selenium.click("deleteBtn");
								selenium.waitingTime(18000);
							}
							else
							{
								selenium.waitForElementToBeClickable("moreActionsBtn");
								selenium.click("moreActionsBtn");
								selenium.waitForElementToBeClickable("OppDeleteActionListOption");
								selenium.click("OppDeleteActionListOption");
								selenium.waitForElementToBeClickable("DeleteOppConfirmationPopupOkBtn");
								selenium.clickLoop("DeleteOppConfirmationPopupOkBtn");
								selenium.waitingTime(18000);
							}
					 }
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }

	    @And("^Go through the quote approval process with Do not link Opportunity$")
	    public void quote_approval_process()
	    {
	        try {
	            System.out.println("waiting waiting....");
	            selenium.waitingTime(150000);
	            selenium.refresh();
	            selenium.waitingTime(10000);
	            selenium.defaultframe();
	            selenium.switchToFrame("newAccountFrame");
	            System.out.println("1st frame");
	            selenium.waitingTime(2000);
	            selenium.switchToFrame("frame_quote");
	            System.out.println("2nd frame");
	            selenium.waitForElementToBeVisible("approve_quote");
	            selenium.scrollToElement("approve_quote");
	            selenium.waitForElementToBeClickable("approve_quote");
	            selenium.click("approve_quote");
	            selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("noApprovalRequired_quote");
				selenium.click("noApprovalRequired_quote");
	            selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
	            selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
	            selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("LinkOpportunityCheckBox");
				selenium.click("LinkOpportunityCheckBox");
	            selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
	            selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("savedoNotLinkQuoteLine");
				selenium.click("doNotLink");
				selenium.waitForElementToBeVisible("reasonText");
				selenium.typeData("reasonText","Test");
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
				selenium.waitingTime(30000);
				selenium.captureScreenShot();
	        }
	        catch (Exception e)
	        {
	            selenium.reportFailure(e.getMessage());
	            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	        }
	    }

		 @Then("^navigate to MHE Quotes Admin tab$")
		 public void navigate_to_MHE_Quotes_Admin_tab()
		 {
				try
					{
						selenium.refresh();
						selenium.waitingTime(8000);
						selenium.waitForElementToBeClickable("menuDots");
						selenium.click("menuDots");
						selenium.waitingTime(3000);
						selenium.typeData("searchItemsTextField", "MHE Quotes Admin");
						selenium.waitForElementToBeClickable("MHEQuoteAdminTabSearchInAppLauncher");
						selenium.jsClick("MHEQuoteAdminTabSearchInAppLauncher");
						selenium.waitingTime(5000);
					}

				catch (Exception e)
					{
						selenium.reportFailure("Error while navigating to MHE Quotes Admin tab" + e.getMessage());
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}

		 }

		 @Then("^navigate to Web Service Tester tab$")
		 public void navigate_to_Web_Service_Tester_tab()
		 {
				try
					{
		            System.out.println("waiting waiting....");
		            selenium.waitingTime(180000);
		            selenium.refresh();
		            selenium.waitingTime(10000);
		            selenium.defaultframe();
		            selenium.switchToFrame("newAccountFrame");
		            System.out.println("1st frame");
		            selenium.waitingTime(2000);
		            selenium.switchToFrame("MHEQuoteAdminFrame");
		            System.out.println("2nd frame");
		            selenium.waitForElementToBeClickable("WebServiceTesterBtn");
		            selenium.click("WebServiceTesterBtn");
					selenium.waitingTime(5000);
					}

				catch (Exception e)
					{
						selenium.reportFailure("Error while navigating to web service tester tab" + e.getMessage());
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}

		 }
		 
			@And("validate MHEQuote SOA response")
			public void validate_MHEQuote_SOA_response()
			{
				try
				{
					System.out.println("Quote URL is : " + selenium.new_QuoteURL);
					String QuoteURL = selenium.new_QuoteURL;
					String QuoteId = QuoteURL.substring(69, 87);
					System.out.println("The Quote ID is : " + QuoteId);
					selenium.typeData("QuoteID", QuoteId);
					selenium.click("CustomerInfo");
					selenium.click("Tax");
					selenium.click("ShippingAndHandling");
					selenium.click("CustomerPriceing");
					selenium.waitingTime(2000);
					selenium.click("RunBtn");
					selenium.waitingTime(25000);
					selenium.waitForElementToBeVisible("WebServiceResult");
					if((selenium.isElementPresentFast("WebServiceResult")) && (!selenium.isElementPresentFast("MHEQuoteAdminWebServiceError")))
					{
						selenium.test.log(LogStatus.PASS, "Webservice returned quote results and it has no error");
		                selenium.captureScreenShot();
		                System.out.println("PASS");
					}
					else
					{
						selenium.click("RunBtn");
						selenium.waitingTime(25000);
						selenium.waitForElementToBeVisible("WebServiceResult");
						if((selenium.isElementPresentFast("WebServiceResult")) && (!selenium.isElementPresentFast("MHEQuoteAdminWebServiceError")))
						{
							selenium.test.log(LogStatus.PASS, "Webservice returned quote results and it has no error");
			                System.out.println("PASS");
						}
						else
						{
			                selenium.test.log(LogStatus.FAIL, "Either Webservice did not return quote results or it returned error");
			                selenium.reportFailure("Either Webservice did not return quote results or it returned error");
						}
					}
					selenium.waitingTime(2000);
				}
				catch (Exception e)
				{
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Test Case Failed " + e.getMessage());
				}
			}

		 @And("^validate MHEQuote Admin functionality$")
		 public void validate_MHEQuote_Admin_functionality()
		 {
				try
					{
						System.out.println("Quote URL is : " + selenium.newQuoteURL);
						String QuoteURL = selenium.newQuoteURL;
						String QuoteId = QuoteURL.substring(69, 87);
						System.out.println("The Quote ID is : " + QuoteId);
//						String QuoteId = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Quote ID");
						selenium.typeData("QuoteID", QuoteId);
						selenium.click("CustomerInfo");
						selenium.click("Tax");
						selenium.click("ShippingAndHandling");
						selenium.click("CustomerPriceing");
						selenium.waitingTime(2000);
						selenium.click("RunBtn");
						selenium.waitingTime(25000);
						selenium.waitForElementToBeVisible("WebServiceResult");
						if(selenium.isElementPresentFast("WebServiceResult"))
						{
							selenium.test.log(LogStatus.PASS, "Webservice returned quote results");
			                selenium.captureScreenShot();
			                System.out.println("PASS");
						}
						else
						{
							selenium.click("RunBtn");
							selenium.waitingTime(25000);
							selenium.waitForElementToBeVisible("WebServiceResult");
							if(selenium.isElementPresentFast("WebServiceResult"))
							{
								selenium.test.log(LogStatus.PASS, "Webservice returned quote results");
				                selenium.captureScreenShot();
				                System.out.println("PASS");
							}
							else
							{
				                selenium.test.log(LogStatus.FAIL, "Webservice did not return quote results");
				                selenium.captureScreenShot();
				                selenium.reportFailure("Webservice did not return quote results");
							}
						}
						selenium.waitingTime(2000);
					}

				catch (Exception e)
					{
						selenium.reportFailure("Error while validating MHE Quote" + e.getMessage());
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}

		 }

		 @Then("^navigate to Approved MHEQuote$")
		 public void navigate_to_Approved_MHEQuote()
		 {
				try
					{
			         String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Approved Quote URL");
			         selenium.navigateToURL(url);
			         selenium.waitingTime(10000);
			         selenium.captureScreenShot();
					}

				catch (Exception e)
					{
						selenium.reportFailure("Error while navigating to Approved MHE Quote" + e.getMessage());
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}

		 }

		 @And("^open linked opportunity and get the URL$")
		 public void open_linked_opportunity_and_get_the_URL()
		 {
				try
					{
//		        	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Quote__c/a25DY000000L3qkYAC/view?0.source=alohaHeader");
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
						selenium.waitingTime(10000);
						selenium.waitForElementToBeVisible("newAccountFrame");
			            selenium.switchToFrame("newAccountFrame");
						selenium.waitForElementToBeClickable("DefaultAdoptionLink");
						selenium.jsClick("DefaultAdoptionLink");
			            selenium.waitingTime(6000);
						selenium.oppURL = selenium.getURL();
						System.out.println(selenium.oppURL);
						selenium.navigateBack();
			            selenium.waitingTime(5000);
			            selenium.refresh();
			            selenium.waitingTime(5000);
					}

				catch (Exception e)
					{
						selenium.reportFailure("Error while navigating to Approved MHE Quote" + e.getMessage());
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}
		 }

		 @Then("^review or clone MHE Quote opportunity functionality$")
		 public void review_or_clone_MHEQuote_opportunity_functionality()
		 {
				try
					{
						selenium.switchToMultipleFrame("newAccountFrame");
						selenium.waitingTime(5000);
						if(selenium.getTestCaseName().equalsIgnoreCase("UpdateOppThroughMHEQuotesUsingReview"))
						{
							selenium.waitForElementToBeClickable("Review");
							selenium.click("Review");
						}
						if(selenium.getTestCaseName().equalsIgnoreCase("UpdateOppThroughMHEQuotesUsingClone"))
						{
							selenium.waitForElementToBeClickable("Clone");
							selenium.click("Clone");
							selenium.waitingTime(4000);
							selenium.refresh();
							selenium.waitingTime(5000);
							selenium.switchToMultipleFrame("newAccountFrame");
							selenium.waitingTime(4000);
							selenium.waitForElementToBeClickable("nextButtonValue");
							selenium.click("nextButtonValue");
							selenium.waitingTime(4000);
							selenium.refresh();
							selenium.waitingTime(5000);
							selenium.switchToMultipleFrame("newAccountFrame");
							selenium.waitForElementToBeClickable("nextButtonValue");
							selenium.click("nextButtonValue");
						}
			            System.out.println("waiting waiting....");
			            selenium.waitingTime(150000);
			            selenium.refresh();
			            selenium.waitingTime(25000);
			            selenium.defaultframe();
			            selenium.switchToFrame("newAccountFrame");
			            System.out.println("1st frame");
			            selenium.waitingTime(2000);
			            selenium.switchToFrame("frame_quote");
			            System.out.println("2nd frame");
			            selenium.waitingTime(15000);
//						if(selenium.getTestCaseName().equalsIgnoreCase("UpdateOppThroughMHEQuotesUsingClone"))
//						{
//							selenium.waitForElementToBeClickable("QuoteProductSelectAllChkBox");
//				        	selenium.click("QuoteProductSelectAllChkBox");
//				        	selenium.waitingTime(2000);
//				        	selenium.jsClick("quoteProceedBtn");
//				            selenium.waitingTime(25000);
//						}
			            if(selenium.isElementPresentFast("MHEQuoteLinkOppBtnNew"))
			            {
				            selenium.waitForElementToBeClickable("MHEQuoteLinkOppBtnNew");
				            selenium.clickLoop("MHEQuoteLinkOppBtnNew");
			            }
			            else
			            {
				            selenium.refresh();
				            selenium.waitingTime(25000);
				            selenium.defaultframe();
				            selenium.waitingTime(4000);
				            selenium.switchToFrame("newAccountFrame");
				            System.out.println("1st frame");
				            selenium.waitingTime(4000);
				            selenium.switchToFrame("frame_quote");
				            System.out.println("2nd frame");
				            selenium.waitingTime(8000);
				            selenium.waitForElementToBeClickable("MHEQuoteLinkOppBtnNew");
				            selenium.clickLoop("MHEQuoteLinkOppBtnNew");
			            }
						selenium.waitingTime(4000);
						selenium.captureScreenShot();
						selenium.waitingTime(4000);
						if(selenium.isElementPresentFast("LinkToExistingOppRadioBtn"))
						{
							selenium.waitForElementToBeClickable("LinkToExistingOppRadioBtn");
							selenium.click("LinkToExistingOppRadioBtn");							
						}
						else
						{
				            selenium.clickLoop("MHEQuoteLinkOppBtn");
							selenium.waitForElementToBeClickable("LinkToExistingOppRadioBtn");
							selenium.click("LinkToExistingOppRadioBtn");
						}
						selenium.waitForElementToBeVisible("opportunityDD");
						String OppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
						Select dropdown = new Select(selenium.getElement("opportunityDD"));
						dropdown.selectByVisibleText(OppName);
			            selenium.waitForElementToBeVisible("updateDropDown");
			            Select dropdown_update = new Select(selenium.getElement("updateDropDown"));
			            dropdown_update.selectByValue("Match Quote");
						selenium.waitForElementToBeClickable("QuoteOppLinkPopupSaveBtn");
						selenium.clickLoop("QuoteOppLinkPopupSaveBtn");
						selenium.waitingTime(8000);
						selenium.switchOutOfFrame();
			            selenium.waitingTime(2000);
			            selenium.captureScreenShot();
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("MHEQuoteEditPageCloseBtn");
			            selenium.click("MHEQuoteEditPageCloseBtn");
			            selenium.waitingTime(4000);
					}

				catch (Exception e)
					{
						selenium.reportFailure("Error while reviewing MHE Quote opportunity functionality" + e.getMessage());
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}
		 }

		    @And("^validate old and new opportunity amount value$")
		    public void validate_old_and_new_opportunity_amount_value()
		    {
		        try
		        {
		            selenium.waitingTime(6000);
					selenium.refresh();
					selenium.waitingTime(10000);
		            selenium.switchToFrame("newAccountFrame");
		            selenium.waitingTime(2000);
		            if(selenium.isElementPresentFast("DefaultAdoptionLink"))
		            {
						selenium.waitForElementToBeClickable("DefaultAdoptionLink");
						selenium.jsClick("DefaultAdoptionLink");
		            }
		            else
		            {
						selenium.waitForElementToBeClickable("MHEQuoteDetailsArrow");
						selenium.jsClick("MHEQuoteDetailsArrow");
						selenium.waitForElementToBeClickable("DefaultAdoptionLink");
						selenium.jsClick("DefaultAdoptionLink");
		            }
		            selenium.waitingTime(4000);
		            selenium.refresh();
		            selenium.waitingTime(10000);
		            selenium.switchOutOfFrame();
		            selenium.waitForElementToBeVisible("opportunityAmount");
		            String amount2 = selenium.getText("opportunityAmount");
		            System.out.println("opp amount"+ amount2);
		            String number2 = amount2.replaceAll("[^0-9]", "");
		            System.out.println("2nd Opp Amount:" + number2);
		            selenium.captureScreenShot();
		            selenium.waitingTime(2000);

					selenium.navigateToURL(selenium.oppURL);
		            selenium.waitingTime(4000);
		            selenium.refresh();
		            selenium.waitingTime(10000);
		            selenium.switchOutOfFrame();
		            selenium.waitForElementToBeVisible("opportunityAmount");
		            String amount1 = selenium.getText("opportunityAmount");
		            System.out.println("opp amount"+ amount1);
		            String number1= amount1.replaceAll("[^0-9]", "");
		            System.out.println("1st Opp Amount:" + number1);
		            selenium.captureScreenShot();
		            selenium.waitingTime(2000);

		            if (number2.equals(number1))
			            {
			                selenium.test.log(LogStatus.PASS, "Amount is matching");
			                System.out.println("PASS");
//			                selenium.captureScreenShot();
			            }
		            else
			            {
			                selenium.test.log(LogStatus.FAIL, "Amount is not matching");
			                System.out.println("FAIL");
			                selenium.reportFailure("Amount is not matching");
//			                selenium.captureScreenShot();
			            }
		        }
		        catch (Exception e)
		        {
		            selenium.reportFailure(e.getMessage());
		            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		        }
		    }
		    
			 @Then("^navigate to Calendar tab$")
			 public void navigate_to_Calendar_tab()
			 {
					try
						{
							selenium.waitingTime(6000);
							selenium.waitForElementToBeClickable("menuDots");
							selenium.click("menuDots");
							selenium.waitingTime(3000);
							selenium.waitForElementToBeVisible("searchItemsTextField");
							selenium.type("searchItemsTextField", "Search Text");
							selenium.waitForElementToBeClickable("AppLauncherCalendarMenu");
							selenium.jsClick("AppLauncherCalendarMenu");
							selenium.waitingTime(5000);
							selenium.test.log(LogStatus.INFO, "Calendar Event screen loaded successfully!");
						}

					catch (Exception e)
						{
							selenium.reportFailure("Error while navigating to MHE Quotes tab" + e.getMessage());
							selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						}

			 }

		@And("^link an opp to the newly created quote$")
		public void link_opp_to_quote()
		{
			try
			{
				selenium.waitForElementToBeClickable("MHEQuoteLinkOppBtn");
				selenium.click("MHEQuoteLinkOppBtn");
				selenium.waitForElementToBeClickable("LinkToExistingOppRadioBtn");
				selenium.click("LinkToExistingOppRadioBtn");
				selenium.waitForElementToBeVisible("opportunityDD");
				String OppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
				Select dropdown = new Select(selenium.getElement("opportunityDD"));
				dropdown.selectByVisibleText(OppName);
				selenium.waitForElementToBeClickable("QuoteOppLinkPopupSaveBtn");
				selenium.clickLoop("QuoteOppLinkPopupSaveBtn");
				selenium.waitingTime(20000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.captureScreenShot();
			}

		catch (Exception e)
			{
				selenium.reportFailure("Error while linking opp to quote" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Error while linking opp to quote");
			}

		}
		
		@Then("^Go through the approval process with discount$")
		public void go_through_the_approval_process_with_discount() {
			try {
				//Discount field is present on header displaying discount given by user
				selenium.waitForElementToBeClickable("QuoteProductMassEditBtn");
				selenium.jsClick("QuoteProductMassEditBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SelectAllChkBxInProdMassEdit");
				selenium.click("SelectAllChkBxInProdMassEdit");
				selenium.waitingTime(2000);
				selenium.selectAllandReplaceText("DiscountBox", selenium.DiscountPercentage);
				selenium.waitingTime(2000);
				selenium.click("ApplyDiscountbtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CloseAlertMsgPopup");
				selenium.click("CloseAlertMsgPopup");
				selenium.waitingTime(2000);
				selenium.click("SaveAndReturnBtn");
				selenium.waitingTime(5000);		
				selenium.waitForElementToBeVisible("QuoteDiscountValue");
				String quotepercent = selenium.getText("QuoteDiscountValue");
				System.out.println("quotepercent" + quotepercent);

				if(quotepercent.contains(selenium.DiscountPercentage)) //15 = 15.00 so using contains here
				{
					selenium.test.log(LogStatus.PASS, "15% discount applied");
					System.out.println("PASS - Discount field is present on header displaying discount given by user");					
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Error while applying discount");
					selenium.reportFailure("Error while applying discount");
					System.out.println("FAIL");
				}
				
				//Verify Grand Total is calculated i.e with discount applied on it
				/*String Grand_Total = selenium.getText("grandTotalprice");
				System.out.println("Grand_Total -->" + Grand_Total);
		        String GrandTotalWithoutSymbol = Grand_Total.replaceAll("\\$", "");        		        // Remove the "$" symbol
		        System.out.println("Grand_Total without $ symbol: " + GrandTotalWithoutSymbol);
				String TotalSellingPriceOfProduct1 = selenium.getText("totalSellingPrice_Product1");
				System.out.println("TotalSellingPriceOfProduct1 -->" + TotalSellingPriceOfProduct1);
		        String TotalSellingPriceOfProduct1WithoutSymbol = TotalSellingPriceOfProduct1.replaceAll("\\$", "");		    		        // Remove the "$" symbol    
		        System.out.println("TotalSellingPriceOfProduct1 without $ symbol: " + TotalSellingPriceOfProduct1WithoutSymbol);
				String TotalSellingPriceOfProduct2 = selenium.getText("totalSellingPrice_Product2");
				System.out.println("TotalSellingPriceOfProduct2 -->" + TotalSellingPriceOfProduct2);
		        String TotalSellingPriceOfProduct2WithoutSymbol = TotalSellingPriceOfProduct2.replaceAll("\\$", "");		        		        // Remove the "$" symbol
		        System.out.println("TotalSellingPriceOfProduct2 without $ symbol: " + TotalSellingPriceOfProduct2WithoutSymbol);
		        TotalSellingPriceOfProduct1WithoutSymbol = TotalSellingPriceOfProduct1WithoutSymbol.replaceAll("\\,", "");
		        TotalSellingPriceOfProduct2WithoutSymbol = TotalSellingPriceOfProduct2WithoutSymbol.replaceAll("\\,", "");
		        double TSP_Prod1 = Double.parseDouble(TotalSellingPriceOfProduct1WithoutSymbol);
		        double TSP_Prod2 = Double.parseDouble(TotalSellingPriceOfProduct2WithoutSymbol);
		        System.out.println("TSP_Prod1-->" + TSP_Prod1 + "TSP_Prod2-->" + TSP_Prod2);
		        double SumOfTotalSellingPricesOfProduct1AndProduct2 = TSP_Prod1 + TSP_Prod2;
		        System.out.println("SumOfTotalSellingPricesOfProduct1AndProduct2 -->" + SumOfTotalSellingPricesOfProduct1AndProduct2);
		        double GrandTotal = Double.parseDouble(GrandTotalWithoutSymbol);
		        double delta = 0.001; // specify a small delta for tolerance
		        Assert.assertEquals(SumOfTotalSellingPricesOfProduct1AndProduct2, GrandTotal, delta);
		        System.out.println("PASS - Sum of Total Selling Prices after the Discount is matching with Quote's Grand Total");
		        selenium.test.log(LogStatus.PASS, "Sum of Total Selling Prices after the Discount is matching with Quote's Grand Total");
				
		        //Verify ‘Selling Price’ has different value to ‘Catalog Price’
				String SellingPrice = selenium.getText("QuoteSellingPrice");
				System.out.println("SellingPrice -->" + SellingPrice);
		        String SellingPriceWithoutSymbol = SellingPrice.replaceAll("\\$", "");		 		        // Remove the "$" symbol       
		        System.out.println("SellingPrice without $ symbol: " + SellingPriceWithoutSymbol);
		        String CatalogPrice = selenium.getText("QuoteCatalogPrice");
				System.out.println("CatalogPrice -->" + CatalogPrice);
		        String CatalogPriceWithoutSymbol = CatalogPrice.replaceAll("\\$", "");				        // Remove the "$" symbol        
		        System.out.println("CatalogPrice without $ symbol: " + CatalogPriceWithoutSymbol);
		        Assert.assertNotEquals(SellingPriceWithoutSymbol, CatalogPriceWithoutSymbol);
		        System.out.println("PASS - Selling Price and Catalog Price is different");
		        selenium.test.log(LogStatus.PASS, "Selling Price and Catalog Price is different");
		        
		        //Verify the discount percentage and discounted amount is correctly calculated
		        double Catalog_Price = Double.parseDouble(CatalogPriceWithoutSymbol); 		        // Casting string to double
		        System.out.println("Catalog_Price -->" + Catalog_Price);
		        double DiscountedPrice = 15/100*Catalog_Price;
		        System.out.println("DiscountedPrice -->" + DiscountedPrice);
		        double ExcludeTheDiscountPriceFromCatalogPrice = Catalog_Price - DiscountedPrice;
		        System.out.println("ExcludeTheDiscountPriceFromCatalogPrice -->" + ExcludeTheDiscountPriceFromCatalogPrice);
		        double TotalSellingPriceOfProd1 = Double.parseDouble(TotalSellingPriceOfProduct1WithoutSymbol);
		        System.out.println("TotalSellingPriceOfProd1 -->" + TotalSellingPriceOfProd1 );
		        Assert.assertEquals(TotalSellingPriceOfProd1, ExcludeTheDiscountPriceFromCatalogPrice, delta);*/
		        
				selenium.waitForElementToBeClickable("approve_quote");
				selenium.click("approve_quote");
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("LinkOpportunityCheckBox");
				selenium.click("LinkOpportunityCheckBox");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.clickLoop("nextButton_quote");
				selenium.waitingTime(5000);
				
				if(!selenium.isElementPresentFast("MHEQuoteNewOppRatioBtn"))
				{
					System.out.println("Clicking Next button..");
					selenium.jsClick("nextButton_quote");
					selenium.waitingTime(5000);
				}
				
				//Link Quote to new opportunity
				selenium.waitForElementToBeClickable("MHEQuoteNewOppRatioBtn");
				selenium.click("MHEQuoteNewOppRatioBtn");
	            Select dropdown = new Select(selenium.getElement("MarketSubject"));
		        dropdown.selectByIndex(5);
	            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendar");
	            selenium.click("NewOppCloseOrDecisionDateCalendar");
	            selenium.waitingTime(2000);
	            selenium.click("NewOppCloseOrDecisionDateCalendar");
	            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendarDate");
	            selenium.click("NewOppCloseOrDecisionDateCalendarDate");
	            selenium.waitingTime(2000);
	            selenium.waitForElementToBeClickable("NewOppPurchaseDateCalendar");
	            selenium.click("NewOppPurchaseDateCalendar");
	            selenium.waitingTime(2000);
	            selenium.click("NewOppPurchaseDateCalendar");
	            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendarDate");
	            selenium.click("NewOppCloseOrDecisionDateCalendarDate");						
	            selenium.waitingTime(2000);
	            dropdown = new Select(selenium.getElement("SubtypeDrpDwnInQuoteNewOpp"));
		        dropdown.selectByValue("New Logo");
	            selenium.waitingTime(2000);
	            selenium.waitForElementToBeClickable("QuoteLinkOppNextBtn");
	            selenium.click("QuoteLinkOppNextBtn");
	            selenium.waitingTime(4000);	            
	            selenium.takeScreenShot();
	            
	            //Delete duplicate opp
	            if(selenium.isElementPresentFast("OppAlreadyExistsPopup"))
	            {
	            	selenium.click("CloseAlertMsgPopup");
	            	selenium.waitForElementToBeClickable("QuoteOppLinkCancelBtnNew");
	            	selenium.click("QuoteOppLinkCancelBtnNew");
		            selenium.waitingTime(8000);
		            selenium.switchOutOfFrame();
		            selenium.refresh();
		            selenium.waitingTime(15000);
		            selenium.logoutFromAnyUser();
					 selenium.waitingTime(4000);
					 if(selenium.isElementPresentFast("loginPassword"))
					 {
						 System.out.println("Main login page appeared so doing login again");
						 selenium.doDefaultUATLogin();
					 }
		            selenium.waitingTime(5000);
		            selenium.refresh();
		            selenium.waitingTime(8000);
		            String OppName="2024-North-West University-ELEMENTARY: CORE - OTHER-Open-acaro-Renewal";
					selenium.search_data(OppName);
					String Xpath = selenium.getDynamicXpath_data("opportunityStartContains1", OppName, "endContains");
					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("OppsTopResult"))
					{
						selenium.click("OppsTopResult");
					}
					else
					{
						selenium.click("TopResultShowMoreLink");
						selenium.waitForElementToBeClickable("OppsTopResult");
						selenium.click("OppsTopResult");
					}
					System.out.println(Xpath);
					selenium.clickLoopXpath(Xpath);
					selenium.waitingTime(8000);
					selenium.test.log(LogStatus.INFO, "Navigated to the desired opportunity");
			 		selenium.waitForElementToBeClickable("moreActionsBtn");
			 		selenium.click("moreActionsBtn");
			 		selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("DeletePopup2");
					selenium.clickLoop("DeletePopup2");
					selenium.waitForElementToBeClickable("deletePopupBtn");
					selenium.clickLoop("deletePopupBtn");
					selenium.waitingTime(9000);
					selenium.reportFailure("Test Case Failed");
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	            }
				selenium.waitingTime(25000);
	            String quoteReviewText = "Automation Test";
	            selenium.typeData("QuoteApprovalTextBox",quoteReviewText);
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
				selenium.waitForElementToBeClickable("SubmitForApprovalBtn");
				selenium.clickLoop("SubmitForApprovalBtn");
				selenium.waitingTime(10000);
	            
			} catch (Exception e)
			{
				selenium.reportFailure(e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		
		@And("^approver one approves the quote$")
		public void approver_one_approves_the_quote()
		{
			try
				{
					selenium.navigateToURL(selenium.new_QuoteURL);
					selenium.waitingTime(10000);
					selenium.switchToMultipleFrame("newAccountFrame");
					selenium.waitForElementToBeClickable("ApprovalHistoryRelatedListInQuote");
					selenium.jsClick("ApprovalHistoryRelatedListInQuote");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ApproveQuoteinApprovalHistory");
					selenium.click("ApproveQuoteinApprovalHistory");
					selenium.waitingTime(2000);
					selenium.switchOutOfFrame();
					selenium.waitForElementToBeClickable("ApproveActionBtnInQuote");
					selenium.click("ApproveActionBtnInQuote");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ApproveQuoteCommentbox");
					selenium.typeData("ApproveQuoteCommentbox", "Automation Test");
					selenium.waitForElementToBeClickable("ApproveBtn");
					selenium.click("ApproveBtn");
					selenium.waitingTime(15000);							
					Assert.assertTrue(selenium.isElementPresentFast("QuoteStatus_AwaitingApproval"));
					selenium.test.log(LogStatus.PASS, "Quote status is Awaiting Approval");
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		}
		
		@And("^approver two approves the quote$")
		public void approver_two_approves_the_quote()
		{
			try
				{
					selenium.navigateToURL(selenium.new_QuoteURL);
					selenium.waitingTime(10000);
					selenium.switchToMultipleFrame("newAccountFrame");
					selenium.waitForElementToBeClickable("ApprovalHistoryRelatedListInQuote");
					selenium.jsClick("ApprovalHistoryRelatedListInQuote");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ApproveQuoteinApprovalHistory");
					selenium.click("ApproveQuoteinApprovalHistory");
					selenium.waitingTime(2000);
					selenium.switchOutOfFrame();
					selenium.waitForElementToBeClickable("ApproveActionBtnInQuote");
					selenium.click("ApproveActionBtnInQuote");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ApproveQuoteCommentbox");
					selenium.typeData("ApproveQuoteCommentbox", "Automation Test");
					selenium.waitForElementToBeClickable("ApproveBtn");
					selenium.click("ApproveBtn");
					selenium.waitingTime(15000);							
					Assert.assertTrue(selenium.isElementPresentFast("QuoteStatus_Approved"));
					selenium.test.log(LogStatus.PASS, "Quote status is Approved/Active");
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		}
				
		 @And("^verify Show Discounting Field is Visible for this \"([^\"]*)\"$")
		 public void verify_Show_Discounting_Field_is_Visible_for_this_user(String User)
		 {
			try
				{
					System.out.println("Currnelty logged in user is" + User);
					
					if(User.equals("Stefanie_Vogel"))
					{
						System.out.println("For this user Allow Discounting option is checked in user setup page, so this user should be able to see the 'Show Discounting' field");
						Assert.assertTrue(selenium.isElementPresentFast("ShowDiscountFieldCheckbox"));
						selenium.test.log(LogStatus.PASS, "Show Discounting field is visible for the user");
					}
//					else if(User.equals("Elva_Smith"))
//					{
//						System.out.println("For this user Allow Discounting option is NOT checked in user setup page, so this user should NOT be able to see the 'Show Discounting' field");
//						Assert.assertFalse(selenium.isElementPresentFast("ShowDiscountFieldCheckbox"));
//					}
				}

			catch (Exception e)
				{
					selenium.reportFailure("Error while verifying show discounting field" + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		 }
	 
		@And("^verify add product through Subscription button$")
		public void verify_add_product_through_Subscription_button()
		{
			try
				{
					selenium.click("SubscriptionBtnInQuoteProduct");
					selenium.waitingTime(2000);
					Select dropdown = new Select(selenium.getElement("SelectSponsorListBox"));
		            dropdown.selectByIndex(1);
					selenium.waitingTime(2000);
					dropdown = new Select(selenium.getElement("SelectContractTypeListBox"));
		            dropdown.selectByIndex(1);
					selenium.waitingTime(2000);
					selenium.click("SearchSubscriptionBtn");
					selenium.waitingTime(3000);
					Assert.assertTrue(selenium.isElementPresentFast("AddtoQuoteBtnInSubscription"));
					selenium.click("CancelAddtoQuotePopup");
					selenium.waitingTime(3000);
					selenium.test.log(LogStatus.PASS, "Successfully verified Subscription functionalilty");
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		}
		
		@Then("^Go through the approval process match quote$")
		public void go_through_the_approval_process_match_quote() {
			try {
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("approve_quote");
				selenium.click("approve_quote");
				selenium.waitForElementToBeClickable("noApprovalRequired_quote");
				selenium.click("noApprovalRequired_quote");
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitForElementToBeClickable("LinkOpportunityCheckBox");
				selenium.click("LinkOpportunityCheckBox");
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitingTime(5000);
         
				selenium.waitForElementToBeClickable("LinkToExistingOppRadioBtn");
				selenium.click("LinkToExistingOppRadioBtn");
				selenium.waitForElementToBeVisible("opportunityDD");
				String OppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
				Select dropdwn = new Select(selenium.getElement("opportunityDD"));
				dropdwn.selectByVisibleText(OppName);
				selenium.waitingTime(2000);
				
				//Verify if the Quote Lines on Quote have the sum total of 0, the Targeted Products on Opportunity will NOT get updated - GCRM-15758
				Select updateDropDown = new Select(selenium.getElement("updateDropDown"));
				updateDropDown.selectByValue("Match Quote");										//Match Quote
				Select updateStageDropDown = new Select(selenium.getElement("updateStageDropDown"));
				updateStageDropDown.selectByVisibleText("Won");					//Won
				Select opportunityReason = new Select(selenium.getElement("opportunityReason"));
				opportunityReason.selectByVisibleText("Due to Messaging/Presentation");							//messaging/presentation
				Select PrimaryFundingType = new Select(selenium.getElement("PrimaryFundingType"));
				PrimaryFundingType.selectByValue("Title I");										//Title I
				selenium.waitingTime(2000);
				
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
				selenium.waitingTime(60000);
				selenium.captureScreenShot();
	        	selenium.waitingTime(2000);
	            
			} catch (Exception e)
			{
				selenium.reportFailure(e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		
		@Then("^Go through the upsell approval process$")
		public void go_through_the_upsell_approval_process() {
			try {
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("approve_quote");
				selenium.click("approve_quote");
				selenium.waitForElementToBeClickable("noApprovalRequired_quote");
				selenium.click("noApprovalRequired_quote");
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitForElementToBeClickable("QuoteUpSellYesRadioBtn");
				selenium.click("QuoteUpSellYesRadioBtn");
				selenium.waitingTime(2000);
				Select upsell1 = new Select(selenium.getElement("SelectUpSell1DrpDwnList"));
				upsell1.selectByIndex(1);
				Select upsell2 = new Select(selenium.getElement("SelectUpSell2DrpDwnList"));
				upsell2.selectByIndex(2);
				Select upsell3 = new Select(selenium.getElement("SelectUpSell3DrpDwnList"));
				upsell3.selectByIndex(3);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("QuotePriceNextBtn");
				selenium.click("QuotePriceNextBtn");
				selenium.waitingTime(60000);
	            
			} catch (Exception e)
			{
				selenium.reportFailure(e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		
		@And("^try editing or deleting upsell record in MHE Quotes$")
		public void try_editing_or_deleting_upsell_record_in_MHE_Quotes() {
			try {
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(8000);
	            selenium.defaultframe();
	            selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("QuoteUpSellRelatedListLink");
				selenium.click("QuoteUpSellRelatedListLink");
				selenium.waitForElementToBeClickable("UpSellEditLink");		//EDIT UPSELL THROUGH MHE QUOTES
				selenium.click("UpSellEditLink");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
				Assert.assertTrue(selenium.isElementPresentFast("UpSellCannotEditDeleteMsg"));
				selenium.test.log(LogStatus.PASS, "You cannot Edit/Delete Quote Upsell directly. - Validation Message Appeared");
				
				/*selenium.navigateBack();
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(8000);
	            selenium.defaultframe();
	            selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("QuoteUpSellRelatedListLink");
				selenium.click("QuoteUpSellRelatedListLink");
				selenium.waitForElementToBeClickable("UpSellDeleteLink");		//DELETE UPSELL THROUGH MHE QUOTES
				selenium.click("UpSellDeleteLink");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
				Assert.assertTrue(selenium.isElementPresentFast("UpSellCannotEditDeleteMsg"));
				selenium.test.log(LogStatus.PASS, "You cannot Edit/Delete Quote Upsell directly. - Validation Message Appeared");*/				
				
				selenium.navigateBack();
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(8000);
	            selenium.defaultframe();
	            selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("QuoteUpSellRelatedListLink");
				selenium.click("QuoteUpSellRelatedListLink");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("UpSellRecordNameLink");
				selenium.click("UpSellRecordNameLink");
				selenium.waitingTime(5000);
				selenium.switchOutOfFrame();
				selenium.waitForElementToBeClickable("editButton");		//EDIT UPSELL THROUGH UPSELL TAB
				selenium.click("editButton");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Status_DropDown");
				selenium.jsClick("Status_DropDown");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Quote_Status_Options");
				selenium.jsClick("Quote_Status_Options");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("UpSellQuoteStatus");
				String checkStatus = selenium.getText("UpSellQuoteStatus").toString();
				System.out.println("The Status is : " + checkStatus);
				if (checkStatus.equalsIgnoreCase("Draft")) {
					System.out.println("Status Got Updated");
					selenium.test.log(LogStatus.PASS, "Status Got Updated - user is able to edit upsell record through Upsell Tab");
				} else {
					System.out.println("Status did not update");
					selenium.test.log(LogStatus.FAIL, "Status did not update");
				}
//				Assert.assertFalse(selenium.isElementPresentFast("UpSellCannotEditDeleteMsg"));
//				selenium.test.log(LogStatus.PASS, "Able to edit upsell record through Upsell Tab");				
//				selenium.click("CancelButton");
				selenium.waitingTime(3000);

				selenium.waitForElementToBeClickable("DeleteActionBtn");		//DELETE UPSELL THROUGH UPSELL TAB
				selenium.click("DeleteActionBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("deleteBtn");
				selenium.click("deleteBtn");
				selenium.waitingTime(4000);
				selenium.test.log(LogStatus.PASS, "Able to delete upsell record through Upsell Tab");
	            
			} catch (Exception e)
			{
				selenium.reportFailure(e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		
		@Then("^Go through the finance approver approval process$")
		public void go_through_the_finance_approver_approval_process() {
			try {
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("approve_quote");
				selenium.click("approve_quote");
				selenium.waitForElementToBeClickable("QuoteApprovalRequiredRadioBtn");
				selenium.click("QuoteApprovalRequiredRadioBtn");
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");				
				selenium.waitForElementToBeClickable("QuoteRVPChkBox");
				selenium.click("QuoteRVPChkBox");
				selenium.waitForElementToBeClickable("QuoteFinanceChkBox");
				selenium.click("QuoteFinanceChkBox");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextButton_quote");
				selenium.click("nextButton_quote");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextBtn_quote_lnkpage");
				selenium.click("nextBtn_quote_lnkpage");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("QuoteApprovalcomments");
	            selenium.typeData("QuoteApprovalcomments","Automation Testing");
				selenium.waitForElementToBeClickable("next");
				selenium.clickLoop("next");
				selenium.waitingTime(3000);
				Assert.assertTrue(selenium.isElementPresentFast("QuoteFinanceApproverName"));
				selenium.test.log(LogStatus.PASS, "Quote Finance Approver Name is - Brian Joniak");
				selenium.waitForElementToBeClickable("SubmitForApprovalBtn");
				selenium.clickLoop("SubmitForApprovalBtn");
				selenium.waitingTime(10000);
	            
			} catch (Exception e)
			{
				selenium.reportFailure(e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		
		@And("^\"([^\"]*)\" approves the quote$")
		public void approver_approves_the_quote(String approver)
		{
			try
				{
					selenium.waitingTime(5000);
					selenium.refresh();
					selenium.waitingTime(5000);
					selenium.waitForElementToBeVisible("ItemsToApproveSection");
					selenium.scrollToElement("ItemsToApproveSection");
					selenium.waitingTime(2000);					
					selenium.waitForElementToBeClickable("ApproveOrRejectQuoteLink");
					selenium.jsClick("ApproveOrRejectQuoteLink");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("QuoteApprovalcomments");
					selenium.typeData("QuoteApprovalcomments", "Automation Test");
					selenium.waitForElementToBeClickable("ApproveQuoteBtnClassic");
					selenium.click("ApproveQuoteBtnClassic");
					selenium.waitingTime(10000);
					if(approver.equals("Stewart_Smith") || approver.equals("Bethany_Davis"))
					{
						Assert.assertTrue(selenium.isElementPresentFast("QuoteStatus_AwaitingApproval"));
						selenium.test.log(LogStatus.PASS, "Quote status is Awaiting Approval");
					}
					else if(approver.equals("Brian_Joniak"))
					{
						Assert.assertTrue(selenium.isElementPresentFast("QuoteStatus_Approved"));
						selenium.test.log(LogStatus.PASS, "Quote status is Approved/Active");
					}
				}

			catch (Exception e)
				{
					selenium.reportFailure(e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		}
		
		@Then("^revise the approved quote$")
		public void revise_the_approved_quote() {
			try {
	        	selenium.navigateToURL(selenium.new_QuoteURL);
				selenium.waitingTime(15000);
				selenium.waitForElementToBeClickable("ReviseQuoteBtn");
				selenium.click("ReviseQuoteBtn");
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitingTime(4000);	
				selenium.waitForElementToBeClickable("nextButtonValue");
				selenium.click("nextButtonValue");
	            System.out.println("waiting waiting....");
	            selenium.waitingTime(150000);
	            selenium.refresh();
	            selenium.waitingTime(15000);
	            selenium.defaultframe();
	            selenium.switchToFrame("newAccountFrame");
	            System.out.println("1st frame");
	            selenium.waitingTime(2000);
	            selenium.switchToFrame("frame_quote");
	            System.out.println("2nd frame");
			}
			catch (Exception e)
			{
				selenium.reportFailure(e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	}
		
		@And("^link new opportunity with existing A3K account quote for \"([^\"]*)\"$")
		 public void link_new_opportunity_with_existing_A3K_account_quote(String Opp_Type, DataTable table)
		 {
			 List<String> data = table.transpose().asList(String.class);
				try
					{
			            System.out.println("waiting waiting....");
			            selenium.waitingTime(150000);
			            selenium.refresh();
			            selenium.waitingTime(10000);
			            selenium.defaultframe();
			            selenium.switchToFrame("newAccountFrame");
			            System.out.println("1st frame");
			            selenium.waitingTime(2000);
			            selenium.switchToFrame("frame_quote");
			            System.out.println("2nd frame");
			            selenium.waitForElementToBeClickable("MHEQuoteLinkOppBtnNew");
			            selenium.clickLoop("MHEQuoteLinkOppBtnNew");
						selenium.waitingTime(4000);					
			            
			            if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
			            {
			            	selenium.click("CloseAlertMsgPopup");
			            	selenium.waitingTime(2000);
			            	System.out.println("Adding valid ISBN");
			                selenium.waitForElementToBeVisible("isbnInput");
			                selenium.typeData("isbnInput",data.get(0));
			                selenium.waitingTime(4000);
			                selenium.waitForElementToBeClickable("addIsbn");
			                selenium.click("addIsbn");
			                selenium.waitingTime(10000);
			                selenium.refresh();
			                selenium.waitingTime(20000);
				            selenium.defaultframe();
				            selenium.switchToFrame("newAccountFrame");
				            System.out.println("1st frame");
				            selenium.waitingTime(2000);
				            selenium.switchToFrame("frame_quote");
				            System.out.println("2nd frame");
				            selenium.waitForElementToBeClickable("MHEQuoteLinkOppBtnNew");
				            selenium.clickLoop("MHEQuoteLinkOppBtnNew");
							selenium.waitingTime(4000);
			            }
			            
						selenium.waitForElementToBeClickable("MHEQuoteNewOppRatioBtn");
						selenium.click("MHEQuoteNewOppRatioBtn");	
			            Select dropdown = new Select(selenium.getElement("MarketSubject"));
			            dropdown.selectByIndex(2);
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("NewOppCloseOrDecisionDateCalendar");
			            selenium.click("NewOppCloseOrDecisionDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.click("NewOppCloseOrDecisionDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectMonthFilter");
			            selenium.click("SelectMonthFilter");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("ChooseMonth");
			            selenium.clickLoop("ChooseMonth");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectCloseOrDecisionDate");
			            selenium.click("SelectCloseOrDecisionDate");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("NewOppPurchaseDateCalendar");
			            selenium.click("NewOppPurchaseDateCalendar");
			            selenium.waitingTime(2000);
			            selenium.click("NewOppPurchaseDateCalendar");
			            selenium.waitForElementToBeClickable("SelectMonthFilter");
			            selenium.click("SelectMonthFilter");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("ChooseMonth");
			            selenium.clickLoop("ChooseMonth");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("SelectPurchaseDate");
			            selenium.click("SelectPurchaseDate");
			            selenium.waitingTime(2000);

				        if(Opp_Type.equals("DAG New/Field"))
						{
							selenium.typeData("NewOppforQuote_DealNamefield","DAG New/Field");
						}
				        else if(Opp_Type.equals("DAG Renewal"))
				        {
				        	selenium.typeData("NewOppforQuote_DealNamefield","DAG Renewal");
				        }
				        else if(Opp_Type.equals("SEG"))
				        {
				        	selenium.typeData("NewOppforQuote_DealNamefield","SEG");
				        }
			            selenium.waitingTime(2000);
			            dropdown = new Select(selenium.getElement("SubtypeDrpDwnInQuoteNewOpp"));
				        dropdown.selectByValue("New Logo");
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("QuoteOppLinkPopupSaveBtn");
			            selenium.waitingTime(4000);
			            selenium.click("QuoteOppLinkPopupSaveBtn");
			            selenium.waitingTime(15000);			            
						selenium.switchOutOfFrame();
			            selenium.waitingTime(2000);
			            selenium.waitForElementToBeClickable("MHEQuoteEditPageCloseBtn");
			            selenium.click("MHEQuoteEditPageCloseBtn");
					}

				catch (Exception e)
					{
						selenium.reportFailure(e.getMessage());
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}
		 }
}
