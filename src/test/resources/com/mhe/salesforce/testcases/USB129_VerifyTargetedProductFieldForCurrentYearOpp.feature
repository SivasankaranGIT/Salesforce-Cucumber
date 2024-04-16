#DEPENDENT SCRIPT - This script is dependent on AddEverGreenProdAndVerifyEGFieldInOpp script for getting the Opportunity URL (selenium.MHHENewOppURLToVerifyEvergreenField). 
#This same URL is getting used in RemoveOneEGProdAndVerifyEGFieldInOpp, RemoveAllEGProdAndVerifyEGFieldInOpp, VerifyCSPartnerFieldInOpp, VerifyFutureNetPriceAndDateFieldProd, VerifyFutureNetPriceAndDateFieldProdInUse scripts as well.
Feature: Verify the targeted product field is updated in the related Opportunity orders when the opportunity year is current year

Background: 
	Given I am logged into salesforce for "VerifyTPFieldForCurrentYearOpp" 

@OpportunitiesDependent
@VerifyTPFieldForCurrentYearOpp
@GCRM-10447
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the targeted product field is updated in the related Opportunity orders when the opportunity year is current year

	Given Runmode for "VerifyTPFieldForCurrentYearOpp" is Y
	Then I logout of any user
	Then create order line and add opportunity order to it
	Then I do login as "<MHHE_Business_Administrator>"
	Then navigate to an exiting opportunity
#	Then add targeted products to MHHE opportunity //when creating opp in USB122 itself we are adding products to this opp. 
	And Verify Order Targeted Products field in opportunity
	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|