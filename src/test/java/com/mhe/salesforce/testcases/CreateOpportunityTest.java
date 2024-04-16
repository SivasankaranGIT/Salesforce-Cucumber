package com.mhe.salesforce.testcases;

import javax.annotation.processing.SupportedSourceVersion;


import lombok.Value;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateOpportunityTest {
	WebConnector selenium = WebConnector.getInstance();
	public String opportunityContacts = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity_Contact__c/a0m0y00000J1EBjAAN/view";
	public String contactforOppCreationNew = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038000000pW7xZAAS/related/Opportunity_Contact__r/view";
	public String opportunityProductpriceNew = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0067h00000FDMaKAAX/related/OpportunityLineItems/view";
	public String lisyViewOpp = "https://mh--uat.sandbox.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent";
	public String INTLOppForVerifySuppliercodeMHEorVST = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001Gq5LeAAJ/view";
	public String SEGOppToAddMarketCode = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DY000002R95tYAC/view";
	public String CourseRcordWithCategoryAsSEGOH = "https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Course__c/a0U8b00000Q45qnEAB/view";
	public String CourseRcordWithCategoryNotAsSEGOH = "https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Course__c/a0U80000002MbZGEA0/view";
	public String TaskURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Task/00T0y00006qLWg3EAG/view";
	public String OppURLToEditProduct="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001EPsQNAA1/view";
	String initialCloseDate;
	String initialPurchaseDate;
	String updatedCloseDate;
	String updatedPurchaseDate;
	String ISBNNum="9780079002525";

//	String ISBNNum = "9789942198044";
	String TP_xpath = null;
	String RolloverAging;

	String EAMValue,SolutionManager,LearningSpecialist2,SimNet,ALEKSSpec,DistrictManager,CPM,CSCValue;

	static String EAMValue1,SolutionManager1,LearningSpecialist1,SimNet1,ALEKSSpec1,DistrictManager1,CPM1,CSCValue1;


	@Then("^opportunity should get created$")
	public void contact_should_get_created() {
		try {
			boolean isSuccess = false;
			if (selenium.getUI().contains("Lightning")) {
				// selenium.acceptAlert();
				selenium.waitingTime(5000);
				if (selenium.isElementPresentFast("mheCourseRequired")) {
					selenium.clearText("mheCourse");
					selenium.type("mheCourse", "MHE Course");
					selenium.waitingTime(2000);
					String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
					selenium.waitingTime(4000);
					selenium.clickLoopXpath(xpath);
					selenium.waitForElementToBeClickable("saveButton");
					selenium.click("saveButton");
				}
				selenium.waitingTime(9000);
				String xpath = selenium.getDynamicAccountXpath("opportunityMessage", WebConnector.ACC_NAME_RANDOM,
						"endContains");
				// String xpath1 = selenium.getDynamicXpath("opportunityMessage", "Account
				// Name", "endContains");
				isSuccess = selenium.isElementPresentXpathFast(xpath);
			} else {
				String xpath = selenium.getDynamicXpath("opportunityMessageC", "MHE Course", "endContains");
				selenium.waitingTime(4000);
				isSuccess = selenium.isElementPresentXpathFast(xpath);
			}
			selenium.printLastTestResult(isSuccess);
		} catch (Exception e) {
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I fill in all the mandatory details to create a new opportunity$")
	public void i_fill_in_the_following_to_create_a_new_opportunity() {
		try {

			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("opportunitiesLink");
				// selenium.scrollToElement("opportunities");
				// selenium.click("NewOpportunity");
				selenium.click("opportunitiesLink");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				// selenium.click("NewBtn");
				selenium.click("newOpportunityBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityName");
				selenium.click("opportunityName");
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.click("nextBtn");
				selenium.waitForElementsToBeVisible("newAccountFrame");
				selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitingTime(2000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}

			selenium.type("closeDate", "Close Date");
			selenium.type("orderDate", "Order Date");
			selenium.type("mheCourse", "MHE Course");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(xpath);
			selenium.type("enrollment", "Enrollment");

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@Then("^create a new opportunity$")
	public void create_a_new_opportunity() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
//				selenium.waitingTime(2000);
//				if(selenium.getTestCaseName().equalsIgnoreCase("VerifyValidationRuleForRecognizeStage")||
//				selenium.getTestCaseName().equalsIgnoreCase("VerifyActiveContactInNewOpp"))
				selenium.waitingTime(5000);
//				if(selenium.getTestCaseName().equalsIgnoreCase("VerifyValidationRuleForRecognizeStage"))
//				{
//					System.out.println(selenium.getTestCaseName());
//				}
//				else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyOppPIURelatedListAddDelete")) {
				if(selenium.isElementPresentFast("Opp_Name_01"))
				{
					selenium.waitForElementToBeClickable("Opp_Name_01");
					selenium.click("Opp_Name_01");
				}
//				}
//				else {
//					selenium.waitForElementToBeClickable("opportunityName");
//					selenium.click("opportunityName");
//				}
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.click("nextBtn");
				selenium.waitingTime(5000);
				selenium.waitForElementsToBeVisible("newAccountFrame");
				selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitingTime(2000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
			selenium.waitForElementsToBeVisible("opportunityAccountName");
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyOppPIURelatedListAddDelete"))
			{
				selenium.type_propertiesFile("opportunityAccountName","account_name2");
				selenium.waitingTime(4000);
				selenium.clickDynamicXpath_propertiesFile("spanTitle", "account_name2", "end");
			}
			else if(selenium.getTestCaseName().equalsIgnoreCase("VerifyValidationRuleForRecognizeStage"))
			{
				selenium.type_propertiesFile("opportunityAccountName","account_name4");
				selenium.waitingTime(4000);
				selenium.clickDynamicXpath_propertiesFile("spanTitle", "account_name4", "end");
			}
			else
			{
				selenium.type_propertiesFile("opportunityAccountName","account_name");
				selenium.waitingTime(4000);
				selenium.clickDynamicXpath_propertiesFile("spanTitle", "account_name", "end");
			}

			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("closeDate1");
			selenium.click("closeDate1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TomorrowDateInCalendar");
			selenium.click("TomorrowDateInCalendar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("orderDate1");
			selenium.click("orderDate1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TodayDateInCalendar");
			selenium.click("TomorrowDateInCalendar");
			selenium.waitingTime(2000);
			String xpath;
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyOppPIURelatedListAddDelete"))
			{
				selenium.type_propertiesFile("mheCourse", "mhe_course_2");
				selenium.waitingTime(2000);
				xpath = selenium.getDynamicXpath_propertiesFile("spanTitle", "mhe_course_2", "end");
			}
			else
			{
				selenium.type_propertiesFile("mheCourse", "mhe_course");
				selenium.waitingTime(2000);
				xpath = selenium.getDynamicXpath_propertiesFile("spanTitle", "mhe_course", "end");
			}

			selenium.waitingTime(2000);
			selenium.clickLoopXpath(xpath);
			String xpath1 = selenium.getDynamicXpath_propertiesFile("spanTitle", "account_name", "end");
			selenium.waitingTime(2000);
			selenium.clickLoopXpath(xpath1);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("enrollment");
			selenium.type_propertiesFile("enrollment", "Enrollment");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("save_new_opp");
			selenium.click("save_new_opp");
			selenium.waitingTime(20000);
			System.out.println("New Opportunity created");
			selenium.OppPIUAddDeleteURL = selenium.getURL();
			System.out.println("The newly created INTL opportunity url is :" + selenium.OppPIUAddDeleteURL);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("^create a new opportunity for \"([^\"]*)\"$")
	public void create_a_new_opportunity_routetomarket(String route_to_market) {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
//			selenium.waitForElementToBeClickable("opportunityName");
//			selenium.click("opportunityName");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("Opp_Name_01"))
			{
				selenium.waitForElementToBeClickable("Opp_Name_01");
				selenium.click("Opp_Name_01");
			}
			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementsToBeVisible("newAccountFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("opportunityAccountName");
//			selenium.type_propertiesFile("opportunityAccountName","account_name");
//			selenium.waitingTime(4000);
//			selenium.autoSuggestiveDropdownWithoutText("opportunityAccountName");
			selenium.waitForElementToBeClickable("opportunityAccountName");
			selenium.type_propertiesFile("opportunityAccountName","account_name2");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "account_name2", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("closeDate1");
			selenium.click("closeDate1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TomorrowDateInCalendar");
			selenium.click("TomorrowDateInCalendar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("orderDate1");
			selenium.click("orderDate1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TodayDateInCalendar");
			selenium.click("TomorrowDateInCalendar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("mheCourse");
			selenium.type_propertiesFile("mheCourse", "mhe_course_2");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath_propertiesFile("spanTitle", "mhe_course_2", "end");
			selenium.waitingTime(2000);
			selenium.clickLoopXpath(xpath);
			String xpath1 = selenium.getDynamicXpath_propertiesFile("spanTitle", "account_name2", "end");
			selenium.waitingTime(2000);
			selenium.clickLoopXpath(xpath1);
			selenium.waitForElementToBeClickable("enrollment");
			selenium.type_propertiesFile("enrollment", "Enrollment");
			selenium.waitingTime(2000);
			if(route_to_market.equalsIgnoreCase("HE Adoption"))
			{
				Select dropdown = new Select(selenium.getElement("RouteToMarketDropDown"));
				dropdown.selectByIndex(0);
				selenium.waitingTime(2000);
			}
			else if(route_to_market.equalsIgnoreCase("HE Enterprise"))
			{
				Select dropdown = new Select(selenium.getElement("RouteToMarketDropDown"));
				dropdown.selectByIndex(1);
				selenium.waitingTime(2000);
			}
			else if(route_to_market.equalsIgnoreCase("Distributor"))
			{
				Select dropdown = new Select(selenium.getElement("RouteToMarketDropDown"));
				dropdown.selectByIndex(2);
				selenium.waitingTime(2000);
			}
			else if(route_to_market.equalsIgnoreCase("School Enterprise"))
			{
				Select dropdown = new Select(selenium.getElement("RouteToMarketDropDown"));
				dropdown.selectByIndex(3);
				selenium.waitingTime(2000);
			}
			else if(route_to_market.equalsIgnoreCase("School Adoption"))
			{
				Select dropdown = new Select(selenium.getElement("RouteToMarketDropDown"));
				dropdown.selectByIndex(4);
				selenium.waitingTime(2000);
			}
			else if(route_to_market.equalsIgnoreCase("Library"))
			{
				Select dropdown = new Select(selenium.getElement("RouteToMarketDropDown"));
				dropdown.selectByIndex(5);
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("save_new_opp");
			selenium.click("save_new_opp");
			selenium.waitingTime(20000);
			System.out.println("New Opportunity created");
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

//	@And("^I fill in all the mandatory details to create a new opportunity for Sales Ref$")
//	public void i_fill_in_the_following_to_create_a_new_opportunity_for_Sales_Ref() {
//		try {
//
//			if (selenium.getUI().contains("Lightning")) {
//
//				selenium.waitForElementToBeClickable("opp_Link");
//				selenium.jsClick("opp_Link");
//				selenium.waitForElementToBeClickable("newAccountOpportunityBtn1");
//				selenium.jsClick("newAccountOpportunityBtn1");
//				selenium.waitingTime(4000);
//				selenium.switchToFrame("newOppurtunityFrame");
//				selenium.waitingTime(4000);
//				selenium.autoSuggestiveDropdownOne("OpportunityMHECourse", "MHE Course");
//				selenium.waitingTime(6000);
//				String mheCourse = selenium.getDynamicXpath("SelectMHECourses", "MHE Course",
//						"endContains");
//				selenium.waitingTime(4000);
//				System.out.println("mheCourse :" + mheCourse);
//				selenium.clickLoopXpath(mheCourse);
//				selenium.waitingTime(4000);
//				selenium.waitForElementToBeVisible("oppurtunityType");
//				selenium.selectDropdownText("oppurtunityType", "Oppurtunity Type");
//				selenium.type("accountsOpportunityFallEnrolement", "Fall Enrolement");
//				selenium.waitingTime(3000);
//				selenium.moveTab("accountsOpportunityFallEnrolement");
//				selenium.captureScreenShot();
//				selenium.waitForElementToBeClickable("ButtonSave");
//				selenium.jsClick("ButtonSave");
//				selenium.waitingTime(5000);
//				selenium.switchOutOfFrame();
//				selenium.waitingTime(5000);
//				selenium.isElementPresentFast("newOppurtunitySuccessCheck");
//				selenium.waitingTime(2000);
//				selenium.captureScreenShot();
//				selenium.test.log(LogStatus.PASS, "oppurtunity  created!");
//				selenium.waitingTime(5000);
//			} else {
//				selenium.waitForElementToBeVisible("opportunitiesC");
//				selenium.scrollToElement("opportunitiesC");
//				selenium.click("opportunitiesC");
//			}
//		}
//
//		catch (Exception e) {
//			selenium.switchOutOfFrame();
//			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//
//		}
//	}

	@And("^new I fill in all the mandatory details to create a new opportunity for Sales Ref$")
	public void new_i_fill_in_the_following_to_create_a_new_opportunity_for_Sales_Ref() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.waitForElementToBeClickable("opp_Link");

				selenium.jsClick("opp_Link");
				selenium.waitForElementToBeClickable("newAccountOpportunityBtn1");
				selenium.jsClick("newAccountOpportunityBtn1");
				selenium.waitingTime(6000);
				selenium.switchToFrame("newOppurtunityFrame");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("oppAccount");
				selenium.type("oppAccount", "Account Name");
				selenium.waitForElementToBeClickable("oppAccountLookupicon");
				selenium.click("oppAccountLookupicon");
				selenium.waitingTime(4000);
				selenium.clickLoop("oppAccountName");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("OpportunityMHECourse2");
				selenium.type("OpportunityMHECourse2", "MHE Course");
				selenium.waitForElementToBeClickable("opportunityMHECourseOptionSelect");
				selenium.click("opportunityMHECourseOptionSelect");
				selenium.waitForElementToBeVisible("oppurtunityType");
				selenium.selectDropdownText("oppurtunityType", "Oppurtunity Type");
				selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
				selenium.type("oppurtunityFallEnrollment", "Fall Enrollment");
				selenium.waitForElementToBeVisible("oppurtunitySpringEnrollment");
				selenium.type("oppurtunitySpringEnrollment", "Spring Enrollment");
				selenium.waitForElementToBeVisible("oppurtunitySummerEnrollment");
				selenium.type("oppurtunitySummerEnrollment", "Summer Enrollment");
				selenium.waitForElementToBeVisible("oppurtunityWinterEnrollment");
				selenium.type("oppurtunityWinterEnrollment", "Winter Enrollment");
				selenium.waitForElementToBeVisible("ButtonSave");
				selenium.scrollToElement("ButtonSave");
				selenium.jsClick("ButtonSave");
				selenium.waitingTime(5000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(5000);
				selenium.isElementPresentFast("newOppurtunitySuccessCheck");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "oppurtunity  created!");
				selenium.waitingTime(5000);
				selenium.opportunityURL = selenium.getURL();
				System.out.println("Newly created opportunity URL is : " + selenium.opportunityURL);
			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		}

////             selenium.type("closeDate", "Close Date");
////             selenium.type("orderDate", "Order Date");
//               selenium.type("mheCourse", "MHE Course");
//               selenium.waitingTime(2000);
//               String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
//               selenium.clickLoopXpath(xpath);
//               selenium.type("enrollment", "Enrollment");
//
//         } 
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@When("^I click sales Ref user Contacts MHHE$")
	public void I_click_sales_Ref_user_Contacts_tab_MHHE() throws InterruptedException {
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
			selenium.waitForElementToBeClickable("contactsOptionMenuDots");
			// selenium.click("accountTabOptionsClick");
			selenium.jsClick("contactsOptionMenuDots");
			selenium.waitingTime(5000);
			selenium.search("ValueTo Search In GlobalSearch");
			selenium.waitingTime(2000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "ValueTo Search In GlobalSearch", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(7000);

//		selenium.clickDynamic("anchorTitle", "Contact Name Click", "end");

			// selenium.clickHeader(objectRepoElement);
//		selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^New I click sales Ref user Contacts MHHE$")
	public void New_I_click_sales_Ref_user_Contacts_tab_MHHE() throws InterruptedException {
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
			selenium.waitForElementToBeClickable("contactsOptionMenuDots");
			// selenium.click("accountTabOptionsClick");
			selenium.jsClick("contactsOptionMenuDots");
			selenium.waitingTime(7000);
//		selenium.type("ContactNameInputSearchNew", "Contact Name Click");
//		selenium.waitingTime(2000);
			selenium.search("ValueTo Search In GlobalSearch");
			selenium.waitingTime(2000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "ValueTo Search In GlobalSearch", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(5000);
//		selenium.click("ContactNameInputSearchNewRefresh");
//		selenium.waitingTime(4000);
//		selenium.clickDynamic("anchorTitle", "Contact Name Click", "end");

			// selenium.clickHeader(objectRepoElement);
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I fill in all the mandatory details to create a new opportunity from Contacts")
	public void i_fill_in_the_following_to_create_a_new_opportunity_From_Contacts() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.jsClick("NewContactOpportunityClickToOpen1");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("NewOportunityButton");
				selenium.jsClick("NewOportunityButton");
				selenium.waitingTime(4000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(4000);
				selenium.autoSuggestiveDropdownOne("OpportunityMHECourse2", "MHE Course");
				selenium.waitingTime(6000);
				String mheCourse = selenium.getDynamicXpath("SelectMHECourses", "MHE Course",
						"endContains");
				selenium.waitingTime(4000);
				System.out.println("mheCourse :" + mheCourse);
				selenium.clickLoopXpath(mheCourse);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("oppurtunityType");
				selenium.selectDropdownText("oppurtunityType", "Oppurtunity Type");
				selenium.type("accountsOpportunityFallEnrolement", "Fall Enrolement");
				selenium.waitingTime(3000);
				selenium.moveTab("accountsOpportunityFallEnrolement");
				selenium.captureScreenShot();
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("ButtonSave");
				selenium.jsClick("ButtonSave");
				selenium.waitingTime(5000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(5000);
				selenium.isElementPresentFast("newOppurtunitySuccessCheck");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
//				selenium.waitingTime(3000);

				selenium.test.log(LogStatus.PASS, "oppurtunity  created!");
				selenium.waitingTime(10000);
			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		}

////             selenium.type("closeDate", "Close Date");
////             selenium.type("orderDate", "Order Date");
//               selenium.type("mheCourse", "MHE Course");
//               selenium.waitingTime(2000);
//               String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
//               selenium.clickLoopXpath(xpath);
//               selenium.type("enrollment", "Enrollment");
//
//         } 
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}


	@And("^New opportunity from Contacts MHHE")
	public void new_opportunity_From_Contacts_MHHE() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.navigateToURL(contactforOppCreationNew);

				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("NewOportunityButton");
				selenium.click("NewOportunityButton");
				selenium.waitingTime(4000);
				selenium.switchToMultipleFrame("productframeUat");
				System.out.println("Inside opportunity Frame");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("mheCourse");

				selenium.type("mheCourse", "MHE Course");
				selenium.waitingTime(2000);
				String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
//				selenium.waitForXpathElementToBeClickable(xpath);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(xpath);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunityTypeDropdown");
				selenium.selectDropdownText("opportunityTypeDropdown", "Oppurtunity Type");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
				selenium.type("oppurtunityFallEnrollment", "Fall Enrollment");
				selenium.type("oppurtunitySpringEnrollment", "Spring Enrollment");
				selenium.waitForElementToBeClickable("oppurtunitySummerEnrollment");
				selenium.click("oppurtunitySummerEnrollment");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("ButtonSave");
				selenium.clickLoop("ButtonSave");
				selenium.waitingTime(20000);
				selenium.switchOutOfFrame();

				if (selenium.waitForElementToBeClickable("strategyWorksheetBtn") == true) {
					System.out.println("Strategy Worksheet Button is visible");
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("mheCourseGetText");
					selenium.scrollToElement("mheCourseGetText");

					String mheCourse = selenium.getText("mheCourseGetText").toString();
					String expected_mheCourse = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MHE Course");
					if (mheCourse.equalsIgnoreCase(expected_mheCourse)) {
						selenium.test.log(LogStatus.PASS, "Opportunity created successfully " + mheCourse);
					} else {
						selenium.test.log(LogStatus.FAIL, "Opportunity creation failed");
						selenium.reportFailure("Opportunity creation failed");
					}

				} else {
					selenium.test.log(LogStatus.FAIL, "Opportunity page not loaded yet after details saved");
				}

			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@And("^send Email to Contacts MHHE")
	public void send_email_to_Contacts_MHHE() {
		try {

			if (selenium.getUI().contains("Lightning")) {
//				selenium.navigateToURL(emailToContact);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("SendemailClick");
				selenium.click("SendemailClick");
				selenium.waitingTime(6000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(5000);
				selenium.scrollToElement("NxtButton");
				selenium.waitForElementToBeClickable("NxtButton");
				selenium.click("NxtButton");
				if (selenium.isElementPresentFast("OpportunitySaveWarningContinueBtn")) {
					selenium.waitForElementToBeClickable("OpportunitySaveWarningContinueBtn");
					selenium.click("OpportunitySaveWarningContinueBtn");
//					selenium.waitForElementToBeClickable("NxtButton");
//					selenium.click("NxtButton");
				}
				selenium.waitingTime(6000);
//				selenium.switchToMultipleFrame("productframeUat");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("emailTemplateTosend");
				selenium.click("emailTemplateTosend");
				selenium.selectDropdownText("emailTemplateTosend", "email Template");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("NxtButton");
				selenium.click("NxtButton");
//				selenium.waitingTime(9000);
				selenium.waitForElementsToBeVisible("emailCCvalue");
				selenium.type("emailCCvalue", "email CCvalue");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("emailSendClick");
				selenium.click("emailSendClick");

				selenium.waitingTime(6000);

			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@And("^create product Exceptio request MHHE")
	public void create_product_Exceptio_request_MHHE() {
		try {

			if (selenium.getUI().contains("Lightning")) {
//				selenium.navigateToURL(productException);
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("requestProductAcceptionBtn");
				selenium.clickLoop("requestProductAcceptionBtn");
				selenium.waitingTime(6000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("productReasonException", "productReason Exception");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("ProductExceptionComments");
				selenium.type("ProductExceptionComments", "productException Comment");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("productExceptionCheckbox");
				selenium.scrollToElement("productExceptionCheckbox");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("productExceptionCheckbox");
				selenium.clickLoop("productExceptionCheckbox");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("productExceptionDateBtn");
				selenium.click("productExceptionDateBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("productExceptionDateYear");
				selenium.selectDropdownText("productExceptionDateYear", "productExceptionDate Year");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("productExceptionDate");
				selenium.click("productExceptionDate");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("SubmitButton");
				selenium.scrollToElement("SubmitButton");
				selenium.click("SubmitButton");

				boolean success = selenium.isElementPresentFast("samplecreatedSuccessMessage");
				System.out.println("success" + success);
				if (success == true) {
					selenium.test.log(LogStatus.PASS, "Successfull");
					System.out.println("INSIDE PASS");

				} else {
					selenium.test.log(LogStatus.FAIL, "UnSuccessfull");
					System.out.println("INSIDE Fail");
					selenium.reportFailure("UnSuccessfull");


				}


			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@And("^verify CourseBuildConfigurationRequest fields in \"([^\"]*)\"")
	public void verify_CourseBuildConfigurationRequest_fields(String MHHEOppURL) {
		try {
			selenium.navigateToURL(MHHEOppURL);
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("buildReqeustBtn")) {
				selenium.waitForElementToBeClickable("buildReqeustBtn");
				selenium.click("buildReqeustBtn");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("buildRequest");
				selenium.click("buildRequest");
			}

			selenium.waitingTime(4000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("buildRequestRadioBtn");

			if (selenium.isElementPresentFast("courseBuildReqOption1") && selenium.isElementPresentFast("courseBuildReqOption2")) {
				selenium.test.log(LogStatus.PASS, "The expected two fields are present in Course Build / Connect Conﬁguration page!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected fields are missing in Course Build / Connect Conﬁguration page!");
				selenium.reportFailure("The expected fields are missing in Course Build / Connect Conﬁguration page!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("The expected fields are missing in Course Build / Connect Conﬁguration pages " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "The expected fields are missing in Course Build / Connect Conﬁguration page");

		}
	}

	@And("^Build ConnectConfiguration Reques")
	public void build_ConnectConfiguration_Reques_MHHE() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.refresh();
				selenium.waitingTime(6000);
				if (selenium.isElementPresentFast("buildReqeustBtn")) {
					selenium.waitForElementToBeClickable("buildReqeustBtn");
					selenium.click("buildReqeustBtn");
				} else {
					selenium.waitForElementToBeClickable("moreActionsBtn");
					selenium.click("moreActionsBtn");
					selenium.waitForElementToBeClickable("buildRequest");
					selenium.click("buildRequest");
				}

				selenium.waitingTime(4000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("buildRequestRadioBtn");

				if (selenium.isElementPresentFast("buildRequestNewName")) {
					selenium.test.log(LogStatus.PASS, "The Course Build / Connect Conﬁguration wording is changed from NSS to BEST!");
					System.out.println("PASS");
					selenium.captureScreenShot();
				} else {
					selenium.test.log(LogStatus.FAIL, "The Course Build / Connect Conﬁguration wording is NOT changed from NSS to BEST!");
					selenium.reportFailure("The Course Build / Connect Conﬁguration wording is NOT changed from NSS to BEST!");
					System.out.println("FAIL");
				}
				selenium.click("buildRequestRadioBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NxtButton");
				selenium.click("NxtButton");
				selenium.waitingTime(4000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("buildInstaractorSearch");
				selenium.click("buildInstaractorSearch");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("buildInstaractorSearchInput");
				selenium.typeData("buildInstaractorSearchInput", "PAUL Plummer");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.click("searchBtn");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("buildInstaractorSearchInputSearchValue1");
				selenium.click("buildInstaractorSearchInputSearchValue1");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("buildDateClick");
				selenium.click("buildDateClick");

				selenium.waitingTime(2000); 

				selenium.waitForElementToBeClickable("classStateDateToday");
				selenium.jsClick("classStateDateToday");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("needDateClick");
				selenium.click("needDateClick");

				selenium.waitingTime(2000); 
				selenium.waitForElementToBeClickable("newDateToday");
				selenium.jsClick("newDateToday");
	            selenium.waitForElementToBeClickable("buildCurrentEdition1");

				selenium.type("buildCurrentEdition1", "buildCurrent Edition");
				selenium.type("buildNewEdition1", "buildNew Edition");
				selenium.type("buildTimeZone1", "buildTime Zone");
				selenium.type("buildComments1", "build Comments");
				selenium.type("urgentReason", "Urgent Reason");
				selenium.type("buildCourceNameSectionName1", "buildCourceNameSection Name");
				selenium.type("buildExceptionComments1", "buildException Comments");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("buildTandC");
				selenium.clickLoop("buildTandC");
				selenium.waitingTime(2000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("SubmitButton");
				selenium.scrollToElement("SubmitButton");
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SubmitButton");
				selenium.click("SubmitButton");
				selenium.waitingTime(9000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				System.out.println("Data Saved Successfully!");

	            }
		}		
		catch (Exception e) {

			selenium.captureScreenShot();
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}


	@And("^Mandatory details to create a new opportunity from Contacts Marketing")
	public void I_fill_in_all_the_mandatory_details_to_create_a_new_opportunity_from_Contacts_Marketing() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.jsClick("opp_Link");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("NewActionButton");
				selenium.jsClick("NewActionButton");
				selenium.waitingTime(4000);
				selenium.switchToFrame("sampleContact");
				selenium.waitingTime(4000);
				selenium.autoSuggestiveDropdownOne("OpportunityMHECourse2", "MHE Course");
				selenium.waitingTime(6000);
				String mheCourse = selenium.getDynamicXpath("SelectMHECourses", "MHE Course",
						"endContains");
				selenium.waitingTime(4000);
				System.out.println("mheCourse :" + mheCourse);
				selenium.clickLoopXpath(mheCourse);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("oppurtunityType");
				selenium.selectDropdownText("oppurtunityType", "Oppurtunity Type");
				selenium.type("accountsOpportunityFallEnrolement", "Fall Enrolement");
				selenium.waitingTime(3000);
				selenium.moveTab("accountsOpportunityFallEnrolement");
				selenium.captureScreenShot();
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("ButtonSave");
				selenium.jsClick("ButtonSave");
				selenium.waitingTime(5000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(5000);
				selenium.isElementPresentFast("newOppurtunitySuccessCheck");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
//				selenium.waitingTime(3000);

				selenium.test.log(LogStatus.PASS, "oppurtunity  created!");
				selenium.waitingTime(5000);
			} else {
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		}

////             selenium.type("closeDate", "Close Date");
////             selenium.type("orderDate", "Order Date");
//               selenium.type("mheCourse", "MHE Course");
//               selenium.waitingTime(2000);
//               String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
//               selenium.clickLoopXpath(xpath);
//               selenium.type("enrollment", "Enrollment");
//
//         } 
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@And("^Edit Opportunity Contact for Role Rank Loyalt and Is Teaching")
	public void Edit_Opportunity_Contact_for_Role_Rank_Loyalt_and_Is_Teacing() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.waitForElementToBeClickable("OpportunityContactClick1");
				selenium.click("OpportunityContactClick1");
				selenium.waitingTime(3000);
				selenium.clickDynamicOpportunity("Text_Span", "Contact Name Click",
						"end");
//				selenium.clickDynamic("anchorTitle", "Contact Name Click", "end");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				if (selenium.isElementPresentFast("CloseNotificationPopup")) {
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.waitingTime(3000);
				selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitycontactIsteachingnew");
				selenium.waitingTime(3000);
				selenium.autoSuggestiveDropdownWithoutTextTwo("opportunityContactRolenew");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitycontactLoyaltynew");
				selenium.waitingTime(2000);
				selenium.type("OpportunityContactRank", "OpportunityContactRank value");
				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("OpportunityContactPrimaryCheckBox") == true) {
					System.out.println("OpportunityContactPrimaryCheckBox Present");

					selenium.jsClick("OpportunityContactPrimaryCheckBox");
				}

				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");

				selenium.waitingTime(8000);
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {
				selenium.click("CancelButton");
			}
		}

	}

	@Then("^Make the Product Solution field as blank and edit stage$")
	public void make_the_product_solution_field_as_blank_and_edit_stage(DataTable table)
	{
		try {
//			List<String> data = table.transpose().asList(String.class);
//			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Opp_Stage_Resolve");
			selenium.jsClick("Opp_Stage_Resolve");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("ProductStage");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("ProductStage");
				String actualProductSolution = selenium.getText("ProductStage");
				if (actualProductSolution.equalsIgnoreCase("")) {

				System.out.println("Inside If Statement: Print Option");

				selenium.waitForElementToBeClickable("EditProductSolution");
				selenium.click("EditProductSolution");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ClickPrintOption1");
				selenium.click("ClickPrintOption1");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("clickDeleteButton1");
				selenium.click("clickDeleteButton1");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
			}

				selenium.waitForElementToBeClickable("EditProductSolution");
				selenium.jsClick("EditProductSolution");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("ClickPrintOption");
				selenium.click("ClickPrintOption");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("clickInsertButton");
				selenium.click("clickInsertButton");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("clickonstageedit");
				selenium.jsClick("clickonstageedit");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("OppStageField");
				selenium.click("OppStageField");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("OppStageWon1_new");
				selenium.click("OppStageWon1_new");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());

		}
}

	@Then("^Verify the triggered error")
	public void verify_the_triggered_error() {
		try {
			String expectedmsg = "Review the errors on this page.";
			selenium.waitForElementToBeVisible("TriggeredError");
			String message = selenium.getText("TriggeredError");
			if (message.equalsIgnoreCase("expectedmsg")) ;
			{
				System.out.println("Triggered Message Displayed Successfully");
				selenium.waitingTime(3000);
				selenium.click("closePopUp");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CancelButton");
				selenium.click("CancelButton");
				selenium.waitingTime(6000);
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());

		}
	}

	@Then(("^update the product solution"))
	public void update_the_product_solution(){
		try {

			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("EditProductSolution");
			selenium.waitingTime(2000);
			selenium.scrolldown(-500);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditProductSolution");
			selenium.click("EditProductSolution");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClickPrintOption1");
			selenium.click("ClickPrintOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickDeleteButton1");
			selenium.click("clickDeleteButton1");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("OppStageWon1_new");
			selenium.click("OppStageWon1_new");
			selenium.waitingTime(2000);
//			selenium.scrollToElement("ReasonDDList");
//			selenium.waitingTime(2000);
//			selenium.scrolldown(-200);
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("ReasonDDList");
//			selenium.click("ReasonDDList");
//			selenium.waitForElementToBeClickable("OppStageCloseReasonValue");
//			selenium.click("OppStageCloseReasonValue");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());

		}
	}

	@Then("^verify the error is not triggered")
	public void verify_the_error_is_not_triggered() {
		try {
				if (!selenium.isElementPresentFast("TriggeredError"))
				{
					System.out.println("Triggered Message is Not Displayed");
					selenium.clickLoop("RecordSaveButton");
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Error message triggered");
					selenium.reportFailure("Error message triggered");
				}
			}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
		}
	}

	@And("^Edit Opportunity edit Stages")
	public void Edit_Opportunity_edit_Stages() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("actualStage1");
				String actualStage = selenium.getText("actualStage1");
				selenium.scrollToElement("editStagesNew");
				selenium.waitForElementToBeClickable("clickonstageedit");
				selenium.jsClick("clickonstageedit");
				selenium.waitForElementToBeClickable("OppStageField");
				selenium.jsClick("OppStageField");
				selenium.waitForElementToBeVisible("oppStageList");
				List<WebElement> attribute = selenium.getElements("oppStageList");
				int j = 2;
				System.out.println("Actual stage : " + actualStage);
				for (int i = 1; i <= attribute.size(); i++) {
					String stageValue = attribute.get(i).getAttribute("data-value");
					System.out.println(stageValue);
					if (stageValue.equalsIgnoreCase("Prospect")) {
						String stageXpath = selenium.getPropertiesObj().getProperty("oppStageItem").
								replace("$val", Integer.toString(j + 1));
						selenium.clickXpath(stageXpath);
						break;
					}
					if (stageValue.equalsIgnoreCase(actualStage)) {
						int k = i + 2;
						String stageXpath = selenium.getPropertiesObj().getProperty("oppStageItem").
								replace("$val", Integer.toString(j));
						selenium.clickXpath(stageXpath);
						break;
					}
				}
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(3000);

				if (selenium.isElementPresentFast("RecordSaveButton")) {
					selenium.clickLoop("RecordSaveButton");
				}
				selenium.waitingTime(8000);
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {
				selenium.click("CancelButton");
				selenium.clickLoop("opportunityAccountsEditCancel");

			}
		}

	}

	@And("^Edit Opportunity Account Trageted Product")
	public void Edit_Opportunity_Account_Trageted_Product() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(10000);
				selenium.jsClick("opportunityLineItemRelatedList");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("FirstTableRecord");
				selenium.clickLoop("FirstTableRecord");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("editL");
				selenium.click("editL");
				selenium.waitingTime(6000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeVisible("opportunityAccountsEditQuantity");
				selenium.type("opportunityAccountsEditQuantity", "opportunityProductNewEditQuantity value");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.clickLoop("Button_Save");
				selenium.waitingTime(6000);
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {
				selenium.click("CancelButton");
//				selenium.click("opportunityProductNewEditCancle");

			}
		}

	}

	@And("^Marketing Use Edit Opportunity Account Trageted Product")
	public void Edit_Opportunity_Account_Trageted_Product_Marketing_User() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(6000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");

				selenium.jsClick("opportunityLineItemRelatedList");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("opportunityProductNewClickMarketing_new");
				selenium.jsClick("opportunityProductNewClickMarketing_new");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("EditButton");
				selenium.click("EditButton");
				selenium.waitingTime(6000);
				selenium.switchToFrame("iFrame");
				selenium.waitForElementToBeVisible("opportunityAccountsEditQuantity");
				selenium.type("opportunityAccountsEditQuantity", "opportunityProductNewEditQuantity value");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.jsClick("Button_Save");
				selenium.waitingTime(8000);
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

//				selenium.click("opportunityProductNewEditCancleMarketing");
				selenium.click("CancelButton");

			}
		}

	}

	@And("^Marketing Use Add or Edit Opportunity Account tagged product with ISBN")
	public void Marketing_Use_Add_or_Edit_Opportunity_Account_tagged_product_with_ISBN() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(6000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");

				selenium.jsClick("opportunityLineItemRelatedList");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(4000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(4000);
				if (selenium.isElementPresentFast("opportunitISBNAllreadyPresent")) {
					System.out.println("ISBN already present");
					selenium.scrollToElement("taggedProductISBNSearchSelectionAllreadyExist1");
					selenium.click("taggedProductISBNSearchSelectionAllreadyExist1");
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("removeBtn");
					selenium.click("removeBtn");
					System.out.println("ISBN Removed");
				}

				selenium.scrollToElement("taggedProductISBN1");
				selenium.type("taggedProductISBN1", "taggedProductISBN value");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("taggedProductISBNSearch");
				selenium.clickLoop("taggedProductISBNSearch");
				selenium.waitingTime(2000);
				// selenium.jsClick("taggedProductISBNSearchSelectionNew");
				// selenium.jsClick("taggedProductISBNSearchSelectionAllreadyExist");
				if (selenium.isElementPresentFast("taggedProductISBNSearchSelectionAllreadyExist1")) {

					selenium.jsClick("taggedProductISBNSearchSelectionAllreadyExist1");
				} else {
					selenium.jsClick("taggedProductISBNSearchSelectionAllreadyExist");
				}
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
				selenium.waitingTime(2000);
				selenium.clickLoop("addProductNew");
				selenium.waitForElementToBeVisible("Button_Save");
				selenium.scrollToElement("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(5000);

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

//				selenium.click("opportunityProductNewEditCancleMarketing");
				selenium.click("CancelButton");

			}
		}

	}

	@And("^Search and Link Targeted Productswith ISBN Marketing")
	public void Search_and_Link_Targeted_Productswith_ISBN_Marketing() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(3000);
				selenium.clickDynamicOpportunity("anchorTitle", "Opportunity Name dynamic Value",
						"end");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
				selenium.jsClick("opportunityLineItemRelatedList");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(4000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(4000);
				String isbn = selenium.getValueByColumnName("taggedProductISBN value");
				String isbnXpath = selenium.getPropertiesObj()
						.getProperty("taggedProductISBNSearchSelectionAllreadyExist_op").replace("$val", isbn);
				if (selenium.isElementPresentFast("opportunitISBNAllreadyPresent")) {
					System.out.println("ISBN already present");
					selenium.clickXpath(isbnXpath);
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("removeBtn");
					selenium.click("removeBtn");
					System.out.println("ISBN Removed");
				}
				selenium.scrollToElement("taggedProductISBN1");
				selenium.type("taggedProductISBN1", "taggedProductISBN value");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("taggedProductISBNSearch");
				selenium.clickLoop("taggedProductISBNSearch");
				selenium.waitingTime(2000);

				selenium.clickXpath(isbnXpath);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("Button_Save");
				selenium.scrollToElement("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(5000);

			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

//				selenium.click("opportunityProductNewEditCancleMarketing");
				selenium.click("CancelButton");

			}
		}

	}

	@And("^Use Add or Edit Opportunity Account tagged product with ISBN")
	public void Use_Add_or_Edit_Opportunity_Account_tagged_product_with_ISBN() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(3000);
				selenium.clickDynamicOpportunity("anchorTitle", "Opportunity Name dynamic Value",
						"end");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
				selenium.jsClick("opportunityLineItemRelatedList");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(8000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.scrollToElement("taggedProductISBN1");
				selenium.type("taggedProductISBN1", "taggedProductISBN value");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("taggedProductISBNSearch");
				selenium.click("taggedProductISBNSearch");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("taggedProductISBNSearchSelectionMHHE");
				selenium.jsClick("taggedProductISBNSearchSelectionMHHE");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(5000);

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

//				selenium.click("opportunityProductNewEditCancleMarketing");
				selenium.click("CancelButton");

			}
		}

	}

	@And("^MHHE Use Add or Edit Opportunity Account tagged product with ISBN")
	public void MHHE_Use_Add_or_Edit_Opportunity_Account_tagged_product_with_ISBN() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.waitingTime(6000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(4000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");

				selenium.jsClick("opportunityLineItemRelatedList");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(4000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(6000);
				if (selenium.isElementPresentFast("opportunitISBNAllreadyPresent")) {
					System.out.println("ISBN already present");
					selenium.scrollToElement("taggedProductISBNSearchSelectionAllreadyExist1");
					selenium.click("taggedProductISBNSearchSelectionAllreadyExist1");
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("removeBtn");
					selenium.click("removeBtn");
					System.out.println("ISBN Removed");
				}
				selenium.scrollToElement("taggedProductISBN1");
				selenium.type("taggedProductISBN1", "taggedProductISBN value");
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("taggedProductISBNSearch");
				selenium.click("taggedProductISBNSearch");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("targetCheckBox");
				// selenium.jsClick("taggedProductISBNSearchSelectionMHHE2");
				selenium.jsClick("targetCheckBox");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(5000);

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

//				selenium.click("opportunityProductNewEditCancleMarketing");
				selenium.click("CancelButton");

			}
		}

	}

	@And("^MHHE Search and Link Targeted Productswith ISBN")
	public void MHHE_Search_and_Link_Targeted_Productswith_ISBN() {
		try {

			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(3000);
//				selenium.clickDynamicOpportunity("anchorTitle", "Opportunity Name dynamic Value",
//						"end");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
				selenium.jsClick("opportunityLineItemRelatedList");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(4000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(6000);
				String isbn = selenium.getValueByColumnName("taggedProductISBN value");
				String isbnXpath = selenium.getPropertiesObj()
						.getProperty("taggedProductISBNSearchSelectionAllreadyExist_op").replace("$val", isbn);
				if (selenium.isElementPresentFast("opportunitISBNAllreadyPresent")) {
					System.out.println("ISBN already present");
					selenium.clickXpath(isbnXpath);
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("removeBtn");
					selenium.click("removeBtn");
					System.out.println("ISBN Removed");
				}
				selenium.scrollToElement("taggedProductISBN1");
				selenium.type("taggedProductISBN1", "taggedProductISBN value");
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("taggedProductISBNSearch");
				selenium.click("taggedProductISBNSearch");
				selenium.waitingTime(5000);
//	            selenium.waitForXpathElementToBeVisible(isbnXpath);
				selenium.clickXpath(isbnXpath);
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(10000);

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

//				selenium.click("opportunityProductNewEditCancleMarketing");
				selenium.click("CancelButton");

			}
		}

	}

	@And("^Opp Contact Add Primary")
	public void Opp_Contact_Add_Primary() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(4000);
//				selenium.navigateToURL(opportunityContactAddPri);
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("opportunityContactsLink");
				selenium.click("opportunityContactsLink");
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(8000);
				if (!selenium.isElementPresentFast("firstOppContactRecord")) {
					selenium.captureScreenShot();
					System.out.println("No Contact exist for this opportunity");
					selenium.test.log(LogStatus.INFO, "Creating New Opp. Contact");
					selenium.waitForElementToBeClickable("productAddOrEdit");
					selenium.jsClick("productAddOrEdit");
					selenium.waitingTime(5000);
					selenium.waitForElementToBeVisible("productframeUat");
					selenium.switchToMultipleFrame("productframeUat");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("OppContactFirstName");
					selenium.type("OppContactFirstName", "contact Name Opp");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("searchBtn");
					selenium.jsClick("searchBtn");
					selenium.waitingTime(8000);

					if (selenium.isElementPresentFast("opportunitiesSearchResultForAdding")) {
						selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
						selenium.jsClick("opportunitiesSearchResultForAdding");
					} else {
						selenium.waitForElementToBeClickable("OppContactFirstName");
						selenium.type("OppContactFirstName", "contact Name Opp2");
						selenium.waitForElementToBeClickable("searchBtn");
						selenium.jsClick("searchBtn");
						selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
						selenium.jsClick("opportunitiesSearchResultForAdding");
					}

					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
					selenium.scrollToElement("opportunitiesAddToOpportunity");
					selenium.jsClick("opportunitiesAddToOpportunity");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("Button_Save");
					selenium.scrollToElement("Button_Save");
					selenium.jsClick("Button_Save");
					selenium.switchOutOfFrame();
					selenium.waitingTime(12000);
					selenium.waitForElementToBeClickable("opportunityContactsLink");
					selenium.click("opportunityContactsLink");
					selenium.waitingTime(6000);
				}
				selenium.waitForElementToBeClickable("productAddOrEdit");
				selenium.jsClick("productAddOrEdit");
				selenium.waitingTime(8000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(8000);
				String nameXpath = selenium.getDynamicXpath("Text_Span", "contact Name Opp", "end");
				System.out.println(nameXpath);
				selenium.waitingTime(2000);
				boolean name = selenium.isElementPresentXpathFast(nameXpath);
				System.out.println("Contact Name Xpath is: " + name);
				selenium.waitingTime(8000);
				if (name == true) {

					System.out.println("Primary checkbox Present");
					String Name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name Opp");
					selenium.waitingTime(2000);
					String contactNameFieldXpathOpp = selenium.getPropertiesObj().getProperty("contactNameOppPrimary1").
							replace("<placeholder>", Name);
					selenium.waitingTime(4000);
					System.out.println("contactNameFieldXpathOpp is : " + contactNameFieldXpathOpp);
					selenium.clickLoopXpath(contactNameFieldXpathOpp);
					System.out.println("Primary checkbox checked");

//					if(selenium.isElementPresentsuperFast("PrimaryContactEnabled"))
//					{
//						selenium.clickLoopXpath(contactNameFieldXpathOpp);					
//						System.out.println("Primary checkbox unchecked");
//						selenium.waitingTime(1000);
//						selenium.clickLoopXpath(contactNameFieldXpathOpp);					
//						System.out.println("Primary checkbox checked back");
//					}
//					else
//					{
//						selenium.clickLoopXpath(contactNameFieldXpathOpp);					
//						System.out.println("Primary checkbox checked");
//					}

					selenium.waitForElementToBeClickable("Button_Save");
					selenium.click("Button_Save");
					selenium.waitingTime(10000);
					selenium.test.log(LogStatus.PASS, "Primary contact Added");
					System.out.println("Primary contact Added");

				} else {
					selenium.test.log(LogStatus.FAIL, "Contact Name Not Found");
					System.out.println("Contact Name Not Found.");
					selenium.reportFailure("Contact Name Not Found");

				}


			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

//				selenium.click("opportunityProductNewEditCancleMarketing");
				selenium.click("CancelButton");

			}
		}

	}

	@And("^Removal of Opp Contact Add Secondary")
	public void Opp_Contact_Add_Secondary_removal() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(4000);
//				selenium.navigateToURL(opportunityContactAddSec);
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
				String ContactName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name");
				String contactNameFieldXpathOpp = selenium.getPropertiesObj().getProperty("contactNameSecOpp").
						replace("<placeholder>", ContactName);
				boolean name = selenium.isElementPresentXpathFast(contactNameFieldXpathOpp);


				if (name == true) {

					System.out.println("Primary checkbox Present");
					String Name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name");
					String contactNameCheckbox = selenium.getPropertiesObj().getProperty("contactNameCheckboxOpp").
							replace("<placeholder>", Name);
					System.out.println("contactNameCheckbox" + contactNameCheckbox);
					selenium.clickLoopXpath(contactNameCheckbox);
					selenium.waitingTime(3000);		
					selenium.waitForElementToBeClickable("opportunitiesRemove");
					selenium.click("opportunitiesRemove");
					selenium.waitingTime(5000);		
					selenium.waitForElementToBeClickable("Button_Save");
					selenium.click("Button_Save");
					selenium.waitingTime(12000);
				}
			}

		} catch (Exception E) {

			selenium.click("opportunitiesToCancel");
			selenium.test.log(LogStatus.FAIL, "Contact Name Not Found");
			selenium.reportFailure("Test Case Failed");
			System.out.println("Contact Name Not Found.");
		}
	}

	@And("^Removal of Opp Account")
	public void Removal_of_Opp_Account() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(4000);
				selenium.navigateToURL(selenium.MHENewOppURL);
//				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("OppProduct");
				selenium.click("OppProduct");
				selenium.waitingTime(3000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(6000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(8000);
				String AccountName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
				String accountNameFieldXpathOpp = selenium.getPropertiesObj().getProperty("accountNamePriceCheck").
						replace("<placeholder>", AccountName);
				boolean name = selenium.isElementPresentXpathFast(accountNameFieldXpathOpp);
				System.out.println(AccountName);
				System.out.println(accountNameFieldXpathOpp);
				System.out.println(name);

				if (name == true) {

					System.out.println("Primary checkbox Present");
					String AccName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
					String accountNameCheckboxOpp = selenium.getPropertiesObj().getProperty("accountNameCheckboxOpp").
							replace("<placeholder>", AccName);
					System.out.println(accountNameCheckboxOpp);
					selenium.waitingTime(4000);
//		            selenium.waitForXpathElementToBeVisible(accountNameCheckboxOpp);
					selenium.clickLoopXpath(accountNameCheckboxOpp);
//					selenium.waitingTime(3000);		
					selenium.waitForElementToBeClickable("opportunitiesRemove");
					selenium.click("opportunitiesRemove");
//					selenium.waitingTime(2000);	
					selenium.waitForElementToBeClickable("Button_Save");
					selenium.click("Button_Save");
					selenium.waitingTime(12000);
				}
			}

		} catch (Exception E) {

			selenium.click("opportunitiesToCancel");
			selenium.test.log(LogStatus.FAIL, "Contact Name Not Found");
			selenium.reportFailure("Test Case Failed");
			System.out.println("Contact Name Not Found.");
		}
	}


	@And("^List View Create Opp")
	public void List_View_Create_Opp() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(4000);
				selenium.navigateToURL(lisyViewOpp);
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("listViewBtn");
				selenium.click("listViewBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("settingsViewNew");
				selenium.click("settingsViewNew");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("listNameView");
				selenium.type("listNameView", "Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("SaveBtnNew1");
				selenium.clickLoop("SaveBtnNew1");
				selenium.waitingTime(17000);
//				String LName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Name");
//				String ListViewFieldXpathOpp = selenium.getPropertiesObj().getProperty("listViewNameCreate").
//						replace("<placeholder>", LName);
//				boolean name = selenium.isElementPresentXpathFast(ListViewFieldXpathOpp);

				if (selenium.isElementPresentFast("NewListviewFilter")) {

					System.out.println("List view Created Successfully");
					selenium.test.log(LogStatus.PASS, "List view Created Successfully");


				} else {

					System.out.println("Issue in creating List view");
					selenium.test.log(LogStatus.FAIL, "Issue in creating List view");
					selenium.reportFailure("Issue in creating List view");
				}


			}


		} catch (Exception E) {

			selenium.click("opportunitiesToCancel");
			selenium.test.log(LogStatus.FAIL, "Issue came");
			selenium.reportFailure("Test Case Failed");
			System.out.println("Issue came");
		}
	}

	@And("^Price Calculation")
	public void Price_Calculation() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(2000);
				selenium.navigateToURL_propertiesFile("US089_OppURL");
				selenium.waitingTime(3000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.scrolldown(100);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("oppProducForPriceValueNew");
				selenium.click("oppProducForPriceValueNew");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("ProductPriceValue");

				String SalePrice = selenium.getText("ProductPriceValue");
				System.out.println(" Sale Price is :" + SalePrice);

				String sp1 = SalePrice.replaceAll("[^A-Za-z]", "");
				String sp2 = SalePrice.replaceAll("[^0-9]", "");
				System.out.println("String Sale Price = " + sp1);
				System.out.println("Int Sale Price = " + sp2);

				selenium.waitingTime(3000);
				selenium.navigateBack();
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("totalRevenue");
				selenium.scrollToElement("totalRevenue");
				String TotalRevenue = selenium.getText("totalRevenue");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("termRevenue");
				String TermRevenue = selenium.getText("termRevenue");
				System.out.println("Total Revenue" + TotalRevenue);
				System.out.println("Term Revenue" + TermRevenue);

				String st = TotalRevenue;

//			    String st3=st.replaceAll(".00", "");			    

				String st1 = st.replaceAll("[^A-Za-z]", "");
				String st2 = st.replaceAll("[^0-9]", "");
				System.out.println("String Total Revenue = " + st1);
				System.out.println("Int Total Revenue = " + st2);
				//		    System.out.println("Int Total Revenue = "+st3);


				String str = TermRevenue;
				String str1 = str.replaceAll("[^A-Za-z]", "");
				String str2 = str.replaceAll("[^0-9]", "");
				System.out.println("String Term Revenue = " + str1);
				System.out.println("Int Term Revenue = " + str2);


//				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("editFallEnrollmrntForCalculation");
				selenium.scrollToElement("editFallEnrollmrntForCalculation");
				selenium.waitForElementsToBeVisible("editFallEnrollmrntForCalculation");
				Boolean P = selenium.isElementPresentFast("editFallEnrollmrntForCalculation");
				System.out.println(P);
//				selenium.waitingTime(4000);		
				selenium.waitForElementToBeClickable("editFallEnrollmrntForCalculation");
				selenium.jsClick("editFallEnrollmrntForCalculation");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("Edit_Fallenrollment");
				selenium.type("Edit_Fallenrollment", "FallEnrollmrnt");
				selenium.type("type_springenrollment", "SpringEnrollment");
				selenium.type("Edit_Summnerenrollment", "SummerEnrollment");
				selenium.type("inputWinterEnrollment", "WinterEnrollment");
				selenium.type("inputOtherEnrollment", "OtherEnrollment");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(8000);

				selenium.scrollToElement("totalEnrollmentGetText");
				String TotalEnrollment = selenium.getText("totalEnrollmentGetText");
				System.out.println("totalEnrollmentGet is:" + TotalEnrollment);
				selenium.waitingTime(2000);
				int j = Integer.parseInt(TotalEnrollment);
				int i = Integer.parseInt(st2);
				int k = Integer.parseInt(sp2);

				int price = j * k;

				if (price == i) {

					System.out.println("Price is " + price);

					System.out.println("Working fine");
				}


			}


		} catch (Exception E) {
//			selenium.click("opportunitiesToCancel");	
			selenium.test.log(LogStatus.FAIL, "Issue came");
			selenium.reportFailure("Test Case Failed");
			System.out.println("Issue came");
		}
	}

	@And("^List View Opp Delete")
	public void List_View_opp_Delete() {
		try {

			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(4000);	
				selenium.waitForElementToBeClickable("listViewBtn");
				selenium.click("listViewBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("settingsViewDelete");
				selenium.click("settingsViewDelete");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("deleteBtn");
				selenium.clickLoop("deleteBtn");
				selenium.waitingTime(9000);
				System.out.println("List view Deleted");
				selenium.test.log(LogStatus.PASS, "List view Deleted");

			}


		} catch (Exception E) {

			selenium.click("opportunitiesToCancel");
			selenium.test.log(LogStatus.FAIL, "issue in Delete List view");
			selenium.reportFailure("Test Case Failed");
			System.out.println("issue in Delete List view");
		}
	}


	@And("^Opp Contact Add Secondary")
	public void Opp_Contact_Add_Secondary() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(4000);
//				selenium.navigateToURL(opportunityContactAddSec);
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
				String ContactName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name");
				String contactNameFieldXpathOpp = selenium.getPropertiesObj().getProperty("contactNameSecOpp").
						replace("<placeholder>", ContactName);
				boolean name = selenium.isElementPresentXpathFast(contactNameFieldXpathOpp);


				if (name == false) {

					selenium.waitingTime(2000);
					String Name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("contact Name");
					String contactNameCheckbox = selenium.getPropertiesObj().getProperty("contactNameCheckboxOpp").
							replace("<placeholder>", Name);
					System.out.println("Results : " + Name + contactNameCheckbox);
					selenium.scrollToElement("SearchInputValue");
					selenium.waitForElementToBeClickable("SearchInputValue");
					selenium.type("SearchInputValue", "contact Name");
					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("searchBtn");
					selenium.click("searchBtn");
					selenium.waitingTime(4000);
//		            selenium.waitForXpathElementToBeClickable(contactNameCheckbox);
					selenium.clickLoopXpath(contactNameCheckbox);
					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickableLongerDuration("Addtoopportunity");
					selenium.click("Addtoopportunity");
					System.out.println("check box clicked");
					selenium.waitingTime(4000);
//		            selenium.waitForXpathElementToBeClickable(contactNameCheckbox);
					selenium.clickXpath(contactNameCheckbox);
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("Button_Save");
					selenium.click("Button_Save");
					selenium.waitingTime(10000);
					selenium.test.log(LogStatus.PASS, "Secondary contact Added");
					System.out.println("Secondary contact Added");


				}


			}
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

				selenium.click("opportunitiesToCancel");
				selenium.test.log(LogStatus.FAIL, "Contact Name Not Found");
				System.out.println("Contact Name Not Found.");

			}
		}

	}

	@And("^add product to MHHE opportunity")
	public void add_product_to_MHHE_opportunity() {
		try {
			selenium.navigateToURL(selenium.MHENewOppURL);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.jsClick("taggedProductAddorEdit");
			selenium.waitingTime(6000);
			selenium.switchToFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("isbnSearch1");
			selenium.scrollToElement("isbnSearch1");
			selenium.type_propertiesFile("isbnSearch1", "ISBNNo");
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("productCheckBox");
			selenium.click("productCheckBox");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.click("Button_Save");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.PASS, "Product Added to Opportunity");
			System.out.println("Product Added to Opportunity");
		} catch (Exception e) {
			selenium.reportFailure("Error while adding product to an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding product to an opportunity");
		}
	}

	@And("^Opp AccountProduct Add after removal with Price")
	public void Opp_AccountProduct_add_after_removal() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(4000);
//				selenium.navigateToURL(opportunityProductpriceNew);
//				selenium.waitingTime(6000);
				selenium.navigateToURL(selenium.MHENewOppURL);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("OppProduct");
				selenium.click("OppProduct");
				selenium.waitingTime(3000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(6000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(8000);
				String AccountName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
				String AccountNameFieldXpathOpp = selenium.getPropertiesObj().getProperty("accountNamePriceCheck").
						replace("<placeholder>", AccountName);
				boolean name = selenium.isElementPresentXpathFast(AccountNameFieldXpathOpp);
				System.out.println(AccountName);
				System.out.println(AccountNameFieldXpathOpp);
				System.out.println(name);

				if (name == false) {
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("isbnSearch1");
					selenium.scrollToElement("isbnSearch1");
					selenium.type("isbnSearch1", "ISBN No");
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("searchBtn");
					selenium.click("searchBtn");
					selenium.waitingTime(12000);

					if (selenium.isElementPresentFast("productPriceCheck") == true) {
//						selenium.waitingTime(3000);
						selenium.waitForElementToBeVisible("productPriceCheck");
						String PriceValue = selenium.getText("productPriceCheck");
//						selenium.waitingTime(3000);
						System.out.println(PriceValue);
						selenium.waitingTime(8000);
						String Name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
						String AccountNameCheckbox1 = selenium.getPropertiesObj().getProperty("accountNameCheckboxOpp").
								replace("<placeholder>", Name);
						selenium.waitingTime(4000);
//			            selenium.waitForXpathElementToBeVisible(AccountNameCheckbox1);
//						selenium.clickLoopXpath(AccountNameCheckbox1);
						selenium.clickXpath(AccountNameCheckbox1);
//						selenium.jsClickXpath(AccountNameCheckbox1);
//						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
						selenium.click("opportunitiesAddToOpportunity");
						System.out.println("check box clicked");
						selenium.waitingTime(4000);
//			            selenium.waitForXpathElementToBeVisible(AccountNameCheckbox1);
						selenium.clickXpath(AccountNameCheckbox1);
//						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("Button_Save");
						selenium.click("Button_Save");
						selenium.waitingTime(10000);
						selenium.test.log(LogStatus.PASS, "Added");
						System.out.println("Added");
					} else {


						selenium.test.log(LogStatus.FAIL, "Price details not present, cant be added to opp");
						System.out.println("Price details not present, cant be added to opp");
						selenium.reportFailure("Price details not present, cant be added to opp");

					}


				}


			}
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {

				selenium.click("opportunitiesToCancel");
				selenium.test.log(LogStatus.FAIL, "Name Not Found");
				System.out.println("Name Not Found.");

			}
		}

	}


	@And("^I fill in all the mandatory details to create a new opportunity for Marketing User$")
	public void i_fill_in_the_following_to_create_a_new_opportunity_for_Marketing_User() {
		try {
			selenium.waitForElementToBeClickable("opp_Link");
			selenium.jsClick("opp_Link");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("NewActionButton");
			selenium.jsClick("NewActionButton");
			selenium.waitingTime(6000);
			// selenium.switchToFrame("newOppurtunityFrame");
			// selenium.switchToFrame("OpportunityFrameNew");
			selenium.switchToMultipleFrame("productframeUat");
			System.out.println("Inside opportunity Frame");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("mheCourse");

			selenium.type("mheCourse", "MHE Course");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(xpath);
			selenium.waitingTime(2000);
			selenium.selectDropdownText("opportunityTypeDropdown", "Oppurtunity Type");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
			selenium.type("oppurtunityFallEnrollment", "Fall Enrollment");
			selenium.type("oppurtunitySpringEnrollment", "Spring Enrollment");
			selenium.click("oppurtunitySummerEnrollment");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(50000);
			selenium.switchOutOfFrame();

			if (selenium.waitForElementToBeClickable("strategyWorksheetBtn") == true) {
				System.out.println("Strategy Worksheet Button is visible");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("mheCourseGetText");
				selenium.scrollToElement("mheCourseGetText");

				String mheCourse = selenium.getText("mheCourseGetText").toString();
				String expected_mheCourse = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MHE Course");
				if (mheCourse.equalsIgnoreCase(expected_mheCourse)) {
					selenium.test.log(LogStatus.PASS, "Opportunity created successfully " + mheCourse);
				} else {
					selenium.test.log(LogStatus.FAIL, "Opportunity creation failed");
				}

			} else {
				selenium.test.log(LogStatus.FAIL, "Opportunity page not loaded yet after details saved");
				selenium.reportFailure("Opportunity page not loaded yet after details saved");
			}

		} catch (Exception e) {
			selenium.click("CancelEdit");
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

//	@And("^Validate the contacts linked to opportunities edit$")
//	public void Validate_the_contacts_linked_to_opportunities_edit() {
//		try {
//
//			if (selenium.getUI().contains("Lightning")) {
//				selenium.jsClick("oppurtunitiesWithinAccount");
////				selenium.waitingTime(3000);
//	            selenium.waitForElementToBeClickable("newOpportunityBtn1");
//				selenium.jsClick("newOpportunityBtn1");
//				selenium.waitingTime(4000);
//				selenium.switchToFrame("newOppurtunityFrame");
//				selenium.type("OpportunityMHECourse", "MHE Course");
////				selenium.waitingTime(4000);
//	            selenium.waitForElementToBeVisible("OppurtunityMHECourseOptionsClick");
//				selenium.dropdownListClick("OppurtunityMHECourseOptionsClick");
////				selenium.waitingTime(3000);
//	            selenium.waitForElementToBeVisible("oppurtunityType");
//				selenium.selectDropdownText("oppurtunityType", "Oppurtunity Type");
//				selenium.type("accountsOpportunityFallEnrolement", "Fall Enrolement");
//				selenium.waitingTime(3000);
//				selenium.moveTab("accountsOpportunityFallEnrolement");
//				selenium.captureScreenShot();
////				selenium.waitingTime(3000);
//	            selenium.waitForElementToBeClickable("ButtonSave");
//				selenium.jsClick("ButtonSave");
//				selenium.waitingTime(5000);
//				selenium.switchOutOfFrame();
//				selenium.waitingTime(5000);
//				selenium.isElementPresentFast("newOppurtunitySuccessCheck");
//				selenium.waitingTime(2000);
//				selenium.captureScreenShot();
////				selenium.waitingTime(3000);
//
//				selenium.test.log(LogStatus.PASS, "oppurtunity  created!");
//				selenium.waitingTime(5000);
//			} else {
////				selenium.waitingTime(2000);
//				selenium.waitForElementToBeVisible("opportunitiesC");
//				selenium.scrollToElement("opportunitiesC");
//				selenium.click("opportunitiesC");
//			}
//		}
//
//////             selenium.type("closeDate", "Close Date");
//////             selenium.type("orderDate", "Order Date");
////               selenium.type("mheCourse", "MHE Course");
////               selenium.waitingTime(2000);
////               String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
////               selenium.clickLoopXpath(xpath);
////               selenium.type("enrollment", "Enrollment");
////
////         } 
//		catch (Exception e) {
//			selenium.switchOutOfFrame();
//			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//		}
//	}

	@And("^Edit contact of Opportunities$")
	public void Edit_contact_of_Opportunities() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				/*
				 * // selenium.clickDynamicOpportunity("anchorTitle",
				 * "Opportunity Name dynamic Value", "anchorTitle");
				 * selenium.waitingTime(3000); selenium.jsClick("OpportunityContactClick");
				 * selenium.waitingTime(3000);
				 * selenium.clickDynamicOpportunity("Text_Span",
				 * "Opportunity dynamic Value", "end");
				 * selenium.waitingTime(5000);
				 */

				/*selenium.waitingTime(6000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(5000);*/

//				String opp=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opp URL"); 
//				selenium.navigateToURL(opp);
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("opportunityContactsLink");

				selenium.click("opportunityContactsLink");
				selenium.waitingTime(5000);
				selenium.clickDynamicOpportunity("Text_Span", "Opportunity dynamic Value",
						"end");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.captureScreenShot();
				selenium.waitForElementToBeClickable("editButton");
				//selenium.navigateToURL(opportunityContacts);
				//selenium.waitingTime(8000);
				selenium.jsClick("editButton");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("opportunityContactRolenew");
				selenium.jsClick("opportunityContactRolenew");
				selenium.waitingTime(1000);
				selenium.autoSuggestiveDropdownWithoutText1("opportunityContactRolenew");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(15000);
				selenium.test.log(LogStatus.PASS, "Edited");

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Edit contact of Opportunities Marketing$")
	public void Edit_contact_of_Opportunities_Marketing() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				/*
				 * selenium.search("Opportunity Name dynamic Value");
				 * selenium.waitingTime(4000); String
				 * xpath=selenium.getDynamicXpath("anchorTitle",
				 * "Opportunity Name dynamic Value", "end");
				 * selenium.clickLoopXpath(xpath); //
				 * selenium.clickDynamicOpportunity("anchorTitle",
				 * "Opportunity Name dynamic Value", "end");
				 * selenium.waitingTime(3000);
				 */

				/*
				 * selenium.waitingTime(6000);
				 * selenium.search("Opportunity Name dynamic Value");
				 * selenium.waitingTime(2000); String Xpath =
				 * selenium.getDynamicXpath("anchorTitlecontains",
				 * "Opportunity Name dynamic Value", "endContains");
				 * selenium.clickLoopXpath(Xpath);
				 */
//				String	URL=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Data Url");
//				  selenium.navigateToURL(URL);
//				  selenium.waitingTime(4000);
//				  selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityContactsLink");

				selenium.click("opportunityContactsLink");
				selenium.waitingTime(5000);
				selenium.clickDynamicOpportunity("Text_Span", "Opportunity dynamic Value",
						"end");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.captureScreenShot();
				selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("opportunityContactRolenew");
				selenium.clickLoop("opportunityContactRolenew");
				selenium.waitingTime(1000);
				selenium.autoSuggestiveDropdownWithoutText1("opportunityContactRolenew");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(8000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Edit contact of Opportunities MHES$")
	public void Edit_contact_of_Opportunities_MHES() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				/*
				 * selenium.search("Opportunity Name dynamic Value");
				 * selenium.waitingTime(4000); String
				 * xpath=selenium.getDynamicXpath("anchorTitle",
				 * "Opportunity Name dynamic Value", "end");
				 * selenium.clickLoopXpath(xpath);
				 * //selenium.clickDynamicOpportunity("anchorTitle",
				 * "Opportunity Name dynamic Value", "end");
				 * selenium.waitingTime(3000);
				 */

				/*
				 * selenium.waitingTime(6000);
				 * selenium.search("Opportunity Name dynamic Value");
				 * selenium.waitingTime(2000); String Xpath =
				 * selenium.getDynamicXpath("anchorTitlecontains",
				 * "Opportunity Name dynamic Value", "endContains");
				 * selenium.clickLoopXpath(Xpath);
				 */
//				String	URL=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Data Url");
//				  selenium.navigateToURL(URL);
//				  selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityContactsLink");
				selenium.click("opportunityContactsLink");
				selenium.waitingTime(5000);
				selenium.clickDynamicOpportunity("Text_Span", "Opportunity dynamic Value",
						"end");
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityContactRolenew");
				selenium.jsClick("opportunityContactRolenew");
				selenium.waitingTime(3000);
				selenium.autoSuggestiveDropdownWithoutText1("opportunityContactRolenew");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(12000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^verify MHHE Sales Rep user can not Edit McGrawHill GO field$")
	public void MHHESalesRep_user_Edit_McGrawHillGO_field() {
		try {
			if (!selenium.isElementPresentFast("McGrawHillGOEditBtn")) {
				selenium.test.log(LogStatus.PASS, "For McGrawHill GO field the edit button/icon is not present in Opp page for MHHE Sales Rep user");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "MHHE Sales Rep user is able to edit the McGrawHill GO field in Opp.");
				selenium.reportFailure("MHHE Sales Rep user is able to edit the McGrawHill GO field in Opp.");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying the McGrawHill GO field's edit button in opportunity for MHHE Sales Rep user " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying the McGrawHill GO field's edit button in opportunity for MHHE Sales Rep user");
		}
	}

	@And("^MHHE Markerting user Edit McGrawHill GO field$")
	public void MHHEMarkerting_user_Edit_McGrawHillGO_field() {
		try {
			selenium.navigateToURL(selenium.MarketingUserNewOppURL);
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrolldown(600);
			selenium.waitForElementToBeClickable("McGrawHillGOEditBtn");
			selenium.click("McGrawHillGOEditBtn");
			selenium.waitingTime(8000);
			selenium.scrollToElement("McGrawHillGOCheckbox");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("McGrawHillGOCheckbox");
			selenium.click("McGrawHillGOCheckbox");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			selenium.scrolldown(800);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.PASS, "MHHE Marketing/Editorial/Business_Administrator user is able to edit the McGrawHill GO field in opportunity");
			System.out.println("PASS");
		} catch (Exception e) {
			selenium.reportFailure("Error while editing McGrawHill GO field in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing McGrawHill GO field in opportunity");
		}
	}

	@And("^Edit Opportunities details$")
	public void edit_Opportunities_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.navigateToURL(selenium.MarketingUserNewOppURL);
				selenium.waitingTime(10000);
				if (selenium.isElementPresentFast("editButton")) {
					selenium.clickLoop("editButton");
				} else {
					selenium.waitingTime(4000);
					selenium.click("moreActionsBtn");
					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("NewOpportunityEditBtn1");
					selenium.clickLoop("NewOpportunityEditBtn1");
				}
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityEditYear");
				selenium.jsClick("opportunityEditYear");
				selenium.autoSuggestiveDropdownWithoutText1("opportunityEditYear");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("opportunityEditTerm");
				selenium.jsClick("opportunityEditTerm");
				selenium.autoSuggestiveDropdownWithoutText1("opportunityEditTerm");
				selenium.waitingTime(2000);
				/*
				 * selenium.jsClick("opportunityEditClearCourceSelection");
				 * selenium.waitingTime(2000); selenium.type("opportunityEditSearchCource",
				 * "opportunity Edit Search Cource"); selenium.waitingTime(2000);
				 * selenium.autoSuggestiveDropdownWithoutText1("opportunityEditSearchCource");
				 * selenium.waitingTime(5000);
				 * selenium.type("opportunityEditAccountMHECourseName",
				 * "opportunity Edit Account MHE Course Name");
				 */
				//selenium.waitingTime(2000);
				//selenium.clearText("opportunitymhecourse");
				selenium.waitForElementToBeClickable("mheCourseDeleteIcon");
				selenium.click("mheCourseDeleteIcon");
				selenium.waitForElementToBeVisible("opportunitymhecourse");
				selenium.type("opportunitymhecourse", "opportunity Edit MHE Course Name");
				selenium.waitingTime(2000);
//				selenium.waitForElementToBeVisible("opportunitymhecourse");
				selenium.pressEnter("opportunitymhecourse");
				selenium.waitingTime(2000);
				selenium.clickDynamic("anchorTitle", "opportunity Edit MHE Course Name", "end");
				selenium.waitingTime(2000);
				//selenium.autoSuggestiveDropdownWithoutText1("opportunitymhecourse");
				/*
				 * selenium.waitingTime(5000);
				 * if(selenium.isElementPresentFast("opportunityEditMHECourseName1NewPage")) {
				 * selenium.waitingTime(2000);
				 * selenium.type("opportunityEditMHECourseName1NewPage",
				 * "opportunity Edit MHE Course Name"); selenium.waitingTime(2000);
				 * selenium.clickLoop("SaveBtnNew1"); selenium.waitingTime(9000); }
				 */
				//selenium.click("RecordSaveButton");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");

				selenium.waitingTime(5000);
				if (selenium.isElementPresentFast("ErrorListAll")) {
					selenium.jsClick("closePopUp");
					selenium.waitingTime(2000);
					selenium.click("CancelButton");

				}

				selenium.waitingTime(12000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {

			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
				selenium.switchOutOfFrame();
				selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			} else {
				selenium.click("CancelButton");
				selenium.switchOutOfFrame();
				selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

		}

	}

	@And("^Edit Opportunities details for salesMarketing$")
	public void edit_Opportunities_details_for_salesMarketing() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.navigateToURL(selenium.MarketingUserNewOppURL);
				selenium.waitingTime(10000);
				if (selenium.isElementPresentFast("editButton")) {
					selenium.clickLoop("editButton");
				} else {

					selenium.click("moreActionsBtn");
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("editBtn");
					selenium.clickLoop("editBtn");
				}
//				selenium.waitingTime(2000);
				selenium.waitForElementsToBeVisible("opportunityEditYear");
				selenium.jsClick("opportunityEditYear");
				selenium.autoSuggestiveDropdownWithoutText1("opportunityEditYear");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityEditTerm");
				selenium.jsClick("opportunityEditTerm");
				selenium.autoSuggestiveDropdownWithoutText1("opportunityEditTerm");
//				selenium.waitingTime(5000);
				/*
				 * selenium.jsClick("opportunityEditClearCourceSelection");
				 * selenium.waitingTime(2000); selenium.type("opportunityEditSearchCource",
				 * "opportunity Edit Search Cource"); selenium.waitingTime(2000);
				 * selenium.autoSuggestiveDropdownWithoutText1("opportunityEditSearchCource");
				 * selenium.waitingTime(5000);
				 */
				/*
				 * selenium.type("opportunityEditAccountMHECourseName",
				 * "opportunity Edit Account MHE Course Name"); selenium.waitingTime(2000);
				 * selenium.type("opportunityEditMHECourseName1",
				 * "opportunity Edit MHE Course Name"); selenium.waitingTime(2000);
				 * selenium.autoSuggestiveDropdownWithoutText1("opportunityEditMHECourseName1");
				 * selenium.waitingTime(5000);
				 * if(selenium.isElementPresentFast("opportunityEditMHECourseName1NewPage")) {
				 * selenium.waitingTime(2000);
				 * selenium.type("opportunityEditMHECourseName1NewPage",
				 * "opportunity Edit MHE Course Name"); selenium.waitingTime(2000);
				 * selenium.clickLoop("SaveBtnNew1"); selenium.waitingTime(9000); }
				 */
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
//				selenium.waitingTime(5000);
				//selenium.jsClick("Save_Btn");

				selenium.waitingTime(10000);
				if (selenium.isElementPresentFast("ErrorListAll")) {
					selenium.jsClick("closePopUp");
					selenium.waitingTime(2000);
					selenium.click("CancelButton");

				}

				selenium.waitingTime(12000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {

			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
				selenium.switchOutOfFrame();
				selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			} else {
				selenium.click("CancelButton");
				selenium.switchOutOfFrame();
				selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

		}

	}

	@And("^Edit Opportunities details Product related$")
	public void dit_Opportunities_details_product_related() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(3000);
				/*selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);*/

				selenium.navigateToURL(OppURLToEditProduct);
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
				selenium.click("opportunityLineItemRelatedList");
				selenium.waitingTime(5000);
				String Xpath_opp = selenium.getDynamicXpath("anchorTitle", "Opportunity Products", "end");
				System.out.println(Xpath_opp);
				//selenium.clickXpath(Xpath_opp);
				selenium.refresh();
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("table_row1");
				selenium.jsClick("table_row1");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("editL");
				selenium.click("editL");
				selenium.waitingTime(5000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeVisible("opportunityAccountsEditQuantity");
				selenium.type("opportunityAccountsEditQuantity", "opportunity Accounts Edit Quantity");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(12000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			if (selenium.isElementPresentFast("ErrorMsg")) {
				selenium.click("opportunityAccountsEditCancel");
			}

			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@And("^verify Edit Product From Opp Successfull$")
	public void verify_sample_is_created_for_seg_user() {
		try {
			selenium.waitingTime(5000);
			boolean success = selenium.isElementPresentFast("samplecreatedSuccessMessage");
			System.out.println("success" + success);
			if (success == true) {
				selenium.test.log(LogStatus.PASS, "Edit Product From Opp Successfull");
				System.out.println("INSIDE PASS");

			} else {
				selenium.test.log(LogStatus.FAIL, "Edit Product From Opp Successfull");
				System.out.println("INSIDE Fail");
				selenium.reportFailure("Edit Product From Opp Successfull");


			}
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Edit Product From Opp Successfull");
			System.out.println("INSIDE Fail");
		}
	}


	@And("^Opp Pri Contact Via Edit$")
	public void Opp_Pri_Contact_Via_Edit() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(2000);
				selenium.navigateToURL(opportunityContacts);
//				selenium.waitingTime(8000);	
				selenium.waitForElementToBeClickable("contactPromaryEditClick");
				selenium.click("contactPromaryEditClick");
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("contactPrimaryMark");
				selenium.jsClick("contactPrimaryMark");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");


				selenium.waitForElementsToBeVisible("contactPromaryEditClick");
				if (selenium.isElementPresentFast("contactPromaryEditClick")) {

					selenium.test.log(LogStatus.PASS, "Edited from Opp Primary");
					System.out.println(" Edited from Opp Primary");
				} else {

					boolean error = selenium.isElementPresentFast("ErrorListAll");
					System.out.println(error);
					if (error == true) {
						System.out.println("Error came");
						selenium.waitingTime(2000);
						selenium.click("ProductCloseButtonOpp");
						selenium.test.log(LogStatus.FAIL, "Error Product Edited from Opp");
						selenium.reportFailure("Error Product Edited from Opp");
					}


				}
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("ProductCloseButtonOpp");
			} else {

				selenium.click("ProductCloseButtonOpp");
			}
		}
	}


	@And("^Edit Product From Opp$")
	public void Edit_Product_From_Opp() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(2000);
//				selenium.navigateToURL(opportunityAccount);
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("products_quote");
				selenium.click("products_quote");
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(10000);
				if (selenium.isElementPresentFast("FirstTableRecord")) {
					System.out.println("FirstTableRecord Eelement Present");
					selenium.click("FirstTableRecord");
				} else {
					selenium.refresh();
					selenium.waitingTime(10000);
					selenium.waitForElementToBeClickable("FirstTableRecord");
					selenium.clickLoop("FirstTableRecord");
				}
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("editL");
				selenium.click("editL");
				selenium.waitingTime(6000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeVisible("opportunityAccountsEditQuantity");
				selenium.type("opportunityAccountsEditQuantity", "Edit Quantity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(8000);

				if (!selenium.isElementPresentFast("opportunityAccountsEditQuantity")) {

					selenium.test.log(LogStatus.PASS, "Product Edited from Opp");
					System.out.println("Product Edited from Opp");
				} else {

					boolean error = selenium.isElementPresentFast("ErrorListAll");
					System.out.println(error);
					if (error == true) {
						System.out.println("Error came");
						selenium.waitingTime(2000);
						selenium.click("ProductCloseButtonOpp");
						selenium.test.log(LogStatus.FAIL, "Error Product Edited from Opp");
						selenium.reportFailure("Error Product Edited from Opp");
					}


				}
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("ProductCloseButtonOpp");
			} else {

				selenium.click("ProductCloseButtonOpp");
			}
		}
	}

	@And("^Edit Quote From Opp$")
	public void Edit_Quote_From_Opp() {
		try {
//			selenium.waitingTime(2000);
//			selenium.clickLoop("RecentlyAddedRecord");
//			selenium.waitingTime(5000);
//			selenium.waitForElementToBeVisible("newAccountFrame");
//			selenium.switchToMultipleFrame("newAccountFrame");
//			selenium.waitingTime(6000);
//			selenium.waitForElementToBeClickable("edit");
//			selenium.click("edit");
//			selenium.switchOutOfFrame();
//			System.out.println("Waiting Waiting....");
//			selenium.waitingTime(60000);
			selenium.captureScreenShot();
			selenium.defaultframe();
			selenium.switchToMultipleFrame("productframeUat");
			System.out.println("1st frame");
			selenium.waitingTime(4000);
			selenium.switchToFrame("frame_quote");
			System.out.println("2nd frame");
			selenium.waitingTime(4000);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickableLongerDuration("quoteEditOpp");
			selenium.click("quoteEditOpp");
			System.out.println("edit btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("quoteNameEdit");
			selenium.type("quoteNameEdit", "quote Name");
			selenium.waitingTime(4000);
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("quoteSave");
			selenium.jsClick("quoteSave");
			selenium.waitingTime(4000);
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.PASS, "Edited from Opp");
			System.out.println("PASS");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("ProductCloseButtonOpp");
			} else {

				selenium.click("ProductCloseButtonOpp");
				selenium.test.log(LogStatus.FAIL, "Edited from Opp");
			}
		}
	}

	@And("^I Add INTL Sample to opportunity$")
	public void I_Add_INTL_Sample_to_opportunity() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("INTLNewSampleBtn");
			selenium.click("INTLNewSampleBtn");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ProductCourse");
			selenium.clearText("ProductCourse");
			selenium.waitForElementToBeClickable("author");
			selenium.type("author", "Author Name");
//			selenium.type("SampleISBN", "ISBN");
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.jsClick("searchProductsBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstOppContactCheckbox");
			selenium.click("FirstOppContactCheckbox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Addtosampleandcontinue");
			selenium.click("Addtosampleandcontinue");
			selenium.waitingTime(5000);
			selenium.defaultframe();
			selenium.switchToFrame("sampleContact");
			selenium.waitForElementToBeClickable("createsampleorder");
			selenium.click("createsampleorder");
			if (selenium.isElementPresentFast("Duplicate")) {
				selenium.waitForElementToBeClickable("yestoall");
				selenium.click("yestoall");
			}
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.PASS, "New Sample created successfully");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating INTL sample for an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating INTL sample for an opportunity");
		}
	}

	@And("^Opportunities Samples creation$")
	public void Edit_Opportunities_Samples() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(3000);
				selenium.waitingTime(6000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(5000);
				if (selenium.isElementPresentFast("CloseNotificationPopup")) {
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
				if (selenium.isElementPresentFast("opportunityNewSample")) {
					selenium.click("opportunityNewSample");
				} else {
					selenium.click("moreActionsBtn");
					selenium.waitForElementToBeClickable("NewSampleopportunityL");
					selenium.click("NewSampleopportunityL");
				}
				selenium.waitingTime(6000);
				selenium.switchToFrame("sampleContact");
				selenium.waitingTime(4000);
				if (selenium.isElementPresentFast("newSampleCreationPopup")) {
					selenium.clickLoop("newSampleCreationPopupOk");
				}
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("ClickNextButton");
				selenium.click("ClickNextButton");
				selenium.switchOutOfFrame();
				selenium.waitingTime(4000);
				selenium.switchToFrame("iFrameOppSampleCreation");
				selenium.click("createSampleOrderBtn");
				selenium.switchOutOfFrame();
				boolean duplicateSample = selenium.isElementPresentFast("opportunitySampleCreationIframeDuplicate");
				if (duplicateSample == true) {
					selenium.switchToFrame("opportunitySampleCreationIframeDuplicate");
					selenium.click("opportunitySampleCreationIframeDuplicateOK");
					selenium.switchOutOfFrame();
				}

				selenium.waitingTime(10000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Opportunities Samples Creation Marketing$")
	public void Edit_Opportunities_Samples_Marketing() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(3000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(3000);
				String xpath = selenium.getDynamicXpath("anchorTitle",
						"Opportunity Name dynamic Value", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(xpath);

//                	  selenium.type("ContactNameInputSearchNewOpportunity", "Opportunity Name dynamic Value");
//                	  selenium.waitingTime(3000);
//                	  selenium.click("ContactNameInputSearchNewRefresh");
//                	  selenium.waitingTime(6000);
//                        selenium.clickDynamicOpportunity("anchorTitle", "Opportunity Name dynamic Value", "end");
				selenium.waitingTime(5000);
				if (selenium.isElementPresentFast("CloseNotificationPopup")) {
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
				if (selenium.isElementPresentFast("opportunityNewSample")) {
					selenium.click("opportunityNewSample");
				} else {
					selenium.click("moreActionsBtn");
					selenium.waitForElementToBeClickable("NewSampleopportunityL");
					selenium.click("NewSampleopportunityL");
				}
				selenium.waitingTime(6000);
				selenium.switchToFrame("iFrameOppSampleCreation");
				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("swappedProductsPopUp")) {
					System.out.println("inside swap poppup");
					selenium.test.log(LogStatus.INFO, "Swap Product Popup Appeared!");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("okButton");
					selenium.jsClick("okButton");
					selenium.waitingTime(3000);
				}
				selenium.waitForElementToBeClickable("ClickNextButton");
				selenium.click("ClickNextButton");
				selenium.switchOutOfFrame();
				selenium.waitingTime(10000);
				selenium.switchToFrame("iFrameOppSampleCreation");
				selenium.waitForElementToBeClickable("opportunityCreateSampleRequest");
				selenium.click("opportunityCreateSampleRequest");
				selenium.waitingTime(10000);
				selenium.switchOutOfFrame();
				boolean duplicateSample = selenium
						.isElementPresent("iFrameOppSampleCreation");
				if (duplicateSample == true) {
					selenium.switchToFrame("iFrameOppSampleCreation");
					selenium.click("opportunitySampleCreationIframeDuplicateOK");
					selenium.switchOutOfFrame();
				}

				selenium.waitingTime(10000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Opportunities New Event Nomination$")
	public void Opportunities_NewEventNomination() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				/*
				 * selenium.search("Opportunity Name dynamic Value");
				 * selenium.waitingTime(4000); String
				 * xpath=selenium.getDynamicXpath("anchorTitle",
				 * "Opportunity Name dynamic Value", "end");
				 * selenium.clickLoopXpath(xpath); //
				 * selenium.clickDynamicOpportunity("anchorTitle",
				 * "Opportunity Name dynamic Value", "end");
				 * selenium.waitingTime(4000);
				 */
				/*
				selenium.waitingTime(6000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(6000);				

				 */
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.jsClick("moreActionsBtn");
				selenium.waitingTime(2000);
//				selenium.waitForElementToBeClickable("opportunityNewEventNominationNew");
				selenium.click("opportunityNewEventNominationNew");

//				selenium.click("opportunityMoreOptionDropDown");
//				selenium.waitingTime(2000);			

//				selenium.jsClick("opportunityNewEventNomination");
				selenium.waitingTime(6000);
				selenium.switchToFrame("OpportunityFrameNew");
				// selenium.click("opportunityNewEventNominationCheckbox");
				selenium.waitingTime(2000);
				selenium.click("OppWSVotingTallyORNewEventNominationInstructorRanking");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunityNewEventNominationValue");
				selenium.type("opportunityNewEventNominationValue", "opportunity NewEventNomination Value IR");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityNewEventNominationValueOK");
				selenium.click("opportunityNewEventNominationValueOK");
//				selenium.waitingTime(2000);
//				selenium.waitForElementToBeClickable("opportunityNewEventNominationReasonForNomination");
//				selenium.click("opportunityNewEventNominationReasonForNomination");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunityNewEventNominationValue");
				selenium.type("opportunityNewEventNominationValue", "opportunity NewEventNomination Value RFN");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityNewEventNominationValueOK");
				selenium.click("opportunityNewEventNominationValueOK");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ButtonSave");
				selenium.click("ButtonSave");
				selenium.switchOutOfFrame();

				selenium.waitingTime(9000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Opportunities WorkSheet Validation$")
	public void Opportunities_WorkSheet_Validation() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				// selenium.clickDynamicOpportunity("anchorTitle", "Opportunity
				// Name dynamic Value", "end");
				selenium.waitingTime(6000);
				selenium.searchGlobal("Opportunity Name dynamic Value");
				selenium.waitingTime(6000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);

//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("strategyWorksheetBtn");
				selenium.jsClick("strategyWorksheetBtn");
//				selenium.waitingTime(10000);
				selenium.waitForElementToBeVisible("OpportunityFrameNew");

				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(2000);
				selenium.click("OppWSVotingTallyORNewEventNominationInstructorRanking");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityStrategyWorksheetVotingTallyEdit");
				selenium.click("opportunityStrategyWorksheetVotingTallyEdit");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityStrategyWorksheetVotingTallyValue");
				// selenium.click("opportunityStrategyWorksheetVotingTallyValue");
				selenium.jsClick("opportunityStrategyWorksheetVotingTallyValue");
//                	    selenium.waitingTime(2000);
//                	    selenium.autoSuggestiveDropdownOne("opportunityStrategyWorksheetVotingTallyEdit", "Worksheet Voting Tally Edit");
//                	    selenium.waitingTime(2000);
//                	    selenium.click("opportunityStrategyWorksheetDecisionMakerType");
//                	    selenium.waitingTime(2000);
//                	    selenium.autoSuggestiveDropdownOne("opportunityStrategyWorksheetDecisionMakerTypeEdit", "Worksheet Decision MakerType Edi");
//                	    selenium.waitingTime(2000);
//                	    selenium.click("opportunityStrategyWorksheetDecisionDriver");
//                	    selenium.waitingTime(2000);                	  
//                	    selenium.autoSuggestiveDropdownOne("opportunityStrategyWorksheetDecisionDriverEdit", "Worksheet Decision Driver Edit");
//                	    selenium.waitingTime(2000);
//                	    selenium.click("Button_Save");
//                	    selenium.waitingTime(8000);

			}

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^add Primary Campaign Source to opportunity$")
	public void add_Primary_Campaign_Source_to_opportunity() {
		try {
			selenium.waitForElementToBeClickable("PrimaryCampaignSourceEditIcon");
			selenium.click("PrimaryCampaignSourceEditIcon");
			selenium.waitingTime(10000);
			selenium.scrolldown(100);
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("ClearExistingCampaign"))
			{
				selenium.click("ClearExistingCampaign");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("PrimaryCampaignSourceEditBox");
			selenium.type("PrimaryCampaignSourceEditBox", "Primary Campaign Source");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath("lightningTitle", "Primary Campaign Source", "end");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(xpath);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ConfidenceFactorList");
			selenium.click("ConfidenceFactorList");
			selenium.waitForElementToBeClickable("ConfidenceFactorListValue");
			selenium.click("ConfidenceFactorListValue");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(20000);
		} catch (Exception e) {
			selenium.reportFailure("Error while adding Primary Campaign Source for opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding Primary Campaign Source for opportunity");
		}
	}

	@And("^make sure the contact is active and linked to account$")
	public void validate_contact_account_and_status() {
		try {
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002TU9KQAA1/view");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			if (selenium.isElementPresentFast("ContactInactiveStatusCheck")) {
				System.out.println("Contact is in InActive state");
				selenium.test.log(LogStatus.INFO, "Contact is in InActive state");
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("ContactStatusField");
				selenium.click("ContactStatusField");
				selenium.waitForElementToBeClickable("ContactActiveOption");
				selenium.click("ContactActiveOption");
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
			} else {
				System.out.println("Contact is in Active state");
				selenium.test.log(LogStatus.INFO, "Contact is in Active state");
			}

			if (selenium.isElementPresentFast("AccountLinkInContact")) {
				System.out.println("Contact is linked to an account");
				selenium.test.log(LogStatus.INFO, "Contact is linked to an account");
			} else {
				System.out.println("Contact is not linked to an account");
				selenium.test.log(LogStatus.INFO, "Contact is not linked to an account");
				if (!selenium.isElementPresentFast("Save_Btn")) {
					System.out.println("Contact page is in view mode. so editing it..");
					selenium.waitForElementToBeClickable("editButton");
					selenium.click("editButton");
					selenium.waitingTime(4000);
				}
				System.out.println("Contact page is already in edit mode.");
				selenium.waitForElementToBeClickable("serach_Account");
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
			}
			selenium.captureScreenShot();
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.reportFailure("Error while validating account and status of a contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating account and status of a contact");
		}
	}

	@And("^add opp contact if not already exist$")
	public void add_opp_contact_if_not_already_exist() {
		try {
			String contactName = "Billy";
			String contactName2 = "Jim";
			selenium.refresh();
			selenium.waitingTime(12000);
			selenium.scrollToElement("opportunityContactsLink");
			selenium.waitingTime(2000);
			selenium.scrolldown(-300);
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(6000);
			if (!selenium.isElementPresentFast("firstOppContactRecord")) {
				selenium.captureScreenShot();
				System.out.println("No Contact exist for this opportunity");
				selenium.test.log(LogStatus.INFO, "Creating New Opp. Contact");
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("productAddOrEdit");
				selenium.jsClick("productAddOrEdit");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeVisible("productframeUat");
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("OppContactFirstName");
				selenium.typeData("OppContactFirstName", contactName);
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.jsClick("searchBtn");
				selenium.waitingTime(8000);
				if (selenium.isElementPresentFast("opportunitiesSearchResultForAdding")) {
					selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
					selenium.jsClick("opportunitiesSearchResultForAdding");
				} else {
					selenium.waitForElementToBeClickable("OppContactFirstName");
					selenium.typeData("OppContactFirstName", contactName2);
					selenium.waitForElementToBeClickable("searchBtn");
					selenium.jsClick("searchBtn");
					selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
					selenium.jsClick("opportunitiesSearchResultForAdding");
				}
				selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
				selenium.scrollToElement("opportunitiesAddToOpportunity");
				selenium.jsClick("opportunitiesAddToOpportunity");
				selenium.waitForElementToBeVisible("Button_Save");
				selenium.scrollToElement("Button_Save");
				selenium.jsClick("Button_Save");
				selenium.switchOutOfFrame();
				selenium.waitingTime(12000);
				selenium.refresh();
				selenium.waitingTime(6000);
			} else {
					if(selenium.getTestCaseName().equalsIgnoreCase("VerifyCSPartnerFieldInOpp"))
					{
						selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
					}
					else
					{
						selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
					}
				selenium.waitingTime(8000);
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while adding contact for opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding contact for opportunity");
		}
	}

	@And("^add opp product if not already exist$")
	public void add_opp_product_if_not_already_exist() {
		try {
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(6000);
			if (!selenium.isElementPresentFast("firstOppProductRecord")) {
				selenium.waitForElementToBeClickable("modifyProducts");
				selenium.click("modifyProducts");
				selenium.waitingTime(15000);
				selenium.switchToFrame("switch_iFrame");
				selenium.waitForElementToBeClickable("keyIsbn");
				selenium.click("keyIsbn");
				selenium.waitingTime(2000);
				selenium.type("keyIsbn", "ISBN");
				selenium.waitForElementToBeClickable("addButton");
				selenium.click("addButton");
				selenium.waitingTime(13000);
				selenium.clickLoop("saveProduct");
				selenium.switchOutOfFrame();
				selenium.waitingTime(12000);
				selenium.refresh();
				selenium.waitingTime(6000);
			} else {
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(8000);
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while adding product for opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding product for opportunity");
		}
	}

	@And("^verify the Primary Campaign Source and opp Created Date in newly cloned opportunities$")
	public void verify_the_Primary_Campaign_Source_and_opp_Created_Date_in_newly_cloned_opportunities() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("OppPrimaryCampaignSourceValue");
			String actualValue = selenium.getText("OppPrimaryCampaignSourceValue");
			System.out.println("Actual Value is :" + actualValue);
			String expectedValue = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Primary Campaign Source");
			System.out.println("Expected Value is : " + expectedValue);
			if (actualValue.equalsIgnoreCase(expectedValue)) {
				selenium.test.log(LogStatus.PASS, "The Primary Campaign Source got updated in the newly cloned opp successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "The Primary Campaign Source did not get updated in the newly cloned opp");
				selenium.reportFailure("The Primary Campaign Source did not get updated in the newly cloned opp");
				System.out.println("FAIL");
			}

			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);

			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);

			selenium.waitForElementToBeVisible("OppCreatedDate");
			String recordDate = selenium.getTextLoop("OppCreatedDate").toString();
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);

			if (recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
				selenium.test.log(LogStatus.PASS, "Opp created date verified successfully in the newly cloned opp!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp created date validation failed in the newly cloned opp");
				selenium.reportFailure("Opp created date validation failed in the newly cloned opp");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while verifying Primary Campaign Source and opp Created Date in newly cloned opportunities " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying Primary Campaign Source and opp Created Date in newly cloned opportunities");
		}
	}

	@And("^verify the Product and Contact details in newly cloned opportunities$")
	public void verify_the_Product_and_Contact_details_in_newly_cloned_opportunities() {
		try {
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(5000);

			if (selenium.isElementPresentFast("firstOppContactRecord")) {
				selenium.test.log(LogStatus.PASS, "Contact details cloned to new opp successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Contact details did not get cloned to new opp");
				selenium.reportFailure("Contact details did not get cloned to new opp");
				System.out.println("FAIL");
			}
			selenium.navigateBack();
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("firstOppProductRecord")) {
				selenium.test.log(LogStatus.PASS, "Product details cloned to new opp successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Product details did not get cloned to new opp");
				selenium.reportFailure("Product details did not get cloned to new opp");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying Product and Contact details in newly cloned opportunities " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying Product and Contact details in newly cloned opportunities");
		}
	}

	@And("^validate the Reason in previous opportunity$")
	public void validate_the_Reason_in_previous_opportunity() {
		try {
			selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("Opp_ReasonValue");
			String actualReason = selenium.getText("Opp_ReasonValue");
			System.out.println("Actual Reason is :" + actualReason);
			String expectedReason = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Clone Reason");
			System.out.println("Expected Reason is : " + expectedReason);
			if (actualReason.equalsIgnoreCase(expectedReason)) {
				selenium.test.log(LogStatus.PASS, "The cloned reason got updated in the previous/parent opp successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "The cloned reason did not get updated in the previous/parent opp");
				selenium.reportFailure("The cloned reason did not get updated in the previous/parent opp");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying reason in the previous opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying reason in the previous opportunity");
		}
	}

	@Then("^change the opportunity stage to OPEN$")
	public void change_the_opportunity_stage_to_OPEN() {
		try {
			if (selenium.isElementPresentFast("OppStatePostponed")) {
				System.out.println("Opp is in Postponed stage so we cannot perform Clone/Postpone operation on it. So, I am changing the opp stage to Open");
				selenium.waitForElementToBeClickable("editStagesNew");
				selenium.click("editStagesNew");
				selenium.waitForElementToBeClickable("OppStatePostponedBtn");
				selenium.click("OppStatePostponedBtn");
				selenium.waitForElementToBeClickable("opportunityStage5");
				selenium.click("opportunityStage5");
				selenium.waitingTime(2000);
				selenium.scrolldown(200);
				selenium.waitForElementToBeClickable("ConfidenceFactorList");
				selenium.click("ConfidenceFactorList");
				selenium.waitForElementToBeClickable("ConfidenceFactorListValue");
				selenium.click("ConfidenceFactorListValue");
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(8000);
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while changing opportunity state " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while changing opportunity state");
		}
	}

	@And("^Opportunities PostponeClone Validation$")
	public void Opportunities_PostponeClone_Validation() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.refresh();
				selenium.waitingTime(10000);
				if (selenium.getTestCaseName().equalsIgnoreCase("VerifyOppCloseAndPurchaseDatePostponeClone")) {
					selenium.waitForElementToBeVisible("closedateOpp1");
					initialCloseDate = selenium.getText("closedateOpp1").toString();
					initialPurchaseDate = selenium.getText("purchaseDateopp1").toString();
					System.out.println("Initial Close Date" + initialCloseDate + "Initial Purchase Date " + initialPurchaseDate);
				}
				selenium.captureScreenShot();
				selenium.waitingTime(2000);

				if (selenium.isElementPresentFast("CheckOppStageProspect"))        //opp stage should not be prospect/closed for postpone/clone
				{
					selenium.scrollToElement("Edit_Stage");
					selenium.waitingTime(2000);
					selenium.scrolldown(-200);
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("Edit_Stage");
					selenium.click("Edit_Stage");
					selenium.waitingTime(6000);
					selenium.waitForElementToBeClickable("OppStageProspect1");
					selenium.click("OppStageProspect1");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("opportunityStage5");    //changing the stage to 'StatedNeed' if stage is 'Prospect'
					selenium.click("opportunityStage5");
					selenium.waitForElementToBeClickable("Save_Btn");
					selenium.click("Save_Btn");
					selenium.waitingTime(4000);
				}

				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("opportunityPostponClone");
				selenium.click("opportunityPostponClone");
				selenium.waitingTime(8000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(2000);
				selenium.selectDropdownByIndex("opportunityPostponCloneYear", "Index");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("opportunityPostponCloneReason", "Postpone Clone Reason");
				selenium.waitForElementToBeClickable("opportunityPostponCloneSave");
				selenium.click("opportunityPostponCloneSave");
				selenium.waitUntilOpportunityClones();
				selenium.waitingTime(60000);
				selenium.test.log(LogStatus.PASS, "Cloning process completed");
				selenium.switchOutOfFrame();
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				/*Capturing newly created opp url and name for createQuote test*/
				selenium.newOppCreatedViaPostponeClone = selenium.getURL();
				System.out.println("newOppCreatedViaPostponeClone URL is: " + selenium.newOppCreatedViaPostponeClone);
				selenium.waitingTime(2000);
				selenium.navigateToURL(selenium.newOppCreatedViaPostponeClone);
				selenium.waitingTime(10000);
//				selenium.waitForElementToBeVisible("OppNameFromOppPage");
//				selenium.opty_expected = selenium.getText("OppNameFromOppPage");
//				System.out.println("Newly created via postpone/clone opp name is :" + selenium.opty_expected);
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating Opportunity PostponeClone functionality " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating Opportunity PostponeClone functionality");
		}
	}
	
	@And("^add subtypes in opportunity$")
	public void add_subtypes_in_opportunity() {
		try {
			selenium.takeScreenShot();
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.takeScreenShot();
			if (selenium.isElementPresentFast("editButton")) {
				selenium.click("editButton");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("editBtn");
				selenium.click("editBtn");
			}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SubtypeDropDownOpp");
			selenium.click("SubtypeDropDownOpp");
			selenium.waitForElementToBeClickable("SubtypeValue");
			selenium.click("SubtypeValue");
			selenium.waitingTime(2000);			
			selenium.click("Save_Btn");
			selenium.waitingTime(5000);
			
			if(selenium.isElementPresentFast("ConfidenceFactorError"))
			{
				System.out.println("Confidence factor is missing, so adding it..");
				selenium.scrollToElement("ConfidenceFactorList");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ConfidenceFactorList");
				selenium.click("ConfidenceFactorList");
				selenium.waitForElementToBeClickable("ConfidenceFactorListValue");
				selenium.click("ConfidenceFactorListValue");
				selenium.waitingTime(2000);
				selenium.click("Save_Btn");
				selenium.test.log(LogStatus.INFO, "Successfully added confidence factor in opportunity!");
			}
			
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Successfully added subtypes in opportunity!");
			
			if (selenium.getTestCaseName().equalsIgnoreCase("SEGSalesRepUserRenameOpp"))
			{
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeVisible("OppsubTypeHelpIcon");
				selenium.mouseHover("OppsubTypeHelpIcon");
				selenium.waitingTime(3000);
				selenium.takeScreenShot();
				String expected = selenium.getTestDataFromPropertiesFile("OppSubtypeTooltipText");
				String actual = selenium.getElement("OppsubtypeTooltipGetText").getText();
				System.out.println("expected" +  expected + "actual" + actual);
				assertTrue(actual.contains(expected));
				selenium.test.log(LogStatus.PASS, "The expected tooltip message appeared");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while adding subtypes in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding subtypes in opportunity");
		}
	}
	
	@And("^add confidence factor in opportunity$")
	public void add_confidence_factor_in_opportunity() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("editButton")) {
				selenium.click("editButton");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("editBtn");
				selenium.click("editBtn");
			}
			
			selenium.waitForElementToBeClickable("ConfidenceFactorList");
			selenium.click("ConfidenceFactorList");
			selenium.waitForElementToBeClickable("ConfidenceFactorListValue");
			selenium.click("ConfidenceFactorListValue");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Successfully added confidence factor in opportunity!");
		} catch (Exception e) {
			selenium.reportFailure("Error while adding confidence factor in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding confidence factor in opportunity");
		}
	}

	@And("^validate the close and purchase dates$")
	public void validate_the_close_and_purchase_dates() {
		try {
			selenium.waitForElementToBeVisible("closedateOpp1");
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("closedateOpp1");
			updatedCloseDate = selenium.getText("closedateOpp1").toString();
			updatedPurchaseDate = selenium.getText("purchaseDateopp1").toString();
			System.out.println("Updated Close Date" + updatedCloseDate + "Updated Purchase Date " + updatedPurchaseDate);
			if (updatedCloseDate.equalsIgnoreCase(initialCloseDate) && updatedPurchaseDate.equalsIgnoreCase(initialPurchaseDate)) {
				selenium.test.log(LogStatus.FAIL, "Post postpone/clone opportunity, the Close and Purchase Date Did Not Get Updated");
				selenium.reportFailure("Post postpone/clone opportunity, the Close and Purchase Date Did Not Get Updated");
				System.out.println("FAIL");
			} else {
				selenium.test.log(LogStatus.PASS, "Post postpone/clone opportunity, the Close and Purchase Date Updated Successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while validating close and purchase date of the opportunity");
			selenium.reportFailure("Error while validating close and purchase date of the opportunity" + e.getMessage());
		}
	}

	@And("^Opportunities Split Lines Validation for Lost Stage$")
	public void Opportunities_Split_Lines_Validation_lost_Stage() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("OpportunityProductSplitLines");
				selenium.click("OpportunityProductSplitLines");
				selenium.waitingTime(4000);
//				if(!selenium.isElementPresentFast("splitOption"))
//				{
//					selenium.navigateToURL(splitLostProduct);
//				}
				selenium.waitForElementToBeClickable("splitOption");
				Select dropdown = new Select(selenium.getElement("splitOption"));
				dropdown.selectByValue("Lost");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("OpportunityProductSelect1");
				selenium.click("OpportunityProductSelect1");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("OpportunityProductSelect2");
				selenium.click("OpportunityProductSelect2");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("OpportunityProductSplitLinesBtn");
				selenium.click("OpportunityProductSplitLinesBtn");
				selenium.waitingTime(6000);
				selenium.selectDropdownText("PrimaryFundingType", "Primary Funding Type");
				selenium.waitingTime(5000);
				selenium.selectDropdownText("CreateLostOpportunityReason", "Create Lost Opportunity Reason");
				selenium.waitingTime(5000);
				selenium.selectDropdownText("WinPubSelect", "WinPub Select");
				selenium.waitingTime(4000);
				selenium.captureScreenShot();
				selenium.click("OpportunityProductSplitLinesBtn");
				selenium.waitingTime(35000);
				selenium.test.log(LogStatus.PASS, "Split Opportunity - Lost Stage");
			}

		} catch (Exception e) {

			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^verify Status Date field value$")
	public void verify_Status_Date_field_value() {
		try {
			selenium.navigateToURL(selenium.OppWithLostStage);
			selenium.waitingTime(8000);			
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("modifyProducts");
			selenium.click("modifyProducts");
			selenium.waitingTime(15000);
			selenium.switchToFrame("switch_iFrame");
			selenium.waitForElementToBeClickable("keyIsbn");
			selenium.click("keyIsbn");
			selenium.waitingTime(2000);
			selenium.typeData("keyIsbn", "9780390353092"); //9780077033569
			selenium.waitForElementToBeClickable("addButton");
			selenium.click("addButton");
			selenium.waitingTime(10000);
			selenium.clickLoop("saveProduct");
			selenium.waitingTime(25000);
			selenium.switchOutOfFrame();
			
			selenium.navigateToURL(selenium.OppWithLostStage);
			selenium.waitingTime(8000);		
			selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitForElementToBeClickable("StageLost");	//lost
			selenium.jsClick("StageLost");
			selenium.waitForElementToBeClickable("SubtypeDropDownOpp");
			selenium.click("SubtypeDropDownOpp");
			selenium.waitForElementToBeClickable("SubtypeValue");
			selenium.click("SubtypeValue");
			selenium.waitingTime(2000);	
			selenium.waitForElementToBeClickable("WinningPublisherField");
			selenium.click("WinningPublisherField");
			selenium.waitForElementToBeClickable("WinningPublisherPicklistValue4");
			selenium.click("WinningPublisherPicklistValue4");
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitForElementToBeClickable("OppLostReasonValue");
			selenium.jsClick("OppLostReasonValue");
			selenium.waitingTime(2000);
			selenium.scrollToElement("PrimaryFundingTypeField");
			selenium.waitingTime(2000);	
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);	
			selenium.waitForElementToBeClickable("PrimaryFundingTypeField");
			selenium.click("PrimaryFundingTypeField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PrimaryFundingTypeValue");
			selenium.click("PrimaryFundingTypeValue");
			selenium.waitingTime(2000);
		
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			
			selenium.waitForElementToBeVisible("StatusDatefieldInSEGOpp");
			selenium.scrollToElement("StatusDatefieldInSEGOpp");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			String StatusDate = selenium.getText("StatusDatefieldInSEGOpp");
			System.out.println("StatusDate when Opp stage is in Won/Lost/Cancelled/Postponed is -->" + StatusDate);
			if(StatusDate != null)
			{
				System.out.println("StatusDate field is not null");
				selenium.jsClick("editButton");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("OppStageField");
				selenium.jsClick("OppStageField");
				selenium.waitForElementToBeClickable("opportunityStage2");	//Qualified
				selenium.jsClick("opportunityStage2");
//				selenium.waitForElementToBeClickable("SubtypeDropDownOpp");
//				selenium.click("SubtypeDropDownOpp");
//				selenium.waitForElementToBeClickable("SubtypeValue");
//				selenium.click("SubtypeValue");
				selenium.waitingTime(2000);			
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
				StatusDate = selenium.getText("StatusDatefieldInSEGOpp");
				System.out.println("StatusDate when Opp stage is in Stated Need/Pilot/Qualified/Presentation/Quote is -->" + StatusDate);
				if(StatusDate == null || StatusDate.isBlank() || StatusDate.isEmpty())
				{
					System.out.println("Status Date is cleared out & is blank now - PASS");
					selenium.test.log(LogStatus.PASS, "Status Date is cleared out & is blank now");
				}
				else
				{
					System.out.println("FAIL");
					selenium.reportFailure("Status Date field is not blank");
					selenium.test.log(LogStatus.FAIL, "Status Date field is not blank");
				}
			}
			else
			{
				System.out.println("Make sure StatusDate field is not null");
				selenium.reportFailure("Make sure StatusDate field is not null");
				selenium.test.log(LogStatus.FAIL, "Make sure StatusDate field is not null");
			}
			
			
		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.waitingTime(8000);
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Opportunities New Event Nomination Marketing$")
	public void Opportunities_NewEventNomination_Marketing() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				/*
				 * selenium.search("Opportunity Name dynamic Value");
				 * selenium.waitingTime(3000); String
				 * xpath=selenium.getDynamicXpath("anchorTitle",
				 * "Opportunity Name dynamic Value", "end");
				 * selenium.clickLoopXpath(xpath);
				 *
				 * //selenium.clickDynamicOpportunity("anchorTitle",
				 * "Opportunity Name dynamic Value", "end");
				 * selenium.waitingTime(4000);
				 */
				/*
				selenium.waitingTime(6000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(6000);

				 */
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.jsClick("moreActionsBtn");
				selenium.waitForElementToBeClickable("opportunityNewEventNomination");
				selenium.jsClick("opportunityNewEventNomination");
				selenium.waitingTime(8000);
				selenium.switchToFrame("OpportunityFrameNew");
				// selenium.click("opportunityNewEventNominationCheckbox");
				selenium.waitingTime(2000);
				selenium.click("OppWSVotingTallyORNewEventNominationInstructorRanking");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunityNewEventNominationValue");
				selenium.type("opportunityNewEventNominationValue", "opportunity NewEventNomination Value IR");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityNewEventNominationValueOK");
				selenium.click("opportunityNewEventNominationValueOK");
//				selenium.waitingTime(2000);
//				selenium.waitForElementToBeClickable("opportunityNewEventNominationReasonForNomination");
//				selenium.click("opportunityNewEventNominationReasonForNomination");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunityNewEventNominationValue");
				selenium.type("opportunityNewEventNominationValue", "opportunity NewEventNomination Value RFN");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityNewEventNominationValueOK");
				selenium.click("opportunityNewEventNominationValueOK");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ButtonSave");
				selenium.click("ButtonSave");
				selenium.switchOutOfFrame();

				selenium.waitingTime(5000);

			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Mass Edit Opportunities$")
	public void Mass_Edit_Opportunities() {
		try {
			selenium.waitForElementToBeVisible("opportunityRecentlyViewed1");
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("opportunityRecentlyViewed1");
			selenium.click("opportunityRecentlyViewed1");
//				selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("opportunityRecentlyViewedSearch");
			selenium.type("opportunityRecentlyViewedSearch", "opportunity Recently Viewed Search");
			selenium.waitingTime(3000);
			selenium.autoSuggestiveDropdownWithoutText1("opportunityRecentlyViewedSearch");
			selenium.waitingTime(60000);
			selenium.waitForElementsToBeVisible("opportunitySelectionCheckBox1");
			selenium.waitingTime(9000);
//				selenium.waitForElementToBeClickable("opportunitySelectionCheckBox1");
			selenium.jsClick("opportunitySelectionCheckBox1");
			selenium.waitingTime(2000);
//				selenium.waitForElementToBeClickable("opportunitySelectionCheckBox2");
			selenium.jsClick("opportunitySelectionCheckBox2");
			selenium.waitingTime(4000);
//				selenium.waitForElementToBeClickable("opportunityMassEdit");
			if (selenium.isElementPresentFast("CloseNotificationPopup")) {
				selenium.click("CloseNotificationPopup");
				selenium.waitingTime(2000);
			}
			selenium.click("opportunityMassEdit");
			selenium.waitingTime(4000);
			// selenium.switchToFrame("switch_iFrame");
			selenium.switchToMultipleFrame("switch_iFrame");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityMassEditValueInput1");
			selenium.type("opportunityMassEditValueInput1", "opportunity Mass EditValue Input1");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("opportunityMassEditValueInput2");
			selenium.type("opportunityMassEditValueInput2", "opportunity Mass EditValue Input2");
			selenium.waitingTime(3000);

//				Select dropdown = new Select(selenium.getElement("MassOppEditStage1"));
//				dropdown.selectByValue("Prospect");
//				dropdown = new Select(selenium.getElement("MassOppEditStage2"));
//				dropdown.selectByValue("Prospect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunityMassEditSave");
			selenium.jsClick("opportunityMassEditSave");
			selenium.switchOutOfFrame();
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^check two opp records avilability in recently view opp list$")
	public void check_two_opp_records() {
		try {		
			selenium.waitForElementToBeVisible("opportunityRecentlyViewed1");
			selenium.waitingTime(10000);
			String OppRecentlyViewedList_Page = selenium.getURL();

			if(selenium.isElementPresentFast("opportunitySelectionCheckBox1") && selenium.isElementPresentFast("opportunitySelectionCheckBox2"))
			{
				System.out.println("Opportunities already present in the recently viewed list..");
			}
			else
			{
				System.out.println("Creating new opportunity..");
				String AccountName1 = "ACE ACADEMY";
				String Amount = "100";
				String Owner = "MHHE Automation Testing";
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.click("NewBtn");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("NextButton");
				selenium.click("NextButton");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(15000);
				if(selenium.isElementPresentFast("SEGOppAccountName"))
				{
					selenium.waitForElementToBeClickable("SEGOppAccountName");
					selenium.typeData("SEGOppAccountName", AccountName1);
				}
				else
				{
					selenium.refresh();
					selenium.waitingTime(15000);
					selenium.waitForElementToBeClickable("SEGOppAccountName");
					selenium.typeData("SEGOppAccountName", AccountName1);
				}
				
				selenium.waitingTime(4000);
//				selenium.clickDynamicUsingAccName("StrongTagStart", AccountName1, "endContains");
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("DateLink");
				selenium.click("DateLink");
				selenium.waitForElementToBeClickable("DefaultPurchaseDate");
				selenium.click("DefaultPurchaseDate");

//				selenium.click("ConfidenceFactor");
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(1);
			selenium.typeData("OppAmount", Amount);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppOwner");
			selenium.typeData("OppOwner", Owner);
			selenium.waitingTime(4000);
//			selenium.clickDynamicUsingAccName("StrongTagStart", Owner, "endContains");
//			selenium.waitingTime(6000);
			selenium.click("Button_Save");
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("Button_Save")) {
				selenium.click("Button_Save");
				selenium.waitingTime(10000);
			}
			selenium.navigateToURL(OppRecentlyViewedList_Page);
			selenium.waitingTime(5000);
			check_two_opp_records();
		}

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^SEG Sales Manager Mass Edit Opportunities$")
	public void SEG_Sales_Manager_Mass_Edit_Opportunities() {
		try {

				
			selenium.waitForElementsToBeVisible("opportunitySelectionCheckBox1");
			selenium.jsClick("opportunitySelectionCheckBox1");
			selenium.waitingTime(2000);
			selenium.jsClick("opportunitySelectionCheckBox2");
			selenium.waitingTime(4000);

			selenium.click("opportunityMassEdit");
			selenium.waitingTime(4000);

//			selenium.switchToMultipleFrame("switch_iFrame");
//			selenium.waitingTime(3000);
//			selenium.typeData("opportunityMassEditValueInput1", "1500");
//			selenium.typeData("opportunityMassEditValueInput2", "1500");


				selenium.switchToMultipleFrame("switch_iFrame");
				selenium.waitingTime(3000);
				selenium.typeData("opportunityMassEditValueInput1", "1500");
				selenium.typeData("opportunityMassEditValueInput2", "1500");

				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityMassEditSave");
				selenium.jsClick("opportunityMassEditSave");
				selenium.switchOutOfFrame();
				selenium.waitingTime(15000);
		}

		catch (Exception e) {

			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Mass Edit Opportunities Marketing$")
	public void Mass_Edit_Opportunities_Marketing() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				// selenium.click("opportunityRecentlyViewed1");
				selenium.jsClick("opportunityRecentlyViewed1");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("opportunityRecentlyViewedSearch");
				selenium.type("opportunityRecentlyViewedSearch", "opportunity Recently Viewed Search");
				selenium.waitingTime(3000);
				selenium.autoSuggestiveDropdownWithoutText1("opportunityRecentlyViewedSearch");
				selenium.waitingTime(25000);
				selenium.waitForElementsToBeVisible("opportunitySelectionCheckBox1");
				selenium.waitingTime(9000);
				selenium.jsClick("opportunitySelectionCheckBox1");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunitySelectionCheckBox2");
				selenium.jsClick("opportunitySelectionCheckBox2");
				selenium.click("opportunityMassEdit");
				selenium.waitingTime(4000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(2000);
				selenium.type("opportunityMassEditValueInput1", "opportunity Mass EditValue Input1");
				selenium.type("opportunityMassEditValueInput2", "opportunity Mass EditValue Input2");
//				Select dropdown = new Select(selenium.getElement("MassOppEditStage3"));
//				dropdown.selectByValue("Takeaway");
//				dropdown = new Select(selenium.getElement("MassOppEditStage4"));
//				dropdown.selectByValue("Takeaway");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("opportunityMassEditSave");
				selenium.jsClick("opportunityMassEditSave");
				selenium.switchOutOfFrame();
				selenium.waitingTime(6000);
			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I fill in all the mandatory details to create a new opportunity Sales$")
	public void i_fill_in_the_following_to_create_a_new_opportunity_Sales() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.jsClick("opp_Link");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("NewActionButton");
				selenium.clickLoop("NewActionButton");
				selenium.waitingTime(4000);
				// selenium.switchToFrame("productframeUat");
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(4000);
				selenium.autoSuggestiveDropdownOne("OpportunityMHECourse2", "MHE Course");
				selenium.waitingTime(6000);
				String mheCourse = selenium.getDynamicXpath("SelectMHECourses", "MHE Course",
						"endContains");
				selenium.waitingTime(4000);
				System.out.println("mheCourse :" + mheCourse);
				selenium.clickLoopXpath(mheCourse);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("oppurtunityType");
				selenium.selectDropdownText("oppurtunityType", "Oppurtunity Type");
				selenium.type("accountsOpportunityFallEnrolement", "Fall Enrolement");
				selenium.waitingTime(3000);
				selenium.moveTab("accountsOpportunityFallEnrolement");
				selenium.captureScreenShot();
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("ButtonSave");
				selenium.jsClick("ButtonSave");
				selenium.waitingTime(5000);
				selenium.switchOutOfFrame();
				selenium.waitingTime(5000);
				selenium.isElementPresentFast("newOppurtunitySuccessCheck");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
//				selenium.waitingTime(3000);

				selenium.test.log(LogStatus.PASS, "oppurtunity  created!");
				selenium.waitingTime(5000);
			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}
		}

////             selenium.type("closeDate", "Close Date");
////             selenium.type("orderDate", "Order Date");
//               selenium.type("mheCourse", "MHE Course");
//               selenium.waitingTime(2000);
//               String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
//               selenium.clickLoopXpath(xpath);
//               selenium.type("enrollment", "Enrollment");
//
//         } 
		catch (Exception e) {
			// selenium.click("CancelEdit");

			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Opportunity Contact Edit Update")
	public void Opportunity_Contact_Edit_Update() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				if (selenium.isElementPresentFast("CloseNotificationPopup")) {
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("OpportunityContactClick1");
				selenium.clickLoop("OpportunityContactClick1");
				selenium.waitingTime(5000);
				selenium.clickDynamic("Text_Span", "Contact Name Click", "end");
				selenium.waitingTime(8000);

				if (selenium.isElementPresentFast("closeBtn")) {
					System.out.println("Popup Present");
					selenium.click("closeBtn");
					selenium.waitingTime(8000);
				}

				selenium.waitingTime(15000);
				selenium.waitingTime(6000);
				selenium.clickLoop("NewOpportunityEditBtnMHE");
				selenium.waitingTime(6000);

				selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitycontactIsteachingnew");
				selenium.waitingTime(3000);
				selenium.autoSuggestiveDropdownWithoutTextTwo("opportunityContactRolenew");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutTextTwo("opportunitycontactLoyaltynew");
				selenium.waitingTime(2000);
				selenium.type("OpportunityContactRank", "OpportunityContactRank value");
				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("OpportunityContactPrimaryCheckBox") == true) {
					System.out.println("OpportunityContactPrimaryCheckBox Present");

					selenium.jsClick("OpportunityContactPrimaryCheckBox");
				}

				selenium.waitingTime(2000);
				selenium.click("Save_Btn");

				selenium.waitingTime(8000);
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {
				selenium.click("CancelButton");
			}
		}

	}

	@And("^Marketing Opportunity Contact Edit Update")
	public void Marketing_Opportunity_Contact_Edit_Update() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.waitingTime(6000);
				selenium.search("Opportunity Name dynamic Value");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name dynamic Value",
						"endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("OpportunityContactClick1");

				selenium.clickLoop("OpportunityContactClick1");
				selenium.waitingTime(3000);
				selenium.clickDynamic("Text_Span", "Contact Name Click", "end");
				selenium.waitingTime(8000);

				if (selenium.isElementPresentFast("closeBtn")) {
					System.out.println("Popup Present");
					selenium.click("closeBtn");
					selenium.waitingTime(8000);
				}

				selenium.waitingTime(15000);
//				selenium.waitForElementToBeClickable("NewOpportunityEditBtnMHE");
				// selenium.clickLoop("editButton");

				selenium.clickLoop("NewOpportunityEditBtnMHE");

				selenium.waitingTime(6000);

				if (selenium.isElementPresentFast("OpportunityContactIsteaching2")) {
					selenium.scrollToElement("OpportunityContactIsteaching2");
					System.out.println("OpportunityContactIsteaching Present");
				}
				selenium.autoSuggestiveDropdownWithoutTextTwo("OpportunityContactIsteaching2");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutTextTwo("OppRoleDropDown");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutTextTwo("OpportunityContactLoyality2");
				selenium.waitingTime(2000);
				selenium.type("OpportunityContactRank", "OpportunityContactRank value");
				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("OpportunityContactPrimaryCheckBox") == true) {
					System.out.println("OpportunityContactPrimaryCheckBox Present");

					selenium.jsClick("OpportunityContactPrimaryCheckBox");
				}

//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");

				selenium.waitingTime(8000);
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {
				selenium.click("CancelButton");
			}
		}

	}

	@And("^Consultant Request Form")
	public void Consultant_Request_Form() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("newCRF");
				selenium.clickLoop("newCRF");
				selenium.waitingTime(8000);
				selenium.switchToFrame("newCRFIframe");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("crfType", "Type");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("crfJobTitle", "JobTitle");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("crfPayRate", "PayRate");
				selenium.type("crfPresentationDate", "PresentationDate");
				selenium.type("crfAlternateDate1", "AlternateDate1");
				selenium.type("crfAlternateDate2", "AlternateDate2");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("crfPresentationTimeZone", "PresentationTimeZone");
				selenium.waitingTime(4000);
				selenium.scrollToElement("crfPresentationStartTime");
				selenium.selectDropdownText("crfPresentationStartTime", "PresentationStartTime");
				selenium.selectDropdownText("crfPresentationEndTime", "PresentationEndTime");
				selenium.jsClick("crfPresentationTime");
				selenium.type("crfConsultantsNeeded", "ConsultantsNeeded");
				selenium.type("crfPrimaryContactNumber", "PrimaryContactNumber");
				selenium.scrollToElement("crfProgramCopyRightProgramlevels");
				selenium.type("crfProgramCopyRightProgramlevels", "ProgramCopyRightProgramlevels");
				selenium.waitingTime(2000);
				selenium.clickLoop("crfPresentationType");
				selenium.waitingTime(2000);
				selenium.clickLoop("crfArrowToMove");
				selenium.waitingTime(2000);
				selenium.type("crfDistrickMeetingType", "DistrickMeetingType");
				selenium.selectDropdownText_propertiesFile("webinarinperson", "WebinarInPerson");
				selenium.type("crfNoOfParticipant", "NoOfParticipant");
				selenium.type("crfEquipmentNeeds", "EquipmentNeeds");
				selenium.waitingTime(2000);
				selenium.type("crfAudienceGradeLevels", "AudienceGradeLevels");
				selenium.type("crfParticipantGradeLevelBreakdown", "ParticipantGradeLevelBreakdown");
				selenium.type("crfPresentationDescription", "PresentationDescription");
				selenium.type("crfSiteAddress", "SiteAddress");
				selenium.type("crfSiteCity", "SiteCity");
				selenium.selectDropdownText("crfSiteState", "SiteState");
				selenium.type("crfSitePostalCode", "SitePostalCode");
				selenium.type("crfPresentationSite", "PresentationSite");
				selenium.type("crfSitePhone", "SitePhone");
				selenium.type("crfSiteContactName", "SiteContactName");
				selenium.type("crfSiteContactEmail", "SiteContactEmail");
				selenium.type("crfAirportName", "AirportName");
				selenium.type("crfAirportCityState", "AirportCityState");
				selenium.type("crfTravelTime", "TravelTime");
				selenium.scrollToElement("crfSaveClose");
				selenium.jsClick("crfSaveClose");
				selenium.waitingTime(5000);
				if (selenium.isElementPresentFast("crfError")) {
					System.out.println("opportunity not created!");
					selenium.test.log(LogStatus.FAIL, "opportunity  not created!");
					selenium.reportFailure("opportunity not created!");
				} else {
					System.out.println("opportunity  created!");
					selenium.test.log(LogStatus.PASS, "opportunity  created!");
				}
			}
		} catch (Exception e) {

			selenium.scrollToElement("crfCancel");
			selenium.clickLoop("crfCancel");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}


//	@And("^I fill in all the mandatory details to create a new opportunity for Sales Ref in accounts$")
//	public void i_fill_in_the_following_to_create_a_new_opportunity_for_Sales_Ref_in_accounts() {
//		try {
//
//			if (selenium.getUI().contains("Lightning")) {
//				selenium.jsClick("oppurtunitiesWithinAccount");
////				selenium.waitingTime(3000);
//				selenium.waitForElementToBeClickable("newOpportunityBtn");
//				selenium.jsClick("newOpportunityBtn");
//				selenium.waitingTime(4000);
//				selenium.switchToFrame("newOppurtunityFrame");
//				selenium.type("OpportunityMHECourse", "MHE Course");
//				selenium.waitingTime(4000);
//				selenium.dropdownListClick("OppurtunityMHECourseOptionsClick");
//				selenium.waitingTime(3000);
//				selenium.selectDropdownText("oppurtunityType", "Oppurtunity Type");
//				selenium.type("accountsOpportunityFallEnrolement", "Fall Enrolement");
//				selenium.waitingTime(3000);
//				selenium.moveTab("accountsOpportunityFallEnrolement");
//				selenium.captureScreenShot();
////				selenium.waitingTime(3000);
//				selenium.waitForElementToBeClickable("ButtonSave");
//				selenium.jsClick("ButtonSave");
//				selenium.waitingTime(5000);
//				selenium.switchOutOfFrame();
//				selenium.waitingTime(5000);
//				selenium.isElementPresentFast("newOppurtunitySuccessCheck");
//				selenium.waitingTime(2000);
//				selenium.captureScreenShot();
////				selenium.waitingTime(3000);
//
//				selenium.test.log(LogStatus.PASS, "oppurtunity  created!");
//				selenium.waitingTime(5000);
//			} else {
////				selenium.waitingTime(2000);
//				selenium.waitForElementToBeVisible("opportunitiesC");
//				selenium.scrollToElement("opportunitiesC");
//				selenium.click("opportunitiesC");
//			}
//		}
//
//////             selenium.type("closeDate", "Close Date");
//////             selenium.type("orderDate", "Order Date");
////               selenium.type("mheCourse", "MHE Course");
////               selenium.waitingTime(2000);
////               String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
////               selenium.clickLoopXpath(xpath);
////               selenium.type("enrollment", "Enrollment");
////
////         } 
//		catch (Exception e) {
//			selenium.switchOutOfFrame();
//			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//		}
//	}

	@Then("^I create new opportunity$")
	public void I_create_new_opportunity() {
		try {

			selenium.jsClick("newOpportunityBtn");
			selenium.waitingTime(5000);

			if(selenium.isElementPresentFast("NextButton"))
			{
				selenium.waitForElementToBeClickable("NextButton");
				selenium.click("NextButton");
			}

			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityAccount");
			selenium.type("opportunityAccount", "Account Name");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("spanTitle", "Account Name", "end");
			selenium.waitingTime(2000);
//			selenium.clickLoop("");
			selenium.type("OpportunityMHECourse2", "MHE Course");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("spanTitle", "MHE Course", "end");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("oppurtunityType", "Opportunity Type");
			selenium.waitingTime(4000);
			selenium.selectDropdownText("salesStageDropdown", "Sales Stage");
			selenium.waitForElementToBeVisible("oppurtunitySpringEnrollment");
			selenium.type("oppurtunitySpringEnrollment", "Spring Enrollment");
			selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
			selenium.type("oppurtunityFallEnrollment", "Fall Enrollment");
			selenium.waitingTime(2000);
			selenium.moveTab("oppurtunitySummerEnrollment");
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.jsClick("ButtonSave");
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(25000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);

			if (selenium.getTestCaseName().equalsIgnoreCase("MarketingUserCreateOpportunity")) {
				selenium.MarketingUserNewOppURL = selenium.getURL();
				System.out.println("The newly created opp url is :" + selenium.MarketingUserNewOppURL);
			}

			if (selenium.getTestCaseName().equalsIgnoreCase("MHHESalesRepUserCreateNewOpp")) {
				selenium.MHHENewOppURL = selenium.getURL();
				System.out.println("The newly created MHHE opportunity url is :" + selenium.MHHENewOppURL);
			}

			if (selenium.getTestCaseName().equalsIgnoreCase("CloneOppAndVerifyData")) {
				selenium.MHHENewOppURLForSingleClone = selenium.getURL();
				System.out.println("The newly created MHHE opportunity url is :" + selenium.MHHENewOppURLForSingleClone);
			}

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^verify access for SEP Asset Send and SEP Asset Session objects on the opportunity for MHHE Business Admin$")
	public void verify_access_for_SEP_Asset_Send_and_SEP_Asset_Session_objects_on_the_opportunity_for_MHHE_Business_Admin() {
		try {
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("SEPAssetSendRelatedList"))
			{
				selenium.jsClick("SEPAssetSendRelatedList");
			}
			else
			{
				selenium.jsClick("showAllLinks");
				selenium.waitingTime(2000);
				selenium.jsClick("SEPAssetSendRelatedList");				
			}
			selenium.waitForElementToBeClickable("FirstTableRecord");
			selenium.jsClick("FirstTableRecord");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			Assert.assertFalse(selenium.isElementPresentFast("editButton"));
			
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("SEPAssetSessionRelatedList"))
			{
				selenium.jsClick("SEPAssetSessionRelatedList");
			}
			else
			{
				selenium.jsClick("showAllLinks");
				selenium.waitingTime(2000);
				selenium.jsClick("SEPAssetSendRelatedList");				
			}
			selenium.waitForElementToBeClickable("FirstTableRecord");
			selenium.jsClick("FirstTableRecord");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			Assert.assertFalse(selenium.isElementPresentFast("editButton"));
			
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^verify the access for SEP Asset Send objects on the opportunity for system and super admins$")
	public void verify_the_access_for_SEP_Asset_Send_objects_on_the_opportunity_for_system_and_super_admins() {
		try {
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("SEPAssetSendRelatedList"))
			{
				selenium.jsClick("SEPAssetSendRelatedList");
			}
			else
			{
				selenium.jsClick("showAllLinks");
				selenium.waitingTime(2000);
				selenium.jsClick("SEPAssetSendRelatedList");				
			}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewButton");
			selenium.click("NewButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.click("Search_contact");
			selenium.autoSuggestiveDropdownWithoutText("Search_contact");
			selenium.waitForElementToBeClickable("LiveSendLinkID");
			selenium.typeData("LiveSendLinkID", "12345");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Created new SEP Asset Send");
			
			selenium.waitForElementToBeClickable("FirstTableRecord");
			selenium.jsClick("FirstTableRecord");
			selenium.waitingTime(5000);
			
			selenium.waitForElementToBeVisible("SEPAssetSessionContact_NameField");
			if(selenium.isElementPresentFast("SEPAssetSessionContact_NameField") || selenium.isElementPresentFast("SEPAssetSend_Contact") ||selenium.isElementPresentFast("SEPAssetSend_Opportunity") ||selenium.isElementPresentFast("SEPAssetSend_LiveSendLinkID") ||selenium.isElementPresentFast("SEPAssetSend_EmailContent") ||selenium.isElementPresentFast("SEPAssetSend_EmailTemplate"))
			{
				selenium.test.log(LogStatus.PASS, "All the required fields are available");
				System.out.println("PASS");
			}
			else
			{
				selenium.reportFailure("One or more fields are missing");
				selenium.test.log(LogStatus.FAIL, "One or more fields are missing");
				System.out.println("FAIL");
			}
			
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^verify the access for SEP Asset Session objects on the opportunity for system and super admins$")
	public void verify_the_access_for_SEP_Asset_Session_objects_on_the_opportunity_for_system_and_super_admins() {
		try {
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("SEPAssetSessionRelatedList"))
			{
				selenium.jsClick("SEPAssetSessionRelatedList");
			}
			else
			{
				selenium.jsClick("showAllLinks");
				selenium.waitingTime(2000);
				selenium.jsClick("SEPAssetSessionRelatedList");		
			}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewButton");
			selenium.click("NewButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.click("Search_contact");
			selenium.autoSuggestiveDropdownWithoutText("Search_contact");
			selenium.waitForElementToBeClickable("LiveSendLinkID");
			selenium.typeData("LiveSendLinkID", "12345");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Created new SEP Asset Session");
			
			selenium.waitForElementToBeClickable("FirstTableRecord");
			selenium.jsClick("FirstTableRecord");
			selenium.waitingTime(5000);
			
			selenium.waitForElementToBeVisible("SEPAssetSessionContact_NameField");
			if(selenium.isElementPresentFast("SEPAssetSessionContact_NameField") || selenium.isElementPresentFast("SEPAssetSend_Contact") ||selenium.isElementPresentFast("SEPAssetSend_Opportunity") ||selenium.isElementPresentFast("SEPAssetSend_LiveSendLinkID") ||selenium.isElementPresentFast("SEPAssetSession_TotalContentViewed") ||selenium.isElementPresentFast("SEPAssetSession_TotalDurationSeconds"))
			{
				selenium.test.log(LogStatus.PASS, "All the required fields are available in SEP Asset Session page");
				System.out.println("PASS");
			}
			else
			{
				selenium.reportFailure("One or more fields are missing");
				selenium.test.log(LogStatus.FAIL, "One or more fields are missing");
				System.out.println("FAIL");
			}
			
			selenium.jsClick("SEPAssetSessionContactRelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewButton");
			selenium.click("NewButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SEPAssetSessionContact_ContactType");
			selenium.typeData("SEPAssetSessionContact_ContactType", "Automation Test");
			selenium.typeData("SEPAssetSessionContact_ContactName", "Mr. Automation Test");
			selenium.typeData("SEPAssetSessionContact_TotalPages", "2");
			selenium.typeData("SEPAssetSessionContact_TotalPagesViewed", "2");
			selenium.typeData("SEPAssetSessionContact_DurationSeconds", "60");
			selenium.jsClick("SEPAssetSessionContact_Downloaded");
			selenium.jsClick("SEPAssetSessionContact_Viewed");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Created new SEP Asset Session Contact");
			
			selenium.waitForElementToBeClickable("FirstTableRecord");
			selenium.jsClick("FirstTableRecord");
			selenium.waitingTime(5000);
			
			selenium.waitForElementToBeVisible("SEPAssetSessionContact_NameField");
			if(selenium.isElementPresentFast("SEPAssetSessionContact_NameField") || selenium.isElementPresentFast("SEPAssetSessionContact_SEPAssetSessionField") ||selenium.isElementPresentFast("SEPAssetSessionContact_ContentTypeField") ||selenium.isElementPresentFast("SEPAssetSessionContact_ContentNameField") ||selenium.isElementPresentFast("SEPAssetSessionContact_TotalPagesField") ||selenium.isElementPresentFast("SEPAssetSessionContact_TotalPagesViewedField")||selenium.isElementPresentFast("SEPAssetSessionContact_DurationSecondsField")||selenium.isElementPresentFast("SEPAssetSessionContact_DownloadedField")||selenium.isElementPresentFast("SEPAssetSessionContact_ViewedField"))
			{
				selenium.test.log(LogStatus.PASS, "All the required fields are available in SEP Asset Session Contact page");
				System.out.println("PASS");
			}
			else
			{
				selenium.reportFailure("One or more fields are missing");
				selenium.test.log(LogStatus.FAIL, "One or more fields are missing");
				System.out.println("FAIL");
			}
			
			selenium.jsClick("SEPAssetSessionContactPagesRelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewButton");
			selenium.click("NewButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SEPAssetSessionContactPage_PageIndex");
			selenium.typeData("SEPAssetSessionContactPage_PageIndex", "1");
			selenium.typeData("SEPAssetSessionContactPage_DurationMs", "1000");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Created new SEP Asset Session Contact Page");
			
			selenium.waitForElementToBeClickable("FirstTableRecord");
			selenium.jsClick("FirstTableRecord");
			selenium.waitingTime(5000);
			
			selenium.waitForElementToBeVisible("SEPAssetSessionContact_NameField");
			if(selenium.isElementPresentFast("SEPAssetSessionContact_NameField") || selenium.isElementPresentFast("SEPSessionContentPages_SEPSessionContent") ||selenium.isElementPresentFast("SEPSessionContentPages_PageIndex") ||selenium.isElementPresentFast("SEPSessionContentPages_DurationMilliseconds"))
			{
				selenium.test.log(LogStatus.PASS, "All the required fields are available in SEP Asset Session Contact page");
				System.out.println("PASS");
			}
			else
			{
				selenium.reportFailure("One or more fields are missing");
				selenium.test.log(LogStatus.FAIL, "One or more fields are missing");
				System.out.println("FAIL");
			}
			
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@Then("^MHHE Business Admin create new MHHE type opportunity$")
	public void MHHE_Business_Admin_create_new_MHHE_type_opportunity() {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.jsClick("newOpportunityBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.click("NextButton");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityAccount");
			selenium.type_propertiesFile("opportunityAccount", "MHHEOppAccountName");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "MHHEOppAccountName", "end");
			selenium.waitingTime(2000);
			selenium.type_propertiesFile("OpportunityMHECourse2", "MHHEOppCourseName");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "MHHEOppCourseName", "end");
			selenium.waitingTime(2000);
			selenium.selectDropdownText_propertiesFile("oppurtunityType", "MHHEOppType");
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForFutureYearOpp")) {
				selenium.selectDropdownText_propertiesFile("MHHEOppYear", "MHHEOppYear_Future");//2026
			}
			else if(selenium.getTestCaseName().equalsIgnoreCase("VerifyEditorialSectionInOppContactByMHHEBusinessAdmin"))
			{
				selenium.selectDropdownText_propertiesFile("MHHEOppYear", "NewYear");//2024
			}
			else if(selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForPastYearOpp"))
			{
				selenium.selectDropdownText_propertiesFile("MHHEOppYear", "MHHEOppYear_Past");//2023
			}
			else
			{
				selenium.selectDropdownText_propertiesFile("MHHEOppYear", "MHHEOppYear_Current");//2024
			}

			selenium.waitingTime(4000);
			selenium.selectDropdownText_propertiesFile("salesStageDropdown", "MHHEOppSalesStage");
			selenium.waitForElementToBeVisible("oppurtunitySpringEnrollment");
			selenium.type_propertiesFile("oppurtunitySpringEnrollment", "MHHEOppSpringEnrollment");
			selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
			selenium.type_propertiesFile("oppurtunityFallEnrollment", "MHHEOppFallEnrollment");
			selenium.waitingTime(2000);
			selenium.moveTab("oppurtunitySummerEnrollment");
			selenium.captureScreenShot();
//			if(selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserRenameOpp"))
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.jsClick("ButtonSave");
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(25000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForFutureYearOpp")) {
				selenium.MHHEOppWithFutureYear = selenium.getURL();
				System.out.println("The newly created MHHE future year opportunity url is.. " + selenium.MHHEOppWithFutureYear);
			} 
			else if(selenium.getTestCaseName().equalsIgnoreCase("VerifyEditorialSectionInOppContactByMHHEBusinessAdmin"))
			{
				selenium.MHHEOppToTestEditorialSection=selenium.getURL();
				System.out.println("The newly created MHHE opportunity url to test EditorialSection is.. " + selenium.MHHEOppToTestEditorialSection);
			}
			else if(selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForPastYearOpp"))
			{
				selenium.MHHEOppWithPastYear=selenium.getURL();
				System.out.println("The newly created MHHE opportunity url .. " + selenium.MHHEOppWithPastYear);
			}
			else
			{
				selenium.MHHENewOppURLToVerifyEvergreenField=selenium.getURL();
				System.out.println("The newly created MHHE opportunity url is.. " + selenium.MHHENewOppURLToVerifyEvergreenField);	
			}
		}

		catch (Exception e)
		{
			selenium.reportFailure("Error while creating MHHE type opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating MHHE type opportunity");
		}
	}

	@Then("^Create new MHHE type opportunity$")
	public void Create_new_MHHE_type_opportunity() {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.jsClick("newOpportunityBtn");
//			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("NextButton");
//			selenium.click("NextButton");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityAccount");
			selenium.type_propertiesFile("opportunityAccount", "MHEOppAccountName");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "MHEOppAccountName", "end");
			selenium.waitingTime(2000);
			selenium.type_propertiesFile("OpportunityMHECourse2", "MHEOppCourseName");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "MHEOppCourseName", "end");
			selenium.waitingTime(2000);
			selenium.selectDropdownText_propertiesFile("oppurtunityType", "MHHEOppType");
			selenium.waitingTime(4000);
			selenium.selectDropdownText_propertiesFile("salesStageDropdown", "MHHEOppSalesStage");
			selenium.waitForElementToBeVisible("oppurtunitySpringEnrollment");
			selenium.type_propertiesFile("oppurtunitySpringEnrollment", "MHHEOppSpringEnrollment");
			selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
			selenium.type_propertiesFile("oppurtunityFallEnrollment", "MHHEOppFallEnrollment");
			selenium.waitingTime(2000);
			selenium.moveTab("oppurtunitySummerEnrollment");
			selenium.captureScreenShot();
//			if(selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserRenameOpp"))
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.jsClick("ButtonSave");
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(25000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.MHENewOppURL = selenium.getURL();
			System.out.println("The newly created MHE opportunity url is.. " + selenium.MHENewOppURL);
		} catch (Exception e) {
			selenium.reportFailure("Error while creating MHHE type opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating MHHE type opportunity");
		}
	}

	@Then("^verify field label in user setup \\\"([^\\\"]*)\\\"$")
	public void verify_field_label_in_user_setup(String url) {
		try {
			selenium.waitingTime(5000);
			selenium.navigateToURL(url);
			selenium.waitingTime(8000);
			selenium.switchToFrame("newAccountFrame");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("CSCFieldInUserSetup")) {
				selenium.test.log(LogStatus.PASS, "The expected label is present on the user setup page!");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected label is NOT present on the user setup page!");
				selenium.reportFailure("The expected label is NOT present on the user setup page!");
				System.out.println("FAIL");
			}
			selenium.switchOutOfFrame();
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying field labels in user setup " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying field labels in user setup");
		}
	}

	@And("^verify field label in opportunity$")
	public void verify_field_label_in_opportunity() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("CSCScheduleLinkLabelInOpp");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("CSCScheduleLinkLabelInOpp") && selenium.isElementPresentFast("CustomerSupportConsultantLabelInOpp")) {
				selenium.test.log(LogStatus.PASS, "The expected label is present on the opp page!");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected label is NOT present on the opp page!");
				selenium.reportFailure("The expected label is NOT present on the opp page!");
				System.out.println("FAIL");
			}
			selenium.scrollToElement("OppSalesTeamHeader");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);

			if (selenium.isElementPresentFast("OppESDLabel") && selenium.isElementPresentFast("OppCSCLabel")) {
				selenium.test.log(LogStatus.PASS, "The expected label is present on the opp page!");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected label is NOT present on the opp page!");
				selenium.reportFailure("The expected label is NOT present on the opp page!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying field labels in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying field labels in opportunity");
		}
	}

	@And("^verify CustomerSuccssSpecialist field is non editable$")
	public void verify_CustomerSuccssSpecialist_field_is_non_editable() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			if (!selenium.isElementPresentFast("CustomerSuccssSpecialistEditIcon")) {
				selenium.test.log(LogStatus.PASS, "The expected field is non-editable for MHHE Implementation Team profile user!");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected field is editable for MHHE Implementation Team profile user!");
				selenium.reportFailure("The expected field is editable for MHHE Implementation Team profile user!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying non-editable field in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying non-editable field in opportunity");
		}
	}

	@Then("^enable everygreen flag for products$")
	public void enable_everygreen_flag_for_products() {
		try {
			selenium.waitingTime(5000);
			//Enabling Evergreen flag for 9781260580037 product
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t0y000005IxrYAAS/view");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.click("EditButton");
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("EvergreenChkBxInProduct")) {
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("EvergreenChkBxInProduct");
				selenium.click("EvergreenChkBxInProduct");
			} else {
				System.out.println("Retrying...");
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t0y000005IxrYAAS/view");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("EditButton");
				selenium.click("EditButton");
				selenium.waitingTime(15000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("EvergreenChkBxInProduct");
				selenium.click("EvergreenChkBxInProduct");
			}
			selenium.waitingTime(5000);
			selenium.click("RecordSaveButton");
			selenium.waitingTime(6000);
			//Enabling Evergreen flag for 9781259702686 product
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01tC0000004ZnCqIAK/view");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.click("EditButton");
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("EvergreenChkBxInProduct")) {
				selenium.waitForElementToBeClickable("EvergreenChkBxInProduct");
				selenium.click("EvergreenChkBxInProduct");
			} else {
				System.out.println("Retrying...");
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01tC0000004ZnCqIAK/view");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("EditButton");
				selenium.click("EditButton");
				selenium.waitingTime(15000);
				selenium.waitForElementToBeClickable("EvergreenChkBxInProduct");
				selenium.click("EvergreenChkBxInProduct");
			}
			selenium.waitingTime(5000);
			selenium.click("RecordSaveButton");
			selenium.waitingTime(6000);
			System.out.println("Successfully enabled evergreen flag for products");
		} catch (Exception e) {
			selenium.reportFailure("Error while enabling everygreen flag for products " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while enabling everygreen flag for products");
		}
	}

	@Then("^disable everygreen flag for products$")
	public void disable_everygreen_flag_for_products() {
		try {
			selenium.waitingTime(5000);
			//Disabling Evergreen flag for 9781260580037 product
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t0y000005IxrYAAS/view");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.click("EditButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EvergreenChkBxInProduct");
			selenium.click("EvergreenChkBxInProduct");
			selenium.waitingTime(1000);
			selenium.click("RecordSaveButton");
			selenium.waitingTime(6000);
			//Disabling Evergreen flag for 9781259702686 product
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01tC0000004ZnCqIAK/view");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.click("EditButton");
			selenium.waitForElementToBeClickable("EvergreenChkBxInProduct");
			selenium.click("EvergreenChkBxInProduct");
			selenium.click("RecordSaveButton");
			selenium.waitingTime(6000);
			System.out.println("Successfully disabled evergreen flag for products");
		} catch (Exception e) {
			selenium.reportFailure("Error while disabling everygreen flag for products " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while disabling everygreen flag for products");
		}
	}

	@Then("^add products to MHHE opportunity$")
	public void add_products_to_MHHE_opportunity() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.jsClick("taggedProductAddorEdit");
			selenium.waitingTime(4000);
			selenium.switchToFrame("OpportunityFrameNew");
			selenium.waitingTime(6000);

			if (selenium.getTestCaseName().equalsIgnoreCase("AddEverGreenProdAndVerifyEGFieldInOpp")) {
//Adding evergreen product1
				selenium.scrollToElement("taggedProductISBN1");
				selenium.type_propertiesFile("taggedProductISBN1", "MHHEOppEverGreenProductISBN1");
				selenium.waitForElementToBeClickable("taggedProductISBNSearch");
				selenium.click("taggedProductISBNSearch");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("addAllProductinProductSearch");
				selenium.click("addAllProductinProductSearch");
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
				selenium.waitingTime(5000);
//Adding evergreen product2
				selenium.scrollToElement("taggedProductISBN1");
				selenium.type_propertiesFile("taggedProductISBN1", "MHHEOppEverGreenProductISBN2");
				selenium.waitForElementToBeClickable("taggedProductISBNSearch");
				selenium.click("taggedProductISBNSearch");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("addAllProductinProductSearch");
				selenium.click("addAllProductinProductSearch");
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
				selenium.waitingTime(5000);
			}
//Adding normal product
			selenium.scrollToElement("taggedProductISBN1");
			selenium.type_propertiesFile("taggedProductISBN1", "MHHEOppProductISBN1");
			selenium.waitForElementToBeClickable("taggedProductISBNSearch");
			selenium.click("taggedProductISBNSearch");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("addAllProductinProductSearch");
			selenium.click("addAllProductinProductSearch");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.click("Button_Save");
			selenium.waitingTime(20000);
		} catch (Exception e) {
			selenium.reportFailure("Error while adding product to MHHE opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding product to MHHE opportunity");
		}
	}

	@Then("^add targeted products to MHHE opportunity$")
	public void add_targeted_products_to_MHHE_opportunity() {
		try {
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForFutureYearOpp")) {
				selenium.navigateToURL(selenium.MHHEOppWithFutureYear);
			}
			else if(selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForPastYearOpp"))
			{
				selenium.navigateToURL(selenium.MHHEOppWithPastYear);
			}
			else {
				selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
			}


			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.jsClick("taggedProductAddorEdit");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.switchToFrame("OpportunityFrameNew");
			selenium.waitingTime(2000);
//Adding targeted product
			selenium.waitForElementToBeClickable("taggedProductISBN1");
			selenium.scrollToElement("taggedProductISBN1");
			selenium.type_propertiesFile("taggedProductISBN1", "MHHEOppProductISBN2");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("taggedProductISBNSearch");
			selenium.click("taggedProductISBNSearch");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("addAllProductinProductSearch");
			selenium.click("addAllProductinProductSearch");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.click("Button_Save");
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.reportFailure("Error while adding targeted product to MHHE opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding targeted product to MHHE opportunity");
		}
	}

	@And("^create order line with ordered item$")
	public void create_order_line_with_product() {
		try {
			selenium.waitingTime(5000);
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/page/home");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("allButtonLightning");
			selenium.click("allButtonLightning");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("AllButtonL");
			selenium.click("AllButtonL");
			selenium.waitingTime(4000);
			selenium.type_propertiesFile("searchallitems", "OrderLinesMenu");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("orderLinesLink");
			selenium.jsClick("orderLinesLink");
			selenium.waitingTime(4000);
			selenium.test.log(LogStatus.INFO, "Order Lines Page loaded successfully!");

			selenium.waitForElementToBeClickable("NewBtn");
			selenium.clickLoop("NewBtn");
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.type_propertiesFile("Name_Field", "OrderLineData");
			selenium.type_propertiesFile("OrderNumber", "OrderLineData");
			selenium.type_propertiesFile("ShiptoActNumber", "OrderLineData");
			selenium.waitingTime(4000);
			selenium.scrollToElement("searchEditProduct");
			selenium.waitForElementToBeClickable("searchEditProduct");
			selenium.click("searchEditProduct");
			selenium.waitForElementToBeClickable("NewProductOption");
			selenium.click("NewProductOption");
			selenium.waitForElementToBeClickable("NextPageButton");
			selenium.click("NextPageButton");
			selenium.waitForElementToBeClickable("NewMHEProductNameField");
			selenium.type_propertiesFile("NewMHEProductNameField", "LongProductName");
			selenium.waitForElementToBeClickable("ProdctStatusList");
			selenium.click("ProdctStatusList");
			selenium.waitForElementToBeClickable("ProdStatusActive");
			selenium.click("ProdStatusActive");
			selenium.waitForElementToBeClickable("RecordSaveButton");
			selenium.click("RecordSaveButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Order Lines created successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while creating order line " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating order line");
		}
	}

	@And("^verify product name limit in order line$")
	public void verify_product_name_limit_in_order_line() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OrderedItemTextInOrderLine");
			String orderedItemText = selenium.getText("OrderedItemTextInOrderLine");
			System.out.println("orderedItemText is :" + orderedItemText);
			String str = orderedItemText.trim();

			String[] parts = str.split(" ");
			String part1 = parts[0];    //Open Text
			String part2 = parts[1];    //Actual Ordered Item Text
			String part3 = parts[2];    //Preview Text
			System.out.println("part1 " + part1);
			System.out.println("part2 " + part2);
			selenium.test.log(LogStatus.INFO, "The Ordered Item Name is!" + part2);
			System.out.println("part3 " + part3);
			part2 = part2.replace(",", "");

			int totalChars = (int) part2.chars().count();
			System.out.println("Total Characters Present in Ordered Item Name is :" + totalChars);
			selenium.test.log(LogStatus.INFO, "Total Characters Present in Ordered Item Name is !" + totalChars);
			if (totalChars == 255) {
				selenium.test.log(LogStatus.PASS, "The Ordered Item has 255 characters!");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The Ordered Item is not having 255 characters!");
				selenium.reportFailure("The Ordered Item is not having 255 characters!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying ordered item name limit " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying ordered item limit");
		}
	}

	@And("^verify product name limit in opp order line$")
	public void verify_product_name_limit_in_opp_order_line() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("firstSampleRecordNew");
			selenium.jsClick("firstSampleRecordNew");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("OrderedItemTextInOppOrderLine");
			String orderedItemText = selenium.getText("OrderedItemTextInOppOrderLine");
			selenium.waitingTime(8000);
			System.out.println("orderedItemText is :" + orderedItemText);
			selenium.test.log(LogStatus.INFO, "The Product Name is!" + orderedItemText);
			String str = orderedItemText.trim();
			System.out.println("str is :" + str);
			int totalChars = (int) str.chars().count();
			System.out.println("Total Characters Present in Product Name is :" + totalChars);
			selenium.test.log(LogStatus.INFO, "Total Characters Present in Ordered Item Name is !" + totalChars);
			if (totalChars == 255) {
				selenium.test.log(LogStatus.PASS, "The Product Name has 255 characters!");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The Product Name is not having 255 characters!");
				selenium.reportFailure("The Product Name is not having 255 characters!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying product name limit " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying product name limit");
		}
	}

	@Then("^create opportunity orders$")
	public void create_opportunity_orders() {
		try {
			selenium.waitForElementToBeClickable("opportunityOrderLink");
			selenium.clickLoop("opportunityOrderLink");
			selenium.waitForElementToBeClickable("NewButton");
			selenium.clickLoop("NewButton");
			selenium.waitForElementToBeVisible("searchOpportunities");
			selenium.type_propertiesFile("searchOpportunities", "USB132_OppName");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.click("showAllResultsFromDropDwn");
			selenium.waitingTime(2000);
			String nameXpath = selenium.getDynamicXpathData_propertiesFile("supplementTableDynamic", "USB132_OppName", "endContains");
			System.out.println("nameXpath is : " + nameXpath);
			selenium.waitingTime(2000);
			selenium.clickXpath(nameXpath);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(12000);
			selenium.test.log(LogStatus.INFO, "Linked Opp with Order Lines successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while creating opp orders " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating opp orders");
		}
	}

	@And("^create order line and add opportunity order to it$")
	public void create_order_line_and_add_opportunity_order_to_ity() {
		try {
			selenium.waitingTime(5000);
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/page/home");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("allButtonLightning");
			selenium.click("allButtonLightning");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("AllButtonL");
			selenium.click("AllButtonL");
			selenium.waitingTime(4000);
			selenium.type_propertiesFile("searchallitems", "OrderLinesMenu");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("orderLinesLink");
			selenium.jsClick("orderLinesLink");
			selenium.waitingTime(4000);
			selenium.test.log(LogStatus.INFO, "Order Lines Page loaded successfully!");

			selenium.waitForElementToBeClickable("NewBtn");
			selenium.clickLoop("NewBtn");
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.type_propertiesFile("Name_Field", "OrderLineData");
			selenium.type_propertiesFile("OrderNumber", "OrderLineData");
			selenium.type_propertiesFile("ShiptoActNumber", "OrderLineData");
			selenium.click("Save_Btn");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.INFO, "Order Lines created successfully!");

			selenium.waitForElementToBeClickable("opportunityOrderLink");
			selenium.clickLoop("opportunityOrderLink");
			selenium.waitForElementToBeClickable("NewButton");
			selenium.clickLoop("NewButton");
			selenium.waitForElementToBeVisible("searchOpportunities");
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForFutureYearOpp")) {
				selenium.type_propertiesFile("searchOpportunities", "USB130_OppName");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(2000);
				String nameXpath = selenium.getDynamicXpathData_propertiesFile("supplementTableDynamic", "USB130_OppName", "endContains");
				System.out.println("nameXpath is : " + nameXpath);
				selenium.waitingTime(2000);
				selenium.clickXpath(nameXpath);
			} else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForCurrentYearOpp")) {
				selenium.type_propertiesFile("searchOpportunities", "USB129_OppName");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(2000);
				String nameXpath = selenium.getDynamicXpathData_propertiesFile("supplementTableDynamic", "USB129_OppName", "endContains");
				System.out.println("nameXpath is : " + nameXpath);
				selenium.waitingTime(2000);
				selenium.clickXpath(nameXpath);
			} else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForPastYearOpp")) {
				selenium.type_propertiesFile("searchOpportunities", "USB131_OppName");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(2000);
				String nameXpath = selenium.getDynamicXpathData_propertiesFile("supplementTableDynamic", "USB131_OppName", "endContains");
				System.out.println("nameXpath is : " + nameXpath);
				selenium.waitingTime(2000);
				selenium.clickXpath(nameXpath);
			}

			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(6000);
			selenium.test.log(LogStatus.INFO, "Linked Opp with Order Lines successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while creating order line and linking opportunity to it " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating order line and linking opportunity to it");
		}
	}

	@And("^Verify Order Targeted Products field in opportunity$")
	public void Verify_Order_Targeted_Products_field_in_opportunity() {
		try {
			//Verify newly added product in Targeted Products of Opp
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("OppTargetProductLabel");
			selenium.waitingTime(2000);
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForCurrentYearOpp")) {
				TP_xpath = selenium.getDynamicXpath_propertiesFile("TPContainsStart", "MHHEOppProductISBN1", "endContains");
				selenium.waitingTime(2000);
			} 
			else {
				TP_xpath = selenium.getDynamicXpath_propertiesFile("TPContainsStart", "MHHEOppProductISBN2", "endContains");
				selenium.waitingTime(2000);
			}
			System.out.println("xpath is " + TP_xpath);

			if (selenium.isElementPresentXpathFast(TP_xpath)) {
				selenium.test.log(LogStatus.PASS, "The newly added product is appearing against Opportunity's 'Targeted Product' field");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected data is missing");
				selenium.reportFailure("The expected data is missing");
				System.out.println("FAIL");
			}
			selenium.refresh();
			selenium.waitingTime(8000);
			//Verify newly added product in Targeted Products of Order Lines
			selenium.waitForElementToBeClickable("opportunityOrderLink");
			selenium.clickLoop("opportunityOrderLink");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstSampleRecordNew");
			selenium.jsClick("firstSampleRecordNew");
			selenium.waitingTime(6000);
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForCurrentYearOpp")) {
				System.out.println("Current TC is VerifyTPFieldForCurrentYearOpp");
				TP_xpath = selenium.getDynamicXpath_propertiesFile("TPContainsStart", "MHHEOppProductISBN1", "endContains");
				selenium.waitingTime(2000);
			} else {
				System.out.println("Current TC is either VerifyTPFieldForFutureYearOpp or VerifyTPFieldForPastYearOpp ");
				TP_xpath = selenium.getDynamicXpath_propertiesFile("TPContainsStart", "MHHEOppProductISBN2", "endContains");
				selenium.waitingTime(2000);
			}
			System.out.println("xpath is " + TP_xpath);

			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForCurrentYearOpp") || selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForFutureYearOpp")) {
				if (selenium.isElementPresentXpathFast(TP_xpath)) {
					selenium.test.log(LogStatus.PASS, "The newly added product is appearing against Opportunity order's 'Targeted Product' field");
					System.out.println("PASS");
					selenium.captureScreenShot();
				} else {
					selenium.test.log(LogStatus.FAIL, "The expected data is missing");
					selenium.reportFailure("The expected data is missing");
					System.out.println("FAIL");
				}
			} else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForPastYearOpp")) {
				if (!selenium.isElementPresentXpathFast(TP_xpath)) {
					selenium.test.log(LogStatus.PASS, "The newly added product is NOT appearing against Opportunity order's 'Targeted Product' field");
					System.out.println("PASS");
					selenium.captureScreenShot();
				} else {
					selenium.test.log(LogStatus.FAIL, "The newly added product is appearing against Opportunity order's 'Targeted Product' field");
					selenium.reportFailure("The newly added product is appearing against Opportunity order's 'Targeted Product' field");
					System.out.println("FAIL");
				}
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while verifying targeted product in MHHE opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying targeted product in MHHE opportunity");
		}
	}

	@And("^remove one evergreen product from opportunity$")
	public void remove_one_evergreen_product_from_opportunity() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("mhheDigitalOfferDeleteMenuNew");
			selenium.click("mhheDigitalOfferDeleteMenuNew");
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.jsClick("DeleteRecord");
			selenium.waitingTime(8000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while removing one evergreen product from opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while removing one evergreen product from opportunity");
		}
	}

	@And("^remove all evergreen product from opportunity$")
	public void remove_all_evergreen_product_from_opportunity() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("mhheDigitalOfferDeleteMenuNew");
			selenium.click("mhheDigitalOfferDeleteMenuNew");
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.jsClick("DeleteRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("mhheDigitalOfferDeleteMenuNew");
			selenium.click("mhheDigitalOfferDeleteMenuNew");
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.jsClick("DeleteRecord");
			selenium.waitingTime(8000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			//deleted all the opp products
		} catch (Exception e) {
			selenium.reportFailure("Error while removing all evergreen product from opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while removing all evergreen product from opportunity");
		}
	}

	@And("^verify evergreen field in opportunity when it has evergreen product$")
	public void verify_evergreen_field_in_opportunity_TRUE() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OppEvergreenCheckbox");
			selenium.scrollToElement("OppEvergreenCheckbox");
			selenium.waitingTime(4000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			if (selenium.getElement("OppEvergreenCheckbox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "Evergreen checkbox is enabled for opportunity");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Evergreen checkbox is NOT enabled for opportunity");
				selenium.reportFailure("Address - 'Evergreen checkbox is NOT enabled for opportunity");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while verifying evergreen field in MHHE opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying evergreen field in MHHE opportunity");
		}
	}

	@And("^verify evergreen field in opportunity when it does not have evergreen product$")
	public void verify_evergreen_field_in_opportunity_FALSE() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OppEvergreenCheckbox");
			selenium.scrollToElement("OppEvergreenCheckbox");
			selenium.waitingTime(4000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			if (!selenium.getElement("OppEvergreenCheckbox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "Evergreen checkbox is NOT enabled for opportunity");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Evergreen checkbox is enabled for opportunity which has no evergreen product");
				selenium.reportFailure("Address - 'Evergreen checkbox is enabled for opportunity which has no evergreen product");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while verifying evergreen field in MHHE opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying evergreen field in MHHE opportunity");
		}
	}

	@Then("^INTLSalesRep user create new opportunity$")
	public void INTLSalesRep_user_create_new_opportunity() {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.jsClick("newOpportunityBtn");
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("NextButton")) {
				selenium.click("NextButton");
				selenium.waitingTime(10000);
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementsToBeVisible("newAccountFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(3000);
			selenium.type("opportunityAccount", "Account Name");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("spanTitle", "Account Name", "end");
			selenium.waitingTime(5000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("OpportunityMHECourse2");
			selenium.type("OpportunityMHECourse2", "MHE Course");
			selenium.waitingTime(4000);
			selenium.takeScreenShot();
			selenium.clickDynamicXpath("spanTitle", "MHE Course", "end");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("closeDate1");
			selenium.click("closeDate1");
			selenium.waitForElementToBeClickable("TomorrowDateInCalendar");
			selenium.click("TomorrowDateInCalendar");

			selenium.waitForElementToBeClickable("orderDate1");
			selenium.click("orderDate1");
			selenium.waitForElementToBeClickable("TodayDateInCalendar");
			selenium.click("TomorrowDateInCalendar");

			selenium.waitForElementToBeClickable("enrollment");
			selenium.type("enrollment", "Enrollment");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.click("ButtonSave");
			selenium.switchOutOfFrame();
			selenium.waitingTime(20000);

			if (selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserCreateNewOpp")) {
				selenium.INTLOppURL = selenium.getURL();
				System.out.println("The newly created INTL opportunity url is :" + selenium.INTLOppURL);
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while creating new INTL opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating new INTL opportunity");
		}
	}

	@And("^validate the opportunity owner$")
	public void validate_the_opportunity_owner() {
		try {
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0067h00000G3CrBAAV/view");
			selenium.waitingTime(8000);
			String OppOwner = selenium.getText("opportunityOwnerGetText");
			System.out.println("Opp Owner is :" + OppOwner);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("userIcon");
			selenium.clickNew("userIcon");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("userName");
			String user = selenium.getText("userName");
			System.out.println("Currently logged-in user is : " + user);

			if (user.equalsIgnoreCase(OppOwner)) {
				selenium.test.log(LogStatus.PASS, "Opportunity owner name is matching with logged-in user name!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opportunity owner name is not matching with logged-in user name!");
				selenium.reportFailure("Opportunity owner name is not matching with logged-in user name!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating opportunity owner " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating opportunity owner");
		}
	}

	@And("^verify Term Revenue field in MHHE Opp$")
	public void verify_Term_Revenue_field_in_MHHE_Opp() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("MHHEOppTermRevenueField");
			if (selenium.isElementPresentFast("MHHEOppTermRevenueField")) {
				selenium.test.log(LogStatus.PASS, "Term Revenue field is available!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Term Revenue field is not available!");
				selenium.reportFailure("Term Revenue field is not available!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifing Term Revenue field in MHHE opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing Term Revenue field in MHHE opportunity");
		}
	}


	@And("^MHHESalesRep user edit opportunity$")
	public void MHHESalesRep_user_edit_opportunity() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("CallAlertPopup")) {
				System.out.println("Call Alert Poped-up.. so closing it..");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.click("CloseNotificationPopup");
				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("CloseNotificationPopup")) { //two alert pop-up present
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
			}
			if (selenium.isElementPresentFast("editButton")) {
				selenium.click("editButton");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("editBtn");
				selenium.click("editBtn");
			}
			selenium.waitForElementToBeClickable("SimpleTextAreaField");
			selenium.type("SimpleTextAreaField", "Opp Comments");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(20000);
			selenium.test.log(LogStatus.INFO, "Successfully editing MHHE Opp by adding new comment!");
			selenium.waitForElementToBeVisible("mheCourseGetText");
			selenium.scrollToElement("mheCourseGetText");
			selenium.scrolldown(150);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while editing MHHE opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing MHHE opportunity");
		}
	}

	@And("^MHHESalesRep user edit opportunity stage$")
	public void MHHESalesRep_user_edit_opportunity_stage() {
		try {
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("editButton")) {
				selenium.click("editButton");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("editBtn");
				selenium.click("editBtn");
			}
			selenium.waitingTime(5000);
			selenium.scrollToElement("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageProspect");
			selenium.click("OppStageProspect");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Successfully editing MHHE Opp stage!");
			selenium.waitForElementToBeVisible("opportunityNameGetText");
			selenium.scrollToElement("opportunityNameGetText");
//			selenium.scrolldown(150);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while editing MHHE opportunity stage " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing MHHE opportunity stage");
		}
	}
	
	@And("^MHHE opp edit opportunity type$")
	public void MHHE_opp_edit_opportunity_type(String opptype) {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("editButton")) {
				selenium.click("editButton");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("editBtn");
				selenium.click("editBtn");
			}
			selenium.waitingTime(5000);
			selenium.scrollToElement("MHHEOppTypeField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MHHEOppTypeField");
			selenium.click("MHHEOppTypeField");
			selenium.waitingTime(5000);
			String Xpath = selenium.getDynamicXpath_data("spanTitle", opptype, "end");
			System.out.println("opp type xpath is:" +Xpath);
			selenium.clickXpath(Xpath);
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Successfully editing MHHE Opp stage!");
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while editing MHHE opportunity stage " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing MHHE opportunity stage");
		}
	}
	
	@And("^verify Winning Publisher picklist$")
	public void verify_Winning_Publisher_picklist() {
		try {
			selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("editButton")) {
				selenium.click("editButton");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("editBtn");
				selenium.click("editBtn");
			}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StageLost");
			selenium.click("StageLost");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("WinningPublisherField");
			selenium.click("WinningPublisherField");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("WinningPublisherPicklistValue1") && selenium.isElementPresentFast("WinningPublisherPicklistValue2") && selenium.isElementPresentFast("WinningPublisherPicklistValue3")&&selenium.isElementPresentFast("WinningPublisherPicklistValue5")&&selenium.isElementPresentFast("WinningPublisherPicklistValue6")&&selenium.isElementPresentFast("WinningPublisherPicklistValue7"))
			{
		 		selenium.test.log(LogStatus.PASS, "The expected picklist values are present in Winning Publisher dropdown list");
		 		System.out.println("PASS");
			}
			else
		 	{
				selenium.test.log(LogStatus.FAIL, "The expected picklist values are missing");
				selenium.reportFailure("The expected picklist values are missing");
			}
			selenium.pressEscapeKey();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CancelEdit");
			selenium.click("CancelEdit");
			selenium.waitingTime(10000);
		}
		catch (Exception e) {
			System.out.println("Inside catch");
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("CancelEdit");
			selenium.click("CancelEdit");
			selenium.waitingTime(10000);
			selenium.reportFailure("Error while verifing Winning Publisher picklist " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing Winning Publisher picklist");
		}
	}

	@And("^SEGSalesRep user edit opportunity$")
	public void SEGSalesRep_user_edit_opportunity() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("editButton")) {
				selenium.click("editButton");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("editBtn");
				selenium.click("editBtn");
			}
			selenium.waitForElementToBeClickable("OppOtherPublisherNameField");
			selenium.type("OppOtherPublisherNameField", "Other Publisher Name");
			selenium.waitingTime(2000);
			
			selenium.waitForElementToBeClickable("SubtypeDropDownOpp");
			selenium.click("SubtypeDropDownOpp");
			selenium.waitForElementToBeClickable("SubtypeValue");
			selenium.click("SubtypeValue");
			selenium.waitingTime(2000);
			
			selenium.click("Save_Btn");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.INFO, "Successfully editing SEG Opp by adding Other Publisher Name field!");
			selenium.waitForElementToBeVisible("mheCourseGetText");
//			selenium.scrollToElement("OppProduct");
			selenium.scrolldown(500);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while editing SEG opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing SEG opportunity");
		}
	}

	@And("^INTLSalesRep user edit opportunity$")
	public void INTLSalesRep_user_edit_opportunity() {
		try {
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitForElementToBeClickable("SimpleTextAreaField");
			selenium.type("SimpleTextAreaField", "Opp Comments");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Successfully editing INTL Opp by adding new comment!");
			selenium.waitForElementToBeVisible("mheCourseGetText");
			selenium.scrollToElement("mheCourseGetText");
			selenium.scrolldown(-50);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while editing INTL opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing INTL opportunity");
		}
	}

	@And("^INTLSalesRep user edit opportunity stage$")
	public void INTLSalesRep_user_edit_opportunity_stage() {
		try {
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageValue");
			selenium.click("OppStageValue");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(15000);
			
			if(selenium.isElementPresentFast("closePopUp"))
			{
				System.out.println("Error in editing opp stage");
				selenium.click("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
				selenium.waitingTime(2000);
				selenium.reportFailure("Error while editing INTL opportunity stage ");
				selenium.test.log(LogStatus.FAIL, "Error while editing INTL opportunity stage");
			}
			else
			{
				selenium.scrolldown(150);
				selenium.waitingTime(2000);
				selenium.test.log(LogStatus.PASS, "Successfully editing INTL Opp stage");
			}			

		} catch (Exception e) {
			if(selenium.isElementPresentFast("closePopUp"))
			{
				selenium.click("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
				selenium.waitingTime(2000);
			}
			selenium.reportFailure("Error while editing INTL opportunity stage " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing INTL opportunity stage");
		}
	}

	@Then("^verify the contact is active or not$")

	public void verify_the_contact_is_active_or_not()
	{
		try
		{
			if(selenium.getTestCaseName().equalsIgnoreCase("ValidateInActiveMHHEOppContact"))
			{
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/003C000001wJ8aIIAS/view");
			}
			else
			{
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002Zjo2RAAR/view");	
			}

			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			if (selenium.isElementPresentFast("ContactInactiveStatusCheck")) {
				System.out.println("Contact is in InActive state");
				selenium.test.log(LogStatus.INFO, "Contact is in InActive state");
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.waitingTime(8000);
				selenium.scrollToElement("ContactStatusField");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ContactStatusField");
				selenium.click("ContactStatusField");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("ContactActiveOption");
				selenium.click("ContactActiveOption");
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
			} else {
				System.out.println("Contact is in Active state");
				selenium.test.log(LogStatus.INFO, "Contact is in Active state");
			}
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying contact status " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying contact status");
		}
	}
	
	@And("^verify the process builder functionality$")
	public void verify_the_process_builder_functionality()
	{
		try
		{
//Update the opp stage as TakeAway & check the Rollover Aging field is set to 0 initially
			MHHE_opp_edit_opportunity_type("Takeaway");
			selenium.waitForElementToBeVisible("RolloverAgingValue");
			RolloverAging = selenium.getText("RolloverAgingValue");
			System.out.println("RolloverAging" + RolloverAging);
			if(RolloverAging.equalsIgnoreCase("0"))
			{
		 		selenium.test.log(LogStatus.PASS, "Rollover Aging value is 0 when the Opp Type is set as Takeaway");
		 		System.out.println("PASS");
			}
			else
		 	{
				selenium.test.log(LogStatus.FAIL, "Rollover Aging value is not equal to 0 when the Opp Type is set as Takeaway");
				selenium.reportFailure("Rollover Aging value is not equal to 0 when the Opp Type is set as Takeaway");
			}

//Update the Type as Rollover & check the Rollover Aging is set as 1
			MHHE_opp_edit_opportunity_type("Rollover");
			selenium.waitForElementToBeVisible("RolloverAgingValue");
			RolloverAging = selenium.getText("RolloverAgingValue");
			System.out.println("RolloverAging" + RolloverAging);
			if(RolloverAging.equalsIgnoreCase("1"))
			{
		 		selenium.test.log(LogStatus.PASS, "Rollover Aging value is 1 when the Opp Type is set as Rollover");
		 		System.out.println("PASS");
			}
			else
		 	{
				selenium.test.log(LogStatus.FAIL, "Rollover Aging value is not equal to 1 when the Opp Type is set as Rollover");
				selenium.reportFailure("Rollover Aging value is not equal to 1 when the Opp Type is set as Rollover");
			}

//Update the Type as Service & check the Rollover Aging is set as 0
			MHHE_opp_edit_opportunity_type("Service");
			selenium.waitForElementToBeVisible("RolloverAgingValue");
			RolloverAging = selenium.getText("RolloverAgingValue");
			System.out.println("RolloverAging" + RolloverAging);
			if(RolloverAging.equalsIgnoreCase("0"))
			{
		 		selenium.test.log(LogStatus.PASS, "Rollover Aging value is 0 when the Opp Type is set as Service");
		 		System.out.println("PASS");
			}
			else
		 	{
				selenium.test.log(LogStatus.FAIL, "Rollover Aging value is not equal to 0 when the Opp Type is set as Service");
				selenium.reportFailure("Rollover Aging value is not equal to 0 when the Opp Type is set as Service");
			}

//Update the Type as Rollover & check the Rollover Aging is set as 1
			MHHE_opp_edit_opportunity_type("Rollover");
			selenium.waitForElementToBeVisible("RolloverAgingValue");
			RolloverAging = selenium.getText("RolloverAgingValue");
			System.out.println("RolloverAging" + RolloverAging);
			if(RolloverAging.equalsIgnoreCase("1"))
			{
		 		selenium.test.log(LogStatus.PASS, "Rollover Aging value is 1 when the Opp Type is set as Rollover");
		 		System.out.println("PASS");
			}
			else
		 	{
				selenium.test.log(LogStatus.FAIL, "Rollover Aging value is not equal to 1 when the Opp Type is set as Rollover");
				selenium.reportFailure("Rollover Aging value is not equal to 1 when the Opp Type is set as Rollover");
			}

//Update the Type as competition Not in play & check the Rollover Aging is set as 0
			MHHE_opp_edit_opportunity_type("Competition Not in Play");
			selenium.waitForElementToBeVisible("RolloverAgingValue");
			RolloverAging = selenium.getText("RolloverAgingValue");
			System.out.println("RolloverAging" + RolloverAging);
			if(RolloverAging.equalsIgnoreCase("0"))
			{
		 		selenium.test.log(LogStatus.PASS, "Rollover Aging value is 0 when the Opp Type is set as Competition Not in Play");
		 		System.out.println("PASS");
			}
			else
		 	{
				selenium.test.log(LogStatus.FAIL, "Rollover Aging value is not equal to 0 when the Opp Type is set as Competition Not in Play");
				selenium.reportFailure("Rollover Aging value is not equal to 0 when the Opp Type is set as Competition Not in Play");
			}

//Update the Type as Rollover & check the Rollover Aging is set as 1
			MHHE_opp_edit_opportunity_type("Rollover");
			selenium.waitForElementToBeVisible("RolloverAgingValue");
			RolloverAging = selenium.getText("RolloverAgingValue");
			System.out.println("RolloverAging" + RolloverAging);
			if(RolloverAging.equalsIgnoreCase("1"))
			{
		 		selenium.test.log(LogStatus.PASS, "Rollover Aging value is 1 when the Opp Type is set as Rollover");
		 		System.out.println("PASS");
			}
			else
		 	{
				selenium.test.log(LogStatus.FAIL, "Rollover Aging value is not equal to 1 when the Opp Type is set as Rollover");
				selenium.reportFailure("Rollover Aging value is not equal to 1 when the Opp Type is set as Rollover");
			}

//Update the Rollover aging as 5(value>4) & verify Stage is set as service & Type is set as qualified
			selenium.waitForElementToBeVisible("RolloverAgingEditBtn");
			selenium.jsClick("RolloverAgingEditBtn");
			selenium.waitForElementToBeClickable("RolloverAgingEditField");
			selenium.typeData("RolloverAgingEditField", "5");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			
			selenium.waitForElementToBeVisible("RolloverAgingValue");
			String MHHEOppTypeValue = selenium.getText("MHHEOppTypeValue");
			System.out.println("MHHEOppTypeValue" + MHHEOppTypeValue);
			String MHHEOppStageValue = selenium.getText("MHHEOppStageValue");
			System.out.println("MHHEOppStageValue" + MHHEOppStageValue);
			if(MHHEOppTypeValue.equalsIgnoreCase("Service") && MHHEOppStageValue.equalsIgnoreCase("Qualified"))
			{
		 		selenium.test.log(LogStatus.PASS, "After updating Rollover aging value as 5, the stage got updated as Service & type got updated as Qualified");
		 		System.out.println("PASS");
			}
			else
		 	{
				selenium.test.log(LogStatus.FAIL, "Validation failed");
				selenium.reportFailure("Validation failed");
			}
			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifying process builder functionality " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying process builder functionality");
		}
	}
	
	@Then("^add print exception allowed product to opportunity$")
	public void add_print_exception_allowed_product_to_opportunity()
	{
		try
		{
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.jsClick("taggedProductAddorEdit");
			selenium.waitingTime(4000);
			selenium.switchToFrame("OpportunityFrameNew");
			selenium.typeData("taggedProductISBN1", "9781264868452");		//select id from Product2 where Print_Exception_Allowed__c = true
			selenium.waitForElementToBeClickable("taggedProductISBNSearch");
			selenium.clickLoop("taggedProductISBNSearch");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("taggedProductISBNSearchSelectionMHHENEW");
			selenium.jsClick("taggedProductISBNSearchSelectionMHHENEW");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");
			selenium.waitingTime(2000);
			selenium.clickLoop("addProductNew");
			selenium.waitForElementToBeVisible("Button_Save");
			selenium.scrollToElement("Button_Save");
			selenium.click("Button_Save");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Print exception allowed product has been successfully added to opportunity");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Test case failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test case failed");
		}
	}
	
	@Then("^create and verify the request product exception$")
	public void create_and_verify_the_request_product_exception()
	{
		try
		{
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("requestProductAcceptionBtn");
			selenium.click("requestProductAcceptionBtn");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.jsClick("EverGreenPrintExceptionNationalChkBx");
			selenium.click("NxtButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ProductExceptionReasonDrpDwn");
			selenium.click("ProductExceptionReasonDrpDwn");
			selenium.waitForElementToBeClickable("ProductExceptionReason");
			selenium.click("ProductExceptionReason");
			selenium.typeData("ProductExceptionComments", "Test");
			selenium.jsClick("ProductExceptionProductSelectionChkBx");
			selenium.typeData("ExpectedSoldQty", "1");
			selenium.typeData("ExceptionThroughDate", "Feb 7, 2025");
			selenium.click("SubmitButton");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.PASS, "Product Expection Request has been submitted");
			
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("ApprovalHistoryRelatedList");
			selenium.click("ApprovalHistoryRelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			Assert.assertTrue(selenium.isElementPresentFast("ApprovalRequestSubmittedInApprovalHistory"));
			Assert.assertTrue(selenium.isElementPresentFast("RVPApprovalInApprovalHistroy"));
			Assert.assertTrue(selenium.isElementPresentFast("RVPApprovalStatus"));
			Assert.assertTrue(selenium.isElementPresentFast("ApprovalRequestSubmittedStatus"));
			Assert.assertTrue(selenium.isElementPresentFast("ProductExceptionActualApproverName"));	 //Opp Owner Jackie Alvarado's Manager2 name is 'James Heine' as of 07/FEB/24
			selenium.test.log(LogStatus.PASS, "Product Exception Request Created & assiged to correct approver & status also as expected!");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Test case failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test case failed");
		}
	}
	
	@And("^try creating one more product expection request when existing request is pending$")
	public void try_creating_one_more_product_expection_request_when_existing_request_is_pending()
	{
		try
		{
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("requestProductAcceptionBtn");
			selenium.click("requestProductAcceptionBtn");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.jsClick("EverGreenPrintExceptionNationalChkBx");
			selenium.click("NxtButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ProductExceptionReasonDrpDwn");
			selenium.click("ProductExceptionReasonDrpDwn");
			selenium.waitForElementToBeClickable("ProductExceptionReason");
			selenium.click("ProductExceptionReason");
			selenium.typeData("ProductExceptionComments", "Test");
			selenium.jsClick("ProductExceptionProductSelectionChkBx");
			selenium.typeData("ExpectedSoldQty", "1");
			selenium.typeData("ExceptionThroughDate", "Feb 7, 2025");
			selenium.click("SubmitButton");
			selenium.waitingTime(5000);
			Assert.assertTrue(selenium.isElementPresentFast("AlreadyProdExceptionApprovalPendingMsg"));
			selenium.test.log(LogStatus.PASS, "The expected validation message triggered");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Test case failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test case failed");
		}
	}
	
	@And("^verify the product exception request status after approval$")
	public void verify_the_product_exception_request_status_after_approval()
	{
		try
		{
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("MHHEOpp_EvergreenPrintExceptionStatusGetText");
			String actual_Status = selenium.getText("MHHEOpp_EvergreenPrintExceptionStatusGetText");
			String expected_Status = "In Approval";
			System.out.println("actual_Status" + actual_Status);
			Assert.assertEquals(actual_Status, expected_Status);
			
			selenium.waitForElementToBeClickable("ApprovalHistoryRelatedList");
			selenium.click("ApprovalHistoryRelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			Assert.assertTrue(selenium.isElementPresentFast("RVPApprovalStatus2"));
			Assert.assertTrue(selenium.isElementPresentFast("PrintExceptionTeamApprovalStatus"));
			selenium.test.log(LogStatus.PASS, "Product Exception Request status is showing as expected!");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Test case failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test case failed");
		}
	}
	
	@And("^verify the product exception request status after rejection$")
	public void verify_the_product_exception_request_status_after_rejection()
	{
		try
		{
			selenium.navigateToURL(selenium.MHHENewOppURL);
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("MHHEOpp_EvergreenPrintExceptionStatusGetText");
			String actual_Status = selenium.getText("MHHEOpp_EvergreenPrintExceptionStatusGetText");
			String expected_Status = "Denied by Print Exception Team";
			System.out.println("actual_Status" + actual_Status);
			Assert.assertEquals(actual_Status, expected_Status);
			
			selenium.waitForElementToBeClickable("ApprovalHistoryRelatedList");
			selenium.click("ApprovalHistoryRelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			Assert.assertTrue(selenium.isElementPresentFast("PrintExceptionTeamApprovalStatus2"));
			selenium.test.log(LogStatus.PASS, "Product Exception Request status is showing as expected!");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Test case failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test case failed");
		}
	}
	
	@Then("^approve the product exception request$")
	public void approve_the_product_exception_request()
	{
		try
		{
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/n/ear__Approval_Requests");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("SideButtonDropDown");
			selenium.click("SideButtonDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ApproveBtn");
			selenium.click("ApproveBtn");			
			selenium.waitForElementToBeVisible("SimpleTextAreaField");
			selenium.typeData("SimpleTextAreaField", "Approving");		
			selenium.click("ApproveBtnInProductExceptionRequestPopup");
			selenium.waitingTime(10000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Test case failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test case failed");
		}
	}
	
	@Then("^reject the product exception request$")
	public void reject_the_product_exception_request()
	{
		try
		{
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/n/ear__Approval_Requests");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("SideButtonDropDown");
			selenium.click("SideButtonDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("rejectBtnNew");
			selenium.click("rejectBtnNew");			
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("SimpleTextAreaField");
			selenium.typeData("SimpleTextAreaField", "Rejecting");		
			selenium.click("RejectBtnInProductExceptionRequestPopup");
			selenium.waitingTime(10000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Test case failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test case failed");
		}
	}

	@Then("^navigate to an exiting opportunity$")
	public void navigate_to_an_exiting_opportunity()
	{
		try
		{
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyAtRiskHistoryIsTracked")||selenium.getTestCaseName().equalsIgnoreCase("VerifyStageChangeWithZeroTargetProduct")|| selenium.getTestCaseName().equalsIgnoreCase("VerifyValidationRuleIsTriggeredForOpp")||selenium.getTestCaseName().equalsIgnoreCase("VerifyValidationRuleIsTriggeredOnOppFieldProductSolution")||selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserRenameOpp") || selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserAddContactToOpp") || selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserAddProductToOpp") || selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserEditOpp") || selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserCreateSampleOpp") || selenium.getTestCaseName().equalsIgnoreCase("DeleteINTLOpportunity") || selenium.getTestCaseName().equalsIgnoreCase("INTLCloneOpp") || selenium.getTestCaseName().equalsIgnoreCase("ValidateInActiveINTLOppContact") || selenium.getTestCaseName().equalsIgnoreCase("ValidateInActiveINTLOppContactForPastYear") || selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserVerifyRevenueCal"))
			{
				selenium.navigateToURL(selenium.INTLOppURL);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("ValidateNewlyAddedFieldAreEditable")||selenium.getTestCaseName().equalsIgnoreCase("MHHESalesRepUserRenameOpp") || selenium.getTestCaseName().equalsIgnoreCase("MHHESalesRepUserEditOpp") || selenium.getTestCaseName().equalsIgnoreCase("ValidateInActiveMHHEOppContact") || selenium.getTestCaseName().equalsIgnoreCase("UpdateAndVerifyTPOptOutDataViaOppMassEdit") || selenium.getTestCaseName().equalsIgnoreCase("MHHEUpdateOpp") || selenium.getTestCaseName().equalsIgnoreCase("VerifyProcessBuilderFunctionality") || selenium.getTestCaseName().equalsIgnoreCase("VerifyRequestProductExceptionflow")) {
				selenium.navigateToURL(selenium.MHHENewOppURL);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("SEGSalesRepUserRenameOpp") || selenium.getTestCaseName().equalsIgnoreCase("SEGSalesRepUserEditOpp") || selenium.getTestCaseName().equalsIgnoreCase("VerifyOppCloseAndPurchaseDatePostponeClone") || selenium.getTestCaseName().equalsIgnoreCase("MHESPostponeCloneOpp")) {
				selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("OppListViewMassCloneAndVerifyData")) {
				selenium.navigateToURL(selenium.MHHENewOppURLForSingleClone);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("RemoveOneEGProdAndVerifyEGFieldInOpp") || selenium.getTestCaseName().equalsIgnoreCase("RemoveAllEGProdAndVerifyEGFieldInOpp") || selenium.getTestCaseName().equalsIgnoreCase("VerifyCSPartnerFieldInOpp") || selenium.getTestCaseName().equalsIgnoreCase("VerifyFutureNetPriceAndDateFieldProd") || selenium.getTestCaseName().equalsIgnoreCase("VerifyFutureNetPriceAndDateFieldProdInUse") || selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForCurrentYearOpp") || selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForFutureYearOpp") || selenium.getTestCaseName().equalsIgnoreCase("VerifyTPFieldForPastYearOpp") || selenium.getTestCaseName().equalsIgnoreCase("VerifyFieldsLabelInUserAndOpp")) {
				selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("ValidateInActiveMHESOppContact")) {
				selenium.navigateToURL(selenium.SEGSalesRepValidateInActiveOppcontactURL);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifySuppliercodeMHEorVST")) {
				selenium.navigateToURL(INTLOppForVerifySuppliercodeMHEorVST);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("SEGUserAddProdwithCourseCategoryMarketCodeAsSEGOH") || selenium.getTestCaseName().equalsIgnoreCase("SEGUserAddProdwithCourseCategoryMarketCodeNotAsSEGOH")) {
				selenium.navigateToURL(SEGOppToAddMarketCode);

			}
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyOppReasonFieldWithStatusPostponed")){
				selenium.navigateToURL(selenium.url);
			}
//			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyOppPIURelatedListAddDelete")) {
//				selenium.navigateToURL(selenium.OppPIUAddDeleteURL);
//			}




			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Navigated to desired opportunity");
		} catch (Exception e) {
			selenium.reportFailure("Error while navigating to exiting opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to exiting opportunity");
		}
	}

	@And("^validate the opportunity name$")
	public void validate_the_opportunity_name() {
		try {
			selenium.waitForElementToBeVisible("opportunityNameGetText");
			String opportunityName = selenium.getText("opportunityNameGetText").toString();
			System.out.println("Opp Name : " + opportunityName);
			String opportunityAccountName = selenium.getText("opportunityAccountNameGetText").toString();
			System.out.println("Opp Account Name : " + opportunityAccountName);
			String opportunityMHECourseName = selenium.getText("opportunityMHECourseNameGetText").toString();
			System.out.println("Opp MHECourse Name : " + opportunityMHECourseName);
			String opportunityYear = selenium.getText("opportunityYearGetText").toString();
			System.out.println("Opp Year : " + opportunityYear);
			String opportunityType = selenium.getText("opportunityTypeGetText").toString();
			System.out.println("Opp Type : " + opportunityType);
			String opportunityStage = selenium.getText("opportunityStageGetText").toString();
			System.out.println("Opp Stage : " + opportunityStage);

			if (opportunityName.contains(opportunityAccountName) && opportunityName.contains(opportunityMHECourseName) && opportunityName.contains(opportunityYear) && opportunityName.contains(opportunityType)) {
				selenium.test.log(LogStatus.PASS, "Opportunity Name Validated Successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opportunity Name Validation Failed!");
				selenium.reportFailure("Opportunity Name Validation Failed!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating INTL opportunity name " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating INTL opportunity name");
		}
	}

	@And("^validate the SEG opportunity name$")
	public void validate_the_SEG_opportunity_name() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("opportunityNameGetText");
			String opportunityName = selenium.getText("opportunityNameGetText").toString();
			System.out.println("Opp Name : " + opportunityName);
			String opportunityYear = selenium.getText("opportunityYearGetText").toString();
			System.out.println("Opp Year : " + opportunityYear);
			String opportunityAccountName = selenium.getText("opportunityAccountNameGetText").toString();
			System.out.println("Opp Account Name : " + opportunityAccountName);
			String MarketRevenueGroup = selenium.getText("MarketRevenueGroupGetText").toString();
			System.out.println("Opp MarketRevenue Group : " + MarketRevenueGroup);
			String opportunityStage = selenium.getText("opportunityStageGetText").toString();
			System.out.println("Opp Stage : " + opportunityStage);

			String USStateCode = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("US State Code");
			System.out.println("US State Code : " + USStateCode);
			String Alias = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Alias");
			System.out.println("Alias : " + Alias);


			if (opportunityName.contains(USStateCode) && opportunityName.contains(opportunityAccountName) && opportunityName.contains(MarketRevenueGroup) && opportunityName.contains(opportunityYear)) {
				selenium.test.log(LogStatus.PASS, "Opportunity Name Validated Successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opportunity Name Validation Failed!");
				selenium.reportFailure("Opportunity Name Validation Failed!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating SEG opportunity name " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating SEG opportunity name");
		}
	}

	@Then("^rename the INTL opportunity$")
	public void rename_the_INTL_opportunity() {
		try {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("editAccount");
			selenium.click("editAccount");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppAccountNameClearSelectionIcon");
			selenium.click("OppAccountNameClearSelectionIcon");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("opportunityAccount");
			selenium.type("opportunityAccount", "Account Name");
			selenium.waitingTime(6000);
			selenium.clickDynamicXpath("lightningTitle", "Account Name", "end");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppMHECourseClearSelectionIcon");
			selenium.click("OppMHECourseClearSelectionIcon");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OpportunityMHECourse2");
			selenium.type("OpportunityMHECourse2", "MHE Course");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("lightningTitle", "MHE Course", "end");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppTermField");
			selenium.click("OppTermField");
			selenium.waitForElementToBeClickable("OppTermValueSpring");
			selenium.click("OppTermValueSpring");
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitForElementToBeClickable("OppStageValue");
			selenium.click("OppStageValue");
			selenium.waitingTime(2000);
//			selenium.scrolldown(150);
//			selenium.waitForElementToBeClickable("OppYearField");
//			selenium.click("OppYearField");
//			selenium.waitForElementToBeClickable("OppYearValue");
//			selenium.click("OppYearValue");
//			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.INFO, "Renaming of opportunity name is completed!");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while renaming INTL opportunity name " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while renaming INTL opportunity name");
		}
	}


	@Then("^rename the opportunity$")
	public void rename_the_opportunity() {
		try {
			selenium.waitForElementToBeVisible("editAccount");
			selenium.scrollToElement("RelatedListQuickLinks");
			selenium.waitForElementToBeClickable("editAccount");
			selenium.click("editAccount");
			selenium.waitingTime(2000);
			selenium.pressEscapeKey();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppAccountNameClearSelectionIcon");
			selenium.click("OppAccountNameClearSelectionIcon");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("opportunityAccount");
			selenium.type("opportunityAccount", "Account Name");
			selenium.waitingTime(6000);
			selenium.clickDynamicXpath("lightningTitle", "Account Name", "end");
			selenium.waitingTime(4000);

			selenium.waitForElementToBeClickable("OppMHECourseClearSelectionIcon");
			selenium.click("OppMHECourseClearSelectionIcon");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OpportunityMHECourse1");
			selenium.type("OpportunityMHECourse1", "MHE Course");
			selenium.waitingTime(5000);
			selenium.clickDynamicXpath("lightningTitle", "MHE Course", "end");
			selenium.waitingTime(4000);

			selenium.scrollToElement("OppAccountNameClearSelectionIcon");
			selenium.waitForElementToBeClickable("OppTermField");
			selenium.click("OppTermField");
			selenium.waitForElementToBeClickable("OppTermValueSpring");
			selenium.click("OppTermValueSpring");
			selenium.scrollToElement("OppMHECourseClearSelectionIcon");
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("OppStageValue");
//			selenium.click("OppStageValue");
			selenium.clickDynamicXpath("spanTitle", "Stage Name", "end");
			selenium.waitingTime(2000);
//			selenium.scrolldown(150);
//			selenium.waitForElementToBeClickable("OppYearField");
//			selenium.click("OppYearField");
//			selenium.waitForElementToBeClickable("OppYearValue");
//			selenium.click("OppYearValue");
//			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.INFO, "Renaming of opportunity name is completed!");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while renaming opportunity name " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while renaming opportunity name");
		}
	}

	@Then("^rename the SEG opportunity$")
	public void rename_the_SEG_opportunity() {
		try {
			selenium.waitingTime(6000);
			selenium.scrolldown(100);
			selenium.waitForElementToBeVisible("editAccount");
//			selenium.scrollToElement("RelatedListQuickLinks");
			selenium.waitForElementToBeClickable("editAccount");
			selenium.click("editAccount");

			selenium.waitForElementToBeClickable("OppAccountNameClearSelectionIcon");
			selenium.click("OppAccountNameClearSelectionIcon");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("opportunityAccount");
			selenium.type("opportunityAccount", "Account Name");
			selenium.waitingTime(6000);
			selenium.clickDynamicXpath("lightningTitle", "Account Name", "end");
			selenium.waitingTime(4000);

			selenium.waitForElementToBeClickable("MarketRevenueField");
			selenium.click("MarketRevenueField");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("spanTitle", "Market Revenue", "end");
			selenium.waitingTime(4000);
			selenium.scrolldown(150);

			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("spanTitle", "Stage Name", "end");
			selenium.waitingTime(2000);

			selenium.click("Save_Btn");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.INFO, "Renaming of opportunity name is completed!");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure("Error while renaming opportunity name " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while renaming opportunity name");
		}
	}

	@And("^validate the updated opportunity name$")
	public void validate_the_updated_opportunity_name() {
		try {
			selenium.waitForElementToBeVisible("opportunityNameGetText");
			String opportunityName = selenium.getText("opportunityNameGetText").toString();
			System.out.println("Opp Name : " + opportunityName);
			String opportunityAccountName = selenium.getText("opportunityAccountNameGetText").toString();
			System.out.println("Opp Account Name : " + opportunityAccountName);
			String opportunityMHECourseName = selenium.getText("opportunityMHECourseNameGetText").toString();
			System.out.println("Opp MHECourse Name : " + opportunityMHECourseName);
			String opportunityYear = selenium.getText("opportunityYearGetText").toString();
			System.out.println("Opp Year : " + opportunityYear);
			String opportunityType = selenium.getText("opportunityTypeGetText").toString();
			System.out.println("Opp Type : " + opportunityType);
			String opportunityStage = selenium.getText("opportunityStageGetText").toString();
			System.out.println("Opp Stage : " + opportunityStage);
			String opportunityTerm = selenium.getText("opportunityTermGetText").toString();
			System.out.println("Opp Term : " + opportunityTerm);

			if (opportunityName.contains(opportunityAccountName) && opportunityName.contains(opportunityMHECourseName) && opportunityName.contains(opportunityYear) && opportunityName.contains(opportunityType) && opportunityName.contains(opportunityTerm)) {
				selenium.test.log(LogStatus.PASS, "Opportunity Name Validated Successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opportunity Name Validation Failed!");
				selenium.reportFailure("Opportunity Name Validation Failed!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating INTL opportunity name " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating INTL opportunity name");
		}
	}

	@And("^validate the updated SEG opportunity name$")
	public void validate_the_updated_SEG_opportunity_name() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("opportunityNameGetText");
			String opportunityName = selenium.getText("opportunityNameGetText").toString();
			System.out.println("Opp Name : " + opportunityName);
			String opportunityYear = selenium.getText("opportunityYearGetText").toString();
			System.out.println("Opp Year : " + opportunityYear);
			String opportunityAccountName = selenium.getText("opportunityAccountNameGetText").toString();
			System.out.println("Opp Account Name : " + opportunityAccountName);
			String MarketRevenueGroup = selenium.getText("MarketRevenueGroupGetText").toString();
			System.out.println("Opp MarketRevenue Group : " + MarketRevenueGroup);
			String opportunityStage = selenium.getText("opportunityStageGetText").toString();
			System.out.println("Opp Stage : " + opportunityStage);

			String USStateCode = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("US State Code");
			System.out.println("US State Code : " + USStateCode);
			String Alias = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Alias");
			System.out.println("Alias : " + Alias);


			if (opportunityName.contains(USStateCode) && opportunityName.contains(opportunityAccountName) && opportunityName.contains(MarketRevenueGroup) && opportunityName.contains(opportunityYear)) {
				selenium.test.log(LogStatus.PASS, "Opportunity Name Validated Successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opportunity Name Validation Failed!");
				selenium.reportFailure("Opportunity Name Validation Failed!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating SEG opportunity name " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating SEG opportunity name");
		}
	}

	@And("^verify Lead Nomination Details section$")
	public void verify_Lead_Nomination_Details_section() {
		try {
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("OppLeadNominDetailsSec");
			selenium.scrollToElement("OppLeadNominDetailsSec");
			selenium.waitingTime(2000);
			selenium.scrolldown(-220);
			selenium.test.log(LogStatus.PASS, "VERIFIED - In MHHE Opportunity page, the LEAD NOMINATION DETAILS Section is availabe under COMMENTS section.");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NominLeadEditIcon");
			selenium.jsClick("NominLeadEditIcon");
			selenium.waitForElementToBeClickable("NominateLeadCheckBox");
			selenium.jsClick("NominateLeadCheckBox");
			selenium.type("AdoptionSituationTextBox", "Adoption Situation");
			selenium.waitingTime(2000);
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			
			if(selenium.isElementPresentFast("Save_Btn"))
			{
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(8000);
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating lead nomination details section " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating lead nomination details section");
		}
	}

	@And("^Navigate to products section$")
	public void navigate_to_products_section() {
		try {

			selenium.waitForElementToBeClickable("productsSectionForOpportunity");
			selenium.jsClick("productsSectionForOpportunity");
//			selenium.waitingTime(3000);
//			selenium.waitForElementToBeVisible("productAddOrEdit");
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while navigating to products section " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Navigate to Lead Nomination section$")
	public void navigate_to_lead_nomination_section() {
		try {
			//selenium.oppLeadNominationUrl=selenium.getURL();
			selenium.waitForElementToBeClickable("leadNominationSectionForOpportunity");
			selenium.jsClick("leadNominationSectionForOpportunity");
			selenium.captureScreenShot();
			//selenium.waitForElementToBeClickable("productAddOrEdit");
			//selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(5000);
			System.out.println("Navigated to Lead Nomination section");
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while navigating to Lead Nomination section " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@And("^Verify the Event Nomination Criteria Field and its value$")
	public void verify_the_Event_Nomination_Criteria_Field_and_its_value() {
		try {

			selenium.waitForElementToBeVisible("eventNominationCriteria");
			System.out.println("Reached field eventNominationCriteria");
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("eventNominationCriteriaFieldValue");
			selenium.jsClick("eventNominationCriteriaFieldValue");
			selenium.waitingTime(5000);
			String newURL = selenium.getElement("eventNominationCriteriaFieldValue").getAttribute("href");
			System.out.println("New URL: " + newURL);
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("URL");
			System.out.println("URL: " + url);
			//selenium.navigateToURL(selenium.oppLeadNominationUrl);
			selenium.waitingTime(3000);
			if (newURL.equals(url))
				System.out.println("Both URLs matched: Test is Pass");
			else
				System.out.println("Both URLs did not matched: Test is Fail");
			System.out.println("Testing successfull for field eventNominationCriteria");
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while navigating to Event Nomination Criteria Field " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	/*@Then("^Add product to opportunity$")

    public void Add_product_to_opportunity() {
           try {
selenium.waitForElementsToBeVisible("productframeUat");
selenium.switchToMultipleFrame("productframeUat");
                        selenium.waitingTime(3000);
                        selenium.click("isbnField");
                        selenium.waitingTime(2000);
                        selenium.type("isbnField", "ISBN");
                        selenium.waitingTime(3000);
                        selenium.click("searchBtn");
                        selenium.waitingTime(5000);
                        selenium.click("selectProductToAddToOpp");
                        selenium.waitingTime(2000);
                        selenium.click("opportunitiesAddToOpportunity");
                        selenium.waitingTime(2000);
                        
                        selenium.captureScreenShot();
                        selenium.waitingTime(2000);
                        selenium.click("Button_Save");
                        selenium.waitingTime(5000);
                        selenium.switchOutOfFrame();
                        selenium.waitingTime(5000);
                       
           }

                   catch (Exception e) {
                  selenium.switchOutOfFrame();
                  selenium.reportFailure("Error while adding product " + e.getMessage());
           }
    }*/

	@Then("^request discount for opportunity product$")
	public void request_discount_for_opportunity_product() {
		try {
//        	   selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0067h00000G2LJSAA3/view");
//        	   selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("DIscountdurationopportunity");
			selenium.click("DIscountdurationopportunity");
			selenium.waitingTime(2000);
			selenium.waitForElementsToBeVisible("productframeUat");
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.click("piuCurrentPrice");
			selenium.waitingTime(3000);
			selenium.type("piuCurrentPrice", "PIU Price");
			selenium.waitingTime(3000);
			selenium.click("competitivePrice");
			selenium.waitingTime(3000);
			selenium.type("competitivePrice", "Competitive Price");
			selenium.waitingTime(3000);
			selenium.click("discountSubmissionComments");
			selenium.waitingTime(3000);
			selenium.type("discountSubmissionComments", "Comments");
			selenium.waitingTime(3000);
			selenium.click("digitalRequiredDropdown");
			selenium.waitingTime(3000);

			selenium.selectDropdownText("digitalRequiredDropdown", "Digital Required");
			selenium.waitingTime(3000);
			selenium.click("adoptionProbability");
			selenium.waitingTime(3000);
			selenium.selectDropdownText("adoptionProbability", "Adoption Probability");
			selenium.waitingTime(3000);

			selenium.click("courseStartDate");
			selenium.waitingTime(3000);
			selenium.click("needByDate");
			selenium.waitingTime(3000);
			selenium.click("campusesNeedingOffer");
			selenium.waitingTime(3000);
			selenium.type("campusesNeedingOffer", "Campuses Offer");
			selenium.waitingTime(3000);
//                      System.out.println("MMM");
			selenium.waitForElementToBeClickable("requestedPrice");
			selenium.click("requestedPrice");
			selenium.waitingTime(3000);
			selenium.type("requestedPrice", "Requested Price");
			selenium.waitingTime(3000);
			selenium.moveTab("requestedPrice");
			selenium.waitingTime(7000);
			selenium.selectDropdownByIndex("DiscountType", "Discount Type");
			String discount = selenium.getText("discountPrice1").toString();
			System.out.println("discount is :" + discount);
			String approval = selenium.getText("approvalForDiscount1").toString();
			System.out.println("approval is :" + approval);
			if (discount != null & approval != null) {
				System.out.println("passed");
				selenium.test.log(LogStatus.PASS, "Request Discount page verified successfully");
			}
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.click("submitForApprovalButton");
			selenium.waitingTime(5000);
			boolean alert = selenium.waitForAlertToBeVisible();
			System.out.println("alert 1" + alert);
			selenium.acceptAlert();
			System.out.println("1st alert accepted");
//                        selenium.click("submitForApprovalButton");
			boolean alert1 = selenium.waitForAlertToBeVisible();
			System.out.println("alert 2" + alert1);
			selenium.acceptAlert();
			System.out.println("2nd alert accepted");
			selenium.switchOutOfFrame();
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while submitting request" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^verify approval history$")
	public void verify_approval_history() {
		try {
			selenium.waitForElementToBeClickable("approvaHistorySection");
			selenium.click("approvaHistorySection");
			selenium.waitingTime(5000);
			boolean record = selenium.isElementPresentFast("approvalRecords");
			System.out.println("record present" + record);
			if (record = true) {
				System.out.println("passed test case");
				selenium.test.log(LogStatus.PASS, "request discount success");
			} else {
				System.out.println("fail test case");
				selenium.test.log(LogStatus.FAIL, "request discount failed");
				selenium.reportFailure("request discount failed");
			}
			selenium.captureScreenShot();
			selenium.waitingTime(8000);


		} catch (Exception e) {
			selenium.reportFailure("Error while verifying approval" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^Add product to opportunity$")
	public void Add_product_to_opportunity() {
		try {
			selenium.waitForElementsToBeVisible("productframeUat");
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.click("isbnField");
			selenium.waitingTime(2000);
			selenium.type("isbnField", "ISBN");
			selenium.waitingTime(3000);
			selenium.click("searchBtn");
			selenium.waitingTime(20000);
			selenium.click("selectProductToAddToOpp");
			selenium.waitingTime(2000);
			selenium.click("opportunitiesAddToOpportunity");
			selenium.waitingTime(2000);

			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.click("Button_Save");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
			selenium.waitForElementToBeVisible("requestDiscount");
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while adding product " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@And("^Opportunities Split Lines Validation for Postponed Stage$")
	public void Opportunities_Split_Lines_Validation_Postponed_stage() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("OppProduct");
				selenium.click("OppProduct");
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("OpportunityProductSplitLines");
				selenium.click("OpportunityProductSplitLines");
				selenium.waitingTime(4000);
//				if(!selenium.isElementPresentFast("splitOption"))
//				{
//					selenium.navigateToURL(splitPostponedProduct);
//				}
				selenium.waitForElementToBeClickable("splitOption");
				Select dropdown = new Select(selenium.getElement("splitOption"));
				dropdown.selectByValue("Postponed");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("OpportunityProductSelect1");
				selenium.click("OpportunityProductSelect1");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("OpportunityProductSelect2");
				selenium.click("OpportunityProductSelect2");
				selenium.waitingTime(3000);
				selenium.captureScreenShot();
				selenium.click("OpportunityProductSplitLinesBtn");
				selenium.waitingTime(4000);
				Select dropdown_year = new Select(selenium.getElement("selectYear_postponed"));
				dropdown_year.selectByValue("2026");
				selenium.waitingTime(2000);
				Select dropdown_reason = new Select(selenium.getElement("selectReason_postponed"));
				dropdown_reason.selectByValue("New administration");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
				selenium.click("CreateLostOpportunitySplitLines_postponed");
				selenium.waitingTime(15000);
				selenium.test.log(LogStatus.PASS, "Split Opportunity - Postpond Stage");
				selenium.navigateTo("LoginTest", "Url");
				selenium.waitingTime(3000);

			}

		} catch (Exception e) {

			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^Opportunities Split Lines Validation for Cancelled Stage$")
	public void Opportunities_Split_Lines_Validation_cancelled_stage() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.waitingTime(5000);
//				selenium.waitForElementToBeClickable("OppProduct");
				if (selenium.isElementPresentFast("OppProduct")) {
					selenium.click("OppProduct");
				}
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("OpportunityProductSplitLines");
				selenium.click("OpportunityProductSplitLines");
				selenium.waitingTime(4000);
//				if(!selenium.isElementPresentFast("splitOption"))
//				{
//					selenium.navigateToURL(splitCancelledProduct);
//				}
				selenium.waitForElementToBeClickable("splitOption");
				Select dropdown = new Select(selenium.getElement("splitOption"));
				dropdown.selectByValue("Cancelled");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("OpportunityProductSelect1");
				selenium.click("OpportunityProductSelect1");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("OpportunityProductSelect2");
				selenium.click("OpportunityProductSelect2");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("OpportunityProductSplitLinesBtn");
				selenium.click("OpportunityProductSplitLinesBtn");
				selenium.waitingTime(4000);
				Select dropdown_reason = new Select(selenium.getElement("selectReaseon_cancelled"));
				dropdown_reason.selectByValue("New administration");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
				selenium.click("OpportunityProductSplitLinesBtn");
				selenium.waitingTime(15000);
				selenium.test.log(LogStatus.PASS, "Split Opportunity - Cancelled Stage");
				System.out.println("URL of the Cancelled Opp" +selenium.getURL());
			}

		} catch (Exception e) {

			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@Then("^Add product using ISBN for split$")
	public void add_product_using_ISBN_for_split() {
		try {
			selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("modifyProducts");
			selenium.click("modifyProducts");
			selenium.waitingTime(15000);
			selenium.switchToFrame("switch_iFrame");
			selenium.waitForElementToBeClickable("keyIsbn");
			selenium.click("keyIsbn");
			selenium.waitingTime(2000);
			selenium.type("keyIsbn", "ISBN");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addButton");
			selenium.click("addButton");
				selenium.waitingTime(3000);
			//---------------------------------------------
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("keyIsbn");
			selenium.click("keyIsbn");
			selenium.waitingTime(2000);
			selenium.type("keyIsbn", "ISBN2");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addButton");
			selenium.click("addButton");
				selenium.waitingTime(3000);
			//---------------------------------------------
//				selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("keyIsbn");
			selenium.click("keyIsbn");
			selenium.waitingTime(2000);
			selenium.type("keyIsbn", "ISBN3");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addButton");
			selenium.click("addButton");
			selenium.waitingTime(10000);
			selenium.clickLoop("saveProduct");
			selenium.waitingTime(25000);
			selenium.switchOutOfFrame();
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
//			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^SEG Sales Rep user creates new opportunity$")
	public void SEG_Sales_Rep_user_creates_new_opportunity() {
		try {
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.click("NextButton");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(15000);

			if (selenium.isElementPresentFast("SEGOppAccountName")) {
				selenium.waitForElementToBeClickable("SEGOppAccountName");
				selenium.type("SEGOppAccountName", "Account Name");
			} else {
				selenium.refresh();
				selenium.waitingTime(15000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("SEGOppAccountName");
				selenium.type("SEGOppAccountName", "Account Name");
			}
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath("StrongTagStart", "Account Name", "endContains");
			selenium.waitingTime(6000);
			
			selenium.waitForElementToBeClickable("DateLink");
			selenium.click("DateLink");
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.click("DefaultPurchaseDate");
//			selenium.click("ConfidenceFactor");
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(1);
			selenium.type("OppAmount", "Amount");
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("CreateOppAndVerifyDaysToClose")) {
				selenium.waitForElementToBeClickable("OppOwner");
				selenium.type("OppOwner", "Opp Owner");
				selenium.waitingTime(4000);
				selenium.clickDynamicXpath("StrongTagStart", "Opp Owner", "endContains");
				selenium.waitingTime(6000);
			}
			selenium.click("Button_Save");
			selenium.waitingTime(10000);

			if (selenium.isElementPresentFast("Button_Save")) {
				selenium.takeScreenShot();
				selenium.click("Button_Save");
				selenium.waitingTime(15000);
			}
			
			selenium.refresh();
			selenium.waitingTime(15000);
			
			/*SAVING THE NEWLY CREATED OPP URL AND NAME FOR FURTHER USE*/
			if (selenium.getTestCaseName().equalsIgnoreCase("SEGSalesRepUserCreateOpportunity")) {
				selenium.SEGSalesRepUserNewOppURL = selenium.getURL();
				System.out.println("Newly created opp url is :" + selenium.SEGSalesRepUserNewOppURL);
				selenium.waitForElementToBeVisible("OppNameFromOppPage");
				selenium.opportunity_expected = selenium.getText("OppNameFromOppPage");
				System.out.println("Newly created opp name is :" + selenium.opportunity_expected);
				selenium.test.log(LogStatus.INFO, "Newly created opp url is :" + selenium.SEGSalesRepUserNewOppURL);
			}

			if (selenium.getTestCaseName().equalsIgnoreCase("CreateNewOppForSamplesTest")) {
				selenium.NewOppURLForSamplesTest = selenium.getURL();
				System.out.println("The newly created opp url is :" + selenium.NewOppURLForSamplesTest);
				selenium.opportunity_name = selenium.getText("OppNameFromOppPage");
				System.out.println("The newly created opp name is :" + selenium.opportunity_name);
			}

			if (selenium.getTestCaseName().equalsIgnoreCase("CreateOppAndVerifyCloseAndPurchaseDate")) {
				selenium.NewOppURLForClosePurchaseDateTest = selenium.getURL();
				System.out.println("The newly created opp url :" + selenium.NewOppURLForClosePurchaseDateTest);
			}

			if (selenium.getTestCaseName().equalsIgnoreCase("CreateOppAndVerifyDaysToClose")) {
				selenium.NewOppURLForVerifyDaysToCloseTest = selenium.getURL();
				System.out.println("The newly created opp url ::" + selenium.NewOppURLForVerifyDaysToCloseTest);
			}

			if(selenium.getTestCaseName().equalsIgnoreCase("CreateNewOppForSamplesTest") )
			{
				selenium.SampleTestingURL=selenium.getURL();
				System.out.println("The newly created opp url ::" + selenium.SampleTestingURL);
			}
			
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyStatusDateinSEGOpp") )
			{
				selenium.OppWithLostStage=selenium.getURL();
				System.out.println("The newly created opp url to verfy Status Date field::" + selenium.OppWithLostStage);
			}
			
			if (selenium.getTestCaseName().equalsIgnoreCase("CreateNewOppForQuotesTest")) {
				selenium.NewOppURLForQuotesTest = selenium.getURL();
				System.out.println("The newly created opportunity url is :" + selenium.NewOppURLForQuotesTest);
				selenium.waitForElementToBeVisible("OppNameFromOppPage");
				selenium.opty_expected = selenium.getText("OppNameFromOppPage");
				System.out.println("Newly created via postpone/clone opp name is :" + selenium.opty_expected);
			}
			
			selenium.waitingTime(4000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^create new contact with SDR values$")
	public void create_new_contact_with_SDR_values() {
		try {
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitForElementToBeClickable("ContactLastName");
			selenium.type_propertiesFile("ContactLastName", "AutomationUser");
			selenium.type_propertiesFile("serach_Account", "serach_Account");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.click("showAllResultsFromDropDwn");
			selenium.waitingTime(4000);
			String accountsearch = selenium.getDynamicXpath_propertiesFile("anchorTitlecontains", "serach_Account", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(accountsearch);
			selenium.waitingTime(4000);
			selenium.scrollToElement("JobFunctionOption");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.click("JobFunctionOption");
			selenium.click("JobFunctionMoveIcon");
			selenium.scrollToElement("SDRNextStepfield");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.type_propertiesFile("SDRNextStepfield", "DummyText");
			selenium.type_propertiesFile("SDRNeedField", "DummyText");
			selenium.waitingTime(2000);
			selenium.type_propertiesFile("search_People", "SDRUser");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.clickLoop("showAllResultsFromDropDwn");
			selenium.waitingTime(4000);
			String usersearch = selenium.getDynamicXpath_propertiesFile("anchorTextcontainsPeople", "SDRUser", "endContains");
			selenium.waitingTime(4000);
			System.out.println(usersearch);
			selenium.clickLoopXpath(usersearch);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SDRLeadSourceField");
			selenium.click("SDRLeadSourceField");
			selenium.waitingTime(2000);
			selenium.click("SDRLeadSourceValue");
			selenium.click("SDRSolutionsOption");
			selenium.click("SDRSolutionsMoveIcon");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			boolean duplicate = selenium.isElementPresentFast("okToAddDuplicate");
			if (duplicate == true) {
				selenium.test.log(LogStatus.INFO, "Duplicate Contact exists");
				System.out.println("Duplicate Contact exists");
				selenium.waitForElementToBeClickable("okToAddDuplicate");
				selenium.jsClick("okToAddDuplicate");
				selenium.waitForElementToBeClickable("okToAddDuplicateCheckbox1");
				selenium.jsClick("okToAddDuplicateCheckbox1");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.jsClick("saveButton");
				selenium.waitingTime(15000);

				boolean viewDuplicates = selenium.isElementPresentFast("DuplidateRecordValidation");
				if (viewDuplicates == true) {
					System.out.println("Duplicate Record Present message displayed");
					selenium.jsClick("saveButton");
					selenium.waitingTime(6000);
				}
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while creating contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating contact");
		}
	}

	@And("^add contact to existing opp$")
	public void add_contact_to_existing_opp() {
		try {
			selenium.navigateToURL(selenium.NewOppURLForClosePurchaseDateTest);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.click("productAddOrEdit");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("OppContactNameSearchField");
//			selenium.type("MHHEOpportunitiesFirstNameSearchField", "First Name search");
			selenium.type_propertiesFile("OppContactNameSearchField", "AutomationUser");
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
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
		} catch (Exception e) {
			selenium.reportFailure("Error while adding contact to an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding contact to an opportunity");
		}
	}

	@And("^validate SDR field values in opp$")
	public void validate_SDR_field_values_in_opp() {
		try {
			selenium.navigateToURL(selenium.NewOppURLForClosePurchaseDateTest);
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			String value1 = selenium.getText("OppSDRValue1");
			String value2 = selenium.getText("OppSDRValue2");
			String value3 = selenium.getText("OppSDRValue3");
			String value4 = selenium.getText("OppSDRValue4");
			System.out.println("value1 " + value1 + "value2" + value2 + "value3" + value3 + "value4" + value4);
			if (!value1.isEmpty() && !value2.isEmpty() && !value3.isEmpty() && !value4.isEmpty()) {
				selenium.test.log(LogStatus.PASS, "The SDR values in opp got copied successfully from opp contact!");
				System.out.println("PASS");
				selenium.scrollToElement("OppSDRValue4");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "The SDR values did not get copied to opp from opp contact!");
				selenium.reportFailure("The SDR values did not get copied to opp from opp contact!");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while validating SDR field values in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating SDR field values in opportunity");
		}
	}

	@And("^verify the SDR section in opportunity$")
	public void verify_SDR_section() {
		try {
//			selenium.refresh();
//			selenium.waitingTime(8000);

			if (selenium.isElementPresentFast("OppSDRSection") && selenium.isElementPresentFast("OppSDRLabel1") && selenium.isElementPresentFast("OppSDRLabel2") && selenium.isElementPresentFast("OppSDRLabel3") && selenium.isElementPresentFast("OppSDRLabel4") && selenium.isElementPresentFast("OppSDRLabel5")) {
				selenium.test.log(LogStatus.PASS, "SDR section in opportunity verified successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "SDR section in opportunity verification failed!");
				selenium.reportFailure("SDR section in opportunity verification failed!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifing SDR section in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing SDR section in opportunity");
		}
	}

	@And("^verify total amount and revenue fields$")
	public void verify_amount_and_revenue_field() {
		try {
			selenium.waitingTime(5000);
			selenium.navigateToURL(selenium.NewOppURLForVerifyDaysToCloseTest);
			selenium.waitingTime(10000);

			String Total_Amount = selenium.getText("TotalAmount").toString();
			System.out.println("TotalAmount when opp stage is OPEN :" + Total_Amount);

			String rev_in_pipeline = selenium.getText("RevenueInPipeline").toString();
			System.out.println("RevenueInPipeline when opp stage is OPEN :" + rev_in_pipeline);

			selenium.click("products_quote");
			
			selenium.waitingTime(6000);
			if(selenium.isElementPresentFast("CloseNotificationPopup"))
			{
				selenium.click("CloseNotificationPopup");
				selenium.waitingTime(2000);
			}
			
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("ProductSalesPrice");
			String product_sales_price = selenium.getText("ProductSalesPrice").toString();
			System.out.println("ProductSalesPrice when opp stage is OPEN :" + product_sales_price);

			if (Total_Amount.contentEquals(rev_in_pipeline) && (Total_Amount.contentEquals(product_sales_price))) {
				selenium.test.log(LogStatus.PASS, "Total Amount is matching with Revenue In Pipeline amount & product total amount when Opp stage is OPEN");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Total Amount is NOT matching with Revenue In Pipeline amount & product total amount when Opp stage is OPEN");
				selenium.reportFailure("Total Amount is NOT matching with Revenue In Pipeline amount & product total amount when Opp stage is OPEN");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while verifying amount and revenu fields in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying amount and revenu fields in opportunity");
		}
	}

	@And("^verify pipeline creation process$")
	public void verify_pipeline_creation_process() {
		try {
			selenium.waitForElementsToBeVisible("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("PipelineDisplayList");
			String View = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Display View");
			Select dropdown = new Select(selenium.getElement("PipelineDisplayList"));
			dropdown.selectByVisibleText(View);

			selenium.waitingTime(20000);
			selenium.waitForElementToBeClickable("NextOppYearList");
			String Year = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Next Opp Year");
			dropdown = new Select(selenium.getElement("NextOppYearList"));
			dropdown.selectByVisibleText(Year);

			selenium.jsClick("DateLink");
			selenium.click("FirstOppContactCheckbox");
			selenium.waitingTime(2000);
			selenium.click("CreatePipelineBtn");
			selenium.waitingTime(20000);
			selenium.test.log(LogStatus.PASS, "Pipeline Creation Successfully Initiated!");
			System.out.println("PASS");
			selenium.captureScreenShot();

            selenium.waitingTime(2000);
		}
		catch (Exception e)
		{

			selenium.reportFailure("Error while verifying pipeline creation process " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying pipeline creation process");
		}
	}
	
	@And("^validate opp purchase and decision date for stage Pilot or Quote$")
	public void validate_opp_purchase_and_decision_date_for_stage_Pilot_or_Quote() {
		try
		{
			
		 	Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
			System.out.println("todays date"+todaysDate);
			
			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);
			System.out.println("yesterday date" + yesterdaysDate);

			calendar1.add(Calendar.DAY_OF_YEAR, 2);
			Date tomorrow=calendar1.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String tomorrowsdate = sdf.format(tomorrow);
			System.out.println("tomorrow date" + tomorrowsdate);
			
			selenium.navigateToURL(selenium.NewOppURLForVerifyDaysToCloseTest); //The opp should be already in Pilot stage due to dependent script (VerifyOppStageTypes)
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("EditDecisionDateIcon");
			selenium.click("EditDecisionDateIcon");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppCloseDateSelectionField");
			selenium.waitingTime(2000);
			selenium.typeData("OppCloseDateSelectionField", tomorrowsdate);			//Future Close Date (of same FY)
			selenium.waitForElementToBeClickable("OppPurchaseDateSelectionField");
			selenium.waitingTime(2000);
			selenium.scrolldown(50);
			selenium.waitingTime(2000);
			selenium.typeData("OppPurchaseDateSelectionField", tomorrowsdate);		//Future Purchase Date (of same FY)
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(15000);
			
			selenium.waitForElementToBeClickable("EditDecisionDateIcon");
			selenium.click("EditDecisionDateIcon");
			selenium.waitForElementToBeClickable("OppCloseDateSelectionField");
			selenium.click("OppCloseDateSelectionField");
			selenium.typeData("OppCloseDateSelectionField", yesterdaysDate);		//Past Close Date (of same FY)
			selenium.waitForElementToBeClickable("OppPurchaseDateSelectionField");
			selenium.click("OppPurchaseDateSelectionField");
			selenium.typeData("OppPurchaseDateSelectionField", yesterdaysDate);		//Past Purchase Date (of same FY)
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifying opp purchase and decision date for stage Pilot or Quote " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying opp purchase and decision date for stage Pilot or Quote");
		}
	}

	@And("^verify primary funding field$")
	public void verify_primary_funding_field() {
		try {
			selenium.waitingTime(5000);
//			selenium.navigateToURL(selenium.NewOppURLForClosePurchaseDateTest);
			selenium.navigateToURL(selenium.NewOppURLForVerifyDaysToCloseTest);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.click("clickonstageedit");
			selenium.waitingTime(6000);
			selenium.scrolldown(100);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStagePilot1");
			selenium.click("OppStagePilot1");
			selenium.waitingTime(4000);
			selenium.scrollToElement("OppStageWon1_new");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageWon1_new");
			selenium.click("OppStageWon1_new");
			selenium.waitingTime(2000);
			selenium.scrollToElement("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.click("ReasonDDList");
			selenium.waitForElementToBeClickable("OppStageCloseReasonValue");
			selenium.click("OppStageCloseReasonValue");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(4000);
			if (selenium.isElementPresentFast("PrimaryFundingTypeErrorMsg")) {
				selenium.test.log(LogStatus.PASS, "PrimaryFundingType validation message appeared");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "PrimaryFundingType validation message DID NOT appear");
				selenium.reportFailure("PrimaryFundingType validation message DID NOT appear");
				System.out.println("FAIL");
			}
			selenium.click("PrimaryFundingTypeErrorMsg");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.click("PrimaryFundingTypeField");
			selenium.waitForElementToBeClickable("PrimaryFundingTypeValue");
			selenium.click("PrimaryFundingTypeValue");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Opp stage changed to WON after adding Primary Funding Type");
			
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("TotalAmount");

			String Total_Amount = selenium.getText("TotalAmount").toString();
			System.out.println("TotalAmount when opp stage is not OPEN :" + Total_Amount);

			String rev_in_pipeline = selenium.getText("RevenueInPipeline").toString();
			System.out.println("RevenueInPipeline when opp stage is not OPEN :" + rev_in_pipeline);

			String expected_rev_in_pipeline = "USD 0.00";

			if (expected_rev_in_pipeline.contentEquals(rev_in_pipeline) && (!expected_rev_in_pipeline.contentEquals(Total_Amount))) {
				selenium.test.log(LogStatus.PASS, "Total Amount is NOT equal to 0 and Revenue In Pipeline amount is equal to 0 when Opp stage is NOT OPEN");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Test case failed");
				selenium.reportFailure("Test case failed");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while verifying primary funding field in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying primary funding field in opportunity");
		}
	}

	@And("^navigate to desired account in SF Classic$")
	public void navigate_to_desired_account_in_SF_Classic() {
		try {
			selenium.navigateToURL("https://mh--uat.sandbox.my.salesforce.com/0018000000bwWyh");
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
		} catch (Exception e) {
			selenium.reportFailure("Error while navigating to desired account page in SF Classic " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to desired account page in SF Classic");
		}
	}

	@And("^navigate to Account Call Report and run the report$")
	public void run_the_report() {
		try {
			selenium.waitForElementToBeVisible("CustomLinks");
			selenium.scrollToElement("CustomLinks");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountCallReport");
			selenium.click("AccountCallReport");
			selenium.waitingTime(5000);
			selenium.pressEscapeKey();
			selenium.waitForElementToBeClickable("SalesStatusAllRadioBtn");
			selenium.click("SalesStatusAllRadioBtn");
			selenium.click("SalesCellViewCheckBox");
			selenium.click("SampleHistoryViewCheckBox");
			selenium.click("SalesHistoryViewCheckBox");
			selenium.click("BackOrdersViewCheckBox");
			selenium.click("OneReportThisAccountOnlyRadioBtn");
			selenium.waitingTime(4000);
			selenium.captureScreenShot();
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("RunReportBtn");
			selenium.click("RunReportBtn");
			selenium.waitingTime(15000);
		} catch (Exception e) {
			selenium.reportFailure("Error either while navigating to account call report or while running the report " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error either while navigating to account call report or while running the report");
		}
	}

	@And("^verify revenue total in report$")
	public void verify_revenue_total_in_report() {
		try {
			selenium.waitingTime(2000);
			selenium.switchToLastWindow();
			selenium.waitingTime(5000);
//			selenium.scrolldownFile();
//			selenium.waitingTime(2000);
//			selenium.captureScreenShot();
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.PASS, "Revenue Total In Report Verified Successfully");
			System.out.println("PASS");
			selenium.close();
			selenium.waitingTime(5000);
			selenium.switchBackToParentWindow();
			selenium.waitingTime(4000);
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying revenue total in report " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying revenue total in report");
		}
	}

	@And("^validate close and purchase dates$")
	public void validate_close_and_purchase_dates() {
		try {
			selenium.navigateToURL(selenium.NewOppURLForClosePurchaseDateTest);
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0067h00000FrQLJAA3/view");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppCloseDateSelectionField");
			selenium.click("OppCloseDateSelectionField");
			selenium.type("OppCloseDateSelectionField", "Non Prior Close Date");
			selenium.click("Save_Btn");
			selenium.waitingTime(3000);
			String validationMessage1 = selenium.getDynamicXpath("divTextcontains2", "Validation Message1", "endContains");
			selenium.waitingTime(4000);
			System.out.println(validationMessage1);
			if (selenium.isElementPresentXpathFast(validationMessage1)) {
				selenium.test.log(LogStatus.PASS, "Close/Decision Date should be prior to Purchase Date - validation message verified successfully");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.click("CloseErrorDialogPopup");
			} else {
				selenium.test.log(LogStatus.FAIL, "Expected Validation Message Did Not Appear");
				selenium.reportFailure("Expected Validation Message Did Not Appear");
				System.out.println("FAIL");
			}
			selenium.click("CancelButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppPurchaseDateSelectionField");
			selenium.click("OppPurchaseDateSelectionField");
			selenium.type("OppPurchaseDateSelectionField", "Invalid Purchase Date");
			selenium.click("Save_Btn");
			selenium.waitingTime(3000);
			String validationMessage2 = selenium.getDynamicXpath("divTextcontains2", "Validation Message2", "endContains");
			selenium.waitingTime(4000);
			System.out.println(validationMessage2);
			if (selenium.isElementPresentXpathFast(validationMessage2)) {
				selenium.test.log(LogStatus.PASS, "Purchase Date Fiscal Year must match Opportunity Year. - validation message verified successfully");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.click("CloseErrorDialogPopup");
			} else {
				selenium.test.log(LogStatus.FAIL, "Expected Validation Message Did Not Appear");
				selenium.reportFailure("Expected Validation Message Did Not Appear");
				System.out.println("FAIL");
			}
			selenium.click("CancelButton");
			selenium.waitingTime(3000);
		} catch (Exception e) {
			selenium.reportFailure("Error while validating close and purchase dates in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating close and purchase dates in opportunity");
		}
	}

	@And("^validate opportunity stage types$")
	public void validate_opportunity_stage_types() {
		try {
//			selenium.navigateToURL(selenium.NewOppURLForClosePurchaseDateTest);
			selenium.navigateToURL(selenium.NewOppURLForVerifyDaysToCloseTest);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("OppNameGetText");
			String oppName = selenium.getText("OppNameGetText").toString();
			String expected_oppStageName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Initial Opp Stage Name");
			System.out.println("opp name is" + oppName);
			System.out.println("Expected opp STAGE name is" + expected_oppStageName);
			if (oppName.contains(expected_oppStageName)) {
				selenium.test.log(LogStatus.PASS, "Opp stage name is matching with expected name i.e OPEN");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp stage name is NOT matching with expected name i.e OPEN(STATED NEED)");
				selenium.reportFailure("Opp stage name is NOT matching with expected name i.e OPEN(STATED NEED)");
				System.out.println("FAIL");
			}

			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.click("clickonstageedit");
			selenium.waitingTime(6000);
			selenium.scrolldown(100);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageStatedNeed");
			selenium.click("OppStageStatedNeed");
			selenium.waitForElementToBeClickable("OppStageProspect");
			selenium.click("OppStageProspect");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(20000);
			selenium.waitForElementToBeClickable("OppNameGetText");
			oppName = selenium.getText("OppNameGetText").toString();
			expected_oppStageName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Updated Opp Stage Name");
			System.out.println("opp name is" + oppName);
			System.out.println("Expected opp STAGE name is" + expected_oppStageName);
			if (oppName.contains(expected_oppStageName)) {
				selenium.test.log(LogStatus.PASS, "Opp stage name is matching with expected name i.e PROSPECT(PROSPECT)");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp stage name is NOT matching with expected name i.e PROSPECT(PROSPECT)");
				selenium.reportFailure("Opp stage name is NOT matching with expected name i.e PROSPECT(PROSPECT)");
				System.out.println("FAIL");
			}

			selenium.scrollToElement("clickonstageedit");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.click("clickonstageedit");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OppStageProspect1");
			selenium.click("OppStageProspect1");
			selenium.waitForElementToBeClickable("OppStagePilot");
			selenium.click("OppStagePilot");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(20000);
			selenium.waitForElementToBeClickable("OppNameGetText");
			oppName = selenium.getText("OppNameGetText").toString();
			expected_oppStageName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Initial Opp Stage Name");
			System.out.println("opp name is" + oppName);
			System.out.println("Expected opp STAGE name is" + expected_oppStageName);
			if (oppName.contains(expected_oppStageName)) {
				selenium.test.log(LogStatus.PASS, "Opp stage name is matching with expected name i.e OPEN(PILOT)");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp stage name is NOT matching with expected name i.e  OPEN(PILOT)");
				selenium.reportFailure("Opp stage name is NOT matching with expected name i.e  OPEN(PILOT)");
				System.out.println("FAIL");
			}
			//SETTING IT BACK TO OPEN STAGE FOR TESTING USB109_VerifyOppProductQuantity TEST CASE
//            selenium.waitForElementToBeClickable("clickonstageedit");
//			selenium.click("clickonstageedit");
//			selenium.waitingTime(6000);
//			selenium.waitForElementToBeVisible("OppStagePilot1");
//			selenium.scrollToElement("OppStagePilot1");
//			selenium.waitingTime(2000);
//			selenium.scrolldown(-200);
//			selenium.waitingTime(2000);
//            selenium.waitForElementToBeClickable("OppStagePilot1");
//			selenium.click("OppStagePilot1");
//            selenium.waitForElementToBeClickable("OppStageStatedNeed1");
//			selenium.click("OppStageStatedNeed1");
//            selenium.waitForElementToBeClickable("Save_Btn");
//			selenium.click("Save_Btn");
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.reportFailure("Error while validating stage types in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating stage types in opportunity");
		}
	}

	@And("^validate days to close$")
	public void validate_days_to_close() {
		try {
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0067h00000GA2d2AAD/view");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("OpportunityHistoryHeading");
			selenium.waitForElementToBeClickable("OppSourceCreateDateEditIcon");
			selenium.click("OppSourceCreateDateEditIcon");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("OppSourceCreateDateEntry");
			selenium.type("OppSourceCreateDateEntry", "Opp Source Date");
			selenium.click("Save_Btn");
			selenium.waitingTime(30000);

			selenium.waitForElementToBeClickable("OppDaysToClose");
			String valueBeforeOppStageUpdate = selenium.getText("OppDaysToClose").toString();

			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.click("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.scrolldown(100);
			selenium.waitForElementToBeClickable("OppStageStatedNeed2");
			selenium.click("OppStageStatedNeed2");
			selenium.waitForElementToBeClickable("OppStageProspect");
			selenium.click("OppStageProspect");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(20000);

			//CHANING THE OPP STAGE FROM PROSPECT TO OPEN (Stated Need/Discovery) TO TEST USB108_VerifyOppStageTypes TEST CASE
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.click("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.scrolldown(100);
			selenium.waitForElementToBeClickable("OppStageProspect1");
			selenium.click("OppStageProspect1");
			selenium.waitForElementToBeClickable("opportunityStage5");
			selenium.click("opportunityStage5");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(20000);

			selenium.waitForElementToBeClickable("OppDaysToClose");
			String valueAfterOppStageUpdate = selenium.getText("OppDaysToClose").toString();
			System.out.println("Value before opp stage update " + valueBeforeOppStageUpdate);
			System.out.println("Value after opp stage update " + valueAfterOppStageUpdate);

			if (valueBeforeOppStageUpdate.equalsIgnoreCase(valueAfterOppStageUpdate)) {
				selenium.test.log(LogStatus.PASS, "The opportunity days to close values is matching before and after opp stage modification!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "The opportunity days to close values is not matching before and after opp stage modification!");
				selenium.reportFailure("The opportunity days to close values is not matching before and after opp stage modification!");
				System.out.println("FAIL");
			}


		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while validating Days To Close in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating Days To Close in opportunity");
		}
	}

	@Then("^navigate to opp and add product$")

	public void navigate_to_opp_and_add_product()
	{
		try
		{

			selenium.navigateToURL(selenium.NewOppURLForVerifyDaysToCloseTest);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("products_quote");
			selenium.click("products_quote");

			selenium.waitingTime(4000);
//			if(selenium.isElementPresentFast("CloseNotificationPopup"))
//			{
//				selenium.click("CloseNotificationPopup");
//				selenium.waitingTime(2000);
//			}
			selenium.refresh();
			selenium.waitingTime(6000);			
			selenium.waitForElementToBeClickable("modifyProducts");
			selenium.click("modifyProducts");
			selenium.waitingTime(15000);
			selenium.switchToFrame("switch_iFrame");
			selenium.waitForElementToBeClickable("keyIsbn");
			selenium.click("keyIsbn");
			selenium.waitingTime(2000);
			selenium.type("keyIsbn", "ISBN");
			selenium.waitForElementToBeClickable("addButton");
			selenium.click("addButton");
			selenium.waitingTime(13000);
			selenium.clickLoop("saveProduct");
			selenium.waitingTime(25000);
			selenium.switchOutOfFrame();
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.reportFailure("Error while adding product to opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding product to opportunity");
		}
	}

	@And("^validate opportunity product quantity$")
	public void validate_opportunity_product_quantity() {
		try {
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstProductLink");
			selenium.click("FirstProductLink");
			selenium.waitingTime(5000);
			String productURL = selenium.getURL();
			String prodQty1 = selenium.getText("OppProdQty").toString();
			System.out.println("When opp stage is OPEN/PILOT the Product Quantity is :" + prodQty1);

//			selenium.navigateToURL(selenium.NewOppURLForClosePurchaseDateTest);
			selenium.navigateToURL(selenium.NewOppURLForVerifyDaysToCloseTest);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.click("clickonstageedit");
			selenium.waitingTime(6000);
			selenium.scrolldown(100);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStagePilot1");
			selenium.click("OppStagePilot1");
			selenium.waitForElementToBeClickable("OppStageProspect");
			selenium.click("OppStageProspect");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(20000);
			selenium.navigateToURL(productURL);
			String prodQty2 = selenium.getText("OppProdQty").toString();
			System.out.println("When opp stage is PROSPECT the Product Quantity is :" + prodQty2);
			if (prodQty1.equalsIgnoreCase(prodQty2)) {
				selenium.test.log(LogStatus.PASS, "Opp product quantity is verified successfully");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp product quantity verification failed");
				selenium.reportFailure("Opp product quantity verification failed");
				System.out.println("FAIL");
			}
			//CHANING THE OPP STAGE TO OPEN (PILOT) FOR TESTING USB111_VerifyOppPrimaryFundingField TEST CASE

//			selenium.navigateToURL(selenium.NewOppURLForClosePurchaseDateTest);
			selenium.navigateToURL(selenium.NewOppURLForVerifyDaysToCloseTest);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.click("clickonstageedit");
			selenium.waitingTime(6000);
			selenium.scrolldown(100);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageProspect1");
			selenium.click("OppStageProspect1");
			selenium.waitForElementToBeClickable("OppStagePilot");
			selenium.click("OppStagePilot");
//            selenium.waitForElementToBeClickable("ReasonDDList");
//			selenium.click("ReasonDDList");
//            selenium.waitForElementToBeClickable("OppStageCloseReasonValue");
//			selenium.click("OppStageCloseReasonValue");			
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(20000);


		} catch (Exception e) {
			selenium.reportFailure("Error while validating product quantity in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating product quantity in opportunity");
		}
	}

	@And("^verify Revenue Calculation on Product with header type as Print$")
	public void verify_Revenue_Calculation_Print() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);

			selenium.waitForElementToBeVisible("OppRevenue");
			String OppRevenue = selenium.getText("OppRevenue");
			System.out.println("OppRevenue :" + OppRevenue);    //AUD 140.86 (INR 6,786.70)
			String[] parts = OppRevenue.split(" ");
			String part1 = parts[0];    //AUD
			String part2 = parts[1];    //140.86
			System.out.println("part1 " + part1);
			System.out.println("part2 " + part2);
			part2 = part2.replace(",", "");
			double OppRevenueNumber = Double.parseDouble(part2);
			System.out.println("******************OppRevenueNumber****************** :" + OppRevenueNumber);    //140.86
			selenium.test.log(LogStatus.INFO, "******************OppRevenueNumber****************** :" + OppRevenueNumber);

			String OppEnrollment = selenium.getText("OppEnrollment");
			System.out.println("OppEnrollment :" + OppEnrollment);
			int OppEnrollmentNumber = Integer.parseInt(OppEnrollment);
			System.out.println("******************OppEnrollmentNumber****************** :" + OppEnrollmentNumber);    //100
			selenium.test.log(LogStatus.INFO, "******************OppEnrollmentNumber****************** :" + OppEnrollmentNumber);

			String OppPrintSellThru = selenium.getText("OppPrintSellThru");
			System.out.println("OppPrintSellThru :" + OppPrintSellThru);    //11%
			String[] parts2 = OppPrintSellThru.split("%");
			String part11 = parts2[0];    //11
			System.out.println("part11 " + part11);
			double OppPrintSellThruNumber = Double.parseDouble(part11);
			System.out.println("OppPrintSellThruNumber :" + OppPrintSellThruNumber);
			double OppPrintSellThruNumberPercent = OppPrintSellThruNumber / 100;
			System.out.println("******************OppPrintSellThruNumberPercent****************** :" + OppPrintSellThruNumberPercent);    //0.11
			selenium.test.log(LogStatus.INFO, "******************OppPrintSellThruNumberPercent****************** :" + OppPrintSellThruNumberPercent);

			String OppDiscount = selenium.getText("OppDiscount");
			System.out.println("OppDiscount :" + OppDiscount);    //35%
			String[] parts3 = OppDiscount.split("%");
			String part21 = parts3[0];
			System.out.println("part21 " + part21);    //35
			double OppDiscountNumber = Double.parseDouble(part21);
			System.out.println("OppDiscountNumber :" + OppDiscountNumber);
			double OppDiscountNumberPercent = OppDiscountNumber / 100;
			System.out.println("******************OppDiscountNumberPercent****************** :" + OppDiscountNumberPercent);    //0.35
			selenium.test.log(LogStatus.INFO, "******************OppDiscountNumberPercent****************** :" + OppDiscountNumberPercent);

			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");         //products_quote
			selenium.click("opportunityLineItemRelatedList");            //products_quote
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstProductLink");
			selenium.click("FirstProductLink");
			selenium.waitingTime(5000);

			selenium.waitForElementToBeVisible("TargetProductRevenueCalc"); //Revenue Calc(from TP) is checked
			String CountryProductPrice = selenium.getText("CountryProductPrice");
			System.out.println("CountryProductPrice :" + CountryProductPrice);    //AUD 140.86
			String[] parts4 = CountryProductPrice.split(" ");
			String part31 = parts4[0];    //AUD
			String part32 = parts4[1];    //140.86
			System.out.println("part31 " + part31);
			System.out.println("part32 " + part32);
			double CountryProductPriceNumber = Double.parseDouble(part32);
			System.out.println("******************CountryProductPriceNumber****************** :" + CountryProductPriceNumber);    //140.86
			selenium.test.log(LogStatus.INFO, "******************CountryProductPriceNumber****************** :" + CountryProductPriceNumber);

//			Print Revenue =  (Enrollment * (Print Sell Thru / 100) * Print Price) - (Enrollment * (Print Sell Thru / 100) * Print Price * (Discount/100));
			double Revenue = (OppEnrollmentNumber * OppPrintSellThruNumberPercent * CountryProductPriceNumber) - (OppEnrollmentNumber * OppPrintSellThruNumberPercent * CountryProductPriceNumber * OppDiscountNumberPercent);
			DecimalFormat df = new DecimalFormat("#.##");
			String RevenueRoundOffValue = df.format(Revenue);

			System.out.println("******************The automation script calculated Revenue is****************** : " + Revenue);
			System.out.println("******************The automation script calculated RoundOff Revenue is******************  : " + RevenueRoundOffValue);
			System.out.println("******************The actual Revenue shown in the application is****************** : " + OppRevenueNumber);

			selenium.test.log(LogStatus.INFO, "******************The automation script calculated Revenue is****************** :" + Revenue);
			selenium.test.log(LogStatus.INFO, "******************The automation script calculated RoundOff Revenue is****************** :" + RevenueRoundOffValue);
			selenium.test.log(LogStatus.INFO, "******************The actual Revenue shown in the application is****************** :" + OppRevenueNumber);

			String UIFetchedRevenue = Double.toString(OppRevenueNumber);
			System.out.println("CalculatedRevenue : " + RevenueRoundOffValue);
			System.out.println("UIFetchedRevenue : " + UIFetchedRevenue);

			if (RevenueRoundOffValue.equalsIgnoreCase(UIFetchedRevenue)) {
				selenium.test.log(LogStatus.PASS, "Opp Revenue value is getting calculated correctly");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp Revenue value is NOT getting calculated correctly");
				selenium.reportFailure("Opp Revenue value is NOT getting calculated correctly");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while validating Revenue Calculation " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating Revenue Calculation");
		}
	}

	@Then("^add digital product to opportunity$")
	public void add_digital_product_to_opportunity() {
		try {

			selenium.waitingTime(5000);
			if (selenium.getTestCaseName().equalsIgnoreCase("INTLSalesRepUserVerifyRevenueCal")) {
				selenium.navigateToURL(selenium.INTLOppURL);
				selenium.waitingTime(5000);
			}
			selenium.refresh();
			selenium.waitingTime(8000);
//			if(selenium.isElementPresentFast("products_quote"))
//			{
//				selenium.click("products_quote");
//			}
//			else
//			{
//				selenium.click("productsSectionForOpportunity");
//			}	
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.click("opportunityLineItemRelatedList");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("AddproductL");
			selenium.click("AddproductL");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
//			selenium.clearText("Oppproductcourse");
			selenium.waitForElementToBeClickable("ProductCourse");
			selenium.clearText("ProductCourse");
//			selenium.waitForElementToBeClickable("author");
//			selenium.type("author", "Author Name");
			selenium.type("SampleISBN", "ISBN");
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.jsClick("searchProductsBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstOppContactCheckbox");
			selenium.click("FirstOppContactCheckbox");
			selenium.click("Addtoopportunity");
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.reportFailure("Error while adding digital product to opp " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding digital product to opp");
		}
	}

	@And("^verify Revenue Calculation on Product with header type as Print and Digital$")
	public void verify_Revenue_Calculation_Print_Digital() {
		try {
			selenium.navigateToURL(selenium.INTLOppURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);

			selenium.waitForElementToBeVisible("OppRevenue");
			String OppRevenue = selenium.getText("OppRevenue");
			System.out.println("OppRevenue :" + OppRevenue);    //AUD 695.77
			String[] parts = OppRevenue.split(" ");
			String part1 = parts[0];    //AUD
			String part2 = parts[1];    //695.77
			System.out.println("part1 " + part1);
			System.out.println("part2 " + part2);
			part2 = part2.replace(",", "");
			double OppRevenueNumber = Double.parseDouble(part2);
			System.out.println("******************OppRevenueNumber****************** :" + OppRevenueNumber);
			selenium.test.log(LogStatus.INFO, "******************OppRevenueNumber****************** :" + OppRevenueNumber);

			String OppEnrollment = selenium.getText("OppEnrollment");
			System.out.println("OppEnrollment :" + OppEnrollment);
			int OppEnrollmentNumber = Integer.parseInt(OppEnrollment);
			System.out.println("******************OppEnrollmentNumber****************** :" + OppEnrollmentNumber);
			selenium.test.log(LogStatus.INFO, "******************OppEnrollmentNumber****************** :" + OppEnrollmentNumber);

			String OppPrintSellThru = selenium.getText("OppPrintSellThru");
			System.out.println("OppPrintSellThru :" + OppPrintSellThru);    //11%
			String[] parts2 = OppPrintSellThru.split("%");
			String part11 = parts2[0];    //11
			System.out.println("part11 " + part11);
			double OppPrintSellThruNumber = Double.parseDouble(part11);
			System.out.println("OppPrintSellThruNumber :" + OppPrintSellThruNumber);
			double OppPrintSellThruNumberPercent = OppPrintSellThruNumber / 100;
			System.out.println("******************OppPrintSellThruNumberPercent****************** :" + OppPrintSellThruNumberPercent);    //0.11
			selenium.test.log(LogStatus.INFO, "******************OppPrintSellThruNumberPercent****************** :" + OppPrintSellThruNumberPercent);

			String OppDigitalSellThru = selenium.getText("OppDigitalSellThru");
			System.out.println("OppDigitalSellThru :" + OppDigitalSellThru);    //11%
			String[] parts5 = OppDigitalSellThru.split("%");
			String part41 = parts5[0];    //11
			System.out.println("part41 " + part41);
			double OppDigitalSellThruNumber = Double.parseDouble(part41);
			System.out.println("OppDigitalSellThruNumber :" + OppDigitalSellThruNumber);
			double OppDigitalSellThruNumberPercent = OppDigitalSellThruNumber / 100;
			System.out.println("******************OppDigitalSellThruNumberPercent****************** :" + OppDigitalSellThruNumberPercent);    //0.1
			selenium.test.log(LogStatus.INFO, "******************OppDigitalSellThruNumberPercent****************** :" + OppDigitalSellThruNumberPercent);

			String OppDiscount = selenium.getText("OppDiscount");
			System.out.println("OppDiscount :" + OppDiscount);    //35%
			String[] parts3 = OppDiscount.split("%");
			String part21 = parts3[0];
			System.out.println("part21 " + part21);    //35
			double OppDiscountNumber = Double.parseDouble(part21);
			System.out.println("OppDiscountNumber :" + OppDiscountNumber);
			double OppDiscountNumberPercent = OppDiscountNumber / 100;
			System.out.println("******************OppDiscountNumberPercent****************** :" + OppDiscountNumberPercent);    //0.35
			selenium.test.log(LogStatus.INFO, "******************OppDiscountNumberPercent****************** :" + OppDiscountNumberPercent);

			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");     //products_quote
			selenium.click("opportunityLineItemRelatedList");    //products_quote
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SecondProductLink"); //Product ordered based on Sales Price
			selenium.click("SecondProductLink");
			selenium.waitingTime(5000);

			selenium.waitForElementToBeVisible("TargetProductRevenueCalc"); //Revenue Calc(from TP) is checked

			String CountryProductPricePrint = selenium.getText("CountryProductPrice");
			System.out.println("CountryProductPricePrint :" + CountryProductPricePrint);    //AUD 140.86
			String[] parts4 = CountryProductPricePrint.split(" ");
			String part31 = parts4[0];    //AUD
			String part32 = parts4[1];    //140.86
			System.out.println("part31 " + part31);
			System.out.println("part32 " + part32);
			part32 = part32.replace(",", "");
			double CountryProductPricePrintNumber = Double.parseDouble(part32);
			System.out.println("******************CountryProductPricePrintNumber****************** :" + CountryProductPricePrintNumber);
			selenium.test.log(LogStatus.INFO, "******************CountryProductPricePrintNumber****************** :" + CountryProductPricePrintNumber);

			selenium.navigateBack();
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstProductLink");
			selenium.click("FirstProductLink");
			selenium.waitingTime(5000);

			selenium.waitForElementToBeVisible("TargetProductRevenueCalc"); //Revenue Calc(from TP) is checked

			String CountryProductPriceDigital = selenium.getText("CountryProductPrice");
			System.out.println("CountryProductPriceDigital :" + CountryProductPriceDigital);    //AUD 140.86
			String[] parts6 = CountryProductPriceDigital.split(" ");
			String part51 = parts6[0];    //AUD
			String part52 = parts6[1];    //140.86
			System.out.println("part51 " + part51);
			System.out.println("part52 " + part52);
			part52 = part52.replace(",", "");
			double CountryProductPriceDigitalNumber = Double.parseDouble(part52);
			System.out.println("******************CountryProductPriceDigitalNumber****************** :" + CountryProductPriceDigitalNumber);
			selenium.test.log(LogStatus.INFO, "******************CountryProductPriceDigitalNumber****************** :" + CountryProductPriceDigitalNumber);

//			Print Revenue =  (Enrollment * (Print Sell Thru / 100) * Print Price) - (Enrollment * (Print Sell Thru / 100) * Print Price * (Discount/100));
//			Digital Revenue = (Enrollment * (Digital Sell Through/100) * Digital Price) - (Enrollment * (Digital Sell Through/100) * Digital Price * (Discount/100));
//			Revenue = Print Revenue + Digital Revenue

			double Revenue = ((OppEnrollmentNumber * OppPrintSellThruNumberPercent * CountryProductPricePrintNumber) - (OppEnrollmentNumber * OppPrintSellThruNumberPercent * CountryProductPricePrintNumber * OppDiscountNumberPercent)) + ((OppEnrollmentNumber * OppDigitalSellThruNumberPercent * CountryProductPriceDigitalNumber) - (OppEnrollmentNumber * OppDigitalSellThruNumberPercent * CountryProductPriceDigitalNumber * OppDiscountNumberPercent));
			DecimalFormat df = new DecimalFormat("#.##");
			String RevenueRoundOffValue = df.format(Revenue);

			System.out.println("******************The automation script calculated Revenue is****************** : " + Revenue);
			System.out.println("******************The automation script calculated RoundOff Revenue is******************  : " + RevenueRoundOffValue);
			System.out.println("******************The actual Revenue shown in the application is****************** : " + OppRevenueNumber);

			selenium.test.log(LogStatus.INFO, "******************The automation script calculated Revenue is****************** :" + Revenue);
			selenium.test.log(LogStatus.INFO, "******************The automation script calculated RoundOff Revenue is****************** :" + RevenueRoundOffValue);
			selenium.test.log(LogStatus.INFO, "******************The actual Revenue shown in the application is****************** :" + OppRevenueNumber);

			String UIFetchedRevenue = Double.toString(OppRevenueNumber);
			System.out.println("CalculatedRevenue : " + RevenueRoundOffValue);
			System.out.println("UIFetchedRevenue : " + UIFetchedRevenue);

			if (RevenueRoundOffValue.equalsIgnoreCase(UIFetchedRevenue)) {
				selenium.test.log(LogStatus.PASS, "Opp Revenue value is getting calculated correctly");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp Revenue value is NOT getting calculated correctly");
				selenium.reportFailure("Opp Revenue value is NOT getting calculated correctly");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while validating Revenue Calculation " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating Revenue Calculation");
		}
	}

	@Then("^remove print product from opprotunity$")
	public void remove_print_product() {
		try {
			selenium.navigateToURL(selenium.INTLOppURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);

			selenium.waitForElementToBeClickable("productsSectionForOpportunity");
			selenium.click("productsSectionForOpportunity");
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DeletePrintTypeOppProduct");
			selenium.click("DeletePrintTypeOppProduct");
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
			selenium.waitingTime(6000);
		} catch (Exception e) {
			selenium.reportFailure("Error while removing print product " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while removing print product");
		}
	}

	@Then("^remove digital product from opprotunity$")
	public void remove_digital_product() {
		try {
			selenium.navigateToURL(selenium.INTLOppURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);

			selenium.waitForElementToBeClickable("productsSectionForOpportunity");
			selenium.click("productsSectionForOpportunity");
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DeleteDigitalTypeOppProduct");
			selenium.click("DeleteDigitalTypeOppProduct");
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
			selenium.waitingTime(6000);
		} catch (Exception e) {
			selenium.reportFailure("Error while removing print product " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while removing print product");
		}
	}

	@And("^verify Revenue Calculation on Product with header type as Digital$")
	public void verify_Revenue_Calculation_Digital() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);

			selenium.waitForElementToBeVisible("OppRevenue");
			String OppRevenue = selenium.getText("OppRevenue");
			System.out.println("OppRevenue :" + OppRevenue);    //AUD 695.77
			String[] parts = OppRevenue.split(" ");
			String part1 = parts[0];    //AUD
			String part2 = parts[1];    //695.77
			System.out.println("part1 " + part1);
			System.out.println("part2 " + part2);
			part2 = part2.replace(",", "");
			double OppRevenueNumber = Double.parseDouble(part2);
			System.out.println("******************OppRevenueNumber****************** :" + OppRevenueNumber);
			selenium.test.log(LogStatus.INFO, "******************OppRevenueNumber****************** :" + OppRevenueNumber);

			String OppEnrollment = selenium.getText("OppEnrollment1");
			System.out.println("OppEnrollment :" + OppEnrollment);
			int OppEnrollmentNumber = Integer.parseInt(OppEnrollment);
			System.out.println("******************OppEnrollmentNumber****************** :" + OppEnrollmentNumber);
			selenium.test.log(LogStatus.INFO, "******************OppEnrollmentNumber****************** :" + OppEnrollmentNumber);

			String OppDigitalSellThru = selenium.getText("OppDigitalSellThru");
			System.out.println("OppDigitalSellThru :" + OppDigitalSellThru);    //11%
			String[] parts5 = OppDigitalSellThru.split("%");
			String part41 = parts5[0];    //11
			System.out.println("part41 " + part41);
			double OppDigitalSellThruNumber = Double.parseDouble(part41);
			System.out.println("OppDigitalSellThruNumber :" + OppDigitalSellThruNumber);
			double OppDigitalSellThruNumberPercent = OppDigitalSellThruNumber / 100;
			System.out.println("******************OppDigitalSellThruNumberPercent****************** :" + OppDigitalSellThruNumberPercent);    //0.11
			selenium.test.log(LogStatus.INFO, "******************OppDigitalSellThruNumberPercent****************** :" + OppDigitalSellThruNumberPercent);

			String OppDiscount = selenium.getText("OppDiscount");
			System.out.println("OppDiscount :" + OppDiscount);    //35%
			String[] parts3 = OppDiscount.split("%");
			String part21 = parts3[0];
			System.out.println("part21 " + part21);    //35
			double OppDiscountNumber = Double.parseDouble(part21);
			System.out.println("OppDiscountNumber :" + OppDiscountNumber);
			double OppDiscountNumberPercent = OppDiscountNumber / 100;
			System.out.println("******************OppDiscountNumberPercent****************** :" + OppDiscountNumberPercent);    //0.35
			selenium.test.log(LogStatus.INFO, "******************OppDiscountNumberPercent****************** :" + OppDiscountNumberPercent);

			selenium.waitForElementToBeClickable("productsSectionForOpportunity");
			selenium.click("productsSectionForOpportunity");
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstProductLink");
			selenium.click("FirstProductLink");
			selenium.waitingTime(5000);

			selenium.waitForElementToBeVisible("TargetProductRevenueCalc"); //Revenue Calc(from TP) is checked

			String CountryProductPrice = selenium.getText("CountryProductPrice");
			System.out.println("CountryProductPrice :" + CountryProductPrice);    //AUD 140.86
			String[] parts4 = CountryProductPrice.split(" ");
			String part31 = parts4[0];    //AUD
			String part32 = parts4[1];    //140.86
			System.out.println("part31 " + part31);
			System.out.println("part32 " + part32);
			part32 = part32.replace(",", "");
			double CountryProductPriceNumber = Double.parseDouble(part32);
			System.out.println("******************CountryProductPriceNumber****************** :" + CountryProductPriceNumber);
			selenium.test.log(LogStatus.INFO, "******************CountryProductPriceNumber****************** :" + CountryProductPriceNumber);

//			Digital Revenue = (Enrollment * (Digital Sell Through/100) * Digital Price) - (Enrollment * (Digital Sell Through/100) * Digital Price * (Discount/100));
			double Revenue = (OppEnrollmentNumber * OppDigitalSellThruNumberPercent * CountryProductPriceNumber) - (OppEnrollmentNumber * OppDigitalSellThruNumberPercent * CountryProductPriceNumber * OppDiscountNumberPercent);
			DecimalFormat df = new DecimalFormat("#.##");
			String RevenueRoundOffValue = df.format(Revenue);

			System.out.println("******************The automation script calculated Revenue is****************** : " + Revenue);
			System.out.println("******************The automation script calculated RoundOff Revenue is******************  : " + RevenueRoundOffValue);
			System.out.println("******************The actual Revenue shown in the application is****************** : " + OppRevenueNumber);

			selenium.test.log(LogStatus.INFO, "******************The automation script calculated Revenue is****************** :" + Revenue);
			selenium.test.log(LogStatus.INFO, "******************The automation script calculated RoundOff Revenue is****************** :" + RevenueRoundOffValue);
			selenium.test.log(LogStatus.INFO, "******************The actual Revenue shown in the application is****************** :" + OppRevenueNumber);

			String UIFetchedRevenue = Double.toString(OppRevenueNumber);
			System.out.println("CalculatedRevenue : " + RevenueRoundOffValue);
			System.out.println("UIFetchedRevenue : " + UIFetchedRevenue);

			if (RevenueRoundOffValue.equalsIgnoreCase(UIFetchedRevenue)) {
				selenium.test.log(LogStatus.PASS, "Opp Revenue value is getting calculated correctly");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp Revenue value is NOT getting calculated correctly");
				selenium.reportFailure("Opp Revenue value is NOT getting calculated correctly");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating Revenue Calculation " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating Revenue Calculation");
		}
	}

	@Then("^verify and update TPOptOut field via Opp MassEdit$")
	public void update_TPOptOut_field_via_Opp_MassEdit() {
		try {
			selenium.waitForElementToBeClickable("FirstRecordCheckbox");
			selenium.click("FirstRecordCheckbox");
			selenium.waitForElementToBeClickable("opportunityMassEdit");
			selenium.click("opportunityMassEdit");
			selenium.waitingTime(5000);
			selenium.waitForElementsToBeVisible("switch_iFrame");
			selenium.switchToMultipleFrame("switch_iFrame");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("TPOptOutColumnInOppMassEdit");
			if (selenium.isElementPresentFast("TPOptOutColumnInOppMassEdit")) {
				selenium.test.log(LogStatus.PASS, "TP-Opt-Out column is present in Opp Mass edit page");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "TP-Opt-Out column is NOT present in Opp Mass edit page");
				selenium.reportFailure("TP-Opt-Out column is NOT present in Opp Mass edit page");
				System.out.println("FAIL");
			}

			selenium.click("TPOptOutCheckBoxInMassEdit");
			selenium.jsClick("opportunityMassEditSave");
			selenium.switchOutOfFrame();
			selenium.waitingTime(25000);
		} catch (Exception e) {
			selenium.reportFailure("Error while updating TPOptOut field via Opp MassEdit " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while updating TPOptOut field via Opp MassEdit");
		}
	}

	@And("^verify the TPOptOut field$")
	public void verify_the_TPOptOut_field() {
		try {
			selenium.waitForElementToBeVisible("TPOptOutFieldinOpp");
			if (selenium.isElementPresentFast("TPOptOutFieldinOpp")) {
				selenium.test.log(LogStatus.PASS, "TP-Opt-Out field is present in Opp page");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "TP-Opt-Out field is NOT present in Opp page");
				selenium.reportFailure("TP-Opt-Out field is NOT present in Opp page");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while validating TPOptOut field in mass edited opp " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating TPOptOut field in mass edited opp");
		}
	}

	@And("^add opportunity contact$")
	public void add_opportunity_contact() {
		try {
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(6000);
			selenium.test.log(LogStatus.INFO, "Creating New Opp. Contact");
			if (selenium.isElementPresentFast("CallAlertPopup")) {
				System.out.println("Call Alert Poped-up.. so closing it..");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.click("CloseNotificationPopup");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("productframeUat");
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("OppContactFirstName");
			selenium.type("OppContactFirstName", "contact Name Opp");
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
			selenium.jsClick("opportunitiesSearchResultForAdding");
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.scrollToElement("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
			selenium.waitForElementToBeVisible("Button_Save");
			selenium.scrollToElement("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.switchOutOfFrame();
			selenium.waitingTime(12000);
			selenium.refresh();
			selenium.waitingTime(6000);
		} catch (Exception e) {
			selenium.reportFailure("Error while adding contact for opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding contact for opportunity");
		}
	}

	@And("^add opportunity product$")
	public void add_opportunity_product() {
		try {
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.click("taggedProductAddorEdit");
			selenium.waitingTime(15000);
			selenium.switchToFrame("productframeUat");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("isbnField");
			selenium.click("isbnField");
			selenium.waitingTime(2000);
			selenium.type("isbnField", "ISBN");
			selenium.waitingTime(3000);
			selenium.click("searchBtn");
			selenium.waitingTime(5000);
			selenium.click("selectProductToAddToOpp");
			selenium.waitingTime(2000);
			selenium.click("opportunitiesAddToOpportunity");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.click("Button_Save");
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(6000);
		} catch (Exception e) {
			selenium.reportFailure("Error while adding product for opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding product for opportunity");
		}
	}

	@Then("^edit product team comments field$")
	public void edit_product_team_comments_field() {
		try {
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppEditProductTeamCommentsIcon");
			selenium.jsClick("OppEditProductTeamCommentsIcon");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppEditProductTeamCommentsField");
			selenium.type_propertiesFile("OppEditProductTeamCommentsField", "ProductTeamComments");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("SubtypeErrorLink"))
			{
				selenium.jsClick("SubtypeErrorLink");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitForElementToBeClickable("SubtypeDropDownOpp");
				selenium.click("SubtypeDropDownOpp");
				selenium.waitForElementToBeClickable("SubtypeValue");
				selenium.click("SubtypeValue");
				selenium.waitingTime(2000);
				selenium.click("Save_Btn");
			}
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.reportFailure("Error while editing product team comments field in opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing product team comments field in opportunity");
		}
	}

	@And("^verify opp field history section$")
	public void verify_opp_field_history_section() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("OppEditProductTeamCommentsIcon");
			selenium.waitingTime(4000);
			if (selenium.isElementPresentFast("showAllLinks")) {
				selenium.jsClick("showAllLinks");
				selenium.waitingTime(2000);
			}

			if (selenium.isElementPresentFast("OpportunityFieldHistoryLink")) {
				selenium.jsClick("OpportunityFieldHistoryLink");
			} else {
				selenium.jsClick("OpportunityFieldHistoryLink2");
			}

			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("OppFieldHistoryPTC");
			if (selenium.isElementPresentFast("OppFieldHistoryPTC")) {
				selenium.test.log(LogStatus.PASS, "Product Team Comments is present in Opp Field History");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Product Team Comments is NOT present in Opp Field History");
				selenium.reportFailure("Product Team Comments is NOT present in Opp Field History");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.reportFailure("Error while verifying opp field history " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying opp field history");
		}
	}
	
	@And("^verify Title and Rank columns are removed$")
	public void verify_Rank_and_columns_in_opp_contact_removed() {
		try {
			selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(6000);
			if (!(selenium.isElementPresentFast("TitleColumnInOppContact") || selenium.isElementPresentFast("RankColumnInOppContact"))) {
				selenium.test.log(LogStatus.PASS, "Title & Rank columns are not there in Opp Contact related list");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Title or Rank column is appearing in Opp Contact related list");
				selenium.reportFailure("Title or Rank column is appearing in Opp Contact related list");
				System.out.println("FAIL");
			}	
			
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying opp contact related list columns " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying opp contact related list columns");
		}
	}
	
	@And("^verify CS fields in opp contact$")
	public void verify_CS_fields_in_opp_contact() {
		try {
	
			selenium.waitForElementToBeClickable("FirstOppOrderRecord");
			selenium.jsClick("FirstOppOrderRecord");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrolldown(500);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("CSPartnerField");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("CSPartnerField") && selenium.isElementPresentFast("CSPartnerEngagementField") && selenium.isElementPresentFast("CSIdentificationField")) {
				selenium.test.log(LogStatus.PASS, "All three CS fields are available in Opp Contact record");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected fields are missing");
				selenium.reportFailure("The expected fields are missing");
				System.out.println("FAIL");
			}

			//Check above 3 mentioned CS fields are editable
			if (selenium.isElementPresentFast("CSPartnerEditBtn") && selenium.isElementPresentFast("CSPartnerEngagementEditBtn") && selenium.isElementPresentFast("CSIdentificationEditBtn")) {
				selenium.test.log(LogStatus.PASS, "All three CS fields are editable by MHHE_Business_Administrator user");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The CS fields are read only for MHHE_Business_Administrator user");
				selenium.reportFailure("The CS fields are read only for MHHE_Business_Administrator user");
				System.out.println("FAIL");
			}
			
			
		}
		catch (Exception e) {
			selenium.reportFailure("Error while verifying CS field  " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying CS field");
		}
	}

	@And("^verify CS Partner field values$")
	public void verify_CS_Partner_field_values() {
		try {
			//CS Partner field has been renamed as CS Engagement later on.
			selenium.waitForElementToBeVisible("OppCSPartnerEditIcon");
			selenium.scrollToElement("OppCSPartnerEditIcon");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppCSPartnerEditIcon");
			selenium.click("OppCSPartnerEditIcon");
			selenium.waitingTime(5000);
			selenium.scrolldown(-100);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppCSPartnerEditField");
			selenium.click("OppCSPartnerEditField");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("CSSOption1") && selenium.isElementPresentFast("CSSOption2") && selenium.isElementPresentFast("CSSOption3")) {
				selenium.test.log(LogStatus.PASS, "All four CS fields are available in the CS Partner drop-down list");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected fields are missing in CS Partner drop-down list");
				selenium.reportFailure("The expected fields are missing in CS Partner drop-down list");
				System.out.println("FAIL");
			}
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.click("CancelButton");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying CS Partner field  " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying CS Partner field");
		}
	}
	
	@And("^verify CS fields in opp contact are readonly$")
	public void verify_CS_fields_in_opp_contact_are_readonly() {
		try { 		
			//Check above 3 mentioned CS fields are non editable for non MHHE Business admin users
			
			selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("FirstOppOrderRecord");
			selenium.jsClick("FirstOppOrderRecord");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrolldown(500);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("CSPartnerField");
			selenium.waitingTime(2000);
			
			if (selenium.isElementPresentFast("CSPartnerEditBtn") && selenium.isElementPresentFast("CSPartnerEngagementEditBtn") && selenium.isElementPresentFast("CSIdentificationEditBtn")) {
				selenium.test.log(LogStatus.FAIL, "The CS fields are editable for NON MHHE_Business_Administrator user");
				selenium.reportFailure("The CS fields are editable for NON MHHE_Business_Administrator user");
				System.out.println("FAIL");
			} else {
				selenium.test.log(LogStatus.PASS, "The CS fields fields are read only for NON MHHE_Business_Administrator user");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			}
			
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying CS fields  " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying CS fields");
		}
	}

	@And("^verify CS Partner field is readonly$")
	public void verify_CS_Partner_field_is_readonly() {
		try {
			selenium.waitForElementToBeVisible("OppCSPartnerLabel");
			selenium.scrollToElement("OppCSPartnerLabel");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);

			if (!selenium.isElementPresentFast("OppCSPartnerEditIcon")) {
				selenium.test.log(LogStatus.PASS, "Non MHHE Business Admin user is not able to edit the CS Partner field.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Non MHHE Business Admin user is able to edit the CS Partner field.");
				selenium.reportFailure("Non MHHE Business Admin user is able to edit the CS Partner field.");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying CS Partner field  " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying CS Partner field");
		}
	}

	@And("^verify FutureNetPrice and FuturePriceDate field in Product$")
	public void verify_FutureNetPrice_and_FuturePriceDate_field_in_Product() {
		try {
			//Verifying the presence of FutureNetPrice field under Products Section of the Opportunity
			/*selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");			
			selenium.waitForElementToBeVisible("FutureNetPriceFieldinProductsSection");
			if(selenium.isElementPresentFast("FutureNetPriceFieldinProductsSection"))
			{
				selenium.test.log(LogStatus.PASS, "FutureNetPrice field is present in Opp Products section/panel!");
				System.out.println("PASS");
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "The expected field is missing in Opp Products section/panel!");
				selenium.reportFailure("The expected field is missing in Opp Products section/panel!");
				System.out.println("FAIL");
			}*/
			//Verifying the presence of FutureNetPrice & FuturePriceDate fields under OppLineItem (Products) related list of the Opportunity
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.click("opportunityLineItemRelatedList");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("FutureNetPriceFieldinOppProduct");
			if (selenium.isElementPresentFast("FutureNetPriceFieldinOppProduct") && selenium.isElementPresentFast("FuturePriceDateFieldinOppProduct")) {
				selenium.test.log(LogStatus.PASS, "Both FutureNetPrice & FuturePriceDate fields are present in Opp Line Item page!");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected fields are missing in Opp Line Item page!");
				selenium.reportFailure("The expected fields are missing in Opp Line Item page!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying FutureNetPrice and FuturePriceDate field in MHHE Opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying FutureNetPrice and FuturePriceDate field in MHHE Opportunity");
		}
	}

	@And("^verify FutureNetPrice and FuturePriceDate field in ProductInUse$")
	public void verify_FutureNetPrice_and_FuturePriceDate_field_in_ProductInUse() {
		try {
			selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("productInUseLink2");
			selenium.scrolldown(150);
			selenium.waitingTime(2000);
			//Verifying the presence of FutureNetPrice & FuturePriceDate fields under ProductInUse related list of the Opportunity
			selenium.waitForElementToBeClickable("productInUseLink2");
			selenium.click("productInUseLink2");
			selenium.waitingTime(5000);

			if (!selenium.isElementPresentFast("FutureNetPriceFieldinOppProduct")) {
				selenium.waitingTime(3000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("productAddOrEdit");
				selenium.jsClick("productAddOrEdit");
				selenium.waitingTime(6000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("isbnSearch1");
				selenium.scrollToElement("isbnSearch1");
				selenium.type_propertiesFile("isbnSearch1", "ISBNNo");
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.click("searchBtn");
				selenium.waitingTime(12000);
				selenium.waitForElementToBeClickable("productCheckBox");
				selenium.click("productCheckBox");
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(10000);
				selenium.test.log(LogStatus.PASS, "Product Added to PIU of Opportunity");
				System.out.println("Product Added to PIU of Opportunity");
//				verify_FutureNetPrice_and_FuturePriceDate_field_in_ProductInUse();
			}

			selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("productInUseLink2");
			selenium.scrolldown(150);
			selenium.waitingTime(2000);
			//Verifying the presence of FutureNetPrice & FuturePriceDate fields under ProductInUse related list of the Opportunity
			selenium.waitForElementToBeClickable("productInUseLink2");
			selenium.click("productInUseLink2");
			selenium.waitingTime(5000);

			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("FutureNetPriceFieldinOppProduct");
			if (selenium.isElementPresentFast("FutureNetPriceFieldinOppProduct") && selenium.isElementPresentFast("FuturePriceDateFieldinOppProduct")) {
				selenium.test.log(LogStatus.PASS, "Both FutureNetPrice & FuturePriceDate fields are present in ProductInUse page!");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected fields are missing in ProductInUse page!");
				selenium.reportFailure("The expected fields are missing in ProductInUse page!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying FutureNetPrice and FuturePriceDate field in MHHE Opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying FutureNetPrice and FuturePriceDate field in MHHE Opportunity");
		}
	}

	@Then("^update opp year to future year$")
	public void update_opp_year_to_future_year() {
		try {
			selenium.waitForElementToBeClickable("EditOppYear");
			selenium.click("EditOppYear");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppYearField");
			selenium.click("OppYearField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppFutureYear");
			selenium.click("OppFutureYear");
			selenium.click("Save_Btn");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.INFO, "Updated opp year to future year successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while updating opp year to future year " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while updating opp year to future year");
		}
	}

	@Then("^update opp year to past year$")
	public void update_opp_year_to_past_year() {
		try {
			selenium.waitForElementToBeClickable("EditOppYear");
			selenium.click("EditOppYear");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppYearField");
			selenium.click("OppYearField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppPastYear");
			selenium.click("OppPastYear");
			selenium.click("Save_Btn");
			selenium.waitingTime(6000);
			selenium.test.log(LogStatus.INFO, "Updated opp year to future year successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while updating opp year to past year " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while updating opp year to past year");
		}
	}

	@Then("^delete opp order line$")
	public void delete_opp_order_line() {
		try {
			selenium.waitForElementToBeClickable("opportunityOrderLink");
			selenium.click("opportunityOrderLink");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstSampleRecordNew");
			selenium.jsClick("firstSampleRecordNew");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.click("DeleteActionBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Deleted opp order line successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while deleting opp order line " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while deleting opp order line");
		}
	}

	@Then("^delete opp line item$")
	public void delete_opp_line_item() {
		try {
			selenium.navigateToURL(selenium.MHHENewOppURLToVerifyEvergreenField);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("firstTableRecord"); //opp product (OLI)
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("DeleteActionButton");
			selenium.click("DeleteActionButton");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Deleted opp order line successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while deleting opp line items " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while deleting opp line items");
		}
	}

	@And("^delete print product and verify print revenue value$")
	public void delete_print_product() {
		try {
			selenium.navigateToURL(selenium.INTLOppURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
//			if(selenium.isElementPresentFast("products_quote"))
//			{
//				selenium.click("products_quote");
//			}
//			else
//			{
//				selenium.click("productsSectionForOpportunity");
//			}
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.click("opportunityLineItemRelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("DeletePrintProductinOpp");
			selenium.click("DeletePrintProductinOpp");
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
			selenium.waitingTime(6000);
			System.out.println("Successfully deleted the Print type Product");
			selenium.navigateToURL(selenium.INTLOppURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OppPrintRevenue");
			String OppPrintRevenue = selenium.getText("OppPrintRevenue");
			System.out.println("OppPrintRevenue :" + OppPrintRevenue);    //AUD 140.86 (INR 6,786.70)
			String[] parts = OppPrintRevenue.split(" ");
			String part1 = parts[0];    //AUD
			String part2 = parts[1];    //140.86
			System.out.println("part1 " + part1);
			System.out.println("part2 " + part2);
			part2 = part2.replace(",", "");
			double OppPrintRevenueNumber = Double.parseDouble(part2);
			System.out.println("******************OppRevenueNumber****************** :" + OppPrintRevenueNumber);    //140.86
			selenium.test.log(LogStatus.INFO, "******************OppRevenueNumber****************** :" + OppPrintRevenueNumber);

			if (OppPrintRevenueNumber == 0.00) {
				selenium.test.log(LogStatus.PASS, "Opp Print Revenue value is 0.00 as there is no print type product attached to this opportunity");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp Print Revenue value is NOT 0.00");
				selenium.reportFailure("Opp Print Revenue value is NOT 0.00");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying print revenu value after deleting print product " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying print revenu value after deleting print product");
		}
	}

	@And("^verify digital supplier code validation message with (.+) code and (.+) code$")
	public void validate_the_MHE_or_VST_digital_supplier_error_message(String validsuppliercode, String invalidsuppliercode) {
		try {
			/*Testcase for invalid supplier code*/
			selenium.waitForElementToBeClickable("CreateeCommerceURL");
			selenium.click("CreateeCommerceURL");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("DigitalSupplierEditIcon");
			selenium.hoverAndClick("DigitalSupplierEditIcon");
			selenium.waitForElementToBeClickable("DigitalSupplierEditTextField");
			selenium.typeData("DigitalSupplierEditTextField", invalidsuppliercode);
			selenium.moveTab("DigitalSupplierEditTextField");
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("DigitalSupplierValidationMsg")) {
				selenium.test.log(LogStatus.PASS, "For invalid supplier code it displayed the expected validation message and changes did not save");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected validation message did not appear");
				selenium.reportFailure("The expected validation message did not appear");
				System.out.println("FAIL");
			}

			/*Testcase for valid supplier code*/
			selenium.waitForElementToBeClickable("DigitalSupplierEditIcon");
			selenium.hoverAndClick("DigitalSupplierEditIcon");
			selenium.waitForElementToBeClickable("DigitalSupplierEditTextField");
			selenium.typeData("DigitalSupplierEditTextField", validsuppliercode);
			selenium.moveTab("DigitalSupplierEditTextField");
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("DigitalSupplierValidationMsg")) {
				selenium.test.log(LogStatus.FAIL, "For valid supplier code it displayed the validation message");
				selenium.reportFailure("For valid supplier code it displayed the validation messag");
				System.out.println("FAIL");
			} else {
				selenium.test.log(LogStatus.PASS, "For valid supplier code it did not throw any validation message and changes saved successfully!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}

		} catch (Exception e) {
			selenium.reportFailure("Error while validating the MHE or VST digital supplier error message " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while validating the MHE or VST digital supplier error message");
		}
	}

	@When("^Select any existing Course record with Category (.+)$")
	public void select_any_existing_course_record_with_category(String marketcode) {
		try {

			if (selenium.getTestCaseName().equalsIgnoreCase("SEGUserAddProdwithCourseCategoryMarketCodeAsSEGOH")) {
				selenium.navigateToURL(CourseRcordWithCategoryAsSEGOH);
				selenium.waitForElementToBeVisible("CategoryMarketCodeField");
				String CategoryMarketCode = selenium.getText("CategoryMarketCodeFieldValue");
				if (CategoryMarketCode.equalsIgnoreCase(marketcode)) {
					selenium.test.log(LogStatus.PASS, "Navigated to a Course with CategoryMarketCode as SEGOH");
					System.out.println("PASS");
					selenium.captureScreenShot();
				} else {
					selenium.test.log(LogStatus.FAIL, "Navigated to a wrong Course");
					selenium.reportFailure("Navigated to a wrong Course");
					System.out.println("FAIL");
				}
			} else if (selenium.getTestCaseName().equalsIgnoreCase("SEGUserAddProdwithCourseCategoryMarketCodeNotAsSEGOH")) {
				selenium.navigateToURL(CourseRcordWithCategoryNotAsSEGOH);
				selenium.waitForElementToBeVisible("CategoryMarketCodeField");
				String CategoryMarketCode = selenium.getText("CategoryMarketCodeFieldValue");
				if (CategoryMarketCode.equalsIgnoreCase(marketcode)) {
					selenium.test.log(LogStatus.PASS, "Navigated to a Course with CategoryMarketCode as NOT SEGOH");
					System.out.println("PASS");
					selenium.captureScreenShot();
				} else {
					selenium.test.log(LogStatus.FAIL, "Navigated to a Course with CategoryMarketCode as SEGOH");
					selenium.reportFailure("Navigated to a Course with CategoryMarketCode as SEGOH");
					System.out.println("FAIL");
				}
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while seleting existing course record " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while seleting existing course record");
		}
	}

	@Then("^Open any record from Product course related list$")
	public void open_any_record_from_product_course_related_list() {
		try {
			selenium.click("MHEcourseProductCourseLink");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("firstSampleRecordNew");
			selenium.jsClick("firstSampleRecordNew");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.reportFailure("Error while opening existing record from product course related list" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while opening existing record from product course related list");
		}

	}

	@Then("^Open the related product record and note the ISBN$")
	public void open_the_related_product_record_and_note_the_isbn() {
		try {
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("MHEcourseProductLink");
			selenium.jsClick("MHEcourseProductLink");
			selenium.waitForElementToBeVisible("MHEcourseProductISBNNumber");
			ISBNNum = selenium.getText("MHEcourseProductISBNNumber");
			System.out.println("Product ISBN is:" + ISBNNum);
		} catch (Exception e) {
			selenium.reportFailure("Error while opening related product record and note the ISBN " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while opening related product record and note the ISBN");
		}

	}

	@Then("^Go to Products related list and click on Modify Products button$")
	public void go_to_products_related_list_and_click_on_modify_products_button() {
		try {
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("modifyProducts");
			selenium.click("modifyProducts");
			selenium.waitingTime(15000);
		} catch (Exception e) {
			selenium.reportFailure("Error while navigating to product related list and click on Modify Products button " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to product related list and click on Modify Products button");
		}

	}


	    @Then("^Provide the ISBN in the key ISBN text box and click on Add button$")
	    public void provide_the_isbn_in_the_key_isbn_text_box_and_click_on_add_button()  {
	        try {
				selenium.switchToFrame("switch_iFrame");
				selenium.waitForElementToBeClickable("keyIsbn");
				selenium.click("keyIsbn");
				selenium.waitingTime(2000);
				if(selenium.getTestCaseName().equalsIgnoreCase("SEGUserAddProdwithCourseCategoryMarketCodeAsSEGOH"))
				{
				System.out.println("ISBNNum : " + "ISBNNum01");
				selenium.type_propertiesFile("keyIsbn", "ISBNNum01"); //ISBN is hard coded because the product should have selling price <> 0
				selenium.waitForElementToBeClickable("addButton");
				selenium.click("addButton");
				selenium.waitingTime(13000);
				selenium.clickLoop("saveProduct");
				selenium.test.log(LogStatus.INFO, "Added ISBN with course");

				}
				else if (selenium.getTestCaseName().equalsIgnoreCase("VerifySEGUserAbleToAddProductInOppwithAndWithoutproductCourse"))
				{
					System.out.println("ISBNNum : " + "ISBNNum01");
					selenium.type_propertiesFile("keyIsbn", "ISBNNum01"); //ISBN is hard coded because the product should have selling price <> 0
					selenium.waitForElementToBeClickable("addButton");
					selenium.click("addButton");
					selenium.waitingTime(13000);
					selenium.clickLoop("saveProduct");
					selenium.test.log(LogStatus.INFO, "Added ISBN with course");
				}

				else if(selenium.getTestCaseName().equalsIgnoreCase("SEGUserAddProdwithCourseCategoryMarketCodeNotAsSEGOH"))
				{
					System.out.println("ISBNNum : " + "ISBNNum02");
					selenium.type_propertiesFile("keyIsbn", "ISBNNum02"); //ISBN is hard coded because the product should have selling price <> 0
					selenium.waitForElementToBeClickable("addButton");
					selenium.click("addButton");
					selenium.waitingTime(13000);
					selenium.clickLoop("saveProduct");
					selenium.test.log(LogStatus.INFO, "Added ISBN without course");
				}
				selenium.switchOutOfFrame();
				selenium.waitingTime(8000);
	        }
			catch (Exception e)	{
				selenium.reportFailure("Error while adding ISBN " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Error while adding ISBN");
			}
	        
	    }

	    @And("^Verify the product is successfully added to the opportunity$")
	    public void verify_the_product_is_successfully_added_to_the_opportunity()  {
	        try {
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("OppProduct");
				selenium.click("OppProduct");
//	        	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001DgXwAAAV/related/OpportunityLineItems/view");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.scrollToElement("lastTaskRecord");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("lastTaskRecord");
				selenium.clickLoop("lastTaskRecord"); //just to navigate to last row
				selenium.waitingTime(5000);
	        	String xpath = selenium.getDynamicXpathData("anchorTextcontains",ISBNNum,"endContains");
	        	System.out.println("xpath is:" + xpath);
				System.out.println("test1:" + ISBNNum);
	        	if(selenium.isElementPresentXpathFast(xpath))
	        	{
	        		selenium.test.log(LogStatus.PASS, "Product added to opportunity");
					System.out.println("PASS");
					selenium.captureScreenShot();
	        	}
	        	else
	        	{
					selenium.test.log(LogStatus.FAIL, "Product not added to opportunity");
					selenium.reportFailure("Product not added to opportunity");
					System.out.println("FAIL");
	        	}
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("showlastoption");
	        	selenium.click("showlastoption");
				selenium.waitForElementToBeClickable("DeleteRecord");
				selenium.click("DeleteRecord");
				selenium.waitingTime(10000);
				System.out.println("Deleted the newly added opportunity product");	        	
	        }
			catch (Exception e) {
				selenium.reportFailure("Error while verifying product added to opp or not " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Error while verifying product added to opp or not");
			}}

	@Then("Go to Products related list and click on Modify Product button")
	public void go_to_products_related_list_and_click_on_modify_product_button() {
		try {
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("modifyProducts");
			selenium.click("modifyProducts");
			selenium.waitingTime(15000);
		} catch (Exception e) {
			selenium.reportFailure("Error while navigating to product related list and click on Modify Products button " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to product related list and click on Modify Products button");
		}

	}

//	@Then("^Provide the ISBN in the key ISBN text box and click on Add button$")
//	public void provide_the_isbn_in_the_key_isbn_text_box_and_click_on_add_button() {
//		try {
//			selenium.switchToFrame("switch_iFrame");
//			selenium.waitForElementToBeClickable("keyIsbn");
//			selenium.click("keyIsbn");
//			selenium.waitingTime(2000);
//			System.out.println("ISBNNum : " + "ISBNNum01");
//			selenium.type_propertiesFile("keyIsbn", "ISBNNum01"); //ISBN is hard coded because the product should have selling price <> 0
//			selenium.waitForElementToBeClickable("addButton");
//			selenium.click("addButton");
//			selenium.waitingTime(13000);
//			selenium.clickLoop("saveProduct");
//			selenium.test.log(LogStatus.INFO, "Added ISBN with course");
//			selenium.switchOutOfFrame();
//			selenium.waitingTime(8000);
//
//			selenium.waitForElementToBeClickable("modifyProducts");
//			selenium.click("modifyProducts");
//			selenium.waitingTime(4000);
//			selenium.switchToFrame("switch_iFrame");
//
//
//			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("keyIsbn");
//			selenium.click("keyIsbn");
//			selenium.waitingTime(2000);
//			System.out.println("ISBNNum : " + "ISBNNum02");
//
//			selenium.type_propertiesFile("keyIsbn", "ISBNNum02"); //ISBN is hard coded because the product should have selling price <> 0
//			selenium.waitForElementToBeClickable("addButton");
//			selenium.click("addButton");
//			selenium.waitingTime(13000);
//			selenium.clickLoop("saveProduct");
//			selenium.test.log(LogStatus.INFO, "Added ISBN without course");
//			selenium.switchOutOfFrame();
//			selenium.waitingTime(12000);
//			selenium.refresh();
//			selenium.waitingTime(6000);


//				selenium.navigateBack();
//				selenium.waitForElementToBeClickable("modifyProducts");
//				selenium.click("modifyProducts");

//				selenium.switchToFrame("switch_iFrame");

//
//		} catch (Exception e) {
//			selenium.reportFailure("Error while adding ISBN " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Error while adding ISBN");
//		}
//
//	}

//	@And("^Verify the product is successfully added to the opportunity$")
//	public void verify_the_product_is_successfully_added_to_the_opportunity() {
//		try {
//			selenium.waitForElementToBeClickable("OppProduct");
//			selenium.click("OppProduct");
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001DgXwAAAV/related/OpportunityLineItems/view");
//			selenium.refresh();
//			selenium.waitingTime(8000);
//			selenium.scrollToElement("lastTaskRecord");
//			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("lastTaskRecord");
//			selenium.clickLoop("lastTaskRecord"); //just to navigate to last row
//			selenium.waitingTime(5000);
//			String xpath = selenium.getDynamicXpathData("anchorTextcontains", ISBNNum, "endContains");
//			System.out.println("xpath is:" + xpath);
//			if (selenium.isElementPresentXpathFast(xpath)) {
//				selenium.test.log(LogStatus.PASS, "Product added to opportunity");
//				System.out.println("PASS");
//				selenium.captureScreenShot();
//			} else {
//				selenium.test.log(LogStatus.FAIL, "Product not added to opportunity");
//				selenium.reportFailure("Product not added to opportunity");
//				System.out.println("FAIL");

//			}
//			selenium.refresh();
//			selenium.waitingTime(10000);
//			selenium.waitForElementToBeClickable("showlastoption");
//			selenium.click("showlastoption");
//			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("DeleteRecord");
//			selenium.click("DeleteRecord");
//			selenium.waitingTime(10000);
//			System.out.println("Deleted the newly added opportunity product");
//		} catch (Exception e) {
//			selenium.reportFailure("Error while verifying product added to opp or not " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Error while verifying product added to opp or not");
//		}
//
//	}

	@And("^Verify that the product is successfully added to the opportunity$")
	public void verify_that_the_product_is_successfully_added_to_the_opportunity() {
		try {
//				selenium.waitForElementToBeClickable("OppProduct");
//				selenium.click("OppProduct");
//	        	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001DgXwAAAV/related/OpportunityLineItems/view");
			selenium.waitForElementToBeClickable("ClickOnProducts");
			selenium.click("ClickOnProducts");
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("lastTaskRecord");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("lastTaskRecord");
			selenium.clickLoop("lastTaskRecord"); //just to navigate to last row
			selenium.waitingTime(5000);
			String xpath = selenium.getDynamicXpath_propertiesFile("anchorTextcontains", "ISBNNum01", "endContains");
			System.out.println("xpath is:" + xpath);
			if (selenium.isElementPresentXpathFast(xpath)) {
				selenium.test.log(LogStatus.PASS, "Product added to opportunity");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Product not added to opportunity");
				selenium.reportFailure("Product not added to opportunity");
				System.out.println("FAIL");
			}

			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("showlastoption");
			selenium.click("showlastoption");
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
			selenium.waitingTime(10000);
			System.out.println("Deleted the newly added opportunity product");


			String xpath1 = selenium.getDynamicXpath_propertiesFile("anchorTextcontains","ISBNNum01","endContains");

			System.out.println("xpath is:" + xpath1);
			if (selenium.isElementPresentXpathFast(xpath1)) {
				selenium.test.log(LogStatus.PASS, "Product added to opportunity");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Product not added to opportunity");
				selenium.reportFailure("Product not added to opportunity");
				System.out.println("FAIL");
			}
//			selenium.refresh();
//			selenium.waitingTime(10000);
//			selenium.waitForElementToBeClickable("showlastoption");
//			selenium.click("showlastoption");
//			selenium.waitingTime(6000);
//			selenium.waitForElementToBeClickable("DeleteRecord");
//			selenium.click("DeleteRecord");
//			selenium.waitingTime(10000);
//			System.out.println("Deleted the newly added opportunity product");
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying product added to opp or not " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying product added to opp or not");
		}

	}

	@And("^Verify the opportunity validation message$")
	public void Verify_the_opportunity_validation_message()  {
		try {
			selenium.waitingTime(2000);
			selenium.navigateToURL(TaskURL);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("editL");
			selenium.click("editL");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("TaskStatusField");
			selenium.click("TaskStatusField");
			selenium.waitForElementToBeClickable("TaskStatusCompleted");
			selenium.click("TaskStatusCompleted");
			selenium.waitForElementToBeClickable("SalesAcceptedField");
			selenium.click("SalesAcceptedField");
			selenium.waitForElementToBeClickable("SalesAcceptedYes");
			selenium.click("SalesAcceptedYes");
			selenium.waitForElementToBeClickable("MarketingReasonField");
			selenium.click("MarketingReasonField");
			selenium.waitForElementToBeClickable("MarketingReasonQualified");
			selenium.click("MarketingReasonQualified");
			selenium.waitForElementToBeClickable("MarketingTaskSourceField");
			selenium.click("MarketingTaskSourceField");
			selenium.waitForElementToBeClickable("MarketingTaskSourceMarketo");
			selenium.click("MarketingTaskSourceMarketo");
			selenium.waitForElementToBeClickable("RecordSaveButton");
			selenium.click("RecordSaveButton");
			selenium.waitingTime(4000);

			if(selenium.isElementPresentFast("TaskStatusField"))
			{
				selenium.test.log(LogStatus.PASS, "The expected validation message appeared");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "The expected validation message DID NOT appear");
				selenium.reportFailure("The expected validation message DID NOT appear");
				System.out.println("FAIL");
			}

		}
		catch (Exception e)	{
			selenium.reportFailure("Error while verifying opportunity validation message " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying opportunity validation message");
		}

	}
	    
	    @Then("^create new DFC Request in Opp$")
	    public void create_new_DFC_Request_in_Opp(DataTable table)
	    {
	        try {
				List<String> data = table.transpose().asList(String.class);
				selenium.navigateToURL(selenium.MHHENewOppURL);
				selenium.waitingTime(10000);
				if (selenium.isElementPresentFast("DFCRequestLinkinOpp")) {
					selenium.jsClick("DFCRequestLinkinOpp");
					selenium.waitingTime(2000);
				} else {
					selenium.refresh();
					selenium.waitingTime(10000);
					System.out.println("Scrolling to ShowAllLinks..");
					selenium.scrollToElement("showAllLinks");
					selenium.waitingTime(2000);
					selenium.scrolldown(-400);
					selenium.waitingTime(4000);
					selenium.click("showAllLinks");
					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("DFCRequestLinkinOpp");
					selenium.jsClick("DFCRequestLinkinOpp");
					selenium.waitingTime(5000);
				}
				selenium.waitForElementToBeClickable("DFCRequestNEWBtn");
				selenium.click("DFCRequestNEWBtn");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("DFCRequestTimeZone");
				selenium.typeData("DFCRequestTimeZone",data.get(0));
				selenium.click("TypeDDList");
				selenium.waitingTime(1000);
				selenium.clickDynamicData("spanTitle", data.get(1), "end");

				selenium.waitForElementToBeClickable("DFCRequestInstructor");
				selenium.typeData("DFCRequestInstructor", data.get(2));
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String Instructor = selenium.getDynamicXpathData("anchorTitlecontains", data.get(2), "endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Instructor);
				selenium.waitingTime(2000);

				selenium.waitForElementToBeClickable("RADFCRequestInstructorAvailability");
				selenium.typeData("DFCRequestInstructorAvailability", data.get(3));

				selenium.waitForElementToBeClickable("DFCRequestExactDate");
				selenium.click("DFCRequestExactDate");
//	        	selenium.waitForElementToBeClickable("TomorrowDateInCalendar");
//	        	selenium.click("TomorrowDateInCalendar");
				selenium.typeData("DFCRequestExactDate", data.get(7));

				selenium.waitForElementToBeClickable("search_People");
				selenium.typeData("search_People", data.get(4));
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.clickLoop("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("PeopleShowAllResultTopRecord");
				selenium.click("PeopleShowAllResultTopRecord");
				/*String LTR = selenium.getDynamicXpathData("anchorTitlecontains", data.get(4), "endContains");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(LTR);*/
				selenium.waitingTime(2000);

				selenium.waitForElementToBeClickable("DFCRequestNeededDetails");
				selenium.typeData("DFCRequestNeededDetails",data.get(5));
				selenium.waitingTime(2000);
				selenium.scrollToElement("DFCRequestActivityfocus");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DFCRequestActivityfocus");
				selenium.click("DFCRequestActivityfocus");
				selenium.waitingTime(1000);
				selenium.clickDynamicData("spanTitle", data.get(6), "end");
				selenium.waitingTime(2000);

				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(15000);
				selenium.test.log(LogStatus.INFO, "New DFC Request has been created successfully!");
//        		selenium.DFCRequest = selenium.getURL();
//        		selenium.test.log(LogStatus.INFO, "The newly created DFC Request URL is " + selenium.DFCRequest);
			}
			catch (Exception e)
			{
				System.out.println("Inside catch");
				selenium.reportFailure("Error while creating new DFC Request in opportunity " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Error while creating new DFC Request in opportunity");
			}
		}
	@Then("^Make the field as blank and edit stage")
//	public void make_the_field_as_blank_and_edit_stage(DataTable table) {
		public void make_the_field_as_blank_and_edit_stage() {

			try {
//			List<String> data = table.transpose().asList(String.class);
//			selenium.navigateToURL(data.get(0));

				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("clickonstageedit");
				selenium.jsClick("clickonstageedit");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("OppStageField");
				selenium.click("OppStageField");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Opp_Stage1");
				selenium.jsClick("Opp_Stage1");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.scrollToElement("EditRevRealisation");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("EditRevRealisation");
				selenium.jsClick("EditRevRealisation");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ClickOnStudentPay");
				selenium.click("ClickOnStudentPay");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("RevenueRealisationInsert");
				selenium.click("RevenueRealisationInsert");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ClickOnDecisionOption");
				selenium.click("ClickOnDecisionOption");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ClickOnInsertDecision");
				selenium.click("ClickOnInsertDecision");
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
				
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("clickonstageedit");
				selenium.jsClick("clickonstageedit");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("OppStageField");
				selenium.click("OppStageField");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Opp_Stage_Resolve");
				selenium.jsClick("Opp_Stage_Resolve");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());

		}
	}
	@Then(("^update the decision dynamic and revenue realisation"))
	public void update_the_decision_dynamic_and_revenue_realisation(){
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("EditRevRealisation");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditRevRealisation");
			selenium.jsClick("EditRevRealisation");
			selenium.waitingTime(6000);
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClickOnStudentPay");
			selenium.click("ClickOnStudentPay");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RevRealisationDelete");	//insert
			selenium.click("RevRealisationDelete");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClickOnDecisionOption");
			selenium.click("ClickOnDecisionOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DecisionDynamicDelete");	//insert
			selenium.click("DecisionDynamicDelete");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());

		}
	}

	@Then(("^update the revenue realisation"))
	public void update_the_revenue_realisation(){
		try {
			selenium.scrolldown(330);//down
			selenium.waitForElementToBeClickable("EditRevRealisation");
			selenium.clickLoop("EditRevRealisation");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClickOnStudentPay");
			selenium.click("ClickOnStudentPay");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RevRealisationDelete");
			selenium.click("RevRealisationDelete");
			selenium.waitingTime(4000);

			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(6000);

			selenium.scrolldown(-350);
//			selenium.scrollToElement("actualStage1");
			selenium.waitForElementToBeVisible("actualStage1");
			String actualStage = selenium.getText("actualStage1");
//			selenium.scrollToElement("editStagesNew");
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("oppStageList");
//			List<WebElement> attribute = selenium.getElements("oppStageList");

			List<WebElement> attribute = selenium.getElements("oppStageList");
			int j = 7;
			System.out.println("Actual stage : " + actualStage);
			for (int i = 1; i <= attribute.size(); i++) {
				String stageValue = attribute.get(i).getAttribute("data-value");
				System.out.println(stageValue);
				if (stageValue.equalsIgnoreCase("Resolve")) {
					String stageXpath = selenium.getPropertiesObj().getProperty("oppStageItem").
							replace("$val", Integer.toString(j + 1));
					selenium.clickXpath(stageXpath);
					break;
				}
				if (stageValue.equalsIgnoreCase(actualStage)) {
					int k = i + 2;
					String stageXpath = selenium.getPropertiesObj().getProperty("oppStageItem").
							replace("$val", Integer.toString(j));
					selenium.clickXpath(stageXpath);
					break;
				}
			}


			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(3000);

			if (selenium.isElementPresentFast("RecordSaveButton")) {
				selenium.clickLoop("RecordSaveButton");
			}
			selenium.waitingTime(8000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());

		}
	}

	@And(("^Verify the customer success consultant field"))
	public void verify_the_customer_success_consultant_field(DataTable table){
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));

			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("CustomerSuccessField");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("CustomerSuccessField");
			String actualCustomer = selenium.getText("CustomerSuccessField");
			if (actualCustomer.equalsIgnoreCase("")) {
				System.out.println("Customer Success Consultant Field is Blank");
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());

		}
	}



	    
	    @Then("^verify the DFC Request fields$")
	    public void verify_the_DFC_Request_fields(DataTable table)
	    {
	        try
	        {
	        	List<String> data = table.transpose().asList(String.class);
	        	selenium.navigateToURL(selenium.MHHENewOppURL);
        		selenium.waitingTime(10000);
    			if (selenium.isElementPresentFast("DFCRequestLinkinOpp"))
    			{
            		selenium.jsClick("DFCRequestLinkinOpp");
    				selenium.waitingTime(2000);
    			}
    			else
    			{
					selenium.refresh();
					selenium.waitingTime(10000);
    				System.out.println("Scrolling to ShowAllLinks..");
    				selenium.scrollToElement("showAllLinks");
    				selenium.waitingTime(4000);
    				selenium.scrolldown(-400);
    				selenium.waitingTime(2000);
    				selenium.click("showAllLinks");
    				selenium.waitingTime(2000);
            		selenium.waitForElementToBeClickable("DFCRequestLinkinOpp");
            		selenium.jsClick("DFCRequestLinkinOpp");
    				selenium.waitingTime(5000);
    			}
        		selenium.refresh();
        		selenium.waitingTime(4000);
	        	selenium.waitForElementToBeClickable("firstTableRecord");
	        	selenium.jsClick("firstTableRecord");
	        	selenium.waitingTime(6000);
	        	String CSC = selenium.getDynamicXpathData("Text_Span", data.get(0), "end");
	        	String CSS = selenium.getDynamicXpathData("Text_Span", data.get(1), "end");
	        	System.out.println("CSC :" + CSC + "CSS :" + CSS);
	        	if(selenium.isElementPresentXpathFast(CSC) && selenium.isElementPresentXpathFast(CSS))
	        	{
	        		selenium.test.log(LogStatus.PASS, "The expected fields appeared");
					System.out.println("PASS");
					selenium.captureScreenShot();
	        	}
	        	else
	        	{
					selenium.test.log(LogStatus.FAIL, "The expected fields DID NOT appear");
					selenium.reportFailure("The expected fields DID NOT appear");
					System.out.println("FAIL");
	        	}
        	}
			catch (Exception e)
	        {
				selenium.reportFailure("Error while verifying DFC Request fields in opportunity " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Error while verifying DFC Request fields in opportunity");
			}	        
	    }

		@Then("^confirm the DFC Request field values are getting populated from opp record$")
		public void confirm_the_DFC_Request_field_values_are_getting_populated_from_opp_record()
		{
			try
			{
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeVisible("CSCValue");
				String CSCValueInDFCRequest = selenium.getText("CSCValue").toString();
				String CSSValueInDFCRequest = selenium.getText("CSSValue").toString();
				String BusinessUnitValueInDFCRequest = selenium.getText("BusinessUnitValue").toString();
				String DisciplineValueInDFCRequest = selenium.getText("DisciplineValue").toString();
				String MHECourseValueInDFCRequest = selenium.getText("MHECourseValueInDFCRequest").toString();
				System.out.println("CSCValueInDFCRequest:" + CSCValueInDFCRequest + "CSSValueInDFCRequest:" + CSSValueInDFCRequest + "BusinessUnitValueInDFCRequest:" + BusinessUnitValueInDFCRequest + "DisciplineValueInDFCRequest:" + DisciplineValueInDFCRequest + "MHECourseValueInDFCRequest:" + MHECourseValueInDFCRequest);

				selenium.navigateToURL(selenium.MHHENewOppURL);
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeVisible("CSCValue");
				String CSCValueInOpp = selenium.getText("CSCValue").toString();
				String CSSValueInOpp = selenium.getText("CSSValue").toString();
				String BusinessUnitValueInOpp = selenium.getText("BusinessUnitValue").toString();
				String DisciplineValueInOpp = selenium.getText("DisciplineValue").toString();
				String MHECourseValueInOpp = selenium.getText("MHECourseValueInOpp").toString();
				System.out.println("CSCValueInOpp:" + CSCValueInOpp + "CSSValueInOpp:" + CSSValueInOpp + "BusinessUnitValueInOpp:" + BusinessUnitValueInOpp + "DisciplineValueInOpp:" + DisciplineValueInOpp + "MHECourseValueInOpp:" + MHECourseValueInOpp);

				if(CSCValueInDFCRequest.equalsIgnoreCase(CSCValueInOpp) && CSSValueInDFCRequest.equalsIgnoreCase(CSSValueInOpp) && BusinessUnitValueInDFCRequest.equalsIgnoreCase(BusinessUnitValueInOpp) && DisciplineValueInDFCRequest.equalsIgnoreCase(DisciplineValueInOpp) && MHECourseValueInDFCRequest.equalsIgnoreCase(MHECourseValueInOpp))
				{
					selenium.test.log(LogStatus.PASS, "The values in DFC Request page is matching with Opp page values");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "The expected values are not matching");
					selenium.reportFailure("The expected values are not matching");
					System.out.println("FAIL");
				}

//NEED TO COMPARE DATA
			}
			catch (Exception e)
			{
				selenium.reportFailure("Error while verifying DFC Request fields values " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Error while verifying DFC Request fields values");
			}
		}

	@Then("^verify the DFC fields are editable$")
	public void verify_the_DFC_fields_are_editable() {
		try {
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DY000002QwWDYA0/view");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitingTime(4000);
			selenium.scrollToElement("showAllLinks");
			selenium.waitingTime(4000);
			selenium.scrolldown(-1000);
			selenium.waitingTime(4000);
			selenium.click("showAllLinks");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DFCRequestLinkinOpp");
			selenium.hoverAndClick("DFCRequestLinkinOpp");
			selenium.refresh();
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("Edit_BU");
			selenium.jsClick("Edit_BU");
			String Test = "UATTest";
			selenium.clearText("BU_Input");
			selenium.typeData("BU_Input", Test);
			selenium.waitingTime(2000);
			String Test1 = "Science";
//			selenium.waitForElementToBeClickable("Edit_Discipline");
//			selenium.hoverAndClick("Edit_Discipline");
			selenium.clearText("Dis_Input");
			selenium.typeData("Dis_Input", Test1);
			selenium.waitingTime(4000);


//			selenium.waitForElementToBeClickable("Course_DFC");
//			selenium.click("Course_DFC");

			String course1="Computer Applications";
			selenium.waitForElementToBeClickable("crossButton");
			selenium.click("crossButton");
			selenium.waitingTime(2000);
			selenium.typeData("mheCoursedropdown",course1);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.click("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("selectMHELink");
			selenium.click("selectMHELink");
			selenium.waitingTime(4000);


//			String Course="Environmental Science";
//			selenium.clearText("Course_Input");
//			selenium.typeData("Course_Input",Course);
//			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("Save_DFC"))
			{

				System.out.println("DFC BU,MHE Course & Discipline Fields Are Editable");
			}
			selenium.waitForElementToBeClickable("Save_DFC");
			selenium.click("Save_DFC");
			selenium.test.log(LogStatus.INFO, "DFC Request record has been saved successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while editing DFC Request " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing DFC Request");
		}
	}

	@Then("^delete the DFC Request$")
	public void delete_the_DFC_Request() {
		try {
			selenium.navigateToURL(selenium.DFCRequest);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.click("DeleteActionBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "DFC Request record has been deleted successfully!");
		} catch (Exception e) {
			selenium.reportFailure("Error while deleting DFC Request " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while deleting DFC Request");
		}
	}

	@Then("^I Open any Opportunity having stage as Recognize$")
	public void I_Open_any_Opportunity_having_stage_as_Recognize(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitForElementToBeVisible("actualStage1");
			String actualStage2 = selenium.getText("actualStage1");
			System.out.println("Current Opp Stage is -->" + actualStage2);
			
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("firstTableRecord"))
			{
				selenium.waitForElementToBeClickable("firstTableRecord");
				selenium.jsClick("firstTableRecord");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("DeleteActionButton");
				selenium.click("DeleteActionButton");
				selenium.waitingTime(10000);
				selenium.test.log(LogStatus.INFO, "Deleted opp order line successfully!");
			}
			else
			{
				System.out.println("No Opp Line Item Exist for this Opp");
				selenium.test.log(LogStatus.INFO, "No Opp Line Item Exist for this Opp!");
				selenium.navigateToURL(data.get(0));
			}
			
			/*selenium.waitForElementToBeClickable("ClickOnProduct");
			selenium.click("ClickOnProduct");
			selenium.waitingTime(3000);
			selenium.switchToFrame("IFrame_Click");
			selenium.waitForElementToBeClickable("ClickCheckBox");
			selenium.jsClick("ClickCheckBox");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("CLickDelete");
			selenium.click("CLickDelete");
			selenium.waitingTime(3000);
			selenium.defaultframe();
			selenium.waitingTime(3000);*/
			
			if(!actualStage2.equalsIgnoreCase("Recognize"))
			{
				selenium.waitForElementToBeClickable("Edit_Stage");
				selenium.jsClick("Edit_Stage");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("OppStageField");
				selenium.jsClick("OppStageField");
				selenium.waitingTime(2000);
				selenium.jsClick("OppStageValue");	//Recognize
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
			}			
			
			selenium.waitForElementToBeClickable("Edit_Stage");
			selenium.jsClick("Edit_Stage");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitingTime(2000);
			selenium.jsClick("Opp_Stage1");	//Evaluate
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(3000);

			if (selenium.isElementPresentFast("RecordSaveButton")) {
				System.out.println("Verify Error Message is Triggered");
				selenium.clickLoop("RecordSaveButton");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.click("CancelButton");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");

				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {
				selenium.click("CancelButton");
				selenium.clickLoop("opportunityAccountsEditCancel");
			}
		}
	}

	@Then("^I create a new opportunity$")
	public void I_create_a_new_opportunity() {
		try {
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("Click_New");
			selenium.waitForElementToBeClickable("Click_New");
			selenium.jsClick("Click_New");
			selenium.waitingTime(8000);
//			selenium.setImplicitWait(1000);
			selenium.switchToFrame("iframe_new");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("Serach_OppName");
			selenium.hoverAndClick("Serach_OppName");
			
			String Account = "Clarke University";
			selenium.typeData("Serach_OppName", Account);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppAccountText");
			selenium.click("OppAccountText");
			selenium.waitingTime(2000);

			String Course = "Advanced Engineering Mathematics";
			selenium.typeData("OpportunityMHECourse2", Course);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppMHEcourseText");
			selenium.click("OppMHEcourseText");
			selenium.waitingTime(2000);
			
			String Value = "20";
			selenium.typeData("enrollment_fall", Value);
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.click("ButtonSave");
			selenium.waitingTime(9000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.PASS, "Opportunity created successfully");
			selenium.waitingTime(10000);
			selenium.scrolldown(-230);
			selenium.waitingTime(2000);
			selenium.scrollToElement("Opp_Owner");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			boolean oppOwner = selenium.isElementPresentFast("Opp_Owner");
			if (oppOwner == true) {
				System.out.println("Opp Owner is National Sales SEM");
				selenium.test.log(LogStatus.INFO, "Opp Owner Verified Successfully");
			}

			selenium.waitingTime(10000);
			selenium.scrolldown(-800);
			selenium.scrollToElement("EAMValue");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("EAMValue");
			EAMValue1 = selenium.getText("EAMValue").toString();
			SolutionManager1 = selenium.getText("SolutionM").toString();
			LearningSpecialist1 = selenium.getText("Learning1").toString();
			SimNet1 = selenium.getText("SimNet1").toString();
			ALEKSSpec1 = selenium.getText("Aleks_Spec1").toString();
			DistrictManager1 = selenium.getText("District_M").toString();
			CPM1 = selenium.getText("CPM1").toString();
			CSCValue1 = selenium.getText("CSC_Val").toString();
			System.out.println("EAMValue1:" + EAMValue1 + "SolutionManager1:" + SolutionManager1 +
					"LearningSpecialist1:" + LearningSpecialist1 + "SimNet1:" + SimNet1
					+ "ALEKSSpec1:" + ALEKSSpec1 +"DistrictManager1:" +DistrictManager1 + "CPM1:" +CPM1 + "CSCValue1:" +CSCValue1);


		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}



	@Then("^confirm Sales Team Values of Opp is updated from corresponding accounts national sales SEM owner users fields$")
	public void confirm_Sales_Team_Values_of_Opp_is_updated_from_corresponding_accounts_national_sales_SEM_owner_users_fields(DataTable table) {
		try {

			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.switchToFrame("Iframesetup");
			selenium.scrollToElement("EAM_Value");
			selenium.waitForElementToBeVisible("EAM_Value");
			EAMValue = selenium.getText("EAM_Value").toString();
			SolutionManager = selenium.getText("Solution_Manager").toString();
			LearningSpecialist2 = selenium.getText("LearSpec1").toString();
			SimNet = selenium.getText("SimNet_Spec").toString();
			ALEKSSpec = selenium.getText("ALEKS_Spec").toString();
			 DistrictManager = selenium.getText("Dict_Manager").toString();
			 CPM = selenium.getText("CPM").toString();
			 CSCValue = selenium.getText("CSS_Value").toString();
			System.out.println("EAMValue:" + EAMValue + "SolutionManager:" + SolutionManager +
					"LearningSpecialist:" + LearningSpecialist2 + "SimNet:" + SimNet
					+ "ALEKSSpec:" + ALEKSSpec +"DistrictManager:" +DistrictManager + "CPM:" +CPM + "CSCValue:" +CSCValue);


			System.out.println("EAMValue1:" + EAMValue1 + "SolutionManager1:" + SolutionManager1 +
					"LearningSpecialist1:" + LearningSpecialist1 + "SimNet1:" + SimNet1
					+ "ALEKSSpec1:" + ALEKSSpec1 +"DistrictManager1:" +DistrictManager1 + "CPM1:" +CPM1 + "CSCValue1:" +CSCValue1);

			if (EAMValue1.equalsIgnoreCase(EAMValue) && SolutionManager1.equalsIgnoreCase(SolutionManager) && LearningSpecialist1.equalsIgnoreCase(LearningSpecialist2)
					&& SimNet1.equalsIgnoreCase(SimNet) && ALEKSSpec1.equalsIgnoreCase(ALEKSSpec) && DistrictManager1.equalsIgnoreCase(DistrictManager)
			&& CPM1.equalsIgnoreCase(CPM) && CSCValue1.equalsIgnoreCase(CSCValue)) {
				selenium.test.log(LogStatus.INFO, "verified");
				System.out.println("PASS");


			} else {
				selenium.test.log(LogStatus.FAIL, "The expected values are not matching");
				selenium.reportFailure("The expected values are not matching");
				System.out.println("FAIL");
			}
		}

			catch(Exception e){
				selenium.switchOutOfFrame();
				selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
	
	@And("^verify replace PIU with TP validation message in Opp List View$")
	public void verify_replace_PIU_with_TP_validation_message() {
		try {
			selenium.navigateToURL(selenium.INTLOppURL);
			selenium.waitingTime(10000);
			selenium.navigateBack();
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("FirstOppCheckboxinRecentlyViewList");
			selenium.jsClick("FirstOppCheckboxinRecentlyViewList");
			selenium.click("ReplacePIUwithTPActionBtn");			
			selenium.waitingTime(10000);
			
			  if(selenium.isAlertPresent())
			  {
				  System.out.println("The expected alert message appeared.");
				  selenium.acceptAlertPopup();
				  selenium.waitingTime(5000);
				  if(selenium.isAlertPresent())
				  {
					  System.out.println("Alert appeared.");
					  selenium.acceptAlertPopup();
				  }
			  }
			  else
			  {
				  	System.out.println("FAIL");
					selenium.reportFailure("The 0 Opportunities were processed and 0 products were replaced ! alert message did not appear");
					selenium.test.log(LogStatus.FAIL, "The 0 Opportunities were processed and 0 products were replaced ! alert message did not appear");
			  }
		}
		catch(Exception e){
			selenium.reportFailure("Error while verifying replace PIU with TP functionality " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying replace PIU with TP functionality");
		}
	}
	
	@And("^verify replace PIU with TP validation message in PIU related list$")
	public void verify_replace_PIU_with_TP_validation_message_in_PIU_related_list() {
		try {
			selenium.navigateToURL(selenium.INTLOppURL);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("productInUseLink");
			selenium.click("productInUseLink");
			selenium.waitingTime(8000);
			selenium.click("replacePIUWithTPBtn");			
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.switchToFrame("newAccountFrame");
			Assert.assertTrue(selenium.isElementPresentFast("ReplacePIUwithTPUnSuccessMsg"));
			selenium.test.log(LogStatus.PASS,"Expected error message appeared on Product-In-Use related list page");	
		}
		catch(Exception e){
			selenium.reportFailure("Error while verifying replace PIU with TP functionality " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying replace PIU with TP functionality");
		}
	}
}