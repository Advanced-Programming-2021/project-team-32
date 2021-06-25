package app.model.k;

import java.util.ArrayList;
import java.util.List;

public class ExcelCard {
    List<Card> cardList = new ArrayList<>();

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Card buyCard(Player player, String cardName) {
        if (selectCard(cardName) != null) {
            if (player.getBalance() >= selectCard(cardName).getPrice()) {
                System.out.println("buy success");
                player.getStock().addToAllCard(selectCard(cardName));
                return selectCard(cardName);
            } else {
                System.out.println("not enough money");
                return null;
            }
        }
        return null;
    }

    public void showAllCards() {
        for (Card card : cardList) {
            System.out.println(card.getName() + " : " + card.getDescription());
        }
    }

    public Card selectCard(String cardName) {
        for (Card card : cardList) {
            if (card.getName().equals(cardName)) {
                return card;
            }
        }
        System.out.println("error entry name");
        return null;
    }
}
