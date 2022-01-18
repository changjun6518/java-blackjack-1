package gamePlayer;

import card.Card;

import java.util.ArrayList;

public abstract class GamePlayer {
    protected ArrayList<Card> cards = new ArrayList<>();
    protected String name;
    protected int count = 0;

    public GamePlayer(String name) {
        this.name = name;
    }

    public void draw(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCard() {
        return cards;
    }

    public int sum() {
        count = 0;
        for (Card card : cards) {
            count += card.getNumber().getNumber();
        }
        return count;
    }

    public String getName() {
        return name;
    }
}
