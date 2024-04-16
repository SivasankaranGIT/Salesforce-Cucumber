#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL). 
#This same URL is getting used in INTLSalesRepUserAddContactToOpp, INTLSalesRepUserAddProductToOpp, INTLSalesRepUserEditOpp, INTLSalesRepUserCreateSampleOpp scripts as well.
Feature: Verify Revenue Calculation on Product with header type as Print & another Product with header type as Digital

Background: 
	Given I am logged into salesforce for "INTLSalesRepUserVerifyRevenueCal"
	
@OpportunitiesDependent
@INTLSalesRepUserVerifyRevenueCalculation
@GCRM-10554 @GCRM-10556 @GCRM-10557 @GCRM-11748 @GCRM-16041
@RegressionTest @RegressionTestOpportunities

Scenario Outline: Verify Revenue Calculation on Product with header type as Digital & another Product with header type as Print

	Given Runmode for "INTLSalesRepUserVerifyRevenueCal" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHE_Business_Operations>"
	Then navigate to an exiting opportunity
	And verify Revenue Calculation on Product with header type as Print
	Then add digital product to opportunity
	And verify Revenue Calculation on Product with header type as Print and Digital
	And delete print product and verify print revenue value

	Examples:
	|MHE_Business_Operations|
	|Nisha_Bansal|
