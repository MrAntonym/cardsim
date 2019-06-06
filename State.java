/**
 * Stores the physical position of a particular card.
 */
public class State {
   private boolean face; //face true is faceup, face false is facedown.
   private Orientation orient;

   /**
    * Public constructor for State.
    * @param face Boolean which is true if the face is faceup, false otherwise.
    * @param orient Orientation of FORWARD, RIGHT, LEFT, DOWN.
    */
   public State(boolean face, Orientation orient) {
      this.orient = orient;
      this.face = face;
   }

   /**
    * @return One of the following: FORWARD, RIGHT, LEFT, DOWN.
    */
   public Orientation getOrientation() {
      return orient;
   }

   /**
    * @return True if the card is faceup and false if the card is facedown.
    */
   public boolean isFaceup() {
      return face;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof State)) return false;
      State s = (State) o;
      return s.isFaceup() == this.face && s.getOrientation() == this.orient;
   }

   @Override
   public String toString() {
      if (face) {
         return "Faceup, " + orient;
      } else {
         return "Facedown, " + orient;
      }
   }
}
