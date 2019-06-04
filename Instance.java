package com.company;
import java.util.HashMap;

/**
 * An instance of a particular game
 */
public class Instance {
   public Mode mode;
   public String ID;
   public HashMap<String, Zone> zones;

   public Instance(Mode mode, String ID) {
      this.mode = mode;
      this.ID = ID;
      zones = new HashMap<String, Zone>();
   }

   @Override public String toString() {
      return "Instance with ID: " + ID + " | Using mode: " + mode.toString();
   }
}
