Feature: Verify that the Chatbot is available on the page and it is responding

Background: 
	Given I am logged into salesforce for "VerifyChatBot_CSOMCommunityPage"

@Chatbot
@VerifyChatBot_CSOMCommunityPage @GCRM-8945 @GCRM-8944
Scenario Outline: Verify that the Chatbot is available on the page and it is responding
	Given Runmode for "VerifyChatBot_CSOMCommunityPage" is Y
#	Then I logout of any user
	Then Open <CSOM_Community_URL> page
	And verify the "CSOM" chatbot on <CSOM_Community_URL> page
	Examples:
	|CSOM_Community_URL												 |
	|"https://mh--uat.sandbox.my.site.com/CSOM"|