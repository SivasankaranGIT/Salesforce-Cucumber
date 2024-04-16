#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Suraj
#The opp contact record will be deleted only after the apex batch job is executed. so, I am marking this test as SKIP.
Feature: verify the Opportunity Contacts of the related Contacts are deleted when the Contact is deleted from SFDC
  Background:
  Given I am logged into salesforce for "VerifyOppIsDeletedWhenContactIsDeleted"

  @OpportunitiesNonDependentSKIP @GCRM-20473 @VerifyOppIsDeletedWhenContactIsDeleted
  Scenario Outline: verify the Opportunity Contacts of the related Contacts are deleted when the Contact is deleted from SFDC
    Given Runmode for "VerifyOppIsDeletedWhenContactIsDeleted" is Y
    Then I do login as "<MHHE_Business_Administrator>"
    Then I navigate to contacts page
    When I create a new contact from contact page and new opportunity from contact created
    Then I logout of any user
    Then I do login as "<System_Admin>"
    Then i navigated on created contact page as an Admin
    Then I navigate to contacts page
    Then i delete the newly created contact record as an admin and verify the opp contact

    Examples:
    |MHHE_Business_Administrator|System_Admin|
    |Jaime_Klar|Sivasankaran_Periyasamy|

  #Created By : Suraj
  @Contacts @VerifyContactHistoryForINTL @GCRM-17114
  Scenario Outline: Verify the Contact history is updated when the fields Consent to Communicate SFDC Email consent / opt-in Phone consent / opt-in values are changed

    Given Runmode for "VerifyContactHistoryForINTL" is Y
    Then I do login as "<MHE_Business_Operations>"
    Then I navigate to contacts page
    Then create a new contact
    Then I verify the changes for contact in Contact History

    Examples:
      |MHE_Business_Operations|
      |Nisha_Bansal|

  #Created By : Suraj
  @Contacts @VerifyContactCreationForINTLWitoutValidation @GCRM-22142
  Scenario Outline: verify the validation rule is not triggered and contact is created successfully when the address details of the account is incomplete for Indian sales reps

    Given Runmode for "VerifyContactCreationForINTLWitoutValidation" is Y
    Then I do login as "<Sales Rep Lightning>"
    Then I navigate to contacts page
    Then create a new contact
    Then validate contact is created with no error

    Examples:
      |Sales Rep Lightning|
      |Nick_Achelles|

  #Created By : Suraj & Siva
  #FYR - select Id, Division, CreatedById, LastModifiedById, ConnectionReceivedId, ConnectionSentId, Account_ID__c, LegacyId__c, Creation_Source_ID__c, Role__c  from Opportunity_Contact__c where Role__c  in ('Training Contact','Strategic Key Decision Maker / Buyer','Activation Contact / MCH') and Account_ID__c  ='0018000000cMIbs'
  #https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DY000002R2alYAC/view 
  @OpportunitiesNonDependent @ConfirmOppDAGRules @GCRM-17672 @GCRM-25295
  Scenario Outline: Confirm Opportunity rules for DAG record types

  Given Runmode for "ConfirmOppDAGRules" is Y
  Then I do login as "<SEG_Sales_Rep_Inside>"
  Then I change the app launcher to "<Sales>"
  #Then I navigate to "<Accounts>" tab
  And navigate to account record
  Then create an new Opp of DAG New record type
  Then verify DAG Opp Field Values
  Then Add a product through opportunity
  Then I add role based opportunity contacts from opportunity
  Then PostponeClone Opportunity when no provisioning rostering fields are blank
  Then I add Provisioning and rostering details
  Then I edit the stage to won and verify

  Examples:
  |SEG_Sales_Rep_Inside|Accounts|Sales|
  |Jed_Holdeman|Accounts|Sales|
  
  
  #Created By : Suraj
  @OpportunitiesNonDependent @VerifyOppCloneEvents @GCRM-19934
  Scenario Outline: Verify open activities/events are getting cloned when an original opportunity is being cloned

    Given Runmode for "VerifyOppCloneEvents" is Y
    Then I do login as "<MHE_Business_Operations_Restricted>"
    And create a new task for INTL Opportunity and Verify Opp Clone Task

    Examples:
    |MHE_Business_Operations_Restricted|
    |Carlos_Perez|