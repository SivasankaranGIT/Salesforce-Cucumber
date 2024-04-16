#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForQuotesTest script for getting the Opportunity URL (selenium.NewOppURLForQuotesTest)
#This same URL is getting used in createNewQuote and EditQuoteInOpp scripts as well. 
Feature: Creating new opp from quote

  Background:
    Given I am logged into salesforce for "CreateNewOppFromQuote"

#	@OpportunitiesDependent
  @Quote @CreateNewOppFromQuote @GCRM-9449
  Scenario Outline: Creating new opp from quote
    Given Runmode for "CreateNewOppFromQuote" is Y
    Then I do login as "<SEG_Sales_Rep>"
    And I change the app launcher to Salesforce Chatter
    #And add subtypes in opportunity
    Then navigate to MHE_Quotes tab on Account
    Then I click on MHE New Quote
    Then I Create a New Quote
    And I Add <ISBN> number
    And Select Opportunity name and validate status
    Examples:
    |ISBN|SEG_Sales_Rep|
    |"9780076866878"|Open_Baker|