#DEPENDENT SCRIPT - This script is dependent on multiple test scripts to get the URLs of the records (which has been created at run time) which needs to be deleted
Feature: Verify that the system admin is able to delete the opportunity or not

Background: 
	Given I am logged into salesforce for "DeleteOpportunity" 
	
@OpportunitiesDependent
@DeleteOpportunity @GCRM-8404 @GCRM-9193
Scenario Outline: Verify that the system admin is able to delete the opportunity or not

	Given Runmode for "DeleteOpportunity" is Y
#  Then I login as Sales Rep
  Then I do login as "<System_Administrator>"
  Then I navigate to Sales Home page
  #And delete opportunity
  Then global search for opportunities
  And delete original opp created for SEGSalesRepUserCreateOpportunity

  Examples:
  |System_Administrator|
  |Sivasankaran_Periyasamy|