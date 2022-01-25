package card;

import java.util.List;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cardList;

    public Deck(Stack<Card> cardList) {
        this.cardList = cardList;
    }

    public Stack<Card> getCardList() {
        return cardList;
    }

    public Card pop() {
        return cardList.pop();
    }
}
