package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class SearchProductsFromOpportunitiesTest {

	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to products screen and add product$")
	public void I_navigate_product_screen_addProduct() {
		try {
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("OppProduct");
		selenium.click("OppProduct");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("taggedProductAddorEdit");
		selenium.click("taggedProductAddorEdit");
		selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
		selenium.waitingTime(4000);
		
		selenium.switchToMultipleFrame("productframeUat");
		selenium.waitingTime(60000);
		selenium.waitForElementToBeClickable("clearButton");
		selenium.click("clearButton");
		selenium.type("copyrightField", "Copyright");
		selenium.waitForElementToBeClickable("searchBtn");
		selenium.click("searchBtn");
		selenium.waitingTime(5000);
		//selenium.clickDynamic("divText","Author Name", "productCheckBoxDynamic");
		String checkBox = selenium.getDynamicXpath("divText", "Author Name", "productCheckBoxDynamic");
		selenium.clickLoopXpath(checkBox);
		selenium.waitForElementToBeClickable("Addtoopportunity");
		selenium.click("Addtoopportunity");
		selenium.waitingTime(12000);
//		selenium.waitForElementToBeVisible("Button_Save");
		selenium.scrollToElement("Button_Save");
		selenium.waitForElementToBeClickable("Button_Save");
		selenium.click("Button_Save");
		selenium.waitingTime(5000);
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("opportunityProductsLink");
		selenium.clickLoop("opportunityProductsLink");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@And("^Verify product list within the opportunity$")
	public void verify_contact_list_within_the_account() {
		try {
			System.out.println("Inside verify contact list");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("productCourseTable_New");
			WebElement table = selenium.getElement("productCourseTable_New");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("th"));
					WebElement column = columnsList.get(0);
					System.out.print(column.getText());
					String author=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Author");
					if (column.getText().contains(author)) {
						selenium.test.log(LogStatus.PASS, "Product is successfully added to the opportunity");
						System.out.println("PASS - Product is successfully added to the opportunity");
						break;
					}
					else continue;
					

			}
			selenium.test.log(LogStatus.INFO, "All the product details tied to opportunity are listed");
//			System.out.println("INFO - All the product details tied to opportunity are listed");
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

}
