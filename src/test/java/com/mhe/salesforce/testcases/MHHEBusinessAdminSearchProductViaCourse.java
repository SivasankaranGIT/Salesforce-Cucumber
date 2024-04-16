package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEBusinessAdminSearchProductViaCourse {

	WebConnector selenium = WebConnector.getInstance();

	@Then("^I search product via Course$")
	public void I_search_product_via_Course() {
		try {
//			selenium.closeAllChildWindows();
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Clicking on Advanced Product Search");
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("advancedProductSearch");
			selenium.click("advancedProductSearch");
			selenium.waitForElementToBeClickable("clearButton");
			selenium.click("clearButton");
			selenium.type("courseText", "Course");
			//selenium.selectFromProductLookUp("Active MHE Course Lookup", "Course");
			selenium.selectCourseFromProductLookUp("Active MHE Course Lookup", "Course");
			selenium.waitingTime(5000);
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.click("searchProductsBtn");
			selenium.scrollToElement("productsTable");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Verify Product course related list is dispalyed$")
	public void Verify_Product_course_related_list_is_dispalyed() {
		try {
//			selenium.waitingTime(4000);
//			selenium.waitForElementToBeVisible("productandCoursesTable");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("productandCoursesTable");
			WebElement table = selenium.getElement("productandCoursesTable");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));
				WebElement column = columnsList.get(1);
				System.out.print(column.getText());
				if (column.getText() != null) {
					selenium.test.log(LogStatus.INFO, "Product course: " + column.getText());
				}
				continue;

			}
			selenium.test.log(LogStatus.INFO, "All the product courses tied to product are listed");
			selenium.switchOutOfFrame();
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

}
