#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the User can pick different address than default


Background:
	Given I am logged into salesforce for "Sample_DepartmentAddress"
	
@Samples
@TC08_US_Sample_VerifyDefaultShippinAddressWillBeBasedOnDepartmentAddress @GCRM-9266
Scenario Outline: VerifyUserCanPickDifferentAddressThanDefault

	Given Runmode for "Sample_DepartmentAddress" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for contact
	Then click on sample contact button
	Then search for product and click on next
	Then verify address on page and click on create sample order

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|