package com.company;
import java.util.*;

public class Mode {
   public String modeName;
   public HashMap<String, Rule> rules; //<Rule's name, Rule>
   public HashMap<String, LinkedList<String>> slots; //<playerType, [SlotName, SlotName,...]>
   public HashMap<String, Card> cards; //<Card's name, Card>
   public HashMap<String, TraitType> traits; //<TraitType's name, TraitType>
   public HashMap<String, Integer> playerTypes; //<playerType, number of that playerType in a game>

   public Mode() {}

   public Mode(String modeName, HashMap<String, Rule> rules, HashMap<String, LinkedList<String>> slots, HashMap<String, Card> cards, HashMap<String, TraitType> traits, HashMap<String, Integer> playerTypes) {
      this.modeName = modeName;
      this.rules = rules;
      this.slots = slots;
      this.cards = cards;
      this.traits = traits;
      this.playerTypes = playerTypes;
   }

   @Override
   public String toString() {
      return modeName + "\n" + playerTypes.entrySet().toString() + "\n" + rules.keySet().toString() + "\n" + slots.entrySet().toString() + "\n" + cards.keySet().toString() + "\n" + traits.keySet().toString();
   }
}
