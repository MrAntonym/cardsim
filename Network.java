package com.company;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.util.HashMap;

import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.util.Map;

/**
 * The top level class which handles communication between the local gamestate and
 * other connections (central server, other players, etc.)
 */
public class Network {
   private HashMap<ID, Mode> loadedModes;
   private HashMap<ID, Gamestate> runningGamestates;
   private static ID lastGeneratedID;

   public static void main(String[] args) {
      System.out.println("Starting Network...");
      Network n = new Network();
      //Chooses a testing mode and makes an gamestate of that mode.
      Mode m = n.loadMode(pickMode());
      System.out.println("Mode Loaded: \n" + m);
      n.loadedModes.put(Network.generateNextID(), m);
      //Print expanded traits.
      System.out.println("Printing Expanded Traits:");
      for (Map.Entry<String, TraitType> entry : m.traits.entrySet()) {
         String name = entry.getKey();
         TraitType t = entry.getValue();
         System.out.println(name + ":\n\tType: " + t.type + "\n\tVariations: " + t.var.toString());
      }
      //Print expanded rules.
      System.out.println("Printing Expanded Rules:");
      for (Rule r : m.rules.values()) {
         System.out.println("\t" + r.toString());
      }
      //Initialize a new gamestate from Mode m.
      Gamestate gamestate = new Gamestate(m, generateNextID());
      n.runningGamestates.put(gamestate.id, gamestate);
      gamestate.startup();
   }

   public Network() {
      loadedModes = new HashMap<ID, Mode>();
      runningGamestates = new HashMap<ID, Gamestate>();
      lastGeneratedID = new ID("");
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
   public Mode loadMode(File f) throws InvalidPathException {
      Reader reader;
      try {
         reader = new FileReader(f);
      } catch (FileNotFoundException e) {
         System.out.println("File not found when loading mode...");
         return null;
      }
      Mode m = new Gson().fromJson(reader, Mode.class);
      return m;
   }

   /**
    * Generates a generic String ID which can be used for gamestates, slots, cards, etc.
    * such that there are never any duplicated IDs.
    * @return Unique String ID.
    */
   public static ID generateNextID() {
      lastGeneratedID = generateNextID(lastGeneratedID);
      return lastGeneratedID;
   }

   private static ID generateNextID(ID lastID) {
      if (lastID.id.equals("")) return new ID("0");
      if (lastID.id.charAt(lastID.id.length() - 1) == 'o') {
         return new ID(generateNextID(new ID(lastID.id.substring(0, lastID.id.length() - 1))).id + "0");
      } else {
         return new ID(lastID.id.substring(0, lastID.id.length() - 1) + (char) ((int) lastID.id.charAt(lastID.id.length() - 1) + 1));
      }
   }

   public static ID getLastID() {
      return lastGeneratedID;
   }

   public Gamestate startGamestate(Mode m) {
      Gamestate i = new Gamestate(m, generateNextID());
      runningGamestates.put(lastGeneratedID, i);
      return i;
   }
}
