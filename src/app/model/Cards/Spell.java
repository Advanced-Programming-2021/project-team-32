package app.model.Cards;

import app.model.CardTypes.CardType;
import app.model.CardTypes.SpellType;

public class Spell extends Card{
    String icon;
    String status;
    public Spell(String name,String icon ,String description,String status ,int price) {
        super(CardType.SPELL, name, description, price);
        this.status = status;
        this.icon = icon;
    }//Name,Type ,Icon (Property),Description,Status,Price
}
