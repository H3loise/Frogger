/* Decompiler 13ms, total 246ms, lines 52 */
package src.givenEnvironment;

import src.gameCommons.Game;
import src.graphicalElements.Element;
import java.awt.Color;
import src.util.Case;

public class Car {
   private Game game;
   private Case leftPosition;
   private boolean leftToRight;
   private int length;
   private final Color colorLtR;
   private final Color colorRtL;

   public Car(Game game, Case frontPosition, boolean leftToRight) {
      this.colorLtR = Color.BLACK;
      this.colorRtL = Color.BLUE;
      this.game = game;
      this.length = game.randomGen.nextInt(3) + 1;
      this.leftToRight = leftToRight;
      this.leftPosition = new Case(leftToRight ? frontPosition.absc - this.length : frontPosition.absc, frontPosition.ord);
   }

   public void move(boolean b) {
      if (b) {
         this.leftPosition = new Case(this.leftPosition.absc + (this.leftToRight ? 1 : -1), this.leftPosition.ord);
      }

      this.addToGraphics();
   }

   private void addToGraphics() {
      for(int i = 0; i < this.length; ++i) {
         this.game.getGraphic().add(new Element(this.leftPosition.absc + i, this.leftPosition.ord, this.leftToRight ? this.colorLtR : this.colorRtL));
      }

   }

   public boolean appearsInBounds() {
      return this.leftPosition.absc + this.length > 0 || this.leftPosition.absc < this.game.width;
   }

   public boolean coversCase(Case pos) {
      if (pos.ord != this.leftPosition.ord) {
         return false;
      } else {
         return pos.absc >= this.leftPosition.absc && pos.absc < this.leftPosition.absc + this.length;
      }
   }
}
