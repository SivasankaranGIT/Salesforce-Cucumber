#STAND_ALONE_SCRIPT - This script can be executed separately.
#https://confluence.mheducation.com/pages/viewpage.action?spaceKey=GCRM&title=Overview+Flow+and+test+script
Feature: Validate SEG_Business_Admin  user is able to create new quote with multiple approvers through accounts object.

Background:
	Given I am logged into salesforce for "VerifyFreightChargesSOAErrorMessageForQuote"

@Quote @VerifyFreightChargesSOAErrorMessageForQuote @GCRM-24915
Scenario Outline: Verify Freight Charges SOA Error Message For Quote

	Given Runmode for "VerifyFreightChargesSOAErrorMessageForQuote" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	When I navigate to "Accounts" tab
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote
	And I Add <ISBN> number
	And verify Freight Charges SOA Error Message For Quote
	Examples:
  |ISBN|SEG_Business_Admin|
  |"9780076911394"|Ivan_Gomez|
  
@Quote @CreateNewQuotewithMultipleApprovers @GCRM-6171
Scenario Outline: Validate SEG_Business_Admin  user is able to create new quote with multiple approvers through accounts object.

	Given Runmode for "CreateNewQuotewithMultipleApprovers" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote
	And I Add <ISBN> number
	Then Go through the approval process with multiple approvers
	And validate the quote status
	Then navigate to MHE Quotes tab
	And validate the quote status in approval history section
	And reject the quote in approval history section
	Examples:
  |ISBN|SEG_Business_Admin|
  |"9780076122158"|Ivan_Gomez|