#All the below scripts are created by Siva
Feature: confirm A3K Customer Support users can create new case of Smarty Ants record type

Background:
  Given I am logged into salesforce for "FSLSalesRepCreateWO_PreSales"

@A3K @A3KCases @A3KUserCreateNewCaseOfSmartyAntsType @GCRM-16618 @GCRM-16621 @GCRM-16627 @GCRM-16644 @GCRM-16659 @GCRM-16704 @GCRM-16707 @GCRM-16709 @GCRM-17628
Scenario Outline: confirm A3K Customer Support users can create new case of Smarty Ants record type
  Given Runmode for "A3KUserCreateNewCaseOfSmartyAntsType" is Y
  Then I do login as "<A3K_Customer_Support>"
  And I change the app launcher to "A3K Customer Support"
  When I navigate to "Cases" tab
  And create new Smarty Ants record type case
  |STANFORD UNIVERSITY|Automation Test|
  And confirm case related list fields
  And confirm case fields are added up correctly
  And confirm case can be transferred
  |A3K Smarty Ants|Dannial Huang|
  And close the A3K case
  And verify Supplemental Tier field
  And verify functionality of Junk Case Button
  And verify functionality of Create Contact Button
  Examples:
    |A3K_Customer_Support|
    |Julianne_Bonilla|

@A3K @A3KCases @VerifyAppPermissionsofA3KUser @GCRM-17628
Scenario Outline: Verify App Permissions of A3K User
  Given Runmode for "VerifyAppPermissionsofA3KUser" is Y
  Then I do login as "<A3K_Customer_Support>"
  And I change the app launcher to "A3K Customer Support"
  When I navigate to existing A3K case record
  Then verify app permissions for A3K user
  When I navigate to "Accounts" tab
  When I navigate to "Cases" tab
  When I navigate to "Chatter" tab
  When I navigate to "Contacts" tab
  #When I navigate to "Leads" tab
  When I navigate to "Opportunities" tab
  Examples:
    |A3K_Customer_Support|
    |Julianne_Bonilla|

@A3K @A3KCases @VerifyA3KRecordTypesAndStatusPicklist @GCRM-16620 @GCRM-16641
Scenario Outline: verify record types are set up
  Given Runmode for "VerifyA3KRecordTypesAndStatusPicklist" is Y
	Then I do login as "<A3K_Customer_Support>"
  And I change the app launcher to "A3K Customer Support"
  When I navigate to "Cases" tab
  And verify A3k record types
  |A3K Accounts Receivable|A3K Commission Questions|A3K Customer Support|A3K Customer Support - Training|A3K Data Provisioning|A3K International Customer Support|A3K Preferred Support|A3K Smarty Ants|A3K Suggestions|
  And verify A3k record status picklist values
  |Child to Escalated Parent|Closed - Duplicate|Escalated CS|Escalated Dev|Escalated to Achieve3000 Math/Actively Learn|Extensive Dev Work Time|In Progress|New|Open|Pending|Ready for QA|Response Received|Waiting on Approval/Approval Forms|Waiting on Customer|Waiting on Internal|Waiting on Third Party|Closed|
  Examples:
    |A3K_Customer_Support|
    |Julianne_Bonilla|

@A3K @A3KCases @VerifyA3KCaseCateogryPicklistValues @GCRM-23711
Scenario Outline: verify record types are set up
  Given Runmode for "VerifyA3KCaseCateogryPicklistValues" is Y
	Then I do login as "<Blended_Service_and_Sales>"
  And I change the app launcher to "Sales"
  When I navigate to "Cases" tab
  And create A3K Accounts Receivable type case
  |Royal Manor Elementary School|Testing|
  And close A3K Accounts Receivable type case 
Examples:
  |Blended_Service_and_Sales|
  |Halene_Holland|
    
@A3K @A3KCases @VerifyCaseRequiredFieldsForDiffRecordTypes @GCRM-16644
Scenario Outline: Verify case required fields are correct
  Given Runmode for "VerifyCaseRequiredFieldsForDiffRecordTypes" is Y
  Then I do login as "<A3K_Customer_Support>"
  And I change the app launcher to "A3K Customer Support"
  When I navigate to "Cases" tab
  And choose case <Record_Type> and verify required fields
  Examples:
    |A3K_Customer_Support|Record_Type|
    |Julianne_Bonilla|"A3K Customer Support"|
    |Julianne_Bonilla|"A3K Customer Support - Training"|
    |Julianne_Bonilla|"A3K International Customer Support"|
    |Julianne_Bonilla|"A3K Preferred Support"|
    |Julianne_Bonilla|"A3K Suggestions"|
    |Julianne_Bonilla|"A3K Data Provisioning"|
    
@A3K @A3KCases @ValidateJIRAIssueCreationFromA3KSupportCase @GCRM-16654
Scenario Outline: validate jira issue is created correctly from A3K customer support case
  Given Runmode for "ValidateJIRAIssueCreationFromA3KSupportCase" is Y
  Then I do login as "<A3K_Customer_Support>"
  And I change the app launcher to "A3K Customer Support"
  When I navigate to existing A3K case record
  Then verify JIRA issue creation from A3K support case
  And confirm the JIRA issue creation and verify its fields
  Examples:
    |A3K_Customer_Support|
    |Julianne_Bonilla|
    
@A3K @A3KCases @ConfirmfunctionalityofNewCSbutton @GCRM-22971
Scenario Outline: Confirm functionality of New CS button
  Given Runmode for "ConfirmfunctionalityofNewCSbutton" is Y
  Then I do login as "<A3K_Customer_Support>"
  And I change the app launcher to "A3K Customer Support"
  When I navigate to "Contacts" tab
	And verify the New CS button functionality
	And confirm the account and contact name on the case matches what was on the contact record
  Examples:
    |A3K_Customer_Support|
    |Julianne_Bonilla|
    
@A3K @A3KCases @SEGSalesOperationsUserCreatesDAGCases @GCRM-17640 @GCRM-20826
Scenario Outline: Confirm SEG Sales Operations can create DAG Cases
  Given Runmode for "SEGSalesOperationsUserCreatesDAGCases" is Y
  Then I do login as "<Blended_Service_and_Sales>"
  Then I navigate to salesapplication
  When I navigate to "Cases" tab
	And create new DAG Sales Support type case
	And verify Sub Reason field is required when Request Reason is Quoting
	And verify A3K and DAG record type flipping
  Examples:
    |Blended_Service_and_Sales|
    |Halene_Holland|

#Notes : A3K CS Close Cases button has been renamed as Change Status button
@A3K @A3KCases @VerifyA3KCSCloseCasesButtonFunctionality @GCRM-17630 @GCRM-17631
Scenario Outline: Verify A3K CS Close Cases button functionality
  Given Runmode for "VerifyA3KCSCloseCasesButtonFunctionality" is Y
  Then I do login as "<A3K_Customer_Support>"
  And I change the app launcher to "A3K Customer Support"
  When I navigate to "Cases" tab
	And verify the A3K CS Close Cases button functionality
	And verify the A3K Change Owner button functionality
  Examples:
    |A3K_Customer_Support|
    |Julianne_Bonilla|