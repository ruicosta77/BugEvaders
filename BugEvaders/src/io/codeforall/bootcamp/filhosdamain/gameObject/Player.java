package io.codeforall.bootcamp.filhosdamain.gameObject;
import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Hitable {
    private int playerX;

    private int playerY;
    private Picture playerImage = new Picture(450,900 ,"BugEvaders/resources/igorpng2.png");

    public BugProjectile bugProjectile;


    public Player(){

        playerImage.draw();
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void moveRight(){
        playerImage.translate(10,0);
    }
    public void moveLeft(){
        playerImage.translate(-10,0);
    }
}
