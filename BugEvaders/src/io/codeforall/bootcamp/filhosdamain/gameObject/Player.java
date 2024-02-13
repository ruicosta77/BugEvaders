package io.codeforall.bootcamp.filhosdamain.gameObject;
import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Hitable {
    private int playerX = 450;
    private int playerY = 800;

    private Picture playerImage = new Picture(playerX,playerY ,"BugEvaders/resources/igorpng2.png");
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
        this.playerX = playerX + 10;
    }
    public void moveLeft(){
        playerImage.translate(-10,0);
        this.playerX = playerX - 10;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerX=" + playerX +
                ", playerY=" + playerY +
                ", playerImage=" + playerImage +
                ", bugProjectile=" + bugProjectile +
                '}';
    }
}
