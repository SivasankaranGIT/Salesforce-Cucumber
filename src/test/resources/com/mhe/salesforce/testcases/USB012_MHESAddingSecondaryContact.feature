#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd, EditTargetedProductUS, ConsultantRequestForm, EditProductFromOpp, AddingPrimaryContact scripts as well.
Feature: MHHEAddingSecondaryContact

Background: 
	Given I am logged into salesforce for "MHHEAddingSecondaryContact" 	
	
@OpportunitiesDependent
@MHHEAddingSecondaryContact @GCRM-9251
Scenario Outline: MHHEAddingSecondaryContact

	Given Runmode for "MHHEAddingSecondaryContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And Removal of Opp Contact Add Secondary
	And Opp Contact Add Secondary

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|