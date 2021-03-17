/* "copied" from https://docs.oracle.com/javase/8/docs/technotes/guides/language/enums.html */
import java.util.*;

public class Card {
    public enum Rank { DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    private final Rank rank;
    private final Suit suit;
    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() { return rank; }
    public Suit suit() { return suit; }
    public String toString() { return rank + " of " + suit; }

    private static final List<Card> protoDeck = new ArrayList<Card>();

    // Initialize prototype deck
    static {
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                protoDeck.add(new Card(rank, suit));
    }

    public static ArrayList<Card> newDeck() {
        return new ArrayList<Card>(protoDeck); // Return copy of prototype deck
    }

    public String shortString() {
        String n = "";
        String s = "";
        switch(suit) { // UNICODE - look it up
            case CLUBS: s = "\u2663";
                break;
            case DIAMONDS: s = "\u2666";
                break;
            case HEARTS: s = "\u2665";
                break;
            case SPADES: s = "\u2660";
                break;
        }
        switch(rank) {
            case DEUCE: n = "2";
                break;
            case THREE: n = "3";
                break;
            case FOUR: n = "4";
                break;
            case FIVE: n = "5";
                break;
            case SIX: n = "6";
                break;
            case SEVEN: n = "7";
                break;
            case EIGHT: n = "8";
                break;
            case NINE:  n = "9";
                break;
            case TEN: n = "10";
                break;
            case JACK: n = "J";
                break;
            case QUEEN: n = "Q";
                break;
            case KING: n = "K";
                break;
            case ACE: n = "A";
                break;
        }
        return n+s;
    }

}