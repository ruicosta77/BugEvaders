package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.filhosdamain.positions.Position;

import java.awt.*;

public abstract class Enemy implements Hitable {
    private int enemyX;
    private int enemyY;
    private Position position;
    protected Picture enemyImage;
    public final int ENEMY_SPEED = 10;

    public Enemy(int x, int y) {
        this.enemyX = x;
        this.enemyY = y;
        this.position = new Position(x, y);
    }

    public void destroy() {
        enemyImage.delete();
    }

    public void movement() {

        int random = (int) (Math.random() * 100);
        if (random < 5) {
            randomMovement();
            return;
        }
        System.out.println("ola");
    }


    public void randomMovement() {
        int random = (int) (Math.random() * 2);
        switch (random) {
            case 0:
                for (int i = 0; i < 5; i++) {
                    moveLeft();
                }
                    break;

            case 1:
                for (int i = 0; i < 5; i++) {
                moveRight();}
                break;

        }
    }

    public void moveRight() {
        if (enemyX + enemyImage.getWidth() < 1000) {
            enemyImage.translate(ENEMY_SPEED, 0);
            enemyX += ENEMY_SPEED;
        }
    }

    public void moveLeft() {
        if (enemyX > 0) {
            enemyImage.translate(-ENEMY_SPEED, 0);
            enemyX -= ENEMY_SPEED;
        }
    }


    public Position getPosition() {
        return position;
    }

    public int getEnemyX() {
        return enemyX;
    }

    public void setEnemyX(int enemyX) {
        this.enemyX = enemyX;
    }

    public int getEnemyY() {
        return enemyY;
    }

    public void setEnemyY(int enemyY) {
        this.enemyY = enemyY;
    }

    public Picture getPicture() {
        return enemyImage;
    }
}
