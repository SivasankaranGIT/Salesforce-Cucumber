Feature: Validate that the newly added fields are read only by profile other then given in the list

  Background:
    Given I am logged into salesforce for "ValidateNewlyAddedFieldAreInReadOnly"

  @ValidateNewlyAddedFieldAreInReadOnly @GCRM-17639

  Scenario Outline: Validate that the newly added fields are read only by profile other then given in the list

    Given Runmode for "ValidateNewlyAddedFieldAreInReadOnly" is Y
#    Then I login as <UserURL>
    Then I do login as "<CSOM_General_User>"
   And  I change the app launcher to <app_Name>
#   Then I navigate to opportunity tab
    Then verify the goal field is read only
      |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068H000006DyO3QAK/view|
    Then verify the goal last modified is read only
    Then verify the goal modified by is read only

    Examples:
      |CSOM_General_User|app_Name|
      |Renata_Obey|"CSOM Lightning Console"|