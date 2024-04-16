#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd, EditTargetedProductUS, ConsultantRequestForm, EditProductFromOpp, AddingPrimaryContact, MHHEAddingSecondaryContact, MHHERemovingAcontact scripts as well.
Feature: MHESSearchingAllAvailableContacts

Background: 
	Given I am logged into salesforce for "MHESSearchingAllAvailableContacts" 	
	
@OpportunitiesDependent
@MHESSearchingAllAvailableContacts @GCRM-9255
Scenario Outline: MHESSearchingAllAvailableContacts

	Given Runmode for "MHESSearchingAllAvailableContacts" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And Opp Contact Add All
	Then I logout of any user

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|