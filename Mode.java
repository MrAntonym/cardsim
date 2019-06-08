import java.io.*;
import com.google.gson.Gson;
import java.util.*;

public class Mode {
   public String modeName;
   public HashMap<String, Rule> rules;
   public LinkedList<String> slots;
   public HashMap<String, Card> cards;
   public HashMap<String, Trait> traits;

   public Mode() {}

   @Override
   public String toString() {
      return modeName + "\n" + rules.keySet().toString() + "\n" + slots.toString() + "\n" + cards.keySet().toString() + "\n" + traits.keySet().toString();
   }
}
