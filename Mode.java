package com.company;
import java.io.*;
import com.google.gson.Gson;
import java.util.*;

public class Mode {
   public String modeName;
   public HashMap<String, Rule> rules;
   public LinkedList<String> zones;

   public Mode(String modeName, HashMap<String, Rule> rules, LinkedList<String> zones) {
      this.modeName = modeName;
      this.rules = rules;
      this.zones = zones;
   }

   public Mode() {}

   @Override
   public String toString() {
      return modeName + "\n" + rules.keySet().toString() + "\n" + zones.toString();
   }
}
