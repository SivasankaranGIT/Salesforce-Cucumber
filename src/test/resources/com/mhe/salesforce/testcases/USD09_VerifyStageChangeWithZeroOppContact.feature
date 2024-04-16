#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify all profile users are able to update stage in an Opportunity with 0 Opportunity Contact

  Background:
    Given I am logged into salesforce for "VerifyStageChangeWithZeroOppContact"

  @OpportunitiesNonDependent @VerifyStageChangeWithZeroOppContact @GCRM-19619
  Scenario Outline:Verify all profile users are able to update stage in an Opportunity with 0 Opportunity Contact

    Given Runmode for "VerifyStageChangeWithZeroOppContact" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHE_Business_Operations>"
    Then I navigate to opportunity tab
    And  I edit Opportunity stage
     |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001GNKeuAAH/view|

    Examples:
      |MHE_Business_Operations|
      |Nisha_Bansal|
