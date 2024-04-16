#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify when an Evergreen Product is added to an MHHE Opportunity, the Opportunity Evergreen field is set as 'TRUE'

Background: 
	Given I am logged into salesforce for "AddEverGreenProdAndVerifyEGFieldInOpp" 

@OpportunitiesDependent
@AddEverGreenProdAndVerifyEGFieldInOpp
@GCRM-10855 @GCRM-13049 @GCRM-13277
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify evergreen field is TRUE in opp after adding evergreen product to it

	Given Runmode for "AddEverGreenProdAndVerifyEGFieldInOpp" is Y
#	Then enable everygreen flag for products		#uncomment this line to enable EG flag for 2 products which has atleast one country product
	Then I do login as "<MHHE_Admin>"
	When I click sales Ref user details to navigate Sales
	Then MHHE Business Admin create new MHHE type opportunity
	Then add products to MHHE opportunity
	And verify evergreen field in opportunity when it has evergreen product
	Examples:
  |MHHE_Admin|
  |Jaime_Klar|