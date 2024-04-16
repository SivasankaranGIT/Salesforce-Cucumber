#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify validation error while changing status with inactive contacts and active contact on an opportunity

  Background:
    Given I am logged into salesforce for "VerifyValidationErrorWithINTLUser"

  @OpportunitiesNonDependentNA @VerifyValidationErrorWithINTLUser @GCRM-19602 @GCRM-19599 @GCRM-19600 @GCRM-15966 @GCRM-15965 @GCRM-16361 @GCRM-16363 @GCRM-16358 @GCRM-16365
  Scenario Outline: Verify validation error while changing status with inactive contacts and active contact on an opportunity

    Given Runmode for "VerifyValidationErrorWithINTLUser" is Y
#    Then I login as <UserURL>
    Then I do login as "<Sales_Rep_Lightning>"
    When I navigate to contacts page
    And create new contact
    Then I navigate to opportunity tab
    Then create a new opportunity
    And I Add contact <LastName> from opportunity page
    And Verify  error is not triggered for Opp Stage Change When Opp Contact is Active
    And deactivate the opportunity contact
    Then I navigate to opportunity tab and verify validation error even if one contact is inactive

    Examples:
      |LastName|Sales_Rep_Lightning|
      |"zaman"|Nick_Achelles|