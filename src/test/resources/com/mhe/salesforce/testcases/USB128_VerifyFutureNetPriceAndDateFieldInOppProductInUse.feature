#DEPENDENT SCRIPT - This script is dependent on AddEverGreenProdAndVerifyEGFieldInOpp script for getting the Opportunity URL (selenium.MHHENewOppURLToVerifyEvergreenField). 
#This same URL is getting used in RemoveOneEGProdAndVerifyEGFieldInOpp, RemoveAllEGProdAndVerifyEGFieldInOpp, VerifyCSPartnerFieldInOpp, VerifyFutureNetPriceAndDateFieldProd scripts as well.
Feature: Verify the Products In Use Related list from Opportunity record has Future Net Price and Future Price date fields added to the list view

Background: 
	Given I am logged into salesforce for "VerifyFutureNetPriceAndDateFieldProdInUse" 

@OpportunitiesDependent
@VerifyFutureNetPriceAndDateFieldProdInUse
@GCRM-9902 @GCRM-9897
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the Products In Use Related list from Opportunity record has Future Net Price and Future Price date fields added to the list view

	Given Runmode for "VerifyFutureNetPriceAndDateFieldProdInUse" is Y
#	Then I login as <MHHEBusinessAdminUserURL>
	Then I do login as "<MHHE_Business_Administrator>"
	And verify FutureNetPrice and FuturePriceDate field in ProductInUse
#	Then I login as <MHHESalesRepUserURL>
	Then I do login as "<MHHE_Sales_Representative>"
	And verify FutureNetPrice and FuturePriceDate field in ProductInUse

	Examples:
	|MHHE_Business_Administrator|MHHE_Sales_Representative|
	|Jaime_Klar|Jackie_Alvarado|