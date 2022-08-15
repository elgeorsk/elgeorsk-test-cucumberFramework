Feature: Launch Swiggy Application

  Scenario: Search restaurants for "Ahmedabad" location
    Given User is on page "https://www.swiggy.com"
    When Location is "Ahmedabad"
    Then Reach restaurants page for "Ahmedabad, Gujarat, India"