package app.model;

import java.util.List;

public class Turn {
    private int id;
    private int score;
    private int counter;
    private Player player;
    private Round game;

    public Turn() {
    }

    public Round getGame() {
        return game;
    }

    public void setGame(Round game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
    public Card selectCard(List<Card> cards, String cardName) {
        for (Card ca : cards) {
            if (ca.getName().equals(cardName)) {
                return ca;
            }
        }
        return null;
    }

    public void deselectCard(Card card) {
        card = null;
    }

    // to add card to the player's hand every turn and its name
    public void drawPhase(Place hiddenPlace, Place handPlace) {
        Card c = hiddenPlace.getCardList().get(hiddenPlace.getCardList().size() - 1);
        handPlace.getCardList().add(c);
    }

    //
    public void standByPhase() {
        System.out.println(player.getNickName());
    }

    // to select monster card
    public void summon(Card card) {
        card.getPlace().getCardList().remove(card);
        for (Place place : this.getGame().getMat1().getPlaceList()) {
            if (place.getType().equals(TypePlace.MONSTER)) {
                place.getCardList().add(card);
                card.setStatusCardInTurn(StatusCardInTurn.ATTACK);
                card.setPlace(place);
                card.setHidden(true);
            }
        }
    }

    // to set  card
    public void set(Card card) {
        Place magicPlace = null;
        Place monsterPlace = null;
        card.getPlace().getCardList().remove(card);
        for (Place place : this.getGame().getMat1().getPlaceList()) {
            if (place.getType().equals(TypePlace.MAGIC)) {
                magicPlace = place;
                magicPlace.getCardList().add(card);
                card.setPlace(magicPlace);
                card.setHidden(false);
            }
            if (place.getType().equals(TypePlace.MONSTER)) {
                monsterPlace = place;
                monsterPlace.getCardList().add(card);
                card.setPlace(monsterPlace);
                card.setHidden(false);
                card.setStatusCardInTurn(StatusCardInTurn.DEFENCE);
            }
        }
    }

    // to select the state of the card if it attack or defence
    public void setPosition(Card card, Place monsterPlace) {
        if (card.isHidden()) {
            card.setStatusCardInTurn(StatusCardInTurn.ATTACK);
        } else {
            if (card.getStatusCardInTurn().equals(StatusCardInTurn.ATTACK))
                card.setStatusCardInTurn(StatusCardInTurn.DEFENCE);
            else {
                card.setStatusCardInTurn(StatusCardInTurn.ATTACK);
            }
        }
    }

    //change from hidden to shown
    public void flipSummon(Card card) {
        card.setHidden(true);
        card.setStatusCardInTurn(StatusCardInTurn.ATTACK);
    }

    //to attack monster
    public void attack(Card card1, Card card2, Place gravePlace, Place monsterPlace) {
        System.out.println(card1.getName() + " attacked " + card2.getName());
        if (card2.getStatusCardInTurn().equals(StatusCardInTurn.ATTACK)) {
            if (card1.getAttack() > card2.getDefence()) {
                this.getGame().setScore2(this.getGame().getScore2() - (card1.getAttack() - card2.getDefence()));
                monsterPlace.getCardList().remove(card2);
                gravePlace.getCardList().add(card2);
            }
            if (card1.getAttack() == card2.getDefence()) {
                System.out.println(" the attack power is equal to the defence power so both will be removed");
                monsterPlace.getCardList().remove(card1);
                monsterPlace.getCardList().remove(card2);
                gravePlace.getCardList().add(card1);
                gravePlace.getCardList().add(card2);
            }
            if (card1.getAttack() < card2.getDefence()) {
                this.getGame().setScore1(this.getGame().getScore1() - (card2.getDefence() - card1.getAttack()));
                monsterPlace.getCardList().remove(card1);
                gravePlace.getCardList().add(card1);
            }
        }
        if (card2.getStatusCardInTurn().equals(StatusCardInTurn.DEFENCE)) {
            if (card1.getAttack() > card2.getDefence()) {
                monsterPlace.getCardList().remove(card2);
                gravePlace.getCardList().add(card2);
            }
            if (card1.getAttack() < card2.getDefence()) {
                this.getGame().setScore1(this.getGame().getScore1() - (card2.getDefence() - card1.getAttack()));
            }
        }
    }

    //attack direct
    public void attackDirect(Card card, Place cardsInHands) {
        System.out.println(card.getName() + " attacked directly ");
        this.getGame().setScore2(this.getGame().getScore2() - (card.getAttack()));
    }

    // to activate magic card
    public void activateEffect(Card card) {
        if (card.getPlace().getType().equals(TypePlace.INHAND)) {
            Place handPlace = null;
            Place magicPlace = null;
            for (Place place : this.getGame().getMat1().getPlaceList()) {
                if (place.getType().equals(TypePlace.MAGIC)) {
                    magicPlace = place;
                }
                if (place.getType().equals(TypePlace.INHAND)) {
                    handPlace = place;
                }
            }
            selectCard(handPlace.getCardList(), card.getName());
            handPlace.getCardList().remove(card);
            magicPlace.getCardList().add(card);
            card.setHidden(true);
            card.setPlace(magicPlace);
        }
        if (card.getPlace().getType().equals(TypePlace.MAGIC)) {
            card.setHidden(true);
        }
    }

    // to show the cards in the grave no matter
    // if it im my yard or his
    public void showGraveYard(Place place) {
        if (place.getType().equals(TypePlace.GRAVEYARD)) {
            for (Card card : place.getCardList()) {
                System.out.println(card.getName() + " " + card.getDescription());
            }
        }
    }

    public void back() {
    }

    // to end the game
    // esteslam
    public void surrender() {
        this.getGame().setScore1(0);
        System.out.println("you lost");
    }
}
