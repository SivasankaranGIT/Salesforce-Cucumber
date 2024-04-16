#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Update the Editorial Section on the Opportunity Contact Record page with the MHHE Business & MHHE Contract Admin User

Background: 
	Given I am logged into salesforce for "VerifyEditorialSectionInOppContactByMHHEBusinessAdmin" 

@OpportunitiesNonDependent @VerifyEditorialSectionInOppContactByMHHEBusinessAdmin @GCRM-15921
Scenario Outline: Update the Editorial Section on the Opportunity Contact Record page with the MHHE Business Admin User
	Given Runmode for "VerifyEditorialSectionInOppContactByMHHEBusinessAdmin" is Y
	Then I do login as "<MHHE_Business_Admin>"
	And I change the app launcher to "MHHE"
	When I click sales Ref user details to navigate Sales
	Then MHHE Business Admin create new MHHE type opportunity
	And add new opp <contact> for MHHE Opp
	And verify the editorial section in opp contact
	And edit the editorial section field values
	|DEI Review|Relevancy Module|Live Focus Group|Print|ABA|Testing|

	Examples:
	|MHHE_Business_Admin|contact|
	|Jaime_Klar|"James"|

#This script is dependent on the above script for getting opp URL 'selenium.MHHEOppToTestEditorialSection'
@OpportunitiesNonDependent @VerifyEditorialSectionInOppContactByMHHEContractAdmin @GCRM-15923
Scenario Outline: Update the Editorial Section on the Opportunity Contact Record page with the MHHE Contract Admin User
	Given Runmode for "VerifyEditorialSectionInOppContactByMHHEContractAdmin" is Y
	Then I do login as "<MHHE_Contract_Admin>"
	And I change the app launcher to "MHHE"
	And verify the editorial section in opp contact
	And edit the editorial section field values
	|DEI Review|Relevancy Module|Live Focus Group|Print|ABA|Testing|

	Examples:
	|MHHE_Contract_Admin|
	|Jason_Dai|