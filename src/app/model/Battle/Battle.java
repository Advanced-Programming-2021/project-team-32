package app.model.Battle;

import app.model.User;

public class Battle {
    private Player[] players = new Player[2];
    private BattleField battleField;
    private int selectedAddress;
    private SelectType selectType;

    private int turn;

    public Battle(User currentUser, User secondPlayer, int round) {
    }

    public void select(int selectedAddress, SelectType selectType){
        this.selectType = selectType;
        this.selectedAddress = selectedAddress;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
