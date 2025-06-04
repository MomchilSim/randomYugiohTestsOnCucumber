package org.Yugioh;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class DeckCreationSteps {
    private final DeckService deckService = new DeckService();
    private boolean hasPermission;
    private boolean creationResult;
    private boolean isValid;

    private String currentDeckName;

    @Given("a user {int} creates a deck named {string} with {int} cards")
    public void aUserCreatesADeckWithCards(int isUser, String deckName, int cardCount){
        this.hasPermission = isUser == 1;
        this.currentDeckName = deckName;

        if (!hasPermission) {
            creationResult = false;
            return;
        }

        creationResult = deckService.createDeck(deckName, "TestUser");

        if (creationResult) {
            for (int i = 0; i < cardCount; i++) {
                String cardName = "Card" + (i % 10); // simulate duplicates
                Card card = new Card(cardName, 1000 + i, 1000 + i, 4);
                deckService.addCardToDeck(deckName, card);
            }
        }
    }
@When("the user adds {int} cards to the deck")
    public void theUserAddsCardsToTheDeck(int cardCount) {
        if (!hasPermission || !creationResult) return;
        //this should work with ids of existing cards
        for (int i = 0; i < cardCount; i++) {
            String cardName = "Card" + (i % 10); // Repeats card names, tests 3-copy limit
            Card card = new Card(cardName, 1000 + i, 1000 + i, 4);
            deckService.addCardToDeck(currentDeckName, card);
        }
    }

    @Then("the system returns deck validity as {string}")
    public void theSystemReturnsDeckValidityAs(String expected) {
        if (!hasPermission || !creationResult) {
            isValid = false;
        } else {
            isValid = deckService.validateDeck(currentDeckName);
        }

        assertEquals(Boolean.parseBoolean(expected), isValid);
    }
}
