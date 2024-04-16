package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHESSalesRepViewTerritoriesFromAccountsTest {
	
WebConnector selenium = WebConnector.getInstance();
//public String TerrAccount="https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000cMbA3AAK/view";
	
	@Then("^I navigate to territories from account$")
	public void I_navigate_to_territories_from_account() {
		try {

			if (selenium.getUI().contains("Lightning")) {

/*				selenium.search("Account Name");
				selenium.waitingTime(4000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
				selenium.clickLoopXpath(Xpath);*/
				
//				selenium.waitingTime(2000);
//				selenium.navigateToURL(TerrAccount);				
//				selenium.waitingTime(8000);
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("territoriesLink");
				selenium.jsClick("territoriesLink");
				selenium.waitingTime(2000);

			}

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}

	}
	
	@And("^verify territories list within the account$")
	public void verify_contact_list_within_the_account() {
		try {
			WebElement table = selenium.getElement("productCourseTable_New");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("th"));
					WebElement column = columnsList.get(0);
					System.out.print(column.getText());
					if (column.getText() != null) {
						selenium.test.log(LogStatus.INFO, "Territories Details: " + column.getText());
					}
					continue;

			}
			selenium.test.log(LogStatus.INFO, "All the territories details tied to account are listed");
			
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

}
