#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Create Contact Specifc Address

Background: 
	Given I am logged into salesforce for "MHECreateContactAddress"	
	
@Contacts
@CreateContactAddress	@GCRM-9010
Scenario Outline: Create Contact Specifc Address

	Given Runmode for "MHECreateContactAddress" is Y
#	Then I login as Sales Rep
	Then  I do login as "<MHHE_Sales_Representative>"
	And I enter the record fields
#	Then Contact should be updated
	
	Examples: 
	|MHHE_Sales_Representative|
	|Haley_Loebig|