package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MHECourseProductGroup {
	WebConnector selenium = WebConnector.getInstance();
	
	 @When("^I navigate to MHE Course tab$")
	    public void i_navigate_to_mhe_course_tab()  {
		try {
		
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Course");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("mheCourseMenuOptions");
		selenium.jsClick("mheCourseMenuOptions");
		selenium.waitingTime(5000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to MHE Course" + e.getMessage());
			}

	}
	 
	 @And("^Navigate to existing course URL$")
	    public void navigate_to_existing_course_url() {
	        try {

	            selenium.waitingTime(3000);
	            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Course URL");
	            selenium.navigateToURL(url);
	            selenium.waitingTime(10000);
	            selenium.test.log(LogStatus.INFO, "Navigated to the desired Course" );
	            selenium.captureScreenShot();
//	            selenium.waitingTime(2000);
	        }
	        catch (Exception e) {
	            selenium.reportFailure("Error while clicking Course " + e.getMessage());
	            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	        }
	    }
	 
	 @Then("^edit product group$")
	    public void edit_product_group()  {
		try {
		selenium.navigateToURL(selenium.MHECourseURL);
		System.out.println("Navigated to MHE Course: " + selenium.MHECourseURL);
	    selenium.waitForElementToBeClickable("editProductGroupButton");
		selenium.jsClick("editProductGroupButton");
		selenium.waitingTime(7000);
		selenium.waitForElementToBeClickable("productGroupBox");
		selenium.jsClick("productGroupBox");
		 selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("productGroupBox");
		selenium.type("productGroupBox", "Product Group");
		selenium.waitingTime(2000);
		selenium.pressEscapeKey();
		 selenium.waitForElementToBeClickable("Save_Btn");
         selenium.click("Save_Btn");
 		 selenium.waitingTime(9000);
		}
		 catch (Exception e) {
			 	selenium.captureScreenShot();
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while editing product group" + e.getMessage());
			}

	}
	 
	 @And("^verify Product group$")
	    public void verify_product_group()  {
			try {
			
			selenium.waitForElementToBeVisible("productGroupAfterEdit");
			String name = selenium.getText("productGroupAfterEdit").toString();
			String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Product Group");
			System.out.println("product group is" +name+ "and expected is"+expected_name );
			if (name.contains(expected_name)) {
				System.out.println("inside pass");
				selenium.test.log(LogStatus.PASS, "Product Group edited successfully");

			} else {
				System.out.println("inside fail");
				selenium.test.log(LogStatus.FAIL, "Editing of product group failed");
				selenium.reportFailure("Test Case Failed");

			}
			
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			}
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying details" + e.getMessage());
				
				}

		}

	 @And("^I create a new MHE course$")
	    public void I_create_a_new_MHE_course()
	 	{
			try
				{			
					selenium.waitForElementToBeClickable("NewButtonToAdd");
					selenium.click("NewButtonToAdd");
					selenium.waitForElementToBeClickable("Name_Field");
					String courseName = selenium.getRandomString();
					selenium.getElement("Name_Field").sendKeys(courseName);
					System.out.println("courseName is :" + courseName);
					selenium.type("productGroupBox", "Product Group");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("Save_Btn");
			        selenium.click("Save_Btn");
			 		selenium.waitingTime(8000);		
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					selenium.test.log(LogStatus.PASS, "New MHECourse Created Successfully!");
					selenium.MHECourseURL = selenium.getURL();
					System.out.println("Newly created MHECourseURL is : " + selenium.MHECourseURL);
				}
			 catch (Exception e)
				{
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while creating new MHE course" + e.getMessage());				
				}

		}

}
