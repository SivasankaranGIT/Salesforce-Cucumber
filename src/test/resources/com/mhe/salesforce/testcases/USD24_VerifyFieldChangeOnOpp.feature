#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: verify field changes on Opportunities

  Background:
    Given I am logged into salesforce for "VerifyFieldChangeOnOpp"
    @OpportunitiesNonDependent
    @VerifyFieldChangeOnOpp
    @GCRM-16569

  Scenario Outline: verify field changes on Opportunities

    Given Runmode for "VerifyFieldChangeOnOpp" is Y
    Then I do login as "<MHE_Business_Operations>"
    Then I navigate to opportunity tab
    Then I navigate to the first opp in the page
    Then verify route to market field is editable in opp record
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001GM0h9AAD/view|

    Examples:
      |MHE_Business_Operations|
      |Nisha_Bansal|

