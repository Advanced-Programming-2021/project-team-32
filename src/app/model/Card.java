package app.model;

import java.util.List;

public class Card {
    private int id;
    private String name;
    private TypeCard type;
    private int attack;
    private int defence;
    private int price;
    private String description;
    private boolean buy; // to show if the card is sell or not
    private StatusCardInTurn statusCardInTurn;
    private Place place;
    private boolean isHidden;

    //constructor
    public Card() {
    }

    public StatusCardInTurn getStatusCardInTurn() {
        return statusCardInTurn;
    }

    public void setStatusCardInTurn(StatusCardInTurn statusCardInTurn) {
        this.statusCardInTurn = statusCardInTurn;
    }

    public Place getPlace() {
        return place;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    //get and set
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //methods
    // to show my cards
    public void showAllCards(List<Card> cards){
        for (Card card : cards) {
                System.out.println(card.getName() + " : " + card.getDescription());
        }
    }

    // to show the description of one card
    public void showCard(Card card){
        System.out.println(card.getName());
        System.out.println(card.getDescription());
        System.out.println(card.getAttack());
        System.out.println(card.getDefence());
        System.out.println(card.getPrice());
    }



}
