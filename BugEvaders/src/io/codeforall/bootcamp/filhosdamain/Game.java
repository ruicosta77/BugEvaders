package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.enemies.Mcs;
import io.codeforall.bootcamp.filhosdamain.enemies.SmallEnemy;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;

public class Game {
    Field field;
    Player myLittleObject;
    Controls playerControls;

    Mcs mcs;

    SmallEnemy smallEnemy;

    private int delay;

    public Game(int delay) throws InterruptedException {
        Thread.sleep(delay);
        field = new Field(1000,1000);
        myLittleObject = new Player();
        playerControls = new Controls(myLittleObject);
        smallEnemy = new SmallEnemy();
        mcs = new Mcs("resources/villian1.png");
    }
}
