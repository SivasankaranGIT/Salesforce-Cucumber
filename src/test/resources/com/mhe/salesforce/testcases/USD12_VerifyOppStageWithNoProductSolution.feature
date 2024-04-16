#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify profile users are able to change  stage Opportunity having Opportunity Contact , Targeted Product, Decision Dynamic and Revenue Realization values but no value in Product Solution

  Background:
    Given I am logged into salesforce for "VerifyOppStageWithNoProductSolutionInOpp"

  @OpportunitiesNonDependent @VerifyOppStageWithNoProductSolutionInOpp @GCRM-19626
  Scenario Outline:Verify profile users are able to change  stage Opportunity having Opportunity Contact , Targeted Product, Decision Dynamic and Revenue Realization values but no value in Product Solution

    Given Runmode for "VerifyOppStageWithNoProductSolutionInOpp" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHE_Business_Operations>"
    Then I navigate to opportunity tab
    And  Verify Opportunity Stage with no product solution mentioned
      |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001GNKexAAH/view|

    Examples:
      |MHE_Business_Operations|
      |Nisha_Bansal|
