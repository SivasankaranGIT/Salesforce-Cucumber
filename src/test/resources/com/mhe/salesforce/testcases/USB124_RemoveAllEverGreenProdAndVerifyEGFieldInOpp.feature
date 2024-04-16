#DEPENDENT SCRIPT - This script is dependent on AddEverGreenProdAndVerifyEGFieldInOpp script for getting the Opportunity URL (selenium.MHHENewOppURLToVerifyEvergreenField). 
#This same URL is getting used in RemoveOneEGProdAndVerifyEGFieldInOpp script as well.
Feature: Verify when all the Evergreen products are removed from Opportunity, the 'Evergreen' field in Op record is updated to FALSE

Background: 
	Given I am logged into salesforce for "RemoveAllEGProdAndVerifyEGFieldInOpp" 

@OpportunitiesDependent
@RemoveAllEverGreenProdAndVerifyEGFieldInOpp
@GCRM-10858 @GCRM-13053 @GCRM-13277
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify evergreen field is FLASE in opp after removing all the evergreen product

	Given Runmode for "RemoveAllEGProdAndVerifyEGFieldInOpp" is Y
#	Then I login as <UserURL>
	Then I do login as "<MHHE_Business_Administrator>"
	Then navigate to an exiting opportunity
	Then remove all evergreen product from opportunity
	And verify evergreen field in opportunity when it does not have evergreen product
#	Then I logout of any user
#	Then disable everygreen flag for products
	Examples:
  |MHHE_Business_Administrator|
  |Jaime_Klar|