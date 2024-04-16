#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Knowledge Transfer field is visible and Editable for the given MHHE profiles in Opportunity Comments section

Background:
  Given I am logged into salesforce for "MHHESalesRepVerifyKnowledgeTransferFieldIsVisibleAndEditable"

@OpportunitiesNonDependent @MHHESalesRepVerifyKnowledgeTransferFieldIsVisibleAndEditable @GCRM-17393
Scenario Outline: Verify the Knowledge Transfer field is visible and Editable for the given MHHE profiles in Opportunity Comments section

  Given Runmode for "MHHESalesRepVerifyKnowledgeTransferFieldIsVisibleAndEditable" is Y
  Then I do login as "<UserURL>"
  And I change the app launcher to MHHE
  Then I navigate to opportunity tab
  Then verify the knowledge transfer field
  Then I logout of any user

  Examples:
    |UserURL|
    |Jaime_Klar|
    |Cassie_Cannon|
    |Jennifer_Bahl|
    |Tina_Altman|
    |Jennifer_Bahl|