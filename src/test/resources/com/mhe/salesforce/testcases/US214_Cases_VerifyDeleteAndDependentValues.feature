#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify users can delete and Verify the LOVs and Dependencies of the Category

  Background: 
    Given I am logged into salesforce for "VerifyDeleteAndDependentValues"

  @Cases @GCRM-7222 @GCRM-7220 @VerifyDeleteAndDependentValues  
  Scenario Outline: Verify users can delete and Verify the LOVs and Dependencies of the Category
    Given Runmode for "VerifyDeleteAndDependentValues" is Y
#    Then I login as Sales Rep
    Then I do login as "<CXG_Administrator>"
    And  I change the app launcher to <app_Name>
    And verify user can delete the access
    Then I logout of any user
#    And I login as ALEKS user
    Then I do login as "<ALEKS Administrator>"
    Then verify the dependencies of the category
    Examples:
      |app_Name|CXG_Administrator|ALEKS Administrator|
      |"CXG Lightning Console"|Eric_Nelson|Isaac_Rubio|