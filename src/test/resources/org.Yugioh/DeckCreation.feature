Feature: Deck Creation and Validation

  Scenario Outline: Creating a deck and validating its contents
    Given a user <isUser> creates a deck named "<deckName>" with <cardCount> cards
    Then the system returns deck validity as "<valid>"

    Examples:
      | isUser | deckName     | cardCount | valid  |
      | 1      | DragonStorm  | 40        | true   |
      | 1      | OverLimit    | 65        | false  |
      | 0      | NoPermDeck   | 45        | false  |
      | 1      | SmallDeck    | 10        | false  |
      | 1      | MaxLimit     | 60        | true   |
      | 1      | TripleDeck   | 43        | true   |
      | 1      | ValidDeck   | 40        | true   |