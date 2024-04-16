#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales user is able to create a new Lead.

Background: 
	Given I am logged into salesforce for "MHHECreateNewLead" 
	
	
@Leads
@MHHECreateNewLead	@GCRM-9209
Scenario Outline: Verify that MHHE Sales user is able to create a new Lead.

	Given Runmode for "MHHECreateNewLead" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Support>"
	When Navigate to Leads Page
	Then create new Lead

	Examples:
	|MHHE_Sales_Support|
	|Jennifer_Bahl|