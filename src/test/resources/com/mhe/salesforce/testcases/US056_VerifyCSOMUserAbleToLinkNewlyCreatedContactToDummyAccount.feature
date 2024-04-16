#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that CSOM General User is able to link the newly created contact to the dummy account

Background: 
	Given I am logged into salesforce for "CSOMUserLinkDummyAcct" 
	
	
@Cases
@Cases_TS01_TC01_VerifyCSOMUserAbleToLinkNewlyCreatedContactToDummyAccount @GCRM-9059
Scenario Outline: VerifyCSOMUserAbleToLinkNewlyCreatedContactToDummyAccount

	Given Runmode for "CSOMUserLinkDummyAcct" is Y
#	Then I login as CSOM User
	Then I do login as "<CSOM_General_User>"
	And  I change the app launcher to <app_Name>
#	Then I navigate to CSOM Lightning Console Home page
	When I search for CSOM User contacts
	Then create a new contact for CSOM user
	Then Verify Account name and Support account

	Examples:
		|app_Name|CSOM_General_User|
		|"CSOM Lightning Console"|Lisa_Phelps|