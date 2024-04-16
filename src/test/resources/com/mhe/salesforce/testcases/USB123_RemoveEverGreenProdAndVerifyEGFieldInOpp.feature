#DEPENDENT SCRIPT - This script is dependent on AddEverGreenProdAndVerifyEGFieldInOpp script for getting the Opportunity URL (selenium.MHHENewOppURLToVerifyEvergreenField). 
Feature: Verify when one of the evergreen products from an opportunity is removed, still the Opportunity Evergreen field is set as TRUE

Background: 
	Given I am logged into salesforce for "RemoveOneEGProdAndVerifyEGFieldInOpp" 

@OpportunitiesDependent
@RemoveOneEverGreenProdAndVerifyEGFieldInOpp
@GCRM-10863 @GCRM-13052 @GCRM-13277
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify evergreen field is TRUE in opp after removing one of the evergreen product

	Given Runmode for "RemoveOneEGProdAndVerifyEGFieldInOpp" is Y
#	Then I login as <UserURL>
	Then I do login as "<MHHE_Business_Administrator>"
	Then navigate to an exiting opportunity
	Then remove one evergreen product from opportunity
	And verify evergreen field in opportunity when it has evergreen product
	Examples:
  |MHHE_Business_Administrator|
  |Jaime_Klar|