#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify specified fields and fields that are required when closing case

  Background: 
    Given I am logged into salesforce for "VerifyFieldsAndCloseCase"

  @Cases @GCRM-6807 @GCRM-6763 @GCRM-6762 @GCRM-6761 @VerifyFieldsAndCloseCase
  
  Scenario Outline: Verify specified fields and fields that are required when closing case

    Given Runmode for "VerifyFieldsAndCloseCase" is Y
#    Then I login as CXG User
	  Then I do login as "<CXG_Administrator>"
	  And  I change the app launcher to <app_Name>
	  When I search for CXG User contacts
	  Then global search for contact
	  Then click on New case by selecting one contact
		And fill all mandatory details to create CXG case
	  Then click on close case button after filling all the required details
	  And will verify the fields of the closed case
	  Then verify the status of closed case

	  Examples:
		  |app_Name|CXG_Administrator|
		  |"CXG Lightning Console"|Eric_Nelson|
