import java.awt.*;
import java.time.LocalTime;

public class SpecialCase {
    private Game game;
    private Case Position;
    private int length=1;
    private final Color colorKill = Color.RED;
    private final Color colorInvincible = Color.orange;
    private boolean kill;

    public SpecialCase(Game g,Case c){
        this.game=g;
        this.Position=c;
        this.kill=this.game.randomGen.nextBoolean();
    }

    public void addToGraphics() {
        for (int i = 0; i < length; i++) {
            Color color = colorInvincible;
            if (this.kill){
                color = colorKill;
            }
            game.getGraphic()
                    .add(new Element(Position.absc + i, Position.ord - this.game.Score(), color));
        }
    }

    public boolean isSafe(Case c){
        if(c.absc==this.Position.absc && c.ord==this.Position.ord && this.kill){
            return false;
        }
        return true;
    }

    public boolean isInvincible(Case c){
        if(c.absc==this.Position.absc && c.ord==this.Position.ord && !this.kill){
            this.game.debutInvincible= LocalTime.now().toSecondOfDay();
            this.game.isInvincible=true;
            return true;

        }return false;
    }

}

