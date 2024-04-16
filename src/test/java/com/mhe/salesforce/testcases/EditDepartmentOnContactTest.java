package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class EditDepartmentOnContactTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^select department name$")
	public void selectDepartment() throws InterruptedException {
		try {
//		String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
//		selenium.navigateToURL(url);
//		selenium.waitingTime(6000);
		selenium.waitForElementToBeClickable("editButton");
		
		selenium.clickLoop("editButton");
//		selenium.waitingTime(6000);
		selenium.waitForElementToBeVisible("deptNameLabel");
		
		selenium.scrollToElement("deptNameLabel");
		selenium.click("deptDeleteIcon");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("search_Departments");
		
		selenium.type("search_Departments", "Department Name");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
		selenium.click("showAllResultsFromDropDwn");
		selenium.waitingTime(6000);
		String deptsearch = selenium.getDynamicXpath("searchDepartment", "Department Name",
				"end");
//		selenium.waitForXpathElementToBeClickable(deptsearch);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(deptsearch);
		selenium.waitForElementToBeClickable("save");
		selenium.clickLoop("save");
		selenium.waitingTime(25000);
		selenium.waitForElementToBeVisible("deptNameGetText");
		
		String deptName = selenium.getText("deptNameGetText").toString();
		String expected_deptName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Department Name");
		System.out.println("Expected Result : "+deptName + expected_deptName);
		if (deptName.equalsIgnoreCase(expected_deptName)) {
			selenium.test.log(LogStatus.PASS, "Department Name updated successfully " + deptName);
			System.out.println("PASS");
			selenium.waitingTime(5000);
		} else {
			selenium.test.log(LogStatus.FAIL, "Department Name updation failed");
			System.out.println("FAIL");
			selenium.reportFailure("Department Name updation failed");
		}
		}catch (Exception e){
		    selenium.reportFailure(e.getMessage());
		    selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) 
			{
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}

			else 
			{
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}
	}


}
