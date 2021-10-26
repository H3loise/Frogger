/* Decompiler 4ms, total 196ms, lines 43 */
package src.givenEnvironment;

import src.gameCommons.Game;
import src.gameCommons.IEnvironment;
import java.util.ArrayList;
import java.util.Iterator;
import src.util.Case;

public class GivenEnvironment implements IEnvironment {
   private ArrayList<Lane> roadLines;
   private Game game;

   public GivenEnvironment(Game game) {
      this.game = game;
      this.roadLines = new ArrayList();
      this.roadLines.add(new Lane(game, 0, 0.0D));

      for(int i = 1; i < game.height - 1; ++i) {
         this.roadLines.add(new Lane(game, i));
      }

      this.roadLines.add(new Lane(game, game.height - 1, 0.0D));
   }

   public boolean isSafe(Case c) {
      return ((Lane)this.roadLines.get(c.ord)).isSafe(c);
   }

   public boolean isWinningPosition(Case c) {
      return c.ord == this.game.height - 1;
   }

   public void update() {
      Iterator var2 = this.roadLines.iterator();

      while(var2.hasNext()) {
         Lane lane = (Lane)var2.next();
         lane.update();
      }

   }
}
