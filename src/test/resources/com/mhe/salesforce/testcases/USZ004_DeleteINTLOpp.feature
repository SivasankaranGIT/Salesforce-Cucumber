#DEPENDENT SCRIPT - This script is dependent on multiple test scripts to get the URLs of the records (which has been created at run time) which needs to be deleted
Feature: Verify the MHE Business Operations user can delete the INTL opportunity

Background: 
	Given I am logged into salesforce for "DeleteINTLOpportunity" 

@OpportunitiesDependent
@DeleteINTLOpportunity
@GCRM-10275
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the MHE Business Operations user can delete the INTL opportunity

	Given Runmode for "DeleteINTLOpportunity" is Y
#  Then I login as Sales Rep
  Then I do login as "<MHE_Business_Operations>"
  Then I navigate to Sales Home page
  Then navigate to an exiting opportunity
  And delete INTL opportunity

  Examples:
  |MHE_Business_Operations|
  |Nisha_Bansal|