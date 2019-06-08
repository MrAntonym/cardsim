import java.util.HashMap;

/**
 * Defines the base actions that can be used in rules for all card games.
 * Formally speaking, an action takes a gamestate as an input and returns a gamestate as an output
 */
public class Action {

    //would it be better to make this an abstract class? Or just to simply expand out on the list of actions?

    /**
     * Create a new uniquely identified Slot.
     * @return The newly created Slot.
     */
    public static Slot createSlot(){
        return new Slot(Network.generateNextID());
    }

    /**
     * Removes the Slot with a given id.
     * @param slots The collection containing the Slot to be removed.
     * @param id The id to identify which Slot is to be removed.
     * @return Returns true if a Slot was removed and false if there was no matching Slot.
     */
    public static boolean removeSlot(HashMap<String, Slot> slots, String id) {
        Slot z = slots.remove(id);
        if (z == null) return false;
        return true;
    }

    /**
     * Creates a new Card with the given title from the given mode.
     * @param title The title of the Card to be created.
     * @param m The mode from which the Card's template should be drawn from.
     * @return The newly created Card.
     */
    public static Card createCard(String title, Mode m){
        try {
            Card c = (Card) m.cards.get(title).clone();
            c.ID = Network.generateNextID();
            c.s = new Cardstate(true, Orientation.UP);
            return c;
        } catch (CloneNotSupportedException e) {
            System.out.println("Card not defined");
            return null;
        }
    }

    /**
     * Removes the Card in the given index from the given Slot.
     * @param z The Slot containing the Card to be removed.
     * @param index The index from which the Card is to be removed.
     */
    public static void removeCard(Slot z, int index){
        z.remove(index);
    }

    /**
     * Moves the Card from one index of one Slot to another.
     * @param zStart The Slot initially containing the Card to be moved.
     * @param indexStart The index of the Card initially.
     * @param zEnd The Slot to where the Card is to be moved.
     * @param indexEnd The index to where the Card is to be moved.
     */
    public static void moveCard(Slot zStart, int indexStart, Slot zEnd, int indexEnd){
        zEnd.insert(zStart.remove(indexStart), indexEnd);
    }

    /**
     * Ends the turn of the current player and begins the next.
     * @param g The current gamestate
     */
    public static void endTurn(Gamestate g){
        g.playerPriority++;
    }



}
