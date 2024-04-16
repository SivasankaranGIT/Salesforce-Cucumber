#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: View Account Hierarchy

Background: 
	Given I am logged into salesforce for "MHESAccountHierarchy" 
	
	
@Accounts
@MHESAccountHierarchy	@GCRM-9213
Scenario Outline: MHESAccountHierarchy

	Given Runmode for "MHESAccountHierarchy" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then navigate to accounts tab
	Then global search for accounts
	Then click on heirarchy
	And view hierarchy

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|