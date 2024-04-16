#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify MHE Product Case field is editable for Digital Sales Support users

  Background:
  Given I am logged into salesforce for "VerifyMHEProductFieldIsEditableForDigitalSalesSupport"
  @Cases @VerifyMHEProductFieldIsEditableForDigitalSalesSupport  @GCRM-17144 @GCRM-26853
  Scenario Outline: Verify MHE Product Case field is editable for Digital Sales Support users

    Given Runmode for "VerifyMHEProductFieldIsEditableForDigitalSalesSupport" is Y
    Then I do login as "<Digital Sales Support>"
    Then I navigate to cases
    When I create a case for digital sales support
    Then I verify MHE product field is editable
		And close the digital sales support case
    Examples:
      |Digital Sales Support|
      |Meghan_Clark|