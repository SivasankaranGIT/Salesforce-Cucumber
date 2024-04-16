#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that CXG General User is able to link the newly created contact to the dummy account

Background: 
	Given I am logged into salesforce for "CXGUserLinkDummyAcct"	
	
@Cases
@Cases_TS01_TC02_VerifyCCXGUserAbleToLinkNewlyCreatedContactToDummyAccount @GCRM-9272
Scenario Outline: VerifyCCXGUserAbleToLinkNewlyCreatedContactToDummyAccount

	Given Runmode for "CXGUserLinkDummyAcct" is Y
#	Then I login as CXG User
	Then I do login as "<CXG_Administrator>"
	And  I change the app launcher to <app_Name>
	When I search for CXG User contacts
	Then create a new contact for CXG user
	Then Verify Account name and Support account for CXG
	Then I logout of any user

	Examples:
		|app_Name|CXG_Administrator|
		|"CXG Lightning Console"|Eric_Nelson|