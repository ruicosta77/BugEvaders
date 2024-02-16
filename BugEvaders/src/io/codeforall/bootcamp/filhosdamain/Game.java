package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.*;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Field field;
    Player player;
    Controls playerControls;
    ControlsInitial initialControls;
    Mcs mcs;
    SmallEnemy smallEnemy;
    Game g;
    private int delay;
    private Picture hitImage;
    private Score score;
    private Score score2;
    Lifes life;

    public LinkedList<BugProjectile> bugs = new LinkedList<>();
    public ArrayList<Enemy> enemies = new ArrayList<>();

    public Game(int delay) throws InterruptedException {
        Thread.sleep(delay);
        this.delay = delay;
        initialScreen();

    }

    public void initialScreen() {

        field = new Field(1000, 1000, "BugEvaders/resources/background.jpeg");
        initialControls = new ControlsInitial(this);
    }

    public void gameScreen() {

        field = new Field(1000, 1000, "BugEvaders/resources/background2.jpeg");
        player = new Player(450, 880, bugs);
        playerControls = new Controls(player);
        EnemiesFactory.getNewEnemy(enemies);
        mcs = new Mcs(450, 150);
        enemies.add(mcs);
        //score = new Score("Score");
        score2 = new Score("Highscore");
        life = new Lifes(3);
    }


    public void run() throws InterruptedException {
        while (true) {

            try {
                Thread.sleep(delay);
                for (Enemy enemy : enemies) {
                    enemy.movement();
                }
                for (BugProjectile bug : bugs) {
                    bug.moveUp();
                    for (Enemy enemy : enemies) {

                        if (!player.isAlive()){
                            System.exit(0); // change to lose screen
                        }
                        if (!mcs.isAlive()){
                            System.exit(0); // change to win screen
                        }

                        if (bug.checkCollision(enemy)) {
                            enemy.hit(1);
                            if (enemy.isDestroyed()) {
                                enemy.destroy();
                                enemies.remove(enemy);
                            }
                            bug.delete();
                            bugs.remove(bug);
                            this.hitImage = new Picture(bug.getPosition().getX(), bug.getPosition().getY(), "BugEvaders/resources/explosion.png");
                            this.hitImage.draw();
                            Thread.sleep(20);
                            this.hitImage.delete();
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
            }
        }
    }
}

