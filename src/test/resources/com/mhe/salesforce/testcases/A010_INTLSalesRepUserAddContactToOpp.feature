#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL)
Feature: Verify That INTL Sales Rep User Can Add A Contact To An Opportunity

Background: 
	Given I am logged into salesforce for "INTLSalesRepUserAddContactToOpp"	
	
@OpportunitiesDependent
@INTLSalesRepUserAddContactToOpp
@GCRM-10165 @GCRM-16037
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify That INTL Sales Rep User Can Add A Contact To An Opportunity

	Given Runmode for "INTLSalesRepUserAddContactToOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales Rep Lightning>"
	Then verify the contact is active or not
	Then navigate to an exiting opportunity
	And I Add contact <LastName> from opportunity page
	
	Examples:
	|LastName|Sales Rep Lightning|
	|"Mylan"|Nick_Achelles|
	