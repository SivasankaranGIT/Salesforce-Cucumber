#DEPENDENT SCRIPT - This script is dependent on CreateNewQuotewithMultipleApprovers script for getting the Quote URL (selenium.newQuoteURL)
Feature: Verify MHEQuotes Admin Functionality

Background:
	Given I am logged into salesforce for "VerifyMHEQuotesAdminFunctionality"

@VerifyMHEQuotesAdminFunctionality @Quote @GCRM-4139
Scenario Outline: Verify MHEQuotes Admin Functionality

	Given Runmode for "VerifyMHEQuotesAdminFunctionality" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to MHE Quotes Admin tab
	Then navigate to Web Service Tester tab
	And validate MHEQuote Admin functionality

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|