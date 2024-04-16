package com.mhe.salesforce.testcases;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEUserCreatesStrategyWorksheetTest {
	WebConnector selenium = WebConnector.getInstance();
	String WSOpp_URL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FTvZKAA1/view";

	@Then("^create a strategy worksheet$")
	public void create_strategy_worksheet() throws InterruptedException {
		try {
		selenium.navigateToURL(WSOpp_URL);
		selenium.waitingTime(8000);
		selenium.waitForElementToBeVisible("courseNameGetText");
		String course = selenium.getText("courseNameGetText").toString();
		selenium.scrollToElement("totalEnrollmentGetText");
		String totalEnrollment = selenium.getText("totalEnrollmentGetText").toString();
		String fallEnrollment = selenium.getText("fallEnrollmentGetText").toString();
		System.out.println("fallEnrollment" + fallEnrollment);
		selenium.scrollToElement("decisionDateGetText");
		// String decisionDate = selenium.getText("decisionDateGetText").toString();

		selenium.scrollToElement("strategyWorksheetBtn");
		selenium.waitingTime(2000);
		selenium.scrolldown(-200);
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("strategyWorksheetBtn");
		selenium.jsClick("strategyWorksheetBtn");
		selenium.waitingTime(10000);
		selenium.refresh();
		selenium.waitingTime(10000);
		if(selenium.isElementPresentFast("strategyWorksheetBtn"))
		{
			System.out.println("strategyWorksheetBtn did not get clicked, so trying..");
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.click("strategyWorksheetBtn");
			selenium.waitingTime(10000);
		}
		selenium.waitForElementToBeVisible("productframeUat");
		selenium.switchToMultipleFrame("productframeUat");
		selenium.waitingTime(10000);

		selenium.waitForElementToBeVisible("opportunityNameSWGetText");
		String oppName = selenium.getText("opportunityNameSWGetText").toString();
		String expected_oppName = "KANSAS STATE UNIVERSITY Zoology 2021 Fall Service Adopted";
		//selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
		System.out.println("oppName" + oppName + "expected_oppName" + expected_oppName );

		if (oppName.equalsIgnoreCase(expected_oppName)) {
			selenium.test.log(LogStatus.PASS, "Opportunity name is pre-populated as: " + oppName);
		} else {
			selenium.test.log(LogStatus.FAIL, "Opportunity name value is blank");
			selenium.reportFailure("Opportunity name value is blank");
		}

		String accntName = selenium.getText("accountNameSWGetText").toString();
		String expected_accntName = "KANSAS STATE UNIVERSITY";
				//selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
		System.out.println("accntName" + accntName + "expected_accntName" + expected_accntName );
		if (accntName.equalsIgnoreCase(expected_accntName)) {
			selenium.test.log(LogStatus.PASS, "Account name is pre-populated as: " + accntName);
		} else {
			selenium.test.log(LogStatus.FAIL, "Account name value is blank");
			selenium.reportFailure("Account name value is blank");
		}

		String courseName = selenium.getText("courseNameSWGetText").toString();
		System.out.println("courseName" + courseName + "course" + course );
		if (courseName.equalsIgnoreCase(course)) {
			selenium.test.log(LogStatus.PASS, "Course name is pre-populated as: " + course);
		} else {
			selenium.test.log(LogStatus.FAIL, "Course name value is blank");
			selenium.reportFailure("Course name value is blank");
		}

		String totalEnroll = selenium.getText("totalEnrollmentSWGetText").toString();
		System.out.println("totalEnroll" + totalEnroll + "totalEnrollment" + totalEnrollment );
		if (totalEnroll.equalsIgnoreCase(totalEnrollment)) {
			selenium.test.log(LogStatus.PASS, "Total Enrollment is pre-populated as: " + totalEnroll);
		} else {
			selenium.test.log(LogStatus.FAIL, "Total Enrollment value is blank");
			selenium.reportFailure("Total Enrollment value is blank");
		}

		String fallEnroll = selenium.getText("fallEnrollmentSWGetText").toString();
		System.out.println("fallEnroll" + fallEnroll + "fallEnrollment" + fallEnrollment );

		if (fallEnroll.equalsIgnoreCase(fallEnrollment)) {
			selenium.test.log(LogStatus.PASS, "Fall Enrollment is pre-populated as: " + fallEnroll);
		} else {
			selenium.test.log(LogStatus.FAIL, "Fall Enrollment value is blank");
			selenium.reportFailure("Fall Enrollment value is blank");
		}

		selenium.waitForElementToBeClickable("voteTallyEditIcon");
		selenium.click("voteTallyEditIcon");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("voteTallyDrpDwn");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("voteTallyDrpDwn", "Vote Tally");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("votingStructureEdit");
		selenium.click("votingStructureEdit");
		selenium.waitingTime(2000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("votingStructureDrpDwn");
		selenium.waitingTime(5000);
		selenium.selectDropdownText("votingStructureDrpDwn", "Voting Structure");
		selenium.waitingTime(5000);

		selenium.scrollToElement("professorSectionHeader");

		String professor = selenium.getText("professorNameSWGetText").toString();
		System.out.println("professor is :" + professor);
		if (professor != null) {
			selenium.test.log(LogStatus.PASS, "Professor field is pre-populated as: " + professor);
		} else {
			selenium.test.log(LogStatus.FAIL, "Professor field value is blank");
			selenium.reportFailure("Professor field value is blank");
		}
		selenium.waitForElementToBeClickable("votingForMheEditIcon");
		selenium.jsClick("votingForMheEditIcon");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("votingForMheDrpDwn", "Voting for MHE?New");		//No Vote
		selenium.waitingTime(2000);
//		selenium.selectDropdownText("votingForMheDrpDwn", "Voting for MHE?");		//No
//		selenium.waitingTime(2000);
		/*selenium.waitForElementToBeClickable("decisionDriverEditIcon");
		selenium.click("decisionDriverEditIcon");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("decisionDriverDrpDwn");
		selenium.selectDropdownText("decisionDriverDrpDwn", "Decision Driver");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("decisionMakerEditIcon");

		selenium.click("decisionMakerEditIcon");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("decisionMakerDrpDwn");
		selenium.selectDropdownText("decisionMakerDrpDwn", "Decision Maker");
		selenium.waitingTime(2000);*/
//		selenium.waitForElementToBeClickable("instructorTypeEditIcon");
//		selenium.click("instructorTypeEditIcon");
//		selenium.waitingTime(2000);
//		selenium.waitForElementToBeVisible("instructorTypeDrpDwn");
//		selenium.selectDropdownText("instructorTypeDrpDwn", "Instructor Type");
//		selenium.waitingTime(2000);
		
		Assert.assertFalse(selenium.isElementPresentsuperFast("instructorTypeDrpDwn"));
		String expected = selenium.getText("WSColumnNameBuyingCriteriaGetText");
		String actual = "Buying Criteria";
		System.out.println("expected" + expected);
		Assert.assertEquals(expected, actual);
		
		Assert.assertTrue(selenium.isElementPresentFast("PrimaryInterestHelpIcon"));
		Assert.assertTrue(selenium.isElementPresentFast("BuyingCriteriaHelpIcon"));
		Assert.assertTrue(selenium.isElementPresentFast("RiskVsRewardHelpIcon"));
		Assert.assertTrue(selenium.isElementPresentFast("IndividulaMotiveHelpIcon"));

		Calendar calendar = Calendar.getInstance();
		String todaysdate = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		selenium.waitingTime(2000);

		System.out.println(todaysdate);
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("Button_Save");
		selenium.clickLoop("Button_Save");
		selenium.waitingTime(7000);

		selenium.switchOutOfFrame();
		selenium.waitForElementToBeClickable("strategyWorksheetBtn");
		selenium.clickLoop("strategyWorksheetBtn");
		selenium.waitingTime(20000);
		selenium.waitForElementToBeVisible("productframeUat");
		selenium.switchToMultipleFrame("productframeUat");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeVisible("strategyWorksheetHeader");
		selenium.strategy=selenium.getURL();
		System.out.println(selenium.strategy);
		String vote = selenium.getTextLoop("voteNew");
		String expected_voteTally = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Vote Tally");
		System.out.println("vote" + vote + "expected_vote" + expected_voteTally );
		if (vote.equalsIgnoreCase(expected_voteTally)) {
			selenium.test.log(LogStatus.PASS, "Changes are reflecting as: " + vote);
			System.out.println("PASS");
		} else {
			selenium.test.log(LogStatus.FAIL, "Changes are not reflecting");
			selenium.reportFailure("Changes are not reflecting");
			System.out.println("FAIL");
		}
		selenium.switchOutOfFrame();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^create a strategy worksheet for marketing user$")
	public void create_strategy_worksheet_mkt() throws InterruptedException {
		try {

		selenium.search("Opportunity Name Mkt");
		selenium.waitingTime(2000);
		String xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name Mkt", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(xpath);
		selenium.waitingTime(4000);
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.waitForElementToBeVisible("courseNameGetText");
		String course = selenium.getText("courseNameGetText").toString();
		System.out.println("course -->" + course);
		selenium.scrollToElement("totalEnrollmentGetText");
		selenium.waitingTime(2000);
		selenium.scrolldown(-200);
		selenium.waitingTime(2000);
		String totalEnrollment = selenium.getText("totalEnrollmentGetText").toString().replaceAll(",", "");
		System.out.println("totalEnrollment -->" + totalEnrollment);
		String summerEnrollment = selenium.getTextLoop("summerEnrollmentGetText").toString();
		System.out.println("summerEnrollment -->" + summerEnrollment);
		selenium.scrollToElement("decisionDateGetText");
		/*selenium.scrollToElement("strategyWorksheetBtn");
		selenium.waitingTime(2000);
		selenium.scrolldown(-200);
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("strategyWorksheetBtn");
		selenium.clickLoop("strategyWorksheetBtn");
		selenium.waitingTime(20000);
		selenium.waitForElementToBeVisible("productframeUat");
		selenium.switchToMultipleFrame("productframeUat");
		selenium.waitForElementToBeVisible("strategyWorksheetHeader");*/
		
		selenium.waitingTime(5000);
		selenium.refresh();
		selenium.waitingTime(10000);
		selenium.takeScreenShot();
		selenium.waitForElementToBeClickable("strategyWorksheetBtn");
		selenium.click("strategyWorksheetBtn");
		selenium.waitingTime(10000);
		selenium.takeScreenShot();

		if(!selenium.isElementPresentFast("switch_iFrame")) {
			System.out.println("strategyWorksheetBtn not clicked, refreshing page..");
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("strategyWorksheetBtn");
			selenium.clickLoop("strategyWorksheetBtn");
			selenium.waitingTime(10000);
			selenium.takeScreenShot();
		}
		selenium.refresh();
		selenium.waitingTime(10000);
		selenium.waitForElementToBeVisible("switch_iFrame");
		selenium.switchToFrame("switch_iFrame");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("opportunityNameSWGetText");

		String oppName = selenium.getText("opportunityNameSWGetText").toString();
		String expected_oppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name Mkt");
		if (oppName.equalsIgnoreCase(expected_oppName)) {
			selenium.test.log(LogStatus.PASS, "Opportunity name is pre-populated as: " + oppName);
		} else {
			selenium.test.log(LogStatus.FAIL, "Opportunity name value is blank");
			selenium.reportFailure("Opportunity name value is blank");
		}

		String accntName = selenium.getText("accountNameSWGetText").toString();
		String expected_accntName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name Mkt");
		if (accntName.equalsIgnoreCase(expected_accntName)) {
			selenium.test.log(LogStatus.PASS, "Account name is pre-populated as: " + accntName);
		} else {
			selenium.test.log(LogStatus.FAIL, "Account name value is blank");
			selenium.reportFailure("Account name value is blank");
		}

		String courseName = selenium.getText("courseNameSWGetText").toString();
		if (courseName.equalsIgnoreCase(course)) {
			selenium.test.log(LogStatus.PASS, "Course name is pre-populated as: " + course);
		} else {
			selenium.test.log(LogStatus.FAIL, "Course name value is blank");
			selenium.reportFailure("Course name value is blank");
		}

		String totalEnroll = selenium.getText("totalEnrollmentSWGetText").toString().replaceAll(",", "");
		if (totalEnroll.equalsIgnoreCase(totalEnrollment)) {
			selenium.test.log(LogStatus.PASS, "Total Enrollment is pre-populated as: " + totalEnroll);
		} else {
			selenium.test.log(LogStatus.FAIL, "Total Enrollment value is blank");
			selenium.reportFailure("Total Enrollment value is blank");
		}

		String summerEnroll = selenium.getText("fallEnrollmentSWGetText").toString();
		if (summerEnroll.equalsIgnoreCase(summerEnrollment)) {
			selenium.test.log(LogStatus.PASS, "Summer Enrollment is pre-populated as: " + summerEnroll);
		} else {
			selenium.test.log(LogStatus.FAIL, "Summer Enrollment value is blank");
			selenium.reportFailure("Summer Enrollment value is blank");
		}

		selenium.waitForElementToBeClickable("voteTallyEditIcon");
		selenium.click("voteTallyEditIcon");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("voteTallyDrpDwn");
		selenium.selectDropdownText("voteTallyDrpDwn", "Vote Tally");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("votingStructureEditIcon");

		selenium.click("votingStructureEditIcon");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("votingStructureDrpDwn");
		selenium.selectDropdownText("votingStructureDrpDwn", "Voting Structure");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("professorSectionHeader");

		selenium.scrollToElement("professorSectionHeader");

		String professor = selenium.getText("professorNameSWGetText").toString();
		if (professor != null) {
			selenium.test.log(LogStatus.PASS, "Professor field is pre-populated as: " + professor);
		} else {
			selenium.test.log(LogStatus.FAIL, "Professor field value is blank");
			selenium.reportFailure("Professor field value is blank");
		}
		selenium.waitForElementToBeClickable("votingForMheEditIcon");
		selenium.jsClick("votingForMheEditIcon");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("votingForMheDrpDwn");
		selenium.selectDropdownText("votingForMheDrpDwn", "Voting for MHE?");
//		selenium.waitingTime(2000);
		/*selenium.waitForElementToBeClickable("decisionDriverEditIcon");

		selenium.click("decisionDriverEditIcon");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("decisionDriverDrpDwn");
		selenium.selectDropdownText("decisionDriverDrpDwn", "Decision Driver");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("decisionMakerEditIcon");

		selenium.click("decisionMakerEditIcon");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("decisionMakerDrpDwn");
		selenium.selectDropdownText("decisionMakerDrpDwn", "Decision Maker");
//		selenium.waitingTime(2000);*/

//		selenium.waitForElementToBeClickable("instructorTypeEditIcon");
//		selenium.click("instructorTypeEditIcon");
//		selenium.waitingTime(2000);
//		selenium.waitForElementToBeVisible("instructorTypeDrpDwn");
//		selenium.selectDropdownText("instructorTypeDrpDwn", "Instructor Type");
//		selenium.waitingTime(2000);

		Calendar calendar = Calendar.getInstance();
		String todaysdate = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		selenium.waitForElementToBeClickable("dateBtn");
		selenium.click("dateBtn");
		selenium.waitingTime(2000);
		selenium.clickDynamicUsingXpath("dateSelectDynamic", todaysdate, "end");
		System.out.println(todaysdate);
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Button_Save");
		selenium.clickLoop("Button_Save");
		selenium.waitingTime(7000);

		selenium.switchOutOfFrame();
		selenium.waitForElementToBeClickable("strategyWorksheetBtn");
		selenium.clickLoop("strategyWorksheetBtn");
		selenium.waitingTime(20000);
		selenium.waitForElementToBeVisible("productframeUat");
		selenium.switchToMultipleFrame("productframeUat");

		selenium.waitForElementToBeVisible("strategyWorksheetHeader");

		String voteTally = selenium.getTextLoop("voteNew").toString();
		String expected_voteTally = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Vote Tally");
		if (voteTally.equalsIgnoreCase(expected_voteTally)) {
			selenium.test.log(LogStatus.PASS, "Changes are reflecting as: " + voteTally);
		} else {
			selenium.test.log(LogStatus.FAIL, "Changes are not reflecting");
			selenium.reportFailure("Changes are not reflecting");
		}
		selenium.switchOutOfFrame();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error occurred");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

}
