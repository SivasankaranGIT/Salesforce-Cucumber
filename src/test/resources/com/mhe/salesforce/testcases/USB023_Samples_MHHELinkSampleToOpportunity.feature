#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForSamplesTest script for getting the Opportunity URL (selenium.NewOppURLForSamplesTest)
Feature: Link a sample to an opportunity.

Background: 
Given I am logged into salesforce for "MHHELinkSampToOpp" 
	
@Samples @MHHELinkSampToOpp	@GCRM-9233
Scenario Outline: MHHELinkSampToOpp

	Given Runmode for "MHHELinkSampToOpp" is Y
	Then I do login as "<SEG_Sales_Rep>"
	Then I navigate to Sales Home page
	And select sample from search
	Then link opportunity to sample
  Then verify opportunity linked to sample

Examples:
	|SEG_Sales_Rep|
	|Open_Baker|