Feature: Clone opportunity 
Background: 
Given I am logged into salesforce for "VerifySalesRepIsAbleToEditQuotesInOpp"

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
#@OpportunitiesNonDependent
@Quote @VerifySalesRepIsAbleToEditQuotesInOpp  @GCRM-17083
Scenario Outline: Verify Sales Rep is able to Edit quotes in opportunity
Given Runmode for "VerifySalesRepIsAbleToEditQuotesInOpp" is Y
Then I do login as "<SEG_Sales_Rep>"
Then I change the app launcher to "<Sales>"
Then I navigate to opportunity tab
Then I create a new opportunity Of SEG Record Type
Then I click on MHE Quotes link through opportunity
Then I Create a Quote
Then I verify the created quote can be edit or not

Examples:
|SEG_Sales_Rep|Sales|
|Open_Baker|Sales|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@VerifyOppFieldsAreRemovedFromOppHistory  @GCRM-17041 @GCRM-16862
Scenario Outline: Verify the Given Opportunity Fields Are Removed From Opportunity History in SEG Record Type
Given Runmode for "VerifyOppFieldsAreRemovedFromOppHistory" is Y
Then I do login as "<SEG_Sales_Rep>"
Then I change the app launcher to "<Sales>"
Then I navigate to opportunity tab
Then I create a new opportunity Of SEG Record Type
Then verify the opportunity history fields are removed or not

Examples:
|SEG_Sales_Rep|Sales|
|Open_Baker|Sales|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@VerifyPercentOfGradesValue  @GCRM-17031
Scenario Outline: Verify Percent Of Grade Has value '5' added to the picklist when Digital Assignments is 'Required for Grades'
Given Runmode for "VerifyPercentOfGradesValue" is Y
Then I do login as "<Nisha_Bansal>"
Then I change the app launcher to "<Sales>"
Then I navigate to opportunity tab
Then create a new opportunity
Then I verify the percent of grades value

Examples:
|Nisha_Bansal|Sales|
|Nisha_Bansal|Sales|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent_SKIP
@ConfirmContactRolesForDAGOpp  @GCRM-17671
Scenario Outline: Confirm Contact Roles are validated for DAG Opportunities
Given Runmode for "ConfirmContactRolesForDAGOpp" is Y
Then I do login as "<Jed_Holdeman>"
#Then I change the app launcher to "<Sales>"
Then I navigate to salesapplication
Then I navigate to opportunity tab
Then I create a new opportunity for DAG New record type
And add subtypes in opportunity
Then Add a product through opportunity
Then I add opportunity contact from opportunity
Then I edit the stage to won and verify

Examples:
|Jed_Holdeman|Sales|
|Jed_Holdeman|Sales|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@VerifyStageProbabilityInOpp  @GCRM-17039 @GCRM-16868
Scenario Outline: Confirm Contact Roles are validated for DAG Opportunities
Given Runmode for "VerifyStageProbabilityInOpp" is Y
Then I do login as "<SEG_Business_Admin>"
Then I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to opportunity tab
Then create a new opportunity of SEG Record Type
And add subtypes in opportunity
Then I add product through opportunity
Then I add opportunity contact from opportunity
Then I check the probability of stage in opportunity

Examples:
|SEG_Business_Admin|MHES_Lightning_Console|
|Ivan_Gomez|MHES Lightning Console|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@VerifyPicklistValueInTeachingField   @GCRM-16902 @GCRM-15935 @GCRM-15934
Scenario Outline: Add Undecided Picklist Value to Is Teaching field
Given Runmode for "VerifyPicklistValueInTeachingField" is Y
Then I do login as "<Jaime_Klar>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then I create a new opportunity of MHHE record type
Then I add opportunity contact from opportunity
Then I verify the created contact Is Teaching field picklist value

Examples:
|Jaime_Klar|MHHE|
|Jaime_Klar|MHHE|

