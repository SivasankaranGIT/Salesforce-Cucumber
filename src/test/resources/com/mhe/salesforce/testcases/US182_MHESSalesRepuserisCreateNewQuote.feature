#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForQuotesTest script for getting the Opportunity URL (selenium.NewOppURLForQuotesTest)
Feature: Verify Sample Status after address verification

  Background: 
    Given I am logged into salesforce for "createNewQuote"

#	@OpportunitiesDependent 
	@Quote @createNewQuote @GCRM-8958 @GCRM-26889 @GCRM-24098 @GCRM-24099
  Scenario Outline: VerifythatMHESSalesRepuserisabletocreateanewquote
  Given Runmode for "createNewQuote" is Y
  Then I do login as "<SEG_Sales_Rep>"
  Then navigate to MHE_Quotes tab on opportunity
  Then click on New Quote
  Then I Create a Quote
  And I fill details in Product information related page
  Then I fill product details
  And Validate Opportunity name and status

  Examples:
  |SEG_Sales_Rep|
  |Open_Baker|