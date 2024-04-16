Feature: Logout from application

 
#
#Background: 
    #Given I am logged into salesforce for "ALEKSAdminCreatesContact" 
    
    
@logout    
Scenario: Logout from application

	Given Runmode for "LogoutTest" is Y 
  Then I logout