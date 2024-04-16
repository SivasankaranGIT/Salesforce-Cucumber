#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate that the new fields 'Customer_Success_Consultant__c' is present on the Opportunity record is blank.

Background:
  Given I am logged into salesforce for "ValidateTheNewFieldIsPresentOnTheOpportunity"

@OpportunitiesNonDependent @ValidateTheNewFieldIsPresentOnTheOpportunity @GCRM-18420
Scenario Outline: Validate that the new fields 'Customer_Success_Consultant__c' is present on the Opportunity record is blank.

  Given Runmode for "ValidateTheNewFieldIsPresentOnTheOpportunity" is Y
#  Then I login as <UserURL>
  Then I do login as "<MHHE_Business_Administrator>"
  And Verify the customer success consultant field
  |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001NzdhaAAB/view|

  Examples:
    |MHHE_Business_Administrator|
    |Jaime_Klar|