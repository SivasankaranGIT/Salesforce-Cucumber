#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHEVerifyContact
Background:
  Given I am logged into salesforce for "MHEEditContactTest"

	@Contacts
  @MHEEVerifyContact @GCRM-9293
  Scenario Outline: Verify contact
    Given Runmode for "MHEEditContactTest" is Y
#    Then I login as Sales Rep
      Then I do login as "<System_Administrator>"
    Then global search for contact
    And I edit details 
	  And I click on "save"
    Then Verify error message

      Examples:
      |System_Administrator|
      |Sivasankaran_Periyasamy|