#DEPENDANT_SCRIPT - This script is dependent on 'CSOMUserCreatesNewContact' script for getting 'selenium.contacts'
Feature: CSOM User Edit a Contact

Background: 
	Given I am logged into salesforce for "CSOMUserEditContact"

#@Contacts
#@CSOMUserEditContact	@GCRM-9258
#Scenario: CSOM User Edit a Contact
#Given Runmode for "CSOMUserEditContact" is Y
#Then I login as Sales Rep
#And edit any contact and save


#Created By: Ramkaran Singh
@Contacts
@VerifyMKTOSFCDSyncCheckBox	@GCRM-17647
Scenario Outline: CSOM User Edit a Contact
Given Runmode for "VerifyMKTOSFCDSyncCheckBox" is Y
Then I logout of any user
Then I change the app launcher to "<MHHE>"
Then I navigate to contacts page
Then I create a contact with contact type student
Then I verify the Exclude from MKTO SFDC Sync

Examples:
|MHHE|
|MHHE|


#Created By: Ramkaran Singh
@Contacts
@VerifyFAXFieldLength	@GCRM-17080
Scenario Outline: CSOM User Edit a Contact
Given Runmode for "VerifyFAXFieldLength" is Y
Then I change the app launcher to "<MHHE>"
Then I navigate to contacts page
Then I create a contact for Fax Field
Then I do login as classic "<eCommerce_SOA_User>"
Then I create a new contact external related record
Then I logout of any classic user

Examples:
|MHHE|eCommerce_SOA_User|
|MHHE|eCommerce_SOA_User|


#Created By: Ramkaran Singh
@Contacts
@VerifyFromTimeAndToTimeUpdating	@GCRM-17057 @GCRM-16996
Scenario Outline: Verify Office Hours Functionality in Contact Page Layout/Verify the field Hours Last Update Date is present in the right side of the contact record under Office/Teaching Hour tool section
Given Runmode for "VerifyFromTimeAndToTimeUpdating" is Y
Then I do login as "<Lightning_Sales_Rep>"
Then I change the app launcher to "<MHHE>"
Then I navigate to contacts page
Then create a contact by Admin profile for CSOM Lightning Console
Then I verify the From Date and To Date field
#Then I verify the last updated field

Examples:
|MHHE|Lightning_Sales_Rep|
|MHHE|Jaime_Klar|


#Created By: Ramkaran Singh
@Contacts
@VerifyActiveInternationalContacts	@GCRM-17205
Scenario Outline: Verify the Active International Contacts can be created or updated
Given Runmode for "VerifyActiveInternationalContacts" is Y
Then I do login as "<Lightning_Sales_Rep>"
Then I change the app launcher to "<MHEI>"
Then I navigate to contacts page
Then create a new contact for INTL user
Then I verify the status price class and department

Examples:
|MHEI|Lightning_Sales_Rep|
|MHEI|Nick_Achelles|


#Created By: Ramkaran Singh
@Contacts
@VerifyTheValidationRuleForSDR	@GCRM-16969
Scenario Outline: Verify the validation rule when SDR Source Lead Source field is not blank and SDR field is blank when a Contact record is created/updated
Given Runmode for "VerifyTheValidationRuleForSDR" is Y
Then I do login as "<Ivan_Gomez>"
Then I change the app launcher to "<Field_Service_Console>"
Then I navigate to contacts page
Then create a contact with sdr lead source field
Then verify that validation is triggered or not

Examples:
|Field_Service_Console|Ivan_Gomez|
|Field Service Console|Ivan_Gomez|


#Created By: Ramkaran Singh
@Contacts @VerifyContactStatusUpdate @GCRM-16904
Scenario Outline: HE TS/ALEKS: Contact Status update requirements
Given Runmode for "VerifyContactStatusUpdate" is Y
Then I do login as "<ALEKS_CSR>"
Then I change the app launcher to "<ALEKS_Lightning_Console>"
Then I navigate to contacts page
Then create a contact for ALEKS user
Then verify the contact status
Then I logout of any user
Then I do login as "<CXG_Contractor_Student_Chat_Single>"
Then I change the app launcher to "<CXG_Lightning_Console>"
Then I navigate to contacts page
Then create a contact for CXG Lightning Console
Then verify the contact status
Then I logout of any user
Then I do login as "<CXG_Operations>"
Then I change the app launcher to "<CXG_Lightning_Console>"
Then I navigate to contacts page
Then create a contact for CXG Lightning Console
Then verify the contact status
Then I logout of any user
Then I do login as "<ALEKS_Administrator>"
Then I change the app launcher to "<ALEKS_Lightning_Console>"
Then I navigate to contacts page
Then create a contact for ALEKS user
Then verify the contact status for ALEKS
Then I logout of any user
Then I do login as "<CXG_Administrator>"
Then I change the app launcher to "<CXG_Lightning_Console>"
Then I navigate to contacts page
Then create a contact for CXG Lightning Console
Then verify the contact status for ALEKS
Then I logout of any user
Then I do login as "<CXG_Admin_Operations>"
Then I change the app launcher to "<CXG_Lightning_Console>"
Then I navigate to contacts page
Then create a contact for CXG Lightning Console
Then verify the contact status for ALEKS
Then I logout of any user

Examples:
|ALEKS_Lightning_Console|ALEKS_CSR|CXG_Contractor_Student_Chat_Single|CXG_Lightning_Console|CXG_Operations|ALEKS_Administrator|CXG_Administrator|CXG_Admin_Operations|
|ALEKS Lightning Console|James_Galvez|Darwill_Tiamzon|CXG Lightning Console|Cory_Bailon|Isaac_Rubio|Eric_Nelson|Vern_Thorson|