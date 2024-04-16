#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales Rep merge a contact within the same account.

Background: 
	Given I am logged into salesforce for "MergeDuplicateContact" 
	
	
@Contacts
@MergeDuplicateContact	@GCRM-9230
Scenario Outline: Verify that MHHE Sales Rep merge a contact within the same account.

	Given Runmode for "MergeDuplicateContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Contacts page
	And create contact to merge duplicates
	
	Examples: 
	|MHHE_Sales_Representative|
	|Danielle_Snyder|