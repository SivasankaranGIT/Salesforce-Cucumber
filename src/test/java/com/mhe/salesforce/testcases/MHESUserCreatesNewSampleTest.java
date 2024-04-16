package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MHESUserCreatesNewSampleTest {
	WebConnector selenium = WebConnector.getInstance();
	String url;
	
	@And("^I switch to SalesChatter home page$")
    public void switchToSalesHomePage() {
		try {
		selenium.waitingTime(5000);
		if (selenium.isElementPresentFast("CXGApp"))
		{
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.getElement("searchItemsTextField").sendKeys("Sales");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Saleslightningapp");
			selenium.jsClick("Saleslightningapp");
			selenium.waitingTime(8000);
		}
		selenium.waitForElementToBeClickable("menuDots");
        selenium.click("menuDots");
        selenium.waitingTime(4000);
        selenium.waitForElementToBeClickable("AllButtonLNEW");
        selenium.click("AllButtonLNEW");
        selenium.waitingTime(4000);
        selenium.type("searchallitems", "Screen Name");
        selenium.waitingTime(2000);
        selenium.waitForElementToBeClickable("salesChatterHomePage");
        selenium.clickLoop("salesChatterHomePage");
        selenium.waitingTime(4000);
        selenium.test.log(LogStatus.INFO, "Sales Chatter Home Page loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
    }
	
	@Then("^I create new sample from Opportunity$")
    public void create_sample()  {
		try {
			
			selenium.search("Opportunity Name");
			selenium.waitingTime(3000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name", "endContains");
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(10000);
			selenium.takeScreenShot();
			url=selenium.getURL();
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("newSampleFromOpportunity");
			selenium.jsClick("newSampleFromOpportunity");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("sampleContact");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);			
			selenium.selectDropdownText("contactSampleDropDwn", "Contact");
			selenium.waitingTime(2000);

			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow=calendar.getTime();
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(tomorrow);
			System.out.println(todaysdate);
			selenium.scrollToElement("futureProcessDateText");
			selenium.typeData("futureProcessDateText", todaysdate);
			selenium.typeData("backOrderCancelDateText", todaysdate);
			selenium.scrollToElement("pilotEndDateText");
			selenium.typeData("pilotEndDateText", todaysdate);
			
			selenium.scrollToElement("NxtButton");
			selenium.jsClick("NxtButton");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("keyISBNText");
			
			selenium.type("keyISBNText", "ISBN");
			selenium.waitForElementToBeClickable("addButton");
			selenium.click("addButton");
//			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("productCheckBox");
			selenium.click("productCheckBox");
			selenium.scrollToElement("NxtButton");
			selenium.jsClick("NxtButton");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("notesSample");
			
			selenium.type("notesSample", "Notes");
			selenium.scrollToElement("NxtButton");
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("createSampleOrderBtn");
			
			selenium.click("createSampleOrderBtn");
			selenium.waitingTime(3000);
			
			if(selenium.isElementPresentFast("duplicateSamplesPopup")==true) {
				selenium.waitForElementToBeClickable("createSamples");
				selenium.jsClick("createSamples");
				selenium.waitingTime(5000);
			}
			
			//selenium.scrollToElement("accntTypeGetText");
			String sampleID = selenium.getText("sampleIDSuccess").toString();
			//expected_accountType = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Type");
			selenium.waitForElementToBeClickable("closeOnOrderPadWindow");
			selenium.click("closeOnOrderPadWindow");
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();
			
			selenium.navigateToURL(url);
			selenium.waitingTime(4000);
			
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("sampleLinkFromOpportunities");
				selenium.click("sampleLinkFromOpportunities");
			} else {
				selenium.waitForElementToBeClickable("sampleLinkFromOpportunities");
				selenium.click("sampleLinkFromOpportunities");
			}
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("spanTagContainsSampleList", "Contact", "endContains");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("sampleIDGetText");
			
			selenium.scrollToElement("sampleIDGetText");
			String id = selenium.getText("sampleIDGetText").toString();
			if(sampleID.contains(id)) {
				selenium.test.log(LogStatus.PASS, "New Sample created successfully");
				System.out.println("PASS");
			}
			else {
				selenium.test.log(LogStatus.FAIL, "New Sample creation failed");
				System.out.println("FAIL");
				selenium.reportFailure("New Sample creation failed");
			}
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Error while navigating to opportunity");
				selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
			}

	}

}
