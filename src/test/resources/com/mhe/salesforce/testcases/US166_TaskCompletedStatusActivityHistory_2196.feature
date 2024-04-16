#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that once the task status get changed to Completed then its available in Activity history section

Background: 
	Given I am logged into salesforce for "TaskCompletedStatusActivityHistory" 
	
	
@Tasks
@TaskCompletedStatusActivityHistory	@GCRM-8949
Scenario Outline: Verify that once the task status get changed to Completed then its available in Activity history section

	Given Runmode for "TaskCompletedStatusActivityHistory" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And I switch to Sales home page
	When Navigate to Tasks page
	And edit task status and verify Activity History section

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|