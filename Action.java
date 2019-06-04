package com.company;
import java.util.HashMap;

/**
 * Defines the base actions that can be used in rules for all card games.
 */
public final class Action {

    /**
     * Create a new uniquely identified Zone with a public description of the Zone.
     * @param desc A description of the Zone publically available to players.
     * @return The newly created Zone.
     */
    public static Zone createZone(String desc){
        return new Zone(Network.generateNextID(), desc);
    }

    /**
     * Create a new uniquely identified Zone.
     * @return The newly created Zone.
     */
    public static Zone createZone(){
        return new Zone(Network.generateNextID());
    }

    /**
     * Removes the Zone with a given id.
     * @param zones The collection containing the Zone to be removed.
     * @param id The id to identify which Zone is to be removed.
     * @return Returns true if a Zone was removed and false if there was no matching Zone.
     */
    public static boolean removeZone(HashMap<String, Zone> zones, String id) {
        Zone z = zones.remove(id);
        if (z == null) return false;
        return true;
    }

    /**
     * Creates a new Card with the given title from the given mode.
     * @param title The title of the Card to be created.
     * @param m The mode from which the Card's template should be drawn from.
     * @return The newly created Card.
     */
    public static Card createCard(String title, Mode m){
        return Card.generateCard(title, m, Network.generateNextID());
    }

    /**
     * Removes the Card in the given index from the given Zone.
     * @param z The Zone containing the Card to be removed.
     * @param index The index from which the Card is to be removed.
     */
    public static void removeCard(Zone z, int index){
        z.remove(index);
    }

    /**
     * Moves the Card from one index of one Zone to another.
     * @param zStart The Zone initially containing the Card to be moved.
     * @param indexStart The index of the Card initially.
     * @param zEnd The Zone to where the Card is to be moved.
     * @param indexEnd The index to where the Card is to be moved.
     */
    public static void moveCard(Zone zStart, int indexStart, Zone zEnd, int indexEnd){
        zEnd.insert(zStart.remove(indexStart), indexEnd);
    }



}
