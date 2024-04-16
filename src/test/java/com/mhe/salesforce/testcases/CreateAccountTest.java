package com.mhe.salesforce.testcases;

import java.util.List;
import java.util.Map;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountTest {

	WebConnector selenium = WebConnector.getInstance();
	private String testCaseName = "CreateAccountTest";
	public String AccountURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwVPOAA2/view";

	@When("^I go to account creation screen$")
	public void i_go_to_account_address_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("new");
			selenium.click("new");
			selenium.test.log(LogStatus.INFO, "Accounts screen loaded successfully!");
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//				selenium.waitingTime(2000);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("new");
			selenium.click("new");
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I click on the INTL accounts tab$")
	public void I_click_on_the_accounts_tab() {
		try {
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(2000);
		selenium.type("searchItemsTextField", "New Account");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("accountTabOption");
		selenium.click("accountTabOption");

		// selenium.clickHeader(objectRepoElement);
		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I click sales Ref user Accounts$")
	public void I_click_sales_Ref_user_Accounts_tab() throws InterruptedException {
		try {

		// selenium.waitingTime(7000);
		// selenium.click("accountTabClick");

		// selenium.clickHeader(objectRepoElement);

//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Account");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountTabOptionsClick");
		// selenium.click("accountTabOptionsClick");
		selenium.jsClick("accountTabOptionsClick");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountsNameClick");
		selenium.jsClick("accountsNameClick");

		// selenium.clickHeader(objectRepoElement);
		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I click sales Ref user Accounts MHHE$")
	public void I_click_sales_Ref_user_Accounts_tab_MHHE() throws InterruptedException {
		try {

		// selenium.waitingTime(7000);
		// selenium.click("accountTabClick");

		// selenium.clickHeader(objectRepoElement);

//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Account");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountTabOptionsClick");
		// selenium.click("accountTabOptionsClick");
		selenium.jsClick("accountTabOptionsClick");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountsNameClick2");
		selenium.jsClick("accountsNameClick2");

		// selenium.clickHeader(objectRepoElement);
		selenium.waitingTime(4000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I click sales Ref user Accounts to Proceed$")
	public void I_click_sales_Ref_user_Accounts_to_Proceed() throws InterruptedException {
		try {

		// selenium.waitingTime(7000);
		// selenium.click("accountTabClick");

		// selenium.clickHeader(objectRepoElement);

		selenium.waitingTime(5000);
		if (selenium.isElementPresentFast("CXGApp"))
		{
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.getElement("searchItemsTextField").sendKeys("Sales");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Saleslightningapp");
			selenium.jsClick("Saleslightningapp");
			selenium.waitingTime(4000);
		}
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Account");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountTabOptionsClick");
		// selenium.click("accountTabOptionsClick");
		selenium.jsClick("accountTabOptionsClick");
		selenium.waitingTime(7000);		

		// selenium.clickHeader(objectRepoElement);
//		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I click sales Ref user Accounts Marketing$")
	public void I_click_sales_Ref_user_Accounts_tab_Marketing() throws InterruptedException {
		try {

		// selenium.waitingTime(7000);
		// selenium.click("accountTabClick");

		// selenium.clickHeader(objectRepoElement);

//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Account");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountTabOptionsClick");
		// selenium.click("accountTabOptionsClick");
		selenium.jsClick("accountTabOptionsClick");
		selenium.waitingTime(5000);
		/*selenium.searchGlobal("ValueTo Search In GlobalSearch");
		selenium.waitingTime(12000);
		String Xpath = selenium.getDynamicXpath("anchorTitle", "ValueTo Search In GlobalSearch", "end");
		selenium.clickLoopXpath(Xpath);*/
		String opp = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SalesRepURL");
		selenium.navigateToURL(opp);
		selenium.waitingTime(8000);
//		selenium.jsClick("accountsToclickforValidation");
		
		// selenium.clickHeader(objectRepoElement);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	
	@When("^I click sales Ref user details to navigate$")
	public void I_click_sales_Re_user_details_to_navigate() throws InterruptedException {
		try {
		
		//selenium.waitingTime(7000);
		//selenium.click("accountTabClick");			
		//selenium.clickHeader(objectRepoElement);
		
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Opportunities");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("OpportunityClick");
		selenium.jsClick("OpportunityClick");
		selenium.waitingTime(3000);
//		selenium.jsClick("OpportunityAccountClick");	
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		
	}
	@When("^I click sales Ref user details to navigate Marketing$")
	public void I_click_sales_Re_user_details_to_navigate_Marketing() throws InterruptedException {
		try {
	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Opportunities");
		selenium.waitForElementToBeClickable("OpportunityClick");
		selenium.jsClick("OpportunityClick");
		selenium.waitingTime(3000);	
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		
	}
	
	@When("^I click sales Ref user details to navigate Sales$")
	public void I_click_sales_Re_user_details_to_navigate_Sales() throws InterruptedException {
		try {
	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type_propertiesFile("searchItemsTextField", "New_Opportunity");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("OpportunityClick");
		selenium.jsClick("OpportunityClick");
		selenium.waitingTime(6000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		
	}
	

	@When("^I click sales Ref user Opportunity$")
	public void I_click_sales_Ref_user_Opportunity() throws InterruptedException {
		try {
		// selenium.waitingTime(7000);
		// selenium.click("accountTabClick");

		// selenium.clickHeader(objectRepoElement);

//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Account");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountTabOptionsClick");
		// selenium.click("accountTabOptionsClick");
		selenium.jsClick("accountTabOptionsClick");
		selenium.waitingTime(5000);
		selenium.search("ValueTo Search In GlobalSearch");
		selenium.waitingTime(2000);
		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "ValueTo Search In GlobalSearch", "endContains");
		System.out.println(Xpath);
		selenium.waitingTime(4000);
//		selenium.waitForXpathElementToBeClickable(Xpath);
		selenium.clickLoopXpath(Xpath);
//		selenium.jsClick("accountsNameClickMarketingUser2");

		// selenium.clickHeader(objectRepoElement);
		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I click sales Ref user Accounts MHHE Terrotories linked account$")
	public void I_click_sales_Ref_user_Accounts_tab_MHHE_Terrotories_linked_account() throws InterruptedException {
		try {
		// selenium.waitingTime(7000);
		// selenium.click("accountTabClick");

		// selenium.clickHeader(objectRepoElement);

//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Account");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountTabOptionsClick");
		// selenium.click("accountTabOptionsClick");
		selenium.jsClick("accountTabOptionsClick");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("accountsTerritoriesLinkedAccounts");
		selenium.jsClick("accountsTerritoriesLinkedAccounts");

		// selenium.clickHeader(objectRepoElement);
		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Account Name click and proceed validate$")
	public void Account_Name_click_and_proceed() {
		try {
		if (selenium.getUI().contains("Lightning")) {		
			
			selenium.waitingTime(6000);
//			selenium.search("Accounts Name dynamic Value");
//			selenium.waitingTime(2000);
//			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Accounts Name dynamic Value", "endContains");
//  			System.out.println(Xpath);
//  			selenium.waitingTime(4000);
//            selenium.clickLoopXpath(Xpath);  
			selenium.navigateToURL(AccountURL);
			selenium.waitingTime(6000);
      		selenium.waitForElementToBeClickable("accountContacts1");
			selenium.jsClick("accountContacts1");
      		selenium.waitForElementToBeClickable("objectFilterBtn");
			selenium.jsClick("objectFilterBtn");
      		selenium.waitForElementToBeVisible("contactFiltervalueInput");
			selenium.type("contactFiltervalueInput", "First Name");
      		selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(5000);
			String Xpath1 = selenium.getDynamicXpath("anchorTitlecontains", "First Name", "endContains");
			selenium.waitingTime(4000);
            selenium.clickLoopXpath(Xpath1); 
            selenium.waitingTime(8000);
            selenium.test.log(LogStatus.PASS, "is present");
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^Account Name click proceed and contacts Edit contact$")
	public void Account_Name_click_proceed_and_contacts_Edit_contact() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			// selenium.waitForElementToBeVisible("newAccountFrame");
			// selenium.switchToFrame("newAccountFrame");

			// selenium.waitingTime(3000);
			// selenium.jsClick("accountsNameClick");
			
			selenium.waitingTime(6000);
   	        selenium.search("Account Name");
   		    selenium.waitingTime(7000);
   		    String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
			System.out.println(Xpath);
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeClickable(Xpath);
   		    selenium.clickLoopXpath(Xpath);              		
//     	    selenium.waitingTime(5000);

			
//			selenium.waitingTime(3000);
      		selenium.waitForElementToBeClickable("accountContacts");
			selenium.jsClick("accountContacts");
//			selenium.waitingTime(3000);
      		selenium.waitForElementToBeClickable("objectFilterBtn");
			selenium.jsClick("objectFilterBtn");
//			selenium.waitingTime(2000);
      		selenium.waitForElementToBeVisible("contactFiltervalueInput1");
			selenium.type("contactFiltervalueInput1", "First Name");
//			selenium.waitingTime(2000);
      		selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(9000);
			boolean table = selenium.isElementPresentFast("searchFields");
			if (table == true) {

				selenium.test.log(LogStatus.INFO, "is present");
			}
      		selenium.waitForElementToBeClickable("contactsViewResultClick3");
			selenium.click("contactsViewResultClick3");
			selenium.waitingTime(5000);
      		selenium.waitForElementToBeClickable("contactEdit");
			selenium.clickLoop("contactEdit");
			selenium.waitingTime(3000);
      		selenium.waitForElementToBeClickable("contactStatusDropdown");
			selenium.jsClick("contactStatusDropdown");
			selenium.clickDynamic("spanTitle", "Contact Status", "end");
			selenium.waitingTime(2000);
      		selenium.waitForElementToBeVisible("accountContactInactivereason");
			selenium.scrollToElement("accountContactInactivereason");
			selenium.click("accountContactInactivereason");
			selenium.clickDynamic("spanTitle", "Inactive reason", "end");
			selenium.waitingTime(2000);
      		selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
//			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("contactSuccessfulL");
			boolean contact= selenium.isElementPresentFast("contactSuccessfulL");
			System.out.println("success message" + contact);
			
			 if(contact == true) {
				 selenium.test.log(LogStatus.PASS, "Contact edited successfully" );
			 }	
			 
			 else {
				 selenium.test.log(LogStatus.FAIL, "Test case failed" );
			 	 selenium.reportFailure("Test Case Failed");
				 selenium.captureScreenShot();
				 System.out.println("FAIL");
			 }

		}
		}
		
		 catch (Exception e) {
				 selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				 selenium.reportFailure("Test Case Failed");
			 	selenium.waitingTime(3000);
	            System.out.println("Error catch");
	            
				 boolean  error=selenium.isElementPresentFast("ErrorListAll"); 
		         System.out.println(error);
				 if(error==true ) {
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

	@And("^Account Name click proceed and contacts Edit contact from pending to Active Inactive$")
	public void Account_Name_click_proceed_and_contacts_Edit_contact_contact_from_pending_to_Active_Inactive() {
		
		try{
		if (selenium.getUI().contains("Lightning")) {
      		selenium.waitForElementToBeClickable("editButton");
			selenium.clickLoop("editButton");
			selenium.waitingTime(6000);
      		selenium.waitForElementToBeClickable("ContactStatusField");
			selenium.click("ContactStatusField");
			selenium.clickDynamic("spanTitle", "Contact Status", "end");
			selenium.waitingTime(2000);
      		selenium.waitForElementToBeVisible("accountContactInactivereason");
			selenium.scrollToElement("accountContactInactivereason");
			selenium.click("accountContactInactivereason");
			selenium.clickDynamic("spanTitle", "Inactive reason", "end");
			selenium.waitingTime(2000);
      		selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(10000);
			/*selenium.waitForElementToBeVisible("contactSuccessfulL");
			boolean contact= selenium.isElementPresentFast("contactSuccessfulL");
			System.out.println("success message" + contact);
			
			 if(contact == true) {
				 selenium.test.log(LogStatus.PASS, "Contact edited successfully" );
			 }	
			 
			 else
			 {
				 selenium.test.log(LogStatus.FAIL, "Test case failed" );
				 selenium.reportFailure("Test Case Failed");
				 selenium.click("CancelButton");
			 }*/
			 
			 
			 /*Activate the contact back*/
//				selenium.waitingTime(10000);
	      		selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
				selenium.waitingTime(3000);
	      		selenium.waitForElementToBeClickable("ContactStatusField");
				selenium.jsClick("ContactStatusField");
				selenium.waitingTime(2000);
				selenium.clickDynamicData("spanTitle", "Active", "end");
				selenium.waitingTime(2000);
	      		selenium.waitForElementToBeClickable("saveButton");
				selenium.click("saveButton");
				selenium.waitingTime(10000);			 
		}		

		} catch(Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			
			selenium.waitingTime(3000);
            System.out.println("Error catch");
            boolean      error=selenium.isElementPresentFast("ErrorListAll");     
            System.out.println(error);
            if(error==true) {
                   System.out.println("Error came");
                   
                   selenium.jsClick("closePopUp");
                   selenium.waitingTime(2000);             
                   selenium.click("CancelButton");
            }
            
            else {
                   selenium.click("CancelButton");
            }
			
		}
	}

	@And("^Account Name click proceed view Address$")
	public void Account_Name_click_proceed_view_Address() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			selenium.waitingTime(6000);
//            selenium.search("Accounts Name dynamic Value");
//            selenium.waitingTime(2000);
//            String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Accounts Name dynamic Value", "endContains");
//			System.out.println(Xpath);
//			selenium.waitingTime(4000);
//            selenium.clickLoopXpath(Xpath);
			selenium.navigateToURL(AccountURL);
			selenium.waitingTime(6000);
      		selenium.waitForElementToBeClickable("accountsAddress1");
			selenium.jsClick("accountsAddress1");
      		selenium.waitForElementToBeClickable("objectFilterBtn");
			selenium.jsClick("objectFilterBtn");
      		selenium.waitForElementToBeVisible("addressFiltervalueInput");
			selenium.type("addressFiltervalueInput", "Address details");
      		selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(5000);
			
			String Xpath1 = selenium.getDynamicXpath("anchorTitlecontains", "Address details", "endContains");
			selenium.waitingTime(4000);
            selenium.clickLoopXpath(Xpath1); 
            selenium.waitingTime(5000);
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

	@And("^Account Name click proceed view Territories$")
	public void Account_Name_click_proceed_view_Territories()
	{
		try
			{
				if (selenium.getUI().contains("Lightning"))
					{
						// selenium.waitForElementToBeVisible("newAccountFrame");
						// selenium.switchToFrame("newAccountFrame");
			
						// selenium.waitingTime(3000);
						// selenium.jsClick("accountsTerritoriesLinkedAccounts");
						
//						    selenium.search("Accounts Name dynamic Value");
//				            selenium.waitingTime(2000);
//				            String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Accounts Name dynamic Value", "endContains");
//							System.out.println(Xpath);
//							selenium.waitingTime(4000);
//			//				selenium.waitForXpathElementToBeClickable(Xpath);
//				            selenium.clickLoopXpath(Xpath);                      
			//	            selenium.waitingTime(5000);
						
			//			selenium.waitingTime(3000);
				      	selenium.waitForElementToBeClickable("accountsTerritoriesLink1");
						selenium.jsClick("accountsTerritoriesLink1");
			//			selenium.waitingTime(3000);
				      	selenium.waitForElementToBeClickable("objectFilterBtn");
						selenium.jsClick("objectFilterBtn");
			//			selenium.waitingTime(2000);
				      	selenium.waitForElementToBeVisible("accountTerritoriesInput");
						selenium.type("accountTerritoriesInput", "Territories");
			//			selenium.waitingTime(2000);
				      	selenium.waitForElementToBeClickable("Save_Button");
						selenium.jsClick("Save_Button");
						selenium.waitingTime(5000);			 
				
						boolean table = selenium.isElementPresentFast("accountTerritoriesSearch");
						if (table == true) 
							{
								selenium.test.log(LogStatus.INFO, "is present");
								System.out.println("PASS");
							}
						// selenium.click("Save_Button");
					}
			}
		
		 catch (Exception e)
			{
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while viewing territories " + e.getMessage());
			}

	}

	@And("^Account Name click proceed view Address MHHE$")
	public void Account_Name_click_proceed_view_Address_MHHE() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			// selenium.waitForElementToBeVisible("newAccountFrame");
			// selenium.switchToFrame("newAccountFrame");

			// selenium.waitingTime(3000);
			// selenium.jsClick("accountsNameClick");
			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeClickable("accountAddressMHHE1");
			selenium.jsClick("accountAddressMHHE1");
//			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeClickable("objectFilterBtn");
			selenium.jsClick("objectFilterBtn");
//			selenium.waitingTime(2000);
	      	selenium.waitForElementToBeVisible("addressFiltervalueInput");
			selenium.type("addressFiltervalueInput", "Address details");
//			selenium.waitingTime(2000);
	      	selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(9000);
			boolean table = selenium.isElementPresentFast("searchFields");
			if (table == true) {

				selenium.test.log(LogStatus.INFO, "is present");
			}

			// selenium.click("Save_Button");

		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

	@And("^Account Name click proceed new Address MHHE$")
	public void Account_Name_click_proceed_new_Address_MHHE() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwVEHAA2/view");
     	    selenium.waitingTime(8000);
	      	selenium.waitForElementToBeClickable("accountAddressMHHE1");
			selenium.jsClick("accountAddressMHHE1");
			selenium.waitingTime(3000);
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

	@And("^Account Name click proceed Contact Update$")
	public void Account_Name_click_proceed_Contact_Update() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			// selenium.waitForElementToBeVisible("newAccountFrame");
			// selenium.switchToFrame("newAccountFrame");

//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("accountsNameClick");
			selenium.jsClick("accountsNameClick");
//			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeVisible("accountUpdateContactNew");
			selenium.type("accountUpdateContactNew", "Contact Update");
			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(5000);

			/*
			 * selenium.waitingTime(3000); selenium.jsClick("objectFilterBtn");
			 * selenium.waitingTime(2000); selenium.type("addressFiltervalueInput",
			 * "Address details"); selenium.waitingTime(2000); selenium.jsClick("Save_Button");
			 * selenium.waitingTime(9000); boolean
			 * table=selenium.isElementPresentFast("searchFields"); if(table==true) {
			 * 
			 * selenium.test.log(LogStatus.INFO, "is present"); }
			 * 
			 * // selenium.click("Save_Button");
			 */

		}
		}catch(Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
			selenium.waitingTime(3000);
            System.out.println("Error catch");
            boolean error=selenium.isElementPresentFast("ErrorListAll");     
            System.out.println(error);
            if(error==true) {
                   System.out.println("Error came");                   
                   selenium.jsClick("closePopUp");
                   selenium.waitingTime(2000);             
                   selenium.click("CancelButton");
            }
            
            else {
                   selenium.click("CancelButton");
            }
            }

			
			
		}
	
		


	
	@And("^Account Name click proceed Opportunity check$")
	public void Account_Name_click_proceed_Opportunity_check() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			// selenium.waitForElementToBeVisible("newAccountFrame");
			// selenium.switchToFrame("newAccountFrame");

//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("accountsNameClick");
			selenium.jsClick("accountsNameClick");
//			selenium.waitingTime(4000);
	      	selenium.waitForElementToBeClickable("NewAccountOpportunityBtnClick1");
			selenium.jsClick("NewAccountOpportunityBtnClick1");
//			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeClickable("objectFilterBtn");
			selenium.jsClick("objectFilterBtn");
//			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeVisible("accountOpportunityInput");
			selenium.type("accountOpportunityInput", "Opportunity Name Input");
//			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(3000);
			boolean table = selenium.isElementPresentFast("searchFields");
			if (table == true) {

				selenium.test.log(LogStatus.INFO, "is present");
			}

		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^Account Name click proceed Opportunity check and Create$")
	public void Account_Name_click_proceed_Opportunity_check_and_Create() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			// selenium.waitForElementToBeVisible("newAccountFrame");
			// selenium.switchToFrame("newAccountFrame");

//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("accountsNameClick");
			selenium.jsClick("accountsNameClick");
//			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeClickable("accountOpportunity");
			selenium.jsClick("accountOpportunity");
			/*
			 * selenium.waitingTime(3000); selenium.jsClick("objectFilterBtn");
			 * selenium.waitingTime(3000); selenium.type("accountOpportunityInput",
			 * "Opportunity Name Input"); selenium.waitingTime(3000);
			 * selenium.jsClick("Save_Button"); selenium.waitingTime(3000); boolean
			 * table=selenium.isElementPresentFast("searchFields"); if(table==true) {
			 * 
			 * selenium.test.log(LogStatus.INFO, "is present"); }
			 */

		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}

	}

	@And("^Account Name click proceed and Coverage$")
	public void Account_Name_click_proceed_and_Coverage() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			// selenium.waitForElementToBeVisible("newAccountFrame");
			// selenium.switchToFrame("newAccountFrame");

//			selenium.waitingTime(3000);
			// selenium.jsClick("accountsNameClick");
			selenium.waitingTime(3000);
	      	selenium.waitForElementToBeVisible("accountCoverage");
			selenium.scrollToElement("accountCoverage");
			boolean value2 = selenium.isElementPresentFast("accountCoverage");
			boolean value = selenium.isElementPresentFast("accountCoverageName1");
			boolean value1 = selenium.isElementPresentFast("accountCoveragecareerSalesRep1");
			System.out.println("value-->" + value + "value1-->" + value1 + "value2-->" + value2);
					
			if (value == true & value1 == true & value2 == true) {
				
				System.out.println("Value is True");

				selenium.test.log(LogStatus.INFO, "is present");
			}else {
				
				System.out.println("Value is false");
				
			}

		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}

	}

	@And("^I validate the Account Name$")
	public void i_validate_the_account_name() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");

			// selenium.waitingTime(5000);
			// selenium.jsClick("accountsNameClick");
		}

		/*
		 * if (selenium.getValueByColumnName("Dynamic").equalsIgnoreCase("Y")) { String
		 * accname = selenium.getRandomString();
		 * selenium.typeRandomstring("accountName", accname); }
		 * 
		 * else { selenium.type("accountName", "Account Name");
		 * selenium.test.log(LogStatus.INFO, "Entering the account name as: " +
		 * "Account Name");
		 * 
		 * }
		 */

		selenium.typeRandomstring("newaccountName", WebConnector.ACC_NAME_RANDOM);
		selenium.test.log(LogStatus.INFO, "Entering the account name as: " + WebConnector.ACC_NAME_RANDOM);

		selenium.test.log(LogStatus.INFO, "Searching the account name");
		selenium.pressEnter("newaccountName");
		selenium.setImplicitWait(15);
		if (selenium.isElementPresentFast("accountNotPresent")) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Account already exists");
		} else {
			selenium.click("createNewAccount");
			selenium.waitingTime(2000);

		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}

	}

	@When("^I fill in the following$")
	public void I_fill_in_the_accountDetails(DataTable accountData) {
		try {
			List<Map<String, String>> accountDataList = accountData.asMaps(String.class, String.class);

			for (int count = 0; count <= 5; count++) {
				selenium.type(accountDataList.get(count).get("locator"),
						accountDataList.get(count).get("Excel Column Name"));
			}

			selenium.selectDropdownText(accountDataList.get(6).get("locator"),
					accountDataList.get(6).get("Excel Column Name"));

			selenium.selectCheckbox(accountDataList.get(7).get("locator"), testCaseName);

			selenium.type(accountDataList.get(8).get("locator"), accountDataList.get(8).get("Excel Column Name"));
			selenium.type(accountDataList.get(9).get("locator"), accountDataList.get(9).get("Excel Column Name"));
			for (int i = 10; i <= 14; i++) {
				selenium.selectDropdownText(accountDataList.get(i).get("locator"),
						accountDataList.get(i).get("Excel Column Name"));
			}

			selenium.type(accountDataList.get(15).get("locator"), accountDataList.get(15).get("Excel Column Name"));

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Error while filling up the account details");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^Accounts Contacts and validate$")

	public void i_add_contact_on_Account_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			// selenium.waitForElementsToBeVisible("NewContactOpportunityL");
//			selenium.waitingTime(8000);
	      	selenium.waitForElementToBeClickable("accContacts");
			// selenium.jsClickXpath("//*[contains(@title,'Opportunity
			// Contacts')][contains(@class,'rlql-label')]");
			selenium.click("accContacts");
			// selenium.clickLoop("NewContactOpportunityL");
			selenium.waitingTime(5000);
			// selenium.isCheck("Viewall");
			// selenium.click("addContactL");

		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Account creation will be successful if the desired page is displayed \"([^\"]*)\"$")
	public void verify(String verificationelement) {
		boolean result = false;

		if (selenium.getUI().contains("Lightning")) {
			selenium.switchOutOfFrame();
			result = selenium.isElementPresentFast(verificationelement);

		} else if (selenium.getUI().contains("Classic")) {

			result = selenium.isElementPresentFast("accountCreationMsg_C");
		}
		if (!result)
			selenium.reportFailure("Success message could not be verified");
		else {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			selenium.waitingTime(1000);
			selenium.captureScreenShot();
		}

	}

	@Then("^required fields error message will displayed$")
	public void verifyAccountRequiredFields() {
		String result = null;
		String expected_error = null;
		if (selenium.getUI().contains("Lightning")) {
			// selenium.switchOutOfFrame();
			expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
			result = selenium.getText("MessageText");

		} else if (selenium.getUI().contains("Classic")) {

			result = selenium.getText("accountCreationMsg_C");
		}
		if (result.contains(expected_error))
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I enter Account name$")
	public void enterAccountName() {
		try {
		selenium.waitForElementToBeVisible("newAccountFrame");
		selenium.switchToFrame("newAccountFrame");
		selenium.type("newaccountName", "Account Name");
		selenium.test.log(LogStatus.INFO, "Entering the account name ");

		selenium.test.log(LogStatus.INFO, "Searching the account name");
		selenium.pressEnter("newaccountName");
		selenium.setImplicitWait(15);
		if (selenium.isElementPresentFast("accountNotPresent")) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Account already exists");
		} else {
			selenium.waitForElementToBeClickable("createNewAccount");
			selenium.click("createNewAccount");
			selenium.waitingTime(2000);
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I enter MHE salesrep$")
	public void enterMHEsalesrep() {
		selenium.selectFromSalesrepLookUp("MHE Sales Rep Lookup (New Window)", "MHE salesrep");
		// selenium.type("MHEsalesrepaccount", "MHE salesrep");
	}

	@Then("^Oracle account number shoul get update$")
	public void accountNumber() {
		try {
		selenium.waitingTime(4000);
		String AccountID = selenium.getText("AccountID");
		String OracleaccountNumber = selenium.getText("Oracleaccountnumber");
		if (OracleaccountNumber.equalsIgnoreCase(AccountID)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		} else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	
	@And("^Change app launcher to Field Service$")
	public void Change_app_launcher_to_Field_Service() {
		try {
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.getElement("searchItemsTextField").sendKeys("Field Service");
			selenium.waitForElementToBeClickable("FSApp");
			selenium.jsClick("FSApp");
			selenium.waitingTime(4000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^navigate to Dispatch Console page$")
	public void navigate_to_Dispatch_Console_page() {
		try {
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.getElement("searchItemsTextField").sendKeys("Field Service");
			selenium.waitForElementToBeClickable("FieldServiceModule");
			selenium.jsClick("FieldServiceModule");
			selenium.waitingTime(4000);
			selenium.takeScreenShot();
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
}
