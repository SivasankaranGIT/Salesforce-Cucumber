package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChatChannelSupport {
	
WebConnector selenium = WebConnector.getInstance();
	

@Then("^open CSOM support page$")
public void open_csom_support_page() {
 try {
	 selenium.switchToFrame("newAccountFrame");
	 selenium.waitingTime(2000);
	 selenium.waitForElementToBeVisible("CSOMUrl");
	 String CSOMurl = selenium.getText("CSOMUrl");
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
//	 selenium.waitingTime(4000);
 }
 catch (Exception e) {
	 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error while loading CSOM Supoport URL  " + e.getMessage());
	}
}

	 
@And("^verify BOT on homepage$")
public void verify_bot_on_homepage() {
		 try {
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			 selenium.waitForElementToBeVisible("csomChatBot");
			boolean csomBot= selenium.isElementPresentFast("csomChatBot");
			if(csomBot==true)
			{
				System.out.println("inside bot check");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("csomChatBot");
				selenium.click("csomChatBot");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeVisible("csomBotChatArea");
					if(selenium.isElementPresentFast("csomBotChatArea"))
					{
						System.out.println("inside pass");
						selenium.test.log(LogStatus.PASS, "CSOM Bot Available" );					 
					}
					 else
					 { 
							selenium.refresh();
							selenium.waitingTime(8000);
							if(selenium.isElementPresentFast("csomBotChatArea"))
							{
								System.out.println("inside pass");
								selenium.test.log(LogStatus.PASS, "CSOM Bot Available" );							 
							}
							else
							{ 
								System.out.println("inside fail");
								selenium.test.log(LogStatus.FAIL, "CSOM Bot not Available" );
								selenium.reportFailure("CSOM Bot not Available");
							}
					 }
			}
			selenium.waitingTime(8000);
			 selenium.captureScreenShot();
			 selenium.waitingTime(2000);
			 selenium.navigateBack();
			 selenium.waitingTime(5000);
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying CSOM chat bot" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }

@Then("^open DTS support page$")
public void open_dts_support_page() {
 try {
	 selenium.switchToFrame("newAccountFrame");
	 selenium.waitingTime(2000);
	 selenium.waitForElementToBeVisible("DTSUrl_01");
	 String DTSUrl = selenium.getText("DTSUrl_01");
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
	 selenium.waitingTime(4000);
	 
 }
 catch (Exception e) {
	 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error while loading DTS Supoport URL  " + e.getMessage());
	}
}
	
@Then("^open ALEKS support page$")
public void open_ALEKS_support_page() {
 try {
	 
	 selenium.switchToFrame("newAccountFrame");
	 selenium.waitingTime(5000);
	 selenium.waitForElementToBeVisible("ALEKSSupportURL");
	 String ALEKSurl = selenium.getText("ALEKSSupportURL");
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
//	 selenium.waitingTime(4000);
	
 }
 catch (Exception e) {
	 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error while loading ALEKS Supoport URL  " + e.getMessage());
	}
}
	
@And("^verify BOT not present on homepage$")
public void verify_bot_not_present_on_homepage() {
		 try {
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeVisible("csomChatBot");
			boolean csomBot= selenium.isElementPresentFast("csomChatBot");
			if(csomBot==false) {
				System.out.println("inside bot check");
					 selenium.test.log(LogStatus.PASS, "ALEKS Bot not available on homepage" );
					 
				 }
				 else { 
					 System.out.println("inside fail");
					 selenium.test.log(LogStatus.FAIL, "ALEKS Bot available on homepage" );
					 selenium.reportFailure("ALEKS Bot available on homepage");
				 
				}
				
			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 selenium.navigateBack();
			 selenium.waitingTime(5000);
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying ALEKS chat bot" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }


@Then("^login into \"([^\"]*)\" page using \"([^\"]*)\" and \"([^\"]*)\"$")
public void login_into_connect_platform_page(String URL, String EmailID, String Password)
{
	try
	{
		selenium.navigateToURL(URL);
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ConnectChatbotEmailAddress");
		selenium.typeData("ConnectChatbotEmailAddress",EmailID);
		selenium.waitForElementToBeClickable("ConnectChatbotPassword");
		selenium.typeData("ConnectChatbotPassword",Password);
		selenium.waitForElementToBeClickable("ConnectChatbotSigninBtn");
		selenium.click("ConnectChatbotSigninBtn");
		selenium.waitingTime(10000);
		selenium.waitForElementToBeClickable("TipsAndTutorialsBtn");
		selenium.click("TipsAndTutorialsBtn");
		selenium.waitForElementToBeClickable("ContactSupportOption");
		selenium.click("ContactSupportOption");
		selenium.waitingTime(2000);
		selenium.switchToChildWindow();
		selenium.waitingTime(2000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("Error while logging-in to connect platform page" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Error while logging-in to connect platform page");
	}
}

@Then("^Open \"([^\"]*)\" page$")
public void open_chatbot_page(String URL)
{
	try
	{
		selenium.navigateToURL(URL);
		selenium.waitingTime(5000);		
	}
	catch (Exception e)
	{
		selenium.reportFailure("Error while navigating to chatbot page" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Error while navigating to chatbot page");
	}
}

@And("verify the \"([^\"]*)\" chatbot on \"([^\"]*)\" page$")
public void verify_the_chatbot(String ChatCommunityType, String URL)
{
	try
	{
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("csomChatBot");
		boolean csomBot= selenium.isElementPresentFast("csomChatBot");
		if(csomBot==true)
		{
			System.out.println("inside bot check");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("csomChatBot");
			selenium.click("csomChatBot");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("csomBotChatArea");
			if(selenium.isElementPresentFast("csomBotChatArea"))
			{
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS, "<b> *** " + " Chatbot is available & it is responding in " + URL + " *** </b>");					 
			}
			 else
			 { 
				selenium.refresh();
				selenium.waitingTime(8000);
				if(selenium.isElementPresentFast("csomBotChatArea"))
				{
					System.out.println("PASS");
					selenium.test.log(LogStatus.PASS, "<b> *** " + " Chatbot is available & it is responding in " + URL + " *** </b>");							 
				}
				else
				{ 
					System.out.println("FAIL");
					selenium.test.log(LogStatus.FAIL, "<b> *** " + " Chatbot is either not available or not responding in " + URL + " *** </b>");
					selenium.reportFailure("<b> *** " + " Chatbot is either not available or not responding in " + URL + " *** </b>");
				}
			 }
		}
		 selenium.waitingTime(8000); //wait for all default chat options to load
		 selenium.captureScreenShot();
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("CSOM_DTS_CloseChatBotPopup");
		 selenium.click("CSOM_DTS_CloseChatBotPopup");
		 selenium.waitForElementToBeClickable("CSOM_DTS_ConfirmEndChatBtn");
		 selenium.click("CSOM_DTS_ConfirmEndChatBtn");
		 selenium.waitForElementToBeClickable("CSOM_DTS_CloseChatBtn");
		 selenium.click("CSOM_DTS_CloseChatBtn");
		 selenium.waitingTime(2000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("<b>Error while verifying chatbot</b>" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "<b>Error while verifying chatbot</b>");
	}
}

@And("^navigate to CXG chatbot page by using Help link$")
public void navigate_to_CXG_chatbot_page_by_using_Help_Link()
{
	try
	{
		selenium.waitForElementToBeClickable("HelpLink");
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		selenium.jsClick("HelpLink");
		selenium.waitingTime(2000);
		selenium.switchToChildWindow();
		selenium.waitingTime(2000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("<b>Error while navigating to chatbot page</b>" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "<b>Error while navigating to chatbot page</b>");
	}
}

@And("^navigate to CXG chatbot page by using support button$")
public void navigate_to_CXG_chatbot_page_by_using_Support_Button()
{
	try
	{
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("AcceptAllCookieBtn"))
		{
			selenium.click("AcceptAllCookieBtn");
			selenium.waitingTime(2000);
		}
		
		selenium.waitForElementToBeClickable("SupportBtn");
		selenium.jsClick("SupportBtn");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ChatWithRepLink");
		selenium.jsClick("ChatWithRepLink");
		selenium.waitingTime(2000);
		selenium.switchToChildWindow();
		selenium.waitingTime(2000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("<b>Error while navigating to chatbot page</b>" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "<b>Error while navigating to chatbot page</b>");
	}
}

@And("^close the CXG chatbot page and navigate back to parent page$")
public void navigate_back_to_parent_page()
{
	try
	{
		selenium.close();
		selenium.waitingTime(2000);
		selenium.switchBackToParentWindow();
		selenium.waitingTime(2000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("<b>Error while navigating back to parent page</b>" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "<b>Error while navigating back to parent page</b>");
	}
}

@And("^verify the CXG chatbot on \"([^\"]*)\" page$")
public void verify_CXG_chatbot(String URL)
{
	try
	{
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("AcceptAllCookieBtn"))
		{
			selenium.click("AcceptAllCookieBtn");
			selenium.waitingTime(2000);
		}
		selenium.waitForElementToBeVisible("CXG_ChatbotIcon");
		boolean cxgBot= selenium.isElementPresentFast("CXG_ChatbotIcon");
		if(cxgBot==true)
		{
			System.out.println("inside bot check");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CXG_ChatbotIcon");
			selenium.click("CXG_ChatbotIcon");
			selenium.waitingTime(20000);
			selenium.switchToFrame("ChatFormIframe");
			selenium.waitForElementToBeVisible("CXG_ChatbotTextArea");
			if(selenium.isElementPresentFast("CXG_ChatbotTextArea"))
			{
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS, "<b> *** Chatbot is Available & it is responding in " + URL + " *** </b>");				 
			}
			 else
			 { 
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("CXG_ChatbotIcon");
				selenium.click("CXG_ChatbotIcon");
				selenium.waitingTime(20000);
				if(selenium.isElementPresentFast("CXG_ChatbotTextArea"))
				{
					System.out.println("PASS");
					selenium.test.log(LogStatus.PASS, "<b> *** Chatbot is Available & it is responding in " + URL + " *** </b>");							 
				}
				else
				{ 
					System.out.println("FAIL");
					selenium.test.log(LogStatus.FAIL, "<b> *** Chatbot is either not available or not responding in " + URL + " *** </b>");
					selenium.reportFailure("<b> *** Chatbot is either not available or not responding in " + URL + " *** </b>");
				}
			 }
		}
		else
		{
			System.out.println("FAIL");
			selenium.test.log(LogStatus.FAIL, "<b> *** Chatbot is either not available or not responding in " + URL + " *** </b>");
			selenium.reportFailure("<b> *** Chatbot is either not available or not responding in " + URL + " *** </b>");
		}
		 selenium.switchOutOfFrame();
		 selenium.waitingTime(8000); //wait for all default chat options to load
		 selenium.captureScreenShot();
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("CXG_ChatbotCloseBtn");
		 selenium.click("CXG_ChatbotCloseBtn");
		 selenium.waitingTime(2000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("<b>Error while verifying chatbot</b>" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "<b>Error while verifying chatbot</b>");
	}
}

@And("^verify the chatbot on \"([^\"]*)\" page$")
public void verify_chatbot(String URL)
{
	try
	{
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("AcceptAllCookieBtn"))
		{
			selenium.click("AcceptAllCookieBtn");
			selenium.waitingTime(2000);
		}
		selenium.waitForElementToBeVisible("CXG_ChatbotIcon");
		boolean cxgBot= selenium.isElementPresentFast("CXG_ChatbotIcon");
		if(cxgBot==true)
		{
			System.out.println("inside bot check");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CXG_ChatbotIcon");
			selenium.click("CXG_ChatbotIcon");
			selenium.waitingTime(20000);
			selenium.switchToFrame("ChatFormIframe");
			selenium.waitForElementToBeVisible("InstructorSupport_ChatOptions");
			if(selenium.isElementPresentFast("InstructorSupport_ChatOptions"))
			{
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS, "<b> *** Chatbot is available & it is responding in " + URL + " *** </b>");				 
			}
			 else
			 { 
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("CXG_ChatbotIcon");
				selenium.click("CXG_ChatbotIcon");
				selenium.waitingTime(20000);
				if(selenium.isElementPresentFast("InstructorSupport_ChatOptions"))
				{
					System.out.println("PASS");
					selenium.test.log(LogStatus.PASS, "<b> *** Chatbot is available & it is responding in " + URL + " *** </b>");							 
				}
				else
				{ 
					System.out.println("FAIL");
					selenium.test.log(LogStatus.FAIL, "<b> *** Chatbot is either not available or not responding in " + URL + " *** </b>");
					selenium.reportFailure("<b> *** Chatbot is either not available or not responding in " + URL + " *** </b>");
				}
			 }
		}
		 selenium.switchOutOfFrame();
		 selenium.waitingTime(8000); //wait for all default chat options to load
		 selenium.captureScreenShot();
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("InstructorSupport_CloseBtn");
		 selenium.click("InstructorSupport_CloseBtn");
		 selenium.waitingTime(2000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("<b>Error while verifying chatbot</b>" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "<b>Error while verifying chatbot</b>");
	}
}

@And("^verify the Aleks Live Agent on web page for \"([^\"]*)\"$")
public void verify_the_Aleks_Live_Agent(String region)
{
	try
	{
		String value = selenium.getRandomString();
		String valueURL=value + "@mheducation.com";
		String userChat="Hello I have a question";
		String agentResponse="Thank you for Contacting";
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.checkFlowInterruptedPopup();
		selenium.closeOminiChannelPopup();
		selenium.checkFlowInterruptedPopup();
		if(selenium.isElementPresentFast("AcceptAllCookieBtn"))
		{
			selenium.click("AcceptAllCookieBtn");
			selenium.waitingTime(2000);
		}
		selenium.waitForElementToBeVisible(region);
		selenium.jsClick(region);
		selenium.switchToChildWindow();
		selenium.waitingTime(10000);
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
		selenium.waitingTime(1000);
        if(selenium.isElementPresentsuperFast("ChatAgentAgreementCheckbox"))
        {
        	selenium.jsClick("ChatAgentAgreementCheckbox");
        }
		selenium.waitingTime(2000);
		selenium.click("AleksFormStartChatBtn");
		selenium.waitingTime(10000);
		if(selenium.isElementPresentFast("TxtMessage"))
		{
			System.out.println("inside live agent chat check");
			selenium.waitingTime(5000);
			selenium.typeData("typeMessage",userChat);
			selenium.waitingTime(2000);
			selenium.jsClick("AleksChatSend");
			System.out.println("Message sent successfully");
		}
		else
		{ 
			System.out.println("FAIL");
			selenium.test.log(LogStatus.FAIL, "<b> *** LiveAgent is either not available or not responding in " + region + " *** </b>");
			selenium.reportFailure("<b> *** LiveAgent is either not available or not responding in " + region + " *** </b>");
		}
		selenium.waitingTime(15000);
//		selenium.switchToFirstWindow();
		selenium.switchToFirstWin(selenium.firstWindowHandle);
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("alertMessage")) 
			selenium.acceptAlert();
		selenium.waitingTime(10000);
		selenium.jsClick("chatId");
		selenium.waitingTime(2000);
		selenium.jsClick("MinimizeChat");
		selenium.waitingTime(5000);
		System.out.println("Omni channel minimized");
		String chatReceived=selenium.getText("UserMessage").trim();
		System.out.println("Chat received is: "+chatReceived);
		System.out.println(userChat);
		if(chatReceived.equals(userChat)) {
			System.out.println("Message received by Chat Agent successfully");
			selenium.test.log(LogStatus.PASS, "Message received by Chat Agent successfully");
		}
		else {
			System.out.println("Message not received by Chat Agent");
			selenium.test.log(LogStatus.FAIL, "Message not received by Chat Agent");
			selenium.reportFailure("Message not received by Chat Agent");
		}
		
		System.out.println("Reached here");
//		selenium.switchToFirstWindow();
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
		String resReceived=selenium.getText("AgentResponse");
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
		selenium.close();
		selenium.waitingTime(5000);
//		selenium.switchToFirstWindow();
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
		selenium.waitingTime(15000);		
		selenium.checkFlowInterruptedPopup();		
		selenium.closeOminiChannelPopup();
		selenium.checkFlowInterruptedPopup();		
		if (selenium.isElementPresentFast("CaseInterruptPopupOKBtn")) {
			selenium.click2("CaseInterruptPopupOKBtn");
			selenium.waitingTime(5000);
		}		
		selenium.waitForElementToBeVisible("CaseNumber1");
		selenium.caseNumber=selenium.getText("CaseNumber1").toString();
		System.out.println("Case No is : "+selenium.caseNumber);		
		
		
		selenium.waitForElementToBeVisible("omniBtn");
		selenium.jsClick("omniBtn");
		selenium.waitingTime(2000);
		selenium.jsClick("downArrowBtn");
		selenium.waitingTime(2000);
		selenium.jsClick("omnichatOffline");
		selenium.waitingTime(5000);
		
		/*selenium.logoutFromAnyUser();
		selenium.test.log(LogStatus.PASS, "Logout of specific user successful!");
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
		selenium.checkFlowInterruptedPopup();*/
	}
	catch (Exception e)
	{
		selenium.maximizeBrowserWindow();
		selenium.waitingTime(5000);
		if(selenium.isElementPresentFast("OmniChannelPopup"))
		{
			selenium.waitForElementToBeClickable("OmniChannelPopupClose");
			selenium.click("OmniChannelPopupClose");
			selenium.waitingTime(4000);
			
			selenium.waitForElementToBeVisible("omniBtn");
			selenium.jsClick("omniBtn");
			selenium.waitingTime(2000);
			selenium.jsClick("downArrowBtn");
			selenium.waitingTime(2000);
			selenium.jsClick("omnichatOffline");
			selenium.waitingTime(5000);
			
			/*selenium.logoutFromAnyUser();
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("loginPassword"))
			{
				System.out.println("Main login page appeared so doing login again");
				selenium.doDefaultUATLogin();
			}*/
		}
		selenium.reportFailure("<b>Error while verifying live agent</b>" + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "<b>Error while verifying live agent</b>");
	}
}
 @Then("^verify the ALEKS business hours \"([^\"]*)\"$")
	public void verify_ALEKS_business_hours(String region){
	 try
	 {
		 String value = selenium.getRandomString();
		 String valueURL=value + "@mheducation.com";
		 String userChat="Hello I have a question";
		 String agentResponse="Thank you for Contacting";
		 selenium.refresh();
		 selenium.waitingTime(8000);
		 selenium.checkFlowInterruptedPopup();
		 selenium.captureScreenShot();
		 selenium.waitingTime(2000);
		 selenium.checkFlowInterruptedPopup();
		 selenium.closeOminiChannelPopup();
		 selenium.checkFlowInterruptedPopup();
		 if(selenium.isElementPresentFast("AcceptAllCookieBtn"))
		 {
			 selenium.click("AcceptAllCookieBtn");
			 selenium.waitingTime(2000);
		 }
		 selenium.waitForElementToBeVisible(region);
		 selenium.jsClick(region);
		 selenium.switchToChildWindow();
		 selenium.waitingTime(10000);
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
		 selenium.click("AleksFormStartChatBtn");
		 selenium.waitingTime(10000);
		 if(selenium.isElementPresentFast("TxtMessage"))
		 {
			 System.out.println("inside live agent chat check");
			 selenium.waitingTime(5000);
			 selenium.typeData("typeMessage",userChat);
			 selenium.waitingTime(2000);
			 selenium.jsClick("AleksChatSend");
			 System.out.println("Message sent successfully");
		 }
		 else
		 {
			 System.out.println("FAIL");
			 selenium.test.log(LogStatus.FAIL, "<b> *** LiveAgent is either not available or not responding in " + region + " *** </b>");
			 selenium.reportFailure("<b> *** LiveAgent is either not available or not responding in " + region + " *** </b>");
		 }
		 selenium.waitingTime(15000);
//		 selenium.switchToFirstWindow();
		 selenium.switchToFirstWin(selenium.firstWindowHandle);
		 selenium.waitingTime(2000);
		 if(selenium.isElementPresentFast("alertMessage"))
			 selenium.acceptAlert();
		 selenium.waitingTime(10000);
		 selenium.jsClick("chatId");
		 selenium.waitingTime(2000);
		 selenium.jsClick("MinimizeChat");
		 selenium.waitingTime(5000);
		 System.out.println("Omni channel minimized");
		 String chatReceived=selenium.getText("UserMessage").trim();
		 System.out.println("Chat received is: "+chatReceived);
		 System.out.println(userChat);
		 if(chatReceived.equals(userChat)) {
			 System.out.println("Message received by Chat Agent successfully");
			 selenium.test.log(LogStatus.PASS, "Message received by Chat Agent successfully");
		 }
		 else {
			 System.out.println("Message not received by Chat Agent");
			 selenium.test.log(LogStatus.FAIL, "Message not received by Chat Agent");
			 selenium.reportFailure("Message not received by Chat Agent");
		 }

		 System.out.println("Reached here");
//		 selenium.switchToFirstWindow();
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
		 String resReceived=selenium.getText("AgentResponse");
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
		 selenium.close();
		 selenium.waitingTime(5000);
//		 selenium.switchToFirstWindow();
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
		 String casesUrlToday= selenium.getTestDataFromPropertiesFile("TodayOpenedCasesListView");
		 selenium.navigateToURL(casesUrlToday);
		 selenium.waitingTime(8000);
		 selenium.checkFlowInterruptedPopup();
		 selenium.closeOminiChannelPopup();
		 selenium.checkFlowInterruptedPopup();
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
	//	 selenium.refresh();
	//	 selenium.waitingTime(8000);
		 selenium.scrolldown(150);
		 selenium.waitForElementToBeVisible("Case_BusinessHours");
		 String businessHours=selenium.getText("Case_BusinessHours").toString();
		 System.out.println(businessHours);
		 if(businessHours.equalsIgnoreCase("ALEKS Support"))
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
		 selenium.test.log(LogStatus.PASS, "Logout of specific user successful!");
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

}
