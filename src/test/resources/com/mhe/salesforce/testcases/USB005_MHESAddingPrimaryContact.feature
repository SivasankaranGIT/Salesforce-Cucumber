#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd, EditTargetedProductUS, ConsultantRequestForm, EditProductFromOpp scripts as well.
Feature: AddingPrimaryContact

Background: 
	Given I am logged into salesforce for "AddingPrimaryContact" 	
	
@OpportunitiesDependent
@AddingPrimaryContact
@GCRM-9247 @GCRM-16028 @GCRM-16026
@RegressionTest @RegressionTestOpportunities
Scenario Outline: AddingPrimaryContact

	Given Runmode for "AddingPrimaryContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And Opp Contact Add Primary
	Then I logout of any user

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|