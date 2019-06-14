package com.company;

public class ID {
   public Object pointer;
   public String id;

   public ID(String id) {
      this.id = id;
   }

   public void addPointer(Object pointer) {
      this.pointer = pointer;
   }

   @Override
   public String toString() {
      return "ID: " + id;
   }
}
