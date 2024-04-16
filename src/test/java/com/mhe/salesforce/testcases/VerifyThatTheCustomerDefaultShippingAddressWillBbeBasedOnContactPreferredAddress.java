package com.mhe.salesforce.testcases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class VerifyThatTheCustomerDefaultShippingAddressWillBbeBasedOnContactPreferredAddress {
	
	
WebConnector selenium = WebConnector.getInstance();
	
@Then("^open address link in new tab to verify ContactPrefferedaddres checkbox$")
public void open_address_link_in_new_tab_to_verify_ContactPrefferedaddres_checkbox() {
   
    try {
         //selenium.waitingTime(10000);
         //String clickLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
         //selenium.getElement("addressJordan").sendKeys(clickLink);
//       selenium.waitingTime(10000);
       //selenium.scrollToElement("showAllLinksContact_samp");
		 selenium.waitForElementToBeClickable("showAllLinksContact_samp");
         selenium.click("showAllLinksContact_samp");
//         selenium.waitingTime(4000);
 		 selenium.waitForElementToBeClickable("addressJordan_samp");
         selenium.jsClick("addressJordan_samp");
         selenium.waitingTime(4000);
         selenium.captureScreenShot();

}
    catch (Exception e) {
         selenium.reportFailure("Error while Searching for address " + e.getMessage());
         selenium.test.log(LogStatus.FAIL, "Test Case Failed");
         }

try{
   
   //String xpath=selenium.getDynamicXpath("anchorTitlecontains","AddressFull","endContainsContactPrefferedAdressCheckbox");
   //List<WebElement> checkBoxesList = selenium.getXpathElements(xpath);
   String xpath = selenium.getPropertiesObj().getProperty("tablerow");
   int count =0; int set =0;

      for (int i = 1; i <= selenium.getXpathElements(xpath).size(); i++) {
         System.out.println("size="+selenium.getXpathElements(xpath).size());
         //String indexedXpath=selenium.getDynamicXpathIndexed("anchorTitlecontains", "AddressFull", "endContainsContactPrefferedAdressCheckbox", i);
         String indexedXpath = selenium.getPropertiesObj().getProperty("tablerow_alt")+"["+i+"]";
         System.out.println(selenium.getXpathElement(indexedXpath).getAttribute("alt"));
         if (selenium.getXpathElement(indexedXpath).getAttribute("alt").equals("True")) {
            
            count++;
            break;
         }
         else {
            set++;
         }

      }

   System.out.println("set="+set);
   System.out.println("count="+ count);
   if(count >= 1){
    System.out.println("Contact preffered address present");
   }
   else
      selenium.reportFailure("NO contact preffered address ");
}
catch (Exception e) {
   selenium.reportFailure("Error while Searching for contact preffered address " + e.getMessage());
   selenium.test.log(LogStatus.FAIL, "Test Case Failed");
   }
//try{
//selenium.wait(2000);
//selenium.getElement("addressJordan").sendKeys(Keys.CONTROL + "\t");
//selenium.wait(4000);
//}
//catch(InterruptedException e1){
// e1.printStackTrace();
//}

try {
   
   selenium.navigateBack();
   
} 
catch (Exception e) {
   selenium.reportFailure("Error while Navigating back " + e.getMessage());
   selenium.test.log(LogStatus.FAIL, "Test Case Failed");
}
}
}
