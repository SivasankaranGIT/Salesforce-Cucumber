#STAND_ALONE_SCRIPT - This script can be executed separately.
#select id from Case where SOURCE_CASENUMBER__c != null limit 10
Feature: Verify the INTL CaseNumber field is not present and replaced by Source CaseNumber field

  Background:
    Given I am logged into salesforce for "INTLCaseNoFieldReplacedBySourceCaseNo"

  @Cases @INTLCaseNoFieldReplacedBySourceCaseNo @GCRM-25796
  Scenario Outline: Verify the INTL CaseNumber field is not present and replaced by Source CaseNumber field
  Given Runmode for "INTLCaseNoFieldReplacedBySourceCaseNo" is Y
  Then I logout of any user
  Then I change the app launcher to "<CXG_Lightning_Console>"
  Then verify the Case Number field change
  Examples:
  |CXG_Lightning_Console|
  |CXG Lightning Console|
  
  @Cases @VerifyMHHESupportCaseUserAccessability @GCRM-16567 @GCRM-16571
  Scenario Outline: Verify user in MMHE_View_All role can view cases & Verify user not in MMHE_View_All role cannot view cases
  Given Runmode for "VerifyMHHESupportCaseUserAccessability" is Y
	Then I do login as "<MHHE_Marketing>"
  Then I change the app launcher to "<App_Name>"
  Then verify user in MMHE_View_All role can view MHHE Support case
  Then I logout of any user
  Then I do login as "<MHHE_Sales_Representative>"
  Then verify user not in MMHE_View_All role can not view MHHE Support case
  Examples:
  |App_Name|MHHE_Marketing|MHHE_Sales_Representative|
  |MHHE|Kara_Allara|Danielle_Snyder|
  
  @Cases @VerifyMHHEIGSSegmentFieldUserAccessability @GCRM-19350 @GCRM-19348
  Scenario Outline: Verify MHHE_Marketing, MHHE_Sales_Manager and MHHE_Sales_Representative users are having only view access to field
  Given Runmode for "VerifyMHHEIGSSegmentFieldUserAccessability" is Y
	Then I do login as "<Users>"
  Then I change the app launcher to "<App_Name>"
  When I navigate to contacts page
  And verify user is having only read only access to MHHE IGS Segment field
  Examples:
  |App_Name|Users|
  |MHHE|Kara_Allara|
  |MHHE|Danielle_Snyder|
  |MHHE|James_Heine|
  
  @Cases @VerifyMHHEIGSSegmentFieldCharLimit @GCRM-19351
  Scenario Outline: Verify character limit for MHHE_IGS_Segment field is restricted to 50
  Given Runmode for "VerifyMHHEIGSSegmentFieldCharLimit" is Y
  Then I logout of any user
  Then I change the app launcher to "<App_Name>"
  And verify character limit for MHHE_IGS_Segment field is restricted to 50
  Examples:
  |App_Name|
  |MHHE|
  
  @Cases @VerifyCaseVisibilityInVariousLocations @GCRM-17091 @GCRM-9230
  Scenario Outline: As MHHE Sales Support, verify Case visibility in various locations throughout Salesforce.
  Given Runmode for "VerifyCaseVisibilityInVariousLocations" is Y
  Then I do login as "<MHHE_Sales_Support>"
  Then I change the app launcher to "<App_Name>"
  And verify case visibility through Contact
  And verify case visibility through Opportunity
  Examples:
  |App_Name|MHHE_Sales_Support|
  |MHHE|Jennifer_Bahl|