#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate SEG_Sales_Rep user is able to create new quote through accounts object.

Background: 
	Given I am logged into salesforce for "SEGSalesRepCreateNewQuote"
	
@Quote @SEGSalesRepCreateNewQuoteThroughAccounts @GCRM-8405 @GCRM-9215
Scenario Outline: Validate SEG_Sales_Rep user is able to create new quote through accounts object.

	Given Runmode for "SEGSalesRepCreateNewQuote" is Y
	Then I do login as "<SEG_Sales_Rep>"
	Then I navigate to Sales Home page
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote
	And I Add <ISBN> number
	Then Go through the approval process
  Examples:
  |ISBN|SEG_Sales_Rep|
  |"9780076866885"|Open_Baker|