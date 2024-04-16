package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ConsultantRequestTest {

    WebConnector selenium = WebConnector.getInstance();
     public String newconsultantform="https://mh--uat.sandbox.lightning.force.com/lightning/o/Consultant_Request__c/new?recordTypeId=012C0000000HkY8IAK&additionalParams=&inContextOfRef=1.eyJ0eXBlIjoic3RhbmRhcmRfX29iamVjdFBhZ2UiLCJhdHRyaWJ1dGVzIjp7Im9iamVjdEFwaU5hbWUiOiJDb25zdWx0YW50X1JlcXVlc3RfX2MiLCJhY3Rpb25OYW1lIjoibGlzdCJ9LCJzdGF0ZSI6eyJmaWx0ZXJOYW1lIjoiUmVjZW50In19&count=1";
     String todaysDate;
    @Then("^Navigate to new consultant page$")
    public void navigateToNewConsultantPage() {

        try {
        	selenium.navigateToURL(newconsultantform);
        	selenium.waitingTime(8000);
           
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
        
    }

    @Then("^enter all mandatory fields except email$")
    public void enterAllMandatoryFields() {

        try {
        	selenium.refresh();
        	selenium.waitingTime(8000);
        	selenium.switchToMultipleFrame("newCRFIframe");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("crfType");
			selenium.waitingTime(4000);
			selenium.selectDropdownText("crfType", "Type");
			selenium.waitingTime(2000);

			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();

			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			todaysDate = sdf1.format(date);
			System.out.println(todaysDate);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("PresentationDate");
			selenium.typeData("PresentationDate", todaysDate);
			selenium.typeData("crfAlternateDate1", todaysDate);
           selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("crfAlternateDate2");
			selenium.typeData("crfAlternateDate2", todaysDate);
          selenium.waitingTime(4000);
          if(selenium.getTestCaseName().equals("verifyrequestorandmanagerconsultant"))
          {
        	  selenium.type("CRFManager", "managerName");
          }
			selenium.waitForElementToBeVisible("crfPresentationStartTime");

			selenium.scrollToElement("crfPresentationStartTime");
			selenium.selectDropdownText("crfPresentationStartTime", "PresentationStartTime");
			selenium.selectDropdownText("crfPresentationEndTime", "PresentationEndTime");
			selenium.selectDropdownText("crfPresentationTimeZone", "PresentationTimeZone");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("crfPresentationTime");
			selenium.jsClick("crfPresentationTime");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("crfConsultantsNeeded");

			selenium.type("crfConsultantsNeeded", "ConsultantsNeeded");
			selenium.type("crfPrimaryContactNumber", "PrimaryContactNumber");

			selenium.scrollToElement("crfProgramCopyRightProgramlevels");
			selenium.type("crfProgramCopyRightProgramlevels", "ProgramCopyRightProgramlevels");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("presentationTypes");
			//selenium.moveTab("presentationTypes");
			Select dropdown = new Select(selenium.getElement("presentationTypes"));
            
            dropdown.selectByValue("1");
			//selenium.selectDropdownText("presentationTypes", "Presentation Type");
            selenium.waitForElementToBeClickable("crfArrowToMove");
			selenium.clickLoop("crfArrowToMove");
			selenium.waitingTime(4000);
		    selenium.type("DollarPotentialPurchase", "DollarPotentialPurchase");	
			selenium.waitForElementToBeVisible("crfDistrickMeetingType");
			selenium.type("crfDistrickMeetingType", "DistrickMeetingType");
            selenium.selectDropdownText("webinarinperson", "WebinarInPerson");
			selenium.scrollToElement("crfNoOfParticipant");
			selenium.type("crfNoOfParticipant", "NoOfParticipant");

			selenium.type("crfPresentationDescription", "PresentationDescription");
			if(selenium.getTestCaseName().equals("verifyopportunityconsultant"))
			{
				selenium.type("linkedOpportunityText", "InvalidLinked Opportunity");
			}else {
			selenium.type("linkedOpportunityText", "Linked Opportunity");
			}
			selenium.type("crfSiteAddress", "SiteAddress");
			selenium.type("crfSiteCity", "SiteCity");
			selenium.selectDropdownText("crfSiteState", "SiteState");
			selenium.type("crfSitePostalCode", "SitePostalCode");

			selenium.type("crfPresentationSite", "PresentationSite");
			selenium.type("crfSitePhone", "SitePhone");
			selenium.type("crfSiteContactName", "SiteContactName");
			if(selenium.getTestCaseName().equals("verifyemailconsultant"))
			{		
			selenium.type("crfSiteContactEmail", "SiteContactEmail");
			}
			else {
				selenium.type("crfSiteContactEmail", "SiteContactEmailvalid");
			}
			selenium.type("crfAirportName", "AirportName");
			selenium.type("crfAirportCityState", "AirportCityState");
			selenium.type("crfTravelTime", "TravelTime");
			selenium.scrollToElement("crfSaveClose");
			selenium.waitForElementToBeClickable("crfSaveClose");
			selenium.clickLoop("crfSaveClose");
			if(selenium.getTestCaseName().equals("verifyopportunityconsultant"))
			{
				selenium.type("DollarPotentialPurchase", "DollarPotentialPurchase");
				selenium.clickLoop("crfSaveClose");
			
			}
           selenium.waitingTime(2000);
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
     //   selenium.switchOutOfFrame();
        selenium.waitingTime(2000);
    }

    

    @Then("^Verify Invalid email/opportunityLinked error message$")
    public void verifyInvalidemail() {

        try {

        	selenium.waitingTime(2000);
    		String error = null;
    		String expected_error=null;
    		if (selenium.getUI().contains("Lightning")) {
    			error = selenium.getText("MessageText");
    		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
    		selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
    		if(error.contains(expected_error)) {
    			
    			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
    			System.out.println("PASS");
    		}
    		else {
    			//selenium.click("CancelEdit");
    			selenium.reportFailure("Test Case Failed");
    			System.out.println("FAIL");
    		}
}
        }catch(Exception e)
        {
        	selenium.reportFailure(e.getMessage());
        	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @Then("^enter valid email and Opportunity save$")
    public void enterValidemail() {

        try {

        	selenium.waitingTime(2000);
        	if(selenium.getTestCaseName().equals("verifyemailconsultant"))
        	selenium.type("crfSiteContactEmail", "SiteContactEmailvalid");
        	if(selenium.getTestCaseName().equals("verifyopportunityconsultant"))
        	selenium.type("linkedOpportunityText", "Linked Opportunity");
        	selenium.clickLoop("crfSaveClose");
        	selenium.waitingTime(2000);
        	selenium.switchOutOfFrame();
}
        catch(Exception e)
        {
        	selenium.switchOutOfFrame();
        	selenium.reportFailure(e.getMessage());
        	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @Then("^Verify Invalid opportunitylinked error message$")
    public void verifyOpportunityLinked() {

        try {

        	
        	selenium.waitingTime(2000);
        	selenium.type("crfSiteContactEmail", "SiteContactEmailvalid");
        	selenium.clickLoop("crfSaveClose");
        	selenium.waitingTime(2000);
    		String error = null;
    		String expected_error=null;
    		if (selenium.getUI().contains("Lightning")) {
    			error = selenium.getText("MessageText");
    		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
    		selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
    		if(error.contains(expected_error)) {
    			
    			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
    			
    		}
    		else {
    			//selenium.click("CancelEdit");
    			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
    			selenium.reportFailure("Test Case Failed");
    			
    		}
}
        }catch(Exception e)
        {
        	selenium.reportFailure(e.getMessage());
        	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^I navigate to consultant assignment page$")
    public void navigateToconsultantassignment() {

        try {
        	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Consultant_Assignment__c/a2XC0000000PU15MAG/view");
        	selenium.waitingTime(4000);
        	selenium.refresh();
        	selenium.waitingTime(8000);
        	selenium.checkFlowInterruptedPopup();
        }
        catch(Exception e)
        {        	
        	selenium.reportFailure(e.getMessage());
        	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^I validate consultant type error message$")
    public void validateConsultantType() {

        try {

        	selenium.click("Addeco");
        	String error = null;
    		String expected_error=null;
    		if (selenium.getUI().contains("Lightning")) {
    		if(selenium.isElementPresentFast("contactSuccessfulL"))
    				
    		 {
    			selenium.captureScreenShot();
    			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
    			
    		}
    		else {
    			//selenium.click("CancelEdit");
    			selenium.reportFailure("Test Case Failed");
    			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        		
        }
    		}
        }
        catch(Exception e)
        {
        	
        	selenium.reportFailure(e.getMessage());
        	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    @And("^edit the form and update the manager$")
    public void editformManager() {

        try {
        	selenium.switchOutOfFrame();
        	selenium.waitingTime(4000);
        	selenium.switchToMultipleFrame("newCRFIframe");
        	selenium.clickLoop("edit");
        	selenium.waitingTime(4000);
        	selenium.switchOutOfFrame();
        	selenium.waitingTime(4000);
        	selenium.switchToMultipleFrame("newCRFIframe");
        	selenium.type("CRFManager", "managerName");
        	selenium.scrollToElement("crfSaveClose");
			selenium.clickLoop("crfSaveClose");
        	selenium.test.log(LogStatus.PASS, "Test Case Passed!");
    		
        }
        catch(Exception e)
        {
        	
        	selenium.reportFailure(e.getMessage());
        	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    
    
}
