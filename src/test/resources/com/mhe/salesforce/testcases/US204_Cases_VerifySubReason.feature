#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify sub-reason validation rule

  Background: 
    Given I am logged into salesforce for "VerifySubReason"

  @Cases @GCRM-5433 @VerifySubReason
  
  Scenario Outline: Verify sub-reason validation rule
  
    Given Runmode for "VerifySubReason" is Y
#    Then I login as Sales Rep
    Then I do login as "<CSOM_General_User>"
    And  I change the app launcher to <app_Name>
    #Then I navigate to CSOM Lightning Console Home page
    Then click on New case by selecting one contact 
	  Then select record type as CSOM Support
	  And fill all mandatory details to create CSOM case
	  Then click on close case button
	  And fill mandatory fields to close CSOM Case
	  Then verify the status of closed record

    Examples:
      |app_Name|CSOM_General_User|
      |"CSOM Lightning Console"|Lisa_Phelps|