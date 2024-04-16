package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UpdateCaseTest {
	WebConnector selenium = WebConnector.getInstance();	
	

	@And("^I edit the case origin$")
	public void i_edit_the_case_origin() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseNum");
			selenium.click("CaseNum");
//			selenium.waitingTime(2000);
			//selenium.click("Select_Case");
//			selenium.waitingTime(2000);
			//selenium.clickLoop("editL");
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.test.log(LogStatus.INFO, "selecting the value for case origin!");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("caseOrigin");
			selenium.scrollToElement("caseOrigin");
			selenium.waitForElementToBeClickable("caseOrigin");
			selenium.clickLoop("caseOrigin");
			String CaseOrigin = selenium.getDynamicXpath("anchorTitle", "Case Origin", "end");
			selenium.clickXpath(CaseOrigin);

		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//				selenium.waitingTime(2000);
//			    selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CaseNum_C");
			    selenium.click("CaseNum_C");
//			    selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
			    selenium.click("edit");
			    selenium.waitingTime(2000);
			    selenium.selectDropdownText("caseOrigin_C", "Case Origin");

		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}
	
	
	@Then("^I validate the update success message$")
    public void i_validate_the_update_success_message(){
		try {
		boolean success = false;
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			success = selenium.isElementPresentFast("contactSuccessfulL");	
		}

		else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
				selenium.waitingTime(2000);
			success = selenium.isElementPresentFast("caseno");
			if (success)
			selenium.test.log(LogStatus.INFO, "successfully executed");
		}

		selenium.printLastTestResult(success);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}
	@And("Make the omni channel available for cases and chats")
	public void make_the_omni_channed_available_for_cases_and_chats(DataTable table){
		try{
		List<String> data = table.transpose().asList(String.class);
		
		selenium.closeAllWinExceptFirstWin();
		selenium.firstWindowHandle = selenium.getFirstWin(); //getting the current window id and storing as first window for later switching
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("omniBtn");
		selenium.jsClick("omniBtn");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("downArrowBtn");
		selenium.jsClick("downArrowBtn");
		selenium.waitingTime(2000);
		if (selenium.getTestCaseName().equalsIgnoreCase("LiveAgentChatDTSCommunity")) {
			selenium.jsClick("omniAvblDTSChat");
			selenium.waitingTime(5000);
		} else {
			selenium.waitForElementToBeClickable("AgentChatAvailable");
			selenium.jsClick("AgentChatAvailable");
			selenium.waitingTime(8000);
		}
		selenium.waitForElementToBeClickable("MyWorkBtn");
		selenium.jsClick("MyWorkBtn");
		selenium.waitingTime(2000);
		String URL=data.get(0);
		System.out.println("Community url: " + URL);
		selenium.openURLinNewTab(URL);
//		selenium.waitingTime(10000);
		System.out.println(URL + " opened successfully");

		}catch (Exception e)
		{
			selenium.closeOminiChannelPopup();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("verify the CXG Live Agent on web page")
	public void verify_the_CXG_live_agent_on_the_web_page(){
		try{
			String FirstName = "Demo";
			String LastName="Test";
			String email=FirstName+LastName+"@mheducation.com";
			String schoolName="DemoTest Public School";
			String userChat="Chat with an agent";
			String userChat1="Hello I have a question";
			String agentResponse="Thank you for Contacting";
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("AcceptAllCookieBtn"))
			{
				selenium.click("AcceptAllCookieBtn");
				selenium.waitingTime(2000);
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChatButton");
			selenium.jsClick("ChatButton");
			selenium.waitingTime(20000);

			selenium.switchToFrame("ChatFormIframe");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("InputChat");
			selenium.typeData("InputChat",userChat);
			selenium.waitingTime(5000);
			selenium.pressEnter("InputChat");
//			selenium.waitForElementToBeClickable("sendButton");
//			selenium.jsClick("sendButton");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("InstructorOption");
			selenium.jsClick("InstructorOption");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("FormFirstName");
			selenium.typeData("FormFirstName",FirstName);
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("FormLastName");
			selenium.typeData("FormLastName",LastName);
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("FormEmail");
			selenium.typeData("FormEmail",email);
			selenium.waitingTime(1000);

			selenium.waitForElementToBeClickable("FormSubmitButton");
			selenium.jsClick("FormSubmitButton");
			selenium.waitingTime(20000);
			if(selenium.isElementPresentFast("FormFlagMsg"))
			{
				selenium.waitForElementToBeClickable("InputChat1");
				selenium.typeData("InputChat1",userChat1);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("sendButton");
				selenium.jsClick("sendButton");
				System.out.println("Message sent successfully");
			}
			else
			{
				System.out.println("No Agent available");
				selenium.test.log(LogStatus.FAIL,"No Agent available");
				selenium.reportFailure("No Agent Available");
			}
			selenium.waitingTime(4000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(15000);
//			selenium.switchToFirstWindow();
			selenium.switchToFirstWin(selenium.firstWindowHandle);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("chatId");
			selenium.jsClick("chatId");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("MinimizeChat");
			selenium.jsClick("MinimizeChat");
			selenium.waitingTime(5000);
			System.out.println("Omni channel minimized");
			String chatReceived=selenium.getText("UserMessage").trim();
			System.out.println("Chat received is: "+chatReceived);
			System.out.println(userChat1);
			if(chatReceived.equals(userChat1)) {
				System.out.println("Message received by Chat Agent successfully");
				selenium.test.log(LogStatus.PASS, "Message received by Chat Agent successfully");
			}
			else {
				System.out.println("Message not received by Chat Agent");
				selenium.test.log(LogStatus.FAIL, "Message not received by Chat Agent");
				selenium.reportFailure("Message not received by Chat Agent");
			}
			System.out.println("Reached here");
//			selenium.switchToFirstWindow();
			selenium.switchToFirstWin(selenium.firstWindowHandle);
			selenium.captureScreenShot();
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("EndChatBtn");
			selenium.scrollToElement("EndChatBtn");
			System.out.println("Reached end chat button");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("AgentChat");
			selenium.typeData("AgentChat", agentResponse);
			selenium.waitingTime(2000);
			selenium.pressEnter("AgentChat");
			selenium.waitingTime(8000);
			selenium.switchToChildWindow();
			selenium.waitingTime(3000);
			selenium.switchToFrame("ChatFormIframe");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("AgentResponse1");
			String resReceived=selenium.getText("AgentResponse1");
			System.out.println("Response sent is: "+resReceived);
			System.out.println(agentResponse);
			if(resReceived.equals(agentResponse)) {
				System.out.println("Message received by User successfully");
				selenium.test.log(LogStatus.PASS, "Message received by User successfully");
			}
			else {
				System.out.println("Message not received by User");
				selenium.test.log(LogStatus.FAIL, "Message not received by User");
				selenium.reportFailure("Message not received by User");
			}
			//Adding below code to avoid the subsequent script failures caused by "Continue logging-into Omni-Channel popup"
			selenium.switchOutOfFrame();
			selenium.close();
			selenium.waitingTime(5000);
//			selenium.switchToFirstWindow();
			selenium.switchToFirstWin(selenium.firstWindowHandle);

			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("EndChatBtn");
			selenium.click("EndChatBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ConfirmEndChatBtn");
			selenium.click("ConfirmEndChatBtn");
			selenium.waitingTime(5000);	
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			
			selenium.waitForElementToBeVisible("CaseNumber1");
			selenium.caseNumber=selenium.getText("CaseNumber1").toString();
			System.out.println("Case No is : "+selenium.caseNumber);
			
			selenium.logoutFromAnyUser();
			selenium.test.log(LogStatus.PASS, "Logout of specific user successful!");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("loginPassword"))
			{
				System.out.println("Main login page appeared so doing login again");
				selenium.doDefaultUATLogin();
			}

		}catch (Exception e)
		{
			selenium.refresh();
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("OmniChannelPopup"))
			{
				selenium.waitForElementToBeClickable("OmniChannelPopupClose");
				selenium.click("OmniChannelPopupClose");
				selenium.waitingTime(4000);
				selenium.logoutFromAnyUser();
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("loginPassword"))
				{
					System.out.println("Main login page appeared so doing login again");
					selenium.doDefaultUATLogin();
				}
			}
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("^verify the case \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_the_case_origin(String origin, String businessHours){
		try{
//		selenium.checkFlowInterruptedPopup();
//		selenium.closeOminiChannelPopup();
//		selenium.checkFlowInterruptedPopup();
//		selenium.waitingTime(2000);
		String casesUrlToday= selenium.getTestDataFromPropertiesFile("TodayOpenedCasesListView");
		selenium.navigateToURL(casesUrlToday);
		selenium.waitingTime(8000);
		selenium.checkFlowInterruptedPopup();
		selenium.closeOminiChannelPopup();
		selenium.checkFlowInterruptedPopup();
		if(selenium.isElementPresentFast("CasesTabLink"))
		{
			selenium.jsClick("CasesTabLink");
			selenium.waitingTime(6000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
		}
		System.out.println(selenium.caseNumber);
		selenium.waitForElementToBeClickable("SearchThisList");
		selenium.click("SearchThisList");
		selenium.waitingTime(2000);
		selenium.typeData("SearchThisList", selenium.caseNumber);
		selenium.pressEnter("SearchThisList");
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("FirstRecordCase");
		selenium.jsClick("FirstRecordCase");
		selenium.waitingTime(5000);
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.checkFlowInterruptedPopup();
		selenium.closeOminiChannelPopup();
		selenium.checkFlowInterruptedPopup();
		selenium.scrolldown(200);
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("case_OriginNew");
		String caseOrigin=selenium.getText("case_OriginNew").toString();
		System.out.println("Case_Origin is : "+caseOrigin);
		String expected_CaseOrigin = origin;
		if(caseOrigin.equalsIgnoreCase(expected_CaseOrigin))
		{
			System.out.println("Case origin is Present : "+caseOrigin);
			selenium.test.log(LogStatus.PASS,"Case origin is : "+caseOrigin);
		}
		else
		{
			System.out.println("Case origin is not Chat");
			selenium.test.log(LogStatus.FAIL,"Case origin is not chat");
			selenium.reportFailure("Case origin is not Chat");
		}
		selenium.waitForElementToBeVisible("Case_BusinessHours");
		String ActualBusinessHours=selenium.getText("Case_BusinessHours").toString();
		System.out.println("Case_BusinessHours is " + ActualBusinessHours);
		String expected_BusinessHours = businessHours;
		if(ActualBusinessHours.equalsIgnoreCase(expected_BusinessHours))
		{
			System.out.println("Business Hours are Matched");
			selenium.test.log(LogStatus.PASS,"Business Hours are Matched");
		}
		else {
			System.out.println("Business Hours are Not Matched");
			selenium.test.log(LogStatus.FAIL,"Business Hours are Not Matched");
			selenium.reportFailure("Business Hours are Not Matched");
		}
		selenium.logoutFromAnyUser();
		selenium.test.log(LogStatus.INFO, "Logout of specific user successful!");
		selenium.waitingTime(4000);
		if(selenium.isElementPresentFast("loginPassword"))
		{
			System.out.println("Main login page appeared so doing login again");
			selenium.doDefaultUATLogin();
		}
		selenium.refresh();
		selenium.waitingTime(5000);
		selenium.checkFlowInterruptedPopup();
		selenium.closeOminiChannelPopup();
		selenium.checkFlowInterruptedPopup();
		}
		catch (Exception e)
		{
			if(selenium.isElementPresentFast("OmniChannelPopup"))
			{
				selenium.waitForElementToBeClickable("OmniChannelPopupClose");
				selenium.click("OmniChannelPopupClose");
				selenium.waitingTime(4000);
				selenium.logoutFromAnyUser();
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("loginPassword"))
				{
					System.out.println("Main login page appeared so doing login again");
					selenium.doDefaultUATLogin();
				}
			}
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}
	
	@And("^Make the omni channel available for cases and chat \"([^\"]*)\" page$")
	public void make_omni_channels_available_for_cases_and_chat(String URL) throws Exception{
		try{
//			selenium.getFirstWindow(); //getting the current window id and storing as first window for later switching
			selenium.firstWindowHandle = selenium.getFirstWin(); //getting the current window id and storing as first window for later switching
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			selenium.takeScreenShot();
			selenium.waitingTime(4000);
			selenium.jsClick("omniBtn");
			selenium.waitingTime(2000);
			selenium.jsClick("downArrowBtn");
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("LiveAgentChatDTSCommunity")) {
				selenium.takeScreenShot();
				selenium.jsClick("omniAvblDTSChat");
				selenium.waitingTime(5000);
			} 
			else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyA3KCustomerSupportChatFunctionality")) {
				Assert.assertTrue(selenium.isElementPresentFast("OmniStatus_AvailableChat"));
				Assert.assertTrue(selenium.isElementPresentFast("OmniStatus_Break"));
				Assert.assertTrue(selenium.isElementPresentFast("OmniStatus_Busy"));
				Assert.assertTrue(selenium.isElementPresentFast("OmniStatus_Offline"));
				selenium.jsClick("OmniStatus_AvailableChat");
				selenium.waitingTime(5000);
			}
			else {
				selenium.jsClick("omniAvlblchatncases");
				selenium.waitingTime(5000);
			}
			selenium.takeScreenShot();
			selenium.jsClick("MyWorkBtn");
			selenium.waitingTime(2000);
			
			if (!selenium.getTestCaseName().equalsIgnoreCase("VerifyA3KCustomerSupportChatFunctionality")) {
			System.out.println("Community url: " + URL);
			selenium.openURLinNewTab(URL);
			System.out.println(URL + " opened successfully");
			}
		}catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@And("^verify the Aleks Live Agent on web pages for \"([^\"]*)\"$")
	public void verify_the_Aleks_Live_Agent_on_web_pages_for(String region) {
		try {
			String value = selenium.getRandomString();
			String valueURL = value + "@mheducation.com";
			String userChat = "Hello I have a question";
			String agentResponse = "Thank you for Contacting";
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			if (selenium.isElementPresentFast("AcceptAllCookieBtn")) {
				selenium.click("AcceptAllCookieBtn");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeVisible(region);
			selenium.jsClick(region);
//			selenium.waitForElementToBeClickable("CanadaLink");
//			selenium.jsClick("CanadaLink");
			selenium.waitingTime(4000);
			selenium.switchToChildWindow();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("LiveChat");
			selenium.jsClick("LiveChat");
			selenium.switchToChildWindow();
			selenium.waitingTime(15000);
			selenium.typeData("AleksFormFNm", value);
			selenium.waitingTime(2000);
			selenium.typeData("AleksFormLNm", value);
			selenium.waitingTime(2000);
			selenium.typeData("AleksFormEmail", valueURL);
			selenium.waitingTime(2000);
			selenium.scrollToElement("AleksFormCntct");
			Select dropdown1 = new Select(selenium.getElement("AleksFormCntct"));
			dropdown1.selectByIndex(1);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CanadaChatCheckbox");
			selenium.jsClick("CanadaChatCheckbox");
			selenium.waitingTime(3000);
			selenium.click("AleksFormStartChatBtn");
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("TxtMessage")) {
				System.out.println("inside live agent chat check");
				selenium.waitingTime(5000);
				selenium.typeData("typeMessage", userChat);
				selenium.waitingTime(2000);
				selenium.jsClick("AleksChatSend");
				System.out.println("Message sent successfully");
			} else {
				System.out.println("FAIL");
				selenium.test.log(LogStatus.FAIL, "<b> *** LiveAgent is either not available or not responding in " + region + " *** </b>");
				selenium.reportFailure("<b> *** LiveAgent is either not available or not responding in " + region + " *** </b>");
			}
//			selenium.waitingTime(15000);
//			selenium.switchToFirstWindow();
			selenium.switchToFirstWin(selenium.firstWindowHandle);
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("alertMessage"))
				selenium.acceptAlert();
			selenium.waitingTime(10000);
			selenium.jsClick("chatId");
			selenium.waitingTime(2000);
			selenium.jsClick("MinimizeChat");
			selenium.waitingTime(5000);
			System.out.println("Omni channel minimized");
			String chatReceived = selenium.getText("UserMessage").trim();
			System.out.println("Chat received is: " + chatReceived);
			System.out.println(userChat);
			if (chatReceived.equals(userChat)) {
				System.out.println("Message received by Chat Agent successfully");
				selenium.test.log(LogStatus.PASS, "Message received by Chat Agent successfully");
			} else {
				System.out.println("Message not received by Chat Agent");
				selenium.test.log(LogStatus.FAIL, "Message not received by Chat Agent");
				selenium.reportFailure("Message not received by Chat Agent");
			}

			System.out.println("Reached here");
//			selenium.switchToFirstWindow();
			selenium.switchToFirstWin(selenium.firstWindowHandle);
			selenium.captureScreenShot();
			selenium.waitForElementToBeVisible("EndChatBtn");
			selenium.scrollToElement("EndChatBtn");
			System.out.println("Reached end chat button");
			selenium.waitingTime(2000);
			selenium.typeData("AgentChat", agentResponse);
			selenium.waitingTime(2000);
			selenium.pressEnter("AgentChat");
			selenium.switchToChildWindow();
			selenium.waitingTime(3000);
			String resReceived = selenium.getText("AgentResponse");
			System.out.println("Response sent is: " + resReceived);
			System.out.println(agentResponse);
			if (resReceived.equals(agentResponse)) {
				System.out.println("Message received by User successfully");
				selenium.test.log(LogStatus.PASS, "Message received by User successfully");
			} else {
				System.out.println("Message not received by User");
				selenium.test.log(LogStatus.FAIL, "Message not received by User");
				selenium.reportFailure("Message not received by User");
			}

			//Adding below code to avoid the subsequent script failures caused by "Continue logging-into Omni-Channel popup"
			selenium.close();
			selenium.waitingTime(5000);
//			selenium.switchToFirstWindow();
			selenium.switchToFirstWin(selenium.firstWindowHandle);
			selenium.waitingTime(2000);
			selenium.maximizeBrowserWindow();
			selenium.waitingTime(2000);
			selenium.scrolldown(-100);
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("EndChatBtn");
			selenium.click("EndChatBtn");
			selenium.waitingTime(2000);
			selenium.click("ConfirmEndChatBtn");
			selenium.waitingTime(5000);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			
			selenium.waitForElementToBeVisible("CaseNumber1");
			selenium.caseNumber=selenium.getText("CaseNumber1").toString();
			System.out.println("Case No is : "+selenium.caseNumber);
			
			selenium.logoutFromAnyUser();
			selenium.test.log(LogStatus.INFO, "Logout of specific user successful!");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("loginPassword"))
			{
				System.out.println("Main login page appeared so doing login again");
				selenium.doDefaultUATLogin();
			}
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
		}
		catch (Exception e)
		{
			if(selenium.isElementPresentFast("OmniChannelPopup"))
			{
				selenium.waitForElementToBeClickable("OmniChannelPopupClose");
				selenium.click("OmniChannelPopupClose");
				selenium.waitingTime(4000);
				selenium.logoutFromAnyUser();
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("loginPassword"))
				{
					System.out.println("Main login page appeared so doing login again");
					selenium.doDefaultUATLogin();
				}
			}
			selenium.reportFailure("<b>Error while verifying live agent</b>" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "<b>Error while verifying live agent</b>");
		}
	}
	@Then("create chat with live agent")
	public void create_chat_with_live_agent(){
		try{
			String FirstName = "Demo";
			String LastName="Test";
			String email=FirstName+LastName+"@mheducation.com";
			String schoolName="DemoTest Public School";
			String userChat="Chat with an agent";
			String userChat1="Hello I have a question";
			String agentResponse="Thank you for Contacting";
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("AcceptAllCookieBtn"))
			{
				selenium.click("AcceptAllCookieBtn");
				selenium.waitingTime(2000);
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChatButton");
			selenium.jsClick("ChatButton");
			selenium.waitingTime(39000);

			selenium.switchToFrame("ChatFormIframe");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("InputChat");
			selenium.typeData("InputChat",userChat);
			selenium.waitingTime(5000);
			selenium.pressEnter("InputChat");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("InstructorOption");
			selenium.jsClick("InstructorOption");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("FormFirstName");
			selenium.typeData("FormFirstName",FirstName);
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("FormLastName");
			selenium.typeData("FormLastName",LastName);
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("FormEmail");
			selenium.typeData("FormEmail",email);
			selenium.waitingTime(1000);

			selenium.waitForElementToBeClickable("FormSubmitButton");
			selenium.jsClick("FormSubmitButton");
			selenium.waitingTime(20000);
			if(selenium.isElementPresentFast("FormFlagMsg"))
			{
				selenium.waitForElementToBeClickable("InputChat1");
				selenium.typeData("InputChat1",userChat1);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("sendButton");
				selenium.jsClick("sendButton");
				System.out.println("Message sent successfully");
			}
			else
			{
				System.out.println("No Agent available");
				selenium.test.log(LogStatus.FAIL,"No Agent available");
				selenium.reportFailure("No Agent Available");
			}
			selenium.waitingTime(4000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(15000);
			selenium.switchToFirstWin(selenium.firstWindowHandle);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("chatId");
			selenium.jsClick("chatId");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("MinimizeChat");
			selenium.jsClick("MinimizeChat");
			selenium.waitingTime(5000);
			System.out.println("Omni channel minimized");
			String chatReceived=selenium.getText("UserMessage").trim();
			System.out.println("Chat received is: "+chatReceived);
			System.out.println(userChat1);
			if(chatReceived.equals(userChat1)) {
				System.out.println("Message received by Chat Agent successfully");
				selenium.test.log(LogStatus.PASS, "Message received by Chat Agent successfully");
			}
			else {
				System.out.println("Message not received by Chat Agent");
				selenium.test.log(LogStatus.FAIL, "Message not received by Chat Agent");
				selenium.reportFailure("Message not received by Chat Agent");
			}
			System.out.println("Reached here");
			selenium.switchToFirstWin(selenium.firstWindowHandle);
			selenium.captureScreenShot();
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("EndChatBtn");
			selenium.scrollToElement("EndChatBtn");
			System.out.println("Reached end chat button");
			selenium.waitingTime(2000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("close the case with Unresponsive chat Lex button")
	public void close_the_case_with_unresponsive_chat_lex_button(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			selenium.scrolldown(5000);
			selenium.waitForElementToBeVisible("CaseNumber1");
			selenium.caseNumber=selenium.getText("CaseNumber1").toString();
			System.out.println("Case No is : "+selenium.caseNumber);
			String casesUrlToday= selenium.getTestDataFromPropertiesFile("TodayOpenedCasesListView");
			selenium.navigateToURL(casesUrlToday);
//			selenium.waitingTime(2000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			if(selenium.isElementPresentFast("CasesTabLink"))
			{
				selenium.jsClick("CasesTabLink");
				selenium.waitingTime(6000);
			}
			selenium.waitForElementToBeClickable("SearchThisList");
			selenium.click("SearchThisList");
			selenium.waitingTime(2000);
			selenium.typeData("SearchThisList", selenium.caseNumber);
			selenium.pressEnter("SearchThisList");
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();

			selenium.waitForElementToBeClickable("FirstRecordCase");
			selenium.jsClick("FirstRecordCase");
			selenium.waitingTime(5000);
			
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			if(selenium.isElementPresentFast("UnResponsiveLEXButton"))
			{
				selenium.waitForElementToBeClickable("UnResponsiveLEXButton");
				selenium.jsClick("UnResponsiveLEXButton");
			}
			else
			{
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("UnresponsiveChatLEXOption");
				selenium.click("UnresponsiveChatLEXOption");
			}
			selenium.waitingTime(15000);
			selenium.acceptAlert();
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("Case_Status_1");
			String caseStatus=selenium.getText("Case_Status_1").toString();
			System.out.println(caseStatus);
			if(caseStatus.equalsIgnoreCase("Closed - Unconfirmed"))
			{
				System.out.println("Status is Closed");
				selenium.test.log(LogStatus.PASS,"Status is Closed");
			}
			else
			{
				System.out.println("Status is not Closed");
				selenium.test.log(LogStatus.FAIL,"Status is not Closed");
				selenium.reportFailure("Status is not Closed");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
}
