package com.company;
import java.util.ArrayList;
import java.util.List;

public class Zone {
    //String descriptor;
    String ID;
    List<Card> cards = new ArrayList<>();

    /**
     * Creates a Zone with a descriptor.
     * @param descriptor The description of the Zone.
     * @param id The unique id of the Zone.
     */
    //public Zone(String id, String descriptor){
    //    this(id);
    //    this.descriptor = descriptor;
    //}

    /**
     * Creates a Zone without a descriptor.
     * @param id The unique id of the Zone.
     */
    public Zone(String id){
        this.ID = id;
    //    descriptor = "";
    }


    /**
     * Creates a Zone with a descriptor and a list of Cards already in the Zone.
     * @param descriptor The description of the Zone.
     * @param cards The Cards to be already in the Zone.
     * @param id The unique id of the Zone.
     */
    /*
    public Zone(String id, String descriptor, List<Card> cards){
        this.id = id;
        this.descriptor = descriptor;
        this.cards = cards;
    }*/

    /**
     * Adds a Card on top of all other Cards already in the Zone.
     * @param c The Card that is being added.
     */
    public void add(Card c){
        cards.add(c);
    }

    /**
     * Inserts a Card into position n, the Card that was originally in position n
     * goes to position n+1 and so on.
     * @param c The Card that is being inserted.
     * @param n The position that the Card is being inserted into.
     */
    public void insert(Card c, int n){
        cards.add(n, c);
    }

    /**
     * Removes and returns the Card in the topmost position in the Zone.
     * @return The card that was removed; returns null if the Zone is empty.
     */
    public Card pop(){
        if(isEmpty()) return null;
        Card c = cards.remove(cards.size()-1);
        return c;
    }

    /**
     * Removes the card in the n-th position. Any card whose index was higher than n,
     * say k, is moved one position down or to position k-1. Requires {@code n < cards.size()}
     * @param n The position of the card in the list of cards that you want to remove. Requires {@code n>=0 && n<cards.size()}
     * @return The card that was removed; returns null if the Zone is empty.
     */
    public Card remove(int n){
        assert cards.size() > 0 && n<cards.size();
        if (isEmpty()) return null;
        if (n < 0 || n >= cards.size()) throw new IndexOutOfBoundsException(n + " is not a valid index for this Zone at this time.");
        Card c = cards.remove(n);
        return c;
    }

    /**
     * Returns whether or not this Zone has any Cards contained in it.
     * @return True if the number of Cards in the Zone is equal to 0, false otherwise.
     */
    public boolean isEmpty() {
        return cards.size() == 0;
    }

    @Override
    public String toString(){
        String acc = "Zone with ID: " + ID + "\n";
        for(int i=0; i<cards.size(); i++){
            acc+=cards.get(i).title + ", ";
        }
        //return descriptor + "\n" + acc;
        return acc;
    }


    private class NonExistantCardException extends java.lang.Exception{
        public NonExistantCardException() { super(); }
        public NonExistantCardException(String message) { super(message); }
        public NonExistantCardException(String message, Throwable cause) { super(message, cause); }
        public NonExistantCardException(Throwable cause) { super(cause); }
    }
}
