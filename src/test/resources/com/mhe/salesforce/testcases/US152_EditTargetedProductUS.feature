#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd scripts as well.
Feature: EditTargetedProductUS

Background: 
	Given I am logged into salesforce for "EditTargetedProductUS" 	
	
@OpportunitiesDependent
@EditTargetedProductUS @GCRM-8969
Scenario Outline: EditTargetedProductUS

	Given Runmode for "EditTargetedProductUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
  	When I click sales Ref user details to navigate Sales
	And Edit Opportunity Account Trageted Product

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|