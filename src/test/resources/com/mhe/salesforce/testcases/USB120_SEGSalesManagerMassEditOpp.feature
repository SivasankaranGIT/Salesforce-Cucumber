#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify SEG Sales Manager has access to Mass Edit Opportunities

Background: 
	Given I am logged into salesforce for "SEGSalesManagerMassEditOpp" 

@GCRM-9689 @GCRM-9741 @OpportunitiesNonDependent @SEGSalesManagerMassEditOpp @RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify SEG Sales Manager has access to Mass Edit Opportunities

	Given Runmode for "SEGSalesManagerMassEditOpp" is Y
	Then I do login as "<SEG_Sales_Manager>"
  When I click sales Ref user details to navigate Sales
	And check two opp records avilability in recently view opp list
	And SEG Sales Manager Mass Edit Opportunities
	Examples:
  |SEG_Sales_Manager|
  |Stewart_Smith|
  |Open_Thomas|