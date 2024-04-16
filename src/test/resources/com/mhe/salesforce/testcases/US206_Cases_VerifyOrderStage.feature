#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Template updated in Internal Description 1/2 based on Reason, Action for Order Stage Pre-Order

  Background: 
    Given I am logged into salesforce for "VerifyOrderStage"

  @Cases @GCRM-5056 @GCRM-4659 @VerifyOrderStage
  
  Scenario Outline: VerifyOrderStage
  
    Given Runmode for "VerifyOrderStage" is Y
#    Then I login as Sales Rep
    Then I do login as "<CSOM_General_User>"
    And  I change the app launcher to <app_Name>
    #Then I navigate to CSOM Lightning Console Home page
    Then click on New case by selecting one contact
    Then select record type as CSOM Support
    And fill all mandatory details to create CSOM case
    Then close the CSOM case
    And verify the status of closed case in internal description tab
    Then verify the internal description order stage

    Examples:
      |app_Name|CSOM_General_User|
      |"CSOM Lightning Console"|Lisa_Phelps|