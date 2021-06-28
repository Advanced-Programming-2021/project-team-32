package app.model.Battle;

import app.model.Cards.Card;

import java.util.Random;

public class BattleCard {
    private static final Random rand = new Random();
    private final String id;
    private final Card card;

    public BattleCard(String username, Card card) {
        this.id = username + "-" + card.getName() + "-" + rand.nextInt(10000000);
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }
}
