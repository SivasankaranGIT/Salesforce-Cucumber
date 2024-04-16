#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify omni channel status

  Background: 
    Given I am logged into salesforce for "VerifyOmniChannelStatus"

  @Cases @GCRM-4866 @TC186_US_Cases_VerifyOmniChannelStatus @GCRM-4866
  Scenario Outline: VerifyCSOMCaseHistoryTab
    Given Runmode for "VerifyOmniChannelStatus" is Y
#    Then I login as Sales Rep
    Then I do login as "<CXG_Administrator>"
    And  I change the app launcher to <app_Name>
    And verify the omni channel status
    Then I logout of any user
#    And I login as ALEKS user
    And I do login as "<ALEKS_Administrator>"
    Then verify the different omni channel status

    Examples:
      |app_Name|CXG_Administrator|ALEKS_Administrator|
      |"CXG Lightning Console"|Eric_Nelson|Isaac_Rubio|