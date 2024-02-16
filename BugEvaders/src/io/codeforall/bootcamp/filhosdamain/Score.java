package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.Enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;

public class Score {

    private String name;
    private int score = 1000;
    private static int highScore;
    private Text scoreText;
    private Text highScoreText;

    public Score(String name){
        this.name = name;

        scoreText = new Text(850, 70, "SCORE: ");
        highScoreText = new Text(850, 100, "HIGHSCORE: ");

        scoreText.setColor(Color.GREEN);
        highScoreText.setColor(Color.GREEN);
        scoreText.grow(20,15);
        highScoreText.grow(20,15);
        scoreText.draw();
        highScoreText.draw();
    }
    public void updateScore() {
        setScore(score - 1);
        scoreText.setText("SCORE: " + score);
        if (score > highScore) {
            setHighScore(score);
            highScoreText.setText("HIGHSCORE: " + highScore);
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void setHighScore(int highScore) {
        Score.highScore = highScore;
    }

    public void delete() {
        scoreText.delete();
        highScoreText.delete();
    }

    public int getScore() {
        return score;
    }
}
