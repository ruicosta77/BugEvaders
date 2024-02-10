package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.enemies.Hitable;
import io.codeforall.bootcamp.filhosdamain.enemies.Mcs;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BugProjectile {

    public Player originPlayer;

    public Picture bugProjectileImage;

    public Hitable enemy;

    public Field field;

    private int bugX;

    private int bugY;

    public BugProjectile (){
        bugProjectileImage = new Picture(450, 900,"resources/bug.png");
        bugProjectileImage.draw();
        bugProjectileMovement();
    }




    public void bugProjectileMovement (){
        while(getBugY() !=  -200){
            setBugY(getBugY()-10);
            System.out.println(getBugY());
            bugProjectileImage.translate(0,getBugY());
        }
    }

    public int getBugX() {
        return bugX;
    }

    public void setBugX(int bugX) {
        this.bugX = bugX;
    }

    public int getBugY() {
        return bugY;
    }

    public void setBugY(int bugY) {
        this.bugY = bugY;
    }
}
