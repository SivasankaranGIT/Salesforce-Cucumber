#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESSalesRepandMarketinguserIsAbleToMassEditTheOpportunitiesMarketing

Background: 
	Given I am logged into salesforce for "MHESRepMassEditOppMark" 	
	
@OpportunitiesNonDependent
@US_TS01_TC36_VerifyThatMHESSalesRepandMarketinguserIsAbleToMassEditTheOpportunitiesMarketing @GCRM-8959
Scenario Outline: VerifyThatMHESSalesRepandMarketinguserIsAbleToMassEditTheOpportunitiesMarketing

	Given Runmode for "MHESRepMassEditOppMark" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
  When I click sales Ref user details to navigate Sales
	And Mass Edit Opportunities Marketing

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|