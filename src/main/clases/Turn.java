package src.main.clases;

import java.util.List;

public class Turn {
    private int id;
    private int score;
    private int counter;

    public Turn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    //methods


    // to select card from hand while playing
    public void selectCard(Card card) {
    }

    public void deselectCard(Card card) {
    }

    // to add card to the player's hand every turn and its name
    public Card drawPhase() {
        return null;
    }
    //
    public void standByPhase() {
    }
    //action that taken while playing
    // list because we are making many actions with many cards
    public void mainPhase(List<Card> cards) {
    }
//
    public void battlePhase() {
    }
//
    public void mainPhase2() {
    }
// end turn
    public void endPhase() {
    }
    // to select monster card
    public Card summon(List<Card> cards) {
        return null;
    }

    // to set  card
    public Card set(List<Card> cards) {
        return null;
    }

    // to select the state of the card if it attack or defence
    public void setPosition(Card card) {
    }

    //change from hidden to shown
    public void flipSummon() {
    }

    //to attack monster
    public void attack(Card card) {
    }

    //attack direct
    public void attackDirect(Card card) {
    }

    // to activate magic card
    public void activateEffect(Card card) {
    }

    // to show the cards in the grave no matter
    // if it im my yard or his
    public List<Card> showGraveYard(Place place) {
        return null;
    }

    public void back() {
    }

    public void showCard(Card card) {

    }

    // to end the game
    // esteslam
    public void surrender() {
    }
}
