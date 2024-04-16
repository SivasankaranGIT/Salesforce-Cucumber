#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMhheSalesRepIsableToViewTheAccountAddresses

Background: 
	Given I am logged into salesforce for "ViewTheAccountAddressesUS" 
	

@Accounts	
@TS02_TC04_VerifyThatMhheSalesRepIsableToViewTheAccountAddresses @GCRM-9295
Scenario Outline: VerifyThatMhheSalesRepIsableToViewTheAccountAddresses

	Given Runmode for "ViewTheAccountAddressesUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user Accounts to Proceed
	And Account Name click proceed view Address
	
	Examples: 
	|MHHE_Sales_Representative|
	|Danielle_Snyder|