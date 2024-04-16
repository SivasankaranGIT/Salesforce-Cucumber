#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the new task can be linked to a lead

Background: 
	Given I am logged into salesforce for "LinkTaskToLead" 
	
	
@Tasks
@LinkTaskToLead	@GCRM-8951
Scenario Outline: Verify that the new task can be linked to a lead

	Given Runmode for "LinkTaskToLead" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And I switch to Sales home page
	When Navigate to Tasks page
	And create and link lead to a task
	When I click on the "homepageTab"
	Then verify task created linked with Lead
	And delete the task created with link
	
	Examples: 
	|System_Administrator|
	|Sivasankaran_Periyasamy|

