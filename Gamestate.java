import java.util.HashMap;

/**
 * The gamestate of a particular game
 */
public class Gamestate {
   public Mode mode;
   public String ID;
   public HashMap<String, Slot> slots;
   public HashMap<String, Card> cards;
   public int playerPriority;

   public Gamestate(Mode mode, String ID) {
      this.mode = mode;
      this.ID = ID;
      playerPriority = 0;
   }

   @Override public String toString() {
      return "Gamestate with ID: " + ID + " | Using mode: " + mode.toString();
   }
}
