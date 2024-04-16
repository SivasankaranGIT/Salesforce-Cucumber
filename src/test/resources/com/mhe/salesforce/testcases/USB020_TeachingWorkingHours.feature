#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales Rep edit office and teaching hours on the Contact record.

Background: 
	Given I am logged into salesforce for "TeachingWorkingHours" 
	
	
@Contacts
@TeachingWorkingHours	@GCRM-9012 @GCRM-16903
Scenario Outline: Verify that MHHE Sales Rep edit office and teaching hours on the Contact record.

	Given Runmode for "TeachingWorkingHours" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Contacts page
	Then global search for contact
	And edit office hours
	Then edit teaching hours
	And verify hours relecting after updation

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|