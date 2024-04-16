Feature: MHEcreateanewquote

Background: 
	Given I am logged into salesforce for "MHEcreateanewquote" 
	
	
@MHEcreateanewquote
Scenario: MHEcreateanewquote

	Given Runmode for "MHEcreateanewquote" is Y
	Then I login as Sales Rep
  When I click sales Ref user details to navigate Sales
	And MHE create a new quote
	Then I logout of any user
  
	
	

	