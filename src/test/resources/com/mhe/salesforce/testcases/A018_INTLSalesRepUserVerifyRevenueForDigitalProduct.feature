#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: Verify Revenue Calculation on Product with header type as Digital

Background: 
	Given I am logged into salesforce for "INTLSalesRepUserVerifyRevenueForDigitalProduct"
	
@OpportunitiesDependent
@INTLSalesRepUserVerifyRevenueForDigitalProduct
@GCRM-10554 @GCRM-10556 @GCRM-10557 @GCRM-10390 @GCRM-16041
@RegressionTest @RegressionTestOpportunities

Scenario Outline: Verify Revenue Calculation on Product with header type as Digital

	Given Runmode for "INTLSalesRepUserVerifyRevenueForDigitalProduct" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
#	And I change the app launcher to "Sales"
	Then I navigate to salesapplication
	Then I navigate to opportunity tab
	Then INTLSalesRep user create new opportunity
	Then add digital product to opportunity
	And verify Revenue Calculation on Product with header type as Digital

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|