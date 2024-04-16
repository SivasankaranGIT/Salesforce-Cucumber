#DEPENDANT_SCRIPT - This script is dependent on 'CreateNewTask' script for getting 'selenium.taskURL'
Feature: Verify that the existing task status,type and comment can be modified.

Background: 
	Given I am logged into salesforce for "ExistingTaskCanBeModified"	
	
@Tasks @ExistingTaskCanBeModified	@GCRM-8950
Scenario Outline: Verify that the existing task status,type and comment can be modified.

	Given Runmode for "ExistingTaskCanBeModified" is Y
	Then I do login as "<System_Administrator>"
	When Navigate to Tasks page
	And I edit task details

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|