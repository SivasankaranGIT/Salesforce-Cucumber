#DEPENDENT SCRIPT - This script is dependent on AddEverGreenProdAndVerifyEGFieldInOpp script for getting the Opportunity URL (selenium.MHHENewOppURLToVerifyEvergreenField). 
#This same URL is getting used in RemoveOneEGProdAndVerifyEGFieldInOpp, RemoveAllEGProdAndVerifyEGFieldInOpp, VerifyCSPartnerFieldInOpp, VerifyFutureNetPriceAndDateFieldProd, VerifyFutureNetPriceAndDateFieldProdInUse, VerifyTPFieldForCurrentYearOpp, VerifyTPFieldForPastYearOpp scripts as well.
Feature: confirm new and relabeled fields are editable to BA and not editable to MHHE Implementation Team user

Background: 
	Given I am logged into salesforce for "VerifyFieldsLabelInUserAndOpp" 

@OpportunitiesDependent
@VerifyFieldsLabelInUserAndOpp
@GCRM-7501 @GCRM-7502 @GCRM-14263
@RegressionTest @RegressionTestOpportunities
Scenario Outline: confirm new and relabeled fields are editable to BA and not editable to MHHE Implementation Team user

	Given Runmode for "VerifyFieldsLabelInUserAndOpp" is Y
	Then I logout of any user
	Then verify field label in user setup <MHHEBusinessAdminL>
	Then I do login as "<MHHE_Admin>"
	Then navigate to an exiting opportunity
	And verify field label in opportunity
	Then I logout of any user
	Then I do login as "<MHHE_Implementation_Team>"
	Then navigate to an exiting opportunity
	And verify CustomerSuccssSpecialist field is non editable
	Examples:
  |MHHEBusinessAdminL|MHHE_Implementation_Team|MHHE_Admin|
  |"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F005C0000006w00aIAA%3Fnoredirect%3D1%26isUserEntityOverride%3D1%26retURL%3D%252Fsetup%252Fhome"|Jordan_Allen|Jaime_Klar|