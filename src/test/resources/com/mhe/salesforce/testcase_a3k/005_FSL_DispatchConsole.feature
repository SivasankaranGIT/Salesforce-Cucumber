#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva
Feature: Dispatch Console

Background:
  Given I am logged into salesforce for "DispatchConsole_VerifyGanttFilterAndFields"  
    
@FSL @DispatchConsole @DispatchConsole_VerifyGanttFilterAndFields @GCRM-21948 @GCRM-19242
Scenario Outline: Gantt Filter, Verify (Hours tab, Resource tab, Skill tab, Pallete tab.)
  Given Runmode for "DispatchConsole_VerifyGanttFilterAndFields" is Y
  Then I do login as "<SALES_REP>"
  And Change app launcher to Field Service
  And navigate to Dispatch Console page
  And verify the Gantt filter and fields
    Examples:
    | SALES_REP |
    | Stefanie_Vogel |
  
@FSL @DispatchConsole @DispatchConsole_VerifySAFieldsandActionsOnGantt @GCRM-21948 @GCRM-19287
Scenario Outline: Service Appointments on the Gantt & Actions
  Given Runmode for "DispatchConsole_VerifySAFieldsandActionsOnGantt" is Y
  Then I do login as "<SALES_REP>"
  And Change app launcher to Field Service
  And navigate to Dispatch Console page
  And locate the SA and verify the fields
    Examples:
    | SALES_REP |
    | Stefanie_Vogel |

@FSL @DispatchConsole @DispatchConsole_CreateSRAbsence @GCRM-21948 @GCRM-19288 @GCRM-18877
Scenario Outline: Create a Resource Absence
  Given Runmode for "DispatchConsole_CreateSRAbsence" is Y
  Then I do login as "<SALES_REP>"
  And Change app launcher to Field Service
  And navigate to Dispatch Console page
  And locate the SR and create absence
  |Kira Leblanc|Automation Testing|
    Examples:
    | SALES_REP |
    | Stefanie_Vogel |
    
@FSL @DispatchConsole @DispatchConsole_AssignCandidatesToSA @GCRM-21948 @GCRM-19237
Scenario Outline: Use Candidate action button on the Service Appointment Record
  Given Runmode for "DispatchConsole_AssignCandidatesToSA" is Y
  Then I do login as "<SALES_REP>"
  And Change app launcher to Field Service
  And navigate to Dispatch Console page
  And verify territories in Gantt
  And locate the SA and assign the candidates
  |SA-477441|
    Examples:
    | SALES_REP |
    | Stefanie_Vogel |