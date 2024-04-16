#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL).
#This same URL is getting used in INTLSalesRepUserAddContactToOpp, INTLSalesRepUserAddProductToOpp, INTLSalesRepUserEditOpp, INTLSalesRepUserCreateSampleOpp, INTLCloneOpp scripts as well.
Feature: Verify for Opp with year greater than or equal to current year the INTL Opportunity contact is getting deleted automatically when the same contact is marked as inactive

Background: 
	Given I am logged into salesforce for "ValidateInActiveINTLOppContact" 
	
@OpportunitiesDependent
@ValidateInActiveINTLOppContact
@GCRM-10393
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that INTL Opportunity contact is getting deleted automatically when the same contact is marked as inactive

	Given Runmode for "ValidateInActiveINTLOppContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	Then I navigate to Sales Home page
	Then navigate to an exiting opportunity
	And deactivate the opportunity contact
	Then navigate to an exiting opportunity
	And verify that the opportunity contact record got deleted or not
	And activate the contact back
	Then navigate to an exiting opportunity
	And I Add contact <LastName> from opportunity page	
	
Examples:
	|LastName|Sales_Rep_Lightning|
	|"Mylan"|Nick_Achelles|