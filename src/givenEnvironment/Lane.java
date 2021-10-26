/* Decompiler 22ms, total 121ms, lines 111 */
package src.givenEnvironment;

import src.gameCommons.Game;
import java.util.ArrayList;
import java.util.Iterator;
import src.util.Case;

public class Lane {
   private Game game;
   private int ord;
   private int speed;
   private ArrayList<Car> cars;
   private boolean leftToRight;
   private double density;
   private int timer;

   public Lane(Game game, int ord, double density) {
      this.cars = new ArrayList();
      this.game = game;
      this.ord = ord;
      this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1;
      this.leftToRight = game.randomGen.nextBoolean();
      this.density = density;

      for(int i = 0; i < 4 * game.width; ++i) {
         this.moveCars(true);
         this.mayAddCar();
      }

   }

   public Lane(Game game, int ord) {
      this(game, ord, game.defaultDensity);
   }

   public void update() {
      ++this.timer;
      if (this.timer <= this.speed) {
         this.moveCars(false);
      } else {
         this.moveCars(true);
         this.mayAddCar();
         this.timer = 0;
      }
   }

   private void moveCars(boolean b) {
      Iterator var3 = this.cars.iterator();

      while(var3.hasNext()) {
         Car car = (Car)var3.next();
         car.move(b);
      }

      this.removeOldCars();
   }

   private void removeOldCars() {
      ArrayList<Car> toBeRemoved = new ArrayList();
      Iterator var3 = this.cars.iterator();

      Car c;
      while(var3.hasNext()) {
         c = (Car)var3.next();
         if (!c.appearsInBounds()) {
            toBeRemoved.add(c);
         }
      }

      var3 = toBeRemoved.iterator();

      while(var3.hasNext()) {
         c = (Car)var3.next();
         this.cars.remove(c);
      }

   }

   private void mayAddCar() {
      if (this.isSafe(this.getFirstCase()) && this.isSafe(this.getBeforeFirstCase()) && this.game.randomGen.nextDouble() < this.density) {
         this.cars.add(new Car(this.game, this.getBeforeFirstCase(), this.leftToRight));
      }

   }

   public boolean isSafe(Case pos) {
      Iterator var3 = this.cars.iterator();

      while(var3.hasNext()) {
         Car car = (Car)var3.next();
         if (car.coversCase(pos)) {
            return false;
         }
      }

      return true;
   }

   private Case getFirstCase() {
      return this.leftToRight ? new Case(0, this.ord) : new Case(this.game.width - 1, this.ord);
   }

   private Case getBeforeFirstCase() {
      return this.leftToRight ? new Case(-1, this.ord) : new Case(this.game.width, this.ord);
   }

   public String toString() {
      return "Lane [ord=" + this.ord + ", cars=" + this.cars + "]";
   }
}
