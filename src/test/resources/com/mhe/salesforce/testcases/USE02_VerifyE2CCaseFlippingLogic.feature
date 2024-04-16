#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Case created from MHES pilots E2C for field updates, auto response rule and case flipping logic

  Background:
  Given I am logged into salesforce for "E2C_CaseFlippingLogic"

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2C_CaseFlippingLogic @GCRM-17725
  #Scenario Outline: Verify the Case created from MHES pilots E2C for field updates, auto response rule and case flipping logic
  #Given Runmode for "E2C_CaseFlippingLogic" is Y
  #Then I do login as "<US_UAT>"
  #Then I change the app launcher to "<MHES_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|mhepilots@j-2173o2ed43sidkgfyeg0x3uwl6i9hm68vrwyodpc1f3ogk53sv.dy-o8z2ae.cs258.case.sandbox.salesforce.com|Case Flip Logic|Email2Case Daily|
  #Then Verify the case details field
  #|Case Flip Logic|New|Medium|DTS Tier 2|Email|SEG Product Support|CSOM Order Management|CSOM Support|
  #Examples:
  #|MHES_Lightning_Console|US_UAT|
  #|MHES Lightning Console|Ivan_Gomez|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2C_CanadaMediaTechList @GCRM-20891
  #Scenario Outline: Verify the Case created from MHES pilots E2C for field updates, auto response rule and case flipping logic
  #Given Runmode for "E2C_CanadaMediaTechList" is Y
  #Then I logout of any user
  #Then send external email using backend and verify case created or not
  #|ryerson_mediatechrequest@z-2j5jsgyqmptdoe0pgcxrtbjf1izdbll36pep4fypnoxp6m8r26.dy-o8z2ae.cs258.case.sandbox.salesforce.com|Canada Case List|Email2Case Daily|
  #Then I do login as "<US_UAT>"
  #Then I navigate to cases
  #Then verify the created case fields value
  #|Canada Case List|Canada Media Tech|INTL Ryerson Product Support|Ryerson Media Tech Support|
  #Examples:
  #|US_UAT|
  #|Jeff_Skinner|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2C_EmailNotification @GCRM-20956
  #Scenario Outline: Verify an email notification is sent to the case owner whenever a email is attached to the corresponding case
  #Given Runmode for "E2C_EmailNotification" is Y
  #Then I do login as "<Steve Loori>"
  #Then I navigate to cases
  #Then I change the owner of case
  #Then send external email using backend and verify case created or not
  #|support@c-1z41vkas41ae4fs16isd8ppuh9vj6s3dwerz363ehyt7vd5r6k.dy-o8z2ae.cs258.case.sandbox.salesforce.com|A3K Case|Email2Case Daily|
  #Examples:
  #|Steve Loori|
  #|Steve_Loori|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  # Created By : Ramkaran Singh
  #@E2C @E2C_InternalCustomerService @GCRM-17197 @GCRM-17001
  #Scenario Outline: Verify the Email to case created from internalcustomerservice@mheducation.com. is assigned to CSOM Domestic BASIC Customer Service queue
  #Given Runmode for "E2C_InternalCustomerService" is Y
  #Then I do login as "<US_UAT>"
  #Then I change the app launcher to "<CSOM_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|internalcustomerservice@b-2otxy90schi55zcpi2du1qri93h99xv7xwwfalkdcirzx4hzef.dy-o8z2ae.cs258.case.sandbox.salesforce.com|CSOM Case|Email2Case Daily|
  #Then confirm case origin and case owner field
  #|CSOM Domestic BASIC Customer Service|Medium|Email|
  #Examples:
  #|US_UAT|CSOM_Lightning_Console|
  #|Jennifer_Ryan|CSOM Lightning Console|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2C_CSSalesline @GCRM-16676
  #Scenario Outline: verify case gets created with correct origin and in correct queue
  #Given Runmode for "E2C_CSSalesline" is Y
  #Then I do login as "<US_UAT>"
  #Then I change the app launcher to "<CSOM_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|cs_salesline@1ftj1dzwbk2n8egkb5qn3fqgo1lfdizilhbmxo7kvwv3vai5nc.dy-o8z2ae.cs258.case.sandbox.salesforce.com|PLATFORM DEACTIVATION LIST|Email2Case Daily|
  #Then confirm case origin
  #|Email|CSOM Sales Rep Customer Service|
  #Examples:
  #|US_UAT|CSOM_Lightning_Console|
  #|Jennifer_Ryan|CSOM Lightning Console|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2C_ConfirmAutoReply @GCRM-16688
  #Scenario Outline: confirm auto reply is received for cxg.fsu@mheducation.com and cxg.cameron@mheducation.com
  #Given Runmode for "E2C_ConfirmAutoReply" is Y
  #Then I logout of any user
  #Then I change the app launcher to "<CXG_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|cxg.fsu@al7opx4k6l7g12pp9b41urolc3u5xeq5q7lyh9xdm354u5j3h.dy-o8z2ae.cs258.case.sandbox.salesforce.com|E2C Mail|Email2Case Daily|
  #Then verify the email created
  #Examples:
  #|CXG_Lightning_Console|
  #|CXG Lightning Console|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2C_ConfirmAutoReplyWalterstatecc @GCRM-17214
  #Scenario Outline: confirm autoreply is received for cxg.strayer@mheducation.com and cxg.walterstatecc@mheducation.com
  #Given Runmode for "E2C_ConfirmAutoReply_Walterstatecc" is Y
  #Then I logout of any user
  #Then I change the app launcher to "<CXG_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|cxg.cpcc@1yjm1w1jfssq2tifxps6tckwcqunqygbywn6a4bgzqojak78hg.dy-o8z2ae.cs258.case.sandbox.salesforce.com|E2C Mail|Email2Case Daily|
  #Then verify email created
  #Examples:
  #|CXG_Lightning_Console|
  #|CXG Lightning Console|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2C_ConfirmAutoReplyCXGTopAccount @GCRM-17216
  #Scenario Outline: Verify the Auto response emails are received for the case custom setting with the email templates: CXG_Top_Account_New_Mexico and CXG_Top_Account_Utah_Valley
  #Given Runmode for "E2C_ConfirmAutoReplyCXGTopAccount" is Y
  #Then I logout of any user
  #Then I change the app launcher to "<CXG_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|cxg.newmexico@1c5bj1mxxzm33x8k9890wgy72bdez1ebmcgcp1hdz1g7uah5zk.dy-o8z2ae.cs258.case.sandbox.salesforce.com|E2C Mail|Email2Case Daily|
  #Then verify email created or not
  #Examples:
  #|CXG_Lightning_Console|
  #|CXG Lightning Console|