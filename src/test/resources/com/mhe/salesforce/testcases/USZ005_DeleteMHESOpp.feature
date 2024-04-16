#DEPENDENT SCRIPT - This script is dependent on multiple test scripts to get the URLs of the records (which has been created at run time) which needs to be deleted
Feature: Verify the SEG Biz Admin user can delete the MHES/SEG opportunity

Background: 
	Given I am logged into salesforce for "DeleteMHESOpportunity" 

@OpportunitiesDependent
@DeleteMHESOpportunity
@GCRM-10276
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the SEG Biz Admin user can delete the MHES/SEG opportunity

	Given Runmode for "DeleteMHESOpportunity" is Y
#  Then I login as Sales Rep
  Then I do login as "<SEG_Business_Admin>"
  Then I navigate to Sales Home page
  Then navigate to an exiting opportunity
  And delete MHES opportunity

  Examples:
  |SEG_Business_Admin|
  |Ivan_Gomez|
