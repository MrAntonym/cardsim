package com.company.language;
import com.company.*;

import java.util.Stack;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Takes constructed rules as taken from json and interacts with the gamestate based on them.
 */
public class Interpreter {

   public HashSet<String> reserved = new HashSet<String>(Arrays.asList(new String[]
         {"createCard", "removeCard", "moveCard", "setPriority", "stop", "setCardState", "addCardTrait", "removeCardTrait",
               "addCardRule", "removeCardRule", "+", "*", "/", "%", "abs", "-", "if", "=", ">", "<", "or", "pop", "duplicate"}
         )); //See GitHub wiki for details on the workings of reserved rules.

   private Gamestate gamestate;
   private Stack<Object> stack; //The memory of the interpreter. All objects in the stack should be immutable/unchanging.
   private Mode mode;

   public Interpreter(Gamestate gamestate, Mode mode) {
      this.gamestate = gamestate;
      stack = new Stack<Object>();
      this.mode = mode;
   }

   /**
    * Runs a Rule on the Gamestate.
    * @param r A non-reserved Rule.
    */
   public void run(Rule r) {
      for (String s : r.operation) {
         if (reserved.contains(s)) {
            run(s);
         } else {
            try {
               Integer i = Integer.parseInt(s);
               stack.push(i);
            } catch (NumberFormatException e) {
               if (gamestate.playerSlotTable.get(gamestate.getCurrentPlayerID()).containsKey(s)) {
                  stack.push(gamestate.playerSlotTable.get(gamestate.getCurrentPlayerID()).get(s));
               } else if (mode.cards.containsKey(s)) {
                  stack.push(mode.cards.get(s));
               } else {
                  String[] split = s.trim().split("\\s+");
                  if (mode.traits.containsKey(split[0])) {
                     TraitType t = mode.traits.get(split[0]);
                     Class<?> c = TraitType.getType(t);
                     s = s.substring(s.indexOf(split[0]) + split[0].length()); //remove split[0] from s
                     if (c.equals(String.class)) {
                        stack.push(new Trait(t, s));
                     } else if (c.equals(Integer.class)) {
                        stack.push(new Trait(t, Integer.parseInt(s)));
                     } else if (c.equals(Boolean.class)) {
                        stack.push(new Trait(t, Boolean.parseBoolean(s)));
                     } else if (c.equals(Float.class)) {
                        stack.push(new Trait(t, Float.parseFloat(s)));
                     } else {
                        throw new Error("Trait of unimplemented class");
                     }
                  } else {
                     run(mode.rules.get(s));
                  }
               }
            }
         }
      }
   }

   /**
    * Runs a reserved word Rule on the Gamestate.
    * See GitHub wiki for details on the workings of reserved rules.
    * @param s The name of a reserved Rule.
    */
   public void run(String s) {
      switch (s) {
         //TODO
         case "createCard":
            break;
         case "removeCard":
            break;
         case "moveCard":
            break;
         case "setPriority":
            break;
         case "stop":
            break;
         case "setCardState":
            break;
         case "addCardTrait":
            break;
         case "removeCardTrait":
            break;
         case "addCardRule":
            break;
         case "removeCardRule":
            break;
         case "+":
            break;
         case "*":
            break;
         case "/":
            break;
         case "%":
            break;
         case "abs":
            break;
         case "-":
            break;
         case "if":
            break;
         case "=":
            break;
         case ">":
            break;
         case "<":
            break;
         case "or":
            break;
         case "pop": System.out.println(stack.pop());
            break;
         case "duplicate":
            break;
      }
   }
}
