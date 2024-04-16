#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Email messages related to the case are visible on a related list to the case

Background: 
	Given I am logged into salesforce for "EmailmessagesCaseVisible"

@Cases
@TC16_US_Cases_VerifyEmailmessagesRelatedToCaseAreVisible @GCRM-9057
Scenario Outline: VerifyEmailmessagesRelatedToCaseAreVisible

	Given Runmode for "EmailmessagesCaseVisible" is Y 
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to cases tab
	And open the case
	Then verify Email notification is present

	Examples:
	|app_Name|System_Administrator|
	|"MHHE"|Sivasankaran_Periyasamy|