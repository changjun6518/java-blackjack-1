package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardLetter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private static final int BUST_LIMIT = 22;
    private static final int NO_ACE = 0;

    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(final Card card) {
        cards.add(card);
    }

    public boolean isBust() {
        return calculateScore() >= BUST_LIMIT;
    }

    public int calculateScore() {
        final int maximumSum = cards.stream()
                .mapToInt(card -> card.getCardLetter().getValue())
                .sum();

        if (maximumSum >= BUST_LIMIT && countAce() > NO_ACE) {
            return adjustScoreWithAce(maximumSum);
        }
        return maximumSum;
    }

    private int countAce() {
        return (int) cards.stream().filter(Card::isAce).count();
    }

    private int adjustScoreWithAce(final int maximumSum) {
        int aceCount = countAce();
        int adjustSum = maximumSum;
        while (aceCount > 0 && adjustSum >= BUST_LIMIT) {
            adjustSum = adjustSum - CardLetter.ACE.getValue() + CardLetter.ACE.getExtraValue();
            aceCount--;
        }
        return adjustSum;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}