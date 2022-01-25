import card.CardFactory;
import card.Deck;
import gamePlayer.Dealer;
import gamePlayer.GamePlayer;
import gamePlayer.Player;
import org.junit.jupiter.api.Test;
import util.Calculator;
import util.OutputView;

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
        OutputView.printResult(winner);

    }
}