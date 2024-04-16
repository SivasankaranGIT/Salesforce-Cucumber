#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: As NSS, I have visibility into the Lead Scoring and Marketo Sales Insight panels on the Lead record.

  Background:
    Given I am logged into salesforce for "MHHEMarketoSalesInsightPanels"

	@Leads
  @MHHEMarketoSalesInsightPanels @GCRM-9260
  Scenario Outline: As NSS, I have visibility into the Lead Scoring and Marketo Sales Insight panels on the Lead record.
    Given Runmode for "MHHEMarketoSalesInsightPanels" is Y
#    Then I login as Sales Rep
    Then I do login as "<MHHE_Sales_Support>"
    When I navigate to Leads tab
    And I select required search criteria for global search dropdown
    Then click on Lead based on Search
    Then Validate user has access to Marketo Sales Insight section

      Examples:
      |MHHE_Sales_Support|
      |Jennifer_Bahl|

