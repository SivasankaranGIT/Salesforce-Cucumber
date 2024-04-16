#DEPENDANT_SCRIPT - This script is dependent on 'CreateNewMHECourse' script for getting 'selenium.MHECourseURL'
Feature: As an MHHE Business Admin, I can maintain product group on a course to drive ownership calculation on opportunities.

  Background:
    Given I am logged into salesforce for "MHHEProductGroup"


	@MHECourse
  @MHHEProductGroup @GCRM-9292
  Scenario Outline: As an MHHE Business Admin, I can maintain product group on a course to drive ownership calculation on opportunities.

    Given Runmode for "MHHEProductGroup" is Y
#    Then I login as Sales Rep
      Then I do login as "<MHHE_Business_Administrator>"
    When I navigate to MHE Course tab
    Then edit product group
    And verify Product group

      Examples:
      |MHHE_Business_Administrator|
      |Jaime_Klar|