#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the Approved samples with print product will flow to ERP when picked up by interface the status will update to Sent to Oracle

Background: 
	Given I am logged into salesforce for "SamplesStatusToSentToOracle" 
	
	
@Samples
@TC27_US_Sample_VerifyApprovedSamplesWithPrintProductStatusWillUpdateToSentToOracle	@GCRM-9081
Scenario Outline: VerifyApprovedSamplesWithPrintProductStatusWillUpdateToSentToOracle

	Given Runmode for "SamplesStatusToSentToOracle" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I navigate to contacts tab
	Then global search for contact
	Then click on sample contact button
	Then search for product click on next for any ISBN
	Then select order line type as Desk US
	And click on create sample order for copy
	And I change the app launcher to MHHE
	Then verify sample for Copy

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|