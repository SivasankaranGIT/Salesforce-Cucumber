package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEBusinessAdminSearchProductViaCourseTest {

	WebConnector selenium = WebConnector.getInstance();

	@Then("^I search document via Course$")
	public void I_search_product_via_Course() {
		try {
			selenium.test.log(LogStatus.INFO, "Clicking on Advanced Product Search");
			selenium.waitingTime(5000);
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("advancedProductSearch");
			selenium.click("advancedProductSearch");
			selenium.waitForElementToBeClickable("clearButton");
			selenium.click("clearButton");
			selenium.type("courseText", "Course");
			// selenium.selectFromProductLookUp("Course Lookup", "Course");
			selenium.selectCourseFromProductLookUp("Course Lookup", "Course");
			selenium.waitingTime(5000);
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.click("searchProductsBtn");
//			selenium.waitingTime(12000);
			selenium.waitForElementToBeVisible("productsTable");
			selenium.scrollToElement("productsTable");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Verify documents present under all four categories$")
	public void Verify_documents_present_under_four_categories() {
		try {

			// selenium.click("productsTable");
			//selenium.switchToFrame("productframeUat");
			String Xpath = selenium.getDynamicXpath("tableContentDynamic", "ISBN", "endContains");
			System.out.println(Xpath);
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(4000);
			selenium.getTabNamesFromExcel("tabDyanmicNew", "Tab1", "endContains");
			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index1");
			selenium.getTabNamesFromExcel("tabDyanmicNew", "Tab2", "endContains");
			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index2");
			selenium.getTabNamesFromExcel("tabDyanmicNew", "Tab3", "endContains");
			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index3");
			selenium.getTabNamesFromExcel("tabDyanmicNew", "Tab4", "endContains");
			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index4");
			selenium.switchOutOfFrame();
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
	
	@Then("^Verify documents for four categories$")
	public void verify_documents_for_four_categories() {
		try {

			// selenium.click("productsTable");
			selenium.switchToFrame("productframeUat");
			String Xpath = selenium.getDynamicXpath("tableContentDynamic", "ISBN", "endContains");
			selenium.clickLoopXpath(Xpath);
			selenium.getTabNamesFromExcel("tabDyanmic", "Tab1", "end");
			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index1");
			selenium.getTabNamesFromExcel("tabDyanmic", "Tab2", "end");
			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index2");
			selenium.getTabNamesFromExcel("tabDyanmic", "Tab3", "end");
			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index3");
			selenium.getTabNamesFromExcel("tabDyanmic", "Tab4", "end");
			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index4");
			selenium.switchOutOfFrame();
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

}
