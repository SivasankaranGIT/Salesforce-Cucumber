#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate when the case record is updated record type: MHHE_Product_Support, product value not in ('ALEKS', ‘CHBA') AND 'MHE Product’ value is blank, change the category value then the validation rule should fire

  Background:
    Given I am logged into salesforce for "VerifyMHEProductValidationErrorForCase"

  @Cases @VerifyMHEProductValidationErrorForCase @GCRM-19977 @GCRM-19978 @GCRM-17026
  Scenario Outline: Validate when the case record is updated record type: MHHE_Product_Support, product value not in ('ALEKS', ‘CHBA') AND 'MHE Product’ value is blank, change the category value then the validation rule should fire
    Given Runmode for "VerifyMHEProductValidationErrorForCase" is Y
    Then I do login as "<CXG_Administrator>"
    Then I navigate to cases
    Then create a new case for MHHE Product Support
    Then validate error message for MHE product
    Then I enter mandatory details and close the case

  Examples:
    |CXG_Administrator|
    |Eric_Nelson|