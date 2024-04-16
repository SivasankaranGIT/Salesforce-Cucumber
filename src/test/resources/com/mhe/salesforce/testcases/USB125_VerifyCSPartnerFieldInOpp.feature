#DEPENDENT SCRIPT - This script is dependent on AddEverGreenProdAndVerifyEGFieldInOpp script for getting the Opportunity URL (selenium.MHHENewOppURLToVerifyEvergreenField). 
#This same URL is getting used in RemoveOneEGProdAndVerifyEGFieldInOpp, RemoveAllEGProdAndVerifyEGFieldInOpp scripts as well.
Feature: verify MHHE Business Admins can edit field and verify non MHHE BA users only have read access to field

Background: 
	Given I am logged into salesforce for "VerifyCSPartnerFieldInOpp" 

@OpportunitiesDependent
@VerifyCSPartnerFieldInOpp
@GCRM-10855 @GCRM-10209 @GCRM-19422 @GCRM-19423 @GCRM-19419 @GCRM-19418 @GCRM-19420 @GCRM-19421
@RegressionTest @RegressionTestOpportunities
Scenario Outline: verify MHHE Business Admins can edit field and verify non MHHE BA users only have read access to field

	Given Runmode for "VerifyCSPartnerFieldInOpp" is Y
#	Then I login as <MHHEBusinessAdminUserURL>
	Then I do login as "<MHHE_Business_Administrator>"
	Then navigate to an exiting opportunity
	And verify CS Partner field values
	And add opp contact if not already exist
	And verify Title and Rank columns are removed
	And verify CS fields in opp contact
	Then I logout of any user
#	Then I login as <NonMHHEBusinessAdminUserURL>
	Then I do login as "<MHHE_Sales_Representative>"
	Then navigate to an exiting opportunity
	And verify CS Partner field is readonly
	And verify CS fields in opp contact are readonly
	Examples:
  |MHHE_Business_Administrator|MHHE_Sales_Representative|
  |Jaime_Klar|Jackie_Alvarado|