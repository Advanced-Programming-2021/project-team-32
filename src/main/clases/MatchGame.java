package src.main.clases;

public class MatchGame {
    private int id;
    private int playerStarted;

    //constructor
    public MatchGame() {
    }

    //get and set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerStarted() {
        return playerStarted;
    }

    public void setPlayerStarted(int playerStarted) {
        this.playerStarted = playerStarted;
    }

    //methods
    public void startGame(){}

    public void ai(){}

    // to increase my money
    public void increaseMoney(){}

    // to decrease the money of the second player
    public void decreaseMoney(){}

    // to add force card
    public void addForceCard(){}

    // to make me the winner
    public void makeMeWinner(){}

}
