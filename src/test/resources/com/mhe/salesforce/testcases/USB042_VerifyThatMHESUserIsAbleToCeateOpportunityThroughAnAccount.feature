#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify That MHES User Is Able To Ceate Opportunity Through An Account

Background: 
	Given I am logged into salesforce for "MHESCreateOpportunity" 
	
@Tasks
@SmokeTest	
@VerifyThatMHESUserIsAbleToCeateOpportunityThroughAnAccount @GCRM-9083
Scenario Outline: Verify That MHES User Is Able To Ceate Opportunity Through An Account

	Given Runmode for "MHESCreateOpportunity" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for accounts
	And new I fill in all the mandatory details to create a new opportunity for Sales Ref

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|
