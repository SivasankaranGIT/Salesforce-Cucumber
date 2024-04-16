package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MHECoursesOpportunitiesProductsTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
//	String mheCourseURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Course__c/a0U80000002McWi/view";

	@When("^Navigate to MHE Courses page$")
	public void navigate_to_products_screen() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "MHE Courses");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("mheCoursesOption");
		selenium.click("mheCoursesOption");
		selenium.waitingTime(2000);
		selenium.test.log(LogStatus.INFO, "MHE Courses screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^Verify MHE course related list$")
	public void verify_mhe_course_related_list() {
		try {
			/*selenium.searchGlobal("MHE Course");
			selenium.waitingTime(7000);

			String xpath = selenium.getDynamicXpath("anchorTitle", "MHE Course", "end");
			selenium.clickLoopXpath(xpath);*/
//			selenium.navigateToURL(mheCourseURL);
//			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("mheCourseNameGetTextNew");
//			String courseName = selenium.getTextLoop("mheCourseNameGetText").toString();
			String courseName=selenium.getText("mheCourseNameGetTextNew").toString();
			selenium.test.log(LogStatus.PASS, "MHE Course Name :  " + courseName + " is displayed");
			selenium.waitingTime(3000);

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^Link a MHE Course to the opportunity$")
	public void link_mhe_course_to_opportunity() {
		try {
			/*
			 * selenium.search("Opportunity Name"); selenium.waitingTime(4000); String xpath
			 * = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name",
			 * "endContains"); selenium.clickLoopXpath(xpath); selenium.waitingTime(8000);
			 */
//			String opp = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opp URL");
//			selenium.navigateToURL(opp);
//			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("NewOpportunityEditBtnMHE"))
			{
				selenium.waitForElementToBeClickable("NewOpportunityEditBtnMHE");
				selenium.clickLoop("NewOpportunityEditBtnMHE");				
			}
			else
			{
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("NewOpportunityEditBtn");
				selenium.click("NewOpportunityEditBtn");
			}
//			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("mheCourseDeleteIcon");

			selenium.jsClick("mheCourseDeleteIcon");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("mheCoursedropdown");

			selenium.type("mheCoursedropdown", "MHE Course");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.click("showAllResultsFromDropDwn");
			selenium.waitingTime(6000);
			String accountsearch = selenium.getDynamicXpath("mheCouseNameOption", "MHE Course", "end");
//			selenium.waitForXpathElementToBeClickable(accountsearch);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(accountsearch);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("save");
			selenium.clickLoop("save");
			// selenium.waitForElementToDisappear("internalSpinner");
			selenium.waitingTime(50000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("mheCourseGetText");
			String mheCourse = selenium.getText("mheCourseGetText").toString();
			String expected_mheCourse = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MHE Course");
			System.out.println("mheCourse : "+ mheCourse + " expected_mheCourse : " + expected_mheCourse);
			if (mheCourse.equalsIgnoreCase(expected_mheCourse)) {
				selenium.test.log(LogStatus.PASS, "Course name is updated as: " + mheCourse);
				System.out.println("PASS");
			} else {
				selenium.test.log(LogStatus.FAIL, "Course name is not updated");
				System.out.println("FAIL");
				selenium.reportFailure("Test Case Failed");
			}

			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}

			else {
				//selenium.click("CancelButton");
			}

		}

	}

	@Then("^Search product via Course$")
	public void I_search_product_via_Course() {
		try {
		selenium.test.log(LogStatus.INFO, "Clicking on Advanced Product Search");
		selenium.waitingTime(4000);
		selenium.switchToMultipleFrame("productframeUat");
		// selenium.click("advancedProductSearch");
		selenium.click("clearButton");
		selenium.type("courseText", "Course");
		selenium.waitingTime(5000);
		selenium.selectCourseFromProductLookUp("Active MHE Course Lookup", "Course");
		selenium.waitingTime(5000);
		selenium.switchToMultipleFrame("productframeUat");
		selenium.click("searchProductsBtn");
//		selenium.waitingTime(10000);
		selenium.waitForElementToBeVisible("productsTable");
		selenium.scrollToElement("productsTable");
		selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

}
