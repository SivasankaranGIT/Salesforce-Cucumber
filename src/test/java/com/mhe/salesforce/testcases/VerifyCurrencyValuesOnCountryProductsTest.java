package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCurrencyValuesOnCountryProductsTest {
	WebConnector selenium = WebConnector.getInstance();
//	public String Productname="https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t0y000005LhLRAA0/view";
//	@When("^Navigate to Products page$")
//	public void navigate_to_products_screen() {
//		try {
//		selenium.waitForElementToBeClickable("allButtonLightning");
//		selenium.click("allButtonLightning");
//		selenium.waitingTime(4000);
//		selenium.waitForElementToBeClickable("AllButtonL");
//		selenium.click("AllButtonL");
//		selenium.waitingTime(4000);
//		selenium.type("searchallitems", "Products");
//		selenium.waitingTime(2000);
//		selenium.waitForElementToBeClickable("productsOption");
//		selenium.click("productsOption");
//		selenium.waitingTime(2000);
//		selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
//		}
//		catch (Exception e)
//		{
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//			selenium.reportFailure("Error occurred " + e.getMessage());
//		}
//	}
	
	@Then("^Click on CP US product and check currency$")
	public void Verify_currency_for_CP_US() {
		try {
//		selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t0y000005LhLRAA0/view");
		selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t80000001xowkAAA/view");
		selenium.waitingTime(4000);
		/*
		 * selenium.search("Product Name"); selenium.waitingTime(2000); String Xpath =
		 * selenium.getDynamicXpath("anchorTitlecontains", "Product Name",
		 * "endContains"); selenium.clickLoopXpath(Xpath); selenium.waitingTime(4000);
		 */
		selenium.waitingTime(2000);
		System.out.println("Inside Verify_currency_for_CP_US method");
		selenium.refresh();
		selenium.waitingTime(8000);
		String productName = selenium.getTextLoop("productNameGetText").toString();
		selenium.test.log(LogStatus.INFO, "Product Name page:  " + productName + "is displayed");
		System.out.println("Product Name from UI is : "+productName);
		System.out.println("Step1 Done:Verify_currency_for_CP_US method");

		//selenium.scrollToElement("caListPriceGetText");
		
		String listPrice = selenium.getText("listPrice").toString();
		System.out.println("List Price from UI is : "+listPrice);
		String netPrice = selenium.getText("netPrice").toString();
		System.out.println("Net Price from UI is : "+netPrice);
		String caListPrice = selenium.getText("caListPriceGetText").toString();
		System.out.println("CA List Price from UI is : "+caListPrice);
		String caNetPrice = selenium.getText("caNetPriceGetText").toString();
		System.out.println("CA Net Price from UI is : "+caNetPrice);
		if (selenium.isElementPresentFast("closeBtn")) {
		selenium.waitForElementToBeClickable("closeBtn");
		selenium.click("closeBtn");
		selenium.waitForElementToBeClickable("countryProductsLink");
		selenium.click("countryProductsLink");
		} else {
			selenium.waitForElementToBeClickable("countryProductsLink");
			selenium.click("countryProductsLink");
		}
		selenium.waitingTime(4000);
		String country = selenium.getDynamicXpath("spantextContains", "US Country Name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(country);
		selenium.waitingTime(4000);
		String cplistPrice = selenium.getText("listPriceGetText").toString();
		String cpnetPrice = selenium.getText("cpNetPriceGetText").toString();
		System.out.println("cplistPrice :" + cplistPrice);
		System.out.println("cpnetPrice :" + cpnetPrice);
		if(cplistPrice.contains(listPrice) && cpnetPrice.contains(netPrice)) {
			selenium.test.log(LogStatus.PASS, "Verified susccessfully the values of the prices as per US fields on the Product record.");
			System.out.println("PASS");
		}
		selenium.navigateBack();
		selenium.waitingTime(2000);
		String country1 = selenium.getDynamicXpath("spantextContains", "CA Country Name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(country1);
		selenium.waitingTime(4000);
//		String cplistPrice1 = selenium.getText("cpListPriceGetText1").toString().replaceAll("CAD", "USD");
		String cpnetPrice1 = selenium.getText("cpNetPriceGetText").toString().replaceAll("CAD", "USD");
		System.out.println("cpnetPrice1 :" + cpnetPrice1);
//		if(cplistPrice1.contains(caListPrice) && cpnetPrice1.contains(caNetPrice)) {
			if(cpnetPrice1.contains(caNetPrice)) {
			selenium.test.log(LogStatus.PASS, "Verified susccessfully the values of the prices as per CA fields on the Product record.");
			System.out.println("PASS");
		}
		
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}

}
