Feature: Login
Scenario: Successful Login
  Given I open browser
  And Open website saucedemo
  And Located on saucedemo website
  When I input valid username
  And I input valid password
  Then I go to homepage