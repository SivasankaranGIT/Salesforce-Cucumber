#DEPENDANT_SCRIPT - This script is dependent on 'MHHECreateNewLead' script for getting 'selenium.LeadURl'
Feature: MHES Edit lead

  Background:
    Given I am logged into salesforce for "MHESLeadManagementEditLead"

	@Leads
  @MHESLeadManagementEditLead @GCRM-9240
  Scenario Outline: MHES Edit lead
    Given Runmode for "MHESLeadManagementEditLead" is Y
#    Then I login as Sales Rep
      Then I do login as "<MHHE_Sales_Support>"
    And Modify Lead Rating

      Examples:
      |MHHE_Sales_Support|
      |Jennifer_Bahl|