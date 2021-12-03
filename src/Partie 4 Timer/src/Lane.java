

import java.util.ArrayList;

public class Lane {
    private Game game;
    private int ord;
    private int speed;
    private ArrayList<Car> cars = new ArrayList<>();
    private boolean leftToRight;
    private double density;
    private int tick=0;


    public Lane(Game game, int ord, int speed,boolean leftToRight){
        this.density=game.defaultDensity;
        this.game=game;
        this.ord=ord;
        this.speed=speed;
        this.leftToRight=leftToRight;
        this.cars=new ArrayList<>();
    }

	public Lane(Game game, int ord, int speed,boolean leftToRight, int density){
        this(game, ord, speed, leftToRight);
		this.density = density;
    }

    public void update() {
        for(int i=0;i<cars.size();i++){
            cars.get(i).moveTo(this.tick==this.speed);
        }
        if(this.tick==this.speed){
            this.tick=0;
            mayAddCar();
        } else{
            this.tick++;
        }
	}
	public boolean isSafe(Case c){
        for(Car car : this.cars){
            if(car.TouchFullSizeVoiture(c)){
                return false;
            }
        }return true;
    }


    public void moveCar(){
        for(Car car : this.cars){
            car.moveTo(true);
        }
    }

    private void mayAddCar() {
        if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
            if (game.randomGen.nextDouble() < density) {
                cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
            }
        }
    }

    private Case getFirstCase() {
        if (leftToRight) {
            return new Case(0, ord);
        } else
            return new Case(game.width - 1, ord);
    }

    private Case getBeforeFirstCase() {
        if (leftToRight) {
            return new Case(-1, ord);
        } else
            return new Case(game.width, ord);
    }

}
