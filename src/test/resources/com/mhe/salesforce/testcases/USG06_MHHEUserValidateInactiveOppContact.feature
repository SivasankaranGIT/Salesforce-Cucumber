#DEPENDENT SCRIPT - This script is dependent on MHHESalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.MHHENewOppURL).
#This same URL is getting used in VerifyProcessBuilderFunctionality,MHHESalesRepUserEditOpp, VerifyDFCRequestFieldsInOpp, MHHESalesRepUserRenameOpp scripts as well.
Feature: Verify that MHHE Opportunity contact is getting deleted automatically when the same contact is marked as inactive

Background: 
	Given I am logged into salesforce for "ValidateInActiveMHHEOppContact" 
	
@OpportunitiesDependent
@ValidateInActiveMHHEOppContact
@GCRM-10632 @GCRM-16013
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that MHHE Opportunity contact is getting deleted automatically when the same contact is marked as inactive

	Given Runmode for "ValidateInActiveMHHEOppContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then verify the contact is active or not
	And I change the app launcher to MHHE
	Then navigate to an exiting opportunity
	And I Add contact from MHHE opportunity page
	And deactivate the opportunity contact
	Then navigate to an exiting opportunity
	And verify that the opportunity contact record got deleted or not
	And activate the contact back

	Examples:
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|

