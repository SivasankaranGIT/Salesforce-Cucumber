package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHHESalesRepViewOpportunityFromAccountsTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^I navigate to opportunity from account$")
	public void I_navigate_to_opportunity_from_account() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.search("Account Name");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
				selenium.clickLoopXpath(Xpath);
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("accountsOpportunityLink1");
				selenium.jsClick("accountsOpportunityLink1");
				selenium.waitingTime(2000);

			}

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
	
	@And("^verify opportunity list within the account$")
	public void verify_contact_list_within_the_account() {
		try {
			WebElement table = selenium.getElement("productCourseTable");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));
					WebElement column = columnsList.get(0);
					System.out.print(column.getText());
					if (column.getText() != null) {
						selenium.test.log(LogStatus.INFO, "Opportunity Details: " + column.getText());
					}
					continue;

			}
			selenium.test.log(LogStatus.PASS, "All the opportunity details tied to account are listed");
			
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

}
