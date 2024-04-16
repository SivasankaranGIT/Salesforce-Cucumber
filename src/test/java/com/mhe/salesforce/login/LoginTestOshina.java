package com.mhe.salesforce.login;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestOshina {
	WebConnector selenium = WebConnector.getInstance();
	private String testCaseName="LoginTestOshina";

	@When("^I navigate to sdfc \"([^\"]*)\"$")
	public void I_navigate_to_sdfc(String url) {
	    selenium.openBrowser();
	    selenium.navigateTo(testCaseName, url);
	}

	@When("^I enter credentials \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_enter_credentials(String obj, String text) {
	    selenium.type(obj, text);
	}
	
	@When("^I click on button \"([^\"]*)\"$")
	public void I_click_on_button(String obj) {
		selenium.click(obj);
		selenium.waitingTime(2000);
	}
	
	@Then("^sdfc login should be successful$")
	public void sdfc_login_should_be_successful() {
		try {
			selenium.getUI();
			selenium.check_Change_UserInterface();
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
		}
	}
	
}
