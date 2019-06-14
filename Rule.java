package com.company;
import java.util.ArrayList;

/**
 * A rule is a set of actions and other rules which it does in a specified order based on
 * conditionals about the gamestate and player input.
 */
public class Rule {
   public String title; //The unique title of this rule
   public int inputs;
   public ArrayList<String> condition; //The condition when this rule can be acted on directly by the priority player. If this is empty, then this rule CAN NOT be acted on directly.
   public ArrayList<String> operation; //The sequence of operations performed when this rule is triggered. Should only use actions or other rules.

   @Override
   public String toString() {
      String output = title;
      if (inputs == 0) {
         return output;
      } else {
         output += "(";
         for (int i = 0; i < inputs; i++) {
            output += (char) (97 + i);
            if (i + 1 < inputs) output += ", ";
         }
         output += ")";
         return output;
      }
   }
}
