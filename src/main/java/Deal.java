/* "copied" from https://docs.oracle.com/javase/8/docs/technotes/guides/language/enums.html */
import java.util.*;

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
        Collections.shuffle(deck);
        ArrayList<ArrayList<Card>> hands = new ArrayList<>();
        for (int i=0; i < game.numHands; i++)
            hands.add(deal(deck, game.cardsPerHand));

        for (List<Card> hand: hands) {
            System.out.print("[ ");
            for (Card card: hand) {
                System.out.print(card.toString()+", ");
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
