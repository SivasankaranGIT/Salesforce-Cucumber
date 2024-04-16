#DEPENDENT SCRIPT - This script is dependent on MHHESalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.MHHENewOppURL).
#This same URL is getting used in VerifyProcessBuilderFunctionality,MHHESalesRepUserEditOpp, VerifyDFCRequestFieldsInOpp scripts as well.
Feature: Verify that MHHE Sales Rep user is able to rename the Name of the Opportunity and verify Lead Nomination Details section

Background: 
	Given I am logged into salesforce for "MHHESalesRepUserRenameOpp"	
	
@OpportunitiesDependent
@MHHESalesRepUserRenameOpp
@GCRM-10144 @GCRM-8288 @GCRM-16009
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that MHHE Sales Rep user is able to rename the Name of the Opportunity and verify Lead Nomination Details section

	Given Runmode for "MHHESalesRepUserRenameOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	Then navigate to an exiting opportunity
#	And validate the opportunity name
#	Then rename the opportunity
#	And validate the updated opportunity name
	And verify Lead Nomination Details section

	Examples:
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|