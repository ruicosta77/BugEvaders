package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import io.codeforall.bootcamp.filhosdamain.interfaces.Shootable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Mcs extends Enemy implements Shootable, Hitable {

    private int health;

    public Mcs(int x, int y) {
        super(x, y);
        this.health = 500;
        enemyImage = new Picture(450, 200, "BugEvaders/resources/villian2.png");
        enemyImage.draw();
    }

    @Override
    public void shoot() {
    }

    @Override
    public void hit(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            destroy();
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
