package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class createProductcourse {
	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to product course screen$")
	public void i_navigate_to_product_course_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(4000);
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "product course");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("productCourses");
			selenium.click("productCourses");
			selenium.test.log(LogStatus.INFO, "Product Course screen loaded successfully!");
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.type("searchTextC", "opportunity name");
			selenium.pressEnter("searchTextC");
			selenium.clickDynamic("anchorText", "opportunity name", "end");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Addproduct");
			selenium.click("Addproduct");

		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^I Create new product course$")
	public void i_Create_new_product_course() {
		try {
		selenium.test.log(LogStatus.INFO, "creating product course");

		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.click("NewButtonToAdd");
			selenium.type("Name_Field", "product course name");
			selenium.type("productcoursedivision", "product course divison");
//			selenium.waitingTime(20000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");

		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains", "Product Name", "productnamedynamic");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

	@And("^I validate product course name$")
	public void i_validate_product_course_name() {
		try {
		selenium.test.log(LogStatus.INFO, "product course name");
		selenium.waitingTime(2000);
		boolean isSuccess = false;
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			String productcoursename = "PC-" + selenium.getValueByColumnName("product course divison");
			String xpath = selenium.getDynamicXpathData("ProductcourseL", productcoursename, "end");
			if (selenium.isElementPresentXpathFast(xpath)) {
				isSuccess = true;
		
		
		} 
			else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains", "Product Name", "productnamedynamic");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");
		}
			
			selenium.printLastTestResult(isSuccess);	
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
}
