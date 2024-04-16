package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateAcceptAddressChangesTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String street1;

	@And("^create new address for any contact and verify$")
	public void create_new_address_for_any_contact() {
		try {
			if (selenium.getUI().contains("Lightning")) {

//				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
//				selenium.navigateToURL(url);
				selenium.waitingTime(6000);
				if (selenium.isElementPresentsuperFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
				}
				if (selenium.isElementPresentsuperFast("showAllLinks")) {
					selenium.waitForElementToBeClickable("showAllLinks");
				selenium.click("showAllLinks");
				}
				if (selenium.isElementPresentsuperFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
				}
				selenium.waitForElementToBeClickable("addressLink");
				selenium.click("addressLink");
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("new");
				selenium.clickLoop("new");

				String recordtype = selenium.getDynamicXpath("spantextContains", "Record Type", "endRadioBtn");
				System.out.println(recordtype);
//				selenium.waitForXpathElementToBeClickable(recordtype);
				selenium.waitingTime(4000);
				selenium.clickXpath(recordtype);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.click("nextBtn");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Name_Field");
				String address = selenium.getRandomString();
				selenium.getElement("Name_Field").sendKeys(address);
				System.out.println(address);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("addressTypeDropDwn1");
				/*
				 * Actions action = new Actions(selenium.getDriver());
				 * action.moveToElement(selenium.getElement("addressTypeDropDwn2_new")).click().
				 * perform();
				 */
				selenium.jsClick("addressTypeDropDwn1");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Address Type", "end");
				/*
				 * selenium.getElement("addressTypeDropDwn2_new").sendKeys(Keys.DOWN);
				 * selenium.getElement("addressTypeDropDwn2_new").sendKeys(Keys.RETURN);
				 */
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactPreferredCheckBox");
				//selenium.jsClick("addressTypeDropDwn2");
				//selenium.waitingTime(2000);
				//selenium.clickDynamic("spanTitle", "Address Type", "end");

				selenium.jsClick("contactPreferredCheckBox");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("street1Address");

				selenium.type("street1Address", "Street1");
				selenium.type("street2Address", "Street2");
				selenium.type("street3Address", "Street3");
				selenium.type("street4Address", "Street4");

				String cityAddress = selenium.getRandomString();
				selenium.getElement("cityAddress").sendKeys(cityAddress);
				System.out.println(cityAddress);
				selenium.type("postalCodeAddress", "Postal Code");
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
//				selenium.waitingTime(8000);
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("objectFilterBtn");
				selenium.waitingTime(2000);
				selenium.jsClick("objectFilterBtn");
//				selenium.waitingTime(2000);
//				selenium.waitForElementToBeVisible("addressFiltervalueInput");
//				selenium.clearText("addressFiltervalueInput");

				selenium.waitingTime(2000);
				selenium.getElement("addressFiltervalueInput").sendKeys(cityAddress);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Button");
				selenium.jsClick("Save_Button");
				selenium.waitingTime(5000);

				selenium.url = selenium.getURL();
				System.out.println(selenium.url);
				selenium.test.log(LogStatus.INFO, "URL : "+selenium.url );
				String Xpath1 = selenium.getDynamicXpathProperty("spantextContains", cityAddress, "endContains");
//				selenium.waitForXpathElementToBeClickable(Xpath1);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath1);
				selenium.waitingTime(8000);

			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}

	}

	@Then("^Accept changes and verify status$")
	public void accept_changes() {
		try {

			String addressStatus = null;
			String exp_addressStatus = null;
			selenium.waitForElementToBeVisible("addressStatusGetText");
			addressStatus = selenium.getTextLoop("addressStatusGetText").toString();
			exp_addressStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address Status Before");
			System.out.println("Actual & Expected Address :" +addressStatus+ exp_addressStatus );
			if (addressStatus.equalsIgnoreCase(exp_addressStatus)) 
			{
				selenium.test.log(LogStatus.PASS, "Test Case Passed! Status changed to Not Verified");
				System.out.println("PASS - Test Case Passed! Status changed to Not Verified");
			}
			else 
			{
				selenium.reportFailure("Test Case Failed! Status did not change to Not Verified");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed! Status did not change to Not Verified");
				System.out.println("FAIL - Test Case Failed! Status did not change to Not Verified");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("verifyAddressBtn");
			selenium.jsClick("verifyAddressBtn");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.switchToMultipleFrame("FSL_Iframe");
			selenium.waitingTime(4000);
			selenium.scrollToElement("acceptChangesBtn");
			selenium.waitForElementToBeClickable("acceptChangesBtn");
			selenium.click("acceptChangesBtn");
			selenium.waitingTime(12000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("addressStatusGetText");
			addressStatus = selenium.getText("addressStatusGetText").toString();
			exp_addressStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address Status After");
			System.out.println("Actual & Expected Addresses :" +addressStatus+ exp_addressStatus );
			if (addressStatus.equalsIgnoreCase(exp_addressStatus)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed! Status changed to Verified");
				System.out.println("Test Case Passed! Status changed to Verified");
			} else {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed! Status did not change to Verified");
				selenium.reportFailure("Test Case Failed! Status did not change to Verified");
				System.out.println("Test Case Failed! Status did not change to Verified");
			}
		} catch (Exception e) {
			selenium.captureScreenShot();
			selenium.navigateTo("LoginTest", "Url");
			selenium.waitingTime(4000);
			selenium.check_Switch_UserInterface();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@And("^delete new address for the contact$")
	public void delete_new_address_for_the_contact() {
		try {
			if (selenium.getUI().contains("Lightning")) {

				selenium.navigateToURL(selenium.url);
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("objectFilterBtn");
				selenium.jsClick("objectFilterBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("clearFilterBtn");
				selenium.jsClick("clearFilterBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Button");
				selenium.jsClick("Save_Button");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("closeFilterBtn");
				selenium.jsClick("closeFilterBtn");
				selenium.waitingTime(10000);
				String Xpath = selenium.getDynamicXpath("deleteMenuStart1", "Address", "deleteMenuEnd1");
				selenium.waitingTime(3000);
				System.out.println("xpath is" + Xpath);
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForXpathElementToBeClickable(Xpath);
				selenium.clickXpath(Xpath);
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("DeleteRecord");
				selenium.click("DeleteRecord");
				selenium.waitingTime(8000);
				selenium.captureScreenShot();
				selenium.waitForElementToBeClickable("deleteBtn");
				selenium.click("deleteBtn");
				selenium.waitingTime(15000);
				/*selenium.waitForElementToBeVisible("contactSuccessfulL");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);*/

				selenium.test.log(LogStatus.PASS, "Record deleted successfully");

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}

			else {
				selenium.click("CancelButton");
			}

		}

	}

	@And("^I change the app launcher to MHHE$")
	public void i_change_the_app_launcher_to_Salesforce_Chatter() {
		try {
			String appName = selenium.getText("appName");
			if(appName.equalsIgnoreCase("MHHE")){
				System.out.println("App Launcher is MHHE");
			}else{
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("searchItemsTextField");
				selenium.typeData("searchItemsTextField", "MHHE");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("MHHEApplaunch");
				selenium.jsClick("MHHEApplaunch");
				selenium.waitingTime(5000);

			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I change the app launcher to \"([^\"]*)\"$")
	public void i_change_the_app_launcher_to_Salesforce_Chatter(String app_Name) {
		try {
			selenium.waitingTime(5000);
			String appName=null;
			if (selenium.isElementPresentFast("appName01")){
				appName = selenium.getText("appName01");
			}
			else {
				appName = selenium.getText("appName02");
			}

			if(appName.equalsIgnoreCase(app_Name)){
				System.out.println("Current App Launcher is "+appName+"Expected App Launcher is"+app_Name);
			}else{
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("searchItemsTextField");
				selenium.typeData("searchItemsTextField", app_Name);
				selenium.waitingTime(4000);
				selenium.clickDynamicData("ApplaunchStart",app_Name ,"ApplaunchEnd");
				selenium.waitingTime(5000);
			}			
			selenium.checkFlowInterruptedPopup();
			selenium.captureScreenShot();
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to app");
		}
	}

	@And("^I change the app launcher to MHES Lightning Console")
	public void i_change_the_app_launcher_to_mhes_lightning_console() {
		try {
			String appName = selenium.getText("appName");
			if (appName.equalsIgnoreCase("MHES Lightning Console")) {
				System.out.println("App Launcher is MHES Lightning Console");
			} else {
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("searchItemsTextField");
				selenium.typeData("searchItemsTextField", "MHES Lightning Console");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("csomapplauncher");
				selenium.jsClick("csomapplauncher");
				selenium.waitingTime(5000);
			}
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@And("^I change the app launcher to CSOM Lightning Console")
	public void i_change_the_app_launcher_to_csom_lightning_console() {
		try {
			String appName = selenium.getText("appName");
			if(appName.equalsIgnoreCase("CSOM Lightning Console")){
				System.out.println("App Launcher is CSOM Lightning Console");
			}else{
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("searchItemsTextField");
				selenium.typeData("searchItemsTextField", "CSOM Lightning Console");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("csomapplauncher");
				selenium.jsClick("csomapplauncher");
				selenium.waitingTime(5000);
			}
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
}
