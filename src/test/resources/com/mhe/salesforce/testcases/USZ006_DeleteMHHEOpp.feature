#DEPENDENT SCRIPT - This script is dependent on multiple test scripts to get the URLs of the records (which has been created at run time) which needs to be deleted
Feature: Verify the MHHE business admin user can delete the MHHE opportunity

Background: 
	Given I am logged into salesforce for "DeleteMHHEOpportunity" 

@OpportunitiesDependent
@DeleteMHHEOpportunity
@GCRM-10277
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the MHHE business admin user can delete the MHHE opportunity

	Given Runmode for "DeleteMHHEOpportunity" is Y
#  Then I login as Sales Rep
  Then I do login as "<MHHE_Business_Administrator>"
  #Then I navigate to Sales Home page
  Then navigate to an exiting opportunity
  And delete MHHE opportunity

  Examples:
  |MHHE_Business_Administrator|
  |Jaime_Klar|