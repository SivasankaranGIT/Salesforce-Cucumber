package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;

import io.cucumber.java.en.And;

public class ExistingTaskCanBeModifiedTest {
	
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	
	@And("^I edit task details$")
	public void I_edit_task_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				if(selenium.isElementPresentFast("closeBtn"))
				{
					selenium.click("closeBtn");
				}
				selenium.waitForElementToBeClickable("dispalyAsBtn");
				selenium.click("dispalyAsBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("tableView");
				selenium.click("tableView");
				
				/*selenium.waitingTime(3000);
				selenium.click("SearchThisList");
				selenium.waitingTime(2000);
				selenium.type("SearchThisList", "Task Name");
				selenium.getElement("SearchThisList").sendKeys(Keys.ENTER);*/
				
				selenium.waitingTime(4000);
				/*
				selenium.waitForElementToBeClickable("campaignFromDrpDwn");
				selenium.click("campaignFromDrpDwn");
				selenium.waitingTime(2000);
				String nameXpath = selenium.getDynamicXpath("spanTitle", "Search Dropdown", "end");
				selenium.scrollToXpathElement(nameXpath);
				selenium.clickXpath(nameXpath);
				selenium.waitingTime(2000);
				
				selenium.search("Task Name");
				selenium.waitingTime(3000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Task Name", "endContains");
				selenium.clickLoopXpath(Xpath);

				 */
//				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Task URL");
//				selenium.navigateToURL(url);
//				selenium.waitingTime(10000);
				selenium.navigateToURL(selenium.taskURL);
				System.out.println("Navigated to task URL : " + selenium.taskURL);
				//selenium.clickLoop("editButton");
				//selenium.waitForElementToBeClickable("taskArrowBtn");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentsuperFast("EditButton"))
				{
					selenium.waitForElementToBeClickable("EditButton");
					selenium.jsClick("EditButton");
				}
				else
				{
					selenium.waitForElementToBeClickable("taskArrowBtn");
					selenium.click("taskArrowBtn");
					selenium.waitForElementToBeClickable("editL");
					selenium.click("editL");
				}
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("TypeDDList");
				selenium.click("TypeDDList");
				selenium.waitingTime(2000);
				selenium.clickDynamic("anchorTitle", "Task Type", "end");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("taskCommentsTextarea");
				
				selenium.scrollToElement("taskCommentsTextarea");
				selenium.type("taskCommentsTextarea", "Comments");
				
				selenium.scrollToElement("taskStatusDropDwn");
				selenium.click("taskStatusDropDwn");
				selenium.clickDynamic("newType", "Status", "end");
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				selenium.waitingTime(10000);
				/*selenium.waitForElementToBeVisible("contactSuccessfulL");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);*/

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

}
