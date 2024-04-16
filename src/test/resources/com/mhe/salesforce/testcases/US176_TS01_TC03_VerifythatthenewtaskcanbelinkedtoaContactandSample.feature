#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the new task can be linked to a Contact and Sample

Background: 
	Given I am logged into salesforce for "LinkTaskToContactSample" 
	
	
@Tasks
@VerifythatthenewtaskcanbelinkedtoaContactandSample	@GCRM-9269
Scenario Outline: Verify that the new task can be linked to a Contact and Sample

	Given Runmode for "LinkTaskToContactSample" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And I switch to MHHE home page
	When I click on the "tasksTab"
	And create and link contact and sample to a task
	Then global search for contact
	Then verify task created linked with contact

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|