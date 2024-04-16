#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify New Field K12 Leadership Escalation is Visible under Jira Tab for SEG Product Support Cases

  Background:
    Given I am logged into salesforce for "VerifyK12FieldForDTSCase"
  @Cases @VerifyK12FieldForDTSCase @GCRM-17622
  Scenario Outline: Verify New Field K12 Leadership Escalation is Visible under Jira Tab for SEG Product Support Cases

    Given Runmode for "VerifyK12FieldForDTSCase" is Y
    Then I do login as "<CSOM_Business_Administrators>"
    And  I change the app launcher to <app_Name>
    Then I navigate to cases
    Then I create a new case for SEG Product Support
    Then verify K12 leadership section on JIRA tab

    Examples:
      |CSOM_Business_Administrators|app_Name|
      |Jennifer_Ryan|"DTS Lightning Console"|
