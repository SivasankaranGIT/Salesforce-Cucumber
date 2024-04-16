#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Mhhe Sales Rep is able to create a new opportunity from within an account

Background: 
	Given I am logged into salesforce for "MHHERepCreateOpp" 
	
@Accounts
@MHHESalesRepCreateOpportunityFromAccount @GCRM-9294
Scenario Outline: Mhhe Sales Rep is able to create a new opportunity from within an account
	Given Runmode for "MHHERepCreateOpp" is Y 
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Accounts page
	And I fill mandatory opportunity details
	Then I validate opportunity created under account

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|
