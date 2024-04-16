#DEPENDANT_SCRIPT - This script is dependent on 'MHESCreateOpportunity' script for getting 'selenium.opportunityURL'.
Feature: Create task on Opp page

  Background:
    Given I am logged into salesforce for "CreateTaskOnOpportunity"


	@Tasks
  @CreateTaskOnOpportunity @GCRM-9212
  Scenario Outline: Create task on Opp page

    Given Runmode for "CreateTaskOnOpportunity" is Y
#    Then I login as Sales Rep
      Then I do login as "<MHHE_Sales_Representative>"
    Then Create Task from Open Activity section
    And create task from Opportunity
    Then Edit task status
    Then Validate completed Task in Activity History tab
    And Delete completed Task

      Examples:
      |MHHE_Sales_Representative|
      |Haley_Loebig|