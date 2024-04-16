package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.Data;

public class MHHEUserCreatesPilotRequestTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String accessManager,chromeBook,dashboardButton,buttonFaQs,button_Reset,buip_Btn,button_Canvas,button_License,report_Btn,user_Btn,user_guideBtn,resource_Btn;

	@When("^I create a new MHHE Pilot Request$")
	public void create_pilot_refresh() {
		try {

			selenium.search("Opportunity Name");
			selenium.waitingTime(3000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name", "endContains");
			System.out.println(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("moreActionsBtn");
			selenium.click("moreActionsBtn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("mhhePilotRequestBtn");
			selenium.click("mhhePilotRequestBtn");
			selenium.waitingTime(4000);

			selenium.switchToMultipleFrame("productframeUat");

			selenium.click("fielsSearchDrpDwn");
			//selenium.clickDynamic("Text_Span", "Contact", "end");
			selenium.waitForElementToBeClickable("drpDownRecord");
			selenium.click("drpDownRecord");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("fielsSearchDrpDwn");
			selenium.click("fielsSearchDrpDwn");
			//selenium.clickDynamic("spantextContains", "Product", "endContains");
			selenium.waitForElementToBeClickable("drpDownRecord");
			selenium.click("drpDownRecord");
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("hoursPerWeekExpectationText");

			selenium.type("hoursPerWeekExpectationText", "Hours Per Week Expectation");

			selenium.selectDropdownText("integratingWithLmsDrpDwn", "Integrating with LMS");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("productTypeDrpDwn");

			selenium.selectDropdownText("productTypeDrpDwn", "Product Type");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("trainingRequiredDrpDwn");

			selenium.selectDropdownText("trainingRequiredDrpDwn", "Training Required");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("measureOfSuccessText");

			selenium.type("measureOfSuccessText", "Measure of Success");
			selenium.waitingTime(2000);

			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow = calendar.getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(tomorrow);
			System.out.println(todaysdate);
			selenium.scrollToElement("decisionDateText");
			selenium.typeData("decisionDateText", todaysdate);
			selenium.typeData("pilotStartDateTextBox", todaysdate);
			selenium.typeData("pilotEndDateText", todaysdate);

			selenium.selectDropdownText("pilotPricingDrpDwn", "Pilot Pricing");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("noOfStudentsInPilotText");

			selenium.type("noOfStudentsInPilotText", "Number of Students in Pilot");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("goalOfPilotText");

			selenium.type("goalOfPilotText", "Goal of Pilot");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("pilotNotesText");

			selenium.type("pilotNotesText", "Pilot Notes");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");

			selenium.click("saveButton");
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();

			if (selenium.isElementPresentFast("showAllLinks")) {
				selenium.waitForElementToBeClickable("showAllLinks");
				selenium.click("showAllLinks");
			}
			selenium.waitingTime(2000);

			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitingTime(2000);
			}
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);

			selenium.scrolldown(25);
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("mhhePilotLink1");
			selenium.click("mhhePilotLink1");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("MHHEPilotTableLastRecord");


//			selenium.scrollToElement("MHHEPilotTableLastRecord");
//			selenium.waitingTime(3000);
//			selenium.scrolldown(-50);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MHHEPilotTableLastRecord");
			selenium.jsClick("MHHEPilotTableLastRecord");


//			String opportunity = selenium.getDynamicXpath("anchorTitlecontains", "Name", "endContains");
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitingTime(2000);
			}
//			selenium.clickLoopXpath(opportunity);
			selenium.waitingTime(4000);

			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow1 = calendar1.getTime();

			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String currentDate = sdf1.format(tomorrow1);
			System.out.println("Tomorrow Date is :" + currentDate);

			calendar1.setTime(tomorrow1);
			calendar1.add(Calendar.DATE, +1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String tomorrowDate = sdf2.format(dateBefore1Day);
			System.out.println("Day-after-tomorrow Date is :" + tomorrowDate);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);

			//selenium.scrollToElement("pilotStartDateGetText");
			String name = selenium.getTextLoop("pilotStartDateGetText");
			System.out.println("name:" + name);

			if (name.contains(currentDate) || name.contains(tomorrowDate)) {
				selenium.test.log(LogStatus.PASS, "MHHE Pilot Record created successfully " + name);
				System.out.println("Pass");
			} else {
				selenium.test.log(LogStatus.FAIL, "MHHE Pilot Record creation failed ");
				System.out.println("Fail");
				selenium.reportFailure("MHHE Pilot Record creation failed");
			}
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.click("DeleteActionBtn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");
			selenium.waitingTime(4000);

		} catch (Exception e) {

			selenium.reportFailure("Error while navigating to MHHE Pilot page " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}

	}

	@When("^I create a new MHHE Pilot Request Marketing$")
	public void create_pilot_marketing() {
		try {

			/*
			 * selenium.waitingTime(3000); selenium.click("SearchThisList");
			 * selenium.waitingTime(2000); selenium.type("SearchThisList",
			 * "Opportunity Name Mkt");
			 * selenium.getElement("SearchThisList").sendKeys(Keys.ENTER);
			 * selenium.waitingTime(2000);
			 */

			selenium.search("Opportunity Name Mkt");
			selenium.waitingTime(3000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name Mkt", "endContains");
			System.out.println(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("moreActionsBtn");
			selenium.click("moreActionsBtn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("mhhePilotRequestBtn");
			selenium.click("mhhePilotRequestBtn");
			selenium.waitingTime(4000);

			selenium.switchToMultipleFrame("productframeUat");

			selenium.click("fielsSearchDrpDwn");
			//selenium.clickDynamic("Text_Span", "Contact Mkt", "end");
			selenium.waitForElementToBeClickable("drpDownRecord");
			selenium.click("drpDownRecord");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("fielsSearchDrpDwn");
			selenium.click("fielsSearchDrpDwn");
			//selenium.clickDynamic("Text_Span", "Product Mkt", "end");
			selenium.waitForElementToBeClickable("drpDownRecord");
			selenium.click("drpDownRecord");
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("hoursPerWeekExpectationText");

			selenium.type("hoursPerWeekExpectationText", "Hours Per Week Expectation");

			selenium.selectDropdownText("integratingWithLmsDrpDwn", "Integrating with LMS");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("productTypeDrpDwn");

			selenium.selectDropdownText("productTypeDrpDwn", "Product Type");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("trainingRequiredDrpDwn");

			selenium.selectDropdownText("trainingRequiredDrpDwn", "Training Required");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("measureOfSuccessText");

			selenium.type("measureOfSuccessText", "Measure of Success");
			selenium.waitingTime(2000);

			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow = calendar.getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(tomorrow);
			System.out.println(todaysdate);
			selenium.scrollToElement("decisionDateText");
			selenium.typeData("decisionDateText", todaysdate);
			selenium.typeData("pilotStartDateTextBox", todaysdate);
			selenium.typeData("pilotEndDateText", todaysdate);

			selenium.selectDropdownText("pilotPricingDrpDwn", "Pilot Pricing");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("noOfStudentsInPilotText");

			selenium.type("noOfStudentsInPilotText", "Number of Students in Pilot");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("goalOfPilotText");

			selenium.type("goalOfPilotText", "Goal of Pilot");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("pilotNotesText");

			selenium.type("pilotNotesText", "Pilot Notes");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");

			selenium.click("saveButton");
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();

			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
			}
			selenium.waitForElementToBeClickable("showAllLinks");
			selenium.click("showAllLinks");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("mhhePilotLink");
				selenium.click("mhhePilotLink");

			} else {
				selenium.waitForElementToBeClickable("mhhePilotLink");
				selenium.click("mhhePilotLink");
			}
			selenium.waitingTime(4000);

			selenium.lastRowFetchingFromTable("mhhePilotTableXpath", "mhePilotTableDynamic", "endMhePilotTable");

			
			/*String opportunity = selenium.getDynamicXpath("anchorTitlecontains", "Name Mkt", "endContains");
			selenium.clickLoopXpath(opportunity);
			selenium.waitingTime(4000);*/

			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow1 = calendar1.getTime();

			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String currentDate = sdf1.format(tomorrow1);
			System.out.println(currentDate);

			//selenium.scrollToElement("pilotStartDateGetText");
			String name = selenium.getTextLoop("pilotStartDateGetText");

			if (name.contains(currentDate)) {
				selenium.test.log(LogStatus.PASS, "MHHE Pilot Record created successfully " + name);
			} else {
				selenium.test.log(LogStatus.FAIL, "MHHE Pilot Record creation failed ");
				selenium.reportFailure("MHHE Pilot Record creation failed");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while navigating to MHHE Pilot page");
			selenium.reportFailure("Error while navigating to MHHE Pilot page " + e.getMessage());
		}

	}

	@Then("I verify the fields value")
	public void i_verify_the_fields_value(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("Case_Owner_New");
			String caseOwner = selenium.getText("Case_Owner_New").toString();
			System.out.println("The Case Owner name in UI is : " + caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner name is present");
				selenium.test.log(LogStatus.PASS, "Case Owner name is present");
				System.out.println("PASS - Case Owner name is present");
			} else {
				System.out.println("Case Owner name is not present");
				selenium.test.log(LogStatus.FAIL, "Case Owner name is not present");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Record_Type");
			String caseRecordType = selenium.getText("Case_Record_Type").toString();
			System.out.println("The Case Record type in UI is : " + caseRecordType);
			if (caseRecordType.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Record type is present");
				selenium.test.log(LogStatus.PASS, "Case Record type is present");
				System.out.println("PASS - Case Record type is present");
			} else {
				System.out.println("Case Record type not present");
				selenium.test.log(LogStatus.FAIL, "Case Record type present");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Origin_New");
			String caseOrigin = selenium.getText("Case_Origin_New").toString();
			System.out.println("The Case Origin name in UI is : " + caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(2))) {
				System.out.println("Case origin is present");
				selenium.test.log(LogStatus.PASS, "Case origin is present");
				System.out.println("PASS - Case origin is present");
			} else {
				System.out.println("Case origin is not present");
				selenium.test.log(LogStatus.FAIL, "Case origin is not present");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Priority_New");
			String casePriority = selenium.getText("Case_Priority_New").toString();
			System.out.println("The Priority in UI is : " + casePriority);
			if (casePriority.equalsIgnoreCase(data.get(3))) {
				System.out.println("Case Priority is present");
				selenium.test.log(LogStatus.PASS, "Case Priority is present");
				System.out.println("PASS - Case Priority is present");
			} else {
				System.out.println("Case Priority is not present");
				selenium.test.log(LogStatus.FAIL, "Case Priority is not present");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			/*selenium.waitForElementToBeClickable("Edit_StatusBtn");
			selenium.jsClick("Edit_StatusBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Status_DropDown");
			selenium.jsClick("Status_DropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Status_Options");
			selenium.jsClick("Status_Options");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");*/	
			
			selenium.waitForElementToBeClickable("Close_case");
			selenium.jsClick("Close_case");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("Close_case");
			selenium.jsClick("Close_case");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("closingStatus");
			selenium.jsClick("closingStatus");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("closeCaseStatus");
			selenium.click("closeCaseStatus");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("closeCaseReasonField");
			selenium.click("closeCaseReasonField");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("closeCaseReasonValue");
			selenium.click("closeCaseReasonValue");
			selenium.waitingTime(1000);
			selenium.jsClick("closeCaseSaveBtn");			
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Check_Status");
			String checkStatus = selenium.getText("Check_Status").toString();
			System.out.println("The Status is : " + checkStatus);
			if (checkStatus.equalsIgnoreCase(data.get(4))) {
				System.out.println("Status is matched");
				selenium.test.log(LogStatus.PASS, "Status is present");
				System.out.println("PASS - Status is present");
			} else {
				System.out.println("Status is not matched");
				selenium.test.log(LogStatus.FAIL, "Status is not present");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("Verify the case owner")
	public void verify_the_case_owner(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);

			selenium.navigateToURL(selenium.newE2CaseURL);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Case_Owner2");
			String caseOwner = selenium.getText("Case_Owner2").toString();
			System.out.println("The Case Owner name in UI is : " + caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Owner is Assigned");
				selenium.test.log(LogStatus.PASS, "Case Owner is Assigned");
			} else {
				System.out.println("Case Owner is not Assigned");
				selenium.test.log(LogStatus.FAIL, "Case Owner is not Assigned");
				selenium.reportFailure("Case Owner is not Assigned");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("I verify all the fields")
	public void i_verify_all_the_fields(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);

			selenium.navigateToURL(selenium.newE2CaseURL);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Case_Owner_New");
			String caseOwner = selenium.getText("Case_Owner_New").toString();
			System.out.println("Case Owner from UI is : " + caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Owner is present");
				selenium.test.log(LogStatus.PASS, "Case Owner is present");
			} else {
				System.out.println("Case Owner is not present");
				selenium.test.log(LogStatus.FAIL, "Case Owner is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("CaseNumber");
			String caseNumber = selenium.getText("CaseNumber").toString();
			System.out.println("Case Number from UI is : " + caseNumber);
			if (caseNumber.equalsIgnoreCase(data.get(2))) {
				System.out.println("Case Number is present");
				selenium.test.log(LogStatus.PASS, "Case Number is present");
			} else {
				System.out.println("Case Number is not present");
				selenium.test.log(LogStatus.FAIL, "Case Number is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Account_Name");
			String accountName = selenium.getText("Account_Name").toString();
			System.out.println("Account Name from UI is : " + accountName);
			if (accountName.equalsIgnoreCase(data.get(3))) {
				System.out.println("Account Name is present");
				selenium.test.log(LogStatus.PASS, "Account Name is present");
			} else {
				System.out.println("Account Name is not present");
				selenium.test.log(LogStatus.FAIL, "Account Name is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("International_Product");
			String internationalProduct = selenium.getText("International_Product").toString();
			System.out.println("International Product from UI is : " + internationalProduct);
			if (internationalProduct.equalsIgnoreCase(data.get(4))) {
				System.out.println("International Product is present");
				selenium.test.log(LogStatus.PASS, "International Product is present");
			} else {
				System.out.println("International Product is not present");
				selenium.test.log(LogStatus.FAIL, "International Product is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("SalesApproved");
			String salesApproved = selenium.getText("SalesApproved").toString();
			System.out.println("Sales Approved from UI is : " + salesApproved);
			if (salesApproved.equalsIgnoreCase(data.get(5))) {
				System.out.println("Sales Approved is present");
				selenium.test.log(LogStatus.PASS, "Sales Approved is present");
			} else {
				System.out.println("Sales Approved is not present");
				selenium.test.log(LogStatus.FAIL, "Sales Approved is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Record_Type");
			String caseRecordType = selenium.getText("Case_Record_Type").toString();
			System.out.println("Case Record type from UI is : " + caseRecordType);
			if (caseRecordType.equalsIgnoreCase(data.get(6))) {
				System.out.println("Case Record Type is present");
				selenium.test.log(LogStatus.PASS, "Case Record Type is present");
			} else {
				System.out.println("Case Record Type is not present");
				selenium.test.log(LogStatus.FAIL, "Case Record Type is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Reason");
			String caseReason = selenium.getText("Case_Reason").toString();
			System.out.println("Care Reason from UI is : " + caseReason);
			if (caseReason.equalsIgnoreCase(data.get(7))) {
				System.out.println("Case Reason is present");
				selenium.test.log(LogStatus.PASS, "Case Reason is present");
			} else {
				System.out.println("Case Reason is not present");
				selenium.test.log(LogStatus.FAIL, "Case Reason is not present");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(2000);
			selenium.waitForElementToBeVisible("Status_Field");
			String statusField = selenium.getText("Status_Field").toString();
			System.out.println("Status Field from UI is : " + statusField);
			if (statusField.equalsIgnoreCase(data.get(8))) {
				System.out.println("Status Field is present");
				selenium.test.log(LogStatus.PASS, "Status Field is present");
			} else {
				System.out.println("Status Field is not present");
				selenium.test.log(LogStatus.FAIL, "Status Field is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Origin_New");
			String caseOrigin = selenium.getText("Case_Origin_New").toString();
			System.out.println("Case Origin from UI is : " + caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(9))) {
				System.out.println("Case Origin is present");
				selenium.test.log(LogStatus.PASS, "Case Origin is present");
			} else {
				System.out.println("Case Origin is not present");
				selenium.test.log(LogStatus.FAIL, "Case Origin is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Priority_New");
			String casePriority = selenium.getText("Case_Priority_New").toString();
			System.out.println("Case Priority from UI is : " + casePriority);
			if (casePriority.equalsIgnoreCase(data.get(10))) {
				System.out.println("Case Priority is present");
				selenium.test.log(LogStatus.PASS, "Case Priority is present");
			} else {
				System.out.println("Case Priority is not present");
				selenium.test.log(LogStatus.FAIL, "Case Priority is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Subject_Field1");
			String subject = selenium.getText("Subject_Field1").toString();
			System.out.println("Subject from UI is : " + subject);
			if (subject.equalsIgnoreCase(data.get(11))) {
				System.out.println("Subject is present");
				selenium.test.log(LogStatus.PASS, "Subject is present");
			} else {
				System.out.println("Subject is not present");
				selenium.test.log(LogStatus.FAIL, "Subject is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("DateTimeOpened");
			String dateTimeOpened = selenium.getText("DateTimeOpened").toString();
			System.out.println("Date Time Opened from UI is : " + dateTimeOpened);
			if (dateTimeOpened.equalsIgnoreCase(data.get(12))) {
				System.out.println("Date time is present");
				selenium.test.log(LogStatus.PASS, "Date time is present");
			} else {
				System.out.println("Date time is not present");
				selenium.test.log(LogStatus.FAIL, "Date time is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Last_Modified_Date");
			String lastModifiedDate = selenium.getText("Last_Modified_Date").toString();
			System.out.println("Last Modified Date from UI is : " + lastModifiedDate);
			if (lastModifiedDate.equalsIgnoreCase(data.get(13))) {
				System.out.println("Last Modified date is present");
				selenium.test.log(LogStatus.PASS, "Last Modified date is present");
			} else {
				System.out.println("Last Modified date is not present");
				selenium.test.log(LogStatus.FAIL, "Last Modified date is not present");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("Verify the case details field")
	public void verify_the_case_details_field(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
//			String url = selenium.getTestDataFromPropertiesFile("AutomationCasesListToday");
//			selenium.navigateToURL(url);
//			selenium.waitingTime(4000);
//			selenium.refresh();
//			selenium.waitingTime(8000);
//			String caseXpath = selenium.getDynamicXpathData("anchorTextcontains", data.get(0), "endContains");
//			System.out.println(caseXpath);
//			selenium.clickXpath(caseXpath);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Case_Status_1");
			String caseStatus = selenium.getText("Case_Status_1").toString();
			System.out.println("Case Status from UI is : " + caseStatus);
			if (caseStatus.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Status is : " + caseStatus);
				selenium.test.log(LogStatus.PASS, "Case Status is present");
			} else {
				System.out.println("Case Status is not Present");
				selenium.test.log(LogStatus.FAIL, "Case Status is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Priority");
			String casePriority = selenium.getText("Case_Priority").toString();
			System.out.println("Case Status from UI is : " + casePriority);
			if (casePriority.equalsIgnoreCase(data.get(2))) {
				System.out.println("Case Priority is : " + casePriority);
				selenium.test.log(LogStatus.PASS, "Case Priority is present");
			} else {
				System.out.println("Case Priority is not present");
				selenium.test.log(LogStatus.FAIL, "Case Priority is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_BusinessHours");
			String businessHours = selenium.getText("Case_BusinessHours").toString();
			System.out.println("Case Status from UI is : " + businessHours);
			if (businessHours.equalsIgnoreCase(data.get(3))) {
				System.out.println("Case Business Hours is : " + businessHours);
				selenium.test.log(LogStatus.PASS, "Case Business Hours is present");
			} else {
				System.out.println("Case Business Hours is not present");
				selenium.test.log(LogStatus.FAIL, "Case Business Hours is not present");
			}

			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Origin");
			String caseOrigin = selenium.getText("Case_Origin").toString();
			System.out.println("Case Status from UI is : " + caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(4))) {
				System.out.println("Case Origin is : " + caseOrigin);
				selenium.test.log(LogStatus.PASS, "Case Origin is present");
			} else {
				System.out.println("Case Origin is not present");
				selenium.test.log(LogStatus.FAIL, "Case Origin is not present");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(5000);
			selenium.waitForElementToBeVisible("Case_Record_Type");
			String caseRecordType = selenium.getText("Case_Record_Type").toString();
			System.out.println("Case Status from UI is : " + caseRecordType);
			if (caseRecordType.equalsIgnoreCase(data.get(5))) {
				System.out.println("Case Record type is : " + caseRecordType);
				selenium.test.log(LogStatus.PASS, "Case Record Type is present");
			} else {
				System.out.println("Case Record Type is not present");
				selenium.test.log(LogStatus.FAIL, "Case Record Type is not present");
			}
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_Change_Owner");
			selenium.jsClick("Case_Change_Owner");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("UserTypeDD");
			selenium.jsClick("UserTypeDD");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("UserTypeValue");
			selenium.jsClick("UserTypeValue");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchQueues");
			selenium.typeData("searchQueues", "CSOM");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SearchResultForUser");
			selenium.jsClick("SearchResultForUser");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseClickOwner");
			selenium.jsClick("CaseClickOwner");
			selenium.waitingTime(5000);

			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChangeOwnerBtn");
			selenium.jsClick("ChangeOwnerBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("Case_BusinessHours");
			String caseBusinessHours = selenium.getText("Case_BusinessHours").toString();
			System.out.println("Case Business Hours from UI after Owner Change is : " + caseBusinessHours);
			if (caseBusinessHours.equalsIgnoreCase(data.get(6))) {
				System.out.println("Case Business Hours are : " + caseBusinessHours);
				selenium.test.log(LogStatus.PASS, "Case Business Hours are Changed");
			} else {
				System.out.println("Case Business Hours are not changed");
				selenium.test.log(LogStatus.FAIL, "Case Business Hours are not Changed");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(5000);
			selenium.waitForElementToBeClickable("Case_Record_Type");
			String caseRecordType1 = selenium.getText("Case_Record_Type").toString();
			System.out.println("Case Business Hours from UI after Owner Change is : " + caseRecordType1);
			if (caseRecordType1.equalsIgnoreCase(data.get(7))) {
				System.out.println("Case Record Type is : " + caseBusinessHours);
				selenium.test.log(LogStatus.PASS, "Case Record Type is Changed");
			} else {
				System.out.println("Case Record Type is not changed");
				selenium.test.log(LogStatus.FAIL, "Case Record Type is not Changed");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("Verify the CXG case origin field")
	public void verify_the_CXG_case_origin_field() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Origin_New");
			String caseOrigin = selenium.getText("Case_Origin_New").toString();
			System.out.println("Case Origin CXG from UI is : " + caseOrigin);
			if (caseOrigin.equalsIgnoreCase("Self_Service")) {
				System.out.println("Case origin field is present");
				selenium.test.log(LogStatus.PASS, "Field is present");
			} else {
				System.out.println("Case origin field is not present");
				selenium.test.log(LogStatus.PASS, "Field is not present");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("Verify the ALEKS case origin field")
	public void verify_the_ALEKS_case_origin_field() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Origin_New");
			String caseOrigin = selenium.getText("Case_Origin_New").toString();
			System.out.println("Case Origin ALEKS from UI is : " + caseOrigin);
			if (caseOrigin.equalsIgnoreCase("Email - ALEKS")) {
				System.out.println("Case origin field is present");
				selenium.test.log(LogStatus.PASS, "Field is present");
			} else {
				System.out.println("Case origin field is not present");
				selenium.test.log(LogStatus.PASS, "Field is not present");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}

	}

	@Then("I create a new case for ALEKS")
	public void i_created_a_new_case_fro_ALEKS() {
		try {
			selenium.waitingTime(4000);
			if (selenium.isElementPresentFast("loginPopUpNew")) {
				System.out.println("I am inside loginPopUpNew method");
				selenium.clickLoop("loginPopUpNew");
				selenium.waitingTime(2000);
			} else if (selenium.isElementPresentFast("loginPopUp")) {
				System.out.println("I am inside loginPopup method");
				selenium.click("loginPopUp");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.typeData("Search_contact", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectContactName");
			selenium.jsClick("SelectContactName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "ALEKS");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Business_Hours_ALEKS");
			selenium.jsClick("Business_Hours_ALEKS");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Support_account");
			selenium.typeData("Support_account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults2");
			selenium.jsClick("ShowAllResults2");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Case_OriginOption1");
			selenium.jsClick("Case_OriginOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productDropDwn1");
			selenium.jsClick("productDropDwn1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSCaseReasonOption");
			selenium.jsClick("ALEKSCaseReasonOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "ALEKS Demo Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSCaseInternalDescriptionTextBox");
			selenium.typeData("ALEKSCaseInternalDescriptionTextBox", "Demo Test");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify the case origin field")
	public void verify_the_case_origin_field() {
		try {
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("ALEKSCaseEditCaseOriginBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSCaseEditCaseOriginBtn");
			selenium.clickLoop("ALEKSCaseEditCaseOriginBtn");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitForElementToBeVisible("CaseOriginOptions");
			List<WebElement> options = selenium.getElements("CaseOriginOptions");
			int flag = 1;
			for (int i = 1; i < options.size(); i++) {
				String text = options.get(i).getText().toString();
				selenium.waitingTime(2000);
				System.out.println("Options in the Case Origin Dropdown list are : " + text);
				flag++;

			}
			if (flag == 4) {
				System.out.println("Dropdown has only two options");
			}
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("Case_OriginDropDown");
//			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseOriginOption1");
			selenium.jsClick("CaseOriginOption1");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ALEKSCaseInternalDescriptionTextBox");
			selenium.typeData("ALEKSCaseInternalDescriptionTextBox", "Demo Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("validate the owner and record type")
	public void validate_the_owner_and_record_type(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
//		selenium.waitingTime(4000);
//		String url = selenium.getTestDataFromPropertiesFile("AutomationCasesListToday");
//		selenium.navigateToURL(url);
//		selenium.waitingTime(4000);
//		selenium.refresh();
//		selenium.waitingTime(8000);
//		String caseXpath = selenium.getDynamicXpathData("anchorTextcontains", data.get(0), "endContains");
//		System.out.println(caseXpath);
//		selenium.clickXpath(caseXpath);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Case_Owner");
			String caseOwnerDSC = selenium.getText("Case_Owner").toString();
			System.out.println("Case Owner from UI is : " + caseOwnerDSC);
			if (caseOwnerDSC.equalsIgnoreCase("Ryerson DSC Queue")) {
				System.out.println("Case Owner name is present");
				selenium.test.log(LogStatus.PASS, "Case Owner name is present");
			} else {
				System.out.println("Case Owner name is not present");
				selenium.test.log(LogStatus.PASS, "Case Owner name is not present");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(5000);
			selenium.waitForElementToBeVisible("Case_Record_Type");
			String caseRecordType = selenium.getText("Case_Record_Type").toString();
			System.out.println("Case Owner from UI is : " + caseRecordType);
			if (caseRecordType.equalsIgnoreCase("INTL Ryerson Product Support")) {
				System.out.println("Case Record type is present");
				selenium.test.log(LogStatus.PASS, "Case Record type is present");
			} else {
				System.out.println("Case Record type is not present");
				selenium.test.log(LogStatus.PASS, "Case Record type is not present");
			}


		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify the created case fields value")
	public void verify_the_created_case_fields_value(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			String url = selenium.getTestDataFromPropertiesFile("AutomationCasesListToday");
			selenium.navigateToURL(url);
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
//			selenium.waitForElementToBeClickable("SearchThisList");
//			selenium.click("SearchThisList");
//			selenium.waitingTime(2000);
//			selenium.typeData("SearchThisList", data.get(0));
//			selenium.pressEnter("SearchThisList");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SelectListView");
			selenium.jsClick("SelectListView");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SearchList");
			selenium.typeData("SearchList", "Canada Media Tech");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SelectCanadaMediaTech");
			selenium.jsClick("SelectCanadaMediaTech");
			selenium.waitingTime(8000);

			selenium.waitForElementToBeClickable("FirstRecordCase");
			selenium.jsClick("FirstRecordCase");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Case_Owner");
			String caseOwner = selenium.getText("Case_Owner").toString();
			System.out.println("Case owner from UI is : " + caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Owner is " + caseOwner);
				selenium.test.log(LogStatus.PASS, "Case Owner is present");
			} else {
				System.out.println("Case Owner is not present");
				selenium.test.log(LogStatus.FAIL, "Case Owner is not present");
				selenium.reportFailure("Test Case failed");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(150);
			selenium.waitForElementToBeVisible("Case_Record_Type");
			String caseRecordType = selenium.getText("Case_Record_Type").toString();
			System.out.println("Case Record Type from UI is : " + caseRecordType);
			if (caseRecordType.equalsIgnoreCase(data.get(2))) {
				System.out.println("Case Record type is " + caseRecordType);
				selenium.test.log(LogStatus.PASS, "Case record type is present");
			} else {
				System.out.println("Case Record type is not present");
				selenium.test.log(LogStatus.FAIL, "Case Record type is not present");
				selenium.reportFailure("Test Case failed");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(100);
			selenium.waitForElementToBeVisible("Case_Origin");
			String caseOrigin = selenium.getText("Case_Origin").toString();
			System.out.println("Case Origin from UI is : " + caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(3))) {
				System.out.println("Case Origin is " + caseOrigin);
				selenium.test.log(LogStatus.PASS, "Case Origin is present");
			} else {
				System.out.println("Case Origin is not present");
				selenium.test.log(LogStatus.FAIL, "Case Origin is not present");
				selenium.reportFailure("Test Case failed");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("I change the owner of case")
	public void i_change_the_owner_of_the_case() {
		try {
			selenium.waitForElementToBeClickable("SelectListView");
			selenium.jsClick("SelectListView");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SearchList");
			selenium.typeData("SearchList", "A3K Customer Support");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SelectA3KInSearchList");
			selenium.jsClick("SelectA3KInSearchList");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("FirstRecordCase");
			selenium.jsClick("FirstRecordCase");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ChangeOwnerButton1");
			selenium.jsClick("ChangeOwnerButton1");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("search_user");
			selenium.typeData("search_user", "Steve Loori");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ChangeOwnerUsers");
			selenium.jsClick("ChangeOwnerUsers");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectOwnerNew");
			selenium.jsClick("SelectOwnerNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChangeOwnerSubmitBtn");
			selenium.jsClick("ChangeOwnerSubmitBtn");

			boolean ownerChanged = selenium.isElementPresentFast("contactSuccessfulL");
			System.out.println("owner transfer success" + ownerChanged);
			if (ownerChanged == true) {
				selenium.test.log(LogStatus.PASS, "Case transferred to new owner");
			} else {

				selenium.click("deleteAction");
				selenium.waitForElementToBeClickable("search_user");
				selenium.jsClick("search_user");
				selenium.waitingTime(2000);
				selenium.typeData("search_user", "Arlenis Guanco");
				selenium.waitingTime(2000);
//					selenium.clickDynamic("divTitle", "Owner", "end");
				selenium.clickLoop("ChangeCaseOwnerSelection");
//					selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SubmitForm");
				selenium.jsClick("SubmitForm");
				boolean ownerChangedNew = selenium.isElementPresentFast("contactSuccessfulL");
				System.out.println("owner transfer success" + ownerChangedNew);
				if (ownerChangedNew == true) {
					selenium.test.log(LogStatus.PASS, "Case transferred to new owner");
				} else {
					selenium.test.log(LogStatus.FAIL, "Case did not transferred to new owner");
					selenium.reportFailure("Case did not transferred to new owner");
				}
			}

			if (selenium.isElementPresentFast("changeOwnerAlert")) {
				selenium.click("CancelButton_Span");
				selenium.waitingTime(3000);
			}
			/*selenium.waitingTime(4000);
			selenium.scrolldown(400);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Owner");
			String caseOwner=selenium.getText("Case_Owner").toString();
			System.out.println("Case Owner from UI is : "+caseOwner);
			if(caseOwner.equalsIgnoreCase("Steve Loori")){
				System.out.println("Case Owner is : "+caseOwner);
				selenium.test.log(LogStatus.PASS,"Case Owner Changed");
			}
			else {
				System.out.println("Case Owner is not Changed");
				selenium.test.log(LogStatus.FAIL,"Case Owner is not changed");
				selenium.reportFailure("Test Case Failed");
			}*/

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("validate the fields value")
	public void validate_the_fields_value(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.waitForElementToBeClickable("Case_Owner");
			String caseOwner = selenium.getText("Case_Owner").toString();
			System.out.println(caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner is Matched");
				selenium.test.log(LogStatus.PASS, "Case Owner is Matched");
			} else {
				System.out.println("Case Owner is not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Owner is not Matched");
				selenium.reportFailure("Case Owner is not Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Case_Priority");
			String casePriority = selenium.getText("Case_Priority").toString();
			System.out.println(casePriority);
			if (casePriority.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Priority is Matched");
				selenium.test.log(LogStatus.PASS, "Case Priority is Matched");
			} else {
				System.out.println("Case Priority is not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Priority is not Matched");
				selenium.reportFailure("Case Priority is not Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Case_Origin");
			String caseOrigin = selenium.getText("Case_Origin").toString();
			System.out.println(caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(2))) {
				System.out.println("Case Origin is Matched");
				selenium.test.log(LogStatus.PASS, "Case Origin is Matched");
			} else {
				System.out.println("Case Origin is not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Origin is not Matched");
				selenium.reportFailure("Case Origin is not Matched");
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("Case_Record_Type");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Case_Record_Type");
			String caseRecordType = selenium.getText("Case_Record_Type").toString();
			System.out.println(caseRecordType);
			if (caseRecordType.equalsIgnoreCase(data.get(3))) {
				System.out.println("Case Record Type is Matched");
				selenium.test.log(LogStatus.PASS, "Case Record Type is Matched");
			} else {
				System.out.println("Case Record Type is not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Record Type is not Matched");
				selenium.reportFailure("Case Record Type is not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("created a new case for MHHE Sales Support")
	public void created_a_new_case_for_mhhe_sales_support() {
		try {
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SalesSupportRadioBtn");
			selenium.jsClick("SalesSupportRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MHHECaseOriginOption");
			selenium.jsClick("MHHECaseOriginOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductTypeDDList");
			selenium.jsClick("ProductTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MHHEProductTypeOption");
			selenium.jsClick("MHHEProductTypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductDropDown");
			selenium.jsClick("SalesSupportProductDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductOption");
			selenium.jsClick("SalesSupportProductOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("incident_option");
			selenium.jsClick("incident_option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MHHEIncidentOption");
			selenium.jsClick("MHHEIncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("caseSubIncidentDrpDwnNew");
			selenium.jsClick("caseSubIncidentDrpDwnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportSubIncidentOption");
			selenium.jsClick("SalesSupportSubIncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "Rep Sales");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseDesc");
			selenium.typeData("CaseDesc", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CXG");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BusinessHoursOption");
			selenium.jsClick("BusinessHoursOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify the all field according to condition")
	public void verify_the_all_field_according_to_condition(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("ProductFieldVerify");
			selenium.waitingTime(2000);
			selenium.scrolldown(-300);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ProductFieldVerify");
			String productFieldVerify = selenium.getText("ProductFieldVerify").toString();
			System.out.println(productFieldVerify);
			if (productFieldVerify.equalsIgnoreCase(data.get(0))) {
				System.out.println("Product field value is not changed");
				selenium.test.log(LogStatus.PASS, "Product field value is not changed");
			} else {
				System.out.println("Product field value is changed");
				selenium.test.log(LogStatus.FAIL, "Product field value is changed");
				selenium.reportFailure("Product field value is changed");
			}
			selenium.waitForElementToBeVisible("IncidentFieldVerify");
			String incidentFieldVerify = selenium.getText("IncidentFieldVerify").toString();
			System.out.println(incidentFieldVerify);
			if (incidentFieldVerify.equalsIgnoreCase(data.get(1))) {
				System.out.println("Incident field value is not changed");
				selenium.test.log(LogStatus.PASS, "Incident field value is not changed");
			} else {
				System.out.println("Incident field value is changed");
				selenium.test.log(LogStatus.FAIL, "Incident field value is changed");
				selenium.reportFailure("Incident field value is changed");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("SubIncidentFieldVerify");
			String subIncidentFieldVerify = selenium.getText("SubIncidentFieldVerify").toString();
			System.out.println(subIncidentFieldVerify);
			if (subIncidentFieldVerify.equalsIgnoreCase(data.get(2))) {
				System.out.println("SubIncident field value is not changed");
				selenium.test.log(LogStatus.PASS, "SubIncident field value is not changed");
			} else {
				System.out.println("SubIncident field value is changed");
				selenium.test.log(LogStatus.FAIL, "SubIncident field value is changed");
				selenium.reportFailure("SubIncident field value is changed");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentEditBtn");
			selenium.jsClick("IncidentEditBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("caseSubIncidentDrpDwnNew");
			selenium.jsClick("caseSubIncidentDrpDwnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncidentOption");
			selenium.jsClick("SubIncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("ProductFieldVerify");
			productFieldVerify = selenium.getText("ProductFieldVerify").toString();
			System.out.println(productFieldVerify);
			if (productFieldVerify.equalsIgnoreCase(data.get(0))) {
				System.out.println("Product field value is not changed");
				selenium.test.log(LogStatus.PASS, "Product field value is not changed");
			} else {
				System.out.println("Product field value is changed");
				selenium.test.log(LogStatus.FAIL, "Product field value is changed");
				selenium.reportFailure("Product field value is changed");
			}
			selenium.waitForElementToBeVisible("IncidentFieldVerify");
			incidentFieldVerify = selenium.getText("IncidentFieldVerify").toString();
			System.out.println(incidentFieldVerify);
			if (incidentFieldVerify.equalsIgnoreCase(data.get(1))) {
				System.out.println("Incident field value is not changed");
				selenium.test.log(LogStatus.PASS, "Incident field value is not changed");
			} else {
				System.out.println("Incident field value is changed");
				selenium.test.log(LogStatus.FAIL, "Incident field value is changed");
				selenium.reportFailure("Incident field value is changed");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentEditBtn");
			selenium.jsClick("IncidentEditBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("caseSubIncidentDrpDwnNew");
			selenium.jsClick("caseSubIncidentDrpDwnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncidentOption1");
			selenium.jsClick("SubIncidentOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("ProductFieldVerify");
			productFieldVerify = selenium.getText("ProductFieldVerify").toString();
			System.out.println(productFieldVerify);
			if (productFieldVerify.equalsIgnoreCase(data.get(0))) {
				System.out.println("Product field value is not changed");
				selenium.test.log(LogStatus.PASS, "Product field value is not changed");
			} else {
				System.out.println("Product field value is changed");
				selenium.test.log(LogStatus.FAIL, "Product field value is changed");
				selenium.reportFailure("Product field value is changed");
			}
			selenium.waitForElementToBeVisible("IncidentFieldVerify");
			incidentFieldVerify = selenium.getText("IncidentFieldVerify").toString();
			System.out.println(incidentFieldVerify);
			if (incidentFieldVerify.equalsIgnoreCase(data.get(1))) {
				System.out.println("Incident field value is not changed");
				selenium.test.log(LogStatus.PASS, "Incident field value is not changed");
			} else {
				System.out.println("Incident field value is changed");
				selenium.test.log(LogStatus.FAIL, "Incident field value is changed");
				selenium.reportFailure("Incident field value is changed");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("SubIncidentFieldVerify");
			subIncidentFieldVerify = selenium.getText("SubIncidentFieldVerify").toString();
			System.out.println(subIncidentFieldVerify);
			if (subIncidentFieldVerify.equalsIgnoreCase(data.get(3))) {
				System.out.println("SubIncident field value is not changed");
				selenium.test.log(LogStatus.PASS, "SubIncident field value is not changed");
			} else {
				System.out.println("SubIncident field value is changed");
				selenium.test.log(LogStatus.FAIL, "SubIncident field value is changed");
				selenium.reportFailure("SubIncident field value is changed");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentEditBtn");
			selenium.jsClick("IncidentEditBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("caseSubIncidentDrpDwnNew");
			selenium.jsClick("caseSubIncidentDrpDwnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncidentOption2");
			selenium.jsClick("SubIncidentOption2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("ProductFieldVerify");
			productFieldVerify = selenium.getText("ProductFieldVerify").toString();
			System.out.println(productFieldVerify);
			if (productFieldVerify.equalsIgnoreCase(data.get(0))) {
				System.out.println("Product field value is not changed");
				selenium.test.log(LogStatus.PASS, "Product field value is not changed");
			} else {
				System.out.println("Product field value is changed");
				selenium.test.log(LogStatus.FAIL, "Product field value is changed");
				selenium.reportFailure("Product field value is changed");
			}
			selenium.waitForElementToBeVisible("IncidentFieldVerify");
			incidentFieldVerify = selenium.getText("IncidentFieldVerify").toString();
			System.out.println(incidentFieldVerify);
			if (incidentFieldVerify.equalsIgnoreCase(data.get(1))) {
				System.out.println("Incident field value is not changed");
				selenium.test.log(LogStatus.PASS, "Incident field value is not changed");
			} else {
				System.out.println("Incident field value is changed");
				selenium.test.log(LogStatus.FAIL, "Incident field value is changed");
				selenium.reportFailure("Incident field value is changed");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("SubIncidentFieldVerify");
			subIncidentFieldVerify = selenium.getText("SubIncidentFieldVerify").toString();
			System.out.println(subIncidentFieldVerify);
			if (subIncidentFieldVerify.equalsIgnoreCase(data.get(4))) {
				System.out.println("SubIncident field value is not changed");
				selenium.test.log(LogStatus.PASS, "SubIncident field value is not changed");
			} else {
				System.out.println("SubIncident field value is changed");
				selenium.test.log(LogStatus.FAIL, "SubIncident field value is changed");
				selenium.reportFailure("SubIncident field value is changed");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentEditBtn");
			selenium.jsClick("IncidentEditBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("caseSubIncidentDrpDwnNew");
			selenium.jsClick("caseSubIncidentDrpDwnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncidentOption3");
			selenium.jsClick("SubIncidentOption3");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("ProductFieldVerify");
			productFieldVerify = selenium.getText("ProductFieldVerify").toString();
			System.out.println(productFieldVerify);
			if (productFieldVerify.equalsIgnoreCase(data.get(0))) {
				System.out.println("Product field value is not changed");
				selenium.test.log(LogStatus.PASS, "Product field value is not changed");
			} else {
				System.out.println("Product field value is changed");
				selenium.test.log(LogStatus.FAIL, "Product field value is changed");
				selenium.reportFailure("Product field value is changed");
			}
			selenium.waitForElementToBeVisible("IncidentFieldVerify");
			incidentFieldVerify = selenium.getText("IncidentFieldVerify").toString();
			System.out.println(incidentFieldVerify);
			if (incidentFieldVerify.equalsIgnoreCase(data.get(1))) {
				System.out.println("Incident field value is not changed");
				selenium.test.log(LogStatus.PASS, "Incident field value is not changed");
			} else {
				System.out.println("Incident field value is changed");
				selenium.test.log(LogStatus.FAIL, "Incident field value is changed");
				selenium.reportFailure("Incident field value is changed");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("SubIncidentFieldVerify");
			subIncidentFieldVerify = selenium.getText("SubIncidentFieldVerify").toString();
			System.out.println(subIncidentFieldVerify);
			if (subIncidentFieldVerify.equalsIgnoreCase(data.get(5))) {
				System.out.println("SubIncident field value is not changed");
				selenium.test.log(LogStatus.PASS, "SubIncident field value is not changed");
			} else {
				System.out.println("SubIncident field value is changed");
				selenium.test.log(LogStatus.FAIL, "SubIncident field value is changed");
				selenium.reportFailure("SubIncident field value is changed");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("created a case for MHHE Sales Support")
	public void created_a_case_for_MHHE_Sales_Support() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("NewBtn")) {
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			} else {
				selenium.waitForElementToBeClickable("DropDownBtn");
				selenium.jsClick("DropDownBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			}

			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SalesSupportRadioButton");
			selenium.jsClick("SalesSupportRadioButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportOption1");
			selenium.jsClick("SalesSupportOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "DemoTest");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseDesc");
			selenium.typeData("CaseDesc", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CXG");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BusinessHoursOption");
			selenium.jsClick("BusinessHoursOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductTypeDDList");
			selenium.jsClick("ProductTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductTypeOption");
			selenium.jsClick("SalesSupportProductTypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify the incident field")
	public void verify_the_incident_field(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("IncidentFieldVerify");
			selenium.waitingTime(2000);
			selenium.scrolldown(-300);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("IncidentFieldVerify");
			String incidentFieldVerify = selenium.getText("IncidentFieldVerify").toString();
			System.out.println(incidentFieldVerify);
			if (incidentFieldVerify.equalsIgnoreCase(data.get(0))) {
				System.out.println("Incident field value is not changed");
				selenium.test.log(LogStatus.PASS, "Incident field value is not changed");
			} else {
				System.out.println("Incident field value is changed");
				selenium.test.log(LogStatus.FAIL, "Incident field value is changed");
				selenium.reportFailure("Incident field value is changed");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("created a case for MHHE Sales Support_1")
	public void created_a_case_for_MHHE_Sales_Support_1() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("NewBtn")) {
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			} else {
				selenium.waitForElementToBeClickable("DropDownBtn");
				selenium.jsClick("DropDownBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SalesSupportRadioButton");
			selenium.jsClick("SalesSupportRadioButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SEGCaseOriginOption");
			selenium.jsClick("SEGCaseOriginOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "DemoTest");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseDesc");
			selenium.typeData("CaseDesc", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CXG");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BusinessHoursOption");
			selenium.jsClick("BusinessHoursOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductTypeDDList");
			selenium.jsClick("ProductTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductTypeOption");
			selenium.jsClick("SalesSupportProductTypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("created a case for MHHE Sales Support_2")
	public void created_a_case_for_MHHE_Sales_Support_2() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("NewBtn")) {
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			} else {
				selenium.waitForElementToBeClickable("DropDownBtn");
				selenium.jsClick("DropDownBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SalesSupportRadioButton");
			selenium.jsClick("SalesSupportRadioButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SEGCaseOriginOption1");
			selenium.jsClick("SEGCaseOriginOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "DemoTest");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("SimpleTextBox");
//			selenium.typeData("SimpleTextBox", "Automation Test");
			selenium.waitForElementToBeClickable("CaseDesc");
			selenium.typeData("CaseDesc", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CXG");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BusinessHoursOption");
			selenium.jsClick("BusinessHoursOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductTypeDDList");
			selenium.jsClick("ProductTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductTypeOption");
			selenium.jsClick("SalesSupportProductTypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("created a case for MHHE Sales Support_3")
	public void created_a_case_for_MHHE_Sales_Support_3() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("NewBtn")) {
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			} else {
				selenium.waitForElementToBeClickable("DropDownBtn");
				selenium.jsClick("DropDownBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SalesSupportRadioButton");
			selenium.jsClick("SalesSupportRadioButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SEGCaseOriginOption2");
			selenium.jsClick("SEGCaseOriginOption2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "DemoTest");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("SimpleTextBox");
//			selenium.typeData("SimpleTextBox", "Automation Test");
			selenium.waitForElementToBeClickable("CaseDesc");
			selenium.typeData("CaseDesc", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CXG");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BusinessHoursOption");
			selenium.jsClick("BusinessHoursOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductTypeDDList");
			selenium.jsClick("ProductTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductTypeOption");
			selenium.jsClick("SalesSupportProductTypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("created a case for MHHE Sales Support_4")
	public void created_a_case_for_MHHE_Sales_Support_4() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("NewBtn")) {
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			} else {
				selenium.waitForElementToBeClickable("DropDownBtn");
				selenium.jsClick("DropDownBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SalesSupportRadioButton");
			selenium.jsClick("SalesSupportRadioButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SEGCaseOriginOption3");
			selenium.jsClick("SEGCaseOriginOption3");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "DemoTest");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("SimpleTextBox");
//			selenium.typeData("SimpleTextBox", "Automation Test");
			selenium.waitForElementToBeClickable("CaseDesc");
			selenium.typeData("CaseDesc", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CXG");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BusinessHoursOption");
			selenium.jsClick("BusinessHoursOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductTypeDDList");
			selenium.jsClick("ProductTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductTypeOption");
			selenium.jsClick("SalesSupportProductTypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("created a case for MHHE Sales Support_5")
	public void created_a_case_for_MHHE_Sales_Support_5() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("NewBtn")) {
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			} else {
				selenium.waitForElementToBeClickable("DropDownBtn");
				selenium.jsClick("DropDownBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SalesSupportRadioButton");
			selenium.jsClick("SalesSupportRadioButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SEGCaseOriginOption4");
			selenium.jsClick("SEGCaseOriginOption4");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "DemoTest");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SimpleTextBox");
			selenium.typeData("SimpleTextBox", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CXG");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BusinessHoursOption");
			selenium.jsClick("BusinessHoursOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductTypeDDList");
			selenium.jsClick("ProductTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductTypeOption");
			selenium.jsClick("SalesSupportProductTypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("created a case for MHHE Sales Support_6")
	public void created_a_case_for_MHHE_Sales_Support_6() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DropDownBtn");
			selenium.jsClick("DropDownBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SalesSupportRadioButton");
			selenium.jsClick("SalesSupportRadioButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SEGCaseOriginOption5");
			selenium.jsClick("SEGCaseOriginOption5");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "DemoTest");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SimpleTextBox");
			selenium.typeData("SimpleTextBox", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CXG");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BusinessHoursOption");
			selenium.jsClick("BusinessHoursOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductTypeDDList");
			selenium.jsClick("ProductTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SalesSupportProductTypeOption");
			selenium.jsClick("SalesSupportProductTypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("I verify the fields value.")
	public void i_verify_all_the_fields_value(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.waitForElementToBeVisible("Case_Origin");
			String caseOrigin = selenium.getText("Case_Origin").toString();
			System.out.println(caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Origin Matched");
				selenium.test.log(LogStatus.PASS, "Case Origin Matched");
			} else {
				System.out.println("Case Origin Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Origin Not Matched");
				selenium.reportFailure("Case Origin Not Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Owner");
			String caseOwner = selenium.getText("Case_Owner").toString();
			System.out.println(caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner Matched");
				selenium.test.log(LogStatus.PASS, "Case Owner Matched");
			} else {
				System.out.println("Case Owner Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Owner Not Matched");
				selenium.reportFailure("Case Owner Not Matched");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("confirm case origin and case owner field")
	public void confirm_case_origin_and_case_owner_field(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(12000);
			selenium.waitForElementToBeVisible("CSOMCaseOwner");
			String caseOwner = selenium.getText("CSOMCaseOwner").toString();
			System.out.println(caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner Matched");
				selenium.test.log(LogStatus.PASS, "Case Owner Matched");
			} else {
				System.out.println("Case Owner Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Owner Not Matched");
				selenium.reportFailure("Case Owner Not Matched");
			}
			selenium.waitForElementToBeVisible("Case_Priority");
			String casePriority = selenium.getText("Case_Priority").toString();
			System.out.println(casePriority);
			if (casePriority.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Priority Matched");
				selenium.test.log(LogStatus.PASS, "Case Priority Matched");
			} else {
				System.out.println("Case Priority Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Priority Not Matched");
				selenium.reportFailure("Case Priority Not Matched");
			}
			selenium.waitForElementToBeVisible("Case_Origin");
			String caseOrigin = selenium.getText("Case_Origin").toString();
			System.out.println(caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(2))) {
				System.out.println("Case Origin Matched");
				selenium.test.log(LogStatus.PASS, "Case Origin Matched");
			} else {
				System.out.println("Case Origin Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Origin Not Matched");
				selenium.reportFailure("Case Origin Not Matched");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("confirm case origin")
	public void confirm_case_origin(DataTable table) {
		try {

			selenium.refresh();
			selenium.waitingTime(18000);
			List<String> data = table.transpose().asList(String.class);
			selenium.waitForElementToBeVisible("CSOMCaseOwner");
			String caseOwner = selenium.getText("CSOMCaseOwner").toString();
			System.out.println("caseOwner is -->" + caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Owner Matched");
				selenium.test.log(LogStatus.PASS, "Case Owner Matched");
			} else {
				System.out.println("Case Owner Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Owner Not Matched");
				selenium.reportFailure("Case Owner Not Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Origin");
			String caseOrigin = selenium.getText("Case_Origin").toString();
			System.out.println(caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Origin Matched");
				selenium.test.log(LogStatus.PASS, "Case Origin Matched");
			} else {
				System.out.println("Case Origin Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Origin Not Matched");
				selenium.reportFailure("Case Origin Not Matched");
			}
			selenium.waitingTime(6000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("confirm case owner")
	public void confirm_case_owner(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.waitForElementToBeVisible("CSOMCaseOwner");
			String caseOwner = selenium.getText("CSOMCaseOwner").toString();
			System.out.println(caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner Matched");
				selenium.test.log(LogStatus.PASS, "Case Owner Matched");
			} else {
				System.out.println("Case Owner Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Owner Not Matched");
				selenium.reportFailure("Case Owner Not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case failed");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("create a new case for ALEKS")
	public void created_a_new_case_for_ALEKS() {
		try {
			selenium.waitingTime(4000);
			if (selenium.isElementPresentFast("loginPopUpNew")) {
				System.out.println("I am inside loginPopUpNew method");
				selenium.clickLoop("loginPopUpNew");
				selenium.waitingTime(2000);
			} else if (selenium.isElementPresentFast("loginPopUp")) {
				System.out.println("I am inside loginPopup method");
				selenium.click("loginPopUp");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.typeData("Search_contact", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectContactName");
			selenium.jsClick("SelectContactName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "ALEKS");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Business_Hours_ALEKS");
			selenium.jsClick("Business_Hours_ALEKS");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Support_account");
			selenium.typeData("Support_account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults2");
			selenium.jsClick("ShowAllResults2");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Case_OriginOption1");
			selenium.jsClick("Case_OriginOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productDropDwn1");
			selenium.jsClick("productDropDwn1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSReasonOptn");
			selenium.jsClick("ALEKSReasonOptn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSSubReasonDrpDwn");
			selenium.jsClick("ALEKSSubReasonDrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSSubReasonOptn");
			selenium.jsClick("ALEKSSubReasonOptn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", "ALEKS Automation Demo Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSCaseInternalDescriptionTextBox");
			selenium.typeData("ALEKSCaseInternalDescriptionTextBox", "Automation Demo Test");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify the reason and sub reason fields")
	public void verify_the_incident_and_sub_incident_fields(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.scrollToElement("ALEKSIncident");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ALEKSIncident");
			String incident = selenium.getText("ALEKSIncident").toString();
			System.out.println(incident);
			if (incident.equalsIgnoreCase(data.get(0))) {
				System.out.println("Incident is Matched");
				selenium.test.log(LogStatus.PASS, "Incident is Matched");
			} else {
				System.out.println("Incident is not Matched");
				selenium.test.log(LogStatus.FAIL, "Incident is not Matched");
				selenium.reportFailure("Incident is not Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ALEKSSubIncident");
			String subIncident = selenium.getText("ALEKSSubIncident").toString();
			System.out.println(subIncident);
			if (subIncident.equalsIgnoreCase(data.get(1))) {
				System.out.println("Sub-Incident is Matched");
				selenium.test.log(LogStatus.PASS, "Sub-Incident is Matched");
			} else {
				System.out.println("Sub-Incident is not Matched");
				selenium.test.log(LogStatus.FAIL, "Sub-Incident is not Matched");
				selenium.reportFailure("Sub-Incident is not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("I verify the Jira Initial Assignee")
	public void i_verify_the_jira_initial_assignee() {
		try {
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption");
			selenium.jsClick("IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentOption");
			selenium.jsClick("Sub_IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGSaveBtn");
			selenium.jsClick("CXGSaveBtn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.scrollToElement("CXGEditCategory");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGEditCategory");
			selenium.jsClick("CXGEditCategory");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CXGCategoryDropDown");
			selenium.jsClick("CXGCategoryDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("CXGCategoryOptionPlatform");
			selenium.jsClick("CXGCategoryOptionPlatform");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGComponentDropDown");
			selenium.jsClick("CXGComponentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ComponentOptionConnect");
			selenium.jsClick("ComponentOptionConnect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("jiraTabBtn");
			selenium.jsClick("jiraTabBtn");
			selenium.scrolldown(200);
			selenium.waitForElementToBeVisible("JIRAInitialAssignee");
			String JiraAssignee = selenium.getText("JIRAInitialAssignee").trim().toString();
			System.out.println(JiraAssignee);
			if (JiraAssignee.equalsIgnoreCase("CXG Tier 2 Support")) {
				System.out.println("JiraAssignee is Matched");
				selenium.test.log(LogStatus.PASS, "JiraAssignee is Matched");
			} else {
				System.out.println("Jira Assignee is not Matched");
				selenium.test.log(LogStatus.FAIL, "Jira Assignee is not Matched");
				selenium.reportFailure("Jira Assignee is not Matched");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify other Jira Initial Assignee")
	public void verify_other_jira_initial_assignee() {
		try {
			selenium.waitingTime(14000);
			selenium.waitForElementToBeClickable("detailsTab");
			selenium.jsClick("detailsTab");
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.scrollToElement("CXGEditCategory");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGEditCategory");
			selenium.jsClick("CXGEditCategory");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CXGCategoryDropDown");
			selenium.jsClick("CXGCategoryDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CategoryOptionImprovement");
			selenium.jsClick("CategoryOptionImprovement");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGComponentDropDown");
			selenium.jsClick("CXGComponentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ComponentOptionExcel");
			selenium.jsClick("ComponentOptionExcel");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("jiraTabBtn");
			selenium.jsClick("jiraTabBtn");
			selenium.scrolldown(200);
			selenium.waitForElementToBeVisible("JIRAInitialAssignee");
			String JiraAssignee = selenium.getText("JIRAInitialAssignee").trim().toString();
			System.out.println(JiraAssignee);
			if (JiraAssignee.equalsIgnoreCase("rishi_mehta")) { //xin_lin
				System.out.println("JiraAssignee is Matched");
				selenium.test.log(LogStatus.PASS, "JiraAssignee is Matched");
			} else {
				System.out.println("Jira Assignee is not Matched");
				selenium.test.log(LogStatus.FAIL, "Jira Assignee is not Matched");
				selenium.reportFailure("Jira Assignee is not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("go to actions tab and validate the email")
	public void go_to_actions_tab_and_validate_the_email() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseActionTab");
			selenium.jsClick("CaseActionTab");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EmailComposeBtn");
			selenium.jsClick("EmailComposeBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CaseEmailFrom");
			selenium.jsClick("CaseEmailFrom");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseEmailOption");
			selenium.jsClick("CaseEmailOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseEmailSubject");
			selenium.typeData("CaseEmailSubject", "Automation Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EmailSendBtn");
			selenium.jsClick("EmailSendBtn");
			selenium.waitingTime(10000);
			selenium.scrolldown(-500);
			selenium.waitForElementToBeClickable("CaseEmailLink1");
			selenium.jsClick("CaseEmailLink1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseEmailVerifyLink");
			selenium.jsClick("CaseEmailVerifyLink");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("VerifyFromText");
			String backOrderUpdates = selenium.getText("VerifyFromText").toString();
			if (backOrderUpdates.equalsIgnoreCase("Backorder Updates")) {
				System.out.println("Back Order Update is Matched");
				selenium.test.log(LogStatus.PASS, "Back Order Update is Matched");
			} else {
				System.out.println("Back Order Update is not Matched");
				selenium.test.log(LogStatus.FAIL, "Back Order Update is not Matched");
				selenium.reportFailure("Back Order Update is not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("validate the component value")
	public void validate_the_component_value() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionConnect");
			selenium.jsClick("ProductOptionConnect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("click_onSubProduct");
			selenium.jsClick("click_onSubProduct");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionNoSubProduct");
			selenium.jsClick("ProductOptionNoSubProduct");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("VersionDropDown");
			selenium.jsClick("VersionDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("VersionOption");
			selenium.jsClick("VersionOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_categoryDropdownoption");
			selenium.jsClick("select_categoryDropdownoption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncident_CXG_Option");
			selenium.jsClick("SubIncident_CXG_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown");
			selenium.jsClick("ProductDisciplineDropdown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DisciplineOption1");
			selenium.jsClick("DisciplineOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Internal_Description1");
			selenium.clearText("Internal_Description1");
			selenium.typeData("Internal_Description1", "Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(8000);

			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("EditBtnContact");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditBtnContact");
			selenium.jsClick("EditBtnContact");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.typeData("Search_contact", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectContactName");
			selenium.jsClick("SelectContactName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppContactTypeValue");
			selenium.jsClick("OppContactTypeValue");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Support_account");
			selenium.typeData("Support_account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("search_producttextbox");
			selenium.jsClick("search_producttextbox");
			selenium.waitingTime(2000);
			String subject = "Biology";
			selenium.typeData("search_producttextbox", subject);
//			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("selectBioSubject");
//			selenium.hoverAndClick("selectBioSubject");
//			selenium.waitingTime(4000);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.clickLoop("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectProductName");
			selenium.jsClick("SelectProductName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CXGCategoryDropDown");
			selenium.jsClick("CXGCategoryDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("select_categoryDropdownoption");
			selenium.jsClick("select_categoryDropdownoption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGComponentDropDown");
			selenium.jsClick("CXGComponentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ComponentQuestionBank");
			selenium.jsClick("ComponentQuestionBank");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("VerifyComponentField");
			String componentField = selenium.getText("VerifyComponentField").toString();
			if (componentField.equalsIgnoreCase("Connect: Question Bank")) {
				System.out.println("Component Field Matched");
				selenium.test.log(LogStatus.PASS, "Component Field Matched");
			} else {
				System.out.println("Component Field Not Matched");
				selenium.test.log(LogStatus.FAIL, "Component Field Not Matched");
				selenium.reportFailure("Component Field Not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("validate the national house support fields")
	public void validate_the_national_house_support_fields(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.waitForElementToBeVisible("Case_Owner_New");
			String caseOwner = selenium.getText("Case_Owner_New").toString();
			System.out.println(caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner Matched");
				selenium.test.log(LogStatus.PASS, "Case Owner Matched");
			} else {
				System.out.println("Case Owner Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Owner Not Matched");
				selenium.reportFailure("Case Owner Not Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Origin_New");
			String caseOrigin = selenium.getText("Case_Origin_New").toString();
			System.out.println(caseOrigin);
			if (caseOrigin.equalsIgnoreCase(data.get(1))) {
				System.out.println("Case Origin Matched");
				selenium.test.log(LogStatus.PASS, "Case Origin Matched");
			} else {
				System.out.println("Case Origin Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Origin Not Matched");
				selenium.reportFailure("Case Origin Not Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Priority_New");
			String casePriority = selenium.getText("Case_Priority_New").toString();
			System.out.println(casePriority);
			if (casePriority.equalsIgnoreCase(data.get(2))) {
				System.out.println("Case Priority Matched");
				selenium.test.log(LogStatus.PASS, "Case Priority Matched");
			} else {
				System.out.println("Case Priority Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Priority Not Matched");
				selenium.reportFailure("Case Priority Not Matched");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(5000);
			selenium.waitForElementToBeVisible("Case_Record_Type");
			String recordType = selenium.getText("Case_Record_Type").toString();
			System.out.println(recordType);
			if (recordType.equalsIgnoreCase(data.get(3))) {
				System.out.println("Case Record Type Matched");
				selenium.test.log(LogStatus.PASS, "Case Record Type Matched");
			} else {
				System.out.println("Case Record Type Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Record Type Not Matched");
				selenium.reportFailure("Case Record Type Not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify the category dropdown picklist")
	public void verify_the_category_dropdown_picklist() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGProduct_Option");
			selenium.jsClick("CXGProduct_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("incident_option");
			selenium.jsClick("incident_option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption");
			selenium.jsClick("IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseSubIncidentDrpDwn01");
			selenium.jsClick("CaseSubIncidentDrpDwn01");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentOption");
			selenium.jsClick("Sub_IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Internal_Description1");
			selenium.typeData("Internal_Description1", "Test Dummy Data");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.scrollToElement("EditMHEProductBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditMHEProductBtn");
			selenium.jsClick("EditMHEProductBtn");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("search_producttextbox");
			selenium.jsClick("search_producttextbox");
			selenium.waitingTime(2000);
			String subject = "Biology";
			selenium.typeData("search_producttextbox", subject);

			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectProductName");
			selenium.jsClick("SelectProductName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CXGCategoryDropDown");
			selenium.jsClick("CXGCategoryDropDown");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentsuperFast("select_categoryDropdownoption") && selenium.isElementPresentsuperFast("CXGCategoryOptionPlatform") && selenium.isElementPresentsuperFast("Category_Option1") && selenium.isElementPresentsuperFast("CategoryOptionImprovement")) {
				System.out.println("All Picklist Values are Present");
				selenium.test.log(LogStatus.PASS, "All Picklist Values are Present");
			} else {
				System.out.println("All Picklist Values are not Present");
				selenium.test.log(LogStatus.FAIL, "All Picklist Values are Present");
				selenium.reportFailure("All Picklist Values are not Present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CategoryOptionImprovement");
			selenium.jsClick("CategoryOptionImprovement");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGComponentDropDown");
			selenium.jsClick("CXGComponentDropDown");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentsuperFast("Component_Option_PhiLS")) {
				System.out.println("Component Picklist Values is Present");
				selenium.test.log(LogStatus.PASS, "Component Picklist Values is Present");
			} else {
				System.out.println("Component Picklist Values is not Present");
				selenium.test.log(LogStatus.FAIL, "Component Picklist Values is not Present");
				selenium.reportFailure("Component Picklist Values is not Present");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("go to DTS link and verify")
	public void go_to_DTS_link_and_verify() {
		try {
			selenium.waitingTime(8000);
			selenium.navigateToURL("https://mh--uat.sandbox.my.site.com/DTS");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("DTSPageTeachersLink");
			selenium.jsClick("DTSPageTeachersLink");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("DTSPageMathLink");
			String mathLink = selenium.getText("DTSPageMathLink").toString();
			System.out.println(mathLink);
			if (mathLink.equalsIgnoreCase("Illustrative Math 2020 (6-12)")) {
				System.out.println("Illustrative Math Link Matched");
				selenium.test.log(LogStatus.PASS, "Illustrative Math Link Matched");
			} else {
				System.out.println("Illustrative Math Link Not Matched");
				selenium.test.log(LogStatus.FAIL, "Illustrative Math Link Not Matched");
				selenium.reportFailure("Illustrative Math Link Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("DTSPageSocialStudiesLink");
			String socialStudiesLink = selenium.getText("DTSPageSocialStudiesLink").toString();
			System.out.println(socialStudiesLink);
			if (socialStudiesLink.equalsIgnoreCase("Social Studies 2023/2024 (6-12)")) {
				System.out.println("Social Studies Link Matched");
				selenium.test.log(LogStatus.PASS, "Social Studies Link Matched");
			} else {
				System.out.println("Social Studies Link Not Matched");
				selenium.test.log(LogStatus.FAIL, "Social Studies Link Not Matched");
				selenium.reportFailure("Social Studies Link Not Matched");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("DTSPageStudentLink");
			selenium.jsClick("DTSPageStudentLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("DTSPageMathLink");
			mathLink = selenium.getText("DTSPageMathLink").toString();
			System.out.println(mathLink);
			if (mathLink.equalsIgnoreCase("Illustrative Math 2020 (6-12)")) {
				System.out.println("Illustrative Math Link Matched");
				selenium.test.log(LogStatus.PASS, "Illustrative Math Link Matched");
			} else {
				System.out.println("Illustrative Math Link Not Matched");
				selenium.test.log(LogStatus.FAIL, "Illustrative Math Link Not Matched");
				selenium.reportFailure("Illustrative Math Link Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("DTSPageSocialStudiesLink");
			socialStudiesLink = selenium.getText("DTSPageSocialStudiesLink").toString();
			System.out.println(socialStudiesLink);
			if (socialStudiesLink.equalsIgnoreCase("Social Studies 2023/2024 (6-12)")) {
				System.out.println("Social Studies Link Matched");
				selenium.test.log(LogStatus.PASS, "Social Studies Link Matched");
			} else {
				System.out.println("Social Studies Link Not Matched");
				selenium.test.log(LogStatus.FAIL, "Social Studies Link Not Matched");
				selenium.reportFailure("Social Studies Link Not Matched");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("I create new knowledge record")
	public void i_create_new_knowledge_record() {
		try {
			String random = selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("HowToRadioBtn");
			selenium.jsClick("HowToRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("KnowledgeTitleTextBox");
			selenium.typeData("KnowledgeTitleTextBox", "TestAutomation");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("KnowledgeUrlNameTextBox");
			selenium.typeData("KnowledgeUrlNameTextBox", random);
			selenium.waitingTime(2000);
			selenium.clearText("KnowledgeUrlNameTextBox");
			selenium.waitingTime(2000);
			selenium.typeData("KnowledgeUrlNameTextBox", random);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductGroupOption1");
			selenium.jsClick("ProductGroupOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductSelect");
			selenium.jsClick("ProductSelect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductGroupOption2");
			selenium.jsClick("ProductGroupOption2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductSelect");
			selenium.jsClick("ProductSelect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RecordSaveButton");
			selenium.jsClick("RecordSaveButton");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("ValidateProduct");
			String validateProduct = selenium.getText("ValidateProduct").toString();
			System.out.println("Product Group is : " + validateProduct);
			if (validateProduct.equalsIgnoreCase("Illustrative Math 2020;Social Studies 2023/2024 (6-12)")) {
				System.out.println("Product Group Matched");
				selenium.test.log(LogStatus.PASS, "Product Group Matched");
			} else {
				System.out.println("Product Group Not Matched");
				selenium.test.log(LogStatus.FAIL, "Product Group Not Matched");
				selenium.reportFailure("Product Group Not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("I confirm all the fields")
	public void i_confirm_all_the_fields() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Owner2");
			String caseOwner = selenium.getText("Case_Owner2").toString();
			System.out.println(caseOwner);
			if (caseOwner.equalsIgnoreCase("CSOM Returns Order Mgmt")) {
				System.out.println("Case Owner is Matched");
				selenium.test.log(LogStatus.PASS, "Case Owner is Matched");
			} else {
				System.out.println("Case Owner is Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Owner is Not Matched");
				selenium.reportFailure("Case Owner is Not Matched");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("VerifyCaseOriginSkill");
			String caseOriginSkill = selenium.getText("VerifyCaseOriginSkill").toString();
			System.out.println(caseOriginSkill);
			if (caseOriginSkill.equalsIgnoreCase("Backorder Updates Order Mgmt")) {
				System.out.println("Case Origin Skill is Matched");
				selenium.test.log(LogStatus.PASS, "Case Origin Skill is Matched");
			} else {
				System.out.println("Case Origin Skill is Not Matched");
				selenium.test.log(LogStatus.FAIL, "Case Origin Skill is Not Matched");
				selenium.reportFailure("Case Origin Skill is Not Matched");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@And("verify Discipline LOV")
	public void verify_Discipline_LOV()
	{
		try
		{
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionConnect");
			selenium.jsClick("ProductOptionConnect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown1");
			selenium.jsClick("ProductDisciplineDropdown1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DisciplineOption2");
			selenium.jsClick("DisciplineOption2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionMHReader");
			selenium.jsClick("ProductOptionMHReader");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown1");
			selenium.jsClick("ProductDisciplineDropdown1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DisciplineOption2");
			selenium.jsClick("DisciplineOption2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionOLC");
			selenium.jsClick("ProductOptionOLC");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown1");
			selenium.jsClick("ProductDisciplineDropdown1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DisciplineOption2");
			selenium.jsClick("DisciplineOption2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionTestGen");
			selenium.jsClick("ProductOptionTestGen");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown1");
			selenium.jsClick("ProductDisciplineDropdown1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DisciplineOption2");
			selenium.jsClick("DisciplineOption2");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.PASS, "All the expected fields are present");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@Then("verify Jira Initial Assignee")
	public void verify_the_jira_initial_assignee() {
		try {
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption");
			selenium.jsClick("IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentOption");
			selenium.jsClick("Sub_IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGSaveBtn");
			selenium.jsClick("CXGSaveBtn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.scrollToElement("CXGEditCategory");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGEditCategory");
			selenium.jsClick("CXGEditCategory");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CXGCategoryDropDown");
			selenium.jsClick("CXGCategoryDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("CXGCategoryOptionPlatform");
			selenium.jsClick("CXGCategoryOptionPlatform");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGComponentDropDown");
			selenium.jsClick("CXGComponentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("CXGProduct_Option");
			selenium.jsClick("CXGProduct_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("jiraTabBtn");
			selenium.jsClick("jiraTabBtn");
			selenium.scrolldown(200);
			selenium.waitForElementToBeVisible("JIRAInitialAssignee");
			String JiraAssignee = selenium.getText("JIRAInitialAssignee").trim().toString();
			System.out.println(JiraAssignee);
			if (JiraAssignee.equalsIgnoreCase("Sharpen")) {
				System.out.println("Jira Initial Assignee is Matched");
				selenium.test.log(LogStatus.PASS, "Jira Initial Assignee is Matched");
			} else {
				System.out.println("Jira Initial Assignee is not Matched");
				selenium.test.log(LogStatus.FAIL, "Jira Initial Assignee is not Matched");
				selenium.reportFailure("Jira Initial Assignee is not Matched");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("create a case for CSOM support")
	public void create_a_case_for_CSOM_support() {
		try {
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
			selenium.jsClick("caseOriginSkillDropdownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseOriginSkillOption");
			selenium.jsClick("CaseOriginSkillOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(12000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify picklist value in Action dropdown for ID1")
	public void verify_picklist_value_in_action_dropdown_for_id1() {
		try {
			selenium.waitingTime(4000);
			String url = selenium.getURL();
			selenium.waitForElementToBeClickable("Order_StageDropDown");
			selenium.jsClick("Order_StageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionPostOrder");
			selenium.jsClick("ProductOptionPostOrder");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_ReasonDropDown");
			selenium.jsClick("Request_ReasonDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RequestReasonWrongTitle");
			selenium.jsClick("RequestReasonWrongTitle");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action_DropDown");
			selenium.jsClick("Action_DropDown");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentsuperFast("ActionOptions")) {
				System.out.println("Picklist value is present");
				selenium.test.log(LogStatus.PASS, "Picklist value is present");
				selenium.jsClick("ActionOptions");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("Save_Button");
				selenium.jsClick("Save_Button");
				selenium.waitingTime(10000);
			} else {
				System.out.println("Picklist value is not present");
				selenium.test.log(LogStatus.FAIL, "Picklist value is not present");
				selenium.reportFailure("Picklist value is not present");
			}
			selenium.waitingTime(6000);
			if (!selenium.isElementPresentsuperFast("ActionOption1")) {
				System.out.println("Picklist value is not present");
				selenium.test.log(LogStatus.PASS, "Picklist value is not present");
			} else {
				System.out.println("Picklist value is present");
				selenium.test.log(LogStatus.FAIL, "Picklist value is present");
				selenium.reportFailure("Picklist value is present");
			}
			selenium.waitForElementToBeClickable("ActionDropDownNew");
			selenium.jsClick("ActionDropDownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ActionOptionAnyWrong");
			selenium.jsClick("ActionOptionAnyWrong");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("internalDescriptionHistorybtn");
			selenium.jsClick("internalDescriptionHistorybtn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("InternalDescriptionVerifyTextNew");
			String internalDescription = selenium.getText("InternalDescriptionVerifyTextNew").toString();
			System.out.println(internalDescription);
			if (internalDescription.contains("REQUEST PICKUP WITH CREDIT DUE FOR WRONG TITLE KEYED BY CSOM")) {
				System.out.println("Text Matched");
				selenium.test.log(LogStatus.PASS, "Text Matched");
			} else {
				System.out.println("Text Not Matched");
				selenium.test.log(LogStatus.FAIL, "Text Not Matched");
				selenium.reportFailure("Text Not Matched");
			}
			selenium.navigateToURL(url);
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify picklist value in Action dropdown for ID2")
	public void verify_picklist_value_in_action_dropdown_for_id2() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			String url = selenium.getURL();
			selenium.waitForElementToBeClickable("internalDescription2text");
			selenium.jsClick("internalDescription2text");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OrderStage2btn");
			selenium.jsClick("OrderStage2btn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionPostOrder");
			selenium.jsClick("ProductOptionPostOrder");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonCode2btn");
			selenium.jsClick("ReasonCode2btn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RequestReasonWrongTitle");
			selenium.jsClick("RequestReasonWrongTitle");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action2DropDownNew");
			selenium.jsClick("Action2DropDownNew");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentsuperFast("ActionOptions")) {
				System.out.println("Picklist value is present");
				selenium.test.log(LogStatus.PASS, "Picklist value is present");
				selenium.jsClick("ActionOptions");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("Save_Button2");
				selenium.jsClick("Save_Button2");
				selenium.waitingTime(10000);
			} else {
				System.out.println("Picklist value is not present");
				selenium.test.log(LogStatus.FAIL, "Picklist value is not present");
				selenium.reportFailure("Picklist value is not present");
			}
			selenium.waitingTime(2000);
			if (!selenium.isElementPresentsuperFast("ActionOption1")) {
				System.out.println("Picklist value is not present");
				selenium.test.log(LogStatus.PASS, "Picklist value is not present");
			} else {
				System.out.println("Picklist value is present");
				selenium.test.log(LogStatus.FAIL, "Picklist value is present");
				selenium.reportFailure("Picklist value is present");
			}
			selenium.waitForElementToBeClickable("Action2DropDownNew");
			selenium.jsClick("Action2DropDownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ActionOptionAnyWrong");
			selenium.jsClick("ActionOptionAnyWrong");
			selenium.waitingTime(4000);
			selenium.scrolldown(250);
			selenium.waitForElementToBeClickable("Save_Button2");
			selenium.jsClick("Save_Button2");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("internalDescriptionHistorybtn");
			selenium.jsClick("internalDescriptionHistorybtn");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("InternalDescriptionVerifyText1");
			String internalDescription = selenium.getText("InternalDescriptionVerifyText1").toString();
			System.out.println(internalDescription);
			if (internalDescription.contains("REQUEST PICKUP WITH CREDIT DUE FOR WRONG TITLE KEYED BY CSOM")) {
				System.out.println("Text Matched");
				selenium.test.log(LogStatus.PASS, "Text Matched");
			} else {
				System.out.println("Text Not Matched");
				selenium.test.log(LogStatus.FAIL, "Text Not Matched");
				selenium.reportFailure("Text Not Matched");
			}
			selenium.navigateToURL(url);
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify the order stage")
	public void verify_the_order_stage() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("Order_StageDropDown");
			selenium.jsClick("Order_StageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionPostOrder");
			selenium.jsClick("ProductOptionPostOrder");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_ReasonDropDown");
			selenium.jsClick("Request_ReasonDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RequestReasonOrderMaintenance");
			selenium.jsClick("RequestReasonOrderMaintenance");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubReasonDrpDwn");
			selenium.jsClick("SubReasonDrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubReasonOptionNew");
			selenium.jsClick("SubReasonOptionNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action_DropDown");
			selenium.jsClick("Action_DropDown");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentsuperFast("ActionOptionALEKSExt")) {
				System.out.println("Picklist value is present");
				selenium.test.log(LogStatus.PASS, "Picklist value is present");
				selenium.jsClick("ActionOptionALEKSExt");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("Save_Button");
				selenium.jsClick("Save_Button");
				selenium.waitingTime(10000);
			} else {
				System.out.println("Picklist value is not present");
				selenium.test.log(LogStatus.FAIL, "Picklist value is not present");
				selenium.reportFailure("Picklist value is not present");
			}
			selenium.waitForElementToBeClickable("ActionDropDownNew");
			selenium.jsClick("ActionDropDownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ActionOptionCancelledItem");
			selenium.jsClick("ActionOptionCancelledItem");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("internalDescriptionHistorybtn");
			selenium.jsClick("internalDescriptionHistorybtn");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("InternalDescriptionVerifyTextCaseDetails");
			String internalDescription = selenium.getText("InternalDescriptionVerifyTextCaseDetails").toString();
			System.out.println(internalDescription);
			if (internalDescription.contains("Case details")) {
				System.out.println("Text Matched");
				selenium.test.log(LogStatus.PASS, "Text Matched");
			} else {
				System.out.println("Text Not Matched");
				selenium.test.log(LogStatus.FAIL, "Text Not Matched");
				selenium.reportFailure("Text Not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}

	}

	@Then("I edit the newly created case 1")
	public void i_edit_the_newly_created_case_1() {
		try {
			selenium.waitForElementToBeVisible("getCaseNum");
			selenium.caseNumber = selenium.getText("getCaseNum").toString();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.jsClick("Search_contact");
			selenium.waitingTime(5000);
			selenium.typeData("Search_contact", "Sachin");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("contactNameSelect");
			selenium.jsClick("contactNameSelect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(30000);
			selenium.waitForElementToBeClickable("Order_StageDropDown");
			selenium.jsClick("Order_StageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OrderStageValue");
			selenium.jsClick("OrderStageValue");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_ReasonDropDown");
			selenium.jsClick("Request_ReasonDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_Reason");
			selenium.jsClick("Request_Reason");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action_DropDown");
			selenium.jsClick("Action_DropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ActionOptionAccountDenied");
			selenium.jsClick("ActionOptionAccountDenied");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(10000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("I edit the newly created case 2")
	public void i_edit_the_newly_created_case_2() {
		try {
			selenium.waitForElementToBeVisible("getCaseNum");
			selenium.NewCaseNum = selenium.getText("getCaseNum").toString();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.jsClick("Search_contact");
			selenium.waitingTime(5000);
			selenium.typeData("Search_contact", "Mohit");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("contactNameSelectNew");
			selenium.jsClick("contactNameSelectNew");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(30000);
			selenium.waitForElementToBeClickable("Order_StageDropDown");
			selenium.jsClick("Order_StageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OrderStageValue");
			selenium.jsClick("OrderStageValue");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_ReasonDropDown");
			selenium.jsClick("Request_ReasonDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_Reason");
			selenium.jsClick("Request_Reason");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action_DropDown");
			selenium.jsClick("Action_DropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ActionOptionAccountDenied");
			selenium.jsClick("ActionOptionAccountDenied");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(15000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("Click on mass case closure button")
	public void click_on_mass_case_closure_button() {
		try {
			String todayUrl = selenium.getTestDataFromPropertiesFile("CaseRecentlyViewedList");
			selenium.waitingTime(2000);
			selenium.navigateToURL(todayUrl);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("searchCaseInListView");
			selenium.typeData("searchCaseInListView", "DA Account Maintenance");		//There should be more than one case with subject as 'DA Account Maintenance' should be present under recently viewed list
			selenium.pressEnterKey();
			selenium.waitingTime(10000);
//			selenium.waitForElementToBeClickable("CaseNumberColumnInCaseList");
//			selenium.jsClick("CaseNumberColumnInCaseList");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("CheckBoxClick");
			selenium.jsClick("CheckBoxClick");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CheckBoxClick1");
			selenium.jsClick("CheckBoxClick1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MassCloseBtn");
			selenium.jsClick("MassCloseBtn");
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("switch_iFrame");
			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(3000);
			selenium.scrolldown(5000);
			selenium.waitingTime(4000);
			if (selenium.isElementPresentsuperFast("OrderStage2") && selenium.isElementPresentsuperFast("RequestReason2") && selenium.isElementPresentsuperFast("SubReason2") && selenium.isElementPresentsuperFast("Action2") && selenium.isElementPresentsuperFast("InternalDescriptionTextField")) {
				System.out.println("All Fields Are Available");
				selenium.test.log(LogStatus.PASS, "All Fields Are Available");
			} else {
				System.out.println("All Fields Are Not Available");
				selenium.test.log(LogStatus.FAIL, "All Fields Are Not Available");
				selenium.reportFailure("All Fields Are Not Available");
			}
			selenium.scrolldown(5000);
			Select dropdown = new Select(selenium.getElement("StatusDropDown"));
//			dropdown.selectByIndex(1);
			dropdown.selectByVisibleText("Closed - Unconfirmed");
			dropdown.selectByVisibleText("Closed");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ID1TextField");
			selenium.typeData("ID1TextField", "Demo");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseResolutionTextBox");
			selenium.typeData("CaseResolutionTextBox", "Test");
			selenium.waitingTime(2000);
			selenium.scrolldown(-5000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(15000);
			selenium.defaultframe();
			selenium.waitingTime(2000);
			todayUrl = selenium.getTestDataFromPropertiesFile("CaseRecentlyViewedList");
			selenium.waitingTime(2000);
			selenium.navigateToURL(todayUrl);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("searchCaseInListView");
			selenium.typeData("searchCaseInListView", "DA Account Maintenance");
			selenium.pressEnterKey();
			selenium.waitingTime(10000);
//			selenium.waitForElementToBeClickable("CaseNumberColumnInCaseList");
//			selenium.jsClick("CaseNumberColumnInCaseList");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("CaseLink1");
			selenium.jsClick("CaseLink1");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("Case_Status_New");
			String caseStatus = selenium.getText("Case_Status_New").toString();
			System.out.println(caseStatus);
			if (caseStatus.equalsIgnoreCase("Closed")) {
				System.out.println("Case is Closed");
				selenium.test.log(LogStatus.PASS, "Case is Closed");
			} else {
				System.out.println("Case is Not Closed");
				selenium.test.log(LogStatus.FAIL, "Case is Not Closed");
				selenium.reportFailure("Case is Not Closed");
			}
			todayUrl = selenium.getTestDataFromPropertiesFile("CaseRecentlyViewedList");
			selenium.waitingTime(2000);
			selenium.navigateToURL(todayUrl);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("searchCaseInListView");
			selenium.typeData("searchCaseInListView", "DA Account Maintenance");
			selenium.pressEnterKey();
			selenium.waitingTime(10000);
//			selenium.waitForElementToBeClickable("CaseNumberColumnInCaseList");
//			selenium.jsClick("CaseNumberColumnInCaseList");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("CaseLink2");
			selenium.jsClick("CaseLink2");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("Case_Status_New");
			caseStatus = selenium.getText("Case_Status_New").toString();
			System.out.println(caseStatus);
			if (caseStatus.equalsIgnoreCase("Closed")) {
				System.out.println("Case is Closed");
				selenium.test.log(LogStatus.PASS, "Case is Closed");
			} else {
				System.out.println("Case is Not Closed");
				selenium.test.log(LogStatus.FAIL, "Case is Not Closed");
				selenium.reportFailure("Case is Not Closed");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("Verify the featured content section")
	public void verify_the_featured_content_section() {
		try {
			String url = "https://mh--uat.sandbox.my.site.com/DTS/s/";
			selenium.navigateToURL(url);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("FeaturedContentLink");
			List<WebElement> count = selenium.getElements("FeaturedContentLink");
			selenium.waitingTime(2000);
			int linkCount = count.size();
			if (linkCount == 10) {
				System.out.println("10 Links are present");
				selenium.test.log(LogStatus.PASS, "10 Links are present");
			} else {
				System.out.println("Links are less than 10");
				selenium.test.log(LogStatus.FAIL, "Links are less than 10");
				selenium.reportFailure("Links are less than 10");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("RecentlyAddedUpdatedText");
			String recentlyAddedUpdatedText = selenium.getText("RecentlyAddedUpdatedText").toString();
			if (recentlyAddedUpdatedText.equalsIgnoreCase("Recently Added/Updated")) {
				System.out.println("Label is Present");
				selenium.test.log(LogStatus.PASS, "Label is present");
			} else {
				System.out.println("Label is not present");
				selenium.test.log(LogStatus.FAIL, "Label is not present");
				selenium.reportFailure("Label is not present");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("create a knowledge record")
	public void create_a_knowledge_record() {
		try {
			selenium.firstWindowHandle = selenium.getFirstWin();
			selenium.waitingTime(2000);
			selenium.randomString = selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("HowToRadioBtn");
			selenium.jsClick("HowToRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("KnowledgeTitleTextBox");
			selenium.typeData("KnowledgeTitleTextBox", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("KnowledgeUrlNameTextBox");
			selenium.typeData("KnowledgeUrlNameTextBox", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.clearText("KnowledgeUrlNameTextBox");
			selenium.waitingTime(2000);
			selenium.typeData("KnowledgeUrlNameTextBox", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductGroupOption1");
			selenium.jsClick("ProductGroupOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductSelect");
			selenium.jsClick("ProductSelect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductGroupOption2");
			selenium.jsClick("ProductGroupOption2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductSelect");
			selenium.jsClick("ProductSelect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IsFeaturedCheckBox");
			selenium.jsClick("IsFeaturedCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("VisibleInKnowledgeBaseCheckBox");
			selenium.jsClick("VisibleInKnowledgeBaseCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("VisibleToCustomerCheckBox");
			selenium.jsClick("VisibleToCustomerCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("VisibleToPartnerCheckBox");
			selenium.jsClick("VisibleToPartnerCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnNew1");
			selenium.jsClick("SaveBtnNew1");
			selenium.waitingTime(8000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("edit the record and publish")
	public void edit_the_record_and_publish() {
		try {
			selenium.waitForElementToBeClickable("ExpandAllDropDownBtn");
			selenium.jsClick("ExpandAllDropDownBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditOption");
			selenium.jsClick("EditOption");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ExpandAllBtn");
			selenium.jsClick("ExpandAllBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DTSTopicsCheckBox");
			selenium.jsClick("DTSTopicsCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnNew1");
			selenium.jsClick("SaveBtnNew1");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("PublishButton");
			selenium.jsClick("PublishButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("PublishNowButton");
			selenium.jsClick("PublishNowButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("ArticleStatus");
			System.out.println("The Article is published successfully");
			selenium.test.log(LogStatus.INFO, "The Article is published successfully");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("go the DTS community page and verify")
	public void go_to_the_dts_community_page_and_verify() {
		try {
			String dtsUrl = "https://mh--uat.sandbox.my.site.com/DTS/s/";
			selenium.openURLinNewTab(dtsUrl);
			selenium.waitingTime(12000);
			selenium.waitForElementToBeVisible("FeaturedContentLink");
			List<WebElement> count = selenium.getElements("FeaturedContentLink");
			selenium.waitingTime(2000);
			int linkCount = count.size();
			if (linkCount == 10) {
				System.out.println("10 Links are present");
				selenium.test.log(LogStatus.PASS, "10 Links are present");
			} else {
				System.out.println("Links are less than 10");
				selenium.test.log(LogStatus.FAIL, "Links are less than 10");
				selenium.reportFailure("Links are less than 10");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("RecentlyAddedUpdatedText");
			String recentlyAddedUpdatedText = selenium.getText("RecentlyAddedUpdatedText").toString();
			if (recentlyAddedUpdatedText.equalsIgnoreCase("Recently Added/Updated")) {
				System.out.println("Label is Present");
				selenium.test.log(LogStatus.PASS, "Label is present");
			} else {
				System.out.println("Label is not present");
				selenium.test.log(LogStatus.FAIL, "Label is not present");
				selenium.reportFailure("Label is not present");
			}
			selenium.waitingTime(2000);
			String DtsXpath = selenium.getDynamicXpathData("anchorTextcontains", selenium.randomString, "endContains");
			System.out.println("caseXpath is " + DtsXpath);
			selenium.clickXpath(DtsXpath);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("VerifyDTSText");
			String link = selenium.getText("VerifyDTSText").toString();
			if (link.equalsIgnoreCase(selenium.randomString)) {
				System.out.println("Link is available");
				selenium.test.log(LogStatus.PASS, "Link is available");
			} else {
				System.out.println("Link is not available");
				selenium.test.log(LogStatus.PASS, "Link is not available");
				selenium.reportFailure("Link is not available");
			}
			selenium.navigateToURL(dtsUrl);
			selenium.waitingTime(4000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("update the record and verify again")
	public void update_the_record_and_verify_again() {
		try {
			selenium.switchToFirstWin(selenium.firstWindowHandle);
			String updateLink = selenium.randomString + " Edited";
			System.out.println("String After Edit is : " + updateLink);
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("EditAsDraftBtn");
			selenium.jsClick("EditAsDraftBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ConfirmEditAsDraftBtn");
			selenium.jsClick("ConfirmEditAsDraftBtn");
			selenium.waitingTime(10000);

			selenium.waitForElementToBeClickable("KnowledgeTitleTextBox");
			selenium.typeData("KnowledgeTitleTextBox", updateLink);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("KnowledgeUrlNameTextBox");
			selenium.typeData("KnowledgeUrlNameTextBox", updateLink);
			selenium.waitingTime(2000);
			selenium.clearText("KnowledgeUrlNameTextBox");
			selenium.waitingTime(2000);
			selenium.typeData("KnowledgeUrlNameTextBox", updateLink);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnNew1");
			selenium.jsClick("SaveBtnNew1");
			selenium.waitingTime(2000);
			selenium.jsClick("SaveBtnNew1");
			selenium.waitingTime(8000);

			selenium.waitForElementToBeClickable("PublishButton");
			selenium.jsClick("PublishButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("PublishNowButton");
			selenium.jsClick("PublishNowButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("ArticleStatus");
			System.out.println("The Article is published successfully");
			selenium.test.log(LogStatus.INFO, "The Article is published successfully");
			selenium.waitingTime(6000);
			selenium.switchToChildWindow();
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(10000);
			String DtsXpath = selenium.getDynamicXpathData("anchorTextcontains", updateLink, "endContains");
			System.out.println("caseXpath is " + DtsXpath);
			selenium.clickXpath(DtsXpath);
			selenium.waitingTime(12000);
			selenium.waitForElementToBeVisible("VerifyDTSText");
			String link = selenium.getText("VerifyDTSText").toString();
			if (link.equalsIgnoreCase(updateLink)) {
				System.out.println("Link is available");
				selenium.test.log(LogStatus.PASS, "Link is available");
			} else {
				System.out.println("Link is not available");
				selenium.test.log(LogStatus.PASS, "Link is not available");
				selenium.reportFailure("Link is not available");
			}
			selenium.waitingTime(2000);
			String dtsUrl = "https://mh--uat.sandbox.my.site.com/DTS/s/";
			selenium.navigateToURL(dtsUrl);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("UpdatedTag");
			String updatedTag = selenium.getText("UpdatedTag").toString();
			System.out.println(updatedTag);
			if (updatedTag.equalsIgnoreCase("Updated!")) {
				System.out.println("Updated Tag is available");
				selenium.test.log(LogStatus.PASS, "Updated Tag is available");
			} else {
				System.out.println("Updated Tag is not available");
				selenium.test.log(LogStatus.PASS, "Updated Tag is not available");
				selenium.reportFailure("Updated Tag is not available");
			}
		}catch (Exception e) {
				selenium.test.log(LogStatus.FAIL, "Test case fail");
				selenium.reportFailure("Test Case failed" + e.getMessage());
			}

		}


	@Then("go to DTS community page and verify the blades")
	public void go_to_DTS_community_page_and_verify_the_blades(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			String dtsUrl = "https://mh--uat.sandbox.my.site.com/DTS/s/";
			selenium.navigateToURL(dtsUrl);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("DTSPageTeachersLink");
			selenium.jsClick("DTSPageTeachersLink");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("select_DTSProgram");
			selenium.jsClick("select_DTSProgram");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentsuperFast("user_guideBtnn"));
			{
				user_guideBtn = selenium.getText("user_guideBtnn").toString();
				System.out.println("Value of AccessManage is " + user_guideBtn);
			}
			if(selenium.isElementPresentsuperFast("resource_Btnn"));
			{
				resource_Btn = selenium.getText("resource_Btnn").toString();
				System.out.println("value is " + resource_Btn);
			}
			if(selenium.isElementPresentsuperFast("dashboard_Btn"));
			{
				dashboardButton = selenium.getText("dashboard_Btn").toString();
				System.out.println("value is " + dashboardButton);
			}
//			if(selenium.isElementPresentsuperFast("button_FAQs"));
//			{
//				buttonFaQs = selenium.getText("button_FAQs").toString();
//				System.out.println("value is " + buttonFaQs);
//			}
//			if(selenium.isElementPresentsuperFast("button_Reset"));
//			{
//				button_Reset = selenium.getText("button_Reset").toString();
//				System.out.println("value is " + button_Reset);
//			}
			selenium.waitingTime(2000);
			if (user_guideBtn.equalsIgnoreCase(data.get(0)) || resource_Btn.equalsIgnoreCase(data.get(1))
					|| dashboardButton.equalsIgnoreCase(data.get(2))) {
				System.out.println(" Pass : Blades Are Presnt In Alphabetical Order ");
				selenium.test.log(LogStatus.PASS, "Blades Are Presnt In Alphabetical Order");
				selenium.takeScreenShot();
			} else {
				System.out.println("Blades Are not Presnt In Alphabetical Order");
				selenium.test.log(LogStatus.FAIL, "Blades Are not Presnt In Alphabetical Order");
				selenium.reportFailure("Blades Are Not Presnt In Alphabetical Order");
			}
//			selenium.waitingTime(4000);
//			selenium.navigateToURL(dtsUrl);
//			selenium.waitingTime(4000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}
	@Then("verify blades are arranged through quick link for Administration")
	public void verify_blades_are_arranged_through_quick_link_for_Administration(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			String dtsUrl = "https://mh--uat.sandbox.my.site.com/DTS/s/";
//			selenium.navigateToURL(dtsUrl);
			selenium.waitingTime(5000);
//			selenium.scrollToElement("quick_linkBtn");
			selenium.scrolldown(5000);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("quick_linkBtn");
			selenium.jsClick("quick_linkBtn");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentsuperFast("select_accessManager"));
			{
				accessManager = selenium.getText("select_accessManager").toString();
				System.out.println("Value of AccessManage is " + accessManager);
			}
			if(selenium.isElementPresentsuperFast("buip_Btn"));
			{
				buip_Btn = selenium.getText("buip_Btn").toString();
				System.out.println("value is " + buip_Btn);
			}
//			if(selenium.isElementPresentsuperFast("button_Canvas"));
//			{
//				button_Canvas = selenium.getText("button_Canvas").toString();
//				System.out.println("value is " + button_Canvas);
//			}
//			if(selenium.isElementPresentsuperFast("button_License"));
//			{
//				button_License = selenium.getText("button_License").toString();
//				System.out.println("value is " + button_License);
//			}
			if(selenium.isElementPresentsuperFast("report_Btn"));
			{
				report_Btn = selenium.getText("report_Btn").toString();
				System.out.println("value is " + report_Btn);
			}
			if(selenium.isElementPresentsuperFast("user_Btn"));
			{
				user_Btn = selenium.getText("user_Btn").toString();
				System.out.println("value is " + user_Btn);
			}

			if (accessManager.equalsIgnoreCase(data.get(0)) || buip_Btn.equalsIgnoreCase(data.get(1))
					|| button_Canvas.equalsIgnoreCase(data.get(2)) || button_License.equalsIgnoreCase(data.get(3))
					|| report_Btn.equalsIgnoreCase(data.get(4)) || user_Btn.equalsIgnoreCase(data.get(5))) {
				System.out.println(" Pass : Blades Are Presnt In Alphabetical Order In Quick Link");
				selenium.test.log(LogStatus.PASS, "Blades Are Presnt In Alphabetical Order");
				selenium.takeScreenShot();
			} else {
				System.out.println("Blades Are not Presnt In Alphabetical Order");
				selenium.test.log(LogStatus.FAIL, "Blades Are not Presnt In Alphabetical Order");
				selenium.reportFailure("Blades Are Not Presnt In Alphabetical Order");
			}
			selenium.waitingTime(5000);
			selenium.navigateToURL(dtsUrl);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("all_UserBtn");
			selenium.jsClick("all_UserBtn");
			selenium.waitingTime(4000);
			String roster_Bttn= selenium.getText("roster_Btn").toString();
			System.out.println("Value of AddOn is " +roster_Bttn);
			String errormsg= selenium.getText("errormsg_Btn").toString();
			System.out.println("Value of errormsg is " +errormsg);
			String MCGBtn= selenium.getText("mcGrawhill_Btn").toString();
			System.out.println("Value of MCGBtn is" +MCGBtn);
			String simplifiedLogin= selenium.getText("login_Btn").toString();
			System.out.println("Value of simplified is" +simplifiedLogin);
//			String ssoBtn= selenium.getText("sso_Btn").toString();
//			System.out.println("Value of SSO is" + ssoBtn);
			if(roster_Bttn.equalsIgnoreCase(data.get(6))&& errormsg.equalsIgnoreCase(data.get(7))
			&& MCGBtn.equalsIgnoreCase(data.get(8))&& simplifiedLogin.equalsIgnoreCase(data.get(9)))
			{
				System.out.println(" Pass : Blades Are Presnt In Alphabetical Order In Quick Link");
				selenium.test.log(LogStatus.PASS, "Blades Are Presnt In Alphabetical Order");
				selenium.takeScreenShot();
			}
			else {
				System.out.println("Blades Are not Presnt In Alphabetical Order");
				selenium.test.log(LogStatus.FAIL, "Blades Are not Presnt In Alphabetical Order");
				selenium.reportFailure("Blades Are Not Presnt In Alphabetical Order");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}

	@Then("verify article is arranged as per blade in alphabetical order")
	public void verify_article_is_arranged_as_per_blade_in_alphabetical_order() {
		try {
			selenium.waitingTime(5000);
			String dtsUrl = "https://mh--uat.sandbox.my.site.com/DTS/s/";
			selenium.navigateToURL(dtsUrl);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("all_userLink");
			selenium.jsClick("all_userLink");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("button_Canvas");
			selenium.jsClick("button_Canvas");
			selenium.waitForElementToBeVisible("article_Btn1");
			String articletName=selenium.getText("article_Btn1").toString();
			System.out.println("Article name is" +articletName );
			if(selenium.isElementPresentsuperFast("article_Btn1")) {
				System.out.println("Pass : Article is present in arranged order in blade");
				selenium.test.log(LogStatus.PASS, "Article is present");
				selenium.takeScreenShot();
			} else {
				System.out.println("Article is not present");
				selenium.test.log(LogStatus.FAIL, "Article is not present");
				selenium.reportFailure("Article is not present");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test case fail");
			selenium.reportFailure("Test Case failed" + e.getMessage());
		}
	}
}



