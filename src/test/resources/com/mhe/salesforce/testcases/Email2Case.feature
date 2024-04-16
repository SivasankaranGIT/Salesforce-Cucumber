Feature: Verify Email2Case base functionality

  Background: 
    Given I am logged into salesforce for "Email2CaseBaseScenario"

  @Email2Case @E2CJob1
  Scenario: Verify Email 2 Case Base functionality.
  Given Runmode for "E2CJob1" is Y
  Then I send external emails using backend and validate expected values

  @Email2Case @E2CJob2
  Scenario: Verify Email 2 Case Base functionality.
  Given Runmode for "E2CJob2" is Y
  Then I send external emails using backend and validate expected values
  
  @Email2Case @E2CJob3
  Scenario: Verify Email 2 Case Base functionality.
  Given Runmode for "E2CJob3" is Y
  Then I send external emails using backend and validate expected values

  @Email2Case @E2CJob4
  Scenario: Verify Email 2 Case Base functionality.
  Given Runmode for "E2CJob4" is Y
  Then I send external emails using backend and validate expected values

  @Email2Case @Email2CaseA3K
  Scenario: Verify Email 2 Case A3K addresses
  Given Runmode for "Email2CaseA3K" is Y
  Then I send external emails using backend and validate expected values