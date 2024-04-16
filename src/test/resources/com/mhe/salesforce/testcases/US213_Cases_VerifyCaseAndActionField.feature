Feature: Verify for a Historical Case of CSOM Product Support and Action/Action2 is auto updated


  Background: 
    Given I am logged into salesforce for "VerifyCaseAndActionField"

   @Cases_Picklist @GCRM-6351 @GCRM-6346 @GCRM-6274 @VerifyCaseAndActionField
  
  Scenario Outline: Verify for a Historical Case of CSOM Product Support and Action/Action2 is auto updated

    Given Runmode for "VerifyCaseAndActionField" is Y
#    Then I login as Sales Rep
     Then I do login as "<CSOM_General_User>"
     #And  I change the app launcher to <app_Name>
    And verify the read access to case based on record type
    Then I logout of any user
#    And I login as ALEKS user
     Then I do login as "<CSOM_General_User>"
    Then verify the read access to case based queue type

     Examples:
     |CSOM_General_User|
     |Lisa_Phelps|



    