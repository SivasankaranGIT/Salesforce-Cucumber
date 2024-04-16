#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: US Profile Validation

  Background:
    Given I am logged into salesforce for "USProfileValidation"

	@UserMaintainance
	@Profiles
  @USProfileValidation @GCRM-9228
  Scenario: US Profile Validation
    Given Runmode for "USProfileValidation" is Y
    Then I logout of any user
    And I Click edit User
    Then I Validate the user role
    Then I Click on Cancel User
