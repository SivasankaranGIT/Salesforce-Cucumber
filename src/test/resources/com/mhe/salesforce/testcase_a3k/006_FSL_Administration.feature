Feature: FSL Service Resource

  Background:
    Given I am logged into salesforce for "FSLServiceResourceUpdatingSkills"

  @FSL @FSLServiceResourceUpdateSkills @GCRM-20940 @GCRM-19174
  Scenario Outline: Updating Skills for a Service Resource
    Given Runmode for "FSLServiceResourceUpdatingSkills" is Y
    Then I do login as "<SCHEDULE_ADMIN>"
		#And I change the app launcher to "MHHE"
    When I navigate to "Service Resources" tab
    Then Click on the Service Resource you want to update SKILLS
    Then Go to the Resource Views section and click on SKILLS
    Examples:
      | SCHEDULE_ADMIN  |
      | Jessica_Devlin  |

  @FSL @FSLServiceResourceAbsence @GCRM-20940 @GCRM-19176
  Scenario Outline: Creating a Service Resource Absence
    Given Runmode for "FSLServiceResourceAbsence" is Y
    Then I do login as "<SCHEDULE_ADMIN>"
    And Change app launcher to Field Service
    When I navigate to "Service Resources" tab
    Then Click on the Service Resource you want to update SKILLS
    Then Locate the Absences related list on the right hand side
    Then Click the down arrow and select NEW
    Then Select Non Availability and Click Next
    Then Enter Type Start Date End Date and Click Save
		Then Confirm the service resource absence is created
		Then Click on the three dotes next to the service resource name on the gantt
		Then Click on Details and Click the Calendar tab and go to the date the absence was created for Confirm it is visible on the Salesforce calendar
    Examples:
      | SCHEDULE_ADMIN  |
      | Jessica_Devlin  |