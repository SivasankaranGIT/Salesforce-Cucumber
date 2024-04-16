#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd, EditTargetedProductUS scripts as well.
Feature: ConsultantRequestForm

Background: 
	Given I am logged into salesforce for "ConsultantRequestForm" 	
	
@OpportunitiesDependentNA
@ConsultantRequestForm @GCRM-8964
Scenario Outline: ConsultantRequestForm

	Given Runmode for "ConsultantRequestForm" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
 	 When I click sales Ref user details to navigate Sales
	And Consultant Request Form

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|