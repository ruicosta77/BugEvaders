package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.filhosdamain.positions.Position;

public abstract class Enemy implements Hitable {
    private int enemyX;
    private int enemyY;
    private Position position;
    protected Picture enemyImage;

    public Enemy(int x, int y) {
        this.enemyX = x;
        this.enemyY = y;
        this.position = new Position(x, y);
    }

    public void destroy() {
        enemyImage.delete();
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
}
