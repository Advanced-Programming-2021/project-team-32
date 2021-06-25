package app.model.k;

import java.util.List;
import java.util.Scanner;

public class Round {
    private int id;
    private int playerStarted;
    private Mat mat1;
    private Mat mat2;
    int score1 = 8000;
    int score2 = 8000;

    //constructor
    public Round() {
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public Mat getMat1() {
        return mat1;
    }

    public void setMat1(Mat mat1) {
        this.mat1 = mat1;
    }

    public Mat getMat2() {
        return mat2;
    }

    public void setMat2(Mat mat2) {
        this.mat2 = mat2;
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
    public void startGame() {

    }

    public void ai() {
    }

    // to increase my money
    public void increaseMoney() {
        System.out.println(" enter code money");
        Scanner scan = new Scanner(System.in);
        if (scan.next().equals("increaseMoney")) {
            this.setScore1(8000);
        }

    }

    // to decrease the money of the second player
    public void decreaseMoney() {
        System.out.println(" enter code money");
        Scanner scan = new Scanner(System.in);
        if (scan.next().equals("decreaseMoney")) {
            this.setScore2(100);
        }
    }

    // to add force card
    public Card addForceCard(List<Card> cardList) {
        System.out.println("enter name card");
        Card ca = null;
        Scanner scan = new Scanner(System.in);
        for (Card card : cardList) {
            if (card.getName().equals(scan.next())) {
                ca = card;
            }
        }
        ca.getPlace().getCardList().remove(ca);
        for (Place place : this.getMat1().getPlaceList()) {
            if (place.getType().equals(TypePlace.INHAND)) {
                place.getCardList().add(ca);
            }
        }
        return ca;
    }

    // to make me the winner
    public void makeMeWinner() {
        this.setScore2(0);
        System.out.println("you win");
    }

}
