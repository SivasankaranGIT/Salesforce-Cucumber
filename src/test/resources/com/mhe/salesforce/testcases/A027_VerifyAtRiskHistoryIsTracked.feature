#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL).
Feature: Confirm At Risk field history is tracked

  Background: Given I am logged into salesforce for "VerifyAtRiskHistoryIsTracked"

  @OpportunitiesDependent @VerifyAtRiskHistoryIsTracked @GCRM-17861
  Scenario Outline: Confirm At Risk field history is tracked
  Given Runmode for "VerifyAtRiskHistoryIsTracked" is Y
# Then I login as <UserURL>
  Then I do login as "<MHE_Business_Operations>"
  Then navigate to an exiting opportunity
  And  Verify At Risk History is Tracked
# |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001GMv13AAD/view|

  Examples:
    |MHE_Business_Operations|
    |Nisha_Bansal|