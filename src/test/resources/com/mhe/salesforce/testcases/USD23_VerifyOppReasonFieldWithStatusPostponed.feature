#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify MHES Opportunity's Reason Field when the Status is set as "Postponed"

  Background:
    Given I am logged into salesforce for "VerifyOppReasonFieldWithStatusPostponed"
    @OpportunitiesNonDependent
    @VerifyOppReasonFieldWithStatusPostponed
    @GCRM-15905

  Scenario Outline: Verify MHES Opportunity's Reason Field when the Status is set as "Postponed"

    Given Runmode for "VerifyOppReasonFieldWithStatusPostponed" is Y
    Then I do login as "<SEG_Business_Admin>"
    Then I navigate to opportunity tab
    Then navigate to an exiting opportunity
    And verify reason field has Extending review option for postponed Opp
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001SiDNMAA3/view|

    Examples:
      |SEG_Business_Admin|
      |Ivan_Gomez|

