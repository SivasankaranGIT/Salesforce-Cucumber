#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the User can pick different address than default

Background: 
	Given I am logged into salesforce for "PickDiffAddress" 
	
	
@Samples
@TC28_US_Sample_VerifyUserCanPickDifferentAddressThanDefault	@GCRM-9262
Scenario Outline: VerifyUserCanPickDifferentAddressThanDefault

	Given Runmode for "PickDiffAddress" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I navigate to contacts tab
	Then global search for contact
	Then click on sample contact button
	Then search for product and click on next
	And click on the address displayed
	Then create new address
	And click on apply to the selected
	Then verify address and click on create sample order 
	Then verify address on new sample

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|