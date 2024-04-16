#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the different record types based on who is creating the Task.

  Background:
    Given I am logged into salesforce for "TaskVarifyDiffRecordType"


	@Tasks
  @TaskVarifyDiffRecordType @GCRM-9210
  Scenario Outline: Verify different user with different profile on different record type
    Given Runmode for "TaskVarifyDiffRecordType" is Y
#    Then I login as Sales Rep
      Then I do login as "<System_Administrator>"
    And Navigate to <SEG_Sales_Rep> Task profile
    Then Validate Record type for SEG Task
    And Navigate to MHHE_Sales_Representative Task profile
    Then Validate Record type for MHE Task
		Examples:
    |System_Administrator|SEG_Sales_Rep|
    |Sivasankaran_Periyasamy|"https://mh--uat.sandbox.lightning.force.com/lightning/setup/EnhancedProfiles/page?address=%2F00e800000011a4B%3Fs%3DObjectsAndTabs%26o%3DTask"|