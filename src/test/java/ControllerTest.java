import card.CardFactory;
import card.Deck;
import gamePlayer.Dealer;
import gamePlayer.GamePlayer;
import gamePlayer.Player;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import util.Calculator;
import util.OutputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    @Before
    public void setup() {
        String input = "chang1212 1 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void flow_test() throws Exception{
        // given
//        String userName = InputView.getUserName();
        String userName = "chang";

        Player player = new Player(userName);
        Dealer dealer = new Dealer("dealer");
        Deck deck = new Deck(CardFactory.generateDeck());
        Calculator calculator = new Calculator();

        // when
        player.draw(deck.pop());
        dealer.draw(deck.pop());
        player.draw(deck.pop());
        dealer.draw(deck.pop());
        OutputView.printCards(player);
        OutputView.printCards(dealer);

        if (dealer.isLessThan16()) {
            dealer.draw(deck.pop());
            OutputView.printCards(dealer);
        }

//        String drawSign = "1";
//        do {
//            drawSign = InputView.getDrawCard();
//            player.draw(deck.pop());
//            OutputView.printCards(player);
//        } while (drawSign.equals("1"));


        // then

        List<GamePlayer> winner = calculator.decideWinner(player, dealer);
        OutputView.printResult(winner);

    }
}