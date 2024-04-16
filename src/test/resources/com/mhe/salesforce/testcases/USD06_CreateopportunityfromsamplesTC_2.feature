Feature: verify Opportunity can be created from the sample for cy/fy scenario 2

Background: 
    Given I am logged into salesforce for "oppcreatedfromsamplescenario2"
  
@sample  
@oppcreatedfromsamplescenario2    @GCRM-2562
Scenario Outline: verify Opportunity can be created from the sample for cy/fy scenario 2
    Given Runmode for "oppcreatedfromsamplescenario2" is Y
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