Feature: Verify that the Chatbot is available on the page and it is responding

Background: 
	Given I am logged into salesforce for "VerifyChatBot_K12MHEducationPage"


@VerifyChatBot_K12MHEducationPage @GCRM-8466
Scenario Outline: Verify that the Chatbot is available on the page and it is responding
	Given Runmode for "VerifyChatBot_K12MHEducationPage" is Y
	Then Open <PreK12_FindProductsAndProgramsPage_URL> page
	And verify the CXG chatbot on <PreK12_FindProductsAndProgramsPage_URL> page
	Examples:
	|PreK12_FindProductsAndProgramsPage_URL										 |
	|"https://www-qalv.mheducation.com/prek-12/home-guest.html"|