package app.model;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private int id;
    private List<Box> boxList;

    public Stock(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<Box> boxList) {
        this.boxList = boxList;
    }

    public void setId(int id) {
        this.id = id;
    }

    //methods
    //these methods related to the deck menu

    // to create new deck
    public Box createDeck(String deckName, Box.TypeBox deckType) {
        Box box = new Box();
        box.setDeckName(deckName);
        box.setType(deckType);
        boxList.add(box);
        return box;
    }

    // to delete a deck
    public void deleteDeck(Box box) {
        boxList.remove(box);
    }

    public List<Card> getAllCards() {
        List<Card> allCard = new ArrayList<>();
        for (Box box : boxList) {
            allCard.addAll(box.getCardList());
        }
        return allCard;
    }

    public void showAllCard() {
        System.out.println("MONSTER:");
        for (Card card : getAllCards()) {
            if (card.getType().equals(TypeCard.MONSTER)) {
                System.out.println(card.getName() + " : " + card.getDescription());
            }
        }
        System.out.println("MAGIC:");
        for (Card card : getAllCards()) {
            if (card.getType().equals(TypeCard.MAGIC)) {
                System.out.println(card.getName() + " : " + card.getDescription());
            }
        }
        System.out.println("MERGE:");
        for (Card card : getAllCards()) {
            if (card.getType().equals(TypeCard.MERGE)) {
                System.out.println(card.getName() + " : " + card.getDescription());
            }
        }
    }

    public void showBuyCard() {
        for (Card card : getAllCards()) {
            if (card.isBuy()) {
                System.out.println(card.getName() + " : " + card.getDescription());
            }
        }
    }

    //to show the details only of the decks
    public void decksShowDetails() {
        for (Box box : boxList) {
            String valid = box.isActivate() ? "valid" : "invalid";
            System.out.println(box.getDeckName() + " : " + box.getType() + " " + box.getNumberCard() + "," + valid);
        }
    }

    public Box getBoxByType(Box.TypeBox typeBox) {
        for (Box box : boxList) {
            if (box.getType().equals(typeBox)) {
                return box;
            }
        }
        return null;
    }

    public void addToAllCard(Card card) {
        getBoxByType(Box.TypeBox.ALLCARD).getCardList().add(card);
    }


}
