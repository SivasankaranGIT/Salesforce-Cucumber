#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Samples created users other than sales reps will have a Pending Approval status

Background: 
Given I am logged into salesforce for "SamplesPrepopulateContAndProd" 
	
	
@Samples
@US_TC05_Sample_VerifyThatSamplesCreatedFromOpportunityWillPrepopulateCombinationsOfContactsAndProducts	@GCRM-9280
Scenario Outline: VerifyThatSamplesCreatedFromOpportunityWillPrepopulateCombinationsOfContactsAndProducts

	Given Runmode for "SamplesPrepopulateContAndProd" is Y
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for opportunities
	Then click on sample contact button from opportunity
	Then click on next and verify samples section
	
	Examples: 
	|MHHE_Sales_Representative|
	|Jenna_Taylor|