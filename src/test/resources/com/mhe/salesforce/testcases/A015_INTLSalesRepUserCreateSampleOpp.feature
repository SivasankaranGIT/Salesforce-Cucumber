#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL). 
#This same URL is getting used in INTLSalesRepUserAddContactToOpp & INTLSalesRepUserAddProductToOpp & INTLSalesRepUserEditOpp scripts as well.
Feature: Verify That INTL Sales Rep User Can Add A Sample To An Opportunity

Background: 
	Given I am logged into salesforce for "INTLSalesRepUserCreateSampleOpp"	
	
@OpportunitiesDependent
@INTLSalesRepUserCreateSampleOpp
@GCRM-10243 @GCRM-16037
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify That INTL Sales Rep User Can Add A Sample To An Opportunity

	Given Runmode for "INTLSalesRepUserCreateSampleOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	Then navigate to an exiting opportunity
	And I Add INTL Sample to opportunity

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|