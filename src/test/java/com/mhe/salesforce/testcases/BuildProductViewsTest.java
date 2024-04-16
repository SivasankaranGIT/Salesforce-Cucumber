package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BuildProductViewsTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("Create a product view$")
	public void create_product_view() {
		try {
			selenium.waitForElementToBeClickable("listViewBtn");
			selenium.click("listViewBtn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("newListView");
			selenium.click("newListView");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("listNameField");
			selenium.type("listNameField", "List Name");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnNew1");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(90000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}
	
	@Then("Delete product view$")
	public void delete_product_view() {
		try {
			selenium.waitForElementToBeClickable("CloseFilterBtnNew");
			selenium.jsClick("CloseFilterBtnNew");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("listViewBtn");
			selenium.click("listViewBtn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.clickLoop("deleteBtn");

			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);

			selenium.test.log(LogStatus.PASS, "List View deleted successfully");

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}
	
	@And("^Verify products list$")
	public void verify_products_list() {
		try {
			WebElement table = selenium.getElement("productCourseTable_N");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));
					WebElement column = columnsList.get(1);
					System.out.print(column.getText());
					if (column.getText() != null) {
						selenium.test.log(LogStatus.INFO, "Product ID: " + column.getText());
					}
					break;
			}
			selenium.test.log(LogStatus.INFO, "All the products are listed for the view");
			
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

}



