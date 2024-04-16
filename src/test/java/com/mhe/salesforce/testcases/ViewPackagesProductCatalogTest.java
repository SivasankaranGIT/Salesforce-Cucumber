package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class ViewPackagesProductCatalogTest {

	WebConnector selenium = WebConnector.getInstance();
	String productTitle = null;

	@Then("Check package records$")
	public void Check_package_records() {
		try {

			selenium.switchToMultipleFrame("productframeUat");
			selenium.click("clearButton");
			selenium.type("Isbn13", "ISBN");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(10000);
			//selenium.scrollToElement("productsTable");
			//selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("productsTable");
			selenium.scrollToElement("productsTable");
			productTitle = selenium.getText("productTitleGetText").toString();
			selenium.waitForElementToBeClickable("goButton");
			selenium.click("goButton");
			selenium.switchToLastWindow();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("packagesTab");
			selenium.click("packagesTab");

			WebElement table = selenium.getElement("packageTable");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));

				for (WebElement column : columnsList) {
					System.out.print(column.getText() + ",");
					if (column.getText().equalsIgnoreCase(productTitle)) {
						selenium.test.log(LogStatus.PASS,
								"The chosen product is part of the package: " + column.getText());
						break;
					}
				}

			}

			selenium.close();
			selenium.switchBackToParentWindow();
			selenium.switchOutOfFrame();

		} catch (Exception e) {
			selenium.switchBackToParentWindow();
			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}
	
	@Then("verify package records$")
	public void verify_package_records() {
		try {

			selenium.switchToMultipleFrame("productframeUat");
			selenium.click("advancedProductSearch");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("clearButton");
			selenium.click("clearButton");
			selenium.type("Isbn13", "ISBN Product");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(10000);
			//selenium.scrollToElement("productsTable");
			//selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("productsTable");
			selenium.scrollToElement("productsTable");
			productTitle = selenium.getText("productTitleGetText").toString();
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("goButton");
			selenium.click("goButton");
			selenium.switchToLastWindow();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("packagesTab");
			selenium.click("packagesTab");

			selenium.waitForElementToBeVisible("packagesText");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
			String packagesTblRecord = selenium.getText("packagesText").toString();
			selenium.waitingTime(2000);
			System.out.println(packagesTblRecord);
			if (packagesTblRecord.equalsIgnoreCase("Data Not Available") || selenium.isElementPresentFast("packagesTblRecord")) {
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS,
						"Fields are non-editable and there are no further package records underneath it.");
				System.out.println("Fields are non-editable and there are no further package records underneath it.");
			} else
			{
				selenium.test.log(LogStatus.FAIL, "Value could not be fetched");
				System.out.println("Value could not be fetched");
				selenium.reportFailure("Test Case Failed");
			}
			
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.close();
			selenium.switchBackToParentWindow();
			selenium.switchOutOfFrame();
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.switchBackToParentWindow();
			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}
}
