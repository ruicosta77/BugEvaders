package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.interfaces.Hitable;
import io.codeforall.bootcamp.filhosdamain.interfaces.Shootable;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.filhosdamain.positions.Position;

import java.util.LinkedList;


public class Player implements Hitable, Shootable {

    private static final int PLAYER_SPEED = 20;
    private int playerX;
    private int playerY;
    private Picture playerImage;
    private LinkedList<BugProjectile> projectiles;

    public Player(int x, int y, LinkedList<BugProjectile> projectiles) {
        this.playerX = x;
        this.playerY = y;
        this.playerImage = new Picture(x, y, "BugEvaders/resources/igorpng2.png");
        this.playerImage.draw();
        this.projectiles = projectiles;
    }

    public void moveRight() {
        if (playerX + playerImage.getWidth() < 1000) {
            playerImage.translate(PLAYER_SPEED, 0);
            playerX += PLAYER_SPEED;
        }
    }

    public void moveLeft() {
        if (playerX > 0) {
            playerImage.translate(-PLAYER_SPEED, 0);
            playerX -= PLAYER_SPEED;
        }
    }

    public void shoot() {
        Position projectilePosition = new Position(playerX + playerImage.getWidth() / 2, playerY);
        BugProjectile projectile = new BugProjectile(projectilePosition);
        projectiles.add(projectile);
    }

    @Override
    public void hit(int damage) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerX=" + playerX +
                ", playerY=" + playerY +
                ", playerImage=" + playerImage +
                ", projectiles=" + projectiles +
                '}';
    }
}