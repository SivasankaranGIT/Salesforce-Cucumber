#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate that the cases with owner Ryerson DSC Queue has record type as INTL Ryerson Product Support

  Background:
    Given I am logged into salesforce for "ValidateCaseWithOwner"

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @E2C_ValidateCaseWithOwner @GCRM-16313
  #Scenario: Validate that the cases with owner Ryerson DSC Queue has record type as INTL Ryerson Product Support
  #Given Runmode for "ValidateCaseWithOwner" is Y
  #Then I logout of any user
  #Then send external email using backend and verify case created or not
  #|dscsupport@36ozt8ijnqnjv47wnupjoiw6bsbcuxbj9g8ex1meh72do1hkag.dy-o8z2ae.cs258.case.sandbox.salesforce.com|DSC Queue|Email2Case Daily|
  #Then validate the owner and record type
  #|DSC Queue|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #@E2C @VerifyE2CForFirstAidForwardSupport @GCRM-17229
  #Scenario Outline: Verify the Email-to-case is created for the new email address firstaidforwardsupport@mheducation.com
  #Given Runmode for "VerifyE2CForFirstAidForwardSupport" is Y
  #Then I do login as "<US_UAT>"
  #Then send external email using backend and verify case created or not
  #|firstaidforwardsupport@89j15tf1mggktomgmihhuup3g2kdwfmdy7lx2vccygh8ch5b2.dy-o8z2ae.cs258.case.sandbox.salesforce.com|FirstAidForwardSupport|Email2Case Daily|
  #Then validate the fields value
  #|CXG-Connect2|Medium|Email|MHHE Product Support|
  #Examples:
  #|US_UAT|
  #|Jennifer_Ryan|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #Created By: Ramkaran Singh
  #@E2C @VerifyE2CForBackOrderUpdate @GCRM-17128
  #Scenario Outline: Verify the Email-to-case is created for the new email address firstaidforwardsupport@mheducation.com
  #Given Runmode for "VerifyE2CForBackOrderUpdate" is Y
  #Then I do login as "<US_UAT>"
  #Then I change the app launcher to "<CSOM_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|backorderupdates@77cae3rqirjro4fibejw5k1nrg6wv8oxr5acp1kugb0c1uizj.dy-o8z2ae.cs258.case.sandbox.salesforce.com|Back Order Updates|Email2Case Daily|
  #Then go to actions tab and validate the email
  #Examples:
  #|US_UAT|CSOM_Lightning_Console|
  #|Jennifer_Ryan|CSOM Lightning Console|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #Created By: Ramkaran Singh
  #@E2C @VerifyE2CForComponentValue @GCRM-16653 @GCRM-16499 @GCRM-19979
  #Scenario Outline: Verify case gets created with the correct default Component value
  #Given Runmode for "VerifyE2CForComponentValue" is Y
  #Then I do login as "<CXG_Admin_User>"
  #Then I change the app launcher to "<CXG_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|lsiworldwidetestbank@1984oox2134f9hgys4m4u41ajv5xt9pxicmv650v473iboatzx.dy-o8z2ae.cs258.case.sandbox.salesforce.com|LSIWorldWideTestBank|Email2Case Daily|
  #Then validate the component value
  #Examples:
  #|CXG_Admin_User|CXG_Lightning_Console|
  #|Eric_Nelson|CXG Lightning Console|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #Created By: Ramkaran Singh
  #@E2C @VerifyE2CNationalHouseSupport @GCRM-15869
  #Scenario Outline: Verify the Email-to-case is created for the new email address firstaidforwardsupport@mheducation.com
  #Given Runmode for "VerifyE2CNationalHouseSupport" is Y
  #Then I do login as "<US_UAT>"
  #Then I change the app launcher to "<MHHE>"
  #Then send external email using backend and verify case created or not
  #|j.collins@5-2892gfedcdhiv3axw91k6i7njl64clpdziyiaicq4yrgc73i5r.dy-o8z2ae.cs258.case.sandbox.salesforce.com|National House Support|Email2Case Daily|
  #Then validate the national house support fields
  #|National House|instructorhelp_Email|Medium|MHHE Sales Support|
  #Examples:
  #|US_UAT|MHHE|
  #|Jaime_Klar|MHHE|

#AS WE ARE COVERING THE BELOW TC IN E2C REGRESSION SUITE, I AM SKIPPING IT IN UAT REGRESSION SUITE
  #Created By: Ramkaran Singh
  #@E2C @VerifyE2CForBackOrderUpdateFields @GCRM-16538
  #Scenario Outline: Verify case is created in the correct queue
  #Given Runmode for "VerifyE2CForBackOrderUpdateFields" is Y
  #Then I do login as "<US_UAT>"
  #Then I change the app launcher to "<CSOM_Lightning_Console>"
  #Then send external email using backend and verify case created or not
  #|backorderupdates@77cae3rqirjro4fibejw5k1nrg6wv8oxr5acp1kugb0c1uizj.dy-o8z2ae.cs258.case.sandbox.salesforce.com|Back Order Updates|Email2Case Daily|
  #Then I confirm all the fields
  #Examples:
  #|US_UAT|CSOM_Lightning_Console|
  #|Jennifer_Ryan|CSOM Lightning Console|
