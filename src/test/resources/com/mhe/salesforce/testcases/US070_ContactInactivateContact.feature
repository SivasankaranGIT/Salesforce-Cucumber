#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: ContactInactivateContact_MHHE_SALES_REP

Background: 
	Given I am logged into salesforce for "ContactInactiveContact" 
	
@ContactsNA
@SmokeTest
@TC06_US_ContactInactivateContact @GCRM-9013
Scenario Outline: ContactInactivateContact_MHHE_SALES_REP

	Given Runmode for "ContactInactiveContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	Then global search for contact
	And dactivate the contact
	And activate the contact
	
	Examples: 
	|MHHE_Sales_Representative|
	|Danielle_Snyder|