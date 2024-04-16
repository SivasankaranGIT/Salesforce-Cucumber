#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the Support Account is automatically populated with the account name for the contact type is student or asset author

Background: 
	Given I am logged into salesforce for "VerifySupportAccountNameForStudent" 
	
	
@Cases
@TC17_US_Cases_VerifySupportAccountNameForStudent @GCRM-9058
Scenario Outline: VerifySupportAccountNameForStudent

	Given Runmode for "VerifySupportAccountNameForStudent" is Y
#	Then I login as Sales Rep
	Then I do login as "<ALEKS Administrator>"
	And  I change the app launcher to <app_Name>
	When I search for contacts
	Then create a new contact for ALEKS user
	Then click on New case
	And fill all mandatory details to create case

	Examples:
		|app_Name|ALEKS Administrator|
		|"ALEKS Lightning Console"|Isaac_Rubio|