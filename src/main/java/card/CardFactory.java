package card;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {

    public static List<Card> generateDeck() {
        List<Card> cardList = new ArrayList<>();
        for (Number number : Number.values()) {
            for (Pattern pattern : Pattern.values()) {
                Card card = new Card(number, pattern);
                cardList.add(card);
            }
        }
        return cardList;
    }
}