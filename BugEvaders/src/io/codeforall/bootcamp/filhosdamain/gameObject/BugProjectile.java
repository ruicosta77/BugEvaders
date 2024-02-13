package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.gameObject.Player;
import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BugProjectile {

    public Player playerPosition;
    public Picture bugProjectileImage;
    public Hitable enemy;
    public Field field;
    private int bugY;

    public BugProjectile (int getX , int getY){
        bugProjectileImage = new Picture(getX, getY,"BugEvaders/resources/bug.png");
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
