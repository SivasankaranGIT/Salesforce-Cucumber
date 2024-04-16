Feature: Edit Account Details 

Background: 
	Given I am logged into salesforce for "EditAccountTest"

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By: Ramkaran Singh
@Accounts @ValidateALEKSLTIAAvailableField @GCRM-16318 @GCRM-16316
Scenario Outline: Verify that the profiles other than defined set of profiles are not able to edit new field ALEKS LTIA Available
	Given Runmode for "ValidateALEKSLTIAAvailableField" is Y
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	Then I navigate to "<Accounts>" tab
	Then I open the account record and verify the field
	Then I logout of any user
	Then I do login as "<MHHE_Business_Administrator>"
	Then I change the app launcher to MHHE
	Then I open the account record again and verify the field

	Examples:
	|MHHE_Sales_Representative|Accounts|MHHE_Business_Administrator|
	|Haley_Loebig         |Accounts|Sarah_Bahl			       |


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By: Ramkaran Singh
@Accounts @ValidataIP1AccountField @GCRM-25686 @GCRM-26277 @GCRM-24486
Scenario Outline: Confirm IP1 field is editable for required profile/ Confirm IP1 field is not editable for profile other than MHE Solution Manager
	Given Runmode for "ValidataIP1AccountField" is Y
	Then I do login as "<MHE_Solution_Manager>"
	Then I change the app launcher to "<Sales>"
	Then I navigate to "<Accounts>" tab
 	Then I validate the IP1 account number field is editable
	Then I logout of any user
	Then I do login as "<SEG_Business_Admin>"
	Then I change the app launcher to "<Sales>"
	Then I validate the IP1 account number field is not editable

	Examples:
	|MHE_Solution_Manager|Accounts|SEG_Business_Admin|Sales|
	|Charlotte_Ward       |Accounts|Ivan_Gomez        |Sales|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By: Ramkaran Singh
@Accounts @ValidataALEKSImplementationManagerField @GCRM-24015
Scenario Outline: Verify ALEKS implementation Manager is available on Account Page
	Given Runmode for "ValidataALEKSImplementationManagerField" is Y
	Then I do login as "<MHHE_Business_Admin>"
	Then I change the app launcher to "<MHHE>"
	Then I navigate to "<Accounts>" tab
	Then I validate the ALEKS Implementation Manager field

	Examples:
	|MHHE_Business_Admin|Accounts|MHHE|
	|Jaime_Klar         |Accounts|MHHE|

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By: Ramkaran Singh
@Accounts @ValidatePK12FieldsLabel @GCRM-21868 @GCRM-17710
Scenario Outline: Confirm field labels have been updated correctly
	Given Runmode for "ValidatePK12FieldsLabel" is Y
	Then I do login as "<SEG_Sales_Rep>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	Then I navigate to "<Accounts>" tab
	Then I validate the field labels

	Examples:
	|SEG_Sales_Rep   |Accounts   |MHES_Lightning_Console|
	|Open_Baker      |Accounts   |MHES Lightning Console|


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By: Ramkaran Singh
@Accounts @VerifyTranscationFieldInAccounts @GCRM-15781
Scenario Outline: Verify that the mentioend users are able to see the field "Transaction Manager" on Account record
	Given Runmode for "VerifyTranscationFieldInAccounts" is Y
	And I do login as "<MHHE_Sales_Support>"
	Then I change the app launcher to "<MHHE>"
	And I navigate to "<Accounts>" tab
	Then I validate the transcation field labels
	And I logout of any user
	Then I do login as "<MHHE_Enterprise>"
	Then I validate the transcation field

	Examples:
	|MHHE_Enterprise|Accounts|MHHE|MHHE_Sales_Support|
	|Kelly_Cornelius|Accounts|MHHE|Jennifer_Bahl     |


#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By: Ramkaran Singh
#@Accounts @ValidateAssignedTerritories @GCRM-17182
#Scenario Outline: Verify the MHE_Secondary_Page_Layout has the related lists Assigned Territories and  Users in Assigned Territories and the records found have hyperlinks
#	Given Runmode for "ValidateAssignedTerritories" is Y
#	And I do login as "<System_Administrator>"
#	Then I change the app launcher to "<CXG_System_Admin>"
#	And I navigate to "<Accounts>" tab
#	Then I create a new account record for MHE Standard Record Type#
#
#	Examples:
#	|System_Administrator   |Accounts|CXG_System_Admin|
#	|Sivasankaran_Periyasamy|Accounts|CXG System Admin|
