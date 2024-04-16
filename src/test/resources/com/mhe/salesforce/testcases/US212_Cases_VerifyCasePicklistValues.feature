Feature: Verify the CSOM Support Cases Picklist Value


  Background: 
    Given I am logged into salesforce for "VerifyCasePicklistValues"

   @Cases_Picklist @GCRM-6644 @GCRM-6642 @GCRM-6637 @VerifyCasePicklistValues
  
  Scenario Outline: Verify the CSOM Support Cases Picklist Value

    Given Runmode for "VerifyCasePicklistValues" is Y
#    Then I login as Sales Rep
     Then I do login as "<CSOM_Business_Administrators>"
    And I navigate to case number
    Then Validate ID dynamic dropdown fields
     
     Examples: 
     |CSOM_Business_Administrators|
     |Jennifer_Ryan|
    