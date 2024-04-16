#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL). 
#This same URL is getting used in INTLSalesRepUserAddContactToOpp script as well.
Feature: Verify That INTL Sales Rep User Can Add A Product To An Opportunity

Background: 
	Given I am logged into salesforce for "INTLSalesRepUserAddProductToOpp"	
	
@OpportunitiesDependent
@INTLSalesRepUserAddProductToOpp
@GCRM-10168 @GCRM-24322 @GCRM-24324 @GCRM-16037
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify That INTL Sales Rep User Can Add A Product To An Opportunity

	Given Runmode for "INTLSalesRepUserAddProductToOpp" is Y
	Then I do login as "<Sales_Rep_Lightning>"
	Then navigate to an exiting opportunity
	And I Add product from opportunity page
	Then I navigate to opportunity tab
	And verify ReplacePIUwithTP functionality from Opp List View
	And verify ReplacePIUwithTP functionality from PIU related list
	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|