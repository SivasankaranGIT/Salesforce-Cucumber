#DEPENDANT_SCRIPT - This script is dependent on 'EventLinkedToContactAndOpportunity' script for getting 'selenium.eventURL'
Feature: Verify that the existing event can be modified

Background: 
	Given I am logged into salesforce for "ExistingEventModification" 
	
@Events
@SmokeTest
@ExistingEventModification @CRMOC-2190 @GCRM-8954
Scenario: Verify that the existing event can be modified

	Given Runmode for "ExistingEventModification" is Y
	When Navigate to digital training Calendar
	And I Edit the event
	Then I validate the edit details on new events