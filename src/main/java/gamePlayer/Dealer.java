package gamePlayer;

public class Dealer extends GamePlayer {
    public Dealer(String name) {
        super(name);
    }

    public boolean isLessThan16() {
        sum();
        return count <= 16;
    }
}
