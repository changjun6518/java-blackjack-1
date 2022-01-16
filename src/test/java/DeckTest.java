import card.CardFactory;
import card.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeckTest {
    public DeckTest() {
    }

    @Test
    public void 카드_조합_만들기() throws Exception {
        Deck deck = new Deck(CardFactory.generateDeck());

        Assertions.assertEquals(52, deck.getCardList().size());
    }
}