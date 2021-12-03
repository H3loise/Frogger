import java.util.ArrayList;
public class Frog implements IFrog{

    private Game game;
    Case position;
    Direction direction;

    public Frog(Game game){
        Case position= new Case(game.width/2,1);
        this.game=game;
        this.direction=Direction.up;
        this.position=position;
    }

    public Case getPosition(){
        return this.position;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void move(Direction key){
        this.direction=key;
        if(key==Direction.up){
            Case newCase= new Case(this.position.absc,this.position.ord+1);
            this.position=newCase;
            IEnvironment newEnv= this.game.getEnvironment();
            newEnv.NouvelleRoute();
            this.game.setEnvironment(newEnv);
        }if(key==Direction.down && this.position.ord>0){
            Case newCase= new Case(this.position.absc,this.position.ord-1);
            this.position=newCase;
        }if(key==Direction.left && this.position.absc>0){
            Case newCase=new Case(this.position.absc-1,this.position.ord);
            this.position=newCase;
        }if(key==Direction.right && this.position.absc<this.game.width){
            Case newCase=new Case(this.position.absc+1,this.position.ord);
            this.position=newCase;
        }
        System.out.println("(" + this.position.absc + "; " + this.position.ord+ ")");
    }


}
