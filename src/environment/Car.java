/**


package src.environment;

import java.awt.Color;
import src.util.Case;
import src.gameCommons.Game;
import src.graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game game,Case leftPosition, boolean leftToRight){
		this.game=game;
		this.leftPosition=leftPosition;
		this.leftToRight=leftToRight;
	}
	
	//TODO : ajout de methodes

	public boolean isSafe(Case c){
		return !(this.leftPosition.equals(c));
	}


	public void update(boolean move) {
		if (move){
			if (leftToRight)
				leftPosition = new Case(leftPosition.absc + 1, leftPosition.ord);
			else
				leftPosition = new Case(leftPosition.absc - 1, leftPosition.ord);
		}
		addToGraphics();
	}

	public void move(boolean possibleToMove){
		if(possibleToMove){
			if(leftToRight){
				Case c=new Case(this.leftPosition.absc+1,this.leftPosition.ord);
				this.leftPosition=c;
			}else{
				Case c=new Case(this.leftPosition.absc-1,this.leftPosition.ord);
				this.leftPosition=c;
			}this.addToGraphics();
		}
	}

	public boolean shouldBeDeleted() {
		return leftPosition.absc + length < 0 || leftPosition.ord > game.width;
	}

	
	
	 Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
**/

/* Decompiler 13ms, total 246ms, lines 52 */
package src.environment;

import src.gameCommons.Game;
import src.graphicalElements.Element;
import java.awt.Color;
import src.util.Case;



import java.awt.Color;



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
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}