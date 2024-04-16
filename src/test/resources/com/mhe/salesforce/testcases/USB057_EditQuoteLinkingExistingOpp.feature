#DEPENDENT SCRIPT - This script is dependent on createNewQuote script for getting the Quote details (selenium.newQuoteName & selenium.newQuoteNumber).
#This same URL is getting used in EditQuoteDoNotLinkFeature script as well.
Feature: Using Do Not Link feature - Edit Quote

  Background:
    Given I am logged into salesforce for "EditQuoteLinkingExistingOpp"

#	@OpportunitiesDependent 
	@Quote @EditQuoteLinkingExistingOpp @GCRM-9451
  Scenario Outline: Using Do Not Link feature - Edit Quote
    Given Runmode for "EditQuoteLinkingExistingOpp" is Y
    Then I do login as "<SEG_Sales_Rep>"
    Then I navigate to Sales Home page
    Then Edit Quote Using Do Not Link feature
    And Go through the approval process with Link to Existing
    #Then Validate item Quantity

  Examples:
	  |SEG_Sales_Rep|
	  |Open_Baker|