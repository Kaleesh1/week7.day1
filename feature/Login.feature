Feature: Login to the application


Scenario: Positive login
Given Enter the user name 'demosalesmanager'
And Enter the password 'crmsfa'
And click on login
Then the user home page should be displayed.

Scenario: Negative login
Given Enter the user name 'demosalesmanager'
And Enter the password 'crmsfa1'
When click on login
But error message should be displayed for incorrect creds.

