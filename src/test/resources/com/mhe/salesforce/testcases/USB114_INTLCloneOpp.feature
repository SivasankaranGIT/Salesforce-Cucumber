#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL).
#This same URL is getting used in INTLSalesRepUserAddContactToOpp, INTLSalesRepUserAddProductToOpp, INTLSalesRepUserEditOpp, INTLSalesRepUserCreateSampleOpp scripts as well.
Feature: Verify that INTL sales rep user is able to Clone an Opportunity using clone button present in opportunity record

Background: 
	Given I am logged into salesforce for "INTLCloneOpp" 
	
@OpportunitiesDependent
@INTLCloneOpp
@GCRM-10368 @GCRM-16043
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that INTL sales rep user is able to Clone an Opportunity using clone button present in opportunity record

	Given Runmode for "INTLCloneOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	Then navigate to an exiting opportunity
	And I clone INTL opportunity using clone option
	And verify the Product and Contact details in newly cloned opportunities

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|