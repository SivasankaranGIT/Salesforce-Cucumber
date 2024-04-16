#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Create Contact Specifc Address

Background: 
	Given I am logged into salesforce for "MHESCreateContactSpecificAddress" 
	
	
@Contacts
@MHESContactAddress	@GCRM-9009
Scenario Outline: Create Contact Specifc Address

	Given Runmode for "MHESCreateContactSpecificAddress" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for contact
	And I create new address record for MHES User
	Then I Validate Contact Success message

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|