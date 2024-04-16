#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify new opportunity lookup field MHES Sales Opportunity is found in the case record page

  Background:
    Given I am logged into salesforce for "VerifyNewOppLookupField"

  @Cases @VerifyNewOppLookupField @GCRM-17419
  Scenario Outline: Verify new opportunity lookup field MHES Sales Opportunity is found in the case record page
    Given Runmode for "VerifyNewOppLookupField" is Y
    Then I do login as "<SEG_Sales_Operations>"
    Then I navigate to cases
    Then I create a new case
    Then validate the opportunity field and edit it

    Examples:
      |SEG_Sales_Operations|
      |Stefanie_Vogel|