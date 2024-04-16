#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESSalesRepIsAbleToViewTheSalesRepCoverageOnTheAccount

Background: 
	Given I am logged into salesforce for "MHESRepViewCoverageOnAcct" 
	
	
@Accounts
@TS01_TC04_VerifyThatMHESSalesRepIsAbleToViewTheSalesRepCoverageOnTheAccount @GCRM-9300
Scenario Outline: VerifyThatMHESSalesRepIsAbleToViewTheSalesRepCoverageOnTheAccount

	Given Runmode for "MHESRepViewCoverageOnAcct" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user Accounts MHHE
	When I get the Account Name
	And Account Name click proceed and Coverage

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|