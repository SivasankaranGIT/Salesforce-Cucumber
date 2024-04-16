#DEPENDENT SCRIPT - This script is dependent on MHHESalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.MHHENewOppURL)Feature: Verify Validation rule is triggered when opp field Product Solution is blank and stage is WON
Feature: Validate that the newly added fields are editable by a list of profiles

  Background:
    Given I am logged into salesforce for "ValidateNewlyAddedFieldAreEditable"

  @OpportunitiesDependent @ValidateNewlyAddedFieldAreEditable @GCRM-15445
  Scenario Outline: Validate that the newly added fields are editable by a list of profiles
    Given Runmode for "ValidateNewlyAddedFieldAreEditable" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHHE_Sales_Rep>"
    Then I navigate to opportunity tab
    Then navigate to an exiting opportunity
    And verify the goal field is editable
#      |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001TMfkiAAD/view|
    Then verify the goal field last modified is editable
    Then verify the goal last modified by is editable

    Examples:
      |MHHE_Sales_Rep|
      |Jackie_Alvarado|
