#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Change Case Owner to appropriate queue

  Background: 
    Given I am logged into salesforce for "VerifyOwnerChange"

  @Cases @GCRM-4835 @GCRM-4839 @VerifyOwnerChange
  
  Scenario Outline: Verify Change Case Owner to appropriate queue
  
    Given Runmode for "VerifyOwnerChange" is Y
#    Then I login as Sales Rep
    Then I do login as "<MHHE_Sales_Support>"
    And  I change the app launcher to <app_Name>
    When I navigate to cases tab
    And create the new case by entering the required fields
    Then change the owner of the case
    And check the field details
    Then verify the change owner to appropriate queue

    Examples:
      |app_Name|MHHE_Sales_Support|
      |"MHHE"|Jennifer_Bahl|
