package org.Yugioh;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Deck {

    private final String name;
    private final String ownerUsername;
    private final List<Card> cards;

    public Deck(String name, String ownerUsername) {
        this.name = name;
        this.ownerUsername = ownerUsername;
        this.cards = new ArrayList<>();
    }

    public boolean addCard(Card card) {
        /*if (cards.size() >= 60) {
            return false; // Max deck size
        }
        long count = cards.stream().filter(c -> c.getName().equals(card.getName())).count();
        if (count >= 3) {
            return false; // Limit to 3 copies
        }
        */
        return cards.add(card);
    }

    public boolean removeCard(String cardName) {
        return cards.removeIf(c -> c.getName().equals(cardName));
    }

    public boolean isValid() {
        int size = cards.size();
        return size >= 40 && size <= 60;
    }
}
