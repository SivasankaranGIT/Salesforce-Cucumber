package com.mhe.salesforce.testcases;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class Cases_CSOMandCXGContactLinkToDummyAccount {
	WebConnector selenium = WebConnector.getInstance();
	public String MHESProductTypeCaseURL = null;
	public String NONMHESProductTypeCaseURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Case/5008b000027lR9sAAE/view";
	public String url=null;
	public String alternatateEmail=null;
	public String newEmail=null;
	@When("^I search for CSOM User contacts$")
    public void i_search_for_csom_user_contacts()  {
		try {
	    selenium.waitingTime(5000);
	    selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Contact");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("contactsOptionMenuDots");
		selenium.jsClick("contactsOptionMenuDots");
		selenium.waitingTime(3000);
		
	
	}
	 catch (Exception e) {
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");			
			selenium.reportFailure("Error while navigating to contacts " + e.getMessage());
		}

}
	
	
	 @Then("^create a new contact for CSOM user$")
	    public void create_a_new_contact_for_csom_user() {
		 try {
			 selenium.waitForElementToBeClickable("NewButtonToAdd");
			 selenium.jsClick("NewButtonToAdd");
			 selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("firstName");
				selenium.type("firstName", "First Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("lastName");
				selenium.type("lastName", "Last Name");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.waitForElementToBeClickable("searchAccounts");
				selenium.jsClick("searchAccounts");
				selenium.waitingTime(4000);
				selenium.type("searchAccounts", "Support Account");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("accountAutosuggestiveOption");
				selenium.jsClick("accountAutosuggestiveOption");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("jobFunctionStudent1");
				selenium.scrollToElement("jobFunctionStudent1");
				selenium.waitForElementToBeClickable("jobFunctionStudent1");
				selenium.jsClick("jobFunctionStudent1");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("JobFunctionChooseButton");
				selenium.click("JobFunctionChooseButton");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitingTime(2000);
//				selenium.waitForElementToBeVisible("okToAddDuplicateCheckbox");
//				selenium.scrolldown(-300);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
//				selenium.waitForElementToBeClickable("okToAddDuplicateCheckbox");
//				selenium.jsClick("okToAddDuplicateCheckbox");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(8000);
				
//				if(selenium.isElementPresentFast("CancelButton"))
//				{
//					System.out.println("Add Contact popup did not close. So, clicking on Cancel button.");
//					selenium.jsClick("CancelButton");
//					selenium.test.log(LogStatus.FAIL, "Create New Contact Failed!");
//					selenium.reportFailure("Create New Contact Failed!");
//				}
		 }
		 catch (Exception e) {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error occurred " + e.getMessage());
				selenium.waitingTime(3000);
	            System.out.println("Error catch");
	            boolean  error=selenium.isElementPresentFast("ErrorListAll");    
	            System.out.println(error);
	            if(error==true) {
	                   System.out.println("Error came");
	                   selenium.jsClick("closePopUp");
	                   selenium.waitingTime(2000);            
	                   selenium.click("CancelButton");
	            }

	            else {
	                   selenium.click("CancelButton");
	            }			}
		 
		 

		 
	 }
	 
	 @Then("^Verify Account name and Support account$")
	    public void verify_account_name_and_support_account() {
		 try {
//			 selenium.refresh();
			 selenium.waitingTime(10000);
			 selenium.captureScreenShot();
//			 selenium.waitForElementToBeVisible("csomUserSupportAccountName");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeVisible("csomUserSupportAccountNameNew");
			 String supportaccountname = selenium.getTextLoop("csomUserSupportAccountNameNew");
			 selenium.waitingTime(2000);
			 String expected_supportname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Actual Account Name");
			 selenium.waitingTime(2000);
				System.out.println("support account name is" + supportaccountname + expected_supportname);
			String accountname = selenium.getTextLoop("scomUserAccountName");
				//String accountname = selenium.getText("accountNameCases").toString();
			 selenium.waitingTime(2000);
			 String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
			 selenium.waitingTime(2000);
				System.out.println("account name is" + accountname + expected_name);
				if ((accountname.equalsIgnoreCase(expected_name)) & (supportaccountname.equalsIgnoreCase(expected_supportname))) {
					selenium.test.log(LogStatus.PASS, "Account and support account verified successfully");
					System.out.println("PASS");
				}
				
				else
				{
					selenium.test.log(LogStatus.FAIL, "Account and support account name not proper " );
					selenium.reportFailure("Account and support account name not proper");
					System.out.println("FAIL");
				}
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.closeSubTabs();
				selenium.waitingTime(2000);
		 }
		 catch (Exception e) {
			 	selenium.captureScreenShot();
				selenium.reportFailure("Error while verifying account name and support account " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @When("^I search for CXG User contacts$")
	    public void i_search_for_cxg_user_contacts()  {
			try {
		        if (selenium.isElementPresentFast("loginPopUp"))
		        {
		        	System.out.println("I am inside loginPopup method");
		        	selenium.clickLoop("loginPopUp");
		        	selenium.waitingTime(2000);	
		        }
				
		    selenium.waitingTime(5000);
		    selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "New Contact");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactsOptionMenuDots");
			selenium.jsClick("contactsOptionMenuDots");
			selenium.waitingTime(3000);
			
		
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to contacts " + e.getMessage());
			}

	}
	 
	@Then("^navigate to MHES Product type case$")
    public void navigate_to_MHES_Product_type_case()  {
		try {
			//we need to create new MHES product type case here
			selenium.navigateToURL(MHESProductTypeCaseURL);
			selenium.waitingTime(8000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Error while navigating to MHES Product type case");
				selenium.reportFailure("Error while navigating to MHES Product type case " + e.getMessage());
			}
		}
	
	@Then("^navigate to NON MHES Product type case$")
    public void navigate_to_NON_MHES_Product_type_case()  {
		try {
			//we need to create new MHES product type case here
			selenium.navigateToURL(NONMHESProductTypeCaseURL);
			selenium.waitingTime(8000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Error while navigating to NON MHES Product type case");
				selenium.reportFailure("Error while navigating to NON MHES Product type case " + e.getMessage());
			}
		}
	
	@And("^validate the MHES Product picklist values$")
    public void validate_the_MHES_Product_picklist_values(DataTable table)  {
		try {
			List<String> data = table.transpose().asList(String.class);
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Case/500DY000001Tw2lYAC/view");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("MHESMarketSegmentEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MHESMarketSegmentEditBtn");
			selenium.click("MHESMarketSegmentEditBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("MHESMarketSegmentField");
			selenium.scrollToElement("MHESMarketSegmentField");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			
			 System.out.println("Choosen different MHESMarketSegment value1");
	    	 selenium.waitForElementToBeClickable("MHESMarketSegmentField");
	    	 selenium.jsClick("MHESMarketSegmentField");
	    	 selenium.waitingTime(2000);
	    	 selenium.clickDynamicData("spanTitle", data.get(0), "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("MHESProductField");
			 selenium.jsClick("MHESProductField");
			 selenium.waitingTime(2000);			 
			 String xpath1 = selenium.getDynamicXpath_data("spanTitle", data.get(1), "end");
			 String xpath2 = selenium.getDynamicXpath_data("spanTitle", data.get(2), "end");
			 if(selenium.isElementPresentXpathFast(xpath1) && selenium.isElementPresentXpathFast(xpath2))
			 {
				System.out.println("Verified picklist value successfully!");
			 }
			 else
			 {
				selenium.test.log(LogStatus.FAIL, "Picklist value is missing!");
				selenium.reportFailure("Picklist value is missing!");
				System.out.println("FAIL");
			 }
			 
			 System.out.println("Choosen different MHESMarketSegment value2");
	    	 selenium.waitForElementToBeClickable("MHESMarketSegmentField");
	    	 selenium.jsClick("MHESMarketSegmentField");
	    	 selenium.waitingTime(2000);
	    	 selenium.clickDynamicData("spanTitle", data.get(3), "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("MHESProductField");
			 selenium.jsClick("MHESProductField");
			 selenium.waitingTime(2000);
			 String xpath4 = selenium.getDynamicXpath_data("spanTitle", data.get(4), "end");
			 String xpath5 = selenium.getDynamicXpath_data("spanTitle", data.get(5), "end");
			 String xpath6 = selenium.getDynamicXpath_data("spanTitle", data.get(6), "end");
			 if(selenium.isElementPresentXpathFast(xpath4) && selenium.isElementPresentXpathFast(xpath5) && selenium.isElementPresentXpathFast(xpath6))
			 {
				System.out.println("Verified picklist value successfully!");
			 }
			 else
			 {
				selenium.test.log(LogStatus.FAIL, "Picklist value is missing!");
				selenium.reportFailure("Picklist value is missing!");
				System.out.println("FAIL");
			 }

			 System.out.println("Choosen different MHESMarketSegment value3");			 
	    	 selenium.waitForElementToBeClickable("MHESMarketSegmentField");
	    	 selenium.jsClick("MHESMarketSegmentField");
	    	 selenium.waitingTime(2000);
	    	 selenium.clickDynamicData("spanTitle", data.get(7), "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("MHESProductField");
			 selenium.jsClick("MHESProductField");
			 selenium.waitingTime(2000);
			 String xpath8 = selenium.getDynamicXpath_data("spanTitle", data.get(8), "end");
			 String xpath9 = selenium.getDynamicXpath_data("spanTitle", data.get(9), "end");
			 String xpath10 = selenium.getDynamicXpath_data("spanTitle", data.get(10), "end");
			 if(selenium.isElementPresentXpathFast(xpath8) && selenium.isElementPresentXpathFast(xpath9) && selenium.isElementPresentXpathFast(xpath10))
			 {
				System.out.println("Verified picklist value successfully!");
			 }
			 else
			 {
				selenium.test.log(LogStatus.FAIL, "Picklist value is missing!");
				selenium.reportFailure("Picklist value is missing!");
				System.out.println("FAIL");
			 }
			 
			 System.out.println("Choosen different MHESMarketSegment value4");
	    	 selenium.waitForElementToBeClickable("MHESMarketSegmentField");
	    	 selenium.jsClick("MHESMarketSegmentField");
	    	 selenium.waitingTime(2000);
	    	 selenium.clickDynamicData("spanTitle", data.get(11), "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("MHESProductField");
			 selenium.jsClick("MHESProductField");
			 selenium.waitingTime(2000);
			 String xpath12 = selenium.getDynamicXpath_data("spanTitle", data.get(12), "end");
			 String xpath13 = selenium.getDynamicXpath_data("spanTitle", data.get(13), "end");
			 if(selenium.isElementPresentXpathFast(xpath12) && selenium.isElementPresentXpathFast(xpath13))
			 {
				System.out.println("Verified picklist value successfully!");
			 }
			 else
			 {
				selenium.test.log(LogStatus.FAIL, "Picklist value is missing!");
				selenium.reportFailure("Picklist value is missing!");
				System.out.println("FAIL");
			 }
			 
			 System.out.println("The picklist values are verified successfully!");
			 selenium.test.log(LogStatus.PASS, "The picklist values are verified successfully!");
	        
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Error while validating MHES Product picklist values");
				selenium.reportFailure("Error while validating MHES Product picklist values " + e.getMessage());
			}
	}
	
	@And("^validate the MHES Product fields$")
    public void validate_the_MHES_Product_fields()  {
		try {
			if(!(selenium.isElementPresentFast("MHESMarketSegmentLabel") || selenium.isElementPresentFast("MHESMarketSegmentLabel")))
			{
				selenium.test.log(LogStatus.PASS, "The MHES Market Segment & MHES Product fields are not present for non MHES Product type case records!");
				System.out.println("PASS");
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Validation failed!");
				selenium.reportFailure("Validation failed!");
				System.out.println("FAIL");
			}
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Error while validating MHES Product picklist values");
				selenium.reportFailure("Error while validating MHES Product picklist values " + e.getMessage());
			}
	}
	 
	 @Then("^create a new contact for CXG user$")
	    public void create_a_new_contact_for_cxg_user() {
		 try {
			 selenium.waitForElementToBeClickable("NewButtonToAdd");
			 selenium.jsClick("NewButtonToAdd");
			 selenium.waitingTime(5000);
			 String firstName= selenium.getRandomString();
	            selenium.getElement("firstName").sendKeys(firstName);
	            selenium.waitingTime(2000);
	            
	            String lastName= selenium.getRandomString();
	            selenium.getElement("lastName").sendKeys(lastName);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactStatusDropdown");
				selenium.jsClick("contactStatusDropdown");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Contact Status", "end");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("searchAccounts");
				selenium.jsClick("searchAccounts");
				selenium.waitingTime(4000);
				selenium.type("searchAccounts", "Support Account");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("accountAutosuggestiveOption");
				selenium.jsClick("accountAutosuggestiveOption");
				selenium.waitingTime(2000);
				String email= selenium.getRandomString();
				 String address = "@mhedu.com";
				 String emailAddress = email+address;
		            selenium.getElement("emailCXG").sendKeys(emailAddress);
		            selenium.waitingTime(2000);
		        selenium.waitForElementToBeClickable("search_Departments");
				selenium.jsClick("search_Departments");
				selenium.autoSuggestiveDropdown("search_Departments","Department Name");
				selenium.waitingTime(3000);
		        selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitForElementToBeVisible("contactSuccessfulL");
				boolean contact= selenium.isElementPresentFast("contactSuccessfulL");
				System.out.println("success message" + contact);
				 if(contact == true) {
					 selenium.test.log(LogStatus.INFO, "Contact created successfully" );
				 }
				 
//					if(selenium.isElementPresentFast("CancelButton"))
//					{
//						System.out.println("Add Contact popup did not close. So, clicking on Cancel button.");
//						selenium.jsClick("CancelButton");
//						selenium.test.log(LogStatus.FAIL, "Create New Contact Failed!");
//						selenium.reportFailure("Create New Contact Failed!");
//					}
				
		 }
		 catch (Exception e) {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error occurred " + e.getMessage());
				selenium.waitingTime(3000);
	            System.out.println("Error catch");
	            
	             boolean duplicate = selenium.isElementPresentFast("DuplidateRecordValidation");
				 System.out.println(duplicate);
				 boolean  error=selenium.isElementPresentFast("ErrorListAll"); 
		         System.out.println(error);
				 if(duplicate==true) {
					 System.out.println("inside duplicate");
					 selenium.click("DuplidateRecordValidation");
					 selenium.waitingTime(3000);
					 selenium.click("openDuplicateContact");
					 selenium.waitingTime(3000);
					 selenium.test.log(LogStatus.INFO, "Duplicate Contact exists" );
				} 
				 
		            else if(error==true ) {
	                   System.out.println("Error came");
	                   selenium.jsClick("closePopUp");
	                   selenium.waitingTime(2000);            
	                   selenium.click("CancelButton");
	            }
		            else {
		            	System.out.println("inside Else");
		            	 selenium.click("CancelButton");
		            }
		 		}
		 
	 }
	 
	 @Then("^Verify Account name and Support account for CXG$")
	    public void verify_account_name_and_support_account_for_CXG() {
		 try {

			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeVisible("supportAccntNameGetText");
			 //String supportaccountname = selenium.getElement("supportAccountCases").getAttribute("innerHTML");
			 String supportaccountname = selenium.getTextLoop("supportAccntNameGetText").toString();
			 String expected_supportname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Actual Account name");
				System.out.println("support account name is" + supportaccountname);
				System.out.println("expected support account name is" + expected_supportname);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("accountNameCases");
//			 String accountname = selenium.getElement("accountNameCases").getAttribute("innerHTML");
				String accountname = selenium.getTextLoop("scomUserAccountName");
			 String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
				System.out.println("account name is" + accountname);
				System.out.println("expected account name is" + expected_name);
				if ((accountname.equalsIgnoreCase(expected_name)) & (supportaccountname.equalsIgnoreCase(expected_supportname))) {
					selenium.test.log(LogStatus.PASS, "Account and support account verified successfully");
					System.out.println("PASS");
				}
				
				else
				{
					selenium.test.log(LogStatus.FAIL, "Account and support account name not proper " );
					selenium.reportFailure("Account and support account name not proper");
					System.out.println("FAIL");
				}
				
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying account name and support account " + e.getMessage());
			}
	 }
	 
	 @Then("^change the order of case$")
	    public void change_the_order_of_case() {
		 
		 try {
			 	String Owner = "Sivasankaran Periyasamy";
				selenium.waitingTime(4000);
				selenium.click("moreActionsBtn");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("ChangeOwnerEditBtn");
				selenium.clickLoop("ChangeOwnerEditBtn");
				selenium.waitForElementToBeClickable("search_user");
				selenium.jsClick("search_user");
				selenium.waitingTime(2000);
				selenium.typeData("search_user", Owner);
				selenium.waitingTime(2000);
				selenium.clickDynamicData("divTitle", Owner, "end");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SubmitForm");
				selenium.jsClick("SubmitForm");
				
				
				boolean ownerChanged= selenium.isElementPresentFast("contactSuccessfulL");
				System.out.println("order transfer success" + ownerChanged);
				 if(ownerChanged == true) {
					 selenium.test.log(LogStatus.PASS, "Case transferred to new order" );
				 }
				 else {
					 selenium.test.log(LogStatus.FAIL, "Case did not transferred to new order" );
					 selenium.reportFailure("Case did not transferred to new order");
				 }
				 
				 if(selenium.isElementPresentFast("changeOwnerAlert")) {
					 selenium.click("CancelButton_Span");
					 selenium.waitingTime(3000); 
				 }
				
		 }
		 
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while changing order " + e.getMessage());
			}
	 }
	 
	 
	 @Then("^verify new order Case details$")
	    public void verify_new_order_Case_details() {
		 
		 try {
			 
			selenium.scrollToElement("caseOwnerName1");
			selenium.waitForElementToBeVisible("caseOwnerName1");
			String name = selenium.getElement("caseOwnerName1").getAttribute("innerHTML");
			String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Owner");
			System.out.println("actual and expected owner" + name +expected_name );
			boolean recordtype = selenium.isElementPresentFast("caseRecordType");
			boolean hours = selenium.isElementPresentFast("businessHours");
			System.out.println("record type and hours" + recordtype + hours);
			if((name.equalsIgnoreCase(expected_name)) & recordtype == true & hours == true) {
				System.out.println("inside pass");
					 selenium.test.log(LogStatus.PASS, "Case transferred to new order successfully" );
				 }
				 else {
					 System.out.println("inside fail");
					 selenium.test.log(LogStatus.FAIL, "Case transfer failed" );
					 selenium.reportFailure("Case transfer failed");
				 }
				
			selenium.captureScreenShot();
//			selenium.waitingTime(2000); 
		 }
		 
		 
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying new  order " + e.getMessage());
			}
	 }
	 
	 @Then("^I Quick search for the Case$")
	    public void i_quick_search_for_the_case() {
			try {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("quickFind");
			selenium.click("quickFind");
			selenium.waitingTime(2000);
			selenium.type("quickFind", "Search");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("caseAutoResponseRulesSearch");
			selenium.click("caseAutoResponseRulesSearch");
			
			
			
		}
			catch (Exception e) {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while quick search  " + e.getMessage());
			}
			
	}
		
		 @When("^I Click on email to case$")
		    public void i_click_on_email_to_case() {
			 try {
				 
				 selenium.switchToFrame("newAccountFrame");
//				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("caseAutoResponseRulesLink");
				 selenium.click("caseAutoResponseRulesLink");
				 
				 
				 
			 }
			 catch (Exception e) {
					selenium.switchOutOfFrame();
					selenium.reportFailure("Error while clicking on rules link  " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		 }
		 
		 @Then("^I verify ship to org$")
		    public void i_verify_ship_to_org() {
			 try  {
				 
				 selenium.waitingTime(2000);
				 selenium.refresh();
				 selenium.waitingTime(5000);
				 selenium.isElementPresentFast("ruleDetail");
				 selenium.isElementPresentFast("ruleEntries");
				 selenium.isElementPresentFast("ruleTable");
				 selenium.captureScreenShot();
				 selenium.switchOutOfFrame();
				 
				 
			 }
			 
			 catch (Exception e) {
				 selenium.switchOutOfFrame();
					selenium.reportFailure("Error while verifying rules   " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		 }
		 @Then("create a contact by Admin profile for CSOM Lightning Console")
		public void create_a_contact_by_admin_profile_for_csom_lightning_console(){
		try{
			selenium.randomString=selenium.getRandomString();
			String email=selenium.randomString+"@test.com";
			alternatateEmail = selenium.randomString+"@alterTest.com";
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.click("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DepartmentNameSelect");
			selenium.jsClick("DepartmentNameSelect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.typeData("EmailTextBox",email);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AlternateEmailTextBox");
			selenium.typeData("AlternateEmailTextBox",alternatateEmail);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("WebsiteName");
			selenium.typeData("WebsiteName","test.com");
//			selenium.scrollToElement("OkToAddDuplicateCheckBox");
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("OkToAddDuplicateCheckBox");
//			selenium.jsClick("OkToAddDuplicateCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.test.log(LogStatus.PASS, "Save Button clicked");
			selenium.waitingTime(20000);
			
			/*boolean duplicate = selenium.isElementPresentFast("okToAddDuplicate");
			if (duplicate == true) {
				selenium.test.log(LogStatus.INFO, "Navigated to Ok to Add Duplicate check box");
				selenium.click("okToAddDuplicate");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("OkToAddDuplicateCheckBox");
				selenium.jsClick("OkToAddDuplicateCheckBox");
				selenium.waitingTime(2000);
				selenium.test.log(LogStatus.INFO, "Duplicate Contact exists");
				if (selenium.isElementPresentFast("closeDuplicateWindowCard")) {
					selenium.waitForElementToBeClickable("closeDuplicateWindowCard");
					selenium.click("closeDuplicateWindowCard");
				}
				selenium.waitForElementToBeClickable("saveButton");
				selenium.jsClick("saveButton");
				selenium.waitingTime(8000);
			}*/

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("edit the email and verify alternate email")
	public void edit_the_email_and_verify_alternate_email(){
		try{
			selenium.randomString=selenium.getRandomString();
			newEmail=selenium.randomString+"@NewTest.com";
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("contactEdit");
			selenium.jsClick("contactEdit");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.typeData("EmailTextBox",newEmail);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("WebsiteName");
			selenium.typeData("WebsiteName","www.test123.com");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(15000);

//			selenium.waitForElementToBeVisible("VerifyEmailText");
//			String emailText=selenium.getText("VerifyEmailText").toString();
//			System.out.println(emailText);
			selenium.waitForElementToBeVisible("VerifyAlternateText1");
			String alternateEmailText=selenium.getText("VerifyAlternateText1").toString();
//			selenium.waitForElementToBeVisible("VerifyAlternateText");
//			String alternateEmailText=selenium.getText("VerifyAlternateText").toString();
			System.out.println(alternateEmailText);
			if(alternatateEmail.equalsIgnoreCase(alternateEmailText))
			{
				System.out.println("Alternate Email Not Changed");
				selenium.test.log(LogStatus.PASS,"Alternate Email Not Changed");
			}
			else
			{
				System.out.println("Alternate Email Also Changed");
				selenium.test.log(LogStatus.FAIL,"Alternate Email Also Changed");
				selenium.reportFailure("Alternate Email Also Changed");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("check the contact history for email")
	public void check_the_contact_history_for_email(){
		try{
			selenium.refresh();
			selenium.waitingTime(12000);
			if (selenium.isElementPresentFast("showAllLinks")) {
				selenium.waitForElementToBeClickable("showAllLinks");
				selenium.click("showAllLinks");
			}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ContactHistory");
			selenium.jsClick("ContactHistory");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("VerifyContactHistoryNewValue");
			String contactHistory=selenium.getText("VerifyContactHistoryNewValue").toString();
			System.out.println(contactHistory);
			if(contactHistory.equalsIgnoreCase(newEmail))
			{
				System.out.println("Email is present in contact history");
				selenium.test.log(LogStatus.PASS,"Email is present in contact history");
			}
			else
			{
				System.out.println("Email is present in contact history");
				selenium.test.log(LogStatus.FAIL,"Email is present in contact history");
				selenium.reportFailure("Email is present in contact history");
			}
			
			selenium.closeSubTabs();
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("verify the edit feature")
	public void verify_the_edit_feature(){
		try{
			System.out.println("Testing");
			String oppName="UNIV OF PITTSBURGH PITTS Plant Science Billy Wayne Coakley";
			selenium.waitForElementToBeClickable("SearchTextBoxClassicMode");
			selenium.typeData("SearchTextBoxClassicMode",oppName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchBtnClassicMode");
			selenium.jsClick("SearchBtnClassicMode");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("SelectFirstOppContact");
			selenium.jsClick("SelectFirstOppContact");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("OppContactEditBtn");
			if(selenium.isElementPresentFast("OppContactEditBtn"))
			{
				System.out.println("Editing is enable");
				selenium.test.log(LogStatus.PASS,"Editing is enable");
			}
			else
			{
				System.out.println("Editing is not enable");
				selenium.test.log(LogStatus.FAIL,"Editing is not enable");
				selenium.reportFailure("Editing is not enable");
			}
		}catch (Exception e) {
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
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I open contact in classic and verify contact name and account name")
	public void i_open_contact_in_classic_and_verify_contact_name_and_account_name(){
		try{
			selenium.waitForElementToBeClickable("SearchTextBoxClassicMode");
			selenium.typeData("SearchTextBoxClassicMode","Darryl Stafford");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchBtnClassicMode");
			selenium.jsClick("SearchBtnClassicMode");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("ContactClassicMode");
			selenium.jsClick("ContactClassicMode");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("CasesQuickLinkClassicMode");
			selenium.jsClick("CasesQuickLinkClassicMode");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewCaseBtnClassicMode");
			selenium.jsClick("NewCaseBtnClassicMode");
			selenium.waitingTime(6000);
			Select dropdown = new Select(selenium.getElement("departmentAddressC"));
			dropdown.selectByIndex(5);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("continue");
			selenium.jsClick("continue");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("AccountNameGetText");
			String accountName=selenium.getAttribute("AccountNameGetText").toString();
			System.out.println(accountName);
			selenium.waitForElementToBeVisible("ContactNameGetText");
			String contactName=selenium.getAttribute("ContactNameGetText").toString();
			System.out.println(contactName);
			if(accountName.equalsIgnoreCase("Kent Denver School")&&contactName.equalsIgnoreCase("Mr. Darryl Stafford"))
			{
				System.out.println("PASS!!!!!Account Name and Contact Name Field has autopopulated value");
				selenium.test.log(LogStatus.PASS,"Account Name and Contact Name Field has autopopulated value");
			}
		else
			{
				System.out.println("FAIL!!!!Account Name and Contact Name Field has not any value");
				selenium.test.log(LogStatus.FAIL,"Account Name and Contact Name Field has not any value");
				selenium.reportFailure("Account Name and Contact Name Field has not any value");
			}

		}catch (Exception e) {
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
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I verify the auto populated contact name and account name")
	public void i_verify_the_auto_populated_contact_and_account_name(){
		try{
			String randomString=selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", randomString);
			selenium.waitingTime(2000);
			String accountName="STANFORD UNIVERSITY";
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", accountName);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(25000);

			selenium.waitForElementToBeClickable("CasesQuickLink");
			selenium.jsClick("CasesQuickLink");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewActionButton");
			selenium.jsClick("NewActionButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("A3KSmartyAntsRadioBtn");
			selenium.jsClick("A3KSmartyAntsRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("VerifyAccountNameField");
			String getAccountName=selenium.getAttribute("VerifyAccountNameField").toString();
			System.out.println(getAccountName);
			selenium.waitForElementToBeVisible("VerifyContactNameField");
			String contactName=selenium.getAttribute("VerifyContactNameField").toString();
			System.out.println(contactName);
			if(accountName.equalsIgnoreCase(getAccountName)&&randomString.equalsIgnoreCase(contactName))
			{
				System.out.println("PASS!!! Account Name and Contact Name are Auto Populating");
				selenium.test.log(LogStatus.PASS,"Account Name and Contact Name are Auto Populating");
			}
			else
			{
				System.out.println("FAIL!!! Account Name and Contact Name are Not Auto Populating");
				selenium.test.log(LogStatus.FAIL,"FAIL!!! Account Name and Contact Name are Not Auto Populating");
				selenium.reportFailure("FAIL!!! Account Name and Contact Name are Not Auto Populating");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	
	@Then("I create a contact for SEG User")
	public void i_create_a_contact_for_SEG_user(){
		try{
			selenium.randomString=selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "Palo Alto University");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountNameNew");
			selenium.jsClick("SelectAccountNameNew");
			selenium.waitingTime(5000);
			selenium.scrollToElement("JobFunctionChooseButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("JobFunctionOptionNew");
			selenium.jsClick("JobFunctionOptionNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("JobFunctionChooseButton");
			selenium.click("JobFunctionChooseButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(25000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	
	@Then("create opportunity with same account name as of contact")
	public void create_opportunity_with_same_account_name_as_of_contact(){
		try{
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			if(selenium.getTestCaseName().equalsIgnoreCase("ConfirmProfileAccess")||selenium.getTestCaseName().equalsIgnoreCase("ConfirmDAGNewFieldValidation"))
			{
				selenium.waitForElementToBeClickable("OpptyDAGNewCheckBox");
				selenium.jsClick("OpptyDAGNewCheckBox");
			}
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			String accountName="Palo Alto University";
			if(selenium.getTestCaseName().contains("ConfirmProfileAccess"))
			{
				selenium.waitForElementToBeClickable("opp_accName");
				selenium.click("opp_accName");
				selenium.waitingTime(1000);
				selenium.typeData("opp_accName","Lawton Public School");
				
			} else if (selenium.getTestCaseName().equalsIgnoreCase("ConfirmDAGNewFieldValidation"))
			{
				selenium.waitForElementToBeClickable("opp_accName");
				selenium.click("opp_accName");
				selenium.waitingTime(1000);
				selenium.typeData("opp_accName","LESLEY UNIVERSITY");
			} else
			{
				selenium.waitForElementToBeClickable("opp_accName");
				selenium.click("opp_accName");
				selenium.waitingTime(1000);
				selenium.typeData("opp_accName",accountName);
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DateLink");
			selenium.jsClick("DateLink");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.jsClick("DefaultPurchaseDate");
			selenium.waitingTime(2000);
			String Amount="200";
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(14);
			selenium.typeData("OppAmount", Amount);
			selenium.waitingTime(2000);
			if(selenium.getTestCaseName().equalsIgnoreCase("ConfirmDAGNewFieldValidation"))
			{
				System.out.println(selenium.getTestCaseName());
			}
			else if(selenium.getTestCaseName().equalsIgnoreCase("ConfirmProfileAccess"))
			{
				selenium.waitForElementToBeClickable("OppOwner");
				selenium.typeData("OppOwner","Stefanie Vogel");
				selenium.waitingTime(2000);
			}
			else
			{
				selenium.waitForElementToBeClickable("OppOwner");
				selenium.typeData("OppOwner","Jaime Klar");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(10000);
			if(selenium.getTestCaseName().equalsIgnoreCase("ConfirmDAGNewFieldValidation"))
			{
				System.out.println(selenium.getTestCaseName());
			}
			else
			{
				if(selenium.isElementPresentFast("OpptySaveBtn"))
				{
					selenium.waitForElementToBeClickable("OpptySaveBtn");
					selenium.jsClick("OpptySaveBtn");
				}
			}
			selenium.waitingTime(10000);
			selenium.task=selenium.getURL();
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I go to opportunity contact and add a contact")
	public void i_go_to_opportunity_contact_and_add_a_contact(){
		try{
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("OppContactNameSearchField");
			selenium.typeData("OppContactNameSearchField", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("taggedProductISBNSearch");
			selenium.jsClick("taggedProductISBNSearch");
			selenium.waitingTime(3000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsFirstCheckBox");
			selenium.jsClick("ObjectsFirstCheckBox");
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsSecondCheckBox");
			selenium.jsClick("ObjectsSecondCheckBox");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(20000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "Contact added to opportunity successfully!");
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I go to contact and verify the added opportunity")
	public void i_go_to_contact_and_verify_the_added_opportunity(){
		try{
			selenium.waitForElementToBeClickable("FirstContactRecord");
			selenium.jsClick("FirstContactRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OpptyContact");
			selenium.jsClick("OpptyContact");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("VerifyOpp");
			if(selenium.isElementPresentFast("VerifyOpp"))
			{
				System.out.println("Opportunity Contact is present");
				selenium.test.log(LogStatus.PASS,"Opportunity Contact is present");
				selenium.url=selenium.getURL();
			}
			else
			{
				System.out.println("Opportunity Contact is not present");
				selenium.test.log(LogStatus.FAIL,"Opportunity Contact is not present");
				selenium.reportFailure("Opportunity Contact is not present");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I delete the contact and verify the added opportunity")
	public void i_delete_the_contact_and_verify_the_added_opportunity(){
		try{
			selenium.waitForElementToBeClickable("VerifySideBtn");
			selenium.jsClick("VerifySideBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.jsClick("DeleteRecord");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.jsClick("deleteBtn");
			selenium.waitingTime(8000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("DeletePageMsg");
			if(selenium.isElementPresentsuperFast("DeletePageMsg"))
			{
				System.out.println("PASS!!! Opportunity Contact is not present");
				selenium.test.log(LogStatus.PASS,"Opportunity Contact is not present");
			}
			else
			{
				System.out.println("FAIL!!!Opportunity Contact is present");
				selenium.test.log(LogStatus.FAIL,"Opportunity Contact is present");
				selenium.reportFailure("Opportunity Contact is present");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I verify the opportunity record")
	public void i_verify_the_opportunity_record(){
		try{
			selenium.waitForElementToBeClickable("OpportunityClick01");
			selenium.jsClick("OpportunityClick01");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityOwnerGetText");
			String opportunityOwner=selenium.getText("opportunityOwnerGetText").toString();
			System.out.println(opportunityOwner);
			if(opportunityOwner.equalsIgnoreCase("Jaime Klar"))
			{
				System.out.println("PASS!!! Opportunity Record is present");
				selenium.test.log(LogStatus.PASS,"Opportunity Record is present");
			}
				else
			{
				System.out.println("FAIL!!!Opportunity Record is not present");
				selenium.test.log(LogStatus.FAIL,"Opportunity Record is not present");
				selenium.reportFailure("Opportunity Record is not present");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("create a new contact")
	public void create_a_new_contact(){
		try{
			selenium.randomString=selenium.getRandomString();
			String email=selenium.randomString+"@test.com";
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.click("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(2000);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DepartmentNameSelect");
			selenium.jsClick("DepartmentNameSelect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.typeData("EmailTextBox",email);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.type_propertiesFile("serach_Account","account_name4");
			selenium.waitingTime(5000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("serach_Account");
//			selenium.waitForElementToBeClickable("ShowAllResults1");
//			selenium.jsClick("ShowAllResults1");
//			selenium.waitingTime(5000);
//			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyContactStatusFieldForMHEAdmin"))
//			{
//				selenium.waitForElementToBeClickable("ContactAccountNameTextBox");
//				selenium.jsClick("ContactAccountNameTextBox");
//			}
//			else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyContactCreationForINTLWitoutValidation") || selenium.getTestCaseName().equalsIgnoreCase("VerifyOppContactAfterDeleteByINTLUser"))
//			{
//				selenium.waitForElementToBeClickable("ContactAccountNameSelect4");
//				selenium.clickLoop("ContactAccountNameSelect4");
//			}
//			else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyContactHistoryForINTL"))
//			{
//				selenium.waitForElementToBeClickable("ContactAccountNameSelect3");
//				selenium.jsClick("ContactAccountNameSelect3");
//			} else
//			{
//				selenium.waitForElementToBeClickable("SelectOxfordCollegeAccountName");
//				selenium.jsClick("SelectOxfordCollegeAccountName");
//			}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(25000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I add new opportunity from opportunity contact related list quick links")
	public void i_add_new_opp_from_opp_contact_related_list_quick_links(){
		try{
			selenium.url=selenium.getURL();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OpptyContactLink");
			selenium.jsClick("OpptyContactLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("AddNewOpptyBtn");
			selenium.jsClick("AddNewOpptyBtn");
			selenium.waitingTime(20000);
			selenium.switchToMultipleFrame("opportunitiesFrame1");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("MHECourseOppty");
			selenium.selectFromLookUp_propertiesFile("MHE Course Lookup","MHECourseName");
			selenium.waitingTime(2000);
			selenium.switchToMultipleFrame("opportunitiesFrame1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyEnrollment");
			selenium.typeData("OpptyEnrollment","12");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("OpptyStageDropDown");
			Select dropDown1=new Select(selenium.getElement("OpptyStageDropDown"));
			dropDown1.selectByIndex(1);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("OpptyTypeDropDown");
			Select dropDown2=new Select(selenium.getElement("OpptyTypeDropDown"));
			dropDown2.selectByIndex(1);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("OpptyRouteToMarketDropDown");
			Select dropDown3=new Select(selenium.getElement("OpptyRouteToMarketDropDown"));
			dropDown3.selectByIndex(1);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DateLink");
			selenium.jsClick("DateLink");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.jsClick("DefaultPurchaseDate");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.click("OpptySaveBtn");
			selenium.waitingTime(20000);
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I delete the created contact")
	public void i_delete_the_created_contact(){
		try{
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.jsClick("DeleteActionBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.jsClick("deleteBtn");
			selenium.waitingTime(8000);
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I try to open the deleted contact")
	public void i_try_to_open_the_deleted_contact(){
		try{
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("DeletePageMsg");
			if(selenium.isElementPresentsuperFast("DeletePageMsg"))
			{
				System.out.println("PASS!!! Opportunity Contact is not present");
				selenium.test.log(LogStatus.PASS,"Opportunity Contact is not present");
			}
			else
			{
				System.out.println("FAIL!!!Opportunity Contact is present");
				selenium.test.log(LogStatus.FAIL,"Opportunity Contact is present");
				selenium.reportFailure("Opportunity Contact is present");
			}

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I open the created opportunity contact and verify contact status field")
	public void i_open_the_created_opp_contact_and_verify_contact_status_field(){
		try{
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			String contactStatus=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatus);
			if(contactStatus.equalsIgnoreCase("Active"))
			{
				System.out.println("PASS!!! Contact Status is Active");
				selenium.test.log(LogStatus.PASS,"Contact Status is Active");
			}
			else
			{
				System.out.println("FAIL!!! Contact Status is not Active");
				selenium.test.log(LogStatus.FAIL,"Contact Status is not Active");
				selenium.reportFailure("Contact Status is not Active");
			}
			selenium.waitingTime(2000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			String contactStatusFromContactRecord=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatusFromContactRecord);
			if(contactStatus.equalsIgnoreCase(contactStatusFromContactRecord))
			{
				System.out.println("PASS!!! Both the contact status are same");
				selenium.test.log(LogStatus.PASS,"Both the contact status are same");
			}
			else
			{
				System.out.println("FAIL!!! Both the contact status are not same");
				selenium.test.log(LogStatus.FAIL,"Both the contact status are not same");
				selenium.reportFailure("Both the contact status are not same");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditContactBtn");
			selenium.jsClick("EditContactBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OpptyContactStausDropDown");
			selenium.jsClick("OpptyContactStausDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactStausOption");
			selenium.jsClick("OpptyContactStausOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			contactStatusFromContactRecord=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatusFromContactRecord);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactLink");
			selenium.jsClick("OpptyContactLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			contactStatus=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatus);
			if(contactStatus.equalsIgnoreCase(contactStatusFromContactRecord))
			{
				System.out.println("PASS!!! Both the contact status are same");
				selenium.test.log(LogStatus.PASS,"Both the contact status are same");
			}
			else
			{
				System.out.println("FAIL!!! Both the contact status are not same");
				selenium.test.log(LogStatus.FAIL,"Both the contact status are not same");
				selenium.reportFailure("Both the contact status are not same");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("verify the contact record is editable or not")
	public void verify_the_contact_record_is_editable_or_not(){
		try{
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("contactEdit");
			selenium.jsClick("contactEdit");
			selenium.waitingTime(20000);

			selenium.waitForElementToBeVisible("Save_Btn");
			if(selenium.isElementPresentFast("Save_Btn"))
			{
				System.out.println("PASS!!! Contact Record is editable");
				selenium.test.log(LogStatus.PASS,"Contact Record is editable");
				selenium.jsClick("Save_Btn");
			}
			else
			{
				System.out.println("FAIL!!! Contact Record is not editable");
				selenium.test.log(LogStatus.FAIL,"Contact Record is not editable");
				selenium.reportFailure("Contact Record is not editable");
			}
			selenium.waitingTime(8000);
			selenium.scrollToElement("EditContactBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditContactBtn");
			selenium.jsClick("EditContactBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactStausDropDown");
			selenium.jsClick("OpptyContactStausDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactInactiveOption");
			selenium.jsClick("ContactInactiveOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("InactiveReasonField");
			selenium.jsClick("InactiveReasonField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("InactiveReasonOptionNew");
			if(selenium.isElementPresentFast("InactiveReasonOptionNew"))
			{
				System.out.println("PASS!!! Option is present");
				selenium.test.log(LogStatus.PASS,"Option is present");
			}
			else
			{
				System.out.println("FAIL!!! Option is not present");
				selenium.test.log(LogStatus.FAIL,"Option is not present");
				selenium.reportFailure("Option is not present");
			}

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("verify the external contact name can be update or not")
	public void verify_the_external_contact_name_can_be_update_or_not(){
		try{
			String app_Name="Contact External";
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.typeData("searchItemsTextField", app_Name);
			selenium.waitingTime(4000);
//				selenium.waitForElementToBeClickable("MHHEApplaunch");
			selenium.clickDynamicData("ApplaunchStart",app_Name ,"ApplaunchEnd");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAListViewDropDown");
			selenium.jsClick("SelectAListViewDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SelectAllContactOption");
			selenium.jsClick("SelectAllContactOption");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("ExternalContactNameFirstRecord");
			selenium.jsClick("ExternalContactNameFirstRecord");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("VerifyContactName");
			String contactNameBeforeEdit=selenium.getText("VerifyContactName").toString();
			System.out.println(contactNameBeforeEdit);
			selenium.waitForElementToBeClickable("EditBtnContact");
			selenium.jsClick("EditBtnContact");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CrossBtn");
	//		String contactNameAfterEdit=selenium.getText("VerifyContactName").toString();
	//		System.out.println(contactNameAfterEdit);
			if(selenium.isElementPresentFast("CrossBtn"))
			{
				System.out.println("PASS!!! Contact Field is Editable");
				selenium.test.log(LogStatus.PASS,"Contact Field is Editable");
			}
			else
			{
				System.out.println("FAIL!!! Contact Field not Editable");
				selenium.test.log(LogStatus.FAIL,"Contact Field not Editable");
				selenium.reportFailure("Contact Field not Editable");
			}

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I verify the Exclude from MKTO SFDC Sync field")
	public void i_verify_the_exclude_form_mkto_sfdc_sync_field(){
		try{
			selenium.waitingTime(2000);
			selenium.scrollToElement("VerifyMKTOField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("VerifyMKTOField");
			if(selenium.isElementPresentFast("VerifyMKTOField"))
			{
				System.out.println("PASS!!! Exclude from MKTO SFDC Sync Field is present");
				selenium.test.log(LogStatus.PASS,"Exclude from MKTO SFDC Sync Field is present");
			}
			else
			{
				System.out.println("FAIL!!! Exclude from MKTO SFDC Sync Field is not present");
				selenium.test.log(LogStatus.FAIL,"Exclude from MKTO SFDC Sync Field is not Updated");
				selenium.reportFailure("Exclude from MKTO SFDC Sync Field is not Updated");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I verify the Exclude from MKTO SFDC Sync field in classic mode")
	public void i_verify_the_exclude_from_mkto_sfdc_sync_field_in_classic_mode() {
		try {
			selenium.waitForElementToBeClickable("SearchTextBoxClassicMode");
			selenium.typeData("SearchTextBoxClassicMode", "bonjour-contacts-pro");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchBtnClassicMode");
			selenium.jsClick("SearchBtnClassicMode");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ClickContactClassicMode");
			selenium.jsClick("ClickContactClassicMode");
			selenium.waitingTime(5000);
			selenium.scrollToElement("VerifyMKTOFieldClassic");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("VerifyMKTOFieldClassic");
			if (selenium.isElementPresentFast("VerifyMKTOFieldClassic")) {
				System.out.println("PASS!!! Exclude from MKTO SFDC Sync Field is present");
				selenium.test.log(LogStatus.PASS, "Exclude from MKTO SFDC Sync Field is present");
			} else {
				System.out.println("FAIL!!! Exclude from MKTO SFDC Sync Field is not present");
				selenium.test.log(LogStatus.FAIL, "Exclude from MKTO SFDC Sync Field is not Updated");
				selenium.reportFailure("Exclude from MKTO SFDC Sync Field is not Updated");
			}

		} catch (Exception e) {
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
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
		@Then("I verify the Exclude from MKTO SFDC Sync field in classic")
		public void i_verify_the_exclude_from_mkto_sfdc_sync_field_in_classic(){
			try{
				selenium.waitForElementToBeClickable("SearchTextBoxClassicMode");
				selenium.typeData("SearchTextBoxClassicMode","Stephanie Aamodt");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SearchBtnClassicMode");
				selenium.jsClick("SearchBtnClassicMode");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("SelectContactClassicMode");
				selenium.jsClick("SelectContactClassicMode");
				selenium.waitingTime(8000);
				selenium.scrollToElement("VerifyMKTOFieldClassic");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("VerifyMKTOFieldClassic");
				if(selenium.isElementPresentFast("VerifyMKTOFieldClassic"))
				{
					System.out.println("PASS!!! Exclude from MKTO SFDC Sync Field is present");
					selenium.test.log(LogStatus.PASS,"Exclude from MKTO SFDC Sync Field is present");
				}
				else
				{
					System.out.println("FAIL!!! Exclude from MKTO SFDC Sync Field is not present");
					selenium.test.log(LogStatus.FAIL,"Exclude from MKTO SFDC Sync Field is not Updated");
					selenium.reportFailure("Exclude from MKTO SFDC Sync Field is not Updated");
				}
			}catch (Exception e) {
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
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Test Case Failed" + e.getMessage());
			}
	}
	@Then("I verify Rostering fields are not editable for CSOM")
	public void i_verify_Rostering_fields_are_not_editable_for_CSOM(){
		try{
			selenium.navigateToURL(selenium.task);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("editAdditonaInfoBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertFalse(selenium.isElementPresentsuperFast("TechAccessSSOInUseTextBox")&&selenium.isElementPresentsuperFast("TechDSATextBox")&&
					selenium.isElementPresentsuperFast("TechRequestedRostering")&&selenium.isElementPresentsuperFast("ImplStartDateTextBox")&&
					selenium.isElementPresentsuperFast("ImplScope")&&selenium.isElementPresentsuperFast("ImplSuccessMetrics"));

				System.out.println("PASS!!! ALL Fields are present & not editable");
				selenium.test.log(LogStatus.PASS,"ALL Fields are present & not editable");

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
}
