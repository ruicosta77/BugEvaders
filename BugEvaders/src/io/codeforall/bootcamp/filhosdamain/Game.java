package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.BugProjectile;
import io.codeforall.bootcamp.filhosdamain.gameObject.Mcs;
import io.codeforall.bootcamp.filhosdamain.gameObject.Player;
import io.codeforall.bootcamp.filhosdamain.gameObject.SmallEnemy;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;

public class Game {
    Field field;
    Player myLittleObject;
    Controls playerControls;
    Mcs mcs;
    SmallEnemy smallEnemy;
    private int delay;

    public LinkedList<BugProjectile> bugs = new LinkedList<>();

    public Game(int delay) throws InterruptedException {
        Thread.sleep(delay);
        this.delay = delay;
        field = new Field(1000, 1000);
        myLittleObject = new Player();
        playerControls = new Controls(myLittleObject, bugs);
        smallEnemy = new SmallEnemy();
        mcs = new Mcs("BugEvaders/resources/villian1.png");
    }

    public void run() throws InterruptedException {

        while (true) {

            try {
                Thread.sleep(delay);
                System.out.println(bugs);
                for (BugProjectile bug : bugs) {
                    if (bug.getBugY() == mcs.getEnemyY() && bug.getBugX() == mcs.getEnemyX()) {
                        mcs.setAlive();
                    }
                    bug.moveUp();
                    //mcs.moveEnemy();
                    smallEnemy.moveEnemy();

                }
            } catch (ConcurrentModificationException e) {
                continue;
            }
        }
    }
}

