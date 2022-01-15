package card;

import java.util.List;

public class Deck {
    private final List<Card> cardList;

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }
}
