package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHESCreatesConsultantRequestTest {

	WebConnector selenium = WebConnector.getInstance();
	String todaysDate;

	@And("^create Consultant Request Form for account")
	public void create_Consultant_Request_Form_account() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(3000);

				String opp = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
				selenium.waitingTime(2000);
				System.out.println(opp);
				selenium.clickLoopXpath(opp);
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("showAllLinks"))
				{
					selenium.waitForElementToBeClickable("showAllLinks");
					selenium.click("showAllLinks");				
				}
				else
				{
					selenium.refresh();
					selenium.waitingTime(15000);
					selenium.waitForElementToBeClickable("showAllLinks");
					selenium.click("showAllLinks");				
				}
				selenium.waitingTime(2000);	
				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
					selenium.waitForElementToBeClickable("consultantRequestLink");
					selenium.click("consultantRequestLink");
				} else {
					selenium.waitForElementToBeClickable("consultantRequestLink");
					selenium.click("consultantRequestLink");
				}
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("NewActionButton");
				selenium.clickLoop("NewActionButton");

				selenium.clickDynamic("spantextContains", "Record Type", "endRadioBtn");
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.click("nextBtn");

				selenium.waitingTime(4000);
//				selenium.waitForElementToBeVisible("newCRFIframe");
				selenium.switchToMultipleFrame("newCRFIframe");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("crfType");

				selenium.selectDropdownText("crfType", "Type");
				selenium.waitingTime(2000);

				Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();

				SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				todaysDate = sdf1.format(date);
				System.out.println(todaysDate);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("crfPresentationDate");
				selenium.typeData("crfPresentationDate", todaysDate);
				selenium.typeData("crfAlternateDate1", todaysDate);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("crfAlternateDate2");
				selenium.typeData("crfAlternateDate2", todaysDate);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("crfPresentationStartTime");

				selenium.scrollToElement("crfPresentationStartTime");
				selenium.selectDropdownText("crfPresentationStartTime", "PresentationStartTime");
				selenium.selectDropdownText("crfPresentationEndTime", "PresentationEndTime");
				selenium.selectDropdownText("crfPresentationTimeZone", "PresentationTimeZone");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("crfPresentationTime");
				selenium.jsClick("crfPresentationTime");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("crfConsultantsNeeded");

				selenium.type("crfConsultantsNeeded", "ConsultantsNeeded");
				selenium.type("crfPrimaryContactNumber", "PrimaryContactNumber");

				selenium.scrollToElement("crfProgramCopyRightProgramlevels");
				selenium.type("crfProgramCopyRightProgramlevels", "ProgramCopyRightProgramlevels");
//				selenium.waitingTime(2000);
				selenium.type("DollerAmount", "Doller Amount");
				selenium.waitForElementToBeVisible("presentationTypes");
				//selenium.moveTab("presentationTypes");
				Select dropdown = new Select(selenium.getElement("presentationTypes"));
	            
	            dropdown.selectByValue("1");
				//selenium.selectDropdownText("presentationTypes", "Presentation Type");
	            selenium.waitForElementToBeClickable("crfArrowToMove");
				selenium.clickLoop("crfArrowToMove");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("crfDistrickMeetingType");
				selenium.type("crfDistrickMeetingType", "DistrickMeetingType");
                selenium.selectDropdownText("webinarinperson", "WebinarInPerson");
				selenium.scrollToElement("crfNoOfParticipant");
				selenium.type("crfNoOfParticipant", "NoOfParticipant");

				selenium.type("crfPresentationDescription", "PresentationDescription");

//				selenium.type("linkedOpportunityText", "Linked Opportunity");
				selenium.click("CRFLinkOppLookupIcon");
				selenium.waitingTime(2000);
				selenium.switchToChildWindow();
				selenium.waitingTime(2000);
				selenium.switchToFrame("CRFLinkFirstOppFrame");
				selenium.waitForElementToBeClickable("CRFLinkFirstOppName");
				selenium.click("CRFLinkFirstOppName");
				selenium.waitingTime(2000);
				selenium.switchBackToParentWindow();
				selenium.waitingTime(2000);
				selenium.switchToMultipleFrame("newCRFIframe");
				selenium.waitingTime(2000);
				selenium.type("crfSiteAddress", "SiteAddress");
				selenium.type("crfSiteCity", "SiteCity");
				selenium.selectDropdownText("crfSiteState", "SiteState");
				selenium.type("crfSitePostalCode", "SitePostalCode");

				selenium.type("crfPresentationSite", "PresentationSite");
				selenium.type("crfSitePhone", "SitePhone");
				selenium.type("crfSiteContactName", "SiteContactName");
				selenium.type("crfSiteContactEmail", "SiteContactEmail");

				selenium.type("crfAirportName", "AirportName");
				selenium.type("crfAirportCityState", "AirportCityState");
				selenium.type("crfTravelTime", "TravelTime");
				selenium.scrollToElement("crfSaveClose");
				selenium.clickLoop("crfSaveClose");
				selenium.waitingTime(2000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(5000);

			}
		} catch (Exception e) {

			selenium.scrollToElement("crfCancel");
			selenium.clickLoop("crfCancel");
			selenium.switchOutOfFrame();
		}
	}

	@Then("^check status of CRF$")
	public void check_status_of_CRF() {

		try {

			// selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Consultant_Request__c/a2cf0000006X33jAAC/view");
			selenium.switchToMultipleFrame("newCRFIframe");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("submitToSchedulerBtn");
			selenium.click("submitToSchedulerBtn");
			selenium.waitingTime(2000);
			selenium.acceptAlert();
			selenium.switchOutOfFrame();
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeVisible("newCRFIframe");

			selenium.switchToFrame("newCRFIframe");
			String statusUI = selenium.getText("crfStatus").toString();
			String expected_expected = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Status");
			System.out.println("Result :" + statusUI + expected_expected);
			if (statusUI.equalsIgnoreCase(expected_expected)) {
				selenium.test.log(LogStatus.PASS, "CRF Status is: " + statusUI);
				System.out.println("PASS");
			} else {
				selenium.test.log(LogStatus.FAIL, "CRF could not be submitted");
				System.out.println("FAIL");
				selenium.reportFailure("CRF could not be submitted");
			}
			selenium.switchOutOfFrame();
			
		} catch (Exception e) {
			selenium.switchOutOfFrame();
		}
	}

}
