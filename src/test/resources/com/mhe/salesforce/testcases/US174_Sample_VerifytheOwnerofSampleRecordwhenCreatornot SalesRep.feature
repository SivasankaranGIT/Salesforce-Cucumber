#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Sample_Verify the Owner of the Sample record when the Creator is not a Sales Rep.

Background: 
	Given I am logged into salesforce for "Sample_OwnerOfSampleRecord"	
	
@Samples @Sample_VerifytheOwnerofSampleRecordwhenCreatornotASalesRep	@GCRM-9264
Scenario Outline:  Sample_Verify the Owner of the Sample record when the Creator is not a Sales Rep.

	Given Runmode for "Sample_OwnerOfSampleRecord" is Y
	Then I do login as "<SEG_Sales_Rep>"
	And I switch to SalesChatter home page
	Then global search for contact
  Then click on new Sample button
  Then fill address on account and orders details page
	Then add products by ISBN number
	Then fill details on additional info page
	Then review details on review page
	Then verify account details on sample record
  Then I logout of any user
	Then I do login as "<System_Administrator>"
	And I switch to SalesChatter home page
	Then I navigate to ownership verification tab
	And verify sample details from owner verification page

Examples:
	|SEG_Sales_Rep|System_Administrator|
	|Open_Baker|Sivasankaran_Periyasamy|