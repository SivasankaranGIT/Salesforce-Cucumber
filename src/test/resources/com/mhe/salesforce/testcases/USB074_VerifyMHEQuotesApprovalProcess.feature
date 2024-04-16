#DEPENDENT SCRIPT - This script is dependent on CreateNewQuotewithMultipleApprovers script for getting the Quote URL (selenium.newQuoteURL)
Feature: Verify MHEQuotes Approval Process

Background:
	Given I am logged into salesforce for "VerifyMHEQuotesApprovalProcess"

@VerifyMHEQuotesApprovalProcess @Quote @GCRM-4130
Scenario Outline: Verify MHEQuotes Approval Process

	Given Runmode for "VerifyMHEQuotesApprovalProcess" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to MHE Quotes tab
	Then edit existing quote
	And Go through the quote approval process with Do not link Opportunity
	
	Examples: 
	|SEG_Business_Admin|
	|Ivan_Gomez|