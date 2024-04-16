package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.mhe.salesforce.util.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class Email2Case {

	WebConnector selenium = WebConnector.getInstance();

	boolean caseIsValid = true;
//	int failedCases = 0;
	String dataSheet = null;
	String casesUrlToday = selenium.getTestDataFromPropertiesFile("AutomationCasesListToday");
	String casesUrl = selenium.getTestDataFromPropertiesFile("AutomationCasesList"); //selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Automation Cases List");
	String smtpHost = selenium.getTestDataFromPropertiesFile("smtpHost"); //selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Email Host");
	String senderEmail = selenium.getTestDataFromPropertiesFile("senderEmail"); //selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sender Email");
	String smtpPort = selenium.getTestDataFromPropertiesFile("smtpPort");  //(int) Double.parseDouble(selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Email Port"));
//	String senderPassword = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sender Password");
	String recipientEmail = "";
	String subject = "";
	String plainTextBody = "";
	String rowComments = "";
	int rowCountJob1= 0;
	int rowCountJob2= 0;
	int rowCountJob3= 0;
	int rowCountJob4= 0;
	int rowCountA3K= 0;

	public void send_external_emails_using_backend_and_validate_expected_values(int rowCount, Xls_Reader xlName)
	{
		rowCount = selenium.getRowCountFromSpecificSheetE2C(dataSheet, xlName);
		selenium.totalCases = selenium.getRowCountFromSpecificSheetE2C(dataSheet, xlName);
		while (rowCount > 1) {
			if (!Boolean.parseBoolean(selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Run", rowCount, xlName))) {
				reportTestSkipped("Run is FALSE: Skipping execution for row " + rowCount);
				rowCount--;
				continue;
			}
			reportTestInfo("Starting execution for row " + rowCount);
			String testResult = "Passed";
			rowComments = " ";

			i_send_an_external_email_using_backend(rowCount, xlName);
			if (case_has_been_created_via_email2case(rowCount, xlName)) {
				selenium.setCellDataOnSpecificSheetE2C(dataSheet, "Case URL", rowCount, selenium.getURL(), xlName);
				the_e2c_case_fields_are_as_expected(rowCount, xlName);
				i_change_the_owner_of_the_case(rowCount, xlName);
				reply_email_has_been_sent(rowCount, xlName);
			}

			if (!caseIsValid) {
				selenium.failedCases++;
				testResult = "FAILED";
				selenium.test.log(LogStatus.FAIL, "Execution " + testResult + " for row " + rowCount);
				selenium.test.log(LogStatus.FAIL, rowCount + " Failure Reason: " + rowComments);
			} else {
				selenium.test.log(LogStatus.PASS, "Execution " + testResult + " for row " + rowCount);
			}
			System.out.println("Execution " + testResult + " for row " + rowCount);
			selenium.setCellDataOnSpecificSheetE2C(dataSheet, "Test Result", rowCount, testResult, xlName);
			selenium.setCellDataOnSpecificSheetE2C(dataSheet, "Comments", rowCount, rowComments, xlName);
			rowCount--;
		}
	}
	
	public void send_external_emails_using_backend_and_validate_case_expected_values(int rowCount, Xls_Reader xlName)
	{
		rowCount = selenium.getRowCountFromSpecificSheetE2C(dataSheet, xlName);
		selenium.totalCases = selenium.getRowCountFromSpecificSheetE2C(dataSheet, xlName);
		while (rowCount > 1) {
			if (!Boolean.parseBoolean(selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Run", rowCount, xlName))) {
				reportTestSkipped("Run is FALSE: Skipping execution for row " + rowCount);
				rowCount--;
				continue;
			}
			reportTestInfo("Starting execution for row " + rowCount);
			String testResult = "Passed";
			rowComments = " ";

			i_send_an_external_email_using_backend(rowCount, xlName);
			if (case_has_been_created_via_email2case(rowCount, xlName)) {
				selenium.setCellDataOnSpecificSheetE2C(dataSheet, "Case URL", rowCount, selenium.getURL(), xlName);
//				the_e2c_case_fields_are_as_expected(rowCount, xlName);
//				i_change_the_owner_of_the_case(rowCount, xlName);
				reply_email_has_been_sent(rowCount, xlName);
			}

			if (!caseIsValid) {
				selenium.failedCases++;
				testResult = "FAILED";
				selenium.test.log(LogStatus.FAIL, "Execution " + testResult + " for row " + rowCount);
				selenium.test.log(LogStatus.FAIL, rowCount + " Failure Reason: " + rowComments);
			} else {
				selenium.test.log(LogStatus.PASS, "Execution " + testResult + " for row " + rowCount);
			}
			System.out.println("Execution " + testResult + " for row " + rowCount);
			selenium.setCellDataOnSpecificSheetE2C(dataSheet, "Test Result", rowCount, testResult, xlName);
			selenium.setCellDataOnSpecificSheetE2C(dataSheet, "Comments", rowCount, rowComments, xlName);
			rowCount--;
		}
	}

	@Then("^I send external emails using backend and validate expected values$")
	public void i_send_external_emails_using_backend_and_validate_expected_values() {
		
		if(selenium.getTestCaseName().equalsIgnoreCase("E2CJob1"))
		{
			dataSheet = selenium.getTestCaseName();			
			send_external_emails_using_backend_and_validate_expected_values(rowCountJob1,selenium.xlsE2C_1);
		}
		else if(selenium.getTestCaseName().equalsIgnoreCase("E2CJob2"))
		{
			dataSheet = selenium.getTestCaseName();
			send_external_emails_using_backend_and_validate_expected_values(rowCountJob2,selenium.xlsE2C_2);
		}
		else if(selenium.getTestCaseName().equalsIgnoreCase("E2CJob3"))
		{
			dataSheet = selenium.getTestCaseName();
			send_external_emails_using_backend_and_validate_expected_values(rowCountJob3,selenium.xlsE2C_3);
		}
		else if(selenium.getTestCaseName().equalsIgnoreCase("E2CJob4"))
		{
			dataSheet = selenium.getTestCaseName();
			send_external_emails_using_backend_and_validate_expected_values(rowCountJob4,selenium.xlsE2C_4);
		}
		else if(selenium.getTestCaseName().equalsIgnoreCase("Email2CaseA3K"))
		{
			dataSheet = selenium.getTestCaseName();
			send_external_emails_using_backend_and_validate_expected_values(rowCountA3K,selenium.xlsE2C_A3K);
		}		


		if (selenium.failedCases > 0) {
			selenium.test.log(LogStatus.FAIL, selenium.failedCases + " Cases contain errors, please review the logs");
			selenium.reportFailure(selenium.failedCases + " Cases contain errors, please review the logs");
		}
		reportTestPassed("All Cases have been created as expected");
	}
	
	@Then("^send external email using backend and verify case created or not$")
	public void send_external_email_using_backend_and_verify_case_created_or_not(DataTable table) {		
		List<String> data = table.transpose().asList(String.class);
		
		if(selenium.isElementPresentFast("CasesTabLink"))
		{
			selenium.jsClick("CasesTabLink");
			selenium.waitingTime(5000);
		}
		
		subject = "E2C Automation Case - " + " " + java.time.Clock.systemUTC().instant();
		
		send_an_external_email_using_backend(data.get(0),subject,data.get(2));
		selenium.waitingTime(10000);
		selenium.test.log(LogStatus.INFO, "Navigating to E2C Cases list view");
		if(selenium.getTestCaseName().equalsIgnoreCase("Email2CaseSubscriptionMgmt")||
			selenium.getTestCaseName().equalsIgnoreCase("Email2CaseSubscriptionMgmtUnsubscribe")||
			selenium.getTestCaseName().equalsIgnoreCase("Email2CaseSubscriptionMgmtUnsubscribeAndPO")) {
			String casesUrl = selenium.getTestDataFromPropertiesFile("TodayOpenedCasesListView");
			selenium.navigateToURL(casesUrl);
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			if(selenium.getTestCaseName().equalsIgnoreCase("Email2CaseSubscriptionMgmtUnsubscribeAndPO"))
			{
				selenium.waitForElementToBeClickable("CasePOAndUnsubscribe");
				selenium.jsClick("CasePOAndUnsubscribe");
			}
			else
			{
				selenium.waitForElementToBeClickable("WelcomeEmailCases");
				selenium.jsClick("WelcomeEmailCases");
			}
			selenium.waitingTime(6000);
		}
		else
		{
			selenium.navigateToURL(casesUrlToday);
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			String caseXpath = selenium.getDynamicXpathData("anchorTextcontains", subject, "endContains");
			System.out.println("caseXpath is " + caseXpath);
			if (!selenium.isElementPresentXpathFast(caseXpath))
			{
				System.out.println("Unable to find case number. Retrying..");
//				selenium.refresh();
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("CaseNumberColumnInCaseList");
				selenium.jsClick("CaseNumberColumnInCaseList");
				selenium.waitingTime(5000);
				if (!selenium.isElementPresentXpathFast(caseXpath))
				{
					selenium.click("CaseNumberColumnInCaseList");		//reversing the order again
					selenium.waitingTime(5000);
					if (!selenium.isElementPresentXpathFast(caseXpath))
					{
						selenium.test.log(LogStatus.FAIL, "Case has not been created");
						selenium.reportFailure("Case has not been created");
						System.out.println("FAIL");
					}
					else
					{
						selenium.test.log(LogStatus.PASS, "Case has been created");
						System.out.println("PASS");
						selenium.clickXpath(caseXpath);
						selenium.waitingTime(8000);
						selenium.newE2CaseURL = selenium.getURL();
						System.out.println("selenium.newE2CaseURL is" + selenium.newE2CaseURL);
						selenium.test.log(LogStatus.INFO, "Navigated to newly created case record" + selenium.newE2CaseURL);
					}
				}
				else
				{
					selenium.test.log(LogStatus.PASS, "Case has been created");
					System.out.println("PASS");
					selenium.clickXpath(caseXpath);
					selenium.waitingTime(8000);
					selenium.newE2CaseURL = selenium.getURL();
					System.out.println("selenium.newE2CaseURL is" + selenium.newE2CaseURL);
					selenium.test.log(LogStatus.INFO, "Navigated to newly created case record" + selenium.newE2CaseURL);
				}
			}
			else
			{
				selenium.checkFlowInterruptedPopup();
				selenium.test.log(LogStatus.PASS, "Case has been created");
				System.out.println("PASS");
				selenium.clickXpath(caseXpath);
				selenium.waitingTime(8000);
				selenium.newE2CaseURL = selenium.getURL();
				System.out.println("selenium.newE2CaseURL is" + selenium.newE2CaseURL);
				selenium.test.log(LogStatus.INFO, "Navigated to newly created case record" + selenium.newE2CaseURL);
			}
		}

	}

	public void i_send_an_external_email_using_backend(int rowIndex, Xls_Reader xlName) {
		try {
 			recipientEmail = selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Recipient Email", rowIndex, xlName);

 			subject = "E2C Automation Case - " + selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Subject", rowIndex, xlName)
 					+ " " + java.time.Clock.systemUTC().instant();

 			plainTextBody = selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Plain Text Body", rowIndex, xlName);

 			Email email = EmailBuilder.startingBlank().from("Automation-UAT-Global", senderEmail).to(recipientEmail)
 					.withSubject(subject).withPlainText(plainTextBody).buildEmail();
 			
			/*Gmail SMTP Server details*/
 			//Mailer mailer = MailerBuilder.withSMTPServer(smtpHost, smtpPort, senderEmail, senderPassword).withTransportStrategy(TransportStrategy.SMTPS).buildMailer();
 			
			/*MHEInternal SMTP Server detail*/ 
 			Mailer mailer = MailerBuilder.withSMTPServerHost(smtpHost).buildMailer();
 			mailer.sendMail(email);
 			reportTestPassed("Mail sent successfully: " + subject);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while sending message: " + e.getMessage());
			selenium.reportFailure("Error while sending message: " + e.getMessage());
		}
	}
	
	public void send_an_external_email_using_backend(String recipientEmail, String subject, String plainTextBody) {
		try {
			if (selenium.getTestCaseName().equalsIgnoreCase("Email2CaseSubscriptionMgmt")) {
				subject = "How to Access Your Recently Purchased McGraw Hill Online Content";
				plainTextBody = "optout";
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("Email2CaseSubscriptionMgmtUnsubscribeAndPO")) {
				subject = "How to Access Your Recently Purchased McGraw Hill Online Content";
				plainTextBody = "Unsubscribe and PO";
			}
 			Email email = EmailBuilder.startingBlank().from("Automation-UAT-Global", senderEmail).to(recipientEmail)
 					.withSubject(subject).withPlainText(plainTextBody).buildEmail();
 			Mailer mailer = MailerBuilder.withSMTPServerHost(smtpHost).buildMailer();
 			mailer.sendMail(email);
 			reportTestPassed("Mail sent successfully: " + subject);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while sending message: " + e.getMessage());
			selenium.reportFailure("Error while sending message: " + e.getMessage());
		}
	}
	
	public boolean case_has_been_created_via_email2case(int rowIndex, Xls_Reader xlName) {
		String caseXpath = selenium.getDynamicXpathData("anchorTextcontains", subject, "endContains");
		System.out.println("caseXpath is " + caseXpath);
		try {
			caseIsValid = true;
			selenium.waiting(10);
			reportTestInfo("Navigating to E2C Cases list view");
			selenium.navigateToURL(casesUrl);
			selenium.waitingTime(6000);
			if (!selenium.isElementPresentXpathFast(caseXpath)) {
				reportTestInfo("Case hasn't been created - Refreshing Cases tab once");
				selenium.waitingTime(30000); //Adding one minute of waiting time for the case to be created
				caseXpath = selenium.getDynamicXpathData("anchorTextcontains", subject, "endContains"); //generating the dynamic xpath again
				System.out.println("caseXpath is :" + caseXpath);
				selenium.waitingTime(2000);
				selenium.refresh();
				selenium.waitingTime(15000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				if (!selenium.isElementPresentXpathFast(caseXpath)) {
					reportTestInfo("Case hasn't been created - Retrying the E2C scenario");
					for(int i=1; i<=1;i++)		//just running this loop for one time (i.e. retrying the failed E2C one more time)
					{
						i_send_an_external_email_using_backend(rowIndex, xlName);
						i++;
					}
					selenium.waitingTime(10000);
					caseXpath = selenium.getDynamicXpathData("anchorTextcontains", subject, "endContains"); //generating the dynamic xpath again
					System.out.println("caseXpath is ::" + caseXpath);
					selenium.waitingTime(2000);
					selenium.navigateToURL(casesUrl);
					selenium.waitingTime(4000);
					selenium.refresh();
					selenium.waitingTime(15000);
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
				}
			}
			selenium.jsClickXpath(caseXpath);
			selenium.waitingTime(6000);
			if(!selenium.getURL().contains("r/Case")){
				selenium.refresh();
				selenium.waitingTime(15000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.jsClickXpath(caseXpath);
				selenium.waitingTime(10000);
				if(!selenium.getURL().contains("r/Case"))
				{
					selenium.reportFailure("Case not created or unreachable");
				}
			}
			reportTestInfo("Case reached successfully: " + subject + " (URL): " + selenium.getURL());
			return true;
		} catch (Exception | AssertionError e) {
			reportTestFailed(e.getMessage());
			return false;
		}
	}

	public void the_e2c_case_fields_are_as_expected(int rowIndex, Xls_Reader xlName) {
		try {
			reportTestInfo("Validating Case fields");
			String expectedCaseOwner = selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Case Owner", rowIndex, xlName);
			String expectedCaseOrigin = selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Case Origin", rowIndex, xlName);
			String expectedCaseRecordType = selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Case Record Type", rowIndex, xlName);

			String actualCaseOwner = getElementTextSafely("LightningCaseOwnerQueue");
			String actualCaseOrigin = getElementTextSafely("LightningCaseOrigin");
			String actualCaseRecordType = getElementTextSafely("caseRecordType");
			String actualCaseWebEmail = getElementTextSafely("LightningCaseWebEmail");
			String actualCaseDescription = getElementTextSafely("LightningCaseDescription");

			validateFieldValue("Case Owner", expectedCaseOwner, actualCaseOwner);
			validateFieldValue("Case Origin", expectedCaseOrigin, actualCaseOrigin);
			validateFieldValue("Case Record Type", expectedCaseRecordType, actualCaseRecordType);
			validateFieldValue("Case Web Email", senderEmail, actualCaseWebEmail);
			if (!plainTextBody.equals("")) {
				validateFieldValue("Case Description", plainTextBody, actualCaseDescription);
			}

		} catch (Exception e) {
			reportTestFailed(e.getMessage());
		}
	}

	public void validateFieldValue(String fieldName, String expectedValue, String actualValue) {
		String validationMessage = " Validating " + fieldName + " (EXPECTED): " + expectedValue + " (ACTUAL): " + actualValue;
		if(actualValue == null) {
			reportTestSkipped(fieldName + " field validation");
		} else if (expectedValue.equals(actualValue) || (fieldName.contains("SimpleTextBox") && actualValue.contains(expectedValue))) {
			reportTestPassed(validationMessage);
		} else {
			reportTestFailed(validationMessage);
		}
	}

	public void i_change_the_owner_of_the_case(int rowIndex, Xls_Reader xlName) {
		try {
			String newCaseOwner = selenium.getCellDataFromSpecificSheetE2C(dataSheet, "New Case Owner", rowIndex, xlName);
			String newCaseOwnerType = selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Change Case Owner By", rowIndex, xlName);
			if (!newCaseOwner.isEmpty()) {
				if (!newCaseOwnerType.equalsIgnoreCase("Queue") && !newCaseOwnerType.equalsIgnoreCase("User")) {
					selenium.reportFailure("Unsupported Case Owner Type: " + newCaseOwnerType);
				}
				newCaseOwnerType = newCaseOwnerType.substring(0, 1).toUpperCase() + newCaseOwnerType.substring(1).toLowerCase();
				reportTestInfo("Updating the Case Owner (" + newCaseOwnerType + ")");
				
				if(!openChangeCaseOwnerModal()) {
					reportTestSkipped("Owner can't be updated for this Record");
					return;
				}
				selenium.waiting(2);
				selenium.getElement("LightningCaseSearchOwners").click();
				selenium.waiting(2);
				selenium.getElement("LightningCase" + newCaseOwnerType + "OwnerOption").click();
				selenium.waiting(2);
				selenium.typeData("search" + newCaseOwnerType + "s", newCaseOwner);
				selenium.waiting(1);
				selenium.typeData("search" + newCaseOwnerType + "s", newCaseOwner);
				selenium.waiting(2);
				selenium.getXpathElement(selenium.getDynamicXpathData("divTitle", newCaseOwner, "end")).click();
				submitNewOwner();

				if (waitAndRetryForElementVisible("CaseOwnerSuccessToast")) {
					reportTestPassed("Owner updated succcessfully");
				} else {
					reportTestFailed("Case Owner update: Success message didn't show up");
				}
				selenium.waiting(8);
			}
		} catch (Exception | AssertionError e) {
			reportTestFailed(e.getMessage());
		}
	}

	public void reply_email_has_been_sent(int rowIndex, Xls_Reader xlName) {
		boolean sendsReply = Boolean.parseBoolean(selenium.getCellDataFromSpecificSheetE2C(dataSheet, "Sends Reply", rowIndex, xlName).toLowerCase());
		if (sendsReply) {
			try {
				reportTestInfo("Checking if Reply Email has been sent");
				selenium.waitForElementToBeClickable("caseEmailSection1");
				selenium.jsClick("caseEmailSection1");
				selenium.waiting(6);
				if (!selenium.isElementPresentFast("LightningCaseRelatedEmailSent")) {
					selenium.refresh();
					selenium.waiting(6);
				}
				if (!selenium.isElementPresentFast("LightningCaseRelatedEmailSent")) {
					selenium.reportFailure("Reply Email hasn't been sent");
				} else {
					reportTestPassed("Reply Email sent successfully");
				}
			} catch (Exception | AssertionError e) {
				reportTestFailed(e.getMessage());
			}

		}
	}
	
	public boolean waitAndRetryForElementVisible(String element) {
		int retries = 22;
		while(retries>0) {
			if(selenium.isElementPresentsuperFast(element)) {
				return true;
			}
			retries--;
		}
		return false;
	}
	
	public String getElementTextSafely(String element) {
		reportTestInfo("Trying to get text from " + element);
		if(selenium.isElementPresentsuperFast(element)) {
			return selenium.getElement(element).getText();
		}
		return null;
	}
	
	public boolean openChangeCaseOwnerModal() {
		if(selenium.isElementPresentsuperFast("LightningChangeOwner")) {
			selenium.jsClick("LightningChangeOwner");
			return true;
		} else if (changeOwnerFromQuickActions()) {
			return true;
		}
		return false;
	}
	
	public boolean changeOwnerFromQuickActions() {
		if(selenium.isElementPresentsuperFast("menuButton")) {
			selenium.jsClick("menuButton");
			if(selenium.isElementPresentFast("QuickActionChangeOwner")) {
				selenium.jsClick("QuickActionChangeOwner");
				return true;
			}
		}
		return false;
	}
	
	public boolean submitNewOwner() {
		if(selenium.isElementPresentsuperFast("ChangeOwnerBtn")) {
			selenium.click("ChangeOwnerBtn");
			return true;
		} else if (selenium.isElementPresentsuperFast("submitTitleButton")) {
			selenium.click("submitTitleButton");
			return true;
		}
		return false;
	}
	public void reportTestInfo(String infoMessage) {
		selenium.test.log(LogStatus.INFO, infoMessage);
		System.out.println(infoMessage);
	}
	
	public void reportTestSkipped(String skipMessage) {
		skipMessage = " (SKIPPING): " + skipMessage;
		reportTestInfo(skipMessage);
		rowComments += skipMessage;
	}
	
	public void reportTestPassed(String passMessage) {
		selenium.test.log(LogStatus.PASS, passMessage);
		System.out.println(passMessage);
	}
	
	public void reportTestFailed(String failMessage) {
		failMessage = " (FAIL): " + failMessage;
		selenium.test.log(LogStatus.FAIL, failMessage);
		System.out.println(failMessage);
		rowComments += failMessage;
		caseIsValid = false;
	}
	
}
