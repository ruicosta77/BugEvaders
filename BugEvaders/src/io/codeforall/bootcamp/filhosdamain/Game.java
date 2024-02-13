package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.*;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Field field;
    Player player;
    Controls playerControls;
    Mcs mcs;
    SmallEnemy smallEnemy;
    private int delay;

    public LinkedList<BugProjectile> bugs = new LinkedList<>();
    public ArrayList<Enemy> enemies = new ArrayList<>();

    public Game(int delay) throws InterruptedException {

        Thread.sleep(delay);
        this.delay = delay;
        field = new Field(1000, 1000);
        player = new Player(450, 900, bugs);
        playerControls = new Controls(player);
        EnemiesFactory.getNewEnemy(enemies);
        mcs = new Mcs(450, 200);
        enemies.add(mcs);

    }

    public void run() throws InterruptedException {

        while (true) {
            try {
                Thread.sleep(delay);
                for (Enemy enemy : enemies){
                    enemy.movement();
                }
                for (BugProjectile bug : bugs) {
                    bug.moveUp();

                    for (Enemy enemy : enemies) {
                        if (enemy.getPosition().getX() <= (bug.getPosition().getX()) && (enemy.getPosition().getX() + enemy.getPicture().getWidth()) >= (bug.getPosition().getX()) && enemy.getPosition().getY() - enemy.getPicture().getHeight() == bug.getPosition().getY()) {
                            enemy.destroy();
                            bug.delete();
                            enemies.remove(enemy);
                            bugs.remove(bug);
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
            }
        }
    }
}

