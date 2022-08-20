Feature: EditLead

Background: Positive login
Given Enter the user name 'demosalesmanager'
And Enter the password 'crmsfa'
And click on login
Then the user home page should be displayed.

Scenario Outline: Edit different leads
Given Click on CRMSFA edt
And Click on leads tab
And Click on findLeads shortcut
And Search leadID as <leadID>
And Click on findLeads button
And Click on resultingLead
When Click on editLead
And Update CompanyName as <companyName>
And Update FirstName as <firstName>
And Update LastName as <lastName>
And Click on update button
Then verify the ViewLeadsPageEdt

Examples:
|leadID|companyName|firstName|lastName|
|10992|Aston|Lance|Stroll|
|10994|Haas|Mick|Shumi|
