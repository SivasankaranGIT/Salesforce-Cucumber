#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Confirm the 2 date fields are not included in opp cloning

  Background:
    Given I am logged into salesforce for "VerifyLeadDateIsNotClonedWhenOppIsCloned"
    @OpportunitiesNonDependent
    @VerifyLeadDateIsNotClonedWhenOppIsCloned
    @GCRM-16597

  Scenario Outline: Confirm the 2 date fields are not included in opp cloning
    Given Runmode for "VerifyLeadDateIsNotClonedWhenOppIsCloned" is Y
#    Then I login as <UserURL>
      Then I do login as "<MHHE_Business_Administrator>"
    Then I navigate to opportunity tab
    And verify Lead Nomination date
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001NyvAxAAJ/view|
    And verify Opportunity contact lead date is changed to today date when lead is checked
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001NyvAxAAJ/view|
    Then verify lead submission date is blank in cloned Opportunity and Opportunity contact
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001NyvAxAAJ/view|

    Examples:
    |MHHE_Business_Administrator|
    |Jaime_Klar|