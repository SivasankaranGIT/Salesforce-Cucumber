#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify  Case transfers to a new queue or owner

Background: 
	Given I am logged into salesforce for "VerifyCaseTransfersToNewQueueOrOwner"

@Cases
@TC14_US_Cases_VerifyCaseTransfersToNewQueueOrOwner @GCRM-9056
Scenario Outline: VerifyCaseTransfersToNewQueueOrOwner

	Given Runmode for "VerifyCaseTransfersToNewQueueOrOwner" is Y 
#	Then I login as Admin User
	Then I do login as "<System_Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to cases tab
	Then change the owner of case

	Examples:
		|app_Name|System_Administrator|
		|"MHHE"|Sivasankaran_Periyasamy|