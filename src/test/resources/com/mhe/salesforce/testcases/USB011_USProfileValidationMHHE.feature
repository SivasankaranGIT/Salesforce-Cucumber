#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: US Profile Validation for MHHE user

  Background:
    Given I am logged into salesforce for "USProfileValidationMHHE"

	@UserMaintainance
	@Profiles
  @USProfileValidationMHHE @GCRM-9249
  Scenario: US Profile Validation for MHHE user
    Given Runmode for "USProfileValidationMHHE" is Y
    Then I logout of any user
    And I Click edit User
    Then I Validate the user role
    Then I Click on Cancel User