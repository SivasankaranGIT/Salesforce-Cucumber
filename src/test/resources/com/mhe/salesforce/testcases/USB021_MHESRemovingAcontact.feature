#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd, EditTargetedProductUS, ConsultantRequestForm, EditProductFromOpp, AddingPrimaryContact, MHHEAddingSecondaryContact scripts as well.
Feature: MHHERemovingAcontact

Background: 
	Given I am logged into salesforce for "MHHERemovingAcontact" 	
	
@OpportunitiesDependent
@MHHERemovingAcontact @GCRM-9263
Scenario Outline: MHHERemovingAcontact

	Given Runmode for "MHHERemovingAcontact" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And Removal of Opp Contact From Opportunity by Name
	And Opp Contact Add after Removel

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|