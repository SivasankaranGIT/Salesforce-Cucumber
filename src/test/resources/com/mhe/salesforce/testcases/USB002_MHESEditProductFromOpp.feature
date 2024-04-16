#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd, EditTargetedProductUS, ConsultantRequestForm scripts as well.
Feature: EditProductFromOpp

Background: 
	Given I am logged into salesforce for "EditProductFromOpp" 	
	
@OpportunitiesDependent
@EditProductFromOpp @GCRM-9279
Scenario Outline: EditProductFromOpp

	Given Runmode for "EditProductFromOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
  When Edit Product From Opp

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|