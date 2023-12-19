Feature: Validate the metrics unit tab and its functionalities

  Background:
    Given launch the browser
    And load the url

 @test1
    Scenario Outline: To verify that the amount of carbohydrate intake is calculated based on metric units
      Given user is present on the metric units page by default
      And user clicks on "clear" button
      Then user enters the <age> in the "age" field
      And user enters the <height> in the "height" field
      And user enters the <weight> in the "weight" field
      And user selects the <activity_value> in the activity field
      When user clicks on "calculate" button
      Then user is displayed with detailed results

      Examples:
      |age|height|weight|activity_value|
      |25 |188   |80    |1.465         |
      |30 |178   |100   |1.9           |
      |45 |170   |67    |1.2           |

  @test2
      Scenario Outline: To validate the error messages in metric units when the fields are left blank
        Given user is present on the metric units page by default
        And user clicks on "clear" button
        When user clicks on "calculate" button
        Then user verifies the "<errorMessage1>" for not entering "age"
        Then user verifies the "<errorMessage2>" for not entering "height"
        Then user verifies the "<errorMessage3>" for not entering "weight"
        Then user enters the <age> in the "age" field
        And user enters the <height> in the "height" field
        And user enters the <weight> in the "weight" field
        And user selects the <activity_value> in the activity field
        When user clicks on "calculate" button
        Then user is displayed with detailed results

        Examples:
          |age|height|weight|activity_value|errorMessage1|errorMessage2|errorMessage3|
          |25 |188   |80    |1.465         |Please provide an age between 18 and 80.|Please provide positive height value.|Please provide positive weight value.|