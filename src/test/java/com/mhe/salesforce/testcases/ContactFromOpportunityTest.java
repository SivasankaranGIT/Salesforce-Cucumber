package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContactFromOpportunityTest {
	WebConnector selenium = WebConnector.getInstance();
	String contatname = null;
	String contactURL = null;
	String LastName = null;
//	public String OppEidtMark="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FUI4GAAX/view";
//	public String OppEdit="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FUI4GAAX/view";

//	@And("^I open new contact from opportunity page$")
//	public void I_open_new_contact_from_opportunity_page() {
//		try {
//		if (selenium.getUI().contains("Lightning")) {
//			//selenium.click("newContact");
//			selenium.waitForElementToBeClickable("opportunityContact");
//			selenium.click("opportunityContact");
//			selenium.waitForElementToBeClickable("addContactL");
//			selenium.click("addContactL");
//			selenium.switchToFrame("productframeUat");
//			selenium.waitForElementToBeClickable("newContactL");
//			selenium.click("newContactL");
//			selenium.switchOutOfFrame();
//		} else {
//			selenium.scrollToElement("addContact");
//			selenium.waitForElementToBeClickable("addContact");
//			selenium.click("addContact");
//			selenium.waitForElementToBeClickable("contactC");
//			selenium.click("contactC");
//		}
//		}
//		catch (Exception e)
//		{
//			selenium.reportFailure("Error occurred " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//		}
//	}
	
	@And("^I Add Edit contact from opportunity page$")
	public void I_AddEdit_Contact_from_opportunity_page() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			
			selenium.waitingTime(6000);
   	        selenium.search("Opportunity Name dynamic Value");
   		    selenium.waitingTime(2000);
   		    String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value", "endContains");
//   		    selenium.waitForXpathElementToBeClickable(Xpath);
     	    selenium.waitingTime(5000);
   		    selenium.clickLoopXpath(Xpath);              		
//     	    selenium.waitingTime(5000);
   		    selenium.waitForElementToBeClickable("OpportunityContactClick1");			
			
			selenium.jsClick("OpportunityContactClick1");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(3000);
			
//			selenium.switchToFrame("opportunitiesFrameOneNew");	
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			//select check box
			selenium.waitForElementToBeClickable("OpportunitiesValueSelections1");
			selenium.jsClick("OpportunitiesValueSelections1");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("opportunitiesRemove");
			selenium.jsClick("opportunitiesRemove");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("SearchInputValue");
			selenium.type("SearchInputValue", "Last Name search");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			//select check box 
			selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
		    selenium.jsClick("opportunitiesSearchResultForAdding");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.scrollToElement("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("Button_Save");
			selenium.scrollToElement("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.switchOutOfFrame();			
			selenium.waitingTime(18000);
			selenium.test.log(LogStatus.INFO, "Contact added to opportunity successfully!");
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^create new contact$")
	public void create_new_contact () {
		try {
			selenium.randomString=selenium.getRandomString();
			LastName = selenium.randomString;
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
			selenium.typeData("lastName", LastName);
			selenium.waitingTime(2000);

			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.typeData("EmailTextBox",email);
			selenium.waitingTime(2000);
			
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "AUSTRALIAN TERTIARY ACADEMY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.clickLoop("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(15000);
		}
		catch(Exception e){
			selenium.reportFailure("Error while creating new contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I Add contact \"([^\"]*)\" from opportunity page$")
	public void I_Add_Contact_from_opportunity_page(String lastName) {
		try
		{
		if (selenium.getUI().contains("Lightning"))
			{				
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("OpportunityContactClick1");				
				selenium.jsClick("OpportunityContactClick1");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("OppAddContactBtn");
				selenium.jsClick("OppAddContactBtn");
				selenium.waitingTime(3000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(3000);
				selenium.click("clearButton");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("OpportunitiesLastNameSearchField");
				selenium.typeData("OpportunitiesLastNameSearchField", lastName);
				selenium.waitForElementToBeClickable("searchContactsOnNewSample");
				selenium.jsClick("searchContactsOnNewSample");
				selenium.waitingTime(3000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("FirstOppContactCheckbox");
			    selenium.jsClick("FirstOppContactCheckbox");
				selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
				selenium.jsClick("opportunitiesAddToOpportunity");
				selenium.waitingTime(2000);
				selenium.switchOutOfFrame();			
				selenium.waitingTime(15000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.test.log(LogStatus.INFO, "Contact added to opportunity successfully!");
			}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^I Add contact from MHHE opportunity page$")
	public void I_Add_Contact_from_MHHE_opportunity_page() {
		try
		{		
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("OpportunityContactClick1");	
				selenium.scrollToElement("OpportunityContactClick1");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.jsClick("OpportunityContactClick1");
				selenium.waitForElementToBeClickable("productAddOrEdit");
				selenium.jsClick("productAddOrEdit");
				selenium.waitingTime(3000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("MHHEOpportunitiesFirstNameSearchField");
				selenium.type("MHHEOpportunitiesFirstNameSearchField", "First Name search");
				selenium.type("OppContactNameSearchField", "Last Name search");
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.jsClick("searchBtn");
				//select check box 
				selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
			    selenium.jsClick("opportunitiesSearchResultForAdding");
				selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
				selenium.scrollToElement("opportunitiesAddToOpportunity");
				selenium.jsClick("opportunitiesAddToOpportunity");
				selenium.waitForElementToBeVisible("Button_Save");
				selenium.scrollToElement("Button_Save");
				selenium.jsClick("Button_Save");
				selenium.switchOutOfFrame();			
				selenium.waitingTime(18000);
				selenium.test.log(LogStatus.INFO, "Contact added to opportunity successfully!");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^update the opportunity year to past year$")
	public void update_the_opportunity_year() {
		try
		{
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditOppYear");
			selenium.jsClick("EditOppYear");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OppYearField");
			selenium.jsClick("OppYearField");
			selenium.waitForElementToBeClickable("OppYearValuePast");
			selenium.click("OppYearValuePast");
			selenium.waitingTime(2000);
			selenium.scrollToElement("OppTermField");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppTermField");
			selenium.click("OppTermField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppTermValueSpring");
			selenium.click("OppTermValueSpring");
			selenium.waitingTime(4000);
			selenium.click("Save_Btn");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.INFO, "Opp Year Updated Successfully!");
			System.out.println("Opp Year Updated Successfully!");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while updating opp year " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while updating opp year");
		}
	}

	@And("^I Add product from opportunity page$")
	public void I_Add_Product_from_opportunity_page() {
		try
		{
			String ISBN_PrintType = "9781265213367";
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitForElementToBeClickable("addProductBtn");
			selenium.click("addProductBtn");
			selenium.test.log(LogStatus.INFO, "Add Products screen loaded successfully!");
			selenium.waitingTime(8000);
			selenium.switchToFrame("productframeUat");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductCourse");
			selenium.clearText("ProductCourse");
			selenium.waitForElementToBeClickable("Isbn13");
//			selenium.type("author", "Author Name");
			selenium.typeData("Isbn13", ISBN_PrintType);
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(15000);
//			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
			selenium.waitForElementToBeClickable("FirstOppContactCheckbox");
			selenium.click("FirstOppContactCheckbox");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");	
//			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.INFO, "Product added to opportunity successfully!");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Verify Error message is not triggered$")
	public void Verify_Error_message_is_not_triggered() {
		try {
			selenium.waitForElementToBeVisible("actualStage1");
			String actualStage2 = selenium.getText("actualStage1");
			String ISBN_PrintType = "9781265213367";
			selenium.scrolldown(-600);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Add_Product1");
			selenium.click("Add_Product1");
			selenium.test.log(LogStatus.INFO, "Add Products screen loaded successfully!");
			selenium.waitingTime(8000);
			selenium.switchToFrame("productframeUat");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductCourse");
			selenium.clearText("ProductCourse");
			selenium.waitingTime(2000);
			selenium.click("clearButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Isbn13");
//			selenium.type("author", "Author Name");
			selenium.typeData("Isbn13", ISBN_PrintType);
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(15000);
//			selenium.clickDynamic("spantextContains","Product Name", "productnamedynamic");
			selenium.waitForElementToBeClickable("FirstOppContactCheckbox");
			selenium.click("FirstOppContactCheckbox");
			selenium.waitForElementToBeClickable("Addtoopportunity");
			selenium.click("Addtoopportunity");
//			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.INFO, "Product added to opportunity successfully!");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Stage");
			selenium.jsClick("Edit_Stage");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitingTime(2000);
			selenium.jsClick("Opp_Stage1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);

			if (selenium.isElementPresentFast("RecordSaveButton")) {
				selenium.reportFailure("Error message still occurred");
				selenium.test.log(LogStatus.FAIL, "Error message still occurred");
				selenium.waitForElementToBeClickable("CancelButton");
				selenium.click("CancelButton");
			}
			selenium.waitingTime(6000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@And("^I Add Edit contact from opportunity page marketing$")
	public void I_AddEdit_Contact_from_opportunity_page_marketing() {
		try {
		if (selenium.getUI().contains("Lightning")) {
			//selenium.click("newContact");
/*			selenium.waitingTime(3000);
			selenium.type("ContactNameInputSearchNewOpportunity", "Opportunities Search Name");
			selenium.waitingTime(2000);
			selenium.click("ContactNameInputSearchNewRefresh");
			selenium.waitingTime(4000);
	//		selenium.type("opportunitiesSearch", "Opportunities Search Name");
	//		selenium.waitingTime(3000);
			//Enter */
			
			selenium.waitingTime(6000);
   	        selenium.search("Opportunity Name dynamic Value");
   	     	selenium.waitingTime(2000);
   	     	String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value", "endContains");
     		selenium.clickLoopXpath(Xpath);              		
//     	    selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");

//			selenium.jsClick("opportunitiesResultsClickMarketing");
//			selenium.waitingTime(3000);
			selenium.jsClick("OpportunityContactClick1");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("opportunitiesFrame1");
			selenium.switchToFrame("opportunitiesFrame1");			
			selenium.waitingTime(3000);
			//select check box
			selenium.waitForElementToBeClickable("OpportunitiesValueSelections1");
			selenium.jsClick("OpportunitiesValueSelections1");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("opportunitiesRemove");	
			selenium.jsClick("opportunitiesRemove");
//			selenium.waitingTime(3000);
			selenium.waitForElementsToBeVisible("SearchInputValue");
			selenium.type("SearchInputValue", "Last Name search");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			//select check box 
			selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding1");
		    selenium.jsClick("opportunitiesSearchResultForAdding1");
//			selenium.waitingTime(5000);
			selenium.waitForElementsToBeVisible("opportunitiesAddToOpportunity");
			selenium.scrollToElement("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
//			selenium.waitingTime(3000);
			selenium.waitForElementsToBeVisible("Button_Save");
			selenium.scrollToElement("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.switchOutOfFrame();
			
			selenium.waitingTime(18000);
			
		}
			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@And("^deactivate the opportunity contact$")
	public void deactivate_the_opportunity_contact()
	{
		try
		{
//			selenium.refresh();
//			selenium.waitingTime(8000);
//			if(selenium.isElementPresentFast("contactsOpportunityLink1"))
//			{
//			selenium.waitForElementToBeClickable("contactsOpportunityLink1");
//			selenium.click("contactsOpportunityLink1");
//			}
//			else
//			{
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("OpportunityContactClick1");	
				selenium.scrollToElement("OpportunityContactClick1");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.jsClick("OpportunityContactClick1");
//			}
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			if(selenium.getTestCaseName().equalsIgnoreCase("ValidateInActiveMHHEOppContact") || selenium.getTestCaseName().equalsIgnoreCase("ValidateInActiveMHESOppContact"))
			{
				selenium.waitForElementToBeClickable("OppContactNameLink");
//				contatname = selenium.getText("OppContactNameLink").toString();
				contatname = selenium.getElement("OppContactNameLink").getAttribute("title");
				System.out.println("The contact name is :" + contatname);
				selenium.click("OppContactNameLink");
			}
			else
			{
				selenium.waitForElementToBeClickable("OppContactNameLink");
//				contatname = selenium.getText("OppContactNameLink").toString();
				contatname = selenium.getElement("OppContactNameLink").getAttribute("title");
				System.out.println("The contact name is ::" + contatname);
				selenium.click("OppContactNameLink");
			}
//selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002KrmiVAAR/view");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			contactURL = selenium.getURL();
			//contactURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002Zjo2RAAR/view";
			System.out.println("The contact url is :" + contactURL);
			selenium.test.log(LogStatus.INFO, "Navigated from Opp contact page to Contact page");
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitingTime(8000);
			selenium.scrollToElement("ContactStatusField");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactStatusField");
			selenium.click("ContactStatusField");
			selenium.waitForElementToBeClickable("ContactInactiveOption");
			selenium.click("ContactInactiveOption");
			selenium.waitForElementToBeClickable("InactiveReasonField");
			selenium.click("InactiveReasonField");
			selenium.waitForElementToBeClickable("InactiveReasonOption");
			selenium.click("InactiveReasonOption");
			selenium.waitingTime(2000);
			
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(5000);
			
			if (selenium.isElementPresentFast("closeBtn")) {
				System.out.println("Inside closeBtn.");
				selenium.click2("closeBtn");
				selenium.waitingTime(2000);
			}
			
				if(selenium.isElementPresentFast("DeptNameMissingMsg"))
				{
					System.out.println("scrolling to department name field..");
					selenium.waitForElementToBeClickable("search_Departments");
					selenium.scrollToElement("search_Departments");
					selenium.waitingTime(2000);
					selenium.scrolldown(-200);
					selenium.waitingTime(2000);
					selenium.click("search_Departments");
					selenium.typeData("search_Departments", "CHEMISTRY");
					selenium.waitingTime(8000);
					selenium.autoSuggestiveDropdownWithoutTextTwo("search_Departments");
//					selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
//					selenium.clickLoop("showAllResultsFromDropDwn");
//					selenium.waitingTime(6000);
//					String deptsearch = selenium.getDynamicXpath("searchDepartment", "Department Name", "end");
//					selenium.waitingTime(4000);
//					selenium.clickLoopXpath(deptsearch);
					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("Save_Btn");
					selenium.click("Save_Btn");
					selenium.waitingTime(4000);
				}
				
				if(selenium.isElementPresentFast("ContactTypeMissingMsg"))
				{
					System.out.println("scrolling to contact type field..");
					selenium.scrollToElement("contactTypeBtnNew");
					selenium.waitingTime(2000);
					selenium.scrolldown(-200);
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("contactTypeBtnNew");
					selenium.click("contactTypeBtnNew");
					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("OppContactTypeValue");
					selenium.click("OppContactTypeValue");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("Save_Btn");
					selenium.click("Save_Btn");
					selenium.waitingTime(4000);
				}
			
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.INFO, "Deactivated a contact which is already linked to an opportunity.");
		}
		catch (Exception e)
		{
			selenium.click("CancelButton");
			selenium.reportFailure("Error while deactivating the opportunity contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while deactivating the opportunity contact");
		}
	}
	
	@And("^verify that the opportunity contact record got deleted or not$")
	public void verify_opportunity_contact_record_delete()
	{
		try
		{
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.scrollToElement("OpportunityContactClick1");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			System.out.println("The contact name is :" + contatname);
			String Xpath = selenium.getDynamicXpathData("anchorTitle", contatname,
					"end");
			System.out.println("The xpath is : " + Xpath);
			if(!selenium.isElementPresentXpathFast(Xpath))
			{
				selenium.test.log(LogStatus.PASS, "The deactivated contact disappeared/deleted from opp contact page successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "The deactivated contact did not disappear/delete from opp contact page");
				selenium.reportFailure("The deactivated contact did not disappear/delete from opp contact page");
				System.out.println("FAIL");
			}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifying the opportunity contact record " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying the opportunity contact record");
		}
	}

	@And("^verify that the opportunity contact record is present or not$")
	public void verify_opportunity_contact_record_present()
	{
		try
		{
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(5000);
			System.out.println("The contact name is :" + contatname);
			String Xpath = selenium.getDynamicXpathData("anchorTitle", contatname,
					"end");
			System.out.println("The xpath is : " + Xpath);
			if(selenium.isElementPresentXpathFast(Xpath))
			{
				selenium.test.log(LogStatus.PASS, "The deactivated contact is present in opp contact page!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "The deactivated contact is NOT present in opp contact page");
				selenium.reportFailure("The deactivated contact is NOT present in opp contact page");
				System.out.println("FAIL");
			}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifying the opportunity contact record " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying the opportunity contact record");
		}
	}

	@And("^activate the contact back$")
	public void activate_the_contact_back()
	{
		try
		{
			selenium.navigateToURL(contactURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitingTime(8000);
			selenium.scrollToElement("ContactStatusField");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.click("closeBtn");
				selenium.waitingTime(2000);
			}
			
			selenium.waitForElementToBeClickable("ContactStatusField");
			selenium.click("ContactStatusField");
			selenium.waitForElementToBeClickable("ContactActiveOption");
			selenium.click("ContactActiveOption");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.INFO, "Activated back the contact which is already linked to an opportunity.");			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while activating back the contact record " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while activating back the contact record");
		}
	}

	@And("^add the account back to contact$")
	public void add_the_account_back_to_contact()
	{
		try
		{
			selenium.navigateToURL(contactURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("serach_Account");
			selenium.type("serach_Account", "Account Name");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.click("showAllResultsFromDropDwn");
			selenium.waitingTime(6000);
			String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name",
					"end");
			selenium.waitingTime(2000);
			selenium.clickLoopXpath(accountsearch);		
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.INFO, "Added back the account to contact.");	
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while adding back the account for contact record " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding back the account for contact record");
		}
	}

	@And("^I clone INTL opportunity using clone option$")
	public void I_clone_INTL_opportunity_using_clone_option()
	{
		try
		{
			selenium.refresh();
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("NewopportunitiesClone1"))
			{
				selenium.click("NewopportunitiesClone1");
			}
			else
			{
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("NewopportunitiesClone");
				selenium.click("NewopportunitiesClone");
			}

			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("opportunitiesFrameOneNew1");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NewopportunitiesCloneSave");
			selenium.click("NewopportunitiesCloneSave");
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.INFO, "INTL Opportunity Cloning is done!");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while cloning INTL Opp " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while cloning INTL Opp");
		}
	}

	@And("^I Clone from opportunity page$")
	public void I_Clone_from_opportunity_page() throws InterruptedException {
		try{
			
			if(selenium.getTestCaseName().equalsIgnoreCase("CloneOppAndVerifyData"))
			{
			selenium.navigateToURL(selenium.MHHENewOppURLForSingleClone);
			selenium.waitingTime(5000);
			}

			if(selenium.isElementPresentFast("CloseNotificationPopup"))
			{
				selenium.click("CloseNotificationPopup");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("NewopportunitiesClone1");
			selenium.clickLastXpath("NewopportunitiesClone1");
			selenium.waitingTime(9000);
//			selenium.switchToFrame("newOpportunitiesFrame");
			selenium.switchToMultipleFrame("opportunitiesFrameOneNew1");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("opportunitiesYear");
		//	selenium.jsClick("opportunitiesYear");
			selenium.click("opportunitiesYear");
			selenium.waitingTime(2000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitiesYear");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("opportunitiesTerm");
		//	selenium.jsClick("opportunitiesTerm");
			selenium.click("opportunitiesTerm");
			selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitiesTerm");
		
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("NewopportunitiesCloneSave");
	//		selenium.clickLoop("opportunitiesCloneSave");
			selenium.click("NewopportunitiesCloneSave");
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("OppCloneContinueBtn"))
			{
				selenium.click("OppCloneContinueBtn");
				selenium.waitingTime(15000);
			}
			selenium.switchOutOfFrame();
			selenium.waitingTime(10000);
		}catch(Exception e) {
			
      		selenium.click("opportunitiesToCancel");
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
			
			
		
		
	}
	@And("^I Clone from opportunity page Marketing$")
	public void I_Clone_from_opportunity_page_Marketing() throws InterruptedException {
		try {
		if (selenium.getUI().contains("Lightning")) {
			//selenium.click("newContact");
	//		selenium.type("opportunitiesSearch", "Opportunities Search Name");
	/*		selenium.clickDynamic("opportunitiesResultsToClick1", "opportunitiesResultsToClick value", "opportunitiesResultsToClick2");
			selenium.waitingTime(3000);*/
			
			//Enter
			
/*			selenium.waitingTime(6000);
      	    selenium.searchGlobal("Opportunity Name dynamic Value");
      		selenium.waitingTime(2000);
      		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value", "endContains");
      		selenium.clickLoopXpath(Xpath);*/
      		
//      		selenium.waitingTime(2000);
//      		selenium.navigateToURL(OppEidtMark);
//      		selenium.waitingTime(8000);      		
      		
        	
	//		selenium.jsClick("opportunitiesResultsClick2");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewopportunitiesClone1");
		//	selenium.jsClick("opportunitiesContactClick");
		//	selenium.waitingTime(3000);
			selenium.clickLoop("NewopportunitiesClone1");
			selenium.waitingTime(9000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
		//	selenium.jsClick("opportunitiesYear");
			selenium.click("opportunitiesYear");
//			selenium.waitingTime(2000);
			selenium.waitForElementsToBeVisible("opportunitiesYear");
			selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitiesYear");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("opportunitiesTerm");
		//	selenium.jsClick("opportunitiesTerm");
			selenium.click("opportunitiesTerm");
			selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitiesTerm");
		
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("NewopportunitiesCloneSave");
	//		selenium.jsClick("opportunitiesCloneSave");
			selenium.click("NewopportunitiesCloneSave");
			selenium.switchOutOfFrame();
			selenium.waitingTime(15000);
			
			
			
		}
		
	}catch(Exception e) {
		
  		selenium.click("opportunitiesToCancel");
		selenium.switchOutOfFrame();
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Test Case Failed");
	}
		
	}
	
	@And("^I Clone from opportunity page MHES$")
	public void I_Clone_from_opportunity_page_MHES() throws InterruptedException {
		
		try {
		if (selenium.getUI().contains("Lightning")) {
		
			selenium.waitingTime(6000);
   	        /*selenium.search("Opportunity Name dynamic Value");
   	    	selenium.waitingTime(2000);
   	    	String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value", "endContains");
//   	    	selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
   	    	selenium.clickLoopXpath(Xpath);              		
     	    selenium.waitingTime(5000);*/

			
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewopportunitiesClone1");
			selenium.jsClick("NewopportunitiesClone1");
			selenium.waitingTime(4000);
			selenium.switchToFrame("NewOpportunityCloneClickFrame");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunitiesYear");
		//	selenium.jsClick("opportunitiesYear");
			selenium.click("opportunitiesYear");
			selenium.waitingTime(2000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitiesYear");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("opportunitiesTerm");
		//	selenium.jsClick("opportunitiesTerm");
			selenium.click("opportunitiesTerm");
			selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitiesTerm");
		
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("opportunitiesCloneSave");
			selenium.jsClick("opportunitiesCloneSave");
			System.out.println("Clicked on Save");
			selenium.waitingTime(9000);
			selenium.switchOutOfFrame();
			selenium.waitForElementsToBeVisible("NewopportunitiesClone1");
			selenium.waitingTime(5000);
			
			
			
		}
	}catch(Exception e) {
		selenium.switchOutOfFrame();
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Test Case Failed");
		
	}
		
		
	}
	
           
	


//	@And("^I fill up the mandatory details$")
//	public void I_fill_up_the_mandatory_details() {
//		try {
//		if (selenium.getUI().contains("Lightning")) {/*
//			selenium.waitForElementsToBeVisible("serach_Account");
//			selenium.type("serach_Account", "Account Name");
//			selenium.waitingTime(2000);
//			selenium.clickDynamic("divTitle", "Account Name", "end");
//			selenium.click("salutation");
//			selenium.clickDynamic("anchorTitle", "Salutation", "end");
//			selenium.click("contactType");
//			selenium.clickDynamic("anchorTitle", "Contact Type", "end");
//			selenium.type("firstName", "First Name");
//			selenium.type("lastName", "Last Name");
//			selenium.scrollToElement("Name_Field");
//			selenium.type("Name_Field", "Department Name");
//			selenium.waitingTime(2000);
//			selenium.clickDynamic("divTitle", "Department Name", "end");
//			selenium.scrollToElement("email");
//			selenium.type("email", "Email");
//			selenium.clickLoop("saveContact");
//		*/
//			selenium.switchToFrame("productframeUat");
//			} 
//			selenium.selectDropdownText("salutationCl", "Salutation");
//			selenium.type("firstNameCl", "First Name");
//			selenium.type("lastNameCl", "Last Name");
//			selenium.selectDropdownText("contactTypeCl", "Contact Type");
//			selenium.type("emailCl", "Email");
//			selenium.type("departmentNameCl", "Department Name");
//			selenium.isDuplicateOpportunity();
//			selenium.pressEnter("departmentNameCl");
//			selenium.waitingTime(2000);
//		
//		selenium.switchOutOfFrame();
//		}
//		catch (Exception e)
//		{
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//			selenium.reportFailure("Test Case Failed");
//		}
//	}

	@Then("^contact should get saved$")
	public void contact_should_get_saved() {
		try {
		boolean isSuccess = false;
		if (selenium.getUI().contains("Lightning"))
			isSuccess = selenium.isElementPresentFast("contactSuccessfulL");
		else{
			String messageLocator=selenium.getDynamicXpath("contactVerification", "Email", "end");
			isSuccess = selenium.isElementPresentXpathFast(messageLocator);
		}
		selenium.printLastTestResult(isSuccess);
		selenium.waitingTime(5000);
		
	
	}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Test Case Failed");
			}
	}
	@Then("create a new opportunity of SEG Record Type")
	public void create_a_new_opportunity_of_SEG_record_type(){
		try{
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			String AccountName="Lawton Public School";
			selenium.waitForElementToBeClickable("opp_accName");
			selenium.click("opp_accName");
			selenium.waitingTime(1000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyOppDateAndYearWhenStageEqualsWon")||
					selenium.getTestCaseName().equalsIgnoreCase("VerifyOppCloseDateWhenStageNotEqualsWon"))
			{
				selenium.typeData("opp_accName","Yukon Public Schools");
			}
			else
			{
				selenium.typeData("opp_accName",AccountName);
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
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyOppDateAndYearWhenStageEqualsWon")||selenium.getTestCaseName().equalsIgnoreCase("VerifyOppCloseDateWhenStageNotEqualsWon"))
			{
				System.out.println("Test Case Name is : "+selenium.getTestCaseName());
			}
			else
			{
				selenium.waitForElementToBeClickable("OppOwner");
				selenium.typeData("OppOwner","Computer Science");
			}
			selenium.waitingTime(2000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyStageProbabilityInOpp")||selenium.getTestCaseName().equalsIgnoreCase("VerifyOppDateAndYearWhenStageEqualsWon"))
			{
				System.out.println("Test Case Name is : "+selenium.getTestCaseName());
			}
			else
			{
				selenium.waitForElementToBeClickable("PrimaryCampaignSourceTextBox");
				selenium.typeData("PrimaryCampaignSourceTextBox","test");
			}
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("OpptySaveBtn"))
			{
				selenium.waitForElementToBeClickable("OpptySaveBtn");
				selenium.jsClick("OpptySaveBtn");
				selenium.waitingTime(4000);
			}
			
			if(selenium.isElementPresentFast("OpptySaveBtn"))
			{
				selenium.waitForElementToBeClickable("OpptySaveBtn");
				selenium.jsClick("OpptySaveBtn");
			}
			selenium.waitingTime(10000);
			selenium.oppURL =selenium.getURL();
			System.out.println("selenium.oppURL is --> " + selenium.oppURL);
			
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify the fields on newly created opp")
	public void verify_the_fields_on_newly_created_opp(){
		try{
			selenium.waitForElementToBeVisible("purchaseDateopp2");
			String purchaseDateOpp=selenium.getText("purchaseDateopp2").toString();
			System.out.println(purchaseDateOpp);
			if(purchaseDateOpp.contains("202"))
			{
				System.out.println("Purchase Field is Visible");
				selenium.test.log(LogStatus.PASS,"Purchase Field is Visible");
			}
			else
			{
				System.out.println("Purchase Field is Not Visible");
				selenium.test.log(LogStatus.FAIL,"Purchase Field is Not Visible");
				selenium.reportFailure("Purchase Field is Not Visible");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ConfidenceFactorOpp");
			String confidenceFactor= selenium.getText("ConfidenceFactorOpp").toString();
			System.out.println(confidenceFactor);
			if(confidenceFactor.equalsIgnoreCase("1"))
			{
				System.out.println("Confidence Factor is Visible");
				selenium.test.log(LogStatus.PASS,"Confidence Factor is Visible");
			}
			else
			{
				System.out.println("Confidence Factor is Not Visible");
				selenium.test.log(LogStatus.FAIL,"Confidence Factor is Not Visible");
				selenium.reportFailure("Confidence Factor is Not Visible");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("PrimaryCampaignSourceOpp");
			String primaryCampaignSource =selenium.getText("PrimaryCampaignSourceOpp").toString();
			System.out.println(primaryCampaignSource);
			if(primaryCampaignSource.equalsIgnoreCase("test"))
			{
				System.out.println("Primary Campaign Source is Visible");
				selenium.test.log(LogStatus.PASS,"Primary Campaign Source is Visible");
			}
			else
			{
				System.out.println("Primary Campaign Source is not Visible");
				selenium.test.log(LogStatus.FAIL,"Primary Campaign Source is not Visible");
				selenium.reportFailure("Primary Campaign Source is not Visible");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("edit the fields  for newly created opp")
	public void edit_the_fields_for_newly_created_opp(){
		try{
			selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(10000);
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow=calendar.getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(tomorrow);
			System.out.println(todaysdate);
			selenium.waitForElementToBeClickable("OppPurchaseDateSelectionField");
			selenium.typeData("OppPurchaseDateSelectionField", todaysdate);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ConfidenceFactorList");
			selenium.jsClick("ConfidenceFactorList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ConfidenceFactorOption");
			selenium.jsClick("ConfidenceFactorOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PrimaryCampaignCrossBtn");
			selenium.jsClick("PrimaryCampaignCrossBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PrimaryCampaignSourceEditBox");
			selenium.clearText("PrimaryCampaignSourceEditBox");
			selenium.waitingTime(500);
			selenium.typeData("PrimaryCampaignSourceEditBox","testing");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("TestCampaignSelect");
			selenium.jsClick("TestCampaignSelect");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("purchaseDateopp2");
			String purchaseDateOpp=selenium.getText("purchaseDateopp2").toString();
			System.out.println(purchaseDateOpp);
			if(purchaseDateOpp.contains("202"))
			{
				System.out.println("Purchase Field is Visible");
				selenium.test.log(LogStatus.PASS,"Purchase Field is Visible");
			}
			else
			{
				System.out.println("Purchase Field is Not Visible");
				selenium.test.log(LogStatus.FAIL,"Purchase Field is Not Visible");
				selenium.reportFailure("Purchase Field is Not Visible");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ConfidenceFactorOpp");
			String confidenceFactor= selenium.getText("ConfidenceFactorOpp").toString();
			System.out.println(confidenceFactor);
			if(confidenceFactor.equalsIgnoreCase("2"))
			{
				System.out.println("Confidence Factor is Visible");
				selenium.test.log(LogStatus.PASS,"Confidence Factor is Visible");
			}
			else
			{
				System.out.println("Confidence Factor is Not Visible");
				selenium.test.log(LogStatus.FAIL,"Confidence Factor is Not Visible");
				selenium.reportFailure("Confidence Factor is Not Visible");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("PrimaryCampaignSourceOpp");
			String primaryCampaignSource =selenium.getText("PrimaryCampaignSourceOpp").toString();
			System.out.println(primaryCampaignSource);
			if(primaryCampaignSource.equalsIgnoreCase("testing"))
			{
				System.out.println("Primary Campaign Source is Visible");
				selenium.test.log(LogStatus.PASS,"Primary Campaign Source is Visible");
			}
			else
			{
				System.out.println("Primary Campaign Source is not Visible");
				selenium.test.log(LogStatus.FAIL,"Primary Campaign Source is not Visible");
				selenium.reportFailure("Primary Campaign Source is not Visible");
			}


		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("go to strategy worksheet page and edit")
	public void go_to_strategy_worksheet_page_and_edit(){
		try{
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("strategyWorksheetBtn");
			selenium.click("strategyWorksheetBtn");
			selenium.waitingTime(10000);
			selenium.takeScreenShot();

			if(!selenium.isElementPresentFast("switch_iFrame")) {
				System.out.println("strategyWorksheetBtn not clicked, refreshing page..");
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("strategyWorksheetBtn");
				selenium.clickLoop("strategyWorksheetBtn");
				selenium.waitingTime(10000);
				selenium.takeScreenShot();
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("switch_iFrame");
			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("StrategyWorkSheetTextBox");
			selenium.typeData("StrategyWorkSheetTextBox","Automation UAT Testing");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(20000);

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
		@Then("verify the strategy worksheet page fields")
		public void verify_the_strategy_worksheet_page_fields(){
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("strategyWorksheetBtn");
			selenium.click("strategyWorksheetBtn");
			selenium.waitingTime(10000);
			selenium.takeScreenShot();

			if(!selenium.isElementPresentFast("switch_iFrame")) {
				System.out.println("strategyWorksheetBtn not clicked, refreshing page..");
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("strategyWorksheetBtn");
				selenium.clickLoop("strategyWorksheetBtn");
				selenium.waitingTime(10000);
				selenium.takeScreenShot();
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("switch_iFrame");
			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("StrategyWorkSheetProfessor");
			
			if(selenium.isElementPresentsuperFast("StrategyWorkSheetProfessor")&&selenium.isElementPresentsuperFast("StrategyWorkSheetRole")&&
			selenium.isElementPresentsuperFast("StrategyOfficeHours")&&selenium.isElementPresentsuperFast("StrategyWorkSheetVoting")&&
			selenium.isElementPresentsuperFast("StrategyWorkSheetPrimaryInterest")&&selenium.isElementPresentsuperFast("StrategyWorkSheetBuyCriteria")&&
			selenium.isElementPresentsuperFast("StrategyWorkSheetRiskVsReward")&&selenium.isElementPresentsuperFast("StrategyWorkSheetIndividualMotive")&&
			selenium.isElementPresentsuperFast("StrategyHaveTheyField")&&selenium.isElementPresentsuperFast("StrategyDateOfLastField")&&
			selenium.isElementPresentsuperFast("StrategyMarketDevType")&&selenium.isElementPresentsuperFast("StrategyLastVisit")&&
			selenium.isElementPresentsuperFast("StrategyNextEngagement")&&selenium.isElementPresentsuperFast("StrategyOfficeLocation"))
			{
				System.out.println("All Fields are Present");
				selenium.test.log(LogStatus.PASS,"All Fields are Present");
			}
			else
			{
				System.out.println("Not all Fields are Present");
				selenium.test.log(LogStatus.FAIL,"Not all Fields are Present");
				selenium.reportFailure("Not all Fields are Present");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify the fields are visible on strategy worksheet page")
	public void verify_the_fields_are_visible_on_strategy_worksheet_page(){
		try{
			if(!(selenium.isElementPresentsuperFast("StrategyDecisionDriver")&&selenium.isElementPresentsuperFast("StrategyDecisionMaker")&&
			selenium.isElementPresentsuperFast("StrategyNotes")&&selenium.isElementPresentsuperFast("StrategyLastMarket")&&
			selenium.isElementPresentsuperFast("StrategyCampus")))
			{
				System.out.println("The removed fields are not Present");
				selenium.test.log(LogStatus.PASS,"The removed fields are not Present");
			}
			else
			{
				System.out.println("The removed fields are Present");
				selenium.test.log(LogStatus.FAIL,"The removed fields are Present");
				selenium.reportFailure("The removed fields are Present");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("go to opp contact and add a contact")
	public void go_to_opp_contact_and_a_contact(){
		try{
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(3000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("OppContactNameSearchField");
			selenium.typeData("OppContactNameSearchField", "David");
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

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify the role in strategy worksheet page")
	public void verify_the_role_in_strategy_worksheet_page(){
		try{
			selenium.refresh();
			selenium.waitingTime(12000);
			String url=selenium.getURL();
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("EditOppContactRoleBtn");
			selenium.jsClick("EditOppContactRoleBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppRoleDropDown");
			selenium.jsClick("OppRoleDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppRoleOption");
			selenium.jsClick("OppRoleOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.navigateToURL(url);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("strategyWorksheetBtn");
			selenium.click("strategyWorksheetBtn");
			selenium.waitingTime(10000);
			selenium.takeScreenShot();

			if(!selenium.isElementPresentFast("switch_iFrame")) {
				System.out.println("strategyWorksheetBtn not clicked, refreshing page..");
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("strategyWorksheetBtn");
				selenium.clickLoop("strategyWorksheetBtn");
				selenium.waitingTime(10000);
				selenium.takeScreenShot();
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("switch_iFrame");
			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(3000);			
			selenium.waitForElementToBeVisible("StrategyWorkSheetField");
			String role=selenium.getText("StrategyWorkSheetField").toString();
			System.out.println(role);
			if(role.equalsIgnoreCase("Key Decision Maker"))
			{
				System.out.println("Role Field is Present");
				selenium.test.log(LogStatus.PASS,"Role Field is Present");
			}
			else
			{
				System.out.println("Role Field is not Present");
				selenium.test.log(LogStatus.FAIL,"Role Field is not Present");
				selenium.reportFailure("Role Field is not Present");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("clone the opportunity and verify")
	public void clone_the_opportunity_and_verify(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("moreActionsBtn");
			selenium.click("moreActionsBtn");
			selenium.waitForElementToBeClickable("NewopportunitiesClone");
			selenium.click("NewopportunitiesClone");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("opportunitiesFrameOneNew1");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.click("OpptySaveBtn");
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.INFO, "INTL Opportunity Cloning is done!");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrolldown(50000);
			selenium.waitForElementToBeVisible("PreviousOriginalOppLink");
			String previousOpp =selenium.getText("PreviousOriginalOppLink").toString();
			System.out.println("previousOpp --> " + previousOpp);
			if(previousOpp.contains("AUSTRALIAN TERTIARY ACADEMY"))
			{
				System.out.println("Previous Opportunity is available");
				selenium.test.log(LogStatus.PASS,"Previous Opportunity is available");
			}
			else
			{
				System.out.println("Previous Opportunity is not available");
				selenium.test.log(LogStatus.FAIL,"Previous Opportunity is not available");
				selenium.reportFailure("Previous Opportunity is not available");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PreviousOppLink");
			selenium.jsClick("PreviousOppLink");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrolldown(50000);
			selenium.waitForElementToBeVisible("NextClonedOppLink");
			String nextOpp= selenium.getText("NextClonedOppLink").toString();
			System.out.println(nextOpp);
			if(nextOpp.contains("AUSTRALIAN TERTIARY ACADEMY"))
			{
				System.out.println("Next Opportunity is available");
				selenium.test.log(LogStatus.PASS,"Next Opportunity is available");
			}
			else
			{
				System.out.println("Next Opportunity is not available");
				selenium.test.log(LogStatus.FAIL,"Next Opportunity is not available");
				selenium.reportFailure("Next Opportunity is not available");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("click on opp new sample button and verify calender")
	public void click_on_opp_new_sample_button_and_verify_calender(){
		try{

			selenium.waitForElementToBeClickable("newSampleFromOpportunity");
			selenium.jsClick("newSampleFromOpportunity");
			selenium.waitingTime(20000);
			selenium.switchToFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("AttnLineTextBox");
			selenium.typeData("AttnLineTextBox","test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RefInstructionTextBox");
			selenium.typeData("RefInstructionTextBox","test");
			selenium.waitingTime(2000);
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow=calendar.getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(tomorrow);
			System.out.println(todaysdate);
			selenium.scrollToElement("futureProcessDateText");
			selenium.typeData("futureProcessDateText", "1");
			selenium.pressEnter("futureProcessDateText");
			selenium.pressBackspace("futureProcessDateText");

			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("FutureProcessDateErrorMsg");
			String futureProcessDateErrorMsg= selenium.getText("FutureProcessDateErrorMsg").toString();
			System.out.println(futureProcessDateErrorMsg);
			if(futureProcessDateErrorMsg.equalsIgnoreCase("Please fill the date field in MM/DD/YYYY format"))
			{
				System.out.println("Error message is showing");
				selenium.test.log(LogStatus.PASS,"Error message is showing");
			}
			else
			{
				System.out.println("Error message is not showing");
				selenium.test.log(LogStatus.FAIL,"Error message is not showing");
				selenium.reportFailure("Error message is not showing");
			}

			selenium.waitForElementToBeClickable("futureProcessDateText");
			selenium.waitingTime(2000);
			selenium.typeData("futureProcessDateText", todaysdate);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("backOrderCancelDateText");
			selenium.waitingTime(2000);
			selenium.typeData("backOrderCancelDateText", todaysdate);
			selenium.waitingTime(4000);

			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("addButton");
			if(selenium.isElementPresentFast("addButton"))
			{
				System.out.println("Calender date is selected");
				selenium.test.log(LogStatus.PASS,"Calender date is selected");
			}
			else
			{
				System.out.println("Calender date is not selected");
				selenium.test.log(LogStatus.FAIL,"Calender date is not selected");
				selenium.reportFailure("Calender date is not selected");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("create opportunity from accounts record")
	public void create_opportunity_from_accounts_record(){
		try {
			String url="https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bx0wOAAQ/view";
			selenium.navigateToURL(url);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OppLinkfromAccounts");
			selenium.jsClick("OppLinkfromAccounts");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("NewActionButton");
			selenium.jsClick("NewActionButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DAGRecordTypeRadioBtn");
			selenium.jsClick("DAGRecordTypeRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(15000);

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
			String OppOwnerName="Jaime Klar";
			selenium.waitForElementToBeClickable("OppOwner");
			selenium.typeData("OppOwner","Jaime Klar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("opportunityOwnerGetText");
			String opportunityOwner=selenium.getText("opportunityOwnerGetText").toString();
			System.out.println(opportunityOwner);
			if(opportunityOwner.equalsIgnoreCase(OppOwnerName))
			{
				System.out.println("Opportunity created successfully");
				selenium.test.log(LogStatus.PASS,"Opportunity created successfully");
			}
			else
			{
				System.out.println("Opportunity not created successfully");
				selenium.test.log(LogStatus.FAIL,"Opportunity not created successfully");
				selenium.reportFailure("Opportunity not created successfully");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify inactive contacts are not cloned in cloned opportunity")
	public void verify_inactive_contacts_are_not_cloned_in_cloned_opportunity(){
		try {
		 selenium.refresh();
		 selenium.waitingTime(7000);
		 selenium.waitForElementToBeClickable("OpportunityContactClick1");
		 selenium.jsClick("OpportunityContactClick1");
		 selenium.waitingTime(3000);
		 Assert.assertFalse(selenium.isElementPresentFast("OppContactFirstRecord"));
		 System.out.println("PASS");
		 selenium.test.log(LogStatus.PASS, "PASS");

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

}
