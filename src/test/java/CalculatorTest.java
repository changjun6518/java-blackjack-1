import card.CardFactory;
import card.Deck;
import gamePlayer.Dealer;
import gamePlayer.GamePlayer;
import gamePlayer.Player;
import org.junit.jupiter.api.Test;
import util.Calculator;

import java.util.List;

public class CalculatorTest {
    public CalculatorTest() {
    }

    @Test
    public void calculate_winner() throws Exception {
        // given
        Player player = new Player("chang");
        Dealer dealer = new Dealer("dealer");
        Deck deck = new Deck(CardFactory.generateDeck());
        Calculator calculator = new Calculator();

        // when
        player.draw(deck.pop());
        player.draw(deck.pop());
        dealer.draw(deck.pop());
        dealer.draw(deck.pop());

        if (dealer.isLessThan16()) {
            dealer.draw(deck.pop());
        }

        // then
        List<GamePlayer> winner = calculator.decideWinner(player, dealer);
        if (winner.isEmpty()) {
            System.out.println("승자가 없습니다");
        }
        if (winner.size() == 2) {
            System.out.println("동점입니다!");
        }
        System.out.println(winner.get(0).getName() + " 이 승리하였습니다");

    }
}