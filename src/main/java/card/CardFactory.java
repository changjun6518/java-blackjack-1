package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardFactory {

    public static Stack<Card> generateDeck() {
        Stack<Card> cardList = new Stack<>();
        for (Number number : Number.values()) {
            for (Pattern pattern : Pattern.values()) {
                Card card = new Card(number, pattern);
                cardList.add(card);
            }
        }
        Collections.shuffle(cardList);
        return cardList;
    }

}