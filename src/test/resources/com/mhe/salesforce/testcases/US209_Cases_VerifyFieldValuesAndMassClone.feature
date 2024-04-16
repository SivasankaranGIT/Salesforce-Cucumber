#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the created case has sub incident values and Fields Request Reason 2, Sub Reason 2, Action 2, Internal Description 2 fields are added to the Mass Case Close Screen


  Background: 
    Given I am logged into salesforce for "VerifyFieldValuesAndMassClone"

  @Cases @GCRM-6005 @GCRM-5999 @GCRM-6086 @VerifyFieldValuesAndMassClone  
  Scenario Outline: Verify the created case has sub incident values and Mass Case Close Screen

    Given Runmode for "VerifyFieldValuesAndMassClone" is Y
    Then I do login as "<ALEKS_Administrator>"
    And  I change the app launcher to <app_Name>
	  And I navigate to cases page 
	  And fill all mandatory details to create new case and verify field values
	  Then I will verify the mass case close screen

  Examples:
    |app_Name|ALEKS_Administrator|
    |"ALEKS Lightning Console"|Isaac_Rubio|