#DEPENDANT_SCRIPT - This script is dependent on 'EventLinkedToContactAndOpportunity' script for getting 'selenium.eventURL'
Feature: Verify that if the event date has a past date then it is available in Activity history section.

Background: 
	Given I am logged into salesforce for "EventPastDateActivityHistory" 
	
	
@Events
@EventPastDateActivityHistory	@GCRM-8953
Scenario Outline: Verify that if the event date has a past date then it is available in Activity history section.

	Given Runmode for "EventPastDateActivityHistory" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And I switch to Sales home page
	Then navigate to Calendar tab
	When I change event to past date

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|
