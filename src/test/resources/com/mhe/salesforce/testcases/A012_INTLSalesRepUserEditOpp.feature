#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL).
#This same URL is getting used in INTLSalesRepUserAddContactToOpp & INTLSalesRepUserAddProductToOpp scripts as well.
Feature: Verify that INTL Sales Rep Lightning user is able to edit an opportunity

Background: 
	Given I am logged into salesforce for "INTLSalesRepUserEditOpp"	
	
@OpportunitiesDependent
@INTLSalesRepUserEditOpp
@GCRM-10184 @GCRM-10238
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that INTL Sales Rep Lightning user is able to edit an opportunity

	Given Runmode for "INTLSalesRepUserEditOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	Then navigate to an exiting opportunity
	And INTLSalesRep user edit opportunity
	And INTLSalesRep user edit opportunity stage

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|