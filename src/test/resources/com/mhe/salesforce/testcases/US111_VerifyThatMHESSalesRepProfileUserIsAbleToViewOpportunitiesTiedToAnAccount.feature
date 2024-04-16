#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESSalesRepProfileUserIsAbleToViewOpportunitiesTiedToAnAccount

Background: 
	Given I am logged into salesforce for "MHESRepViewOppTiedToAcct" 
	
	
@Accounts
@TS01_TC11_VerifyThatMHESSalesRepProfileUserIsAbleToViewOpportunitiesTiedToAnAccount @GCRM-9092
Scenario Outline: VerifyThatMhheSalesRepProfileUserIsAbleToModifyTheAccountDetails

	Given Runmode for "MHESRepViewOppTiedToAcct" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user Accounts
	When I get the Account Name
	And Account Name click proceed Opportunity check

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|