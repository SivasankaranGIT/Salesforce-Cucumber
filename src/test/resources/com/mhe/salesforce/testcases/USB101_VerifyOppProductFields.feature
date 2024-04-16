#DEPENDENT SCRIPT - This script is dependent on PriceExistInProductToaddInOpp script for getting the Opportunity URL (selenium.MHENewOppURL)
Feature: Verify Product Not In System New Button in Product In Use Page and verify few required fields in Opportunity Product and PIU page

  Background:
    Given I am logged into salesforce for "VerifyOppProductFields"

	@OpportunitiesDependent
  @VerifyOppProductFields
  @GCRM-8846 @GCRM-8943 @GCRM-12839 @GCRM-12843
  Scenario Outline: Verify Product Not In System New Button in Product In Use Page and verify few required fields in Opportunity Product and PIU page
    Given Runmode for "VerifyOppProductFields" is Y
#    Then I login as <MHHE_Sales_Rep>
      Then I do login as "<MHHE_Sales_Rep>"
    When I navigate to opportunity tab
    And verify the fields Evergreen and Release Date in Product page
    And I go to add product in use page of opportunity
    And verify the fields Evergreen and Release Date in ProductInUse page
    Then I logout of any user
#    Then I login as <MHHE_Business_Admin>
      Then I do login as "<MHHE_Business_Admin>"
    When I navigate to opportunity tab
    And verify the fields OracleStatus OPDate and PermissionEndDate in Product page
    And verify the fields Evergreen and Release Date in Product page
    And I go to add product in use page of opportunity
    And verify the fields OracleStatus OPDate PermissionEndDate and NetPrice in ProductInUse page
    And verify the fields Evergreen and Release Date in ProductInUse page
    And verify product not in system functionality
    Examples:
    |MHHE_Sales_Rep|MHHE_Business_Admin|
    |Jenna_Taylor|Jaime_Klar|