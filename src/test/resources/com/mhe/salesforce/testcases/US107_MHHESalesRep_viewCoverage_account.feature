#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Sales Rep User View Coverage from within an Account 

Background: 
	Given I am logged into salesforce for "MHHESalesRepViewCoverageFromAccounts" 
	
	
@Accounts
@MHHESalesRepViewCoverageFromAccounts @GCRM-9091
Scenario Outline: MHHE Sales Rep User View Coverage from within an Account

	Given Runmode for "MHHESalesRepViewCoverageFromAccounts" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user Accounts to Proceed
	When I get the Account Name
	Then verify coverage details

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|

