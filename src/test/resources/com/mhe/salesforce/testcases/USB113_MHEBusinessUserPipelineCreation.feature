#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHE Business Operations user is able to perform "Pipeline Creation" process

  Background:
    Given I am logged into salesforce for "MHEBusinessUserPipelineCreation"

	@OpportunitiesNonDependent @MHEBusinessUserPipelineCreation @GCRM-10301 @GCRM-10063 @RegressionTest @RegressionTestOpportunities
  Scenario Outline: Verify that MHE Business Operations user is able to perform "Pipeline Creation" process
    Given Runmode for "MHEBusinessUserPipelineCreation" is Y
		#Then I login as Sales Rep
    Then I do login as "<MHE_Business_Operations>"
    Then I change the app launcher to "<Sales>"
    And I switch to Pipeline Creation page
    And verify pipeline creation process
	Examples:
  |Sales|MHE_Business_Operations|
  |Sales|Nisha_Bansal|