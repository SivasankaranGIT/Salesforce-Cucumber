Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToEditAnExistingStrategyWorksheet

Background: 
	Given I am logged into salesforce for "MHHEEditStrategyWorksheet" 
	
	
@US_TS01_TC06_VerifyThatMHHESalesRepAndMarketingUserIsAbleToEditAnExistingStrategyWorksheet
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToEditAnExistingStrategyWorksheet

	Given Runmode for "MHHEEditStrategyWorksheet" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
  When I click sales Ref user details to navigate Sales
	And Opportunities WorkSheet Validation
#	Then I logout of any user

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|
  
	
	

	