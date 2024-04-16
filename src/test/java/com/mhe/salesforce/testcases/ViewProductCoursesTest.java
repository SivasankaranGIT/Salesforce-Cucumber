package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewProductCoursesTest {

	WebConnector selenium = WebConnector.getInstance();
	String isbn;
//	String contactURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002TUBTJAA5/view";

	@When("^click Sample contact button and search for MHE Course$")
	public void I_click_contact_button_and_search_MHE_course() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(2000);
//				selenium.search("Contact Name");
//				selenium.waitingTime(5000);
//				String Xpath=selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
//				selenium.clickLoopXpath(Xpath);
				
//				selenium.navigateToURL(contactURL);
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("sampleContactButton");
				selenium.click("sampleContactButton");
				selenium.waitingTime(4000);
//				selenium.waitForElementToBeVisible("productframeUat");
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("searchProductsBtn");
				selenium.click("searchProductsBtn");
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("mheCourse");

				selenium.clearText("mheCourse");
				selenium.type("mheCourse", "MHE Course");
				selenium.waitingTime(2000);
				String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(xpath);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.clickLoop("searchBtn");
				selenium.waitingTime(20000);
				System.out.println("Search Button Clicked");

			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while searching products " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^fetch ISBN number and search for product$")
	public void fetch_ISBN_number() {
		try {

			selenium.scrollToElement("productTable");
			WebElement table = selenium.getElement("productTable");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));
				WebElement column = columnsList.get(5);
				isbn = column.getText();
				selenium.switchOutOfFrame();
				break;
			}
			System.out.println("ISBN : "+isbn);
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeVisible("globalSearch_new");
			/*selenium.getElement("globalSearch").sendKeys(isbn);
//			selenium.waitingTime(2000);
			selenium.click("salesrepsearch");
//			selenium.waitingTime(5000);*/
			selenium.click("globalSearch_new");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("globalSearch_text");
			selenium.typeData("globalSearch_text", isbn);
			selenium.getElement("globalSearch_text").sendKeys(Keys.ENTER);
			selenium.waitingTime(4000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Product Course", "endContains");
			System.out.println(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(6000);

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed"+e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^click on Product course related list$")
	public void click_on_Product_course() {
		try {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("productCourseLink");
			selenium.click("productCourseLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("productCourseTable_N");
			WebElement table = selenium.getElement("productCourseTable_N");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));
				//for (WebElement columnVal : columnsList) {
					WebElement column = columnsList.get(1);
					System.out.print(column.getText());
					if (column.getText() != null) {
						selenium.test.log(LogStatus.INFO, "Product course: " + column.getText());
					}
					break;
				//}

			}
			selenium.test.log(LogStatus.INFO, "All the product courses tied to product are listed");
			
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

}
