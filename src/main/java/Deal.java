/* "copied" from https://docs.oracle.com/javase/8/docs/technotes/guides/language/enums.html */
import java.util.*;

/* Maybe this should be refactored to have a Hand class which would be an ArrayList<Card> */
public class Deal {
    private int numHands = 1;
    private int cardsPerHand = 1;

    public Deal(int numHands, int cardsPerHand) {
        this.numHands = numHands;
        this.cardsPerHand = cardsPerHand;
    }
    public static void main(String args[]) {
        Deal game = new Deal(4,5);
        List<Card> deck  = Card.newDeck();

        // wha? witchcraft??
        //Collections.shuffle(deck);
        // Use this if you want to make sure you get a random shuffle each time.

        // or if I wanted to make sure I got the SAME cards each time
        // in order to TEST a game using a Deck and the Hands built from it...
        // I can force the order of the cards by setting the Random seed used when shuffling
        // I pick any integer... I used 102
        // first card in first hand should be five of hearts... every time
        Collections.shuffle(deck, new Random(102));

        // generate a list of list of card
        ArrayList<ArrayList<Card>> hands = new ArrayList<>();
        for (int i=0; i < game.numHands; i++)
            hands.add(deal(deck, game.cardsPerHand));

        // print them out.
        for (List<Card> hand: hands) {
            System.out.print("[ ");
            for (Card card: hand) {
                System.out.print(card.toString()+", ");
            }
            System.out.println("]");

        }

        for (List<Card> hand: hands) {
            System.out.print("[ ");
            for (Card card: hand) {
                System.out.print(card.shortString()+", ");
            }
            System.out.println("]");

        }
    }

    public static ArrayList<Card> deal(List<Card> deck, int n) {
        int deckSize = deck.size();
        List<Card> handView = deck.subList(deckSize-n, deckSize);
        ArrayList<Card> hand = new ArrayList<Card>(handView);
        handView.clear();
        return hand;
    }
}
