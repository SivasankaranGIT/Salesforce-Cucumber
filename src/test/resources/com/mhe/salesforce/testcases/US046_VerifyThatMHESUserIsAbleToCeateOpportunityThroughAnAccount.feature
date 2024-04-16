#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: VerifyThatMHESUserIsAbleToCeateOpportunityThroughAnAccount

Background: 
	Given I am logged into salesforce for "MHESCreateOpp" 
	
@OpportunitiesDependent
@SmokeTest	
@US_TS01_TC25_VerifyThatMHESUserIsAbleToCeateOpportunityThroughAnAccount @GCRM-9083
Scenario Outline: VerifyThatMHESUserIsAbleToCeateOpportunityThroughAnAccount

	Given Runmode for "MHESCreateOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	Then global search for accounts
	And new I fill in all the mandatory details to create a new opportunity for Sales Ref

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|