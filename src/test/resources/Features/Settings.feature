Feature: To validate the settings menu and body fat percentage

  Background:
    Given launch the browser
    And load the url
@test3
  Scenario Outline: To verify that the settings menu is expanded and user gives the body fat percentage
    Given user is present on the metric units page by default
    And user clicks on "clear" button
    Then user enters the <age> in the "age" field
    And user enters the <height> in the "height" field
    And user enters the <weight> in the "weight" field
    And user selects the <activity_value> in the activity field
    When user clicks on "settings" button
    Then user verifies the options displayed under settings
    And used clicks on "Katch-McArdle" radio button
    And user enters the <body-fat> in the "body fat" field
    When user clicks on "calculate" button
    Then user is displayed with detailed results

    Examples:
      |age|height|weight|activity_value|body-fat|
      |25 |188   |80    |1.465         |30     |