package src.environment;

import java.util.ArrayList;

import src.util.Case;
import src.gameCommons.Game;
import src.environment.Lane;

import src.gameCommons.IEnvironment;



import java.util.ArrayList;

public class Environment implements IEnvironment {
    private ArrayList<Lane> routes;
    private Game game;

    public Environment(Game g){
        this.game=g;
        this.routes=new ArrayList<>();
        new Lane(g,0,game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1,true, 0);
        new Lane(g,1,game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1,true, 0);
        for(int i=2; i<game.height;i++){
            double d = Math.random();
            d=d*2;
            int n=(int)d;
            if(n==0){
                this.routes.add(new Lane(g,i,game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1,false));
            }else {
                this.routes.add(new Lane(g, i, game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1, true));
            }
        }
    }

    public boolean isSafe(Case c){
        for(Lane l : routes){
            if(l.isSafe(c)!=true){
                return false;
            }
        }return true;
    }

    public void update(){
        for(Lane l : routes){
            l.update();
        }
    }

    public boolean isWinningPosition(Case c){
        if(c.ord==game.height - 1) {
            return true;
        }return false;
    }
}