package io.codeforall.bootcamp.filhosdamain.gameObject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mcs extends Enemy {
    private int enemyX = 450;
    private int enemyY = 20;



    private boolean isAlive = true;


    public Mcs(String picture) {
        enemyImage = new Picture(enemyX, enemyY, picture);
        enemyImage.draw();
    }


    public int getEnemyX() {
        return enemyX;
    }

    public int getEnemyY() {
        return enemyY;
    }
    public void setAlive() {
        isAlive = false;
    }

    public void moveEnemy() {

        if (isAlive) {

            int checkMove = (int) (Math.random() * 10);

            if (checkMove % 2 == 0 && enemyX < 900) {
                enemyImage.translate(10, 0);
                this.enemyX = enemyX + 10;
            }
            if (checkMove % 2 == 1 && enemyX > 50) {
                enemyImage.translate(-10, 0);
                this.enemyX = enemyX - 10;
            }
        }
    }
}

