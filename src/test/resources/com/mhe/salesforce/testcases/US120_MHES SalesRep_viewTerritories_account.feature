#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES Sales Rep User Views Territories from within an Account

  Background: 
    Given I am logged into salesforce for "MHESRepViewTerritories"

  @Accounts @MHESSalesRepViewTerritoriesFromAccounts @GCRM-9094
  Scenario Outline: MHES Sales Rep User Views Territories from within an Account
    Given Runmode for "MHESRepViewTerritories" is Y
#    Then I login as Sales Rep
    Then I do login as "<System_Administrator>"
    Then global search for accounts
    Then I navigate to territories from account
    And verify territories list within the account

    Examples:
    |System_Administrator|
    |Sivasankaran_Periyasamy|