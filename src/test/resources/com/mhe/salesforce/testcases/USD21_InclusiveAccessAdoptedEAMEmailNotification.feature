#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the "EAM" receives an E-mail when the user sets the "Inclusive Access - Adopted" checkbox as true just after creating or cloning an Opportunity.

  Background:
    Given I am logged into salesforce for "VerifyInclusiveAccessAdoptedEAMEmailNotification"
    @OpportunitiesNonDependent
    @VerifyInclusiveAccessAdoptedEAMEmailNotification
    @GCRM-15777

  Scenario Outline: Verify that the "EAM" receives an E-mail when the user sets the "Inclusive Access - Adopted" checkbox as true just after creating or cloning an Opportunity.

    Given Runmode for "VerifyInclusiveAccessAdoptedEAMEmailNotification" is Y
  	Then I do login as "<MHHE_Sales_Representative>"
    Then I navigate to opportunity tab
    Then I create a new opportunity record
    When I verify EAM name is populated in Opp record
    Then verify EAM receives email when inclusive access adopted is true

    Examples:
    |MHHE_Sales_Representative|
    |Danielle_Snyder|