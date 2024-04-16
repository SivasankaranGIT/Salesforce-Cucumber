#DEPENDENT SCRIPT - This script is dependent on MHHESalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.MHHENewOppURL).
#This same URL is getting used in VerifyProcessBuilderFunctionality,MHHESalesRepUserEditOpp, VerifyDFCRequestFieldsInOpp, MHHESalesRepUserRenameOpp, ValidateInActiveMHHEOppContact scripts as well.
#Pre-condition: The opp's owner should be Jackie Alvarado and this user's Manager2 in User Setup page should be set as James Heine. 
Feature: Verify the E2E flow of Request Product Exception functionality

Background: 
	Given I am logged into salesforce for "VerifyRequestProductExceptionflow" 

@OpportunitiesDependent @VerifyRequestProductExceptionflow @GCRM-24141 @GCRM-24162 @GCRM-24311 @GCRM-24140 @GCRM-24138 @GCRM-24139
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the E2E flow of Request Product Exception functionality
	Given Runmode for "VerifyRequestProductExceptionflow" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	And I change the app launcher to MHHE
	Then navigate to an exiting opportunity
	Then add print exception allowed product to opportunity
	Then create and verify the request product exception
	Then I logout of any user
	Then I do login as "<MHHE_Sales_Manager>"
	And I change the app launcher to MHHE
	Then approve the product exception request
	And try creating one more product expection request when existing request is pending
	And verify the product exception request status after approval
	Then I logout of any user
	Then I do login as "<Print_Exception>"
	And I change the app launcher to MHHE
	Then reject the product exception request
	And verify the product exception request status after rejection
Examples:
	|MHHE_Business_Administrator|MHHE_Sales_Manager|Print_Exception|
	|Jaime_Klar|James_Heine|Print_Exception|