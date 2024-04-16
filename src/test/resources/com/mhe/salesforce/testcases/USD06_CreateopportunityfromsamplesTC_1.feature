Feature: verify Opportunity can be created from the sample

Background: 
    Given I am logged into salesforce for "oppcreatedfromsample"
  
@sample  
@oppcreatedfromsample    @GCRM-2569
Scenario Outline: verify Opportunity can be created from the sample

    Given Runmode for "oppcreatedfromsample" is Y
#    Then I login as Sales Rep
    Then I do login as "<SEG_Business_Admin>"
    When I navigate to sample tab
    And click on New to create sample
    Then add contact information
    Then add products by clicking search product
    Then create new opportunity from smample
    And verify cy/fy date on opportunity

    Examples:
    |SEG_Business_Admin|
    |Ivan_Gomez|
