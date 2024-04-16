#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify when the Opportunity created, the sales team fields should be updated from National Sales SEM user's corresponding fields

  Background:
    Given I am logged into salesforce for "VerifySalesTeamFieldFromOppOwner"

  @OpportunitiesNonDependent @VerifySalesTeamFieldFromOppOwner @GCRM-15447 @GCRM-22477
  Scenario Outline: Verify when the Opportunity created, the sales team fields should be updated from National Sales SEM user's corresponding fields

    Given Runmode for "VerifySalesTeamFieldFromOppOwner" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHHE_National_Sales_Manager>"
    Then navigate to account tab
    And I edit account detail
    |https://mh--uat.sandbox.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent|
    #And I navigate to opportunity tab
    Then Verify Opportunity sales team value is matching with Opp Owners profile value

    Examples:
      |MHHE_National_Sales_Manager|
      |Cassie_Cannon|
