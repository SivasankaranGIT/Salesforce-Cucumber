#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the new event can be linked to a Contact and opportunity

Background: 
	Given I am logged into salesforce for "EventLinkedToContactAndOpportunity" 
	
@Events
@SmokeTest
@EventLinkedToContactAndOpportunity @CRMOC-2187 @GCRM-8957
Scenario: Verify that the new event can be linked to a Contact and opportunity

	Given Runmode for "EventLinkedToContactAndOpportunity" is Y
  Then I login as Sales Rep
	Then navigate to MHES Lightning Console
	Then EventLinkedToContactAndOpportunity - Navigate to digital training Calendar
	Then I select new calendar event and validate page title
	Then I validate MHE event is selected as record type by default and page title
	Then I validate correct name is displayed in assigned to field
	Then I enter subject of meeting
	Then I select opportunities from related to field
	Then I verify contacts and enter contact name
	Then I select all day calendar event
	Then EventLinkedToContactAndOpportunity - I enter start date in calendar event
	Then I select action
	Then I enter description in description field
	Then I click save button to save calendar meeting
	Then I verify calendar event is available in calendar section
	Then I select calendar event
	Then I click on related opportunity
	Then I click on open activities and verify calendar event
	Then I click on name field and verify event in contacts open activites