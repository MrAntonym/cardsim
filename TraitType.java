package com.company;

import java.util.List;
/**
 * Stores a trait such as the suit of a card or the number on its face, but not an effect.
 * A TraitType should only ever be constructed once. If more than one TraitType is constructed
 * with the same name, errors may occur.
 */
public class TraitType {
   public String type;
   public List<String> var;

   /**
    * Constructor for a root TraitType.
    * @param type The type of the TraitType.
    */
   public TraitType(String type) {
      this.type = type;
   }

   /**
    * Constructor for a TraitType with an enumerable type.
    * @param type The name of the type, should be enumerable.
    * @param var The variations of the trait.
    */
   public TraitType(String type, List<String> var) {
      this(type);
      this.var = var;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) return true;
      if (o instanceof TraitType) {
         TraitType traitType = (TraitType) o;
         return this.type.equals(traitType.type);
      } else {
         return false;
      }
   }

   public static Class<?> getType(TraitType traitType) {
      try {
         return Class.forName(traitType.type);
      } catch (ClassNotFoundException e) {
         throw new Error("Invalidly typed trait");
      }
   }

   @Override
   public String toString() {
      return "Type: " + type + "\n" + "Variations: " + var.toString();
   }
}
