package com.mhe.salesforce.testcases;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommunitySites {
	
	WebConnector selenium = WebConnector.getInstance();
	public String title;
	public String value;
	public String input;
	public String valueEmailURL;
	
	@Then("^I Quick search for all sites$")
    public void i_quick_search_for_all_sites() {
		try {
		selenium.waitForElementToBeClickable("quickFind");
		selenium.click("quickFind");
		selenium.waitingTime(2000);
		selenium.type("quickFind", "Search");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("allCommunitiesQuickSearch");
		selenium.jsClick("allCommunitiesQuickSearch");
		selenium.waitingTime(5000);		
	}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while quick search  " + e.getMessage());
		}
		
}
	
	@Then("I Quick search for sites")
	public void i_quick_search_for_sites()
	{
		try
		{
			selenium.waitForElementToBeClickable("quickFind");
			selenium.click("quickFind");
			selenium.waitingTime(2000);
			selenium.typeData("quickFind", "Sites");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("UserSetupSitesLink");
			selenium.jsClick("UserSetupSitesLink");
			selenium.waitingTime(5000);	
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@Then("get the INTL Implementation Customer Success site URL and navigate")
	public void get_the_INTL_Implementation_Customer_Success_site_URL_and_navigate()
	{
		try
		{
			selenium.switchToFrame("newAccountFrame");
			selenium.scrollToElement("INTLImplementationCustomerSuccessSiteLink");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("INTLImplementationCustomerSuccessSiteLink");
			selenium.jsClick("INTLImplementationCustomerSuccessSiteLink");
			selenium.waitingTime(4000);
			selenium.switchOutOfFrame();
			selenium.switchToChildWindow();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("verify the form fields and their behavior")
	public void verify_the_form_fields_and_their_behavior()
	{
		try
		{
			selenium.waitForElementToBeVisible("YourInfoHeader");
			Assert.assertTrue(selenium.isElementPresentFast("YourInfoHeader"));
			selenium.close();
			selenium.waitingTime(2000);
			selenium.switchBackToParentWindow();
			selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	 @Then("^get the ALEKS Support URL and verify page load$")
	    public void get_the_aleks_support_url_and_verify_page_load() {
		 try {
			 
			 selenium.switchToFrame("newAccountFrame");
			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeVisible("ALEKSSupportURLNew");
			 String ALEKSurl = selenium.getText("ALEKSSupportURLNew");
			 System.out.println("ALEKSurl is " + ALEKSurl);
			
			 selenium.waitingTime(2000);
			 selenium.navigateToURL(ALEKSurl);
			 selenium.waitForElementToBeVisible("ALEKSSupportPageTitle");
			 boolean value = selenium.isElementPresentFast("ALEKSSupportPageElement");
			 System.out.println(value);
			 if (value == true) {
				 selenium.test.log(LogStatus.PASS, "ALEKS Support page loaded" );
				 System.out.println("inside pass");
			 }
			 else { 
				 selenium.test.log(LogStatus.FAIL, "ALEKS Support page not loaded" );
				 System.out.println("inside fail");
				 selenium.reportFailure("ALEKS Support page not loaded");
			 }
			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 
			 selenium.navigateBack();
			 selenium.waitingTime(2000);
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while loading ALEKS Supoport URL  " + e.getMessage());
			}
	 }
	 
	 @Then("^get the CSOM URL and verify page load$")
	    public void get_the_csom_url_and_verify_page_load() {
		 try {
			 selenium.switchToFrame("newAccountFrame");
//			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeVisible("CSOMUrlNew");
			 String CSOMurl = selenium.getText("CSOMUrlNew");
			 System.out.println("CSOMUrl is " + CSOMurl);
			 selenium.waitingTime(2000);
			 selenium.navigateToURL(CSOMurl);
			 selenium.waitForElementToBeVisible("CSOMPageTitle");
			 boolean value = selenium.isElementPresentFast("CSOMPageElement");
			 System.out.println(value);
			 if (value == true) {
				 selenium.test.log(LogStatus.PASS, "CSOM Support page loaded" );
				 System.out.println("inside pass");
			 }
			 else { 
				 selenium.test.log(LogStatus.FAIL, "CSOM Support page not loaded" );
				 System.out.println("inside fail");
				 selenium.reportFailure("CSOM Support page not loaded");
			 }
			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 selenium.navigateBack();
			 selenium.waitingTime(2000);
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while loading CSOM Supoport URL  " + e.getMessage());
			}
	 }
	 
	 @Then("^get the CXG URL and verify page load$")
	    public void get_the_cxg_url_and_verify_page_load() {
		 try {
			 selenium.switchToFrame("newAccountFrame");
//			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeVisible("CXGUrl");
			 String CXGurl = selenium.getText("CXGUrl");
			 System.out.println("CXGurl is " + CXGurl);
			 selenium.waitingTime(2000);
			 selenium.navigateToURL(CXGurl);
			 selenium.waitForElementToBeVisible("CXGPageTitle");
			 boolean value = selenium.isElementPresentFast("CXGPageElement");
			 System.out.println(value);
			 if (value == true) {
				 selenium.test.log(LogStatus.PASS, "CXG Support page loaded" );
				 System.out.println("inside pass");
			 }
			 else { 
				 selenium.test.log(LogStatus.FAIL, "CXG Support page not loaded" );
				 System.out.println("inside fail");
				 selenium.reportFailure("CXG Support page not loaded");
			 }
			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 selenium.navigateBack();
			 selenium.waitingTime(2000);
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while loading CXG Supoport URL  " + e.getMessage());
			}
	 }

	 @Then("^get the DTS URL and verify page load$")
	    public void get_the_dts_url_and_verify_page_load() {
		 try {
			 selenium.switchToFrame("newAccountFrame");
//			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeVisible("DTSUrl");
			 String DTSUrl = selenium.getText("DTSUrl");
			 System.out.println("DTSUrl is " + DTSUrl);
			 selenium.waitingTime(3000);
			 selenium.navigateToURL(DTSUrl);
			 selenium.waitForElementToBeVisible("DTSPageTitle");
			 boolean value = selenium.isElementPresentFast("DTSPageTitle");
			 System.out.println(value);
			 if (value == true) {
				 selenium.test.log(LogStatus.PASS, "DTS Support page loaded" );
				 System.out.println("inside pass");
			 }
			 else { 
				 selenium.test.log(LogStatus.FAIL, "DTS Support page not loaded" );
				 System.out.println("inside fail");
				 selenium.reportFailure("DTS Support page not loaded");
			 }
			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 selenium.navigateBack();
			 selenium.waitingTime(2000);
			 selenium.switchOutOfFrame();
			 selenium.waitingTime(2000);
			 
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while loading DTS Supoport URL  " + e.getMessage());
			}
	 }
	 
	 
	 @When("^I navigate to \"([^\"]*)\" tab and click on New button$")
		public void I_navigate_to_tab_and_click_on_New_button(String knowledge)  {
			try {
			//selenium.refresh();
			selenium.waitForElementToBeVisible("menuDots");
			selenium.jsClick("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.typeData("searchItemsTextField", knowledge);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("KnowledgeApp");
			selenium.jsClick("KnowledgeApp");
			System.out.println("Navigated successfully to Knowledge Tab");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.click("NewButtonToAdd");
			selenium.waitingTime(3000);
			}
			 catch (Exception e) {
					
					selenium.reportFailure("Error while navigating to Knowledge tab " + e.getMessage());
				}

		}	 
		
		@And("^I click \"([^\"]*)\" radio button and click Next$")
		public void i_click_radio_button(String recordType) {
			selenium.test.log(LogStatus.INFO, "click Record Type radio button");
			//selenium.waitForElementToBeClickable("FAQ_Solution");
			selenium.clickHeader(recordType);
			selenium.waitingTime(2000);
			selenium.clickHeader("NextButton");
			selenium.waitingTime(2000);
		
			}

		 @And("^Validate dropdown fields$")
		 public void validate_dynamic_dropdown_fields()
		 {
		 try
		 {
		 selenium.dropdownvalues();
		 selenium.test.log(LogStatus.INFO, "Dropdown fields are having correct data!");
		 System.out.println("Dropdown fields are having correct data!");
		 }

		 catch (Exception e)
		 {

		 Assert.assertTrue(true);
		 selenium.reportFailure("Error while validating dropdown list values" + e.getMessage());
		 System.out.println("Dropdown fields are having Incorrect data!");
		 }
		 }
		 
		 
		 @And("^fill all mandatory details to create new Knowledge article for \"([^\"]*)\"$")
		    public void fill_all_mandatory_details_to_create_new_Knowledge_article(String category) {
			 
			 try {
				 selenium.refresh();
				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("TxtBoxURLName");
				 selenium.jsClick("TxtBoxURLName");
				 title = selenium.getRandomString();
				 selenium.getElement("TxtBoxTitle").sendKeys(title);
				 System.out.println("Title is :" + title);
				 selenium.waitForElementToBeClickable("TxtBoxURLName");
				 selenium.jsClick("TxtBoxURLName");
				 selenium.waitingTime(3000);
				 if(selenium.getTestCaseName().equalsIgnoreCase("VerifyCasesScenarios" )) {
					 System.out.println("Inside if block");
					selenium.jsClick("ProductGroupPicklist");
					System.out.println("Clicked Product Group");
					selenium.multiSelect("ProductGroupPicklist","ProductGroupValues");
					selenium.waitingTime(2000);
					selenium.click("selectRight");
					selenium.waitingTime(2000);
				 }
				 selenium.scrollToElement("CategoryDropDown");
				 selenium.waitForElementToBeClickable("CategoryDropDown");
				 selenium.jsClick("CategoryDropDown");
				 System.out.println("Reached Category dropdown");
	        	 selenium.waitingTime(2000);

		         if (selenium.isElementPresentFast("loginPopUpNew"))
		         {
		        	System.out.println("I am inside loginPopUpNew method");
		        	selenium.clickLoop("loginPopUpNew");
		        	selenium.waitingTime(2000);	
		         }
		         else if (selenium.isElementPresentFast("loginPopUp"))
				 {
		        	 System.out.println("I am inside loginPopup method");
					 selenium.click("loginPopUp");
					 selenium.waitingTime(2000);
				 }
			 
				 selenium.scrollToElement(category);
				 System.out.println("Category is: "+category);
				 selenium.click(category);
				 selenium.waitingTime(2000);
				 selenium.scrollToElement("ChannelChkbox1");
				 selenium.waitingTime(2000);
				 selenium.click("ChannelChkbox1");
				 selenium.waitForElementToBeClickable("ChannelChkbox2");
				 selenium.click("ChannelChkbox2");
				 selenium.waitForElementToBeClickable("ChannelChkbox3");
				 selenium.click("ChannelChkbox3");
				 selenium.waitForElementToBeClickable("ChannelChkbox4");
				 selenium.click("ChannelChkbox4");
				 selenium.waitingTime(3000);
				 selenium.waitForElementToBeClickable("SaveButton");
				 selenium.jsClick("SaveButton");
				 
				 selenium.waitingTime(4000);			
			 	 selenium.waitForElementToBeVisible("ArticleNumber");
			 	 System.out.println("Element is present");
				 if(selenium.isElementPresentFast("ArticleNumber"))
				 {
				 selenium.test.log(LogStatus.PASS, "Article created successfully");
				 System.out.println("PASS: Article created successfully");
				 }			 
				 else
				 {
					 selenium.test.log(LogStatus.FAIL, "Article is not created");
				 	 selenium.reportFailure("Article is not created");
				 	 System.out.println("Article is not created");
				 }

				 selenium.ArticleURL = selenium.getURL();
				 System.out.println("Newly created Article URL is " + selenium.ArticleURL);

				 }
				 catch (Exception e)
				 {
				 	System.out.println("inside catch");
					selenium.reportFailure("Error while creating new article " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");				
				 }
		 }


		 @When("^I navigate to \"([^\"]*)\" tab$")
			public void I_navigate_to_tab(String AppName)  {
				try {
					selenium.refresh();
					selenium.waitingTime(6000);
					selenium.clickOnClearAllNotification();
					selenium.checkFlowInterruptedPopup();					
					selenium.checkOmniChannelPopup();
					selenium.closeAllWinExceptFirstWin();
					selenium.waitForElementToBeClickable("menuDots");
					selenium.click("menuDots");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("searchItemsTextField");
					selenium.typeData("searchItemsTextField", AppName);
					selenium.waitForElementToBeClickable("CommunityName");
					selenium.jsClick("CommunityName");
					System.out.println("Navigated successfully to " + AppName +" Page");
					selenium.waitingTime(5000);
					if(selenium.getTestCaseName().equalsIgnoreCase("LiveAgentChatAleksCommunity"))
					{
						selenium.switchBackToParentWindow();
					}
					selenium.takeScreenShot();
				}
				 catch (Exception e) {
						
						selenium.reportFailure("Error while navigating to Knowledge tab " + e.getMessage());
					}

			}
		 
		 @When("^I navigate to \"([^\"]*)\" page$")
			public void I_navigate_to_page(String AppName)  {
				try {
				
				selenium.waitForElementToBeVisible("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("searchItemsTextField");
				selenium.typeData("searchItemsTextField", AppName);
				selenium.waitForElementToBeVisible("CXGCommunity");
				selenium.jsClick("CXGCommunity");
				System.out.println("Navigated successfully to Community Page");
				selenium.waitingTime(5000);
				}
				 catch (Exception e) {
						
						selenium.reportFailure("Error while navigating to Knowledge tab " + e.getMessage());
					}

			}

		 @And("^I click \"([^\"]*)\" button$")
			public void i_click_DTSPage_button(String dtsPageSegment) {
			 	selenium.switchToChildWindow();
				selenium.waitingTime(20000);
				selenium.test.log(LogStatus.INFO, "click DTS Page button");
				selenium.waitForElementToBeClickable(dtsPageSegment);
				selenium.click(dtsPageSegment);
				selenium.waitingTime(10000);
			
				}
		 
		 @Then("I click on \"([^\"]*)\" link and match the given \"([^\"]*)\"$")
		 	public void i_click_on_link_and_match(String program, String url) {
			 	selenium.switchToChildWindow();
			 	System.out.println("On given link page");
				selenium.waitingTime(20000);
				selenium.scrollToElement(program);
				selenium.click(program);
				selenium.switchToChildWindow();
				System.out.println("On New Window");
				selenium.waitingTime(20000);
				String getUrlUI= selenium.getURL();
				System.out.println("URl from UI is " +getUrlUI);
				System.out.println("URL from file is " +url);
				if(selenium.getURL().equals(url))
				{
					System.out.println("Clicked link "+program+" matches the given URL");
				}
				else
				{
					System.out.println("URLs do not match");
				}
				selenium.waitingTime(5000);	
				
				selenium.close();
				selenium.switchBackToParentWindow();
				selenium.waitingTime(5000);	
				selenium.close();
				selenium.switchBackToParentWindow();
				selenium.waitingTime(5000);	
				selenium.maximizeBrowserWindow();
		 }
		 
			@And("^I edit the category segment to \"([^\"]*)\" and publish the article$")
			public void i_edit_the_category_segment_and_publish_the_article(String newCategory) {
				selenium.test.log(LogStatus.INFO, "click Edit buton under Category section");
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("EditDownArrow");
				selenium.jsClick("EditDownArrow");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("EditOption");
				selenium.jsClick("EditOption");
				
				selenium.waitingTime(5000);
				//selenium.switchToChildWindow();
				System.out.println("Reaching to edit segment window");
				/*if(selenium.isElementPresentFast("EditWindow"))
				 {
				 selenium.test.log(LogStatus.PASS, "Editting the Category");
				 System.out.println("PASS: Editting the Category");
				 }			 
				 else
				 {
					 selenium.test.log(LogStatus.FAIL, "Did not reach Edit Window");
				 	 selenium.reportFailure("Did not reach Edit Window");
				 	 System.out.println("Did not reach Edit Window");
				 }*/
				//selenium.waitingTime(3000);
				//selenium.switchToChildWindow();
//				selenium.scrollToElement("SelectSegment");
				
				selenium.waitForElementToBeClickable("SelectSegment");
				selenium.jsClick("SelectSegment");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("SelectDTSTopic");
				selenium.jsClick("SelectDTSTopic");
				selenium.waitingTime(3000);
				selenium.scrollToElement(newCategory);
				selenium.waitForElementToBeClickable(newCategory);
				selenium.jsClick(newCategory);
				selenium.waitingTime(30000);
				selenium.waitForElementToBeClickable("SaveSegment");
				selenium.jsClick("SaveSegment");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("CategorySegment");
				selenium.jsClick("CategorySegment");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("newCategoryName");
				System.out.println("Article's new category is now: "+"newCategoryName");
				selenium.test.log(LogStatus.INFO, "Article's new category is now updated");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("PublishButton");
				selenium.jsClick("PublishButton");
				//selenium.switchToChildWindow();
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("PublishNowButton");
				selenium.jsClick("PublishNowButton");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeVisible("ArticleStatus");
				System.out.println("The Article is published successfully");
				selenium.test.log(LogStatus.INFO, "The Article is published successfully");					
							
				}
		 
	
			@Then ("I click on \"([^\"]*)\" and select \"([^\"]*)\"$")
			public void i_click_on_tab_and_select_link(String tab, String link) {
				selenium.test.log(LogStatus.INFO, "click MHHE Links tab");
				selenium.waitForElementToBeClickable(tab);
				selenium.click(tab);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable(link);
				selenium.click(link);
				/*selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("MinimizeButton");
				selenium.click("MinimizeButton");*/
				selenium.waitingTime(10000);
				System.out.println("Form opens successfully");
				selenium.switchToChildWindow();
				selenium.waitingTime(5000);
				selenium.refresh();
			}
			
			@Then ("I click on picklist \"([^\"]*)\" and select option \"([^\"]*)\"$")
			public void i_click_on_picklist_and_select_option(String picklist, String value) {
				selenium.test.log(LogStatus.INFO, "click picklist");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable(picklist);
				selenium.click(picklist);
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable(value);
				selenium.click(value);
				selenium.waitingTime(5000);
				System.out.println("Customer Form opens successfully!");
			}
			
			 @And("^I validate that the article created is present on the webpage$")
			 public void  validate_the_article_created_is_present_on_the_webpage()
			 {
			 try
			 {
				
				 String xpath = selenium.getDynamicXpathData("anchorText", title, "end");
		         System.out.println(xpath);
		        if(selenium.isElementPresentXpathFast(xpath)) {		       
		        	selenium.test.log(LogStatus.INFO, "Article is present on the webpage");
		        	System.out.println("Article is present on the webpage");
		        }
		        else
		        {
				 	System.out.println("Article is not present on the webpage!");
		        }
				 selenium.closeSubTabs();
			 }

			 catch (Exception e)
			 {

			 Assert.assertTrue(true);
			 	selenium.reportFailure("Article is not present on the webpage" + e.getMessage());
			 
			 }
			 }
			 
			 @And("^I filled the form$")
				public void i_filled_the_form() {
					try {
						if(selenium.getTestCaseName().equalsIgnoreCase("VerifytheInternalCodeRequestForm" ))
						{
						if (selenium.getUI().contains("Lightning")) {
							selenium.waitingTime(10000);
							value = selenium.getRandomString();
							String valueURL=value + "@gmail.com";
							selenium.typeData("RequestorEmail", valueURL);
							System.out.println("Requestor Email is :" + valueURL);
							selenium.waitingTime(2000);
							selenium.typeData("RequestorName", value);
							selenium.waitingTime(2000);
							selenium.typeData("ManagerName", value);							
							try {
									selenium.waitingTime(2000);
									Select dropdown = new Select(selenium.getElement("SalesVP"));
									dropdown.selectByIndex(1);
									selenium.waitingTime(2000);
								}
							catch (Exception e){
								System.out.println("Sales VP Element is not present");
								}
							selenium.scrolldown(100);
							selenium.waitingTime(2000);
							selenium.typeData("ProfessorName", value);
							selenium.waitingTime(2000);
							selenium.typeData("ProfessorEmail", valueURL);
							System.out.println("Professor Email is :" + valueURL);
							selenium.waitingTime(2000);
							selenium.scrollToElement("Name_Field");
							System.out.println("Scrolled to Department");
							Select dropdown1 = new Select(selenium.getElement("Name_Field"));
					        dropdown1.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown2 = new Select(selenium.getElement("CountryName"));
					        dropdown2.selectByIndex(2);
					        selenium.waitingTime(2000);
							selenium.typeData("CityName", value);
							selenium.waitingTime(2000);
							selenium.typeData("SchoolNm", value);
							selenium.waitingTime(2000);
							/*
							Select dropdown3 = new Select(selenium.getElement("StateName"));
					        dropdown3.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown4 = new Select(selenium.getElement("SchoolName"));
					        dropdown4.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown5 = new Select(selenium.getElement("SchoolName"));
					        dropdown5.selectByIndex(11);
							selenium.waitingTime(2000);*/
							//Select dropdown6 = new Select(selenium.getElement("SuperCode"));
					        //dropdown6.selectByIndex(0);
							//selenium.waitingTime(2000);
							selenium.typeData("NumberOfRedemptions", value);
							selenium.waitingTime(2000);
							Select dropdown7 = new Select(selenium.getElement("Duration"));
					        dropdown7.selectByIndex(1);
							selenium.waitingTime(2000);
							//Select dropdown8 = new Select(selenium.getElement("ProductName"));
					        //dropdown8.selectByIndex(0);
							//selenium.waitingTime(2000);
							selenium.typeData("CourseName", value);
							selenium.waitingTime(2000);
							selenium.typeData("URLName", value);
							selenium.waitingTime(2000);
							selenium.scrollToElement("AuthorName");
							selenium.typeData("AuthorName", value);
							selenium.waitingTime(2000);
							selenium.typeData("TitleName", value);
							selenium.waitingTime(2000);
							selenium.typeData("EditionName", value);
							selenium.waitingTime(2000);
							Select dropdown9 = new Select(selenium.getElement("Reason"));
					        dropdown9.selectByIndex(1);
							selenium.waitingTime(2000);
							selenium.scrollToElement("SubmitForm");
							selenium.click("SubmitForm");
							selenium.waitingTime(10000);
							if(selenium.isElementPresentFast("Note")) {
							selenium.test.log(LogStatus.PASS, "Form submitted successsfully");
							System.out.println("Form submitted successsfully");
							}
							else {
								System.out.println("Form is not submitted");
								selenium.test.log(LogStatus.FAIL, "Test Case Failed");
								selenium.reportFailure("Test Case Failed");
							}
						}
						}
						if(selenium.getTestCaseName().equalsIgnoreCase("VerifytheInternalCodeRequestFormforCodeDeactivationRequest")) {
							if (selenium.getUI().contains("Lightning")) {
								selenium.waitingTime(10000);
								value = selenium.getRandomString();
								String valueURL=value + "@gmail.com";
								selenium.typeData("RequestorEmail", valueURL);
								System.out.println("Requestor Email is :" + valueURL);
								selenium.waitingTime(2000);
								selenium.typeData("RequestorName", value);
								selenium.waitingTime(2000);
								selenium.scrollToElement("ProductNameInfo");
								Select dropdown1 = new Select(selenium.getElement("ProductNameInfo"));
						        dropdown1.selectByIndex(1);
								selenium.waitingTime(2000);
								selenium.scrollToElement("ISBNInfo");
								selenium.typeData("ISBNInfo", value);
								selenium.waitingTime(2000);
								selenium.typeData("DeactivationInfo", value);
								selenium.waitingTime(2000);
								selenium.scrollToElement("SubmitForm");
								selenium.click("SubmitForm");
								selenium.waitingTime(10000);
								if(selenium.isElementPresentFast("Note")) {
								selenium.test.log(LogStatus.PASS, "Form submitted successsfully");
								System.out.println("Form submitted successsfully");
								}
								else {
									System.out.println("Form is not submitted");
									selenium.test.log(LogStatus.FAIL, "Test Case Failed");
									selenium.reportFailure("Test Case Failed");
								}
							}

						}
						if(selenium.getTestCaseName().equalsIgnoreCase("VerifytheInternalCodeRequestFormforSIMnet" ))
						{
						if (selenium.getUI().contains("Lightning")) {
							selenium.waitingTime(10000);
							value = selenium.getRandomString();
							String valueURL=value + "@gmail.com";
							selenium.typeData("RequestorEmail", valueURL);
							System.out.println("Requestor Email is :" + valueURL);
							selenium.waitingTime(2000);
							selenium.typeData("RequestorName", value);
							selenium.waitingTime(2000);
							selenium.typeData("ManagerName", value);							
							selenium.typeData("ProfessorEmail", valueURL);
							System.out.println("Professor Email is :" + valueURL);
							selenium.waitingTime(2000);
							Select dropdown2 = new Select(selenium.getElement("CountryName"));
					        dropdown2.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown3 = new Select(selenium.getElement("StateName"));
					        dropdown3.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown4 = new Select(selenium.getElement("SchoolName"));
					        dropdown4.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown5 = new Select(selenium.getElement("SchoolName"));
					        dropdown5.selectByIndex(11);
							selenium.waitingTime(2000);
							Select dropdown6 = new Select(selenium.getElement("SuperCode"));
					        dropdown6.selectByIndex(1);
							selenium.waitingTime(2000);
							selenium.typeData("NumberOfRedemptions", value);
							selenium.waitingTime(2000);
							Select dropdown7 = new Select(selenium.getElement("Duration"));
					        dropdown7.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown8 = new Select(selenium.getElement("ProductName"));
					        dropdown8.selectByIndex(0);
							selenium.waitingTime(2000);
							selenium.typeData("OfferLink", value);
							selenium.waitingTime(2000);
							Select dropdown9 = new Select(selenium.getElement("ReqType"));
					        dropdown9.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown10 = new Select(selenium.getElement("Reason"));
					        dropdown10.selectByIndex(1);
							selenium.waitingTime(2000);
							selenium.scrollToElement("SubmitForm");
							selenium.click("SubmitForm");
							selenium.waitingTime(10000);
							if(selenium.isElementPresentFast("Note")) {
							selenium.test.log(LogStatus.PASS, "Form submitted successsfully");
							System.out.println("Form submitted successsfully");
							}
							else {
								System.out.println("Form is not submitted");
								selenium.test.log(LogStatus.FAIL, "Test Case Failed");
								selenium.reportFailure("Test Case Failed");
							}
						}
						}	
						
				         if (selenium.isElementPresentFast("loginPopUpNew"))
				         {
				        	System.out.println("I am inside loginPopUpNew method");
				        	selenium.clickLoop("loginPopUpNew");
				        	selenium.waitingTime(2000);	
				         }
				         else if (selenium.isElementPresentFast("loginPopUp"))
						 {
				        	 System.out.println("I am inside loginPopup method");
							 selenium.click("loginPopUp");
							 selenium.waitingTime(2000);
						 }
						
					} catch (Exception e) {

						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Test Case Failed");
					}
					
			 }
			 
			 
			 @And("^I filled the complete form$")
				public void i_filled_the_complete_form() {
					try {
						if(selenium.getTestCaseName().equalsIgnoreCase("VerifytheInternalCodeRequestFormforCodeReq" ))
						{
						if (selenium.getUI().contains("Lightning")) {
							selenium.waitingTime(10000);
							value = selenium.getRandomString();
							String valueURL=value + "@mheducation.com";
							selenium.typeData("RequestorEmail", valueURL);
							System.out.println("Requestor Email is :" + valueURL);
							selenium.waitingTime(2000);
							selenium.typeData("RequestorName", value);
							selenium.waitingTime(2000);
							selenium.typeData("ManagerName", value);							
							if(selenium.isElementPresentFast("SalesVP")) {
							selenium.waitingTime(2000);
							Select dropdown = new Select(selenium.getElement("SalesVP"));
					        dropdown.selectByIndex(1);
							selenium.waitingTime(2000);
							}
							selenium.typeData("ProfessorName", value);
							selenium.waitingTime(2000);
							selenium.typeData("ProfessorEmail", valueURL);
							System.out.println("Professor Email is :" + valueURL);
							selenium.waitingTime(2000);
							selenium.scrollToElement("Name_Field");
							Select dropdown1 = new Select(selenium.getElement("Name_Field"));
					        dropdown1.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown2 = new Select(selenium.getElement("CountryName"));
					        dropdown2.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown3 = new Select(selenium.getElement("StateName"));
					        dropdown3.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown4 = new Select(selenium.getElement("SchoolName"));
					        dropdown4.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown5 = new Select(selenium.getElement("SchoolName"));
					        dropdown5.selectByIndex(11);
							selenium.waitingTime(2000);
							Select dropdown6 = new Select(selenium.getElement("SuperCode"));
					        dropdown6.selectByIndex(1);
							selenium.waitingTime(2000);
							selenium.typeData("NumberOfRedemptions", value);
							selenium.waitingTime(2000);
							Select dropdown7 = new Select(selenium.getElement("Duration"));
					        dropdown7.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown8 = new Select(selenium.getElement("ProductName"));
					        dropdown8.selectByIndex(1);
							selenium.waitingTime(2000);
							selenium.typeData("CourseName", value);
							selenium.waitingTime(2000);
							selenium.typeData("ISBNInfo", value);
							selenium.waitingTime(2000);
							selenium.scrollToElement("AuthorName");
							selenium.typeData("AuthorName", value);
							selenium.waitingTime(2000);
							selenium.typeData("TitleName", value);
							selenium.waitingTime(2000);
							selenium.typeData("EditionName", value);
							selenium.waitingTime(2000);
							Select dropdown9 = new Select(selenium.getElement("CopyRightName"));
					        dropdown9.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown10 = new Select(selenium.getElement("Reason"));
					        dropdown10.selectByIndex(1);
							selenium.waitingTime(2000);
							selenium.scrollToElement("SubmitForm");
							selenium.click("SubmitForm");
							selenium.waitingTime(10000);
							if(selenium.isElementPresentFast("Note")) {
							selenium.test.log(LogStatus.PASS, "Form submitted successsfully");
							System.out.println("Form submitted successsfully");
							}
							else {
								System.out.println("Form is not submitted");
							}
						}
						}
						if(selenium.getTestCaseName().equalsIgnoreCase("VerifytheInternalCodeRequestFormforCartridgeReq")) {
							if (selenium.getUI().contains("Lightning")) {
								selenium.waitingTime(10000);
								value = selenium.getRandomString();
								valueEmailURL=value + "@gmail.com";
								selenium.typeData("RequestorEmail", valueEmailURL);
								System.out.println("Requestor Email is :" + valueEmailURL);
								selenium.waitingTime(2000);
								selenium.typeData("RequestorName", value);
								selenium.waitingTime(2000);
								selenium.typeData("ProfessorName", value);
								selenium.waitingTime(2000);
								selenium.typeData("ProfessorEmail", valueEmailURL);
								System.out.println("Professor Email is :" + valueEmailURL);
								selenium.waitingTime(2000);
								selenium.scrollToElement("Name_Field");
								Select dropdown1 = new Select(selenium.getElement("Name_Field"));
						        dropdown1.selectByIndex(1);
								selenium.waitingTime(2000);
								Select dropdown2 = new Select(selenium.getElement("CountryName"));
						        dropdown2.selectByIndex(1);
								selenium.waitingTime(2000);
								Select dropdown3 = new Select(selenium.getElement("StateName"));
						        dropdown3.selectByIndex(1);
								selenium.waitingTime(2000);
								Select dropdown4 = new Select(selenium.getElement("SchoolName"));
						        dropdown4.selectByIndex(1);
								selenium.waitingTime(2000);
								Select dropdown5 = new Select(selenium.getElement("SchoolName"));
						        dropdown5.selectByIndex(11);
								selenium.waitingTime(2000);
								selenium.typeData("SFDCLink", value);
								selenium.waitingTime(2000);
								Select dropdown6 = new Select(selenium.getElement("Version"));
						        dropdown6.selectByIndex(1);
								selenium.waitingTime(2000);
								selenium.typeData("ISBNInfo", value);
								selenium.waitingTime(2000);
								selenium.typeData("AuthorName", value);
								selenium.waitingTime(2000);
								selenium.typeData("TitleName", value);
								selenium.waitingTime(2000);
								selenium.typeData("EditionName", value);
								selenium.waitingTime(2000);
								Select dropdown7 = new Select(selenium.getElement("CopyRightName"));
						        dropdown7.selectByIndex(1);
								selenium.waitingTime(2000);
								selenium.scrollToElement("SubmitForm");
								selenium.click("SubmitForm");
								selenium.waitingTime(10000);
								if(selenium.isElementPresentFast("Note")) {
								selenium.test.log(LogStatus.PASS, "Form submitted successsfully");
								System.out.println("Form submitted successsfully");
								}
							}
							else {
								System.out.println("Form is not submitted");
							}
						}
						if(selenium.getTestCaseName().equalsIgnoreCase("VerifytheInternalCodeRequestFormforLicenseRemoval" ))
						{
						if (selenium.getUI().contains("Lightning")) {
							selenium.waitingTime(10000);
							value = selenium.getRandomString();
							String valueURL=value + "@gmail.com";
							selenium.typeData("RequestorEmail", valueURL);
							System.out.println("Requestor Email is :" + valueURL);
							selenium.waitingTime(2000);
							selenium.typeData("RequestorName", value);
							selenium.waitingTime(2000);
							selenium.typeData("CustomerName", value);
							selenium.waitingTime(2000);
							selenium.typeData("CustomerEmail", valueURL);
							System.out.println("Customer Email is :" + valueURL);
							selenium.waitingTime(2000);
							Select dropdown2 = new Select(selenium.getElement("CountryName"));
					        dropdown2.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown3 = new Select(selenium.getElement("StateName"));
					        dropdown3.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown4 = new Select(selenium.getElement("SchoolName"));
					        dropdown4.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown5 = new Select(selenium.getElement("SchoolName"));
					        dropdown5.selectByIndex(11);
							selenium.waitingTime(2000);
							Select dropdown6 = new Select(selenium.getElement("ProductNameInfo"));
					        dropdown6.selectByIndex(1);
							selenium.waitingTime(2000);
							selenium.typeData("ISBNInfo", value);
							selenium.waitingTime(2000);
							selenium.typeData("PurchaseDate", value);
							selenium.waitingTime(2000);
							selenium.typeData("DeactivationInfo", value);
							selenium.waitingTime(2000);
							selenium.scrollToElement("SubmitForm");
							selenium.click("SubmitForm");
							selenium.waitingTime(10000);
							if(selenium.isElementPresentFast("Note")) {
							selenium.test.log(LogStatus.PASS, "Form submitted successsfully");
							System.out.println("Form submitted successsfully");
							}
							else {
								System.out.println("Form is not submitted");
							}
						}
						}	
						
				         if (selenium.isElementPresentFast("loginPopUpNew"))
				         {
				        	System.out.println("I am inside loginPopup method");
				        	selenium.clickLoop("loginPopUpNew");
				        	selenium.waitingTime(2000);	
				         }
						
					} catch (Exception e) {

						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Test Case Failed");
					}
					
			 }
			 
			 
			 @And("^I validate the Requestor Name in Case$")
				public void i_validate_the_requestor_name_in_case() {
					try {
						selenium.waitingTime(10000);
						selenium.refresh();
						selenium.waitingTime(10000);
						selenium.scrollToElement("EditDescriptionButton");
						//selenium.scrollToElement("EditDescriptionButton");
						//selenium.scrolldown(-200);
						selenium.waitingTime(3000);
						selenium.waitForElementToBeClickable("EditDescriptionButton");
						selenium.jsClick("EditDescriptionButton");
						selenium.waitingTime(3000);
						System.out.println(value);
						String requestorData= selenium.getDynamicXpath_data("RequestorDetails", value, "endContains");
						System.out.println("Requestor Data is: "+requestorData);
						try {
							selenium.isElementPresentFast(requestorData);
							System.out.println("Requestor Name found correctly");
						}
						catch (Exception e) {
							System.out.println("Requestor Name not found");
						}
						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("CancelEdit");
						selenium.click("CancelEdit");
						selenium.waitingTime(10000);
					}
					catch (Exception e) {

						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Test Case Failed");
					}
			 }
			 
			 @Then("^global search for cases created for Cartridge Request$")
				public void global_search_for_cases_for_cartridge_request()
				{
					try
					{
						selenium.switchBackToParentWindow();
						selenium.refresh();
						System.out.println("String is: "+valueEmailURL);
						selenium.search_data(valueEmailURL);
//						String Xpath = selenium.getDynamicXpath_data("casesStartContains1", valueEmailURL, "endContains");
//						System.out.println("xpath is:" +Xpath);
						selenium.waitingTime(8000);
						if(selenium.isElementPresentFast("CaseTopResult"))
						{
							System.out.println("Inside IF statement");
							selenium.click("CaseTopResult");
						}
						else
						{
							System.out.println("Inside ELSE statement");
							selenium.click("TopResultShowMoreLink");
							selenium.waitForElementToBeClickable("CaseTopResult");
							selenium.click("CaseTopResult");
						}
						selenium.waitingTime(8000);
//						System.out.println(Xpath);
//						selenium.clickLoopXpath(Xpath);
						selenium.jsClick("FirstCaseInGlobalSearchResultPage");
						selenium.waitingTime(10000);
						selenium.test.log(LogStatus.INFO, "Navigated to the desired Case");
					}
					catch (Exception e)
					{
						selenium.test.log(LogStatus.FAIL, "Case navigation failed");
						selenium.reportFailure("Error while navigation to the case" + e.getMessage());
					}
				}

			 @And("^I filled the webform$")
				public void i_filled_the_webform() {
					try {
							selenium.refresh();
							selenium.waitingTime(5000);
							input = selenium.getRandomString();
							String inputURL=input + "@gmail.com";
							System.out.println("Reached here");
							Select dropdown = new Select(selenium.getElement("Product_Nm"));
					        dropdown.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown1 = new Select(selenium.getElement("Contact_Nm"));
					        dropdown1.selectByIndex(1);
					        selenium.waitingTime(2000);
					        selenium.typeData("First_Nm", input);
							selenium.waitingTime(2000);
							selenium.typeData("Last_Nm", input);
							selenium.waitingTime(2000);
							selenium.typeData("Email_Nm", inputURL);
							selenium.waitingTime(2000);
							selenium.typeData("CnfrmEmail_Nm", inputURL);
							selenium.waitingTime(2000);
							Select dropdown2 = new Select(selenium.getElement("Country_Nm"));
					        dropdown2.selectByIndex(1);
					        selenium.waitingTime(2000);
					        Select dropdown3 = new Select(selenium.getElement("State_Nm"));
					        dropdown3.selectByIndex(1);
					        selenium.waitingTime(2000);
					        Select dropdown4 = new Select(selenium.getElement("School_Nm"));
					        dropdown4.selectByIndex(1);
							selenium.waitingTime(2000);
							Select dropdown5 = new Select(selenium.getElement("School_Nm"));
					        dropdown5.selectByIndex(11);
							selenium.waitingTime(2000);
							Select dropdown6 = new Select(selenium.getElement("Learning_Nm"));
					        dropdown6.selectByIndex(1);
					        selenium.waitingTime(2000);
					        selenium.typeData("CourseName", input);
							selenium.waitingTime(2000);
							Select dropdown7 = new Select(selenium.getElement("Help_Nm"));
					        dropdown7.selectByIndex(1);
					        selenium.waitingTime(2000);
					        selenium.typeData("Description_Nm", input);
							selenium.waitingTime(2000);
							
							selenium.scrollToElement("NxtButton");
							selenium.click("NxtButton");
							selenium.waitingTime(10000);
							if(selenium.isElementPresentFast("Note")) {
							selenium.test.log(LogStatus.PASS, "Form submitted successsfully");
							System.out.println("Form submitted successsfully");
							}
							else {
								System.out.println("Form is not submitted");
							}
					
						
					} catch (Exception e) {

						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Test Case Failed");
					}
			 }
			 
			 @And("^I validate the \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" in Case$")
				public void i_validate_the_case_details_in_case(String origin, String incident, String subIncident, String subject) {
					try {
						selenium.refresh();
						selenium.waitingTime(10000);
						selenium.isElementPresentFast(origin);
						selenium.waitingTime(2000);
						selenium.isElementPresentFast(incident);
						selenium.waitingTime(2000);
						selenium.isElementPresentFast(subIncident);
						selenium.waitingTime(2000);
						selenium.isElementPresentFast(subject);						
						selenium.waitingTime(10000);
						selenium.test.log(LogStatus.PASS, "Test Case Passed");
						System.out.println("All element are present. This is a PASS");
					}
					catch (Exception e) {

						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Test Case Failed");
					}
			 }
}
