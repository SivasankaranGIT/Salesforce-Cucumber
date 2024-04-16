package com.mhe.salesforce.testcases;

import java.util.List;
import java.util.Map;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class CreateAccountOshina {
	
	WebConnector selenium = WebConnector.getInstance();
	private String testCaseName = "CreateAccountTest";

	@When("^I navigate to account creation screen$")
	public void I_navigate_to_account_creation_screen() {
		try {
		if(selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("new");
			selenium.click("new");
			selenium.test.log(LogStatus.INFO, "Accounts screen loaded successfully!");
		
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@When("^I validate the account name$")
	public void i_validate_the_account_name() {
		try {
		if (selenium.getUI().contains("Lightning")) {
//			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.switchToFrame("newAccountFrame");
		}
		
		selenium.typeRandomstring("accountName", WebConnector.ACC_NAME_RANDOM);
		selenium.test.log(LogStatus.INFO, "Entering the account name as: " + WebConnector.ACC_NAME_RANDOM);
		
		selenium.test.log(LogStatus.INFO, "Searching the account name");
		selenium.pressEnter("accountName");
		selenium.setImplicitWait(15);
		if (selenium.isElementPresentFast("accountNotPresent")) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Account already exists");
		} else {
			selenium.waitForElementToBeClickable("createNewAccount");
			selenium.click("createNewAccount");
			selenium.waitingTime(2000);
			

		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@When("^I fill in the following fields$")
	public void I_fill_in_the_following_fields(DataTable accountData) {
		try {
			List<Map<String, String>> accountDataList = accountData.asMaps(String.class, String.class);

			for (int count = 0; count <= 5; count++) {
				selenium.type(accountDataList.get(count).get("locator"),
						accountDataList.get(count).get("Excel Column Name"));
			}

			selenium.selectDropdownText(accountDataList.get(6).get("locator"),
					accountDataList.get(6).get("Excel Column Name"));

			selenium.selectCheckbox(accountDataList.get(7).get("locator"), testCaseName);

			selenium.type(accountDataList.get(8).get("locator"), accountDataList.get(8).get("Excel Column Name"));
			selenium.type(accountDataList.get(9).get("locator"), accountDataList.get(9).get("Excel Column Name"));
			for (int i = 10; i <= 14; i++) {
				selenium.selectDropdownText(accountDataList.get(i).get("locator"),
						accountDataList.get(i).get("Excel Column Name"));
			}

			selenium.type(accountDataList.get(15).get("locator"), accountDataList.get(15).get("Excel Column Name"));
			
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Error while filling up the account details");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
}
