#DEPENDENT SCRIPT - This script is dependent on AddEverGreenProdAndVerifyEGFieldInOpp script for getting the Opportunity URL (selenium.MHHENewOppURLToVerifyEvergreenField). 
#This same URL is getting used in RemoveOneEGProdAndVerifyEGFieldInOpp, RemoveAllEGProdAndVerifyEGFieldInOpp, VerifyCSPartnerFieldInOpp scripts as well.
Feature: Verify the Products Related list from Opportunity record has Future Net Price and Future Price date fields added to the list view

Background: 
	Given I am logged into salesforce for "VerifyFutureNetPriceAndDateFieldProd" 

@OpportunitiesDependent
@VerifyFutureNetPriceAndDateFieldInOppProduct
@GCRM-9896
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the Products Related list from Opportunity record has Future Net Price and Future Price date fields added to the list view

	Given Runmode for "VerifyFutureNetPriceAndDateFieldProd" is Y
#	Then I login as <MHHEBusinessAdminUserURL>
	Then I do login as "<MHHE_Business_Administrator>"
	Then navigate to an exiting opportunity
	Then add products to MHHE opportunity
	Then navigate to an exiting opportunity
	And verify FutureNetPrice and FuturePriceDate field in Product
#	Then I login as <MHHESalesRepUserURL>
	Then I do login as "<MHHE_Sales_Representative>"
	Then navigate to an exiting opportunity
	And verify FutureNetPrice and FuturePriceDate field in Product
	Examples:
  |MHHE_Business_Administrator|MHHE_Sales_Representative|
  |Jaime_Klar|Jackie_Alvarado|