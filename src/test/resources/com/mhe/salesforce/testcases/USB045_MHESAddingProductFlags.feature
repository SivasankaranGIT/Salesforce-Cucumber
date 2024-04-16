#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Adding a Product w Product Flags

  Background: 
    Given I am logged into salesforce for "MHESAddingProductFlags"

  @Products @MHESAddingProductFlags @GCRM-9214
  Scenario Outline: Adding a Product w Product Flags
    Given Runmode for "MHESAddingProductFlags" is Y
#    Then I login as Sales Rep
    Then I do login as "<SEG_Sales_Rep>"
    When I navigate to Products tab
    Then I click on Product based on isbn
    Then global search for product
    And Verify Product flag

    Examples:
    |SEG_Sales_Rep|
    |Open_Baker|