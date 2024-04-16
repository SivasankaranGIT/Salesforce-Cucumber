package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class SEGBASEGADMINRejectsAddressTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String url;
	String street1;

	@And("^create new address for the account$")
	public void create_new_address_for_the_account() {
		try {
			if (selenium.getUI().contains("Lightning")) {
		/*
				selenium.search("Account Name");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(4000);


		 */
//				String url=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account URL");;
//				selenium.navigateToURL(url);

				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(10000);
				if (selenium.isElementPresentFast("showAllLinks")) {
					selenium.waitForElementToBeClickable("showAllLinks");
					selenium.click("showAllLinks");
				}
//				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
					selenium.waitForElementToBeClickable("addressLink_new");
					selenium.click("addressLink_new");
				} else {
					selenium.waitForElementToBeClickable("addressLink_new");
					selenium.click("addressLink_new");
				}
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("new");
				selenium.clickLoop("new");
				selenium.clickDynamic("spantextContains", "Record Type", "endRadioBtn");
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.click("nextBtn");

				/*String address = selenium.getRandomString();
				selenium.getElement("Name_Field").sendKeys(address);
				System.out.println(address);*/
				
				selenium.type("Name_Field", "Address");
				
//				selenium.type("Search_contact", "Contact Name");
				selenium.type_propertiesFile("Search_contact", "ContactName");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("FirstContactInSearchContactPopup");
				selenium.jsClick("FirstContactInSearchContactPopup");
				selenium.waitingTime(2000);
				

				/*selenium.type("Search_contact", "Contact Name");
				selenium.waitingTime(2000);
				selenium.clickDynamic("strongdynamic", "Name", "end");*/
				selenium.waitingTime(3000);
				street1 = selenium.getRandomString();

				selenium.getElement("street1Address").sendKeys(street1);
				System.out.println(street1);

				// selenium.type("street1Address", "Street1");
				selenium.type("street2Address", "Street2");
				selenium.type("street3Address", "Street3");
				selenium.type("street4Address", "Street4");

				selenium.type("cityAddress", "City");
				selenium.type("postalCodeAddress", "Postal Code");

				//selenium.scrollToElement("addressTypeDropDwn2");
				//selenium.click("addressTypeDropDwn2");
				
				selenium.scrollToElement("addressTypeDropDwn1");
				selenium.click("addressTypeDropDwn1");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Address Type", "end");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("workflowNotesTextField");

				selenium.scrollToElement("workflowNotesTextField");
				selenium.type("workflowNotesTextField", "Workflow Notes");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("save");

				selenium.click("save");
				selenium.waitingTime(20000);
				/*flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);
				selenium.waitingTime(2000);*/

			}

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Login as different US user$")
	public void segbaAdminLogin() {
		try {
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("loginButton"))
			{
				System.out.println("Default user got logged-out. So doing default user login again!");
				selenium.doDefaultUATLogin();
			}
			selenium.waitingTime(2000);
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("User");
			selenium.navigateToURL(url);
			selenium.waitingTime(8000);
			selenium.switchToFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("loginSalesrep");
			selenium.click("loginSalesrep");
			selenium.waitingTime(15000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.check_Change_UserInterface();
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");

		} catch (Exception e) {

			selenium.reportFailure("Error while closing case " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Login as different \"([^\"]*)\"$")
	public void AdminLogin(String url) {
		try {
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("loginButton"))
			{
				System.out.println("Default user got logged-out. So doing default user login again!");
				selenium.doDefaultUATLogin();
			}
			selenium.waitingTime(2000);
			//String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("User");
			selenium.navigateToURL(url);
			selenium.waitingTime(8000);
			selenium.switchToFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("loginSalesrep");
			selenium.click("loginSalesrep");
			selenium.waitingTime(15000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.check_Change_UserInterface();
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");

		} catch (Exception e) {

			selenium.reportFailure("Error while closing case " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	
	@Then("^User rejects any address$")
	public void user_rejects_any_address() {
		
		String workflowStatus = null;
		String exp_workflowStatus = null;
		selenium.navigateToURL(url);
		selenium.waitForElementToBeClickable("approvaHistorySection");
		selenium.click("approvaHistorySection");
		selenium.waitingTime(6000);
		selenium.refresh();
		selenium.waitingTime(10000);
		selenium.waitForElementToBeClickable("rejectBtn");
		selenium.clickLoop("rejectBtn");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("commentsTextArea");
		selenium.type("commentsTextArea", "Comments");
		selenium.waitForElementToBeClickable("rejectBtnNew");
		selenium.click("rejectBtnNew");
		selenium.waitingTime(5000);
		selenium.navigateToURL(url);
		selenium.scrollToElement("workflowStatusText");
		workflowStatus = selenium.getText("workflowStatusText").toString();
		exp_workflowStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Workflow Status");
		System.out.println("The expected result is : "+workflowStatus +exp_workflowStatus);
		if (workflowStatus.equalsIgnoreCase(exp_workflowStatus)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");

		} else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^Navigate to addresses screen$")
	public void navigate_to_any_screen() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "Screen Name");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("addressSearch");
		selenium.clickLoop("addressSearch");
		selenium.waitingTime(4000);
		selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^capture the address url$")
	public void capture_address_url() {
		try {
		String Xpath1 = selenium.getDynamicXpathProperty("anchorTitlecontains", street1, "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath1);
		selenium.waitingTime(4000);

		url = selenium.getURL();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

}
