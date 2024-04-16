#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForQuotesTest script for getting the Opportunity URL (selenium.NewOppURLForQuotesTest)
#This same URL is getting used in createNewQuote script as well.
Feature: EditQuoteInOpp

Background: 
	Given I am logged into salesforce for "EditQuoteInOpp" 	
	
#@OpportunitiesDependent 
@Quote @EditQuoteInOpp @GCRM-9215
Scenario Outline: EditQuoteInOpp

	Given Runmode for "EditQuoteInOpp" is Y
  Then I do login as "<SEG_Sales_Rep>"
	Then navigate to MHE_Quotes tab on opportunity
  Then click on New Quote
  Then I Create a new Quote
  And Edit Quote From Opp
  Then I logout of any user

  Examples:
  |SEG_Sales_Rep|
  |Open_Baker|