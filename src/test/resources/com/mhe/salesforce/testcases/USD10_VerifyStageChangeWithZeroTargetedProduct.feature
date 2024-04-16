#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify profile user are able to change the stage for an Opportunity with 0 Targeted product but have Opportunity Contact

  Background:
    Given I am logged into salesforce for "VerifyStageChangeWithZeroTargetProduct"

  @OpportunitiesNonDependent @VerifyStageChangeWithZeroTargetProduct @GCRM-19621
  Scenario Outline:Verify profile user are able to change the stage for an Opportunity with 0 Targeted product but have Opportunity Contact

    Given Runmode for "VerifyStageChangeWithZeroTargetProduct" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHE_Business_Operations>"
    Then I navigate to opportunity tab
    And  I edit Opportunity stage with at least one contact
      |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001QziyKAAR/view|
    Examples:
      |MHE_Business_Operations|
      |Nisha_Bansal|
