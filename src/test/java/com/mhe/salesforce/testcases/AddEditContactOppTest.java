package com.mhe.salesforce.testcases;

import javax.annotation.processing.SupportedSourceVersion;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEditContactOppTest {
	WebConnector selenium = WebConnector.getInstance();
	String oppurl;
	
//	public String opportunityContactForRemoval="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0067h00000FDPSFAA5/related/Opportunity_Contacts1__r/view";
//	public String opportunityContactForAll="https://mh--uat.sandbox.lightning.force.com/lightning/r/0060y00001FSQaeAAH/related/Opportunity_Contacts1__r/view";
//	public String opportunityContactForAllNew="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006C000000ztiSMIAY/related/Opportunity_Contacts1__r/view";
	
	
	@And("^Removal of Opp Contact From Opportunity by Name")
	public void Opp_Contact_Add_Secondary_removal() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(4000);
//				selenium.navigateToURL(opportunityContactForRemoval);
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("opportunityContactsLink");
				selenium.click("opportunityContactsLink");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("productAddOrEdit");
				selenium.jsClick("productAddOrEdit");
				selenium.waitingTime(6000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(8000);				
				String ContactName= selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name");					
				String contactNameFieldXpathOpp = selenium.getPropertiesObj().getProperty("contactNameSecOpp").
		                replace("<placeholder>",ContactName);
				boolean name=selenium.isElementPresentXpathFast(contactNameFieldXpathOpp);				
				
				
				if (name==true) {

					System.out.println("Primary checkbox Present");					
					String Name= selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name");					
					String contactNameCheckbox = selenium.getPropertiesObj().getProperty("contactNameCheckboxOpp").
			                replace("<placeholder>",Name);
//					selenium.waitForXpathElementToBeClickable(contactNameCheckbox);
					selenium.waitingTime(4000);
					selenium.clickLoopXpath(contactNameCheckbox);
//					selenium.waitingTime(3000);	
					selenium.waitForElementToBeClickable("opportunitiesRemove");
					selenium.click("opportunitiesRemove");
//					selenium.waitingTime(2000);		
					selenium.waitForElementToBeClickable("Button_Save");
					selenium.click("Button_Save");
					selenium.waitingTime(12000);	
				}
			}	
			
		}catch(Exception E) {
			
			selenium.click("opportunitiesToCancel");				
			selenium.test.log(LogStatus.FAIL, "Contact Name Not Found");					
			System.out.println("Contact Name Not Found.");
			selenium.reportFailure("Test Case Failed");
		}
	}
	
//	@And("^Removal of Opp Contact All")
//	public void Removal_of_opp_Contact_All() {
//		try {
//
//			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(4000);
//				selenium.navigateToURL(opportunityContactForAllNew);
////				selenium.waitingTime(6000);
//				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
//				selenium.jsClick("taggedProductAddorEdit");
////				selenium.waitingTime(7000);
//				selenium.waitForElementToBeVisible("OpportunityFrameNew");
//				selenium.switchToFrame("OpportunityFrameNew");
//				selenium.waitingTime(8000);		
////				selenium.waitForElementToBeVisible("contactCheckboxOppPresent1");
//				selenium.click("contactCheckboxOppPresent1");
//				System.out.println("check box clicked");
////				selenium.waitingTime(3000);
//				selenium.waitForElementToBeClickable("opportunitiesRemove");
//				selenium.click("opportunitiesRemove");
////				selenium.waitingTime(8000);		
//				selenium.waitForElementToBeClickable("Button_Save");
//				selenium.click("Button_Save");
//				selenium.waitingTime(15000);
//				
//				
//				}
//			
//			
//		}catch(Exception E) {
//			
//			selenium.click("opportunitiesToCancel");				
//			selenium.test.log(LogStatus.FAIL, "Contact Name Not Found");
//			selenium.reportFailure("Contact Name Not Found");
//			System.out.println("Contact Name Not Found.");
//		}
//	}
	
	
	@And("^Opp Contact Add after Removel")
	public void Opp_Contact_Addition_after_Removal() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				// As in this scenario contact is getting removed ,, adding it back after saving 
				selenium.waitingTime(4000);
//				selenium.navigateToURL(opportunityContactForRemoval);
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("opportunityContactsLink");
				selenium.click("opportunityContactsLink");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("productAddOrEdit");
				selenium.jsClick("productAddOrEdit");
				selenium.waitingTime(6000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(8000);				
				String ContactName= selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name");					
				String contactNameFieldXpathOpp = selenium.getPropertiesObj().getProperty("contactNameSecOpp").
		                replace("<placeholder>",ContactName);
				boolean name=selenium.isElementPresentXpathFast(contactNameFieldXpathOpp);				
				
				
				if (name==false) {

					selenium.waitingTime(2000);
					String Name= selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name");					
					String contactNameCheckbox = selenium.getPropertiesObj().getProperty("contactNameCheckboxOpp").
			                replace("<placeholder>",Name);
					selenium.waitForElementToBeClickable("SearchInputValue");
					selenium.scrollToElement("SearchInputValue");
					selenium.type("SearchInputValue", "contact Name");
					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("searchBtn");
					selenium.click("searchBtn");
//					selenium.waitingTime(4000);
//					selenium.waitForXpathElementToBeClickable(contactNameCheckbox);
					selenium.waitingTime(4000);
					selenium.clickLoopXpath(contactNameCheckbox);
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickableLongerDuration("Addtoopportunity");
					selenium.click("Addtoopportunity");
					selenium.waitingTime(4000);
//					selenium.waitForXpathElementToBeClickable(contactNameCheckbox);
					selenium.waitingTime(4000);
					selenium.clickXpath(contactNameCheckbox);
					System.out.println("check box clicked");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("Button_Save");
					selenium.click("Button_Save");					
					selenium.waitingTime(10000);
					selenium.test.log(LogStatus.PASS, "Secondary contact Added");					
					System.out.println("Secondary contact Added");	
					selenium.waitingTime(5000);
					
				}	

			

		} 
		}catch (Exception e) {

			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
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

				selenium.click("opportunitiesToCancel");				
				selenium.test.log(LogStatus.FAIL, "Contact Name Not Found");
				selenium.reportFailure("Contact Name Not Found");
				System.out.println("Contact Name Not Found.");

			}
		}

	}
	
	
	@And("^Opp Contact Add All")
	public void Opp_Contact_Add_All() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				
				selenium.waitingTime(4000);
//				selenium.navigateToURL(opportunityContactForAllNew);
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("opportunityContactsLink");
				selenium.click("opportunityContactsLink");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("productAddOrEdit");
				selenium.jsClick("productAddOrEdit");
				selenium.waitingTime(6000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(8000);		
				selenium.waitForElementToBeClickable("searchBtn");
					selenium.click("searchBtn");
					selenium.waitingTime(8000);	
					selenium.waitForElementToBeClickable("contactCheckboxOppSearch1");
					selenium.click("contactCheckboxOppSearch1");
					System.out.println("check box clicked");
					selenium.waitingTime(8000);
					selenium.waitForElementToBeClickableLongerDuration("Addtoopportunity");
					selenium.click("Addtoopportunity");
													
//					selenium.waitingTime(8000);	
					selenium.waitForElementToBeClickable("Button_Save");
					
					selenium.click("Button_Save");
					selenium.switchOutOfFrame();
					selenium.waitingTime(10000);
					selenium.waitForElementsToBeVisible("OpportunityContactClick1");
					selenium.test.log(LogStatus.PASS, "All contact added");					
					System.out.println("All contact added");	
					
					
				}	

			

	
		}catch (Exception e) {

			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
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

				selenium.click("opportunitiesToCancel");				
				selenium.test.log(LogStatus.FAIL, "Contact Name Not Found");	
				selenium.reportFailure("Contact Name Not Found");
				System.out.println("Contact Name Not Found.");

			}
		}

	}
	
	@Then("^MHHE Delete Opp$")
    public void MHHEDelete_Opp() {
           try {
        	   
//        	   selenium.waitForElementToBeClickable("oppToclickFromApprovalHistry");
//             selenium.click("oppToclickFromApprovalHistry");
//        	   selenium.navigateToURL(testURL);  
        	   
              // selenium.navigateBack();
        	   selenium.navigateToURL(oppurl);
               selenium.waitingTime(9000);
				selenium.waitForElementToBeClickable("moreActionsBtn");
               
				/*
				 * selenium.waitForElementToBeClickable("moreActionsBtn"); selenium.click("moreActionsBtn");
				 * selenium.waitingTime(2000); selenium.click("deleteBtn");
				 * selenium.waitingTime(4000);
				 * 
				 * selenium.click("DeleteConfirmationButton");
				 */ 
               selenium.click("moreActionsBtn");
				 selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("deleteBtn");
					selenium.click("deleteBtn");
//					 selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("deletePopupBtn");
					 //selenium.click("deleteBtn");
					 selenium.click("deletePopupBtn");
					 selenium.waitingTime(9000);
               
           	   selenium.test.log(LogStatus.PASS, "Created Data deleted");
               
               selenium.captureScreenShot();
//               selenium.waitingTime(5000);
                       
                       
           }

                   catch (Exception e) {
                  selenium.reportFailure("Error while verifying approval" + e.getMessage());
                  selenium.test.log(LogStatus.FAIL, "Test Case Failed");
           }
    }
	
	@Then("^MHHE create new opportunity$")
	public void MHHE_I_create_new_opportunity() {
		try {

			selenium.jsClick("newOpportunityBtn");
			selenium.waitingTime(4000);
			// selenium.switchToFrame("productframeUat");
//			selenium.waitForElementsToBeVisible("newAccountFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("opportunityAccount");

			selenium.type("opportunityAccount", "Account Name");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("spanTitle", "Account Name", "end");
			selenium.waitingTime(2000);

//			selenium.clickLoop("");
			selenium.type("OpportunityMHECourse2", "MHE Course");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("spanTitle", "MHE Course", "end");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("oppurtunityType");

			selenium.selectDropdownText("oppurtunityType", "Opportunity Type");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("salesStageDropdown");
			selenium.selectDropdownText("salesStageDropdown", "Sales Stage");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("oppurtunitySpringEnrollment");
			selenium.type("oppurtunitySpringEnrollment", "Spring Enrollment");
			selenium.waitingTime(3000);
			//selenium.moveTab("oppurtunitySummerEnrollment");
			selenium.captureScreenShot();
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
			selenium.type("oppurtunityFallEnrollment", "Fall Enrollment");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("oppurtunitySummerEnrollment");
			selenium.moveTab("oppurtunitySummerEnrollment");
			selenium.jsClick("ButtonSave");
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
//			selenium.waitingTime(3000);

		}

		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^MHHE Navigate to products section$")
	public void MHHEnavigate_to_products_section() {
		try {
			 oppurl= selenium.getURL();
			selenium.waitForElementToBeClickable("productsSectionForOpportunity");
			selenium.jsClick("productsSectionForOpportunity");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("productAddOrEdit1");
//			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.jsClick("productAddOrEdit1");
			selenium.waitingTime(5000);
		}

		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while navigating to products section " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("^MHHE Addproduct to opportunity$")
	public void MHHEAdd_product_to_opportunity() {
		try {
			selenium.waitingTime(3000);
//			selenium.waitForElementsToBeVisible("productframeUat");
			selenium.switchToMultipleFrame("productframeUat");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("isbnField");
			selenium.click("isbnField");
			selenium.waitingTime(2000);
			selenium.type("isbnField", "ISBN");
			selenium.waitingTime(3000);
//			selenium.waitForElementToBeVisible("searchBtn");
			selenium.click("searchBtn");
//			selenium.waitingTime(20000);
			selenium.waitForElementToBeClickable("selectProductToAddToOpp");
			selenium.click("selectProductToAddToOpp");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");
//			selenium.waitingTime(2000);

//			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.click("Button_Save");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
			selenium.waitForElementToBeVisible("DIscountdurationopportunity");
		}


		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while adding product " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


@Then("^MHHE Request discount for opportunity product$")
public void MHHErequest_discount_for_opportunity_product() {
       try {
    	   selenium.waitForElementToBeVisible("DIscountdurationopportunity");
                    selenium.click("DIscountdurationopportunity");
                    selenium.waitingTime(2000);
//                    selenium.waitForElementsToBeVisible("productframeUat");
                    selenium.switchToMultipleFrame("productframeUat");
                    selenium.waitingTime(3000);
//        			selenium.waitForElementToBeVisible("piuCurrentPrice");
                    selenium.click("piuCurrentPrice");
                    selenium.waitingTime(3000);
                    selenium.type("piuCurrentPrice", "PIU Price");
//                    selenium.waitingTime(3000);
        			selenium.waitForElementToBeClickable("competitivePrice");
                    selenium.click("competitivePrice");
                    selenium.waitingTime(3000);
                    selenium.type("competitivePrice", "Competitive Price");
//                    selenium.waitingTime(3000);
        			selenium.waitForElementToBeClickable("discountSubmissionComments");
                    selenium.click("discountSubmissionComments");
                    selenium.waitingTime(3000);
                    selenium.type("discountSubmissionComments", "Comments");
//                    selenium.waitingTime(3000);
        			selenium.waitForElementToBeClickable("digitalRequiredDropdown");
                    selenium.click("digitalRequiredDropdown");
                    selenium.waitingTime(3000);
                    
                    selenium.selectDropdownText("digitalRequiredDropdown", "Digital Required");
//                    selenium.waitingTime(3000);
        			selenium.waitForElementToBeClickable("adoptionProbability");
                    selenium.click("adoptionProbability");
                    selenium.waitingTime(3000);
                    selenium.selectDropdownText("adoptionProbability", "Adoption Probability");
//                    selenium.waitingTime(3000);
        			selenium.waitForElementToBeVisible("courseStartDate");
                    
                    selenium.click("courseStartDate");
//                    selenium.waitingTime(3000);
        			selenium.waitForElementToBeClickable("needByDate");
                    selenium.click("needByDate");
//                    selenium.waitingTime(3000);
        			selenium.waitForElementToBeClickable("campusesNeedingOffer");
                    selenium.click("campusesNeedingOffer");
                    selenium.waitingTime(3000);
                    selenium.type("campusesNeedingOffer", "Campuses Offer");
//                    selenium.waitingTime(3000);
        			selenium.waitForElementToBeClickable("requestedPrice");
                    
                    selenium.click("requestedPrice");
                    selenium.waitingTime(3000);
                    selenium.type("requestedPrice", "Requested Price");
                    selenium.waitingTime(3000);
//        			selenium.waitForElementToBeVisible("requestedPrice");
                    selenium.moveTab("requestedPrice");
                    selenium.waitingTime(7000);
//        			selenium.waitForElementToBeVisible("DiscountType");
                    selenium.selectDropdownByIndex("DiscountType", "Discount Type");
                    String discount = selenium.getText("discountPrice").toString();
                    String approval = selenium.getText("approvalForDiscount").toString();
                    System.out.println("discount & approval is" + discount + approval);
                    if(discount!=null & approval!=null) {
                    	System.out.println("passed");
                    	selenium.test.log(LogStatus.PASS, "Request Discount page verified successfully");
                    }
//                    selenium.captureScreenShot();
//                    selenium.waitingTime(2000);
        			selenium.waitForElementToBeClickable("submitForApprovalButton");
                    selenium.click("submitForApprovalButton");
                    selenium.waitingTime(5000);
                   boolean alert = selenium.waitForAlertToBeVisible();
                   System.out.println("alert 1"+ alert);
                    selenium.acceptAlert();
                    System.out.println("1st alert accepted");
                    boolean alert1 = selenium.waitForAlertToBeVisible();
                    System.out.println("alert 2"+ alert1);
                    selenium.acceptAlert();
                    System.out.println("2nd alert accepted");
                    selenium.switchOutOfFrame();
                    selenium.waitingTime(5000);
                   
       }

               catch (Exception e) {
              selenium.switchOutOfFrame();
              selenium.reportFailure("Error while submitting request" + e.getMessage());
              selenium.test.log(LogStatus.FAIL, "Test Case Failed");
       }
}

@Then("^MHHE verify approval history$")
public void MHHEverify_approval_history() {
       try {
    	   selenium.waitForElementToBeClickable("approvaHistorySection");
                    selenium.click("approvaHistorySection");
                    selenium.waitingTime(5000);
                    boolean record = selenium.isElementPresentFast("approvalRecords");
                    System.out.println("record present" + record);
                    if(record=true) {
                    	System.out.println("passed test case");
                    	selenium.test.log(LogStatus.PASS, "request discount success");
                    }
                    else {
                    	System.out.println("fail test case");
                    	selenium.test.log(LogStatus.FAIL, "request discount failed");
                    	selenium.reportFailure("request discount failed");
                    }
                    selenium.captureScreenShot();
                    selenium.waitingTime(2000);
                   
                   
       }

               catch (Exception e) {
              selenium.reportFailure("Error while verifying approval" + e.getMessage());
              selenium.test.log(LogStatus.FAIL, "Test Case Failed");
       }
}
	

	
	
}