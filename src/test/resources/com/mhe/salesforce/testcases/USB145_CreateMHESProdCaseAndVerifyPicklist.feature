#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify new dependent values of MHES Product on parent field MHES Market Segment for Case object

  Background:
    Given I am logged into salesforce for "VerifyPicklistInMHESProductTypeCase"

  @Cases @VerifyPicklistInMHESProductTypeCase @GCRM-19802
  Scenario Outline: Verify new dependent values of MHES Product on parent field MHES Market Segment for Case object
    Given Runmode for "VerifyPicklistInMHESProductTypeCase" is Y
    Then I do login as "<SEG_Business_Admin>"
    And  I change the app launcher to <app_Name>
    Then I navigate to cases
    And I create a new case for MHES Sales Opertation record type
		And validate the MHES Product picklist values
		|Platform|McGraw Hill Plus|McGraw Hill AR|Science|Science K-5|Science 6-8|Science 9-12|Humanities|Social Studies K-5|Social Studies 6-8|Social Studies 9-12|Other|Actively Learn|Smarty Ants|
		Then navigate to NON MHES Product type case
		And validate the MHES Product fields
    Examples:
      |SEG_Business_Admin|app_Name|
      |Ivan_Gomez|"Sales"|
      
  @Cases @VerifyPicklistInNONMHESProductTypeCase @GCRM-19803
  Scenario: Verify new dependent values of MHES Product on parent field MHES Market Segment for Case object
    Given Runmode for "VerifyPicklistInNONMHESProductTypeCase" is Y
		Then navigate to NON MHES Product type case
		And validate the MHES Product fields


  @Cases @VerifyCallTypeOptionInCases @GCRM-16540
  Scenario Outline: Verify value is available for call type
    Given Runmode for "VerifyCallTypeOptionInCases" is Y
    Then I do login as "<SEG_Business_Admin>"
    And  I change the app launcher to <app_Name>
    Then I navigate to cases
    And I create a new case for MHES Sales Opertation record type

    Examples:
    |SEG_Business_Admin|app_Name|
    |Ivan_Gomez|"Sales"|

  @Cases @VerifyCallTypeOption @GCRM-16567
  Scenario Outline: Verify value is available for call type
    Given Runmode for "VerifyCallTypeOption" is Y
    Then I do login as "<SEG_Business_Admin>"
    And  I change the app launcher to <app_Name>
    Then I navigate to cases
    And I create a new case for MHES Sales Opertation record type

    Examples:
    |SEG_Business_Admin|app_Name|
    |Ivan_Gomez|"Sales"|

  @Cases @VerifyAccountDistrictInformation @GCRM-27097
  Scenario Outline: Verify that Account district information is displayed when user searches for account name on case page
    Given Runmode for "VerifyAccountDistrictInformation" is Y
    Then I do login as "<A3K_Customer_Support>"
    Then I navigate to cases
    Then I create a new case for A3K customer support
    And verify the district from account name dropdown

    Examples:
    |A3K_Customer_Support|
    |Steve_Loori|


  @Cases @VerifyTelePerformanceUserInNotEditable @GCRM-27089
  Scenario Outline: Verify Teleperformance Reporting user is having read only access on Case records
    Given Runmode for "VerifyTelePerformanceUserInNotEditable" is Y
    Then I do login as classic "<Teleperformance_Reporting>"
    And switch to classic user interface
    Then I go to cases in classic mode and verify

    Examples:
    |Teleperformance_Reporting|
    |Teleperformance_Reporting|





