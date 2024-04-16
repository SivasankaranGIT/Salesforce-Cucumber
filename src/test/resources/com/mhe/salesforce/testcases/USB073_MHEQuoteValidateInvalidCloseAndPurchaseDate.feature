Feature: MHEQuote Verify Invalid Close & Purchase Date

Background: Given I am logged into salesforce for "MHEQuoteValidateInvalidCloseAndPurchaseDate"

@MHEQuoteValidateInvalidCloseAndPurchaseDate @GCRM-4017
Scenario Outline: MHEQuote Verify Invalid Close & Purchase Date

	Given Runmode for "MHEQuoteValidateInvalidCloseAndPurchaseDate" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then delete previously created opportunity
	Then edit existing quote
	And link new opportunity with existing quote
		|9780076866885|

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|