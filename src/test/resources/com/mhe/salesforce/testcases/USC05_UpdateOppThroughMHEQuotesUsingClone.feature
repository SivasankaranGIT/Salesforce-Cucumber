#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepCreateNewQuote script for getting the Quote name (selenium.newQuoteNum & selenium.newQuoteUniqueName)
Feature: Update Opp. through MHE Quotes using Clone option
Background: 
Given I am logged into salesforce for "UpdateOppThroughMHEQuotesUsingClone"

@UpdateOppThroughMHEQuotesUsingClone @Quote @GCRM-4677
Scenario Outline: UpdateOppThroughMHEQuotesUsingClone

	Given Runmode for "UpdateOppThroughMHEQuotesUsingClone" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	And open linked opportunity and get the URL
	Then review or clone MHE Quote opportunity functionality
	And validate old and new opportunity amount value

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|