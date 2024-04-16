#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity name (selenium.opportunity_expected)
Feature: Verify that the event can be created and linked to the newly created opportunity

Background: 
	Given I am logged into salesforce for "AddEventToNewlyCreatedOpp" 
	
@OpportunitiesDependent
@AddEventToNewlyCreatedOpp @GCRM-8403 @GCRM-9196
Scenario Outline: Verify that the event can be created and linked to the newly created opportunity

	Given Runmode for "AddEventToNewlyCreatedOpp" is Y
#  	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
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
	Then I logout of any user
	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|