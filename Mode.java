import java.io.*;
import com.google.gson.Gson;
import java.util.*;

public class Mode {
   public String modeName;
   public HashMap<String, Rule> rules;
   public LinkedList<String> slots;
   public HashMap<String, Card> cards;
   public HashMap<String, Trait> traits;
   int numPlayers; // 0 indicates a variable number of players

   public Mode(String modeName, HashMap<String, Rule> rules, LinkedList<String> slots, HashMap<String, Card> cards, HashMap<String, Trait> traits, int numPlayers) {
      this.modeName = modeName;
      this.rules = rules;
      this.slots = slots;
      this.cards = cards;
      this.traits = traits;
      this.numPlayers = numPlayers;
   }

   @Override
   public String toString() {
      return modeName + "\n" + rules.keySet().toString() + "\n" + slots.toString() + "\n" + cards.keySet().toString() + "\n" + traits.keySet().toString();
   }
}
