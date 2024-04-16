#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify stage changing with inactive contact for an opportunity other than INTL users

  Background:
    Given I am logged into salesforce for "VerifyNoValidationErrorForUserOtherThanINTLUser"
  @OpportunitiesNonDependent
  @VerifyNoValidationErrorForUserOtherThanINTLUser
  @GCRM-19610

 Scenario Outline: Verify stage changing with inactive contact for an opportunity other than INTL users

    Given Runmode for "VerifyNoValidationErrorForUserOtherThanINTLUser" is Y
#    Then I login as <UserURL>
    Then I do login as "<System_Administrator>"
    Then I navigate to opportunity tab
    And verify opp stage changed having inactive opp contact with no validation error
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001GNzBDAA1/view|

    Examples:
    |System_Administrator|
    |Sivasankaran_Periyasamy|

