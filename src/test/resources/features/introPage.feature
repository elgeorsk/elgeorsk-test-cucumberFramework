Feature: Check Intro Page

  Scenario: This scenario is to check login existence on home page
    Given Navigate to swiggy url
    When Pages is loaded
    Then Validate the existence of "Login" text

  Scenario: This scenario is to check signup existence on home page
    Given Navigate to swiggy url
    When Pages is loaded
    Then Validate the existence of "signup" text