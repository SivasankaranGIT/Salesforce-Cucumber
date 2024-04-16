#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESSalesRepIsAbleToCreateNewAccountAddressesFromWithinAnAccount

Background: 
       Given I am logged into salesforce for "MHESRepCreateAccountAddress" 
       
 
@Accounts      
@TS01_TC08_VerifyThatMHESSalesRepIsAbleToCreateNewAccountAddressesFromWithinAnAccount @GCRM-9023
Scenario Outline: VerifyThatMHESSalesRepIsAbleToCreateNewAccountAddressesFromWithinAnAccount

       Given Runmode for "MHESRepCreateAccountAddress" is Y
#       Then I login as Sales Rep
       Then I do login as "<MHHE_Sales_Representative>"
       When I click sales Ref user Accounts to Proceed
       #And I select required search criteria for global search dropdown
       #Then click on Lead based on Search
       And Account Name click proceed new Address MHHE
       And I enter and save all the Address details

       Examples:
       |MHHE_Sales_Representative|
       |Haley_Loebig|