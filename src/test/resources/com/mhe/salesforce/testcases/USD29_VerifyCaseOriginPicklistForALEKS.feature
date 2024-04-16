#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Case Origin Picklist Values For ALEKS Profile

  Background:
    Given I am logged into salesforce for "VerifyCaseOriginPicklistForALEKS"

  @Cases @VerifyCaseOriginPicklistForALEKS @GCRM-16406
  Scenario Outline: Verify Case Origin Picklist Values For ALEKS Profile
  Given Runmode for "VerifyCaseOriginPicklistForALEKS" is Y
  Then I do login as "<ALEKS_Administrator>"
  Then I change the app launcher to "<ALEKS_Lightning_Console>"
  Then I navigate to cases
  Then I create a new case for ALEKS
  Then verify the case origin field


  Examples:
  |ALEKS_Administrator|ALEKS_Lightning_Console|
  |Isaac_Rubio|ALEKS Lightning Console|
  
