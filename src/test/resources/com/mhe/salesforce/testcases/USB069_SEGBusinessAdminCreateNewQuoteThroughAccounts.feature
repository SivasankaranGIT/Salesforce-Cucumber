#STAND_ALONE_SCRIPT - This script can be executed separately.
#https://confluence.mheducation.com/pages/viewpage.action?spaceKey=GCRM&title=Overview+Flow+and+test+script
#Created_By: Siva
Feature: Validate SEG_Business_Admin  user is able to create new quote through accounts object.

Background: 
	Given I am logged into salesforce for "CreateNewQuoteThroughAccounts"	

@Quote @CreateNewQuoteThroughAccounts @GCRM-6171 @GCRM-21716 @GCRM-16354 @GCRM-16356
Scenario Outline: Validate SEG_Business_Admin  user is able to create new quote through accounts object.

	Given Runmode for "CreateNewQuoteThroughAccounts" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote
	And I Add ISBN number
	Then Go through the approval process
	And export the quote excel file
	|Order Form|Proposal|
	And email the quote details
	Then navigate to MHE Quotes tab
	Then capture the newly created quote url
	And validate the quote expireation date
Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|

#Created_By: Siva
@Quote @VerifyQuoteNameFieldValidation @GCRM-18759 @GCRM-18761
Scenario Outline: Validate that Quote Name is mandatory while cloning/revising a Quote

	Given Runmode for "VerifyQuoteNameFieldValidation" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to existing approved quote
	And validate quote name field while "<action>" quote
Examples:
	|SEG_Business_Admin|action|
	|Ivan_Gomez|Clone|
	|Ivan_Gomez|reviseQuoteBtn|
	
#Created_By: Siva
@Quote @ValidateExportPDFLicenceError @GCRM-22137
Scenario Outline: Validate that the export to PDF gives license error response for IP1 Account American School of Brasilia
	Given Runmode for "ValidateExportPDFLicenceError" is Y
	Then I do login as "<SEG_Sales_Operations>"
	Then I navigate to Sales Home page
	And verify if export PDF is throwing license error alert popup
	|https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Quote__c/a250y000000BuNzAAK/view|
Examples:
	|SEG_Sales_Operations|
	|Stefanie_Vogel|
	
#Created_By: Siva
@Quote @CreateNewQuoteWithDifferentQuoteTypes @GCRM-21012 @GCRM-21360 @GCRM-21008 @GCRM-21412 @GCRM-20968 @GCRM-26225 @GCRM-26226
Scenario Outline: Verify New IP1 users are able to approve MHE quote for all 3 different Quote Types (Core/Blended, Supplemental/ALEKS and Renewal) having multiple ISBN products added  & also verify Show Discounting Field is Visible Only When It Is Enabled For User 
	Given Runmode for "CreateNewQuoteWithDifferentQuoteTypes" is Y
	Then I do login as "<User>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote with quote "<Type>"
	And I Add multiple ISBN number
	Then Go through the approval process
	And validate the quote status
	And verify Show Discounting Field is Visible for this "<User>"
	Then navigate to MHE Quotes tab
	Then capture the newly created quote url
Examples:
	|User|MHES_Lightning_Console|Type|
	|Amy_Carolan|MHES Lightning Console|QuoteTypeValue|
	|Krystal_Slick|MHES Lightning Console|QuoteTypeValue2|
	|Krystal_Slick|MHES Lightning Console|QuoteTypeValue3|
	
#Created_By: Siva
@Quote @VerifyConvertToOrderInQuote @GCRM-21587 @GCRM-22240 @GCRM-22189 @GCRM-22192 @GCRM-26225 @GCRM-26226
Scenario Outline: Validate that IP1 users other than (Amy, Eileen and Krystal) cannot convert quotes to orders
	Given Runmode for "VerifyConvertToOrderInQuote" is Y
  Then I do login as "<Blended_Service_and_Sales_User_WithoutAccess>"
  Then I change the app launcher to "<MHES_Lightning_Console>"
  And confirm the user has no access to covert to order
  Then I logout of any user
  Then I do login as "<Blended_Service_and_Sales_User_WithAccess>"
	And confirm the user has access to covert to order
Examples:
	|Blended_Service_and_Sales_User_WithAccess|MHES_Lightning_Console|Blended_Service_and_Sales_User_WithoutAccess|
	|Stefanie_Vogel|MHES Lightning Console|Halene_Holland|
	
#Created_By: Siva
#DEPENDENT SCRIPT - This script is dependent on CreateNewQuoteWithDifferentQuoteTypes script for getting the Quote name (selenium.new_QuoteURL)
@Quote @ConfirmMHEQuoteTagInfo @GCRM-24208
Scenario Outline: To Confirm MHE Quote Tag Information
	Given Runmode for "ConfirmMHEQuoteTagInfo" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to MHE Quotes Admin tab
	Then navigate to Web Service Tester tab
	And validate MHEQuote SOA response
Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|

#Created_By: Siva
#DEPENDENT SCRIPT - This script is dependent on CreateNewQuoteWithDifferentQuoteTypes script for getting the Quote name (selenium.new_QuoteURL)
@Quote @VerifyIP1UserCanCloneandReviseQuote @GCRM-26225 @GCRM-26226
Scenario Outline: Verify IP1 User Can Clone and Revise the Quote
	Given Runmode for "VerifyIP1UserCanCloneandReviseQuote" is Y
	Then I do login as "<User>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	And "<Action>" the quote
Examples:
	|User|MHES_Lightning_Console|Action|
	|Stefanie_Vogel|MHES Lightning Console|Clone|
	|Stefanie_Vogel|MHES Lightning Console|Revise|
	
#Created_By: Siva
@Quote @VerifyCatalogPriceInClonedQuoteWithoutDiscount_InternationalAccount @GCRM-21585 @GCRM-22468 @GCRM-22769
Scenario Outline: Validate that catalog price of a cloned quote without discount does not differ in catalog price from original IP1 quote & Validate that Selling Price of IP1 Quotes is maintained while Cloning and Revising for Core Quotes irrespective of 'Keep Discount' field value
	Given Runmode for "VerifyCatalogPriceInClonedQuoteWithoutDiscount_InternationalAccount" is Y
	Then I do login as "<Blended_Service_and_Sales_User>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote with quote "<Type>"
	And I Add multiple ISBN number
	Then Go through the approval process
	And validate the quote status
	And capture the catalog price
	And capture the selling price
	Then navigate to MHE Quotes tab
	Then capture the newly created quote url
	And clone the quote and validate catalog price
	And clone the quote and validate selling price
Examples:
	|Blended_Service_and_Sales_User|MHES_Lightning_Console|Type|
	|Amy_Carolan|MHES Lightning Console|QuoteTypeValue|
	
#Created_By: Siva
@Quote @VerifyCatalogPriceInClonedQuoteWithoutDiscount_DomasticAccount @GCRM-21597
Scenario Outline: Validate that catalog price of a cloned quote without discount does not differ in catalog price from original domestic quote
	Given Runmode for "VerifyCatalogPriceInClonedQuoteWithoutDiscount_DomasticAccount" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote with quote "<Type>"
	And I Add multiple ISBN number
	Then Go through the approval process
	And validate the quote status
	And capture the catalog price
	Then navigate to MHE Quotes tab
	Then capture the newly created quote url
	And clone the quote and validate catalog price
Examples:
	|SEG_Business_Admin|MHES_Lightning_Console|Type|
	|Ivan_Gomez|MHES Lightning Console|QuoteTypeValue2|
	
#Created_By: Siva
@Quote @VerifyDiscountApprovalQuoteExportForRenewalQuoteType @GCRM-21186 @GCRM-21422 @GCRM-22468 @GCRM-23014 @GCRM-15832 @GCRM-26444 @GCRM-25576 @GCRM-25188 @GCRM-24224 @GCRM-24223 @GCRM-24289 @GCRM-24218
Scenario Outline: Verify Renewal type Quote with Discount Approval Process and verify opp type
	Given Runmode for "VerifyDiscountApprovalQuoteExportForRenewalQuoteType" is Y
	Then I do login as "<Blended_Service_and_Sales>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote with quote "<Type>"
	And I Add multiple ISBN number
	Then Go through the approval process with discount
	And validate the quote status
	And confirm new opp status is set as Renewal
	And capture the catalog price
	Then export the quote excel file for Discount Approval
	|Discount Approval|
	Then navigate to MHE Quotes tab
	Then capture the newly created quote url
	Then capture the newly created opp url
	Then I logout of any user
  Then I do login as "<Quote_Approver1>"
  And approver one approves the quote
  Then I logout of any user
  Then I do login as "<Quote_Approver2>"
  And approver two approves the quote
  Then I logout of any user
  And delete the newly created opportunity
Examples:
	|Blended_Service_and_Sales|MHES_Lightning_Console|Type|Quote_Approver1|Quote_Approver2|
	|Amy_Carolan|MHES Lightning Console|QuoteTypeValue3|Nick_Black|Julie_Kniveton|
	
#Created_By: Siva
#DEPENDENT SCRIPT - This script is dependent on VerifyDiscountApprovalQuoteExportForRenewalQuoteType script for getting the Quote name (selenium.new_QuoteURL)
@Quote @VerifyCatalogPriceInClonedQuoteWithDiscount @GCRM-21590 @GCRM-21599 @GCRM-20968 @GCRM-20938 @GCRM-24224 @GCRM-24223 @GCRM-24289 @GCRM-24218
Scenario Outline: Validate that catalog price of a cloned quote with discount does not differ in catalog price from original quote & also verify Show Discounting Field is Visible Only When It Is Enabled For User & Verify Subscription Button 
	Given Runmode for "VerifyCatalogPriceInClonedQuoteWithDiscount" is Y
	Then I do login as "<User>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	And clone the quote and validate catalog price
	And verify Show Discounting Field is Visible for this "<User>"
	And verify add product through Subscription button
Examples:
	|User|MHES_Lightning_Console|
	|Stefanie_Vogel|MHES Lightning Console|
	
#Created_By: Siva
#https://mcgrawhill.atlassian.net/browse/GCRM-22623 (SKIP REASON)
@Quote_SKIP @VerifySameDiscountPriceIsMaintainedInClonedandRevisedQuote @GCRM-22766
Scenario Outline: Validate that Discounted Price of IP1 Quotes is maintained while Cloning and Revising for Supplemental and Renewal Quotes if 'Keep Discount' is checked
	Given Runmode for "VerifySameDiscountPriceIsMaintainedInClonedandRevisedQuote" is Y
	Then I do login as "<User>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	And "<Action>" the quote with discount checked and verify discount in new quote
Examples:
	|User|MHES_Lightning_Console|Action|
	|Stefanie_Vogel|MHES Lightning Console|Clone|
	|Stefanie_Vogel|MHES Lightning Console|Revise|
	
#Created_By: Siva
#https://mcgrawhill.atlassian.net/browse/GCRM-22623 (SKIP REASON)
@Quote_SKIP @VerifyDiscountPriceIsNOTMaintainedInClonedandRevisedQuote @GCRM-22767
Scenario Outline: Validate that Discounted Price of IP1 Quotes is NOT maintained while Cloning and Revising for Supplemental and Renewal Quotes if 'Keep Discount' is NOT checked
	Given Runmode for "VerifyDiscountPriceIsNOTMaintainedInClonedandRevisedQuote" is Y
	Then I do login as "<User>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	And "<Action>" the quote with discount checked and verify discount in new quote
Examples:
	|User|MHES_Lightning_Console|Action|
	|Stefanie_Vogel|MHES Lightning Console|Clone|
	|Stefanie_Vogel|MHES Lightning Console|Revise|
	
#Created_By: Siva
@Quote @ValidateQuoteTotalSellingPriceIsNotZero @GCRM-15950 @GCRM-15761 @GCRM-15764 @GCRM-15758 @GCRM-15766 @GCRM-15709 @GCRM-17135 @GCRM-26179
Scenario Outline: Validate Rule for Total selling price of the MHE Quote line should not be Zero & validate the same when FWO is enabled/disabled

	Given Runmode for "ValidateQuoteTotalSellingPriceIsNotZero" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote
	And I Add multiple ISBN number
	And validate total selling price after made quantity as zero for one product and FWO is disabled
	And validate total selling price when FWO is enabled
	Then Go through the approval process match quote
	Then navigate to MHE Quotes tab
	Then capture the newly created quote url
	And validate the quote name format
	And validate the linked opp has got only the products with quantity
	And verify Stage Reason and Primary Funding Type field values in opp
Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|

#Created By : Siva
@Quote @VerifyUpsellProcess @GCRM-15900 @GCRM-15901 @GCRM-15903 @GCRM-15898 @GCRM-15926 @GCRM-15928
Scenario Outline: Verify Upsell Process

	Given Runmode for "VerifyUpsellProcess" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to Sales Home page
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote
	And I Add ISBN number
	Then Go through the upsell approval process
	And export the quote excel file
	|Price Quote|
	And try editing or deleting upsell record in MHE Quotes
Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|
	
#Created_By: Siva
@Quote @VerifyFinanceApproverQuoteApprovalProcess @GCRM-17064 @GCRM-17060 @GCRM-15785
Scenario Outline: Verify the Finance Approver for a NEW and REVISED Quote is changed to Brian Joniak
	Given Runmode for "VerifyFinanceApproverQuoteApprovalProcess" is Y
	Then I do login as "<SEG_Business_Admin>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	Then navigate to accounts tab
	And click on any account
	Then navigate to MHE_Quotes tab on Account
	Then I click on MHE New Quote
	Then I Create a New Quote
	And I Add ISBN number
	Then Go through the finance approver approval process
	And validate the quote status
	Then navigate to MHE Quotes tab
	Then capture the newly created quote url
	Then I logout of any user
  Then I do login as classic "<Quote_Approver1>"
  And switch to classic user interface
  And "<Quote_Approver1>" approves the quote
  Then I logout of any classic user
  Then I do login as classic "<Quote_Approver2>"
  And switch to classic user interface
  And "<Quote_Approver2>" approves the quote
  Then I logout of any classic user
  Then I do login as classic "<Quote_Approver3>"
  And "<Quote_Approver3>" approves the quote
  Then I logout of any classic user
  #Then I do login as "<SEG_Business_Admin>"
#	Then I change the app launcher to "<MHES_Lightning_Console>"
#	Then revise the approved quote
#	Then Go through the finance approver approval process
#	And validate the quote status
#	Then navigate to MHE Quotes tab
#	Then capture the newly created quote url
#	Then I logout of any user
  #Then I do login as classic "<Quote_Approver1>"
  #And switch to classic user interface
  #And "<Quote_Approver1>" approves the quote
  #Then I logout of any classic user
  #Then I do login as classic "<Quote_Approver2>"
  #And switch to classic user interface
  #And "<Quote_Approver2>" approves the quote
  #Then I logout of any classic user
  #Then I do login as classic "<Quote_Approver3>"
  #And "<Quote_Approver3>" approves the quote
  #Then I logout of any classic user
Examples:
	|SEG_Business_Admin|MHES_Lightning_Console|Quote_Approver1|Quote_Approver2|Quote_Approver3|
	|Ivan_Gomez|MHES Lightning Console|Bethany_Davis|Stewart_Smith|Brian_Joniak|