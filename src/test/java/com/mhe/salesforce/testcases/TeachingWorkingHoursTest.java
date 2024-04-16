package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TeachingWorkingHoursTest {

	WebConnector selenium = WebConnector.getInstance();

	@And("^edit office hours$")
	public void edit_office_hours() {
		try {

//			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
//			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("editHoursBtn");
			selenium.clickLoop("editHoursBtn");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.clickDynamic("addHoursBtnDynamic", "Day", "addHoursBtnEnd");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("fromTime");
			selenium.click("fromTime");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("toTime");
			selenium.click("toTime");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("addOffcHrsBtn");
			selenium.click("addOffcHrsBtn");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.INFO, "Office hours added successfully");
			selenium.refresh();
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^edit teaching hours$")
	public void edit_teaching_hours() {
		try {
			selenium.waitingTime(3000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.clickDynamic("addHoursBtnDynamic", "Day", "addHoursBtnEnd");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("fromTime");
			selenium.click("fromTime");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("toTime");
			selenium.click("toTime");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("addTeachingHrsBtn");
			selenium.click("addTeachingHrsBtn");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.INFO, "Teaching hours added successfully");
			selenium.refresh();
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^verify hours relecting after updation$")
	public void verify_hours_reflecting_after_updation() {
		try {

			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(5000);
			String day = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Day");
			selenium.waitForElementToBeVisible("displayOffcHrsGetText");
			String offcHrs = selenium.getText("displayOffcHrsGetText");
			selenium.waitForElementToBeVisible("displayTeachingHrsGetText");
			String teachingHrs = selenium.getText("displayTeachingHrsGetText");

			if (offcHrs.contains(day) && teachingHrs.contains(day)) {
				selenium.test.log(LogStatus.PASS, "Office and Teaching hours added successfully");
				System.out.println("PASS");
				selenium.waitForElementToBeClickable("deleteOffcAndTeachingHrs");
				selenium.click("deleteOffcAndTeachingHrs");
				selenium.waitingTime(9000);
				selenium.waitForElementToBeVisible("deleteOffcAndTeachingHrs");
				selenium.scrollToElement("deleteOffcAndTeachingHrs");
				selenium.waitForElementToBeClickable("deleteOffcAndTeachingHrs");
				selenium.click("deleteOffcAndTeachingHrs");
				selenium.waitingTime(9000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.switchOutOfFrame();
			}

		} catch (Exception e) {
			selenium.captureScreenShot();
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

}
