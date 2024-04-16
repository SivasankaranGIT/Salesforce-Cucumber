#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepCreateNewQuote script for getting the Quote name (selenium.newQuoteUniqueName)
Feature: MHES User edit quote using MATCH QUOTE option

  Background:
    Given I am logged into salesforce for "MHESMatchQuote"

	@Quote
  @MHESMatchQuote @GCRM-9455
  Scenario Outline: MHES User edit quote using MATCH QUOTE option
  
    Given Runmode for "MHESMatchQuote" is Y
    Then I do login as "<SEG_Sales_Rep>"
    And I change the app launcher to Salesforce Chatter
    Then Revise Quote for one ISBN
    And Go through the approval process for Match Quote
    #Then Validate grand Total price for opportunity (Now the Amount in opp will match with total product Qty)
  
  Examples: 
    |SEG_Sales_Rep|
    |Open_Baker|