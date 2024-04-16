#DEPENDENT SCRIPT - This script is dependent on MHHESalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.MHHENewOppURL).
Feature: Verify the Process Builder Functionality

Background: 
	Given I am logged into salesforce for "VerifyProcessBuilderFunctionality"	
	
@OpportunitiesDependent @VerifyProcessBuilderFunctionality @GCRM-16954 @GCRM-16958
Scenario Outline: Verify the Process Builder Functionality
	Given Runmode for "VerifyProcessBuilderFunctionality" is Y
	Then I logout of any user
	And  I change the app launcher to <app_Name>
	Then navigate to an exiting opportunity
	And verify the process builder functionality
  Examples:
  |app_Name|
  |"MHHE"|