package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import io.codeforall.bootcamp.filhosdamain.interfaces.Shootable;
import io.codeforall.bootcamp.filhosdamain.positions.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Mcs extends Enemy implements Shootable, Hitable {

    private int health;
    private boolean isDestroyed;
    private static int random = 1;
    private LinkedList<SlidesProjectile> projectiles;

    public Mcs(int x, int y) {
        super(x, y);
        this.health = 5;
        enemyImage = new Picture(x, y, "BugEvaders/resources/villian2.png");
        enemyImage.draw();
    }

    @Override
    public void shoot() {
    }

    @Override
    public void hit(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            isDestroyed = true;
        }
    }

    @Override
    public boolean isAlive() {
        if(this.health <= 0){
            return false;
        }
        return true;
    }


    @Override
    public void movement() {
        switch (random) {
            case 0:
                moveLeft();
                if (getEnemyX() ==200 ) {
                    random = 1;
                }
                break;
            case 1:
                moveRight();
                if (getEnemyX() == 800) {
                    random = 0;
                }
                break;
        }
    }

    public void shootMcs() {
        Position projectilePosition = new Position(getEnemyX(), getEnemyY());
        SlidesProjectile projectile = new SlidesProjectile(projectilePosition);
        projectiles.add(projectile);
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
}
