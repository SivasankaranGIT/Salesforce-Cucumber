package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortSequenceOnCourseTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	int count = 0;
//	String courseURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Course__c/a0U80000002MbrAEAS/view";

	@When("^Navigate to MHE Courses screen$")
	public void navigate_to_any_screen() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "MHE Course Search Option");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("mheCoursesOption");
		selenium.clickLoop("mheCoursesOption");
		selenium.waitingTime(4000);
		selenium.test.log(LogStatus.INFO, "MHE Course screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^Select course and change sort sequence as \\\"([^\\\"]*)\\\"$")
	public void select_course_and_change_sort_sequence(String MHECourseURL) {
		try {
			selenium.navigateToURL(MHECourseURL);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.clickLoop("editButton");
	
			selenium.clearText("sortSequence3field");
			if (count == 0) {
				selenium.type("sortSequence3field", "Sort Sequence 3");
			}
			if (count == 1) {
				selenium.type("sortSequence3field", "Sort Sequence Default");
			}
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);
			count++;
			selenium.waitingTime(2000);
			}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^Check sequence in product catalog$")
	public void check_sequence_in_product_catalog() {
		try {

			selenium.test.log(LogStatus.INFO, "Selecting and expanding Business Unit");
			selenium.switchToFrame("productframeUat");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("businessUnitDropDwn");
			selenium.click("businessUnitDropDwn");
			// selenium.clickDynamic("currencyValue", "Business Unit", "end");
			selenium.selectDropdownText("businessUnitDropDwn", "Business Unit");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("expandAllOption");
			selenium.click("expandAllOption");
			selenium.waitingTime(3000);

			String index = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sort Sequence 3");

			String courseSequence1 = selenium.getDynamicXpathProperty("courseLeftPanel", index, "end");
			if (selenium.isElementPresentXpathFast(courseSequence1)) {
				selenium.test.log(LogStatus.PASS, "Course is present in the following sequence: " + index);
			} else {
				selenium.test.log(LogStatus.FAIL, "Course is not present in the proper sequence: " + index);
				selenium.reportFailure("Test Case Failed");
			}

			if (count == 2) {
				index = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sort Sequence Default");

				String courseSequence2 = selenium.getDynamicXpathProperty("courseLeftPanel", index, "end");
				if (selenium.isElementPresentXpathFast(courseSequence2)) {
					selenium.test.log(LogStatus.PASS, "Course is present in the following sequence: " + index);
				} else {
					selenium.test.log(LogStatus.FAIL, "Course is not present in the proper sequence: " + index);
					selenium.reportFailure("Test Case Failed");
				}

			}
			selenium.switchOutOfFrame();
			selenium.waitingTime(4000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}
}
