#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Sample Status after address verification

  Background: 
    Given I am logged into salesforce for "Sample_VerifySampleStatus"

	@Samples
  @TC29_US_Sample_VerifySampleStatusChangeWhenAddressVerified @GCRM-9261
  Scenario Outline: VerifySampleStatus
  Given Runmode for "Sample_VerifySampleStatus" is Y
  Then I do login as "<MHHE_Sales_Representative>"
  Then global search for contact
  Then click on sample contact button
	Then search for product and click on next
	And click on the address displayed
	Then create new address
	And click on apply to the selected
	Then verify address on page and click on create sample order
	Then change Address status to verified on contact
	Then verify SFDC Status on sample record created

      Examples:
      |MHHE_Sales_Representative|
      |Jenna_Taylor|