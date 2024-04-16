Feature: Add Reason Code "Quote" For MHSE Sales Operations Record Type and check additional picklist values

Background: 
	Given I am logged into salesforce for "AddReasonCodeAndVerifyPicklist" 
	
	
@Cases_Picklist @AddReasonCodeAndVerifyPicklist @GCRM-3112 @GCRM-3105
Scenario Outline: AddReasonCodeAndVerifyPicklist

	Given Runmode for "AddReasonCodeAndVerifyPicklist" is Y
#  Then I login as Sales Rep
   #Then I login as Sales Rep
	Then I do login as "<ALEKS_Administrator>"
	And I navigate to cases page 
	And fill all mandatory details to create new case with reason code
	Then I will edit the required fields to verify Picklist

	Examples:
	|ALEKS_Administrator|
	|Isaac_Rubio|