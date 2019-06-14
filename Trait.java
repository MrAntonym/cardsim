package com.company;

public class Trait {
   public TraitType traitType;
   public Object variation;
   public Class<?> type;

   public Trait(TraitType traitType, Object variation) {
      this.traitType = traitType;
      this.variation = variation;
      this.type = TraitType.getType(traitType);
   }
}
