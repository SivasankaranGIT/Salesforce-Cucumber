#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL)Feature: Verify Validation rule is triggered when opp field Product Solution is blank and stage is WON
Feature: Verify Validation rule is triggered when opp field Revenue Realisation and Decision Dynamic is blank and stage is RESOLVE

  Background:
    Given I am logged into salesforce for "VerifyValidationRuleIsTriggeredForOpp"

  @OpportunitiesDependent @VerifyValidationRuleIsTriggeredForOpp @GCRM-17159
  Scenario Outline: Verify Validation rule is triggered when opp field Revenue Realisation and Decision Dynamic is blank and stage is RESOLVE

    Given Runmode for "VerifyValidationRuleIsTriggeredForOpp" is Y
#    Then I login as <UserURL>
    Then I do login as "<Sales_Rep_Lightning>"
    Then navigate to an exiting opportunity
    Then Make the field as blank and edit stage
#      |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DY000002QG0eYAG/view|
    Then Verify the triggered error
    Then update the decision dynamic and revenue realisation
    #Then Verify the triggered error
    #Then update the revenue realisation
    Then verify the error is not triggered

    Examples:
      |Sales_Rep_Lightning|
      |Nick_Achelles|