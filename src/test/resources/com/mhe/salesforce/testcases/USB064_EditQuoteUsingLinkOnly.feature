#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepCreateNewQuote script for getting the Quote name (selenium.newQuoteNum & selenium.newQuoteUniqueName)
Feature: Using Link Only feature - Edit Quote

Background:
  Given I am logged into salesforce for "EditQuoteUsingLinkOnly"

@Quote
@EditQuoteUsingLinkOnly @GCRM-9453
Scenario Outline: Using Link Only feature - Edit Quote
  Given Runmode for "EditQuoteUsingLinkOnly" is Y
#  Then I login as Sales Rep
  Then I do login as "<SEG_Sales_Rep>"
  Then I navigate to Sales Home page
  Then Revise Quote and add <ISBN>
  And Go through the approval process with LINK ONLY
  Then Validate quote link displayed
  Examples:
  |ISBN|SEG_Sales_Rep|
  |"9780076866885"|Open_Baker|