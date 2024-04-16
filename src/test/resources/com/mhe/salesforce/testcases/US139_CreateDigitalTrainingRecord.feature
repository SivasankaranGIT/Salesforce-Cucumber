#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature:  Create a digital training record from Contact page

Background: 
	Given I am logged into salesforce for "CreateDigitalTrainingRecord" 
	
	
@DigitalTrainings
@CreateDigitalTrainingRecord @GCRM-9011
Scenario Outline: Create a digital training record from Contact page

	Given Runmode for "CreateDigitalTrainingRecord" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_National_Sales_Manager>"
#	When Navigate to digital training screen
	And create new digital training record
	Then Verify digital training record created

	Examples:
	|MHHE_National_Sales_Manager|
	|Cassie_Cannon|