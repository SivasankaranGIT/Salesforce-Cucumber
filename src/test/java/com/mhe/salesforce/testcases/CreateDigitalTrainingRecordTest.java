package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateDigitalTrainingRecordTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String url;
	String todaysdate;

	@When("^Navigate to digital training screen$")
	public void navigate_to_digital_training_screen() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "Screen Name");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("digitalTrainingTabSearch");
		selenium.clickLoop("digitalTrainingTabSearch");
		selenium.waitingTime(2000);
		selenium.test.log(LogStatus.INFO, "Digital training screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^create new digital training record$")
	public void create_new_digital_training_record() {
		try {
			selenium.waitingTime(5000);
			if (selenium.getUI().contains("Lightning")) {
				
				/*selenium.search("Digital Training");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Digital Training", "endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);
				selenium.waitForElementToBeClickable("contactGetText");

				selenium.clickLoop("contactGetText");*/
				
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038000000pUpcEAAS/view");
				selenium.waitingTime(8000);

				url = selenium.getURL();

				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.click("closeBtn");
					selenium.clickLoop("newDigitalTrainingRecordBtn");
				} else {
					selenium.clickLoop("newDigitalTrainingRecordBtn");
				}

				selenium.waitingTime(18000);

				selenium.switchToMultipleFrame("productframeUat");

				selenium.selectDropdownText("trainingTopicsDrpDwn", "Training Topic");

				selenium.clickDynamic("spanTitle", "Sub Topic", "end");
				selenium.waitForElementToBeClickable("subTopicArrow");
				selenium.click("subTopicArrow");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("digitalProductTitle");

				selenium.scrollToElement("digitalProductTitle");
				selenium.clickDynamic("spanTitle", "Digital Product", "end");
				selenium.waitForElementToBeClickable("digitalProductArrow1");
				selenium.click("digitalProductArrow1");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("NxtButton");

				selenium.scrollToElement("NxtButton");
				selenium.click("NxtButton");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("opportunitySearchDrpDown");
				selenium.click("opportunitySearchDrpDown");
				selenium.waitingTime(2000);
//				selenium.clickDynamic("spantextContains", "Opportunity", "endContains");
				selenium.click("SearchContent");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.click("saveButton");
				selenium.waitingTime(15000);
				selenium.switchOutOfFrame();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				todaysdate = sdf.format(new Date());
				System.out.println(todaysdate);

				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("digitalTrainingNameGetTextNew");
				String name = selenium.getText("digitalTrainingNameGetTextNew");

				if (name.contains(todaysdate)) {
					selenium.test.log(LogStatus.PASS, "Digital Training Record created successfully " + name);
					System.out.println("PASS");
				} else
				{
					selenium.test.log(LogStatus.FAIL, "Digital Training Record creation failed ");
					selenium.reportFailure("Digital Training Record creation failed");
				}
			}

		} catch (Exception e) {
//			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@Then("^Verify digital training record created$")
	public void verify_digital_training_record_created() {
		try {
		selenium.navigateToURL(url);
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("digitalTrainingLink");
		selenium.clickLoop("digitalTrainingLink");
		selenium.waitingTime(3000);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		todaysdate = sdf.format(new Date());
//		System.out.println(todaysdate);
		
	 	Calendar calendar1 = Calendar.getInstance();
		Date date = calendar1.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
		String todaysdate = sdf1.format(date);
		System.out.println("today date"+todaysdate);
		
		calendar1.setTime(date);
		calendar1.add(Calendar.DATE, -1);
		Date dateBefore1Day = calendar1.getTime();
		SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
		String yesterdaysDate = sdf2.format(dateBefore1Day);
		System.out.println("yesterday/today date" + yesterdaysDate);

		String trainingRecord = selenium.getDynamicXpathProperty("anchorTitlecontains", todaysdate, "endContains");
//		selenium.waitForXpathElementToBeClickable(trainingRecord);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(trainingRecord);

		selenium.waitingTime(5000);
		selenium.refresh();
		selenium.waitingTime(5000);
//		selenium.waitForElementToBeVisible("digitalTrainingNameGetText");

		String name = selenium.getText("digitalTrainingNameGetText");
		System.out.println("digitalTrainingNameGetText" + name);
		if (name.contains(todaysdate) || name.contains(yesterdaysDate)) {
			selenium.test.log(LogStatus.PASS, "Digital Training Record is present in the name: " + name);
			System.out.println("PASS");
		} else
		{
			selenium.test.log(LogStatus.FAIL, "Digital Training Record not present");
			selenium.reportFailure("Digital Training Record not present");
		}
	}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
		

}
