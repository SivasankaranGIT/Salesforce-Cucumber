#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: Verify that INTL Sales Rep Lightning user is able to create an opportunity

Background: 
	Given I am logged into salesforce for "INTLSalesRepUserCreateNewOpp"	
	
@OpportunitiesDependent @RegressionTest @RegressionTestOpportunities @INTLSalesRepUserCreateNewOpp @GCRM-10121 @GCRM-24322 @GCRM-24324 @GCRM-16037
Scenario Outline: Verify that INTL Sales Rep Lightning user is able to create an opportunity

	Given Runmode for "INTLSalesRepUserCreateNewOpp" is Y
	Then I do login as "<Sales Rep Lightning>"
	Then I change the app launcher to "<Sales>"
	Then I navigate to opportunity tab
	Then INTLSalesRep user create new opportunity
#	Then I navigate to opportunity tab
	When I navigate to "Opportunities" tab
	And verify replace PIU with TP validation message in Opp List View
	And verify replace PIU with TP validation message in PIU related list
  Examples:
  |Sales|Sales Rep Lightning|
  |Salesforce Chatter|Nick_Achelles|