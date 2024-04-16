#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify when PIU related list of an opp is updated the same is reflected in Product In Use field

Background:
    Given I am logged into salesforce for "VerifyOppPIURelatedListAddDelete"

@OpportunitiesNonDependent @VerifyOppPIURelatedListAddDelete @GCRM-17180
Scenario Outline: Verify when PIU related list of an opp is updated the same is reflected in Product In Use field

    Given Runmode for "VerifyOppPIURelatedListAddDelete" is Y
    Then I do login as "<Sales_Rep_Lightning>"
    Then I navigate to opportunity tab
    Then create a new opportunity
    When I navigate to product in use screen and add products
    And Verify product in use list within the opportunities
    Then Delete the field product and verify

    Examples:
    |Sales_Rep_Lightning|
    |Nick_Achelles|


#Create By: Ramkaran Singh
@OpportunitiesNonDependent @VerifyRouteToMarektFieldInOpp @GCRM-15883 @GCRM-15881 @GCRM-15878 @GCRM-15876 @GCRM-15874 @GCRM-15871
Scenario Outline: Route-to Market: Create New Opportunity for RTM = Library
    Given Runmode for "VerifyRouteToMarektFieldInOpp" is Y
    Then I do login as "<Sales_Rep_Lightning>"
    Then I navigate to opportunity tab
    Then create a new opportunity for "<route_to_market>"
    Then I verify the "<field>"

    Examples:
    |Sales_Rep_Lightning|route_to_market  |field            |
    |Nick_Achelles      |HE Adoption      |HE Adoption      |
    |Nick_Achelles      |HE Enterprise    |HE Enterprise    |
    |Nick_Achelles      |Distributor      |Distributor      |
    |Nick_Achelles      |School Enterprise|School Enterprise|
    |Nick_Achelles      |School Adoption  |School Adoption  |
    |Nick_Achelles      |Library          |Library          |


