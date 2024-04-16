#DEPENDANT_SCRIPT - This script is dependent on 'MHHECreateNewLead' script for getting 'selenium.LeadURl'. Also, the lead details are modified by 'MHESLeadManagementEditLead' script.
Feature: Verify Lead Source of a Lead.

Background: 
	Given I am logged into salesforce for "VerifyLeadSource" 
	
	
@Leads
@VerifyLeadSource	@GCRM-9244
Scenario Outline: Verify Lead Source of a Lead.

	Given Runmode for "VerifyLeadSource" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Support>"
	When Navigate to Leads Page
	And verify Lead Source

	Examples:
	|MHHE_Sales_Support|
	|Jennifer_Bahl|