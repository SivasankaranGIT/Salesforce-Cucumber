#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify date field functionality on Opportunity

  Background:
    Given I am logged into salesforce for "VerifyLeadDateOnOpportunityRecord"
    @OpportunitiesNonDependent
    @VerifyLeadDateOnOpportunityRecord
    @GCRM-16593

  Scenario Outline: Verify date field functionality on Opportunity

    Given Runmode for "VerifyLeadDateOnOpportunityRecord" is Y
    Then I do login as "<MHHE_Business_Administrator>"
    Then I navigate to opportunity tab
    Then I navigate to the first opp in the page
    And verify Lead Nomination Submission date is today date
    Then verify lead nomination is blank when nominate lead is not checked

    Examples:
      |MHHE_Business_Administrator|
      |Jaime_Klar|