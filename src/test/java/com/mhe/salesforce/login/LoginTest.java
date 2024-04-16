package com.mhe.salesforce.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
	WebConnector selenium = WebConnector.getInstance();
	private String testCaseName="LoginTest";
	@When("^I go to \"([^\"]*)\"$")
	public void I_go_to_salesforce(String url) {
		selenium.openBrowser();
//		selenium.navigateTo(testCaseName,url);
//		selenium.navigateToURL_propertiesFile("loginUrl");
		
		//READING TEST DATA (USER LOGIN URL) FROM TESTDATA PROPERTIES FILE HERE...
		String LoginURL = selenium.getTestDataFromPropertiesFile(url);
		System.out.println("Login URL is : " + LoginURL);
		selenium.navigateToURL(LoginURL);		
		selenium.waitingTime(2000);
	}

	@And("^I enter login \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_enter_login_username_and_password(String username, String password)
	{
		try
		{
			String UserName = selenium.getTestDataFromPropertiesFile(username);
			String Password = selenium.getTestDataFromPropertiesFile(password);
			selenium.waitForElementToBeVisible("loginUsername");
			selenium.typeData("loginUsername", UserName);
			selenium.typeData("loginPassword", Password);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Login Failed");
			selenium.reportFailure("Login Failed");
		}
	}
	
	@And("^I enter informatica login \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_enter_informatica_login_username_and_password(String username, String password)
	{
		try
		{
			String UserName = selenium.getTestDataFromPropertiesFile(username);
			String Password = selenium.getTestDataFromPropertiesFile(password);
			selenium.waitForElementToBeVisible("TextEntryField");
			selenium.typeData("TextEntryField", UserName);
			selenium.typeData("I_loginPassword", Password);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Login Failed");
			selenium.reportFailure("Login Failed");
		}
	}

	@Then("^login should be successful$")
	public void login_should_be_successful() {
		try {
//			if(selenium.isElementPresentFast("ZscalerUserName"))
//			{
//				selenium.waitForElementToBeClickable("ZscalerUserName");
//				selenium.typeData("ZscalerUserName", "sivasankaran.periyasamy@mheducation.com");
//				selenium.click("SignInBtn");
//				selenium.waitForElementToBeClickable("UsrName");
//				selenium.typeData("UsrName", "sivasankaran.periyasamy@mheducation.com");
//				selenium.typeData("Pwd", "T7biz@444T7biz@444");
//				selenium.click("SignInBtn");
//				selenium.waitForElementToBeClickable("SendCode");
//				selenium.click("SendCode");
//			}
			selenium.getUI();
			selenium.check_Change_UserInterface();
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			//selenium.loginAsSalesrep();
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			
	        // Log the IP address (you can customize the logging mechanism)
			String ipAddress = selenium.getIPAddress();
	        System.out.println("IP Address: " + ipAddress);
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	@Then("^I navigate to salesapplication$")
	public void I_navigate_to_salesapp() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			if(selenium.isElementPresentFast("loginPopUp"))
			{
				selenium.click("loginPopUp");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
			}
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.getElement("searchItemsTextField").sendKeys("Sales");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Saleslightningapp");
			selenium.jsClick("Saleslightningapp");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
		}
	}

}