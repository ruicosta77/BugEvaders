package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.Enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;

public class Score {


    private String name;
    protected int score;
    protected static int highScore = 0;
    protected Text text = new Text(250,100, toString());
    private ArrayList<Enemy> enemies;


    public Score(String name , ArrayList enemy) {
        this.name = name;
        this.enemies = enemy;
        text.setColor(Color.ORANGE);
        text.grow(30,30);
        text.draw();
    }

    public int scoreKeeper() {
       for (Enemy enemy : enemies) {
           if (enemy.isAlive()) {
               score++;
           }
           if (score > highScore){
               highScore = score;
           }
           text.setText(toString());
           text.delete();
           text.draw();

       }
       return 0;
    }


    public String toString(int highScore) {
        return "HIGHSCORE: " + highScore;
    }

    public String toString(Integer score) {
        return "SCORE: " + score;
    }

    @Override
    public String toString() {
        return ""+score;
    }

    public void delete(){
        text.delete();
    }

}
