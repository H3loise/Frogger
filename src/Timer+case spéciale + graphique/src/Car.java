

import java.awt.Color;
import java.awt.image.BufferedImage;


public class Car {
    private Game game;
    private Case leftPosition;
    private boolean leftToRight;
    private int length;
    private final Color colorLtR = Color.BLACK;
    private final Color colorRtL = Color.BLUE;

    public Car(Game g,Case c,boolean b){
        this.game=g;
        this.leftPosition=c;
        this.leftToRight=b;
		this.length = game.randomGen.nextInt(3) + 1;
    }


    public Case getLeftPosition(){
        return this.leftPosition;
    }

    public void moveTo(boolean b){
        if(b){
            if(this.leftToRight){
                this.leftPosition=new Case(this.leftPosition.absc+1,this.leftPosition.ord);
            }else{
                this.leftPosition=new Case(this.leftPosition.absc-1, this.leftPosition.ord);
            }
        }
        this.addToGraphics();
    }

    public boolean isSafe(Case c){
        if(c.equals(leftPosition)){
            return false;
        }return true;
    }

    public boolean TouchFullSizeVoiture(Case frog){
        if(frog.ord==this.leftPosition.ord && frog.absc>=this.leftPosition.absc && (this.leftPosition.absc+this.length> frog.absc)){
            return true;
        }return false;
    }


    
    
    /* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
    private void addToGraphics() {
        for (int i = 0; i < length; i++) {
            BufferedImage image=this.game.images.Car_RTL;
            if (this.leftToRight){
                image=this.game.images.Car_LTR;
            }
            game.getGraphic()
                    .add(new Element(leftPosition.absc + i, leftPosition.ord - this.game.Score(), image));
        }
    }

}