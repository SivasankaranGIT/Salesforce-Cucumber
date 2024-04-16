#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the new event can be linked to a Contact and opportunity

Background: 
	Given I am logged into salesforce for "NewEventLinkedToContactAndSample" 
	
@Events
@NewEventLinkedToContactAndSample	@CRMOC-2189 @GCRM-8955
Scenario: Verify that the new event can be linked to a Contact and opportunity

	Given Runmode for "NewEventLinkedToContactAndSample" is Y
	#Then I login as System Admin
	Then I login as Sales Rep
	#Then I navigate to MHES Lightning Console
	Then navigate to MHES Lightning Console
	Then NewEventLinkedToContactAndSample - Navigate to digital training Calendar
	Then NewEventLinkedToContactAndSample - I select new calendar event and validate page title
	Then NewEventLinkedToContactAndSample - I validate MHE event is selected as record type by default and page title
	Then NewEventLinkedToContactAndSample - I validate correct name is displayed in assigned to field
	Then NewEventLinkedToContactAndSample - I enter subject of meeting
	Then NewEventLinkedToContactAndSample - I select sample from related to field
	Then NewEventLinkedToContactAndSample - I verify contacts and enter contact name
	Then NewEventLinkedToContactAndSample - I select all day calendar event
	Then NewEventLinkedToContactAndSample - I enter start date in calendar event
	Then NewEventLinkedToContactAndSample - I select action
	Then NewEventLinkedToContactAndSample - I enter description in description field
	Then NewEventLinkedToContactAndSample - I click save button to save calendar meeting
	Then NewEventLinkedToContactAndSample - I verify calendar event is available in calendar section
	Then NewEventLinkedToContactAndSample - I select calendar event
	Then NewEventLinkedToContactAndSample - I click on name field in event
	Then NewEventLinkedToContactAndSample - I verify event in contacts open activites
	