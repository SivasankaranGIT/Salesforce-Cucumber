#DEPENDENT SCRIPT - This script is dependent on createNewQuote script for getting the Quote details (selenium.newQuoteName & selenium.newQuoteNumber).
Feature: Using Do Not Link feature - Edit Quote

  Background:
    Given I am logged into salesforce for "EditQuoteDoNotLinkFeature"

#	@OpportunitiesDependent 
	@Quote @EditQuoteDoNotLinkFeature @GCRM-9450
  Scenario Outline: Using Do Not Link feature - Edit Quote
    Given Runmode for "EditQuoteDoNotLinkFeature" is Y
    Then I do login as "<SEG_Sales_Rep>"
    And I change the app launcher to Salesforce Chatter
    Then Edit Quote Using Do Not Link feature
    And Go through the approval process with Do not link Opportunity
    Then Validate opportunity linked
      
  Examples: 
	  |SEG_Sales_Rep|
	  |Open_Baker|