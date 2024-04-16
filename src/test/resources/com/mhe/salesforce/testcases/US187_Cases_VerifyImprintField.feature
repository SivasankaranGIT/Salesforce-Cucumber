#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Imprint field

  Background: 
    Given I am logged into salesforce for "VerifyImprintField"

  @Cases @GCRM-6074 @TC187_US_Cases_VerifyImprintField @GCRM-6074
  Scenario Outline: VerifyImprintField
    Given Runmode for "VerifyImprintField" is Y
#    Then I login as Sales Rep
    Then I do login as "<CXG_Administrator>"
    And  I change the app launcher to <app_Name>
    When I navigate to cases
	  And choose first case
	  Then verify the Imprint Field

    Examples:
      |app_Name|CXG_Administrator|
      |"CXG Lightning Console"|Eric_Nelson|

