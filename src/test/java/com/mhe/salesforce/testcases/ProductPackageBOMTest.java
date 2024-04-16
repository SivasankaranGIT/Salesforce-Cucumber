package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPackageBOMTest {

	WebConnector selenium = WebConnector.getInstance();
//	String productURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01tC0000002FlMhIAK/view";

	@When("^Navigate to Products from App Launcher$")
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
		selenium.waitForElementToBeClickable("productOptionFromSearch");
		selenium.clickLoop("productOptionFromSearch");
		selenium.waitingTime(4000);
		selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@When("^I navigate to products tab$")
    public void i_navigate_to_products_tab()  {
		try {
		
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("searchItemsTextField");
		selenium.type("searchItemsTextField", "Products");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("productsMenuDotsOption");
		selenium.jsClick("productsMenuDotsOption");
		selenium.waitingTime(5000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to Products" + e.getMessage());
			}

	}
	@Then("^Verify packages and components$")
	public void Verify_packages_components() {
		try {
//		selenium.search("ISBN");
//		selenium.waitingTime(10000);
//		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "ISBN", "endContains");
//		System.out.println(Xpath);
//		selenium.waitingTime(2000);
//		selenium.clickLoopXpath(Xpath);
//		selenium.waitingTime(6000);
//		selenium.navigateToURL(productURL);
		selenium.waitForElementToBeVisible("productNameGetText");

		String productName = selenium.getTextLoop("productNameGetText").toString();
		selenium.test.log(LogStatus.INFO, "Product Name page:  " + productName + "is displayed");
		selenium.waitingTime(2000);
		selenium.click("packagesLink");
		selenium.waitingTime(4000);

		String packageName = selenium.getDynamicXpath("anchorTitlecontains", "Package Name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(packageName);
		selenium.waitingTime(4000);

		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitForElementToBeClickable("productComponenetLink");
			selenium.clickLoop("productComponenetLink");
		} else {
			selenium.waitForElementToBeClickable("productComponenetLink");
			selenium.clickLoop("productComponenetLink");
		}
		selenium.waitingTime(8000);
		if(!selenium.isElementPresentFast("componentsTable1"))
		{
			selenium.refresh();
			selenium.waitingTime(15000);
		}
			selenium.waitForElementToBeVisible("componentsTable1");
			WebElement table = selenium.getElement("componentsTable1");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));

				for (WebElement column : columnsList) {
					System.out.print(column.getText() + ",");
					if (column.getText().equalsIgnoreCase(productName)) {
						selenium.test.log(LogStatus.INFO,
								"The main product should get displayed under components. " + column.getText());
						break;
					}

				}

			}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
			
		}


	

	@And("^View package definitions BOMs$")
	public void view_package_definitions_BOMs() {
		try {
//			if(selenium.getTestCaseName().equalsIgnoreCase("ProductPackageBOM"))
//			{
//				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("BOM Product URL");
//				selenium.navigateToURL(url);
//			}
//		String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("BOM Product URL");
//		selenium.navigateToURL(url);
		selenium.waitingTime(2000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitForElementToBeClickable("productComponenetLink");
			selenium.clickLoop("productComponenetLink");
		} else {
			selenium.waitForElementToBeClickable("productComponenetLink");
			selenium.clickLoop("productComponenetLink");
		}
		selenium.waitingTime(6000);

		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Component Product Title", "endContains");
		selenium.waitingTime(4000);
		System.out.println(Xpath);
		selenium.clickLoopXpath(Xpath);
		selenium.waitingTime(6000);

		String title = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Component Product Title");
		String productTitle = selenium.getTextLoop("productCompTitleGetText");

		if (productTitle.contains(title)) {
			selenium.test.log(LogStatus.PASS, "BOM package definition present");
			System.out.println("PASS");
		} else {
			selenium.test.log(LogStatus.FAIL, "BOM package definition not present");
			System.out.println("FAIL");
			selenium.reportFailure("Test Case Failed");
		}
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

	@Then("^Verify packages section$")
    public void verify_packages_section()  {
		try {
		selenium.search("ISBN");
		selenium.waitingTime(10000);
		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "ISBN", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath);
//		selenium.waitingTime(6000);
		selenium.waitForElementToBeVisible("productNameGetText");

		String productName = selenium.getTextLoop("productNameGetText").toString();
		selenium.test.log(LogStatus.INFO, "Product Name page:  " + productName + "is displayed");

		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("packagesLink");
		
		selenium.click("packagesLink");
		selenium.waitingTime(6000);

		if(selenium.getElement("packagesTableInsideProduct").isDisplayed()) {
			System.out.println("inside packages pass");
			selenium.test.log(LogStatus.PASS, "Able to view packages");
		} else {
			System.out.println("inside packages fail");
			selenium.test.log(LogStatus.FAIL, "Packages not present");
			selenium.reportFailure("Test Case Failed");
		}
		
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

}
