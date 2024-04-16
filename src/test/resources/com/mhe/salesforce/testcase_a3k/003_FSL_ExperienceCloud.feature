#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva
Feature: Experience Cloud - Per Diem

Background:
  Given I am logged into salesforce for "ExperienceCloud_VerifyComponents"

@FSL @ExperienceCloud @ExperienceCloud_VerifyComponents @GCRM-21948 @GCRM-19183
Scenario Outline: Navigating to Experience Cloud page and verify all it's components
  Given Runmode for "ExperienceCloud_VerifyComponents" is Y
  Then login into experience cloud application
  And verify all the experience cloud components
  
@FSL @ExperienceCloud @ExperienceCloud_CreateAbsenceEvent @GCRM-21948 @GCRM-19184
Scenario Outline: Creating a Resource Absence (For themselves)
  Given Runmode for "ExperienceCloud_CreateAbsenceEvent" is Y
  Then login into experience cloud application
  And create an absence event and verify calendar
  |OnVacation|AutomationTest|
  
@FSL @ExperienceCloud @ExperienceCloud_UpdateSAStatus @GCRM-21948 @GCRM-19185
Scenario Outline: Update the Service Appointment Status
  Given Runmode for "ExperienceCloud_UpdateSAStatus" is Y
  Then login into experience cloud application
  And update the service appointment status