Feature: Verify the Categories 1, 2, 3 Field dependencies for A3K Users

  Background: 
    Given I am logged into salesforce for "VerifyCaseCategoryFieldsDependencies"

  @A3K @Cases_Picklist @VerifyCaseCategoryFieldsDependencies
  Scenario Outline: Validate Case Dynamic Dropdown fields.
    Given Runmode for "VerifyCaseCategoryFieldsDependencies" is Y
    Then I login as Sales Rep
    #And  I change the app launcher to <app_Name>
		When I navigate to Cases item tab
		Then I create New A3K Cases and validate the Category fields

