#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the new event can be linked to a Contact and opportunity

Background: 
	Given I am logged into salesforce for "NewEventLinkedToLead" 
	
@Events
@NewEventLinkedToLead	@CRMOC-2188 @GCRM-8956
Scenario: Verify that the new event can be linked to a Contact and opportunity

	Given Runmode for "NewEventLinkedToLead" is Y
	#Then I login as System Admin
	Then I login as Sales Rep
	#Then I navigate to MHES Lightning Console
	Then navigate to MHES Lightning Console
	Then NewEventLinkedToLead - Navigate to digital training Calendar
	Then NewEventLinkedToLead - I select new calendar event and validate page title
	Then NewEventLinkedToLead - I validate MHE event is selected as record type by default and page title
	Then NewEventLinkedToLead - I validate correct name is displayed in assigned to field
	Then NewEventLinkedToLead - I enter subject of meeting
	Then NewEventLinkedToLead - I select Leads and enter lead name
	Then NewEventLinkedToLead - I select all day calendar event
	Then NewEventLinkedToLead - I enter start date in calendar event
	Then NewEventLinkedToLead - I select action
	Then NewEventLinkedToLead - I enter description in description field
	Then NewEventLinkedToLead - I click save button to save calendar meeting
	Then NewEventLinkedToLead - I verify calendar event is available in calendar section
	Then NewEventLinkedToLead - I select calendar event
	Then NewEventLinkedToLead - I click on name field in event
	Then NewEventLinkedToLead - I click activities tab and verify calendar event