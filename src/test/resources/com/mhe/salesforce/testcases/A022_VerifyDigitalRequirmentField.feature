#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate that the new field is NOT present on Opportunity Records other than INTL

  Background: Given I am logged into salesforce for "VerifyDigitalRequirementFieldInOpp"

  @OpportunitiesNonDependent @VerifyDigitalRequirementFieldForNonINTLOpp @GCRM-16353
    Scenario Outline: Validate that the new field is NOT present on Opportunity Records other than INTL
    Given Runmode for "VerifyDigitalRequirementFieldForNonINTLOpp" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHE_Business_Operations&CSOM_Business_Administrators>"
    And  I Verify the <Opp> record
  Examples:
    |MHE_Business_Operations&CSOM_Business_Administrators|Opp|
    |Nisha_Bansal|"https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y000017nynpAAA/view"|
    |Jennifer_Ryan|"https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y000017nynpAAA/view"|


  @OpportunitiesNonDependent @VerifyDigitalRequirementFieldForINTLOpp @GCRM-16351
  Scenario Outline: Validate that the new field is present on INTL Opportunity Records
    Given Runmode for "VerifyDigitalRequirementFieldForINTLOpp" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHE_Business_Operations&Sales_Manager_Lightning>"
    And  I Verify the <Opp> record
    Examples:
      |MHE_Business_Operations&Sales_Manager_Lightning|Opp|
      |Nisha_Bansal|"https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001IOYvzAAH/view"|
      |Liisa_Bowler|"https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001IOYvzAAH/view"|