#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the INTL Sales Rep Lightning users with Employee Number are able to successfully create sample records

Background:
Given I am logged into salesforce for "INTLUserWithEmpNumCreateSample"

@Samples
@INTLUserWithEmpNumCreateSample
@GCRM-10322 @GCRM-11334 @GCRM-11331 @GCRM-11333
@RegressionTest @RegressionTestSamples
Scenario Outline: Verify the INTL Sales Rep Lightning users with Employee Number are able to successfully create sample records
	#This scenario also includes testing of GCRM-11334 (Error is not received when user other than country code Canada with Employee Number tries to create a new sample)
	Given Runmode for "INTLUserWithEmpNumCreateSample" is Y
	Then I logout of any user
	Then add employee number of <INTL Sales Rep> user as <IN Emp No> and do login
	Then I login as <INTL Sales Rep>
	When Navigate to "Contacts" Screen page
	Then add new contact <Account1>
	Then add contact address with country as "India" and city as "IN"
	Then I logout of any user
	And Login as different <US user>
	Then navigate to existing product
	When I go to Products tab
	Then update product type to print
	Then I logout of any user
	Then I login as <INTL Sales Rep>
	When I go to sample tab
  And create new sample record
  Then I logout of any user
  
  #GCRM-11331 (Error is not received when Canada user with Employee Number tries to create a new sample)
  Then add employee number of <Canada Sales Rep> user as <CA Emp No> and do login
  Then I login as <Canada Sales Rep>
	When Navigate to "Contacts" Screen page
	Then add new contact <Account2>
	Then add contact address with country as "CA" and city as "CA"
	When I go to sample tab
  And create new sample record
  Then I logout of any user
  
  #GCRM-11333 (Error is not received when Canada user without Employee Number tries to create a new sample)
  Then remove employee number of <Canada Sales Rep> user and do login
  Then I login as <Canada Sales Rep>
	When I go to sample tab
  And create new sample record
  Then I logout of any user  
  
   Examples:
  |IN Emp No|CA Emp No|INTL Sales Rep|US user|Canada Sales Rep|Account1|Account2|
  |"IN999"|"CACA1279"|"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F0050y00000F0Y3jAAF%3Fnoredirect%3D1%26isUserEntityOverride%3D1%26retURL%3D%252Fsetup%252Fhome"|"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F0050y00000F0Y98AAF%3Fnoredirect%3D1%26isUserEntityOverride%3D1%26retURL%3D%252Fsetup%252Fhome"|"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F0050y00000F0YKEAA3%3Fnoredirect%3D1%26isUserEntityOverride%3D1%26retURL%3D%252Fsetup%252Fhome"|"McGraw Hill Education India"|"MCGRAW-HILL"|
  
  
@Samples @VerifySampleStatusUpdateForRestrictedUser @GCRM-4324
Scenario Outline: Verify that the logged in User is restricted from changing the SFDC Status to "Approved" on the Sample
	Given Runmode for "validateSampleStatusForRestrictedUser" is Y
	Then I do login as "<Sales_Rep_Lightning>"
	Then global search for accounts
	Then navigate to the desired contact
	Then create INTL sample for the contact
	And validate the contact status

Examples:
	|Sales_Rep_Lightning|
	|Rana_Gaurav_Singh|