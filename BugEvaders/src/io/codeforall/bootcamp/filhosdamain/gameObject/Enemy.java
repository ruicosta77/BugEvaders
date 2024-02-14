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
    public final int ENEMY_SPEED = 5;
    private static int  random = 1;

    public Enemy(int x, int y) {
        this.enemyX = x;
        this.enemyY = y;
        this.position = new Position(x, y);
    }

    public void destroy() {
        enemyImage.delete();
    }

    public void movement() {

        switch (random) {
            case 0:
                moveLeft();
                if (getEnemyX() == 50 ) {
                    random = 1;
                }
                break;
            case 1:
                moveRight();
                if (getEnemyX() == 950) {
                    random = 0;
                }
                break;
        }
    }

    public void moveRight() {
        if (enemyX + enemyImage.getWidth() < 1000) {
            enemyImage.translate(ENEMY_SPEED, 0);
            enemyX += ENEMY_SPEED;
            this.getPosition().setX(enemyX);
        }
    }

    public void moveLeft() {
        if (enemyX > 0) {
            enemyImage.translate(-ENEMY_SPEED, 0);
            enemyX -= ENEMY_SPEED;
            this.getPosition().setX(enemyX);
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
