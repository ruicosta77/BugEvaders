package io.codeforall.bootcamp.filhosdamain.gameObject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SmallEnemy extends Enemy{

    public SmallEnemy(){

            enemyImage = new Picture(450,450,"BugEvaders/resources/villian2.png");
            enemyImage.draw();

    }
}
