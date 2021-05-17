package app.model;

import java.util.ArrayList;
import java.util.List;

public class Box {
    //attributes
    private int id;
    private TypeBox type;
    private int numberCard; // capacity of each deck
    private boolean activate; // this related to the activation of deck
    private List<Card> cardList = new ArrayList<>();
    private String deckName; // name of the box; all decks

    public enum TypeBox {
        ALLCARD,
        DECK,
        FUSIONDECK,
        SIDEDECK;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    // constructor
    public Box() {
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public Box(int id, TypeBox type, int numberCard) {
        this.id = id;
        this.type = type;
        this.numberCard = numberCard;
    }

    // get and set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeBox getType() {
        return type;
    }

    public void setType(TypeBox type) {
        this.type = type;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    //methods
    //this method to remove card from my collection
    public void removeCard(Card card) {
        cardList.remove(card);
    }

    //this method to add card to my collection
    public void addCards(Card card) {
        cardList.add(card);
    }

    //to activate certain deck
    // other wise the deck must not work
    public void deckSetActivate() {
        if (!type.name().equals(TypeBox.ALLCARD)) {
            setActivate(true);
            System.out.println("activate success");
        } else {
            System.out.println("activate failed , this type not activated");
        }
    }
    public void deckSetDeactivate() {
            setActivate(false);
            System.out.println("deactivate success");
    }

    // to show cards in this box
    public void deckShowAllCards() {
        System.out.println("MONSTER:");
        for (Card card : cardList) {
            if (card.getName().equals(TypeCard.MONSTER))
                System.out.println(card.getName() + " : " + card.getDescription());
        }
        System.out.println("MAGIC:");
        for (Card card : cardList) {
            if (card.getName().equals(TypeCard.MAGIC))
                System.out.println(card.getName() + " : " + card.getDescription());
        }
        System.out.println("MERGE:");
        for (Card card : cardList) {
            if (card.getName().equals(TypeCard.MERGE))
                System.out.println(card.getName() + " : " + card.getDescription());
        }
    }


}
