import java.io.*;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import language.src.Parser;
import language.src.Interpreter;

/**
 * The top level class which handles communication between the local gamestate and
 * other connections (central server, other players, etc.)
 */
public class Network {
   private HashMap<String, Mode> loadedModes;
   private HashMap<String, Gamestate> runningGamestates;
   private static String lastGeneratedID;

   public static void main(String[] args) throws IOException, ParseException {
      System.out.println("Starting Network...");
      Network n = new Network();
      //Chooses a testing mode and makes an gamestate of that mode.
      Mode m = n.loadMode(pickMode());
      System.out.println(m);
   }

   public Network() {
      loadedModes = new HashMap<String, Mode>();
      runningGamestates = new HashMap<String, Gamestate>();
      lastGeneratedID = "";
   }

   public static File pickMode() {
      File f = null;
      final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      int rv = fc.showOpenDialog(null);
      if (rv == JFileChooser.APPROVE_OPTION) {
         f = fc.getSelectedFile();
      }
      return f;
   }

   /**
    * Loads the mode specified.
    */
   public Mode loadMode(File f) throws InvalidPathException, IOException, ParseException {
      Reader reader;
      try {
         reader = new FileReader(f);
      } catch (FileNotFoundException e) {
         System.out.println("File not found when loading mode...");
         return null;
      }
//    Reading in the Json file
      Interpreter i = new Interpreter();
      Parser p = new Parser();
      JSONObject jo = (JSONObject)new JSONParser().parse(reader);
      String modeName = (String)jo.get("modeName");
      int numPlayers = Integer.parseInt((String)jo.get("numPlayers"));
      HashMap<String,Trait> traits = i.interpretTraits((HashMap)jo.get("traits"));
      HashMap<String,Slot> slots = i.interpretSlots((HashMap)jo.get("slots"));
      ArrayList<Card> cards = i.interpretCards((HashMap)jo.get("cards"));




      return new Mode()
   }

   /**
    * Generates a generic String ID which can be used for gamestates, slots, cards, etc.
    * such that there are never any duplicated IDs.
    * @return Unique String ID.
    */
   public static String generateNextID() {
      lastGeneratedID = generateNextID(lastGeneratedID);
      return lastGeneratedID;
   }

   private static String generateNextID(String lastID) {
      if (lastID.equals("")) return "0";
      if (lastID.charAt(lastID.length() - 1) == 'o') {
         return generateNextID(lastID.substring(0, lastID.length() - 1)) + "0";
      } else {
         return lastID.substring(0, lastID.length() - 1) + (char) ((int) lastID.charAt(lastID.length() - 1) + 1);
      }
   }

   public Gamestate startGamestate(Mode m) {
      Gamestate i = new Gamestate(m, generateNextID());
      runningGamestates.put(lastGeneratedID, i);
      return i;
   }
}
