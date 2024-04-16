package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class viewCoursesAssignedToProductsForAnOppurtunity {
	WebConnector selenium = WebConnector.getInstance();
	String isbn;
//	public String OppForCourseView="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068D000008W7TGQA0/view";
//	public String OppForCourseViewNew="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0061A000015k4PnQAI/view";
	
	@When("^I click Sales Rep Oppurtunities tab$")
    public void i_click_sales_rep_oppurtunities_tab() throws Exception {
    try {
		 selenium.waitingTime(5000);
		 selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "New Opportunity");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpportunityClick");
			selenium.jsClick("OpportunityClick");
			selenium.waitingTime(5000);
    }
    catch (Exception e)
	{
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
	}
    }
	@Then("^click on Oppurtunity name$")
	public void click_on_Oppurtunity_name() {
		try {
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("opportunityName");
		selenium.click("opportunityName");
		selenium.waitingTime(5000);
		selenium.captureScreenShot();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}
	@Then("^Navigate to Products section$")
	public void Navigate_to_Products_section() {
		try {
		selenium.waitingTime(2000);
//		selenium.navigateToURL(OppForCourseViewNew);
		selenium.navigateToURL_propertiesFile("US089_OppURL");
		selenium.waitingTime(8000);
		selenium.waitForElementToBeVisible("contactsOpportunityLink1");
		selenium.scrolldown(150);
		selenium.waitForElementToBeClickable("contactsOpportunityLink1");
		selenium.click("contactsOpportunityLink1");

		selenium.waitingTime(5000);
		selenium.captureScreenShot();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@And("^click on Add or Edit button$")
	public void click_on_Add_or_Edit_button() {
		try {
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("productAddOrEdit");
		selenium.click("productAddOrEdit");
		selenium.waitingTime(5000);
		selenium.captureScreenShot();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}
	
//	@Then("^search for product using ISBN$")
//	public void search_for_product_using_ISBN() {
//		try {
//			
//		selenium.waitingTime(3000);
////		selenium.waitForElementToBeVisible("productframeUat");
//		selenium.switchToMultipleFrame("productframeUat");
////		selenium.waitingTime(2000);
//		selenium.waitForElementToBeVisible("isbnSearch");
//		selenium.type("isbnSearch", "ISBN");
////		selenium.waitingTime(2000);
//		selenium.waitForElementToBeClickable("searchBtn");
//		selenium.click("searchBtn");
////		selenium.waitingTime(3000);
//		selenium.waitForElementToBeVisible("productDetailsISBN");
//		boolean product = selenium.isElementPresentFast("productDetailsISBN");
//		if(product==true) {
//			
//			selenium.test.log(LogStatus.INFO, "ISBN product record is present");
//		}
//		else {
//			selenium.test.log(LogStatus.INFO, "ISBN product record not present");
//		}
//		selenium.scrollToElement("productDetailsISBN");
//		selenium.waitingTime(2000);
//		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
//		selenium.switchOutOfFrame();
//	}
//	
//		 catch (Exception e) {
//				selenium.switchOutOfFrame();
//				selenium.reportFailure("Error while searching products " + e.getMessage());
//				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//			}
//
//	}
	
	@Then("^global search for product with ISBN$")
	public void global_search_for_product_with_ISBN() {
		try {
		
		/*selenium.type("globalSearch", "ISBN");
		selenium.waitingTime(2000);
		selenium.getElement("globalSearch").sendKeys(Keys.ENTER);*/
			selenium.waitForElementToBeClickable("globalSearch_new");
		selenium.click("globalSearch_new");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("globalSearch_text");
		selenium.type("globalSearch_text", "ISBN");
		selenium.getElement("globalSearch_text").sendKeys(Keys.ENTER);
		selenium.waitingTime(7000);
	    String productsearcresults=selenium.getDynamicXpath("anchorTitlecontains", "ISBN", "endContains");
	    boolean product=selenium.isElementPresentXpathFast(productsearcresults);
	    //boolean product = selenium.isElementPresentFast("productsearcresults");
		selenium.waitingTime(3000);
		if(product==true) {
			
			selenium.test.log(LogStatus.INFO, "ISBN product details present");
		}
		else {
			selenium.test.log(LogStatus.INFO, "ISBN product details not present");
		}
		selenium.captureScreenShot();
	}
	
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while searching products " + e.getMessage());
			}

	}
	
	@Then("^click on product name$")
	public void click_on_product_name() {
		try {
		
		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Product Name", "endContains");
		System.out.println(Xpath);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath);
		selenium.test.log(LogStatus.INFO, "Product is present: " );
		selenium.waitingTime(2000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
	}
	
	
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while searching products " + e.getMessage());
			}

	}
	
@Then("^click on product course to verify products tied to course are displayed$")
	public void click_on_product_course_to_verify_products_tied_to_course_are_displayed() {
		try {
			selenium.waitForElementToBeClickable("productCourse");
			selenium.click("productCourse");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("productCourseTable");
			WebElement table = selenium.getElement("productCourseTable");
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
			

			}
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "All the product courses tied to product are listed");
			
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

}


