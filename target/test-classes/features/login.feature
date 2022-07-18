Feature: Fidexio Login Functionality
  User Story: As a user, I should be able to log in so that I can land on homepage.
  AC1-Users can log in with valid credentials (We have 5 types of users but will test only 2 user: PosManager, SalesManager)
  AC2-"Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
  AC3-"Please fill out this field" message should be displayed if the password or username is empty
  AC4-User land on the ‘reset password’ page after clicking on the "Reset password" link
  AC5-User should see the password in bullet signs by default
  AC6- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.

  Background: The user should be on the login page to be able to use the features on the feature page.
    Given User is on the login page

  @FIDEXI-524
  Scenario Outline: US-001 | TC-001 | Verify that Users can log in with valid credentials
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks the login button
    Then The user should be logged in to the page and see the Odoo title

    Examples: These are the credentials to be entered in the login functionality

      | username                | password     |
      | salesmanager15@info.com | salesmanager |
      | salesmanager21@info.com | salesmanager |
      | salesmanager32@info.com | salesmanager |
      | salesmanager43@info.com | salesmanager |
      | salesmanager54@info.com | salesmanager |
      | posmanager10@info.com   | posmanager   |
      | posmanager20@info.com   | posmanager   |
      | posmanager30@info.com   | posmanager   |
      | posmanager40@info.com   | posmanager   |
      | posmanager50@info.com   | posmanager   |

  @FIDEXI-525 
  Scenario Outline: US-001 | TC-002 | Verify that "Wrong login/password" should be displayed for invalid credentials
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks the login button
    Then The user should see the Wrong login password alert on the page

    Examples: These are the invalid credentials to be entered in the login functionality
      | username                | password     |
      | salesman.com            | salesmanager |
      | salesmanage11@info.com  | salesmanager |
      | salesmanager@info.com   | salesman     |
      | salesmanager13@info.com | manager      |
      | salesmanager19@info.com | lesmanager   |
      | posmanger@info.com      | posmanager   |
      | posmanagerpos@info.com  | posmanager   |
      | posmanager909           | posmanager   |
      | posmanager111@info.com  | posman       |
      | posmanager44@info.com   | manager      |


  @FIDEXI-526 
  Scenario Outline: US-001 | TC-003 | Verify that "Please fill out this field" message should be displayed if the username is empty
    When User enters password "<password>"
    And User clicks the login button
    Then User should see Please fill out this field. message on username input

    Examples:Password list
      | password     |
      | posmanager   |
      | abcdefg      |
      | salesmanager |


  @FIDEXI-527 
  Scenario Outline: US-001 | TC-004 | Verify that "Please fill out this field" message should be displayed if the password is empty
    When User enters username "<username>"
    And User clicks the login button
    Then User should see Please fill out this field. message on password input

    Examples:Username List
      | username                |
      | posmanager10@info.com   |
      | salesmanager15@info.com |
      | aabbccdd@info           |

  @FIDEXI-528 
  Scenario: US-001 | TC-005 | Verify that User land on the ‘reset password’ page after clicking on the "Reset password" link
    When User clicks reset password link
    Then User should land reset password page and should see Reset Password text

  @FIDEXI-529 
  Scenario Outline: US-001 | TC-006 | Verify that User should see the password in bullet signs by default
    When User enters password "<password>"
    Then User should see password as bullet signs

    Examples:Password list
      | password     |
      | posmanager   |
      | abcdefg      |
      | salesmanager |


  @FIDEXI-530 
  Scenario Outline:  US-001 | TC-007 Verify that the 'Enter' key of the keyboard is working correctly on the login page with valid credentials
    When User enters username "<username>"
    When User enters password "<password>"
    And User press Enter key
    Then The user should be logged in to the page and see the Odoo title

    Examples:Username List
      | username                | password     |
      | posmanager25@info.com   | posmanager   |
      | posmanager35@info.com   | posmanager   |
      | salesmanager15@info.com | salesmanager |
      | salesmanager25@info.com | salesmanager |


  @FIDEXI-531 
  Scenario Outline:  US-001 | TC-008 Verify that the 'Enter' key of the keyboard is working correctly on the login page with invalid credentials
    When User enters username "<username>"
    When User enters password "<password>"
    And User press Enter key
    Then The user should see the Wrong login password alert on the page

    Examples:Username List
      | username                  | password    |
      | osmanager1024@info.com    | posmanage   |
      | psmanager@info.com        | posmanage   |
      | alesmanager@info.com      | posmanage   |
      | salesmanage19254@info.com | posmanage   |
      | osmanager1120@info.com    | salesmanage |
      | psmanager2152@info.com    | salesmanage |
      | alesmanager1215@info.com  | salesmanage |
      | salesmanage1449@info.com  | salesmanage |
