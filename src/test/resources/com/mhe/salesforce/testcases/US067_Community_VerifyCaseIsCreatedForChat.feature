#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that a Case is created for a Chat

Background: 
	Given I am logged into salesforce for "Community_VerifyCaseIsCreatedForChat"

@Cases
@TC05_US_Community_VerifyCaseIsCreatedForChat @GCRM-9051
Scenario Outline: Community_VerifyCaseIsCreatedForChat

	Given Runmode for "Community_VerifyCaseIsCreatedForChat" is Y 
#	Then I login as Admin User
	Then I do login as "<System_Administrator>"
#	Then I change the app launcher to MHHE
	And  I change the app launcher to <app_Name>
	When I navigate to chat transcript tab
	Then click on case details for the chat
	And verify Case details

	Examples:
	|app_Name|System_Administrator|
	|"CSOM Lightning Console"|Sivasankaran_Periyasamy|