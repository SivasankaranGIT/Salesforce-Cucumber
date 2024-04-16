#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: As MHHE Sales Support, maintain Case records through NSS view and modify existing cases.

  Background: 
    Given I am logged into salesforce for "MHHEModifyNSSCase"

  @Cases @MHHEModifyNSSCase @GCRM-9231
  Scenario Outline: MHHEModifyNSSCase
    Given Runmode for "MHHEModifyNSSCase" is Y
#    Then I login as Sales Rep
    Then I do login as "<MHHE_Sales_Support>"
    And  I change the app launcher to <app_Name>
    When I navigate to cases tab
    And choose NSS list view
    Then select case from results
    And edit existing case details
    Then verify edited case details

    Examples:
      |app_Name|MHHE_Sales_Support|
      |"MHHE"|Jennifer_Bahl|
