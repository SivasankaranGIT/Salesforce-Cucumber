#DEPENDENT SCRIPT - This script is dependent on CreateNewQuotewithMultipleApprovers script for getting the Quote URL (selenium.newQuoteURL)
Feature: Validate SEG_Business_Admin user is able to create an opportunity through MHE Quote

Background:
	Given I am logged into salesforce for "CreateOppThroughMHEQuote"

@Quote @CreateOppThroughMHEQuote @GCRM-2736 @GCRM-24948 @GCRM-26013
Scenario Outline: Validate SEG_Business_Admin user is able to create an opportunity through MHE Quote

	Given Runmode for "CreateOppThroughMHEQuote" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then edit existing quote
	And link new opportunity with existing quote
	|9780076866885|
	Then validate new opportunity details
	And delete the newly created opportunity

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|