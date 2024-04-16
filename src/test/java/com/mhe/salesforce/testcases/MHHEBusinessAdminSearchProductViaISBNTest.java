package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEBusinessAdminSearchProductViaISBNTest {

	WebConnector selenium = WebConnector.getInstance();

	@Then("^I search product via ISBN$")
	public void I_search_product_via_ISBN() {
		try {
			selenium.test.log(LogStatus.INFO, "Clicking on Advanced Product Search");
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("advancedProductSearch");
			selenium.click("advancedProductSearch");
			selenium.waitForElementToBeClickable("clearButton");
			selenium.click("clearButton");
			selenium.type("Isbn13", "ISBN");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.scrollToElement("productsTable");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Verify products related to ISBN are displayed$")
	public void Verify_products_related_to_ISBN_are_displayed() {
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

}
