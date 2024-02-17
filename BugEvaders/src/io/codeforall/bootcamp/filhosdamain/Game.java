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
    Lifes life;
    Lifes life1;
    Lifes life2;

    public LinkedList<BugProjectile> bugs = new LinkedList<>();
    public ArrayList<Enemy> enemies = new ArrayList<>();
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
        score = new Score("Bullets");
        players.add(player);
        life = new Lifes(50,50);
        life1 = new Lifes(100,50);
        life2 = new Lifes(150,50);
    }

    public void run() throws InterruptedException {
        while (true) {

            try {
                Thread.sleep(delay);

                for (Enemy enemy : enemies) {
                    enemy.movement();
                }

                for (McBullet mcBullet : mcBullets) {
                    mcBullet.moveDown();
                    for (Player player : players) {
                        if (mcBullet.checkCollision(player)) {
                            player.hit(1);
                            removeLifes();
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

                for (BugProjectile bug : bugs) {
                    bug.moveUp();
                    for (Enemy enemy : enemies) {

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

    public void removeLifes (){
        for (Player player : players){
            switch (player.getHealth()){
                case 2:
                    life2.remove();
                    break;
                case 1:
                    life1.remove();
                    break;
                case 0:
                    life.remove();
                    break;
            }
        }
    }
}


