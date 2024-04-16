#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the "Incident & Sub-Incident" fields are non-editable and they are systematically populated based on the Reason field on the ALEKS case

  Background:
  Given I am logged into salesforce for "VerifyCaseCreationFieldsForALEKSProfile"
  @Cases @VerifyCaseCreationFieldsForALEKSProfile  @GCRM-17746
  Scenario Outline: Verify that the "Incident & Sub-Incident" fields are non-editable and they are systematically populated based on the Reason field on the ALEKS case

  Given Runmode for "VerifyCaseCreationFieldsForALEKSProfile" is Y
  Then I do login as "<ALEKS Administrator>"
  When I navigate to contacts page
  Then I create a case for the contact
  Then verify case fields are auto populated

  Examples:
  |ALEKS Administrator|
  |Isaac_Rubio|

  #Created By:Ramkaran Singh
  @Cases @VerifyCaseFromGlobalSearch  @GCRM-16467
  Scenario Outline: verify users can see cases
  Given Runmode for "VerifyCaseFromGlobalSearch" is Y
  Then I do login as "<CSOM Product Support>"
  When I navigate to cases
  Then open MHSE SO PIC list view

  Examples:
  |CSOM Product Support|
  |Cristen_Anglin|


  # Created By : Ramkaran Singh
  @Cases @VerifyJIRAInitialAssigneeForCase @GCRM-16479 @GCRM-16431 @GCRM-16985 @GCRM-16415
  Scenario Outline: VerifyJIRAInitialAssigneeForCase
  Given Runmode for "VerifyJIRAInitialAssigneeForCase" is Y
  Then I do login as "<CXG_Administrator>"
  Then I navigate to cases
  Then I create a new case for CXG Lightning Console
  And verify Discipline LOV
  Then verify Jira Initial Assignee
  Examples:
  |CXG_Administrator|
  |Eric_Nelson|

  # Created By : Ramkaran Singh
  @Cases @VerifyActionAndMatrixChanges @GCRM-16542
  Scenario Outline: Verify action and matrix changes on CSOM cases
  Given Runmode for "VerifyActionAndMatrixChanges" is Y
  Then I do login as "<CSOM_Administrator>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then I navigate to cases
  Then create a case for CSOM support
  Then verify picklist value in Action dropdown for ID1
  Then verify picklist value in Action dropdown for ID2
  Then I navigate to cases
  Then create a case for CSOM support
  Then verify the order stage

  Examples:
  |CSOM_Administrator|CSOM_Lightning_Console|
  |Jennifer_Ryan|CSOM Lightning Console|


  # Created By : Ramkaran Singh
  @Cases @VerifyActionAndTaskFields @GCRM-16545 @GCRM-16893 @GCRM-16483 @GCRM-23483
  Scenario Outline: Verify Action and Task fields auto populate
	  Given Runmode for "VerifyActionAndTaskFields" is Y
	  Then I do login as "<CSOM_Administrator>"
	  Then I change the app launcher to "<CSOM_Lightning_Console>"
	  Then I navigate to cases
	  Then create a case for CSOM support
	  Then I edit the newly created case 1
	  Then I navigate to cases
	  Then create a case for CSOM support
	  Then I edit the newly created case 2
	  Then Click on mass case closure button

  Examples:
	  |CSOM_Administrator|CSOM_Lightning_Console|
	  |Jennifer_Ryan|CSOM Lightning Console|
  
  # Created By : Siva
  @Cases @VerifyContactStatusUpdateValidation @GCRM-17043
  Scenario Outline: Verify the error You cannot change contact status to Active or None when contact type is Student or Asset Author is not fired when the case status is updated by CXG Administrator, CXG Admin Operations user and Aleks Admin user 
  Given Runmode for "VerifyContactStatusUpdateValidation" is Y
  Then I do login as "<Users>"
#	When I navigate to contacts page
	And verify if the contact status validation fired or not
  Examples:
  |Users|
  |Eric_Nelson|
  |Vern_Thorson|
  #|Isaac_Rubio|
  #|James_Galvez|
  #|Jennifer_Ryan|
