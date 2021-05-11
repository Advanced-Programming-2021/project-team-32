package src.main.clases;

public class Card {
    private int id;
    private String name;
    private TypeCard type;
    private int attack;
    private int defence;
    private int price;
    private String description;
    private boolean buy; // to show if the card is sell or not

    //constructor
    public Card() {
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
    public void showAllCards(){}

    // to show the description of one card
    public void showCard(){}

    //
    public void buyCard(){}

    public void showShowCards(){}

}
