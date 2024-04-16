package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;

public class TaskCompletedStatusActivityHistoryTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	
	@And("^I switch to Sales home page$")
    public void switchToSalesHomePage() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
        selenium.click("allButtonLightning");
        selenium.waitingTime(4000);
        selenium.waitForElementToBeClickable("AllButtonL");
        selenium.click("AllButtonL");
        selenium.waitingTime(4000);
//        selenium.type("searchallitems", "Screen Name");
        selenium.type_propertiesFile("searchallitems", "SalesMenu");
        selenium.waitingTime(2000);
        selenium.waitForElementToBeClickable("salesHomePage1");
        selenium.clickLoop("salesHomePage1");
        selenium.waitingTime(4000);
        selenium.test.log(LogStatus.INFO, "Sales Home Page loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
    }

	@And("^I switch to Pipeline Creation page$")
    public void switchToPipelineCreationPage() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
        selenium.click("allButtonLightning");
        selenium.waitingTime(4000);
        selenium.waitForElementToBeClickable("AllButtonL");
        selenium.click("AllButtonL");
        selenium.waitingTime(4000);
        selenium.type("searchallitems", "Screen Name");
        selenium.waitingTime(2000);
        selenium.waitForElementToBeClickable("PipelineCreationLink");
        selenium.clickLoop("PipelineCreationLink");
        selenium.waitingTime(4000);
        selenium.test.log(LogStatus.INFO, "Pipeline Creation Page loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
    }

	@And("^edit task status and verify Activity History section$")
	public void I_edit_task_status() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.navigateToURL(selenium.taskNew);
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("productNameGetTextNew");
				String taskName = selenium.getTextLoop("productNameGetTextNew").toString();
				System.out.println("TaskName is : "+taskName);

				selenium.waitForElementToBeClickable("actionDropdownBtn");
				selenium.clickLoop("actionDropdownBtn");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("editL");
				selenium.clickLoop("editL");

				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("taskStatusDropDwn");
				selenium.scrollToElement("taskStatusDropDwn");
				selenium.waitForElementToBeClickable("taskStatusDropDwn");
				selenium.click("taskStatusDropDwn");
				selenium.clickDynamic("newType", "Status", "end");
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				selenium.waitingTime(25000);
				/*selenium.waitForElementToBeVisible("contactSuccessfulL");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);
				selenium.waitingTime(3000);*/
				selenium.waitForElementToBeClickable("relatedToLink");
				selenium.clickLoop("relatedToLink");
				selenium.waitingTime(4000);
				//selenium.click("activityTab");
				
				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
					selenium.scrolldown(100);
					selenium.waitForElementToBeClickable("activityTab");
					selenium.click("activityTab");
				} else {
					selenium.scrolldown(100);
					selenium.waitForElementToBeClickable("activityTab");
					selenium.click("activityTab");
				}
				
				selenium.waitingTime(4000);


				/*String task = selenium.getDynamicXpathProperty("taskNameDynamic", taskName, "end");
				selenium.scrollToXpathElement(task);
				if (selenium.isElementPresentFast("taskCompletedText")) {
					selenium.test.log(LogStatus.PASS,
							"Task status changed to Completed and it is available in Activity history section");
				} else {
					selenium.test.log(LogStatus.FAIL, "Task not available in Activity history section");
				}*/
				String task = selenium.getDynamicXpathProperty("anchorTitle", taskName, "eventpasdateend");
				System.out.println("Task xpath is: "+task);
				selenium.scrolldown(300);
				selenium.jsClickXpath(task);
				/*
				 * String task = selenium.getDynamicXpathProperty("anchorTitle", taskName,
				 * "end"); selenium.clickLoopXpath(task);
				 */
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("taskStatusText");
				selenium.scrollToElement("taskStatusText");
				String taskstatus=selenium.getTextLoop("taskStatusText");
				String status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Status");
				if (selenium.getTextLoop("taskStatusText").equalsIgnoreCase(status)) {
					selenium.test.log(LogStatus.PASS,
							"Task status changed to Completed and it is available in Activity history section");
					System.out.println("PASS");
				} else {
					selenium.test.log(LogStatus.FAIL, "Task not available in Activity history section");
					System.out.println("FAIL");
					selenium.reportFailure("Test Case Failed");
				}
				
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
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}

	}

	@And("^delete the created task$")
	public void delete_task() {
		try {
//		selenium.navigateToURL(selenium.task);
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("taskArrowBtn");
		selenium.clickLoop("taskArrowBtn");
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("DeleteRecord");
		selenium.click("DeleteRecord");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("deleteBtn");
		selenium.click("deleteBtn");

		flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
		selenium.printLastTestResult(flagsuccess);

		selenium.test.log(LogStatus.PASS, "Task deleted successfully");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

}
