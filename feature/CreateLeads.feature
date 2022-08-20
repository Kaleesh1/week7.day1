Feature: CreateLeads

Background: Positive login
Given Enter the user name 'demosalesmanager'
And Enter the password 'crmsfa'
And click on login
Then the user home page should be displayed.

Scenario Outline: Create different leads
Given Click on CRMSFA
And Click on CreateLead shortcut
When Enter CompanyName as <companyName>
And Enter FirstName as <firstName>
And Enter LastName as <lastName>
And Click on createLead button
Then verify the ViewLeadsPage

Examples:
|companyName|firstName|lastName|
|Alpine|Estaben|Ocon|
|Aston|Seb|Vettel|