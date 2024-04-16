#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the picklist values, categories and hyperlink on Community.

Background:
Given I am logged into salesforce for "VerifypicklistAndLinkOnCommunity"

@Community @VerifypicklistAndLinkOnCommunity @GCRM-17231
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifypicklistAndLinkOnCommunity" is Y
#	Then I login as <Jennifer Ryan>
	Then I do login as "<CSOM_Business_Administrators>"
	When I navigate to "Knowledge" tab and click on New button
	Then I click <Record Type> radio button and click Next
	And Validate dropdown fields    
Examples:
	|Record Type|CSOM_Business_Administrators|
	|"FAQ_Solution"|Jennifer_Ryan|


@Community @VerifyhyperlinkURL @GCRM-17223 @GCRM-18715
Scenario Outline: Verify the hyperlink URL on Community.
 	Given Runmode for "VerifyhyperlinkURL" is Y
	#Then I logout of any user
#	Then I login as <System_Admin>
	Then I do login as "<System_Admin>"
	Then I navigate to salesapplication
	When I navigate to "DTS" tab
	Then I click <DTS Page Segment> button
	Then I click on <Program> link and match the given <URL>	
Examples:
	|Program|URL|DTS Page Segment|System_Admin|
	|"AleksLink"|"https://mh--uat.sandbox.my.site.com/aleks/s/"|"Teachers_Button"|Sivasankaran_Periyasamy|
	|"AchieveMathLink"|"https://achievemath.zendesk.com/hc/en-us"|"Teachers_Button"|Sivasankaran_Periyasamy|
	|"ActivelyLearnLink"|"https://help.activelylearn.com/hc/en-us"|"Teachers_Button"|Sivasankaran_Periyasamy|
	
	
@Community @VerifyAutoRosteredSSOResourcesCategory @GCRM-17228 @GCRM-17226 @GCRM-18723
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifyAutoRosteredSSOResourcesCategory" is Y
	Then I do login as "<CSOM_Business_Administrators>"
	And I change the app launcher to "CSOM Lightning Console"
	When I navigate to "Knowledge" tab and click on New button
	Then I click <Record Type> radio button and click Next
	And fill all mandatory details to create new Knowledge article for <Category> 
	Then I edit the category segment to <New Category> and publish the article
	Then I logout of any user
	Then I do login as "<System_Administrator>"
	When I navigate to "DTS" tab
	Then I click <DTS Page Segment> button
	Then I click <DTS Page Segment Blade> button
	Then I validate that the article created is present on the webpage	    
Examples:
	|Category|New Category|DTS Page Segment|DTS Page Segment Blade|Record Type|CSOM_Business_Administrators|System_Administrator|
	|"CategoryName1"|"newCategory1"|"Tech&MobileFAQ_button"|"roster_Btn"|"FAQ_Solution"|Jennifer_Ryan|Sivasankaran_Periyasamy|
	|"CategoryName2"|"newCategory2"|"AssignmentSync&GradePassback_button"|"DTSPageElementBlade2"|"FAQ_Solution"|Jennifer_Ryan|Sivasankaran_Periyasamy|
	|"CategoryName3"|"newCategory3"|"Login&PsswrdHelp_button"|"mcGrawhill_Btn"|"FAQ_Solution"|Jennifer_Ryan|Sivasankaran_Periyasamy|


@CommunitySKIP @VerifytheInternalCodeRequestForm @GCRM-17103
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifytheInternalCodeRequestForm" is Y
#	Then I login as <System Admin>
	Then I do login as "<System_Administrator>"
	And I change the app launcher to "MHHE"
	Then I click on <Link> and select <Form>
	Then I click on picklist <Request Type> and select option <Request Name>
	Then I click on picklist <Business Unit> and select option <Business Unit Name>
	And I filled the form
	Then global search for cases for <Case Created>
	And I validate the Requestor Name in Case    
Examples:
	|Link|Form|Request Type|Request Name|Business Unit|Business Unit Name|Case Created|System_Administrator|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName"|"BusinessUnit"|"BusinessUnitName"|"Bulk License Extension"|Sivasankaran_Periyasamy|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName"|"BusinessUnit"|"BusinessUnitName1"|"Bulk License Extension"|Sivasankaran_Periyasamy|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName"|"BusinessUnit"|"BusinessUnitName2"|"Bulk License Extension"|Sivasankaran_Periyasamy|


@CommunitySKIP @VerifytheInternalCodeRequestForm @GCRM-17107 @GCRM-17111
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifytheInternalCodeRequestForm" is Y
#	Then I login as <System Admin>
	Then I do login as "<System_Administrator>"
	And I change the app launcher to "MHHE"
	Then I click on <Link> and select <Form>
	Then I click on picklist <Request Type> and select option <Request Name>
	Then I click on picklist <Business Unit> and select option <Business Unit Name>
	And I filled the form
	Then global search for cases for <Case Created>
	And I validate the <Case Origin>, <Incident>, <Sub Incident> and <Subject> in Case  
Examples:
	|Link|Form|Request Type|Request Name|Business Unit|Business Unit Name|Case Created|Case Origin|Incident|Sub Incident|Subject|System_Administrator|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName"|"BusinessUnit"|"BusinessUnitName"|"Bulk License Extension"|"CaseOrigin1"|"Incident1"|"SubIncident2"|"Subject2"|Sivasankaran_Periyasamy|
	

@CommunitySKIP @VerifytheInternalCodeRequestFormforCodeDeactivationRequest @GCRM-17111
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifytheInternalCodeRequestFormforCodeDeactivationRequest" is Y
#	Then I login as <System Admin>
	Then I do login as "<System_Administrator>"
	And I change the app launcher to "MHHE"
	Then I click on <Link> and select <Form>
	Then I click on picklist <Request Type> and select option <Request Name>
	And I filled the form
	Then global search for cases for <Case Created>
	And I validate the <Case Origin>, <Incident>, <Sub Incident> and <Subject> in Case
Examples:
	|Link|Form|Request Type|Request Name|Case Created|Case Origin|Incident|Sub Incident|Subject|System_Administrator|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName2"|"Code Deactivation"|"CaseOrigin1"|"Incident1"|"SubIncident1"|"Subject1"|Sivasankaran_Periyasamy|
	
	
@CommunitySKIP @VerifytheInternalCodeRequestFormforSIMnet @GCRM-17115 @GCRM-17111
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifytheInternalCodeRequestFormforSIMnet" is Y
#	Then I login as <System Admin>
	Then I do login as "<System_Admin>"
	And I change the app launcher to "MHHE"
	Then I click on <Link> and select <Form>
	Then I click on picklist <Request Type> and select option <Request Name>
	And I filled the form
	Then global search for cases for <Case Created>
	And I validate the <Case Origin>, <Incident>, <Sub Incident> and <Subject> in Case
	And I validate the Requestor Name in Case
Examples:
	|Link|Form|Request Type|Request Name|Business Unit|Business Unit Name|Case Created|Case Origin|Incident|Sub Incident|Subject|System_Admin|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName3"|"BusinessUnit"|"BusinessUnitName"|"Simnet"|"CaseOrigin1"|"Incident1"|"SubIncident3"|"Subject3"|Sivasankaran_Periyasamy|
	
@CommunitySKIP @VerifytheInternalCodeRequestFormforCodeReq @GCRM-17123 @GCRM-17111
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifytheInternalCodeRequestFormforCodeReq" is Y
#	Then I login as <System Admin>
	Then I do login as "<System_Admin>"
	And I change the app launcher to "MHHE"
	Then I click on <Link> and select <Form>
	Then I click on picklist <Request Type> and select option <Request Name>
	Then I click on picklist <Business Unit> and select option <Business Unit Name>
	And I filled the complete form
	Then global search for cases for <Case Created>
	And I validate the <Case Origin>, <Incident>, <Sub Incident> and <Subject> in Case
	And I validate the Requestor Name in Case
Examples:
	|Link|Form|Request Type|Request Name|Business Unit|Business Unit Name|Case Created|Case Origin|Incident|Sub Incident|Subject|System_Admin|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName4"|"BusinessUnit"|"BusinessUnitName"|"Anatomy_Physiology_Revealed"|"CaseOrigin1"|"Incident1"|"SubIncident3"|"Subject3"|Sivasankaran_Periyasamy|
	
	
@CommunitySKIP @VerifytheInternalCodeRequestFormforCartridgeReq @GCRM-17127 @GCRM-17111
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifytheInternalCodeRequestFormforCartridgeReq" is Y
#	Then I login as <System Admin>
	Then I do login as "<System_Admin>"
	And I change the app launcher to "MHHE"
	Then I click on <Link> and select <Form>
	Then I click on picklist <Request Type> and select option <Request Name>
	And I filled the complete form
	Then global search for cases created for Cartridge Request
	And I validate the <Case Origin>, <Incident>, <Sub Incident> and <Subject> in Case
	And I validate the Requestor Name in Case
Examples:
	|Link|Form|Request Type|Request Name|Case Origin|Incident|Sub Incident|Subject|System_Admin|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName5"|"CaseOrigin1"|"Incident2"|"SubIncident4"|"Subject3"|Sivasankaran_Periyasamy|
	
	
@CommunitySKIP @VerifytheInternalCodeRequestFormforLicenseRemoval @GCRM-17132 @GCRM-17111
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "VerifytheInternalCodeRequestFormforLicenseRemoval" is Y
#	Then I login as <System Admin>
	Then I do login as "<System_Admin>"
	And I change the app launcher to "MHHE"
#	When I navigate to "MHHE" tab
	Then I click on <Link> and select <Form>
	Then I click on picklist <Request Type> and select option <Request Name>
	And I filled the complete form
	Then global search for cases for <Case Created>
	And I validate the <Case Origin>, <Incident>, <Sub Incident> and <Subject> in Case
	And I validate the Requestor Name in Case
Examples:
	|Link|Form|Request Type|Request Name|Case Created|Case Origin|Incident|Sub Incident|Subject|System_Admin|
	|"MHHELinks"|"InternalCodeRequestFormLink"|"RequestType"|"RequestTypeName6"|"Anatomy_Physiology_Revealed"|"CaseOrigin1"|"Incident3"|"SubIncident5"|"Subject3"|Sivasankaran_Periyasamy|
		
	
#Created By: Suraj Kumar
@Community @VerifyCommunityPageBlades @GCRM-20715 @GCRM-20717 @GCRM-20695
Scenario: Verify the blades of all the Login & Password help and Administrators Setup, Licenses & Reporting button are arranged in Alphabetical order
	Given Runmode for "VerifyCommunityPageBlades" is Y
	Then go to DTS community page and verify the blades
	|User Guides|Tools & Resources|Dashboard & Navigation Overview|FAQs|Reset Password|
	Then verify blades are arranged through quick link for Administration
	|Access Manager|BUIP (Bulk User Import Process)|Canvas|Licenses|Reporting|User Management|Auto-Rostered/SSO Resources|Error Messages|McGraw Hill Plus/NWEA|Simplified Login|SSO Resources|
	Then verify article is arranged as per blade in alphabetical order
	
		
@Community @LiveAgentChatAleksCommunity @GCRM-17084 @GCRM-16410 @GCRM-17084
Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
 	Given Runmode for "LiveAgentChatAleksCommunity" is Y
#	Then I login as <James Galvez>
	Then I do login as "<ALEKS_CSR>"
	And Make the omni channel available for cases and chats and open <ALEKS_Community_URL> page
	And verify the Aleks Live Agent on web page for <Country>
#	Then I login as <James Galvez>
	Then verify the case <origin> and <business_hours>
Examples:
	|Country|ALEKS_CSR|ALEKS_Community_URL|origin|business_hours|
	|"USRegion"|James_Galvez|"https://mh--uat.sandbox.my.site.com/aleks/s/"|"Chat"|"ALEKS Support"|
	|"CanadaLink"|James_Galvez|"https://mh--uat.sandbox.my.site.com/aleks/s/"|"Chat - CANADA"|"ALEKS Support"|
	

#@Community @LiveAgentChatAleksCommunity_US_Canada @GCRM-16410
#Scenario Outline: Verify the Case Origin Created From ALEKS Chat Community Chatbot
#	Given Runmode for "LiveAgentChatAleksCommunity_US_Canada" is Y
#	Then I login as <James Galvez>
#	And Make the omni channel available for cases and chats and open <ALEKS_Community_URL> page
#	And verify the Aleks Live Agent on web page for <Country>
#	Then I login as <James Galvez>
#	Then verify the case origin
#	|Chat|ALEKS Support|
#	Then I login as <James Galvez>
#	And Make the omni channel available for cases and chat <ALEKS_Community_URL> page
##	And verify the Aleks Live Agent on web pages for <Country1>
#	And verify the Aleks Live Agent on web page for <Country1>
#	Then I login as <James Galvez>
#	Then verify the case origin
#	|Chat - CANADA|ALEKS Support|
#Examples:
#	|Country1|Country|System Admin|James Galvez|ALEKS_Community_URL|
#	|"CanadaLink"|"USRegion"|"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F005O8000005CndBIAS%3Fnoredirect%3D1%26isUserEntityOverride%3D1%26retURL%3D%252Fsetup%252Fhome"|"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F005C0000008AxPS%3Fnoredirect%3D1%26isUserEntityOverride%3D1"|"https://mh--uat.sandbox.my.site.com/aleks/s/"|

#@Community @BusinessHoursAleksCommunities @GCRM-17084
#Scenario Outline: Verify the picklist values, categories and hyperlink on Community.
#	Given Runmode for "BusinessHoursAleksCommunities" is Y
#	Then I login as <James Galvez>
#	And Make the omni channel available for cases and chats and open <ALEKS_Community_URL> page
#	Then verify the ALEKS business hours <Country>
#Examples:
#	|Country|System Admin|James Galvez|ALEKS_Community_URL|
#	|"USRegion"|"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F005O8000005CndBIAS%3Fnoredirect%3D1%26isUserEntityOverride%3D1%26retURL%3D%252Fsetup%252Fhome"|"https://mh--uat.sandbox.lightning.force.com/lightning/setup/ManageUsers/page?address=%2F005C0000008AxPS%3Fnoredirect%3D1%26isUserEntityOverride%3D1"|"https://mh--uat.sandbox.my.site.com/aleks/s/"|


#Created By: Siva Sanakran    
@A3K @A3KCases @VerifyA3KCustomerSupportChatFunctionality @GCRM-17632 @GCRM-21918
Scenario Outline: Confirm A3K Customer Support Chat is working
  Given Runmode for "VerifyA3KCustomerSupportChatFunctionality" is Y
  Then I do login as "<A3K_Customer_Support>"
  And I change the app launcher to "A3K Customer Support Console"
  And Make the omni channel available for cases and chat <A3K_Web_Chat> page
  When I navigate to "Omni Supervisor" tab
  And verify current User can see the online agent assigned to A3K Chats queue
Examples:
  |A3K_Customer_Support|A3K_Web_Chat|
  |Julianne_Bonilla|"https://mh--uat--c.sandbox.vf.force.com/apex/A3K_Web_Chat"|   
  
	
@Community @LiveAgentChatCXGCommunity @GCRM-17207 @GCRM-16697
Scenario Outline: Verify the Case Origin of the case created from CXG community Chatbot
	Given Runmode for "LiveAgentChatCXGCommunity" is Y
	Then I do login as "<CXG_Agent>"
	And Make the omni channel available for cases and chats
	|https://mh--uat.sandbox.my.site.com/CXG/s/|
	And verify the CXG Live Agent on web page
	Then verify the case <origin> and <business_hours>
Examples:
	|CXG_Agent|origin|business_hours|
	|Jocelyn_Duterte|"Chat"|"CXG"|
    
    
#Created By: Ramkaran Singh
@Community @UnresponsiveChatLEX @GCRM-16560
Scenario Outline: Confirm case can be closed by using the Unresponsive Chat LEX button
	Given Runmode for "UnresponsiveChatLEX" is Y
	Then I do login as "<CXG_Agent>"
	And Make the omni channel available for cases and chats
	|https://mh--uat.sandbox.my.site.com/CXG/s/|
	Then create chat with live agent
	Then close the case with Unresponsive chat Lex button
Examples:
	|CXG_Agent|
	|Jocelyn_Duterte|
