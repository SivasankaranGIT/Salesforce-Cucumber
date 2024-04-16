#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMhheSalesRepProfileUserIsAbleToModifyTheAccountDetails

Background: 
	Given I am logged into salesforce for "MHHERepModifyAccount" 
	
@Accounts
@SmokeTest	
@TS02_TC01_VerifyThatMhheSalesRepProfileUserIsAbleToModifyTheAccountDetails @GCRM-9297
Scenario Outline: VerifyThatMhheSalesRepProfileUserIsAbleToModifyTheAccountDetails

	Given Runmode for "MHHERepModifyAccount" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user Accounts
	When I get the Account Name
	And Account Name click proceed Contact Update

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|