package io.codeforall.bootcamp.filhosdamain.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mcs extends Enemy{

    public Mcs (String picture){
        enemyImage = new Picture(450,20,picture);
        enemyImage.draw();
    }
}
