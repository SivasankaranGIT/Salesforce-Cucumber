#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESSalesRepandMarketinguserIsAbleToMassEditTheOpportunities

Background: 
	Given I am logged into salesforce for "MHESRepMassEditOpp" 
	
@OpportunitiesNonDependent
@SmokeTest	
@US_TS01_TC36_VerifyThatMHESSalesRepandMarketinguserIsAbleToMassEditTheOpportunities @GCRM-8959
Scenario Outline: VerifyThatMHESSalesRepandMarketinguserIsAbleToMassEditTheOpportunities

	Given Runmode for "MHESRepMassEditOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
  When I click sales Ref user details to navigate Sales
	And Mass Edit Opportunities

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|