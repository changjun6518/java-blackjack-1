import card.Card;
import card.CardFactory;
import card.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ApplicationTest {

    @Test
    public void 카드_조합_만들기() throws Exception{
        Deck deck = new Deck(CardFactory.generateDeck());

        Assertions.assertEquals(52, deck.getCardList().size());
    }

}