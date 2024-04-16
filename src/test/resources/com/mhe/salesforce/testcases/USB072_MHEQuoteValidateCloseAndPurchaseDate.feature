#DEPENDENT SCRIPT - This script is dependent on CreateNewQuotewithMultipleApprovers script for getting the Quote URL (selenium.newQuoteURL)
Feature: Validate SEG_Business_Admin user is able to create an opportunity through MHE Quote and validate close&purchase date

Background:
	Given I am logged into salesforce for "MHEQuoteValidateCloseAndPurchaseDate"

@MHEQuoteValidateCloseAndPurchaseDate @Quote @GCRM-3923
Scenario Outline: Validate SEG_Business_Admin user is able to create an opportunity through MHE Quote and validate close&purchase date

	Given Runmode for "MHEQuoteValidateCloseAndPurchaseDate" is Y
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