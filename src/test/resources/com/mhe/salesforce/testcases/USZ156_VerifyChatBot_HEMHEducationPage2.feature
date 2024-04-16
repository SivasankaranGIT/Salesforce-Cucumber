Feature: Verify that the Chatbot is available on the page and it is responding

Background: 
	Given I am logged into salesforce for "VerifyChatBot_HEMHEducationPage2"

@Chatbot
@VerifyChatBot_HEMHEducationPage2 @GCRM-8466
Scenario Outline: Verify that the Chatbot is available on the page and it is responding
	Given Runmode for "VerifyChatBot_HEMHEducationPage2" is Y
	Then Open <HE_MHEducation_URL> page
	And navigate to CXG chatbot page by using support button
	And verify the CXG chatbot on <HE_MHEducation_URL> page
	And close the CXG chatbot page and navigate back to parent page
	Examples:
	|HE_MHEducation_URL																					|
	|"https://www-demo.mheducation.com/highered/home-guest.html"|