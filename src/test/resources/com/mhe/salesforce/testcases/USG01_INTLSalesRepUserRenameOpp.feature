#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL). 
#This same URL is getting used in INTLSalesRepUserAddContactToOpp, INTLSalesRepUserAddProductToOpp, INTLSalesRepUserEditOpp, INTLSalesRepUserCreateSampleOpp, INTLSalesRepUserVerifyRevenueCal scripts as well.
Feature: Verify that INTL Sales Rep Lightning user is able to rename the Name of the Opportunity

Background: 
	Given I am logged into salesforce for "INTLSalesRepUserRenameOpp"	
	
@OpportunitiesDependent
@INTLSalesRepUserRenameOpp
@GCRM-10134 @GCRM-16035
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that INTL Sales Rep Lightning user is able to rename the Name of the Opportunity

	Given Runmode for "INTLSalesRepUserRenameOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	Then I navigate to Sales Home page
	Then navigate to an exiting opportunity
	And validate the opportunity name
	Then rename the INTL opportunity
	And validate the updated opportunity name

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|
