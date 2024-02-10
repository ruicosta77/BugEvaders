package io.codeforall.bootcamp.filhosdamain.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy implements Hitable {
    private int enemyX;

    private int enemyY;
    protected Picture enemyImage;
    public Enemy() {

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
}
