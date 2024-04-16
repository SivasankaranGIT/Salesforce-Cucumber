#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Opportunity_Contact_editUpdate_Marketing

Background: 
	Given I am logged into salesforce for "OpportunityContactEditMark" 	
	
@OpportunitiesNonDependent
@Opportunity_Contact_editUpdate_Marketing @GCRM-9275
Scenario Outline: Opportunity_Contact_editUpdate_Marketing

	Given Runmode for "OpportunityContactEditMark" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
  	When I click sales Ref user details to navigate Sales
	And Marketing Opportunity Contact Edit Update

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|