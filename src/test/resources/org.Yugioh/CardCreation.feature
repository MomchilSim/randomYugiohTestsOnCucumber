Feature: CreatingACard

  Scenario: Creating An Invalid Card
    Given "1" opens card creation screen
    When enters into atk "-200"
    And enters into def "200"
    And enters into level "7"
    And user clicks the create card button
    Then user receives message "Invalid atk"

  Scenario Outline: Creating a card
    Given <user> opens card creation screen
    When enters into atk <atk>
    And enters into def <def>
    And enters into level <level>
    And user clicks the create card button
    Then user receives message <message>
    Examples:
      | user | atk  | def  | level | message|
      | "1"    | "2500" | "2100" | "7"     | "Card successfully created"          |
      | "1"    | "3000" | "2500" | "8"     | "Card successfully created"          |
      | "1"    | "500"  | "500"  | "2"     | "Card successfully created"          |
      | "1"    | "-100" | "1500" | "4"     | "Invalid atk"                        |
      | "1"    | "2000" | "-500" | "5"     | "Invalid def"                        |
      | "1"    | "1500" | "1000" | "0"     | "Invalid level"                      |
      | "1"    | "-100" | "1000" | "3"     | "Invalid atk"                        |
      | "0"    | "9999" | "9999" | "12"    | "Permission denied"                  |
