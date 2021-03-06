package com.company;
import java.util.LinkedList;

public class Card implements Cloneable {
   public String title;
   public LinkedList<String> rules;
   public String artID; //this may be subject to change in order to better reflect how we connect each card to its art.
   public LinkedList<String> traits;
   public Cardstate s;
   public ID id;

   /**
    * Generates a card from the mode's information. (Currently STUB)
    */
   /**
   public static Card generateCard(String title, Mode m, String ID) {
      //Looks at the JSON file (eventually...)
      return new Card(title, new LinkedList<Rule>(), 0, new LinkedList<TraitType>(), ID);
   }

   private Card(String title, LinkedList<Rule> rules, int artID, LinkedList<TraitType> traits, String ID) {
      this.title = title;
      this.rules = rules;
      this.artID = artID;
      this.traits = traits;
      this.ID = ID;
   }
    */

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

}
