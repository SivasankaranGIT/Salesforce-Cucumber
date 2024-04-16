#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepCreateNewQuote script for getting the Quote name (selenium.newQuoteNum & selenium.newQuoteUniqueName)
Feature: Using ADD/OVERRIDE option - Edit Quote

  Background:
    Given I am logged into salesforce for "EditQuoteUsingAddOverride"

	@Quote
  @EditQuoteUsingAddOverride
  Scenario Outline: Using ADD/OVERRIDE option - Edit Quote
    Given Runmode for "EditQuoteUsingAddOverride" is Y
#    Then I login as Sales Rep
      Then I do login as "<SEG_Sales_Rep>"
    And I change the app launcher to Salesforce Chatter
    Then Revise Quote and add <ISBN>
    And Go through the approval process with Add Override
    Then Validate both old and newly added ISBN in Opportunity Page
    Examples:
	  |ISBN|SEG_Sales_Rep|
	  |"9780076866885"|Open_Baker|