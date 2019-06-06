/**
 * Stores a trait such as the suit of a card or the number on its face, but not an effect.
 * Some traits may be subtraits of other traits and therefore have a superTrait.
 * This relationship can not be traced down, only up to the root.
 * A Trait should only ever be constructed once. If more than one Trait is constructed
 * with the same name, errors may occur.
 */
public class Trait {
   public String type;
   public Trait superTrait;

   /**
    * Constructor for a root Trait.
    * @param type The name of the Trait.
    */
   public Trait(String type) {
      this.type = type;
   }

   /**
    * Constructor for a Trait with a superTrait.
    * @param type The name of this Trait.
    * @param superTrait The superTrait that this Trait is to have.
    */
   public Trait(String type, Trait superTrait) {
      this(type);
      this.superTrait = superTrait;
   }

   @Override
   public boolean equals(Object o) {
      return this == o || this.type.equals(o);
   }

   @Override
   public String toString() {
      return type;
   }
}
