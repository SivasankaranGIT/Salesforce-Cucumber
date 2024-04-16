package com.mhe.salesforce.testcases;

import java.sql.Driver;

import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEBusinessAdminSearchDocumentViaISBNTest {
	WebConnector selenium = WebConnector.getInstance();

	@Then("^Verify documents related to ISBN are displayed$")
	public void Verify_documents_related_to_ISBN_are_displayed() {
		try {
			String productName = null;
			String isbn = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ISBN");
			productName = selenium.getText("productsTable").toString();
			selenium.switchOutOfFrame();
			System.out.println(productName);
			if (productName.contains(isbn)) {
				selenium.test.log(LogStatus.INFO, "Product is dispalyed: " + productName);
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");

			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Verify documents present under all categories$")
	public void Verify_documents_present_under_Area_category() {
		try {
			selenium.waitForElementToBeClickable("productsTable");
			selenium.click("productsTable");
			selenium.waitingTime(5000);
//			selenium.getTabNamesFromExcel("tabDyanmic", "Tab1", "end");
//			selenium.iterateTableAndCheckData("docTable", "endDocTable", "Index1");
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
