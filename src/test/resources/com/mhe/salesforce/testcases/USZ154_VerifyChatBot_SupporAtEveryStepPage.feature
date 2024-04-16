Feature: Verify that the Chatbot is available on the page and it is responding

Background: 
	Given I am logged into salesforce for "VerifyChatBot_SupporAtEveryStepPage"

@Chatbot
@VerifyChatBot_SupporAtEveryStepPage @GCRM-8466
Scenario Outline: Verify that the Chatbot is available on the page and it is responding
	Given Runmode for "VerifyChatBot_SupporAtEveryStepPage" is Y
	Then Open <Instructor_Support_URL> page
	And verify the chatbot on <Instructor_Support_URL> page
	Examples:
	|Instructor_Support_URL																	 |
	|"https://www-qalv.mheducation.com/highered/support.html"|