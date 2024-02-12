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

    private int bugX;

    private int bugY;

    public BugProjectile (){
        bugProjectileImage = new Picture(450, 900,"BugEvaders/resources/bug.png");
        bugX = bugProjectileImage.getX();
        bugY = bugProjectileImage.getY();
        bugProjectileImage.draw();
    }




    public void bugProjectileMovement () throws InterruptedException {


        while(getBugY() >  -200){

            int moveBug = getBugY()-10;
            int finalY = originPlayer.getPlayerY();
            bugProjectileImage.translate(0,moveBug);
            Thread.sleep(100);
            System.out.println("test velocity");
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
