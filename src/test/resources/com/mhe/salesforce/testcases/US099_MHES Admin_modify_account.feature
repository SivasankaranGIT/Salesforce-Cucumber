#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES admin is able to modify Account fields

Background: 
	Given I am logged into salesforce for "MHESAdminModifiesAccountFields" 
	
@Accounts
@SmokeTest	
@MHESAdminModifiesAccountFields	@GCRM-8948
Scenario Outline: MHES admin is able to modify Account fields

	Given Runmode for "MHESAdminModifiesAccountFields" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	When Navigate to Accounts page
	And modify enrollment grade levels and account type account fields
	And Verify the account fields are modified

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|