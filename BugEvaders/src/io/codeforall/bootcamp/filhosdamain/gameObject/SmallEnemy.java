package io.codeforall.bootcamp.filhosdamain.gameObject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SmallEnemy extends Enemy{

    private int enemyX = 450;
    private int enemyY = 450;
    private boolean isAlive = true;

    public SmallEnemy(){

            enemyImage = new Picture(enemyX,enemyY,"BugEvaders/resources/villian2.png");
            enemyImage.draw();

    }

    public int getEnemyX() {
        return enemyX;
    }
    public int getEnemyY() {
        return enemyY;
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
