#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Validation rule is triggered when opp field Targeted Product is blank and stage is Evaluate

Background:
  Given I am logged into salesforce for "VerifyValidationRuleTriggeredForOpportunity"

  @OpportunitiesNonDependent @VerifyValidationRuleTriggeredForOpportunity @GCRM-17156
  Scenario Outline:Verify Validation rule is triggered when opp field Targeted Product is blank and stage is Evaluate

    Given Runmode for "VerifyValidationRuleTriggeredForOpportunity" is Y
#    Then I login as <UserURL>
    Then I do login as "<Sales_Rep_Lightning>"
    Then I navigate to opportunity tab
    Then I Open any Opportunity having stage as Recognize
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001Mp46HAAR/view|
    And  Verify Error message is not triggered

    Examples:
    |Sales_Rep_Lightning|
    |Nick_Achelles|