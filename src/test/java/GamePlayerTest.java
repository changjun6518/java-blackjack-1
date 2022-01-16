import card.Card;
import card.CardFactory;
import card.Deck;
import gamePlayer.Dealer;
import gamePlayer.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GamePlayerTest {
    public GamePlayerTest() {
    }

    @Test
    public void player_draw_card() throws Exception {
        // given
        Player player = new Player("chang");
        Dealer dealer = new Dealer("dealer");
        Deck deck = new Deck(CardFactory.generateDeck());

        // when
        player.draw(deck.pop());
        player.draw(deck.pop());
        dealer.draw(deck.pop());
        dealer.draw(deck.pop());

        // then
        ArrayList<Card> cards = player.getCard();
        ArrayList<Card> cards1 = dealer.getCard();

        Assertions.assertEquals(2, cards.size());
        Assertions.assertEquals(2, cards1.size());
    }

    @Test
    public void stack_test() throws Exception {
        // given
        Stack<String> strings = new Stack<String>();
        strings.push("asd1");
        strings.push("asd2");
        strings.push("asd3");

        // when
        Collections.shuffle(strings);

        // then
        while (!strings.isEmpty()) {
            System.out.println(strings.pop());
        }
    }

    @Test
    public void dealer_draw_when_16_이하() throws Exception{
        // given
        Dealer dealer = new Dealer("dealer");
        Deck deck = new Deck(CardFactory.generateDeck());

        // when
        dealer.draw(deck.pop());
        dealer.draw(deck.pop());

        dealer.sum();
        if (dealer.isLessThan16()) {
            dealer.draw(deck.pop());
        }
        // then
        ArrayList<Card> card1 = dealer.getCard();
        Assertions.assertEquals(3, card1.size());

    }
}