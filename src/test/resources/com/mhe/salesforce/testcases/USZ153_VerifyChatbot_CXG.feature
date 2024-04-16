Feature: Verify that the Chatbot is available on the page and it is responding

Background: 
	Given I am logged into salesforce for "VerifyChatBot_CXGCommunityPage"

@Chatbot
@VerifyChatBot_CXGCommunityPage @GCRM-8466
Scenario Outline: Verify that the Chatbot is available on the page and it is responding
	Given Runmode for "VerifyChatBot_CXGCommunityPage" is Y
	Then Open <CXG_Community_URL> page
	And verify the CXG chatbot on <CXG_Community_URL> page
	Examples:
	|CXG_Community_URL												|
	|"https://mh--uat.sandbox.my.site.com/CXG"|