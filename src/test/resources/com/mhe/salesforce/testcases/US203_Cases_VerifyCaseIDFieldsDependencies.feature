Feature: Verify the Incident and Sub Incident Field dependencies for MHHE Product Support Record type for CXG Users

  Background: 
    Given I am logged into salesforce for "VerifyCaseIDFieldsDependencies"

  @Cases_Picklist @GCRM-4621 @GCRM-4661 @GCRM-4660 @VerifyCaseIDFieldsDependencies
  Scenario Outline: Validate Case Dynamic Dropdown fields.
    Given Runmode for "VerifyCaseIDFieldsDependencies" is Y
#    Then I login as Sales Rep
    Then I do login as "<CSOM_Business_Administrators>"
    And I navigate to case number
    Then Validate ID dynamic dropdown fields

    Examples:
    |CSOM_Business_Administrators|
    |Jennifer_Ryan|