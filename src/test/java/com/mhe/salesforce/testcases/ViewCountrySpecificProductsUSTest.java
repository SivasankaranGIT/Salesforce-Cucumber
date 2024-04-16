package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewCountrySpecificProductsUSTest {

	WebConnector selenium = WebConnector.getInstance();
    String INTLProduct="https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t80000001xtr6AAA/view";
	@When("^Navigate to products screen$")
	public void navigate_to_products_screen() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "Products");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("productSearchUnique");
		selenium.jsClick("productSearchUnique");
		selenium.waitingTime(4000);
		selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^Verify fields have read only access$")
	public void Verify_fields_have_read_only_access() {
		try {
//		selenium.navigateToURL(Product);
		/*
		 * selenium.search("Product Name"); String Xpath =
		 * selenium.getDynamicXpath("anchorTitlecontains", "Product Name",
		 * "endContains"); selenium.clickLoopXpath(Xpath);
		 */
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeVisible("productNameGetText");
		String productName = selenium.getTextLoop("productNameGetText").toString();
		selenium.test.log(LogStatus.INFO, "Product Name page:  " + productName + "is displayed");
		selenium.waitForElementToBeClickable("countryProductsLink");
		selenium.click("countryProductsLink");
		selenium.waitingTime(2000);

		selenium.waitForElementToBeClickable("CountryProductLink");
		selenium.jsClick("CountryProductLink");
		selenium.waitingTime(2000);

//		String country = selenium.getDynamicXpath("anchorTitlecontains", "Country Name", "endContains");
//		System.out.println("Country -->" + country);
//		selenium.clickLoopXpath(country);
		selenium.waitingTime(4000);

		boolean editBtn = selenium.isElementPresent("editBtn");
		boolean printOption = selenium.isElementPresent("printViewBtn");
		if (editBtn == false && printOption == true) {
			selenium.test.log(LogStatus.PASS,
					"Fields are non-editable for the SFDC-Users and only print option is present for them");
			System.out.println("PASS");
		}
		else
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
			System.out.println("FAIL");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^Verify Country specific attributes$")
	public void verify_country_specific_attributes() {
		try {
		selenium.waitingTime(4000);
		String price = null;
		String status = null;
		String qtyOnHand = null;
//        selenium.navigateToURL(Product);
		/*
		 * selenium.search("Product Name"); selenium.waitingTime(3000); String Xpath =
		 * selenium.getDynamicXpath("anchorTitlecontains", "Product Name",
		 * "endContains"); selenium.clickLoopXpath(Xpath);
		 */
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeVisible("productNameGetText");
		String productName = selenium.getTextLoop("productNameGetText").toString();
		selenium.test.log(LogStatus.INFO, "Product Name page:  " + productName + "is displayed");
		selenium.waitForElementToBeClickable("countryProductsLink");
		selenium.click("countryProductsLink");
		selenium.waitingTime(2000);

		/*String country = selenium.getDynamicXpath("anchorTitlecontains", "Country Name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(country);
		selenium.waitingTime(4000);*/
		selenium.waitForElementToBeClickable("CountryProductLink");
		selenium.jsClick("CountryProductLink");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeVisible("listPriceGetText");

		if (selenium.isElementPresentFast("listPriceGetText")) {
			selenium.scrollToElement("listPriceGetText");
			price = selenium.getText("listPriceGetText").toString();
			selenium.test.log(LogStatus.PASS, "Price attribute is visible with value: " + price);
		}
		else
		{
			selenium.test.log(LogStatus.FAIL, "Verification of Price attribute value failed");
			selenium.reportFailure("Verification of Price attribute value failed");
		}

		if (selenium.isElementPresentFast("statusGetText")) {
			selenium.scrollToElement("statusGetText");
			status = selenium.getText("statusGetText").toString();
			selenium.test.log(LogStatus.PASS, "Status attribute is visible with value: " + status);
		}
		else
		{
			selenium.test.log(LogStatus.FAIL, "Verification of Status attribute value failed");
			selenium.reportFailure("Verification of Status attribute value failed");
		}

		if (selenium.isElementPresentFast("qtyOnHandGetText")) {
			selenium.scrollToElement("qtyOnHandGetText");
			qtyOnHand = selenium.getText("qtyOnHandGetText").toString();
			selenium.test.log(LogStatus.PASS, "Quantity on Hand attribute is visible with value: " + qtyOnHand);
		}
		else
		{
			selenium.test.log(LogStatus.FAIL, "Verification of Quantity on Hand attribute value failed");
			selenium.reportFailure("Verification of Quantity on Hand attribute value failed");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^navigate to existing product$")
	public void navigate_to_existing_product() {
		try
		{
			selenium.navigateToURL(INTLProduct);
			System.out.println( "Product is:" +INTLProduct);
			selenium.waitingTime(10000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
}
