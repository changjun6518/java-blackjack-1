package card;

public class Card {

    private Number number;
    private Pattern pattern;

    public Card(Number number, Pattern pattern) {
        this.number = number;
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return pattern.toString() + " " + number.getNumber();
    }
}
