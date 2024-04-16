#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifythatMhheSalesRepIsAbleToCreateANewContactFromWithinAnAccount

Background: 
	Given I am logged into salesforce for "ViewContactsFromAccUS" 
	
	
@Accounts
@TS02_TC05_VerifyThatMhheSalesRepIsAbleToViewContactsFromWithinAnAccount @GCRM-2020
Scenario Outline: VerifyThatMhheSalesRepIsAbleToViewContactsFromWithinAnAccount

	Given Runmode for "ViewContactsFromAccUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user Accounts to Proceed
	And Account Name click and proceed validate
	Then I logout of any user

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|