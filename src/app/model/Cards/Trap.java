package app.model.Cards;

import app.model.CardTypes.CardType;

public class Trap extends Card {
    String icon;
    String status;
    public Trap(String name,String icon ,String description,String status ,int price) {
        super(CardType.TRAP, name, description, price);
        this.status = status;
        this.icon = icon;
    }//Name,Type ,Icon (Property),Description,Status,Price
}
