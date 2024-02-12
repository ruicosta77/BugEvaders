package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.gameObject.Player;
import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BugProjectile {

    public Player originPlayer;
    public Picture bugProjectileImage;
    public Hitable enemy;
    public Field field;
    private int bugY;

    public BugProjectile (){
        bugProjectileImage = new Picture(450, 900,"BugEvaders/resources/bug.png");
        bugY = bugProjectileImage.getY();
        bugProjectileImage.draw();
    }

    public void moveUp(){
        bugProjectileImage.translate(0,-10);
    }

    public int getBugY() {
        return bugY;
    }


}
