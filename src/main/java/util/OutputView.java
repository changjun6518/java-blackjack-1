package util;

import card.Card;
import gamePlayer.GamePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printResult(List<GamePlayer> winner) {
        if (winner.isEmpty()) {
            System.out.println("승자가 없습니다");
            return;
        }
        if (winner.size() == 2) {
            System.out.println("동점입니다!");
            return;
        }
        System.out.println(winner.get(0).getName() + " 승리하였습니다");

    }

    public static void printCards(GamePlayer player) {
        System.out.print(player.getName() + " : ");
        for (Card card : player.getCard()) {
            System.out.print(card + " ");
        }
        System.out.println("합계 : " + player.sum());
    }
}
