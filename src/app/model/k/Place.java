package app.model.k;

import java.util.ArrayList;
import java.util.List;

public class Place {
    private int id;
    private TypePlace type;
    private List<Card> cardList = new ArrayList<>();// list of card in place
    private int index;

    //constructor
    public Place() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    //get and set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypePlace getType() {
        return type;
    }

    public void setType(TypePlace type) {
        this.type = type;
    }
}
