Feature: Verify that the Chatbot is available on the page and it is responding

Background: 
	Given I am logged into salesforce for "VerifyChatBot_ConnectPlatformRegistrationPage"


@VerifyChatBot_ConnectPlatformRegistrationPage @GCRM-8466
Scenario Outline: Verify that the Chatbot is available on the page and it is responding
	Given Runmode for "VerifyChatBot_ConnectPlatformRegistrationPage" is Y
	Then Open <Course_Registration_URL> page
	And navigate to CXG chatbot page by using Help link
	And verify the CXG chatbot on <Course_Registration_URL> page
	And close the CXG chatbot page and navigate back to parent page
#	Then I logout
	Examples:
	|Course_Registration_URL																							 |
	|"https://connectqalv.mheducation.com/class/m-narravula-test1260141020"|