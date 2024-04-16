package com.mhe.salesforce.testcases;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class EditShippingAddress {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String url;
//	String accountName="https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0010y00001YhzQiAAJ/view";
//	String accountName1="https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwXVdAAM/view";
	@And("^I edit the existing contact$")
	public void I_edi_the_existing_contact() {
		try {
			if (selenium.getUI().contains("Lightning")) {

				/*selenium.search("Account Name");
				selenium.waitingTime(3000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
				selenium.clickLoopXpath(Xpath);*/
				
//				selenium.navigateToURL(accountName1);
//				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(5000);
				if (selenium.isElementPresentFast("showAllLinks")) {
					selenium.waitForElementToBeClickable("showAllLinks");
					selenium.click("showAllLinks");
					}
				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
					selenium.waitForElementToBeClickable("addressLink");
					selenium.click("addressLink");
					System.out.println("Address link");
				} else {
					selenium.waitForElementToBeClickable("addressLink");
					selenium.click("addressLink");
				}
				selenium.waitingTime(4000);

//				String address = selenium.getDynamicXpath("spantextContains", "Address Name", "endContains");
//				System.out.println("address" +  address);
//				selenium.clickLoopXpath(address);
//				selenium.waitingTime(4000);
                selenium.waitForElementToBeClickable("FirstTableRecord");
				selenium.jsClick("FirstTableRecord");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
				selenium.waitingTime(4000);
				selenium.clearText("street2Address");
				String street2 = selenium.getRandomString();
				selenium.getElement("street2Address").sendKeys(street2);
				selenium.waitingTime(2000);
				System.out.println(street2);
                selenium.clearText("street3Address");
				String street3 = selenium.getRandomString();
				selenium.getElement("street3Address").sendKeys(street3);
				System.out.println(street3);
                selenium.waitingTime(2000);
                selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				url = selenium.getURL();
			}
		} catch (Exception e) {
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
	
		
			@Then("^Verify the changes$")
			public void Verify_the_changes() {
				try {
				String addressStatus = null;
				String exp_addressStatus = null;
				System.out.println("Navigating to URL :" + url);
				selenium.waitingTime(2000);
				selenium.navigateToURL(url);
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("addressStatusGetText");
				addressStatus = selenium.getText("addressStatusGetText").toString();
				exp_addressStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address Status Before");
				System.out.println("Results: " + addressStatus+ exp_addressStatus);
				if (addressStatus.equalsIgnoreCase(exp_addressStatus)) {
					selenium.test.log(LogStatus.PASS, "Test Case Passed! Status changed to Not Verified");

				} else {
					selenium.reportFailure("Test Case Failed");
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
				}
				catch (Exception e)
				{
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error occurred " + e.getMessage());
				}

	}
}