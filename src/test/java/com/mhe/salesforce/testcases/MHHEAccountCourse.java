package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MHHEAccountCourse {
	WebConnector selenium = WebConnector.getInstance();
	
	 @Then("^I click on new$")
	    public void i_click_on_new()  {
		try {
		
	    selenium.waitForElementToBeClickable("newOpportunityBtn");
	    selenium.click("newOpportunityBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementsToBeVisible("newAccountFrame");
		selenium.switchToMultipleFrame("newAccountFrame");
		selenium.waitingTime(2000);

		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking new opportunity" + e.getMessage());
			}

	}
	 
	 @And("^create opportunity$")
	    public void create_opportunity()  {
		try {
		
			selenium.waitForElementToBeVisible("opportunityAccountName");
			selenium.type("opportunityAccountName", "Account Name");
			selenium.waitingTime(3000);
//			selenium.pressEnter("opportunityAccountName");
//			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath("spanTitle", "Account Name", "dynamicspantext");
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.clickXpath(xpath);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("mheCourse");
			selenium.type("mheCourse", "MHE Course");
			selenium.waitingTime(3000);
//			selenium.pressEnter("mheCourse");
//			selenium.waitingTime(2000);
			String xpath1 = selenium.getDynamicXpath("spanTitle", "MHE Course", "dynamicspantext");
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeClickable(xpath1);
			selenium.clickXpath(xpath1);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunityTypeDropdown");
			
			selenium.jsClick("opportunityTypeDropdown");
			selenium.selectDropdownText("opportunityTypeDropdown", "Opportunity Type");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("oppurtunitySpringEnrollment");
			selenium.type("oppurtunitySpringEnrollment", "Spring Enrollment");
//			 selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
			selenium.type("oppurtunityFallEnrollment", "Fall Enrollment");
//			 selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("oppurtunitySpringEnrollment");
			selenium.moveTab("oppurtunitySpringEnrollment");
			selenium.captureScreenShot();
//            selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ButtonSave");
            selenium.click("ButtonSave");
            selenium.waitingTime(9000);
            selenium.switchOutOfFrame(); 
            selenium.waitingTime(2000);
            selenium.test.log(LogStatus.PASS, "Opportunity created successfully");

		}
		 catch (Exception e) {
			 selenium.switchOutOfFrame(); 
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while creating new opportunity" + e.getMessage());
			}

	}
	
	 @Then("^verify Account course created$")
	    public void verify_account_course_created()  {
		try {
		String newOpp=selenium.getURL();
		System.out.println(newOpp);
			selenium.waitForElementToBeVisible("relatedListLink");
//			selenium.scrollToElement("relatedListLink");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
//	         selenium.waitingTime(2000);
	         
	        
			String course = selenium.getDynamicXpath("opportunityAccountCourse", "MHE Course", "endContains");
			System.out.println(course);
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeClickable(course);
			selenium.clickXpath(course);
			selenium.waitingTime(4000);
			/*
			 * selenium.refresh(); selenium.waitingTime(4000);
			 */
			selenium.waitForElementToBeVisible("accountMHECourseHeading1");
		
			if(selenium.getElement("accountMHECourseHeading1").isDisplayed()) {
				 selenium.test.log(LogStatus.PASS, "Account MHE Course created successfully");
			}
			
			else {
				selenium.test.log(LogStatus.FAIL, "Account MHE Course Not created");
				selenium.reportFailure("Account MHE Course Not created");
			}
			selenium.captureScreenShot();
//         selenium.waitingTime(3000);
         selenium.navigateToURL(newOpp);
         //selenium.jsClick("opportunityFromAccountCourse");
         selenium.waitingTime(5000);

		}
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying account course" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}

	 @And("^delete INTL opportunity$")
	 public void delete_INTL_opportunity()
	 {
		try
		{
			 if(selenium.INTLOppURL != null)
			 {
				 selenium.navigateToURL(selenium.INTLOppURL);
				 selenium.waitingTime(5000);
				 selenium.captureScreenShot();
				 if(selenium.isElementPresentFast("moreActionsBtn"))
					 {
				 		 selenium.waitForElementToBeClickable("moreActionsBtn");
				 		 selenium.click("moreActionsBtn");
				 		 selenium.waitingTime(2000);
						 selenium.waitForElementToBeClickable("DeletePopup2");
						 selenium.clickLoop("DeletePopup2");
						 selenium.waitForElementToBeClickable("deletePopupBtn");
						 selenium.clickLoop("deletePopupBtn");
						 selenium.waitingTime(5000);
						 selenium.test.log(LogStatus.PASS, "The INTL Opp is deleted successfully!");
						 selenium.captureScreenShot();
						 selenium.waitingTime(2000);
					 }
				 else
					 {
						 System.out.println("The INTL Opp has already been deleted");
					 }
			 }
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while deleting INTL Opp " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while deleting INTL Opp");
		}
	 }

	 @And("^delete MHES opportunity$")
	 public void delete_MHES_opportunity()
	 {
		try
		{
			 if(selenium.SEGSalesRepUserNewOppURL != null)
			 {
				 //Original Opp Name would be - "2024-OK-Lawton Public Schools-ELEMENTARY: ASG - LITERACY-Open-jbaker"
				 //Updated Opp Name would be - "2024-OK-Lawton Public Schools-ELEMENTARY: ASG - LITERACY-Closed/Lost-jbaker"
				 //And we delete the updated opp below and original opp in the next feature file step
				 selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				 selenium.waitingTime(10000);
				 selenium.captureScreenShot();

				if(selenium.isElementPresentFast("CloseNotificationPopup"))
				{
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
				 if(selenium.isElementPresentFast("moreActionsBtn"))
					 {
				 		 selenium.waitForElementToBeClickable("moreActionsBtn");
				 		 selenium.click("moreActionsBtn");
				 		 selenium.waitingTime(2000);
						 selenium.waitForElementToBeClickable("DeletePopup2");
						 selenium.clickLoop("DeletePopup2");
						 selenium.waitForElementToBeClickable("deletePopupBtn");
						 selenium.clickLoop("deletePopupBtn");
						 selenium.waitingTime(5000);
						 selenium.test.log(LogStatus.PASS, "The MHES/SEG Opp is deleted successfully!");
						 selenium.captureScreenShot();
						 selenium.waitingTime(2000);
					 }
				 else
					 {
						 System.out.println("The MHES/SEG Opp has already been deleted");
					 }
			 }
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while deleting MHES/SEG Opp " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while deleting MHES/SEG Opp");
		}
	 }

	 @And("^delete MHHE opportunity$")
	 public void delete_MHHE_opportunity()
	 {
		try
		{
			 if(selenium.MHHENewOppURL != null)
			 {
				 selenium.navigateToURL(selenium.MHHENewOppURL);
				 selenium.waitingTime(5000);
				 selenium.captureScreenShot();
				 if(selenium.isElementPresentFast("moreActionsBtn"))
					 {
				 		 selenium.waitForElementToBeClickable("moreActionsBtn");
				 		 selenium.click("moreActionsBtn");
				 		 selenium.waitingTime(2000);
						 selenium.waitForElementToBeClickable("DeletePopup2");
						 selenium.clickLoop("DeletePopup2");
						 selenium.waitForElementToBeClickable("deletePopupBtn");
						 selenium.clickLoop("deletePopupBtn");
						 selenium.waitingTime(5000);
						 selenium.test.log(LogStatus.PASS, "The MHHE Opp is deleted successfully!");
						 selenium.captureScreenShot();
						 selenium.waitingTime(2000);
					 }
				 else
					 {
						 System.out.println("The MHHE Opp has already been deleted");
					 }
			 }
			 
			 if(selenium.MHHENewOppURLToVerifyEvergreenField != null)
			 {
				 selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
				 selenium.waitingTime(5000);
				 selenium.captureScreenShot();
				 if(selenium.isElementPresentFast("moreActionsBtn"))
					 {
				 		 selenium.waitForElementToBeClickable("moreActionsBtn");
				 		 selenium.click("moreActionsBtn");
				 		 selenium.waitingTime(2000);
						 selenium.waitForElementToBeClickable("DeletePopup2");
						 selenium.clickLoop("DeletePopup2");
						 selenium.waitForElementToBeClickable("deletePopupBtn");
						 selenium.clickLoop("deletePopupBtn");
						 selenium.waitingTime(5000);
						 selenium.test.log(LogStatus.PASS, "The MHHE Opp is deleted successfully!");
						 selenium.captureScreenShot();
						 selenium.waitingTime(2000);
					 }
				 else
					 {
						 System.out.println("The MHHE Opp has already been deleted");
					 }
			 }
			 
			 if(selenium.MHHEOppWithFutureYear != null)
			 {
				 selenium.navigateToURL(selenium.MHHEOppWithFutureYear);
				 selenium.waitingTime(5000);
				 selenium.captureScreenShot();
				 if(selenium.isElementPresentFast("moreActionsBtn"))
					 {
				 		 selenium.waitForElementToBeClickable("moreActionsBtn");
				 		 selenium.click("moreActionsBtn");
				 		 selenium.waitingTime(2000);
						 selenium.waitForElementToBeClickable("DeletePopup2");
						 selenium.clickLoop("DeletePopup2");
						 selenium.waitForElementToBeClickable("deletePopupBtn");
						 selenium.clickLoop("deletePopupBtn");
						 selenium.waitingTime(5000);
						 selenium.test.log(LogStatus.PASS, "The MHHE Opp is deleted successfully!");
						 selenium.captureScreenShot();
						 selenium.waitingTime(2000);
					 }
				 else
					 {
						 System.out.println("The MHHE Opp has already been deleted");
					 }
			 }
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while deleting MHHE Opp " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while deleting MHHE Opp");
		}
	 }

	 @And("^delete opportunity$")
	    public void delete_opportunity()
	 {
			 
			 try
			 {
				 if(selenium.getTestCaseName().equalsIgnoreCase("MHHECreateAccountCourse"))
				 {
					 selenium.waitingTime(5000);
					 selenium.captureScreenShot();
			 		 selenium.waitForElementToBeClickable("moreActionsBtn");
			 		 selenium.click("moreActionsBtn");
			 		 selenium.waitingTime(2000);
					 selenium.waitForElementToBeClickable("DeletePopup2");
					 selenium.clickLoop("DeletePopup2");
					 selenium.waitForElementToBeClickable("deletePopupBtn");
					 selenium.clickLoop("deletePopupBtn");
					 selenium.waitingTime(9000);
				 }

//				 if(selenium.getTestCaseName().equalsIgnoreCase("DeleteOpportunity"))
//				 {
//					 //Original Opp Name would be - "2023-OK-Lawton Public Schools-ELEMENTARY: ASG - LITERACY-Open-jbaker"
//					 //Updated Opp Name would be - "2023-OK-Lawton Public Schools-ELEMENTARY: ASG - LITERACY-Cloned/Lost-jbaker"
//					 //And we delete the updated opp below and original opp in the next feature file step
//					 selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
//					 selenium.waitingTime(5000);
//					 selenium.captureScreenShot();
//			 		 selenium.waitForElementToBeClickable("moreActionsBtn");
//			 		 selenium.click("moreActionsBtn");
//			 		 selenium.waitingTime(2000);
//					 selenium.waitForElementToBeClickable("DeletePopup2");
//					 selenium.clickLoop("DeletePopup2");
//					 selenium.waitForElementToBeClickable("deletePopupBtn");
//					 selenium.clickLoop("deletePopupBtn");
//					 selenium.waitingTime(9000);
//				 }

				if(selenium.getTestCaseName().equalsIgnoreCase("DeleteOpportunity_Sample"))
				{
				 selenium.navigateToURL(selenium.NewOppURLForSamplesTest);
				 selenium.waitingTime(8000);
				 if(selenium.isElementPresentFast("moreActionsBtn"))
				 {
			 		 selenium.waitForElementToBeClickable("moreActionsBtn");
			 		 selenium.click("moreActionsBtn");
			 		 selenium.waitingTime(2000);
					 selenium.waitForElementToBeClickable("DeletePopup2");
					 selenium.clickLoop("DeletePopup2");
					 selenium.waitForElementToBeClickable("deletePopupBtn");
					 selenium.clickLoop("deletePopupBtn");
					 selenium.waitingTime(9000);
				 }
				 else
				 {
					 System.out.println("Opp is already been deleted");
				 }
				}
				
				 if(selenium.getTestCaseName().equalsIgnoreCase("DeleteOpportunity_Quote"))
				 {
					 if(selenium.QuoteNewOppURL != null)
					 {
						 selenium.navigateToURL(selenium.QuoteNewOppURL);
						 selenium.waitingTime(5000);
						 selenium.captureScreenShot();
						 if(selenium.isElementPresentFast("moreActionsBtn"))
							 {
						 		 selenium.waitForElementToBeClickable("moreActionsBtn");
						 		 selenium.click("moreActionsBtn");
						 		 selenium.waitingTime(2000);
								 selenium.waitForElementToBeClickable("DeletePopup2");
								 selenium.clickLoop("DeletePopup2");
								 selenium.waitForElementToBeClickable("deletePopupBtn");
								 selenium.clickLoop("deletePopupBtn");
								 selenium.waitingTime(9000);
							 }
						 else
							 {
								 System.out.println("The default adoption link aka opp is already been deleted");
							 }
					 }

					 if(selenium.NewOppURLForQuotesTest != null)
						 {
							 selenium.navigateToURL(selenium.NewOppURLForQuotesTest);
							 selenium.waitingTime(5000);
							 selenium.captureScreenShot();
							 if(selenium.isElementPresentFast("moreActionsBtn"))
								 {
							 		 selenium.waitForElementToBeClickable("moreActionsBtn");
							 		 selenium.click("moreActionsBtn");
							 		 selenium.waitingTime(2000);
									 selenium.waitForElementToBeClickable("DeletePopup2");
									 selenium.clickLoop("DeletePopup2");
									 selenium.waitForElementToBeClickable("deletePopupBtn");
									 selenium.clickLoop("deletePopupBtn");
									 selenium.waitingTime(9000);
								 }
							 else
								 {
									 System.out.println("The opp link is already been deleted");
								 }
						 }

					 if(selenium.QuoteNewOppURL1 != null)
					 {
						 selenium.navigateToURL(selenium.QuoteNewOppURL1);
						 selenium.waitingTime(5000);
						 selenium.captureScreenShot();
						 if(selenium.isElementPresentFast("moreActionsBtn"))
							 {
						 		 selenium.waitForElementToBeClickable("moreActionsBtn");
						 		 selenium.click("moreActionsBtn");
						 		 selenium.waitingTime(2000);
								 selenium.waitForElementToBeClickable("DeletePopup2");
								 selenium.clickLoop("DeletePopup2");
								 selenium.waitForElementToBeClickable("deletePopupBtn");
								 selenium.clickLoop("deletePopupBtn");
								 selenium.waitingTime(9000);
							 }
						 else
							 {
								 System.out.println("The default adoption link aka opp is already been deleted");
							 }
					 }
				 }
				
			 }
			 catch (Exception e)
			 	{
					selenium.reportFailure("Error while deleting opportunity " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		 }

		@And("^delete original opp created for SEGSalesRepUserCreateOpportunity$")
		public void delete_original_opp() {
			try {	
				 selenium.waitingTime(5000);
				 selenium.refresh();
				 selenium.waitingTime(6000);
				 selenium.captureScreenShot();
				 selenium.waitingTime(2000);
		 		 selenium.waitForElementToBeClickable("moreActionsBtn");
		 		 selenium.clickLoop("moreActionsBtn");
		 		 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("DeletePopup2");
				 selenium.clickLoop("DeletePopup2");
				 selenium.waitForElementToBeClickable("deletePopupBtn");
				 selenium.clickLoop("deletePopupBtn");
				 selenium.waitingTime(9000);
			}
		 
		 catch (Exception e) {
				selenium.reportFailure("Error while deleting opportunity " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
		
		 @And("^delete the \"([^\"]*)\" which are created by scripts$")
		 public void del_opportunity(String oppName)
		 {
			try
			{
				selenium.search_data(oppName);
				String Xpath = selenium.getDynamicXpath_data("opportunityStartContains1", oppName, "endContains");
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
				selenium.waitingTime(5000);
				selenium.deleteruntimeopp();
			}
			 catch (Exception e) {
					selenium.reportFailure("Error while deleting opportunity " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		 } 

}
