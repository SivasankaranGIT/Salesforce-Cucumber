#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity scripts as well.
Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToEditTheTargetedProducts

Background: 
	Given I am logged into salesforce for "MHHERepEditTargetedProd" 	
	
@OpportunitiesDependent
@VerifyThatMHHESalesRepAndMarketingUserIsAbleToEditTheTargetedProducts @GCRM-8960
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToEditTheTargetedProducts

	Given Runmode for "MHHERepEditTargetedProd" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
  When I click sales Ref user details to navigate Sales
	And Edit Opportunity Account Trageted Product
	
	Examples: 
	|SEG_Sales_Rep|
	|Open_Baker|