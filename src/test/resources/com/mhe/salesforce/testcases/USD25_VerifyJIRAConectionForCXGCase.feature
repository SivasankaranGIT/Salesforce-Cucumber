#STAND_ALONE_SCRIPT - This script can be executed separately.
    Feature: Verify jira connection is made

    Background:
    Given I am logged into salesforce for "VerifyCaseDetailsForCXGCase"

    @Cases @VerifyCaseDetailsForCXGCase @GCRM-18290 @GCRM-18286
    Scenario Outline: Verify the case details page, creation page, update page from a CXG Contract user

    Given Runmode for "VerifyCaseDetailsForCXGCase" is Y
    Then I do login as "<CXG_Contract_User>"
    Then I navigate to cases
    Then create a new case for CXG
    And I verify Case details
    Then I verify Category Picklist Value
    |Content|Setup & Config|Improvement|
    Then verify edit option for CXG user
    Then I do login as "<CXG_Administrator>"
    Then I navigate to cases
    Then create a new case for CXG
    And I verify Case details
    Then I verify Category Picklist Value
    |Content|Setup & Config|Improvement|
    Then verify edit option for CXG Admin user

    Examples:
      |CXG_Contract_User|CXG_Administrator|
      |Jocelyn_Duterte|Eric_Nelson|


    @Cases @VerifyComponentValueForCXGCase  @GCRM-17189
    Scenario Outline: Verify the Component value 'Connect: Change Point Value' when Category = Platform/Functional
    Given Runmode for "VerifyComponentValueForCXGCase" is Y
    Then I do login as "<CXG_Administrator>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then I verify the component value for case
    Examples:
    |CXG_Administrator|
    |Eric_Nelson|

    @Cases @VerifyProductPicklistvalueForCXGCase  @GCRM-17224
    Scenario Outline: Verify the Product 'Connect2' and 'eLLvate' are not available in the picklist

    Given Runmode for "VerifyProductPicklistvalueForCXGCase" is Y
    Then I do login as "<CXG_Administrator>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then Verify picklist value for Product field

    Examples:
    |CXG_Administrator|
    |Eric_Nelson|

    # Created By : Ramkaran Singh
    @Cases @VerifyJIRAInitialAssignee @GCRM-16978 @GCRM-16982
    Scenario Outline: Verify JIRA Initial Assignee when the Category: Platform/Functional and Component: Connect:Tegrity
    Given Runmode for "VerifyJIRAInitialAssignee" is Y
    Then I do login as "<CXG_Administrator>"
    Then I change the app launcher to "<CXG_Lightning_Console>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then I verify the Jira Initial Assignee
    Then verify other Jira Initial Assignee

    Examples:
    |CXG_Administrator|CXG_Lightning_Console|
    |Eric_Nelson|CXG Lightning Console|


    @Cases @VerifySubProductPicklistvalueForCXGCase @GCRM-17227 @GCRM-25678
    Scenario Outline: Verify when the Product is connect, 2 new sub products Connect2 and eLLevate are available in the picklist
    Given Runmode for "VerifySubProductPicklistvalueForCXGCase" is Y
    Then I do login as "<CXG_Administrator>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then verify sub product picklist value for created case
 		And verify JIRA API Logs related list in case and fields non-editable
 		Then I logout of any user
 		Then I do login as "<System_Administrator>"
 		Then I change the app launcher to "<JIRA_API_Logs>"
 		And verify JIRA API Logs related list in case and fields editable
    Examples:
    |CXG_Administrator|System_Administrator|JIRA_API_Logs|
    |Eric_Nelson|Sivasankaran_Periyasamy|JIRA API Logs|

