#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). This same URL is getting used in SEGSalesRepUserEditOpp & MHESUserSplitProducts scripts as well.
Feature: VerifyThatMHESUserIsAbleToPostponeCloneOpportunity

Background: 
	Given I am logged into salesforce for "MHESPostponeCloneOpp"	
	
@OpportunitiesDependent
@US_TS01_TC27_VerifyThatMHESUserIsAbleToPostponeCloneOpportunity
@GCRM-8966 @GCRM-10313 @GCRM-16033
@RegressionTest @RegressionTestOpportunities
Scenario Outline: VerifyThatMHESUserIsAbleToPostponeCloneOpportunity

	Given Runmode for "MHESPostponeCloneOpp" is Y
	Then I do login as "<SEG_Sales_Rep>"
  When I click sales Ref user details to navigate Sales
  #Incase account is not linked to below contact then we need to login as system admin and add Lawton account
  And make sure the contact is active and linked to account
  Then navigate to an exiting opportunity
  And add Primary Campaign Source to opportunity
  And add opp contact if not already exist
  And add opp product if not already exist
	And Opportunities PostponeClone Validation
	And add subtypes in opportunity
	And verify the Primary Campaign Source and opp Created Date in newly cloned opportunities
	And verify the Product and Contact details in newly cloned opportunities
	And validate the Reason in previous opportunity

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|