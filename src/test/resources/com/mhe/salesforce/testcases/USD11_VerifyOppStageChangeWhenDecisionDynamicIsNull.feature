#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify profile users are able to change stage an Opportunity having Opportunity Contact and Targeted Product but no value in Decision Dynamic

  Background:
    Given I am logged into salesforce for "VerifyOppStageChangeWhenDecisionDynamicIsNull"

  @OpportunitiesNonDependent @VerifyOppStageChangeWhenDecisionDynamicIsNull @GCRM-19623
  Scenario Outline:Verify profile users are able to change stage an Opportunity having Opportunity Contact and Targeted Product but no value in Decision Dynamic

    Given Runmode for "VerifyOppStageChangeWhenDecisionDynamicIsNull" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHE_Business_Operations>"
    Then I navigate to opportunity tab
    And  I edit Opportunity stage for null decision dynamic
      |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001GNKewAAH/view|

    Examples:
      |MHE_Business_Operations|
      |Nisha_Bansal|
