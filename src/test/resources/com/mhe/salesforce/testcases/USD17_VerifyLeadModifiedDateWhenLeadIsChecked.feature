#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify date field functionality on Opportunity Contact

  Background:
    Given I am logged into salesforce for "VerifyLeadModifiedDateWhenLeadIsChecked"
    
  @OpportunitiesNonDependent @VerifyLeadModifiedDateWhenLeadIsChecked @GCRM-16589
  Scenario Outline: Verify date field functionality on Opportunity Contact

    Given Runmode for "VerifyLeadModifiedDateWhenLeadIsChecked" is Y
    Then I do login as "<MHHE_Business_Administrator>"
    #Then I navigate to opportunity tab
    And verify Opportunity contact lead date is changed to today date when lead is checked
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001IPi7LAAT/view|
    Then verify contact lead date is blank when lead date is not checked
  Examples:
    |MHHE_Business_Administrator|
    |Jaime_Klar|