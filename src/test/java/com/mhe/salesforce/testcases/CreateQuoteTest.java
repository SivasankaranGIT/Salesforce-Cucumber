package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bouncycastle.asn1.dvcs.Data;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class CreateQuoteTest {
    WebConnector selenium = WebConnector.getInstance();
    String Opp_Name = "2024-OK-Lawton Public Schools-DAG: ELA/MATH-Open-jbaker";   
    String catalogPrice = null;
    String sellingPrice = null;
    String catalogPriceInClonedQuote = null;
    String sellingPriceInClonedQuote = null;
    String quoteOpp_URL = null;
    String A3KAccount = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000cN0F5AAK/view";
    String AccountName = null;

    @Then("^navigate to MHE_Quotes tab on opportunity$")
    public void navigate_to_MHE_Quotes_tab_on_opportunity() {

        try {
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.getElement("searchItemsTextField").sendKeys("Sales");
			selenium.waitForElementToBeClickable("Saleslightningapp");
			selenium.jsClick("Saleslightningapp");
			selenium.waitingTime(4000);
			
//			selenium.navigateToURL(selenium.newOppCreatedViaPostponeClone);
			selenium.navigateToURL(selenium.NewOppURLForQuotesTest);
            selenium.waitingTime(10000);

            if(selenium.isElementPresentFast("mheQuoteLink"))
            {
                selenium.waitForElementToBeVisible("mheQuoteLink");
                selenium.scrollToElement("mheQuoteLink");
                selenium.waitForElementToBeClickable("mheQuoteLink");
                selenium.jsClick("mheQuoteLink");            	
            }
            else
            {
                selenium.refresh();
                selenium.waitingTime(25000);
                selenium.waitForElementToBeVisible("mheQuoteLink");
                selenium.scrollToElement("mheQuoteLink");
                selenium.waitForElementToBeClickable("mheQuoteLink");
                selenium.jsClick("mheQuoteLink");
            }
            selenium.test.log(LogStatus.INFO, "Navigate to MHE Quote tab on Opportunity");
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^click on New Quote$")
    public void click_on_New_Quote() {
        try {
//            selenium.waitingTime(2000);
            selenium.test.log(LogStatus.INFO, "Click on New Quote");
        	selenium.waitForElementToBeClickable("newQuoteButton");
            selenium.jsClick("newQuoteButton");
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^I Create a Quote$")
    public void I_Create_a_Quote() throws Exception {

        try {
            selenium.waitingTime(6000);
            // selenium.switchiFrame(2);
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(4000);
            String date = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
            String randomValue = Integer.toString(selenium.getRandomNumber());
            selenium.waitForElementToBeClickable("QuoteName1");
            selenium.click("QuoteName1");
            selenium.typeData("QuoteName1", "myQuote_" + randomValue + "_" + date);
            selenium.waitingTime(2000);
            selenium.newQuoteName = "myQuote_" + randomValue + "_" + date;
            System.out.println("The newly quote name is : " + selenium.newQuoteName);
            selenium.waitForElementToBeVisible("QuoteTypeField");            
            selenium.click("QuoteTypeField");
      		selenium.waitForElementToBeClickable("QuoteTypeValue");
      		selenium.click("QuoteTypeValue");
        	selenium.waitForElementToBeVisible("contact_quote1");
            selenium.click("contact_quote1");
//            selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("contact_quoteValue1");
            selenium.click("contact_quoteValue1");
//            selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("subscription_quote1");
            selenium.click("subscription_quote1");
//            selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("subscription_quoteValue2");
            selenium.click("subscription_quoteValue2");
//            selenium.waitingTime(2000);
        	selenium.waitForElementToBeVisible("coverComments1");
            selenium.typeData("coverComments1", "test cover");
            selenium.typeData("eoqComments1", "testComment");
        	selenium.waitForElementToBeClickable("nextButton");
            selenium.click("nextButton");
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^I fill details in Product information related page$")
    public void I_fill_details_in_Product_information_related_page() throws Exception {
        try {
        	System.out.println("Waiting Waiting...");
        	selenium.waitingTime(180000);	//3min
            selenium.takeScreenShot();
            selenium.defaultframe();
            selenium.waitingTime(4000);
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(4000);
            selenium.switchToFrame("frame_quote");
            selenium.waitingTime(4000);
            if(selenium.isElementPresentFast("productSearch"))
            {
            	System.out.println("productSearch element is present.");
                selenium.clickLoop("productSearch");
            }
            else
            {
            	selenium.refresh();
            	System.out.println("Waiting Waiting......");
            	selenium.waitingTime(300000);	//5min
                selenium.takeScreenShot();
                selenium.defaultframe();
                selenium.waitingTime(4000);
                selenium.switchToFrame("newAccountFrame");
                selenium.waitingTime(4000);
                selenium.switchToFrame("frame_quote");
                selenium.waitingTime(4000);
                selenium.waitForElementToBeClickable("productSearch");
                selenium.clickLoop("productSearch");
                if(selenium.isElementPresentFast("productSearch"))
                {
                	System.out.println("productSearch element is present.");
                    selenium.clickLoop("productSearch");
                }
                else
                {
                	selenium.refresh();
                	System.out.println("Waiting Waiting........");
                	selenium.waitingTime(300000);	//5min more
                    selenium.takeScreenShot();
                    selenium.defaultframe();
                    selenium.waitingTime(4000);
                    selenium.switchToFrame("newAccountFrame");
                    selenium.waitingTime(4000);
                    selenium.switchToFrame("frame_quote");
                    selenium.waitingTime(4000);
                    selenium.waitForElementToBeClickable("productSearch");
                    selenium.clickLoop("productSearch");
                }
            }

            selenium.waitingTime(2000);            
            
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }


    @Then("^I fill product details$")
    public void I_fill_product_details() throws Exception {
        try {
            selenium.waitingTime(6000);
            selenium.waitForElementToBeVisible("Copyright");
            String copyright = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Copyright");
            String productName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ProductName");
            String productTitle = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ProductTitle");
            String product1 = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Product1");
            String product2 = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Product2");
            String product3 = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Product3");

            selenium.type("productName_quote", "ProductName");
            //STUDENT EDITION SOFTCOVER
//            selenium.waitingTime(2000);
        	selenium.waitForElementToBeVisible("copyright_quote");
            // selenium.typeData("copyright_quote", "2019");
            selenium.type("copyright_quote","Copyright");
//            selenium.waitingTime(2000);
        	selenium.waitForElementToBeVisible("title_type");
            Select dropdown = new Select(selenium.getElement("title_type"));
            //dropdown.selectByValue("STUDENT EDITION SOFTCOVER");
            dropdown.selectByValue(productTitle);
//            selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("search_quote");
            selenium.click("search_quote");
            selenium.waitingTime(3000);
            selenium.captureScreenShot();
            selenium.waitingTime(5000);
            selenium.click("showBtn");
            selenium.waitingTime(3000);
            //selenium.waitForElementToBeVisible("product1_quote");
            String procuctXpath1 = selenium.getPropertiesObj().getProperty("product_quote").
                    replace("$val", product1);
            String procuctXpath2 = selenium.getPropertiesObj().getProperty("product_quote").
                    replace("$val", product2);
            String procuctXpath3 = selenium.getPropertiesObj().getProperty("product_quote").
                    replace("$val", product3);

            selenium.waitingTime(4000);
            selenium.clickXpath(procuctXpath1);
            System.out.println(procuctXpath1);
            selenium.waitingTime(2000);
            selenium.waitingTime(4000);
            selenium.clickXpath(procuctXpath2);
            System.out.println(procuctXpath2);
            selenium.waitingTime(2000);
            selenium.waitingTime(4000);
            selenium.clickXpath(procuctXpath3);
            System.out.println(procuctXpath3);
            selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("addTocart_Quote");
            selenium.click("addTocart_Quote");
            selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("viewCart_quote");
            selenium.click("viewCart_quote");
            selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("add_quote");
            selenium.click("add_quote");
            selenium.waitingTime(4000);
            
            if(selenium.isElementPresentFast("CancelSubscriptionCheck"))
            {
            	selenium.jsClick("CancelSubscriptionCheck");
            	selenium.waitingTime(5000);
            }
//            selenium.captureScreenShot();
        	selenium.waitForElementToBeClickable("allCheckbox_quote");
            selenium.click("allCheckbox_quote");
            selenium.waitingTime(4000);
//            selenium.click("proceed_quote");
            selenium.waitForElementToBeClickable("approve_quote");
            selenium.click("approve_quote");
            selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("noApprovalRequired_quote");
            selenium.click("noApprovalRequired_quote");
            selenium.waitingTime(3000);
//            selenium.captureScreenShot();
        	selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(3000);
//            if(selenium.isElementPresentFast("PricingInfoQuote"))		//Need to remove this after UAT Fix
//            {
//            	System.out.println("Inside PricingInfoQuote");
//            	selenium.clickLoop("nextButton_quote");
//            }

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^Validate Opportunity name and status$")
    public void Validate_Opportunity_name_and_status() throws Exception {
        try {

            selenium.waitingTime(6000);
            System.out.println("selenium.opty_expected is --> " + selenium.opty_expected);
	        if(selenium.opty_expected == null)
	        {
	        	System.out.println("selenium.opty_expected is.. " + selenium.opty_expected);
	        	selenium.opty_expected = "2024-OK-Edwards Elementary Schoo-DAG: ELA/MATH-Open-jbaker";
	        }
            String opportunity1 = selenium.opty_expected;
            String oppName_actual =  selenium.getElement("oppName_quote").getAttribute("value");
            System.out.println("Opportunity Name expected1 : " + opportunity1);
            System.out.println("Opportunity Name actual : " + oppName_actual);
            if (oppName_actual.contains(opportunity1)) {
                selenium.test.log(LogStatus.PASS, "Opportunity Matching");
                System.out.println("PASS");
            } else {
                selenium.test.log(LogStatus.FAIL, "Opportunity not Matching");
                System.out.println("FAIL");
                selenium.reportFailure("Opportunity not Matching");
            }
            selenium.waitingTime(3000);
//        	selenium.waitForElementToBeVisible("opportunityDD");
//        	selenium.scrollToElement("opportunityDD");
//            selenium.captureScreenShot();
            selenium.waitForElementToBeClickable("savedoNotLinkQuoteLine");
            selenium.click("doNotLink");
    		selenium.waitForElementToBeVisible("reasonText");
            selenium.typeData("reasonText","Test");
            selenium.waitForElementToBeClickable("next");
            selenium.clickLoop("next");
            selenium.waitingTime(15000);
            String status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Status");
            System.out.println("status is : " + status);
            selenium.waitingTime(2000);
            String statusXpath = selenium.getPropertiesObj().getProperty("status_quote_val").
                    replace("$val", status);
            System.out.println("statusXpath is : " + statusXpath);
            selenium.waitingTime(60000);
            if(selenium.isElementPresentXpathFast(statusXpath)){
                selenium.test.log(LogStatus.PASS, "Status Matches");
                System.out.println("PASS");
                selenium.captureScreenShot();
            }else {
                selenium.test.log(LogStatus.FAIL, "Status not Matching");
                System.out.println("FAIL");
                selenium.reportFailure("Status not Matching");
                selenium.captureScreenShot();
            }

            /*Getting newly created quote unique number*/
            selenium.waitForElementToBeClickable("moreInfoOpenBtn");
        	selenium.click("moreInfoOpenBtn");
            selenium.waitForElementToBeVisible("QuoteNumber");
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
            selenium.newQuoteNumber = selenium.getText("QuoteNumber");
            System.out.println("The new quote number is : " + selenium.newQuoteNumber);
            selenium.click("moreInfoCloseBtn");
            selenium.waitingTime(2000);

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^I Create a New Quote$")
    public void I_Create_New_a_Quote() throws Exception {

        try {
            selenium.waitingTime(6000);
            selenium.defaultframe();
            selenium.switchToMultipleFrame("newAccountFrame");
            System.out.println("switch 1st frame");
            selenium.waitingTime(1000);
            String date = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
            String randomValue = Integer.toString(selenium.getRandomNumber());
            selenium.waitForElementToBeClickable("QuoteName1");
            selenium.click("QuoteName1");
            selenium.typeData("QuoteName1", "myQuote_" + randomValue + "_" + date);
            selenium.newlyGeneratedQuoteName = "myQuote_" + randomValue + "_" + date;
            System.out.println("The new quote name is :" + selenium.newlyGeneratedQuoteName);
            selenium.waitingTime(2000);
            if(selenium.getTestCaseName().equalsIgnoreCase("SEGSalesRepCreateNewQuote") || selenium.getTestCaseName().equalsIgnoreCase("CreateNewQuoteThroughAccounts"))
            {
                selenium.newQuoteUniqueName = "myQuote_" + randomValue + "_" + date;
                System.out.println("The newly created quote name is : " + selenium.newQuoteUniqueName);
            }
            
            selenium.waitForElementToBeVisible("QuoteTypeField");            
            selenium.click("QuoteTypeField");            
      		selenium.waitForElementToBeClickable("QuoteTypeValue");
      		selenium.click("QuoteTypeValue");      		
            selenium.waitForElementToBeClickable("contact_quote1");
            selenium.click("contact_quote1");
        	selenium.waitForElementToBeClickable("contact_quoteValue1");
            selenium.click("contact_quoteValue1");
        	selenium.waitForElementToBeClickable("subscription_quote1");
            selenium.click("subscription_quote1");
        	selenium.waitForElementToBeClickable("subscription_quoteValue2");
            selenium.click("subscription_quoteValue2");
        	selenium.waitForElementToBeVisible("coverComments1");
            selenium.typeData("coverComments1", "test cover");
            selenium.typeData("eoqComments1", "testComment");
            selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("nextButton");
            selenium.click("nextButton");
            selenium.waitingTime(2000);
            selenium.switchOutOfFrame();
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @Then("^I Create a New Quote with quote \"([^\"]*)\"$")
    public void I_Create_New_a_Quote_with_different_quote_types(String Type) throws Exception {

        try {
            selenium.waitingTime(6000);
            selenium.defaultframe();
            selenium.switchToMultipleFrame("newAccountFrame");
            System.out.println("switch 1st frame");
            selenium.waitingTime(1000);
            String date = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
            String randomValue = Integer.toString(selenium.getRandomNumber());
            selenium.waitForElementToBeClickable("QuoteName1");
            selenium.click("QuoteName1");
            selenium.typeData("QuoteName1", "myQuote_" + randomValue + "_" + date);
            selenium.newlyGeneratedQuoteName = "myQuote_" + randomValue + "_" + date;
            System.out.println("The new quote name is :" + selenium.newlyGeneratedQuoteName);
            selenium.waitingTime(2000);            
            selenium.waitForElementToBeVisible("QuoteTypeField");            
            selenium.click("QuoteTypeField");
            
            System.out.println("Quote type is :" + Type);
       		selenium.waitForElementToBeClickable(Type);
          	selenium.click(Type);
      		
            selenium.waitForElementToBeClickable("contact_quote1");
            selenium.click("contact_quote1");
        	selenium.waitForElementToBeClickable("contact_quoteValue1");
            selenium.click("contact_quoteValue1");
        	selenium.waitForElementToBeClickable("subscription_quote1");
            selenium.click("subscription_quote1");
        	selenium.waitForElementToBeClickable("subscription_quoteValue2");
            selenium.click("subscription_quoteValue2");
            
            if(selenium.getTestCaseName().equalsIgnoreCase("VerifyCatalogPriceInClonedQuoteWithoutDiscount_InternationalAccount") || selenium.getTestCaseName().equalsIgnoreCase("VerifyDiscountApprovalQuoteExportForRenewalQuoteType"))
            {
            	selenium.jsClick("DateLink");
            }
        	selenium.waitForElementToBeVisible("coverComments1");
            selenium.typeData("coverComments1", "test cover");
            selenium.typeData("eoqComments1", "testComment");
            selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("nextButton");
            selenium.click("nextButton");
            selenium.waitingTime(2000);
            selenium.switchOutOfFrame();
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
	@And("verify Freight Charges SOA Error Message For Quote")
	public void verify_Freight_Charges_SOA_Error_Message_For_Quote()
	{
		try
		{
    		selenium.waitForElementToBeClickable("editQuoteLine");
            selenium.click("editQuoteLine");
            selenium.waitingTime(10000);
    		selenium.waitForElementToBeVisible("lineItemQuantity");
            selenium.clearText("lineItemQuantity");
            selenium.typeData("lineItemQuantity","1000000");
    		selenium.waitForElementToBeClickable("saveQuoteLine");
            selenium.jsClick("saveQuoteLine");
            selenium.waitingTime(8000);
            selenium.test.log(LogStatus.INFO, "Edited Quantity"); 
            selenium.waitForElementToBeClickable("QuotePriceBtn");
            selenium.jsClick("QuotePriceBtn");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("QuotePriceSubmitBtn");
            selenium.jsClick("QuotePriceSubmitBtn");
            selenium.waitingTime(15000);
            
            selenium.waitForElementToBeVisible("QuoteSOAPriceErrorAlertPopup");
            String errorMsg = selenium.getText("QuoteSOAPriceErrorAlertPopup");
            System.out.println("errorMsg -->" + errorMsg);
            Assert.assertEquals(errorMsg, "Due to excessive weight, Shipping and handling cannot be calculated");
            selenium.click("CloseAlertMsgPopup");
            selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
    
    @And("^I Add \"([^\"]*)\" number$")
    public void add_isbn_number_on_new_quote(String ISBN) throws Exception {

        try {

        	System.out.println("waiting waiting....");
        	selenium.waitingTime(60000);	//3min
        	selenium.takeScreenShot();
        	selenium.test.log(LogStatus.INFO, "1min wait over..");
        	System.out.println("1min wait over..");
            if(selenium.isElementPresentFast("quoteFrameOpp"))
            {
            	selenium.test.log(LogStatus.INFO, "quoteFrameOpp frame present..");
            	System.out.println("quoteFrameOpp frame present..");
            	selenium.takeScreenShot();
            	selenium.switchToMultipleFrame("quoteFrameOpp");
            	selenium.waitingTime(2000);
                if(selenium.isElementPresentFast("QuoteStartupActivitiesPage"))
                {
                	System.out.println("QuoteStartupActivitiesPage has appeared..");
                    selenium.takeScreenShot();
                	selenium.waitForElementToDisappearForLongtime("QuoteStartupActivitiesPage");
                }
                selenium.switchOutOfFrame();
            }

            selenium.waitingTime(2000);
            selenium.refresh();
        	System.out.println("waiting waiting....");
            selenium.waitingTime(180000); //3min
            selenium.test.log(LogStatus.INFO, "3min wait over..");
            System.out.println("3min wait over..");
            selenium.takeScreenShot();
            selenium.defaultframe();
            selenium.waitForElementToBeVisible("newAccountFrame");
            selenium.switchToFrame("newAccountFrame");
            System.out.println("1st frame");
            selenium.waitingTime(2000);
            selenium.switchToFrame("frame_quote");
            System.out.println("2nd frame");
            if(selenium.waitForElementToBeClickableLongerDuration("isbnInput")==false)
            {
            	System.out.println("Add ISBN field is not reachable..");            	
            	selenium.refresh();
            	System.out.println("waiting waiting....");
            	selenium.waitingTime(600000); //10min
            	selenium.test.log(LogStatus.INFO, "10min wait over..");
            	System.out.println("5min wait over..");
            	selenium.takeScreenShot();
                selenium.defaultframe();
                selenium.waitForElementToBeVisible("newAccountFrame");
                selenium.switchToFrame("newAccountFrame");
                System.out.println("1st frame");
                selenium.waitingTime(2000);
                selenium.switchToFrame("frame_quote");
                System.out.println("2nd frame");
            }
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
            selenium.waitingTime(12000);
        }
        catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^I Add ISBN number$")
    public void addd_isbm_number() throws Exception {

        try {

        	System.out.println("waiting waiting....");
        	selenium.waitingTime(300000);	//5min
            if(selenium.isElementPresentFast("quoteFrameOpp"))
            {
            	System.out.println("quoteFrameOpp frame present..");
            	selenium.switchToMultipleFrame("quoteFrameOpp");
            	selenium.waitingTime(2000);
                if(selenium.isElementPresentFast("QuoteStartupActivitiesPage"))
                {
                	System.out.println("QuoteStartupActivitiesPage has appeared..");
                    selenium.takeScreenShot();
                	selenium.waitForElementToDisappearForLongtime("QuoteStartupActivitiesPage");
                }
                selenium.switchOutOfFrame();
            }


            selenium.waitingTime(2000);
            selenium.refresh();
            selenium.waitingTime(60000);
            selenium.defaultframe();
            selenium.waitForElementToBeVisible("newAccountFrame");
            selenium.switchToFrame("newAccountFrame");
            System.out.println("1st frame");
            selenium.waitingTime(2000);
            selenium.switchToFrame("frame_quote");
            System.out.println("2nd frame");
            if(selenium.waitForElementToBeClickableLongerDuration("isbnInput")==false)
            {
            	System.out.println("Add ISBN field is not reachable..");
            	selenium.refresh();
            	selenium.waitingTime(120000);
                selenium.defaultframe();
                selenium.waitForElementToBeVisible("newAccountFrame");
                selenium.switchToFrame("newAccountFrame");
                System.out.println("1st frame");
                selenium.waitingTime(2000);
                selenium.switchToFrame("frame_quote");
                System.out.println("2nd frame");
            }
            selenium.type("isbnInput", "ISBN");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("addIsbn");
            selenium.click("addIsbn");
            selenium.waitingTime(4000);            
			if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
			{
			selenium.waitForElementToBeClickable("CloseAlertMsgPopup");
			selenium.click("CloseAlertMsgPopup");
			selenium.test.log(LogStatus.INFO, "Accepted Rep Cost 0 product ISBN!");
			}
            selenium.waitingTime(15000);
            selenium.test.log(LogStatus.INFO, "Added ISBN!");
            
           /* selenium.waitForElementToBeClickable("search_quote");
            selenium.click("search_quote");
            selenium.waitingTime(12000);
            
            if(selenium.isElementPresent("showBtn"))
            {
            	System.out.println("Inside IF");
                selenium.click("showBtn");
                selenium.waitingTime(5000);
            }

        	selenium.waitForElementToBeClickable("allIsbnCheckbox");
            selenium.click("allIsbnCheckbox");
            selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("addTocart_Quote");
            selenium.click("addTocart_Quote");
            selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("viewCart_quote");
            selenium.click("viewCart_quote");
            selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("add_quote");
            selenium.click("add_quote");
            selenium.waitingTime(4000);
            
            if(selenium.isElementPresentFast("CancelSubscriptionCheck"))
            {
            	selenium.jsClick("CancelSubscriptionCheck");
            	selenium.waitingTime(5000);
            }*/

        }catch(Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }


    @Then("^navigate to MHE_Quotes tab on Account$")
    public void navigate_to_MHE_Quotes_tab_on_account() {

        try {
            selenium.waitingTime(4000);
            if(selenium.getTestCaseName().equalsIgnoreCase("CreateNewOppFromQuote"))
            {
//            	selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
            	selenium.navigateToURL(selenium.NewOppURLForQuotesTest);
            	selenium.waitingTime(10000);
            }
            if(selenium.getTestCaseName().equalsIgnoreCase("CreateSEGAndDAGTypeOppFromA3KAccountQuote"))
            {
            	selenium.navigateToURL(A3KAccount);
            	selenium.waitingTime(10000);
            	selenium.waitForElementToBeVisible("AccountNameInAccountRecordGetText");
            	AccountName = selenium.getText("AccountNameInAccountRecordGetText");
            	System.out.println("AccountName -->" + AccountName);
            }
            if(selenium.getTestCaseName().equalsIgnoreCase("VerifyFreightChargesSOAErrorMessageForQuote"))
            {
            	selenium.waitForElementToBeClickable("firstTableRecord");
            	selenium.jsClick("firstTableRecord");
            	selenium.waitingTime(6000);
            }
        	selenium.waitForElementToBeClickable("mheQuoteLink");
            selenium.clickLoop("mheQuoteLink");
            selenium.test.log(LogStatus.INFO, "Navigate to MHE Quote tab on Account");
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^verify the Account name in Opp is matching with original Account for \"([^\"]*)\"$")
    public void verify_the_Account_name_in_Opp_is_matching_with_original_Account_for_Opp(String Opp_Type) {
        try
        {
        	if(Opp_Type.equals("DAG New/Field") || Opp_Type.equals("DAG Renewal")) //GCRM-16637
        	{
	        	selenium.waitForElementToBeVisible("opportunityAccountNameGetText");
	        	String OppAccountName = selenium.getText("opportunityAccountNameGetText");
	        	System.out.println("OppAccountName -->" + OppAccountName);
	        	System.out.println("OriginalAccountName -->" + AccountName);
	        	Assert.assertEquals(AccountName, OppAccountName);
	        	selenium.test.log(LogStatus.PASS, "Account name is matching!");
        	}
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^I click on MHE New Quote$")
    public void click_on_MHE_New_Quote() {
        try {
//            selenium.waitingTime(2000);
            selenium.test.log(LogStatus.INFO, "Click on New Quote");
        	selenium.waitForElementToBeClickable("newQuoteButton");
            selenium.jsClick("newQuoteButton");
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }


    @And("^Select Opportunity name and validate status$")
    public void select_Opportunity_name_and_status() throws Exception {
        try {
//            selenium.waitingTime(3000);
            selenium.waitForElementToBeClickable("approve_quote");
            selenium.click("approve_quote");
//            selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("noApprovalRequired_quote");
            selenium.click("noApprovalRequired_quote");
//            selenium.waitingTime(3000);
            selenium.captureScreenShot();
        	selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("nextButton_quote");
            selenium.click("nextButton_quote");
            selenium.waitingTime(8000);
           /* Select dropdown = new Select(selenium.getElement("opportunityDD"));
            try
            {
//            	dropdown.selectByVisibleText(Opp_Name);
	            selenium.click("opportunityDD");
	            selenium.waitingTime(2000);
	            selenium.clickDynamic("LinkOppStart",Opp_Name, "endContains");
	            selenium.waitingTime(2000);
            }
            catch(Exception e)
            {
            	System.out.println("Opp not found." + Opp_Name);
            	dropdown.selectByIndex(1);
            	selenium.waitingTime(2000);
            }*/
            
			selenium.waitForElementToBeClickable("MHEQuoteNewOppRatioBtn");
			selenium.click("MHEQuoteNewOppRatioBtn");
            Select dropdown = new Select(selenium.getElement("MarketSubject"));
            dropdown.selectByIndex(2);
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
//            selenium.waitForElementToBeClickable("QuoteOppLinkPopupSaveBtn");
//            selenium.waitingTime(4000);
//            selenium.click("QuoteOppLinkPopupSaveBtn");
//            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("next");
            selenium.clickLoop("next");
            selenium.waitingTime(15000);
            String status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Status");
            String statusXpath = selenium.getPropertiesObj().getProperty("status_quote_val").
                    replace("$val", status);
            selenium.waitingTime(60000);
            if(selenium.isElementPresentXpathFast(statusXpath)){
                selenium.test.log(LogStatus.PASS, "Status Matches");
                System.out.println("PASS");
            }else {
                selenium.test.log(LogStatus.FAIL, "Status not Matching");
                selenium.reportFailure("Status not Matching");
                System.out.println("FAIL");
            }
            selenium.scrolldown(-250);
            selenium.captureScreenShot();
        }catch (Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^export the quote excel file$")
    public void export_the_quote_excel_file(DataTable table) throws Exception
    {
    	List<String> data = table.transpose().asList(String.class);
        try
        {
        	if(selenium.getTestCaseName().equalsIgnoreCase("VerifyUpsellProcess"))
        	{
				selenium.waitForElementToBeClickable("QuoteExportBtn");
				selenium.click("QuoteExportBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("QuoteExportSumbitBtn");
				selenium.click("QuoteExportSumbitBtn");
	            selenium.waitingTime(5000);
	            selenium.waitForElementToBeClickable("QuoteExportCloseBtn");
				selenium.click("QuoteExportCloseBtn");
	            selenium.waitingTime(2000);
				selenium.test.log(LogStatus.INFO, "Quote Export Successful!");
	            
				selenium.switchOutOfFrame();
	            selenium.waitingTime(2000);
	            selenium.waitForElementToBeClickable("MHEQuoteEditPageCloseBtn");
	            selenium.click("MHEQuoteEditPageCloseBtn");
        	}
        	else
        	{        	           
				selenium.waitForElementToBeClickable("QuoteExportBtn");
				selenium.click("QuoteExportBtn");
				selenium.waitForElementToBeClickable("QuoteExportOption");
				selenium.click("QuoteExportOption");
				selenium.waitingTime(2000);
				
				//Order From Type
				selenium.selectDropdownText_Data("QuoteExportOption", data.get(0)); 
				Select dropdown = new Select(selenium.getElement("QuoteExportFileFormat"));
	            dropdown.selectByValue("Excel");	//Export Excel File
	            selenium.waitingTime(1000);
				selenium.waitForElementToBeClickable("QuoteExportSumbitBtn");
				selenium.click("QuoteExportSumbitBtn");
	            selenium.waitingTime(5000);
	            
	            dropdown.selectByValue("PDF");	//Export PDF File
	            selenium.waitingTime(1000);
				selenium.waitForElementToBeClickable("QuoteExportSumbitBtn");
				selenium.click("QuoteExportSumbitBtn");
	            selenium.waitingTime(5000);
	            
	            //Proposal Type
				selenium.selectDropdownText_Data("QuoteExportOption", data.get(1)); 
	            dropdown.selectByValue("Excel");	//Excel File
	            selenium.waitingTime(1000);
				selenium.waitForElementToBeClickable("QuoteExportSumbitBtn");
				selenium.click("QuoteExportSumbitBtn");
	            selenium.waitingTime(5000);
	            
	            dropdown.selectByValue("PDF");	//PDF File
	            selenium.waitingTime(1000);
				selenium.waitForElementToBeClickable("QuoteExportSumbitBtn");
				selenium.click("QuoteExportSumbitBtn");
	            selenium.waitingTime(5000);
	            
	            selenium.waitForElementToBeClickable("QuoteExportCloseBtn");
				selenium.click("QuoteExportCloseBtn");
				selenium.test.log(LogStatus.INFO, "Quote Export Successful!");
        	}

        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^email the quote details$")
    public void email_the_quote_details() throws Exception
    {
        try
        {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("QuoteEmailBtn");
			selenium.click("QuoteEmailBtn");
			selenium.waitForElementToBeVisible("QuotetoEmail");
			selenium.getElement("QuotetoEmail").sendKeys("ivan.gomez@mheducation.com.invalid");
			selenium.waitForElementToBeVisible("QuoteEmailSubject");
			selenium.getElement("QuoteEmailSubject").sendKeys("Subject");
			selenium.waitForElementToBeClickable("QuoteSendEmailBtn");
			selenium.click("QuoteSendEmailBtn");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
			{
			selenium.waitForElementToBeClickable("CloseAlertMsgPopup");
			selenium.click("CloseAlertMsgPopup");
			selenium.test.log(LogStatus.PASS, "Email Quote Details Successful!");
			System.out.println("PASS - Email Quote Details Successful!");
			}

			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("homepageTab");
			selenium.waitingTime(2000);
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^I create a new contact for quote$")
    public void I_create_new_contact_for_quote() throws Exception {

        try {
            selenium.waitingTime(6000);
            selenium.defaultframe();
            selenium.switchToMultipleFrame("newAccountFrame");
            System.out.println("switch 1st frame");
            selenium.waitingTime(1000);
            String date = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
            String randomValue = Integer.toString(selenium.getRandomNumber());
            selenium.waitForElementToBeClickable("QuoteName1");
            selenium.click("QuoteName1");
            selenium.typeData("QuoteName1", "myQuote_" + randomValue + "_" + date);
            
            selenium.waitingTime(2000);
            selenium.waitForElementToBeVisible("QuoteTypeField");            
            selenium.click("QuoteTypeField");
      		selenium.waitForElementToBeClickable("QuoteTypeValue");
      		selenium.click("QuoteTypeValue");
      		selenium.waitingTime(2000);

			selenium.waitForElementToBeClickable("MHEQuoteAddContactLink");
			selenium.clickLoop("MHEQuoteAddContactLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("AddContactFirstName");
			selenium.type("AddContactFirstName", "First Name");
			selenium.type("AddContactLastName", "Last Name");

			selenium.scrollToElement("JobFunctionHeading");
			selenium.click("JobFunctionType");
			selenium.click("JobFunctionMoveRightBtn");
//			selenium.waitForElementToBeClickable("QuoteName1");
//            selenium.click("QuoteName1");
//            selenium.typeData("QuoteName1", "myQuote_" + randomValue + "_" + date);

            selenium.waitForElementToBeClickable("Button_Save");
            selenium.click("Button_Save");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.captureScreenShot();
        }
    }

    @And("^validate duplicate contact$")
    public void validate_duplicate_contact() throws Exception {

        try {
            selenium.waitingTime(4000);
//            selenium.click("Button_Save");
            selenium.waitingTime(4000);
            if(selenium.isElementPresentFast("DuplicateContactMsg"))
            {
				selenium.scrollToElement("DuplicateContactMsg");
				selenium.test.log(LogStatus.PASS, "Duplicate Contact Message Appeared!");
				System.out.println("PASS");
				selenium.captureScreenShot();
            }
            else
            {
				selenium.test.log(LogStatus.FAIL, "Duplicate Contact Message Did Not Appear!");
				selenium.reportFailure("Duplicate Contact Message Did Not Appear!");
				selenium.captureScreenShot();
            }

        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.captureScreenShot();
        }
    }

    @And("^get the newly created quotes url$")
    public void get_the_newly_created_quotes_url()
    {
        try
        {
        	selenium.waitForElementToBeVisible("MHEQuotePageInAccounts");
			selenium.waitForElementToBeClickable("FirstTableRecord");
			selenium.clickLoop("FirstTableRecord");
			selenium.newMHEQuoteURl = selenium.getURL();
			System.out.println("Newly created MHE Quote URL is : " + selenium.newMHEQuoteURl);
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^I Create a new Quote$")
    public void I_Create_a_new_Quote() throws Exception {
        try {
            selenium.waitingTime(6000);
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(4000);
            String date = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
            String randomValue = Integer.toString(selenium.getRandomNumber());
            selenium.waitForElementToBeClickable("QuoteName1");
            selenium.click("QuoteName1");
            selenium.typeData("QuoteName1", "myQuote_" + randomValue + "_" + date);
            selenium.waitingTime(2000);

            selenium.waitForElementToBeVisible("QuoteTypeField");            
            selenium.click("QuoteTypeField");
      		selenium.waitForElementToBeClickable("QuoteTypeValue");
      		selenium.click("QuoteTypeValue");
            selenium.waitForElementToBeClickable("contact_quote1");
            selenium.click("contact_quote1");
        	selenium.waitForElementToBeClickable("contact_quoteValue1");
            selenium.click("contact_quoteValue1");
        	selenium.waitForElementToBeClickable("subscription_quote1");
            selenium.click("subscription_quote1");
        	selenium.waitForElementToBeClickable("subscription_quoteValue2");
            selenium.click("subscription_quoteValue2");
        	selenium.waitForElementToBeVisible("coverComments1");
            selenium.typeData("coverComments1", "test cover");
            selenium.typeData("eoqComments1", "testComment");
        	selenium.waitForElementToBeClickable("nextButton");
            selenium.click("nextButton");
            System.out.println("Waiting Waiting....");
            selenium.waitingTime(90000);
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @Then("^navigate to existing approved quote$")
    public void navigate_to_existing_approved_quote() throws Exception
    {
        try
        {
        	selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("globalSearch");
            selenium.click("globalSearch");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("globalsearchadvance");
			selenium.typeData("globalsearchadvance", selenium.newQuoteUniqueName);
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
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired quote");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^validate quote name field while cloning quote$")
    public void validate_quote_name_field_while_cloning_quote() throws Exception
    {
        try
        {
        	
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^validate quote name field while \"([^\"]*)\" quote$")
    public void validate_quote_name_field_while_revising_quote(String action) throws Exception
    {
        try
        {
        	selenium.switchToMultipleFrame("newAccountFrame");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable(action);
            selenium.click(action);
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(4000);
			System.out.println("action is" + action);
			if(action.equals("Clone"))
			{
				selenium.waitForElementToBeClickable("nextButtonValue");
				selenium.click("nextButtonValue");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.switchToMultipleFrame("newAccountFrame");
			}
            selenium.waitForElementToBeClickable("QuoteName1");
            selenium.clearText("QuoteName1");
            selenium.waitingTime(1000);
            selenium.waitForElementToBeClickable("nextButtonValue");
            selenium.click("nextButtonValue");
            selenium.waitingTime(2000);
            if(selenium.isElementPresentFast("QuoteNameMandatoryText"))
            {
				selenium.test.log(LogStatus.PASS, "Quote Name Mandatory Valiation Message Triggered!");
				System.out.println("PASS");
            }
            else
            {
				selenium.test.log(LogStatus.FAIL, "The expected quote name validation message did not trigger!");
				selenium.reportFailure("The expected quote name validation message did not trigger!");
            }
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^verify if export PDF is throwing license error alert popup$")
    public void verify_if_export_PDF_is_throwing_license_error_alert_popup(DataTable table) throws Exception
    {    	
    	List<String> data = table.transpose().asList(String.class);    	
        try
        {
        	selenium.navigateToURL(data.get(0));	//IP1 approved quote
        	selenium.waitingTime(8000);
        	selenium.refresh();
        	selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Review");
			selenium.click("Review");
			selenium.waitingTime(10000);
            selenium.refresh();
            selenium.waitingTime(25000);
            selenium.defaultframe();
            selenium.switchToFrame("newAccountFrame");
            System.out.println("1st frame");
            selenium.waitingTime(2000);
            selenium.switchToFrame("frame_quote");
            System.out.println("2nd frame");
            selenium.waitingTime(5000);
            if(selenium.isElementPresentFast("QuoteExportBtn"))
            {
    			selenium.waitForElementToBeClickable("QuoteExportBtn");
    			selenium.click("QuoteExportBtn");
            }
            else
            {
                selenium.refresh();
                selenium.waitingTime(25000);
                selenium.defaultframe();
                selenium.switchToFrame("newAccountFrame");
                System.out.println("1st frame");
                selenium.waitingTime(2000);
                selenium.switchToFrame("frame_quote");
                System.out.println("2nd frame");
                selenium.waitingTime(5000);
    			selenium.waitForElementToBeClickable("QuoteExportBtn");
    			selenium.click("QuoteExportBtn");
            }
            selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("QuoteExportSumbitBtn");
			selenium.click("QuoteExportSumbitBtn");
            selenium.waitingTime(5000);
            
  		  if(selenium.isAlertPresent())  {
  			  System.out.println("FAIL");
              selenium.reportFailure("The license has expired - alert appeared");
              selenium.test.log(LogStatus.FAIL, "The license has expired - alert appeared");
		  }
  		  
  		  	selenium.waitForElementToBeClickable("QuoteExportCloseBtn");
			selenium.click("QuoteExportCloseBtn");
			selenium.test.log(LogStatus.INFO, "Quote Export Successful!");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^I Add multiple ISBN number$")
    public void I_Add_multiple_ISBN_number() throws Exception
    {    	
        try
        {
        	System.out.println("waiting waiting....");
        	selenium.waitingTime(180000);	//3min
            if(selenium.isElementPresentFast("quoteFrameOpp"))
            {
            	System.out.println("quoteFrameOpp frame present..");
            	selenium.switchToMultipleFrame("quoteFrameOpp");
            	selenium.waitingTime(2000);
                if(selenium.isElementPresentFast("QuoteStartupActivitiesPage"))
                {
                	System.out.println("QuoteStartupActivitiesPage has appeared..");
                    selenium.takeScreenShot();
                	selenium.waitForElementToDisappearForLongtime("QuoteStartupActivitiesPage");
                }
                selenium.switchOutOfFrame();
            }
            selenium.waitingTime(2000);
            selenium.refresh();
            selenium.waitingTime(60000);
            selenium.defaultframe();
            selenium.waitForElementToBeVisible("newAccountFrame");
            selenium.switchToFrame("newAccountFrame");
            System.out.println("1st frame");
            selenium.waitingTime(2000);
            selenium.switchToFrame("frame_quote");
            System.out.println("2nd frame");
            if(selenium.waitForElementToBeClickableLongerDuration("isbnInput")==false)
            {
            	System.out.println("Add ISBN field is not reachable..");
            	selenium.refresh();
            	selenium.waitingTime(120000);
                selenium.defaultframe();
                selenium.waitForElementToBeVisible("newAccountFrame");
                selenium.switchToFrame("newAccountFrame");
                System.out.println("1st frame");
                selenium.waitingTime(2000);
                selenium.switchToFrame("frame_quote");
                System.out.println("2nd frame");
            }
            
            if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
            {
            	System.out.println("IP Server is down..");
            	selenium.click("CloseAlertMsgPopup");
                selenium.waitingTime(2000);
            }
            
            //Adding 1st ISBN
            selenium.waitForElementToBeVisible("isbnInput");
            selenium.type("isbnInput","ISBN1");
            selenium.waitingTime(4000);
//            selenium.captureScreenShot();
//            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("addIsbn");
            selenium.click("addIsbn");
            selenium.waitingTime(4000);            
			if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
			{
			selenium.waitForElementToBeClickable("CloseAlertMsgPopup");
			selenium.click("CloseAlertMsgPopup");
			selenium.test.log(LogStatus.INFO, "Accepted Rep Cost 0 product ISBN!");
			}
            selenium.waitingTime(15000);
            selenium.test.log(LogStatus.INFO, "Added first ISBN!");
            
            //Adding 2nd ISBN
            selenium.waitForElementToBeVisible("isbnInput");
            selenium.type("isbnInput","ISBN2");
            selenium.waitingTime(4000);
//            selenium.captureScreenShot();
//            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("addIsbn");
            selenium.click("addIsbn");
            selenium.waitingTime(4000);            
			if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
			{
			selenium.waitForElementToBeClickable("CloseAlertMsgPopup");
			selenium.click("CloseAlertMsgPopup");
			selenium.test.log(LogStatus.INFO, "Accepted Rep Cost 0 product ISBN!");
			}			
            selenium.waitingTime(15000);
            selenium.test.log(LogStatus.INFO, "Added second ISBN!");			
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

   
    @Then("^capture the newly created quote url$")
    public void capture_the_newly_created_quote_url() throws Exception
    {    	
        try
        {
        	selenium.waitForElementToBeClickable("FirstSampleInOpp");
        	selenium.jsClick("FirstSampleInOpp");
        	selenium.waitingTime(8000);        	
        	selenium.new_QuoteURL = selenium.getURL();        	
        	System.out.println("The quote url is :" + selenium.new_QuoteURL);
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @Then("^capture the newly created opp url$")
    public void capture_the_newly_created_opp_url() throws Exception
    {    	
        try
        {
        	selenium.waitingTime(10000);
			selenium.scrolldown(200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DefaultAdoptionLink2");
			selenium.jsClick("DefaultAdoptionLink2");
        	selenium.waitingTime(8000);
        	selenium.new_QuoteOppURL = selenium.getURL();        	
        	System.out.println("The quote opp url is :" + selenium.new_QuoteOppURL);
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^confirm the user has no access to covert to order$")
    public void confirm_the_user_has_no_access_to_covert_to_order() throws Exception
    {    	
        try
        {
        	selenium.navigateToURL(selenium.new_QuoteURL);
        	selenium.waitingTime(6000);
        	selenium.waitForElementToBeClickable("ConvertToOrderBtn");
        	selenium.click("ConvertToOrderBtn");
        	selenium.waitingTime(8000);
        	selenium.refresh();
        	selenium.waitingTime(8000);
        	System.out.println(selenium.checkElementIsSelectedorNot("ConvertToOrderCheckbox"));
        	Assert.assertFalse(selenium.checkElementIsSelectedorNot("ConvertToOrderCheckbox"));
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^confirm the user has access to covert to order$")
    public void confirm_the_user_has_access_to_covert_to_order() throws Exception
    {    	
        try
        {
        	selenium.navigateToURL(selenium.new_QuoteURL);
        	selenium.waitingTime(6000);
        	selenium.waitForElementToBeClickable("ConvertToOrderBtn");
        	selenium.click("ConvertToOrderBtn");
        	selenium.waitingTime(8000);
        	selenium.refresh();
        	selenium.waitingTime(8000);
        	System.out.println(selenium.checkElementIsSelectedorNot("ConvertToOrderCheckbox"));
        	Assert.assertTrue(selenium.checkElementIsSelectedorNot("ConvertToOrderCheckbox"));
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^capture the catalog price$")
    public void capture_the_catalog_price() throws Exception
    {    	
        try
        {
        	catalogPrice = selenium.getText("CatalogPriceInQuoteISBN");
        	System.out.println("catalogPrice in newly created/approved quote is --> "+ catalogPrice);
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^capture the selling price$")
    public void capture_the_selling_price() throws Exception
    {    	
        try
        {
        	sellingPrice = selenium.getText("SellingPriceInQuoteISBN");
        	System.out.println("sellingPrice in newly created/approved quote is --> "+ sellingPrice);
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^clone the quote and validate catalog price$")
    public void clone_the_quote_and_validate_catalog_price() throws Exception
    {    	
        try
        {
        	if(selenium.getTestCaseName().equalsIgnoreCase("VerifyCatalogPriceInClonedQuoteWithDiscount"))
			 {
				 selenium.navigateToURL(selenium.new_QuoteURL);
				 selenium.waitingTime(10000);
			 }
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ClickOnCloneBtn");
			selenium.click("ClickOnCloneBtn");
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
            System.out.println("waiting waiting....");
            selenium.waitingTime(180000);
            selenium.refresh();
            selenium.waitingTime(25000);
            selenium.defaultframe();
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(2000);
            selenium.switchToFrame("quoteFrameOpp");
            selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("QuoteProductSelectAllChkBox");
        	selenium.click("QuoteProductSelectAllChkBox");
        	selenium.waitingTime(2000);
        	selenium.jsClick("quoteProceedBtn");
            selenium.waitingTime(25000);
            
            if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
            {
            	System.out.println("IP Server is down..");
            	selenium.click("CloseAlertMsgPopup");
            }
            
        	catalogPriceInClonedQuote = selenium.getText("CatalogPriceInQuoteISBN");
        	System.out.println("Catalog Price in newly cloned quote is --> "+ catalogPriceInClonedQuote);
        	
        	Assert.assertEquals(catalogPrice, catalogPriceInClonedQuote);
        	selenium.test.log(LogStatus.PASS, "Catalog Price in cloned quote is matching with original quote");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^clone the quote and validate selling price$")
    public void clone_the_quote_and_validate_selling_price() throws Exception
    {    	
        try
        {
        	sellingPriceInClonedQuote = selenium.getText("SellingPriceInQuoteISBN");
        	System.out.println("Selling Price in newly cloned quote is --> "+ sellingPriceInClonedQuote);
        	
        	Assert.assertEquals(sellingPrice, sellingPriceInClonedQuote);
        	selenium.test.log(LogStatus.PASS, "Selling Price in cloned quote is matching with original quote");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^export the quote excel file for Discount Approval$")
    public void export_the_quote_excel_file_for_Discount_Approval(DataTable table) throws Exception
    {
    	List<String> data = table.transpose().asList(String.class);
        try
        {
        	selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("QuoteExportBtn");
			selenium.click("QuoteExportBtn");
			selenium.waitForElementToBeClickable("QuoteExportOption");
			selenium.click("QuoteExportOption");
			selenium.waitingTime(2000);
			
			//Discount Approval Type
			selenium.selectDropdownText_Data("QuoteExportOption", data.get(0)); 
			Select dropdown = new Select(selenium.getElement("QuoteExportFileFormat"));
            dropdown.selectByValue("Excel");	//Export Excel File
            selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("QuoteExportSumbitBtn");
			selenium.click("QuoteExportSumbitBtn");
            selenium.waitingTime(5000);
            
            dropdown.selectByValue("PDF");	//Export PDF File
            selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("QuoteExportSumbitBtn");
			selenium.click("QuoteExportSumbitBtn");
            selenium.waitingTime(5000);
            
            selenium.waitForElementToBeClickable("QuoteExportCloseBtn");
			selenium.click("QuoteExportCloseBtn");
			selenium.test.log(LogStatus.INFO, "Quote Export Successful!");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^\"([^\"]*)\" the quote with discount checked and verify discount in new quote$")
    public void clone_or_revise_the_quote_with_discount_checked_and_verify_discount_in_new_quote(String Action) throws Exception
    {    	
        try
        {
        	selenium.navigateToURL(selenium.new_QuoteURL);
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("ClickOnCloneBtn");

			if(Action.equals("Clone"))
			{
				selenium.click("ClickOnCloneBtn");
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("nextButtonValue");
				selenium.click("nextButtonValue");
			}
			else
			{
				selenium.click("ReviseQuoteBtn");
			}
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(4000);			
//			selenium.jsClick("DateLink");//this line is required only for internal testing.
			
			//As by default the 'Keep Discount' will be checked in quote record, so we don't need to do enable it for the test GCRM-22766
			//But for the test GCRM-22767 we need to uncheck the 'Keep Discount' check box			
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyDiscountPriceIsNOTMaintainedInClonedandRevisedQuote"))
			{
				if(selenium.isElementPresentFast("KeepDiscountChkboxInQuote"))
				{
					selenium.click("KeepDiscountChkboxInQuote");
					selenium.waitingTime(1000);
				}
			}

			selenium.waitForElementToBeClickable("nextButtonValue");
			selenium.click("nextButtonValue");
            System.out.println("waiting waiting....");
            selenium.waitingTime(180000);
            selenium.refresh();
            selenium.waitingTime(25000);
            selenium.defaultframe();
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(2000);
            selenium.switchToFrame("quoteFrameOpp");
            selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("QuoteProductSelectAllChkBox");
        	selenium.click("QuoteProductSelectAllChkBox");
        	selenium.waitingTime(2000);
        	selenium.jsClick("quoteProceedBtn");
            selenium.waitingTime(25000);
            
            if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
            {
            	System.out.println("IP Server is down..");
            	selenium.click("CloseAlertMsgPopup");
            }
            
			selenium.waitForElementToBeVisible("QuoteDiscountValue");
			String quotepercent = selenium.getText("QuoteDiscountValue");
			System.out.println("quotepercent" + quotepercent);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyDiscountPriceIsNOTMaintainedInClonedandRevisedQuote"))
			{
				if(!quotepercent.contains(selenium.DiscountPercentage)) //15 != 0.00 
				{
					selenium.test.log(LogStatus.PASS, "Discounted Price of IP1 Quotes is NOT maintained while Cloning and Revising for Supplemental and Renewal Quotes if 'Keep Discount' is unchecked");
					System.out.println("PASS");
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Discount value mismatch");
					selenium.reportFailure("Discount value mismatch");
					System.out.println("FAIL");
				}
			}
			else
			{
				if(quotepercent.contains(selenium.DiscountPercentage)) //15 = 15.00 so using contains here
				{
					selenium.test.log(LogStatus.PASS, "Discounted Price of IP1 Quotes is maintained while Cloning and Revising for Supplemental and Renewal Quotes if 'Keep Discount' is checked");
					System.out.println("PASS");
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Discount value mismatch");
					selenium.reportFailure("Discount value mismatch");
					System.out.println("FAIL");
				}	
			}
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^\"([^\"]*)\" the quote$")
    public void clone_or_revise_the_quot(String Action) throws Exception
    {    	
        try
        {
        	selenium.navigateToURL(selenium.new_QuoteURL);
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("ClickOnCloneBtn");

			if(Action.equals("Clone"))
			{
				selenium.click("ClickOnCloneBtn");
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("nextButtonValue");
				selenium.click("nextButtonValue");
			}
			else
			{
				selenium.click("ReviseQuoteBtn");
			}
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(4000);						

			selenium.waitForElementToBeClickable("nextButtonValue");
			selenium.click("nextButtonValue");
            System.out.println("waiting waiting....");
            selenium.waitingTime(180000);
            selenium.refresh();
            selenium.waitingTime(25000);
            selenium.defaultframe();
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(2000);
            selenium.switchToFrame("quoteFrameOpp");
            selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("QuoteProductSelectAllChkBox");
        	selenium.click("QuoteProductSelectAllChkBox");
        	selenium.waitingTime(2000);
        	selenium.jsClick("quoteProceedBtn");
            selenium.waitingTime(25000);
            
            if(selenium.isElementPresentFast("CloseAlertMsgPopup"))
            {
            	System.out.println("IP Server is down..");
            	selenium.click("CloseAlertMsgPopup");
            }
            
            Assert.assertTrue(selenium.isElementPresentFast("isbnInput"));
            selenium.test.log(LogStatus.PASS, "IP1 user is able to " + Action + " the Quote");
            
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^validate the quote expireation date$")
    public void validate_the_quote_expireation_date() throws Exception
    {    	
        try
        {
        	selenium.navigateToURL(selenium.new_QuoteURL);
        	selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(8000);
            selenium.switchToFrame("newAccountFrame");
			selenium.waitingTime(2000);
        	selenium.waitForElementToBeVisible("QuoteExpirationDate");
        	String ExpirationDate = selenium.getText("QuoteExpirationDate");
        	System.out.println("ExpirationDate -->" + ExpirationDate);
        	
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm a");
            LocalDate parsedDate = LocalDate.parse(ExpirationDate, formatter);
            System.out.println("Quote Expiration Date is --> " + parsedDate);
            
            LocalDate currentDate = LocalDate.now();
            System.out.println("Today's Date: " + currentDate);
            
            long daysDifference = ChronoUnit.DAYS.between(currentDate, parsedDate);
            System.out.println("daysDifference: " + daysDifference);
            
            String ExpiryDays = Long.toString(daysDifference);
            System.out.println("ExpiryDays: " + ExpiryDays);
        	System.out.println("Quote approved month is--> " + currentDate.getMonth());
            
            //Validate that the Quotes approved/priced between October 1st and April 30th would have a 120-day expiration window - GCRM-16354
            if(currentDate.getMonth() == Month.MAY || currentDate.getMonth() == Month.JUNE || currentDate.getMonth() == Month.JULY || currentDate.getMonth() == Month.AUGUST || currentDate.getMonth() == Month.SEPTEMBER)
            {
	            if(ExpiryDays.equals("90") || ExpiryDays.equals("89")) //there will be one day difference in Indian local server and US server timing to manage that I am adding OR condition in this.
	            {
	            	System.out.println("PASS.");
	            	selenium.test.log(LogStatus.PASS, "The following validation passed - Validate that the Quotes approved/priced between May 1st and September 30th would have a 90-day expiration window - GCRM-16356");
	            }
	            else
	            {
	            	System.out.println("FAIL.");
	                selenium.reportFailure("The following validation failed - Validate that the Quotes approved/priced between May 1st and September 30th would have a 90-day expiration window - GCRM-16356");
	                selenium.test.log(LogStatus.FAIL, "The following validation failed - Validate that the Quotes approved/priced between May 1st and September 30th would have a 90-day expiration window - GCRM-16356");
	            }
            } 
            //Validate that the Quotes approved/priced between May 1st and September 30th would have a 90-day expiration window - GCRM-16356
            else if(currentDate.getMonth() == Month.OCTOBER || currentDate.getMonth() == Month.NOVEMBER || currentDate.getMonth() == Month.DECEMBER || currentDate.getMonth() == Month.JANUARY || currentDate.getMonth() == Month.FEBRUARY || currentDate.getMonth() == Month.MARCH || currentDate.getMonth() == Month.APRIL)
            {
	            if(ExpiryDays.equals("120") || ExpiryDays.equals("119"))
	            {
	            	System.out.println("PASS");
	            	selenium.test.log(LogStatus.PASS, "The following validation passed - Validate that the Quotes approved/priced between October 1st and April 30th would have a 120-day expiration window");
	            }
	            else
	            {
	            	System.out.println("FAIL");
	                selenium.reportFailure("The following validation failed - Validate that the Quotes approved/priced between October 1st and April 30th would have a 120-day expiration window");
	                selenium.test.log(LogStatus.FAIL, "The following validation failed - Validate that the Quotes approved/priced between October 1st and April 30th would have a 120-day expiration window");
	            }
            }
        	
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^validate total selling price after made quantity as zero for one product and FWO is disabled$")
    public void validate_total_selling_price_after_made_quantity_as_zero_for_one_product() throws Exception
    {    	
        try
        {
            //Verify if FWO__c == False, then Total Selling Price = Selling_Price__c * Quantity__c on the Quote Line record - GCRM-15761
    		selenium.waitForElementToBeClickable("editQuoteLine");
            selenium.click("editQuoteLine");
            selenium.waitingTime(10000);
    		selenium.waitForElementToBeVisible("lineItemQuantity");
            selenium.clearText("lineItemQuantity");
            selenium.typeData("lineItemQuantity","0");
    		selenium.waitForElementToBeClickable("saveQuoteLine");
            selenium.jsClick("saveQuoteLine");
            selenium.waitingTime(8000);
            selenium.test.log(LogStatus.INFO, "Edited Quantity");            
            String sellingPriceof2ndISBN = selenium.getText("SellingPriceInQuoteSecondISBN");
            System.out.println("Selling Price of 2nd ISBN is -->" + sellingPriceof2ndISBN);            
            String grandTotalprice = selenium.getText("grandTotalprice");
            System.out.println("grandTotalprice is -->" + grandTotalprice);            
            Assert.assertEquals(sellingPriceof2ndISBN, grandTotalprice);
            selenium.test.log(LogStatus.PASS, "Grand total is same as the selling price of Product2");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^validate the quote name format$")
    public void validate_the_quote_name_format() throws Exception
    {    	
        try
        {
			selenium.waitingTime(4000);
        	selenium.refresh();
        	selenium.waitingTime(15000);
        	selenium.switchToMultipleFrame("newAccountFrame");
        	selenium.waitForElementToBeVisible("NewQuoteNumber");
        	String QuoteNumber = selenium.getText("NewQuoteNumber");
        	String UniqueQuoteNumber = selenium.getText("NewQuoteUniqueNumber");
        	System.out.println("QuoteNumber is --> " + QuoteNumber + " UniqueQuoteNumber --> " + UniqueQuoteNumber);
        	
//		 	Calendar calendar1 = Calendar.getInstance();
//			Date date = calendar1.getTime();
//			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
//			String todaysDate = sdf1.format(date);
//			System.out.println("todaysDate is --> " + todaysDate);
//			String dateWithoutSlashes = todaysDate.replace("/", "");
//			System.out.println("dateWithoutSlashes is --> " + dateWithoutSlashes); // Output: "10252023"
			
//			String QuoteOwnerName = "IGOMEZ-";
//			String QuoteSuffixNumber ="-001";
//			String QuoteUniqueSuffixNumber ="-001-0";
			
			String QuoteNumberPattern = "^[A-Z]{6}-\\d{12}(?:\\d{2})?-\\d{3}$";		//Quote Number: IGOMEZ-10252023020552-001
			Pattern regexPattern1 = Pattern.compile(QuoteNumberPattern);
			Matcher matcher1 = regexPattern1.matcher(QuoteNumber);
			
			String QuoteUniqueNumberPattern = "^[A-Z]{6}-\\d{12}(?:\\d{2})?-(\\d{3})-(\\d{1})$";	//Unique Quote Number: IGOMEZ-10252023020552-001-0
			Pattern regexPattern2 = Pattern.compile(QuoteUniqueNumberPattern);
			Matcher matcher2 = regexPattern2.matcher(UniqueQuoteNumber);

			
//			if(QuoteNumber.contains(dateWithoutSlashes) && QuoteNumber.contains(QuoteOwnerName) && QuoteNumber.contains(QuoteSuffixNumber) && UniqueQuoteNumber.contains(dateWithoutSlashes) && UniqueQuoteNumber.contains(QuoteOwnerName) && UniqueQuoteNumber.contains(QuoteUniqueSuffixNumber))
			if (matcher1.matches() && matcher2.matches())
			{
            	System.out.println("PASS");
            	selenium.test.log(LogStatus.PASS, "The following validation passed - Verify that when the new quote is created, the data saved in the field \"Quote Number\" is saved in new format.");
            }
            else
            {
            	System.out.println("FAIL");
                selenium.reportFailure("The following validation failed - Verify that when the new quote is created, the data saved in the field \"Quote Number\" is saved in new format.");
                selenium.test.log(LogStatus.FAIL, "The following validation failed - Verify that when the new quote is created, the data saved in the field \"Quote Number\" is saved in new format.");
            }
        	
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^validate the linked opp has got only the products with quantity$")
    public void validate_the_linked_opp_has_got_only_the_products_with_quantity() throws Exception
    {    	
        try
        {
        	selenium.waitForElementToBeClickable("DefaultAdoptionLink3");
        	selenium.jsClick("DefaultAdoptionLink3");
        	selenium.waitingTime(5000);
        	selenium.switchOutOfFrame();
        	quoteOpp_URL = selenium.getURL();
        	System.out.println("quoteOpp_URL is -->" + quoteOpp_URL);
        	selenium.waitingTime(5000);
        	selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
        	selenium.jsClick("opportunityLineItemRelatedList");
        	selenium.waitingTime(5000);
        	
			String ZeroQuantityProductXpath = selenium.getDynamicXpath("anchorTitlecontains", "ISBN1" , "endContains");
			System.out.println("ZeroQuantityProductXpath -->" + ZeroQuantityProductXpath);
			
			if(selenium.isElementPresentXpathFast(ZeroQuantityProductXpath)) {
				System.out.println("FAIL");
	            selenium.reportFailure("Zero quantity product is present in Opp");
	            selenium.test.log(LogStatus.FAIL, "Zero quantity product is present in Opp");
			}
			else
			{
				System.out.println("PASS");
	            selenium.test.log(LogStatus.PASS, "Zero quantity product is NOT present in Opp");
			}
			
			////Verify if the Quote Lines on Quote have the sum total of 0, the Targeted Products on Opportunity will NOT get updated - GCRM-15758
			String NonZeroQuantityProductXpath = selenium.getDynamicXpath("anchorTitlecontains", "ISBN2" , "endContains");
			System.out.println("NON-ZeroQuantityProductXpath -->" + NonZeroQuantityProductXpath);
			
			if(selenium.isElementPresentXpathFast(NonZeroQuantityProductXpath)) {
				System.out.println("PASS");
	            selenium.test.log(LogStatus.PASS, "Non Zero quantity product is present in Opp");
			}
			else
			{
				System.out.println("FAIL");
	            selenium.reportFailure("Non Zero quantity product is Not present in Opp");
	            selenium.test.log(LogStatus.FAIL, "Non Zero quantity product is Not present in Opp");
			}
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^validate total selling price when FWO is enabled$")
    public void validate_total_selling_price_after_enabled_FWO() throws Exception
    {    	
        try
        {
            //Verify if FWO__c == True, then Total Selling Price = 0 on the Quote Line record - GCRM-15764   
    		selenium.waitForElementToBeClickable("editQuoteLine2");
            selenium.click("editQuoteLine2");
            selenium.waitingTime(10000);
    		selenium.waitForElementToBeVisible("FWOCheckBoxInQuoteProduct");
            selenium.click("FWOCheckBoxInQuoteProduct");
    		selenium.waitForElementToBeClickable("saveQuoteLine");
            selenium.jsClick("saveQuoteLine");
            selenium.waitingTime(8000);
            selenium.test.log(LogStatus.INFO, "Enabled FWO checkbox");
            String grandTotalprice = selenium.getText("grandTotalprice");
            System.out.println("grandTotalprice is -->" + grandTotalprice);            
            Assert.assertEquals(grandTotalprice, "$0.00");
            selenium.test.log(LogStatus.PASS, "Grand total is Zero when FWO is enabled");
            
            //Disabling FWO checkbox again for next test step validation
    		selenium.waitForElementToBeClickable("editQuoteLine2");
            selenium.click("editQuoteLine2");
            selenium.waitingTime(10000);
    		selenium.waitForElementToBeVisible("FWOCheckBoxInQuoteProduct");
            selenium.click("FWOCheckBoxInQuoteProduct");
    		selenium.waitForElementToBeClickable("saveQuoteLine");
            selenium.jsClick("saveQuoteLine");
            selenium.waitingTime(8000);
            selenium.test.log(LogStatus.INFO, "Disabled FWO checkbox");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @Then("^I create a new unique contact for quote$")
    public void I_create_new_unique_contact_for_quote() throws Exception {

        try {
        	String LastName = selenium.getRandomString();
      		selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("MHEQuoteAddContactLink");
			selenium.clickLoop("MHEQuoteAddContactLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("AddContactFirstName");
			selenium.type("AddContactFirstName", "First Name");
			selenium.typeData("AddContactLastName", LastName);
//			selenium.scrollToElement("JobFunctionHeading");
//			selenium.click("JobFunctionType");
//			selenium.click("JobFunctionMoveRightBtn");
			selenium.waitingTime(2000);
            selenium.click("Button_Save");
      		selenium.waitingTime(10000);
      		Assert.assertTrue(selenium.waitForElementToBeClickable("MHEQuoteAddContactLink"));
      		selenium.test.log(LogStatus.PASS, "New Contact for Quote has been created successfully!");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @Then("^verify site under maintenance message$")
    public void verify_site_under_maintenance_message() throws Exception {

        try {
        	if(selenium.new_QuoteURL != null)
        	{
        		System.out.println("IF Block");
            	selenium.navigateToURL(selenium.new_QuoteURL);
        	}
        	else
        	{
        		System.out.println("ELSE Block");
        		selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Quote__c/a251A000000FyCTQA0/view");
        	}
        	selenium.waitingTime(4000);
        	selenium.refresh();
        	selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
        	selenium.waitForElementToBeVisible("Clone");
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
			selenium.waitingTime(4000);
        	selenium.waitForElementToBeVisible("QuoteSiteUnderMaintenanceMsg");
        	if(selenium.isElementPresentFast("QuoteSiteUnderMaintenanceMsg"))
        	{
				System.out.println("PASS");
	            selenium.test.log(LogStatus.PASS, "Quote site is currently under maintenance - message appeared");
			}
			else
			{
				System.out.println("FAIL");
	            selenium.reportFailure("Quote site is currently under maintenance - message did not appear");
	            selenium.test.log(LogStatus.FAIL, "Quote site is currently under maintenance - message did not appear");
			}
        	
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^update under maintenance field$")
    public void update_under_maintenance_field() throws Exception {

        try {
            selenium.waitingTime(10000);
            selenium.refresh();
            selenium.waitingTime(10000);
            selenium.defaultframe();
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("QuoteMaintenanceBtn");
            selenium.click("QuoteMaintenanceBtn");
			selenium.waitingTime(5000);
            selenium.refresh();
            selenium.waitingTime(10000);
            selenium.defaultframe();
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("QuoteUnderMaintenanceChkBx");
            selenium.click("QuoteUnderMaintenanceChkBx");
			selenium.waitingTime(2000);
            selenium.click("Button_Save");
			selenium.waitingTime(5000);			
            selenium.waitForElementToBeClickable("QuoteUnderMaintenanceSuccessPopup");
            selenium.click("QuoteUnderMaintenanceSuccessPopup");
			selenium.waitingTime(5000);
			 selenium.test.log(LogStatus.INFO, "Quote - Under Maintenance Status Updated!");
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^verify Stage Reason and Primary Funding Type field values in opp$")
    public void verify_Stage_Reason_and_Primary_Funding_Type_field_values_in_opp() throws Exception
    {    	
        try
        {
        	selenium.navigateToURL(quoteOpp_URL);
        	selenium.waitingTime(10000);
        	selenium.waitForElementToBeVisible("Opp_StageValue");
        	String Stage = selenium.getText("Opp_StageValue");
        	String Reason = selenium.getText("Opp_ReasonValue");
        	String PrimaryFundingField = selenium.getText("Opp_PrimaryFundingValue");
        	System.out.println("Stage --> " +Stage + " Reason --> " + Reason + " PrimaryFundingField --> " + PrimaryFundingField);
        	if(Stage.equalsIgnoreCase("Won") && Reason.equalsIgnoreCase("Due to Messaging/Presentation") && PrimaryFundingField.equalsIgnoreCase("Title I"))
        	{
				System.out.println("PASS");
	            selenium.test.log(LogStatus.PASS, "The Stage, Reason & Primary Funding field values in Opp are same as original Quote values");
			}
			else
			{
				System.out.println("FAIL");
	            selenium.reportFailure("The expected values are not matching");
	            selenium.test.log(LogStatus.FAIL, "The expected values are not matching");
			}
        }
        catch (Exception e)
        {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
}