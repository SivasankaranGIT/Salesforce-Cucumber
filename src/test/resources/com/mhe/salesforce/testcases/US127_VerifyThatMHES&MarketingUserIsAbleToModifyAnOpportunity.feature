#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote scripts as well.
Feature: VerifyThatMHES&MarketingUserIsAbleToModifyAnOpportunityTest

Background: 
	Given I am logged into salesforce for "MHESModifyOppTest" 	
	
@OpportunitiesDependent
@VerifyThatMHESMarketingUserIsAbleToModifyAnOpportunityTest @GCRM-9082
Scenario Outline: VerifyThatMHES&MarketingUserIsAbleToModifyAnOpportunityTest

	Given Runmode for "MHESModifyOppTest" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And Edit Opportunity edit Stages

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|