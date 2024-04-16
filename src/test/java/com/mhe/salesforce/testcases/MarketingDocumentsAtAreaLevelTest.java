package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingDocumentsAtAreaLevelTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("Check categories under Product Summary$")
	public void Check_supplement_records() {
		try {
		selenium.waitUntilLoaderLoads();
		
		selenium.scrollToElement("productsTable");
		selenium.click("goButton");
		selenium.switchToLastWindow();
		selenium.waitingTime(2000);
		
		boolean supplementsTab=selenium.isElementPresentFast("supplementsTab");
		boolean packagesTab=selenium.isElementPresentFast("packagesTab");
		boolean productSummaryTab=selenium.isElementPresentFast("productSummaryTab");
		//boolean url=selenium.isElementPresentFast("url");
		boolean contactTeam=selenium.isElementPresentFast("contactTeam");
		boolean courses=selenium.isElementPresentFast("courses");
		boolean features=selenium.isElementPresentFast("features");
		boolean probes=selenium.isElementPresentFast("probes");
		boolean tableOfContents=selenium.isElementPresentFast("tableOfContents");
		boolean competition=selenium.isElementPresentFast("competition");
		boolean documents=selenium.isElementPresentFast("documents");
		System.out.println("The boolean results are : "+supplementsTab+packagesTab+productSummaryTab+contactTeam+courses+features+probes+tableOfContents+competition+documents);
		
		if(supplementsTab && packagesTab && productSummaryTab  && contactTeam && courses && features && probes && tableOfContents && competition && documents) {
			selenium.test.log(LogStatus.PASS, "The course name got opened in the new tab. The above categories are available");
			System.out.println("PASS");
		}
		else
		{
			selenium.test.log(LogStatus.FAIL, "Some categories are missing");
			System.out.println("FAIL");
			selenium.reportFailure("Test Case Failed");
		}
		selenium.close();
		//selenium.switchToLastWindow();
		//selenium.close();
		selenium.switchBackToParentWindow();
		selenium.switchOutOfFrame();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}
	
	@Then("^Verify tabs are present under Documents section$")
	public void Verify_tabs_under_Documents_section() {
		try {
		selenium.switchToMultipleFrame("productframeUat");
		selenium.click("productsTable");
		selenium.waitingTime(5000);
		boolean areaTab=selenium.isElementPresentFast("areaTab");
		boolean disciplineTab=selenium.isElementPresentFast("disciplineTab");
		boolean courseTab=selenium.isElementPresentFast("courseTab");
		boolean productTab=selenium.isElementPresentFast("productTab");
		boolean libraryTab=selenium.isElementPresentFast("libraryTab");
		boolean disciplineFlyerTab=selenium.isElementPresentFast("disciplineFlyerTab");
		
		if(areaTab && disciplineTab && courseTab && libraryTab && productTab && disciplineFlyerTab) {
			selenium.test.log(LogStatus.PASS, "All the tabs are available under Documents Section");
			System.out.println("PASS");
		}
		else
		{
			selenium.test.log(LogStatus.FAIL, "Tabs are missing");
			System.out.println("FAIL");
			selenium.reportFailure("Test Case Failed");
		}
		
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
		
	}
	
	@When("^Navigate to Product Catalog page$")
	public void navigate_to_products_screen() {
		try {
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "Product Catalog");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("productCatalogOption");
		selenium.click("productCatalogOption");
		selenium.waitingTime(2000);
		selenium.test.log(LogStatus.INFO, "Product catalog screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}


@When("^I navigate to product catalog tab$")
public void i_navigate_to_product_catalogue_tab()  {
	try {
	
//    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
	selenium.click("menuDots");
	selenium.waitingTime(3000);
	selenium.waitForElementToBeVisible("searchItemsTextField");
	selenium.type("searchItemsTextField", "Product Catalog");
//	selenium.waitingTime(2000);
	selenium.waitForElementToBeClickable("productCatalogMenuOption");
	selenium.jsClick("productCatalogMenuOption");
	selenium.waitingTime(5000);
	}
	 catch (Exception e) {
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to Products" + e.getMessage());
		}

}


	@When("^I navigate to product catalog tab from menu bar$")
	public void i_navigate_to_product_catalogue_tab_menuBar()  {
		try {

//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.typeData("searchItemsTextField", "Product Catalog");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productCatalogMenuOption");
			selenium.jsClick("productCatalogMenuOption");
			selenium.waitingTime(8000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to Products" + e.getMessage());
		}

	}

}
