package com.mhe.salesforce.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matcher;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;
//import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import java.security.Timestamp;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class CommonUtil {
	WebConnector selenium = WebConnector.getInstance();
	private static ExtentReports extent;
	public static String fileName;

	String loggedInUser="qa automation";
	public static LinkedHashSet<String> tagNamesCombo = new LinkedHashSet<String>();

	@Given("^Runmode for \"([^\"]*)\" is Y$")
	public void runmode_for_testcase(String testCaseName) {
		if (selenium.getTestCaseName() != testCaseName)
			selenium.test = selenium.extent.startTest(testCaseName);
//		if (!DataUtil.isTestExecutable(selenium.xls, testCaseName)) {
		if (!selenium.isTestExecutable(testCaseName)) {
			selenium.test.log(LogStatus.SKIP, "<b> Skipping the testcase  "  +  testCaseName  +  " as runmode is N </b>");
			System.out.println("<b> Skipping the testcase  "  +  testCaseName  +  " as runmode is N </b>");
			throw new PendingException("<b> Skipping the testcase  "  +  testCaseName  +  " as runmode is N </b>");
		}
		selenium.setTestCaseName(testCaseName);
	}
	
    @Given("^I am logged into salesforce for \"([^\"]*)\"$")
    public void I_am_logged_into_salesforce(String testCaseName) {
//        runmode_for_testcase(testCaseName);
        selenium.checkFlowInterruptedPopup();
        boolean isLoggedIn = false;
        if (selenium.driver != null) {
            //selenium.retryingWait("homeTab");
            System.out.println("selenium.driver is not null");
            isLoggedIn = selenium.isElementPresentFast("userIcon");
            if(!isLoggedIn)
            {
                System.out.println("Is user logged in::" + isLoggedIn);
                System.out.println("Refreshing the page as User Info Icon not found.");
                i_logout_of_any_classic_user();
                selenium.refresh();
                selenium.waitingTime(8000);
                isLoggedIn = selenium.isElementPresentFast("userIcon");
                System.out.println("Is user logged in::" + isLoggedIn);
            }
            if(isLoggedIn)
            {
                System.out.println("usericon visible");
                selenium.test.log(LogStatus.INFO, "usericon visible");
            }
            else if(!isLoggedIn &&(selenium.isElementPresentFast("loginUsername")))
              {
                  selenium.setTestCaseName("LoginTest");
                  selenium.doDefaultLogin();
                    selenium.getUI();
                    selenium.check_Change_UserInterface();
                    selenium.waitingTime(2000);
                    selenium.setTestCaseName(testCaseName);
              }
              else if(!isLoggedIn &&(!selenium.isElementPresentFast("loginUsername")))
              {
                  selenium.getUI();
                    selenium.check_Change_UserInterface();
              }
            //selenium.test.log(LogStatus.INFO, "Hometab is available"+isLoggedIn);
        }

          else if(selenium.driver == null) {
          selenium.setTestCaseName("LoginTest");
          selenium.openBrowser();
          selenium.doDefaultLogin();
          selenium.getUI();
          selenium.check_Change_UserInterface();
          selenium.waitingTime(2000);
          selenium.setTestCaseName(testCaseName);
          }

    }
	
	
	
	@Then("^I login as Sales Rep$")
	 public void i_login_as_sales_rep() {
			try {
//				long startTime = System.nanoTime();
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.click("LogOut");
					selenium.waitingTime(3000);
					if(selenium.isElementPresentFast("menuDots"))
					{
						System.out.println("Successfully logged out from existing user!");
					}
					else if(selenium.isElementPresentFast("loginButton"))
					{
						System.out.println("Default user got logged-out. So doing default user login again!");
						selenium.doDefaultUATLogin();
					}
					else if(selenium.isElementPresentFast("goBackBtn"))
					{
						System.out.println("Page did not load properly. So doing default user login again!");
						selenium.click("goBackBtn");
						selenium.doDefaultUATLogin();
					}
					selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
				}
				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
				selenium.navigateToURL(url);
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("newAccountFrame");
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeVisible("profileName");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(8000);
				/*if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}*/
				I_successfully_logout_from_application();
//				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
//				selenium.waitingTime(2000);				
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
				selenium.check_Switch_UserInterface();
				
//				long endTime = System.nanoTime();
//				long duration = (endTime - startTime);
//				System.out.println("duration 2 -->"  + duration);
			}
			catch (Exception e)
			{	
				selenium.test.log(LogStatus.INFO, "error while loggin in");	
				selenium.check_Switch_UserInterface();
				i_logout_of_any_user();
				selenium.reportFailure("Error while logging in " + e.getMessage());
			}
	}
	
	
	@Then("^I login as \"([^\"]*)\"$")
	 public void i_login_as_user_url(String url) {
			try {
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.click("LogOut");
					selenium.waitingTime(3000);
					if(selenium.isElementPresentFast("menuDots"))
					{
						System.out.println("Successfully logged out from existing user!");
					}
					else if(selenium.isElementPresentFast("loginButton"))
					{
						System.out.println("Default user got logged-out. So doing default user login again!");
						selenium.doDefaultUATLogin();

					}
					else if(selenium.isElementPresentFast("goBackBtn"))
					{
						System.out.println("Page did not load properly. So doing default user login again!");
						selenium.click("goBackBtn");
						selenium.doDefaultUATLogin();
					}
					selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
				}
				selenium.waitingTime(3000);
				//String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
				selenium.navigateToURL(url);
				selenium.waitingTime(8000);
				
				selenium.switchToFrame("newAccountFrame");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//					selenium.captureScreenShot();
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}
				I_successfully_logout_from_application();
				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);				
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
				selenium.check_Switch_UserInterface();

			} catch (Exception e) {	
			selenium.test.log(LogStatus.INFO, "error while loggin in");	
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			//I_successfully_logout_from_application();
			//selenium.waitingTime(4000);
			selenium.check_Switch_UserInterface();
			i_logout_of_any_user();
			selenium.reportFailure("Error while logging in " + e.getMessage());

		}
	}
	
	@Then("^I do login as \"([^\"]*)\"$")
	 public void i_do_login_as_user_url(String url) {
			try {
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.jsClick("LogOut");
					selenium.waitingTime(6000);
					if(selenium.isElementPresentFast("quickFind")) //replaced 'menuDots'
					{
						System.out.println("Successfully logged out from existing user!");
						selenium.test.log(LogStatus.INFO, "Successfully logged out from existing user!");	
					}
					else
					{
						if(selenium.isElementPresentFast("loginButton"))
						{
							System.out.println("Default user got logged-out. So doing default user login again!");
							selenium.test.log(LogStatus.INFO, "Default user got logged-out. So doing default user login again!");
							selenium.doDefaultUATLogin();
						}
						else if(selenium.isElementPresentFast("UserLoggedInTrue"))
						{
							System.out.println("User is still logged-in! so retrying logout..");
							selenium.test.log(LogStatus.INFO, "User is still logged-in! so retrying logout..");
							selenium.refresh();
							selenium.waitingTime(10000);
							selenium.waitForElementToBeClickable("Logoutas");
							selenium.jsClick("Logoutas"); //it should not go to main UAT login page. no logic return for it so far.
						}
						else if(selenium.isElementPresentFast("goBackBtn"))
						{
							System.out.println("Page did not load properly. So doing default user login again!");
							selenium.test.log(LogStatus.INFO, "Page did not load properly. So doing default user login again!");
							selenium.click("goBackBtn");
							selenium.doDefaultUATLogin();
						}
					}
				}
//				selenium.waitingTime(3000);

				//READING TEST DATA (USER LOGIN URL) FROM TESTDATA PROPERTIES FILE HERE...
				String UserLoginURL = selenium.getTestDataFromPropertiesFile(url);
				selenium.navigateToURL(UserLoginURL);
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("newAccountFrame");
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeVisible("profileName");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(8000);
				/*if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}*/
				I_successfully_logout_from_application();
//				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
//				selenium.waitingTime(2000);		
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
				selenium.check_Switch_UserInterface();

			}
			catch (Exception e)
			{	
				if (selenium.isElementPresentsuperFast("DiscardChanges"))
				{
					selenium.click("DiscardChanges");
					selenium.waitingTime(5000);
				}
				selenium.test.log(LogStatus.INFO, "error while loggin in");	
				selenium.check_Switch_UserInterface();
				i_logout_of_any_user();
				selenium.reportFailure("Error while logging in " + e.getMessage());
			}
		}	
	
	@Then("^I login as Sales Rep in classic$")
	 public void i_login_as_sales_rep_in_classic() {
			try
				{
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("userIcon");
					selenium.clickNew("userIcon");
					selenium.waitingTime(6000);
					selenium.waitForElementToBeVisible("userName");
					String user = selenium.getText("userName");
					System.out.println("Currently logged-in user is : " + user);
					System.out.println("Expected log-in user is : " + loggedInUser);
					if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
						System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
						selenium.waitForElementToBeClickable("LogOut");
						selenium.click("LogOut");
						selenium.waitingTime(3000);
						if(selenium.isElementPresentFast("menuDots"))
						{
							System.out.println("Successfully logged out from existing user!");
						}
						else if(selenium.isElementPresentFast("loginButton"))
						{
							System.out.println("Default user got logged-out. So doing default user login again!");
							selenium.doDefaultUATLogin();
						}
						else if(selenium.isElementPresentFast("goBackBtn"))
						{
							System.out.println("Page did not load properly. So doing default user login again!");
							selenium.click("goBackBtn");
							selenium.doDefaultUATLogin();
						}
						selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
					}
					selenium.waitingTime(3000);
					String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
					selenium.navigateToURL(url);
					selenium.waitingTime(8000);					
					selenium.switchToFrame("newAccountFrame");
					String profileName= selenium.getText("profileName");
					String loggedInUserName=selenium.getText("loggedInUserName");
					selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("loginSalesrep");
					selenium.click("loginSalesrep");
					selenium.waitingTime(5000);
					if(selenium.isElementPresentsuperFast("loginsessionbutton"))
					{
						selenium.test.log(LogStatus.INFO, "LogIn Button Found");
						selenium.waitForElementToBeClickable("loginsessionbutton");
						selenium.click("loginsessionbutton");
						selenium.waitingTime(2000);
					}
					I_successfully_logout_from_application();
					selenium.waitingTime(3000);
					selenium.switchOutOfFrame();
					selenium.waitingTime(2000);				
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
//					selenium.check_Switch_UserInterface();
				}
			catch (Exception e)
				{	
					selenium.test.log(LogStatus.INFO, "error while loggin in");	
//					selenium.check_Switch_UserInterface();
					i_logout_of_any_user();
					selenium.reportFailure("Error while logging in " + e.getMessage());
				}
	}
	
	@Then("^I login as Sales Rep in classic \"([^\"]*)\"$")
	 public void i_login_as_sales_rep_in_classic(String url) {
			try
				{
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("userIcon");
					selenium.clickNew("userIcon");
					selenium.waitingTime(6000);
					selenium.waitForElementToBeVisible("userName");
					String user = selenium.getText("userName");
					System.out.println("Currently logged-in user is : " + user);
					System.out.println("Expected log-in user is : " + loggedInUser);
					if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
						System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
						selenium.waitForElementToBeClickable("LogOut");
						selenium.click("LogOut");
						selenium.waitingTime(3000);
						if(selenium.isElementPresentFast("menuDots"))
						{
							System.out.println("Successfully logged out from existing user!");
						}
						else if(selenium.isElementPresentFast("loginButton"))
						{
							System.out.println("Default user got logged-out. So doing default user login again!");
							selenium.doDefaultUATLogin();
						}
						else if(selenium.isElementPresentFast("goBackBtn"))
						{
							System.out.println("Page did not load properly. So doing default user login again!");
							selenium.click("goBackBtn");
							selenium.doDefaultUATLogin();
						}
						selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
					}
					selenium.waitingTime(3000);
//					String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
					selenium.navigateToURL(url);
					selenium.waitingTime(8000);					
					selenium.switchToFrame("newAccountFrame");
					String profileName= selenium.getText("profileName");
					String loggedInUserName=selenium.getText("loggedInUserName");
					selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("loginSalesrep");
					selenium.click("loginSalesrep");
					selenium.waitingTime(5000);
					if(selenium.isElementPresentsuperFast("loginsessionbutton"))
					{
						selenium.test.log(LogStatus.INFO, "LogIn Button Found");
						selenium.waitForElementToBeClickable("loginsessionbutton");
						selenium.click("loginsessionbutton");
						selenium.waitingTime(2000);
					}
					I_successfully_logout_from_application();
					selenium.waitingTime(3000);
					selenium.switchOutOfFrame();
					selenium.waitingTime(2000);				
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
//					selenium.check_Switch_UserInterface();
				}
			catch (Exception e)
				{	
					selenium.test.log(LogStatus.INFO, "error while loggin in");	
//					selenium.check_Switch_UserInterface();
//					i_logout_of_any_user();
					selenium.logoutFromAnyUserClassic();
					selenium.reportFailure("Error while logging in " + e.getMessage());
				}
	}

	@Then("^I logout of Sales Rep$")
	public void i_logout_of_sales_rep() {
		try {
			selenium.waitingTime(2000);
			selenium.logoutOfSalesrep();
			selenium.test.log(LogStatus.PASS, "Logout of sales rep successful!");
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Given("^I navigate to \"([^\"]*)\"$")
	public void I_navigate_to(String pageElements) {
		String element[] = pageElements.split(",");
		for (String webelement : element) {
			selenium.waitingTime(2000);
			selenium.click(webelement);
			selenium.waitingTime(3000);
		}
	}

	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_enter(String objectRepoElement, String text) {
		selenium.type(objectRepoElement, text);
	}

	@And("^I click on \"([^\"]*)\"$")
	public void I_click_on(String objectRepoElement) {
		selenium.click(objectRepoElement);
		selenium.waitingTime(2000);
	}
	
	@And("^I click on the \"([^\"]*)\"$")
	public void I_click_on_the(String objectRepoElement) {
		selenium.waitingTime(2000);
		selenium.clickHeader(objectRepoElement);
		selenium.waitingTime(2000);
	}

	@And("^I click on dynamic element$")
	public void I_click_on_dynamic(DataTable table) {
		selenium.waitingTime(2000);
		List<String> data = table.asList(String.class);
		selenium.clickDynamic(data.get(0), data.get(1), data.get(2));
		selenium.waitingTime(2000);
	}
	
	@And("^I click on dynamic element based on account name$")
    public void i_click_on_dynamic_element_based_on_account_name(DataTable table) {
		selenium.waitingTime(4000);
		List<String> data = table.asList(String.class);
		selenium.clickDynamicUsingAccName(data.get(0), WebConnector.ACC_NAME_RANDOM, data.get(2));
		selenium.waitingTime(4000);
	}
	
	@And("^I click on account name$")
    public void i_click_on_account_name() {
		selenium.waitingTime(4000);
		selenium.clickDynamic("tableHeaderAnchorText","Account Name", "end");
	}
	

	@When("^I search the \"([^\"]*)\"$")
	public void I_search(String data) {
		selenium.waitingTime(2000);
		selenium.search(data);
	}

	@When("^I search Account Name$")
	public void i_search_account_name() {
		selenium.waitingTime(2000);
		selenium.searchForAcc();

	}

	@When("^I get the Account Name$")
	public void i_get_the_account_name() {
		try {

		if (DataUtil.isTestExecutable(selenium.xls, WebConnector.TC_NAME)) {

			if (selenium.getExcelValue(WebConnector.TC_NAME).get(0).get(WebConnector.TC_COLUMN_NAME)
					.equalsIgnoreCase("Y")) {

				selenium.test.log(LogStatus.INFO, "Assigning value to Account Name: " + WebConnector.ACC_NAME_RANDOM);
			}
			else {
				WebConnector.ACC_NAME_RANDOM = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
				selenium.test.log(LogStatus.INFO,"Assigning value to Account Name from Excel: " + WebConnector.ACC_NAME_RANDOM);
			}

		} else {
			WebConnector.ACC_NAME_RANDOM = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
			selenium.test.log(LogStatus.INFO,"Assigning value to Account Name from Excel: " + WebConnector.ACC_NAME_RANDOM);
		}

		/*
		 * && (selenium.getExcelValue(WebConnector.TC_NAME).get(0).get(WebConnector.
		 * TC_COLUMN_NAME).equalsIgnoreCase("Y")))
		 * 
		 * selenium.test.log(LogStatus.INFO, "Assigning value to Account Name: " +
		 * WebConnector.ACC_NAME_RANDOM);
		 */

		/*
		 * else {
		 * 
		 * WebConnector.ACC_NAME_RANDOM =
		 * selenium.getExcelValue(selenium.getTestCaseName()).get(0)
		 * .get("Account Name"); selenium.test.log(LogStatus.INFO,
		 * "Assigning value to Account Name from Excel: " +
		 * WebConnector.ACC_NAME_RANDOM);
		 * 
		 * }
		 */

		/*
		 * if (!selenium.getExcelValue(WebConnector.TC_NAME).get(0).get(WebConnector.
		 * TC_COLUMN_NAME).equalsIgnoreCase("Y")) WebConnector.ACC_NAME_RANDOM =
		 * selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name"
		 * );
		 */

		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}
	
	
	
	@When("^I navigated to cases page$")
    public void i_navigated_to_cases_page() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.click("allButtonLightning");
			selenium.waitingTime(4000);
			selenium.click("AllButtonL");
			selenium.waitingTime(4000);
			selenium.type("searchallitems", "cases");
			selenium.waitingTime(2000);
			//selenium.click("cases");
			selenium.click("casesTab");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "Navigated successfully to Case Page!");

		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("allButtonClassic");
			selenium.click("allButtonClassic");
			selenium.scrollToElement("casesClassic");
			selenium.click("casesClassic");
			selenium.waitingTime(2000);
			
		}
		 
	 }

	@Then("^user should not be able to view the delete button$")
	public void user_should_not_be_able_to_view_the_delete_button() {
		selenium.test.log(LogStatus.INFO, "Checking for the presence of delete button");
		boolean isSuccess = selenium.isElementPresentFast("delete");

		selenium.printLastTestResult(!isSuccess);
	}

	@Then("^user should be able to click the delete button$")
	public void user_should__be_able_to_click_the_delete_button() {
		selenium.test.log(LogStatus.INFO, "Checking for the presence of delete button");
//		selenium.waitingTime(2000);
//		selenium.clickLoop("Select_Case");
//		selenium.waitingTime(2000);
//		selenium.clickLoop("DeleteRecord");
//		selenium.waitingTime(2000);
//		selenium.click("DeleteButton");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("DeleteActionBtn");
		selenium.click("DeleteActionBtn");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("deletePopupBtn");
		selenium.click("deletePopupBtn");
		
	}
	
	public void I_successfully_logout_from_application() {
		System.out.println("Inside I_successfully_logout_from_application method");
//		selenium.navigateTo("LoginTest", "Url");
		selenium.navigateTo_propertiesFile("loginUrl");
		selenium.waitingTime(6000);
		selenium.checkFlowInterruptedPopup();
		  if (selenium.getTestCaseName().contains("ALEKS")) {
				  System.out.println("ALEKS related case..");
				  selenium.checkFlowInterruptedPopup();
				  selenium.waitForElementToBeClickable("menuDots");
				  selenium.click("menuDots");
				  selenium.waitingTime(3000);
				  selenium.waitForElementToBeVisible("searchItemsTextField");
				  selenium.getElement("searchItemsTextField").sendKeys("Sales");
				  selenium.waitingTime(2000);
				  if(selenium.isElementPresentFast("Saleslightningapp"))
				  {
				  selenium.jsClick("Saleslightningapp");
				  selenium.waitingTime(5000);
				  }
				  else {
						selenium.navigateTo("LoginTest", "Url");
						selenium.waitingTime(8000);
				  }			  
		  }
		  
		  if(selenium.isAlertPresent())  {
			  System.out.println("Alert present..");
			  selenium.acceptAlertPopup();
		  }
	}

	
	@When("^I get the Opportunity Name$")
	public void i_get_the_Opportunity_name() {

		if (DataUtil.isTestExecutable(selenium.xls, WebConnector.TC_NAME)) {

			if (selenium.getExcelValue(WebConnector.TC_NAME).get(0).get(WebConnector.TC_COLUMN_NAME)
					.equalsIgnoreCase("Y")) {

				selenium.test.log(LogStatus.INFO, "Assigning value to opportunity Name: " + selenium.opportunity);
			}
			else {
				selenium.opportunity = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("opportunity name");
				selenium.test.log(LogStatus.INFO,"Assigning value to Account Name from Excel: " + selenium.opportunity);
			}

		} else {
			selenium.opportunity = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("opportunity name");
			selenium.test.log(LogStatus.INFO,"Assigning value to Account Name from Excel: " + selenium.opportunity);
		}


		selenium.waitingTime(2000);

	}
	
	@When("^I navigate to setup page$")
	public void I_navigate_to_setup_page()  {
		try {
		
			selenium.navigateToSetupPage("https://mh--uat.sandbox.lightning.force.com/lightning/setup/SetupOneHome/home");
		selenium.waitingTime(5000);
		selenium.refresh();
		selenium.waitingTime(5000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		}
		 catch (Exception e) {
				
				selenium.reportFailure("Error while clicking Setup " + e.getMessage());
			}

	}


	@After
	public void logout(Scenario scenario) {
		
//		selenium.takeScreenShot();	//Capturing screenshot at end of every test scenario
		selenium.total_tc_count++;
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver and save it to the specified location
				File sourcePath = ((TakesScreenshot) selenium.driver).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + screenshotName + ".png");
				Files.copy(sourcePath.toPath(), destinationPath.toPath());
				scenario.attach(destinationPath.toString(), "image/png", "image");				
			} catch (IOException e) {
				System.out.println("Error while taking screenshot...");
		  } 
		}
		
		if (!(selenium.getTestCaseName().equalsIgnoreCase("InformaticaInterfaceLogin") || selenium.getTestCaseName().equalsIgnoreCase("RunInformaticaInterfaceJobs") || selenium.getTestCaseName().equalsIgnoreCase("VerifyInformaticaInterfaceJobStatus") || selenium.getTestCaseName().equalsIgnoreCase("InterfaceJobStatusSummaryReport") || selenium.getTestCaseName().equalsIgnoreCase("InformaticaInterfaceLogout")))
		{
			if(selenium.isElementPresentsuperFast("opportunityAccountsEditCancel"))
			{
				selenium.clickLoop("opportunityAccountsEditCancel");
			}
			else if(selenium.isElementPresentsuperFast("CancelButton"))
			{
				selenium.clickLoop("CancelButton");
			}
			else if (selenium.isElementPresentsuperFast("CancelButton_Span"))
			{
				selenium.clickLoop("CancelButton_Span");
			}
			else if (selenium.isElementPresentsuperFast("DiscardChanges"))
			{
				selenium.click("DiscardChanges");
			}
			try
			{
				I_successfully_logout_from_application();
			}
			catch(org.openqa.selenium.NoSuchSessionException e)
			{
				System.out.println("Invalid session...");
			}
		}
	}
	
	 @Before
	 public void setup(Scenario scenario)
	 {
		 System.out.println("All tagname list::: "+scenario.getSourceTagNames());
//		 ArrayList<String> tagNames = new ArrayList<String>();
		 for (String tagName: scenario.getSourceTagNames()) {
			 if(tagName.equalsIgnoreCase("@DigitalTrainings")||tagName.equalsIgnoreCase("@MHECourse")
				 ||tagName.equalsIgnoreCase("@Campaign")||tagName.equalsIgnoreCase("@Department")||tagName.equalsIgnoreCase("@Profiles")||tagName.equalsIgnoreCase("@Quote")
				 	||tagName.equalsIgnoreCase("@Events")||tagName.equalsIgnoreCase("@Tasks")||tagName.equalsIgnoreCase("@Leads")||tagName.equalsIgnoreCase("@Products")
				 		||tagName.equalsIgnoreCase("@ProductCatalog")||tagName.equalsIgnoreCase("@Consultant")||tagName.equalsIgnoreCase("@Cases")||tagName.equalsIgnoreCase("@Samples")
				 			||tagName.equalsIgnoreCase("@Accounts")||tagName.equalsIgnoreCase("@Contacts")||tagName.equalsIgnoreCase("@Community")||tagName.equalsIgnoreCase("@OpportunitiesDependent")||tagName.equalsIgnoreCase("@OpportunitiesNonDependent")||tagName.equalsIgnoreCase("@InformaticaInterface")||tagName.equalsIgnoreCase("@FSL")
								||tagName.equalsIgnoreCase("@E2CJob1")||tagName.equalsIgnoreCase("@E2CJob2")||tagName.equalsIgnoreCase("@E2CJob3")||tagName.equalsIgnoreCase("@E2CJob4")||tagName.equalsIgnoreCase("@Email2CaseA3K")||tagName.equalsIgnoreCase("@E2C")||tagName.equalsIgnoreCase("@DiscountWizard")||tagName.equalsIgnoreCase("@A3K")) {
				 
				 //				 tagNames.add(tagName);
				 tagNamesCombo.add(tagName.substring(1));
			 }
		 }
		 
//		 System.out.println("selected tagname list::: "+tagNames);
		 System.out.println("combo selected tagname list::: "+tagNamesCombo);
	 }
	
	 @Before()
	    public void beforeScenario(Scenario scenario)
	    {
		    Date d = new Date();
		    fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html" + scenario.getName();
		    String reportPath =WebConnector.REPORTS_PATH + fileName;
	        extent = new ExtentReports (reportPath + DisplayOrder.NEWEST_FIRST, true);
	        extent.loadConfig(new File(System.getProperty("user.dir") + "//ReportsConfig.xml"));
			extent.addSystemInfo("Selenium Version", "4.1.1").addSystemInfo("Environment", "US_UAT")
					.addSystemInfo("Browser", "Chrome 103.0.5060.114");
	    }

	 
//	@Before
//	public void checkiscancel() {
//		if(selenium.isElementPresentFast("CancelButton"))
//		{
//			selenium.click("CancelButton");
//		}
//		else if (selenium.isElementPresentFast("CancelButton_Span"))
//		{
//			selenium.clickLoop("CancelButton_Span");
//		}
//	}
//ALEKSAdminCreatesContact
	@After("@logout or @InformaticaInterfaceLogout")

	public void quitBrowser() throws IOException, InterruptedException {

		System.out.println("Inside quitBrowser method");
		selenium = WebConnector.getInstance();
//		Date d = new Date();
//		//String new_fileName = d.toString().replace(":", "_").replace(" ", "_") + "_Group.html";
//		String new_fileName = "Report_"+tagNamesCombo+"_Group.html";
//		selenium.quit();
		
//		if (selenium.test != null) {
//			selenium.extent.endTest(selenium.test);
//			selenium.extent.flush();
//			
//			File src = new File(WebConnector.REPORTS_PATH + ExtentManager.fileName);
//	        File dest = new File(WebConnector.REPORTS_PATH  + new_fileName);	             
//	        // using copy(InputStream,Path Target); method
//	        Files.copy(src.toPath(), dest.toPath());
//			selenium = WebConnector.getInstance();
//			System.out.println("*********** Extent report is generated successfully!!! *********** ");
//			
//			System.out.println("**************** The EXTENT REPORT is generated successfully!!! *****************");
//		}

//		if (selenium.test != null) {
//			selenium.extent.endTest(selenium.test);
//			selenium.extent.flush();
//			System.out.println("**************** The EXTENT REPORT is generated successfully!!! *****************");
//		}
//		selenium.close();
		selenium.quit();
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(new Thread()
		{
		public void run()
			{
			    System.out.println("shut down hook task completed..");
			    System.out.println("#####################################Inside run method... ");
				String new_fileName = "Report_T"+selenium.total_tc_count+"_F"+selenium.failed_tc_count+"_"+CommonUtil.tagNamesCombo+"_Group.html";
				File src1 = new File(WebConnector.REPORTS_PATH1  + "cucumber-extent-report.html");
				File dest1 = new File(WebConnector.REPORTS_PATH1  + new_fileName);
					try
					{
						Files.copy(src1.toPath(), dest1.toPath());
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
		    }
		});
		System.out.println("*********** Browser closed successfully *********** ");

	}

	@After("@logoutE2C_1")
	public void quitBrowser_1() throws IOException, InterruptedException {
		System.out.println("Inside quitBrowser method");
		selenium = WebConnector.getInstance();
		selenium.quit();
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(new Thread()
		{
		public void run()
			{
			    System.out.println("shut down hook task completed..");
			    System.out.println("#####################################Inside run method... ");
				String new_fileName = "Email2Case_T"+selenium.totalCases+"_F"+selenium.failedCases+"_"+CommonUtil.tagNamesCombo+".xlsx";
				File src1 = new File(WebConnector.REPORTS_PATH_E2C  + "Data_E2CJob1.xlsx");
				File dest1 = new File(WebConnector.REPORTS_PATH  + new_fileName);

					try
					{
						Files.copy(src1.toPath(), dest1.toPath());
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
		    }
		});
		System.out.println("*********** Browser closed successfully *********** ");
	}
	
	@After("@logoutE2C_2")
	public void quitBrowser_2() throws IOException, InterruptedException {
		System.out.println("Inside quitBrowser method");
		selenium = WebConnector.getInstance();
		selenium.quit();
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(new Thread()
		{
		public void run()
			{
			    System.out.println("shut down hook task completed..");
			    System.out.println("#####################################Inside run method... ");
				String new_fileName = "Email2Case_T"+selenium.totalCases+"_F"+selenium.failedCases+"_"+CommonUtil.tagNamesCombo+".xlsx";
				File src1 = new File(WebConnector.REPORTS_PATH_E2C  + "Data_E2CJob2.xlsx");
				File dest1 = new File(WebConnector.REPORTS_PATH  + new_fileName);

					try
					{
						Files.copy(src1.toPath(), dest1.toPath());
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
		    }
		});
		System.out.println("*********** Browser closed successfully *********** ");
	}
	
	@After("@logoutE2C_3")
	public void quitBrowser_3() throws IOException, InterruptedException {
		System.out.println("Inside quitBrowser method");
		selenium = WebConnector.getInstance();
		selenium.quit();
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(new Thread()
		{
		public void run()
			{
			    System.out.println("shut down hook task completed..");
			    System.out.println("#####################################Inside run method... ");
				String new_fileName = "Email2Case_T"+selenium.totalCases+"_F"+selenium.failedCases+"_"+CommonUtil.tagNamesCombo+".xlsx";
				File src1 = new File(WebConnector.REPORTS_PATH_E2C  + "Data_E2CJob3.xlsx");
				File dest1 = new File(WebConnector.REPORTS_PATH  + new_fileName);

					try
					{
						Files.copy(src1.toPath(), dest1.toPath());
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
		    }
		});
		System.out.println("*********** Browser closed successfully *********** ");
	}

	@After("@logoutE2C_4")
	public void quitBrowser_4() throws IOException, InterruptedException {
		System.out.println("Inside quitBrowser method");
		selenium = WebConnector.getInstance();
		selenium.quit();
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(new Thread()
		{
			public void run()
			{
				System.out.println("shut down hook task completed..");
				System.out.println("#####################################Inside run method... ");
				String new_fileName = "Email2Case_T"+selenium.totalCases+"_F"+selenium.failedCases+"_"+CommonUtil.tagNamesCombo+".xlsx";
				File src1 = new File(WebConnector.REPORTS_PATH_E2C  + "Data_E2CJob4.xlsx");
				File dest1 = new File(WebConnector.REPORTS_PATH  + new_fileName);

				try
				{
					Files.copy(src1.toPath(), dest1.toPath());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		});
		System.out.println("*********** Browser closed successfully *********** ");
	}

	@After("@logoutE2C_A3K")
	public void quitBrowser_A3K() throws IOException, InterruptedException {
		System.out.println("Inside quitBrowser method");
		selenium = WebConnector.getInstance();
		selenium.quit();
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(new Thread()
		{
			public void run()
			{
				System.out.println("shut down hook task completed..");
				System.out.println("#####################################Inside run method... ");
				String new_fileName = "Email2Case_T"+selenium.totalCases+"_F"+selenium.failedCases+"_"+CommonUtil.tagNamesCombo+".xlsx";
				File src1 = new File(WebConnector.REPORTS_PATH_E2C  + "Data_E2CA3K.xlsx");
				File dest1 = new File(WebConnector.REPORTS_PATH  + new_fileName);

				try
				{
					Files.copy(src1.toPath(), dest1.toPath());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		});
		System.out.println("*********** Browser closed successfully *********** ");
	}


	@Then("^I login as Admin User$")
	 public void I_login_as_Admin_User() {
		try {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("userIcon");
			selenium.clickNew("userIcon");
//			selenium.waitingTime(3000);
//			selenium.retryingWait("userName");
			selenium.waitForElementToBeVisible("userName");
			String user = selenium.getText("userName");
			System.out.println("Currently logged-in user is : " + user);
			System.out.println("Expected log-in user is : " + loggedInUser);
//			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
				System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
				selenium.click("LogOut");
				selenium.waitingTime(5000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(selenium.isElementPresentFast("menuDots"))
				{
					System.out.println("Successfully logged out from existing user!");
				}
				else if(selenium.isElementPresentFast("loginButton"))
				{
					System.out.println("Default user got logged-out. So doing default user login again!");
					selenium.doDefaultUATLogin();
				}
				else if(selenium.isElementPresentFast("goBackBtn"))
				{
					System.out.println("Page did not load properly. So doing default user login again!");
					selenium.click("goBackBtn");
					selenium.doDefaultUATLogin();
				}
				selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
			}
			
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			
			selenium.switchToFrame("newAccountFrame");
			String profileName= selenium.getText("profileName");
			String loggedInUserName=selenium.getText("loggedInUserName");
			selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
			selenium.click("loginSalesrep");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(5000);
			if(selenium.isElementPresentsuperFast("loginsessionbutton"))
			{
				selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//				selenium.captureScreenShot();
				selenium.click("loginsessionbutton");
				selenium.waitingTime(2000);
			}
			I_successfully_logout_from_application();
			selenium.waitingTime(3000);
			selenium.switchOutOfFrame();
	
			selenium.captureScreenShot();

			selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
			selenium.check_Switch_UserInterface();
			
		} catch (Exception e) {	
		selenium.test.log(LogStatus.INFO, "error while loggin in");	
		selenium.check_Switch_UserInterface();
		i_logout_of_any_user();
		selenium.reportFailure("Error while logging in " + e.getMessage());

	}
}
	
	@Then("^I login as CSOM User$")
    public void i_login_as_CSOM_user() {
		try {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("userIcon");
			selenium.clickNew("userIcon");
			selenium.waitForElementToBeVisible("userName");
			String user = selenium.getText("userName");
			System.out.println("Currently logged-in user is : " + user);
			System.out.println("Expected log-in user is : " + loggedInUser);
//			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
				System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
				selenium.click("LogOut");
				selenium.waitingTime(5000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(selenium.isElementPresentFast("menuDots"))
				{
					System.out.println("Successfully logged out from existing user!");
				}
				else if(selenium.isElementPresentFast("loginButton"))
				{
					System.out.println("Default user got logged-out. So doing default user login again!");
					selenium.doDefaultUATLogin();
				}
				else if(selenium.isElementPresentFast("goBackBtn"))
				{
					System.out.println("Page did not load properly. So doing default user login again!");
					selenium.click("goBackBtn");
					selenium.doDefaultUATLogin();
				}
				selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
			}
			
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			
			selenium.switchToFrame("newAccountFrame");
			String profileName= selenium.getText("profileName");
			String loggedInUserName=selenium.getText("loggedInUserName");
			selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
			selenium.click("loginSalesrep");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentsuperFast("loginsessionbutton"))
			{
				selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//				selenium.captureScreenShot();
				selenium.click("loginsessionbutton");
				selenium.waitingTime(2000);
			}
			I_successfully_logout_from_application();
			selenium.waitingTime(3000);
			selenium.switchOutOfFrame();
			
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
			selenium.check_Switch_UserInterface();
			
		} catch (Exception e) {	
		selenium.test.log(LogStatus.INFO, "error while loggin in");	
		//I_successfully_logout_from_application();
		//selenium.waitingTime(4000);
		selenium.check_Switch_UserInterface();
		i_logout_of_any_user();
		selenium.reportFailure("Error while logging in " + e.getMessage());

	}
}
	@Then("^I login as CXG User$")
    public void i_login_as_CXG_user() {
		try {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("userIcon");
			selenium.clickNew("userIcon");
//			selenium.waitingTime(3000);
//			selenium.retryingWait("userName");
			selenium.waitForElementToBeVisible("userName");
			String user = selenium.getText("userName");
			System.out.println("Currently logged-in user is : " + user);
			System.out.println("Expected log-in user is : " + loggedInUser);
//			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
				System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
				selenium.click("LogOut");
				selenium.waitingTime(5000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(selenium.isElementPresentFast("menuDots"))
				{
					System.out.println("Successfully logged out from existing user!");
				}
				else if(selenium.isElementPresentFast("loginButton"))
				{
					System.out.println("Default user got logged-out. So doing default user login again!");
					selenium.doDefaultUATLogin();
				}
				else if(selenium.isElementPresentFast("goBackBtn"))
				{
					System.out.println("Page did not load properly. So doing default user login again!");
					selenium.click("goBackBtn");
					selenium.doDefaultUATLogin();
				}
				selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
			}
			
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			
			selenium.switchToFrame("newAccountFrame");
			String profileName= selenium.getText("profileName");
			String loggedInUserName=selenium.getText("loggedInUserName");
			selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
			selenium.click("loginSalesrep");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentsuperFast("loginsessionbutton"))
			{
				selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//				selenium.captureScreenShot();
				selenium.click("loginsessionbutton");
				selenium.waitingTime(2000);
			}
			I_successfully_logout_from_application();
			selenium.waitingTime(3000);
			selenium.switchOutOfFrame();
			
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
			selenium.check_Switch_UserInterface();
			
		} catch (Exception e) {	
		selenium.test.log(LogStatus.INFO, "error while loggin in");	
		//I_successfully_logout_from_application();
		//selenium.waitingTime(4000);
		selenium.check_Switch_UserInterface();
		i_logout_of_any_user();
		selenium.reportFailure("Error while logging in " + e.getMessage());

	}
}
	
	@Then("^I login as Marketing Sales Rep$")
    public void i_login_as_Marketing_Sales_Rep() {
		try {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("userIcon");
			selenium.clickNew("userIcon");
//			selenium.waitingTime(3000);
//			selenium.retryingWait("userName");
			selenium.waitForElementToBeVisible("userName");
			String user = selenium.getText("userName");
			System.out.println("Currently logged-in user is : " + user);
			System.out.println("Expected log-in user is : " + loggedInUser);
//			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
				System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
				selenium.click("LogOut");
				selenium.waitingTime(5000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(selenium.isElementPresentFast("menuDots"))
				{
					System.out.println("Successfully logged out from existing user!");
				}
				else if(selenium.isElementPresentFast("loginButton"))
				{
					System.out.println("Default user got logged-out. So doing default user login again!");
					selenium.doDefaultUATLogin();
				}
				else if(selenium.isElementPresentFast("goBackBtn"))
				{
					System.out.println("Page did not load properly. So doing default user login again!");
					selenium.click("goBackBtn");
					selenium.doDefaultUATLogin();
				}
				selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
			}
			
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			
			selenium.switchToFrame("newAccountFrame");
			String profileName= selenium.getText("profileName");
			String loggedInUserName=selenium.getText("loggedInUserName");
			selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
			selenium.click("loginSalesrep");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentsuperFast("loginsessionbutton"))
			{
				selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//				selenium.captureScreenShot();
				selenium.click("loginsessionbutton");
				selenium.waitingTime(2000);
			}
			I_successfully_logout_from_application();
			selenium.waitingTime(3000);
			selenium.switchOutOfFrame();
			
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
			selenium.check_Switch_UserInterface();
			
		} catch (Exception e) {	
		selenium.test.log(LogStatus.INFO, "error while loggin in");	
		//I_successfully_logout_from_application();
		//selenium.waitingTime(4000);
		selenium.check_Switch_UserInterface();
		i_logout_of_any_user();
		selenium.reportFailure("Error while logging in " + e.getMessage());

	}
}
	

	
	@When("^I navigate to Campaigns tab$")
	public void I_navigate_to_Leads_tab()  {
		try {
		
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeVisible("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Campaign");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("campaignOptionMenuDots");
		selenium.jsClick("campaignOptionMenuDots");
		selenium.waitingTime(5000);
		}
		 catch (Exception e) {
				
				selenium.reportFailure("Error while navigating to Campaign tab " + e.getMessage());
			}

	}
	 

	@Then("^I logout of any user$")
	public void i_logout_of_any_user() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.checkFlowInterruptedPopup();
			selenium.logoutFromAnyUser();
			selenium.waitingTime(5000);
			  if(selenium.isAlertPresent())  {
				  System.out.println("Alert present..");
				  selenium.acceptAlertPopup();
			  }
			selenium.test.log(LogStatus.PASS, "Logout of specific user successful!");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("loginPassword"))
			{
				System.out.println("Main login page appeared so doing login again");
				selenium.doDefaultUATLogin();
			}
			
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/page/home");
			selenium.waitingTime(10000);
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	@Then("^I logout of any classic user$")
	public void i_logout_of_any_classic_user() {
		try {
			System.out.println("Inside Classic user logout method..");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.logoutFromAnyUserClassic();
			selenium.test.log(LogStatus.PASS, "Logout of specific user successful!");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("loginPassword"))
			{
				System.out.println("Main login page appeared so doing login again");
				selenium.doDefaultUATLogin();
			}
			
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/page/home");
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	/*
	 * @author Sayan Halder start -----
	 */
	@Then("^I log out from salesforce application \"([^\"]*)\"$")
	public void I_log_out_from_salesforce(String testCaseName) throws Exception {
		if (selenium.driver != null) {
			selenium.setTestCaseName(testCaseName);
			selenium.defaultframe();
			selenium.waitingTime(3500);
			selenium.setTestCaseName(testCaseName);
			selenium.click("logOutIcon");
			selenium.click("LogOut");
			selenium.waitingTime(1500);
		}
	}
	
	
	public void quitBrowserNFlushReport() {
	//	selenium = WebConnector.getInstance();
	//	selenium.quit(); 
		if (selenium.test != null) {
			selenium.extent.endTest(selenium.test);
			selenium.extent.flush();
		}
	}
	
	@Then("^I login as System Admin$")
	public void loginAsSysAdmin() throws Exception {
		selenium.waitForElementToBeClickable("searchFromHome");
		selenium.type("searchFromHome", "SysAdminName");
//		selenium.waiting(2.5);
	//	selenium.pressEnterKeyUsingActionBuilder(1);
		selenium.waitForElementToBeVisible("userProfileFromSearch");
		selenium.click("userProfileFromSearch");
	/*	String sysAdminProfileXpath = selenium.OR.getProperty("sysAdminProfileXpath").
				replace("<placeholder>", selenium.getExcelValue(selenium.getTestCaseName()).
						get(0).get("SysAdminName"));  */
//		selenium.waiting(8);
	//	selenium.waitForXpathElementToBeClickable(sysAdminProfileXpath);
	//	selenium.clickDynamicOpportunity("anchorText", "SysAdminName", "adminAccountXpathEnd");
	//	selenium.clickLoopXpath(sysAdminProfileXpath);
	//	selenium.clickXpath(sysAdminProfileXpath);
	//	selenium.waiting(5);
		selenium.waitForElementToBeVisible("userDetail");
		selenium.click("userDetail");
	//	selenium.switchToFrame(objectRepoElement);
		selenium.waiting(10);
		selenium.switchiFrame();
		selenium.click("adminLoginBtn");
		selenium.waiting(5);
	}
	
	@Then("^I navigate to MHES Lightning Console$")
	public void navigateToMHESLightningConsole() throws Exception {
//		selenium.waiting(4);
		selenium.waitForElementToBeVisible("navigationBtn");
		selenium.click("navigationBtn");
//		selenium.waiting(3.5);
		selenium.waitForElementToBeVisible("viewAllNavigationBtn");
		selenium.click("viewAllNavigationBtn");
		selenium.waitForElementToBeClickable("navigationSearch");
		selenium.type("navigationSearch", "MHESLightningConsole");
		selenium.click("mhesLightningConsole");
		selenium.waiting(10);
	}
	
	/*
	 * @author Sayan Halder end-----
	 */
	
	@When("^Navigate to Accounts page$")
	public void navigate_to_accounts_screen() {
		selenium.waitingTime(4000);
		selenium.waitForElementToBeVisible("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		if(selenium.isElementPresentFast("AllButtonL"))
		{
			selenium.click("AllButtonL");
			selenium.waitingTime(4000);
		}
		selenium.type("searchallitems", "Screen");
		selenium.waitingTime(2000);
		selenium.click("accountsOption");
		selenium.waitingTime(8000);
		selenium.test.log(LogStatus.INFO, "Accounts page loaded successfully!");
	}
	
	@When("^Navigate to Contacts page$")
	public void navigate_to_contacts_screen() {
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "Screen");
		selenium.waitingTime(2000);
		selenium.click("contactsOption");
		selenium.waitingTime(4000);
		selenium.test.log(LogStatus.INFO, "Contacts page loaded successfully!");
	}
	
	@When("^Navigate to \"([^\"]*)\" Screen page$")
	public void navigate_to_contacts_screen_page(String contacts) {
		
		selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/page/home");
		selenium.waitingTime(6000);
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.jsClick("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.jsClick("AllButtonL");
		selenium.waitingTime(4000);
		selenium.typeData("searchallitems", contacts);
		selenium.waitingTime(2000);
		selenium.click("contactsOption");
		selenium.waitingTime(8000);
		selenium.test.log(LogStatus.INFO, "Contacts page loaded successfully!");
	}
	
	@When("^Navigate to Tasks page$")
	public void navigate_tasks_page() throws InterruptedException {
		
	    selenium.waitingTime(5000);
	    selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("searchItemsTextField");
		selenium.type("searchItemsTextField", "Screen");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("tasksView");
		selenium.jsClick("tasksView");
		selenium.waitingTime(3000);		
	}

	@And("^I select required search criteria for global search dropdown$")
	public void select_globalSearch_dropdown() {

		selenium.waitingTime(8000);
		try {

			selenium.waitForElementToBeClickable("searchTextL");
			selenium.click("searchTextL");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("campaignFromDrpDwn1");
			selenium.click("campaignFromDrpDwn1");
			selenium.waitingTime(4000);
			String nameXpath = selenium.getDynamicXpath("spanTitle", "Search Dropdown", "end");
			System.out.println(nameXpath);
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeVisible(nameXpath);
			selenium.scrollToXpathElement(nameXpath);
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeClickable(nameXpath);
			selenium.clickXpath(nameXpath);
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
		}
	}


	@And("^I Click edit User$")
	public void i_Click_edit_User() {

		try {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("userIcon");
			selenium.clickNew("userIcon");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("userName");
			String user = selenium.getText("userName");
			if (!user.equalsIgnoreCase(loggedInUser)) {
				selenium.waitForElementToBeClickable("LogOut");
				selenium.click("LogOut");
				selenium.waitingTime(5000);
				selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
			}

			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
			selenium.navigateToURL(url);
			selenium.waitingTime(10000);

			selenium.switchToFrame("newAccountFrame");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("edit");
			selenium.click("edit");
			selenium.waitingTime(5000);
//			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Clicked in Edit User");
		} catch(Exception e){

			selenium.reportFailure(e.getMessage());

		}

	}
	
	@Then("^I navigate to URL$") 
	  public void I_navigate_to_URL()
	  {
	String	URL=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Data Url");
		  selenium.navigateToURL(URL);
		  selenium.waitingTime(4000);
	  }
	
	@And ("^I login as ALEKS user$")
    public void I_login_as_ALEKS_user() throws Exception {
    	try {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("userIcon");
			selenium.clickNew("userIcon");
			selenium.waitForElementToBeVisible("userName");
			String user = selenium.getText("userName");
			System.out.println("Currently logged-in user is : " + user);
			System.out.println("Expected log-in user is : " + loggedInUser);
//			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
				System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
				selenium.click("LogOut");
				selenium.waitingTime(5000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(selenium.isElementPresentFast("menuDots"))
				{
					System.out.println("Successfully logged out from existing user!");
				}
				else if(selenium.isElementPresentFast("loginButton"))
				{
					System.out.println("Default user got logged-out. So doing default user login again!");
					selenium.doDefaultUATLogin();
				}
				else if(selenium.isElementPresentFast("goBackBtn"))
				{
					System.out.println("Page did not load properly. So doing default user login again!");
					selenium.click("goBackBtn");
					selenium.doDefaultUATLogin();
				}
				selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
			}
			
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ALEKS User");
			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			
			selenium.switchToFrame("newAccountFrame");
			String profileName= selenium.getText("profileName");
			String loggedInUserName=selenium.getText("loggedInUserName");
			selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
			selenium.click("loginSalesrep");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentsuperFast("loginsessionbutton"))
			{
				selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//				selenium.captureScreenShot();
				selenium.click("loginsessionbutton");
				selenium.waitingTime(2000);
			}
			I_successfully_logout_from_application();
			selenium.waitingTime(3000);
			selenium.switchOutOfFrame();
			
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
			selenium.check_Switch_UserInterface();
			
		} catch (Exception e) {	
		selenium.test.log(LogStatus.INFO, "error while loggin in");	
		//I_successfully_logout_from_application();
		//selenium.waitingTime(4000);
		selenium.check_Switch_UserInterface();
		i_logout_of_any_user();
		selenium.reportFailure("Error while logging in " + e.getMessage());

	}
    	
    	
    }
	
	@Then("^I login as MHHE_Career_Sales_Manager$")
	 public void i_login_as_MHHE_Career_Sales_Manager() {
			try {
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitingTime(6000);
//				selenium.retryingWait("userName");
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.click("LogOut");
					selenium.waitingTime(3000);
//					selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("menuDots"))
					{
						System.out.println("Successfully logged out from existing user!");
					}
					else if(selenium.isElementPresentFast("loginButton"))
					{
						System.out.println("Default user got logged-out. So doing default user login again!");
						selenium.doDefaultUATLogin();
//						System.out.println("Back to loginButton block");
//						selenium.captureScreenShot();
					}
					else if(selenium.isElementPresentFast("goBackBtn"))
					{
						System.out.println("Page did not load properly. So doing default user login again!");
						selenium.click("goBackBtn");
						selenium.doDefaultUATLogin();
//						System.out.println("Back to goBackBtn block");
					}
					selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
//			        if (selenium.isElementPresentFast("loginPopUp"))
//			        {
//			        	selenium.click("loginPopUp");
//			        }
				}
				selenium.waitingTime(3000);
				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MHHE_Career_Sales_Manager");
				selenium.navigateToURL(url);
				selenium.waitingTime(8000);
				
				selenium.switchToFrame("newAccountFrame");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//					selenium.captureScreenShot();
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}
				I_successfully_logout_from_application();
				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);				
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
				selenium.check_Switch_UserInterface();

//				System.out.println("Checking sales-rep login successful or not?");
//				selenium.waitingTime(2000);
//				if(!selenium.isElementPresentFast("logoutAnyUserDynamic"))
//				{
//					System.out.println("Sales-rep login failed. Retrying login again..");
//					i_login_as_sales_rep();
//				}
//				else
//				{
//					System.out.println("Sales-rep login successful!");
//				}

			} catch (Exception e) {	
			selenium.test.log(LogStatus.INFO, "error while loggin in");	
			//I_successfully_logout_from_application();
			//selenium.waitingTime(4000);
			selenium.check_Switch_UserInterface();
			i_logout_of_any_user();
			selenium.reportFailure("Error while logging in " + e.getMessage());

		}
	}


	@Then("^I login as MHHE_Business Administrator$")
	 public void i_login_as_MHHE_Business_Administrator() {
			try {
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitingTime(6000);
//				selenium.retryingWait("userName");
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.click("LogOut");
					selenium.waitingTime(3000);
//					selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("menuDots"))
					{
						System.out.println("Successfully logged out from existing user!");
					}
					else if(selenium.isElementPresentFast("loginButton"))
					{
						System.out.println("Default user got logged-out. So doing default user login again!");
						selenium.doDefaultUATLogin();
//						System.out.println("Back to loginButton block");
//						selenium.captureScreenShot();
					}
					else if(selenium.isElementPresentFast("goBackBtn"))
					{
						System.out.println("Page did not load properly. So doing default user login again!");
						selenium.click("goBackBtn");
						selenium.doDefaultUATLogin();
//						System.out.println("Back to goBackBtn block");
					}
					selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
//			        if (selenium.isElementPresentFast("loginPopUp"))
//			        {
//			        	selenium.click("loginPopUp");
//			        }
				}
				selenium.waitingTime(3000);
				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MHHE_Business Administrator");
				selenium.navigateToURL(url);
				selenium.waitingTime(8000);
				
				selenium.switchToFrame("newAccountFrame");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//					selenium.captureScreenShot();
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}
				I_successfully_logout_from_application();
				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);				
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
				selenium.check_Switch_UserInterface();


			} catch (Exception e) {	
			selenium.test.log(LogStatus.INFO, "error while loggin in");	
			//I_successfully_logout_from_application();
			//selenium.waitingTime(4000);
			selenium.check_Switch_UserInterface();
			i_logout_of_any_user();
			selenium.reportFailure("Error while logging in " + e.getMessage());

		}
	}

	
	@Then("^I login as MHHE_Enterprise$")
	 public void i_login_as_MHHE_Enterprise() {
			try {
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitingTime(6000);
//				selenium.retryingWait("userName");
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.click("LogOut");
					selenium.waitingTime(3000);
//					selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("menuDots"))
					{
						System.out.println("Successfully logged out from existing user!");
					}
					else if(selenium.isElementPresentFast("loginButton"))
					{
						System.out.println("Default user got logged-out. So doing default user login again!");
						selenium.doDefaultUATLogin();
//						System.out.println("Back to loginButton block");
//						selenium.captureScreenShot();
					}
					else if(selenium.isElementPresentFast("goBackBtn"))
					{
						System.out.println("Page did not load properly. So doing default user login again!");
						selenium.click("goBackBtn");
						selenium.doDefaultUATLogin();
//						System.out.println("Back to goBackBtn block");
					}
					selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
//			        if (selenium.isElementPresentFast("loginPopUp"))
//			        {
//			        	selenium.click("loginPopUp");
//			        }
				}
				selenium.waitingTime(3000);
				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MHHE_Enterprise");
				selenium.navigateToURL(url);
				selenium.waitingTime(8000);
				
				selenium.switchToFrame("newAccountFrame");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//					selenium.captureScreenShot();
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}
				I_successfully_logout_from_application();
				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);				
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
				selenium.check_Switch_UserInterface();


			} catch (Exception e) {	
			selenium.test.log(LogStatus.INFO, "error while loggin in");	
			//I_successfully_logout_from_application();
			//selenium.waitingTime(4000);
			selenium.check_Switch_UserInterface();
			i_logout_of_any_user();
			selenium.reportFailure("Error while logging in " + e.getMessage());

		}
	}
	
	
	@Then("^I login as MHHE_National_Sales_Manager$")
	 public void i_login_as_MHHE_National_Sales_Manager() {
			try {
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitingTime(6000);
//				selenium.retryingWait("userName");
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.click("LogOut");
					selenium.waitingTime(3000);
//					selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("menuDots"))
					{
						System.out.println("Successfully logged out from existing user!");
					}
					else if(selenium.isElementPresentFast("loginButton"))
					{
						System.out.println("Default user got logged-out. So doing default user login again!");
						selenium.doDefaultUATLogin();
//						System.out.println("Back to loginButton block");
//						selenium.captureScreenShot();
					}
					else if(selenium.isElementPresentFast("goBackBtn"))
					{
						System.out.println("Page did not load properly. So doing default user login again!");
						selenium.click("goBackBtn");
						selenium.doDefaultUATLogin();
//						System.out.println("Back to goBackBtn block");
					}
					selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
//			        if (selenium.isElementPresentFast("loginPopUp"))
//			        {
//			        	selenium.click("loginPopUp");
//			        }
				}
				selenium.waitingTime(3000);
				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MHHE_National_Sales_Manager");
				selenium.navigateToURL(url);
				selenium.waitingTime(8000);
				
				selenium.switchToFrame("newAccountFrame");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//					selenium.captureScreenShot();
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}
				I_successfully_logout_from_application();
				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);				
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
				selenium.check_Switch_UserInterface();


			} catch (Exception e) {	
			selenium.test.log(LogStatus.INFO, "error while loggin in");	
			//I_successfully_logout_from_application();
			//selenium.waitingTime(4000);
			selenium.check_Switch_UserInterface();
			i_logout_of_any_user();
			selenium.reportFailure("Error while logging in " + e.getMessage());

		}
	}
	
	
	@Then("^global search for accounts$")
	public void global_search_for_accounts()
	{
		try
		{
			selenium.search("Search Data");
			String Xpath = selenium.getDynamicXpath("accountStartContains1", "Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("AccountsTopResult"))
			{
				selenium.click("AccountsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("AccountsTopResult");
				selenium.click("AccountsTopResult");
			}
//			selenium.click("AccountsTopResult");
			selenium.waitingTime(4000);
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired account");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Account navigation failed");
			selenium.reportFailure("Error while navigation to the account" + e.getMessage());
		}
	}

	@Then("^global search for quote$")
	public void global_search_for_quote()
	{
		try
		{
			selenium.search("Search Data1");
			String Xpath = selenium.getDynamicXpath("quoteStartContains1", "Search Data2", "endContains");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("QuotesTopResult"))
			{
				selenium.click("QuotesTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("QuotesTopResult");
				selenium.click("QuotesTopResult");
			}
			System.out.println(Xpath);
			selenium.clickXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired quote");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Quote navigation failed");
			selenium.reportFailure("Error while navigation to the quote" + e.getMessage());
		}
	}

	@Then("^global search for product$")
	public void global_search_for_product()
	{
		try
		{
			selenium.search("Search Data");
			String Xpath = selenium.getDynamicXpath("productStartContains1", "Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("ProductsTopResult"))
			{
				selenium.click("ProductsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("ProductsTopResult");
				selenium.clickLoop("ProductsTopResult");
			}
//			selenium.click("ProductsTopResult");
			selenium.waitingTime(4000);
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired product");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Product navigation failed");
			selenium.reportFailure("Error while navigation to the product" + e.getMessage());
		}
	}

	@Then("^global search for products$")
	public void global_search_for_products()
	{
		try
		{
			selenium.search("Product Search Data");
			selenium.waitingTime(5000);
			String Xpath = selenium.getDynamicXpath("productStartContains1", "Product Search Data", "endContains");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("ProductsTopResult"))
			{
				selenium.click("ProductsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("ProductsTopResult");
				selenium.clickLoop("ProductsTopResult");
			}
//			selenium.click("ProductsTopResult");
			selenium.waitingTime(4000);
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired product");
			System.out.println("Navigated to the desired product");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Product navigation failed");
			selenium.reportFailure("Error while navigation to the product" + e.getMessage());
		}
	}

	@Then("^global search for campaign$")
	public void global_search_for_campaign()
	{
		try
		{
			selenium.waitingTime(5000);
			selenium.search("Search Data");
			String Xpath = selenium.getDynamicXpath("campaignStartContains1", "Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("CampaignsTopResult"))
			{
				selenium.click("CampaignsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("CampaignsTopResult");
				selenium.click("CampaignsTopResult");
			}
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired campaign");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Campaign navigation failed");
			selenium.reportFailure("Error while navigation to the campaign" + e.getMessage());
		}
	}

	@Then("^global search for MHECourse$")
	public void global_search_for_MHECourse()
	{
		try
		{
			selenium.search("Search Data");
//			String Xpath = selenium.getDynamicXpath("MHECourseStartContains", "Search Data", "endContains");
			String Xpath = selenium.getDynamicXpath("MHECourseStartContains", "Search Data", "endContains");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("TopResultShowMoreLink"))
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("MHECourseTopResult");
				selenium.click("MHECourseTopResult");
			}
			else
			{
				selenium.waitForElementToBeClickable("MHECourseTopResult");
				selenium.click("MHECourseTopResult");
			}
//			selenium.click("MHECourseTopResult");
			selenium.waitingTime(4000);
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired MHECourse");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "MHECourse navigation failed");
			selenium.reportFailure("Error while navigation to the MHECourse" + e.getMessage());
		}
	}

	@Then("^global search for event$")
	public void global_search_for_event()
	{
		try
		{
			selenium.search("Search Data");
			String Xpath = selenium.getDynamicXpath("eventStartContains1", "Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("EventsTopResult"))
			{
				selenium.click("EventsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("EventsTopResult");
				selenium.click("EventsTopResult");
			}
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired account");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Event navigation failed");
			selenium.reportFailure("Error while navigation to the event" + e.getMessage());
		}
	}

//	@Then("^global search for lead$")
//	public void global_search_for_lead()
//	{
//		try
//		{
//			selenium.search("Search Data");
//			String Xpath = selenium.getDynamicXpath("leadStartContains1", "Search Data", "endContains2");
//			selenium.waitingTime(2000);
//			if(selenium.isElementPresentFast("LeadsTopResult"))
//			{
//				selenium.click("LeadsTopResult");
//			}
//			else
//			{
//				selenium.click("TopResultShowMoreLink");
//				selenium.waitForElementToBeClickable("LeadsTopResult");
//				selenium.click("LeadsTopResult");
//			}
//			System.out.println(Xpath);
//			selenium.clickLoopXpath(Xpath);
//			selenium.waitingTime(8000);
//			selenium.test.log(LogStatus.INFO, "Navigated to the desired lead");
//		}
//		catch (Exception e)
//		{
//			selenium.test.log(LogStatus.FAIL, "Lead navigation failed");
//			selenium.reportFailure("Error while navigation to the lead" + e.getMessage());
//		}
//	}

	@Then("^global search for task$")
	public void global_search_for_task()
	{
		try
		{
			selenium.search("Search Data");
			String Xpath = selenium.getDynamicXpath("taskStartContains", "Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("TasksTopResult"))
			{
				selenium.click("TasksTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("TasksTopResult");
				selenium.click("TasksTopResult");
			}
//			selenium.click("TasksTopResult");
			selenium.waitingTime(4000);
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired task");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Task navigation failed");
			selenium.reportFailure("Error while navigation to the task" + e.getMessage());
		}
	}

	@Then("^global search for sample$")
	public void global_search_for_sample()
	{
		try
		{
			selenium.search("Search Data");
			String Xpath = selenium.getDynamicXpath("sampleStartContains1", "Search Data", "endContains");//endContains1
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("SamplesTopResult"))
			{
				selenium.clickLoop("SamplesTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("SamplesTopResult");
				selenium.clickLoop("SamplesTopResult");
			}
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired sample");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Sample navigation failed");
			selenium.reportFailure("Error while navigation to the sample" + e.getMessage());
		}
	}

	@Then("^global search for contact$")
	public void global_search_for_contact()
	{
		try
		{
			try {
		        if (selenium.isElementPresentFast("loginPopUp"))
		        {
		        	System.out.println("I am inside loginPopup method");
		        	selenium.clickLoop("loginPopUp");
		        	selenium.waitingTime(2000);	
		        }
			}
			catch(Exception e)
			{
				System.out.println("Do nothing..");
			}
			selenium.search("Search Data");
			String Xpath = selenium.getDynamicXpath("contactStartContains1", "Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("ContactsTopResult"))
			{
				selenium.click("ContactsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("ContactsTopResult");
				selenium.click("ContactsTopResult");
			}
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired contact");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Contact navigation failed");
			selenium.reportFailure("Error while navigation to the contact" + e.getMessage());
		}
	}
	
	@Then("^global search for contact record$")
	public void global_search_for_contact_record()
	{
		try
		{
			selenium.search("Contact Search Data");
			String Xpath = selenium.getDynamicXpath("contactStartContains1", "Contact Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("ContactsTopResult"))
			{
				selenium.click("ContactsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("ContactsTopResult");
				selenium.click("ContactsTopResult");
			}
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired contact");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Contact navigation failed");
			selenium.reportFailure("Error while navigation to the contact" + e.getMessage());
		}
	}

	@Then("^global search for opportunities$")
	public void global_search_for_opportunities()
	{
		try
		{
			selenium.search("Opp. Search Data");
			String Xpath = selenium.getDynamicXpath("opportunityStartContains1", "Opp. Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("OppsTopResult"))
			{
				selenium.click("OppsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("OppsTopResult");
				selenium.click("OppsTopResult");
			}
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired opportunity");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Opportunity navigation failed");
			selenium.reportFailure("Error while navigation to the opportunity" + e.getMessage());
		}
	}
	
	@Then("^global search for chat$")
	public void global_search_for_chat()
	{
		try
		{
			 selenium.search("Transcript Number");
				String Xpath = selenium.getDynamicXpath("anchorTitle", "Transcript Number", "end");
				selenium.waitingTime(2000);
				if(selenium.isElementPresentFast("ChatTopResult"))
				{
					selenium.click("ChatTopResult");
				}
				else
				{
					selenium.click("TopResultShowMoreLink");
					selenium.waitForElementToBeClickable("ChatTopResult");
					selenium.click("ChatTopResult");
				}
				System.out.println(Xpath);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(8000);
				selenium.test.log(LogStatus.INFO, "Navigated to the desired chat");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Chat navigation failed");
			selenium.reportFailure("Error while navigation to the chat" + e.getMessage());
		}
	}

	@Then("^global search for consultant$")
	public void global_search_for_consultant()
	{
		try
		{
			selenium.search("Consultant Search Data");
			String Xpath = selenium.getDynamicXpath("consultantStartContains", "Consultant Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("ConsultantsTopResult"))
			{
				selenium.click("ConsultantsTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("ConsultantsTopResult");
				selenium.click("ConsultantsTopResult");
			}
//			selenium.click("ConsultantsTopResult");
			selenium.waitingTime(4000);
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired consultant");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Consultant navigation failed");
			selenium.reportFailure("Error while navigation to the consultant" + e.getMessage());
		}
	}

	@Then("^global search for addresses$")
	public void global_search_for_addresses()
	{
		try
		{
			selenium.search("Address Search Data");
			String Xpath = selenium.getDynamicXpath("addressStartContains1", "Address Search Data", "endContains");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("AddressesTopResult"))
			{
				selenium.click("AddressesTopResult");
			}
			else
			{
				selenium.click("TopResultShowMoreLink");
				selenium.waitForElementToBeClickable("AddressesTopResult");
				selenium.click("AddressesTopResult");
			}
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired address");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Contact navigation failed");
			selenium.reportFailure("Error while navigation to the contact" + e.getMessage());
		}
	}

	@Then("^global search for cases for \"([^\"]*)\"$")
	public void global_search_for_cases_for_given_request(String request)
	{
		try
		{
			selenium.switchBackToParentWindow();
			selenium.refresh();
			System.out.println("String is: "+request);
			selenium.waitingTime(2000);
			selenium.search_data(request);
			String Xpath = selenium.getDynamicXpath_data("casesStartContains1", request, "endContains");
			System.out.println("xpath is:" +Xpath);
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
			if(selenium.isElementPresentFast("CaseTopResult"))
			{
				System.out.println("Inside IF Block");
				selenium.click("CaseTopResult");				
			}
			else
			{
				System.out.println("Inside ELSE Block");
				selenium.click("TopResultShowMoreLink");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("CaseTopResult");
				selenium.click("CaseTopResult");
			}
			selenium.waitingTime(6000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("dateOrTimecaseOpened");
			selenium.jsClick("dateOrTimecaseOpened");
			System.out.println("Clicked sort by time");
			selenium.waitingTime(6000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppOrderFirstRecord");//selectCase
			selenium.jsClick("OppOrderFirstRecord");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Navigated to the desired Case");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Case navigation failed");
			selenium.reportFailure("Error while navigation to the case" + e.getMessage());
		}
	}
	

	
	@Then("^remove employee number of \"([^\"]*)\" user and do login$")
	 public void remove_employee_number_and_login(String url) {
			try {
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.click("LogOut");
					selenium.waitingTime(3000);
					if(selenium.isElementPresentFast("menuDots"))
					{
						System.out.println("Successfully logged out from existing user!");
					}
					else if(selenium.isElementPresentFast("loginButton"))
					{
						System.out.println("Default user got logged-out. So doing default user login again!");
						selenium.doDefaultUATLogin();
					}
					else if(selenium.isElementPresentFast("goBackBtn"))
					{
						System.out.println("Page did not load properly. So doing default user login again!");
						selenium.click("goBackBtn");
						selenium.doDefaultUATLogin();
					}
					selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
				}
				selenium.waitingTime(3000);
				//String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
				selenium.navigateToURL(url);
				selenium.waitingTime(8000);
				
				selenium.switchToFrame("newAccountFrame");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
				selenium.waitingTime(2000);

				/*REMOVING EMP NUMBER (REP CODE) IF IT IS PRESENT FOR THE USER - CODE BLOCK STARTED*/
				selenium.waitForElementToBeClickable("UserDetailsEditBtn");
				selenium.click("UserDetailsEditBtn");
				selenium.waitingTime(6000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(2000);
				selenium.scrolldown(200);
				selenium.waitForElementToBeClickable("EmpNumberEditField");
				selenium.click("EmpNumberEditField");
				selenium.clearText("EmpNumberEditField");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("UserDetailsSaveBtn");
				selenium.click("UserDetailsSaveBtn");
				selenium.waitingTime(10000);
				selenium.test.log(LogStatus.INFO, "Removed Emp Number!");
				selenium.switchToFrame("newAccountFrame");
				/*EMP NUMBER REMOVED - CODE BLOCK ENDED*/

				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}
				I_successfully_logout_from_application();
				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);				
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
				selenium.check_Switch_UserInterface();


			} catch (Exception e) {	
			selenium.test.log(LogStatus.INFO, "error while loggin in or while removing emp number");
			selenium.check_Switch_UserInterface();
			i_logout_of_any_user();
			selenium.reportFailure("Error while logging in " + e.getMessage());
		}
	}

	@Then("^add employee number of \"([^\"]*)\" user as \"([^\"]*)\" and do login$")
	 public void add_employee_number_and_login(String url, String empno) {
			try {
				selenium.waitingTime(3000);
				//String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales Rep");
				selenium.navigateToURL(url);
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitingTime(4000);

				/*ADDING OF EMP NUMBER (REP CODE) - CODE BLOCK STARTED*/
				selenium.waitForElementToBeClickable("UserDetailsEditBtn");
				selenium.click("UserDetailsEditBtn");
				selenium.waitingTime(6000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(2000);
				selenium.scrolldown(200);
				selenium.waitForElementToBeClickable("EmpNumberEditField");
				selenium.click("EmpNumberEditField");
				selenium.typeData("EmpNumberEditField", empno);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("UserDetailsSaveBtn");
				selenium.click("UserDetailsSaveBtn");
				selenium.waitingTime(10000);
				selenium.test.log(LogStatus.INFO, "Added Emp Number!");
				selenium.switchToFrame("newAccountFrame");
				/*EMP NUMBER ADDED - CODE BLOCK ENDED*/

				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(8000);
			} catch (Exception e) {	
				selenium.reportFailure("Error while adding back emp number " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Error while adding back emp number");
		}
	}
	
	@Then("^I do login as classic \"([^\"]*)\"$")
	 public void i_do_login_as_classic_user_url(String url) {
			try {
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("userIcon");
				selenium.clickNew("userIcon");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("userName");
				String user = selenium.getText("userName");
				System.out.println("Currently logged-in user is : " + user);
				System.out.println("Expected log-in user is : " + loggedInUser);
				if(!user.equalsIgnoreCase(loggedInUser) || user.isEmpty()) {
					System.out.println("Logged-in user is not " + loggedInUser + " So clicking logout");
					selenium.waitForElementToBeClickable("LogOut");
					selenium.click("LogOut");
					selenium.waitingTime(3000);
					if(selenium.isElementPresentFast("menuDots"))
					{
						System.out.println("Successfully logged out from existing user!");
					}
					else if(selenium.isElementPresentFast("loginButton"))
					{
						System.out.println("Default user got logged-out. So doing default user login again!");
						selenium.doDefaultUATLogin();

					}
					else if(selenium.isElementPresentFast("goBackBtn"))
					{
						System.out.println("Page did not load properly. So doing default user login again!");
						selenium.click("goBackBtn");
						selenium.doDefaultUATLogin();
					}
					selenium.test.log(LogStatus.PASS, "Successfully logged out from existing user!");
				}
				selenium.waitingTime(3000);

				//READING TEST DATA (USER LOGIN URL) FROM TESTDATA PROPERTIES FILE HERE...
				String UserLoginURL = selenium.getTestDataFromPropertiesFile(url);
				System.out.println("User Login URL is : " + UserLoginURL);
				selenium.navigateToURL(UserLoginURL);
				selenium.waitingTime(8000);
				
				selenium.switchToFrame("newAccountFrame");
				String profileName= selenium.getText("profileName");
				String loggedInUserName=selenium.getText("loggedInUserName");
				selenium.test.log(LogStatus.PASS, "<b> User Name : "+loggedInUserName +" . Profile : "+profileName+"</b>");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("loginSalesrep");
				selenium.click("loginSalesrep");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentsuperFast("loginsessionbutton"))
				{
					selenium.test.log(LogStatus.INFO, "LogIn Button Found");
//					selenium.captureScreenShot();
					selenium.waitForElementToBeClickable("loginsessionbutton");
					selenium.click("loginsessionbutton");
					selenium.waitingTime(2000);
				}
				I_successfully_logout_from_application();
				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(2000);				
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "Successfully logged in as US user!");
//				selenium.check_Switch_UserInterface();

			} catch (Exception e) {	
			selenium.test.log(LogStatus.INFO, "error while loggin in");	
//			selenium.check_Switch_UserInterface();
			i_logout_of_any_user();
			selenium.reportFailure("Error while logging in " + e.getMessage());

		}
	}
}


