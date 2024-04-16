package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEBusinessAdminSearchProductViaDisciplineTest {

	WebConnector selenium = WebConnector.getInstance();

	@Then("^I search product via Discipline$")
	public void I_search_product_via_Discipline() {
		try {
			selenium.test.log(LogStatus.INFO, "Clicking on Advanced Product Search");
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("advancedProductSearch");
			selenium.click("advancedProductSearch");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clearButton");
			selenium.click("clearButton");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("disciplineText");
			selenium.type("disciplineText", "Discipline");
			selenium.selectFromProductLookUp("Discipline Lookup", "Discipline");
			selenium.waitingTime(5000);
			selenium.switchToFrame("productframeUat");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.click("searchProductsBtn");
//			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("productsTable");
			selenium.captureScreenShot();
			selenium.scrollToElement("productsTable");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
	
	@Then("^Search product via Discipline$")
	public void search_product_via_Discipline() {
		try {
			selenium.test.log(LogStatus.INFO, "Clicking on Advanced Product Search");
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("advancedProductSearch");
			selenium.click("advancedProductSearch");
			selenium.waitForElementToBeClickable("clearButton");
			selenium.click("clearButton");
			selenium.type("disciplineText", "Discipline");
			selenium.selectFromProductLookUp("Discipline Lookup", "Discipline");
			selenium.waitingTime(5000);
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.click("searchProductsBtn");
			selenium.waitingTime(20000);
			selenium.captureScreenShot();
			selenium.scrollToElement("productandCoursesTable");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

}
