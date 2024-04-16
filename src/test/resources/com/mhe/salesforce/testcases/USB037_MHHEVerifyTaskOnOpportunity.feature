#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp, MHESUserSplitProducts, MHESPostponeCloneOpp, CreateNewOppFromQuote, MHESModifyOppTest, AbleToModifyAnOpportunity, MHHERepEditTargetedProd, EditTargetedProductUS, ConsultantRequestForm, EditProductFromOpp, AddingPrimaryContact, MHHEAddingSecondaryContact, MHHERemovingAcontact, MHESSearchingAllAvailableContacts scripts as well.
Feature: Verify visibility of Task records via the Activity related lists in various locations for objects they are related to.

  Background:
    Given I am logged into salesforce for "VerifyTaskOnOpportunity"

	@OpportunitiesDependent
  @VerifyTaskOnOpportunity @GCRM-9208
  Scenario Outline: Verify visibility of Task records via the Activity related lists in various locations for objects they are related to.

    Given Runmode for "VerifyTaskOnOpportunity" is Y
#    Then I login as Sales Rep
      Then I do login as "<System_Administrator>"
    And I change the app launcher to Salesforce Chatter
    Then Validate existing Task in Activity History tab

      Examples:
      |System_Administrator|
      |Sivasankaran_Periyasamy|