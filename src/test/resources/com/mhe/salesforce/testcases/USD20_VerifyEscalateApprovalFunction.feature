#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Escalate Approval Button Functionality

  Background:
    Given I am logged into salesforce for "VerifyEscalateApprovalFunction"
    
  @OpportunitiesNonDependent @VerifyEscalateApprovalFunction @GCRM-16900
  Scenario Outline: Verify the Escalate Approval Button Functionality

    Given Runmode for "VerifyEscalateApprovalFunction" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHHE_Enterprise_Service>"
    Then I navigate to opportunity tab
    Then I create a new opportunity of MHHE record type
    Then I verify escalate approval button function for Opp record

    Examples:
    |MHHE_Enterprise_Service|
    |Tracy_Bear|