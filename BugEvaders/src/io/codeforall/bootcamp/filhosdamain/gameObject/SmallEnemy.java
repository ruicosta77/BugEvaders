package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SmallEnemy extends Enemy implements Hitable {

    private int health;

    public SmallEnemy(int x, int y) {
        super(x, y);
        this.health = 100;
        enemyImage = new Picture(450, 450, "BugEvaders/resources/villian1.png");
        enemyImage.draw();
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

