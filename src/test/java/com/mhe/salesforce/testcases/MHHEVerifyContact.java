package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import io.cucumber.java.en.And;


public class MHHEVerifyContact {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

//	@And("^I create new address record$")
//	public void I_create_new_address_record() {
//		try {
//			if (selenium.getUI().contains("Lightning")) {
//
////				selenium.waitingTime(3000);
//				selenium.waitForElementToBeClickable("SearchThisList");
//				selenium.click("SearchThisList");
//				selenium.waitingTime(2000);
//				selenium.type("SearchThisList", "Contact Name");
//				selenium.getElement("SearchThisList").sendKeys(Keys.ENTER);
//				selenium.waitingTime(2000);
//
//				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
//				selenium.waitingTime(4000);
//				selenium.clickLoopXpath(Xpath);
////				selenium.waitingTime(4000);
//				selenium.waitForElementToBeClickable("showAllLinks");
//
//				selenium.click("showAllLinks");
//				selenium.waitingTime(2000);
//				if (selenium.isElementPresentFast("closeBtn")) {
//					selenium.waitForElementToBeClickable("closeBtn");
//					selenium.click("closeBtn");
//					selenium.waitForElementToBeClickable("addressLink");
//					selenium.click("addressLink");
//				} else {
//					selenium.waitForElementToBeClickable("addressLink");
//					selenium.click("addressLink");
//				}
////				selenium.waitingTime(4000);
//				selenium.waitForElementToBeClickable("new");
//				selenium.clickLoop("new");
//
//				String address = selenium.getRandomString();
//				selenium.getElement("Name_Field").sendKeys(address);
//				System.out.println(address);
//				selenium.waitForElementToBeClickable("addressTypeDropDwn2");
//				selenium.jsClick("addressTypeDropDwn2");
//				selenium.waitingTime(2000);
//				selenium.clickDynamic("spanTitle", "Address Type", "end");
//
//				selenium.type("street1Address", "Street1");
//				selenium.type("street2Address", "Street2");
//				selenium.type("street3Address", "Street3");
//				selenium.type("street4Address", "Street4");
//
//				selenium.type("cityAddress", "City");
//				selenium.type("postalCodeAddress", "Postal Code");
//				selenium.waitForElementToBeClickable("save");
//				selenium.click("save");
//				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
//				selenium.printLastTestResult(flagsuccess);
//				selenium.waitingTime(2000);
//
//				String Xpath1 = selenium.getDynamicXpath("anchorTitlecontains", "Street1", "endContains");
//				selenium.waitingTime(4000);
//				selenium.clickLoopXpath(Xpath1);
//				selenium.waitingTime(4000);
//
//		}
//
//		} catch (Exception e) {
//			selenium.waitingTime(3000);
//			System.out.println("Error catch");
//			boolean error = selenium.isElementPresentFast("ErrorListAll");
//			System.out.println(error);
//			if (error == true) {
//				System.out.println("Error came");
//				selenium.jsClick("closePopUp");
//				selenium.waitingTime(2000);
//				selenium.click("CancelButton");
//			}
//
//			else {
//				selenium.click("CancelButton");
//			}
//
//		}
//
//	}
//	@When("^I Navigate to Address record$")
//	public void I_Navigate_to_Address_record() {
//		selenium.click("allButtonLightning");
//		selenium.waitingTime(4000);
//		selenium.click("AllButtonL");
//		selenium.waitingTime(4000);
//		selenium.type("searchallitems", "Screen Name");
//		selenium.waitingTime(2000);
//		selenium.clickLoop("addressSearch");
//		selenium.waitingTime(2000);
//		selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
//
//}
}
