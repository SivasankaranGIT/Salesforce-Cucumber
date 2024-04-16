Feature: MHEERequestforDiscount

Background: 
	Given I am logged into salesforce for "MHEERequestforDiscount" 
	
	
#@OpportunitiesDependent
@MHEERequestforDiscount @GCRM-8978
Scenario Outline: MHEERequestforDiscount

	Given Runmode for "MHEERequestforDiscount" is Y
#	Then I login as Sales Rep
  Then I do login as "<MHHE_Sales_Representative>"
  Then I navigate to opportunity tab
  Then MHHE create new opportunity
  And MHHE Navigate to products section
  Then MHHE Addproduct to opportunity
  Then MHHE Request discount for opportunity product
  Then MHHE verify approval history
  Then I logout of any user
	And Login as different US user
  Then MHHE Delete Opp

  Examples:
  |MHHE_Sales_Representative|
  |Danielle_Snyder|