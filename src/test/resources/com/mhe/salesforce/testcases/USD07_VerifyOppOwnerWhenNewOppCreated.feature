#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify when the Opportunity created with Owner as SEM/BEC/HSSL, the sales team fields should be updated from Account's National SEM/BEC/HSSL owner's user field values

  Background:
    Given I am logged into salesforce for "VerifyOppOwnerWhenNewOppCreated"

  @OpportunitiesNonDependent @VerifyOppOwnerWhenNewOppCreated @GCRM-15447 @GCRM-22477
  Scenario Outline: Verify when the Opportunity created with Owner as SEM/BEC/HSSL, the sales team fields should be updated from Account's National SEM/BEC/HSSL owner's user field values

    Given Runmode for "VerifyOppOwnerWhenNewOppCreated" is Y
#    Then I login as <UserURL>
    Then I do login as "<MHHE_National_Sales_Manager>"
    Then I navigate to opportunity tab
    And I create a new opportunity
    Then I logout of any user
    Then confirm Sales Team Values of Opp is updated from corresponding accounts national sales SEM owner users fields
    |https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F0051A00000D67jWQAR%3Fnoredirect%3D1%26isUserEntityOverride%3D1%26retURL%3D%252Fsetup%252Fhome|

    Examples:
      |MHHE_National_Sales_Manager|
      |Cassie_Cannon|
