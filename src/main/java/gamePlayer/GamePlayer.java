package gamePlayer;

import card.Card;

import java.util.ArrayList;

public abstract class GamePlayer {
    ArrayList<Card> cards = new ArrayList<>();
    int count = 0;

    public void draw(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCard() {
        return cards;
    }

    public void sum() {
        for (Card card : cards) {
            count += card.getNumber().getNumber();
        }
    }
}
