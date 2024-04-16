#DEPENDENT SCRIPT - This script is dependent on MHHESalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.MHHENewOppURL)
Feature: Verify that MHHE Sales Rep Lightning user is able to edit an opportunity & verify Term Revenue field

Background: 
	Given I am logged into salesforce for "MHHESalesRepUserEditOpp"	
	
@OpportunitiesDependent
@MHHESalesRepUserEditOpp
@GCRM-10187 @GCRM-10236 @GCRM-10550 @GCRM-16015
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that MHHE Sales Rep Lightning user is able to edit an opportunity & verify Term Revenue field

	Given Runmode for "MHHESalesRepUserEditOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then navigate to an exiting opportunity
	And verify Term Revenue field in MHHE Opp
	And MHHESalesRep user edit opportunity
	And MHHESalesRep user edit opportunity stage
	
	Examples: 
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|