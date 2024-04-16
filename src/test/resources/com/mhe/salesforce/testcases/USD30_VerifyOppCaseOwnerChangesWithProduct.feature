#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Suraj

Feature: Confirm Opportunity ownership changes correctly

Background:
Given I am logged into salesforce for "VerifyOppCaseOwnerChangesWithProduct"

@OpportunitiesNonDependent @VerifyOppCaseOwnerChangesWithProduct @GCRM-21510 @GCRM-22504 @GCRM-22084 
Scenario Outline: Confirm Opportunity ownership changes correctly and Verify on the opportunity record when the stage value is set as 'Lost',reason field should have value Low usage - where Opportunity record type is SEG
Given Runmode for "VerifyOppCaseOwnerChangesWithProduct" is Y
Then I do login as "<SEG_Sales_Rep>"
Then I navigate to opportunity tab
Then I create a new opportunity Of SEG Record Type
Then verify Opportunity owner is changed when product is modified
Then I verify the stage value and reason field
Examples:
|SEG_Sales_Rep|
|Open_Baker|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
#@OpportunitiesNonDependent @GCRM-22504 @GCRM-22084 @VerifyTheStageValueAndReason
#Scenario Outline: Verify on the opportunity record when the stage value is set as 'Lost',reason field should have value Low usage - where Opportunity record type is SEG
#Given Runmode for "VerifyTheStageValueAndReason" is Y
#Then I do login as "<SEG_Sales_Rep>"
#Then I change the app launcher to "<Sales>"
#Then I navigate to opportunity tab
#Then I create a new opportunity Of SEG Record Type
#Then I verify the stage value and reason field
#Examples:
#|SEG_Sales_Rep|Sales|
#|Open_Baker|Sales|

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
#@OpportunitiesNonDependent
#@VerifyTheStageValueAndReasonOption   @GCRM-22503 @GCRM-22502
#Scenario Outline: Verify on the opportunity record when the stage value is set  as 'cancelled' , reason field should have values - Cancelled and Unresponsive where Opportunity record type is DAG New/Field' or 'DAG Renewal'
#Given Runmode for "VerifyTheStageValueAndReasonOption" is Y
#Then I do login as "<Blended_Service_Sales_User>"
#Then I change the app launcher to "<Sales>"
#Then I navigate to opportunity tab
#Then create opportunity with same account name as of contact
#Then I verify the stage value and reason
#Examples:
#|Blended_Service_Sales_User|Sales|
#|Stefanie_Vogel|Sales|

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@VerifyLogACallBtn   @GCRM-20502
Scenario Outline: Verify "log a call "button is present  on the "Activity History" tab.
Given Runmode for "VerifyLogACallBtn" is Y
Then I do login as "<Blended_Service_Sales_User>"
Then I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to opportunity tab
Then create opportunity with same account name as of contact
Then verify the log a call btn in activity history

Examples:
|Blended_Service_Sales_User|MHES_Lightning_Console|
|Stefanie_Vogel|MHES Lightning Console|

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@VerifyErrorMessageForActionField   @GCRM-20501
Scenario Outline: Verify user get an "Error Message "when " Action Field " has no values selected as .
Given Runmode for "VerifyErrorMessageForActionField" is Y
Then I do login as "<Ivan_Gomez>"
Then I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to "<Tasks>" tab
Then validate the mandatory fields
Then create the task without Action field
Then I validate the error without Action field
#Then I logout of any user

Examples:
|Ivan_Gomez|MHES_Lightning_Console|Tasks|
|Ivan_Gomez|MHES Lightning Console|Tasks|

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@ConfirmNetPriceForCountryProducts   @GCRM-17639
Scenario Outline: Confirm Net Price can be updated for Country Products
Given Runmode for "ConfirmNetPriceForCountryProducts" is Y
Then I logout of any user
Then I change the app launcher to "<Sales>"
Then I navigate to "<Country_Products>" tab
Then I create country product and validate the error

Examples:
|Country_Products|Sales|
|Country Products|Sales|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@VerifyLSProjectValidationError   @GCRM-20332 @GCRM-20330
Scenario Outline: When the Status of the "LS Project "record is submit , keeping all the Target price field as blank when we edit the record it throws an validation error
Given Runmode for "VerifyLSProjectValidationError" is Y
Then I do login as "<Jaime_Klar>"
Then I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then I create a new opportunity of MHHE record type
Then I create new LS project
Then change the status of LS project and validate the error

Examples:
|Jaime_Klar|MHHE|
|Jaime_Klar|MHHE|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@VerifyPostponedStageInOpportunity   @GCRM-22366
Scenario Outline: Validate that SEG Sales Rep get error response when Opportunity stage is selected as Postponed
Given Runmode for "VerifyPostponedStageInOpportunity" is Y
Then I do login as "<Open_Baker>"
Then I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to opportunity tab
Then I create a new opportunity Of SEG Record Type
And add subtypes in opportunity
Then I try to change the stage to postponed and validate
Then I do login as "<Ivan_Gomez>"
Then I change the app launcher to "<MHES_Lightning_Console>"
Then Again I try to change the opportunity stage to postponed and verify

Examples:
|Open_Baker|MHES_Lightning_Console|Ivan_Gomez|
|Open_Baker|MHES Lightning Console|Ivan_Gomez|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
#Requirement Chagned. Please refer GCRM-25869
@OpportunitiesNonDependent
@VerifyESDTopTargetField   @GCRM-17983 @GCRM-17990
Scenario Outline: Verify ESD Top Target Field Is Visible On Opportunity Record under Opportunity Tags Section & Editable/Verify Field ESD Top Target Is only Visible On Opportunity Record for Specific Profiles
  Given Runmode for "VerifyESDTopTargetField" is Y
#Then I do login as "<Tina_Altman>"
#Then I change the app launcher to "<MHHE>"
#Then I navigate to opportunity tab
#Then I create a new opportunity of MHHE record type
#Then I verify the ESD Top field is editable or not
Then I do login as "<Jazmine_Lefort>"
Then I change the app launcher to "<MHHE>"
Then I confirm the ESD Top field is editable or not

Examples:
|Tina_Altman|MHHE|Jazmine_Lefort|
|Tina_Altman|MHHE|Jazmine_Lefort|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@ConfirmProfileAccess @GCRM-17936 @GCRM-22503 @GCRM-22502 @GCRM-16727 @GCRM-26587
Scenario Outline: Confirm profile access to Imp and Tech fields
Given Runmode for "ConfirmProfileAccess" is Y
Then I do login as "<Stefanie_Vogel>"
Then I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to opportunity tab
Then create opportunity with same account name as of contact
And add subtypes in opportunity
Then I verify the stage value and reason
Then I verify the fields are present and editable
Then I logout of any user
Then I do login as "<CSOM_Business_Administrators>"
Then I verify Rostering fields are not editable for CSOM
#Then I logout of any user
#Then I do login as "<Steve_Loori>"
#Then I change the app launcher to "<A3K_Customer_Support>"
#Then I verify same fields from A3K customer support profile

Examples:
|Stefanie_Vogel|MHES_Lightning_Console|Steve_Loori|A3K_Customer_Support|CSOM_Business_Administrators|
|Stefanie_Vogel|MHES Lightning Console|Steve_Loori|A3K Customer Support|Jennifer_Ryan|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created Ramkaran Singh
@OpportunitiesNonDependent
@ConfirmDAGNewFieldValidation  @GCRM-17772
Scenario Outline: Confirm new DAG New Field validation rule conditions are working as expected
Given Runmode for "ConfirmDAGNewFieldValidation" is Y
Then I do login as "<Jed_Holdeman>"
Then I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to opportunity tab
Then create opportunity with same account name as of contact
And add subtypes in opportunity
Then I change the stage to previous to postpone
Then I add opportunity contact from opportunity
Then I edit the contact role

Examples:
|Jed_Holdeman|MHES_Lightning_Console|
|Jed_Holdeman|MHES Lightning Console|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created by - Siva
#select id from Account where Source_System__c = 'A3K' LIMIT 10
@Quote @CreateSEGAndDAGTypeOppFromA3KAccountQuote @GCRM-21120 @GCRM-16714 @GCRM-21121 @GCRM-16716 @GCRM-21119 @GCRM-16643 @GCRM-16637
Scenario Outline: Creating SEG, DAG New/Field and DAG Renewal Opportunity from Quote which is belongs to A3K type Account and Verify stage values on Opportunities
Given Runmode for "CreateSEGAndDAGTypeOppFromA3KAccountQuote" is Y
Then I do login as "<SEG_Sales_Operations>"
Then I change the app launcher to "<Sales>"
Then navigate to MHE_Quotes tab on Account
Then I click on MHE New Quote
Then I Create a New Quote with quote "<Type>"
And link new opportunity with existing A3K account quote for "<Opp_Type>"
|9780076124473|
And confirm the newly created Opp type is "<Opp_Type>"
And verify the Account name in Opp is matching with original Account for "<Opp_Type>"
And verify the Fiscal Year error message for "<Opp_Type>"
And verify the Stage picklist values in "<Opp_Type>"
Then I logout of any user
Then I change the app launcher to "<Sales>"
And delete the <opportunities> which are created by scripts
Examples:
|SEG_Sales_Operations|Sales|Type|ISBN|opportunities|Opp_Type|
|Stefanie_Vogel|Sales|QuoteTypeValue2|"9780076124473"|"2025-KY-New Highland Elem School-DAG New/Field-Open"|DAG New/Field|
|Stefanie_Vogel|Sales|QuoteTypeValue3|"9780076124473"|"2025-KY-New Highland Elem School-DAG Renewal-Open"|DAG Renewal|
|Stefanie_Vogel|Sales|QuoteTypeValue|"9780076124473"|"2025-KY-New Highland Elem School-ELEMENTARY: ASG - MATH-Open"|SEG|
