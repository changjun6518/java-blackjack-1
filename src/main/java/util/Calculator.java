package util;

import gamePlayer.GamePlayer;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public List<GamePlayer> decideWinner(GamePlayer player, GamePlayer dealer) {
        int playerSum = player.sum();
        int dealerSum = dealer.sum();
        List<GamePlayer> result = new ArrayList<>();
        if (isLessThan21(playerSum) && isLessThan21(dealerSum)) {
            if (playerSum < dealerSum) {
                result.add(dealer);
            } else if (playerSum > dealerSum) {
                result.add(player);
            } else {
                result.add(player);
                result.add(dealer);
            }
        } else if (isLessThan21(playerSum)) {
            result.add(player);
        } else if (isLessThan21(dealerSum)) {
            result.add(dealer);
        }
        return result;
    }

    private boolean isLessThan21(int sum) {
        return sum <= 21;
    }
}
