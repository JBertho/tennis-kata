Feature: Deuce Rules
  Scenario: Get advantage when score is deuce
    Given start game properties are used
    And score is set to deuce
    When "Maxime" score a point
    Then score is advantage for "Maxime"

  Scenario: Loose advantage
    Given start game properties are used
    And score is set to advantage for "Jimmy"
    When "Maxime" score a point
    Then score is deuce

  Scenario: Loose advantage
    Given start game properties are used
    And score is set to advantage for "Maxime"
    When "Maxime" score a point
    Then "Maxime" win the game
