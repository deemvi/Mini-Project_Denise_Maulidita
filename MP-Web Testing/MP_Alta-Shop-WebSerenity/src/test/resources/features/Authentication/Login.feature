Feature: Login
    As a user
    I want to log in to my account
    So that I can access my account

    Background:
        Given I am on the login page


    Scenario: As a user I can login with registered account
        When I input username
        And I input password
        And I click login button for registered account
        Then I am on the homepage

    Scenario: As a user I can not login with unregistered account
        When I input unregistered email
        And I input unregistered password
        And I click login button for unregistered account
        Then I can see error message "Record  Not Found"