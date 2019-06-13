import java.util.List;

/**
 * Stores a trait such as the suit of a card or the number on its face, but not an effect.
 * A Trait should only ever be constructed once. If more than one Trait is constructed
 * with the same name, errors may occur.
 */
public class Trait {
   public String type;
   List<String> var;

   /**
    * Constructor for a root Trait.
    * @param type The type of the Trait.
    */
   public Trait(String type) {
      this.type = type;
   }

   /**
    * Constructor for a trait with an enumerable type
    * @param type the name of the trait, should be enumerable
    * @param var the variations of the trait
    */
   public Trait(String type, List<String> var) {
      this.type = type;
      this.var = var;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) return true;
      if (o instanceof Trait) {
         Trait trait = (Trait) o;
         return this.type.equals(trait.type);
      } else if (o instanceof String) {
         return this.type.equals(o);
      } else {
         return false;
      }
   }

   @Override
   public String toString() {
      return type;
   }
}
