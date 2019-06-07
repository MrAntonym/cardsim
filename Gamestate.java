import java.util.LinkedList;

/**
 * A Gamestate represents the state of an instance of a game.
 */
public class Gamestate {
    LinkedList<Slot> slots;
    LinkedList<Card> cards;
    int playerTurn = 0; //TODO come back when we've figured out how turn rotations work


    public Gamestate(LinkedList<Slot> slots, LinkedList<Card> cards) {
        this.slots = slots;
        this.cards = cards;
    }



}
