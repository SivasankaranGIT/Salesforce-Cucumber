#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Create new opportunity to test Quotes object related feature scenarios

Background: 
	Given I am logged into salesforce for "CreateNewOppForQuotesTest"	
	
@Quote @CreateNewOppForQuotesTest @GCRM-8405 @GCRM-9247 @GCRM-16026
Scenario Outline: Create new opportunity to test Quotes object related feature scenarios

	Given Runmode for "CreateNewOppForQuotesTest" is Y
	Then I do login as "<SEG_Sales_Rep>"
	Then I navigate to opportunity tab
	Then SEG Sales Rep user creates new opportunity
	And add subtypes in opportunity
Examples:
	|SEG_Sales_Rep|
	|Open_Baker|