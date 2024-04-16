package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MHHEUserViewProductsFromPackageTest {
	
	WebConnector selenium = WebConnector.getInstance();
	

	@Then("^Verify products under packages$")
	public void Verify_products_under_packages() {
		try {
		selenium.search("Product Name");
		selenium.waitingTime(4000);
		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Product Name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath);
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeVisible("productNameGetText");

		String productName = selenium.getTextLoop("productNameGetText").toString();
		selenium.test.log(LogStatus.INFO, "Product Name page:  " + productName + "is displayed");
		selenium.waitForElementToBeClickable("packagesLink");
		selenium.click("packagesLink");
		selenium.waitingTime(4000);

		String packageName = selenium.getDynamicXpath("anchorTitlecontains", "Package Name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(packageName);
		selenium.waitingTime(4000);
		
		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitForElementToBeVisible("componentsLink");
			selenium.clickLoop("componentsLink");
		} else {
			selenium.waitForElementToBeVisible("componentsLink");
			selenium.clickLoop("componentsLink");
		}
//		selenium.waitingTime(6000);
		selenium.waitForElementToBeVisible("componentsTable");
		
		WebElement table = selenium.getElement("componentsTable");
		List<WebElement> rowsList = table.findElements(By.tagName("tr"));
		List<WebElement> columnsList = null;
		for (WebElement row : rowsList) {
			columnsList = row.findElements(By.tagName("td"));
			
			for (WebElement column : columnsList) {
                System.out.print(column.getText() + ",");
                if (column.getText().equalsIgnoreCase(productName)) {
    				selenium.test.log(LogStatus.INFO, "The main product should get displayed under components. "  +column.getText());
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



}
