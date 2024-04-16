#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: CSOM User Creates New Contact

Background: 
	Given I am logged into salesforce for "CSOMUserCreatesNewContact" 
	
@Contacts
@CSOMUserCreatesNewContact	@GCRM-9258 @GCRM-9258
Scenario Outline: CSOM User Creates New Contact

Given Runmode for "CSOMUserCreatesNewContact" is Y
#Then I login as Sales Rep
Then I do login as "<CSOM_General_User>"
When I navigate to contacts page
And create new contact by filling mandatory fields
And edit any contact and save

Examples:
|CSOM_General_User|
|Lisa_Phelps|

#Created By: Ramkaran Singh
@Contacts
@UpdateEmailAndAlternateEmail	@GCRM-22895 @GCRM-22890
Scenario Outline: Verify any update in email and alternate email field
Given Runmode for "UpdateEmailAndAlternateEmail" is Y
Then I logout of any user
Then I change the app launcher to "<CSOM Lightning Console>"
When I navigate to contacts page
Then create a contact by Admin profile for CSOM Lightning Console
Then edit the email and verify alternate email
Then check the contact history for email

Examples:
|CSOM Lightning Console|
|CSOM Lightning Console|

#Created By: Ramkaran Singh
@Contacts
@VerifyEditFeatureForGainSightAPI	@GCRM-20285
Scenario Outline: Verify Read Only and edit Feature for Gainsight API integration User When Edit is disabled or enabled
Given Runmode for "VerifyEditFeatureForGainSightAPI" is Y
Then I do login as classic "<GainSight_Integration>"
Then verify the edit feature
Then I logout of any classic user
Examples:
|GainSight_Integration|
|GainSight_Integration|


#Created By: Ramkaran Singh
@Contacts
@VerifyAccountAndContactInClassicMode	@GCRM-22963
Scenario Outline: Verify account and contact are autopopulated in new case in Classic page
Given Runmode for "VerifyAccountAndContactInClassicMode" is Y
Then I do login as classic "<System_Administrator>"
And switch to classic user interface
Then I open contact in classic and verify contact name and account name
Then I logout of any classic user
Examples:
|System_Administrator|
|Sivasankaran_Periyasamy|


#Created By: Ramkaran Singh
@Contacts
@VerifyAccountAndContactInLightning	@GCRM-22962
Scenario Outline: Verify account and contact are autopopulated in new case in Lightning page
Given Runmode for "VerifyAccountAndContactInLightning" is Y
Then I do login as "<A3K_Customer_Support_User>"
Then I change the app launcher to "<A3K_Customer_Support>"
Then I navigate to contacts page
Then I verify the auto populated contact name and account name

Examples:
|A3K_Customer_Support_User|A3K_Customer_Support|
|Julianne_Bonilla|A3K Customer Support|


#Created By: Ramkaran Singh
@Contacts
@VerifyOppContactAfterDelete  @GCRM-20532
Scenario Outline: verify the opportunity contacts are deleted when the contact is deleted using an MHES user
Given Runmode for "VerifyOppContactAfterDelete" is Y
Then I do login as "<Ivan_Gomez>"
Then I change the app launcher to "<MHES_Lightning_Console>"
When I navigate to contacts page
Then I create a contact for SEG User
Then I navigate to opportunity tab
Then create opportunity with same account name as of contact
Then I go to opportunity contact and add a contact
Then I navigate to contacts page
Then I go to contact and verify the added opportunity
Then I navigate to contacts page
Then I delete the contact and verify the added opportunity
Then I navigate to opportunity tab
Then I verify the opportunity record

Examples:
|Ivan_Gomez|MHES_Lightning_Console|
|Ivan_Gomez|MHES Lightning Console|


#Created By: Ramkaran Singh
@Contacts
@VerifyOppContactAfterDeleteByINTLUser  @GCRM-20531
Scenario Outline: verify the opportunity contacts are deleted when the contact is deleted using an INTL user
Given Runmode for "VerifyOppContactAfterDeleteByINTLUser" is Y
Then I do login as "<Nick_Achelles>"
Then I change the app launcher to "<Sales>"
When I navigate to contacts page
Then create a new contact
Then I add new opportunity from opportunity contact related list quick links
Then I logout of any user
Then I do login as "<Nisha_Bansal>"
Then I change the app launcher to "<Sales>"
Then I delete the created contact
Then I logout of any user
Then I do login as "<Nick_Achelles>"
Then I change the app launcher to "<Sales>"
Then I try to open the deleted contact

Examples:
|Nick_Achelles|Sales|Nisha_Bansal|
|Nick_Achelles|Sales|Nisha_Bansal|


#Created By: Ramkaran Singh
@Contacts
@VerifyContactStatusFieldForMHEAdmin @GCRM-21185
Scenario Outline: verify the Contact status field is visible for MHE admin and it is updated with Contact's status value
Given Runmode for "VerifyContactStatusFieldForMHEAdmin" is Y
Then I do login as "<Meghna_Gupta>"
Then I change the app launcher to "<Sales>"
When I navigate to contacts page
Then create a new contact
Then I add new opportunity from opportunity contact related list quick links
Then I open the created opportunity contact and verify contact status field

Examples:
|Meghna_Gupta|Sales|
|Meghna_Gupta|Sales|


#Created By: Ramkaran Singh
@Contacts
@VerifyUserIsAbleToEditContactObject @GCRM-19349 @GCRM-17651
Scenario Outline: Verify users for profiles are able to edit the field on the contact object
Given Runmode for "VerifyUserIsAbleToEditContactObject" is Y
Then I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
When I navigate to contacts page
Then create a contact by Admin profile for CSOM Lightning Console
Then verify the contact record is editable or not

Examples:
|MHHE_Business_Admin|MHHE|
|Jaime_Klar|MHHE|

#Created By: Ramkaran Singh
@Contacts
@VerifyContactExternalField @GCRM-17657
Scenario Outline: Verify users for profiles are able to edit the field on the contact object
Given Runmode for "VerifyContactExternalField" is Y
Then I do login as "<MHHE_Business_Admin>"
#Then I change the app launcher to "<Contact_External>"
Then verify the external contact name can be update or not

Examples:
|MHHE_Business_Admin|
|Jaime_Klar|


#Created By: Ramkaran Singh
@Contacts
@VerifyExcludeMKTOFieldIsVisible @GCRM-20230
Scenario Outline: Verify users for profiles are able to edit the field on the contact object
Given Runmode for "VerifyExcludeMKTOFieldIsVisible" is Y
Then I do login as "<Nisha_Bansal>"
Then I change the app launcher to "<MHEI>"
When I navigate to contacts page
Then create a new contact
Then I verify the Exclude from MKTO SFDC Sync field
Then I logout of any user
Then I do login as "<Jaime_Klar>"
Then I change the app launcher to "<MHHE>"
When I navigate to contacts page
Then create a contact by Admin profile for CSOM Lightning Console
Then I verify the Exclude from MKTO SFDC Sync field
Then I logout of any user
Then I do login as classic "<Meg_Boyer>"
Then I verify the Exclude from MKTO SFDC Sync field in classic mode
Then I logout of any classic user
Then I do login as classic "<Steven_Tutunick>"
Then I verify the Exclude from MKTO SFDC Sync field in classic
Then I logout of any classic user

Examples:
|Nisha_Bansal|MHEI|Jaime_Klar|MHHE|Meg_Boyer|Steven_Tutunick|
|Nisha_Bansal|MHEI|Jaime_Klar|MHHE|Meg_Boyer|Steven_Tutunick|

@Accounts @MHHESalesRepViewCustomLinks @GCRM-9168
Scenario Outline: Verify MHHE Sales Rep is able to view custom links
	Given Runmode for "MHHESalesRepViewCustomLinks" is Y
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for accounts
	Then Verify Custom Links
Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|