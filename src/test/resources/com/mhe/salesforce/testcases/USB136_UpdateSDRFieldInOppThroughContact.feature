#DEPENDENT SCRIPT - This script is dependent on CreateOppAndVerifyCloseAndPurchaseDate script for getting the Opportunity URL (selenium.NewOppURLForClosePurchaseDateTest).
Feature: Update SDR Fields on the Opportunity record through Contact record

Background: 
	Given I am logged into salesforce for "UpdateSDRFieldInOppThroughContact" 

@OpportunitiesDependent
@UpdateSDRFieldInOppThroughContact
@GCRM-7497
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Update SDR Fields on the Opportunity record through Contact record

	Given Runmode for "UpdateSDRFieldInOppThroughContact" is Y
#	Then I do login as "<SEG_Business_Admin>"
#	Then navigate to MHES Lightning Page
#	When I navigate to contacts page
#	Then create new contact with SDR values
#	Then I logout of any user
#	Then I login as <SEGSalesRep>
	Then I do login as "<SEG_Sales_Rep>"
	Then add contact to existing opp
	And validate SDR field values in opp
	Examples:
  |SEG_Business_Admin|SEG_Sales_Rep|
  |Ivan_Gomez|Open_Baker|