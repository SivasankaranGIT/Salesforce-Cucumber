package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductMHEarea {
	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to product catalog screen$")
	public void i_navigate_to_product_catalog_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(4000);
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "INTL product catalog");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("intlProductcatalog");
			selenium.click("intlProductcatalog");
			selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
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

	@And("^I search product via MHE area$")
	public void i_search_product_via_MHE_area() {
		selenium.test.log(LogStatus.INFO, "adding product");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.switchToFrame("productframeUat");
			selenium.click("clearButton");
			selenium.selectFromLookUp("MHHE Area Lookup", "MHE Area");
			selenium.waitingTime(6000);
			selenium.switchToFrame("productframeUat");
			selenium.click("Allregionchecbkox");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(20000);
			//selenium.switchToFrame("productframeUat");
	
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
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
	
	@And("^I search product via discipline$")
	public void i_search_product_via_discipline() {
		selenium.test.log(LogStatus.INFO, "adding product");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.switchToFrame("productframeUat");
			selenium.click("clearButton");
			selenium.selectFromLookUp("MHHE Discipline Lookup", "MHE Discipline");
			selenium.waitingTime(6000);
			selenium.switchToFrame("productframeUat");
			selenium.click("Allregionchecbkox");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(20000);
			//selenium.switchToFrame("productframeUat");
	
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
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
	
	@And("^I search product via course$")
	public void i_search_product_via_course() {
		selenium.test.log(LogStatus.INFO, "adding product");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.switchToFrame("productframeUat");
			selenium.click("clearButton");
			selenium.selectFromLookUp("MHE Course Lookup", "MHE Course");
			selenium.waitingTime(20000);
			selenium.switchToFrame("productframeUat");
			selenium.click("Allregionchecbkox");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(20000);
			//selenium.switchToFrame("productframeUat");
	
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeClickable("ProductCourse");
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
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
	
	@And("^I search product via ISBn$")
	public void i_search_product_via_ISBn() {
		selenium.test.log(LogStatus.INFO, "adding product");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.switchToFrame("productframeUat");
			selenium.click("clearButton");
			selenium.type("Isbn13","ISBN");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Allregionchecbkox");
			selenium.click("Allregionchecbkox");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(20000);
			//selenium.switchToFrame("productframeUat");
	
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
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
	
	
	@And("^I search product via \"([^\"]*)\"$")
	public void i_search_product_via_ProductISBN(String ISBN) {
		selenium.test.log(LogStatus.INFO, "adding product");
		try {
			selenium.test.log(LogStatus.INFO, "Clicking on Advanced Product Search");
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.switchToFrame("productframeUat");
			selenium.waitForElementToBeClickable("advancedProductSearch");
			selenium.click("advancedProductSearch");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clearButton");
			selenium.click("clearButton");
			selenium.waitingTime(2000);
			selenium.getElement("Isbn13").sendKeys(ISBN);
			System.out.println("ISBN inserted successfully");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(20000);	
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.clearText("ProductCourse");
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
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
	
	@And("^I click product title$")
	public void i_click_product_title() {
		selenium.test.log(LogStatus.INFO, "click product title");
		selenium.waitForElementToBeClickable("ProductcatalogISBn");
		selenium.click("ProductcatalogISBn");
		selenium.waitingTime(10000);
	
		}

	@Then("^the product should be successfully visible$")
	public void the_product_should_be_successfully_visible() {
		try {
			selenium.waitingTime(2000);
			boolean isSuccess = false;
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				selenium.waitForElementToBeVisible("Productstab");
				
			if (selenium.isElementPresentFast("Productstab")){
						isSuccess = true;	
				} 
			if (selenium.getUI().equalsIgnoreCase("classic")) {
			String xpath=selenium.getDynamicXpath("anchorText", "Product Name", "end");
			selenium.waitingTime(2000);	
			if (selenium.isElementPresentXpathFast(xpath))
						isSuccess = true;	
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
	
	@Then("^the product document should be successfully visible$")
	public void the_product_document_should_be_successfully_visible() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productdocumentsectionsarea");
			selenium.click("productdocumentsectionsarea");
			boolean isSuccess = false;
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				selenium.waitForElementToBeVisible("Coursenamedocument");
				
			if (selenium.isElementPresentFast("Coursenamedocument")){
						isSuccess = true;	
				} 
			if (selenium.getUI().equalsIgnoreCase("classic")) {
			String xpath=selenium.getDynamicXpath("anchorText", "Product Name", "end");
			selenium.waitingTime(2000);	
			if (selenium.isElementPresentXpathFast(xpath))
						isSuccess = true;	
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


@Then("^I click on Course tab in Documents section$")
public void I_click_on_Course_tab_in_Documents_section() {
	try {
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("productdocumentsectionscourse");
		selenium.click("productdocumentsectionscourse");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("EditCoursedocument");
		selenium.click("EditCoursedocument");
		selenium.waitingTime(4000);
	}
	catch (Exception e)
	{
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
	}
 }

 @And("^Verify that the new page has Edit button present$")
 public void verify_that_the_new_page_has_Edit_button_present() {
	selenium.switchToChildWindow();
	selenium.waitingTime(20000);
	selenium.test.log(LogStatus.INFO, "verify Edit Button");
	if(selenium.isElementPresentFast("EditButtononProductCourse"))
 	{
 		selenium.test.log(LogStatus.PASS, "Edit Button is Present on webpage");
 		System.out.println("Edit Button is Present on webpage");
 		selenium.captureScreenShot();
 		selenium.waitingTime(2000);
	}
 	else
 	{
		selenium.test.log(LogStatus.FAIL, "Unable to verify Edit Button is on webpage");
		selenium.reportFailure("Unable to verify Edit Button is Present on webpage");
		System.out.println("FAIL");
	}
	selenium.close();
	selenium.waitingTime(2000);
	selenium.switchBackToParentWindow();
	selenium.waitingTime(2000);

	}
}
