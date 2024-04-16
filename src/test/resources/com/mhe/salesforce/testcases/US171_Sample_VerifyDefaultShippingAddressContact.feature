#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature:Verify that the customer's default shipping address will be based on contact preferred address when available

Background: 
    Given I am logged into salesforce for "Sample_ContactPreferredAddress"

 @Samples
 @TC07_US_Sample_VerifyThatTheCustomerDefaultShippingAddressWillBbeBasedOnContactPreferredAddressWhenAvailable
 @GCRM-9267
  Scenario Outline: Sample_VerifyThatTheCustomerDefaultShippingAddressWillBbeBasedOnContactPreferredAddressWhenAvailable
  
  Given Runmode for "Sample_ContactPreferredAddress" is Y
#  Then I login as Sales Rep
  Then I do login as "<MHHE_Sales_Representative>"
  When I navigate to contacts tab
  Then global search for contact
  And New click on contact based on account names
  Then click on sample contact button
	Then search for product and click on next
	Then verify address and click on create sample order
  
  Examples: 
  |MHHE_Sales_Representative|
  |Jenna_Taylor|