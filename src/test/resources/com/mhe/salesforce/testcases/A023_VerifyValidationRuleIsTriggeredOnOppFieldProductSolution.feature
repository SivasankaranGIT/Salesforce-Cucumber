#DEPENDENT SCRIPT - This script is dependent on INTLSalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.INTLOppURL)Feature: Verify Validation rule is triggered when opp field Product Solution is blank and stage is WON
Feature: Verify Validation rule is triggered when opp field Product Solution is blank and stage is WON

Background:
Given I am logged into salesforce for "VerifyValidationRuleIsTriggeredOnOppFieldProductSolution"

@OpportunitiesDependent @VerifyValidationRuleIsTriggeredOnOppFieldProductSolution @GCRM-17163
Scenario Outline: Verify Validation rule is triggered when opp field Product Solution is blank and stage is WON

Given Runmode for "VerifyValidationRuleIsTriggeredOnOppFieldProductSolution" is Y
#Then I login as <UserURL>
Then I do login as "<Sales_Rep_Lightning>"
Then navigate to an exiting opportunity
Then Make the Product Solution field as blank and edit stage
#|https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DY000002QG0eYAG/view|
Then Verify the triggered error
Then update the product solution
Then verify the error is not triggered

Examples:
|Sales_Rep_Lightning|
|Nick_Achelles|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent 
@ValidateDateRangeInOpp @GCRM-16523
Scenario Outline: validate date range is updated
Given Runmode for "ValidateDateRangeInOpp" is Y
Then I do login as "<SEG_Business_Admin>"
Then I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to "<Accounts>" tab
Then I create a new account for MHES lightning console
Then I verify the year

Examples:
|SEG_Business_Admin|MHES_Lightning_Console|Accounts|
|Ivan_Gomez|MHES Lightning Console|Accounts|

#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyFirstTimeInstructorField @GCRM-15731
Scenario Outline: Verify that the Opp Contact rollover/edit screen has the field "Covid19" relabeled to "First Time Instructor"
Given Runmode for "VerifyFirstTimeInstructorField" is Y
Then I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I verify the First Time Instructor field

Examples:
|MHHE_Business_Admin|MHHE|
|Jaime_Klar|MHHE|

#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyTeachingFieldAfterClone @GCRM-15879 @GCRM-16563 @GCRM-15842
Scenario Outline: TC_01: Verify Is Teaching field on Opp contacts is copying over to Cloned Opp through MHHE Sales Rep
Given Runmode for "VerifyTeachingFieldAfterClone" is Y
Then I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I add opportunity contact from opportunity
Then I get the Is Teaching field value
Then I clone the opportunity and verify the Is Teaching field

Examples:
|MHHE_Business_Admin|MHHE|
|Jackie_Alvarado|MHHE|

#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyIsTeachingFieldAfterOppClone @GCRM-15880
Scenario Outline: TC_02: Verify Is Teaching field on Opp contacts is copying over to Cloned Opp through MHHE Business Admin
Given Runmode for "VerifyIsTeachingFieldAfterOppClone" is Y
Then I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I add opportunity contact from opportunity
Then I get the Is Teaching field value
Then I clone the opportunity and verify the Is Teaching field

Examples:
|MHHE|MHHE_Business_Admin|
|MHHE|Jaime_Klar|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyChangesToOppContactFields @GCRM-16514
Scenario Outline: verify changes to opportunity contact fields
Given Runmode for "VerifyChangesToOppContactFields" is Y
Then I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I verify the Lead field in opportunity and add it

Examples:
|MHHE|MHHE_Business_Admin|
|MHHE|Jaime_Klar|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyPicklistValuesInOpp @GCRM-16500
Scenario Outline: verify picklist values have been updated
Given Runmode for "VerifyPicklistValuesInOpp" is Y
Then I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then verify the picklist value for Lead Nomination

Examples:
|MHHE|MHHE_Business_Admin|
|MHHE|Jaime_Klar|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyOppDateAndYearWhenStageEqualsWon @GCRM-15942
Scenario Outline: Verify that Marking MHES Opp as Won shouldn't change its Decision Date through SEG Business Admin user
Given Runmode for "VerifyOppDateAndYearWhenStageEqualsWon" is Y
Then I do login as "<SEG_Sales_Rep>"
Then I navigate to Sales Home page
Then I navigate to opportunity tab
Then create a new opportunity of SEG Record Type
And add subtypes in opportunity
Then Add a product through opportunity
Then I change the opportunity stage to won
Then I logout of any user
Then I do login as "<SEG_Business_Admin>"
Then I navigate to Sales Home page
Then I verify the opportunity purchase date

Examples:
|SEG_Sales_Rep|SEG_Business_Admin|
|Open_Baker|Ivan_Gomez|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyOppCloseDateWhenStageNotEqualsWon @GCRM-15886 @GCRM-15884 @GCRM-15936 @GCRM-15933
Scenario Outline: Verify that Marking MHES Opp as Won shouldn't change its Decision Date through SEG Sales Rep/Verify that Marking MHES Opp as Won shouldn't change its Decision Date through SEG Business Admin user
Given Runmode for "VerifyOppCloseDateWhenStageNotEqualsWon" is Y
Then I do login as "<SEG_Sales_Rep>"
Then I change the app launcher to "<Sales>"
Then I navigate to opportunity tab
Then I create a new opportunity for SEG profile user
And add subtypes in opportunity
Then Add a product through opportunity
Then I change the opportunity stage to won
Then I validate the close date with today date
Then I logout of any user
Then I do login as "<SEG_Business_Admin>"
Then I change the app launcher to "<Sales>"
Then I navigate to opportunity tab
Then I create a new opportunity for SEG profile
And add subtypes in opportunity
Then Add a product through opportunity
Then I change the opportunity stage to won
Then I validate the close date with today date
Then I validate the push out field picklist values

Examples:
|Sales|SEG_Sales_Rep|SEG_Business_Admin|
|Sales|Open_Baker|Ivan_Gomez|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyPrintableViewBtn @GCRM-15939
Scenario Outline: Verify Printable view button on the Opportunity list view page
Given Runmode for "VerifyPrintableViewBtn" is Y
Then I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then verify the print this page link

Examples:
|MHHE|MHHE_Business_Admin|
|MHHE|Jaime_Klar|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyNotReceivedErrorOnOpp @GCRM-15815
Scenario Outline: Verify that the user "Brenda Brown" do NOT receive error messages when performing the mentioned operations on opportunity record.
Given Runmode for "VerifyNotReceivedErrorOnOpp" is Y
Then I do login as "<Digital_Sales_Support>"
Then I change the app launcher to "<MHEI>"
Then I navigate to opportunity tab
Then I create a new opportunity for MHEI
Then I open the opportunity contact and edit the email and verify
Then I delete the added opportunity contact and verify
Then I open the opportunity and change the stage to lost

Examples:
|MHEI|Digital_Sales_Support|
|MHEI|Meghan_Clark|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyAccountAndMHECourseCombination @GCRM-15799 @GCRM-15784
Scenario Outline: Verify that when the user updates the "Account" or "MHE Course" field & if the combination of Account & MHE Course which has never been used before, the system should automatically create a record in the Account MHE Course object for those values.
Given Runmode for "VerifyAccountAndMHECourseCombination" is Y
Then I logout of any user
Then I change the app launcher to "<MHHE>"
Then I create an account of unique type
Then I do login as "<MHHE_Marketing>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then I create a new opportunity having random account name
Then I click on mhe course link and verify

Examples:
|MHHE_Marketing|MHHE|
|Kara_Allara|MHHE|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyOppAccountAndMHECourseCombination @GCRM-15802 @GCRM-15797
Scenario Outline: Verify that when the user updates the "Account" or "MHE Course" field & if the combination of Account & MHE Course has been used before, new Account MHE Course record should not be created & the system should link the existing Acct MHE Course
Given Runmode for "VerifyOppAccountAndMHECourseCombination" is Y
Then I do login as "<MHHE_Marketing>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then I create a new opportunity of MHHE record type
Then I click on mhe course link and verify

Examples:
|MHHE_Marketing|MHHE|
|Kara_Allara|MHHE|

# Created By: Suraj Kumar
@OpportunitiesNonDependent
@VerifyTeachingFieldPicklistValue @GCRM-16556
Scenario Outline: Verify picklist has been set up correctly
Given Runmode for "VerifyTeachingFieldPicklistValue" is Y
Then I do login as "<MHHE_Sales_Representative>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I add opportunity contact from opportunity
Then navigate to opportunity contact and verify picklist values
Then I logout of any user
Then I do login as "<MHHE_Marketing>"
Then verify teaching fields are not editable

Examples:
|MHHE_Sales_Representative|MHHE|MHHE_Marketing|
|Haley_Loebig|MHHE|Kara_Allara|

#Created By: Suraj Kumar
@OpportunitiesNonDependent
@VerifyOppContactCanBeDeletedAndAdded @GCRM-27003
Scenario Outline: Verify that user is able to remove and add opportunity contact from opportunity record
Given Runmode for "VerifyOppContactCanBeDeletedAndAdded" is Y
Then I do login as "<Sales Rep Lightning>"
Then I navigate to opportunity tab
And create a new Opportunity for INTL
And I Add contact <LastName> from opportunity page
Then I delete the added opp contactt

Examples:
|LastName|Sales Rep Lightning|
|"Mylan"|Nick_Achelles|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyOppContactAfterDupeCheck @GCRM-26349
Scenario Outline: Verify that all the opportunities contacts are listed under the merged contact of similar names.
Given Runmode for "VerifyOppContactAfterDupeCheck" is Y
When I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
When I navigate to contacts page
And I create a new contact for MHHE
When I navigate to contacts page
Then create again a new contact with similar name
Then merge both the contacts

Examples:
|MHHE_Business_Admin|MHHE|
|Jaime_Klar|MHHE|