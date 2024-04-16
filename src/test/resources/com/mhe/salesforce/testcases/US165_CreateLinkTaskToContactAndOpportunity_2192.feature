#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the new task can be linked to a Contact and opportunity

Background: 
	Given I am logged into salesforce for "CreateLinkTaskToContactAndOpportunity" 
	
	
@Tasks
@CreateLinkTaskToContactAndOpportunity	@GCRM-8952
Scenario Outline: Verify that the new task can be linked to a Contact and opportunity

	Given Runmode for "CreateLinkTaskToContactAndOpportunity" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And I switch to MHHE home page
	When Navigate to Tasks page
	And create and link contact and opportunity to a task
	Then verify task created linked with opportunity

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|