package gamePlayer;

import card.Card;

import java.util.ArrayList;

public abstract class GamePlayer {
    ArrayList<Card> cards = new ArrayList<>();

    public void draw(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCard() {
        return cards;
    }
}
