import java.util.HashMap;

/**
 * An instance of a particular game
 */
public class Instance {
   public Mode mode;
   public String ID;
   public HashMap<String, Slot> slots;

   public Instance(Mode mode, String ID) {
      this.mode = mode;
      this.ID = ID;
      slots = new HashMap<String, Slot>();
   }

   @Override public String toString() {
      return "Instance with ID: " + ID + " | Using mode: " + mode.toString();
   }
}
