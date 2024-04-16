package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AccountHierarchy {
WebConnector selenium = WebConnector.getInstance();
	


	
@And("^open existing account$")
public void open_existing_account() {
		try {
		
			  selenium.waitingTime(5000);
			  String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account URL");
				selenium.navigateToURL(url);
				selenium.waitingTime(6000);
				}
				 catch (Exception e) {
					 	selenium.test.log(LogStatus.FAIL, "Error while opening account");
						selenium.reportFailure("Error while opening account" + e.getMessage());
					}

	}

@Then("^click on heirarchy$")
public void click_on_heirarchy() {
	
	try {
		selenium.captureScreenShot();
//		 selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("accountHierarchy");
		selenium.click("accountHierarchy");
		selenium.waitingTime(4000);
		
	}
	catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Error while clicking on heirarchy");
		selenium.reportFailure("Error while clicking on heirarchy" + e.getMessage());
	}
}
	@And("^view hierarchy$")
    public void view_hierarchy() {
		 
		 try {
//			 selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("accountHierarchyDisplay");
			 
			 if(selenium.getElement("accountHierarchyDisplay").isDisplayed() ) {
			 		selenium.test.log(LogStatus.PASS, "Account Hierarchy viewed successfully");
			 		System.out.println("PASS");
				}
			 else {
					selenium.test.log(LogStatus.FAIL, "Account hierarchy not present");
					selenium.reportFailure("Account hierarchy not present");
					}
			 
			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 
			 	
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Error while viewing account hierarchy");
				selenium.reportFailure("Error while viewing account hierarchy" + e.getMessage());
			}
	 } 
	
	@And("^fetch pick list value$")
    public void fetch_pick_list_value() {
		try {
			String PageURL = "https://mh--uat.sandbox.lightning.force.com/lightning/o/Knowledge__kav/new?count=1&nooverride=1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=167721941628955333&recordTypeId=0120y000000QfABAA0";
			selenium.navigateToURL(PageURL);
			selenium.waitingTime(10000);
			//Need to write code to pick value from the picklist
			
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Error while fetching picklist value");
				selenium.reportFailure("Error while fetching picklist value" + e.getMessage());
			}
	}
	 
}


	


