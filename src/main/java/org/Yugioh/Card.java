package org.Yugioh;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Card {
        private String name;
        private int attack;
        private int defense;
        private int level;

        public Card(String name, int attack, int defense, int level) {
            this.name = name;
            this.attack = attack;
            this.defense = defense;
            this.level = level;
        }

}
