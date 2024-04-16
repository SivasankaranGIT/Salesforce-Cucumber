#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL).
#This same URL is getting used in INTLSalesRepUserAddContactToOpp, INTLSalesRepUserAddProductToOpp, INTLSalesRepUserEditOpp, INTLSalesRepUserCreateSampleOpp, INTLCloneOpp, ValidateInActiveINTLOppContact scripts as well.
Feature: Verify for Opp with year less than current year the INTL Opportunity contact is NOT getting deleted when the same contact is marked as inactive

Background: 
	Given I am logged into salesforce for "ValidateInActiveINTLOppContactForPastYear" 
	
@OpportunitiesDependent
@ValidateInActiveINTLOppContactForPastYear
@GCRM-10570 @GCRM-16039
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify for Opp with year less than current year the INTL Opportunity contact is NOT getting deleted when the same contact is marked as inactive

	Given Runmode for "ValidateInActiveINTLOppContactForPastYear" is Y
	Then I do login as "<System_Administrator>"
	Then navigate to an exiting opportunity
	Then update the opportunity year to past year
	Then I logout of any user
	Then I do login as "<Sales_Rep_Lightning>"
	Then I navigate to Sales Home page
	Then navigate to an exiting opportunity
	And deactivate the opportunity contact
	Then navigate to an exiting opportunity
#	And verify that the opportunity contact record is present or not
	And activate the contact back
	
	Examples: 
	|System_Administrator|Sales_Rep_Lightning|
	|Sivasankaran_Periyasamy|Nick_Achelles|