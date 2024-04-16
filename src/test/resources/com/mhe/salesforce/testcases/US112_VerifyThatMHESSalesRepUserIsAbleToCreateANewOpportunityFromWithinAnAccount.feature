#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESSalesRepUserIsAbleToCreateANewOpportunityFromWithinAnAccount

Background: 
	Given I am logged into salesforce for "MHESRePCreatewOpportunityWithinAccount" 
	
	
@Accounts
@TS01_TC10_VerifyThatMHESSalesRepUserIsAbleToCreateANewOpportunityFromWithinAnAccount @GCRM-9299
Scenario Outline: VerifyThatMHESSalesRepUserIsAbleToCreateANewOpportunityFromWithinAnAccount

	Given Runmode for "MHESRePCreatewOpportunityWithinAccount" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for accounts
	And new I fill in all the mandatory details to create a new opportunity for Sales Ref

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|