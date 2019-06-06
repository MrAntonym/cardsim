import java.io.*;
import java.nio.file.InvalidPathException;
import java.util.HashSet;

/**
 * The top level class which handles communication between the local gamestate and
 * other connections (central server, other players, etc.)
 */
public class Network {
   private HashSet<Mode> loadedModes;
   private HashSet<Instance> runningInstances;
   private static String lastGeneratedID;

   public static void main(String[] args) {
      System.out.println("Starting Network...");
      Network n = new Network();
      //Chooses a testing mode and makes an instance of that mode.
      System.out.println("Loading null Mode...");
      Mode m = n.loadMode(null);
      System.out.println(m);
      Instance i = n.startInstance(m);
      System.out.println(i);
      Zone z = Action.createZone();
      System.out.println(z);
      i.zones.put(z.ID, z);
   }

   public Network() {
      loadedModes = new HashSet<Mode>();
      runningInstances = new HashSet<Instance>();
      lastGeneratedID = "";
   }

   /**
    * Loads the mode specified.
    */
   public Mode loadMode(String modeFilePath) throws InvalidPathException {
      Mode m;
      try {
         File f = new File(modeFilePath);
         if (f.exists()) {
            m = new Mode(f);
            m.loadData();
         } else throw new InvalidPathException(modeFilePath, "No such mode found.");
      } catch (NullPointerException e) {
         //Loads a blank mode for abstract testing.
         m = new Mode(null);
      }

      loadedModes.add(m);
      return m;
   }

   /**
    * Generates a generic String ID which can be used for instances, zones, cards, etc.
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

   public Instance startInstance(Mode m) {
      Instance i = new Instance(m, generateNextID());
      runningInstances.add(i);
      return i;
   }
}
