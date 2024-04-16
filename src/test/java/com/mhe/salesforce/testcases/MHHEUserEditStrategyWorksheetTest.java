package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEUserEditStrategyWorksheetTest {
	WebConnector selenium = WebConnector.getInstance();
	String WSOpp_URL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001EPsQcAAL/view";


	@Then("^edit a strategy worksheet$")
	public void edit_strategy_worksheet() throws InterruptedException {
		try {
		
		/*selenium.search("Opportunity Name");
		selenium.waitingTime(3000);

		String xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(xpath);*/
		selenium.navigateToURL(WSOpp_URL);
		selenium.waitingTime(8000);

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
		selenium.waitForElementToBeClickable("voteTallyEditIcon");
		selenium.click("voteTallyEditIcon");
		selenium.waitingTime(10000);
		selenium.waitForElementToBeClickable("voteTallyDrpDwn");
		selenium.selectDropdownText("voteTallyDrpDwn", "Vote Tally");
		selenium.waitingTime(2000);

		selenium.scrollToElement("Button_Save");

		/*selenium.clickLoop("decisionDriverEditIcon");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("decisionDriverDrpDwn", "Decision Driver");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("decisionMakerEditIcon");
		selenium.click("decisionMakerEditIcon");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("decisionMakerDrpDwn", "Decision Maker");
		selenium.waitingTime(2000);*/
		selenium.waitForElementToBeClickable("Button_Save");
		selenium.jsClick("Button_Save");
		selenium.waitingTime(8000);

		selenium.switchOutOfFrame();
		//selenium.waitForElementToBeVisible("strategyWorksheetBtn");
		selenium.clickLoop("strategyWorksheetBtn");
		selenium.waitingTime(8000);
		selenium.refresh();
		selenium.waitingTime(12000);
		selenium.waitForElementToBeVisible("newAccountFrame");
		selenium.switchToMultipleFrame("newAccountFrame");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("voteNew");
		String voteTally = selenium.getTextLoop("voteNew");
		String expected_voteTally = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Vote Tally");
		if (voteTally.equalsIgnoreCase(expected_voteTally)) {
			selenium.test.log(LogStatus.PASS, "Changes are reflecting as: " + voteTally);
			System.out.println("PASS");
		} else {
			selenium.test.log(LogStatus.FAIL, "Changes are not reflecting");
			selenium.reportFailure("Test Case Failed");
			System.out.println("FAIL");
		}
		selenium.switchOutOfFrame();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^edit a strategy worksheet for marketing user$")
	public void edit_strategy_worksheet_mkt() throws InterruptedException {
		try {

		selenium.waitingTime(6000);
        selenium.search("Opportunity Name Mkt");
        selenium.waitingTime(6000);
        String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name Mkt", "endContains");
        selenium.waitingTime(4000);
        selenium.clickLoopXpath(Xpath);                      
        selenium.waitingTime(5000);

		String xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name Mkt", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(xpath);
		selenium.waitingTime(8000);
		selenium.refresh();
		selenium.waitingTime(10000);
		selenium.takeScreenShot();
		selenium.waitForElementToBeClickable("strategyWorksheetBtn");
		selenium.clickLoop("strategyWorksheetBtn");
		selenium.waitingTime(10000);
//		selenium.refresh();
//		selenium.waitingTime(10000);
		selenium.takeScreenShot();
		selenium.waitForElementToBeVisible("productframeUat");
		selenium.switchToMultipleFrame("productframeUat");
		
		if(!selenium.isElementPresentFast("voteTallyEditIcon"))
		{
			System.out.println("voteTallyEditIcon element is not visible, so refreshing page..");
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("productframeUat");
			selenium.switchToMultipleFrame("productframeUat");
		}

		selenium.waitForElementToBeClickable("voteTallyEditIcon");
		selenium.click("voteTallyEditIcon");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("voteTallyDrpDwn", "Vote Tally");
		selenium.waitingTime(2000);

		selenium.scrollToElement("professorSectionHeader");

		/*selenium.click("decisionDriverEditIcon");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("decisionDriverDrpDwn", "Decision Driver");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("decisionMakerEditIcon");
		selenium.click("decisionMakerEditIcon");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("decisionMakerDrpDwn", "Decision Maker");
		selenium.waitingTime(2000);*/
		selenium.waitForElementToBeClickable("Button_Save");
		selenium.click("Button_Save");
		selenium.waitingTime(45000);// 45 sec added 

		selenium.switchOutOfFrame();
		//selenium.waitForElementToBeVisible("strategyWorksheetBtn");
		selenium.clickLoop("strategyWorksheetBtn");
		selenium.waitingTime(5000);
		selenium.switchToMultipleFrame("productframeUat");

		selenium.waitForElementToBeVisible("opportunityNameSWGetText");

		String voteTally = selenium.getTextLoop("voteNew");
		String expected_voteTally = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Vote Tally");
		if (voteTally.equalsIgnoreCase(expected_voteTally)) {
			selenium.test.log(LogStatus.PASS, "Changes are reflecting as: " + voteTally);
			System.out.println("PASS");
		} else {
			selenium.test.log(LogStatus.FAIL, "Changes are not reflecting");
			selenium.reportFailure("Test Case Failed");
		}
		selenium.switchOutOfFrame();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

}
