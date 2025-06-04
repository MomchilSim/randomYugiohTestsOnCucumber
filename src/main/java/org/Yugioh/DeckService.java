package org.Yugioh;
import java.util.HashMap;
import java.util.Map;

public class DeckService {

    private Map<String, Deck> decks = new HashMap<>();

    public boolean createDeck(String name, String ownerUsername) {
        if (decks.containsKey(name)) {
            return false; // Duplicate deck name
        }
        decks.put(name, new Deck(name, ownerUsername));
        return true;
    }

    public Deck getDeck(String name) {
        return decks.get(name);
    }

    public void addCardToDeck(String deckName, Card card) {
        Deck deck = decks.get(deckName);
        if (deck == null) return;
        deck.addCard(card);
    }

    public boolean removeCardFromDeck(String deckName, String cardName) {
        Deck deck = decks.get(deckName);
        if (deck == null) return false;
        return deck.removeCard(cardName);
    }

    public boolean validateDeck(String deckName) {
        Deck deck = decks.get(deckName);
        return deck != null && deck.isValid();
    }

    public boolean deleteDeck(String name) {
        return decks.remove(name) != null;
    }
}