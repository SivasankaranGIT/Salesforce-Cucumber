#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd, EditTargetedProductUS, ConsultantRequestForm, EditProductFromOpp, AddingPrimaryContact, MHHEAddingSecondaryContact, MHHERemovingAcontact, MHESSearchingAllAvailableContacts, VerifyTaskOnOpportunity, CreateNewOppFromQuote scripts as well.
Feature: Verify when year is updated using Postpone/clone opportunity, purchase date, Closed/Decision date year are changed as per the updated financial year

Background: 
	Given I am logged into salesforce for "VerifyOppCloseAndPurchaseDatePostponeClone" 
	
@OpportunitiesDependent
@VerifyOppCloseAndPurchaseDatePostponeClone
@GCRM-9543 @GCRM-16032
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify when year is updated using Postpone/clone opportunity, purchase date, Closed/Decision date year are changed as per the updated financial year

	Given Runmode for "VerifyOppCloseAndPurchaseDatePostponeClone" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	When I click sales Ref user details to navigate Sales
	Then navigate to an exiting opportunity
	Then change the opportunity stage to OPEN
	And Opportunities PostponeClone Validation
	And add subtypes in opportunity
	And validate the close and purchase dates

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|