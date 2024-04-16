#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Sample_Verify that the customer default shipping address will be based on Account
  	primary shipping address when contact preferred address & Department Address 
  		both are not found

  Background: 
    Given I am logged into salesforce for "Sample_AccountqPrimaryShippingAddress"

	@Samples @TC09_US_Sample_VerifyThatTheCustomersDefaultShippingAddressWillBeBasedOnAccountqPrimaryShippingAddress @GCRM-9265
  Scenario Outline: VerifyUserCanPickDifferentAddressThanDefault
    Given Runmode for "Sample_AccountqPrimaryShippingAddress" is Y
#    Then I login as Sales Rep
      Then I do login as "<MHHE_Sales_Representative>"
    When I navigate to contacts tab
    Then global search for contact
    Then click on account link and verify shipping address
    Then click on sample contact button
    Then search for product and click on next
    Then verify address on page and click on create sample order

    Examples:
    |MHHE_Sales_Representative|
    |Jenna_Taylor|