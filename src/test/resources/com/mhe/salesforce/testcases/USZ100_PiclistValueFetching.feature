Feature: Picklist Value Fetching Script
    
@PicklistValueFetching   
Scenario Outline: Logout from application

	Given Runmode for "PicklistValueFetching" is Y 
#	Then I login as <UserURL>
  Then I do login as "<MHHE_Business_Administrator>"
  And fetch pick list value

  Examples:
  |MHHE_Business_Administrator|
  ||