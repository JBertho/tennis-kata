Feature: gain points

  Scenario: gain point when a player has 'love'
    Given start game properties are used
    And "Jimmy" have "Love"
    And "Maxime" have "Love"
    When "Maxime" score a point
    Then score is "Fifteen - Love for Maxime"

  Scenario: gain point when a player has 'Fifteen'
    Given start game properties are used
    And "Jimmy" have "Love"
    And "Maxime" have "Fifteen"
    When "Maxime" score a point
    Then score is "Thirty - Love for Maxime"


  Scenario: gain point when a player has 'Thirty'
    Given start game properties are used
    And "Jimmy" have "Love"
    And "Maxime" have "Thirty"
    When "Maxime" score a point
    Then score is "Forty - Love for Maxime"

  Scenario: when player have both 'Forty' than score is 'Deuce'
    Given start game properties are used
    And "Jimmy" have "Forty"
    And "Maxime" have "Forty"
    Then score is deuce
