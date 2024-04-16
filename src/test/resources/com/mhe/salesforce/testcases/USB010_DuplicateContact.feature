#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales Rep get notified while creating a duplicate contact

Background: 
	Given I am logged into salesforce for "CreateDuplicateContact" 
	
	
@Contacts
@CreateDuplicateContact	@GCRM-9228
Scenario Outline: Verify that MHHE Sales Rep get notified while creating a duplicate contact

	Given Runmode for "CreateDuplicateContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Contacts page
	And create contact to view duplicates

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|