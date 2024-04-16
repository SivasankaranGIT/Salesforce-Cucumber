#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: View MSI - CRMOC-207

  Background:
    Given I am logged into salesforce for "LeadManagementViweMSIMHES"

	@Contacts @LeadManagement_ViweMSI @GCRM-9253
  Scenario Outline: View MSI - CRMOC-207
    Given Runmode for "LeadManagementViweMSIMHES" is Y
    #Then I login as Sales Rep
    Then I do login as "<SEG_Sales_Rep>"
    #Then global search for accounts
    Then Validate access to MSI on an Account
    Then global search for contact record
    Then Validate user has access to MSI on a Contact and can view the Lead Score
  Examples:
    |SEG_Sales_Rep|
    |Open_Baker|