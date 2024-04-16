Feature: Verify that the Chatbot is available on the page and it is responding

Background: 
	Given I am logged into salesforce for "VerifyChatBot_DTSCommunityPage"

@Chatbot
@VerifyChatBot_DTSCommunityPage @GCRM-8466 @GCRM-8944
Scenario Outline: Verify that the Chatbot is available on the page and it is responding
	Given Runmode for "VerifyChatBot_DTSCommunityPage" is Y
	Then Open <DTS_Community_URL> page
	And verify the "DTS" chatbot on <DTS_Community_URL> page
	Examples:
	|DTS_Community_URL												|
	|"https://mh--uat.sandbox.my.site.com/DTS"|