#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the new task can be created

Background: 
	Given I am logged into salesforce for "CreateNewTask"	
	
@Tasks @CreateNewTask	@GCRM-9270
Scenario Outline: Verify that the new task can be created

	Given Runmode for "CreateNewTask" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And I switch to MHHE home page
	When Navigate to Tasks page
	And create and link lead to a task

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|