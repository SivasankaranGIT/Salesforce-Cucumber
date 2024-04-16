#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepCreateNewQuote script for getting the Quote name (selenium.newQuoteNum & selenium.newQuoteUniqueName)
Feature: Using SUM EXISTING option - Edit Quote

  Background:
    Given I am logged into salesforce for "EditQuoteUsingSumExisting"

	@Quote
  @EditQuoteUsingSumExisting @GCRM-9452
  Scenario Outline: Using SUM EXISTING option - Edit Quote
    Given Runmode for "EditQuoteUsingSumExisting" is Y
#    Then I login as Sales Rep
      Then I do login as "<SEG_Sales_Rep>"
    And I change the app launcher to Salesforce Chatter
    And navigate to opp and remove the <ISBN> 
    Then Revise Quote and add <ISBN>
    And Go through the approval process with SUM EXISTING
    Then Validate ISBN with updated Quantity in Opportunity Page
	  Examples:
	  |ISBN|SEG_Sales_Rep|
	  |"9780076866885"|Open_Baker|