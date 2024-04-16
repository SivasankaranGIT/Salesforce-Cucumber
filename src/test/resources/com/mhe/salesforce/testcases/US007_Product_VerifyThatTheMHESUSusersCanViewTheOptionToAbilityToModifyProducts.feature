#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Product_VerifyThatTheMHESUSusersCanViewTheOptionToAbilityToModifyProducts

Background: 
	Given I am logged into salesforce for "MHESViewOptionToModProd" 
	
	
@Products
@US_TC02_US_Product_VerifyThatTheMHESUSusersCanViewTheOptionToAbilityToModifyProducts @GCRM-9279
Scenario Outline: Product_VerifyThatTheMHESUSusersCanViewTheOptionToAbilityToModifyProducts

	Given Runmode for "MHESViewOptionToModProd" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
  When I click sales Ref user details to navigate Sales
	When I get the Account Name
	And Edit Opportunities details Product related
	
	Examples: 
	|MHHE_Sales_Representative|
	|Danielle_Snyder|