package com.mhe.salesforce.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEBusinessAdminVerifyLibraryItemsTest {

	WebConnector selenium = WebConnector.getInstance();

	@Then("^Verify Library Items$")
	public void I_Verify_Library_Items() {
		try {
			selenium.test.log(LogStatus.INFO, "Verifying Library Items");
			selenium.test.log(LogStatus.INFO, "Refreshing the ProductCatalog page");
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
			selenium.switchToFrame("productframeUat");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.INFO, "after switchToFrame");
			selenium.captureScreenShot();
			selenium.getTabNamesFromExcel("tabDyanmic", "Tab", "end");
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "before docTable");
			selenium.captureScreenShot();
			selenium.verifyLibraryItems("docTable", "Index", "endDocTable", "Text_Span", "Library Name", "end");
			// selenium.switchOutOfFrame();
			selenium.waitingTime(5000);
			selenium.captureScreenShot();

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

}
