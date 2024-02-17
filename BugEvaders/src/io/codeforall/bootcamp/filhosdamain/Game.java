package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.controlsFiles.Controls;
import io.codeforall.bootcamp.filhosdamain.controlsFiles.ControlsInitial;
import io.codeforall.bootcamp.filhosdamain.gameObject.*;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

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
    //public ArrayList<Lifes> lifes = new ArrayList<>();
    public LinkedList<McBullet> mcBullets = new LinkedList<>();
    public ArrayList<Player> players = new ArrayList<>();

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
        mcs = new Mcs(450, 150, mcBullets);
        enemies.add(mcs);
        playerControls = new Controls(player, mcs);
        EnemiesFactory.getNewEnemy(enemies);
        score = new Score("Score");
        score2 = new Score("Highscore");
       // lifes.add(new Lifes(3));
        players.add(player);
    }

    public void mcRandomShoot() {
        while (player.isAlive()) {
            int random = (int) (Math.random() * 100);
            if (random < 20) {
                mcs.shootMcs();
            }
        }
    }


    public void run() throws InterruptedException {
//        while (true) {
//
//            try {
//                Thread.sleep(delay);
//                int random = (int) (Math.random() * 100);
//
//                for (McBullet mcBullet : mcBullets) {
//                    mcBullet.moveDown();
//                    if (mcBullet.checkCollision(player)) {
//                        player.hit(1);
//                        if (player.isDestroyed()) {
//                            player.destroy();
//                            enemies.remove(player);
//                        }
//                        mcBullet.delete();
//                        mcBullets.remove(mcBullet);
//                        this.hitImage = new Picture(mcBullet.getPosition().getX(), mcBullet.getPosition().getY(), "BugEvaders/resources/explosion.png");
//                        this.hitImage.draw();
//                        Thread.sleep(20);
//                        this.hitImage.delete();
//                    }
//                }
//                for (BugProjectile bug : bugs) {
//                    bug.moveUp();
//                    for (Enemy enemy : enemies) {
//                        if (bug.checkCollision(enemy)) {
//                            enemy.hit(1);
//                            if (enemy.isDestroyed()) {
//                                enemy.destroy();
//                                enemies.remove(enemy);
//                            }
//                            if (enemy instanceof Mcs) {
//                                int McsProjectile = (int) (Math.random() * 5);
//                                while (McsProjectile > 0) {
//                                    ((Mcs) enemy).shootMcs();
//                                    McsProjectile--;
//
//                                    bug.delete();
//                                    bugs.remove(bug);
//                                    this.hitImage = new Picture(bug.getPosition().getX(), bug.getPosition().getY(), "BugEvaders/resources/explosion.png");
//                                    this.hitImage.draw();
//                                    Thread.sleep(20);
//                                    this.hitImage.delete();
//                                }
//                            }
//                        }
//                    }
//                }
//            } catch (ConcurrentModificationException e) {
//            }
//        }
//
//    }
        while (true) {

            try {
                Thread.sleep(delay);

                for (McBullet mcBullet : mcBullets) {
                    mcBullet.moveDown();
                    for (Player player : players) {
                        System.out.println("player loop");
                        if (mcBullet.checkCollision(player)) {
                            player.hit(1);
                            if (player.isDestroyed()) {
                                player.destroy();
                                players.remove(player);

                            }
                            mcBullet.delete();
                            mcBullets.remove(mcBullet);
                            this.hitImage = new Picture(mcBullet.getPosition().getX(), mcBullet.getPosition().getY(), "BugEvaders/resources/explosion.png");
                            this.hitImage.draw();
                            Thread.sleep(20);
                            this.hitImage.delete();
                        }
                    }
                }

                for (Enemy enemy : enemies) {
                    enemy.movement();
                }
                for (BugProjectile bug : bugs) {
                    bug.moveUp();
                    for (Enemy enemy : enemies) {

                        if (!player.isAlive()){
                            //System.exit(0); // change to lose screen
                        }
                        if (!mcs.isAlive()){
                            //System.exit(0); // change to win screen
                        }

                        if (bug.checkCollision(enemy)) {
                            enemy.hit(1);
                            if (enemy.isDestroyed()) {
                                enemy.destroy();
                                enemies.remove(enemy);
                            }
                            bug.delete();
                            bugs.remove(bug);
                            //iio exception here
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


