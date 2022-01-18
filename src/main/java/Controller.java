import card.CardFactory;
import card.Deck;
import gamePlayer.Dealer;
import gamePlayer.GamePlayer;
import gamePlayer.Player;
import util.Calculator;
import util.InputView;
import util.OutputView;

import java.util.List;

public class Controller {

    private Player player;
    private Deck deck;
    private Dealer dealer;
    private Calculator calculator;


    public void run() {
        init();

        firstDraw();

        extraDrawOnDealer();

        extraDrawOnPlayer();

        decideWinner();
    }

    private void decideWinner() {
        List<GamePlayer> winner = calculator.decideWinner(player, dealer);
        OutputView.printResult(winner);
    }

    private void extraDrawOnPlayer() {
        String drawSign;
        drawSign = InputView.getDrawCard();
        while (drawSign.equals("1")) {
            player.draw(deck.pop());
            OutputView.printCards(player);
            drawSign = InputView.getDrawCard();
        }
    }

    private void extraDrawOnDealer() {
        while (dealer.isLessThan16()) {
            dealer.draw(deck.pop());
            OutputView.printCards(dealer);
        }
    }

    private void firstDraw() {
        player.draw(deck.pop());
        dealer.draw(deck.pop());
        player.draw(deck.pop());
        dealer.draw(deck.pop());
        OutputView.printCards(player);
        OutputView.printCards(dealer);
    }

    private void init() {
        String userName = InputView.getUserName();

        player = new Player(userName);
        dealer = new Dealer("dealer");
        deck = new Deck(CardFactory.generateDeck());
        calculator = new Calculator();
    }
}
