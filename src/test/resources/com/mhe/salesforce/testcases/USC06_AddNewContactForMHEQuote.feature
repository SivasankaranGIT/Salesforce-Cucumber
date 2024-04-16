#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva
Feature: Validate SEG_Business_Admin user is able to create a new contact for MHE Quote
Background:
Given I am logged into salesforce for "CreateNewContactForMHEQuote"	

@CreateNewContactForMHEQuote @Quote @GCRM-6756 @GCRM-15862 @GCRM-15691
Scenario Outline: CreateNewContactForMHEQuote

	Given Runmode for "CreateNewContactForMHEQuote" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I create a new contact for quote
	And validate duplicate contact
	Then I create a new unique contact for quote

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|