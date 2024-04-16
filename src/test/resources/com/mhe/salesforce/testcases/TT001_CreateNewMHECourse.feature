#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: As an MHHE Business Admin, I should be able to create a new MHE course.

  Background:
    Given I am logged into salesforce for "CreateNewMHECourse"


	@MHECourse
  @CreateNewMHECourse @GCRM-9271
  Scenario Outline: As an MHHE Business Admin, I should be able to create a new MHE course.

    Given Runmode for "CreateNewMHECourse" is Y
    #Then I login as Sales Rep
    Then I do login as "<MHHE_Business_Administrator>"
    When I navigate to MHE Course tab
    And I create a new MHE course
  Examples:
	  |MHHE_Business_Administrator|
	  |Jaime_Klar|