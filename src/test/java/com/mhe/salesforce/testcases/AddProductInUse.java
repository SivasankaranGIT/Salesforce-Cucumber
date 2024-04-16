package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddProductInUse {
	WebConnector selenium = WebConnector.getInstance();

	@And("^I go to add product in use page$")
	public void goToAddProduct() {
		selenium.waitingTime(2000);
		try {
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				selenium.waitForElementToBeClickable("productInUse");
				selenium.clickLoop("productInUse");
//				selenium.waitingTime(2000);
				//selenium.isCheck("Viewall");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("addProductInUse");
				selenium.clickLoop("addProductInUse");
			} else if (selenium.getUI().equalsIgnoreCase("classic")) {
				selenium.scrollToElement("addProductInUseC");
				selenium.waitForElementToBeClickable("addProductInUseC");
				selenium.click("addProductInUseC");
			}
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Error while navigating to adding product in use screen");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I search and add product$")
	public void searchAddProduct() {
		try {
			selenium.waitingTime(2000);
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				selenium.waitingTime(4000);
//				selenium.waitForElementToBeVisible("productframeUat");
				//selenium.switchToFrame("newcontactFrame");
				selenium.switchToFrame("productframeUat");
			} else if (selenium.getUI().equalsIgnoreCase("classic")) {

			}
			selenium.type("author", "Author Name");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitForElementToBeVisible("productHeader");
			String xpath = selenium.getDynamicXpath("TdtextProuductcontains", "product name", "Selectproductbyname");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.jsClickXpath(xpath);
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");
			selenium.waitingTime(2000);
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				selenium.switchOutOfFrame();
			}
		} catch (Exception e) {
			e.printStackTrace();
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while selecting the product");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^the product verification should be successful$")
	public void the_product_should_be_successfully_added() {
		selenium.waitingTime(2000);
		boolean isSuccess = false;
		if (selenium.getUI().equalsIgnoreCase("Classic")) 
			selenium.scrollToElement("addProductInUseC");
		String xpath=selenium.getDynamicXpath("anchorTextcontains", "product name", "endContains");
		if (selenium.isElementPresentXpathFast(xpath))
			isSuccess = true;
		selenium.printLastTestResult(isSuccess);

	}


	@Then("^I click on Product based on isbn$")
	public void click_on_contact_based_on_account_names() {

		try {

			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ISBN");
			selenium.search("ISBN");
			selenium.waitingTime(2000);
			//String xpath = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "endSearchContactWithAccount");
			String contactXpath = selenium.getDynamicXpath("anchorTextcontains", "ISBN", "endContains");
			System.out.println(contactXpath);
//			selenium.waitForXpathElementToBeClickable(contactXpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(contactXpath);
			selenium.waitingTime(2000);
			selenium.captureScreenShot();

		}
		catch (Exception e) {
			selenium.reportFailure("Error while Searching for isbn " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@And("^Verify Product flag$")
	public void verify_Product_flag() {

		try {
//			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Product URL");
//			selenium.navigateToURL(url);
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("productFlagEdit");
			selenium.scrollToElement("productFlagEdit");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			String attribute_grad5 = selenium.getElement("GradesPK5_checkBox").getAttribute("alt");
			System.out.println("attribute : "+attribute_grad5);
			String attribute_grade6 = selenium.getElement("GradesPK612_checkBox").getAttribute("alt");
			System.out.println("attribute : "+attribute_grade6);
			String attribute_prodFlag = selenium.getElement("productFlag_checkBox").getAttribute("alt");
			System.out.println("attribute : "+attribute_prodFlag);
			if((attribute_grad5.equalsIgnoreCase("true") ||attribute_grade6.equalsIgnoreCase("true")) || attribute_prodFlag.equalsIgnoreCase("true") ){
				selenium.test.log(LogStatus.PASS, "Grades PK-5 or 6-12 & Product Flags Evaluated - checked");
				System.out.println("PASS");
			}else{
				selenium.test.log(LogStatus.FAIL, "Grades PK-5 or 6-12 & Product Flags Evaluated - not checked");
				selenium.reportFailure("Grades PK-5 or 6-12 & Product Flags Evaluated - not checked");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I click modify product$")
	public void i_click_modify_product() {

		try {
			selenium.waitForElementToBeVisible("modifyProduct");
			selenium.scrollToElement("modifyProduct");
			selenium.waitForElementToBeClickable("modifyProduct");
			selenium.jsClick("modifyProduct");
			selenium.waitingTime(3000);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^Add ISBN to the product$")
	public void add_ISBN_to_the_product() {

		try {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");
			String isbn = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ISBN");
			String productXpath = selenium.getPropertiesObj().getProperty("productcheckbox").
					replace("$val", isbn);
			if(selenium.isElementPresentXpathFast(productXpath)){
//				selenium.waitForXpathElementToBeClickable(productXpath);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(productXpath);
//				selenium.waitingTime(1000);
				selenium.waitForElementToBeClickable("deleteSelected");
				selenium.click("deleteSelected");
			}
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("keyISBNText");
			selenium.type("keyISBNText", "ISBN");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickableLongerDuration("addButton");
			selenium.click("addButton");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickableLongerDuration("saveProduct");
			selenium.click("saveProduct");
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I Validate that isbn is added to the opportunity$")
	public void i_Validate_that_isbn_is_added_to_the_opportunity() {

		try {
			selenium.waitingTime(10000);
			selenium.scrollToElement("modifyProduct");
			selenium.waitForElementToBeClickable("modifyProduct");
			selenium.jsClick("modifyProduct");
			selenium.waitingTime(3000);
//			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");
			String isbn = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ISBN");
			String productXpath = selenium.getPropertiesObj().getProperty("productcheckbox").
					replace("$val", isbn);
			if(selenium.isElementPresentXpathFast(productXpath)){
				selenium.test.log(LogStatus.PASS, "Newly added ISBN found in the opportunity");
				System.out.println("PASS");
			}else {
				selenium.test.log(LogStatus.FAIL, "Newly added ISBN could not found in the opportunity");
				selenium.reportFailure("Newly added ISBN could not found in the opportunity");
				System.out.println("FAIL");
			}
			selenium.scrolldown(250);
			selenium.captureScreenShot();

		}catch (Exception e){
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


}
