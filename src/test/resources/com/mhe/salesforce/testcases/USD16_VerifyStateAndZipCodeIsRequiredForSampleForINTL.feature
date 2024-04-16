#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify state and postal code are required on Sample requests

  Background:
    Given I am logged into salesforce for "VerifyStateAndZipCodeIsRequiredForSampleForINTL"

  @Contacts
  @VerifyStateAndZipCodeIsRequiredForSampleForINTL
  @GCRM-16720
  Scenario Outline: Verify state and postal code are required on Sample requests

    Given Runmode for "VerifyStateAndZipCodeIsRequiredForSampleForINTL" is Y
#    Then I login as <INTL User>
    Then I do login as "<MHE_Business_Operations>"
    And I navigate to the Contact page and add INTL sample to contact
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002ZjrEmAAJ/view|
    Then verify validation error of State and postal code for new address of sample
    And I verify sample created with new address

    Examples:
    |MHE_Business_Operations|
    |Nisha_Bansal|


