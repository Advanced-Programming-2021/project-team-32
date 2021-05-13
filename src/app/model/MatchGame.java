package src.main.clases;

import java.util.ArrayList;
import java.util.List;

public class MatchGame {
    Player player1;
    Player player2;

    List<Round> roundList = new ArrayList<>();

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public MatchGame startOneRound() {
        MatchGame matchGame = new MatchGame();
        matchGame.getRoundList().add(new Round());
        return matchGame;
    }

    public MatchGame startThreeRound() {
        MatchGame matchGame = new MatchGame();
        matchGame.getRoundList().add(new Round());
        matchGame.getRoundList().add(new Round());
        matchGame.getRoundList().add(new Round());
        return matchGame;
    }
}
