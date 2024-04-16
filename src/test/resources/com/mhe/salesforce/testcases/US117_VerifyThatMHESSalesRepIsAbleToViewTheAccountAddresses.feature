#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESSalesRepIsAbleToViewTheAccountAddresses

Background: 
	Given I am logged into salesforce for "MHESViewTheAccountAddresses" 
	
	
@Accounts
@TS01_TC05_VerifyThatMHESSalesRepIsAbleToViewTheAccountAddresses @GCRM-9093
Scenario Outline: VerifyThatMHESSalesRepIsAbleToViewTheAccountAddresses

	Given Runmode for "MHESViewTheAccountAddresses" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user Accounts MHHE
	When I get the Account Name
	And Account Name click proceed view Address MHHE

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|