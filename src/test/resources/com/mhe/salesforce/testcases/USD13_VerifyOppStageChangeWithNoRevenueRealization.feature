#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify profile user change the stage an Opportunity having Opportunity Contact ,Targeted Product, Decision Dynamic but no value in Revenue Realization

  Background:
    Given I am logged into salesforce for "VerifyOppStageWithNoRevenueRealization"

  @OpportunitiesNonDependent @VerifyOppStageWithNoRevenueRealization @GCRM-19624
  Scenario Outline:Verify profile user change the stage an Opportunity having Opportunity Contact ,Targeted Product, Decision Dynamic but no value in Revenue Realization

    Given Runmode for "VerifyOppStageWithNoRevenueRealization" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHE_Business_Operations>"
    Then I navigate to opportunity tab
    And  Verify Opportunity stage having no value in revenue realization
      |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001GNKevAAH/view|

    Examples:
      |MHE_Business_Operations|
      |Nisha_Bansal|
