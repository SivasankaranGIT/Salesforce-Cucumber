Feature: MHHEsubmitProductException

Background: 
	Given I am logged into salesforce for "MHHEsubmitProductException" 
	
	
@MHHEsubmitProductException
Scenario Outline: MHHEsubmitProductException

	Given Runmode for "MHHEsubmitProductException" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And create product Exceptio request MHHE
	Then I logout of any user

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|
  
	
	

	