Feature: Verify that the Chatbot is available on the page and it is responding

Background: 
	Given I am logged into salesforce for "VerifyChatBot_ConnectPlatformInstructorPage"

@Chatbot
@VerifyChatBot_ConnectPlatformInstructorPage @GCRM-8466
Scenario Outline: Verify that the Chatbot is available on the page and it is responding
	Given Runmode for "VerifyChatBot_ConnectPlatformInstructorPage" is Y
	Then login into <ConnectPlatform_Instructor_URL> page using <EmaildID> and <Password>
	And verify the CXG chatbot on <ConnectPlatform_Instructor_URL> page
	And close the CXG chatbot page and navigate back to parent page
	Then I logout
	Examples:
	|ConnectPlatform_Instructor_URL   		 |EmaildID					  |Password	 |
	|"https://connectdemo.mheducation.com/"|"eric.nelson@mh.com"|"Connect1"|