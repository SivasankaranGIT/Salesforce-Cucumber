#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: ALEKS Administrator User Creates New Contact 

Background: 
    Given I am logged into salesforce for "ALEKSAdminCreatesContact"    
  
@Contacts  
@ALEKSAdminCreatesContact   @GCRM-9258 
Scenario Outline: ALEKS Administrator User Creates New Contact

    Given Runmode for "ALEKSAdminCreatesContact" is Y
#    Then I login as Sales Rep
    Then I do login as "<ALEKS_Administrator>"
    When Navigate to CXG Contacts page
    And create new ALEKS contact by filling mandatory fields
    Then Verify the Details of the Contact record created

    Examples:
    |ALEKS_Administrator|
    |Isaac_Rubio|