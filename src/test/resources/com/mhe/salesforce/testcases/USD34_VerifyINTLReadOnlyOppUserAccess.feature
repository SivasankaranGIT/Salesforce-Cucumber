#STAND_ALONE_SCRIPT - This script can be executed separately.
#select id from Opportunity where Is_INTL_Record__c = true and RecordType.Name = 'Read Only' 
Feature: Verify that the users with the profile other than MHE System Administrator, MHE_Business_Operations should NOT able to change the Stage, Close Date/Decision Date on the closed INTL opportunity with record type = Read Only.

  Background:
    Given I am logged into salesforce for "VerifyINTLReadOnlyOppUserAccess"

  @OpportunitiesNonDependent @VerifyINTLReadOnlyOppUserAccess @GCRM-15712 @GCRM-15708
  Scenario Outline: Verify that the users with the profile other than MHE System Administrator, MHE_Business_Operations should NOT able to change the Stage, Close Date/Decision Date on the closed INTL opportunity with record type = Read Only.
  Given Runmode for "VerifyINTLReadOnlyOppUserAccess" is Y
  Then I do login as "<Sales_Rep_Lightning>"
  Then I change the app launcher to "<MHEI>"
  Then verify the INTL Read Only record type opp user permission denial
  Then I logout of any user
  #Verify that the users with the profile MHE System Administrator, MHE_Business_Operations are able to change the Stage, Close Date/Decision Date on the closed INTL opportunity with record type = Read Only.
  Then I do login as "<Nisha_Bansal>"
  Then I change the app launcher to "<MHEI>"
  Then verify the INTL Read Only record type opp user permission approval
  Examples:
  |MHEI|Sales_Rep_Lightning|Nisha_Bansal|
  |MHEI|Karen_Yu|Nisha_Bansal|