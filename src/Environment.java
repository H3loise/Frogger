

import java.util.ArrayList;
import java.util.Iterator;

public class Environment implements IEnvironment {
    private ArrayList<Lane> routes;
    private Game game;

    public Environment(Game g){
        this.game=g;
        this.routes=new ArrayList<>();
        new Lane(g,0,game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1,true, 0);
        new Lane(g,1,game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1,true, 0);
        for(int i=2; i<game.height+10;i++){
            double d = Math.random();
            d=d*2;
            int n=(int)d;
            if(n==0){
                this.routes.add(new Lane(g,i,game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1,false));
            }else {
                this.routes.add(new Lane(g, i, game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1, true));
            }
        }
        for(int i=0;i<60;i++){
            this.update();
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



    public void NouvelleRoute(boolean up){
        double d = Math.random();
        double e=d;
        d=d*2;
        int n=(int)d;
        if(e>0.1) {
            if (n == 0) {
                Lane l1 = new Lane(this.game, this.routes.size() - 1, game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1, false);
                this.routes.add(l1);
                for (int i = 0; i < 20; i++) {
                    l1.update();
                    l1.mayAddSpecialCase();
                }
            } else {
                Lane l2 = new Lane(this.game, this.routes.size() - 1, game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1, true);
                this.routes.add(l2);
                for (int i = 0; i < 20; i++) {
                    l2.update();
                    l2.mayAddSpecialCase();
                }
            }
        }else{
            Lane l3=new Lane(this.game,this.routes.size(),game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1,true, 0);
            this.routes.add(l3);
        }
        for(int i=0;i<20;i++){

        }
    }
}