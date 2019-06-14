package com.company;
import com.company.language.Interpreter;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * The gamestate of a particular game
 */
public class Gamestate {
   private Mode mode;
   public ID id;
   public ID universalID;
   public ArrayList<ID> playerIDs;
   public HashMap<ID, HashMap<String, ID>> playerSlotTable; //Takes PlayerID then slotName to get slot ID.
   public HashMap<ID, Slot> slots;
   public HashMap<ID, Card> cards;
   public int playerPriority;
   private Interpreter interpreter;

   public Gamestate(Mode mode, ID id) {
      this.mode = mode;
      this.id = id;
      universalID = Network.generateNextID();
      playerIDs = new ArrayList<ID>();
      playerSlotTable = new HashMap<ID, HashMap<String, ID>>();
      slots = new HashMap<ID, Slot>();
      cards = new HashMap<ID, Card>();
      playerPriority = 0;
      interpreter = new Interpreter(this, mode);
   }

   public void startup() {
      for (Map.Entry<String, Integer> entry : mode.playerTypes.entrySet()) {
         String playerType = entry.getKey();
         int numType = entry.getValue();
         for (int i = 0; i < numType; i++) {
            HashMap<String, ID> slotNames = new HashMap<String, ID>();
            for (String name : mode.slots.get(playerType)) {
               slotNames.put(name, Network.generateNextID());
               slots.put(Network.getLastID(), new Slot(Network.getLastID()));
            }
            playerSlotTable.put(Network.generateNextID(), slotNames);
            playerIDs.add(Network.getLastID());
         }
      }
      if (mode.slots.containsKey("universal")) {
         HashMap<String, ID> slotNames = new HashMap<String, ID>();
         for (String name : mode.slots.get("universal")) {
            slotNames.put(name, Network.generateNextID());
            slots.put(Network.getLastID(), new Slot(Network.getLastID()));
         }
         playerSlotTable.put(universalID, slotNames);
      }
      if (mode.rules.containsKey("startup")) {
         interpreter.run(mode.rules.get("startup"));
      }
   }

   public ID getCurrentPlayerID() {
      return playerIDs.get(playerPriority);
   }

   @Override public String toString() {
      return "Gamestate with " + id.toString() + " | Using mode: " + mode.toString();
   }
}
