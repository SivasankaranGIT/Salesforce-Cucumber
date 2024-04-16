#DEPENDENT SCRIPT - This script is dependent on INTLUserWithEmpNumCreateSample script to cover the commented out steps
Feature: Verify the error message thrown when the INTL Sales Rep without Employee Number(Rep Code) tries to create a new sample, has the correct Sales Op manager email ID in the error message

Background:
Given I am logged into salesforce for "INTLUserWithoutEmpNumCreateSample"

@Samples
@INTLUserWithoutEmpNumCreateSample
@GCRM-10274 @GCRM-10306 @GCRM-10309 @GCRM-11335
@RegressionTest @RegressionTestSamples
Scenario Outline: Verify the error message thrown when the INTL Sales Rep without Employee Number(Rep Code) tries to create a new sample, has the correct Sales Op manager email ID in the error message
	#This scenario also includes testing of GCRM-11335(Error is received when user other than country code Canada without Employee Number tries to create a new sample)
	Given Runmode for "INTLUserWithoutEmpNumCreateSample" is Y
	Then remove employee number of <INTL Sales Rep> user and do login
# The below commentedout scenarios are already getting executed in USB118_INTLUserWithEmpNumCreateSample script. So, we have skipped it in this script.
#	When Navigate to Contacts page
#	Then add new contact
#	Then add contact address
#	Then I logout of any user
#	And Login as different US user
#	Then navigate to existing product
#	When I navigate to Products tab
#	Then update product type to print
#	Then I logout of any user
#	Then I login as Sales Rep
	When I go to sample tab
  And create new sample and verify rep code validation
  #Then I logout of any user
  #Then add employee number of INTL Sales Rep user and do login
  
  Examples:
  |INTL Sales Rep|
  |"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F0050y00000F0Y3jAAF%3Fnoredirect%3D1%26isUserEntityOverride%3D1%26retURL%3D%252Fsetup%252Fhome"|