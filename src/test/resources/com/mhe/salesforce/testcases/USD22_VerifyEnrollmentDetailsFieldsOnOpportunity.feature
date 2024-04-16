#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Addition Of Fields Under Enrollment Details Section In Opportunity Page Layout

  Background:
    Given I am logged into salesforce for "VerifyEnrollmentDetailsFieldsOnOpportunity"
    
  @OpportunitiesNonDependent @VerifyEnrollmentDetailsFieldsOnOpportunity @GCRM-17038
  Scenario Outline: Addition Of Fields Under Enrollment Details Section In Opportunity Page Layout

    Given Runmode for "VerifyEnrollmentDetailsFieldsOnOpportunity" is Y
    Then I do login as "<MHE_Business_Operations>"
    Then I navigate to opportunity tab
    Then I navigate to the first opp in the page
    Then verify enrollment details section is editable on Opportunity page

    Examples:
    |MHE_Business_Operations|
    |Nisha_Bansal|