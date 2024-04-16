#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales Support verify convertion of a lead to contact

Background: 
	Given I am logged into salesforce for "MHHEConvertLeadToContact" 
	
	
@Leads
@MHHEConvertLeadToContact	@GCRM-7496
Scenario Outline: Verify that MHHE Sales Support verify convertion of a lead to contact.

	Given Runmode for "MHHEConvertLeadToContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Support>"
	When Navigate to Leads Page
	Then create a new Lead
	And convert Lead to Contact

	Examples:
	|MHHE_Sales_Support|
	|Jennifer_Bahl|