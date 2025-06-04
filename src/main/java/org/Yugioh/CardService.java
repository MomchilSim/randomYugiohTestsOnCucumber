package org.Yugioh;

import java.util.ArrayList;
import java.util.List;

public class CardService {

    public Card createCard(User user, String name, int attack, int defense, int level) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Card name cannot be empty");
        }
        if (attack < 0 || defense < 0 || level < 0 || level > 13  && user.getHasPerms()) {
            throw new IllegalArgumentException("Attack, Defense, and Level must be positive");
        }
       return new Card(name, attack, defense, level);
    }
}