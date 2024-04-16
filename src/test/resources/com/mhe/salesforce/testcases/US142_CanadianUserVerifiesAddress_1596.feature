#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that Canadian User is able to verify the Address.

Background: 
	Given I am logged into salesforce for "CanadianUserVerifiesAddress"	
	
@Accounts
@CanadianUserVerifiesAddress	@GCRM-8995
Scenario Outline: Verify that Canadian User is able to verify the Address.

	Given Runmode for "CanadianUserVerifiesAddress" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHE_Business_Operations>"
	And  I change the app launcher to <app_Name>
	When Navigate to Accounts page
	Then global search for accounts
	And create new address for Canada User
	When Navigate to addresses screen
	Then edit and verify Address Status
	Examples:
	|app_Name|MHE_Business_Operations|
	|"Sales"|Nisha_Bansal|
	