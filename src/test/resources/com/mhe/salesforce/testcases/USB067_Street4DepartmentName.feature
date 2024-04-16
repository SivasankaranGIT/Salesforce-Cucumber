#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify new depart address created with a default account primary shipping address.

  Background: 
    Given I am logged into salesforce for "Street4DepartmentName"

  @Accounts @Street4DepartmentName @GCRM-9457 @GCRM-9456
  Scenario Outline: Verify new depart address created with a default account primary shipping address.
    Given Runmode for "Street4DepartmentName" is Y
    Then I do login as "<MHHE_Business_Administrator>"
    Then global search for accounts
    When I create contact for account with new department
    And verify street4 under account addresses
    Then delete newly created department
    Then I logout of any user
    Then I do login as "<System_Administrator>"
    Then delete newly created contact
    
    Examples: 
    |MHHE_Business_Administrator|System_Administrator|
    |Jaime_Klar|Sivasankaran_Periyasamy|