#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Email2Case functionalities

  Background: 
    Given I am logged into salesforce for "Email2CaseFunctionalities"

  @E2C @Email2CaseFunctionalities @GCRM-18043
  Scenario Outline: Verify the E2C created for the email address asiacodereq@mheducation.com
  Given Runmode for "Email2CaseFunctionalities" is Y
  Then I logout of any user
  Then I change the app launcher to "<MHES_Lightning_Console>"
  Then send external email using backend and verify case created or not
  |asiacodereq@k-aducqsa3jk56l1yp8gd3e70k5pswzsd6yci05edrzfe8ddmx8.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|INTL|Email2Case Daily|
  Then I verify the fields value
  |APAC CS-Code Request|EMEA Product Support|APAC CS-Code Request|Medium|Closed|
Examples:
	|MHES_Lightning_Console|
	|MHES Lightning Console|

  @E2C @Email2CaseFunctionalities_1 @GCRM-18046
  Scenario: Verify the E2C created for the email address Asia.studysync@mheducation.com
  Given Runmode for "Email2CaseFunctionalities_1" is Y
  Then send external email using backend and verify case created or not
  |asia.studysync@8-1kadpiaitwk7vcmkr8o0j5sm6tcso8m4biz2d2mwubaf63mkyd.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|INTL1|Email2Case Daily|
  Then I verify the fields value
  |APAC CS-StudySync|EMEA Product Support|APAC CS-StudySync|Medium|Closed|


  @E2C @Email2CaseFunctionalities_2 @GCRM-18045
  Scenario: Verify the E2C created for the email address Asia.a3k@mheducation.com
  Given Runmode for "Email2CaseFunctionalities_2" is Y
  Then send external email using backend and verify case created or not
  |asia.a3k@v-r5q3od4yozub6ksylfiwalz7sm82dv2aj8bl14ig64f6v6leq.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|INTL2|Email2Case Daily|
  Then I verify the fields value
  |APAC CS-A3K|EMEA Product Support|APAC CS-A3K|Medium|Closed|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2CVerifyCaseCreatedInUAT @GCRM-17702
  #Scenario Outline: Verify Case created in UAT SFDC when the Email To addresses are ecommerceacks@mheducation.com and reply-acks-mhe@mheducation.com with BCC/CC as any long email address case owner is assigned
  #Given Runmode for "E2CVerifyCaseCreatedInUAT" is Y
  #Then I do login as "<US_UAT>"
  #Then I change the app launcher to "<CSOM_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|cs_queries@3-i6d6mvfhaoygepes3l0k73b75zvff26g1krp3531exfexfc92.dy-o8z2ae.cs258.case.sandbox.salesforce.com|CSOM_CANADA|Email2Case Daily|
  #Then Verify the case owner
  #|CSOM_CANADA|CSOM Canada Customer Service|
  #Examples:
  #|CSOM_Lightning_Console|US_UAT|
  #|CSOM Lightning Console|Jennifer_Ryan|


  @E2C @E2CConfirmSubscriptionProvisioning @GCRM-18008
  Scenario Outline: Confirm Subscription Provisioning email to case flow
  Given Runmode for "E2CConfirmSubscriptionProvisioning" is Y
  Then I do login as "<MHE_Solution_Manager>"
  Then send external email using backend and verify case created or not
  |emea_subscriptions@1-thqdd74njwka5658he3n6hybv6p1auj5d2qq1jhjdhh68fqc1.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|Subscription Provisioning|Email2Case Daily|
  #Then I do login as "<MHE_Solution_Manager>"
  #Then I navigate to cases
  Then I verify all the fields
  |Subscription Provisioning|EMEA Subscription Provisioning|Case Number|Account Name|International Product ISBN|Sales Approved|EMEA Product Support|Case Reason|Status|Subscription Provisioning|Medium|Subject|Date/Time Opened|INTL LastModifiedDate|

  Examples:
  |MHE_Solution_Manager|
  |Charlotte_Ward|

  #Created by : Suraj
  @E2C @VerifyAutoEmailForMHIndiaSupportINTL @GCRM-20353 @GCRM-17413 @GCRM-15947
  Scenario Outline: Verify Auto Response Received for “MH India Support no.reply.mh-support@mheducation.com"
  Given Runmode for "VerifyAutoEmailForMHIndiaSupportINTL" is Y
  Then I do login as "<MHE_Business_Operations>"
  Then send external email using backend and verify case created or not
  |support.india@wnsv82ico9837ii4lt8jxjgmcckk2v6xhsk6d0sbrqe3u523s.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|India Support|Email2Case Daily|
  Then verify fields in new case created
  |India OLC|New|gcrm_test_automation@mheducation.com|
  Then I navigate to cases
  Then verify created case status
  |Closed|
  Examples:
  |MHE_Business_Operations|
  |Meghna_Gupta|

  #Created by : Suraj
  @E2C @VerifyE2CHasCMGAgentLocation @GCRM-19114
  Scenario: verify the Email-to-case created has the CMG Agent Location case originator updated
  Given Runmode for "VerifyE2CHasCMGAgentLocation" is Y
  Then I logout of any user
  Then send external email using backend and verify case created or not
  |cxgaxisaccount@o-2g7lk1nrxni6ajs65hx6owmhteracw32grdzm7sevwwb0nhp8j.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|CXG Axis Account|Email2Case Daily|
  Then verify case is created with no CMG Agent Location of Case Originator value
  Then verify CMG agent location of case originator is dispayed when case owner is changed

  #Created by : Suraj
  @E2C @VerifyE2CForEducador @GCRM-20581 @GCRM-20738
  Scenario: verify the E2C for the email address educador@mheducation.com
  Given Runmode for "VerifyE2CForEducador" is Y
  Then send external email using backend and verify case created or not
  |educador@9thbt1z6fgd5sgnj2euq095cfs19yald7mioyra5eqzwhfl3n.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|E2C Educator|Email2Case Daily|
  Then verify field values for newly created case
  |Spain Teacher|Spain Teacher|EMEA Product Support|

  #Created by : Suraj
  @E2C @VerifyE2CForSpainEMEA @GCRM-20582 @GCRM-20738
  Scenario Outline: verify the E2C for the email address soporte.aula@mheducation.com
  Given Runmode for "VerifyE2CForSpainEMEA" is Y
  Then I do login as "<MHE_Solution_Manager>"
  Then send external email using backend and verify case created or not
  |soporte.aula@q-12zkugo1daoomsn316e1sc2mck94fcg6nb23w4vn55cnvpmko9.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|E2C Aula|Email2Case Daily|
  Then verify field values for newly created case
  |Spain Teacher|Spain Teacher|EMEA Product Support|
  Examples:
  |MHE_Solution_Manager|
  |Charlotte_Ward|

  #Created by : Suraj
#  @E2C @VerifyE2CForSpainEMEAConsultas  @GCRM-20583 @GCRM-20738
#  Given Runmode for "VerifyE2CForSpainEMEAConsultas" is Y
#  Then I do login as "<HE_Marketing>"
#  Then send external email using backend and verify case created or not
#  |consultas@1-ltnvb3y6vnt7lv8bvhix08ylto2br6m7fc633mex2zhmrthv0.dy-o8z2ae.cs258.case.sandbox.salesforce.com|E2C Spain|Email2Case Daily|
#  Then verify field values of created case
#  |Spain Orders|Spain Orders|EMEA Product Support|
#  Examples:
#  |HE_Marketing|
#  |Patricia_Coy_Aroca|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @Email2CaseAssignedToCorrectCaseQueue @GCRM-17241 @GCRM-15951
  #Scenario: Verify the cases are assigned to correct case Queue
  #Given Runmode for "CasesAssignedToCorrectCaseQueue" is Y
  #Then send external email using backend and verify case created or not
  #|cs.dropship.asia@1u3sa2gabqfdyfn1yfsa9fa2dowhq53bgqept2pl4wwemdwdm6.dy-o8z2ae.cs258.case.sandbox.salesforce.com|APAC CS Dropship Asia|Email2Case Daily|
  #Then I verify the fields value.
  #|APAC CS Dropship Asia|

  #Created by : Ramkaran Singh
  @E2C @Email2CaseGTSEmailMonitoring @GCRM-20141
  Scenario: verify the case created in SFDC UAT for the GTS Email Monitoring E2C and verify the Auto response generated
  Given Runmode for "Email2CaseGTSEmailMonitoring" is Y
  Then I logout of any user
  Then send external email using backend and verify case created or not
  |gcrm-orghealth-prod@2f00ofkg9pregfqtnhuyt796t08qds89tp3x4hcz8aampp3vcg.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|GTS Email Monitoring|Email2Case Daily|
  Then Verify the fields in created case
  |GTS|Medium|GTS Case Monitoring|Email|


  #Created by : Ramkaran Singh
  @E2C @Email2CaseSubscriptionMgmt @GCRM-22823
  Scenario Outline: verify the case created by sending email to long email address of Subscription management and verify the case details
  Given Runmode for "Email2CaseSubscriptionMgmt" is Y
  Then I do login as "<CSOM_Business_Administrator>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then send external email using backend and verify case created or not
  |subscriptionmanagement@7-29aa8q40rtb3bkz62o4uf5doc6l7m2h51x6ec91sd7ebnicfyq.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|How to Access Your Recently Purchased McGraw Hill Online Content |keyword optout|
  Then I verify all the fields from created case
  |Post Order|Welcome Email Inquiry|Explained Automated Email|Sent template explaining automated emails.|CSOM SE Subscription Mgmt|Closed - Unconfirmed|

  Examples:
  |CSOM_Lightning_Console|CSOM_Business_Administrator|
  |CSOM Lightning Console|Jennifer_Ryan|


  #Created by : Ramkaran Singh
  @E2C @Email2CaseSubscriptionMgmtUnsubscribe @GCRM-22912 @GCRM-23534
  Scenario Outline: verify when a Response is received from the customer for the auto response with unsubscribe/optout/opt out, case is picked up by Automation Process
  Given Runmode for "Email2CaseSubscriptionMgmtUnsubscribe" is Y
  Then I do login as "<CSOM_Business_Administrator>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then send external email using backend and verify case created or not
  |subscriptionmanagement@7-29aa8q40rtb3bkz62o4uf5doc6l7m2h51x6ec91sd7ebnicfyq.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|How to Access Your Recently Purchased McGraw Hill Online Content|Unsubscribe|
  Then I verify all the fields from created case
  |Post Order|Welcome Email Inquiry|Explained Automated Email|Sent template explaining automated emails.|CSOM SE Subscription Mgmt|Closed - Unconfirmed|

  Examples:
  |CSOM_Lightning_Console|CSOM_Business_Administrator|
  |CSOM Lightning Console|Jennifer_Ryan|


  #Created by : Ramkaran Singh
  @E2C @Email2CaseSubscriptionMgmtUnsubscribeAndPO @GCRM-22904 @GCRM-23627
  Scenario Outline: verify when email body contains Unsubscribe/optout/opt out along with PO/POs, case is not closed and not picked up by automation process
  Given Runmode for "Email2CaseSubscriptionMgmtUnsubscribeAndPO" is Y
  Then I do login as "<CSOM_Business_Administrator>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then send external email using backend and verify case created or not
  |subscriptionmanagement@7-29aa8q40rtb3bkz62o4uf5doc6l7m2h51x6ec91sd7ebnicfyq.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|How to Access Your Recently Purchased McGraw Hill Online Content|Unsubscribe|
  Then verify all the fields from created case
  |CSOM SE Subscription Mgmt|New|Email|

  Examples:
  |CSOM_Lightning_Console|CSOM_Business_Administrator|
  |CSOM Lightning Console|Jennifer_Ryan|


  #Created by : Ramkaran Singh
  @E2C @Email2VerifyJiraIssueGetAttachedToGTS @GCRM-26881 @GCRM-26884 @GCRM-26883
  Scenario: Verify Jira issue get attached to GTS case when same exception emails are sent more than 3 times.
  Given Runmode for "Email2VerifyJiraIssueGetAttachedToGTS" is Y
  Then send external email using backend and verify case created or not
  |gts_crm_support@d-8mvz49ddr8wteo2de83wx2615g4a55es213flj21s4gbtz0qa.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|How to Access Your Recently Purchased McGraw Hill Online Content|Unsubscribe|
  Then verify the jira issue in email information
  Then send external email using backend and verify case created or not
  |gts_crm_support@d-8mvz49ddr8wteo2de83wx2615g4a55es213flj21s4gbtz0qa.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|How to Access Your Recently Purchased McGraw Hill Online Content|Unsubscribe|
  Then Again verify the jira issue in email information


  #Created by : Ramkaran Singh
  @E2C @Email2CaseALEKSOrderFullfillmentQueue @GCRM-15868
  Scenario Outline:E2C for ALEKS Order Fulfillment queue
  Given Runmode for "Email2CaseALEKSOrderFullfillmentQueue" is Y
  Then I do login as "<CSOM_Business_Administrator>"
  Then I change the app launcher to "<CSOM_Lightning_Console>"
  Then send external email using backend and verify case created or not
  |k12orders@r-l6n65tg85w0ujusl3fl0igkn5v76pkhgf5hest2m20551uwhv.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|E2C|E2C Body|
  Then I validate the ALEKS order fullfillment queue fields
  |Email|ALEKS Order Fulfillment|

  Examples:
  |CSOM_Lightning_Console|CSOM_Business_Administrator|
  |CSOM Lightning Console|Jennifer_Ryan              |

