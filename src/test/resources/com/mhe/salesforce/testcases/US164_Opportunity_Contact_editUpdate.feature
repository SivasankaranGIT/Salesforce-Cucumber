#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Opportunity_Contact_editUpdate

Background: 
	Given I am logged into salesforce for "OppContactEditUpdate" 	
	
@OpportunitiesNonDependent
@Opportunity_Contact_editUpdate @GCRM-9275
Scenario Outline: Opportunity_Contact_editUpdate

	Given Runmode for "OppContactEditUpdate" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
  When I click sales Ref user details to navigate Sales
  Then global search for opportunities
	And Opportunity Contact Edit Update

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|