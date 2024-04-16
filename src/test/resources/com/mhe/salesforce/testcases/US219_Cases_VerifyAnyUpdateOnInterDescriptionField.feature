#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify any update on the Internal Description field of Internal Description header is reflected on ID tab of the case details page

  Background:
    Given I am logged into salesforce for "VerifyAnyUpdateOnInternalDescriptionField"

  @Cases @VerifyAnyUpdateOnInternalDescriptionField @GCRM-18204
  Scenario Outline: Verify any update on the Internal Description field of Internal Description header is reflected on ID tab of the case details page
    Given Runmode for "VerifyAnyUpdateOnInternalDescriptionField" is Y
    Then I do login as "<US_UAT>"
    Then I change the app launcher to "<Internal_Description_Header>"
    Then I fill the details of Internal Description template
    Then I logout of any user
    Then I do login as "<CXG_Admin>"
    Then I change the app launcher to "<CXG_Lightning_Console>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then I update the incident and subincident field and validate the internal description value
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then I validate the Internal Description Field value

    Examples:
      |US_UAT|Internal_Description_Header|CXG_Admin|CXG_Lightning_Console|
      |Jennifer_Ryan|Internal Description Header| Eric_Nelson |CXG Lightning Console|

  @Cases @VerifyBusinessAnalyticsDiscipline @GCRM-20964
  Scenario Outline: Verify the Discipline value Business Analytics is added for all the products for which Discipline field is enabled
    Given Runmode for "VerifyBusinessAnalyticsDiscipline" is Y
    Then I do login as "<CXG_Admin>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then I verify the Discipline field value
    Examples:
    |CXG_Admin|
    |Eric_Nelson|

  @Cases @ConfirmCaseCreatedWithoutError @GCRM-16729
  Scenario Outline: confirm case can be created/edited with no error
    Given Runmode for "ConfirmCaseCreatedWithoutError" is Y
    Then I logout of any user
    Then I change the app launcher to "<CXG_Lightning_Console>"
    Then I navigate to cases
    Then I create a new case by Admin profile

    Examples:
    |CXG_Lightning_Console|
    |CXG Lightning Console|


  @Cases @ConfirmEmailsAreCounted @GCRM-17669
  Scenario Outline: Confirm related emails are counted in new field
  Given Runmode for "ConfirmEmailsAreCounted" is Y
  Then I do login as "<CSOM_Support>" 
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then I navigate to cases
  Then verify the email count

  Examples:
  |CSOM_Support|CSOM_Lightning_Console|
  |Jennifer_Ryan|CSOM Lightning Console|


  @Cases @ConfirmBusinessHours @GCRM-16722
  Scenario Outline: Confirm related emails are counted in new field
  Given Runmode for "ConfirmBusinessHours" is Y
  Then I do login as "<CSOM_Support>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then I navigate to cases
  Then Verify the business hours

  Examples:
  |CSOM_Support|CSOM_Lightning_Console|
  |Jennifer_Ryan|CSOM Lightning Console|


  @Cases @RedesignedLayoutForCSOM @GCRM-16368
  Scenario Outline: CSOM Support Case has a redesigned layout for CSOM_Business_Administrators with Edit button when case is created through Contact<Cases Related list New button
  Given Runmode for "RedesignedLayoutForCSOM" is Y
  Then I do login as "<CSOM_Support>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then I navigate to cases
  Then I confirm the edit buttons when case is created

  Examples:
  |CSOM_Support|CSOM_Lightning_Console|
  |Jennifer_Ryan|CSOM Lightning Console|

  @Cases @RedesignedLayoutForCSOMWithoutEditBtn @GCRM-16366 @GCRM-16364 @GCRM-16367 @GCRM-24378 @GCRM-26725
  Scenario Outline: CSOM Support Case has a redesigned layout for CSOM agents profile without Edit button when case is created through Contact<Cases Related list New button
  Given Runmode for "RedesignedLayoutForCSOMWithoutEditBtn" is Y
  Then I do login as "<CSOM_General_User>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  When I navigate to contacts page
  Then create a new case through contacts
	And verify the MYC field related picklist and dependency values
	And verify the Case origin field doesnot contain MYC Automation
	Then I logout of any user
	Then I do login as "<CSOM_Support>" 
  Then I change the app launcher to "<CSOM_Lightning_Console>"
	And verify the MYC field is editable
  Examples:
  |CSOM_General_User|CSOM_Lightning_Console|CSOM_Support|
  |Lisa_Phelps|CSOM Lightning Console|Jennifer_Ryan|

  @E2C @RedesignedLayoutForCSOMWithoutEditBtnEmail @GCRM-16369
  Scenario Outline: CSOM Support Case has a redesigned layout for CSOM agents profile without Edit button when case is created through Emails
  Given Runmode for "RedesignedLayoutForCSOMWithoutEditBtnEmail" is Y
  Then I do login as "<CSOM_General_User>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then send external email using backend and verify case created or not
  |hep_customer-service@1lro24tqr4u26g1zlynyt5axk3ivdqe0jplkc2pu5atw7rzief.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|CSOM Without Edit|Email2Case Daily|
  Then I open the created case and verify

  Examples:
  |CSOM_General_User|CSOM_Lightning_Console|
  |Lisa_Phelps|CSOM Lightning Console|


  @Cases @CaseComponentValueDependency @GCRM-17649
  Scenario Outline: Confirm Case Component value dependency is updated
  Given Runmode for "CaseComponentValueDependency" is Y
  Then I do login as "<CXG_Admin>"
  Then I change the app launcher to "<CXG_Lightning_Console>"
  Then I navigate to cases
  Then I create a new case for CXG Lightning Console
  Then verify the field value

  Examples:
  |CXG_Admin|CXG_Lightning_Console|
  |Eric_Nelson|CXG Lightning Console|


  @Cases @CaseCreatedButFieldNotUpdated @GCRM-16680 @GCRM-16682
  Scenario Outline: Verify case is created and fields are not updated
  Given Runmode for "CaseCreatedButFieldNotUpdated" is Y
  Then I logout of any user
  Then I do login as "<MHHE_Admin>"
  Then I navigate to cases
  Then I create a case for MHHE Sales Support
  Then verify the product and incident field details
   |Registration|Connect|

  Examples:
  |MHHE_Admin|
  |Jaime_Klar|

  #@Cases @CaseCreatedButFieldNotUpdate @GCRM-16682
  #Scenario Outline: Verify case is created and fields are not updated
  #Given Runmode for "CaseCreatedButFieldNotUpdate" is Y
  #Then I do login as "<MHHE_Admin>"
  #Then I navigate to cases
  #Then I create a case for MHHE Sales Supports
  #Then verify the incident field detail
  #|Portal|
#
  #Examples:
  #|MHHE_Admin|
  #|Jaime_Klar|

  @Cases @IncidentPortalRequest @GCRM-16685
  Scenario Outline: Regression- Incident Portal Request
  Given Runmode for "IncidentPortalRequest" is Y
  Then I logout of any user
  When I navigate to "Cases" tab
	#And I change the app launcher to MHES Lightning Console
  Then I change the app launcher to "<MHES_Lightning_Console>"
  When I navigate to "Cases" tab
  Then created a new case for MHHE Sales Support
  Then verify the all field according to condition
  |National Sales Support|Portal|International Instructor Resource Request|Email Campaigns|Sales Collateral|Product Team Connect Accounts|

  Examples:
  |MHES_Lightning_Console|
  |MHES Lightning Console|

  @Cases @MHHESalesSupportDefaultIncident @GCRM-17635
  Scenario Outline: Regression- MHHE_Sales_Support_Default_Incident
  Given Runmode for "MHHESalesSupportDefaultIncident" is Y
 	#Then I logout of any user
	#Then I change the app launcher to CSOM Lightning Console
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then I navigate to cases
  #When I navigate to "Cases" tab
  Then created a case for MHHE Sales Support
  Then verify the incident field
  |Account Problems|
  Then I navigate to cases
  Then created a case for MHHE Sales Support_1
  Then verify the incident field
  |VitalSource|
  Then I navigate to cases
  Then created a case for MHHE Sales Support_2
  Then verify the incident field
  |Desk Copy|
  Then I navigate to cases
  Then created a case for MHHE Sales Support_3
  Then verify the incident field
  |Add New Account|
  Then I navigate to cases
  Then created a case for MHHE Sales Support_4
  Then verify the incident field
  |Sample Requests|
  Then I navigate to cases
  Then created a case for MHHE Sales Support_5
  Then verify the incident field
  |Opt Out of email campaigns|
#  Then I navigate to cases
#  Then created a case for MHHE Sales Support_6
#  Then verify the incident field
#  |Sample Requests|

  Examples:
  |CSOM_Lightning_Console|
  |CSOM Lightning Console|


  @Cases @ALEKSCaseCreatedAndVerifyFields @GCRM-17122
  Scenario Outline: Verify case is created and fields are not updated
  Given Runmode for "ALEKSCaseCreatedAndVerifyFields" is Y
  Then I do login as "<ALEKS_ADMIN>"
  Then I change the app launcher to "<ALEKS_Lightning_Console>"
  Then I navigate to cases
  Then create a new case for ALEKS
  Then verify the reason and sub reason fields
  |Other|See Case Comments|

  Examples:
  |ALEKS_ADMIN|ALEKS_Lightning_Console|
  |Isaac_Rubio|ALEKS Lightning Console|


#  @Cases @ALEKSCaseCreatedAndVerifyFields @GCRM-17122
#  Scenario Outline: Verify case is created and fields are not updated
#  Given Runmode for "ALEKSCaseCreatedAndVerifyFields" is Y
#  Then I logout of any user
#  Then I change the app launcher to "<CXG_Lightning_Console>"
#  Then I navigate to cases
#  Then create a new case for MHHE Product Support
#  Then verify the reason and sub reason fields
#  |Other|See Case Comments|
#
#  Examples:
#  |CXG_Lightning_Console|
#  |CXG Lightning Console|

  #Created By: Ramkaran Singh
  @Cases @VerifyCategoryDropDownPicklist @GCRM-16916 @GCRM-17054
  Scenario Outline: Confirm Case Component value dependency is updated
  Given Runmode for "VerifyCategoryDropDownPicklist" is Y
  Then I do login as "<CXG_Admin>"
  Then I change the app launcher to "<CXG_Lightning_Console>"
  Then I navigate to cases
  Then I create a new case for CXG Lightning Console
  Then verify the category dropdown picklist

  Examples:
  |CXG_Admin|CXG_Lightning_Console|
  |Eric_Nelson|CXG Lightning Console|

  #Created By: Ramkaran Singh
  @Cases @VerifyDTSlinkFields @GCRM-15814
  Scenario: Verify whether the DTS Community page displays "Illustrative Math", "Social Studies 2023" in "All other Programs section"
  Given Runmode for "VerifyDTSlinkFields" is Y
  Then I logout of any user
  Then go to DTS link and verify

  #Created By: Ramkaran Singh
  @Cases @VerifyKnowledgeProductGroup @GCRM-15811
  Scenario Outline: Verify whether "Illustrative Math, Social Studies 2023" picklist values is available in the multi picklist Product Type while creating new Knowledge article
  Given Runmode for "VerifyKnowledgeProductGroup" is Y
  Then I do login as "<CSOM_Support>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then I navigate to "<Knowledge>" tab
  Then I create new knowledge record

  Examples:
  |CSOM_Support|CSOM_Lightning_Console|Knowledge|
  |Jennifer_Ryan|CSOM Lightning Console|Knowledge|

  @Cases @EditAndVerifyJIRAConnectionSyncedOrNot @GCRM-16503 @GCRM-20168 @GCRM-16677 @GCRM-22479 @GCRM-24675 @GCRM-16435 @GCRM-17026
  Scenario Outline: Confirm component value can be changed on cases that were synced to Jira
  Given Runmode for "EditAndVerifyJIRAConnectionSyncedOrNot" is Y
  Then I do login as "<CXG_Administrator>"
  Then I navigate to cases
  Then create a new case for MHHE Product Support
  Then I fill required case details and create JIRA issue
  Then Edit the created Jira issue
  And close the CXG case
  Then I logout of any user
  Then I do login as "<CXG_Agent>"
  And verify the PnM and Version field removal
  Examples:
  |CXG_Administrator|CXG_Agent|
  |Eric_Nelson|Jocelyn_Duterte|

  @Cases @verifySupportAccount @GCRM-16522
  Scenario Outline: confirm error message is shown, and not a dev script exception
  Given Runmode for "verifySupportAccount" is Y
  Then I do login as "<CXG_Administrator>"
  Then I navigate to cases
  Then verify the support account error message

  Examples:
  |CXG_Administrator|
  |Eric_Nelson|

  #Created By: Ramkaran Singh
  @Cases @FeaturedContentSection @GCRM-21903
  Scenario Outline: Verify the Featured Content section displays 10 articles and Recently created displays even the updated/republished articles
  Given Runmode for "FeaturedContentSection" is Y
  Then I do login as "<CSOM_Support>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then I navigate to "<Knowledge>" tab
  Then create a knowledge record
  Then edit the record and publish
 # Then Verify the featured content section
  Then go the DTS community page and verify
  Then update the record and verify again

  Examples:
  |CSOM_Support|CSOM_Lightning_Console|Knowledge|
  |Jennifer_Ryan|CSOM Lightning Console|Knowledge|

  #Created By: Ramkaran Singh
  @Cases @VerifyCHBAInComponentField @GCRM-22825
  Scenario Outline:Verify there is no validation rule triggered when user fills up Component
    Given Runmode for "VerifyCHBAInComponentField" is Y
    Then I do login as "<CXG_Admin>"
    Then I change the app launcher to "<CXG_Lightning_Console>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then I verify the CHBA option from component

    Examples:
    |CXG_Admin|CXG_Lightning_Console|
    |Eric_Nelson|CXG Lightning Console|

  #Created By: Ramkaran Singh
  @Cases @VerifyRenamedComponentLabels @GCRM-22711
  Scenario Outline:verify the renamed Component labels are all found in UAT UI and make sure the LOvs are set as per existing PROD values
    Given Runmode for "VerifyRenamedComponentLabels" is Y
    Then I do login as "<CXG_Admin>"
    Then I change the app launcher to "<CXG_Lightning_Console>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then I verify all the LOVs in the component

    Examples:
    |CXG_Admin|CXG_Lightning_Console|
    |Eric_Nelson|CXG Lightning Console|



  #Created By: Ramkaran Singh
  @Cases @VerifyInternalDescriptionHeaderTemplate @GCRM-27662
  Scenario Outline:verify the Internal Description Header template is populated for the given list of sub incidents
    Given Runmode for "VerifyInternalDescriptionHeaderTemplate" is Y
    Then I do login as "<CXG_Admin>"
    Then I change the app launcher to "<CXG_Lightning_Console>"
    Then I navigate to cases
    When I create a new case for CXG Lightning Console
    Then update and verify the incident and subincident field
    And I update and verify for incident subincident
    Then I update incident and subincident and subincident

    Examples:
    |CXG_Admin|CXG_Lightning_Console|
    |Eric_Nelson|CXG Lightning Console|

#Created By: Suraj Kumar
@Cases @VerifyJIRAIssueNumber @GCRM-26885
Scenario Outline: Verify jira issue doesnt increase even when reply mail is sent from salesofrce to mailbox
Given Runmode for "VerifyJIRAIssueNumber" is Y
Then I do login as "<CXG_Admin>"
Then I change the app launcher to "<CXG_Lightning_Console>"
Then I navigate to cases
Then create a new case for MHHE Product Support
Then I fill required case details and create JIRA issue
Then verify Jira issue number is same

Examples:
|CXG_Admin|CXG_Lightning_Console|
|Eric_Nelson|CXG Lightning Console|


	#Created By: Siva
  @Cases @VerifyJIRAIssueCreation @GCRM-27412 @GCRM-27425 @GCRM-27424 @GCRM-27663
  Scenario Outline: verify JIRA issue is created successfully for Course/Section Creation  Course/Section Deletion Request  Course/Section Recovery  Gradebook (MH)  sub Incidents
  Given Runmode for "VerifyJIRAIssueCreation" is Y
  Then I do login as "<CXG_Administrator>"
  Then I navigate to cases
  Then create a new case for MHHE Product Support
  Examples:
  |CXG_Administrator|
  |Eric_Nelson|
  
  #This is continuation of above test script. I split it in to two scenario just to avoid the multiple execution of new case creation test step.
  @Cases @VerifyJIRAIssueCreation @GCRM-27412 @GCRM-27425 @GCRM-27424 @GCRM-27663
  Scenario Outline: verify JIRA issue is created successfully for Course/Section Creation  Course/Section Deletion Request  Course/Section Recovery  Gradebook (MH)  sub Incidents
  Given Runmode for "VerifyJIRAIssueCreation" is Y
  Then I fill required case details and create new JIRA issue with "<Incident>" and "<SubIncident>"
  Examples:
  |Incident|SubIncident|
 	|Instructor Course/Section Management|Course/Section Creation|
  #|Instructor Course/Section Management|Course/Section Deletion Request|
  #|Instructor Course/Section Management|Course/Section Recovery|
  |Reporting|Gradebook (MH)|
  #|Reporting|Internal/External Report Requests|
  |Additional Resources|Student Resources|
  #|Assignment Help|Assignment Start/Due Date|
  |Survey Initiatives|BTS Surveys|
  #|Survey Initiatives|Corporate Surveys|
  #|Registration|Code Deactivation|
  #|Account Help|Bulk User Import Process (BUIP)|
  
  #This is continuation of above test script.
  @Cases @VerifyJIRAIssueCreation @GCRM-27412 @GCRM-27425 @GCRM-27424 @GCRM-27663
  Scenario: verify JIRA issue is created successfully for Course/Section Creation  Course/Section Deletion Request  Course/Section Recovery  Gradebook (MH)  sub Incidents
  Given Runmode for "VerifyJIRAIssueCreation" is Y
	And close the digital sales support case
  