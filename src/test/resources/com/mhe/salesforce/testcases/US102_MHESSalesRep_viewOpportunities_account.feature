#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES Sales Rep User Views Opportunities from within an Account 

Background: 
	Given I am logged into salesforce for "ViewOpportunityFromAccUS" 
	
@Accounts
@SmokeTest	
@MHHESalesRepViewOpportunityFromAccounts @GCRM-9298
Scenario Outline: MHES Sales Rep User Views Opportunities from within an Account

	Given Runmode for "ViewOpportunityFromAccUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Accounts page
	Then I navigate to opportunity from account
	And verify opportunity list within the account

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|