#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Contact
Background:
  Given I am logged into salesforce for "VerifyContactTest"

	@Contacts
  @verifycontact @GCRM-9097
  Scenario Outline: Verify contact
    Given Runmode for "VerifyContactTest" is Y
#    Then I login as Admin User
      Then I do login as "<System_Administrator>"
    And I switch from CXG Lightining Console App to Sales App
    When I click on the "contactsTab"
    And I enter mandatory fields and save

      Examples:
      |System_Administrator|
      |Sivasankaran_Periyasamy|