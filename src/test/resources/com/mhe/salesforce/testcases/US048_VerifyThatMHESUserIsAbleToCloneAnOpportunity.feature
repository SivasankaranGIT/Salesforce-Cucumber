#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESUserIsAbleToCloneAnOpportunity

Background: 
Given I am logged into salesforce for "MHESCloneOpp"
	
@OpportunitiesNonDependent
@SmokeTest	
@US_TS01_TC31_VerifyThatMHESUserIsAbleToCloneAnOpportunity @GCRM-8962
Scenario Outline: VerifyThatMHESUserIsAbleToCloneAnOpportunity

Given Runmode for "MHESCloneOpp" is Y
#Then I login as Sales Rep
Then I do login as "<MHHE_Sales_Representative>"
And I change the app launcher to MHHE
When User to search and do Opportunity related validation
When I navigate to the first opp in the page
And I Clone from opportunity page MHES

Examples:
|MHHE_Sales_Representative|
|Danielle_Snyder|

#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@OppCreatedForDAGRenewalRecordType @GCRM-20758
Scenario Outline: Verify visibility of the fileds Purchase Date ,Confidence Factor ,Primary Campaign Source fields on the opportunity object also verify these filed can be updated and history of the fields is displayed.
Given Runmode for "OppCreatedForDAGRenewalRecordType" is Y
Then I do login as "<SEG_Business_Admin>"
And I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to opportunity tab
Then create a new opportunity of SEG Record Type
And add subtypes in opportunity
Then verify the fields on newly created opp
Then edit the fields  for newly created opp

Examples:
|SEG_Business_Admin|MHES_Lightning_Console|
|Ivan_Gomez|MHES Lightning Console|

#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyUpdateStrategyWorksheetBtn @GCRM-22379 @GCRM-22377 @GCRM-22378
Scenario Outline: Verify save and edit of fields on the page when clicked on Update Strategy Worksheet button
Given Runmode for "VerifyUpdateStrategyWorksheetBtn" is Y
Then I do login as "<MHHE_Business_Admin>"
And I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then go to strategy worksheet page and edit
Then verify the strategy worksheet page fields
Then verify the fields are visible on strategy worksheet page

Examples:
|MHHE_Business_Admin|MHHE|
|Jaime_Klar|MHHE|

#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyOppContactOnStrategyWorkSheet @GCRM-22380 @GCRM-16728
Scenario Outline: Verify the fields in the Update Strategy Worksheet page gets updated with an update on Opportunity Contact page
Given Runmode for "VerifyOppContactOnStrategyWorkSheet" is Y
Then I do login as "<MHHE_Business_Admin>"
And I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then go to opp contact and add a contact
Then verify the role in strategy worksheet page

Examples:
|MHHE_Business_Admin|MHHE|
|Jaime_Klar|MHHE|


#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyPreviousAndNextOppAfterCloning @GCRM-21058 @GCRM-21059
Scenario Outline:Verify Intl Opportunity while cloning gets previous opty link in the History
Given Runmode for "VerifyPreviousAndNextOppAfterCloning" is Y
Then I do login as "<MHE_Business_Opr>"
And I change the app launcher to "<MHEI>"
Then I navigate to opportunity tab
Then create a new opportunity
Then clone the opportunity and verify

Examples:
|MHE_Business_Opr|MHEI|
|Nisha_Bansal|MHEI|


#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyCalenderOptionInOpp @GCRM-20814 @GCRM-20818
Scenario Outline:Verify  when clicked on Calendar icon user is able to enter any date on the date field without getting any error
Given Runmode for "VerifyCalenderOptionInOpp" is Y
Then I do login as "<SEG_Business_Admin>"
And I change the app launcher to "<MHES_Lightning_Console>"
Then I navigate to opportunity tab
Then create a new opportunity of SEG Record Type
And add subtypes in opportunity
Then click on opp new sample button and verify calender

Examples:
|SEG_Business_Admin|MHES_Lightning_Console|
|Ivan_Gomez|MHES Lightning Console|


#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyOppCreatedThroughAccountDAGRecord @GCRM-21032
Scenario Outline:verify the opportunity is created successfully for DAG Renewal Record type
Given Runmode for "VerifyOppCreatedThroughAccountDAGRecord" is Y
Then I do login as "<Blended_Service_Sales_User>"
And I change the app launcher to "<MHES_Lightning_Console>"
Then create opportunity from accounts record

Examples:
|Blended_Service_Sales_User|MHES_Lightning_Console|
|Stefanie_Vogel|MHES Lightning Console|


#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifySIMnetFieldInOpp @GCRM-16434 @GCRM-16464
Scenario Outline: add SIM specialist to new Opportunity
Given Runmode for "VerifySIMnetFieldInOpp" is Y
Then I do login as "<MHHE_Sales_Representative>"
And I change the app launcher to "<MHHE>"
Then I navigate to "<Accounts>" tab
Then I open the existing account record
Then I create a new opportunity record through accounts
Then I verify the simnet specialist field
And I clone the opportunity to verify simnet specialist field
Then I verify the simnet specialist field

Examples:
|MHHE_Sales_Representative|MHHE|Accounts|
|Jackie_Alvarado          |MHHE|Accounts|

#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifySIMnetForMHHEBusinessAdmin @GCRM-16468 @GCRM-16460
Scenario Outline: verify opps didnot change for owner with no SIMnet Specialist assigned
Given Runmode for "VerifySIMnetForMHHEBusinessAdmin" is Y
Then I do login as "<MHHE_Business_Administrator>"
And I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I verify the simnet specialist field
Then I change the opp owner and verify the simnet field

Examples:
|MHHE_Business_Administrator|MHHE|
|Jaime_Klar                 |MHHE|


#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyChecklistFieldInOpp @GCRM-25671
Scenario Outline: Verify that Checklist field is visible and editable for certain profile users on opportunity object.
Given Runmode for "VerifyChecklistFieldInOpp" is Y
Then I do login as "<MHHE_Business_Administrator>"
And I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I verify the checklist field in opportunity
Then I logout of any user
Then I do login as "<MHHE_Comp_Control>"
And I change the app launcher to "<MHHE>"
Then I again verify the checklist field in opportunity

Examples:
|MHHE_Business_Administrator|MHHE|MHHE_Comp_Control|
|Jaime_Klar                 |MHHE|Michael_Swert    |

#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyNewBtnForPrintExceptionInOpp @GCRM-26623
Scenario Outline: Verify user is not able to create any New print exception record from New button on related list
Given Runmode for "VerifyNewBtnForPrintExceptionInOpp" is Y
Then I do login as "<MHHE_Business_Administrator>"
And I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I verify the new button for print exception

Examples:
|MHHE_Business_Administrator|MHHE|
|Jaime_Klar                 |MHHE|


#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyCopyRightYearInOpp @GCRM-25722
Scenario Outline: Verify copyright values comes as per the Copyright_Sort__c field during new sample
Given Runmode for "VerifyCopyRightYearInOpp" is Y
Then I do login as "<MHHE_Sales_Representative>"
And I change the app launcher to "<MHHE>"
Then I navigate to "<MHHE_Mass_Sampling>" tab
And I verify that product is fetched

Examples:
|MHHE_Sales_Representative|MHHE_Mass_Sampling|MHHE|
|Danielle_Snyder          |MHHE Mass Sampling|MHHE|

#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyCopyRightYear @GCRM-25722
Scenario Outline: Verify copyright values comes as per the Copyright_Sort__c field during mass sampling
Given Runmode for "VerifyCopyRightYear" is Y
Then I do login as "<MHHE_Sales_Representative>"
And I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I verify the opportunity copyright year

Examples:
|MHHE_Sales_Representative|MHHE|
|Danielle_Snyder          |MHHE|

#Created By:Ramkaran Singh
#select id from Product2 where Print_Exception_Allowed__c =true LIMIT 10
#select id from Product2 where Evergreen_Product_Development__c = true and Print_Exception_Allowed__c =true  LIMIT 10
@OpportunitiesNonDependent
@VerifyEditDeleteBtnInPrintException @GCRM-26625
Scenario Outline: Verify user is not able to edit or delete  any print exception records
Given Runmode for "VerifyEditDeleteBtnInPrintException" is Y
Then I do login as "<MHHE_Business_Administrator>"
And I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
Then I add the product in opportunity
And I verify the mhhe product exception
Then I verify delete button in mhhe product exception
Then I logout of any user
Then I do login as "<MHHE_Sales_Representative>"
And I change the app launcher to "<MHHE>"
Then I reverify delete button in mhhe product exception

Examples:
|MHHE_Business_Administrator|MHHE|MHHE_Sales_Representative|
|Jaime_Klar                 |MHHE|Danielle_Snyder          |

#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyLabelChanges @GCRM-16663
Scenario Outline: Confirm label changes
Given Runmode for "VerifyLabelChanges" is Y
Then I do login as "<MHHE_Implementation_Team>"
And I change the app launcher to "<MHHE>"
Then I navigate to opportunity tab
Then create new opportunity of MHHE record type
And I add new contact from opportunity
Then I verify the handoff field

Examples:
|MHHE_Implementation_Team|MHHE|
|Jordan_Allen            |MHHE|

#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyValidationRuleForRecognizeStage @GCRM-17152
Scenario Outline: Verify Validation rule is triggered when opp field Contact is blank and stage is Recognize
Given Runmode for "VerifyValidationRuleForRecognizeStage" is Y
Then I do login as "<Sales_Rep_Lightning>"
And I change the app launcher to "<Sales>"
Then I navigate to opportunity tab
Then create a new opportunity
Then I update the stage as Recognize and validate the error
And I Add contact <LastName> from opportunity page
Then I revalidate the stage as Recognize

Examples:
|Sales_Rep_Lightning|Sales|LastName|
|Nick_Achelles      |Sales|"Mylan"|


#Created By:Ramkaran Singh
@OpportunitiesNonDependent
@VerifyActiveContactInNewOpp @GCRM-16359 @GCRM-19118
Scenario Outline: Validate that an Active contact can be added to New Opportunity
Given Runmode for "VerifyActiveContactInNewOpp" is Y
Then I do login as "<MHE_Business_Operations>"
And I change the app launcher to "<Sales>"
Then I navigate to opportunity tab
Then create a new opportunity
And I Add contact <LastName> from opportunity page
Then I verify the added contact
And deactivate the opportunity contact
And I navigate to newly create Opportunity record
And I clone INTL opportunity using clone option
Then verify inactive contacts are not cloned in cloned opportunity
And activate the contact back

Examples:
|MHE_Business_Operations|Sales|LastName|
|Nisha_Bansal           |Sales|"Zaman"|

