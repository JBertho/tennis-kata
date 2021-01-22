Feature: Win a game
  Scenario: Win a game when player score with 'forty' and the other have at least one point less
    Given start game properties are used
    And "Maxime" have "Forty"
    And "Jimmy" have "Fifteen"
    When "Maxime" score a point
    Then "Maxime" win the game


  Scenario: Win a game when score is deuce
    Given start game properties are used
    And "Maxime" have "Forty"
    And "Jimmy" have "Forty"
    When "Maxime" score two points in a row
    Then "Maxime" win the game


