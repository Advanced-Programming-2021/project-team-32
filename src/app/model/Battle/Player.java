package app.model.Battle;

import app.model.User;

import java.util.ArrayList;

public class Player {
    private int LP;
    private User user;
    private ArrayList<BattleCard> remainedCards;
    private ArrayList<BattleCard> handCards;

    public Player(int LP, User user, ArrayList<BattleCard> remainedCards, ArrayList<BattleCard> handCards) {
        this.LP = LP;
        this.user = user;
        this.remainedCards = remainedCards;
        this.handCards = handCards;
    }

    public ArrayList<BattleCard> getHandCards() {
        return handCards;
    }
}
