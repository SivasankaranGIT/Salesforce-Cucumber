#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepCreateNewQuote script for getting the Quote name (selenium.newQuoteNum & selenium.newQuoteUniqueName)
Feature: Update Opp. through MHE Quotes using Review option
Background: Given I am logged into salesforce for "UpdateOppThroughMHEQuotesUsingReview"

@UpdateOppThroughMHEQuotesUsingReview @Quote @GCRM-4676
Scenario Outline: UpdateOppThroughMHEQuotesUsingReview

	Given Runmode for "UpdateOppThroughMHEQuotesUsingReview" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	And open linked opportunity and get the URL
	Then review or clone MHE Quote opportunity functionality
	And validate old and new opportunity amount value

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|