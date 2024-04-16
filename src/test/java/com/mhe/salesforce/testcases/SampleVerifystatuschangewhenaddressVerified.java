package com.mhe.salesforce.testcases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SampleVerifystatuschangewhenaddressVerified {

	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^click on contact based on account names$")
	public void click_on_contact_based_on_account_names() {
		
		try {

			selenium.waitingTime(3000);
			/*selenium.searchGlobal("Contact Name");

			selenium.waitingTime(8000);		

			
			//String contactXpath = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "endSearchContactWithAccount");
			//String contactXpath = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "accountDymanicSearch");
			String contactXpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
			System.out.println(contactXpath);
			selenium.clickLoopXpath(contactXpath);*/
			selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
			selenium.waitingTime(8000);
			selenium.captureScreenShot();
			
		}
		catch (Exception e) {
		selenium.reportFailure("Error while Searching for contact " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@Then("^New click on contact based on account names$")
	public void New_click_on_contact_based_on_account_names()  {
		   
		   try {
		      

//		      selenium.waitingTime(3000);
		     /* selenium.search("Contact Name");
		      selenium.waitingTime(2000);
		      
		      //String xpath = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "endSearchContactWithAccount");
		      String contactXpath = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "endSearchContactWithAccount");
		      System.out.println(contactXpath);
		      selenium.clickLoopXpath(contactXpath);*/
//		      selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
			  selenium.refresh();
		      selenium.waitingTime(5000);
		      selenium.captureScreenShot();
//		      try{
		         String contactName = selenium.getValueByColumnName("Contact Name");
		         String[] firstName = contactName.split(" ");
		         String contactNameFieldXpath = selenium.getPropertiesObj().getProperty("selectContact").
		               replace("$val", firstName[0]);
		         if(selenium.isElementPresentXpathFast(contactNameFieldXpath)) {
		            selenium.clickXpath(contactNameFieldXpath);
		         }
//		      }catch (Exception e){
//		         //selenium.reportFailure( e.getMessage());
//		         System.out.println(e.getMessage());
//		      }

		   }
		   catch (Exception e) {
		   selenium.reportFailure("Error while Searching for contact " + e.getMessage());
		   selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		   }
		}

	@Then("^I search contact via URL$")
	public void search_contactviaurl() {
		selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
		selenium.waitingTime(4000);
		
	}
	
	
	
	
	@Then("^search for contact with nonverified Address$")
	public void search_for_contact_with_nonverified_Address() {
		
		try {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SearchThisList");
			selenium.click("SearchThisList");
			selenium.waitingTime(2000);
			selenium.type("SearchThisList", "Contact Name");
			selenium.getElement("SearchThisList").sendKeys(Keys.ENTER);
			selenium.waitingTime(2000);
		}
		catch (Exception e) {
		selenium.reportFailure("Error while Searching for contact " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

		}
	@Then("^change Address status to verified on contact$")
	public void change_Address_status_to_verified_on_contact(){
	    try {
//	    	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0031A000027yYPgQAM/view");
	    	selenium.waitingTime(20000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
			}

			if (selenium.isElementPresentFast("showAllLinks")) {
				selenium.waitForElementToBeClickable("showAllLinks");
			selenium.click("showAllLinks");
			}
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("addressLink_new");
				selenium.click("addressLink_new");
			} else {
				selenium.waitForElementToBeClickable("addressLink_new");
				selenium.click("addressLink_new");
			}
	         selenium.waitingTime(6000);
	         selenium.refresh();
	         selenium.waitingTime(10000);
	         String xpath=selenium.getDynamicXpath("spantextContains","AddressFull","endContainsAncestor");

	         System.out.println("The Address xpath is :"+ xpath);
	         selenium.waitingTime(2000);
	         
//	         selenium.scrollToXpathElement(xpath);


	         if(selenium.isElementPresentXpathFast(xpath))
				{
					System.out.println("Address Present");
					if(selenium.waitForElementToBeClickable(xpath)==true)
					{
//						selenium.clickXpath(xpath);
						selenium.jsClickXpath(xpath);
					}
					else
					{
						System.out.println("Reversing List Order..");
				        selenium.click("ContactAddressListStatusColumn");		//reversing the list order
				        selenium.waitingTime(4000);
				        if(selenium.waitForElementToBeClickable(xpath)==true)
				        {
				        	selenium.jsClickXpath(xpath);
				        }
				        else
				        {
							System.out.println("Address Not Present.Reversing List Order..");
							selenium.waitForElementToBeClickable("AddressColumn");
							selenium.jsClick("AddressColumn");
							selenium.waitingTime(6000);
//							selenium.clickXpath(xpath);
					        selenium.waitForXpathElementToBeClickable(xpath);
					        selenium.jsClickXpath(xpath);
				        }
					}

				}
				else
				{
					System.out.println("Address Not Present");
					selenium.waitForElementToBeClickable("AddressColumn");
					selenium.jsClick("AddressColumn");
					selenium.waitingTime(6000);
//					selenium.clickXpath(xpath);
			        selenium.waitForXpathElementToBeClickable(xpath);
			        selenium.jsClickXpath(xpath);
				}
	}
	    catch (Exception e) {
	         selenium.reportFailure("Error while Searching for address " + e.getMessage());
	         selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	         }
	    
	    try{
	       selenium.waitingTime(4000);
	       selenium.refresh();
	       selenium.waitingTime(8000);;
		       if(selenium.isElementPresentFast("verifyAddressButton"))
		       {
		    	   selenium.waitForElementToBeClickable("verifyAddressButton");
		           selenium.jsClick("verifyAddressButton");
		       }
		       else
		       {
		    	   selenium.waitForElementToBeClickable("reverifyAddressButton");
		    	   selenium.jsClick("reverifyAddressButton");
		       }
	       selenium.waitingTime(4000);
	       
	       selenium.switchToMultipleFrame("productframeUat");
	       selenium.waitingTime(4000);
	       selenium.scrollToElement("acceptChanges");
	       
	       if(selenium.isElementPresentFast("acceptChanges"))
	       {
	    	   selenium.waitForElementToBeClickable("acceptChanges");
	          selenium.jsClick("acceptChanges");
	       }
	       }
	       catch (Exception e) {
	            selenium.reportFailure("Error while Searching for Verify Address Button on address verification page " + e.getMessage());
	            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	            }
	   
	   selenium.waitingTime(2000);
	   selenium.switchOutOfFrame();
	   selenium.waitingTime(4000);
	   selenium.captureScreenShot();
	   String status=selenium.getElement("addressStatus").getText();
	   if(status.equals("Verified")){
	      
	      
	      System.out.println("Status verified");
	      selenium.test.log(LogStatus.PASS, "Address verified");
//	      selenium.waitingTime(2000);
	      //String xpath=selenium.getDynamicXpath("spantextContains","Contact Name","endContainsContact");
	      selenium.waitForElementToBeClickable("ContainsContactlink");
	      selenium.jsClick("ContainsContactlink");
	      selenium.waitingTime(4000);
	      selenium.captureScreenShot();
	   }
	   else {
	      selenium.test.log(LogStatus.FAIL, "Address not verified");
	      selenium.reportFailure("Test Case Failed");
	      }
	   }
		
		

	}
