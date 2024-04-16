#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES Business Admin is able to set the Divisional Opt-Out to true

Background: 
	Given I am logged into salesforce for "MHESBusinessAdminSetDivisionalOptOut" 
	
@Accounts
@MHESBusinessAdminSetDivisionalOptOut @GCRM-9021
Scenario Outline: MHES Business Admin is able to set the Divisional Opt-Out to true
	Given Runmode for "MHESBusinessAdminSetDivisionalOptOut" is Y 
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	When Navigate to Accounts page
	Then global search for accounts
	Then Check Opt Out checkboxes 
	And Verify that OptOut gets auto-applied on the contacts

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|